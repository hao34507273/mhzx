/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoundRobinRoundFightSession
/*    */   extends Session
/*    */ {
/*    */   private final int activityCfgid;
/*    */   private final int roundIndex;
/*    */   private final boolean isMain;
/*    */   
/*    */   public RoundRobinRoundFightSession(long interval, int activityCfgid, int roundIndex, boolean isMain)
/*    */   {
/* 18 */     super(interval, 0L);
/* 19 */     this.activityCfgid = activityCfgid;
/* 20 */     this.roundIndex = roundIndex;
/* 21 */     this.isMain = isMain;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 27 */     CrossBattleOwnManager.logger.info(String.format("[crossbattle_own]RoundRobinRoundFightSession.onTimeOut@session timeout|sessionid=%d|activity_cfg_id=%d|round_index=%d|is_main=%b", new Object[] { Long.valueOf(getSessionId()), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.roundIndex), Boolean.valueOf(this.isMain) }));
/*    */     
/*    */ 
/* 30 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new POnRoundRobinRoundFightStageStart(this.activityCfgid, this.roundIndex, this.isMain));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\RoundRobinRoundFightSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */