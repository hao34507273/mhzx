/*     */ package mzm.gsp.team.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Procedure;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2team;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PApplyTeamRep
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long leader;
/*     */   private final long applicant;
/*     */   private final int reply;
/*     */   
/*     */   public PApplyTeamRep(long leader, long applicant, int reply)
/*     */   {
/*  27 */     this.leader = leader;
/*  28 */     this.applicant = applicant;
/*  29 */     this.reply = reply;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     Long teamid = Role2team.select(Long.valueOf(this.leader));
/*  36 */     if (teamid == null)
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     xbean.Team xTeam = xtable.Team.select(teamid);
/*  42 */     if (xTeam == null)
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (!TeamManager.isInApplyList(this.applicant, xTeam))
/*     */     {
/*  49 */       TeamManager.sendNormalResult(this.leader, 23, new String[0]);
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     Set<Long> lockRoles = new HashSet();
/*  54 */     lockRoles.addAll(TeamManager.getMemberListByXTeam(xTeam));
/*     */     
/*  56 */     if (lockRoles.contains(Long.valueOf(this.applicant)))
/*     */     {
/*  58 */       return false;
/*     */     }
/*  60 */     lockRoles.add(Long.valueOf(this.applicant));
/*     */     
/*     */ 
/*  63 */     lock(Basic.getTable(), lockRoles);
/*     */     
/*  65 */     xTeam = xtable.Team.get(teamid);
/*  66 */     if (xTeam == null)
/*     */     {
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     List<Long> teamMembers = TeamManager.getMemberListByXTeam(xTeam);
/*  72 */     if ((lockRoles.size() != teamMembers.size() + 1) || (!lockRoles.containsAll(teamMembers)))
/*     */     {
/*  74 */       GameServer.logger().error(String.format("[team]PApplyTeamRep.processImp@队伍结构发生变化，同意入队操作失败！|teamId=%d|lockRoles=%s|teamMembersAfterLock=%s|", new Object[] { teamid, lockRoles.toString(), teamMembers.toString() }));
/*     */       
/*     */ 
/*     */ 
/*  78 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  82 */     if (!TeamManager.isLeader(this.leader, xTeam))
/*     */     {
/*  84 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  88 */     if (!TeamManager.isInApplyList(this.applicant, xTeam))
/*     */     {
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     if (this.reply == 1)
/*     */     {
/*     */ 
/*  96 */       if (!checkApplicantState(teamid.longValue(), this.applicant))
/*     */       {
/*     */ 
/*  99 */         TeamManager.rmApplicantNonSyn(teamid.longValue(), this.applicant);
/* 100 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 104 */       if (TeamManager.isTeamFull(xTeam))
/*     */       {
/*     */ 
/* 107 */         Procedure.execute(new PClearAllApplicantsReq(this.leader));
/* 108 */         TeamManager.sendNormalResult(this.leader, 31, new String[0]);
/* 109 */         return false;
/*     */       }
/*     */       
/* 112 */       if (!TeamManager.onRoleJoinTeam(teamid.longValue(), xTeam, this.applicant, JoinTeamType.JOIN_TEAM__APPLY))
/*     */       {
/* 114 */         return false;
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/* 120 */       TeamManager.sendNormalResult(this.applicant, 32, new String[] { RoleInterface.getName(this.leader) });
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 125 */     if (TeamManager.removeApplicant(teamid.longValue(), xTeam, this.applicant))
/*     */     {
/*     */ 
/* 128 */       Procedure.execute(new PSyncApplicantsToAll(teamid.longValue()));
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean checkApplicantState(long teamid, long applicant)
/*     */   {
/* 136 */     if (!OnlineManager.getInstance().isOnline(applicant))
/*     */     {
/* 138 */       TeamManager.sendNormalResult(this.leader, 34, new String[] { RoleInterface.getName(applicant) });
/*     */       
/* 140 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 144 */     if (Role2team.select(Long.valueOf(applicant)) != null)
/*     */     {
/* 146 */       TeamManager.sendNormalResult(this.leader, 11, new String[] { RoleInterface.getName(applicant) });
/*     */       
/* 148 */       return false;
/*     */     }
/*     */     
/* 151 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PApplyTeamRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */