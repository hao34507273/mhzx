/*    */ package mzm.gsp.auction.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AuctionBidWinEvent extends mzm.event.BasicEvent<AuctionBidWinEventArg>
/*    */ {
/*  7 */   private static EventManager<AuctionBidWinEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<AuctionBidWinEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnAuctionBidWinEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\event\AuctionBidWinEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */