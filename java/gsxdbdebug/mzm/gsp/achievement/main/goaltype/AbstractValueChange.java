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
/*    */ public abstract class AbstractValueChange
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 18 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 25 */     List<Integer> xGoalParameterList = xAchievementInfo.getGoal_parameters();
/* 26 */     GoalParameter goalParameter = (GoalParameter)sAchievementGoalCfg.goalParameters.get(0);
/* 27 */     int goalValue = goalParameter.parameter;
/* 28 */     int newValue = ((Integer)context).intValue();
/* 29 */     int setValue = Math.min(newValue, goalValue);
/* 30 */     xGoalParameterList.set(0, Integer.valueOf(setValue));
/*    */     
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\AbstractValueChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */