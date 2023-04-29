/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.skill.main.SkillInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SkillMenPaiLevel
/*    */   extends AbstractConditionalValueChange
/*    */ {
/*    */   public int getType()
/*    */   {
/* 20 */     return 1808;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 27 */     List<Integer> xGoalParameter = xAchievementInfo.getGoal_parameters();
/*    */     
/* 29 */     Map<Integer, Integer> skillLevelMap = SkillInterface.getOccupationSkillLevel(roleId, true);
/*    */     
/* 31 */     int goalSkillId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 32 */     int goalSkillLevel = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 33 */     Integer currentSkillLevel = (Integer)skillLevelMap.get(Integer.valueOf(goalSkillId));
/* 34 */     if (null == currentSkillLevel)
/*    */     {
/* 36 */       xGoalParameter.set(0, Integer.valueOf(0));
/*    */     }
/* 38 */     if (currentSkillLevel.intValue() > ((Integer)xGoalParameter.get(0)).intValue())
/*    */     {
/* 40 */       xGoalParameter.set(0, Integer.valueOf(Math.min(currentSkillLevel.intValue(), goalSkillLevel)));
/*    */     }
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\SkillMenPaiLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */