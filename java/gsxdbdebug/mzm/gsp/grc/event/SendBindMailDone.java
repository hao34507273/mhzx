/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SendBindMailDone extends mzm.event.BasicEvent<SendBindMailDoneArg>
/*    */ {
/*  7 */   private static EventManager<SendBindMailDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SendBindMailDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grc.main.POnSendBindMailDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\SendBindMailDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */