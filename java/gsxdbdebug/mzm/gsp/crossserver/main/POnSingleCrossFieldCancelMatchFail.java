/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldCancelMatchFailArg;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldCancelMatchFailProcedure;
/*    */ 
/*    */ 
/*    */ public class POnSingleCrossFieldCancelMatchFail
/*    */   extends SingleCrossFieldCancelMatchFailProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     ((SingleCrossFieldCancelMatchFailArg)this.arg).getContext().setIsCanceling(false);
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\POnSingleCrossFieldCancelMatchFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */