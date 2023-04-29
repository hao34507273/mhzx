/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.friend.main.FriendInterface;
/*    */ import mzm.gsp.marriage.main.MarriageInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MarryFriendPoint
/*    */   extends AbstractValueChange
/*    */ {
/*    */   public int getType()
/*    */   {
/* 18 */     return 309;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 25 */     long coupleRoleId = MarriageInterface.getMarriedRoleid(roleId, false);
/*    */     int nowValue;
/* 27 */     int nowValue; if (coupleRoleId <= 0L)
/*    */     {
/* 29 */       nowValue = 0;
/*    */     }
/*    */     else
/*    */     {
/* 33 */       nowValue = FriendInterface.getRelationValue(roleId, coupleRoleId, true);
/*    */     }
/*    */     
/*    */ 
/* 37 */     int oldValue = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 38 */     if (oldValue == nowValue)
/*    */     {
/* 40 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 44 */     int goalValue = ((Integer)goalParameters.get(0)).intValue();
/* 45 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalValue, nowValue)));
/*    */     
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\MarryFriendPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */