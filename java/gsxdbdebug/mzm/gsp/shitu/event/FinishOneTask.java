/*    */ package mzm.gsp.shitu.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FinishOneTask extends mzm.event.BasicEvent<FinishOneTaskArg>
/*    */ {
/*  7 */   private static EventManager<FinishOneTaskArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FinishOneTaskArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\event\FinishOneTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */