/*    */ package mzm.gsp.storageexp.main;
/*    */ 
/*    */ 
/*    */ public class ModStorageExpRes
/*    */ {
/*    */   private boolean bSucceed;
/*    */   
/*    */   private long modValue;
/*    */   
/*    */   private ModRes res;
/*    */   
/*    */ 
/*    */   public static enum ModRes
/*    */   {
/* 15 */     ERROR_STOR_EXP_NUM_SIGN, 
/* 16 */     ERROR_STOR_EXP_NUM_HAS_REACH_TOP_LIMIT, 
/* 17 */     ERROR_STOR_EXP_NO_XDATA, 
/* 18 */     ERROR_ADD_STORE_EXP_SWITCH_CLOSED;
/*    */     
/*    */     private ModRes() {}
/*    */   }
/*    */   
/* 23 */   public ModStorageExpRes() { this.bSucceed = false; }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isbSucceed()
/*    */   {
/* 33 */     return this.bSucceed;
/*    */   }
/*    */   
/*    */   public void setbSucceed(boolean bSucceed)
/*    */   {
/* 38 */     this.bSucceed = bSucceed;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getModValue()
/*    */   {
/* 48 */     return this.modValue;
/*    */   }
/*    */   
/*    */   public void setModValue(long modValue)
/*    */   {
/* 53 */     this.modValue = modValue;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public ModRes getRes()
/*    */   {
/* 63 */     return this.res;
/*    */   }
/*    */   
/*    */   public void setRes(ModRes res)
/*    */   {
/* 68 */     this.res = res;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storageexp\main\ModStorageExpRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */