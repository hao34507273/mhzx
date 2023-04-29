/*    */ package mzm.gsp.friendscircle.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FriendsCircleReceiveGift extends mzm.event.BasicEvent<FriendsCircleReceiveGiftArg>
/*    */ {
/*  7 */   private static EventManager<FriendsCircleReceiveGiftArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FriendsCircleReceiveGiftArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnFriendsCircleReceiveGift());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\event\FriendsCircleReceiveGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */