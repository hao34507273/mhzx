/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ReportCrossBattleOwnResultSession
/*    */   extends Session
/*    */ {
/*    */   private final int activityCfgid;
/*    */   
/*    */   public ReportCrossBattleOwnResultSession(long interval, int activityCfgid)
/*    */   {
/* 16 */     super(interval, 0L);
/* 17 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 23 */     CrossBattleOwnManager.logger.info(String.format("[crossbattle_own]ReportCrossBattleOwnResultSession.onTimeOut@session timeout|sessionid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(getSessionId()), Integer.valueOf(this.activityCfgid) }));
/*    */     
/*    */ 
/* 26 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new PTryReportCrossBattleOwnResult(this.activityCfgid));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\ReportCrossBattleOwnResultSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */