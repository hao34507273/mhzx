/*    */ package mzm.gsp.award.gift;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ResetGiftRes
/*    */ {
/*    */   private boolean bSucceed;
/*    */   
/*    */   private ResetRes res;
/*    */   
/*    */ 
/*    */   public static enum ResetRes
/*    */   {
/* 14 */     ERROR__ILLEGAL_USE_TYPE, 
/* 15 */     ERROR__OTHER;
/*    */     
/*    */     private ResetRes() {}
/*    */   }
/*    */   
/*    */   public ResetGiftRes() {
/* 21 */     this.bSucceed = false;
/*    */   }
/*    */   
/*    */   public ResetGiftRes(boolean isSuc)
/*    */   {
/* 26 */     this.bSucceed = isSuc;
/*    */   }
/*    */   
/*    */   public ResetGiftRes(boolean isSuc, ResetRes res)
/*    */   {
/* 31 */     this.bSucceed = isSuc;
/* 32 */     this.res = res;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isbSucceed()
/*    */   {
/* 42 */     return this.bSucceed;
/*    */   }
/*    */   
/*    */   public void setbSucceed(boolean bSucceed)
/*    */   {
/* 47 */     this.bSucceed = bSucceed;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public ResetRes getRes()
/*    */   {
/* 57 */     return this.res;
/*    */   }
/*    */   
/*    */   public void setRes(ResetRes res)
/*    */   {
/* 62 */     this.res = res;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gift\ResetGiftRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */