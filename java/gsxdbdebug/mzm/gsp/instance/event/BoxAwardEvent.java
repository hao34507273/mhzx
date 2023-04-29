/*    */ package mzm.gsp.instance.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class BoxAwardEvent extends mzm.event.BasicEvent<BoxAwardArg>
/*    */ {
/*  7 */   private static EventManager<BoxAwardArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<BoxAwardArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.instance.main.POnBoxAwardEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\event\BoxAwardEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */