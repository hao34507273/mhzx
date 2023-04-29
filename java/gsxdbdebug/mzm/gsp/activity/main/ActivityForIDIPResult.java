/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ public enum ActivityForIDIPResult
/*    */ {
/*  5 */   UNKNOWN_ERROR(-1, "UNKNOWN_ERROR"), 
/*  6 */   CFG_NOT_EXIST(-2, "ACTIVITY CONFIG NOT EXIST!!"), 
/*  7 */   ACTIVITY_ALREADY_OPEN(-3, "ACTIVITY ALREADY OPEN"), 
/*  8 */   MINUTE_PARAMETER_ERROR(-4, "MINUTE PARAMETER ERROR"), 
/*  9 */   ACTIVITY_IN_FORCE_CLOSE(-5, "ACTIVITY_IN_FORCE_CLOSE"), 
/* 10 */   MINUTE_PARAMETER_TOO_LONG(-6, "MINUTE TIME IS TOO LONG"), 
/* 11 */   ACTIVITY_NOT_IN_FORCE_OPEN(-7, "ACTIVITY_NOT_IN_FORCE_OPEN"), 
/* 12 */   SUCCESS(0, "SUCCESS");
/*    */   
/*    */   public final String retString;
/*    */   public final int retCode;
/*    */   
/*    */   private ActivityForIDIPResult(int retCode, String ret) {
/* 18 */     this.retString = ret;
/* 19 */     this.retCode = retCode;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\ActivityForIDIPResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */