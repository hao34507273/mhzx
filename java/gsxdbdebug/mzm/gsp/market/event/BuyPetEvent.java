/*    */ package mzm.gsp.market.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class BuyPetEvent extends mzm.event.BasicEvent<BuyPetArg>
/*    */ {
/*  7 */   private static EventManager<BuyPetArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<BuyPetArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.pet.main.POnMarketBuyPet());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\event\BuyPetEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */