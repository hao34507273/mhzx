/*     */ package mzm.gsp.lonngboatrace.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.lonngboatrace.SRejectJoin;
/*     */ import mzm.gsp.lonngboatrace.confbean.LonngBoatRaceActivityCfg;
/*     */ import mzm.gsp.lonngboatrace.confbean.Phase;
/*     */ import mzm.gsp.lonngboatrace.confbean.PhaseId2round;
/*     */ import mzm.gsp.lonngboatrace.confbean.PhaseNo2phase;
/*     */ import mzm.gsp.lonngboatrace.confbean.Round2times;
/*     */ import mzm.gsp.lonngboatrace.confbean.STLonngBoatRaceEventTriggerCfg;
/*     */ import mzm.gsp.lonngboatrace.confbean.STLonngBoatRacePhaseCfg;
/*     */ import mzm.gsp.lonngboatrace.confbean.Times2eventType;
/*     */ import mzm.gsp.lonngboatrace.confbean.TriggerEvent;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.LonngBoatRaceAwardRecord;
/*     */ import xbean.LonngBoatRaceMatch;
/*     */ import xbean.LonngBoatRaceStat;
/*     */ import xbean.LonngBoatRaceTeamStat;
/*     */ import xtable.Lonngboatrace;
/*     */ import xtable.Role2lonngboatrace;
/*     */ import xtable.Role2lonngboatraceaward;
/*     */ 
/*     */ public class LonngBoatRaceManager
/*     */ {
/*     */   static void init()
/*     */   {
/*  51 */     for (LonngBoatRaceActivityCfg cfg : LonngBoatRaceActivityCfg.getAll().values())
/*     */     {
/*  53 */       int logicType = SActivityCfg.get(cfg.activityId).activityLogicType;
/*  54 */       ActivityInterface.registerActivityByLogicType(logicType, new LonngBoatRaceHandler());
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean isLonngBoatRaceOpenForRole(long roleId, int activityId)
/*     */   {
/*  60 */     return isLonngBoatRaceOpenForRole(roleId, activityId, true);
/*     */   }
/*     */   
/*     */   static boolean isLonngBoatRaceOpenForRole(long roldId, int activityId, boolean isSendTip)
/*     */   {
/*  65 */     LonngBoatRaceActivityCfg cfg = LonngBoatRaceActivityCfg.get(activityId);
/*  66 */     if (cfg == null)
/*     */     {
/*  68 */       return false;
/*     */     }
/*  70 */     return OpenInterface.getOpenStatus(cfg.switchId);
/*     */   }
/*     */   
/*     */   static boolean checkNpcService(long roleId, int activityId)
/*     */   {
/*  75 */     LonngBoatRaceActivityCfg cfg = LonngBoatRaceActivityCfg.get(activityId);
/*  76 */     if (!NpcInterface.checkNpcService(cfg.npcId, cfg.joinActivityServiceId, roleId))
/*     */     {
/*  78 */       return false;
/*     */     }
/*  80 */     return true;
/*     */   }
/*     */   
/*     */   static void sendCantJoinReason(long roleId, int activityId, List<Long> teamMember, ActivityJoinResult activityJoinResult)
/*     */   {
/*  85 */     ArrayList<String> params = new ArrayList();
/*  86 */     int levelMin = SActivityCfg.get(activityId).levelMin;
/*     */     
/*  88 */     if (activityJoinResult.isRoleLevelWrong())
/*     */     {
/*     */ 
/*  91 */       for (Long ri : teamMember)
/*     */       {
/*  93 */         int roleLevel = RoleInterface.getLevel(ri.longValue());
/*  94 */         if (roleLevel < levelMin)
/*  95 */           params.add(RoleInterface.getName(ri.longValue()));
/*     */       }
/*  97 */       OnlineManager.getInstance().sendAtOnce(roleId, new SRejectJoin(1, params));
/*  98 */       return;
/*     */     }
/*     */     
/* 101 */     if (activityJoinResult.isPerSonCountWrong())
/*     */     {
/* 103 */       OnlineManager.getInstance().sendAtOnce(roleId, new SRejectJoin(0, null));
/* 104 */       return;
/*     */     }
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
/*     */   static boolean nextAction(long lonngboatraceId, Map<Integer, Phase> phaseNo2phase)
/*     */   {
/* 118 */     LonngBoatRaceMatch xLonngBoatRaceMatch = Lonngboatrace.get(Long.valueOf(lonngboatraceId));
/* 119 */     if (xLonngBoatRaceMatch == null) {
/* 120 */       return false;
/*     */     }
/*     */     
/* 123 */     int phaseNo = xLonngBoatRaceMatch.getPhaseno();
/* 124 */     int roundNo = xLonngBoatRaceMatch.getRoundno();
/* 125 */     int timesNo = xLonngBoatRaceMatch.getTimesno();
/*     */     
/* 127 */     Phase phase = (Phase)phaseNo2phase.get(Integer.valueOf(phaseNo));
/* 128 */     if (phase == null) {
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     timesNo++;
/* 133 */     if (timesNo <= phase.timesCount)
/*     */     {
/* 135 */       xLonngBoatRaceMatch.setTimesno(timesNo);
/* 136 */       GameServer.logger().info(String.format("[lonngboatrace]LonngBoatRaceManager.nextAction@lonngboatrace next action:TimesAction|lonngboatraceid=%d|phaseno=%d|roundno=%d|timesno=%d", new Object[] { Long.valueOf(lonngboatraceId), Integer.valueOf(phaseNo), Integer.valueOf(roundNo), Integer.valueOf(timesNo) }));
/*     */       
/*     */ 
/* 139 */       return new TimesAction(phaseNo2phase, lonngboatraceId).commandAction();
/*     */     }
/*     */     
/*     */ 
/* 143 */     roundNo++;
/* 144 */     if (roundNo <= phase.roundCount)
/*     */     {
/*     */ 
/* 147 */       xLonngBoatRaceMatch.setRoundno(roundNo);
/* 148 */       xLonngBoatRaceMatch.setTimesno(0);
/* 149 */       GameServer.logger().info(String.format("[lonngboatrace]LonngBoatRaceManager.nextAction@lonngboatrace next action:nextAction|lonngboatraceid=%d|phaseno=%d|roundno=%d|timesno=%d", new Object[] { Long.valueOf(lonngboatraceId), Integer.valueOf(phaseNo), Integer.valueOf(roundNo), Integer.valueOf(0) }));
/*     */       
/*     */ 
/* 152 */       return nextAction(lonngboatraceId, phaseNo2phase);
/*     */     }
/*     */     
/* 155 */     phaseNo++;
/* 156 */     if (phaseNo2phase.containsKey(Integer.valueOf(phaseNo)))
/*     */     {
/* 158 */       xLonngBoatRaceMatch.setPhaseno(phaseNo);
/* 159 */       xLonngBoatRaceMatch.setRoundno(1);
/* 160 */       xLonngBoatRaceMatch.setTimesno(0);
/* 161 */       GameServer.logger().info(String.format("[lonngboatrace]LonngBoatRaceManager.nextAction@lonngboatrace next action:PhaseAction|lonngboatraceid=%d|phaseno=%d|roundno=%d|timesno=%d", new Object[] { Long.valueOf(lonngboatraceId), Integer.valueOf(phaseNo), Integer.valueOf(1), Integer.valueOf(0) }));
/*     */       
/*     */ 
/* 164 */       return new PhaseAction(phaseNo2phase, lonngboatraceId).prepare();
/*     */     }
/*     */     
/* 167 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Phase> getPhaseNo2phase(int raceId)
/*     */   {
/* 178 */     STLonngBoatRacePhaseCfg phaseCfg = (STLonngBoatRacePhaseCfg)((Map.Entry)STLonngBoatRacePhaseCfg.getAll().entrySet().iterator().next()).getValue();
/* 179 */     if ((phaseCfg == null) || (phaseCfg.raceId2phaseNos == null)) {
/* 180 */       return null;
/*     */     }
/* 182 */     PhaseNo2phase phaseNo2phase = (PhaseNo2phase)phaseCfg.raceId2phaseNos.get(Integer.valueOf(raceId));
/* 183 */     if (phaseNo2phase == null)
/* 184 */       return null;
/* 185 */     return phaseNo2phase.phaseNo2phase;
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
/*     */   static TriggerEvent getTriggerEvent(int raceId, int phaseId, int round, int times)
/*     */   {
/* 199 */     STLonngBoatRaceEventTriggerCfg triggerCfg = (STLonngBoatRaceEventTriggerCfg)((Map.Entry)STLonngBoatRaceEventTriggerCfg.getAll().entrySet().iterator().next()).getValue();
/* 200 */     if ((triggerCfg == null) || (triggerCfg.raceId2phaseId == null)) {
/* 201 */       return null;
/*     */     }
/* 203 */     PhaseId2round phaseId2round = (PhaseId2round)triggerCfg.raceId2phaseId.get(Integer.valueOf(raceId));
/* 204 */     if ((phaseId2round == null) || (phaseId2round.phaseId2round == null)) {
/* 205 */       return null;
/*     */     }
/* 207 */     Round2times round2times = (Round2times)phaseId2round.phaseId2round.get(Integer.valueOf(phaseId));
/* 208 */     if ((round2times == null) || (round2times.round2times == null)) {
/* 209 */       return null;
/*     */     }
/* 211 */     Times2eventType times2eventType = (Times2eventType)round2times.round2times.get(Integer.valueOf(round));
/* 212 */     if ((times2eventType == null) || (times2eventType.times2eventType == null))
/* 213 */       return null;
/* 214 */     return (TriggerEvent)times2eventType.times2eventType.get(Integer.valueOf(times));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<Long> getRoleIdsFromLonngBoatRaceMatch(LonngBoatRaceMatch xLonngBoatRaceMatch)
/*     */   {
/* 225 */     Map<Long, LonngBoatRaceTeamStat> teamId2stat = xLonngBoatRaceMatch.getTeamid2teamstat();
/* 226 */     List<Long> result = new LinkedList();
/* 227 */     if (teamId2stat == null) {
/* 228 */       return result;
/*     */     }
/* 230 */     for (Map.Entry<Long, LonngBoatRaceTeamStat> entry : teamId2stat.entrySet())
/*     */     {
/* 232 */       Long teamId = (Long)entry.getKey();
/*     */       
/* 234 */       if (teamId.longValue() >= 0L)
/*     */       {
/*     */ 
/* 237 */         result.addAll(((LonngBoatRaceTeamStat)entry.getValue()).getRole2stat().keySet()); }
/*     */     }
/* 239 */     return result;
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
/*     */ 
/*     */   static void updateBoatLocationAndSpeed(Map<Long, LonngBoatRaceTeamStat> teamId2Stat, int time, Map<Long, Float> teamId2SpeedDelta)
/*     */   {
/* 254 */     for (Map.Entry<Long, LonngBoatRaceTeamStat> entry : teamId2Stat.entrySet())
/*     */     {
/* 256 */       LonngBoatRaceTeamStat xLonngBoatRaceTeamStat = (LonngBoatRaceTeamStat)entry.getValue();
/*     */       
/* 258 */       float location = xLonngBoatRaceTeamStat.getLocation();
/* 259 */       float speed = xLonngBoatRaceTeamStat.getSpeed();
/* 260 */       location += speed * time;
/* 261 */       xLonngBoatRaceTeamStat.setLocation(location);
/*     */       
/*     */ 
/* 264 */       if (teamId2SpeedDelta != null)
/*     */       {
/* 266 */         speed += ((Float)teamId2SpeedDelta.get(entry.getKey())).floatValue();
/* 267 */         xLonngBoatRaceTeamStat.setSpeed(speed);
/*     */       }
/*     */     }
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
/*     */ 
/*     */   static void updateBoatLocationAndSpeed(Map<Long, LonngBoatRaceTeamStat> teamId2Stat, int time, HashMap<Long, Integer> teamId2isAllRight, Phase phase)
/*     */   {
/* 284 */     float speedUpUnit = (float)phase.speedUpUnit;
/* 285 */     float speedDownUnit = (float)phase.speedDownUnit;
/* 286 */     float speedMax = (float)phase.maxSpeed;
/* 287 */     float speedMin = (float)phase.minSpeed;
/*     */     
/* 289 */     for (Map.Entry<Long, LonngBoatRaceTeamStat> entry : teamId2Stat.entrySet())
/*     */     {
/* 291 */       LonngBoatRaceTeamStat xLonngBoatRaceTeamStat = (LonngBoatRaceTeamStat)entry.getValue();
/*     */       
/* 293 */       float location = xLonngBoatRaceTeamStat.getLocation();
/* 294 */       float speed = xLonngBoatRaceTeamStat.getSpeed();
/* 295 */       location += speed * time;
/* 296 */       xLonngBoatRaceTeamStat.setLocation(location);
/*     */       
/*     */ 
/* 299 */       if (((Integer)teamId2isAllRight.get(entry.getKey())).intValue() == 0)
/*     */       {
/* 301 */         float tmp = speed + speedUpUnit;
/* 302 */         speed = tmp > speedMax ? speedMax : tmp;
/*     */       }
/*     */       else
/*     */       {
/* 306 */         float tmp = speed - speedDownUnit;
/* 307 */         speed = tmp < speedMin ? speedMin : tmp;
/*     */       }
/* 309 */       xLonngBoatRaceTeamStat.setSpeed(speed);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void resetRole2Stat_phase(LonngBoatRaceMatch xLonngBoatRaceMatch)
/*     */   {
/* 320 */     Map<Long, LonngBoatRaceTeamStat> teamId2teamStat = xLonngBoatRaceMatch.getTeamid2teamstat();
/*     */     
/*     */ 
/*     */ 
/* 324 */     for (Map.Entry<Long, LonngBoatRaceTeamStat> teamStatEntry : teamId2teamStat.entrySet())
/*     */     {
/*     */ 
/* 327 */       if (((Long)teamStatEntry.getKey()).longValue() >= 0L)
/*     */       {
/* 329 */         LonngBoatRaceTeamStat teamStat = (LonngBoatRaceTeamStat)teamStatEntry.getValue();
/* 330 */         Map<Long, LonngBoatRaceStat> roleId2RaceStat = teamStat.getRole2stat_phase();
/* 331 */         for (Map.Entry<Long, LonngBoatRaceStat> raceStatEntry : roleId2RaceStat.entrySet())
/*     */         {
/* 333 */           LonngBoatRaceStat boatRaceStat = (LonngBoatRaceStat)raceStatEntry.getValue();
/* 334 */           boatRaceStat.setRight(0);
/* 335 */           boatRaceStat.setWrong(0);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void clearRole2isright_times(LonngBoatRaceMatch xLonngBoatRaceMatch)
/*     */   {
/* 347 */     Map<Long, LonngBoatRaceTeamStat> teamId2teamStat = xLonngBoatRaceMatch.getTeamid2teamstat();
/*     */     
/* 349 */     for (Map.Entry<Long, LonngBoatRaceTeamStat> teamStatEntry : teamId2teamStat.entrySet())
/*     */     {
/*     */ 
/* 352 */       if (((Long)teamStatEntry.getKey()).longValue() >= 0L)
/*     */       {
/* 354 */         LonngBoatRaceTeamStat xTeamStat = (LonngBoatRaceTeamStat)teamStatEntry.getValue();
/* 355 */         xTeamStat.getRole2isright_times().clear();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkCommand(List<Integer> requiredList, List<Integer> receivedList)
/*     */   {
/* 368 */     if ((receivedList == null) || (requiredList == null))
/* 369 */       return false;
/* 370 */     if (receivedList.size() != requiredList.size())
/* 371 */       return false;
/* 372 */     for (int i = 0; i < requiredList.size(); i++)
/*     */     {
/* 374 */       if (!((Integer)requiredList.get(i)).equals(receivedList.get(i)))
/* 375 */         return false;
/*     */     }
/* 377 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void updateRoleStat(LonngBoatRaceTeamStat xLonngBoatRaceTeamStat, boolean isCorrect, long roleId)
/*     */   {
/* 389 */     if (xLonngBoatRaceTeamStat.getRole2isright_times().containsKey(Long.valueOf(roleId)))
/*     */     {
/* 391 */       return;
/*     */     }
/*     */     
/* 394 */     xLonngBoatRaceTeamStat.getRole2isright_times().put(Long.valueOf(roleId), Boolean.valueOf(isCorrect));
/*     */     
/* 396 */     LonngBoatRaceStat raceStat_phase = (LonngBoatRaceStat)xLonngBoatRaceTeamStat.getRole2stat_phase().get(Long.valueOf(roleId));
/*     */     
/* 398 */     LonngBoatRaceStat raceStat = (LonngBoatRaceStat)xLonngBoatRaceTeamStat.getRole2stat().get(Long.valueOf(roleId));
/* 399 */     if (isCorrect)
/*     */     {
/* 401 */       raceStat_phase.setRight(raceStat_phase.getRight() + 1);
/* 402 */       raceStat.setRight(raceStat.getRight() + 1);
/*     */     }
/*     */     else
/*     */     {
/* 406 */       raceStat_phase.setWrong(raceStat_phase.getWrong() + 1);
/* 407 */       raceStat.setWrong(raceStat.getWrong() + 1);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void awardForAll(int activityId, LonngBoatRaceMatch xLonngBoatRaceMatch)
/*     */   {
/* 420 */     Map<Long, Long> rankList = getRankList(xLonngBoatRaceMatch);
/*     */     
/* 422 */     Map<Long, LonngBoatRaceTeamStat> teamId2TeamStat = xLonngBoatRaceMatch.getTeamid2teamstat();
/*     */     
/* 424 */     for (Map.Entry<Long, LonngBoatRaceTeamStat> entry : teamId2TeamStat.entrySet())
/*     */     {
/* 426 */       awardForTeam(activityId, ((Long)entry.getKey()).longValue(), (LonngBoatRaceTeamStat)entry.getValue(), rankList);
/*     */     }
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
/*     */   static void awardForTeam(int activityId, long teamId, LonngBoatRaceTeamStat xTeamStat, Map<Long, Long> rankList)
/*     */   {
/* 441 */     int awardId = getAwardId(rankList, teamId, activityId);
/* 442 */     AwardReason reason = getAwardReasonByAwardId(awardId, activityId);
/*     */     
/*     */ 
/* 445 */     awardForRole(xTeamStat.getRole2stat().keySet(), awardId, reason, activityId);
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
/*     */   private static void awardForRole(Set<Long> memberList, int awardId, AwardReason reason, int activityId)
/*     */   {
/* 458 */     long currentTimeStamp = DateTimeUtils.getCurrTimeInMillis();
/* 459 */     int maxAwardTimesPerDay = LonngBoatRaceActivityCfg.get(activityId).awardCount;
/*     */     
/* 461 */     for (Long roleId : memberList)
/*     */     {
/* 463 */       LonngBoatRaceAwardRecord xAwardRecord = Role2lonngboatraceaward.get(roleId);
/* 464 */       if (xAwardRecord == null)
/*     */       {
/* 466 */         xAwardRecord = xbean.Pod.newLonngBoatRaceAwardRecord();
/* 467 */         doAward(roleId.longValue(), awardId, reason, xAwardRecord);
/* 468 */         Role2lonngboatraceaward.insert(roleId, xAwardRecord);
/*     */ 
/*     */ 
/*     */       }
/* 472 */       else if ((DateTimeUtils.diffDays(currentTimeStamp, xAwardRecord.getTimestamp()) != 0) || (xAwardRecord.getAwardcount() < maxAwardTimesPerDay))
/*     */       {
/*     */ 
/*     */ 
/* 476 */         doAward(roleId.longValue(), awardId, reason, xAwardRecord);
/*     */       }
/*     */     }
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
/*     */   private static void doAward(long roleId, int awardId, AwardReason reason, LonngBoatRaceAwardRecord xAwardRecord)
/*     */   {
/* 491 */     AwardInterface.award(awardId, RoleInterface.getUserId(roleId), roleId, false, true, reason);
/*     */     
/* 493 */     long timeStamp = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*     */ 
/* 496 */     xAwardRecord.setTimestamp(timeStamp);
/* 497 */     xAwardRecord.setAwardcount(xAwardRecord.getAwardcount() + 1);
/*     */     
/* 499 */     GameServer.logger().info(String.format("[lonngboatrace]LonngBoatRaceManager.doAward@lonngboatrace award for role|roleid=%d|awardid=%d|awardcount=%d|timestamp=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(awardId), Integer.valueOf(xAwardRecord.getAwardcount()), DateTimeUtils.formatTimestamp(timeStamp) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Long, Long> getRankList(LonngBoatRaceMatch xLonngBoatRaceMatch)
/*     */   {
/* 509 */     long beginTimeStamp = xLonngBoatRaceMatch.getMatchbegintimestamp();
/* 510 */     Map<Long, LonngBoatRaceTeamStat> teamId2TeamStat = xLonngBoatRaceMatch.getTeamid2teamstat();
/* 511 */     Map<Long, Long> teamId2MatchTime = new HashMap();
/* 512 */     for (Map.Entry<Long, LonngBoatRaceTeamStat> entry : teamId2TeamStat.entrySet())
/*     */     {
/* 514 */       teamId2MatchTime.put(entry.getKey(), Long.valueOf(((LonngBoatRaceTeamStat)entry.getValue()).getEndtimestamp() - beginTimeStamp));
/*     */     }
/*     */     
/* 517 */     List<Map.Entry<Long, Long>> list = new LinkedList(teamId2MatchTime.entrySet());
/* 518 */     Collections.sort(list, new Comparator()
/*     */     {
/*     */ 
/*     */       public int compare(Map.Entry<Long, Long> o1, Map.Entry<Long, Long> o2)
/*     */       {
/* 523 */         return ((Long)o1.getValue()).compareTo((Long)o2.getValue());
/*     */       }
/*     */       
/* 526 */     });
/* 527 */     Map<Long, Long> result = new LinkedHashMap();
/* 528 */     StringBuilder logRandList = new StringBuilder("[lonngboatrace]LonngBoatRaceManager.getRankList@lonngboatrace get rank list");
/*     */     
/* 530 */     for (Map.Entry<Long, Long> entry : list)
/*     */     {
/* 532 */       result.put(entry.getKey(), entry.getValue());
/* 533 */       logRandList.append(String.format("|teamid:%d|matchtime:%d", new Object[] { entry.getKey(), entry.getValue() }));
/*     */     }
/* 535 */     GameServer.logger().info(logRandList.toString());
/* 536 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   static int getAwardId(Map<Long, Long> rankList, long teamId, int activityId)
/*     */   {
/* 542 */     long aiShortestTime = 0L;
/* 543 */     for (Map.Entry<Long, Long> entry : rankList.entrySet())
/*     */     {
/* 545 */       if (((Long)entry.getKey()).longValue() <= 0L)
/*     */       {
/* 547 */         aiShortestTime = ((Long)entry.getValue()).longValue();
/*     */       }
/*     */     }
/* 550 */     long teamMatchTime = ((Long)rankList.get(Long.valueOf(teamId))).longValue();
/* 551 */     LonngBoatRaceActivityCfg activityCfg = LonngBoatRaceActivityCfg.get(activityId);
/* 552 */     if (aiShortestTime < teamMatchTime)
/*     */     {
/* 554 */       return activityCfg.minAwardId;
/*     */     }
/*     */     
/*     */ 
/* 558 */     if (teamMatchTime > activityCfg.awardTimeThreshold * 1000)
/*     */     {
/* 560 */       return activityCfg.middleAwardId;
/*     */     }
/*     */     
/*     */ 
/* 564 */     return activityCfg.bestAwardId;
/*     */   }
/*     */   
/*     */   static AwardReason getAwardReasonByAwardId(int awardId, int activityId)
/*     */   {
/* 569 */     LonngBoatRaceActivityCfg activityCfg = LonngBoatRaceActivityCfg.get(activityId);
/* 570 */     if (awardId == activityCfg.bestAwardId)
/*     */     {
/* 572 */       return new AwardReason(LogReason.ACTIVITY_LONNG_BOAT_RACE_BEST_AWARD);
/*     */     }
/* 574 */     if (awardId == activityCfg.middleAwardId)
/*     */     {
/* 576 */       return new AwardReason(LogReason.ACTIVITY_LONNG_BOAT_RACE_MIDDLE_AWARD);
/*     */     }
/* 578 */     if (awardId == activityCfg.minAwardId)
/*     */     {
/* 580 */       return new AwardReason(LogReason.ACTIVITY_LONNG_BOAT_RACE_MIN_AWARD);
/*     */     }
/* 582 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void deleteMatchRecordAndStatus(List<Long> members)
/*     */   {
/* 592 */     if ((members == null) || (members.size() == 0)) {
/* 593 */       return;
/*     */     }
/*     */     
/* 596 */     Long lonngboatraceid = null;
/*     */     
/* 598 */     for (Long roleId : members)
/*     */     {
/* 600 */       if (roleId.longValue() > 0L)
/*     */       {
/* 602 */         lonngboatraceid = Role2lonngboatrace.get(roleId);
/* 603 */         if (lonngboatraceid != null)
/*     */         {
/* 605 */           Role2lonngboatrace.delete(roleId);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 610 */     GameServer.logger().info(String.format("[lonngboatrace]LonngBoatRaceManager.deleteMatchRecordAndStatus@lonngboatrace delete match record done|lonngboatraceid=%d|rolelist=%s", new Object[] { lonngboatraceid, Arrays.toString(members.toArray()) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 615 */     RoleStatusInterface.unsetStatus(members, 1361);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\main\LonngBoatRaceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */