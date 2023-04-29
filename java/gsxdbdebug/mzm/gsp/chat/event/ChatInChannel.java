/*    */ package mzm.gsp.chat.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChatInChannel extends mzm.event.BasicEvent<ChatInChannelArg>
/*    */ {
/*  7 */   private static EventManager<ChatInChannelArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChatInChannelArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.main.POnChatInChannel());
/* 16 */     manager.register(new mzm.gsp.grow.LevelGuide.POnChatInChannel());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\event\ChatInChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */