/*    */ package mzm.gsp.team.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TeamCreateArg
/*    */ {
/*    */   public final long teamid;
/*    */   public final List<TeamMember> members;
/*    */   
/*    */   public TeamCreateArg(long teamid, List<TeamMember> members)
/*    */   {
/* 17 */     this.teamid = teamid;
/* 18 */     this.members = members;
/*    */   }
/*    */   
/*    */   public TeamCreateArg(long teamid) {
/* 22 */     this.teamid = teamid;
/* 23 */     this.members = new ArrayList();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getLeader()
/*    */   {
/* 31 */     return ((TeamMember)this.members.get(0)).roleid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\event\TeamCreateArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */