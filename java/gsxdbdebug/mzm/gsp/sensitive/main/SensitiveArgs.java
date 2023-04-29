/*    */ package mzm.gsp.sensitive.main;
/*    */ 
/*    */ import mzm.gsp.confConverter.ConfManager;
/*    */ 
/*  5 */ class SensitiveArgs { private static SensitiveArgs manager = new SensitiveArgs();
/*    */   String SensitiveNameFile;
/*    */   String SensitiveContentFile;
/*    */   
/*  9 */   public static SensitiveArgs getInstance() { return manager; }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void init()
/*    */   {
/* 20 */     manager = (SensitiveArgs)ConfManager.getInstance().getconf("mzm.gsp.sensitive.main.SensitiveArgs");
/*    */     
/* 22 */     if (manager == null)
/*    */     {
/* 24 */       throw new RuntimeException("敏感词配置找不到：mzm.gsp.sensitive.main.SensitiveArgs");
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sensitive\main\SensitiveArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */