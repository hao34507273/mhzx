/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.achievement.main.AchievementInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AchievementFinish
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 22 */     return 3307;
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
/* 35 */     int goalCfgId = ((Integer)context).intValue();
/* 36 */     boolean isGoalAchievement = false;
/*    */     
/*    */ 
/* 39 */     for (int i = 1; i < sAchievementGoalCfg.goalParameters.size(); i++)
/*    */     {
/* 41 */       int goalGoalCfgId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(i)).parameter;
/* 42 */       if (goalGoalCfgId == 0) {
/*    */         break;
/*    */       }
/*    */       
/* 46 */       if (goalCfgId == goalGoalCfgId)
/*    */       {
/* 48 */         isGoalAchievement = true;
/* 49 */         break;
/*    */       }
/*    */     }
/* 52 */     if (!isGoalAchievement)
/*    */     {
/* 54 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 58 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 59 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(oldCount + 1));
/*    */     
/* 61 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 69 */     int nowCount = 0;
/* 70 */     for (int i = 1; i < sAchievementGoalCfg.goalParameters.size(); i++)
/*    */     {
/* 72 */       int goalCfgId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(i)).parameter;
/* 73 */       if (goalCfgId == 0) {
/*    */         break;
/*    */       }
/*    */       
/* 77 */       int activityCfgId = SAchievementGoalCfg.get(goalCfgId).activityCfgId;
/* 78 */       int state = AchievementInterface.getAchievementGoalState(roleId, activityCfgId, goalCfgId, true);
/* 79 */       if ((state == 2) || (state == 3))
/*    */       {
/* 81 */         nowCount++;
/*    */       }
/*    */     }
/*    */     
/* 85 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 86 */     if (oldCount == nowCount)
/*    */     {
/* 88 */       return false;
/*    */     }
/*    */     
/* 91 */     int goalCount = ((Integer)goalParameters.get(0)).intValue();
/* 92 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalCount, nowCount)));
/*    */     
/* 94 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\AchievementFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */