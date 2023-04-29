/*     */ package mzm.gsp.lonngboatrace.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.lonngboatrace.SPhasePrepare;
/*     */ import mzm.gsp.lonngboatrace.confbean.LonngBoatRaceCfg;
/*     */ import mzm.gsp.lonngboatrace.confbean.Phase;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.LonngBoatRaceMatch;
/*     */ import xbean.LonngBoatRaceTeamStat;
/*     */ import xtable.Lonngboatrace;
/*     */ 
/*     */ public class PhaseAction
/*     */ {
/*     */   final Map<Integer, Phase> phaseNo2phase;
/*     */   final long lonngboatraceId;
/*     */   
/*     */   public PhaseAction(Map<Integer, Phase> phaseNo2phase, long lonngboatraceId)
/*     */   {
/*  27 */     this.phaseNo2phase = phaseNo2phase;
/*  28 */     this.lonngboatraceId = lonngboatraceId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean prepare()
/*     */   {
/*  38 */     LonngBoatRaceMatch xLonngBoatRaceMatch = Lonngboatrace.get(Long.valueOf(this.lonngboatraceId));
/*     */     
/*  40 */     int phaseNo = xLonngBoatRaceMatch.getPhaseno();
/*  41 */     Phase phase = (Phase)this.phaseNo2phase.get(Integer.valueOf(phaseNo));
/*     */     
/*  43 */     List<Long> allReceiver = LonngBoatRaceManager.getRoleIdsFromLonngBoatRaceMatch(xLonngBoatRaceMatch);
/*  44 */     long currTimeStamp = DateTimeUtils.getCurrTimeInMillis();
/*  45 */     long endTimeStampInMillis = phase.prepareTime * 1000 + currTimeStamp;
/*     */     
/*     */ 
/*  48 */     xLonngBoatRaceMatch.setState(0);
/*  49 */     xLonngBoatRaceMatch.setEndtimestamp(endTimeStampInMillis);
/*  50 */     LonngBoatRaceManager.resetRole2Stat_phase(xLonngBoatRaceMatch);
/*     */     
/*     */ 
/*  53 */     new PhasePrepareSession(phase.prepareTime, this.lonngboatraceId);
/*     */     
/*  55 */     OnlineManager.getInstance().sendMulti(new SPhasePrepare(phase.id, endTimeStampInMillis, currTimeStamp), allReceiver);
/*     */     
/*  57 */     GameServer.logger().info(String.format("[lonngboatrace]PhaseAction.prepare@lonngboatrace phase prepare begin|phaseno=%d|lonngboatraceId=%d|endTimeStampInMillis=%d", new Object[] { Integer.valueOf(phaseNo), Long.valueOf(this.lonngboatraceId), Long.valueOf(endTimeStampInMillis) }));
/*     */     
/*     */ 
/*  60 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   class PhasePrepareSession
/*     */     extends Session
/*     */   {
/*     */     public PhasePrepareSession(long interval, long roleId)
/*     */     {
/*  73 */       super(roleId);
/*     */     }
/*     */     
/*     */ 
/*     */     protected void onTimeOut()
/*     */     {
/*  79 */       new PhaseAction.PhasePrepareProcedure(PhaseAction.this).execute();
/*     */     }
/*     */   }
/*     */   
/*     */   class PhasePrepareProcedure extends LogicProcedure
/*     */   {
/*     */     PhasePrepareProcedure() {}
/*     */     
/*     */     protected boolean processImp() throws Exception {
/*  88 */       LonngBoatRaceMatch xLonngBoatRaceMatch = Lonngboatrace.get(Long.valueOf(PhaseAction.this.lonngboatraceId));
/*     */       
/*  90 */       int phaseNo = xLonngBoatRaceMatch.getPhaseno();
/*  91 */       Phase phase = (Phase)PhaseAction.this.phaseNo2phase.get(Integer.valueOf(phaseNo));
/*  92 */       int raceId = xLonngBoatRaceMatch.getRaceid();
/*     */       
/*     */ 
/*  95 */       Map<Long, LonngBoatRaceTeamStat> teamId2TeamStat = xLonngBoatRaceMatch.getTeamid2teamstat();
/*  96 */       Map<Long, Float> teamId2SpeedDelta = new HashMap();
/*  97 */       for (Map.Entry<Long, LonngBoatRaceTeamStat> entry : teamId2TeamStat.entrySet())
/*     */       {
/*  99 */         if (phaseNo == 1) {
/* 100 */           teamId2SpeedDelta.put(entry.getKey(), Float.valueOf((float)LonngBoatRaceCfg.get(raceId).boatInitSpeed));
/*     */         } else
/* 102 */           teamId2SpeedDelta.put(entry.getKey(), Float.valueOf(0.0F));
/*     */       }
/* 104 */       LonngBoatRaceManager.updateBoatLocationAndSpeed(teamId2TeamStat, phase.prepareTime, teamId2SpeedDelta);
/*     */       
/* 106 */       GameServer.logger().info(String.format("[lonngboatrace]PhaseAction.PhasePrepareProcedure.processImp@lonngboatrace phase prepare done|phaseno=%d|lonngboatraceId=%d", new Object[] { Integer.valueOf(phaseNo), Long.valueOf(PhaseAction.this.lonngboatraceId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 111 */       return LonngBoatRaceManager.nextAction(PhaseAction.this.lonngboatraceId, PhaseAction.this.phaseNo2phase);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\main\PhaseAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */