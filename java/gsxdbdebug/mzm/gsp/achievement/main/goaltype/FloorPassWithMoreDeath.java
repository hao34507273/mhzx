/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ public class FloorPassWithMoreDeath extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 13 */     return 5116;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 19 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*    */   {
/* 26 */     Context context = (Context)ctx;
/*    */     
/* 28 */     int goalActivityId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 29 */     int goalFloor = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 30 */     if (((goalActivityId != 0) && (context.activityId != goalActivityId)) || ((goalFloor != 0) && (context.floor != goalFloor)))
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 36 */     int goalDieCount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(2)).parameter;
/* 37 */     if (context.playerDieCount < goalDieCount)
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 43 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 44 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(oldCount + 1));
/*    */     
/* 46 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public static class Context
/*    */   {
/*    */     public final int activityId;
/*    */     
/*    */     public final int floor;
/*    */     
/*    */     public final int playerDieCount;
/*    */     
/*    */     public Context(int activityId, int floor, int playerDieCount)
/*    */     {
/* 60 */       this.activityId = activityId;
/* 61 */       this.floor = floor;
/* 62 */       this.playerDieCount = playerDieCount;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\FloorPassWithMoreDeath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */