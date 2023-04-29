/*    */ package mzm.gsp.chatgift.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChannelChatGiftOutCfgEvent extends mzm.event.BasicEvent<ChatGiftOutCfgArg>
/*    */ {
/*  7 */   private static EventManager<ChatGiftOutCfgArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChatGiftOutCfgArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.chatgift.main.POnChannelChatGiftOutCfgEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\event\ChannelChatGiftOutCfgEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */