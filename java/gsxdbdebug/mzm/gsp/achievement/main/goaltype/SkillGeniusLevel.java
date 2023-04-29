/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.genius.main.GeniusInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SkillGeniusLevel
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 22 */     return 1812;
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
/* 36 */     int nowPoint = GeniusInterface.getGeniusAddPoint(roleId, goalSkillId, true);
/*    */     
/* 38 */     int oldPoint = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 39 */     if (oldPoint == nowPoint)
/*    */     {
/* 41 */       return false;
/*    */     }
/* 43 */     int goalPoint = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 44 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalPoint, nowPoint)));
/*    */     
/* 46 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 53 */     return updateState(roleId, xAchievementInfo, sAchievementGoalCfg, null);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\SkillGeniusLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */