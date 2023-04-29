/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.corps.main.CorpsInfo;
/*     */ import mzm.gsp.corps.main.CorpsInterface;
/*     */ import mzm.gsp.crossbattle.SSynRoundRobinRoundInfoInCrossBattle;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AttendCorpsInfo;
/*     */ import xbean.CrossBattleOwn;
/*     */ import xbean.RoundRobinRoundInfo;
/*     */ import xtable.Cross_battle_owns;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnRoundRobinRoundFightStageStart
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final int activityCfgid;
/*     */   private final int roundIndex;
/*     */   private final boolean isMain;
/*     */   
/*     */   public POnRoundRobinRoundFightStageStart(int activityCfgid, int roundIndex, boolean isMain)
/*     */   {
/*  39 */     this.activityCfgid = activityCfgid;
/*  40 */     this.roundIndex = roundIndex;
/*  41 */     this.isMain = isMain;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/*  48 */     if (cfg == null)
/*     */     {
/*     */ 
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     long worldid = RoundRobinWorldManager.getInstance().getWorldid(this.activityCfgid);
/*  55 */     if (worldid < 0L)
/*     */     {
/*     */ 
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     List<Long> teamids = MapInterface.getAllTeamInWorld(worldid, cfg.round_robin_map_cfg_id);
/*  62 */     Map<Long, TeamInfo> teamInfos = new HashMap();
/*  63 */     for (Iterator i$ = teamids.iterator(); i$.hasNext();) { long teamid = ((Long)i$.next()).longValue();
/*     */       
/*  65 */       TeamInfo teamInfo = TeamInterface.getTeamInfo(teamid, false);
/*  66 */       if (teamInfo != null)
/*     */       {
/*     */ 
/*     */ 
/*  70 */         teamInfos.put(Long.valueOf(teamid), teamInfo); }
/*     */     }
/*  72 */     Map<Long, TeamInfo> corpsTeamInfos = new HashMap();
/*  73 */     for (TeamInfo teamInfo : teamInfos.values())
/*     */     {
/*  75 */       CorpsInfo corpsInfo = CorpsInterface.getCorpsInfoByRoleId(teamInfo.getLeaderId(), false, false);
/*  76 */       if (corpsInfo != null)
/*     */       {
/*     */ 
/*     */ 
/*  80 */         corpsTeamInfos.put(Long.valueOf(corpsInfo.getCorpsId()), teamInfo);
/*     */       }
/*     */     }
/*     */     
/*  84 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  85 */     CrossBattleOwn xSelectCrossBattleOwn = Cross_battle_owns.select(Long.valueOf(globalActivityCfgid));
/*  86 */     if ((xSelectCrossBattleOwn == null) || (xSelectCrossBattleOwn.getStage() == -1))
/*     */     {
/*     */ 
/*  89 */       onFail(4, null);
/*  90 */       return false;
/*     */     }
/*  92 */     if (xSelectCrossBattleOwn.getStage() != 2)
/*     */     {
/*     */ 
/*  95 */       onFail(5, null);
/*  96 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 100 */     Map<Long, Float> averageFightValues = new HashMap();
/* 101 */     for (Iterator i$ = xSelectCrossBattleOwn.getVote_stage_direct_promotion_corps_list().iterator(); i$.hasNext();) { long corpsid = ((Long)i$.next()).longValue();
/*     */       
/* 103 */       AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xSelectCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsid));
/* 104 */       if (xAttendCorpsInfo != null)
/*     */       {
/*     */ 
/*     */ 
/* 108 */         averageFightValues.put(Long.valueOf(corpsid), Float.valueOf(CrossBattleOwnManager.getAverageFightValue(xAttendCorpsInfo.getMembers()))); }
/*     */     }
/* 110 */     for (Iterator i$ = xSelectCrossBattleOwn.getRound_robin_point_rank_list().iterator(); i$.hasNext();) { long corpsid = ((Long)i$.next()).longValue();
/*     */       
/* 112 */       AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xSelectCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsid));
/* 113 */       if (xAttendCorpsInfo != null)
/*     */       {
/*     */ 
/*     */ 
/* 117 */         averageFightValues.put(Long.valueOf(corpsid), Float.valueOf(CrossBattleOwnManager.getAverageFightValue(xAttendCorpsInfo.getMembers())));
/*     */       }
/*     */     }
/*     */     
/* 121 */     CrossBattleOwn xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/* 122 */     if (xCrossBattleOwn.getStage() != 2)
/*     */     {
/*     */ 
/* 125 */       onFail(5, null);
/* 126 */       return false;
/*     */     }
/* 128 */     if (CrossBattleOwnManager.isRoundRobinRoundEnd(xCrossBattleOwn, this.roundIndex))
/*     */     {
/*     */ 
/* 131 */       onFail(6, null);
/* 132 */       return false;
/*     */     }
/* 134 */     RoundRobinRestartInfo restartInfo = RoundRobinRestartManager.getInstance().getRestartInfo(this.activityCfgid);
/* 135 */     if ((restartInfo == null) && (xCrossBattleOwn.getRound_robin_round_index() != this.roundIndex))
/*     */     {
/*     */ 
/* 138 */       onFail(7, null);
/* 139 */       return false;
/*     */     }
/* 141 */     RoundRobinRoundInfo xRoundRobinRoundInfo = (RoundRobinRoundInfo)xCrossBattleOwn.getRound_robin_round_infos().get(this.roundIndex - 1);
/*     */     
/*     */ 
/* 144 */     xRoundRobinRoundInfo.setStage(1);
/*     */     
/* 146 */     boolean isFightStart = false;
/* 147 */     for (xbean.RoundRobinFightInfo xRoundRobinFightInfo : xRoundRobinRoundInfo.getFight_infos())
/*     */     {
/* 149 */       if (!CrossBattleOwnManager.isRoundRobinFightEnd(xRoundRobinFightInfo))
/*     */       {
/*     */ 
/*     */ 
/* 153 */         if (!CrossBattleOwnManager.isCrossBattleRoundRobinStageSwitchOpen(this.activityCfgid))
/*     */         {
/* 155 */           CrossBattleOwnTLogManager.addRoundRobinFightStateTLog(this.activityCfgid, this.roundIndex, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_b_id(), xRoundRobinFightInfo.getState(), 7);
/*     */           
/*     */ 
/* 158 */           xRoundRobinFightInfo.setState(7);
/* 159 */           CrossBattleOwnManager.triggerRoundRobinFightEndEvent(this.activityCfgid, this.roundIndex, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_b_id(), xRoundRobinFightInfo.getState());
/*     */           
/*     */ 
/* 162 */           CrossBattleOwnManager.brdRoundRobinFightResult(this.activityCfgid, this.roundIndex, xCrossBattleOwn, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_b_id(), xRoundRobinFightInfo.getState());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/* 168 */         else if ((!corpsTeamInfos.containsKey(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))) && (!corpsTeamInfos.containsKey(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))))
/*     */         {
/*     */ 
/* 171 */           CrossBattleOwnTLogManager.addRoundRobinFightStateTLog(this.activityCfgid, this.roundIndex, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_b_id(), xRoundRobinFightInfo.getState(), 6);
/*     */           
/*     */ 
/* 174 */           xRoundRobinFightInfo.setState(6);
/* 175 */           CrossBattleOwnManager.triggerRoundRobinFightEndEvent(this.activityCfgid, this.roundIndex, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_b_id(), xRoundRobinFightInfo.getState());
/*     */           
/*     */ 
/* 178 */           CrossBattleOwnManager.brdRoundRobinFightResult(this.activityCfgid, this.roundIndex, xCrossBattleOwn, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_b_id(), xRoundRobinFightInfo.getState());
/*     */ 
/*     */ 
/*     */         }
/* 182 */         else if ((!corpsTeamInfos.containsKey(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))) && (corpsTeamInfos.containsKey(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))))
/*     */         {
/*     */ 
/* 185 */           CrossBattleOwnTLogManager.addRoundRobinFightStateTLog(this.activityCfgid, this.roundIndex, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_b_id(), xRoundRobinFightInfo.getState(), 4);
/*     */           
/*     */ 
/* 188 */           xRoundRobinFightInfo.setState(4);
/* 189 */           ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).setRound_robin_lose_num(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).getRound_robin_lose_num() + 1);
/*     */           
/* 191 */           ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).setRound_robin_point(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).getRound_robin_point() + cfg.round_robin_lose_point);
/*     */           
/*     */ 
/* 194 */           ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).setRound_robin_win_num(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).getRound_robin_win_num() + 1);
/*     */           
/* 196 */           ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).setRound_robin_point(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).getRound_robin_point() + cfg.round_robin_win_point);
/*     */           
/*     */ 
/* 199 */           CrossBattleOwnManager.triggerRoundRobinFightEndEvent(this.activityCfgid, this.roundIndex, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_b_id(), xRoundRobinFightInfo.getState());
/*     */           
/*     */ 
/* 202 */           CrossBattleOwnManager.brdRoundRobinFightResult(this.activityCfgid, this.roundIndex, xCrossBattleOwn, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_b_id(), xRoundRobinFightInfo.getState());
/*     */           
/*     */ 
/*     */ 
/* 206 */           List<Long> roleList = new ArrayList();
/* 207 */           roleList.addAll(((TeamInfo)corpsTeamInfos.get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).getTeamMemberList());
/* 208 */           CrossBattleOneByOneManager.getInstance().addLogicRunnable(Integer.valueOf(this.activityCfgid), new RLeaveRoundRobinMap(this.activityCfgid, roleList));
/*     */ 
/*     */         }
/* 211 */         else if ((corpsTeamInfos.containsKey(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))) && (!corpsTeamInfos.containsKey(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))))
/*     */         {
/*     */ 
/* 214 */           CrossBattleOwnTLogManager.addRoundRobinFightStateTLog(this.activityCfgid, this.roundIndex, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_b_id(), xRoundRobinFightInfo.getState(), 5);
/*     */           
/*     */ 
/* 217 */           xRoundRobinFightInfo.setState(5);
/* 218 */           ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).setRound_robin_lose_num(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).getRound_robin_lose_num() + 1);
/*     */           
/* 220 */           ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).setRound_robin_point(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).getRound_robin_point() + cfg.round_robin_lose_point);
/*     */           
/*     */ 
/* 223 */           ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).setRound_robin_win_num(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).getRound_robin_win_num() + 1);
/*     */           
/* 225 */           ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).setRound_robin_point(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).getRound_robin_point() + cfg.round_robin_win_point);
/*     */           
/*     */ 
/* 228 */           CrossBattleOwnManager.triggerRoundRobinFightEndEvent(this.activityCfgid, this.roundIndex, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_b_id(), xRoundRobinFightInfo.getState());
/*     */           
/*     */ 
/* 231 */           CrossBattleOwnManager.brdRoundRobinFightResult(this.activityCfgid, this.roundIndex, xCrossBattleOwn, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_b_id(), xRoundRobinFightInfo.getState());
/*     */           
/*     */ 
/*     */ 
/* 235 */           List<Long> roleList = new ArrayList();
/* 236 */           roleList.addAll(((TeamInfo)corpsTeamInfos.get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).getTeamMemberList());
/* 237 */           CrossBattleOneByOneManager.getInstance().addLogicRunnable(Integer.valueOf(this.activityCfgid), new RLeaveRoundRobinMap(this.activityCfgid, roleList));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 242 */           CrossBattleOwnTLogManager.addRoundRobinFightStateTLog(this.activityCfgid, this.roundIndex, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_b_id(), xRoundRobinFightInfo.getState(), 1);
/*     */           
/*     */ 
/* 245 */           xRoundRobinFightInfo.setState(1);
/* 246 */           FightInterface.startPVPFightWithTeamDisposition(((TeamInfo)corpsTeamInfos.get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).getTeamNormalList(), ((TeamInfo)corpsTeamInfos.get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).getTeamNormalList(), new RoundRobinFightContext(this.activityCfgid, this.roundIndex, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_b_id()), 19, FightReason.CROSS_BATTLE_ROUND_ROBIN);
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 253 */           isFightStart = true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 258 */     CrossBattleOwnManager.refreshRoundRobinPointRankList(xCrossBattleOwn);
/*     */     
/* 260 */     if (CrossBattleOwnManager.isCrossBattleRoundRobinStageSwitchOpen(this.activityCfgid))
/*     */     {
/* 262 */       SSynRoundRobinRoundInfoInCrossBattle protocol = new SSynRoundRobinRoundInfoInCrossBattle();
/* 263 */       protocol.activity_cfg_id = this.activityCfgid;
/* 264 */       protocol.index = this.roundIndex;
/* 265 */       protocol.stage = 1;
/* 266 */       for (xbean.RoundRobinFightInfo xRoundRobinFightInfo : xRoundRobinRoundInfo.getFight_infos())
/*     */       {
/* 268 */         if ((!xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))) || (!xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))))
/*     */         {
/*     */ 
/* 271 */           CrossBattleOwnManager.logger.error(String.format("[crossbattle_own]POnRoundRobinRoundFightStageStart.processImp@no corps info|corps_a_id=%d|corps_b_id=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()), Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()), Integer.valueOf(this.activityCfgid) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 276 */           mzm.gsp.crossbattle.RoundRobinFightInfo fightInfo = new mzm.gsp.crossbattle.RoundRobinFightInfo();
/* 277 */           CrossBattleOwnManager.fillCorpsBriefInfo(fightInfo.corps_a_brief_info, xRoundRobinFightInfo.getCorps_a_id(), (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id())));
/*     */           
/* 279 */           CrossBattleOwnManager.fillCorpsBriefInfo(fightInfo.corps_b_brief_info, xRoundRobinFightInfo.getCorps_b_id(), (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id())));
/*     */           
/* 281 */           fightInfo.state = xRoundRobinFightInfo.getState();
/* 282 */           protocol.fight_infos.add(fightInfo);
/*     */         } }
/* 284 */       OnlineManager.getInstance().sendAll(protocol);
/*     */     }
/* 286 */     if (!isFightStart)
/*     */     {
/*     */ 
/* 289 */       CrossBattleOwnManager.trySettleRoundRobinRound(xCrossBattleOwn, this.activityCfgid, this.roundIndex, averageFightValues);
/*     */     }
/*     */     
/* 292 */     StringBuilder sb = new StringBuilder();
/* 293 */     sb.append(String.format("[crossbattle_own]POnRoundRobinRoundFightStageStart.processImp@round robin round fight stage start process success|activity_cfg_id=%d|round_index=%d|is_main=%b", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.roundIndex), Boolean.valueOf(this.isMain) }));
/*     */     
/*     */ 
/* 296 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 297 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 302 */     StringBuilder sb = new StringBuilder();
/* 303 */     sb.append(String.format("[crossbattle_own]POnRoundRobinRoundFightStageStart.processImp@round robin round fight stage start process fail|activity_cfg_id=%d|round_index=%d|is_main=%b|res=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.roundIndex), Boolean.valueOf(this.isMain), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 306 */     if (extraInfo != null)
/*     */     {
/* 308 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 310 */         sb.append("|").append((String)entry.getKey());
/* 311 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 314 */     CrossBattleOwnManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\POnRoundRobinRoundFightStageStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */