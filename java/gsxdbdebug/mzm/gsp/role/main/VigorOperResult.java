/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum VigorOperResult
/*    */ {
/*  8 */   SUCCESS(0, "ok"), 
/*  9 */   VIGOR_NUM_ERROR(64506, "value not equal to 0"), 
/* 10 */   VIGOR_TYPE_ERROR(64505, "vigor type not exist"), 
/* 11 */   VIGOR_NUM_NOT_ENOUGH(64504, "vigor not enough"), 
/* 12 */   VIGOR_ADD_MAX(64503, "vigor has reach top limit"), 
/* 13 */   VIGOR_CLEAR_FOR_AQIDIP(64502, "vigor clear for aqidip"), 
/* 14 */   VIGOR_ZERO_ADD(64501, "zero state");
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int ret;
/*    */   
/*    */ 
/*    */ 
/*    */   public String retMsg;
/*    */   
/*    */ 
/*    */ 
/*    */   private VigorOperResult(int ret, String retMsg)
/*    */   {
/* 29 */     this.ret = ret;
/* 30 */     this.retMsg = retMsg;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\VigorOperResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */