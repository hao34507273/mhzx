/*    */ package mzm.gsp.team.changeleader;
/*    */ 
/*    */ import mzm.gsp.team.SCancelInviteBeLeader;
/*    */ import mzm.gsp.team.event.TeamLeaderChangedArg;
/*    */ import mzm.gsp.team.event.TeamLeaderChangedProcedure;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.LeaderChangeBean;
/*    */ import xbean.Pod;
/*    */ import xdb.Procedure;
/*    */ import xtable.Role2leaderchange;
/*    */ 
/*    */ public class POnTeamLeaderChanged extends TeamLeaderChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     long leader_old = ((TeamLeaderChangedArg)this.arg).oldLeader;
/* 19 */     long leader_new = ((TeamLeaderChangedArg)this.arg).newLeader;
/*    */     
/* 21 */     long teamId = ((TeamLeaderChangedArg)this.arg).teamid;
/*    */     
/* 23 */     return onLeaderChange(leader_old, leader_new, teamId);
/*    */   }
/*    */   
/*    */ 
/*    */   static boolean onLeaderChange(long leader_old, long leader_new, long teamId)
/*    */   {
/* 29 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 33 */         LeaderChangeBean xLeaderChangeBean = Role2leaderchange.get(Long.valueOf(this.val$leader_old));
/* 34 */         if (xLeaderChangeBean == null) {
/* 35 */           return false;
/*    */         }
/* 37 */         Session.removeSession(xLeaderChangeBean.getSessionid());
/* 38 */         Role2leaderchange.remove(Long.valueOf(this.val$leader_old));
/* 39 */         TeamInterface.broadcastInTeam(this.val$teamId, new SCancelInviteBeLeader());
/* 40 */         return true;
/*    */ 
/*    */       }
/*    */       
/*    */ 
/* 45 */     });
/* 46 */     LeaderChangeBean xLeaderChangeBean = Role2leaderchange.get(Long.valueOf(leader_new));
/* 47 */     if (xLeaderChangeBean == null) {
/* 48 */       xLeaderChangeBean = Pod.newLeaderChangeBean();
/* 49 */       Role2leaderchange.insert(Long.valueOf(leader_new), xLeaderChangeBean);
/*    */     }
/*    */     
/* 52 */     xbean.Team xTeam = xtable.Team.select(Long.valueOf(teamId));
/* 53 */     if (xTeam == null) {
/* 54 */       return false;
/*    */     }
/*    */     
/* 57 */     ChangeLeaderManager.startChangeLeaderSession(leader_new, xLeaderChangeBean);
/* 58 */     boolean isChangeIng = xTeam.getIschangeleadering();
/* 59 */     if (isChangeIng) {
/* 60 */       xTeam.setIschangeleadering(false);
/*    */     }
/*    */     
/* 63 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\changeleader\POnTeamLeaderChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */