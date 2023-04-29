/*    */ package mzm.gsp.friendscircle.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FriendsCirclePopularityAdd extends mzm.event.BasicEvent<FriendsCirclePopularityAddArg>
/*    */ {
/*  7 */   private static EventManager<FriendsCirclePopularityAddArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FriendsCirclePopularityAddArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnFriendsCirclePopularityAdd());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\event\FriendsCirclePopularityAdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */