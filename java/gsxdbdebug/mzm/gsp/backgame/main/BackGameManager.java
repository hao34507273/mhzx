/*     */ package mzm.gsp.backgame.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.active.main.ActiveInterface;
/*     */ import mzm.gsp.backgame.confbean.BackGameConsts;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.common.confbean.STimeCommonCfg;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2BackGameInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BackGameManager
/*     */ {
/*     */   private static final String BACK_GAME_BACK_DAY_STATIS = "BackGameBackDayStatis";
/*     */   private static final String BACK_GAME_SCORE_AWARD = "BackGameScoreAward";
/*     */   
/*     */   static int getAwardReservedExpDayRatio(int offLineDays)
/*     */   {
/*  33 */     if (offLineDays <= BackGameConsts.getInstance().awardReserveExpMinDay)
/*     */     {
/*  35 */       return BackGameConsts.getInstance().awardReserveExpMinDay;
/*     */     }
/*  37 */     if (offLineDays >= BackGameConsts.getInstance().awardReserveExpMaxDay)
/*     */     {
/*  39 */       return BackGameConsts.getInstance().awardReserveExpMaxDay;
/*     */     }
/*     */     
/*     */ 
/*  43 */     return offLineDays;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkAndClearBackGameScore(Role2BackGameInfo xRole2BackGameInfo, String userId, long roleId, long baseYuanBaoValue, int baseActiveValue, String logStr)
/*     */   {
/*  60 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*     */ 
/*  63 */     long lastClearScoreTime = xRole2BackGameInfo.getClear_score_time();
/*     */     
/*  65 */     STimeCommonCfg sTimeCommonCfg = TimeCommonUtil.getCommonCfg(BackGameConsts.getInstance().scoreResetTime);
/*  66 */     boolean isNeedReset = DateTimeUtils.needDailyReset(lastClearScoreTime, currentTimeMillis, sTimeCommonCfg.activeHour, sTimeCommonCfg.activeMinute);
/*     */     
/*     */ 
/*  69 */     if (isNeedReset)
/*     */     {
/*  71 */       int oldActiveBaseValue = xRole2BackGameInfo.getActive_base_value();
/*  72 */       long oldYuanBaoSaveAmtBaseValue = xRole2BackGameInfo.getYuan_bao_save_amt_base_value();
/*     */       
/*  74 */       long newYuanBaoSaveAmtBaseValue = baseYuanBaoValue < 0L ? QingfuInterface.getSaveAmt(userId, true) : baseYuanBaoValue;
/*     */       
/*  76 */       int newActiveBaseValue = baseActiveValue < 0 ? ActiveInterface.getTotalActiveValue(roleId) : baseActiveValue;
/*     */       
/*  78 */       xRole2BackGameInfo.setActive_base_value(newActiveBaseValue);
/*  79 */       xRole2BackGameInfo.setYuan_bao_save_amt_base_value(newYuanBaoSaveAmtBaseValue);
/*     */       
/*  81 */       xRole2BackGameInfo.setClear_score_time(currentTimeMillis);
/*  82 */       xRole2BackGameInfo.getAleardy_awarded_score_index_list().clear();
/*  83 */       GameServer.logger().info(String.format("[backgame]%s@role back game score reset|role_id=%d|reset_time=%d|old_active_base_value=%d|new_active_base_value=%d|old_yuan_bao_save_amt_base_value=%d|new_yuan_bao_save_amt_base_value=%d|aleardy_awarded_score_index=%s", new Object[] { logStr, Long.valueOf(roleId), Long.valueOf(currentTimeMillis), Integer.valueOf(oldActiveBaseValue), Integer.valueOf(newActiveBaseValue), Long.valueOf(oldYuanBaoSaveAmtBaseValue), Long.valueOf(newYuanBaoSaveAmtBaseValue), xRole2BackGameInfo.getAleardy_awarded_score_index_list().toString() }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getNowBackGameScoreValue(String userId, long roleId, Role2BackGameInfo xRole2BackGameInfo)
/*     */   {
/*  94 */     int activeBaseValue = xRole2BackGameInfo.getActive_base_value();
/*  95 */     long yuanBaoSaveAmtBaseValue = xRole2BackGameInfo.getYuan_bao_save_amt_base_value();
/*     */     
/*  97 */     int nowActiveValue = ActiveInterface.getTotalActiveValue(roleId);
/*  98 */     long nowYuanBaoSaveAmtValue = QingfuInterface.getSaveAmt(userId, true);
/*     */     
/* 100 */     int nowScore = (nowActiveValue - activeBaseValue) * BackGameConsts.getInstance().activeExchangeRate + (int)(nowYuanBaoSaveAmtValue - yuanBaoSaveAmtBaseValue) * BackGameConsts.getInstance().yuanBaoExchangeRate;
/*     */     
/*     */ 
/* 103 */     return nowScore;
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
/*     */ 
/*     */   static boolean isInBackState(long currentTimeMillis, long backGameStateStartTime)
/*     */   {
/* 117 */     return currentTimeMillis - backGameStateStartTime < BackGameConsts.getInstance().lastTime * 86400000L;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isBackGameSwitchOpen(long roleId, String logString, boolean isNeedLog, boolean isSendTips)
/*     */   {
/* 135 */     if (!OpenInterface.getOpenStatus(124))
/*     */     {
/* 137 */       if (isNeedLog)
/*     */       {
/* 139 */         GameServer.logger().info(String.format("[backgame]%s@back game system switch closed|role_id=%d", new Object[] { logString, Long.valueOf(roleId) }));
/*     */       }
/*     */       
/*     */ 
/* 143 */       if (isSendTips)
/*     */       {
/* 145 */         OpenInterface.sendCloseProtocol(roleId, 124, null);
/*     */       }
/* 147 */       return false;
/*     */     }
/*     */     
/* 150 */     if (OpenInterface.isBanPlay(roleId, 124))
/*     */     {
/* 152 */       if (isNeedLog)
/*     */       {
/* 154 */         GameServer.logger().info(String.format("[backgame]%s@back game is ban play|role_id=%d", new Object[] { logString, Long.valueOf(roleId) }));
/*     */       }
/*     */       
/* 157 */       if (isSendTips)
/*     */       {
/* 159 */         OpenInterface.sendBanPlayMsg(roleId, 124);
/*     */       }
/*     */       
/* 162 */       return false;
/*     */     }
/*     */     
/* 165 */     return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void tlogBackGameStatis(long roleId, int roleLevel, String userId, int offLineDays)
/*     */   {
/* 182 */     StringBuilder sbLog = new StringBuilder();
/* 183 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 184 */     sbLog.append(userId).append('|');
/* 185 */     sbLog.append(roleId).append('|');
/* 186 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 188 */     sbLog.append(offLineDays);
/*     */     
/* 190 */     TLogManager.getInstance().addLog(roleId, "BackGameBackDayStatis", sbLog.toString());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void tlogBackGameScoreAward(long roleId, String userId, int awardIndex, int scoreCfgValue, int scoreNow)
/*     */   {
/* 209 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 210 */     StringBuilder sbLog = new StringBuilder();
/* 211 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 212 */     sbLog.append(userId).append('|');
/* 213 */     sbLog.append(roleId).append('|');
/* 214 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 216 */     sbLog.append(awardIndex).append('|');
/* 217 */     sbLog.append(scoreCfgValue).append('|');
/* 218 */     sbLog.append(scoreNow);
/*     */     
/* 220 */     TLogManager.getInstance().addLog(roleId, "BackGameScoreAward", sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgame\main\BackGameManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */