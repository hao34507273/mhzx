/*   */ package mzm.gsp.team.heart;
/*   */ 
/*   */ import mzm.gsp.team.event.JoinTeamArg;
/*   */ 
/*   */ public class POnJoinTeam extends mzm.gsp.team.event.JoinTeamProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     return new PJoinTeam(((JoinTeamArg)this.arg).teamid).call();
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\heart\POnJoinTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */