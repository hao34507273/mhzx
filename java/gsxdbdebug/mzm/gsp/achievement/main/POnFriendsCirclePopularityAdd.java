/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.friendscircle.event.FriendsCirclePopularityAddArg;
/*    */ import mzm.gsp.friendscircle.event.FriendsCirclePopularityAddProcedure;
/*    */ 
/*    */ public class POnFriendsCirclePopularityAdd
/*    */   extends FriendsCirclePopularityAddProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((FriendsCirclePopularityAddArg)this.arg).roleId, 315, Integer.valueOf(((FriendsCirclePopularityAddArg)this.arg).nowTotalPopularity), "POnFriendsCirclePopularityAdd.processImp@handle FRIENDS_CIRCLE_POPULARITY_VALUE finish");
/*    */     
/*    */ 
/*    */ 
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnFriendsCirclePopularityAdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */