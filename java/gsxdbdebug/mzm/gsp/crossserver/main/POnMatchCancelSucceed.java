/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import mzm.gsp.crossserver.event.MatchCancelSucceedArg;
/*    */ 
/*    */ public class POnMatchCancelSucceed extends mzm.gsp.crossserver.event.MatchCancelSucceedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception {
/*  8 */     CrossServerManager.removeMatchContext(((MatchCancelSucceedArg)this.arg).getContextid());
/*    */     
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\POnMatchCancelSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */