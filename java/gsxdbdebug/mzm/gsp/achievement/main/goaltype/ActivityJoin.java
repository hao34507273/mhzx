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
/*    */ public class ActivityJoin
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 18 */     return 2400;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 24 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 31 */     int activityId = ((Integer)context).intValue();
/*    */     
/* 33 */     if (((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter != activityId)
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     int oldFinishTimes = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 39 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(oldFinishTimes + 1));
/*    */     
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\ActivityJoin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */