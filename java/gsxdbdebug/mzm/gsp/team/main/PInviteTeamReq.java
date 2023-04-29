/*     */ package mzm.gsp.team.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*     */ import mzm.gsp.avatar.main.AvatarInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.SInviteTeamTrs;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.SNSTYPE;
/*     */ import mzm.gsp.tlog.SnsFlowArg;
/*     */ import mzm.gsp.tlog.TlogUtil;
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
/*     */ public class PInviteTeamReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long invitee;
/*     */   
/*     */   public PInviteTeamReq(long roleid, long invitee)
/*     */   {
/*  37 */     this.roleid = roleid;
/*  38 */     this.invitee = invitee;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if (this.roleid == this.invitee)
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  51 */     if ((this.roleid < 0L) || (this.invitee < 0L))
/*     */     {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     if (!TeamManager.canInviteRole(this.roleid, this.invitee))
/*     */     {
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     xbean.Team xTeam = null;
/*  62 */     Long teamid = Role2team.select(Long.valueOf(this.roleid));
/*  63 */     Set<Long> lockRoles = new HashSet();
/*  64 */     lockRoles.addAll(Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(this.invitee) }));
/*  65 */     lock(Basic.getTable(), lockRoles);
/*     */     
/*     */ 
/*  68 */     if (teamid != null)
/*     */     {
/*  70 */       xTeam = xtable.Team.get(teamid);
/*     */     }
/*     */     else
/*     */     {
/*  74 */       TeamCreatInfo teamInfo = TeamManager.createTeam(Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*  75 */       if (teamInfo == null)
/*     */       {
/*  77 */         return false;
/*     */       }
/*  79 */       teamid = Long.valueOf(teamInfo.teamid);
/*  80 */       xTeam = teamInfo.xTeam;
/*     */     }
/*     */     
/*  83 */     if (!canActiveInviteInStatus(this.roleid))
/*     */     {
/*  85 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  89 */     if (TeamManager.isTeamFull(xTeam))
/*     */     {
/*  91 */       TeamManager.sendNormalResult(this.roleid, 31, new String[0]);
/*  92 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  96 */     if (!TeamManager.isRoleOnline(this.invitee).booleanValue())
/*     */     {
/*  98 */       TeamManager.sendNormalResult(this.roleid, 3, new String[] { RoleInterface.getName(this.invitee) });
/*     */       
/* 100 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 104 */     TeamMember xMember = TeamManager.getXMember(xTeam, this.roleid);
/* 105 */     if (TeamManager.isInInvitees(this.invitee, xMember))
/*     */     {
/* 107 */       TeamManager.sendNormalResult(this.roleid, 15, new String[] { RoleInterface.getName(this.invitee) });
/*     */       
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     if ((teamid != null) && (TeamManager.isInApplyList(this.invitee, xTeam)))
/*     */     {
/* 114 */       TeamManager.sendNormalResult(this.roleid, 5, new String[] { RoleInterface.getName(this.invitee) });
/*     */       
/* 116 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 120 */     if (TeamInterface.isRoleInTeam(this.invitee, false))
/*     */     {
/* 122 */       if (TeamManager.isRoleInSameTeam(this.roleid, this.invitee, false).booleanValue())
/*     */       {
/* 124 */         TeamManager.sendNormalResult(this.roleid, 4, new String[] { RoleInterface.getName(this.invitee) });
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 129 */         TeamManager.sendNormalResult(this.roleid, 1, new String[] { RoleInterface.getName(this.invitee) });
/*     */       }
/*     */       
/* 132 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 140 */     Session session = null;
/* 141 */     if (teamid != null)
/*     */     {
/* 143 */       session = new InviteTeamSession(this.roleid, this.invitee, teamid.longValue());
/*     */     }
/*     */     else
/*     */     {
/* 147 */       session = new InviteTeamSession(this.roleid, this.invitee);
/*     */     }
/*     */     
/* 150 */     SInviteTeamTrs trs = new SInviteTeamTrs();
/*     */     
/* 152 */     Role role = RoleInterface.getRole(this.roleid, false);
/* 153 */     trs.inviter = this.roleid;
/* 154 */     trs.name = role.getName();
/* 155 */     trs.level = role.getLevel();
/* 156 */     trs.menpai = role.getOccupationId();
/* 157 */     trs.gender = role.getGender();
/* 158 */     trs.avatarid = AvatarInterface.getCurrentAvatar(this.roleid, false);
/* 159 */     trs.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(this.roleid, false);
/* 160 */     trs.sessionid = session.getSessionId();
/*     */     
/* 162 */     OnlineManager.getInstance().sendAtOnce(this.invitee, trs);
/*     */     
/*     */ 
/* 165 */     TeamManager.sendNormalResult(this.roleid, 2, new String[] { RoleInterface.getName(this.invitee) });
/*     */     
/*     */ 
/* 168 */     TeamManager.addInInvitee(this.invitee, xMember);
/*     */     
/*     */ 
/* 171 */     logInvite(teamid);
/*     */     
/* 173 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void logInvite(Long teamid)
/*     */   {
/* 183 */     addInviteTLog();
/*     */     
/* 185 */     int inviterType = -1;
/* 186 */     if (TeamInterface.isTeamLeader(teamid.longValue(), this.roleid, false))
/*     */     {
/* 188 */       inviterType = 1;
/*     */     }
/*     */     else
/*     */     {
/* 192 */       inviterType = 2;
/*     */     }
/* 194 */     TeamLogManager.logInviteOther(this.roleid, this.invitee, inviterType);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void addInviteTLog()
/*     */   {
/* 202 */     SnsFlowArg tArg = new SnsFlowArg();
/* 203 */     tArg.setType(SNSTYPE.SNSTYPE_INVITE);
/* 204 */     TlogUtil.tlogSnsFlow(this.roleid, 1, 0, tArg);
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
/*     */   private boolean canActiveInviteInStatus(long roleId)
/*     */   {
/* 218 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, 49, true))
/*     */     {
/* 220 */       GameServer.logger().error(String.format("[team]PInviteTeamReq.canActiveInviteInStatus@ active invite other is forbiddened!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*     */ 
/* 224 */       return false;
/*     */     }
/* 226 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PInviteTeamReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */