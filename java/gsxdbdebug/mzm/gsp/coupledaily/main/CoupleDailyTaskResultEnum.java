/*    */ package mzm.gsp.coupledaily.main;
/*    */ 
/*    */ public enum CoupleDailyTaskResultEnum
/*    */ {
/*  5 */   SUCCESS(0),  FAIL(1);
/*    */   
/*    */   private final int result;
/*    */   
/*    */   private CoupleDailyTaskResultEnum(int result)
/*    */   {
/* 11 */     this.result = result;
/*    */   }
/*    */   
/*    */   public int getResult()
/*    */   {
/* 16 */     return this.result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\main\CoupleDailyTaskResultEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */