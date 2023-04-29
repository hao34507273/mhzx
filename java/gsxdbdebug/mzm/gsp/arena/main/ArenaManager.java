/*     */ package mzm.gsp.arena.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.arena.SArenaNormalResult;
/*     */ import mzm.gsp.arena.SMatchCountDownBrd;
/*     */ import mzm.gsp.arena.SStageBrd;
/*     */ import mzm.gsp.arena.SSyncGetWinTimesAward;
/*     */ import mzm.gsp.arena.SSyncRoleScore;
/*     */ import mzm.gsp.arena.confbean.SArenaConsts;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.idip.main.IdipManager;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ArenaScore;
/*     */ import xbean.ArenaTmp;
/*     */ import xbean.Pod;
/*     */ import xio.Protocol;
/*     */ import xtable.Arena_tmp;
/*     */ import xtable.Arenachart;
/*     */ import xtable.Arenascore;
/*     */ 
/*     */ class ArenaManager
/*     */ {
/*  40 */   static final Logger logger = Logger.getLogger("Arena");
/*     */   
/*     */ 
/*     */   static ArenaChart chart;
/*     */   
/*     */ 
/*     */   static void init() {}
/*     */   
/*     */ 
/*     */   private static void initChart()
/*     */   {
/*  51 */     chart = new ArenaChart();
/*     */   }
/*     */   
/*     */   static void clearChart() {
/*  55 */     chart.clear();
/*     */   }
/*     */   
/*     */   static xbean.Arena getXArenaIfNotExist()
/*     */   {
/*  60 */     long key = GameServerInfoManager.getLocalId();
/*  61 */     xbean.Arena xArena = xtable.Arena.get(Long.valueOf(key));
/*  62 */     if (xArena == null) {
/*  63 */       xArena = Pod.newArena();
/*  64 */       xtable.Arena.insert(Long.valueOf(key), xArena);
/*     */     }
/*  66 */     return xArena;
/*     */   }
/*     */   
/*     */   static xbean.Arena getXArena(boolean remainLock)
/*     */   {
/*  71 */     long key = GameServerInfoManager.getLocalId();
/*     */     xbean.Arena xArena;
/*  73 */     xbean.Arena xArena; if (remainLock) {
/*  74 */       xArena = xtable.Arena.get(Long.valueOf(key));
/*     */     }
/*     */     else {
/*  77 */       xArena = xtable.Arena.select(Long.valueOf(key));
/*     */     }
/*  79 */     return xArena;
/*     */   }
/*     */   
/*     */   static ArenaTmp getXArenaTmpIfNotExist()
/*     */   {
/*  84 */     long key = GameServerInfoManager.getLocalId();
/*  85 */     ArenaTmp xArenaTmp = Arena_tmp.get(Long.valueOf(key));
/*  86 */     if (xArenaTmp == null) {
/*  87 */       xArenaTmp = Pod.newArenaTmp();
/*  88 */       Arena_tmp.insert(Long.valueOf(key), xArenaTmp);
/*     */     }
/*  90 */     return xArenaTmp;
/*     */   }
/*     */   
/*     */   static ArenaTmp getXArenaTmp(boolean remainLock)
/*     */   {
/*  95 */     long key = GameServerInfoManager.getLocalId();
/*     */     ArenaTmp xArenaTmp;
/*  97 */     ArenaTmp xArenaTmp; if (remainLock) {
/*  98 */       xArenaTmp = Arena_tmp.get(Long.valueOf(key));
/*     */     }
/*     */     else {
/* 101 */       xArenaTmp = Arena_tmp.select(Long.valueOf(key));
/*     */     }
/* 103 */     return xArenaTmp;
/*     */   }
/*     */   
/*     */   static ArenaScore getXArenaScore(long roleid, boolean remainLock) {
/* 107 */     ArenaScore xScore = null;
/* 108 */     if (remainLock) {
/* 109 */       xScore = Arenascore.get(Long.valueOf(roleid));
/*     */     }
/*     */     else {
/* 112 */       xScore = Arenascore.select(Long.valueOf(roleid));
/*     */     }
/* 114 */     return xScore;
/*     */   }
/*     */   
/*     */   static ArenaScore getXArenaScoreIfNotExist(long roleid) {
/* 118 */     ArenaScore xArenaScore = Arenascore.get(Long.valueOf(roleid));
/* 119 */     if (xArenaScore == null) {
/* 120 */       xArenaScore = Pod.newArenaScore();
/* 121 */       Arenascore.insert(Long.valueOf(roleid), xArenaScore);
/* 122 */       initXArenaScore(xArenaScore);
/*     */     }
/* 124 */     return xArenaScore;
/*     */   }
/*     */   
/*     */ 
/*     */   private static void initXArenaScore(ArenaScore xArenaScore)
/*     */   {
/* 130 */     xArenaScore.setCamp(-1);
/* 131 */     xArenaScore.setScore(SArenaConsts.getInstance().InitScore);
/* 132 */     xArenaScore.setAction_point(SArenaConsts.getInstance().InitActionPoint);
/* 133 */     xArenaScore.setWin_times(0);
/* 134 */     xArenaScore.setParticipated(true);
/*     */   }
/*     */   
/*     */   static void sendNormalResult(long roleid, int result, String... args)
/*     */   {
/* 139 */     SArenaNormalResult p = getNormalResult(result, args);
/* 140 */     OnlineManager.getInstance().sendAtOnce(roleid, p);
/*     */   }
/*     */   
/*     */   static void broadcastNormalResult(Collection<Long> roles, int result, String... args)
/*     */   {
/* 145 */     SArenaNormalResult p = getNormalResult(result, args);
/* 146 */     OnlineManager.getInstance().sendMultiAtOnce(p, roles);
/*     */   }
/*     */   
/*     */   private static SArenaNormalResult getNormalResult(int result, String... args)
/*     */   {
/* 151 */     SArenaNormalResult p = new SArenaNormalResult();
/* 152 */     p.result = result;
/* 153 */     for (String arg : args) {
/* 154 */       p.args.add(arg);
/*     */     }
/* 156 */     return p;
/*     */   }
/*     */   
/*     */   static int nextCamp(xbean.Arena xArena)
/*     */   {
/* 161 */     int minCamp = -1;
/* 162 */     int minSize = 0;
/* 163 */     for (Map.Entry<Integer, xbean.Camp> entry : xArena.getCamps().entrySet()) {
/* 164 */       int camp = ((Integer)entry.getKey()).intValue();
/* 165 */       xbean.Camp xCamp = (xbean.Camp)entry.getValue();
/* 166 */       if (minCamp < 0) {
/* 167 */         minCamp = camp;
/* 168 */         minSize = xCamp.getRole_number();
/*     */ 
/*     */       }
/* 171 */       else if (xCamp.getRole_number() < minSize) {
/* 172 */         minSize = xCamp.getRole_number();
/* 173 */         minCamp = camp;
/*     */       }
/*     */     }
/*     */     
/* 177 */     return minCamp;
/*     */   }
/*     */   
/*     */   static void joinCamp(ArenaScore xScore, xbean.Arena xArena, int camp)
/*     */   {
/* 182 */     if (xScore.getCamp() >= 0) {
/* 183 */       return;
/*     */     }
/* 185 */     xScore.setCamp(camp);
/* 186 */     xbean.Camp xCamp = (xbean.Camp)xArena.getCamps().get(Integer.valueOf(camp));
/* 187 */     if (xCamp == null) {
/* 188 */       throw new RuntimeException("Invalid camp: " + camp);
/*     */     }
/* 190 */     xCamp.setRole_number(xCamp.getRole_number() + 1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void broadcastStage(Collection<Long> roles)
/*     */   {
/* 198 */     SStageBrd brd = new SStageBrd();
/* 199 */     brd.stage = ActivityInterface.getActivityStage(SArenaConsts.getInstance().Activityid);
/* 200 */     OnlineManager.getInstance().sendMulti(brd, roles);
/*     */   }
/*     */   
/*     */   static void broadcastStage(ArenaTmp xArenaTmp, int stage)
/*     */   {
/* 205 */     broadcast(xArenaTmp, new SStageBrd(stage));
/*     */   }
/*     */   
/*     */   static void broadcast(ArenaTmp xArenaTmp, Protocol pro) {
/* 209 */     List<Long> roles = MapInterface.getRoleList(xArenaTmp.getWorld());
/* 210 */     OnlineManager.getInstance().sendMulti(pro, roles);
/*     */   }
/*     */   
/*     */   static void syncStage(long roleid)
/*     */   {
/* 215 */     SStageBrd sync = new SStageBrd();
/* 216 */     sync.stage = ActivityInterface.getActivityStage(SArenaConsts.getInstance().Activityid);
/* 217 */     OnlineManager.getInstance().send(roleid, sync);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isInArenaWorld(long roleid)
/*     */   {
/* 227 */     ArenaTmp xArenaTmp = getXArenaTmp(false);
/* 228 */     if (xArenaTmp == null) {
/* 229 */       return false;
/*     */     }
/*     */     
/* 232 */     return MapInterface.getRoleWorldInstanceId(roleid) == xArenaTmp.getWorld();
/*     */   }
/*     */   
/*     */   static void leaveActivityWorld(long roleid) {
/* 236 */     MapInterface.forceTransferToScene(roleid, SArenaConsts.getInstance().LeaveMap);
/*     */   }
/*     */   
/*     */   static void leaveActivityWorldAndCheckActivityEnd(long roleid) {
/* 240 */     leaveActivityWorld(roleid);
/* 241 */     NoneRealTimeTaskManager.getInstance().addTask(new PCheckEnd());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkAndLeaveActivityWorld(long roleid, ArenaTmp xArenaTmp)
/*     */   {
/* 252 */     if (xArenaTmp == null) {
/* 253 */       return false;
/*     */     }
/* 255 */     return checkAndLeaveActivityWorld(roleid, xArenaTmp.getWorld());
/*     */   }
/*     */   
/*     */   static boolean checkAndLeaveActivityWorld(long roleid, long world)
/*     */   {
/* 260 */     if (MapInterface.getRoleWorldInstanceId(roleid) != world) {
/* 261 */       return false;
/*     */     }
/* 263 */     leaveActivityWorldAndCheckActivityEnd(roleid);
/* 264 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void syncRoleScore(long roleid)
/*     */   {
/* 274 */     ArenaScore xScore = getXArenaScoreIfNotExist(roleid);
/* 275 */     syncRoleScore(roleid, xScore);
/*     */   }
/*     */   
/*     */   static void syncRoleScore(long roleid, ArenaScore xScore) {
/* 279 */     SSyncRoleScore sync = new SSyncRoleScore();
/* 280 */     sync.camp = xScore.getCamp();
/* 281 */     sync.score = xScore.getScore();
/* 282 */     sync.action_point = xScore.getAction_point();
/* 283 */     sync.win_times = xScore.getWin_times();
/* 284 */     OnlineManager.getInstance().send(roleid, sync);
/*     */   }
/*     */   
/*     */   static void fillCampBean(xbean.Camp xCamp, int camp, mzm.gsp.arena.Camp campBean)
/*     */   {
/* 289 */     campBean.camp = camp;
/* 290 */     campBean.score = xCamp.getScore();
/*     */   }
/*     */   
/*     */   static mzm.gsp.arena.Camp getCampBean(xbean.Camp xCamp, int camp) {
/* 294 */     mzm.gsp.arena.Camp campBean = new mzm.gsp.arena.Camp();
/* 295 */     fillCampBean(xCamp, camp, campBean);
/* 296 */     return campBean;
/*     */   }
/*     */   
/*     */   static void syncGetWinTimesAward(long roleid) {
/* 300 */     ArenaScore xScore = Arenascore.select(Long.valueOf(roleid));
/* 301 */     syncGetWinTimesAward(roleid, xScore);
/*     */   }
/*     */   
/*     */   static void syncGetWinTimesAward(long roleid, ArenaScore xScore) {
/* 305 */     if (xScore == null) {
/* 306 */       return;
/*     */     }
/* 308 */     SSyncGetWinTimesAward sync = new SSyncGetWinTimesAward();
/* 309 */     sync.awards.addAll(xScore.getGet_awards());
/* 310 */     OnlineManager.getInstance().send(roleid, sync);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isPrepareStage()
/*     */   {
/* 320 */     return ActivityInterface.getActivityStage(SArenaConsts.getInstance().Activityid) == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isMatchStage()
/*     */   {
/* 330 */     int stage = ActivityInterface.getActivityStage(SArenaConsts.getInstance().Activityid);
/* 331 */     return (stage == 1) || (stage == 2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isActivityTime()
/*     */   {
/* 342 */     return ActivityInterface.isActivityOpen(SArenaConsts.getInstance().Activityid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void awardAllParticipants(ArenaTmp xArenaTmp)
/*     */   {
/* 350 */     if (xArenaTmp == null) {
/* 351 */       return;
/*     */     }
/* 353 */     AwardReason reason = new AwardReason(LogReason.ARENA_PREPARE_AWARD);
/* 354 */     long world = xArenaTmp.getWorld();
/* 355 */     Collection<Long> roles = MapInterface.getRoleList(world);
/* 356 */     mzm.gsp.award.main.AwardInterface.awardToAllNoneRealTime(roles, SArenaConsts.getInstance().PrepareAward, -1, false, true, reason);
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
/*     */   private static int findCampOfTopMatchObj(Map<Integer, List<MatchObj>> camp2MatchObjs)
/*     */   {
/* 370 */     int topCamp = -1;
/* 371 */     int topLeftCount = 0;
/* 372 */     MatchObj topObj = null;
/*     */     
/* 374 */     for (Map.Entry<Integer, List<MatchObj>> entry : camp2MatchObjs.entrySet()) {
/* 375 */       int camp = ((Integer)entry.getKey()).intValue();
/* 376 */       List<MatchObj> objs = (List)entry.getValue();
/* 377 */       if (!objs.isEmpty())
/*     */       {
/*     */ 
/* 380 */         int leftCount = objs.size();
/* 381 */         MatchObj obj = (MatchObj)objs.get(0);
/*     */         
/* 383 */         boolean bReplace = false;
/* 384 */         if (topObj == null) {
/* 385 */           bReplace = true;
/*     */ 
/*     */         }
/* 388 */         else if (leftCount > topLeftCount) {
/* 389 */           bReplace = true;
/*     */         }
/* 391 */         else if ((leftCount == topLeftCount) && (obj.compareTo(topObj) < 0)) {
/* 392 */           bReplace = true;
/*     */         }
/*     */         
/*     */ 
/* 396 */         if (bReplace) {
/* 397 */           topObj = obj;
/* 398 */           topCamp = camp;
/* 399 */           topLeftCount = leftCount;
/*     */         }
/*     */       } }
/* 402 */     return topCamp;
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
/*     */   private static MatchObj findAndRemoveOpponent(Map<Integer, List<MatchObj>> camp2MatchObjs, int topCamp, MatchObj topObj)
/*     */   {
/* 417 */     int opponentCamp = -1;
/* 418 */     MatchObj opponent = null;
/* 419 */     int opponentTimes = -1;
/* 420 */     int opponentIndex = -1;
/* 421 */     int opponentLeftCount = 0;
/* 422 */     int minDiffScore = Integer.MAX_VALUE;
/*     */     
/* 424 */     List<ArenaScore> xScores = new ArrayList();
/* 425 */     for (Iterator i$ = topObj.getRoleList().iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 426 */       ArenaScore xScore = Arenascore.select(Long.valueOf(r));
/* 427 */       if (xScore != null) {
/* 428 */         xScores.add(xScore);
/*     */       }
/*     */     }
/*     */     
/* 432 */     for (Map.Entry<Integer, List<MatchObj>> entry : camp2MatchObjs.entrySet()) {
/* 433 */       int camp = ((Integer)entry.getKey()).intValue();
/* 434 */       if (camp != topCamp)
/*     */       {
/*     */ 
/* 437 */         List<MatchObj> objs = (List)entry.getValue();
/* 438 */         if (!objs.isEmpty())
/*     */         {
/*     */ 
/*     */ 
/* 442 */           int leftCount = objs.size();
/*     */           
/* 444 */           for (int i = 0; i < objs.size(); i++) {
/* 445 */             MatchObj obj = (MatchObj)objs.get(i);
/* 446 */             int times = calculateMatchTimes(xScores, obj.getRoleList());
/* 447 */             int diffScore = Math.abs(obj.getScore() - topObj.getScore());
/* 448 */             boolean bReplace = false;
/*     */             
/* 450 */             if (opponent == null) {
/* 451 */               bReplace = true;
/*     */ 
/*     */             }
/* 454 */             else if (times < opponentTimes) {
/* 455 */               bReplace = true;
/*     */             }
/* 457 */             else if (times == opponentTimes) {
/* 458 */               if (diffScore < minDiffScore) {
/* 459 */                 bReplace = true;
/*     */               }
/* 461 */               else if ((diffScore == minDiffScore) && 
/* 462 */                 (leftCount > opponentLeftCount)) {
/* 463 */                 bReplace = true;
/*     */               }
/*     */             }
/*     */             
/*     */ 
/*     */ 
/* 469 */             if (bReplace) {
/* 470 */               opponentCamp = camp;
/* 471 */               opponent = obj;
/* 472 */               opponentTimes = times;
/* 473 */               opponentIndex = i;
/* 474 */               opponentLeftCount = leftCount;
/* 475 */               minDiffScore = diffScore;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 481 */     if (opponent != null) {
/* 482 */       ((List)camp2MatchObjs.get(Integer.valueOf(opponentCamp))).remove(opponentIndex);
/*     */     }
/*     */     
/* 485 */     return opponent;
/*     */   }
/*     */   
/*     */   private static int calculateMatchTimes(List<ArenaScore> xScores, List<Long> opponent)
/*     */   {
/* 490 */     int times = 0;
/* 491 */     for (Iterator i$ = xScores.iterator(); i$.hasNext();) { xScore = (ArenaScore)i$.next();
/* 492 */       for (i$ = opponent.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 493 */         Integer i = (Integer)xScore.getMatchroles().get(Long.valueOf(r));
/* 494 */         if (i != null)
/* 495 */           times += i.intValue();
/*     */       }
/*     */     }
/*     */     ArenaScore xScore;
/*     */     Iterator i$;
/* 500 */     return times;
/*     */   }
/*     */   
/*     */   static void matchFight()
/*     */   {
/* 505 */     if (logger.isDebugEnabled()) {
/* 506 */       logger.debug("天下会武开始匹配！");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 511 */     ArenaTmp xArenaTmp = getXArenaTmp(false);
/* 512 */     if (xArenaTmp == null) {
/* 513 */       return;
/*     */     }
/*     */     
/* 516 */     List<List<Long>> rolesList = MapInterface.getSingleRoleAndTeam(xArenaTmp.getWorld());
/*     */     
/* 518 */     Map<Integer, List<MatchObj>> camp2MatchObjs = new TreeMap();
/* 519 */     for (Iterator i$ = ArenaConfigManager.getInstance().getCampSet().iterator(); i$.hasNext();) { int i = ((Integer)i$.next()).intValue();
/* 520 */       List<MatchObj> objs = new ArrayList();
/* 521 */       camp2MatchObjs.put(Integer.valueOf(i), objs);
/*     */     }
/*     */     
/* 524 */     Iterator<List<Long>> iter = rolesList.iterator();
/* 525 */     while (iter.hasNext()) {
/* 526 */       List<Long> roles = (List)iter.next();
/* 527 */       iter.remove();
/* 528 */       if (!roles.isEmpty())
/*     */       {
/*     */ 
/*     */ 
/* 532 */         boolean ret = true;
/* 533 */         for (Iterator i$ = roles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 534 */           if (FightInterface.isInFight(r)) {
/* 535 */             ret = false;
/* 536 */             break;
/*     */           }
/*     */         }
/*     */         
/* 540 */         if (ret)
/*     */         {
/*     */ 
/*     */ 
/* 544 */           int score = 0;
/* 545 */           int times = 0;
/* 546 */           int camp = -1;
/*     */           
/* 548 */           for (Iterator i$ = roles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 549 */             ArenaScore xScore = Arenascore.select(Long.valueOf(r));
/* 550 */             if (xScore != null) {
/* 551 */               score += xScore.getScore();
/* 552 */               times += getMatchTimes(xScore);
/* 553 */               camp = xScore.getCamp();
/*     */             }
/*     */             else {
/* 556 */               logError("ArenaManager.matchFight@player no camp|roleid=%d|roles=%s", new Object[] { Long.valueOf(r), roles });
/*     */             }
/*     */           }
/*     */           
/* 560 */           if (camp >= 0)
/*     */           {
/*     */ 
/* 563 */             List<MatchObj> objs = (List)camp2MatchObjs.get(Integer.valueOf(camp));
/* 564 */             if (objs != null)
/*     */             {
/*     */ 
/*     */ 
/* 568 */               MatchObj obj = new MatchObj(roles, score, times);
/* 569 */               objs.add(obj);
/*     */             }
/*     */           }
/*     */         } } }
/* 573 */     for (List<MatchObj> objs : camp2MatchObjs.values()) {
/* 574 */       Collections.sort(objs);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 579 */     while (!camp2MatchObjs.isEmpty())
/*     */     {
/*     */ 
/* 582 */       boolean allEmpty = true;
/* 583 */       for (List<MatchObj> objs : camp2MatchObjs.values()) {
/* 584 */         if (!objs.isEmpty()) {
/* 585 */           allEmpty = false;
/* 586 */           break;
/*     */         }
/*     */       }
/* 589 */       if (allEmpty) {
/*     */         break;
/*     */       }
/*     */       
/* 593 */       int topCamp = findCampOfTopMatchObj(camp2MatchObjs);
/*     */       
/* 595 */       MatchObj topObj = (MatchObj)((List)camp2MatchObjs.get(Integer.valueOf(topCamp))).remove(0);
/*     */       
/* 597 */       MatchObj opponentObj = findAndRemoveOpponent(camp2MatchObjs, topCamp, topObj);
/* 598 */       if (opponentObj != null)
/*     */       {
/* 600 */         NoneRealTimeTaskManager.getInstance().addTask(new PMatchOneFight(topObj, opponentObj));
/*     */       }
/*     */       else
/*     */       {
/* 604 */         broadcastMatchCountDownForce(topObj.getRoleList());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addWinTimes(long roleid, ArenaScore xScore)
/*     */   {
/* 614 */     if (!IdipManager.isZeroProfit(roleid)) {
/* 615 */       xScore.setWin_times(xScore.getWin_times() + 1);
/*     */     }
/*     */   }
/*     */   
/*     */   static void deductActionPoint(ArenaScore xScore) {
/* 620 */     xScore.setAction_point(xScore.getAction_point() - SArenaConsts.getInstance().DeductActionPointWhenLose);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onMatchEnd()
/*     */   {
/* 631 */     ArenaTmp xArenaTmp = getXArenaTmp(false);
/* 632 */     Iterator<Long> fightIter = xArenaTmp.getFights().iterator();
/* 633 */     while (fightIter.hasNext()) {
/* 634 */       long fightid = ((Long)fightIter.next()).longValue();
/*     */       
/* 636 */       FightInterface.endFightNonRealTime(fightid);
/*     */     }
/*     */     
/*     */ 
/* 640 */     NoneRealTimeTaskManager.getInstance().addTask(new PResult());
/*     */   }
/*     */   
/*     */ 
/*     */   static void onActivityEnd()
/*     */   {
/* 646 */     ControllerInterface.collectController(SArenaConsts.getInstance().ControllerIn);
/*     */     
/* 648 */     ArenaTmp xArenaTmp = getXArenaTmp(false);
/*     */     
/*     */ 
/* 651 */     MapInterface.dragAllRoleTo(xArenaTmp.getWorld(), SArenaConsts.getInstance().LeaveMap);
/*     */     
/*     */ 
/* 654 */     MapInterface.destroyWorld(xArenaTmp.getWorld());
/*     */     
/*     */ 
/* 657 */     TeamInterface.unRegisterJoinTeam(xArenaTmp.getWorld());
/* 658 */     TeamInterface.unRegisterActivityTeam(xArenaTmp.getWorld());
/*     */   }
/*     */   
/*     */   static xbean.ArenaChart getAndCreateXArenaChart()
/*     */   {
/* 663 */     long key = GameServerInfoManager.getLocalId();
/* 664 */     xbean.ArenaChart xArenaChart = Arenachart.get(Long.valueOf(key));
/* 665 */     if (xArenaChart == null) {
/* 666 */       xArenaChart = Pod.newArenaChart();
/* 667 */       Arenachart.insert(Long.valueOf(key), xArenaChart);
/*     */     }
/* 669 */     return xArenaChart;
/*     */   }
/*     */   
/*     */   static int getMatchTimes(ArenaScore xScore) {
/* 673 */     if (xScore == null) {
/* 674 */       return 0;
/*     */     }
/* 676 */     int times = 0;
/* 677 */     for (Iterator i$ = xScore.getMatchroles().values().iterator(); i$.hasNext();) { int t = ((Integer)i$.next()).intValue();
/* 678 */       times += t;
/*     */     }
/* 680 */     return times;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void broadcastMatchCountDown(Collection<Long> roles)
/*     */   {
/* 687 */     int countDown = MatchObserver.getLeftSeconds();
/* 688 */     if (countDown > 0) {
/* 689 */       broadcastMatchCountDown(roles, countDown);
/*     */     }
/*     */   }
/*     */   
/*     */   static void broadcastMatchCountDown(Collection<Long> roles, int countDown) {
/* 694 */     SMatchCountDownBrd brd = new SMatchCountDownBrd();
/* 695 */     brd.countdown = countDown;
/* 696 */     OnlineManager.getInstance().sendMulti(brd, roles);
/*     */   }
/*     */   
/*     */   static void broadcastMatchCountDownForce(Collection<Long> roles) {
/* 700 */     broadcastMatchCountDown(roles, SArenaConsts.getInstance().MatchInterval);
/*     */   }
/*     */   
/*     */   static void logInfo(String formatStr, Object... args) {
/* 704 */     logger.info(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   static void logError(String formatStr, Object... args) {
/* 708 */     logger.error(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getScore(String userid, long roleid, boolean remainLock)
/*     */   {
/* 719 */     if (!ActivityInterface.isActivityDataValidate(userid, roleid, SArenaConsts.getInstance().Activityid)) {
/* 720 */       return -1;
/*     */     }
/* 722 */     ArenaScore xScore = getXArenaScore(roleid, remainLock);
/* 723 */     if (xScore == null)
/*     */     {
/* 725 */       return -1;
/*     */     }
/* 727 */     return xScore.getScore();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean setScore(long roleid, ArenaScore xScore, int score)
/*     */   {
/* 738 */     if (xScore == null) {
/* 739 */       return false;
/*     */     }
/* 741 */     xScore.setScore(score);
/*     */     
/* 743 */     ArenaChartObj chartObj = new ArenaChartObj(roleid, xScore.getScore(), xScore.getWin_times());
/* 744 */     chart.rank(chartObj);
/* 745 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\ArenaManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */