/*     */ package mzm.gsp.team.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.team.TeamMemberInfo;
/*     */ import mzm.gsp.team.confbean.TeamConsts;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xdb.Procedure;
/*     */ import xio.Protocol;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TeamInterface
/*     */ {
/*     */   public static void formatCreateTeamAsTmpLeave(long bussinessId, List<Long> templetMembers)
/*     */   {
/*  32 */     PFormatTeam.getInstance().formatCreateTeamAsTmpLeave(bussinessId, templetMembers);
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
/*     */   private static void formatCreateTeam(long bussinessId, List<Long> templetMembers)
/*     */   {
/*  49 */     PFormatTeam.getInstance().formatCreateTeamInCondition(bussinessId, templetMembers);
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
/*     */   public static boolean createTeam(long roleId)
/*     */   {
/*  63 */     return TeamManager.createTeam(roleId);
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
/*     */   public static boolean appointLeader(long teamId, long roleId)
/*     */   {
/*  79 */     return TeamManagerForInterSerVice.appointLeader(teamId, roleId);
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
/*     */   public static boolean designTeam(long teamId, List<Long> templetMembers)
/*     */   {
/*  95 */     return TeamManagerForInterSerVice.designTeam(teamId, templetMembers);
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
/*     */   public static void returnTeam(long roleId)
/*     */   {
/* 109 */     ReturnTeamManager.onReturnTeam(roleId);
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
/*     */   public static TeamInfo getTeamInfo(long teamId, boolean isRemainTeamLock)
/*     */   {
/* 124 */     TeamInfo teamInfo = new TeamInfo(teamId, isRemainTeamLock);
/* 125 */     if (!teamInfo.isTeamExist())
/*     */     {
/* 127 */       return null;
/*     */     }
/* 129 */     return teamInfo;
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
/*     */   public static TeamInfo getTeamInfoByRoleId(long roleId)
/*     */   {
/* 142 */     return TeamManager.getTeamInfoByRoleIdImpl(roleId);
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
/*     */   public static boolean isAllTeamMemberNormal(long teamId, boolean remainTeamLock)
/*     */   {
/* 157 */     return TeamManager.isAllTeamMemberNormalImpl(teamId, remainTeamLock);
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
/*     */   public static Long getTeamidByRoleid(long roleid, boolean remainLock)
/*     */   {
/* 172 */     Long teamid = null;
/* 173 */     if (remainLock)
/*     */     {
/* 175 */       teamid = Role2team.get(Long.valueOf(roleid));
/*     */     }
/*     */     else
/*     */     {
/* 179 */       teamid = Role2team.select(Long.valueOf(roleid));
/*     */     }
/* 181 */     return teamid;
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
/*     */   public static boolean activeDismissTeamSyn(long teamId)
/*     */   {
/* 195 */     return new ActiveDismissTeam(teamId).call();
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
/*     */   public static void activeDismissTeamAsyn(long teamId)
/*     */   {
/* 208 */     Procedure.execute(new ActiveDismissTeam(teamId));
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
/*     */   public static boolean isRoleInTeam(long roleid, boolean remainLock)
/*     */   {
/* 223 */     return getTeamidByRoleid(roleid, remainLock) != null;
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
/*     */   public static List<Long> getTeamMemberList(long teamid, boolean remainLock)
/*     */   {
/* 238 */     xbean.Team xTeam = TeamManager.getXTeam(teamid, remainLock);
/* 239 */     return TeamManager.getMemberListByXTeam(xTeam);
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
/*     */   public static int getTeamMemberCount(long teamid, boolean remainLock)
/*     */   {
/* 254 */     xbean.Team xTeam = TeamManager.getXTeam(teamid, remainLock);
/* 255 */     if (xTeam == null)
/*     */     {
/* 257 */       return -1;
/*     */     }
/* 259 */     return TeamManager.getMemberListByXTeam(xTeam).size();
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
/*     */   public static long getTeamLeaderByTeamid(long teamid, boolean remainLock)
/*     */   {
/* 274 */     xbean.Team xTeam = TeamManager.getXTeam(teamid, remainLock);
/* 275 */     if ((xTeam != null) && (!xTeam.getMembers().isEmpty()))
/*     */     {
/* 277 */       return TeamManager.getLearder(xTeam);
/*     */     }
/* 279 */     return -1L;
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
/*     */   public static long getTeamLeaderByRoleid(long roleid, boolean remainRoleLock, boolean remainTeamLock)
/*     */   {
/* 296 */     Long teamid = getTeamidByRoleid(roleid, remainRoleLock);
/* 297 */     if (teamid == null)
/*     */     {
/* 299 */       return -1L;
/*     */     }
/* 301 */     return getTeamLeaderByTeamid(teamid.longValue(), remainTeamLock);
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
/*     */   public static boolean isTeamLeader(long teamId, long roleId, boolean remainTeamLock)
/*     */   {
/* 319 */     long leaderId = getTeamLeaderByTeamid(teamId, remainTeamLock);
/* 320 */     return roleId == leaderId;
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
/*     */   public static boolean isTeamExit(long teamId, boolean remainTeamLock)
/*     */   {
/* 336 */     return TeamManager.getXTeam(teamId, remainTeamLock) != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getTeamCapacity()
/*     */   {
/* 346 */     return TeamConsts.getInstance().TEAM_CAPACITY;
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
/*     */   public static int getTeamMemberStatus(long roleid)
/*     */   {
/* 359 */     xbean.Team xTeam = TeamManager.getXTeamByRoleid(roleid, false);
/* 360 */     if (xTeam == null)
/*     */     {
/* 362 */       return -1;
/*     */     }
/* 364 */     return TeamManager.getTeamMemberStatus(roleid, xTeam);
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
/*     */   public static boolean isTeamMemberNormal(long roleId)
/*     */   {
/* 377 */     int state = getTeamMemberStatus(roleId);
/* 378 */     return state == 0;
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
/*     */   public static boolean isStableTeam(long teamid, boolean remainLock)
/*     */   {
/* 394 */     xbean.Team xTeam = TeamManager.getXTeam(teamid, remainLock);
/* 395 */     if ((xTeam != null) && (!xTeam.getMembers().isEmpty()))
/*     */     {
/* 397 */       return TeamManager.isStableTeam(xTeam).booleanValue();
/*     */     }
/* 399 */     return false;
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
/*     */   public static TeamDispositionInfo getTeamDispositionInfo(long teamid)
/*     */   {
/* 414 */     return TeamManager.getTeamDispInfo(teamid);
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
/*     */   public static Map<Integer, TeamDpMember> getZhanWeiInfo(long leaderId, boolean remainLock)
/*     */   {
/* 429 */     return TeamManager.getZhanWeiInfoImpl(Long.valueOf(leaderId), remainLock);
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
/*     */   public static List<Long> getTeamMembersDispositionByLeaderId(long memberId)
/*     */   {
/* 442 */     return TeamManager.getTeamMembersDispositionByMemberId(memberId);
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
/*     */   public static int getZhenFaId(long teamLeaderId, boolean remainLock)
/*     */   {
/* 457 */     return TeamManager.getZhenFaIdImpl(teamLeaderId, remainLock);
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
/*     */   public static List<Long> getNormalRoleList(long roleId)
/*     */   {
/* 470 */     return TeamManager.getTeamMembersDispositionByMemberId(roleId);
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
/*     */   public static void broadcastInTeam(long teamId, Protocol pro)
/*     */   {
/* 484 */     xbean.Team xTeam = xtable.Team.select(Long.valueOf(teamId));
/* 485 */     if (xTeam == null)
/*     */     {
/* 487 */       return;
/*     */     }
/* 489 */     TeamManager.broadcast(xTeam, pro);
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
/*     */   public static void forceTmpLeaveTeamAsyn(long roleId)
/*     */   {
/* 502 */     Procedure.execute(new PForceTmpLeaveTeam(roleId));
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
/*     */   public static boolean forceTmpLeaveTeam(long roleId)
/*     */   {
/* 515 */     return TeamManager.forceTmpLeaveTeam(roleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void leaveTeamNoneRealTime(long roleId)
/*     */   {
/* 527 */     NoneRealTimeTaskManager.getInstance().addTask(new PForceLeaveTeam(roleId));
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
/*     */   public static boolean leaveTeam(long roleId)
/*     */   {
/* 540 */     LogicProcedure p = new PForceLeaveTeam(roleId);
/* 541 */     return p.call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void registerJoinTeam(long worldId, JoinTeamCheckHandler joinTeamCheckHandler)
/*     */   {
/* 552 */     TeamManager.registerJoinTeamImpl(worldId, joinTeamCheckHandler);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean unRegisterJoinTeam(long worldId)
/*     */   {
/* 563 */     return TeamManager.unRegisterJoinTeamImpl(worldId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void registerReturnTeam(long worldId, ReturnTeamCheckHandler returnTeamCheckHandler)
/*     */   {
/* 574 */     TeamManager.registerReturnTeamImpl(worldId, returnTeamCheckHandler);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean unRegisterReturnTeam(long worldId)
/*     */   {
/* 585 */     return TeamManager.unRegisterReturnTeamImpl(worldId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void registerActivityTeam(long worldId, ActivityTeamHandler activityTeamHandler)
/*     */   {
/* 597 */     TeamManager.registerActivityTeamImpl(worldId, activityTeamHandler);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean unRegisterActivityTeam(long worldId)
/*     */   {
/* 608 */     return TeamManager.unRegisterActivityTeamImpl(worldId);
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
/*     */   public static int getOccupationNumInTeam(long teamId, int occupation)
/*     */   {
/* 624 */     return TeamManager.getOccupationNumInTeamImpl(teamId, occupation);
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
/*     */   public static void rolesJoinTeamByLeaderId(long leaderId, List<Long> members, int matchCfgId)
/*     */   {
/* 638 */     Procedure.execute(new PRolesJoinTeamByLeaderId(leaderId, members, matchCfgId));
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
/*     */   public static void roleTryJoinTeamByLeaders(long roleId, List<Long> leaderIds)
/*     */   {
/* 652 */     Procedure.execute(new PRoleTryJoinTeamByLeaders(roleId, leaderIds));
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
/*     */   public static boolean isTeamFromPlatform(long teamId)
/*     */   {
/* 665 */     xbean.Team xTeam = xtable.Team.select(Long.valueOf(teamId));
/* 666 */     if (xTeam == null)
/*     */     {
/* 668 */       return false;
/*     */     }
/* 670 */     return xTeam.getIsfromplatform();
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
/*     */   public static void fillTeamMemberInfo(long memberId, TeamMemberInfo teamMemberInfo)
/*     */   {
/* 683 */     TeamManager.fillTeamMemberInfo(Long.valueOf(memberId), teamMemberInfo);
/*     */   }
/*     */   
/*     */   public static void sendTeamNormalMsg(long roleid, int result, String... args)
/*     */   {
/* 688 */     TeamManager.sendNormalResult(roleid, result, args);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\TeamInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */