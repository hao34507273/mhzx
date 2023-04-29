/*    */ package mzm.gsp.friendscircle.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FriendsCircleSendGift extends mzm.event.BasicEvent<FriendsCircleSendGiftArg>
/*    */ {
/*  7 */   private static EventManager<FriendsCircleSendGiftArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FriendsCircleSendGiftArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnFriendsCircleSendGift());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\event\FriendsCircleSendGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */