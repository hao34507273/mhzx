/*    */ package mzm.gsp.pet.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PetCatchEvent extends mzm.event.BasicEvent<PetCatchEventArg>
/*    */ {
/*  7 */   private static EventManager<PetCatchEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PetCatchEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnPetCatch());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\event\PetCatchEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */