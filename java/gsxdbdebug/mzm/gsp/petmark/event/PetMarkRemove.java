/*    */ package mzm.gsp.petmark.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PetMarkRemove extends mzm.event.BasicEvent<PetMarkRemoveArg>
/*    */ {
/*  7 */   private static EventManager<PetMarkRemoveArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PetMarkRemoveArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\event\PetMarkRemove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */