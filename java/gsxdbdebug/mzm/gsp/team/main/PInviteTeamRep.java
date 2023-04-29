/*     */ package mzm.gsp.team.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.confbean.TeamConsts;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Procedure;
/*     */ import xtable.Basic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PInviteTeamRep
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long inviter;
/*     */   private final long invitee;
/*     */   private final long sessionid;
/*     */   private final int reply;
/*     */   
/*     */   public PInviteTeamRep(long inviter, long invitee, long sessionid, int reply)
/*     */   {
/*  32 */     this.inviter = inviter;
/*  33 */     this.invitee = invitee;
/*  34 */     this.sessionid = sessionid;
/*  35 */     this.reply = reply;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!RoleStatusInterface.checkCanSetStatus(this.invitee, 395, true))
/*     */     {
/*  43 */       GameServer.logger().info(String.format("[team]PApplyTeamByMemberReq.processImp@ can not answer invite!|roleId=%d", new Object[] { Long.valueOf(this.invitee) }));
/*     */       
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     Session session = Session.getSession(this.sessionid);
/*  49 */     if ((session == null) || (!(session instanceof InviteTeamSession)))
/*     */     {
/*  51 */       TeamManager.sendNormalResult(this.invitee, 13, new String[0]);
/*  52 */       return false;
/*     */     }
/*  54 */     InviteTeamSession inviteSession = (InviteTeamSession)session;
/*  55 */     if ((inviteSession.getInviter() != this.inviter) || (inviteSession.getInvitee() != this.invitee))
/*     */     {
/*  57 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  61 */     if (TeamInterface.isRoleInTeam(this.invitee, false))
/*     */     {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     Set<Long> lockRoles = new HashSet();
/*  67 */     lockRoles.add(Long.valueOf(this.inviter));
/*  68 */     lockRoles.add(Long.valueOf(this.invitee));
/*     */     
/*  70 */     Long teamid = null;
/*  71 */     xbean.Team xTeam = null;
/*     */     
/*  73 */     if (inviteSession.getTeamid() > 0L)
/*     */     {
/*  75 */       teamid = Long.valueOf(inviteSession.getTeamid());
/*  76 */       xTeam = xtable.Team.select(teamid);
/*     */       
/*     */ 
/*  79 */       if (xTeam == null)
/*     */       {
/*     */ 
/*  82 */         TeamManager.sendNormalResult(this.invitee, 33, new String[0]);
/*  83 */         return false;
/*     */       }
/*     */       
/*  86 */       lockRoles.addAll(TeamManager.getMemberListByXTeam(xTeam));
/*     */       
/*  88 */       lock(Basic.getTable(), lockRoles);
/*     */       
/*  90 */       xTeam = TeamManager.getXTeam(teamid.longValue(), true);
/*  91 */       if (xTeam == null)
/*     */       {
/*  93 */         return false;
/*     */       }
/*  95 */       List<Long> members = TeamManager.getMemberListByXTeam(xTeam);
/*  96 */       if (!lockRoles.containsAll(members))
/*     */       {
/*  98 */         return false;
/*     */       }
/*     */       
/* 101 */       if (TeamInterface.isRoleInTeam(this.invitee, true))
/*     */       {
/* 103 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 107 */       boolean isInTeam = TeamManager.isInTeam(this.inviter, xTeam);
/*     */       
/* 109 */       if (this.reply == 1)
/*     */       {
/*     */ 
/*     */ 
/* 113 */         if (!isInTeam)
/*     */         {
/*     */ 
/* 116 */           TeamManager.sendNormalResult(this.invitee, 33, new String[0]);
/* 117 */           return false;
/*     */         }
/*     */         
/* 120 */         if (TeamManager.isLeader(this.inviter, xTeam))
/*     */         {
/*     */ 
/* 123 */           if (TeamManager.isTeamFull(xTeam))
/*     */           {
/* 125 */             TeamManager.sendNormalResult(this.invitee, 14, new String[0]);
/* 126 */             return false;
/*     */           }
/* 128 */           if (!OnlineManager.getInstance().isOnline(this.invitee))
/*     */           {
/*     */ 
/* 131 */             return false;
/*     */           }
/* 133 */           if (!TeamManager.onRoleJoinTeam(teamid.longValue(), xTeam, this.invitee, JoinTeamType.JOIN_TEAM__INVITE))
/*     */           {
/* 135 */             return false;
/*     */           }
/*     */           
/* 138 */           if (TeamManager.removeApplicant(teamid.longValue(), xTeam, this.invitee))
/*     */           {
/*     */ 
/* 141 */             Procedure.execute(new PSyncApplicantsToAll(teamid.longValue()));
/*     */           }
/*     */           
/*     */         }
/*     */         else
/*     */         {
/* 147 */           if (xTeam.getApplicants().size() >= TeamConsts.getInstance().APPLY_CAPACITY)
/*     */           {
/*     */ 
/* 150 */             TeamManager.changeWhenApplicantListFull(xTeam);
/*     */           }
/* 152 */           TeamManager.addApplyList(teamid.longValue(), xTeam, this.invitee, this.inviter);
/*     */           
/* 154 */           TeamManager.sendNormalResult(this.invitee, 22, new String[0]);
/*     */         }
/*     */         
/*     */ 
/*     */       }
/* 159 */       else if (isInTeam)
/*     */       {
/* 161 */         TeamManager.sendNormalResult(this.inviter, 12, new String[] { RoleInterface.getName(this.invitee) });
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 171 */       if (isInTeam)
/*     */       {
/* 173 */         TeamManager.removeInvitee(this.invitee, TeamManager.getXMember(xTeam, this.inviter));
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 180 */       return false;
/*     */     }
/*     */     
/* 183 */     TeamLogManager.logReplyInvite(this.invitee, this.inviter, this.reply);
/*     */     
/* 185 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PInviteTeamRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */