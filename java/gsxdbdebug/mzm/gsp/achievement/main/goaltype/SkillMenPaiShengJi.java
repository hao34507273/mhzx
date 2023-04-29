/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.skill.main.SkillInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SkillMenPaiShengJi
/*    */   extends AbstractDoneOneEventLevelTimes
/*    */ {
/*    */   public int getType()
/*    */   {
/* 22 */     return 1800;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 29 */     Map<Integer, Integer> skillLevelMap = SkillInterface.getOccupationSkillLevel(roleId, true);
/*    */     
/*    */ 
/* 32 */     int goalLevel = ((Integer)goalParameters.get(1)).intValue();
/* 33 */     int maxLevel = 0;
/* 34 */     Map<Long, String> goalParameterExtraMap = xAchievementInfo.getGoal_parameters_extra();
/* 35 */     for (Map.Entry<Integer, Integer> entry : skillLevelMap.entrySet())
/*    */     {
/* 37 */       int skillLevel = ((Integer)entry.getValue()).intValue();
/* 38 */       if (skillLevel >= goalLevel)
/*    */       {
/* 40 */         int skillId = ((Integer)entry.getKey()).intValue();
/* 41 */         goalParameterExtraMap.put(Long.valueOf(skillId), String.valueOf(skillId));
/*    */       }
/* 43 */       maxLevel = Math.max(maxLevel, skillLevel);
/*    */     }
/*    */     
/*    */ 
/* 47 */     List<Integer> parameters = xAchievementInfo.getGoal_parameters();
/* 48 */     if ((maxLevel == ((Integer)parameters.get(0)).intValue()) && (goalParameterExtraMap.size() == ((Integer)parameters.get(1)).intValue()))
/*    */     {
/*    */ 
/* 51 */       return false;
/*    */     }
/* 53 */     int goalNum = ((Integer)goalParameters.get(0)).intValue();
/* 54 */     parameters.set(0, Integer.valueOf(Math.min(goalNum, goalParameterExtraMap.size())));
/* 55 */     parameters.set(1, Integer.valueOf(Math.min(goalLevel, maxLevel)));
/*    */     
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\SkillMenPaiShengJi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */