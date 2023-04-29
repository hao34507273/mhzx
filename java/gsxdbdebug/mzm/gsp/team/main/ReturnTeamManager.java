/*     */ package mzm.gsp.team.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.team.SMemberReturnBrd;
/*     */ import mzm.gsp.team.confbean.TeamConsts;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.TeamMember;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Procedure;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2team;
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
/*     */ public class ReturnTeamManager
/*     */ {
/*     */   static boolean returnTeamInCondition(long roleId)
/*     */   {
/*  32 */     if (!canReturnDirectly(roleId))
/*     */     {
/*  34 */       return false;
/*     */     }
/*  36 */     return onReturnTeam(roleId);
/*     */   }
/*     */   
/*     */   private static boolean canReturnDirectly(long roleId)
/*     */   {
/*  41 */     Long teamid = Role2team.select(Long.valueOf(roleId));
/*  42 */     if (teamid == null)
/*     */     {
/*  44 */       GameServer.logger().error(String.format("[team]ReturnTeamManager.canReturnDirectly@ role not in team!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/*  46 */       return false;
/*     */     }
/*  48 */     xbean.Team xTeam = xtable.Team.select(teamid);
/*  49 */     if (xTeam == null)
/*     */     {
/*  51 */       GameServer.logger().error(String.format("[team]ReturnTeamManager.canReturnDirectly@ role not in team!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     long leaderId = TeamManager.getLearder(xTeam);
/*  57 */     if (TeamManager.isLeaderInHomeLandButNotMember(leaderId, roleId))
/*     */     {
/*     */ 
/*  60 */       transformIntoHomeland(leaderId, roleId);
/*  61 */       GameServer.logger().info(String.format("[team]ReturnTeamManager.canReturnDirectly@ need go into homeland before return!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*  64 */       return false;
/*     */     }
/*  66 */     return true;
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
/*     */   static void transformIntoHomeland(long leaderId, long roleId)
/*     */   {
/*  79 */     Procedure.execute(new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  85 */         long worldId = MapInterface.getRoleWorldInstanceId(this.val$leaderId);
/*  86 */         if (worldId < 0L)
/*     */         {
/*  88 */           return false;
/*     */         }
/*  90 */         long masterId = HomelandInterface.getRoleByHomeWorldId(worldId, false);
/*  91 */         if (masterId < 0L)
/*     */         {
/*  93 */           return false;
/*     */         }
/*  95 */         HomelandInterface.transferHome(masterId, this.val$roleId, new HomeReturnHandler(this.val$roleId));
/*  96 */         return true;
/*     */       }
/*     */     });
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
/*     */   static boolean onReturnTeam(long roleId)
/*     */   {
/* 112 */     Long teamid = Role2team.select(Long.valueOf(roleId));
/* 113 */     if (teamid == null)
/*     */     {
/* 115 */       GameServer.logger().error(String.format("[team]TeamManager.onReturnTeam@ role not in team!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/* 116 */       return false;
/*     */     }
/* 118 */     xbean.Team xTeam = xtable.Team.select(teamid);
/* 119 */     if (xTeam == null)
/*     */     {
/* 121 */       GameServer.logger().error(String.format("[team]TeamManager.onReturnTeam@ role not in team, but team is not exist!|roleId=%d|teamId=%d", new Object[] { Long.valueOf(roleId), teamid }));
/*     */       
/*     */ 
/*     */ 
/* 125 */       return false;
/*     */     }
/* 127 */     List<Long> members = TeamManager.getMemberListByXTeam(xTeam);
/*     */     
/* 129 */     Lockeys.lock(Basic.getTable(), members);
/*     */     
/* 131 */     xTeam = xtable.Team.get(teamid);
/* 132 */     if (!reCheckLock(xTeam, members))
/*     */     {
/* 134 */       GameServer.logger().error(String.format("[team]TeamManager.onReturnTeam@ recheck team lock err!|roleId=%d|teamId=%d", new Object[] { Long.valueOf(roleId), teamid }));
/*     */       
/* 136 */       return false;
/*     */     }
/* 138 */     long leaderId = TeamManager.getLearder(xTeam);
/* 139 */     if (leaderId <= 0L)
/*     */     {
/* 141 */       GameServer.logger().error(String.format("[team]TeamManager.onReturnTeam@ get leaderId err!|roleId=%d|teamId=%d", new Object[] { Long.valueOf(roleId), teamid }));
/*     */       
/* 143 */       return false;
/*     */     }
/* 145 */     TeamMember xTeamMember = TeamManager.getXMember(xTeam, roleId);
/* 146 */     if (xTeamMember.getStatus() != 1)
/*     */     {
/* 148 */       GameServer.logger().error(String.format("[team]TeamManager.onReturnTeam@ role is not ST_TMP_LEAVE!|roleId=%d|status=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(xTeamMember.getStatus()) }));
/*     */       
/*     */ 
/* 151 */       return false;
/*     */     }
/* 153 */     return onRoleReturn(roleId, teamid.longValue(), xTeam, leaderId, xTeamMember);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean reCheckLock(xbean.Team xTeam, List<Long> members)
/*     */   {
/* 165 */     if (xTeam == null)
/*     */     {
/* 167 */       GameServer.logger().error(String.format("[team]TeamManager.reCheckLock@ xteam not exist!|members=%s", new Object[] { members.toString() }));
/*     */       
/* 169 */       return false;
/*     */     }
/* 171 */     List<Long> tmpMembers = TeamManager.getMemberListByXTeam(xTeam);
/* 172 */     if ((tmpMembers.size() != members.size()) || (!tmpMembers.containsAll(members)))
/*     */     {
/* 174 */       GameServer.logger().error(String.format("[team]TeamManager.reCheckLock@ members not equal!|members=%s|tmpMembers=%s", new Object[] { members.toString(), tmpMembers.toString() }));
/*     */       
/*     */ 
/* 177 */       return false;
/*     */     }
/* 179 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean onRoleReturn(long roleid, long teamid, xbean.Team xTeam, long leaderId, TeamMember xTeamMember)
/*     */   {
/* 189 */     RoleJoinState state = TeamManager.checkRoleReturnState(roleid, leaderId);
/* 190 */     if (GameServer.logger().isDebugEnabled())
/*     */     {
/* 192 */       GameServer.logger().debug(String.format("[team]TeamManager.onRoleReturn@ RoleJoinState |roleId=%d|teamId=%d|leaderId=%d|info=%s", new Object[] { Long.valueOf(roleid), Long.valueOf(teamid), Long.valueOf(leaderId), state.toString() }));
/*     */     }
/*     */     
/*     */ 
/* 196 */     if ((state.getState() == 0) || (state.needTF2Leader()))
/*     */     {
/* 198 */       return roleReturn(roleid, teamid, xTeam, leaderId, xTeamMember, state);
/*     */     }
/* 200 */     return onCannotReturn(leaderId, xTeamMember, state);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean onCannotReturn(long leaderId, TeamMember xTeamMember, RoleJoinState state)
/*     */   {
/* 208 */     if (state.getTempState() != 6)
/*     */     {
/* 210 */       return false;
/*     */     }
/* 212 */     xTeamMember.setTempstatus(state.getTempState());
/* 213 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean roleReturn(long roleid, long teamid, xbean.Team xTeam, long leaderId, TeamMember xTeamMember, RoleJoinState state)
/*     */   {
/* 225 */     if (!TeamManager.checkRoleCanReturn(roleid, leaderId, teamid, xTeam))
/*     */     {
/* 227 */       GameServer.logger().error(String.format("[team]teamManager.roleReturn@ checkRoleCanReturn err!|roleId=%d|teamId=%d|leaderId=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(teamid), Long.valueOf(leaderId) }));
/*     */       
/*     */ 
/* 230 */       return false;
/*     */     }
/* 232 */     if (state.needTF2Leader())
/*     */     {
/* 234 */       xTeamMember.setTempstatus(state.getTempState());
/* 235 */       TeamManager.transformToLeader(roleid, leaderId);
/* 236 */       return true;
/*     */     }
/* 238 */     if (!TeamManager.changeMemberStatus(teamid, xTeam, roleid, 0, false))
/*     */     {
/* 240 */       GameServer.logger().error(String.format("[team]teamManager.roleReturn@ changeMemberStatus err!|roleId=%d|teamId=%d|leaderId=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(teamid), Long.valueOf(leaderId) }));
/*     */       
/*     */ 
/* 243 */       return false;
/*     */     }
/* 245 */     afterReturnTeam(roleid, Long.valueOf(teamid), xTeam, xTeamMember);
/* 246 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void afterReturnTeam(long roleid, Long teamid, xbean.Team xTeam, TeamMember xTeamMember)
/*     */   {
/* 255 */     TeamManager.triggerMemberStatusChangeEvent(teamid.longValue(), xTeam, roleid, 1, 0, false, false);
/*     */     
/*     */ 
/* 258 */     noticeRoleReturn(roleid, xTeam);
/*     */     
/* 260 */     resetTempState(xTeamMember);
/*     */     
/* 262 */     checkTeamStable(teamid, xTeam);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void checkTeamStable(Long teamid, xbean.Team xTeam)
/*     */   {
/* 273 */     List<Long> teamerList = TeamManager.getNormalMemberListByXTeam(xTeam);
/* 274 */     if ((TeamManager.isStableTeam(xTeam).booleanValue()) && (teamerList.size() == TeamManager.teamConsts.TEAM_CAPACITY))
/*     */     {
/* 276 */       TeamManager.triggerStableTeamChangeEvent(teamerList, teamid.longValue(), true);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void resetTempState(TeamMember xTeamMember)
/*     */   {
/* 287 */     if (xTeamMember.getTempstatus() == 0)
/*     */     {
/* 289 */       return;
/*     */     }
/* 291 */     xTeamMember.setTempstatus(0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void noticeRoleReturn(long roleid, xbean.Team xTeam)
/*     */   {
/* 301 */     SMemberReturnBrd sMemberReturnBrd = new SMemberReturnBrd();
/* 302 */     sMemberReturnBrd.roleid = roleid;
/* 303 */     TeamManager.broadcast(xTeam, sMemberReturnBrd);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\ReturnTeamManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */