/*    */ package mzm.gsp.friend.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FriendAddEvent extends mzm.event.BasicEvent<FriendAddArg>
/*    */ {
/*  7 */   private static EventManager<FriendAddArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FriendAddArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.LevelGuide.POnFriendAddEvent());
/* 16 */     manager.register(new mzm.gsp.friendscircle.main.POnFriendAdd());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\event\FriendAddEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */