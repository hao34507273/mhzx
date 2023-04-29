/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import mzm.gsp.crossserver.event.SelectionOrFinalMatchFailedArg;
/*    */ import mzm.gsp.crossserver.event.SelectionOrFinalMatchFailedProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnSelectionOrFinalMatchFailed
/*    */   extends SelectionOrFinalMatchFailedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 14 */     KnockOutContextManager.getInstance().removeContext(((SelectionOrFinalMatchFailedArg)this.arg).getContextid());
/*    */     
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\POnSelectionOrFinalMatchFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */