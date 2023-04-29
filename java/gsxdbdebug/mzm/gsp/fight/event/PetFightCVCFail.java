/*    */ package mzm.gsp.fight.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PetFightCVCFail extends mzm.event.BasicEvent<PetFightCVCFailArg>
/*    */ {
/*  7 */   private static EventManager<PetFightCVCFailArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PetFightCVCFailArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.petarena.main.POnPetFightCVCFail());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PetFightCVCFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */