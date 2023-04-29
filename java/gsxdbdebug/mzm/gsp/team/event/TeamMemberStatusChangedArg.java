/*     */ package mzm.gsp.team.event;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.team.TeamMember;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TeamMemberStatusChangedArg
/*     */ {
/*     */   public final long teamid;
/*     */   public final long roleid;
/*     */   public final int oldStatus;
/*     */   public final int status;
/*     */   public final List<TeamMember> teamMembers;
/*     */   public final boolean leaderChange;
/*     */   
/*     */   public TeamMemberStatusChangedArg(long teamid, long roleid, int oldStatus, int status, List<TeamMember> teamMembers, boolean leaderChange)
/*     */   {
/*  21 */     this.teamid = teamid;
/*  22 */     this.roleid = roleid;
/*  23 */     this.oldStatus = oldStatus;
/*  24 */     this.status = status;
/*  25 */     this.teamMembers = teamMembers;
/*  26 */     this.leaderChange = leaderChange;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isPreNormal()
/*     */   {
/*  34 */     return this.oldStatus == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isPreTempLeave()
/*     */   {
/*  42 */     return this.oldStatus == 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isPreOffline()
/*     */   {
/*  50 */     return this.oldStatus == 2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isNormal()
/*     */   {
/*  58 */     return this.status == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isTempLeave()
/*     */   {
/*  66 */     return this.status == 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isOffline()
/*     */   {
/*  74 */     return this.status == 2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getNowLeaderId()
/*     */   {
/*  82 */     if (this.teamMembers.size() <= 0) {
/*  83 */       return -1L;
/*     */     }
/*  85 */     return ((TeamMember)this.teamMembers.get(0)).roleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isLeaderChanged()
/*     */   {
/*  93 */     return this.leaderChange;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getOldLeaderId()
/*     */   {
/* 102 */     if (this.leaderChange) {
/* 103 */       return this.roleid;
/*     */     }
/* 105 */     return getNowLeaderId();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\event\TeamMemberStatusChangedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */