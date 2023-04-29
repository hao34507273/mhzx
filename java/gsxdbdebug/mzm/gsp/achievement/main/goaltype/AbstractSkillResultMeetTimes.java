/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import xbean.AchievementInfo;
/*    */ import xbean.SkillResult;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractSkillResultMeetTimes
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 21 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 28 */     if (null == context)
/*    */     {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     SkillResult skillResultData = (SkillResult)context;
/*    */     
/* 35 */     Map<Integer, Integer> skillResultCountMap = getSkillResultCountMap(skillResultData);
/*    */     
/* 37 */     int goalSkillId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 38 */     int goalCount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 39 */     Integer nowCount = (Integer)skillResultCountMap.get(Integer.valueOf(goalSkillId));
/* 40 */     if ((null == nowCount) || (nowCount.intValue() < goalCount))
/*    */     {
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     int oldFinishCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 46 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(oldFinishCount + 1));
/*    */     
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   protected abstract Map<Integer, Integer> getSkillResultCountMap(SkillResult paramSkillResult);
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\AbstractSkillResultMeetTimes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */