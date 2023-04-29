/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.friendscircle.main.FriendsCircleInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ public class FriendsCirclePopularityValue extends AbstractValueChange
/*    */ {
/*    */   public int getType()
/*    */   {
/* 14 */     return 315;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 21 */     int newValue = FriendsCircleInterface.getRoleTotalPopularity(roleId, true);
/* 22 */     int oldValue = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 23 */     if (newValue == oldValue)
/*    */     {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     int goalValue = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 29 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalValue, oldValue)));
/*    */     
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\FriendsCirclePopularityValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */