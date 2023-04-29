/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ public class FloorPassWithLessMonsterRelive extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 12 */     return 5118;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 18 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*    */   {
/* 25 */     Context context = (Context)ctx;
/*    */     
/* 27 */     int goalActivityId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 28 */     int goalFloor = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 29 */     if (((goalActivityId != 0) && (context.activityId != goalActivityId)) || ((goalFloor != 0) && (context.floor != goalFloor)))
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 35 */     int goalReliveCount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(2)).parameter;
/* 36 */     if (context.monsterReliveCount > goalReliveCount)
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 42 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 43 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(oldCount + 1));
/*    */     
/* 45 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public static class Context
/*    */   {
/*    */     public final int activityId;
/*    */     
/*    */     public final int floor;
/*    */     
/*    */     public final int monsterReliveCount;
/*    */     
/*    */     public Context(int activityId, int floor, int monsterReliveCount)
/*    */     {
/* 59 */       this.activityId = activityId;
/* 60 */       this.floor = floor;
/* 61 */       this.monsterReliveCount = monsterReliveCount;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\FloorPassWithLessMonsterRelive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */