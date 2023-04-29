/*     */ package mzm.gsp.factionpve.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
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
/*     */ 
/*     */ 
/*     */ public class FactionPVETeamHandler
/*     */   implements JoinTeamCheckHandler, ActivityTeamHandler
/*     */ {
/*     */   private static volatile FactionPVETeamHandler instance;
/*     */   
/*     */   static FactionPVETeamHandler getInstance()
/*     */   {
/*  28 */     if (instance == null) {
/*  29 */       synchronized (FactionPVETeamHandler.class) {
/*  30 */         if (instance == null) {
/*  31 */           instance = new FactionPVETeamHandler();
/*     */         }
/*     */       }
/*     */     }
/*  35 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public JoinTeamResult canJoinTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId, boolean tf2LeaderAftJoin, JoinTeamType joinTeamType)
/*     */   {
/*  45 */     JoinTeamResult result = new JoinTeamResult();
/*  46 */     result.setSucceed(false);
/*     */     
/*  48 */     if (leaderWorldId != roleWorldId) {
/*  49 */       switch (joinTeamType) {
/*     */       case JOIN_TEAM__INVITE: 
/*  51 */         result.addResult(JoinTeamResult.Receiver.Member, new JoinTeamResult.Result(8000, new String[0]));
/*     */         
/*  53 */         break;
/*     */       case JOIN_TEAM__APPLY: 
/*  55 */         result.addResult(JoinTeamResult.Receiver.Leader, new JoinTeamResult.Result(8001, new String[] { RoleInterface.getName(roleId) }));
/*     */         
/*     */ 
/*  58 */         break;
/*     */       case JOIN_TEAM__PLATFORM: 
/*     */       case JOIN_TEAM__FORMAT_AS_TMP_LEAVE: 
/*     */       case JOIN_TEAM__FORMAT_IN_CONDITION: 
/*     */         break;
/*     */       
/*     */       default: 
/*  65 */         FactionPVEManager.logError("FactionPVETeamHandler.canJoinTeam@unhandled jointeamtype|teamInfo=%s|roleid=%d|leader_world=%d|role_world=%d|jointeamtype=%d", new Object[] { teamInfo, Long.valueOf(roleId), Long.valueOf(leaderWorldId), Long.valueOf(roleWorldId), Integer.valueOf(joinTeamType.ordinal()) });
/*     */       }
/*     */       
/*     */       
/*     */ 
/*     */ 
/*  71 */       return result;
/*     */     }
/*     */     
/*  74 */     result.setSucceed(true);
/*  75 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   public ReturnTeamResult canReturnTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId)
/*     */   {
/*  81 */     ReturnTeamResult result = new ReturnTeamResult();
/*  82 */     result.setSucceed(false);
/*     */     
/*  84 */     if (leaderWorldId != roleWorldId) {
/*  85 */       result.setResult(new ReturnTeamResult.Result(8002, new String[0]));
/*     */       
/*     */ 
/*  88 */       return result;
/*     */     }
/*     */     
/*  91 */     result.setSucceed(true);
/*  92 */     return result;
/*     */   }
/*     */   
/*     */   public List<Long> findMembers(long roleId, long worldId)
/*     */   {
/*  97 */     List<Long> selectRoles = new ArrayList();
/*     */     
/*     */ 
/* 100 */     List<Long> allRoles = MapInterface.getAllSingleRoleInWorld(worldId);
/* 101 */     for (Iterator i$ = allRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 102 */       if (r != roleId)
/*     */       {
/*     */ 
/* 105 */         selectRoles.add(Long.valueOf(r));
/*     */       }
/*     */     }
/* 108 */     return selectRoles;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> findTeams(long roleId, long worldId)
/*     */   {
/* 114 */     List<Long> selectTeams = new ArrayList();
/*     */     
/*     */ 
/* 117 */     Collection<Long> allTeams = MapInterface.getAllTeamInWorld(worldId);
/* 118 */     for (Iterator i$ = allTeams.iterator(); i$.hasNext();) { long teamid = ((Long)i$.next()).longValue();
/*     */       
/* 120 */       TeamInfo team = TeamInterface.getTeamInfo(teamid, false);
/* 121 */       if ((team != null) && 
/*     */       
/*     */ 
/* 124 */         (!team.isRoleInTeam(roleId)))
/*     */       {
/*     */ 
/*     */ 
/* 128 */         selectTeams.add(Long.valueOf(teamid));
/*     */       }
/*     */     }
/* 131 */     return selectTeams;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\FactionPVETeamHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */