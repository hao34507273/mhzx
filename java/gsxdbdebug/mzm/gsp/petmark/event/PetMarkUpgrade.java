/*    */ package mzm.gsp.petmark.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PetMarkUpgrade extends mzm.event.BasicEvent<PetMarkUpgradeArg>
/*    */ {
/*  7 */   private static EventManager<PetMarkUpgradeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PetMarkUpgradeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.pet.main.POnPetMarkUpgrade());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\event\PetMarkUpgrade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */