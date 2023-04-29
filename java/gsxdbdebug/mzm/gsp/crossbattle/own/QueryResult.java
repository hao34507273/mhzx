/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum QueryResult
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
/* 23 */   ParamError(-1, "parameter error");
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
/*    */   private QueryResult(int code, String desc)
/*    */   {
/* 37 */     this.code = code;
/* 38 */     this.desc = desc;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\QueryResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */