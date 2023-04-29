/*    */ package mzm.gsp.market.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MarketItemOffShelf extends mzm.event.BasicEvent<MarketItemOffShelfArg>
/*    */ {
/*  7 */   private static EventManager<MarketItemOffShelfArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MarketItemOffShelfArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.market.search.POnItemOffShelf());
/* 16 */     manager.register(new mzm.gsp.market.main.POnItemOffShelf());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\event\MarketItemOffShelf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */