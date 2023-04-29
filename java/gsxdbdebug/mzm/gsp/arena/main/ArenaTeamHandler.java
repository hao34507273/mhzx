/*     */ package mzm.gsp.arena.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.arena.confbean.SArenaConsts;
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
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ArenaScore;
/*     */ import xtable.Arenascore;
/*     */ 
/*     */ class ArenaTeamHandler
/*     */   implements JoinTeamCheckHandler, ActivityTeamHandler
/*     */ {
/*     */   public JoinTeamResult canJoinTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId, boolean tf2LeaderAftJoin, JoinTeamType joinTeamType)
/*     */   {
/*  30 */     JoinTeamResult result = new JoinTeamResult();
/*  31 */     result.setSucceed(false);
/*     */     
/*  33 */     if (leaderWorldId != roleWorldId) {
/*  34 */       switch (joinTeamType) {
/*     */       case JOIN_TEAM__INVITE: 
/*  36 */         result.addResult(JoinTeamResult.Receiver.Member, new JoinTeamResult.Result(110, new String[0]));
/*     */         
/*  38 */         break;
/*     */       case JOIN_TEAM__APPLY: 
/*  40 */         result.addResult(JoinTeamResult.Receiver.Leader, new JoinTeamResult.Result(111, new String[] { RoleInterface.getName(roleId) }));
/*     */         
/*     */ 
/*  43 */         break;
/*     */       case JOIN_TEAM__PLATFORM: 
/*     */         break;
/*     */       
/*     */       default: 
/*  48 */         ArenaManager.logger.error("[not same world] Unhandled JoinTeamType: " + joinTeamType);
/*     */       }
/*     */       
/*     */       
/*  52 */       return result;
/*     */     }
/*     */     
/*     */ 
/*  56 */     ArenaScore xScoreLeader = Arenascore.select(Long.valueOf(teamInfo.getLeaderId()));
/*  57 */     ArenaScore xScoreMember = Arenascore.select(Long.valueOf(roleId));
/*  58 */     if ((xScoreLeader == null) || (xScoreMember == null)) {
/*  59 */       return result;
/*     */     }
/*     */     
/*  62 */     if (xScoreLeader.getCamp() != xScoreMember.getCamp()) {
/*  63 */       switch (joinTeamType) {
/*     */       case JOIN_TEAM__INVITE: 
/*  65 */         result.addResult(JoinTeamResult.Receiver.Member, new JoinTeamResult.Result(112, new String[0]));
/*     */         
/*  67 */         break;
/*     */       case JOIN_TEAM__APPLY: 
/*  69 */         result.addResult(JoinTeamResult.Receiver.Leader, new JoinTeamResult.Result(113, new String[] { RoleInterface.getName(roleId) }));
/*     */         
/*     */ 
/*  72 */         break;
/*     */       case JOIN_TEAM__PLATFORM: 
/*     */         break;
/*     */       
/*     */       default: 
/*  77 */         ArenaManager.logger.error("[not same camp] Unhandled JoinTeamType: " + joinTeamType);
/*     */       }
/*     */       
/*     */       
/*  81 */       return result;
/*     */     }
/*     */     
/*     */ 
/*  85 */     if (teamInfo.getTeamAllMembersNum() >= ActivityInterface.getPersonCountMax(SArenaConsts.getInstance().Activityid))
/*     */     {
/*  87 */       switch (joinTeamType) {
/*     */       case JOIN_TEAM__INVITE: 
/*  89 */         result.addResult(JoinTeamResult.Receiver.Member, new JoinTeamResult.Result(114, new String[0]));
/*     */         
/*  91 */         break;
/*     */       case JOIN_TEAM__APPLY: 
/*  93 */         result.addResult(JoinTeamResult.Receiver.Leader, new JoinTeamResult.Result(115, new String[] { RoleInterface.getName(roleId) }));
/*     */         
/*     */ 
/*  96 */         break;
/*     */       case JOIN_TEAM__PLATFORM: 
/*     */         break;
/*     */       
/*     */       default: 
/* 101 */         ArenaManager.logger.error("[full] Unhandled JoinTeamType: " + joinTeamType);
/*     */       }
/*     */       
/*     */       
/*     */ 
/* 106 */       return result;
/*     */     }
/*     */     
/* 109 */     result.setSucceed(true);
/* 110 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   public ReturnTeamResult canReturnTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId)
/*     */   {
/* 116 */     ReturnTeamResult result = new ReturnTeamResult();
/* 117 */     result.setSucceed(false);
/*     */     
/* 119 */     if (leaderWorldId != roleWorldId) {
/* 120 */       result.setResult(new ReturnTeamResult.Result(3020, new String[0]));
/*     */       
/* 122 */       return result;
/*     */     }
/*     */     
/*     */ 
/* 126 */     ArenaScore xScoreLeader = Arenascore.select(Long.valueOf(teamInfo.getLeaderId()));
/* 127 */     ArenaScore xScoreMember = Arenascore.select(Long.valueOf(roleId));
/* 128 */     if ((xScoreLeader == null) || (xScoreMember == null)) {
/* 129 */       return result;
/*     */     }
/*     */     
/* 132 */     if (xScoreLeader.getCamp() != xScoreMember.getCamp()) {
/* 133 */       result.setResult(new ReturnTeamResult.Result(3021, new String[0]));
/*     */       
/* 135 */       return result;
/*     */     }
/*     */     
/*     */ 
/* 139 */     if (teamInfo.getTeamNormalMembersNum() >= ActivityInterface.getPersonCountMax(SArenaConsts.getInstance().Activityid))
/*     */     {
/* 141 */       result.setResult(new ReturnTeamResult.Result(3022, new String[0]));
/*     */       
/* 143 */       return result;
/*     */     }
/*     */     
/* 146 */     result.setSucceed(true);
/* 147 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> findTeams(long roleId, long worldId)
/*     */   {
/* 153 */     List<Long> selectTeams = new ArrayList();
/* 154 */     ArenaScore xRoleScore = Arenascore.select(Long.valueOf(roleId));
/* 155 */     if (xRoleScore == null) {
/* 156 */       return selectTeams;
/*     */     }
/*     */     
/* 159 */     int roleCamp = xRoleScore.getCamp();
/*     */     
/*     */ 
/* 162 */     Collection<Long> allTeams = MapInterface.getAllTeamInWorld(worldId);
/* 163 */     for (Iterator i$ = allTeams.iterator(); i$.hasNext();) { long teamid = ((Long)i$.next()).longValue();
/*     */       
/* 165 */       TeamInfo team = TeamInterface.getTeamInfo(teamid, false);
/* 166 */       if ((team != null) && 
/*     */       
/*     */ 
/* 169 */         (!team.isRoleInTeam(roleId)))
/*     */       {
/*     */ 
/*     */ 
/* 173 */         ArenaScore xScore = Arenascore.select(Long.valueOf(team.getLeaderId()));
/* 174 */         if ((xScore != null) && 
/*     */         
/*     */ 
/*     */ 
/* 178 */           (xScore.getCamp() == roleCamp) && 
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 183 */           (team.getTeamNormalMembersNum() < ActivityInterface.getPersonCountMax(SArenaConsts.getInstance().Activityid)))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 188 */           selectTeams.add(Long.valueOf(teamid)); }
/*     */       }
/*     */     }
/* 191 */     return selectTeams;
/*     */   }
/*     */   
/*     */   public List<Long> findMembers(long roleId, long worldId)
/*     */   {
/* 196 */     List<Long> selectRoles = new ArrayList();
/*     */     
/* 198 */     ArenaScore xRoleScore = Arenascore.select(Long.valueOf(roleId));
/* 199 */     if (xRoleScore == null) {
/* 200 */       return selectRoles;
/*     */     }
/*     */     
/* 203 */     int roleCamp = xRoleScore.getCamp();
/*     */     
/*     */ 
/* 206 */     List<Long> allRoles = MapInterface.getAllSingleRoleInWorld(worldId);
/* 207 */     for (Iterator i$ = allRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 208 */       if (r != roleId)
/*     */       {
/*     */ 
/*     */ 
/* 212 */         ArenaScore xScore = Arenascore.select(Long.valueOf(r));
/* 213 */         if ((xScore != null) && 
/*     */         
/*     */ 
/* 216 */           (xScore.getCamp() == roleCamp))
/*     */         {
/*     */ 
/* 219 */           selectRoles.add(Long.valueOf(r)); }
/*     */       }
/*     */     }
/* 222 */     return selectRoles;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\ArenaTeamHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */