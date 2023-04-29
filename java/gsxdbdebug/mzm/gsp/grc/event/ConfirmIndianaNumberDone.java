/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ConfirmIndianaNumberDone extends mzm.event.BasicEvent<ConfirmIndianaNumberDoneArg>
/*    */ {
/*  7 */   private static EventManager<ConfirmIndianaNumberDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ConfirmIndianaNumberDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.indiana.main.POnConfirmIndianaNumberDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\ConfirmIndianaNumberDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */