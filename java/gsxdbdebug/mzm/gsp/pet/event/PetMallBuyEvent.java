/*    */ package mzm.gsp.pet.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PetMallBuyEvent extends mzm.event.BasicEvent<PetMallBuyEventArg>
/*    */ {
/*  7 */   private static EventManager<PetMallBuyEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PetMallBuyEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnPetMallBuy());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\event\PetMallBuyEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */