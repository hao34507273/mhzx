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
/*    */ public abstract class AbstractAccumulate
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*    */   {
/* 17 */     Context context = (Context)ctx;
/* 18 */     if ((context.diffValue <= 0) || (context.initValue < 0))
/*    */     {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     List<Integer> goalParams = xAchievementInfo.getGoal_parameters();
/*    */     
/* 25 */     if (((Integer)goalParams.get(0)).intValue() == 0)
/*    */     {
/* 27 */       xAchievementInfo.getGoal_parameters_extra().put(Long.valueOf(0L), String.valueOf(context.initValue));
/*    */     }
/* 29 */     int goalValue = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 30 */     int accumulateValue = ((Integer)goalParams.get(0)).intValue() + context.diffValue;
/* 31 */     goalParams.set(0, Integer.valueOf(accumulateValue > goalValue ? goalValue : accumulateValue));
/*    */     
/* 33 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public static class Context
/*    */   {
/*    */     public final int initValue;
/*    */     
/*    */     public final int diffValue;
/*    */     
/*    */ 
/*    */     public Context(int initValue, int diffValue)
/*    */     {
/* 46 */       this.initValue = initValue;
/* 47 */       this.diffValue = diffValue;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\AbstractAccumulate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */