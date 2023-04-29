/*    */ package mzm.gsp.storageexp.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum StorageExpOperResult
/*    */ {
/* 10 */   SUCCESS(0, "ok"), 
/* 11 */   STORAGEEXP_NUM_ERROR(64406, "value not equal 0"), 
/* 12 */   STORAGEEXP_CLEAR_FOR_AQIDIP(64405, "storageExp clear for aqidip");
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
/*    */   private StorageExpOperResult(int ret, String retMsg)
/*    */   {
/* 27 */     this.ret = ret;
/* 28 */     this.retMsg = retMsg;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storageexp\main\StorageExpOperResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */