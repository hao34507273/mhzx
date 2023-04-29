/*    */ package mzm.gsp.team.event;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.team.TeamMember;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TeamLeaderChangedArg
/*    */ {
/*    */   public final long teamid;
/*    */   public final long newLeader;
/*    */   public final long oldLeader;
/*    */   public final List<TeamMember> teamMembers;
/*    */   
/*    */   public TeamLeaderChangedArg(long teamid, long newLeader, long oldLeader, List<TeamMember> teamMembers)
/*    */   {
/* 18 */     this.teamid = teamid;
/* 19 */     this.newLeader = newLeader;
/* 20 */     this.oldLeader = oldLeader;
/* 21 */     this.teamMembers = teamMembers;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\event\TeamLeaderChangedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */