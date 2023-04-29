/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.friendscircle.event.FriendsCircleSendGiftArg;
/*    */ import mzm.gsp.friendscircle.event.FriendsCircleSendGiftProcedure;
/*    */ 
/*    */ public class POnFriendsCircleSendGift
/*    */   extends FriendsCircleSendGiftProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((FriendsCircleSendGiftArg)this.arg).roleId, 317, Integer.valueOf(((FriendsCircleSendGiftArg)this.arg).giftItemNum), "POnFriendsCircleSendGift.processImp@handle FRIENDS_CIRCLE_SEND_GIFT finish");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnFriendsCircleSendGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */