/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import mzm.gsp.qingfu.event.TssChangedArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnUserTssChangedForRMBGiftBagActivity extends LogicProcedure
/*    */ {
/*    */   private final TssChangedArg arg;
/*    */   
/*    */   public POnUserTssChangedForRMBGiftBagActivity(TssChangedArg arg)
/*    */   {
/* 12 */     this.arg = arg;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     return RMBGiftBagActivityManager.onPurchaseService(this.arg);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\POnUserTssChangedForRMBGiftBagActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */