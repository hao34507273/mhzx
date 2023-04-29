/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.equipmentbless.main.EquipmentBlessInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EquipmentBlessLevelCount
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 22 */     return 3017;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 28 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/* 29 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 36 */     return updateState(roleId, xAchievementInfo, sAchievementGoalCfg, null);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 43 */     int targetLevel = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/*    */     
/*    */ 
/* 46 */     int newCount = EquipmentBlessInterface.getRoleBlessedEquipmentNumberWithGivenLevel(roleId, targetLevel);
/* 47 */     int newMaxLevel; int newMaxLevel; if (newCount == 0)
/*    */     {
/* 49 */       int maxLevel = EquipmentBlessInterface.getRoleHighestBlessLevel(roleId);
/* 50 */       newMaxLevel = maxLevel;
/*    */     }
/*    */     else
/*    */     {
/* 54 */       newMaxLevel = targetLevel;
/*    */     }
/*    */     
/* 57 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 58 */     int oldLevel = ((Integer)xAchievementInfo.getGoal_parameters().get(1)).intValue();
/* 59 */     if ((oldCount == newCount) && (oldLevel == newMaxLevel))
/*    */     {
/* 61 */       return false;
/*    */     }
/*    */     
/* 64 */     int targetCount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 65 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(newCount, targetCount)));
/* 66 */     xAchievementInfo.getGoal_parameters().set(1, Integer.valueOf(Math.min(newMaxLevel, targetLevel)));
/*    */     
/* 68 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\EquipmentBlessLevelCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */