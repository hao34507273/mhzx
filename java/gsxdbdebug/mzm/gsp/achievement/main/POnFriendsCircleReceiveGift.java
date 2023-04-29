/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.friendscircle.event.FriendsCircleReceiveGiftArg;
/*    */ import mzm.gsp.friendscircle.event.FriendsCircleReceiveGiftProcedure;
/*    */ 
/*    */ public class POnFriendsCircleReceiveGift
/*    */   extends FriendsCircleReceiveGiftProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((FriendsCircleReceiveGiftArg)this.arg).roleId, 316, Integer.valueOf(((FriendsCircleReceiveGiftArg)this.arg).giftNum), "POnFriendsCircleReceiveGift.processImp@handle FRIENDS_CIRCLE_RECEIVE_GIFT finish");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnFriendsCircleReceiveGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */