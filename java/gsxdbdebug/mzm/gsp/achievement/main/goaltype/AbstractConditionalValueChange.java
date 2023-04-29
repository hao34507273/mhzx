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
/*    */ public abstract class AbstractConditionalValueChange
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 17 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*    */   {
/* 25 */     Context context = (Context)ctx;
/* 26 */     int goalConditionType = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 27 */     if ((goalConditionType != 0) && (goalConditionType != context.conditionValue))
/*    */     {
/* 29 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 33 */     List<Integer> xGoalParameterList = xAchievementInfo.getGoal_parameters();
/* 34 */     int goalValue = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 35 */     int setValue = Math.min(goalValue, context.newValue);
/* 36 */     xGoalParameterList.set(0, Integer.valueOf(setValue));
/*    */     
/* 38 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public static class Context
/*    */   {
/*    */     public final int conditionValue;
/*    */     
/*    */     public final int newValue;
/*    */     
/*    */ 
/*    */     public Context(int conditionValue, int newValue)
/*    */     {
/* 51 */       this.conditionValue = conditionValue;
/* 52 */       this.newValue = newValue;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\AbstractConditionalValueChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */