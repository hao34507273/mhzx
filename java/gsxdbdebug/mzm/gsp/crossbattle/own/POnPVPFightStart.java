/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.fight.event.PVPFightStartArg;
/*     */ import mzm.gsp.fight.event.PVPFightStartProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleOwn;
/*     */ import xbean.RoundRobinFightInfo;
/*     */ import xbean.RoundRobinRoundInfo;
/*     */ import xtable.Cross_battle_owns;
/*     */ 
/*     */ public class POnPVPFightStart extends PVPFightStartProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  20 */     if (!(((PVPFightStartArg)this.arg).context instanceof RoundRobinFightContext))
/*     */     {
/*  22 */       return false;
/*     */     }
/*  24 */     RoundRobinFightContext context = (RoundRobinFightContext)((PVPFightStartArg)this.arg).context;
/*  25 */     int activityCfgid = context.activityCfgid;
/*  26 */     int roundIndex = context.roundIndex;
/*  27 */     long corpsAid = context.corpsAid;
/*  28 */     long corpsBid = context.corpsBid;
/*     */     
/*  30 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(activityCfgid);
/*  31 */     if (cfg == null)
/*     */     {
/*     */ 
/*  34 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  38 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/*  39 */     CrossBattleOwn xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/*  40 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() == -1))
/*     */     {
/*     */ 
/*  43 */       onFail(4, null, activityCfgid, roundIndex, corpsAid, corpsBid);
/*  44 */       return false;
/*     */     }
/*  46 */     if (xCrossBattleOwn.getStage() != 2)
/*     */     {
/*     */ 
/*  49 */       onFail(5, null, activityCfgid, roundIndex, corpsAid, corpsBid);
/*  50 */       return false;
/*     */     }
/*  52 */     if (CrossBattleOwnManager.isRoundRobinRoundEnd(xCrossBattleOwn, roundIndex))
/*     */     {
/*     */ 
/*  55 */       onFail(6, null, activityCfgid, roundIndex, corpsAid, corpsBid);
/*  56 */       return false;
/*     */     }
/*  58 */     RoundRobinRestartInfo restartInfo = RoundRobinRestartManager.getInstance().getRestartInfo(activityCfgid);
/*  59 */     if ((restartInfo == null) && (xCrossBattleOwn.getRound_robin_round_index() != roundIndex))
/*     */     {
/*     */ 
/*  62 */       onFail(7, null, activityCfgid, roundIndex, corpsAid, corpsBid);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     RoundRobinRoundInfo xRoundRobinRoundInfo = (RoundRobinRoundInfo)xCrossBattleOwn.getRound_robin_round_infos().get(roundIndex - 1);
/*  67 */     for (RoundRobinFightInfo xRoundRobinFightInfo : xRoundRobinRoundInfo.getFight_infos())
/*     */     {
/*  69 */       if ((xRoundRobinFightInfo.getCorps_a_id() == corpsAid) && (xRoundRobinFightInfo.getCorps_b_id() == corpsBid))
/*     */       {
/*  71 */         if (CrossBattleOwnManager.isRoundRobinFightEnd(xRoundRobinFightInfo))
/*     */         {
/*     */ 
/*  74 */           onFail(8, null, activityCfgid, roundIndex, corpsAid, corpsBid);
/*  75 */           return false;
/*     */         }
/*  77 */         if ((!((PVPFightStartArg)this.arg).activeRoles.isEmpty()) && (!((PVPFightStartArg)this.arg).passiveRoles.isEmpty()))
/*     */         {
/*  79 */           xRoundRobinFightInfo.setCorps_a_watch_roleid(((Long)((PVPFightStartArg)this.arg).activeRoles.get(0)).longValue());
/*  80 */           xRoundRobinFightInfo.setCorps_b_watch_roleid(((Long)((PVPFightStartArg)this.arg).passiveRoles.get(0)).longValue()); break;
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*  85 */         onFail(9, null, activityCfgid, roundIndex, corpsAid, corpsBid);
/*     */         
/*  87 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  93 */     StringBuilder sb = new StringBuilder();
/*  94 */     sb.append(String.format("[crossbattle_own]POnPVPFightStart.processImp@pvp fight start process success|activity_cfg_id=%d|round_index=%d|corps_a_id=%d|corps_b_id=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(roundIndex), Long.valueOf(corpsAid), Long.valueOf(corpsBid) }));
/*     */     
/*     */ 
/*  97 */     CrossBattleOwnManager.logger.info(sb.toString());
/*  98 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(int res, Map<String, Object> extraInfo, int activityCfgid, int roundIndex, long corpsAid, long corpsBid)
/*     */   {
/* 104 */     StringBuilder sb = new StringBuilder();
/* 105 */     sb.append(String.format("[crossbattle_own]POnPVPFightStart.processImp@pvp fight start process fail|activity_cfg_id=%d|round_index=%d|corps_a_id=%d|corps_b_id=%d|res=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(roundIndex), Long.valueOf(corpsAid), Long.valueOf(corpsBid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 108 */     if (extraInfo != null)
/*     */     {
/* 110 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 112 */         sb.append("|").append((String)entry.getKey());
/* 113 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 116 */     CrossBattleOwnManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\POnPVPFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */