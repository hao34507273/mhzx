/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.changemodelcard.main.ChangeModelCardInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChangeModelCardClassLevelQualityNum
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 23 */     return 3308;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 29 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 36 */     int needClassType = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 37 */     int needLevel = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(2)).parameter;
/* 38 */     int needQuality = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(3)).parameter;
/* 39 */     int newNum = ChangeModelCardInterface.getMatchClassLevelQualityCardNum(roleId, needClassType, needLevel, needQuality, true);
/*    */     
/* 41 */     int oldNum = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 42 */     if (oldNum == newNum)
/*    */     {
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     int goalNum = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 48 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalNum, newNum)));
/*    */     
/* 50 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 57 */     return updateState(roleId, xAchievementInfo, sAchievementGoalCfg, null);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\ChangeModelCardClassLevelQualityNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */