/*    */ package mzm.gsp.market.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SellPetEvent extends mzm.event.BasicEvent<SellPetArg>
/*    */ {
/*  7 */   private static EventManager<SellPetArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SellPetArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.pet.main.POnMarketSellPet());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\event\SellPetEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */