/*     */ package mzm.gsp.backgameactivity.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity3.confbean.SBackGameActivityCfg;
/*     */ import mzm.gsp.activity3.confbean.SBackGameActivityGiftItemCfg;
/*     */ import mzm.gsp.backgameactivity.SBuyBackGameGiftFail;
/*     */ import mzm.gsp.backgameactivity.SBuyBackGameGiftSuccess;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BackGameActivityInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2backgameactivity;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCBuyBackGameGiftReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int giftItemCfgId;
/*     */   private final int buyCount;
/*     */   
/*     */   public PCBuyBackGameGiftReq(long roleId, int giftItemCfgId, int buyCount)
/*     */   {
/*  39 */     this.roleId = roleId;
/*  40 */     this.giftItemCfgId = giftItemCfgId;
/*  41 */     this.buyCount = buyCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */   {
/*  48 */     if (!BackGameActivityManager.isBackGameActivityOpen(this.roleId))
/*     */     {
/*  50 */       String logStr = String.format("[backgameactivity]PCBuyBackGameGiftReq.processImp@BackGameActivity not open!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  52 */       GameServer.logger().info(logStr);
/*  53 */       return false;
/*     */     }
/*  55 */     if (!isBackGameGiftOpen())
/*     */     {
/*  57 */       String logStr = String.format("[backgameactivity]PCBuyBackGameGiftReq.processImp@BackGameActivityAward not open!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  59 */       GameServer.logger().info(logStr);
/*  60 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  64 */     String userId = RoleInterface.getUserId(this.roleId);
/*  65 */     if (null == userId)
/*     */     {
/*  67 */       String logStr = String.format("[backgameactivity]PCBuyBackGameGiftReq.processImp@userId not exist!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  69 */       GameServer.logger().error(logStr);
/*  70 */       return false;
/*     */     }
/*  72 */     lock(Lockeys.get(User.getTable(), userId));
/*  73 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*  76 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1676, true, true))
/*     */     {
/*  78 */       String logStr = String.format("[backgameactivity]PCBuyBackGameGiftReq.processImp@state confict!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  80 */       GameServer.logger().info(logStr);
/*  81 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  85 */     BackGameActivityInfo xBackGameActivityInfo = Role2backgameactivity.get(Long.valueOf(this.roleId));
/*  86 */     if (null == xBackGameActivityInfo)
/*     */     {
/*  88 */       onFail(-1, xBackGameActivityInfo);
/*  89 */       return false;
/*     */     }
/*  91 */     if (!BackGameActivityManager.isBackGameActivityInfoAvailable(xBackGameActivityInfo))
/*     */     {
/*  93 */       onFail(-1, xBackGameActivityInfo);
/*  94 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  98 */     SBackGameActivityGiftItemCfg sBackGameActivityGiftItemCfg = SBackGameActivityGiftItemCfg.get(this.giftItemCfgId);
/*  99 */     if (null == sBackGameActivityGiftItemCfg)
/*     */     {
/* 101 */       onFail(-2, xBackGameActivityInfo);
/* 102 */       return false;
/*     */     }
/* 104 */     SBackGameActivityCfg sBackGameActivityCfg = SBackGameActivityCfg.get(xBackGameActivityInfo.getActivity_id());
/* 105 */     Integer needRecharge = (Integer)sBackGameActivityGiftItemCfg.giftCfgId2NeedRecharge.get(Integer.valueOf(sBackGameActivityCfg.giftCfgId));
/* 106 */     if (null == needRecharge)
/*     */     {
/* 108 */       onFail(-2, xBackGameActivityInfo);
/* 109 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 113 */     long totalRechargeYuanbao = QingfuInterface.getSaveAmt(userId, true);
/* 114 */     if (totalRechargeYuanbao < needRecharge.intValue())
/*     */     {
/* 116 */       onFail(-5, xBackGameActivityInfo);
/* 117 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 121 */     long currentTime = DateTimeUtils.getCurrTimeInMillis();
/* 122 */     checkRefreshGiftInfo(currentTime, xBackGameActivityInfo);
/* 123 */     int alreadyBuyCount = getBuyCount(this.giftItemCfgId, xBackGameActivityInfo);
/* 124 */     if (alreadyBuyCount + this.buyCount > sBackGameActivityGiftItemCfg.buyCount)
/*     */     {
/* 126 */       onFail(-3, xBackGameActivityInfo);
/* 127 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 131 */     CostResult costResult = QingfuInterface.costYuanbao(userId, this.roleId, sBackGameActivityGiftItemCfg.price * this.buyCount, CostType.COST_BACK_GAME_ACTIVITY_GIFT_BUY, new TLogArg(LogReason.BACK_GAME_ACTIVITY_GIFT_BUY_COST_YUANBAO));
/*     */     
/*     */ 
/* 134 */     if (costResult != CostResult.Success)
/*     */     {
/* 136 */       onFail(-4, xBackGameActivityInfo);
/* 137 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 141 */     Map<Integer, Integer> item2Count = new HashMap();
/* 142 */     item2Count.put(Integer.valueOf(sBackGameActivityGiftItemCfg.itemId), Integer.valueOf(this.buyCount));
/* 143 */     ItemOperateResult addResult = ItemInterface.addItemCheckCarrymax(this.roleId, item2Count, true, new TLogArg(LogReason.BACK_GAME_ACTIVITY_GIFT_BUY_AWARD));
/*     */     
/* 145 */     if (!addResult.success())
/*     */     {
/* 147 */       onFail(-6, xBackGameActivityInfo);
/* 148 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 152 */     addBuyCount(this.buyCount, this.giftItemCfgId, xBackGameActivityInfo);
/* 153 */     xBackGameActivityInfo.setLast_buy_gift_time(currentTime);
/*     */     
/* 155 */     onSuccess(xBackGameActivityInfo);
/*     */     
/* 157 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(int errorCode, BackGameActivityInfo xBackGameActivityInfo)
/*     */   {
/* 163 */     String logStr = String.format("[backgameactivity]PCBuyBackGameGiftReq.processImp@buy gift fail!|roleId=%d,errorCode=%d,buyCount=%d,xBackGameActivityInfo=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(errorCode), Integer.valueOf(this.buyCount), xBackGameActivityInfo });
/*     */     
/*     */ 
/* 166 */     GameServer.logger().info(logStr);
/*     */     
/*     */ 
/* 169 */     OnlineManager.getInstance().sendAtOnce(this.roleId, new SBuyBackGameGiftFail(errorCode));
/*     */   }
/*     */   
/*     */ 
/*     */   private void onSuccess(BackGameActivityInfo xBackGameActivityInfo)
/*     */   {
/* 175 */     String logStr = String.format("[backgameactivity]PCBuyBackGameGiftReq.processImp@buy gift success!|roleId=%d,buyCount=%d,xBackGameActivityInfo=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.buyCount), xBackGameActivityInfo });
/*     */     
/*     */ 
/* 178 */     GameServer.logger().info(logStr);
/*     */     
/*     */ 
/* 181 */     BackGameActivityTlogManager.addBackGameActivityGiftBuyTlog(this.roleId, xBackGameActivityInfo.getActivity_id(), xBackGameActivityInfo.getJoin_time(), this.giftItemCfgId, this.buyCount);
/*     */     
/*     */ 
/*     */ 
/* 185 */     SBuyBackGameGiftSuccess protocol = new SBuyBackGameGiftSuccess(this.giftItemCfgId, this.buyCount);
/* 186 */     OnlineManager.getInstance().send(this.roleId, protocol);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkRefreshGiftInfo(long currentTime, BackGameActivityInfo xBackGameActivityInfo)
/*     */   {
/* 198 */     if (DateTimeUtils.needDailyReset(xBackGameActivityInfo.getLast_buy_gift_time(), currentTime, 0))
/*     */     {
/* 200 */       Iterator<Map.Entry<Integer, Integer>> i = xBackGameActivityInfo.getGift_buy_count_map().entrySet().iterator();
/* 201 */       while (i.hasNext())
/*     */       {
/* 203 */         Map.Entry<Integer, Integer> entry = (Map.Entry)i.next();
/* 204 */         SBackGameActivityGiftItemCfg sGiftItemCfg = SBackGameActivityGiftItemCfg.get(((Integer)entry.getKey()).intValue());
/* 205 */         if (sGiftItemCfg.refreshType == 2)
/*     */         {
/* 207 */           i.remove();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getBuyCount(int giftItemCfgId, BackGameActivityInfo xBackGameActivityInfo)
/*     */   {
/* 222 */     Integer buyCount = (Integer)xBackGameActivityInfo.getGift_buy_count_map().get(Integer.valueOf(giftItemCfgId));
/* 223 */     if (null == buyCount)
/*     */     {
/* 225 */       return 0;
/*     */     }
/* 227 */     return buyCount.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addBuyCount(int addCount, int giftItemCfgId, BackGameActivityInfo xBackGameActivityInfo)
/*     */   {
/* 239 */     Map<Integer, Integer> buyCountMap = xBackGameActivityInfo.getGift_buy_count_map();
/* 240 */     Integer oldCount = (Integer)buyCountMap.get(Integer.valueOf(giftItemCfgId));
/* 241 */     if (null == oldCount)
/*     */     {
/* 243 */       oldCount = Integer.valueOf(0);
/*     */     }
/* 245 */     buyCountMap.put(Integer.valueOf(giftItemCfgId), Integer.valueOf(oldCount.intValue() + addCount));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isBackGameGiftOpen()
/*     */   {
/* 255 */     if (!OpenInterface.getOpenStatus(424))
/*     */     {
/* 257 */       return false;
/*     */     }
/* 259 */     if (OpenInterface.isBanPlay(this.roleId, 424))
/*     */     {
/* 261 */       OpenInterface.sendBanPlayMsg(this.roleId, 424);
/* 262 */       return false;
/*     */     }
/* 264 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\main\PCBuyBackGameGiftReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */