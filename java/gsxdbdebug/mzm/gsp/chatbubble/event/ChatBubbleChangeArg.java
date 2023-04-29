/*    */ package mzm.gsp.chatbubble.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChatBubbleChangeArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */ 
/*    */   public final int oldChatBubbleCfgId;
/*    */   
/*    */ 
/*    */   public final int newChatBubbleCfgId;
/*    */   
/*    */ 
/*    */ 
/*    */   public ChatBubbleChangeArg(long roleId, int oldChatBubbleCfgId, int newChatBubbleCfgId)
/*    */   {
/* 19 */     this.roleId = roleId;
/* 20 */     this.oldChatBubbleCfgId = oldChatBubbleCfgId;
/* 21 */     this.newChatBubbleCfgId = newChatBubbleCfgId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatbubble\event\ChatBubbleChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */