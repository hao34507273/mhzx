/*    */ package mzm.gsp.market.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetBackPetEvent extends mzm.event.BasicEvent<GetBackPetArg>
/*    */ {
/*  7 */   private static EventManager<GetBackPetArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetBackPetArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.pet.main.POnMarketGetBackPet());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\event\GetBackPetEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */