/*    */ package mzm.gsp.chatgift.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChatGiftSettle extends mzm.event.BasicEvent<ChatGiftSettleArg>
/*    */ {
/*  7 */   private static EventManager<ChatGiftSettleArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChatGiftSettleArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnChatGiftSettle());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\event\ChatGiftSettle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */