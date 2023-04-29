/*    */ package mzm.gsp.homeland.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class CreateHomeWorldEvent extends mzm.event.BasicEvent<CreateHomeWorldArg>
/*    */ {
/*  7 */   private static EventManager<CreateHomeWorldArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<CreateHomeWorldArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.banquest.main.CreateHomeWorldEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\event\CreateHomeWorldEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */