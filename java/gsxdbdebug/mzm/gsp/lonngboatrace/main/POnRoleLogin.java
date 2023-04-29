/*     */ package mzm.gsp.lonngboatrace.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.lonngboatrace.SCommandResults;
/*     */ import mzm.gsp.lonngboatrace.SEvent;
/*     */ import mzm.gsp.lonngboatrace.SPhasePrepare;
/*     */ import mzm.gsp.lonngboatrace.SSendCommand;
/*     */ import mzm.gsp.lonngboatrace.SSyncRaceInfo;
/*     */ import mzm.gsp.lonngboatrace.TeamStat;
/*     */ import mzm.gsp.lonngboatrace.confbean.Phase;
/*     */ import mzm.gsp.online.event.PlayerLoginProtectProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.LonngBoatRaceMatch;
/*     */ import xbean.LonngBoatRaceTeamStat;
/*     */ import xtable.Role2lonngboatrace;
/*     */ 
/*     */ public class POnRoleLogin extends PlayerLoginProtectProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  26 */     long roleId = ((Long)this.arg).longValue();
/*     */     
/*  28 */     Long lonngboatraceId = Role2lonngboatrace.get(Long.valueOf(roleId));
/*  29 */     if (lonngboatraceId == null) {
/*  30 */       return false;
/*     */     }
/*     */     
/*  33 */     long teamId = TeamInterface.getTeamidByRoleid(roleId, true).longValue();
/*     */     
/*     */ 
/*  36 */     LonngBoatRaceMatch xLonngBoatRaceMatch = xtable.Lonngboatrace.get(lonngboatraceId);
/*  37 */     if (xLonngBoatRaceMatch == null) {
/*  38 */       return false;
/*     */     }
/*  40 */     int raceId = xLonngBoatRaceMatch.getRaceid();
/*  41 */     Map<Integer, Phase> phaseNo2phase = LonngBoatRaceManager.getPhaseNo2phase(raceId);
/*  42 */     if (phaseNo2phase == null) {
/*  43 */       return false;
/*     */     }
/*  45 */     int phaseNo = xLonngBoatRaceMatch.getPhaseno();
/*  46 */     int roundNo = xLonngBoatRaceMatch.getRoundno();
/*  47 */     int timesNo = xLonngBoatRaceMatch.getTimesno();
/*     */     
/*  49 */     Phase phase = (Phase)phaseNo2phase.get(Integer.valueOf(phaseNo));
/*  50 */     if (phase == null)
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     HashMap<Long, TeamStat> teamId2TeamStat = new HashMap();
/*  56 */     Map<Long, LonngBoatRaceTeamStat> teamId2TeamStatDB = xLonngBoatRaceMatch.getTeamid2teamstat();
/*  57 */     for (Map.Entry<Long, LonngBoatRaceTeamStat> entry : teamId2TeamStatDB.entrySet())
/*     */     {
/*  59 */       teamId2TeamStat.put(entry.getKey(), new TeamStat(((LonngBoatRaceTeamStat)entry.getValue()).getLocation(), ((LonngBoatRaceTeamStat)entry.getValue()).getSpeed()));
/*     */     }
/*     */     
/*     */ 
/*  63 */     OnlineManager.getInstance().send(roleId, new SSyncRaceInfo(xLonngBoatRaceMatch.getRaceid(), xLonngBoatRaceMatch.getMatchbegintimestamp(), teamId2TeamStat));
/*     */     
/*     */ 
/*  66 */     long currTimeStamp = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  68 */     switch (xLonngBoatRaceMatch.getState())
/*     */     {
/*     */ 
/*     */     case 0: 
/*  72 */       return OnlineManager.getInstance().send(roleId, new SPhasePrepare(phase.id, xLonngBoatRaceMatch.getEndtimestamp(), currTimeStamp));
/*     */     
/*     */ 
/*     */     case 1: 
/*  76 */       SSendCommand sendCond = new SSendCommand(phase.id, roundNo, timesNo, new ArrayList(), xLonngBoatRaceMatch.getEndtimestamp(), currTimeStamp);
/*     */       
/*  78 */       sendCond.commandlist.addAll(xLonngBoatRaceMatch.getCommandlist());
/*  79 */       return OnlineManager.getInstance().send(roleId, sendCond);
/*     */     
/*     */ 
/*     */     case 2: 
/*  83 */       Map<Long, Boolean> roleId2IsRightDB = ((LonngBoatRaceTeamStat)teamId2TeamStatDB.get(Long.valueOf(teamId))).getRole2isright_times();
/*  84 */       HashMap<Long, Integer> roleId2IsRight = new HashMap();
/*  85 */       for (Map.Entry<Long, Boolean> entry : roleId2IsRightDB.entrySet())
/*     */       {
/*  87 */         roleId2IsRight.put(entry.getKey(), Integer.valueOf(((Boolean)entry.getValue()).booleanValue() ? 0 : 1));
/*     */       }
/*     */       
/*  90 */       HashMap<Long, Integer> teamId2IsAllRight = new HashMap();
/*  91 */       teamId2IsAllRight.putAll(xLonngBoatRaceMatch.getTeamid2isallright());
/*     */       
/*  93 */       return OnlineManager.getInstance().send(roleId, new SCommandResults(phase.id, teamId2IsAllRight, roleId2IsRight, ((Integer)xLonngBoatRaceMatch.getRoleid2israndom().get(Long.valueOf(roleId))).intValue(), xLonngBoatRaceMatch.getEndtimestamp(), currTimeStamp, 5));
/*     */     
/*     */ 
/*     */ 
/*     */     case 3: 
/*  98 */       HashMap<Long, Integer> teamId2eventId = new HashMap();
/*  99 */       for (Map.Entry<Long, LonngBoatRaceTeamStat> entry : teamId2TeamStatDB.entrySet())
/*     */       {
/* 101 */         teamId2eventId.put(entry.getKey(), Integer.valueOf(((LonngBoatRaceTeamStat)entry.getValue()).getEventid()));
/*     */       }
/* 103 */       return OnlineManager.getInstance().send(roleId, new SEvent(phase.id, ((LonngBoatRaceTeamStat)teamId2TeamStatDB.get(Long.valueOf(teamId))).getEventtriggerid(), teamId2eventId, xLonngBoatRaceMatch.getEndtimestamp(), currTimeStamp, 1));
/*     */     }
/*     */     
/*     */     
/* 107 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */