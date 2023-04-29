/*    */ package mzm.gsp.petmark.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PetMarkAdd extends mzm.event.BasicEvent<PetMarkAddArg>
/*    */ {
/*  7 */   private static EventManager<PetMarkAddArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PetMarkAddArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\event\PetMarkAdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */