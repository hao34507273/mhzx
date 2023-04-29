/*    */ package mzm.gsp.task.surprise;
/*    */ 
/*    */ 
/*    */ public enum SurpriseOptionResult
/*    */ {
/*  6 */   UNKNOWN_ERROR(-1, "UNKNOWN_ERROR"), 
/*  7 */   FORMAT_ERROR(-2, "TIME_FORMAT_ERROR"), 
/*  8 */   OVER_CURRENT_TIME_ERROR(-3, "OVER_CURRENT_TIME_ERROR"), 
/*  9 */   SUCCESS(0, "SUCCESS");
/*    */   
/*    */ 
/*    */   public final String retString;
/*    */   public final int retCode;
/*    */   
/*    */   private SurpriseOptionResult(int retCode, String ret)
/*    */   {
/* 17 */     this.retString = ret;
/* 18 */     this.retCode = retCode;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\surprise\SurpriseOptionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */