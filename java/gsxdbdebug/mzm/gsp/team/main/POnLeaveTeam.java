/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.team.event.LeaveTeamArg;
/*    */ 
/*    */ public class POnLeaveTeam extends mzm.gsp.team.event.LeaveTeamProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     if (!((LeaveTeamArg)this.arg).leaderChange)
/*    */     {
/* 11 */       return false;
/*    */     }
/* 13 */     long teamid = ((LeaveTeamArg)this.arg).teamid;
/* 14 */     xbean.Team xTeam = xtable.Team.select(Long.valueOf(teamid));
/* 15 */     if (xTeam == null)
/*    */     {
/* 17 */       return false;
/*    */     }
/* 19 */     TeamManager.changeLeaderPartner(teamid, xTeam);
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */