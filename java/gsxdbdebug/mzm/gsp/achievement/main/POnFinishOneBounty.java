/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.BountyConsts;
/*    */ import mzm.gsp.bounty.event.FinishOneTaskArg;
/*    */ import mzm.gsp.bounty.event.FinishOneTaskProcedure;
/*    */ 
/*    */ public class POnFinishOneBounty
/*    */   extends FinishOneTaskProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     AchievementManager.updateGoalTypeState(((FinishOneTaskArg)this.arg).getRoleId(), 2400, Integer.valueOf(BountyConsts.getInstance().ACTIVITYID), "POnFinishOneBounty.processImp@handle ACTIVITY_JOIN finish");
/*    */     
/*    */ 
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnFinishOneBounty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */