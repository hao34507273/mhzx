/*    */ package mzm.gsp.team.event;
/*    */ 
/*    */ 
/*    */ public class JoinTeamArg
/*    */ {
/*    */   public final long teamid;
/*    */   
/*    */   public final long leaderid;
/*    */   
/*    */   public final TeamMember member;
/*    */   
/*    */   private boolean comeFromPlatform;
/*    */   
/*    */   public JoinTeamArg(long teamid, long leaderid, TeamMember member)
/*    */   {
/* 16 */     this.teamid = teamid;
/* 17 */     this.member = member;
/* 18 */     this.leaderid = leaderid;
/*    */   }
/*    */   
/*    */   public long getNewGuyRoleId() {
/* 22 */     return this.member.roleid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getNewGuyStatus()
/*    */   {
/* 30 */     return this.member.status;
/*    */   }
/*    */   
/*    */   public boolean isComeFromPlatform() {
/* 34 */     return this.comeFromPlatform;
/*    */   }
/*    */   
/*    */   public void setComeFromPlatform(boolean comeFromPlatform) {
/* 38 */     this.comeFromPlatform = comeFromPlatform;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getLeaderId()
/*    */   {
/* 46 */     return this.leaderid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\event\JoinTeamArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */