/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnUserTssChangedForMonthCardActivity extends LogicProcedure
/*    */ {
/*    */   private final String userId;
/*    */   
/*    */   public POnUserTssChangedForMonthCardActivity(String userId)
/*    */   {
/* 11 */     this.userId = userId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     return MonthCardActivityManager.onPurchaseService(this.userId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\POnUserTssChangedForMonthCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */