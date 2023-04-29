/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractDoneOneEventLevelTimes
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 22 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/* 23 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*    */   {
/* 30 */     Context context = (Context)ctx;
/* 31 */     List<Integer> xGoalParameters = xAchievementInfo.getGoal_parameters();
/*    */     
/* 33 */     int nowMaxLevel = ((Integer)xGoalParameters.get(1)).intValue();
/* 34 */     int goalLevel = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/*    */     
/* 36 */     if (context.nowLevel > nowMaxLevel)
/*    */     {
/* 38 */       xAchievementInfo.getGoal_parameters().set(1, Integer.valueOf(Math.min(context.nowLevel, goalLevel)));
/*    */     }
/* 40 */     Map<Long, String> xGoalParameterExtraMap = xAchievementInfo.getGoal_parameters_extra();
/* 41 */     if (context.nowLevel < goalLevel)
/*    */     {
/*    */ 
/* 44 */       if (null != xGoalParameterExtraMap.remove(Long.valueOf(context.goalEventId)))
/*    */       {
/* 46 */         int oldTimes = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 47 */         xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.max(0, oldTimes - 1)));
/*    */       }
/* 49 */       return true;
/*    */     }
/* 51 */     if (xGoalParameterExtraMap.containsKey(Long.valueOf(context.goalEventId)))
/*    */     {
/* 53 */       return true;
/*    */     }
/* 55 */     xGoalParameterExtraMap.put(Long.valueOf(context.goalEventId), String.valueOf(context.goalEventId));
/*    */     
/*    */ 
/* 58 */     int oldTimes = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 59 */     int goalTimes = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 60 */     int newTimes = oldTimes + 1;
/* 61 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(newTimes, goalTimes)));
/*    */     
/* 63 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public static class Context
/*    */   {
/*    */     public final int nowLevel;
/*    */     
/*    */     public final long goalEventId;
/*    */     
/*    */ 
/*    */     public Context(int nowLevel, long goalEventId)
/*    */     {
/* 76 */       this.nowLevel = nowLevel;
/* 77 */       this.goalEventId = goalEventId;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\AbstractDoneOneEventLevelTimes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */