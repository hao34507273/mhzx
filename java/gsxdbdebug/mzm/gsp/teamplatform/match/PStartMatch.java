/*     */ package mzm.gsp.teamplatform.match;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.teamplatform.LevelCfg;
/*     */ import mzm.gsp.teamplatform.MatchCfg;
/*     */ import mzm.gsp.teamplatform.SSynMatchState;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Procedure;
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
/*     */ public class PStartMatch
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final List<MatchCfg> matchCfgs;
/*     */   private final LevelCfg liverange;
/*  31 */   private static final Logger logger = Logger.getLogger(PStartMatch.class);
/*     */   
/*     */   public PStartMatch(long roleId, List<MatchCfg> activityCfgs, LevelCfg liverange)
/*     */   {
/*  35 */     this.roleId = roleId;
/*  36 */     this.matchCfgs = activityCfgs;
/*  37 */     this.liverange = liverange;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if (TeamMatchMananger.isRoleInMatchQueue(this.roleId))
/*     */     {
/*  46 */       GameServer.logger().error(String.format("[teammatch]PStartMatch.processImp@already in matchQueue!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     int matchType = 1;
/*  52 */     int teamMemeberNum = 0;
/*     */     
/*  54 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, true);
/*  55 */     if (teamId == null)
/*     */     {
/*  57 */       if (!canActiveMatchInStatus(this.roleId, false))
/*     */       {
/*  59 */         return false;
/*     */       }
/*  61 */       if (!RoleQueueManager.startMatch(this.roleId, (MatchCfg)this.matchCfgs.get(0), this.liverange.levellow, this.liverange.levelhigh))
/*     */       {
/*  63 */         GameServer.logger().error(String.format("[teammatch]PStartMatch.processImp@start match error!|roleId=%d|momcfgId=%d|index=%d|levelLow=%d|levelHigh=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(((MatchCfg)this.matchCfgs.get(0)).matchcfgid), Integer.valueOf(((MatchCfg)this.matchCfgs.get(0)).index), Integer.valueOf(this.liverange.levellow), Integer.valueOf(this.liverange.levelhigh) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*  68 */         return false;
/*     */       }
/*  70 */       matchType = 2;
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  75 */       long teamLeaderId = TeamInterface.getTeamLeaderByTeamid(teamId.longValue(), true);
/*  76 */       if (this.roleId != teamLeaderId)
/*     */       {
/*     */ 
/*  79 */         return false;
/*     */       }
/*  81 */       if (!canActiveMatchInStatus(this.roleId, true))
/*     */       {
/*  83 */         return false;
/*     */       }
/*  85 */       if (this.matchCfgs.size() != 1)
/*     */       {
/*  87 */         logger.error("PStartMatch@队伍进入平台，只能选择一个活动！");
/*  88 */         return false;
/*     */       }
/*  90 */       teamMemeberNum = TeamInterface.getTeamMemberCount(teamId.longValue(), false);
/*  91 */       if (teamMemeberNum >= TeamInterface.getTeamCapacity())
/*     */       {
/*  93 */         GameServer.logger().error(String.format("[teammatch]PStartMatch.processImp@队伍人数已满，不能匹配！|roleId=%d|momcfgId=%d|index=%d|levelLow=%d|levelHigh=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(((MatchCfg)this.matchCfgs.get(0)).matchcfgid), Integer.valueOf(((MatchCfg)this.matchCfgs.get(0)).index), Integer.valueOf(this.liverange.levellow), Integer.valueOf(this.liverange.levelhigh) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*  98 */         return false;
/*     */       }
/* 100 */       if (!TeamQueueManager.startMatch(teamLeaderId, teamId.longValue(), (MatchCfg)this.matchCfgs.get(0), this.liverange.levellow, this.liverange.levelhigh))
/*     */       {
/* 102 */         GameServer.logger().error(String.format("[teammatch]PStartMatch.processImp@ leader start match error！|roleId=%d|momcfgId=%d|index=%d|levelLow=%d|levelHigh=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(((MatchCfg)this.matchCfgs.get(0)).matchcfgid), Integer.valueOf(((MatchCfg)this.matchCfgs.get(0)).index), Integer.valueOf(this.liverange.levellow), Integer.valueOf(this.liverange.levelhigh) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 107 */         return false;
/*     */       }
/*     */       
/* 110 */       List<Long> normaList = TeamInterface.getNormalRoleList(teamLeaderId);
/* 111 */       TeamMatchMananger.synLeaderMatchInfo(teamLeaderId, normaList, 2);
/* 112 */       Procedure.execute(new PCheckAFLeaderJoinMatch(teamLeaderId));
/*     */     }
/*     */     
/* 115 */     if (TeamMatchMananger.isRoleInMatchQueue(this.roleId))
/*     */     {
/*     */ 
/* 118 */       SSynMatchState sSynMatchState = new SSynMatchState();
/* 119 */       sSynMatchState.matchstate = 1;
/* 120 */       OnlineManager.getInstance().send(this.roleId, sSynMatchState);
/*     */       
/* 122 */       for (MatchCfg cfg : this.matchCfgs)
/*     */       {
/* 124 */         TeamMatchLogManager.addTeamMatchLog(this.roleId, cfg.matchcfgid, cfg.index, matchType, teamMemeberNum);
/*     */       }
/*     */     }
/*     */     
/* 128 */     return true;
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
/*     */   private boolean canActiveMatchInStatus(long roleId, boolean isTeamLeader)
/*     */   {
/* 142 */     int action = -1;
/* 143 */     if (isTeamLeader)
/*     */     {
/* 145 */       action = 51;
/*     */     }
/*     */     else
/*     */     {
/* 149 */       action = 50;
/*     */     }
/* 151 */     if (action < 0)
/*     */     {
/* 153 */       GameServer.logger().error(String.format("[teammatch]PStartMatch.canActiveLeaveTeamInStatus@ action illegal!|roleId=%d|action=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(action) }));
/*     */       
/*     */ 
/* 156 */       return false;
/*     */     }
/* 158 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, action, true))
/*     */     {
/* 160 */       GameServer.logger().error(String.format("[teammatch]PStartMatch.canActiveLeaveTeamInStatus@ active match is forbiddened!|roleId=%d|action=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(action) }));
/*     */       
/*     */ 
/*     */ 
/* 164 */       return false;
/*     */     }
/* 166 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\PStartMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */