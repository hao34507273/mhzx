/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.friendscircle.event.FriendsCircleTreadArg;
/*    */ import mzm.gsp.friendscircle.event.FriendsCircleTreadProcedure;
/*    */ 
/*    */ public class POnFriendsCircleTread extends FriendsCircleTreadProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 10 */     if (((FriendsCircleTreadArg)this.arg).isTriggerTreasureBox)
/*    */     {
/*    */ 
/* 13 */       AchievementManager.updateGoalTypeState(((FriendsCircleTreadArg)this.arg).treadRoleId, 318, Integer.valueOf(1), "POnFriendsCircleTread.processImp@handle FRIENDS_CIRCLE_TREAD_GET_BOX finish");
/*    */       
/*    */ 
/* 16 */       AchievementManager.updateGoalTypeState(((FriendsCircleTreadArg)this.arg).treadRoleId, 319, Integer.valueOf(1), "POnFriendsCircleTread.processImp@handle FRIENDS_CIRCLE_TREAD_COMBO_GET_BOX finish");
/*    */       
/*    */ 
/* 19 */       AchievementManager.updateGoalTypeState(((FriendsCircleTreadArg)this.arg).treadRoleId, 320, Integer.valueOf(0), "POnFriendsCircleTread.processImp@handle FRIENDS_CIRCLE_TREAD_COMBO_NO_BOX finish");
/*    */ 
/*    */ 
/*    */     }
/* 23 */     else if (((FriendsCircleTreadArg)this.arg).beTrodRoleIsOwnTreasureBox)
/*    */     {
/*    */ 
/* 26 */       AchievementManager.updateGoalTypeState(((FriendsCircleTreadArg)this.arg).treadRoleId, 319, Integer.valueOf(0), "POnFriendsCircleTread.processImp@handle FRIENDS_CIRCLE_TREAD_COMBO_GET_BOX finish");
/*    */       
/* 28 */       if (((FriendsCircleTreadArg)this.arg).isCanGetMoreTreasureBox)
/*    */       {
/*    */ 
/* 31 */         AchievementManager.updateGoalTypeState(((FriendsCircleTreadArg)this.arg).treadRoleId, 320, Integer.valueOf(1), "POnFriendsCircleTread.processImp@handle FRIENDS_CIRCLE_TREAD_COMBO_NO_BOX finish");
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnFriendsCircleTread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */