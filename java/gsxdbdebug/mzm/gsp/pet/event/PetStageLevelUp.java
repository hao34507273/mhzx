/*    */ package mzm.gsp.pet.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PetStageLevelUp extends mzm.event.BasicEvent<PetStageLevelUpEventArg>
/*    */ {
/*  7 */   private static EventManager<PetStageLevelUpEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PetStageLevelUpEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnPetStageLevelUp());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\event\PetStageLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */