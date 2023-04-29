/*    */ package mzm.gsp.team.event;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.team.TeamMember;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LeaveTeamArg
/*    */ {
/*    */   public final long teamid;
/*    */   public final long roleid;
/*    */   public final int status;
/*    */   public final LeaveTeamReason reason;
/*    */   public final boolean leaderChange;
/*    */   public final List<TeamMember> teamMembers;
/*    */   
/*    */   public static enum LeaveTeamReason
/*    */   {
/* 20 */     ACTIVE_LEAVE, 
/* 21 */     BE_FIRED, 
/* 22 */     TEAM_DISSOLVE, 
/* 23 */     FORCE_LEAVE;
/*    */     
/*    */     private LeaveTeamReason() {}
/*    */   }
/*    */   
/*    */   public LeaveTeamArg(long teamid, long roleid, int status, LeaveTeamReason reason, boolean leaderChange, List<TeamMember> teamMembers) {
/* 29 */     this.teamid = teamid;
/* 30 */     this.roleid = roleid;
/* 31 */     this.status = status;
/* 32 */     this.reason = reason;
/* 33 */     this.leaderChange = leaderChange;
/* 34 */     this.teamMembers = teamMembers;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isLeaderChanged()
/*    */   {
/* 43 */     return this.leaderChange;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getNowLeaderId()
/*    */   {
/* 51 */     if (this.teamMembers.size() >= 1) {
/* 52 */       return ((TeamMember)this.teamMembers.get(0)).roleid;
/*    */     }
/* 54 */     return -1L;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getOldLeaderId()
/*    */   {
/* 62 */     if (this.leaderChange) {
/* 63 */       return this.roleid;
/*    */     }
/* 65 */     return getNowLeaderId();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\event\LeaveTeamArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */