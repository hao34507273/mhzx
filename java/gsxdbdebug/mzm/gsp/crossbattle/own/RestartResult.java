/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum RestartResult
/*    */ {
/*  8 */   Success(0, "success"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 13 */   ParamError(-1, "parameter error"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 18 */   TimestampError(-2, "timestamp error"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 23 */   ActivityStageError(-3, "activity stage error"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 28 */   RoundIndexError(-4, "round index error"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 33 */   RoundNotEndError(-5, "round not end error"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 38 */   AlreadyHaveRestartRoundError(-6, "already have restart round error"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 43 */   NoNeedRestartFightError(-7, "no need restart fight error"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 48 */   CurrentInFightError(-8, "current in fight error");
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
/*    */   private RestartResult(int code, String desc)
/*    */   {
/* 62 */     this.code = code;
/* 63 */     this.desc = desc;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\RestartResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */