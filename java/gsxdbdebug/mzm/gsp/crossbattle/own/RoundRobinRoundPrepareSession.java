/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoundRobinRoundPrepareSession
/*    */   extends Session
/*    */ {
/*    */   private final int activityCfgid;
/*    */   private final int roundIndex;
/*    */   private final boolean isMain;
/*    */   
/*    */   public RoundRobinRoundPrepareSession(long interval, int activityCfgid, int roundIndex, boolean isMain)
/*    */   {
/* 19 */     super(interval, 0L);
/* 20 */     this.activityCfgid = activityCfgid;
/* 21 */     this.roundIndex = roundIndex;
/* 22 */     this.isMain = isMain;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 28 */     CrossBattleOwnManager.logger.info(String.format("[crossbattle_own]RoundRobinRoundPrepareSession.onTimeOut@session timeout|sessionid=%d|activity_cfg_id=%d|round_index=%d|is_main=%b", new Object[] { Long.valueOf(getSessionId()), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.roundIndex), Boolean.valueOf(this.isMain) }));
/*    */     
/*    */ 
/* 31 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new POnRoundRobinRoundPrepareStageStart(this.activityCfgid, this.roundIndex, this.isMain));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\RoundRobinRoundPrepareSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */