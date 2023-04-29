/*     */ package mzm.gsp.factionpve.main;
/*     */ 
/*     */ import java.text.DateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.factionpve.SFactionGoalAwardNotify;
/*     */ import mzm.gsp.factionpve.SFactionPVENormalResult;
/*     */ import mzm.gsp.factionpve.SFactionPVEStageBrd;
/*     */ import mzm.gsp.factionpve.SFactionPVETimesBrd;
/*     */ import mzm.gsp.factionpve.SKillBossAwardNotify;
/*     */ import mzm.gsp.factionpve.SKillBossBrd;
/*     */ import mzm.gsp.factionpve.SKillBossSucceedBrd;
/*     */ import mzm.gsp.factionpve.SKillBossTimeoutBrd;
/*     */ import mzm.gsp.factionpve.SKillRelatedMonsterBrd;
/*     */ import mzm.gsp.factionpve.SSelfGoalAwardNotify;
/*     */ import mzm.gsp.factionpve.SStartTimeBrd;
/*     */ import mzm.gsp.factionpve.SSyncFactionKillMonster;
/*     */ import mzm.gsp.factionpve.SSyncKillBossCountBrd;
/*     */ import mzm.gsp.factionpve.SSyncParticipateTimes;
/*     */ import mzm.gsp.factionpve.SSyncPlayerCount;
/*     */ import mzm.gsp.factionpve.SSyncSelfKillMonster;
/*     */ import mzm.gsp.factionpve.SSyncStartTime;
/*     */ import mzm.gsp.factionpve.confbean.SFactionPVEConsts;
/*     */ import mzm.gsp.factionpve.confbean.SFactionPVEMonsterGoalCfg;
/*     */ import mzm.gsp.factionpve.confbean.SKillBossAwardCfg;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.MilliSession;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FactionPVE;
/*     */ import xbean.FactionPVETmp;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleFactionPVE;
/*     */ import xio.Protocol;
/*     */ import xtable.Factionpve;
/*     */ import xtable.Factionpve_tmp;
/*     */ import xtable.Role2factionpve;
/*     */ 
/*     */ class FactionPVEManager
/*     */ {
/*     */   static final String TLOG_SET_START_TIME = "FactionPVESetStartTime";
/*     */   static final String TLOG_PARTICIPATE = "FactionPVEParticipate";
/*     */   static final String TLOG_END = "FactionPVEEnd";
/*     */   static final int RESULT_FINISH = 1;
/*     */   static final int RESULT_BOSS_TIMEOUT = 2;
/*     */   static final int RESULT_TIMEOUT = 3;
/*     */   static final int TlogBossCount = 5;
/*     */   static Logger logger;
/*  66 */   static final DateFormat DATE_FORMAT = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
/*     */   
/*     */   static void init() {
/*  69 */     logger = Logger.getLogger("factionpve");
/*     */   }
/*     */   
/*     */   static FactionPVE getXFactionPVEIfNotExist(long factionid) {
/*  73 */     FactionPVE xFactionPVE = Factionpve.get(Long.valueOf(factionid));
/*  74 */     if (xFactionPVE == null) {
/*  75 */       xFactionPVE = Pod.newFactionPVE();
/*  76 */       Factionpve.insert(Long.valueOf(factionid), xFactionPVE);
/*     */       
/*  78 */       initXFactionPVE(xFactionPVE);
/*     */     }
/*  80 */     return xFactionPVE;
/*     */   }
/*     */   
/*     */   static void checkAndInitXFactionPVEAndXFactionPVETmp(FactionPVE xFactionPVE, FactionPVETmp xFactionPVETmp)
/*     */   {
/*  85 */     long activityStartTime = ActivityInterface.getActivityStartTime(SFactionPVEConsts.getInstance().Activityid);
/*     */     
/*  87 */     if ((xFactionPVE.getStart_timestamp() > 0L) && (xFactionPVE.getStart_timestamp() < activityStartTime)) {
/*  88 */       initXFactionPVEAndXFactionPVETmp(xFactionPVE, xFactionPVETmp);
/*     */     }
/*     */   }
/*     */   
/*     */   static void initXFactionPVEAndXFactionPVETmp(FactionPVE xFactionPVE, FactionPVETmp xFactionPVETmp)
/*     */   {
/*  94 */     initXFactionPVE(xFactionPVE);
/*  95 */     initXFactionPVETmp(xFactionPVETmp);
/*     */   }
/*     */   
/*     */   static void clearXFactionPVEAndXFactionPVETmp(FactionPVE xFactionPVE, FactionPVETmp xFactionPVETmp)
/*     */   {
/* 100 */     clearXFactionPVE(xFactionPVE);
/* 101 */     clearXFactionPVETmp(xFactionPVETmp);
/*     */   }
/*     */   
/*     */   private static void initXFactionPVE(FactionPVE xFactionPVE) {
/* 105 */     clearXFactionPVE(xFactionPVE);
/* 106 */     xFactionPVE.setActivate_times(0);
/* 107 */     xFactionPVE.setStart_timestamp(0L);
/*     */   }
/*     */   
/*     */   private static void clearXFactionPVE(FactionPVE xFactionPVE) {
/* 111 */     xFactionPVE.setSet_times(0);
/*     */   }
/*     */   
/*     */   static FactionPVETmp getXFactionPVETmpIfNotExist(long factionid) {
/* 115 */     FactionPVETmp xTmp = Factionpve_tmp.get(Long.valueOf(factionid));
/* 116 */     if (xTmp == null) {
/* 117 */       xTmp = Pod.newFactionPVETmp();
/* 118 */       Factionpve_tmp.insert(Long.valueOf(factionid), xTmp);
/*     */       
/* 120 */       initXFactionPVETmp(xTmp);
/*     */     }
/* 122 */     return xTmp;
/*     */   }
/*     */   
/*     */   private static void initXFactionPVETmp(FactionPVETmp xTmp) {
/* 126 */     clearXFactionPVETmp(xTmp);
/*     */   }
/*     */   
/*     */   private static void clearXFactionPVETmp(FactionPVETmp xTmp) {
/* 130 */     xTmp.setWorld(-1L);
/* 131 */     xTmp.setSessionid(-1L);
/* 132 */     xTmp.getGoal().clear();
/* 133 */     xTmp.setEnd_sessionid(-1L);
/* 134 */     xTmp.getFights().clear();
/* 135 */     xTmp.getKilled_boss().clear();
/*     */   }
/*     */   
/*     */   static RoleFactionPVE getXRoleFactionPVEIfNotExist(long roleid)
/*     */   {
/* 140 */     RoleFactionPVE xRolePVE = Role2factionpve.get(Long.valueOf(roleid));
/* 141 */     if (xRolePVE == null) {
/* 142 */       xRolePVE = Pod.newRoleFactionPVE();
/* 143 */       Role2factionpve.insert(Long.valueOf(roleid), xRolePVE);
/*     */       
/* 145 */       initXRoleFactionPVE(xRolePVE);
/*     */     }
/* 147 */     return xRolePVE;
/*     */   }
/*     */   
/*     */   static void initXRoleFactionPVE(RoleFactionPVE xRolePVE) {
/* 151 */     clearXRoleFactionPVE(xRolePVE);
/* 152 */     xRolePVE.setParticipate_millis(-1L);
/* 153 */     xRolePVE.setParticipate_times(0);
/* 154 */     xRolePVE.setParticipate_faction(-1L);
/*     */   }
/*     */   
/*     */   static void clearXRoleFactionPVE(RoleFactionPVE xRolePVE) {
/* 158 */     xRolePVE.setGoal_times(0);
/* 159 */     xRolePVE.getGoal().clear();
/*     */   }
/*     */   
/*     */   static void sendNormalResult(long roleid, int result, String... args)
/*     */   {
/* 164 */     SFactionPVENormalResult p = getNormalResult(result, args);
/* 165 */     OnlineManager.getInstance().sendAtOnce(roleid, p);
/*     */   }
/*     */   
/*     */   static void broadcastNormalResult(Collection<Long> roles, int result, String... args) {
/* 169 */     SFactionPVENormalResult p = getNormalResult(result, args);
/* 170 */     OnlineManager.getInstance().sendMultiAtOnce(p, roles);
/*     */   }
/*     */   
/*     */   private static SFactionPVENormalResult getNormalResult(int result, String... args) {
/* 174 */     SFactionPVENormalResult p = new SFactionPVENormalResult();
/* 175 */     p.result = result;
/* 176 */     for (String arg : args) {
/* 177 */       p.args.add(arg);
/*     */     }
/* 179 */     return p;
/*     */   }
/*     */   
/*     */   static Protocol getStartTimeBrdProtocol(FactionPVE xFactionPVE, long managerid, String managerName, String managerDuty)
/*     */   {
/* 184 */     SStartTimeBrd brd = new SStartTimeBrd();
/* 185 */     brd.start_time = xFactionPVE.getStart_timestamp();
/* 186 */     brd.manager_id = managerid;
/* 187 */     brd.manager_name = managerName;
/* 188 */     brd.manager_duty = managerDuty;
/* 189 */     return brd;
/*     */   }
/*     */   
/*     */   private static Protocol getSyncStartTimeProtocol(FactionPVE xFactionPVE) {
/* 193 */     SSyncStartTime sync = new SSyncStartTime();
/* 194 */     sync.start_time = xFactionPVE.getStart_timestamp();
/* 195 */     return sync;
/*     */   }
/*     */   
/*     */   static void syncStartTime(long roleid, FactionPVE xFactionPVE) {
/* 199 */     Protocol p = getSyncStartTimeProtocol(xFactionPVE);
/* 200 */     OnlineManager.getInstance().send(roleid, p);
/*     */   }
/*     */   
/*     */   static Protocol getFactionPVETimesBrdProtocol(FactionPVE xFactionPVE) {
/* 204 */     SFactionPVETimesBrd brd = new SFactionPVETimesBrd();
/* 205 */     brd.activate_times = xFactionPVE.getActivate_times();
/* 206 */     brd.set_times = xFactionPVE.getSet_times();
/* 207 */     return brd;
/*     */   }
/*     */   
/*     */   static void sendFactionPVETimes(long roleid, FactionPVE xFactionPVE) {
/* 211 */     Protocol p = getFactionPVETimesBrdProtocol(xFactionPVE);
/* 212 */     OnlineManager.getInstance().send(roleid, p);
/*     */   }
/*     */   
/*     */   static void logWarn(String formatStr, Object... args)
/*     */   {
/* 217 */     logger.warn(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   static void logError(String formatStr, Object... args) {
/* 221 */     logger.error(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   static void logInfo(String formatStr, Object... args) {
/* 225 */     logger.info(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   static void logDebug(String formatStr, Object... args) {
/* 229 */     logger.debug(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   private static void registerTeamHandler(long world)
/*     */   {
/* 234 */     TeamInterface.registerJoinTeam(world, FactionPVETeamHandler.getInstance());
/* 235 */     TeamInterface.registerActivityTeam(world, FactionPVETeamHandler.getInstance());
/*     */   }
/*     */   
/*     */   private static void unregisterTeamHandler(long world)
/*     */   {
/* 240 */     TeamInterface.unRegisterJoinTeam(world);
/* 241 */     TeamInterface.unRegisterActivityTeam(world);
/*     */   }
/*     */   
/*     */   static long createPrepareWorld() {
/* 245 */     long world = MapInterface.createWorld(Arrays.asList(new Integer[] { Integer.valueOf(SFactionPVEConsts.getInstance().PrepareMap) }));
/*     */     
/* 247 */     registerTeamHandler(world);
/*     */     
/* 249 */     return world;
/*     */   }
/*     */   
/*     */   static void destroyPrepareWorld(long world)
/*     */   {
/* 254 */     unregisterTeamHandler(world);
/* 255 */     MapInterface.destroyWorld(world);
/*     */   }
/*     */   
/*     */   static long createFightWorld() {
/* 259 */     long world = MapInterface.createWorld(Arrays.asList(new Integer[] { Integer.valueOf(SFactionPVEConsts.getInstance().FightMap) }));
/*     */     
/*     */ 
/* 262 */     MapInterface.registerMonsterFightHandler(world, FactionPVEMonsterFightHandler.getInstance());
/*     */     
/*     */ 
/* 265 */     ControllerInterface.triggerOrReSpawn(world, SFactionPVEConsts.getInstance().MonsterController);
/*     */     
/*     */ 
/* 268 */     registerTeamHandler(world);
/*     */     
/* 270 */     return world;
/*     */   }
/*     */   
/*     */   static void destroyFightWorld(long world)
/*     */   {
/* 275 */     MapInterface.unregisterMonsterFightHandler(world, FactionPVEMonsterFightHandler.getInstance());
/*     */     
/*     */ 
/* 278 */     ControllerInterface.collectWorldController(world, SFactionPVEConsts.getInstance().MonsterController);
/*     */     
/* 280 */     ControllerInterface.collectWorldController(world, SFactionPVEConsts.getInstance().BossController);
/*     */     
/*     */ 
/*     */ 
/* 284 */     unregisterTeamHandler(world);
/*     */     
/* 286 */     MapInterface.destroyWorld(world);
/*     */   }
/*     */   
/*     */   static void broadcastFactionPVEStage(Gang faction, int stage, long endTime) {
/* 290 */     SFactionPVEStageBrd brd = new SFactionPVEStageBrd();
/* 291 */     brd.stage = stage;
/* 292 */     brd.end_time = endTime;
/* 293 */     if (faction != null) {
/* 294 */       faction.broadcast(brd);
/*     */     }
/*     */   }
/*     */   
/*     */   static void sendFactionPVEStage(long roleid, FactionPVETmp xFactionPVETmp) {
/* 299 */     SFactionPVEStageBrd brd = new SFactionPVEStageBrd();
/*     */     
/* 301 */     if (xFactionPVETmp != null) {
/* 302 */       brd.stage = xFactionPVETmp.getStage();
/* 303 */       long sessionid = xFactionPVETmp.getSessionid();
/* 304 */       MilliSession session = MilliSession.getSession(sessionid);
/* 305 */       if (session != null) {
/* 306 */         brd.end_time = session.getTimeoutTimestamp();
/*     */       }
/*     */       else {
/* 309 */         brd.end_time = -1L;
/*     */       }
/*     */     }
/*     */     else {
/* 313 */       brd.stage = 0;
/* 314 */       brd.end_time = -1L;
/*     */     }
/*     */     
/* 317 */     OnlineManager.getInstance().send(roleid, brd);
/*     */   }
/*     */   
/*     */   private static void setStage(long factionid, FactionPVETmp xFactionPVETmp, int stage, long sessionid)
/*     */   {
/* 322 */     xFactionPVETmp.setStage(stage);
/* 323 */     xFactionPVETmp.setSessionid(sessionid);
/*     */     
/* 325 */     logInfo("FactionPVEManager.setStage@stage begin|factionid=%d|stage=%d|sessionid=%d", new Object[] { Long.valueOf(factionid), Integer.valueOf(stage), Long.valueOf(sessionid) });
/*     */   }
/*     */   
/*     */ 
/*     */   static void setStageAndBroadcast(long factionid, Gang faction, FactionPVETmp xFactionPVETmp, int stage, MilliSession session)
/*     */   {
/* 331 */     long sessionid = -1L;
/* 332 */     long endTime = -1L;
/*     */     
/* 334 */     if (session != null) {
/* 335 */       sessionid = session.getSessionId();
/* 336 */       endTime = session.getTimeoutTimestamp();
/*     */     }
/*     */     
/* 339 */     setStageAndBroadcast(factionid, faction, xFactionPVETmp, stage, sessionid, endTime);
/*     */   }
/*     */   
/*     */   private static void setStageAndBroadcast(long factionid, Gang faction, FactionPVETmp xFactionPVETmp, int stage, long sessionid, long endTime) {
/* 343 */     setStage(factionid, xFactionPVETmp, stage, sessionid);
/* 344 */     broadcastFactionPVEStage(faction, stage, endTime);
/*     */   }
/*     */   
/*     */   static boolean addMonsterCountOfRole(RoleFactionPVE xRolePVE, int monsterid, int count)
/*     */   {
/* 349 */     if (reachMaxRoleGoalTimes(xRolePVE)) {
/* 350 */       return false;
/*     */     }
/* 352 */     Integer old = (Integer)xRolePVE.getGoal().get(Integer.valueOf(monsterid));
/* 353 */     int newCount = count;
/* 354 */     if (old != null) {
/* 355 */       newCount += old.intValue();
/*     */     }
/* 357 */     xRolePVE.getGoal().put(Integer.valueOf(monsterid), Integer.valueOf(newCount));
/*     */     
/* 359 */     return true;
/*     */   }
/*     */   
/*     */   static boolean reachMaxRoleGoalTimes(RoleFactionPVE xRolePVE) {
/* 363 */     return xRolePVE.getGoal_times() >= SFactionPVEConsts.getInstance().PersonGoalCount;
/*     */   }
/*     */   
/*     */   static boolean checkAndHandleRoleGoal(RoleFactionPVE xRolePVE) {
/* 367 */     if (reachMaxRoleGoalTimes(xRolePVE)) {
/* 368 */       return false;
/*     */     }
/*     */     
/* 371 */     if (checkMonsterGoalOfRole(xRolePVE)) {
/* 372 */       xRolePVE.setGoal_times(xRolePVE.getGoal_times() + 1);
/* 373 */       xRolePVE.getGoal().clear();
/* 374 */       return true;
/*     */     }
/* 376 */     return false;
/*     */   }
/*     */   
/*     */   static boolean addMonsterCountOfFaction(FactionPVETmp xFactionPVETmp, int monsterid, int count) {
/* 380 */     if (!FactionPVEConfigManager.isGoalMonster(monsterid)) {
/* 381 */       return false;
/*     */     }
/* 383 */     if (xFactionPVETmp.getStage() != 2) {
/* 384 */       return false;
/*     */     }
/* 386 */     Integer old = (Integer)xFactionPVETmp.getGoal().get(Integer.valueOf(monsterid));
/* 387 */     int newCount = count;
/* 388 */     if (old != null) {
/* 389 */       newCount += old.intValue();
/*     */     }
/*     */     
/* 392 */     xFactionPVETmp.getGoal().put(Integer.valueOf(monsterid), Integer.valueOf(newCount));
/*     */     
/* 394 */     return true;
/*     */   }
/*     */   
/*     */   static boolean checkMonsterGoalOfRole(RoleFactionPVE xRolePVE)
/*     */   {
/* 399 */     for (SFactionPVEMonsterGoalCfg goalCfg : SFactionPVEMonsterGoalCfg.getAll().values()) {
/* 400 */       Integer count = (Integer)xRolePVE.getGoal().get(Integer.valueOf(goalCfg.monsterid));
/* 401 */       if (count == null) {
/* 402 */         return false;
/*     */       }
/* 404 */       if (count.intValue() < goalCfg.personGoal) {
/* 405 */         return false;
/*     */       }
/*     */     }
/* 408 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkMonsterGoalOfFaction(FactionPVETmp xFactionPVETmp)
/*     */   {
/* 418 */     for (SFactionPVEMonsterGoalCfg goalCfg : SFactionPVEMonsterGoalCfg.getAll().values()) {
/* 419 */       Integer count = (Integer)xFactionPVETmp.getGoal().get(Integer.valueOf(goalCfg.monsterid));
/* 420 */       if (count == null) {
/* 421 */         return false;
/*     */       }
/* 423 */       if (count.intValue() < goalCfg.factionGoal) {
/* 424 */         return false;
/*     */       }
/*     */     }
/* 427 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean clearActivityStatus(long roleid)
/*     */   {
/* 438 */     return RoleStatusInterface.unsetStatus(roleid, 1021);
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
/*     */   static void leave(long roleid, Gang faction)
/*     */   {
/* 452 */     if (faction != null)
/*     */     {
/* 454 */       GangInterface.forceTransferToGangMap(roleid, faction.getGangId());
/*     */     }
/*     */     else
/*     */     {
/* 458 */       MapInterface.forceTransferWhenFault(roleid);
/*     */     }
/*     */   }
/*     */   
/*     */   static void syncSelfKillMonster(long roleid, RoleFactionPVE xRolePVE)
/*     */   {
/* 464 */     SSyncSelfKillMonster sync = new SSyncSelfKillMonster();
/* 465 */     sync.goal_times = xRolePVE.getGoal_times();
/* 466 */     sync.monsters.putAll(xRolePVE.getGoal());
/* 467 */     OnlineManager.getInstance().send(roleid, sync);
/*     */   }
/*     */   
/*     */   static void broadcastFactionKillMonster(FactionPVETmp xFactionPVETmp) {
/* 471 */     Protocol sync = getSyncFactionKillMonsterProtocol(xFactionPVETmp);
/* 472 */     MapInterface.brocadCastInWorld(xFactionPVETmp.getWorld(), sync, false);
/*     */   }
/*     */   
/*     */   static void syncFactionKillMonster(long roleid, FactionPVETmp xFactionPVETmp) {
/* 476 */     Protocol sync = getSyncFactionKillMonsterProtocol(xFactionPVETmp);
/* 477 */     OnlineManager.getInstance().send(roleid, sync);
/*     */   }
/*     */   
/*     */   private static Protocol getSyncFactionKillMonsterProtocol(FactionPVETmp xFactionPVETmp) {
/* 481 */     SSyncFactionKillMonster sync = new SSyncFactionKillMonster();
/* 482 */     sync.monsters.putAll(xFactionPVETmp.getGoal());
/* 483 */     return sync;
/*     */   }
/*     */   
/*     */   static long getFactionPVEEndTime(FactionPVE xFactionPVE)
/*     */   {
/* 488 */     if (xFactionPVE == null) {
/* 489 */       return -1L;
/*     */     }
/* 491 */     if (xFactionPVE.getStart_timestamp() <= 0L) {
/* 492 */       return -1L;
/*     */     }
/* 494 */     return xFactionPVE.getStart_timestamp() + TimeUnit.MINUTES.toMillis(SFactionPVEConsts.getInstance().ActivityMinutes);
/*     */   }
/*     */   
/*     */   static void broadcastPlayCount(long world)
/*     */   {
/* 499 */     int count = MapInterface.getRoleNumInWorld(world);
/* 500 */     Protocol p = getSyncPlayerCount(count);
/* 501 */     MapInterface.brocadCastInWorld(world, p, false);
/*     */   }
/*     */   
/*     */   static void syncPlayerCount(long roleid, int playerCount) {
/* 505 */     Protocol p = getSyncPlayerCount(playerCount);
/* 506 */     OnlineManager.getInstance().send(roleid, p);
/*     */   }
/*     */   
/*     */   private static Protocol getSyncPlayerCount(int playerCount) {
/* 510 */     SSyncPlayerCount sync = new SSyncPlayerCount();
/* 511 */     sync.count = playerCount;
/* 512 */     return sync;
/*     */   }
/*     */   
/*     */   static void sendKillBossAward(long roleid, int bossid, AwardModel awardModel)
/*     */   {
/* 517 */     SKillBossAwardNotify notify = new SKillBossAwardNotify();
/* 518 */     notify.bossid = bossid;
/* 519 */     AwardInterface.fillAwardBean(notify.award, awardModel);
/* 520 */     OnlineManager.getInstance().send(roleid, notify);
/*     */   }
/*     */   
/*     */   static void sendSelfGoalAward(long roleid, int goalTimes, AwardModel awardModel) {
/* 524 */     SSelfGoalAwardNotify notify = new SSelfGoalAwardNotify();
/* 525 */     notify.goal_times = goalTimes;
/* 526 */     AwardInterface.fillAwardBean(notify.award, awardModel);
/* 527 */     OnlineManager.getInstance().send(roleid, notify);
/*     */   }
/*     */   
/*     */   static void addKilledBoss(FactionPVETmp xFactionPVETmp, int bossid)
/*     */   {
/* 532 */     Integer count = (Integer)xFactionPVETmp.getKilled_boss().get(Integer.valueOf(bossid));
/* 533 */     if (count == null) {
/* 534 */       xFactionPVETmp.getKilled_boss().put(Integer.valueOf(bossid), Integer.valueOf(1));
/*     */     }
/*     */     else {
/* 537 */       xFactionPVETmp.getKilled_boss().put(Integer.valueOf(bossid), Integer.valueOf(count.intValue() + 1));
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean isAllBossKilled(FactionPVETmp xFactionPVETmp) {
/* 542 */     for (SKillBossAwardCfg awardCfg : SKillBossAwardCfg.getAll().values()) {
/* 543 */       Integer count = (Integer)xFactionPVETmp.getKilled_boss().get(Integer.valueOf(awardCfg.bossid));
/* 544 */       if (count == null) {
/* 545 */         return false;
/*     */       }
/* 547 */       if (count.intValue() < awardCfg.bossNumber) {
/* 548 */         return false;
/*     */       }
/*     */     }
/* 551 */     return true;
/*     */   }
/*     */   
/*     */   private static SSyncKillBossCountBrd getSyncKillBossCountProtocol(FactionPVETmp xFactionPVETmp)
/*     */   {
/* 556 */     SSyncKillBossCountBrd brd = new SSyncKillBossCountBrd();
/* 557 */     brd.boss2count.putAll(xFactionPVETmp.getKilled_boss());
/* 558 */     return brd;
/*     */   }
/*     */   
/*     */   static void broadcastKillBossCount(FactionPVETmp xFactionPVETmp) {
/* 562 */     long world = xFactionPVETmp.getWorld();
/* 563 */     SSyncKillBossCountBrd brd = getSyncKillBossCountProtocol(xFactionPVETmp);
/* 564 */     brd.boss2count.putAll(xFactionPVETmp.getKilled_boss());
/* 565 */     MapInterface.brocadCastInWorld(world, brd, false);
/*     */   }
/*     */   
/*     */   static void sendKillBossCount(long roleid, FactionPVETmp xFactionPVETmp) {
/* 569 */     SSyncKillBossCountBrd sync = getSyncKillBossCountProtocol(xFactionPVETmp);
/* 570 */     OnlineManager.getInstance().send(roleid, sync);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void broadcastKillBossTimeout(long world)
/*     */   {
/* 578 */     SKillBossTimeoutBrd brd = new SKillBossTimeoutBrd();
/* 579 */     MapInterface.brocadCastInWorld(world, brd, false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void broadcastKillBossSucceed(long world)
/*     */   {
/* 588 */     SKillBossSucceedBrd brd = new SKillBossSucceedBrd();
/* 589 */     MapInterface.brocadCastInWorld(world, brd, false);
/*     */   }
/*     */   
/*     */   static void broadcastKillBoss(long world, List<String> roles, int bossid)
/*     */   {
/* 594 */     SKillBossBrd brd = new SKillBossBrd();
/* 595 */     brd.roles.addAll(roles);
/* 596 */     brd.bossid = bossid;
/* 597 */     MapInterface.brocadCastInWorld(world, brd, false);
/*     */   }
/*     */   
/*     */   static void broadcastKillRelatedMonster(long world, String leaderName, int relatedMonster, int bossid) {
/* 601 */     SKillRelatedMonsterBrd brd = new SKillRelatedMonsterBrd();
/* 602 */     brd.leader_name = leaderName;
/* 603 */     brd.related_monster = relatedMonster;
/* 604 */     brd.bossid = bossid;
/* 605 */     MapInterface.brocadCastInWorld(world, brd, false);
/*     */   }
/*     */   
/*     */   static void sendFactionGoalAward(long roleid, AwardModel awardModel) {
/* 609 */     SFactionGoalAwardNotify notify = new SFactionGoalAwardNotify();
/* 610 */     AwardInterface.fillAwardBean(notify.award, awardModel);
/* 611 */     OnlineManager.getInstance().send(roleid, notify);
/*     */   }
/*     */   
/*     */   static void addActivateTimesAndBroadcast(Gang faction, FactionPVE xFactionPVE) {
/* 615 */     xFactionPVE.setActivate_times(xFactionPVE.getActivate_times() + 1);
/* 616 */     if (faction != null) {
/* 617 */       Protocol brd = getFactionPVETimesBrdProtocol(xFactionPVE);
/* 618 */       faction.broadcast(brd);
/*     */     }
/*     */   }
/*     */   
/*     */   static long getPVEEndTime(FactionPVE xFactionPVE) {
/* 623 */     return xFactionPVE.getStart_timestamp() + TimeUnit.MINUTES.toMillis(SFactionPVEConsts.getInstance().ActivityMinutes);
/*     */   }
/*     */   
/*     */   static boolean canParticipate(RoleFactionPVE xRolePVE, long factionid, long pveStartTime)
/*     */   {
/* 628 */     if (xRolePVE.getParticipate_times() < SFactionPVEConsts.getInstance().ParticipateTimes) {
/* 629 */       return true;
/*     */     }
/* 631 */     if (xRolePVE.getParticipate_faction() != factionid) {
/* 632 */       return false;
/*     */     }
/* 634 */     if (xRolePVE.getParticipate_millis() < pveStartTime) {
/* 635 */       return false;
/*     */     }
/*     */     
/* 638 */     return true;
/*     */   }
/*     */   
/*     */   static void setParticipateAndCheckClearRolePVE(RoleFactionPVE xRolePVE, long factionid, long pveStartTime, long nowMillis)
/*     */   {
/* 643 */     if ((xRolePVE.getParticipate_faction() != factionid) || (xRolePVE.getParticipate_millis() <= pveStartTime))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 649 */       clearXRoleFactionPVE(xRolePVE);
/*     */       
/* 651 */       xRolePVE.setParticipate_times(xRolePVE.getParticipate_times() + 1);
/*     */     }
/* 653 */     xRolePVE.setParticipate_faction(factionid);
/* 654 */     xRolePVE.setParticipate_millis(nowMillis);
/*     */   }
/*     */   
/*     */   static void syncParticipateTimes(long roleid, RoleFactionPVE xRolePVE)
/*     */   {
/* 659 */     SSyncParticipateTimes sync = new SSyncParticipateTimes();
/* 660 */     sync.participate_times = xRolePVE.getParticipate_times();
/* 661 */     sync.participate_millis = xRolePVE.getParticipate_millis();
/* 662 */     sync.participate_faction = xRolePVE.getParticipate_faction();
/* 663 */     OnlineManager.getInstance().send(roleid, sync);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isStageCanEnter(int stage)
/*     */   {
/* 672 */     if (stage < 1) {
/* 673 */       return false;
/*     */     }
/* 675 */     if (stage >= 5) {
/* 676 */       return false;
/*     */     }
/* 678 */     return true;
/*     */   }
/*     */   
/*     */   static void tlogSetStartTime(Role role, Gang faction, int date, int hour, int minute, int activateTimes)
/*     */   {
/* 683 */     if ((role == null) || (faction == null)) {
/* 684 */       return;
/*     */     }
/*     */     
/* 687 */     String userid = role.getUserId();
/*     */     
/* 689 */     TLogManager.getInstance().addLog(userid, "FactionPVESetStartTime", new Object[] { GameServerInfoManager.getHostIP(), userid, role.getUserId(), Integer.valueOf(role.getLevel()), Long.valueOf(faction.getGangId()), Long.valueOf(faction.getDisplayid()), Integer.valueOf(faction.getLevel()), Integer.valueOf(date), Integer.valueOf(hour), Integer.valueOf(minute), Integer.valueOf(activateTimes) });
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
/*     */ 
/*     */ 
/*     */   static void tlogParticipate(String leaderUserid, long factionid, long displayid, int participateCount, int onlineCount)
/*     */   {
/* 706 */     TLogManager.getInstance().addLog(leaderUserid, "FactionPVEParticipate", new Object[] { GameServerInfoManager.getHostIP(), Long.valueOf(factionid), Long.valueOf(displayid), Integer.valueOf(participateCount), Integer.valueOf(onlineCount) });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void tlogEnd(String leaderUserid, long factionid, long displayid, int participateCount, int onlineCount, int result, int durationMillis, FactionPVETmp xFactionPVETmp)
/*     */   {
/* 718 */     List<Object> logObjs = new ArrayList();
/* 719 */     logObjs.add(GameServerInfoManager.getHostIP());
/* 720 */     logObjs.add(Long.valueOf(factionid));
/* 721 */     logObjs.add(Long.valueOf(displayid));
/* 722 */     logObjs.add(Integer.valueOf(participateCount));
/* 723 */     logObjs.add(Integer.valueOf(onlineCount));
/* 724 */     logObjs.add(Integer.valueOf(result));
/* 725 */     logObjs.add(Integer.valueOf(durationMillis));
/*     */     
/* 727 */     int bossCount = 0;
/*     */     
/* 729 */     for (SKillBossAwardCfg bossCfg : SKillBossAwardCfg.getAll().values()) {
/* 730 */       logObjs.add(Integer.valueOf(bossCfg.bossid));
/* 731 */       Integer killCount = (Integer)xFactionPVETmp.getKilled_boss().get(Integer.valueOf(bossCfg.bossid));
/* 732 */       if (killCount != null) {
/* 733 */         logObjs.add(Integer.valueOf(killCount.intValue()));
/*     */       }
/*     */       else {
/* 736 */         logObjs.add(Integer.valueOf(0));
/*     */       }
/* 738 */       bossCount++;
/*     */     }
/*     */     
/* 741 */     if (bossCount > 5) {
/* 742 */       logError("FactionPVEManager.tlogEnd@boss too much|factionid=%d|displayid=%d|participate_count=%d|online_count=%d|args=%s", new Object[] { Long.valueOf(factionid), Long.valueOf(displayid), Integer.valueOf(participateCount), Integer.valueOf(onlineCount), logObjs.toString() });
/*     */       
/* 744 */       return;
/*     */     }
/* 747 */     for (; 
/* 747 */         bossCount < 5; bossCount++) {
/* 748 */       logObjs.add(Integer.valueOf(0));
/* 749 */       logObjs.add(Integer.valueOf(0));
/*     */     }
/*     */     
/* 752 */     TLogManager.getInstance().addLog(leaderUserid, "FactionPVEEnd", logObjs.toArray());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\FactionPVEManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */