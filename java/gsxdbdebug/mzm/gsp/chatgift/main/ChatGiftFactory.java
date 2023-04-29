/*    */ package mzm.gsp.chatgift.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChatGiftFactory
/*    */ {
/*    */   static BaseChatGift getChatGift(int chatType)
/*    */   {
/* 20 */     switch (chatType)
/*    */     {
/*    */     case -1: 
/* 23 */       return new RoleChatGift(chatType);
/*    */     case 2: 
/* 25 */       return new GangChatGift(chatType);
/*    */     case 10: 
/* 27 */       return new GroupChatGift(chatType);
/*    */     }
/* 29 */     ChatGiftManager.logDebug("ChatGiftFactory.createGangBuilding@chatType not match|chatType=%d", new Object[] { Integer.valueOf(chatType) });
/* 30 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\main\ChatGiftFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */