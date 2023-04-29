/*   */ package mzm.gsp.task.surprise;
/*   */ 
/*   */ import mzm.gsp.achievement.event.AchievementGoalFinishArg;
/*   */ 
/*   */ public class PAchievementGoalFinish extends mzm.gsp.achievement.event.AchievementGoalFinishProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception
/*   */   {
/* 9 */     return SurpriseTaskManager.handAchievementGraph(((AchievementGoalFinishArg)this.arg).roleId, ((AchievementGoalFinishArg)this.arg).goalCfgId, ((AchievementGoalFinishArg)this.arg).activityCfgId);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\surprise\PAchievementGoalFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */