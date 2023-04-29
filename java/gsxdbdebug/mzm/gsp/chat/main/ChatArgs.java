/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import mzm.gsp.confConverter.ConfManager;
/*    */ 
/*    */ public class ChatArgs
/*    */ {
/*    */   int perInterval;
/*    */   int intervalMil;
/*    */   int cacheSize;
/*    */   int mergeMax;
/*    */   int mergeInterval;
/*    */   int contentMaxLength;
/*    */   int factionChatBufferSize;
/*    */   private static ChatArgs instance;
/*    */   
/*    */   static ChatArgs getInstance() {
/* 17 */     return instance;
/*    */   }
/*    */   
/*    */   static void init() {
/* 21 */     instance = (ChatArgs)ConfManager.getInstance().getconf("mzm.gsp.chat.main.ChatArgs");
/* 22 */     if (instance == null) {
/* 23 */       throw new RuntimeException("ChatArgs文件不存在！");
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\ChatArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */