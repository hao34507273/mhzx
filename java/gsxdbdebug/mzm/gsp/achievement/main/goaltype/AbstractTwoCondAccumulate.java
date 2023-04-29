/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractTwoCondAccumulate
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 19 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*    */   {
/* 27 */     Context context = (Context)ctx;
/* 28 */     int goalCond1 = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 29 */     int goalCond2 = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/*    */     
/* 31 */     if (((goalCond1 != 0) && (goalCond1 != context.condition1)) || ((goalCond2 != 0) && (goalCond2 != context.condition2)))
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 37 */     int oldValue = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 38 */     int goalValue = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(2)).parameter;
/* 39 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalValue, oldValue + context.value)));
/*    */     
/* 41 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public static class Context
/*    */   {
/*    */     public final int condition1;
/*    */     
/*    */     public final int condition2;
/*    */     
/*    */     public final int value;
/*    */     
/*    */     public Context(int cond1, int cond2, int value)
/*    */     {
/* 55 */       this.condition1 = cond1;
/* 56 */       this.condition2 = cond2;
/* 57 */       this.value = value;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\AbstractTwoCondAccumulate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */