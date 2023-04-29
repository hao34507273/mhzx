/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import mzm.gsp.crossserver.event.MatchStartArg;
/*    */ 
/*    */ public class POnMatchStart extends mzm.gsp.crossserver.event.MatchStartProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception {
/*  8 */     MatchContext context = MatchContextManager.getInstance().getContext(((MatchStartArg)this.arg).getContextid());
/*  9 */     if (context != null)
/*    */     {
/* 11 */       context.startTimeoutWatchDog();
/* 12 */       CrossServerManager.confirmJoinMatch(context);
/*    */     }
/*    */     
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\POnMatchStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */