/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldCancelMatchSuccessArg;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldCancelMatchSuccessProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnSingleCrossFieldCancelMatchSuccess
/*    */   extends SingleCrossFieldCancelMatchSuccessProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 14 */     SingleCrossFieldContextManager.getInstance().removeContext(((SingleCrossFieldCancelMatchSuccessArg)this.arg).getContext().getContextid());
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\POnSingleCrossFieldCancelMatchSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */