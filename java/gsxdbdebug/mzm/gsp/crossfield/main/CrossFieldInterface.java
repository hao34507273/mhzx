/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import hub.ExchangeDataHandlerInfo;
/*    */ import mzm.gsp.crossfield.SSynCrossFieldWaitNextRoundMatch;
/*    */ import mzm.gsp.crossfield.confbean.SCrossFieldCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrossFieldInterface
/*    */ {
/*    */   public static int getFieldRoleNum(int activityCfgid)
/*    */   {
/* 21 */     SCrossFieldCfg cfg = SCrossFieldCfg.get(activityCfgid);
/* 22 */     if (cfg == null)
/*    */     {
/* 24 */       return -1;
/*    */     }
/* 26 */     return cfg.role_num;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getSingleBattleCfgid(int activityCfgid)
/*    */   {
/* 37 */     SCrossFieldCfg cfg = SCrossFieldCfg.get(activityCfgid);
/* 38 */     if (cfg == null)
/*    */     {
/* 40 */       return -1;
/*    */     }
/* 42 */     return cfg.single_battle_cfg_id;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean onDataBack(String userid, long roleid, boolean isActiveLeave, int season, int result, int changePoint, boolean isMVP, long startTimestamp, int pvpFightTimes, ExchangeDataHandlerInfo exchangeDataHandlerInfo)
/*    */   {
/* 60 */     return CrossFieldManager.onDataBack(userid, roleid, isActiveLeave, season, result, changePoint, isMVP, startTimestamp, pvpFightTimes, exchangeDataHandlerInfo);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void onWaitNextRoundMatch(long roleid, byte reason)
/*    */   {
/* 73 */     SSynCrossFieldWaitNextRoundMatch protocol = new SSynCrossFieldWaitNextRoundMatch();
/* 74 */     protocol.reason = reason;
/* 75 */     OnlineManager.getInstance().send(roleid, protocol);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\CrossFieldInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */