/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ReceiveChatContent extends mzm.event.BasicEvent<ReceiveChatContentArg>
/*    */ {
/*  7 */   private static EventManager<ReceiveChatContentArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ReceiveChatContentArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.chat.crossserver.POnReceiveChatContent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\ReceiveChatContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */