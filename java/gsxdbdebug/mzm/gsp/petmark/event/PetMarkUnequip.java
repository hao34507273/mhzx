/*    */ package mzm.gsp.petmark.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PetMarkUnequip extends mzm.event.BasicEvent<PetMarkUnequipArg>
/*    */ {
/*  7 */   private static EventManager<PetMarkUnequipArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PetMarkUnequipArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.pet.main.POnPetMarkUnequip());
/* 16 */     manager.register(new mzm.gsp.map.main.POnPetMarkUnequip());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\event\PetMarkUnequip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */