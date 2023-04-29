/*    */ package mzm.gsp.friend.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FriendPointChange extends mzm.event.BasicEvent<FriendPointChangeArg>
/*    */ {
/*  7 */   private static EventManager<FriendPointChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FriendPointChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.marriage.main.POnFriendPointChange());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnFriendPointChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\event\FriendPointChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */