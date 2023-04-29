/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.achievement.main.AchievementInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AchievementScoreValue
/*    */   extends AbstractConditionalValueChange
/*    */ {
/*    */   public int getType()
/*    */   {
/* 20 */     return 3305;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 27 */     int goalActivityCfgId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 28 */     int nowScore = AchievementInterface.getAchievementScore(roleId, goalActivityCfgId, true);
/* 29 */     List<Integer> xGoalParams = xAchievementInfo.getGoal_parameters();
/* 30 */     int oldScore = ((Integer)xGoalParams.get(0)).intValue();
/* 31 */     if (oldScore == nowScore)
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     int goalScore = ((Integer)goalParameters.get(0)).intValue();
/* 37 */     xGoalParams.set(0, Integer.valueOf(Math.min(goalScore, nowScore)));
/*    */     
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\AchievementScoreValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */