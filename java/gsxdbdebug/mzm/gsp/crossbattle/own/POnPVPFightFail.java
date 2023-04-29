/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import mzm.gsp.fight.event.PVPFightFailArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AttendCorpsInfo;
/*     */ import xbean.CrossBattleOwn;
/*     */ import xbean.RoundRobinFightInfo;
/*     */ import xbean.RoundRobinRoundInfo;
/*     */ import xtable.Cross_battle_owns;
/*     */ 
/*     */ public class POnPVPFightFail extends mzm.gsp.fight.event.PVPFightFailProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  21 */     if (!(((PVPFightFailArg)this.arg).context instanceof RoundRobinFightContext))
/*     */     {
/*  23 */       return false;
/*     */     }
/*  25 */     RoundRobinFightContext context = (RoundRobinFightContext)((PVPFightFailArg)this.arg).context;
/*  26 */     int activityCfgid = context.activityCfgid;
/*  27 */     int roundIndex = context.roundIndex;
/*  28 */     long corpsAid = context.corpsAid;
/*  29 */     long corpsBid = context.corpsBid;
/*     */     
/*  31 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(activityCfgid);
/*  32 */     if (cfg == null)
/*     */     {
/*     */ 
/*  35 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  39 */     long globalActivityCfgid = mzm.gsp.GameServerInfoManager.toGlobalId(activityCfgid);
/*  40 */     CrossBattleOwn xSelectCrossBattleOwn = Cross_battle_owns.select(Long.valueOf(globalActivityCfgid));
/*  41 */     if ((xSelectCrossBattleOwn == null) || (xSelectCrossBattleOwn.getStage() == -1))
/*     */     {
/*     */ 
/*  44 */       onFail(4, null, activityCfgid, roundIndex, corpsAid, corpsBid);
/*  45 */       return false;
/*     */     }
/*  47 */     if (xSelectCrossBattleOwn.getStage() != 2)
/*     */     {
/*     */ 
/*  50 */       onFail(5, null, activityCfgid, roundIndex, corpsAid, corpsBid);
/*  51 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  55 */     Map<Long, Float> averageFightValues = new java.util.HashMap();
/*  56 */     for (Iterator i$ = xSelectCrossBattleOwn.getVote_stage_direct_promotion_corps_list().iterator(); i$.hasNext();) { long corpsid = ((Long)i$.next()).longValue();
/*     */       
/*  58 */       AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xSelectCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsid));
/*  59 */       if (xAttendCorpsInfo != null)
/*     */       {
/*     */ 
/*     */ 
/*  63 */         averageFightValues.put(Long.valueOf(corpsid), Float.valueOf(CrossBattleOwnManager.getAverageFightValue(xAttendCorpsInfo.getMembers()))); }
/*     */     }
/*  65 */     for (Iterator i$ = xSelectCrossBattleOwn.getRound_robin_point_rank_list().iterator(); i$.hasNext();) { long corpsid = ((Long)i$.next()).longValue();
/*     */       
/*  67 */       AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xSelectCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsid));
/*  68 */       if (xAttendCorpsInfo != null)
/*     */       {
/*     */ 
/*     */ 
/*  72 */         averageFightValues.put(Long.valueOf(corpsid), Float.valueOf(CrossBattleOwnManager.getAverageFightValue(xAttendCorpsInfo.getMembers())));
/*     */       }
/*     */     }
/*     */     
/*  76 */     CrossBattleOwn xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/*  77 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() == -1))
/*     */     {
/*     */ 
/*  80 */       onFail(4, null, activityCfgid, roundIndex, corpsAid, corpsBid);
/*  81 */       return false;
/*     */     }
/*  83 */     if (xCrossBattleOwn.getStage() != 2)
/*     */     {
/*     */ 
/*  86 */       onFail(5, null, activityCfgid, roundIndex, corpsAid, corpsBid);
/*  87 */       return false;
/*     */     }
/*  89 */     if (CrossBattleOwnManager.isRoundRobinRoundEnd(xCrossBattleOwn, roundIndex))
/*     */     {
/*     */ 
/*  92 */       onFail(6, null, activityCfgid, roundIndex, corpsAid, corpsBid);
/*  93 */       return false;
/*     */     }
/*  95 */     RoundRobinRestartInfo restartInfo = RoundRobinRestartManager.getInstance().getRestartInfo(activityCfgid);
/*  96 */     if ((restartInfo == null) && (xCrossBattleOwn.getRound_robin_round_index() != roundIndex))
/*     */     {
/*     */ 
/*  99 */       onFail(7, null, activityCfgid, roundIndex, corpsAid, corpsBid);
/* 100 */       return false;
/*     */     }
/* 102 */     RoundRobinRoundInfo xRoundRobinRoundInfo = (RoundRobinRoundInfo)xCrossBattleOwn.getRound_robin_round_infos().get(roundIndex - 1);
/* 103 */     for (RoundRobinFightInfo xRoundRobinFightInfo : xRoundRobinRoundInfo.getFight_infos())
/*     */     {
/* 105 */       if ((xRoundRobinFightInfo.getCorps_a_id() == corpsAid) && (xRoundRobinFightInfo.getCorps_b_id() == corpsBid))
/*     */       {
/* 107 */         if (CrossBattleOwnManager.isRoundRobinFightEnd(xRoundRobinFightInfo))
/*     */         {
/*     */ 
/* 110 */           onFail(8, null, activityCfgid, roundIndex, corpsAid, corpsBid);
/* 111 */           return false;
/*     */         }
/* 113 */         CrossBattleOwnTLogManager.addRoundRobinFightStateTLog(activityCfgid, roundIndex, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_b_id(), xRoundRobinFightInfo.getState(), 7);
/*     */         
/*     */ 
/* 116 */         xRoundRobinFightInfo.setState(7);
/* 117 */         CrossBattleOwnManager.triggerRoundRobinFightEndEvent(activityCfgid, roundIndex, corpsAid, corpsBid, xRoundRobinFightInfo.getState());
/*     */         
/* 119 */         CrossBattleOwnManager.brdRoundRobinFightResult(activityCfgid, roundIndex, xCrossBattleOwn, corpsAid, corpsBid, xRoundRobinFightInfo.getState());
/*     */         
/* 121 */         break;
/*     */       }
/*     */     }
/*     */     
/* 125 */     List<Long> roleList = new java.util.ArrayList();
/* 126 */     roleList.addAll(((PVPFightFailArg)this.arg).activeRoles);
/* 127 */     roleList.addAll(((PVPFightFailArg)this.arg).passiveRoles);
/* 128 */     CrossBattleOneByOneManager.getInstance().addLogicRunnable(Integer.valueOf(activityCfgid), new RLeaveRoundRobinMap(activityCfgid, roleList));
/*     */     
/*     */ 
/* 131 */     CrossBattleOwnManager.refreshRoundRobinPointRankList(xCrossBattleOwn);
/*     */     
/* 133 */     CrossBattleOwnManager.trySettleRoundRobinRound(xCrossBattleOwn, activityCfgid, roundIndex, averageFightValues);
/*     */     
/* 135 */     StringBuilder sb = new StringBuilder();
/* 136 */     sb.append(String.format("[crossbattle_own]POnPVPFightFail.processImp@pvp fight fail process success|activity_cfg_id=%d|round_index=%d|corps_a_id=%d|corps_b_id=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(roundIndex), Long.valueOf(corpsAid), Long.valueOf(corpsBid) }));
/*     */     
/*     */ 
/* 139 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 140 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(int res, Map<String, Object> extraInfo, int activityCfgid, int roundIndex, long corpsAid, long corpsBid)
/*     */   {
/* 146 */     StringBuilder sb = new StringBuilder();
/* 147 */     sb.append(String.format("[crossbattle_own]POnPVPFightFail.processImp@pvp fight fail process fail|activity_cfg_id=%d|round_index=%d|corps_a_id=%d|corps_b_id=%d|res=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(roundIndex), Long.valueOf(corpsAid), Long.valueOf(corpsBid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 150 */     if (extraInfo != null)
/*     */     {
/* 152 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 154 */         sb.append("|").append((String)entry.getKey());
/* 155 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 158 */     CrossBattleOwnManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\POnPVPFightFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */