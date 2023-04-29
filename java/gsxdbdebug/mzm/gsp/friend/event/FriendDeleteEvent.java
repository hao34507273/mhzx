/*    */ package mzm.gsp.friend.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FriendDeleteEvent extends mzm.event.BasicEvent<FriendDeleteArg>
/*    */ {
/*  7 */   private static EventManager<FriendDeleteArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FriendDeleteArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.friendscircle.main.POnFriendDelete());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\event\FriendDeleteEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */