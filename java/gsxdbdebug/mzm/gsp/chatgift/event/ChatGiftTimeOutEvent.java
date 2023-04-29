/*    */ package mzm.gsp.chatgift.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChatGiftTimeOutEvent extends mzm.event.BasicEvent<ChatGiftTimeOutArg>
/*    */ {
/*  7 */   private static EventManager<ChatGiftTimeOutArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChatGiftTimeOutArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.chatgift.main.ROnChatGiftTimeOutEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\event\ChatGiftTimeOutEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */