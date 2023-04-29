/*     */ package mzm.gsp.crosscompete.roam;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.ActivityTeamHandler;
/*     */ import mzm.gsp.team.main.JoinTeamCheckHandler;
/*     */ import mzm.gsp.team.main.JoinTeamResult;
/*     */ import mzm.gsp.team.main.JoinTeamResult.Receiver;
/*     */ import mzm.gsp.team.main.JoinTeamResult.Result;
/*     */ import mzm.gsp.team.main.JoinTeamType;
/*     */ import mzm.gsp.team.main.ReturnTeamResult;
/*     */ import mzm.gsp.team.main.ReturnTeamResult.Result;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import xbean.RoamCrossCompeteRole;
/*     */ 
/*     */ 
/*     */ class CrossCompeteTeamHandler
/*     */   implements JoinTeamCheckHandler, ActivityTeamHandler
/*     */ {
/*  26 */   static final CrossCompeteTeamHandler instance = new CrossCompeteTeamHandler();
/*     */   
/*     */ 
/*     */   public JoinTeamResult canJoinTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId, boolean tf2LeaderAftJoin, JoinTeamType joinTeamType)
/*     */   {
/*  31 */     JoinTeamResult result = new JoinTeamResult();
/*  32 */     result.setSucceed(false);
/*     */     
/*  34 */     if (leaderWorldId != roleWorldId) {
/*  35 */       switch (joinTeamType) {
/*     */       case JOIN_TEAM__INVITE: 
/*  37 */         result.addResult(JoinTeamResult.Receiver.Member, new JoinTeamResult.Result(8202, new String[0]));
/*     */         
/*  39 */         break;
/*     */       case JOIN_TEAM__APPLY: 
/*  41 */         result.addResult(JoinTeamResult.Receiver.Leader, new JoinTeamResult.Result(8203, new String[] { RoleInterface.getName(roleId) }));
/*     */         
/*     */ 
/*  44 */         break;
/*     */       case JOIN_TEAM__PLATFORM: 
/*     */         break;
/*     */       
/*     */       default: 
/*  49 */         CrossCompeteManager.logError("CrossCompteTeamHandler.canJoinTeam@unhandled join team type|join_team_type=%d", new Object[] { Integer.valueOf(joinTeamType.ordinal()) });
/*     */       }
/*     */       
/*     */       
/*     */ 
/*     */ 
/*  55 */       return result;
/*     */     }
/*     */     
/*     */ 
/*  59 */     RoamCrossCompeteRole xLeaderRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(teamInfo.getLeaderId(), false);
/*     */     
/*  61 */     RoamCrossCompeteRole xMemberRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(roleId, false);
/*  62 */     if ((xLeaderRole == null) || (xMemberRole == null) || (xLeaderRole.getFactionid() != xMemberRole.getFactionid())) {
/*  63 */       switch (joinTeamType) {
/*     */       case JOIN_TEAM__INVITE: 
/*  65 */         result.addResult(JoinTeamResult.Receiver.Member, new JoinTeamResult.Result(130, new String[0]));
/*     */         
/*  67 */         break;
/*     */       case JOIN_TEAM__APPLY: 
/*  69 */         result.addResult(JoinTeamResult.Receiver.Leader, new JoinTeamResult.Result(131, new String[] { RoleInterface.getName(roleId) }));
/*     */         
/*     */ 
/*  72 */         break;
/*     */       case JOIN_TEAM__PLATFORM: 
/*     */         break;
/*     */       
/*     */       default: 
/*  77 */         CrossCompeteManager.logError("CrossCompteTeamHandler.canJoinTeam@unhandled join team type|join_team_type=%d", new Object[] { Integer.valueOf(joinTeamType.ordinal()) });
/*     */       }
/*     */       
/*     */       
/*     */ 
/*     */ 
/*  83 */       return result;
/*     */     }
/*     */     
/*  86 */     result.setSucceed(true);
/*  87 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ReturnTeamResult canReturnTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId)
/*     */   {
/*  94 */     ReturnTeamResult result = new ReturnTeamResult();
/*  95 */     result.setSucceed(false);
/*     */     
/*  97 */     if (leaderWorldId != roleWorldId) {
/*  98 */       result.setResult(new ReturnTeamResult.Result(3010, new String[0]));
/*     */       
/*     */ 
/* 101 */       return result;
/*     */     }
/*     */     
/*     */ 
/* 105 */     RoamCrossCompeteRole xLeaderRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(teamInfo.getLeaderId(), false);
/*     */     
/* 107 */     RoamCrossCompeteRole xMemberRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(roleId, false);
/* 108 */     if ((xLeaderRole == null) || (xMemberRole == null) || (xLeaderRole.getFactionid() != xMemberRole.getFactionid())) {
/* 109 */       result.setResult(new ReturnTeamResult.Result(3011, new String[0]));
/*     */       
/* 111 */       return result;
/*     */     }
/*     */     
/* 114 */     result.setSucceed(true);
/* 115 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> findTeams(long roleId, long worldId)
/*     */   {
/* 122 */     List<Long> selectTeams = new ArrayList();
/*     */     
/* 124 */     RoamCrossCompeteRole xRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(roleId, false);
/* 125 */     if (xRole == null) {
/* 126 */       return selectTeams;
/*     */     }
/*     */     
/*     */ 
/* 130 */     Collection<Long> allTeams = MapInterface.getAllTeamInWorld(worldId);
/* 131 */     for (Iterator i$ = allTeams.iterator(); i$.hasNext();) { long teamid = ((Long)i$.next()).longValue();
/*     */       
/* 133 */       TeamInfo team = TeamInterface.getTeamInfo(teamid, false);
/* 134 */       if ((team != null) && 
/*     */       
/*     */ 
/* 137 */         (!team.isRoleInTeam(roleId)))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 142 */         RoamCrossCompeteRole xLeaderRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(team.getLeaderId(), false);
/*     */         
/* 144 */         if ((xLeaderRole != null) && (xLeaderRole.getFactionid() == xRole.getFactionid()))
/*     */         {
/*     */ 
/*     */ 
/* 148 */           selectTeams.add(Long.valueOf(teamid)); }
/*     */       }
/*     */     }
/* 151 */     return selectTeams;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> findMembers(long roleId, long worldId)
/*     */   {
/* 157 */     List<Long> selectRoles = new ArrayList();
/*     */     
/* 159 */     RoamCrossCompeteRole xSelfRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(roleId, false);
/* 160 */     if (xSelfRole == null) {
/* 161 */       return selectRoles;
/*     */     }
/*     */     
/*     */ 
/* 165 */     List<Long> allRoles = MapInterface.getAllSingleRoleInWorld(worldId);
/* 166 */     for (Iterator i$ = allRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 167 */       if (r != roleId)
/*     */       {
/*     */ 
/*     */ 
/* 171 */         RoamCrossCompeteRole xRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(r, false);
/* 172 */         if ((xRole != null) && (xRole.getFactionid() == xSelfRole.getFactionid()))
/*     */         {
/*     */ 
/* 175 */           selectRoles.add(Long.valueOf(r)); }
/*     */       }
/*     */     }
/* 178 */     return selectRoles;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\CrossCompeteTeamHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */