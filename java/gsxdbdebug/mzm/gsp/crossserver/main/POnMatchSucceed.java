/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import mzm.gsp.crossserver.event.MatchSucceedArg;
/*    */ 
/*    */ public class POnMatchSucceed extends mzm.gsp.crossserver.event.MatchSucceedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception {
/*  8 */     MatchContext context = MatchContextManager.getInstance().getContext(((MatchSucceedArg)this.arg).getContextid());
/*  9 */     if (context == null)
/*    */     {
/* 11 */       return false;
/*    */     }
/*    */     
/* 14 */     CrossServerManager.genRoamToken(context);
/*    */     
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\POnMatchSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */