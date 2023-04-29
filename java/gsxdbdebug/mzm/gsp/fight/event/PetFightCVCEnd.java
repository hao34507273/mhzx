/*    */ package mzm.gsp.fight.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PetFightCVCEnd extends mzm.event.BasicEvent<PetFightCVCEndArg>
/*    */ {
/*  7 */   private static EventManager<PetFightCVCEndArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PetFightCVCEndArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.petarena.main.POnPetFightCVCEnd());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PetFightCVCEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */