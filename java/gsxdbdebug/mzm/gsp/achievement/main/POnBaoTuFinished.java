/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.baotu.event.BaoTuActivityArg;
/*    */ import mzm.gsp.baotu.event.BaoTuActivityFinishedProcedure;
/*    */ 
/*    */ public class POnBaoTuFinished
/*    */   extends BaoTuActivityFinishedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 12 */     AchievementManager.updateGoalTypeState(((BaoTuActivityArg)this.arg).getRoleid(), 2400, Integer.valueOf(((BaoTuActivityArg)this.arg).getActivityId()), "POnBaoTuFinished.processImp@handle ACTIVITY_JOIN finish");
/*    */     
/*    */ 
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnBaoTuFinished.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */