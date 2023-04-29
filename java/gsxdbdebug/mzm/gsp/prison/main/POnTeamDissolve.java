/*   */ package mzm.gsp.prison.main;
/*   */ 
/*   */ import mzm.gsp.team.event.TeamDissolveArg;
/*   */ 
/*   */ public class POnTeamDissolve extends mzm.gsp.team.event.TeamDissolveProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception
/*   */   {
/* 9 */     return PrisonManager.transferPrisonMap(((TeamDissolveArg)this.arg).getLeader());
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\POnTeamDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */