/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.gangskill.main.GangSkillInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SkillGangLevel
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 22 */     return 1811;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 28 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 35 */     int goalSkillId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 36 */     Map<Integer, Integer> gangSkillId2Level = GangSkillInterface.getGangSkillid2Level(roleId);
/* 37 */     Integer skillLevel = (Integer)gangSkillId2Level.get(Integer.valueOf(goalSkillId));
/* 38 */     int nowSkillLevel = null == skillLevel ? 0 : skillLevel.intValue();
/*    */     
/* 40 */     int oldSkillLevel = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 41 */     if (oldSkillLevel == nowSkillLevel)
/*    */     {
/* 43 */       return false;
/*    */     }
/* 45 */     int goalSkillLevel = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 46 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalSkillLevel, nowSkillLevel)));
/*    */     
/* 48 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 55 */     return updateState(roleId, xAchievementInfo, sAchievementGoalCfg, null);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\SkillGangLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */