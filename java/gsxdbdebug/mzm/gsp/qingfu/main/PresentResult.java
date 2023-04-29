/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum PresentResult
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
/* 18 */   Others(-2, "others exception"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 23 */   RoamServerBan(-3, "roam server ban");
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
/*    */   private PresentResult(int code, String desc)
/*    */   {
/* 37 */     this.code = code;
/* 38 */     this.desc = desc;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\PresentResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */