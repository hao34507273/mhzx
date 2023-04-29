/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.team.event.TeamLeaderChangedArg;
/*    */ import mzm.gsp.team.event.TeamLeaderChangedProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnTeamLeaderChanged
/*    */   extends TeamLeaderChangedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     long teamid = ((TeamLeaderChangedArg)this.arg).teamid;
/* 16 */     xbean.Team xTeam = xtable.Team.select(Long.valueOf(teamid));
/* 17 */     if (xTeam == null)
/*    */     {
/* 19 */       return false;
/*    */     }
/* 21 */     TeamManager.changeLeaderPartner(teamid, xTeam);
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnTeamLeaderChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */