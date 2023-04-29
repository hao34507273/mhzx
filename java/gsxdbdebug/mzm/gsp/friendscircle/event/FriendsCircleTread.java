/*    */ package mzm.gsp.friendscircle.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FriendsCircleTread extends mzm.event.BasicEvent<FriendsCircleTreadArg>
/*    */ {
/*  7 */   private static EventManager<FriendsCircleTreadArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FriendsCircleTreadArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnFriendsCircleTread());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\event\FriendsCircleTread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */