/*    */ package mzm.gsp.pet.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PetFightDefenseTeamChanged extends mzm.event.BasicEvent<PetFightDefenseTeamChangedArg>
/*    */ {
/*  7 */   private static EventManager<PetFightDefenseTeamChangedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PetFightDefenseTeamChangedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.petarena.main.POnPetFightDefenseTeamChanged());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\event\PetFightDefenseTeamChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */