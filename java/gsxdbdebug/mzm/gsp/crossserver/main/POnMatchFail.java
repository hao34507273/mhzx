/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import mzm.gsp.crossserver.event.MatchFailArg;
/*    */ 
/*    */ public class POnMatchFail extends mzm.gsp.crossserver.event.MatchFailProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception {
/*  8 */     CrossServerManager.removeMatchContext(((MatchFailArg)this.arg).getContextid());
/*    */     
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\POnMatchFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */