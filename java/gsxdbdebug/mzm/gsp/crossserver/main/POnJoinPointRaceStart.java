/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import mzm.gsp.crossserver.event.JoinPointRaceStartArg;
/*    */ 
/*    */ public class POnJoinPointRaceStart extends mzm.gsp.crossserver.event.JoinPointRaceStartProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception {
/*  8 */     PointRaceContext context = PointRaceContextManager.getInstance().getContext(((JoinPointRaceStartArg)this.arg).getContextid());
/*  9 */     if (context != null)
/*    */     {
/* 11 */       context.startTimeoutWatchDog();
/* 12 */       CrossServerManager.confirmJoinPointRace(context);
/*    */     }
/*    */     
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\POnJoinPointRaceStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */