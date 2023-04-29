/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.floor.main.FloorInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FloorPass
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 23 */     return 5109;
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
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*    */   {
/* 36 */     Context context = (Context)ctx;
/* 37 */     int goalActicityId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 38 */     if (context.activityId != goalActicityId)
/*    */     {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     int goalFloor = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 44 */     if (goalFloor != context.floor)
/*    */     {
/* 46 */       return false;
/*    */     }
/*    */     
/* 49 */     int goalCount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(2)).parameter;
/* 50 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 51 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalCount, oldCount + 1)));
/*    */     
/* 53 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 61 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 62 */     if (oldCount >= 1)
/*    */     {
/* 64 */       return false;
/*    */     }
/* 66 */     int goalActicityId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 67 */     int goalFloor = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 68 */     Collection<Integer> passedFloors = FloorInterface.getRolePassFloors(roleId, goalActicityId, true);
/* 69 */     if (!passedFloors.contains(Integer.valueOf(goalFloor)))
/*    */     {
/* 71 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 75 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(1));
/*    */     
/* 77 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public static class Context
/*    */   {
/*    */     public final int activityId;
/*    */     
/*    */     public final int floor;
/*    */     
/*    */ 
/*    */     public Context(int activityId, int floor)
/*    */     {
/* 90 */       this.activityId = activityId;
/* 91 */       this.floor = floor;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\FloorPass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */