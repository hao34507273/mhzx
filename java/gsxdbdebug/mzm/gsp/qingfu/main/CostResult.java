/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum CostResult
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
/* 18 */   UserNotFound(-2, "user not found"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 23 */   BalanceNotEnough(-3, "balance not enough"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 28 */   Others(-4, "others exception"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 33 */   BindYuanBaoClearForAqIdip(-5, "bind yuanbao clear for aqidip"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 38 */   YuanBaoClearForAqIdip(-6, "yuanbao clear for aqidip"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 43 */   RoamServerBan(-7, "roam server ban");
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
/*    */   private CostResult(int code, String desc)
/*    */   {
/* 57 */     this.code = code;
/* 58 */     this.desc = desc;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\CostResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */