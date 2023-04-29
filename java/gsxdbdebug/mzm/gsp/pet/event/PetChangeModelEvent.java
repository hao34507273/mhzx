/*    */ package mzm.gsp.pet.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PetChangeModelEvent extends mzm.event.BasicEvent<PetChangeModelEventArg>
/*    */ {
/*  7 */   private static EventManager<PetChangeModelEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PetChangeModelEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnPetChangeModel());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\event\PetChangeModelEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */