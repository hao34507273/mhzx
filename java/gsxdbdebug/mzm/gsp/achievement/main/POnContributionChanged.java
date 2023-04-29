/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalDoneOneEventTimes.Context;
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalValueChange.Context;
/*    */ import mzm.gsp.gang.event.ContributionChangedArg;
/*    */ import mzm.gsp.gang.event.ContributionChangedProcedure;
/*    */ 
/*    */ 
/*    */ public class POnContributionChanged
/*    */   extends ContributionChangedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 14 */     AbstractConditionalValueChange.Context ctx1 = new AbstractConditionalValueChange.Context(4, (int)((ContributionChangedArg)this.arg).newCurContribution);
/*    */     
/*    */ 
/* 17 */     AchievementManager.updateGoalTypeState(((ContributionChangedArg)this.arg).roleid, 4702, ctx1, "POnContributionChanged.processImp@handle OWN_MONEY finish");
/*    */     
/*    */ 
/*    */ 
/* 21 */     int changeNum = (int)(((ContributionChangedArg)this.arg).newCurContribution - ((ContributionChangedArg)this.arg).oldCurContribution);
/* 22 */     AbstractConditionalDoneOneEventTimes.Context ctx2 = new AbstractConditionalDoneOneEventTimes.Context(4, Math.abs(changeNum));
/*    */     
/*    */ 
/* 25 */     if (changeNum > 0)
/*    */     {
/*    */ 
/* 28 */       AchievementManager.updateGoalTypeState(((ContributionChangedArg)this.arg).roleid, 4705, ctx2, "POnJiFenChanged.processImp@handle ACCUMULAT_GET_MONEY finish");
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/* 34 */       AchievementManager.updateGoalTypeState(((ContributionChangedArg)this.arg).roleid, 4701, ctx2, "POnJiFenChanged.processImp@handle ACCUMULAT_COST_MONEY finish");
/*    */     }
/*    */     
/*    */ 
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnContributionChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */