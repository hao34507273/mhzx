/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import mzm.gsp.crossserver.event.SelectionOrFinalMatchSucceedArg;
/*    */ import mzm.gsp.crossserver.event.SelectionOrFinalMatchSucceedProcedure;
/*    */ 
/*    */ public class POnSelectionOrFinalMatchSucceed extends SelectionOrFinalMatchSucceedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     KnockOutContext context = KnockOutContextManager.getInstance().getContext(((SelectionOrFinalMatchSucceedArg)this.arg).getContextid());
/* 11 */     if (context == null)
/*    */     {
/* 13 */       return false;
/*    */     }
/*    */     
/* 16 */     CrossServerManager.genRoamToken(context);
/*    */     
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\POnSelectionOrFinalMatchSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */