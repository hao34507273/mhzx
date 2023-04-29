/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.lifeskill.main.LifeSkillInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SkillShengHuoLevel
/*    */   extends AbstractConditionalValueChange
/*    */ {
/*    */   public int getType()
/*    */   {
/* 21 */     return 1810;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 28 */     Map<Integer, Integer> skillLevelMap = LifeSkillInterface.getLifeSkill(roleId);
/* 29 */     int goalSkillId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 30 */     int currentLevel = ((Integer)skillLevelMap.get(Integer.valueOf(goalSkillId))).intValue();
/*    */     
/*    */ 
/* 33 */     int oldLevel = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 34 */     if (currentLevel == oldLevel)
/*    */     {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     int goalLevel = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 40 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalLevel, currentLevel)));
/*    */     
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\SkillShengHuoLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */