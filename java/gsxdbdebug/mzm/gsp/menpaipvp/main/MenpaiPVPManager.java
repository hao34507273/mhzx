/*     */ package mzm.gsp.menpaipvp.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.map.main.CloneRoleNpcModelType;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.menpaipvp.SFightTimesAwardNotify;
/*     */ import mzm.gsp.menpaipvp.SMatchCountDownBrd;
/*     */ import mzm.gsp.menpaipvp.SMenpaiPVPNormalResult;
/*     */ import mzm.gsp.menpaipvp.SReachMaxLoseTimesNotify;
/*     */ import mzm.gsp.menpaipvp.SStageBrd;
/*     */ import mzm.gsp.menpaipvp.SSyncScore;
/*     */ import mzm.gsp.menpaipvp.confbean.SMenpaiPVPConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MenpaiPVP;
/*     */ import xbean.MenpaiPVPCharts;
/*     */ import xbean.MenpaiPVPScore;
/*     */ import xbean.Pod;
/*     */ import xio.Protocol;
/*     */ import xtable.Menpaipvp;
/*     */ import xtable.Menpaipvpcharts;
/*     */ import xtable.Menpaipvpscore;
/*     */ 
/*     */ 
/*     */ class MenpaiPVPManager
/*     */ {
/*  48 */   static Logger logger = Logger.getLogger("MenpaiPVP");
/*     */   
/*  50 */   static Map<Integer, MenpaiPVPChart> menpai2Chart = new TreeMap();
/*     */   
/*     */   static void init() {
/*  53 */     for (Iterator i$ = MenpaiPVPConfigManager.getInstance().getAllMenpai().iterator(); i$.hasNext();) { int menpai = ((Integer)i$.next()).intValue();
/*  54 */       menpai2Chart.put(Integer.valueOf(menpai), new MenpaiPVPChart(menpai, MenpaiPVPConfigManager.getInstance().getScoreChartCapcity(), MenpaiPVPConfigManager.getInstance().getScoreChartCapcity()));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static MenpaiPVPChart getChart(int menpai)
/*     */   {
/*  61 */     return (MenpaiPVPChart)menpai2Chart.get(Integer.valueOf(menpai));
/*     */   }
/*     */   
/*     */   static void clearCharts()
/*     */   {
/*  66 */     for (MenpaiPVPChart chart : menpai2Chart.values()) {
/*  67 */       chart.clear();
/*     */     }
/*     */   }
/*     */   
/*     */   static Map<Integer, Long> getMenpaiChampions() {
/*  72 */     Map<Integer, Long> menpai2Champion = new TreeMap();
/*  73 */     for (Map.Entry<Integer, MenpaiPVPChart> entry : menpai2Chart.entrySet()) {
/*  74 */       int menpai = ((Integer)entry.getKey()).intValue();
/*  75 */       MenpaiPVPChart chart = (MenpaiPVPChart)entry.getValue();
/*  76 */       Long champion = (Long)chart.getKeyByRank(0);
/*  77 */       if (champion != null) {
/*  78 */         menpai2Champion.put(Integer.valueOf(menpai), champion);
/*     */       }
/*     */     }
/*     */     
/*  82 */     return menpai2Champion;
/*     */   }
/*     */   
/*     */   static MenpaiPVP getXMenpaiPVPIfNotExist()
/*     */   {
/*  87 */     long key = GameServerInfoManager.getLocalId();
/*  88 */     MenpaiPVP xMenpaiPVP = Menpaipvp.get(Long.valueOf(key));
/*  89 */     if (xMenpaiPVP == null) {
/*  90 */       xMenpaiPVP = Pod.newMenpaiPVP();
/*  91 */       Menpaipvp.insert(Long.valueOf(key), xMenpaiPVP);
/*     */     }
/*  93 */     return xMenpaiPVP;
/*     */   }
/*     */   
/*     */   static MenpaiPVP getXMenpaiPVP(boolean remainLock) {
/*  97 */     long key = GameServerInfoManager.getLocalId();
/*  98 */     MenpaiPVP xMenpaiPVP = null;
/*  99 */     if (remainLock) {
/* 100 */       xMenpaiPVP = Menpaipvp.get(Long.valueOf(key));
/*     */     }
/*     */     else {
/* 103 */       xMenpaiPVP = Menpaipvp.select(Long.valueOf(key));
/*     */     }
/* 105 */     return xMenpaiPVP;
/*     */   }
/*     */   
/*     */   static void initXMenpaiPVP(MenpaiPVP xMenpaiPVP)
/*     */   {
/* 110 */     xMenpaiPVP.getFights().clear();
/* 111 */     xMenpaiPVP.getMenpai2world().clear();
/* 112 */     xMenpaiPVP.setIsfinished(false);
/*     */   }
/*     */   
/*     */   static MenpaiPVPScore getXScore(long roleid, boolean remainLock)
/*     */   {
/* 117 */     MenpaiPVPScore xScore = null;
/* 118 */     if (remainLock) {
/* 119 */       xScore = Menpaipvpscore.get(Long.valueOf(roleid));
/*     */     }
/*     */     else {
/* 122 */       xScore = Menpaipvpscore.select(Long.valueOf(roleid));
/*     */     }
/* 124 */     return xScore;
/*     */   }
/*     */   
/*     */   static MenpaiPVPScore getXScoreIfNotExist(long roleid)
/*     */   {
/* 129 */     MenpaiPVPScore xScore = Menpaipvpscore.get(Long.valueOf(roleid));
/* 130 */     if (xScore == null) {
/* 131 */       xScore = Pod.newMenpaiPVPScore();
/* 132 */       Menpaipvpscore.insert(Long.valueOf(roleid), xScore);
/* 133 */       initXMenpaiPVPScore(xScore);
/*     */     }
/* 135 */     return xScore;
/*     */   }
/*     */   
/*     */   static void initXMenpaiPVPScore(MenpaiPVPScore xScore)
/*     */   {
/* 140 */     xScore.setScore(MenpaiPVPConfigManager.getInstance().getInitScore());
/* 141 */     xScore.setWin_times(0);
/* 142 */     xScore.setLose_times(0);
/* 143 */     xScore.setParticipated(false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isInMenpaiPVPWorld(long roleid, int menpai, long roleWorld, MenpaiPVP xMenpaiPVP)
/*     */   {
/* 155 */     if (xMenpaiPVP == null) {
/* 156 */       return false;
/*     */     }
/*     */     
/* 159 */     Long worldid = (Long)xMenpaiPVP.getMenpai2world().get(Integer.valueOf(menpai));
/* 160 */     if (worldid == null) {
/* 161 */       return false;
/*     */     }
/*     */     
/* 164 */     return roleWorld == worldid.longValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isPrepareStage()
/*     */   {
/* 173 */     return ActivityInterface.getActivityStage(MenpaiPVPConfigManager.getInstance().getActivityID()) == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isMatchStage()
/*     */   {
/* 183 */     return ActivityInterface.getActivityStage(MenpaiPVPConfigManager.getInstance().getActivityID()) == 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void matchFight(MenpaiPVP xMenpaiPVP)
/*     */   {
/* 194 */     if (xMenpaiPVP == null) {
/* 195 */       return;
/*     */     }
/*     */     
/* 198 */     logInfo("MenpaiPVPManager.matchFight@begin matching", new Object[0]);
/*     */     
/* 200 */     for (Map.Entry<Integer, Long> entry : xMenpaiPVP.getMenpai2world().entrySet()) {
/* 201 */       int menpai = ((Integer)entry.getKey()).intValue();
/* 202 */       long worldid = ((Long)entry.getValue()).longValue();
/*     */       
/* 204 */       List<Long> roles = MapInterface.getRoleList(worldid);
/*     */       
/* 206 */       List<MatchObj> matchObjs = new ArrayList();
/*     */       
/* 208 */       Iterator<Long> iter = roles.iterator();
/* 209 */       while (iter.hasNext()) {
/* 210 */         long roleid = ((Long)iter.next()).longValue();
/*     */         
/*     */ 
/*     */ 
/* 214 */         if (RoleInterface.getOccupationId(roleid) == menpai)
/*     */         {
/*     */ 
/*     */ 
/* 218 */           if (!FightInterface.isInFight(roleid))
/*     */           {
/* 220 */             MenpaiPVPScore xScore = Menpaipvpscore.select(Long.valueOf(roleid));
/*     */             
/* 222 */             MatchObj obj = null;
/* 223 */             if (xScore == null) {
/* 224 */               obj = new MatchObj(roleid, MenpaiPVPConfigManager.getInstance().getInitScore(), 0);
/*     */             }
/*     */             else {
/* 227 */               obj = new MatchObj(roleid, xScore.getScore(), xScore.getWin_times());
/*     */             }
/* 229 */             matchObjs.add(obj);
/*     */           }
/*     */         }
/*     */       }
/* 233 */       Collections.sort(matchObjs);
/*     */       
/*     */ 
/* 236 */       while (!matchObjs.isEmpty()) {
/* 237 */         Iterator<MatchObj> objIter = matchObjs.iterator();
/* 238 */         MatchObj obj = (MatchObj)objIter.next();
/* 239 */         objIter.remove();
/* 240 */         Map<Long, Integer> opponent2Times = new HashMap();
/*     */         
/* 242 */         MenpaiPVPScore xScore = Menpaipvpscore.select(Long.valueOf(obj.getRoleid()));
/* 243 */         if (xScore != null) {
/* 244 */           opponent2Times.putAll(xScore.getMatchroles());
/*     */         }
/* 246 */         int alternativeIndex = -1;
/* 247 */         int alternativeTimes = -1;
/* 248 */         int i = 0;
/* 249 */         while (objIter.hasNext()) {
/* 250 */           MatchObj opponentObj = (MatchObj)objIter.next();
/* 251 */           Integer times = (Integer)opponent2Times.get(Long.valueOf(opponentObj.getRoleid()));
/* 252 */           if (times == null) {
/* 253 */             alternativeIndex = i;
/* 254 */             break;
/*     */           }
/*     */           
/* 257 */           if (alternativeTimes < 0) {
/* 258 */             alternativeIndex = i;
/* 259 */             alternativeTimes = times.intValue();
/*     */ 
/*     */           }
/* 262 */           else if (times.intValue() < alternativeTimes) {
/* 263 */             alternativeIndex = i;
/* 264 */             alternativeTimes = times.intValue();
/*     */           }
/*     */           
/*     */ 
/* 268 */           i++;
/*     */         }
/*     */         
/* 271 */         if (alternativeIndex >= 0) {
/* 272 */           MatchObj opponentObj = (MatchObj)matchObjs.remove(alternativeIndex);
/* 273 */           startPVPFight(obj.getRoleid(), opponentObj.getRoleid());
/*     */         }
/*     */         else {
/* 276 */           sendMatchCountDownForce(obj.getRoleid());
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 282 */     logInfo("MenpaiPVPManager.matchFight@end matching", new Object[0]);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void startPVPFight(long r1, long r2)
/*     */   {
/* 290 */     FightInterface.startPVPFight(r1, r2, new MenpaiPVPFightContext(), 6, FightReason.MENPAI_PVP_FIGHT);
/*     */     
/* 292 */     logInfo("MenpaiPVPManager.startPVPFight@match fight|roleid1=%d|roleid2=%d", new Object[] { Long.valueOf(r1), Long.valueOf(r2) });
/*     */     
/*     */ 
/*     */ 
/* 296 */     ActivityInterface.logActivity(r1, SMenpaiPVPConsts.getInstance().Activityid, ActivityLogStatus.ATTEND);
/* 297 */     ActivityInterface.logActivity(r2, SMenpaiPVPConsts.getInstance().Activityid, ActivityLogStatus.ATTEND);
/*     */     
/*     */ 
/* 300 */     ActivityInterface.tlogActivity(r1, SMenpaiPVPConsts.getInstance().Activityid, ActivityLogStatus.ATTEND);
/* 301 */     ActivityInterface.tlogActivity(r2, SMenpaiPVPConsts.getInstance().Activityid, ActivityLogStatus.ATTEND);
/*     */   }
/*     */   
/*     */ 
/*     */   static void leaveActivityWorld(long roleid)
/*     */   {
/* 307 */     MapInterface.forceTransferToScene(roleid, MenpaiPVPConfigManager.getInstance().getLeaveMap());
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
/*     */   static boolean leave(long roleid, boolean force)
/*     */   {
/* 320 */     boolean ret = RoleStatusInterface.unsetStatus(roleid, 5);
/* 321 */     if ((!ret) && 
/* 322 */       (force)) {
/* 323 */       logInfo("MenpaiPVPManager.leave@force leave|roleid=%d", new Object[] { Long.valueOf(roleid) });
/* 324 */       ret = true;
/*     */     }
/*     */     
/* 327 */     if (ret) {
/* 328 */       leaveActivityWorld(roleid);
/*     */     }
/* 330 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean leave(long roleid, MenpaiPVPScore xScore, boolean force)
/*     */   {
/* 341 */     boolean ret = RoleStatusInterface.unsetStatus(roleid, 5);
/* 342 */     if ((!ret) && 
/* 343 */       (force)) {
/* 344 */       logInfo("MenpaiPVPManager.leave@force leave|roleid=%d", new Object[] { Long.valueOf(roleid) });
/* 345 */       ret = true;
/*     */     }
/*     */     
/* 348 */     if (ret)
/*     */     {
/* 350 */       xScore.setParticipated(true);
/* 351 */       leaveActivityWorld(roleid);
/*     */     }
/* 353 */     return ret;
/*     */   }
/*     */   
/*     */   static boolean reachMaxLoseTimes(MenpaiPVPScore xScore)
/*     */   {
/* 358 */     return xScore.getLose_times() >= MenpaiPVPConfigManager.getInstance().getMaxLoseTimes();
/*     */   }
/*     */   
/*     */   static boolean hasParticipated(MenpaiPVPScore xScore) {
/* 362 */     return xScore.getParticipated();
/*     */   }
/*     */   
/*     */   static void addWinTimes(MenpaiPVPScore xScore) {
/* 366 */     xScore.setWin_times(xScore.getWin_times() + 1);
/*     */   }
/*     */   
/*     */   static void addLoseTimes(long roleid, MenpaiPVPScore xScore)
/*     */   {
/* 371 */     xScore.setLose_times(xScore.getLose_times() + 1);
/* 372 */     if (reachMaxLoseTimes(xScore)) {
/* 373 */       onReachMaxLoseTimes(roleid, xScore);
/*     */     }
/*     */   }
/*     */   
/*     */   static int getFightTimes(MenpaiPVPScore xScore) {
/* 378 */     return xScore.getWin_times() + xScore.getLose_times();
/*     */   }
/*     */   
/*     */   static boolean checkGiveFightTimesAward(String userid, long roleid, MenpaiPVPScore xScore) {
/* 382 */     int times = getFightTimes(xScore);
/* 383 */     if ((times > 0) && (times % SMenpaiPVPConsts.getInstance().AwardNeedFightTimes == 0)) {
/* 384 */       AwardReason winReason = new AwardReason(LogReason.MENPAI_PVP_FIGHT_TIMES_AWARD);
/* 385 */       AwardModel award = AwardInterface.award(SMenpaiPVPConsts.getInstance().FightTimesAward, userid, roleid, false, false, winReason);
/* 386 */       SFightTimesAwardNotify notify = new SFightTimesAwardNotify();
/* 387 */       AwardInterface.fillAwardBean(notify.award, award);
/* 388 */       OnlineManager.getInstance().send(roleid, notify);
/* 389 */       return true;
/*     */     }
/* 391 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   static void onReachMaxLoseTimes(long roleid, MenpaiPVPScore xScore)
/*     */   {
/* 397 */     leave(roleid, xScore, false);
/*     */     
/* 399 */     OnlineManager.getInstance().send(roleid, new SReachMaxLoseTimesNotify());
/*     */   }
/*     */   
/*     */   static void syncScore(long roleid)
/*     */   {
/* 404 */     MenpaiPVPScore xScore = getXScoreIfNotExist(roleid);
/* 405 */     syncScore(roleid, xScore);
/*     */   }
/*     */   
/*     */   static void syncScore(long roleid, MenpaiPVPScore xScore)
/*     */   {
/* 410 */     SSyncScore sync = new SSyncScore();
/* 411 */     if (xScore == null) {
/* 412 */       sync.score = MenpaiPVPConfigManager.getInstance().getInitScore();
/* 413 */       sync.win_times = 0;
/* 414 */       sync.lose_times = 0;
/*     */     }
/*     */     else {
/* 417 */       sync.score = xScore.getScore();
/* 418 */       sync.win_times = xScore.getWin_times();
/* 419 */       sync.lose_times = xScore.getLose_times();
/*     */     }
/* 421 */     OnlineManager.getInstance().send(roleid, sync);
/*     */   }
/*     */   
/*     */   static void broadcast(MenpaiPVP xMenpaiPVP, Protocol p)
/*     */   {
/* 426 */     if ((xMenpaiPVP == null) || (p == null)) {
/* 427 */       return;
/*     */     }
/*     */     
/* 430 */     for (Iterator i$ = xMenpaiPVP.getMenpai2world().values().iterator(); i$.hasNext();) { long worldid = ((Long)i$.next()).longValue();
/* 431 */       Collection<Long> roles = MapInterface.getRoleList(worldid);
/* 432 */       OnlineManager.getInstance().sendMulti(p, roles);
/*     */     }
/*     */   }
/*     */   
/*     */   static void broadcastStage(MenpaiPVP xMenpaiPVP, int stage)
/*     */   {
/* 438 */     broadcast(xMenpaiPVP, new SStageBrd(stage));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void awardAllParticipants(MenpaiPVP xMenpaiPVP)
/*     */   {
/* 447 */     if (xMenpaiPVP == null) {
/* 448 */       return;
/*     */     }
/* 450 */     AwardReason reason = new AwardReason(LogReason.MENPAI_PVP_PREPARE_AWARD);
/* 451 */     for (Iterator i$ = xMenpaiPVP.getMenpai2world().values().iterator(); i$.hasNext();) { long worldid = ((Long)i$.next()).longValue();
/* 452 */       Collection<Long> roles = MapInterface.getRoleList(worldid);
/* 453 */       AwardInterface.awardToAllNoneRealTime(roles, MenpaiPVPConfigManager.getInstance().getPrepareAwardid(), -1, false, true, reason);
/*     */     }
/*     */   }
/*     */   
/*     */   static Set<Long> getActivityWorlds(MenpaiPVP xMenpaiPVP)
/*     */   {
/* 459 */     Set<Long> worlds = new HashSet();
/* 460 */     if (xMenpaiPVP != null) {
/* 461 */       worlds.addAll(xMenpaiPVP.getMenpai2world().values());
/*     */     }
/* 463 */     return worlds;
/*     */   }
/*     */   
/*     */   static void syncStage(long roleid)
/*     */   {
/* 468 */     int stage = ActivityInterface.getActivityStage(MenpaiPVPConfigManager.getInstance().getActivityID());
/* 469 */     SStageBrd brd = new SStageBrd(stage);
/* 470 */     OnlineManager.getInstance().send(roleid, brd);
/*     */   }
/*     */   
/*     */   static void sendNormalResult(long roleid, int result)
/*     */   {
/* 475 */     SMenpaiPVPNormalResult p = new SMenpaiPVPNormalResult();
/* 476 */     p.result = result;
/* 477 */     OnlineManager.getInstance().sendAtOnce(roleid, p);
/*     */   }
/*     */   
/*     */   static MenpaiPVPCharts getAndCreateXMenpaiPVPCharts()
/*     */   {
/* 482 */     long key = GameServerInfoManager.getLocalId();
/* 483 */     MenpaiPVPCharts xCharts = Menpaipvpcharts.get(Long.valueOf(key));
/* 484 */     if (xCharts == null) {
/* 485 */       xCharts = Pod.newMenpaiPVPCharts();
/* 486 */       Menpaipvpcharts.insert(Long.valueOf(key), xCharts);
/*     */     }
/* 488 */     return xCharts;
/*     */   }
/*     */   
/*     */   static xbean.MenpaiPVPChart getAndCreateXMenpaiPVPChart(int menpai)
/*     */   {
/* 493 */     MenpaiPVPCharts xCharts = getAndCreateXMenpaiPVPCharts();
/* 494 */     xbean.MenpaiPVPChart xChart = (xbean.MenpaiPVPChart)xCharts.getCharts().get(Integer.valueOf(menpai));
/* 495 */     if (xChart == null) {
/* 496 */       xChart = Pod.newMenpaiPVPChart();
/* 497 */       xCharts.getCharts().put(Integer.valueOf(menpai), xChart);
/*     */     }
/* 499 */     return xChart;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void broadcastMatchCountDown(Collection<Long> roles)
/*     */   {
/* 506 */     int countDown = MatchObserver.getLeftSeconds();
/* 507 */     if (countDown > 0) {
/* 508 */       broadcastMatchCountDown(roles, countDown);
/*     */     }
/*     */   }
/*     */   
/*     */   static void broadcastMatchCountDown(Collection<Long> roles, int countDown) {
/* 513 */     SMatchCountDownBrd brd = new SMatchCountDownBrd();
/* 514 */     brd.countdown = countDown;
/* 515 */     OnlineManager.getInstance().sendMulti(brd, roles);
/*     */   }
/*     */   
/*     */   static void broadcastMatchCountDownForce(Collection<Long> roles) {
/* 519 */     broadcastMatchCountDown(roles, MenpaiPVPConfigManager.getInstance().getMatchInterval());
/*     */   }
/*     */   
/*     */   static void sendMatchCountDown(long roleid) {
/* 523 */     int countDown = MatchObserver.getLeftSeconds();
/* 524 */     if (countDown > 0) {
/* 525 */       sendMatchCountDown(roleid, countDown);
/*     */     }
/*     */   }
/*     */   
/*     */   static void sendMatchCountDown(long roleid, int countDown) {
/* 530 */     SMatchCountDownBrd brd = new SMatchCountDownBrd();
/* 531 */     brd.countdown = countDown;
/* 532 */     OnlineManager.getInstance().send(roleid, brd);
/*     */   }
/*     */   
/*     */   static void sendMatchCountDownForce(long roleid) {
/* 536 */     sendMatchCountDown(roleid, MenpaiPVPConfigManager.getInstance().getMatchInterval());
/*     */   }
/*     */   
/*     */   static void logInfo(String formatStr, Object... args)
/*     */   {
/* 541 */     logger.info(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   static void logError(String formatStr, Object... args) {
/* 545 */     logger.error(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   static void onRoleSwitchOccup(long roleid, int oldOccup, int newOccup) {
/* 549 */     MenpaiPVPChart oldChart = getChart(oldOccup);
/* 550 */     MenpaiPVPChart newChart = getChart(newOccup);
/* 551 */     if (oldChart != null) {
/* 552 */       Long oldChampionid = (Long)oldChart.getKeyByRank(0);
/* 553 */       if ((oldChampionid != null) && 
/* 554 */         (oldChampionid.longValue() == roleid))
/*     */       {
/* 556 */         int npc = MenpaiPVPConfigManager.getInstance().getMenpaiChampionNpc(oldOccup);
/* 557 */         if (npc > 0) {
/* 558 */           MapInterface.unsetCloneRoleNpcModelAsync(CloneRoleNpcModelType.MEN_PAI, npc);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 563 */     if (newChart != null) {
/* 564 */       Long newChampionid = (Long)newChart.getKeyByRank(0);
/* 565 */       if ((newChampionid != null) && 
/* 566 */         (newChampionid.longValue() == roleid))
/*     */       {
/* 568 */         MapInterface.setMenPaiNpcModelAsyc(roleid);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\MenpaiPVPManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */