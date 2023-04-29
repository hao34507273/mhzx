/*    */ package mzm.gsp.homeland.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class CleanlinessChangeEvent extends mzm.event.BasicEvent<CleanlinessArg>
/*    */ {
/*  7 */   private static EventManager<CleanlinessArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<CleanlinessArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\event\CleanlinessChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */