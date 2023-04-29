/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.event.AchievementGoalFinishArg;
/*    */ import mzm.gsp.achievement.event.AchievementGoalFinishProcedure;
/*    */ 
/*    */ public class POnAchievementGoalFinish
/*    */   extends AchievementGoalFinishProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((AchievementGoalFinishArg)this.arg).roleId, 3307, Integer.valueOf(((AchievementGoalFinishArg)this.arg).goalCfgId), "POnAchievementGoalFinish.processImp@handle ACHIEVEMENT_FINISH finish");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnAchievementGoalFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */