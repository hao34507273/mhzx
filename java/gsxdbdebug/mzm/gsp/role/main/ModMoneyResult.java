/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModMoneyResult
/*    */ {
/*    */   private boolean bSucceed;
/*    */   
/*    */ 
/*    */ 
/*    */   private long modValue;
/*    */   
/*    */ 
/*    */   private ErrorResult res;
/*    */   
/*    */ 
/*    */ 
/*    */   public static enum ErrorResult
/*    */   {
/* 21 */     ERROR_MONEY_NUM_SIGN, 
/* 22 */     ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT;
/*    */     
/*    */ 
/*    */ 
/*    */     private ErrorResult() {}
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isSucceed()
/*    */   {
/* 32 */     return this.bSucceed;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getModValue()
/*    */   {
/* 42 */     return this.modValue;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public ErrorResult getRes()
/*    */   {
/* 52 */     return this.res;
/*    */   }
/*    */   
/*    */   public void setbSucceed(boolean bSucceed)
/*    */   {
/* 57 */     this.bSucceed = bSucceed;
/*    */   }
/*    */   
/*    */   public void setModValue(long modValue)
/*    */   {
/* 62 */     this.modValue = modValue;
/*    */   }
/*    */   
/*    */   public void setRes(ErrorResult res)
/*    */   {
/* 67 */     this.res = res;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\ModMoneyResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */