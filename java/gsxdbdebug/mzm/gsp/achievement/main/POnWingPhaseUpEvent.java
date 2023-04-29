/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.wing.event.WingPhaseUpArg;
/*    */ import mzm.gsp.wing.event.WingPhaseUpEventProcedure;
/*    */ 
/*    */ public class POnWingPhaseUpEvent
/*    */   extends WingPhaseUpEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((WingPhaseUpArg)this.arg).getRoleid(), 3902, Integer.valueOf(((WingPhaseUpArg)this.arg).getNewphase()), "POnWingPhaseUpEvent.processImp@handle WING_SHENGJIE success");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnWingPhaseUpEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */