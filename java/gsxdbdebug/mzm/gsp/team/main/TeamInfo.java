/*     */ package mzm.gsp.team.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.team.confbean.TeamConsts;
/*     */ import xbean.TeamMember;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TeamInfo
/*     */ {
/*     */   private final long teamId;
/*     */   private final xbean.Team xTeam;
/*     */   
/*     */   public TeamInfo(long teamId, boolean isRemainTeamLock)
/*     */   {
/*  22 */     this.teamId = teamId;
/*  23 */     if (isRemainTeamLock)
/*     */     {
/*  25 */       this.xTeam = xtable.Team.get(Long.valueOf(teamId));
/*     */     }
/*     */     else
/*     */     {
/*  29 */       this.xTeam = xtable.Team.select(Long.valueOf(teamId));
/*     */     }
/*     */   }
/*     */   
/*     */   public TeamInfo(long teamId, xbean.Team xTeam)
/*     */   {
/*  35 */     this.teamId = teamId;
/*  36 */     this.xTeam = xTeam;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isTeamExist()
/*     */   {
/*  46 */     return getxTeam() != null;
/*     */   }
/*     */   
/*     */   private xbean.Team getxTeam()
/*     */   {
/*  51 */     return this.xTeam;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getTeamId()
/*     */   {
/*  61 */     return this.teamId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getLeaderId()
/*     */   {
/*  71 */     return TeamManager.getLearder(this.xTeam);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isLeader(long roleId)
/*     */   {
/*  83 */     return roleId == getLeaderId();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Long> getTeamMemberList()
/*     */   {
/*  93 */     return TeamManager.getMemberListByXTeam(this.xTeam);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getTeamAllMembersNum()
/*     */   {
/* 103 */     return this.xTeam.getMembers().size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isFull()
/*     */   {
/* 113 */     return getTeamAllMembersNum() == TeamConsts.getInstance().TEAM_CAPACITY;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Long> getTeamNormalList()
/*     */   {
/* 123 */     List<Long> normaList = new ArrayList();
/* 124 */     TeamManager.getNormalMemberInDIs(normaList, this.xTeam);
/* 125 */     return normaList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getTeamNormalMembersNum()
/*     */   {
/* 135 */     int num = 0;
/* 136 */     for (TeamMember xMember : this.xTeam.getMembers())
/*     */     {
/* 138 */       if (xMember.getStatus() == 0)
/*     */       {
/* 140 */         num++;
/*     */       }
/*     */     }
/* 143 */     return num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isNormalState(long roleId)
/*     */   {
/* 155 */     return getMemberStatus(roleId) == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getMemberStatus(long roleId)
/*     */   {
/* 167 */     TeamMember xMember = TeamManager.getXMember(this.xTeam, roleId);
/* 168 */     if (xMember == null)
/*     */     {
/* 170 */       return -1;
/*     */     }
/* 172 */     return xMember.getStatus();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isAllTeamMemberNormal()
/*     */   {
/* 190 */     for (TeamMember xTeamMember : this.xTeam.getMembers())
/*     */     {
/* 192 */       if (xTeamMember.getStatus() != 0)
/*     */       {
/* 194 */         return false;
/*     */       }
/*     */     }
/* 197 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isRoleInTeam(long roleId)
/*     */   {
/* 209 */     if (this.xTeam != null)
/*     */     {
/* 211 */       for (TeamMember xMember : this.xTeam.getMembers())
/*     */       {
/* 213 */         if (xMember.getRoleid() == roleId)
/*     */         {
/* 215 */           return true;
/*     */         }
/*     */       }
/*     */     }
/* 219 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isStableTeam()
/*     */   {
/* 229 */     return this.xTeam.getSameteamfightcount() >= TeamConsts.getInstance().TEAM_STABLE_MIN_FIGHTCOUNT;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\TeamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */