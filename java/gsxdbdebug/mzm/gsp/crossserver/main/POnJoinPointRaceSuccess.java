/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import mzm.gsp.crossserver.event.JoinPointRaceSuccessArg;
/*    */ 
/*    */ public class POnJoinPointRaceSuccess extends mzm.gsp.crossserver.event.JoinPointRaceSuccessProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception {
/*  8 */     PointRaceContext context = PointRaceContextManager.getInstance().getContext(((JoinPointRaceSuccessArg)this.arg).getContextid());
/*  9 */     if (context == null)
/*    */     {
/* 11 */       return false;
/*    */     }
/* 13 */     CrossServerManager.genRoamToken(context);
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\POnJoinPointRaceSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */