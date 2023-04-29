/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum PresentInnerSaveAmtResult
/*    */ {
/*  8 */   Success(0, "success"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 13 */   ParamInvalid(-1, "param invlaid"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 18 */   UserNotExist(-2, "user not exist"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 23 */   Others(-100, "others exception");
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int code;
/*    */   
/*    */ 
/*    */ 
/*    */   public final String desc;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private PresentInnerSaveAmtResult(int code, String desc)
/*    */   {
/* 39 */     this.code = code;
/* 40 */     this.desc = desc;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\PresentInnerSaveAmtResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */