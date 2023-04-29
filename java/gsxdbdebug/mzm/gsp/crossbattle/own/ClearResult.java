/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum ClearResult
/*    */ {
/*  8 */   NotReport(0, "not report"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 13 */   AlreadyReport(1, "already report"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 18 */   DoNotNeedReport(2, "do not need report"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 23 */   AlreadyClear(3, "already clear"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 28 */   ParamError(-1, "parameter error"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 33 */   CommunicationError(-2, "communication error");
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int code;
/*    */   
/*    */ 
/*    */   public final String desc;
/*    */   
/*    */ 
/*    */ 
/*    */   private ClearResult(int code, String desc)
/*    */   {
/* 47 */     this.code = code;
/* 48 */     this.desc = desc;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\ClearResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */