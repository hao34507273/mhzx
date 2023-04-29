/*    */ package mzm.gsp.sensitive.main;
/*    */ 
/*    */ import java.io.File;
/*    */ import mzm.gsp.GameServer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class SensitiveManager
/*    */ {
/*    */   private static final String ENCODING = "UTF-16LE";
/* 16 */   private SensitiveWordsChecker nameChecker = new SensitiveWordsChecker();
/* 17 */   private SensitiveWordsChecker contentChecker = new SensitiveWordsChecker();
/*    */   
/* 19 */   private static final SensitiveManager instance = new SensitiveManager();
/*    */   
/*    */   static SensitiveManager getInstance() {
/* 22 */     return instance;
/*    */   }
/*    */   
/*    */   void init() {
/* 26 */     this.nameChecker.load(GameServer.getGamedataDir() + File.separator + SensitiveArgs.getInstance().SensitiveNameFile, "UTF-16LE");
/* 27 */     this.contentChecker.load(GameServer.getGamedataDir() + File.separator + SensitiveArgs.getInstance().SensitiveContentFile, "UTF-16LE");
/*    */   }
/*    */   
/*    */   boolean isNameSensitive(String name) {
/* 31 */     if (this.contentChecker.containsSensitiveWord(name)) {
/* 32 */       return true;
/*    */     }
/* 34 */     if (this.nameChecker.containsSensitiveWord(name)) {
/* 35 */       return true;
/*    */     }
/* 37 */     return false;
/*    */   }
/*    */   
/*    */   boolean isContentSensitive(String content)
/*    */   {
/* 42 */     return this.contentChecker.containsSensitiveWord(content);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sensitive\main\SensitiveManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */