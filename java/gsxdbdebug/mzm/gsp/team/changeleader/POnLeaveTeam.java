/*    */ package mzm.gsp.team.changeleader;
/*    */ 
/*    */ import mzm.gsp.team.SCancelInviteBeLeader;
/*    */ import mzm.gsp.team.event.LeaveTeamArg;
/*    */ import mzm.gsp.team.event.LeaveTeamProcedure;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import xbean.LeaderChangeBean;
/*    */ import xtable.Role2leaderchange;
/*    */ 
/*    */ public class POnLeaveTeam
/*    */   extends LeaveTeamProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     LeaderChangeBean xLeaderChangeBean = Role2leaderchange.get(Long.valueOf(((LeaveTeamArg)this.arg).roleid));
/* 18 */     if (xLeaderChangeBean == null) {
/* 19 */       return false;
/*    */     }
/* 21 */     Session.removeSession(xLeaderChangeBean.getSessionid());
/* 22 */     Role2leaderchange.remove(Long.valueOf(((LeaveTeamArg)this.arg).roleid));
/* 23 */     TeamInterface.broadcastInTeam(((LeaveTeamArg)this.arg).teamid, new SCancelInviteBeLeader());
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\changeleader\POnLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */