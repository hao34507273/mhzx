/*    */ package mzm.gsp.petmark.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PetMarkEquip extends mzm.event.BasicEvent<PetMarkEquipArg>
/*    */ {
/*  7 */   private static EventManager<PetMarkEquipArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PetMarkEquipArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.pet.main.POnPetMarkEquip());
/* 16 */     manager.register(new mzm.gsp.map.main.POnPetMarkEquip());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\event\PetMarkEquip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */