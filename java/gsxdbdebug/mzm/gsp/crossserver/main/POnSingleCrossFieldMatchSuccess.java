/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldMatchSuccessArg;
/*    */ 
/*    */ public class POnSingleCrossFieldMatchSuccess extends mzm.gsp.crossserver.event.SingleCrossFieldMatchSuccessProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     CrossServerManager.genRoamToken(((SingleCrossFieldMatchSuccessArg)this.arg).getContext());
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\POnSingleCrossFieldMatchSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */