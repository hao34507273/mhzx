/*   */ package mzm.gsp.prison.main;
/*   */ 
/*   */ import mzm.gsp.team.event.LeaveTeamArg;
/*   */ 
/*   */ public class POnLeaveTeam extends mzm.gsp.team.event.LeaveTeamProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception
/*   */   {
/* 9 */     return PrisonManager.transferPrisonMap(((LeaveTeamArg)this.arg).roleid);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\POnLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */