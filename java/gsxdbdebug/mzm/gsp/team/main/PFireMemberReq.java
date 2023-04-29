/*     */ package mzm.gsp.team.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.TeamMember;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2team;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PFireMemberReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long leader;
/*     */   private final long member;
/*     */   
/*     */   public PFireMemberReq(long leader, long member)
/*     */   {
/*  25 */     this.leader = leader;
/*  26 */     this.member = member;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     if (this.leader == this.member)
/*     */     {
/*  35 */       return false;
/*     */     }
/*     */     
/*  38 */     Long teamid = Role2team.select(Long.valueOf(this.leader));
/*  39 */     if (teamid == null)
/*     */     {
/*  41 */       return false;
/*     */     }
/*  43 */     xbean.Team xTeam = xtable.Team.select(teamid);
/*     */     
/*  45 */     List<Long> members = TeamManager.getMemberListByXTeam(xTeam);
/*     */     
/*  47 */     lock(Basic.getTable(), members);
/*     */     
/*  49 */     xTeam = xtable.Team.get(teamid);
/*     */     
/*  51 */     List<Long> membersAft = TeamManager.getMemberListByXTeam(xTeam);
/*  52 */     if ((members.size() != membersAft.size()) || (!members.containsAll(membersAft)))
/*     */     {
/*  54 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  58 */     if (!TeamManager.isLeader(this.leader, xTeam))
/*     */     {
/*  60 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  64 */     if (!canFireMemberInStatus(this.leader))
/*     */     {
/*  66 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  70 */     if (!TeamManager.isInTeam(this.member, xTeam))
/*     */     {
/*  72 */       return false;
/*     */     }
/*  74 */     TeamMember xMember = TeamManager.getXMember(xTeam, this.member);
/*     */     
/*  76 */     if (isInSameFight(this.leader, xMember))
/*     */     {
/*  78 */       xMember.setIstobefired(true);
/*  79 */       TeamManager.sendNormalResult(this.leader, 41, new String[0]);
/*  80 */       return true;
/*     */     }
/*     */     
/*  83 */     int oldStatus = xMember.getStatus();
/*  84 */     TeamManager.fireMemberWithEvent(teamid, xTeam, this.member, oldStatus);
/*     */     
/*  86 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isInSameFight(long leaderId, TeamMember xMember)
/*     */   {
/*  98 */     if (TeamManager.isInFight(leaderId).booleanValue())
/*     */     {
/* 100 */       if (xMember.getStatus() == 0)
/*     */       {
/* 102 */         return true;
/*     */       }
/*     */     }
/* 105 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isInSameFlyIng(long leaderId, TeamMember xMember)
/*     */   {
/* 117 */     if (TeamManager.isFlyIng(leaderId))
/*     */     {
/* 119 */       if (xMember.getStatus() == 0)
/*     */       {
/* 121 */         return true;
/*     */       }
/*     */     }
/* 124 */     return false;
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
/*     */   boolean canFireMemberInStatus(long leaderId)
/*     */   {
/* 138 */     if (!RoleStatusInterface.checkCanSetStatus(leaderId, 46, true))
/*     */     {
/* 140 */       GameServer.logger().error(String.format("[team]PFireMemberReq.canFireMemberInStatus@ fire member is forbiddened!|leaderId=%d", new Object[] { Long.valueOf(leaderId) }));
/*     */       
/*     */ 
/* 143 */       return false;
/*     */     }
/* 145 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PFireMemberReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */