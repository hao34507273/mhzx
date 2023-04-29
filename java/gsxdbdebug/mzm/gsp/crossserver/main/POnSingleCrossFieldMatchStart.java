/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldMatchStartArg;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldMatchStartProcedure;
/*    */ 
/*    */ 
/*    */ public class POnSingleCrossFieldMatchStart
/*    */   extends SingleCrossFieldMatchStartProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     ((SingleCrossFieldMatchStartArg)this.arg).getContext().startWatchDog();
/* 14 */     CrossServerManager.confirmJoinSingleCrossFieldMatch(((SingleCrossFieldMatchStartArg)this.arg).getContext());
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\POnSingleCrossFieldMatchStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */