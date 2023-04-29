/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.corps.main.CorpsInfo;
/*     */ import mzm.gsp.corps.main.CorpsInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.JoinTeamCheckHandler;
/*     */ import mzm.gsp.team.main.JoinTeamResult;
/*     */ import mzm.gsp.team.main.JoinTeamResult.Receiver;
/*     */ import mzm.gsp.team.main.JoinTeamResult.Result;
/*     */ import mzm.gsp.team.main.JoinTeamType;
/*     */ import mzm.gsp.team.main.ReturnTeamResult;
/*     */ import mzm.gsp.team.main.ReturnTeamResult.Result;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import xbean.AttendCorpsInfo;
/*     */ import xbean.CrossBattleOwn;
/*     */ import xtable.Cross_battle_owns;
/*     */ 
/*     */ 
/*     */ public class RoundRobinJoinTeamCheckHandler
/*     */   implements JoinTeamCheckHandler
/*     */ {
/*     */   public JoinTeamResult canJoinTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId, boolean tf2LeaderAftJoin, JoinTeamType joinTeamType)
/*     */   {
/*  28 */     JoinTeamResult joinTeamResult = new JoinTeamResult();
/*  29 */     joinTeamResult.setSucceed(false);
/*  30 */     long leaderid = teamInfo.getLeaderId();
/*  31 */     if (RoundRobinWorldManager.getInstance().getActivityCfgid(leaderWorldId) > 0)
/*     */     {
/*     */ 
/*  34 */       if (joinTeamType == JoinTeamType.JOIN_TEAM__APPLY)
/*     */       {
/*  36 */         JoinTeamResult.Result result = new JoinTeamResult.Result(8100, new String[0]);
/*     */         
/*  38 */         joinTeamResult.addResult(JoinTeamResult.Receiver.Leader, result);
/*     */ 
/*     */       }
/*  41 */       else if (joinTeamType == JoinTeamType.JOIN_TEAM__INVITE)
/*     */       {
/*  43 */         JoinTeamResult.Result result = new JoinTeamResult.Result(8101, new String[] { RoleInterface.getName(leaderid) });
/*     */         
/*     */ 
/*  46 */         joinTeamResult.addResult(JoinTeamResult.Receiver.Member, result);
/*     */       }
/*     */     }
/*  49 */     else if (RoundRobinWorldManager.getInstance().getActivityCfgid(roleWorldId) > 0)
/*     */     {
/*     */ 
/*  52 */       if (joinTeamType == JoinTeamType.JOIN_TEAM__APPLY)
/*     */       {
/*  54 */         JoinTeamResult.Result result = new JoinTeamResult.Result(8101, new String[] { RoleInterface.getName(roleId) });
/*     */         
/*     */ 
/*  57 */         joinTeamResult.addResult(JoinTeamResult.Receiver.Leader, result);
/*     */ 
/*     */       }
/*  60 */       else if (joinTeamType == JoinTeamType.JOIN_TEAM__INVITE)
/*     */       {
/*  62 */         JoinTeamResult.Result result = new JoinTeamResult.Result(8100, new String[0]);
/*     */         
/*  64 */         joinTeamResult.addResult(JoinTeamResult.Receiver.Member, result);
/*     */       }
/*     */     }
/*  67 */     return joinTeamResult;
/*     */   }
/*     */   
/*     */ 
/*     */   public ReturnTeamResult canReturnTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId)
/*     */   {
/*  73 */     ReturnTeamResult returnTeamResult = new ReturnTeamResult();
/*  74 */     returnTeamResult.setSucceed(false);
/*  75 */     long leaderid = teamInfo.getLeaderId();
/*  76 */     int activityCfgid = RoundRobinWorldManager.getInstance().getActivityCfgid(leaderWorldId);
/*  77 */     if (activityCfgid > 0)
/*     */     {
/*     */ 
/*  80 */       CorpsInfo corpsInfo = CorpsInterface.getCorpsInfoByRoleId(leaderid, true, true);
/*  81 */       if (corpsInfo == null)
/*     */       {
/*     */ 
/*  84 */         return returnTeamResult;
/*     */       }
/*  86 */       if (!CrossBattleOwnManager.isInRoundRobinStage(activityCfgid))
/*     */       {
/*     */ 
/*  89 */         return returnTeamResult;
/*     */       }
/*     */       
/*  92 */       long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/*  93 */       CrossBattleOwn xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/*  94 */       if ((!xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(corpsInfo.getCorpsId()))) || (!xCrossBattleOwn.getRound_robin_point_rank_list().contains(Long.valueOf(corpsInfo.getCorpsId()))))
/*     */       {
/*     */ 
/*     */ 
/*  98 */         return returnTeamResult;
/*     */       }
/* 100 */       AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsInfo.getCorpsId()));
/* 101 */       if (!xAttendCorpsInfo.getMembers().contains(Long.valueOf(roleId)))
/*     */       {
/*     */ 
/* 104 */         ReturnTeamResult.Result result = new ReturnTeamResult.Result(8101, new String[] { RoleInterface.getName(leaderid) });
/*     */         
/*     */ 
/* 107 */         returnTeamResult.setResult(result);
/* 108 */         return returnTeamResult;
/*     */       }
/* 110 */       if (!RoleStatusInterface.setStatus(roleId, 1305, true))
/*     */       {
/*     */ 
/* 113 */         return returnTeamResult;
/*     */       }
/* 115 */       CrossBattleOwnManager.setRoundRobinTitle(roleId, corpsInfo.getCorpsId(), xAttendCorpsInfo.getName(), ((Long)xAttendCorpsInfo.getMembers().get(0)).longValue() == roleId ? 1 : 2, xAttendCorpsInfo.getBadge());
/*     */       
/*     */ 
/* 118 */       returnTeamResult.setSucceed(true);
/* 119 */       return returnTeamResult;
/*     */     }
/* 121 */     ReturnTeamResult.Result result = new ReturnTeamResult.Result(8100, new String[0]);
/*     */     
/* 123 */     returnTeamResult.setResult(result);
/* 124 */     return returnTeamResult;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\RoundRobinJoinTeamCheckHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */