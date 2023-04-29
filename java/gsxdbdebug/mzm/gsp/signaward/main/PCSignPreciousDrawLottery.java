/*     */ package mzm.gsp.signaward.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.item.main.LotteryManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.signaward.SSignAwardErrorInfo;
/*     */ import mzm.gsp.signaward.SSignPreciousDrawLotterySuccess;
/*     */ import mzm.gsp.signaward.confbean.SignAwardCfgConsts;
/*     */ import mzm.gsp.signprecious.confbean.SChessBoxAwardCfg;
/*     */ import mzm.gsp.signprecious.confbean.SSignPreciousConsts;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Sign;
/*     */ import xtable.Role2sign;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCSignPreciousDrawLottery extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCSignPreciousDrawLottery(long roleId)
/*     */   {
/*  31 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!SignAwardManager.isSignPreciousSwitchOpen(this.roleId))
/*     */     {
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     String userId = RoleInterface.getUserId(this.roleId);
/*     */     
/*     */ 
/*  45 */     lock(xdb.Lockeys.get(User.getTable(), userId));
/*     */     
/*     */ 
/*  48 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 941, true, true))
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*  54 */     if (roleLevel < SignAwardCfgConsts.getInstance().CAN_SIGN_LEVEL)
/*     */     {
/*  56 */       onSignPreciousDrawLotteryFail(4);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     Sign xSign = Role2sign.get(Long.valueOf(this.roleId));
/*  61 */     if (xSign == null)
/*     */     {
/*  63 */       onSignPreciousDrawLotteryFail(14);
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     int currentPreciousBoxBuffId = xSign.getCurrent_precious_box_buff_id();
/*  68 */     if (currentPreciousBoxBuffId <= 0)
/*     */     {
/*  70 */       onSignPreciousDrawLotteryFail(29);
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     if (!LotteryManager.canAdd(this.roleId, 9))
/*     */     {
/*  76 */       onSignPreciousDrawLotteryFail(24);
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     int xCurrentPreciousCellNum = xSign.getCurrent_precious_cell_num();
/*  81 */     SChessBoxAwardCfg sChessBoxAwardCfg = SChessBoxAwardCfg.get(xCurrentPreciousCellNum);
/*  82 */     if (sChessBoxAwardCfg == null)
/*     */     {
/*  84 */       Map<String, Object> extraMap = new HashMap();
/*  85 */       extraMap.put("cell_num", Integer.valueOf(xCurrentPreciousCellNum));
/*     */       
/*  87 */       onSignPreciousDrawLotteryFail(15, extraMap);
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     int goldPreciousCfgId = sChessBoxAwardCfg.gold_precious_cfg_id;
/*     */     
/*     */ 
/*  94 */     AwardPoolResultData awardPoolResultData = AwardPoolInterface.getLotteryResultData(this.roleId, goldPreciousCfgId);
/*     */     
/*  96 */     if (awardPoolResultData == null)
/*     */     {
/*  98 */       onSignPreciousDrawLotteryFail(26);
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     if (awardPoolResultData.getItemMap().isEmpty())
/*     */     {
/* 104 */       onSignPreciousDrawLotteryFail(27);
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     boolean ret = LotteryManager.addLottery(this.roleId, 9, 0, awardPoolResultData, new TLogArg(mzm.gsp.tlog.LogReason.SIGN_PRECIOUS_DRAW_LOTTERY_AWARD_ITEM), SSignPreciousConsts.getInstance().draw_lottery_delay_award_seconds);
/*     */     
/*     */ 
/* 111 */     if (!ret)
/*     */     {
/* 113 */       onSignPreciousDrawLotteryFail(28);
/* 114 */       return false;
/*     */     }
/*     */     
/* 117 */     int itemId = ((Integer)awardPoolResultData.getItemMap().keySet().iterator().next()).intValue();
/* 118 */     int itemNum = ((Integer)awardPoolResultData.getItemMap().get(Integer.valueOf(itemId))).intValue();
/*     */     
/* 120 */     SSignPreciousDrawLotterySuccess signPreciousDrawLotterySuccess = new SSignPreciousDrawLotterySuccess();
/* 121 */     signPreciousDrawLotterySuccess.item_id = itemId;
/* 122 */     signPreciousDrawLotterySuccess.item_num = itemNum;
/* 123 */     signPreciousDrawLotterySuccess.lottery_view_id = sChessBoxAwardCfg.gold_precious_cfg_id;
/* 124 */     signPreciousDrawLotterySuccess.final_index = (awardPoolResultData.getIndex() + 1);
/* 125 */     signPreciousDrawLotterySuccess.buff_id = currentPreciousBoxBuffId;
/* 126 */     signPreciousDrawLotterySuccess.box_type = sChessBoxAwardCfg.cell_award_type;
/* 127 */     OnlineManager.getInstance().send(this.roleId, signPreciousDrawLotterySuccess);
/*     */     
/* 129 */     GameServer.logger().info(String.format("[sign]PCSignPreciousDrawLottery.processImp@sign precious draw lottery success|role_id=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */     
/*     */ 
/* 132 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onSignPreciousDrawLotteryFail(int ret)
/*     */   {
/* 145 */     onSignPreciousDrawLotteryFail(ret, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onSignPreciousDrawLotteryFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 158 */     StringBuilder sbLog = new StringBuilder();
/* 159 */     sbLog.append("[sign]PCSignPreciousAbstractDrawLottery.processImp@draw precious box failed");
/* 160 */     sbLog.append("|ret=").append(ret);
/* 161 */     sbLog.append("|role_id=").append(this.roleId);
/* 162 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 164 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 166 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 169 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 171 */     SSignAwardErrorInfo sSignAwardErrorInfo = new SSignAwardErrorInfo();
/* 172 */     sSignAwardErrorInfo.rescode = ret;
/*     */     
/* 174 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sSignAwardErrorInfo);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\main\PCSignPreciousDrawLottery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */