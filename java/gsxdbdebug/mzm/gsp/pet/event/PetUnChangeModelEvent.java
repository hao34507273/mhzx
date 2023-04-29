/*    */ package mzm.gsp.pet.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PetUnChangeModelEvent extends mzm.event.BasicEvent<PetUnChangeModelEventArg>
/*    */ {
/*  7 */   private static EventManager<PetUnChangeModelEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PetUnChangeModelEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnPetUnChangeModel());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\event\PetUnChangeModelEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */