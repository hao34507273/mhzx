/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import mzm.gsp.fight.event.PVPFightEndArg;
/*     */ import mzm.gsp.fight.event.PVPFightEndProcedure;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AttendCorpsInfo;
/*     */ import xbean.CrossBattleOwn;
/*     */ import xbean.RoundRobinFightInfo;
/*     */ import xbean.RoundRobinRoundInfo;
/*     */ import xtable.Cross_battle_owns;
/*     */ 
/*     */ public class POnPVPFightEnd extends PVPFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  26 */     if ((!(((PVPFightEndArg)this.arg).context instanceof RoundRobinFightContext)) || (((PVPFightEndArg)this.arg).fightReason != FightReason.CROSS_BATTLE_ROUND_ROBIN.value))
/*     */     {
/*     */ 
/*  29 */       return false;
/*     */     }
/*  31 */     RoundRobinFightContext context = (RoundRobinFightContext)((PVPFightEndArg)this.arg).context;
/*  32 */     int activityCfgid = context.activityCfgid;
/*  33 */     int roundIndex = context.roundIndex;
/*  34 */     long corpsAid = context.corpsAid;
/*  35 */     long corpsBid = context.corpsBid;
/*     */     
/*  37 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(activityCfgid);
/*  38 */     if (cfg == null)
/*     */     {
/*     */ 
/*  41 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  45 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/*  46 */     CrossBattleOwn xSelectCrossBattleOwn = Cross_battle_owns.select(Long.valueOf(globalActivityCfgid));
/*  47 */     if ((xSelectCrossBattleOwn == null) || (xSelectCrossBattleOwn.getStage() == -1))
/*     */     {
/*     */ 
/*  50 */       onFail(4, null, activityCfgid, roundIndex, corpsAid, corpsBid);
/*  51 */       return false;
/*     */     }
/*  53 */     if (xSelectCrossBattleOwn.getStage() != 2)
/*     */     {
/*     */ 
/*  56 */       onFail(5, null, activityCfgid, roundIndex, corpsAid, corpsBid);
/*  57 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  61 */     Map<Long, Float> averageFightValues = new HashMap();
/*  62 */     for (Iterator i$ = xSelectCrossBattleOwn.getVote_stage_direct_promotion_corps_list().iterator(); i$.hasNext();) { long corpsid = ((Long)i$.next()).longValue();
/*     */       
/*  64 */       AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xSelectCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsid));
/*  65 */       if (xAttendCorpsInfo != null)
/*     */       {
/*     */ 
/*     */ 
/*  69 */         averageFightValues.put(Long.valueOf(corpsid), Float.valueOf(CrossBattleOwnManager.getAverageFightValue(xAttendCorpsInfo.getMembers()))); }
/*     */     }
/*  71 */     for (Iterator i$ = xSelectCrossBattleOwn.getRound_robin_point_rank_list().iterator(); i$.hasNext();) { long corpsid = ((Long)i$.next()).longValue();
/*     */       
/*  73 */       AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xSelectCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsid));
/*  74 */       if (xAttendCorpsInfo != null)
/*     */       {
/*     */ 
/*     */ 
/*  78 */         averageFightValues.put(Long.valueOf(corpsid), Float.valueOf(CrossBattleOwnManager.getAverageFightValue(xAttendCorpsInfo.getMembers())));
/*     */       }
/*     */     }
/*     */     
/*  82 */     CrossBattleOwn xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/*  83 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() == -1))
/*     */     {
/*     */ 
/*  86 */       onFail(4, null, activityCfgid, roundIndex, corpsAid, corpsBid);
/*  87 */       return false;
/*     */     }
/*  89 */     if (xCrossBattleOwn.getStage() != 2)
/*     */     {
/*     */ 
/*  92 */       onFail(5, null, activityCfgid, roundIndex, corpsAid, corpsBid);
/*  93 */       return false;
/*     */     }
/*  95 */     if (CrossBattleOwnManager.isRoundRobinRoundEnd(xCrossBattleOwn, roundIndex))
/*     */     {
/*     */ 
/*  98 */       onFail(6, null, activityCfgid, roundIndex, corpsAid, corpsBid);
/*  99 */       return false;
/*     */     }
/* 101 */     RoundRobinRestartInfo restartInfo = RoundRobinRestartManager.getInstance().getRestartInfo(activityCfgid);
/* 102 */     if ((restartInfo == null) && (xCrossBattleOwn.getRound_robin_round_index() != roundIndex))
/*     */     {
/*     */ 
/* 105 */       onFail(7, null, activityCfgid, roundIndex, corpsAid, corpsBid);
/* 106 */       return false;
/*     */     }
/* 108 */     RoundRobinRoundInfo xRoundRobinRoundInfo = (RoundRobinRoundInfo)xCrossBattleOwn.getRound_robin_round_infos().get(roundIndex - 1);
/* 109 */     for (RoundRobinFightInfo xRoundRobinFightInfo : xRoundRobinRoundInfo.getFight_infos())
/*     */     {
/* 111 */       if ((xRoundRobinFightInfo.getCorps_a_id() == corpsAid) && (xRoundRobinFightInfo.getCorps_b_id() == corpsBid))
/*     */       {
/* 113 */         if (CrossBattleOwnManager.isRoundRobinFightEnd(xRoundRobinFightInfo))
/*     */         {
/*     */ 
/* 116 */           onFail(8, null, activityCfgid, roundIndex, corpsAid, corpsBid);
/* 117 */           return false;
/*     */         }
/* 119 */         xRoundRobinFightInfo.setRecordid(((PVPFightEndArg)this.arg).recordid);
/* 120 */         if (((PVPFightEndArg)this.arg).isActiveWin)
/*     */         {
/* 122 */           CrossBattleOwnTLogManager.addRoundRobinFightStateTLog(activityCfgid, roundIndex, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_b_id(), xRoundRobinFightInfo.getState(), 2);
/*     */           
/*     */ 
/* 125 */           xRoundRobinFightInfo.setState(2);
/* 126 */           ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).setRound_robin_lose_num(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).getRound_robin_lose_num() + 1);
/*     */           
/* 128 */           ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).setRound_robin_point(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).getRound_robin_point() + cfg.round_robin_lose_point);
/*     */           
/*     */ 
/* 131 */           ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).setRound_robin_win_num(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).getRound_robin_win_num() + 1);
/*     */           
/* 133 */           ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).setRound_robin_point(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).getRound_robin_point() + cfg.round_robin_win_point);
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/* 139 */           CrossBattleOwnTLogManager.addRoundRobinFightStateTLog(activityCfgid, roundIndex, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_b_id(), xRoundRobinFightInfo.getState(), 3);
/*     */           
/*     */ 
/* 142 */           xRoundRobinFightInfo.setState(3);
/* 143 */           ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).setRound_robin_lose_num(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).getRound_robin_lose_num() + 1);
/*     */           
/* 145 */           ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).setRound_robin_point(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).getRound_robin_point() + cfg.round_robin_lose_point);
/*     */           
/*     */ 
/* 148 */           ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).setRound_robin_win_num(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).getRound_robin_win_num() + 1);
/*     */           
/* 150 */           ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).setRound_robin_point(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).getRound_robin_point() + cfg.round_robin_win_point);
/*     */         }
/*     */         
/*     */ 
/* 154 */         CrossBattleOwnManager.triggerRoundRobinFightEndEvent(activityCfgid, roundIndex, corpsAid, corpsBid, xRoundRobinFightInfo.getState());
/*     */         
/* 156 */         CrossBattleOwnManager.brdRoundRobinFightResult(activityCfgid, roundIndex, xCrossBattleOwn, corpsAid, corpsBid, xRoundRobinFightInfo.getState());
/*     */         
/* 158 */         break;
/*     */       }
/*     */     }
/*     */     
/* 162 */     List<Long> roleList = new ArrayList();
/* 163 */     roleList.addAll(((PVPFightEndArg)this.arg).activeRoleList);
/* 164 */     roleList.addAll(((PVPFightEndArg)this.arg).passiveRoleList);
/* 165 */     CrossBattleOneByOneManager.getInstance().addLogicRunnable(Integer.valueOf(activityCfgid), new RLeaveRoundRobinMap(activityCfgid, roleList));
/*     */     
/*     */ 
/* 168 */     CrossBattleOwnManager.refreshRoundRobinPointRankList(xCrossBattleOwn);
/*     */     
/* 170 */     CrossBattleOwnManager.trySettleRoundRobinRound(xCrossBattleOwn, activityCfgid, roundIndex, averageFightValues);
/*     */     
/* 172 */     StringBuilder sb = new StringBuilder();
/* 173 */     sb.append(String.format("[crossbattle_own]POnPVPFightEnd.processImp@pvp fight end process success|activity_cfg_id=%d|round_index=%d|corps_a_id=%d|corps_b_id=%d|is_active_win=%b", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(roundIndex), Long.valueOf(corpsAid), Long.valueOf(corpsBid), Boolean.valueOf(((PVPFightEndArg)this.arg).isActiveWin) }));
/*     */     
/*     */ 
/* 176 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 177 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(int res, Map<String, Object> extraInfo, int activityCfgid, int roundIndex, long corpsAid, long corpsBid)
/*     */   {
/* 183 */     StringBuilder sb = new StringBuilder();
/* 184 */     sb.append(String.format("[crossbattle_own]POnPVPFightEnd.processImp@pvp fight end process fail|activity_cfg_id=%d|round_index=%d|corps_a_id=%d|corps_b_id=%d|res=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(roundIndex), Long.valueOf(corpsAid), Long.valueOf(corpsBid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 187 */     if (extraInfo != null)
/*     */     {
/* 189 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 191 */         sb.append("|").append((String)entry.getKey());
/* 192 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 195 */     CrossBattleOwnManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\POnPVPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */