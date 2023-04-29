/*    */ package mzm.gsp.pet.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PetMoveToDepot extends mzm.event.BasicEvent<PetEventArg>
/*    */ {
/*  7 */   private static EventManager<PetEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PetEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.mounts.main.POnPetMoveToDepot());
/* 16 */     manager.register(new mzm.gsp.pet.main.POnPetMoveToDepot());
/* 17 */     manager.register(new mzm.gsp.petmark.main.POnPetMoveToDepot());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\event\PetMoveToDepot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */