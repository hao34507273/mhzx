/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.friends_circle.confbean.SFriendsCircleConsts;
/*     */ import mzm.gsp.friendscircle.SBuyFriendsCircleTreasureBoxSuccess;
/*     */ import mzm.gsp.friendscircle.SFriendsCircleNormalRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FriendsCirclePlaceTreasureResult;
/*     */ import xbean.Role2FriendsCircleInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCBuyFriendsCircleTreasureBox extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int buyCount;
/*     */   private final long clientCurrencyValue;
/*     */   
/*     */   public PCBuyFriendsCircleTreasureBox(long roleId, int buyCount, long clientCurrencyValue)
/*     */   {
/*  30 */     this.roleId = roleId;
/*  31 */     this.buyCount = buyCount;
/*  32 */     this.clientCurrencyValue = clientCurrencyValue;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (this.buyCount <= 0)
/*     */     {
/*  40 */       onBuyFriendsCircleTreasureBoxFail(10);
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     if (!FriendsCircleManager.isFriendsCircleSwitchOpen(this.roleId, 451, true))
/*     */     {
/*  46 */       onBuyFriendsCircleTreasureBoxFail(1);
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (!FriendsCircleManager.isFriendsCircleSwitchOpen(this.roleId, 454, true))
/*     */     {
/*  52 */       onBuyFriendsCircleTreasureBoxFail(1);
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     String userId = RoleInterface.getUserId(this.roleId);
/*  57 */     if (userId == null)
/*     */     {
/*  59 */       onBuyFriendsCircleTreasureBoxFail(6);
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  65 */     if (!FriendsCircleManager.isRoleLevelFriendsCircleOpen(this.roleId))
/*     */     {
/*  67 */       onBuyFriendsCircleTreasureBoxFail(44);
/*  68 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  72 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1821, true, true))
/*     */     {
/*  74 */       onBuyFriendsCircleTreasureBoxFail(47);
/*  75 */       return false;
/*     */     }
/*  77 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.roleId);
/*     */     
/*  79 */     int originalTreasureBoxNum = xRole2FriendsCircleInfo.getTreasure_box_num();
/*  80 */     int placeTreasureBoxNumMax = SFriendsCircleConsts.getInstance().place_treasure_box_max_num;
/*     */     
/*  82 */     if (originalTreasureBoxNum >= placeTreasureBoxNumMax)
/*     */     {
/*  84 */       Map<String, Object> extraMap = new HashMap();
/*  85 */       extraMap.put("place_treasure_box_num_max", Integer.valueOf(placeTreasureBoxNumMax));
/*  86 */       extraMap.put("current_treasure_box", Integer.valueOf(originalTreasureBoxNum));
/*     */       
/*  88 */       onBuyFriendsCircleTreasureBoxFail(5, extraMap);
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     if (originalTreasureBoxNum + this.buyCount > placeTreasureBoxNumMax)
/*     */     {
/*  94 */       Map<String, Object> extraMap = new HashMap();
/*  95 */       extraMap.put("place_treasure_box_num_max", Integer.valueOf(placeTreasureBoxNumMax));
/*  96 */       extraMap.put("current_treasure_box", Integer.valueOf(originalTreasureBoxNum));
/*     */       
/*  98 */       onBuyFriendsCircleTreasureBoxFail(11, extraMap);
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     long goldValue = RoleInterface.getGold(this.roleId);
/* 103 */     if (goldValue != this.clientCurrencyValue)
/*     */     {
/* 105 */       Map<String, Object> extraMap = new HashMap();
/* 106 */       extraMap.put("server_currency_value", Long.valueOf(goldValue));
/*     */       
/* 108 */       onBuyFriendsCircleTreasureBoxFail(7, extraMap);
/* 109 */       return false;
/*     */     }
/* 111 */     int needGold = SFriendsCircleConsts.getInstance().treasure_box_gold_price * this.buyCount;
/*     */     
/* 113 */     if ((goldValue < needGold) || (needGold < 0))
/*     */     {
/* 115 */       Map<String, Object> extraMap = new HashMap();
/* 116 */       extraMap.put("need_gold", Integer.valueOf(needGold));
/* 117 */       extraMap.put("server_gold_value", Long.valueOf(goldValue));
/*     */       
/* 119 */       onBuyFriendsCircleTreasureBoxFail(8, extraMap);
/* 120 */       return false;
/*     */     }
/*     */     
/* 123 */     boolean result = RoleInterface.cutGold(this.roleId, needGold, new TLogArg(mzm.gsp.tlog.LogReason.FRIENDS_CIRCLE_BUY_TREASURE_BOX));
/*     */     
/* 125 */     if (!result)
/*     */     {
/* 127 */       onBuyFriendsCircleTreasureBoxFail(9);
/* 128 */       return false;
/*     */     }
/*     */     
/* 131 */     int nowTreasureBoxNum = originalTreasureBoxNum + this.buyCount;
/* 132 */     xRole2FriendsCircleInfo.setTreasure_box_num(nowTreasureBoxNum);
/*     */     
/* 134 */     SBuyFriendsCircleTreasureBoxSuccess sBuyFriendsCircleTreasureBoxSuccess = new SBuyFriendsCircleTreasureBoxSuccess();
/* 135 */     sBuyFriendsCircleTreasureBoxSuccess.now_treasure_box_num = nowTreasureBoxNum;
/*     */     
/* 137 */     OnlineManager.getInstance().send(this.roleId, sBuyFriendsCircleTreasureBoxSuccess);
/*     */     
/* 139 */     long serialId = FriendsCircleManager.getFriendsCircleSerialId();
/*     */     
/* 141 */     FriendsCirclePlaceTreasureResult xFriendsCirclePlaceTreasureResult = xbean.Pod.newFriendsCirclePlaceTreasureResult();
/* 142 */     xFriendsCirclePlaceTreasureResult.setIs_ssp_replied(false);
/* 143 */     xFriendsCirclePlaceTreasureResult.setPlace_treasure_count(this.buyCount);
/*     */     
/* 145 */     xRole2FriendsCircleInfo.getPlace_treasure_result().put(Long.valueOf(serialId), xFriendsCirclePlaceTreasureResult);
/* 146 */     FriendsCircleManager.reportPlaceTreasure(this.roleId, this.buyCount, serialId);
/*     */     
/* 148 */     RoleStatusInterface.setStatus(this.roleId, 2001, false);
/*     */     
/* 150 */     tlogFriendsCircleBuyTreasure(userId, this.roleId, this.buyCount, serialId, xRole2FriendsCircleInfo.getTreasure_box_num());
/*     */     
/* 152 */     StringBuilder sBuilder = new StringBuilder();
/* 153 */     sBuilder.append("[friendscircle]PCBuyFriendsCircleTreasureBox.processImp@buy treasure box success");
/* 154 */     sBuilder.append("|role_id=").append(this.roleId);
/* 155 */     sBuilder.append("|buy_count=").append(this.buyCount);
/* 156 */     sBuilder.append("|client_currency_value=").append(this.clientCurrencyValue);
/* 157 */     sBuilder.append("|original_treasure_box=").append(originalTreasureBoxNum);
/* 158 */     sBuilder.append("|current_total_treasure_box=").append(nowTreasureBoxNum);
/* 159 */     sBuilder.append("|serial_id=").append(serialId);
/*     */     
/* 161 */     GameServer.logger().info(sBuilder.toString());
/*     */     
/* 163 */     return true;
/*     */   }
/*     */   
/*     */   private void onBuyFriendsCircleTreasureBoxFail(int ret)
/*     */   {
/* 168 */     onBuyFriendsCircleTreasureBoxFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onBuyFriendsCircleTreasureBoxFail(int ret, Map<String, Object> extraMap)
/*     */   {
/* 173 */     StringBuilder sbLog = new StringBuilder();
/* 174 */     sbLog.append("[friendscircle]PCBuyFriendsCircleTreasureBox.processImp@buy treasure box failed");
/* 175 */     sbLog.append("|ret=").append(ret);
/* 176 */     sbLog.append("|role_id=").append(this.roleId);
/* 177 */     sbLog.append("|buy_count=").append(this.buyCount);
/* 178 */     sbLog.append("|client_currency_value=").append(this.clientCurrencyValue);
/* 179 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 181 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 183 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 186 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 188 */     SFriendsCircleNormalRes sFriendsCircleNormalRes = new SFriendsCircleNormalRes();
/* 189 */     sFriendsCircleNormalRes.ret = ret;
/*     */     
/* 191 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sFriendsCircleNormalRes);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void tlogFriendsCircleBuyTreasure(String userId, long roleId, int buyNum, long serialId, int nowOwnNum)
/*     */   {
/* 200 */     int roleLevel = RoleInterface.getLevel(roleId);
/*     */     
/* 202 */     StringBuilder sbLog = new StringBuilder();
/* 203 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 204 */     sbLog.append(userId).append('|');
/* 205 */     sbLog.append(roleId).append('|');
/* 206 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 208 */     sbLog.append(buyNum).append('|');
/* 209 */     sbLog.append(serialId).append('|');
/* 210 */     sbLog.append(nowOwnNum);
/*     */     
/* 212 */     TLogManager.getInstance().addLog(roleId, "FriendsCircleBuyTreasure", sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\PCBuyFriendsCircleTreasureBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */