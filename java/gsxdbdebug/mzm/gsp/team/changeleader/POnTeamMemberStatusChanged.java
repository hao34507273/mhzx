/*    */ package mzm.gsp.team.changeleader;
/*    */ 
/*    */ import mzm.gsp.team.event.TeamMemberStatusChangedArg;
/*    */ 
/*    */ public class POnTeamMemberStatusChanged extends mzm.gsp.team.event.TeamMemberStatusChangedProcedure {
/*    */   protected boolean processImp() throws Exception {
/*  7 */     if (!((TeamMemberStatusChangedArg)this.arg).leaderChange) {
/*  8 */       return false;
/*    */     }
/* 10 */     long teamId = ((TeamMemberStatusChangedArg)this.arg).teamid;
/* 11 */     long oldLeader = ((TeamMemberStatusChangedArg)this.arg).getOldLeaderId();
/* 12 */     long newLeader = ((TeamMemberStatusChangedArg)this.arg).getNowLeaderId();
/*    */     
/* 14 */     return POnTeamLeaderChanged.onLeaderChange(oldLeader, newLeader, teamId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\changeleader\POnTeamMemberStatusChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */