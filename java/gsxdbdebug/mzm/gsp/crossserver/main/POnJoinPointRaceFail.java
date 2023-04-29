/*   */ package mzm.gsp.crossserver.main;
/*   */ 
/*   */ import mzm.gsp.crossserver.event.JoinPointRaceFailArg;
/*   */ 
/*   */ public class POnJoinPointRaceFail extends mzm.gsp.crossserver.event.JoinPointRaceFailProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     PointRaceContextManager.getInstance().removeContext(((JoinPointRaceFailArg)this.arg).getContextid());
/* 9 */     return true;
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\POnJoinPointRaceFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */