/*    */ package mzm.gsp.market.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MarketItemOnShelf extends mzm.event.BasicEvent<MarketItemArg>
/*    */ {
/*  7 */   private static EventManager<MarketItemArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MarketItemArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.market.search.POnItemOnShelf());
/* 16 */     manager.register(new mzm.gsp.market.main.POnItemOnShelf());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\event\MarketItemOnShelf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */