/*    */ package mzm.gsp.team.changeleader;
/*    */ 
/*    */ import mzm.gsp.team.event.TeamCreateArg;
/*    */ import mzm.gsp.team.event.TeamCreateProcedure;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.LeaderChangeBean;
/*    */ import xbean.Pod;
/*    */ import xtable.Role2leaderchange;
/*    */ 
/*    */ public class POnTeamCreate
/*    */   extends TeamCreateProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     long teamid = ((TeamCreateArg)this.arg).teamid;
/* 16 */     if (teamid <= 0L) {
/* 17 */       return false;
/*    */     }
/* 19 */     long leaderId = TeamInterface.getTeamLeaderByTeamid(teamid, false);
/* 20 */     if (leaderId <= 0L) {
/* 21 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 25 */     LeaderChangeBean xLeaderChangeBean = Role2leaderchange.get(Long.valueOf(leaderId));
/* 26 */     if (xLeaderChangeBean == null) {
/* 27 */       xLeaderChangeBean = Pod.newLeaderChangeBean();
/* 28 */       Role2leaderchange.insert(Long.valueOf(leaderId), xLeaderChangeBean);
/*    */     }
/*    */     
/* 31 */     xbean.Team xTeam = xtable.Team.get(Long.valueOf(teamid));
/* 32 */     if (xTeam == null) {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     ChangeLeaderManager.startChangeLeaderSession(leaderId, xLeaderChangeBean);
/* 37 */     boolean isChangeIng = xTeam.getIschangeleadering();
/* 38 */     if (isChangeIng) {
/* 39 */       xTeam.setIschangeleadering(false);
/*    */     }
/*    */     
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\changeleader\POnTeamCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */