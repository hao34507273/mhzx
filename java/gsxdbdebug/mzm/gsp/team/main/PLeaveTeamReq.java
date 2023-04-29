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
/*     */ public class PLeaveTeamReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PLeaveTeamReq(long roleid)
/*     */   {
/*  23 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     Long teamid = Role2team.select(Long.valueOf(this.roleid));
/*  31 */     if (teamid == null)
/*     */     {
/*  33 */       return false;
/*     */     }
/*     */     
/*  36 */     long leaderId = TeamInterface.getTeamLeaderByRoleid(this.roleid, false, false);
/*  37 */     if (!TeamManager.canActiveLeaveTeam(this.roleid, leaderId))
/*     */     {
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     xbean.Team xTeam = xtable.Team.select(teamid);
/*     */     
/*  44 */     List<Long> members = TeamManager.getMemberListByXTeam(xTeam);
/*     */     
/*  46 */     lock(Basic.getTable(), members);
/*     */     
/*  48 */     xTeam = xtable.Team.get(teamid);
/*  49 */     if (xTeam == null)
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  55 */     List<Long> newMembers = TeamManager.getMemberListByXTeam(xTeam);
/*  56 */     if ((newMembers.size() != members.size()) || (!newMembers.containsAll(members)))
/*     */     {
/*  58 */       GameServer.logger().error(String.format("[team]PLeaveTeamReq.processImp@队伍结构反生变化，队员请求离队失败！|roleId=%d|teamId=%d|lockRoles=%s|newMembers=%s", new Object[] { Long.valueOf(this.roleid), teamid, members.toString(), newMembers.toString() }));
/*     */       
/*     */ 
/*     */ 
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     TeamMember xMember = TeamManager.getXMember(xTeam, this.roleid);
/*  66 */     if (xMember == null)
/*     */     {
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     if (!canActiveLeaveTeamInStatus(this.roleid))
/*     */     {
/*  73 */       return false;
/*     */     }
/*  75 */     if (!TeamManager.checkRoleCanChangeStatus(this.roleid, xMember, teamid.longValue(), 5))
/*     */     {
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     if (TeamManager.checkRemoveTeam(this.roleid, teamid.longValue(), xTeam))
/*     */     {
/*  82 */       TeamManager.disTeam(teamid.longValue(), xTeam);
/*  83 */       return true;
/*     */     }
/*     */     
/*  86 */     boolean leaderChange = false;
/*  87 */     if (TeamManager.isLeader(this.roleid, xTeam))
/*     */     {
/*     */ 
/*  90 */       if (!TeamManager.autoChangeLeader(teamid.longValue(), xTeam))
/*     */       {
/*  92 */         return false;
/*     */       }
/*  94 */       leaderChange = true;
/*     */     }
/*     */     
/*  97 */     int oldStatus = xMember.getStatus();
/*  98 */     if (!TeamManager.activeLeaveTeamWithEvent(teamid, xTeam, this.roleid, oldStatus, leaderChange))
/*     */     {
/* 100 */       return false;
/*     */     }
/* 102 */     return true;
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
/*     */   private boolean canActiveLeaveTeamInStatus(long roleId)
/*     */   {
/* 116 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, 45, true))
/*     */     {
/* 118 */       GameServer.logger().error(String.format("[team]PLeaveTeamReq.canActiveLeaveTeamInStatus@ active leave team is forbiddened!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*     */ 
/* 122 */       return false;
/*     */     }
/* 124 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PLeaveTeamReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */