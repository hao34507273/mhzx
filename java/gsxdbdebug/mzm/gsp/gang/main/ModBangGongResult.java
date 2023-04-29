/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModBangGongResult
/*    */ {
/*    */   private boolean bSucceed;
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
/* 19 */     ERROR_BANGGONG_NOT_IN_GANG, 
/* 20 */     ERROR_BANGGONG_GANG_ERROR, 
/* 21 */     ERROR_BANGGONG_NUM_SIGN, 
/* 22 */     ERROR_BANGGONG_NUM_HAS_REACH_TOP_LIMIT, 
/* 23 */     ERROR_BANGGONG_NUM_HAS_REACH_LOW_LIMIT;
/*    */     
/*    */ 
/*    */     private ErrorResult() {}
/*    */   }
/*    */   
/*    */   public boolean isSucceed()
/*    */   {
/* 31 */     return this.bSucceed;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getModValue()
/*    */   {
/* 39 */     return this.modValue;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public ErrorResult getRes()
/*    */   {
/* 47 */     return this.res;
/*    */   }
/*    */   
/*    */   public void setbSucceed(boolean bSucceed)
/*    */   {
/* 52 */     this.bSucceed = bSucceed;
/*    */   }
/*    */   
/*    */   public void setModValue(long modValue) {
/* 56 */     this.modValue = modValue;
/*    */   }
/*    */   
/*    */   public void setRes(ErrorResult res) {
/* 60 */     this.res = res;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\ModBangGongResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */