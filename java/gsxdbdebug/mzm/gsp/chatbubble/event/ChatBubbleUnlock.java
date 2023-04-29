/*    */ package mzm.gsp.chatbubble.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChatBubbleUnlock extends mzm.event.BasicEvent<ChatBubbleUnlockArg>
/*    */ {
/*  7 */   private static EventManager<ChatBubbleUnlockArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChatBubbleUnlockArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnChatBubbleUnlock());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatbubble\event\ChatBubbleUnlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */