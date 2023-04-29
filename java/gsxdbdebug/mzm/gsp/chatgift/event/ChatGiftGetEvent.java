/*    */ package mzm.gsp.chatgift.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChatGiftGetEvent extends mzm.event.BasicEvent<ChatGiftGetArg>
/*    */ {
/*  7 */   private static EventManager<ChatGiftGetArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChatGiftGetArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.chatgift.main.POnChatGiftGetEvent());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnChatGiftGet());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\event\ChatGiftGetEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */