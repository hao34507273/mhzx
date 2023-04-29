/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.lifeskill.main.LifeSkillInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SkillShengHuoLevelUp
/*    */   extends AbstractDoneOneEventLevelTimes
/*    */ {
/*    */   public int getType()
/*    */   {
/* 20 */     return 1807;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 27 */     List<Integer> xGoalParameter = xAchievementInfo.getGoal_parameters();
/* 28 */     int goalLevel = ((Integer)goalParameters.get(1)).intValue();
/* 29 */     Map<Integer, Integer> skillLevelMap = LifeSkillInterface.getLifeSkill(roleId);
/*    */     
/* 31 */     int maxSkillLevel = 0;
/* 32 */     int skillNum = 0;
/* 33 */     for (Map.Entry<Integer, Integer> entry : skillLevelMap.entrySet())
/*    */     {
/* 35 */       int skillLevel = ((Integer)entry.getValue()).intValue();
/* 36 */       if (skillLevel > maxSkillLevel)
/*    */       {
/* 38 */         maxSkillLevel = skillLevel > goalLevel ? goalLevel : skillLevel;
/*    */       }
/* 40 */       if (skillLevel >= goalLevel)
/*    */       {
/* 42 */         skillNum++;
/*    */       }
/*    */     }
/* 45 */     int goalSkillSize = ((Integer)goalParameters.get(0)).intValue();
/* 46 */     if (skillNum > ((Integer)xGoalParameter.get(0)).intValue())
/*    */     {
/* 48 */       xGoalParameter.set(0, Integer.valueOf(skillNum > goalSkillSize ? goalSkillSize : skillNum));
/*    */     }
/* 50 */     if (maxSkillLevel > ((Integer)xGoalParameter.get(1)).intValue())
/*    */     {
/* 52 */       xGoalParameter.set(1, Integer.valueOf(maxSkillLevel));
/*    */     }
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\SkillShengHuoLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */