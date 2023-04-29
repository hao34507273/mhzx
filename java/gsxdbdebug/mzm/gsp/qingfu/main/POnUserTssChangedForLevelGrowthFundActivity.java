/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import mzm.gsp.qingfu.event.TssChangedArg;
/*    */ 
/*    */ public class POnUserTssChangedForLevelGrowthFundActivity extends mzm.gsp.qingfu.event.TssChangedProcedure
/*    */ {
/*    */   private final TssChangedArg arg;
/*    */   
/*    */   public POnUserTssChangedForLevelGrowthFundActivity(TssChangedArg arg)
/*    */   {
/* 11 */     this.arg = arg;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     return LevelGrowthFundActivityManager.onPurchaseService(this.arg);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\POnUserTssChangedForLevelGrowthFundActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */