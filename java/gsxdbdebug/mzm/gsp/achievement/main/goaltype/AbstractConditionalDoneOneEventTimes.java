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
/*    */ public abstract class AbstractConditionalDoneOneEventTimes
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 18 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*    */   {
/* 26 */     Context context = (Context)ctx;
/* 27 */     int goalConditionType = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 28 */     if ((goalConditionType != 0) && (goalConditionType != context.conditionValue))
/*    */     {
/* 30 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 34 */     List<Integer> xGoalParameterList = xAchievementInfo.getGoal_parameters();
/* 35 */     int goalValue = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 36 */     int oldValue = ((Integer)xGoalParameterList.get(0)).intValue();
/* 37 */     int setValue = Math.min(goalValue, oldValue + context.addCount);
/* 38 */     xGoalParameterList.set(0, Integer.valueOf(setValue));
/*    */     
/* 40 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public static class Context
/*    */   {
/*    */     public final int conditionValue;
/*    */     
/*    */     public final int addCount;
/*    */     
/*    */ 
/*    */     public Context(int conditionValue, int addCount)
/*    */     {
/* 53 */       this.conditionValue = conditionValue;
/* 54 */       this.addCount = addCount;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\AbstractConditionalDoneOneEventTimes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */