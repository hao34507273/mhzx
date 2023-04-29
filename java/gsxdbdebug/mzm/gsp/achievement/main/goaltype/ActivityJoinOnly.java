/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ActivityJoinOnly
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 21 */     return 2401;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 27 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 35 */     int activityId = ((Integer)context).intValue();
/* 36 */     if (((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter != activityId)
/*    */     {
/* 38 */       return false;
/*    */     }
/* 40 */     Map<Long, String> xGoalParameterMap = xAchievementInfo.getGoal_parameters_extra();
/* 41 */     String activityJoinTime = String.valueOf(ActivityInterface.getActivityStartTime(activityId));
/* 42 */     String takePartInTime = (String)xGoalParameterMap.get(Long.valueOf(activityId));
/*    */     
/* 44 */     if ((takePartInTime != null) && (takePartInTime.equals(activityJoinTime)))
/*    */     {
/* 46 */       return false;
/*    */     }
/* 48 */     xGoalParameterMap.put(Long.valueOf(activityId), activityJoinTime);
/*    */     
/* 50 */     int oldFinishTimes = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 51 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(oldFinishTimes + 1));
/*    */     
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\ActivityJoinOnly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */