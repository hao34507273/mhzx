/*     */ package mzm.gsp.competition.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
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
/*     */ 
/*     */ class CompetitionTeamHandler
/*     */   implements JoinTeamCheckHandler, ActivityTeamHandler
/*     */ {
/*     */   static volatile CompetitionTeamHandler instance;
/*     */   
/*     */   static CompetitionTeamHandler getInstance()
/*     */   {
/*  30 */     if (instance == null) {
/*  31 */       synchronized (CompetitionTeamHandler.class) {
/*  32 */         if (instance == null) {
/*  33 */           instance = new CompetitionTeamHandler();
/*     */         }
/*     */       }
/*     */     }
/*  37 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public JoinTeamResult canJoinTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId, boolean tf2LeaderAftJoin, JoinTeamType joinTeamType)
/*     */   {
/*  44 */     JoinTeamResult result = new JoinTeamResult();
/*  45 */     result.setSucceed(false);
/*     */     
/*  47 */     if (leaderWorldId != roleWorldId) {
/*  48 */       switch (joinTeamType) {
/*     */       case JOIN_TEAM__INVITE: 
/*  50 */         result.addResult(JoinTeamResult.Receiver.Member, new JoinTeamResult.Result(132, new String[0]));
/*     */         
/*  52 */         break;
/*     */       case JOIN_TEAM__APPLY: 
/*  54 */         result.addResult(JoinTeamResult.Receiver.Leader, new JoinTeamResult.Result(133, new String[] { RoleInterface.getName(roleId) }));
/*     */         
/*     */ 
/*  57 */         break;
/*     */       case JOIN_TEAM__PLATFORM: 
/*     */         break;
/*     */       
/*     */       default: 
/*  62 */         CompetitionManager.logger.error("[not same world] Unhandled JoinTeamType: " + joinTeamType);
/*     */       }
/*     */       
/*     */       
/*  66 */       return result;
/*     */     }
/*     */     
/*     */ 
/*  70 */     Gang faction = GangInterface.getGangByRoleId(teamInfo.getLeaderId(), false);
/*  71 */     if (!faction.isInGang(roleId)) {
/*  72 */       switch (joinTeamType) {
/*     */       case JOIN_TEAM__INVITE: 
/*  74 */         result.addResult(JoinTeamResult.Receiver.Member, new JoinTeamResult.Result(130, new String[0]));
/*     */         
/*  76 */         break;
/*     */       case JOIN_TEAM__APPLY: 
/*  78 */         result.addResult(JoinTeamResult.Receiver.Leader, new JoinTeamResult.Result(131, new String[] { RoleInterface.getName(roleId) }));
/*     */         
/*     */ 
/*  81 */         break;
/*     */       case JOIN_TEAM__PLATFORM: 
/*     */         break;
/*     */       
/*     */       default: 
/*  86 */         CompetitionManager.logger.error("[not same camp] Unhandled JoinTeamType: " + joinTeamType);
/*     */       }
/*     */       
/*     */       
/*  90 */       return result;
/*     */     }
/*     */     
/*  93 */     result.setSucceed(true);
/*  94 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ReturnTeamResult canReturnTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId)
/*     */   {
/* 101 */     ReturnTeamResult result = new ReturnTeamResult();
/* 102 */     result.setSucceed(false);
/*     */     
/* 104 */     if (leaderWorldId != roleWorldId) {
/* 105 */       result.setResult(new ReturnTeamResult.Result(3010, new String[0]));
/*     */       
/*     */ 
/* 108 */       return result;
/*     */     }
/*     */     
/*     */ 
/* 112 */     Gang faction = GangInterface.getGangByRoleId(teamInfo.getLeaderId(), false);
/* 113 */     if (!faction.isInGang(roleId)) {
/* 114 */       result.setResult(new ReturnTeamResult.Result(3011, new String[0]));
/*     */       
/*     */ 
/* 117 */       return result;
/*     */     }
/*     */     
/* 120 */     result.setSucceed(true);
/* 121 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> findTeams(long roleId, long worldId)
/*     */   {
/* 128 */     List<Long> selectTeams = new ArrayList();
/*     */     
/* 130 */     Gang faction = GangInterface.getGangByRoleId(roleId, false);
/* 131 */     if (faction == null) {
/* 132 */       return selectTeams;
/*     */     }
/*     */     
/*     */ 
/* 136 */     Collection<Long> allTeams = MapInterface.getAllTeamInWorld(worldId);
/* 137 */     for (Iterator i$ = allTeams.iterator(); i$.hasNext();) { long teamid = ((Long)i$.next()).longValue();
/*     */       
/* 139 */       TeamInfo team = TeamInterface.getTeamInfo(teamid, false);
/* 140 */       if ((team != null) && 
/*     */       
/*     */ 
/* 143 */         (!team.isRoleInTeam(roleId)) && 
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 148 */         (faction.isInGang(team.getLeaderId())))
/*     */       {
/*     */ 
/*     */ 
/* 152 */         selectTeams.add(Long.valueOf(teamid));
/*     */       }
/*     */     }
/* 155 */     return selectTeams;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> findMembers(long roleId, long worldId)
/*     */   {
/* 161 */     List<Long> selectRoles = new ArrayList();
/*     */     
/* 163 */     Gang faction = GangInterface.getGangByRoleId(roleId, false);
/* 164 */     if (faction == null) {
/* 165 */       return selectRoles;
/*     */     }
/*     */     
/*     */ 
/* 169 */     List<Long> allRoles = MapInterface.getAllSingleRoleInWorld(worldId);
/* 170 */     for (Iterator i$ = allRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 171 */       if ((r != roleId) && 
/*     */       
/*     */ 
/* 174 */         (faction.isInGang(r)))
/*     */       {
/*     */ 
/* 177 */         selectRoles.add(Long.valueOf(r));
/*     */       }
/*     */     }
/* 180 */     return selectRoles;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\CompetitionTeamHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */