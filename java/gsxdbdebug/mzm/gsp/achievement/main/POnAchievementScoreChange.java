/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.event.AchievementScoreChangeArg;
/*    */ import mzm.gsp.achievement.event.AchievementScoreChangeProcedure;
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalValueChange.Context;
/*    */ 
/*    */ 
/*    */ public class POnAchievementScoreChange
/*    */   extends AchievementScoreChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 13 */     AbstractConditionalValueChange.Context ctx = new AbstractConditionalValueChange.Context(((AchievementScoreChangeArg)this.arg).activityId, ((AchievementScoreChangeArg)this.arg).nowScore);
/* 14 */     AchievementManager.updateGoalTypeState(((AchievementScoreChangeArg)this.arg).roleId, 3305, ctx, "POnAchievementScoreChange.processImp@handle ACHIEVEMENT_SCORE_VALUE finish");
/*    */     
/*    */ 
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnAchievementScoreChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */