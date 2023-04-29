/*    */ package mzm.gsp.chatgift.main;
/*    */ 
/*    */ import mzm.gsp.chat.confbean.ChatGiftConsts;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class ChatGift_GfgManager
/*    */ {
/* 15 */   private static ChatGift_GfgManager instance = new ChatGift_GfgManager();
/*    */   
/*    */   public static ChatGift_GfgManager getInstance() {
/* 18 */     return instance;
/*    */   }
/*    */   
/*    */   static int getRoleMaxChatGiftNum() {
/* 22 */     return ChatGiftConsts.getInstance().dayLimitNum;
/*    */   }
/*    */   
/*    */   static long getChatGiftOutTime() {
/* 26 */     return ChatGiftConsts.getInstance().autoBackTime * 60 * 60 * 1000;
/*    */   }
/*    */   
/*    */   static int getChatGiftMaxChatGiftNumWithType(int chatType) {
/* 30 */     switch (chatType) {
/*    */     case -1: 
/* 32 */       return ChatGiftConsts.getInstance().dayLimitNum;
/*    */     case 2: 
/* 34 */       return ChatGiftConsts.getInstance().chatGiftSaveNum;
/*    */     case 10: 
/* 36 */       return ChatGiftConsts.getInstance().chatGiftSaveNum;
/*    */     }
/* 38 */     return ChatGiftConsts.getInstance().chatGiftSaveNum;
/*    */   }
/*    */   
/*    */   static long getChatGiftOutTimeWithType(int chatType)
/*    */   {
/* 43 */     switch (chatType) {
/*    */     case -1: 
/* 45 */       return getChatGiftOutTime();
/*    */     case 2: 
/* 47 */       return ChatGiftConsts.getInstance().chatGiftSaveTime * 60 * 60 * 1000;
/*    */     case 10: 
/* 49 */       return getChatGiftOutTime();
/*    */     }
/* 51 */     return ChatGiftConsts.getInstance().chatGiftSaveTime * 60 * 60 * 1000;
/*    */   }
/*    */   
/*    */   static int getChatGiftDayGetNumWithType(int chatType)
/*    */   {
/* 56 */     switch (chatType) {
/*    */     case -1: 
/* 58 */       return 0;
/*    */     case 2: 
/* 60 */       return ChatGiftConsts.getInstance().gangDayGetNumLimt;
/*    */     case 10: 
/* 62 */       return ChatGiftConsts.getInstance().groupDayGetNumLimt;
/*    */     }
/* 64 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\main\ChatGift_GfgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */