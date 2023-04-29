/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.team.event.TeamMemberStatusChangedArg;
/*    */ 
/*    */ public class POnTeamMemberStatusChanged extends mzm.gsp.team.event.TeamMemberStatusChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     if (!((TeamMemberStatusChangedArg)this.arg).leaderChange)
/*    */     {
/* 11 */       return false;
/*    */     }
/* 13 */     long teamid = ((TeamMemberStatusChangedArg)this.arg).teamid;
/* 14 */     xbean.Team xTeam = xtable.Team.select(Long.valueOf(teamid));
/* 15 */     if (xTeam == null)
/*    */     {
/* 17 */       return false;
/*    */     }
/* 19 */     TeamManager.changeLeaderPartner(teamid, xTeam);
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnTeamMemberStatusChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */