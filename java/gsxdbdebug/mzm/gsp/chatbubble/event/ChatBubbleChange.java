/*    */ package mzm.gsp.chatbubble.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChatBubbleChange extends mzm.event.BasicEvent<ChatBubbleChangeArg>
/*    */ {
/*  7 */   private static EventManager<ChatBubbleChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChatBubbleChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatbubble\event\ChatBubbleChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */