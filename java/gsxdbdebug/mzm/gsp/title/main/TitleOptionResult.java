/*    */ package mzm.gsp.title.main;
/*    */ 
/*    */ 
/*    */ public enum TitleOptionResult
/*    */ {
/*  6 */   UNKNOWN_ERROR(-1, "UNKNOWN_ERROR"), 
/*  7 */   NOT_OWN_ERROR(-2, "NOT_OWN_ERROR"), 
/*  8 */   SUCCESS(0, "SUCCESS");
/*    */   
/*    */ 
/*    */   public final String retString;
/*    */   public final int retCode;
/*    */   
/*    */   private TitleOptionResult(int retCode, String ret)
/*    */   {
/* 16 */     this.retString = ret;
/* 17 */     this.retCode = retCode;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\TitleOptionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */