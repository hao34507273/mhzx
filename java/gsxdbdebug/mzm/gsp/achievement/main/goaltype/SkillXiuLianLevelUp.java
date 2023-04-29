/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.xiulian.main.XiuLianSkillInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SkillXiuLianLevelUp
/*    */   extends AbstractDoneOneEventLevelTimes
/*    */ {
/*    */   public int getType()
/*    */   {
/* 21 */     return 1805;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 28 */     List<Integer> xGoalParameter = xAchievementInfo.getGoal_parameters();
/* 29 */     int goalLevel = ((Integer)goalParameters.get(1)).intValue();
/* 30 */     Map<Integer, Integer> skillLevelMap = XiuLianSkillInterface.getXiuLianSkill(roleId);
/*    */     
/* 32 */     int maxSkillLevel = 0;
/* 33 */     int skillNum = 0;
/* 34 */     for (Map.Entry<Integer, Integer> entry : skillLevelMap.entrySet())
/*    */     {
/* 36 */       int skillLevel = ((Integer)entry.getValue()).intValue();
/* 37 */       if (skillLevel > maxSkillLevel)
/*    */       {
/* 39 */         maxSkillLevel = skillLevel > goalLevel ? goalLevel : skillLevel;
/*    */       }
/* 41 */       if (skillLevel >= goalLevel)
/*    */       {
/* 43 */         skillNum++;
/*    */       }
/*    */     }
/* 46 */     int goalSkillSize = ((Integer)goalParameters.get(0)).intValue();
/* 47 */     if (skillNum > ((Integer)xGoalParameter.get(0)).intValue())
/*    */     {
/* 49 */       xGoalParameter.set(0, Integer.valueOf(skillNum > goalSkillSize ? goalSkillSize : skillNum));
/*    */     }
/* 51 */     if (maxSkillLevel > ((Integer)xGoalParameter.get(1)).intValue())
/*    */     {
/* 53 */       xGoalParameter.set(1, Integer.valueOf(maxSkillLevel));
/*    */     }
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\SkillXiuLianLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */