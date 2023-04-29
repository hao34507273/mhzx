/*    */ package mzm.gsp.market.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MarketPetOnShelf extends mzm.event.BasicEvent<MarketPetArg>
/*    */ {
/*  7 */   private static EventManager<MarketPetArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MarketPetArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.market.search.POnPetOnShelf());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\event\MarketPetOnShelf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */