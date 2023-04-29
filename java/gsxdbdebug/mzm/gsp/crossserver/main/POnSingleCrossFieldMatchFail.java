/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldMatchFailArg;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldMatchFailProcedure;
/*    */ 
/*    */ 
/*    */ public class POnSingleCrossFieldMatchFail
/*    */   extends SingleCrossFieldMatchFailProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     SingleCrossFieldContextManager.getInstance().removeContext(((SingleCrossFieldMatchFailArg)this.arg).getContext().getContextid());
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\POnSingleCrossFieldMatchFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */