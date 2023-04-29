/*    */ package mzm.gsp.market.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MarketPetOffShelf extends mzm.event.BasicEvent<MarketPetOffShelfArg>
/*    */ {
/*  7 */   private static EventManager<MarketPetOffShelfArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MarketPetOffShelfArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.market.search.POnPetOffShelf());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\event\MarketPetOffShelf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */