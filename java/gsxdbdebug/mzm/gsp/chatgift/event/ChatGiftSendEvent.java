/*    */ package mzm.gsp.chatgift.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChatGiftSendEvent extends mzm.event.BasicEvent<ChatGiftSendArg>
/*    */ {
/*  7 */   private static EventManager<ChatGiftSendArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChatGiftSendArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.chatgift.main.POnChatGiftSendEvent());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnChatGiftSend());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\event\ChatGiftSendEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */