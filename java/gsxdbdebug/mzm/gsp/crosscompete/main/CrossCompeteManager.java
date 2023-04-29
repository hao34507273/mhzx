/*     */ package mzm.gsp.crosscompete.main;
/*     */ 
/*     */ import hub.CrossCompeteAgainstFaction;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.crosscompete.Against;
/*     */ import mzm.gsp.crosscompete.AgainstFaction;
/*     */ import mzm.gsp.crosscompete.CompeteResultFaction;
/*     */ import mzm.gsp.crosscompete.SCompeteResultBrd;
/*     */ import mzm.gsp.crosscompete.SCrossCompeteNormalResult;
/*     */ import mzm.gsp.crosscompete.SEnterCrossCompeteMapFailBrd;
/*     */ import mzm.gsp.crosscompete.SEnterCrossCompeteMapInProgressBrd;
/*     */ import mzm.gsp.crosscompete.SEnterCrossCompeteMapSucceedBrd;
/*     */ import mzm.gsp.crosscompete.SSignUpBrd;
/*     */ import mzm.gsp.crosscompete.SSyncMatch;
/*     */ import mzm.gsp.crosscompete.SSyncSignUp;
/*     */ import mzm.gsp.crosscompete.SSyncSignUpCancel;
/*     */ import mzm.gsp.crosscompete.SignedUpFaction;
/*     */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*     */ import mzm.gsp.crosscompete.event.CrossCompeteParticipateArg;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.online.main.LoginManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossCompete;
/*     */ import xbean.CrossCompeteAgainst;
/*     */ import xbean.CrossCompeteMatch;
/*     */ import xbean.CrossCompeteMatchFaction;
/*     */ import xbean.CrossCompeteSignUp;
/*     */ import xbean.FactionCrossCompete;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleCrossCompete;
/*     */ import xtable.Crosscompete;
/*     */ import xtable.Faction_crosscompete;
/*     */ import xtable.Role_crosscompete;
/*     */ 
/*     */ public class CrossCompeteManager
/*     */ {
/*  57 */   static volatile boolean simplified = false;
/*     */   
/*     */   static Logger logger;
/*     */   public static final String TLOG_SIGN_UP = "CrossCompeteSignUp";
/*     */   public static final String TLOG_MATCH = "CrossCompeteMatch";
/*     */   public static final String TLOG_PARTICIPATE = "CrossCompeteParticipate";
/*     */   public static final String TLOG_RESULT = "CrossCompeteResult";
/*     */   public static final int TLOG_RESULT_BOTH_GIVEUP = 1;
/*     */   public static final int TLOG_RESULT_FRONT_GIVEUP = 2;
/*     */   public static final int TLOG_RESULT_BEHIND_GIVEUP = 3;
/*     */   public static final int TLOG_RESULT_FRONT_WIN = 4;
/*     */   public static final int TLOG_RESULT_BEHIND_WIN = 5;
/*     */   
/*     */   static void init()
/*     */   {
/*  72 */     logger = Logger.getLogger("crosscompete");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static DateFormat getNotifyDateFormat()
/*     */   {
/*  82 */     return new SimpleDateFormat("yyyy-MM-dd HH:mm");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static DateFormat getLogDateFormat()
/*     */   {
/*  91 */     return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
/*     */   }
/*     */   
/*     */   public static boolean isLoggerDebugEnabled() {
/*  95 */     return logger.isDebugEnabled();
/*     */   }
/*     */   
/*     */   public static void logWarn(String formatStr, Object... args) {
/*  99 */     logger.warn(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   public static void logError(String formatStr, Object... args) {
/* 103 */     logger.error(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   public static void logInfo(String formatStr, Object... args) {
/* 107 */     logger.info(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   public static void logDebug(String formatStr, Object... args) {
/* 111 */     logger.debug(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   public static CrossCompete getXCrossCompete(boolean remainLock) {
/* 115 */     long key = GameServerInfoManager.getLocalId();
/* 116 */     CrossCompete xCompete = null;
/* 117 */     if (remainLock) {
/* 118 */       xCompete = Crosscompete.get(Long.valueOf(key));
/*     */     }
/*     */     else {
/* 121 */       xCompete = Crosscompete.select(Long.valueOf(key));
/*     */     }
/*     */     
/* 124 */     return xCompete;
/*     */   }
/*     */   
/*     */   public static CrossCompete createXCrossCompeteIfNotExist()
/*     */   {
/* 129 */     long key = GameServerInfoManager.getLocalId();
/* 130 */     CrossCompete xCompete = Crosscompete.get(Long.valueOf(key));
/* 131 */     if (xCompete == null) {
/* 132 */       xCompete = Pod.newCrossCompete();
/* 133 */       Crosscompete.insert(Long.valueOf(key), xCompete);
/* 134 */       initXCrossCompete(xCompete);
/*     */     }
/* 136 */     return xCompete;
/*     */   }
/*     */   
/*     */   static void initXCrossCompete(CrossCompete xCompete)
/*     */   {
/* 141 */     xCompete.getSignup_factions().clear();
/*     */   }
/*     */   
/*     */   static FactionCrossCompete createXFactionCrossCompeteIfNotExist(long factionid)
/*     */   {
/* 146 */     FactionCrossCompete xFactionCompete = Faction_crosscompete.get(Long.valueOf(factionid));
/* 147 */     if (xFactionCompete == null) {
/* 148 */       xFactionCompete = Pod.newFactionCrossCompete();
/* 149 */       Faction_crosscompete.insert(Long.valueOf(factionid), xFactionCompete);
/* 150 */       initXFactionCrossCompete(xFactionCompete);
/*     */     }
/*     */     
/* 153 */     return xFactionCompete;
/*     */   }
/*     */   
/*     */   static void initXFactionCrossCompete(FactionCrossCompete xFactionCompete) {
/* 157 */     xFactionCompete.setOpponent(-1L);
/*     */   }
/*     */   
/*     */   public static FactionCrossCompete getXFactionCrossCompete(long factionid, boolean remainLock) {
/* 161 */     FactionCrossCompete xFactionCompete = null;
/* 162 */     if (remainLock) {
/* 163 */       xFactionCompete = Faction_crosscompete.get(Long.valueOf(factionid));
/*     */     }
/*     */     else {
/* 166 */       xFactionCompete = Faction_crosscompete.select(Long.valueOf(factionid));
/*     */     }
/* 168 */     return xFactionCompete;
/*     */   }
/*     */   
/*     */   static RoleCrossCompete createXRoleCrossCompeteIfNotExist(long roleid) {
/* 172 */     RoleCrossCompete xRoleCompete = Role_crosscompete.get(Long.valueOf(roleid));
/* 173 */     if (xRoleCompete == null) {
/* 174 */       xRoleCompete = Pod.newRoleCrossCompete();
/* 175 */       Role_crosscompete.insert(Long.valueOf(roleid), xRoleCompete);
/*     */       
/* 177 */       initXRoleCrossCompete(roleid, xRoleCompete);
/*     */     }
/* 179 */     return xRoleCompete;
/*     */   }
/*     */   
/*     */   static void initXRoleCrossCompete(long roleid, RoleCrossCompete xRoleCompete) {
/* 183 */     xRoleCompete.setParticipated(false);
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean addSignUpFaction(CrossCompete xCompete, long factionid, long signUpTime, long activityStartTime)
/*     */   {
/* 189 */     CrossCompeteSignUp xSignUp = (CrossCompeteSignUp)xCompete.getSignup_factions().get(Long.valueOf(factionid));
/* 190 */     if (xSignUp != null) {
/* 191 */       if (xSignUp.getTime() > activityStartTime) {
/* 192 */         return false;
/*     */       }
/*     */     }
/*     */     else {
/* 196 */       xSignUp = Pod.newCrossCompeteSignUp();
/* 197 */       xCompete.getSignup_factions().put(Long.valueOf(factionid), xSignUp);
/*     */     }
/* 199 */     xSignUp.setTime(signUpTime);
/* 200 */     return true;
/*     */   }
/*     */   
/*     */   static boolean isSignedUp(CrossCompete xCompete, long factionid) {
/* 204 */     if (xCompete == null) {
/* 205 */       return false;
/*     */     }
/* 207 */     return xCompete.getSignup_factions().containsKey(Long.valueOf(factionid));
/*     */   }
/*     */   
/*     */   public static void sendNormalResult(long roleid, int result, Object... args) {
/* 211 */     SCrossCompeteNormalResult p = getNormalResult(result, args);
/* 212 */     OnlineManager.getInstance().sendAtOnce(roleid, p);
/*     */   }
/*     */   
/*     */   public static void broadcastNormalResult(Collection<Long> roles, int result, Object... args) {
/* 216 */     SCrossCompeteNormalResult p = getNormalResult(result, args);
/* 217 */     OnlineManager.getInstance().sendMultiAtOnce(p, roles);
/*     */   }
/*     */   
/*     */   private static SCrossCompeteNormalResult getNormalResult(int result, Object... args) {
/* 221 */     SCrossCompeteNormalResult p = new SCrossCompeteNormalResult();
/* 222 */     p.result = result;
/* 223 */     for (Object arg : args) {
/* 224 */       p.args.add(arg.toString());
/*     */     }
/* 226 */     return p;
/*     */   }
/*     */   
/*     */   static void syncSignUp(long roleid) {
/* 230 */     SSyncSignUp sync = new SSyncSignUp();
/* 231 */     OnlineManager.getInstance().send(roleid, sync);
/*     */   }
/*     */   
/*     */   static void broadcastSignUp(Gang faction, long roleid, String name) {
/* 235 */     SSignUpBrd brd = new SSignUpBrd();
/* 236 */     brd.manager_id = roleid;
/* 237 */     brd.manager_name = name;
/* 238 */     faction.broadcast(brd);
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean cancelSignUp(CrossCompete xCompete, long factionid, Gang faction, long activityStartTime)
/*     */   {
/* 244 */     CrossCompeteSignUp xSignUp = (CrossCompeteSignUp)xCompete.getSignup_factions().get(Long.valueOf(factionid));
/* 245 */     if ((xSignUp != null) && 
/* 246 */       (xSignUp.getTime() > activityStartTime)) {
/* 247 */       xCompete.getSignup_factions().remove(Long.valueOf(factionid));
/* 248 */       if (faction != null)
/*     */       {
/* 250 */         broadcastSignUpCancel(faction);
/*     */       }
/* 252 */       return true;
/*     */     }
/*     */     
/* 255 */     return false;
/*     */   }
/*     */   
/*     */   static void broadcastSignUpCancel(Gang faction)
/*     */   {
/* 260 */     SSyncSignUpCancel sync = new SSyncSignUpCancel();
/* 261 */     faction.broadcast(sync);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void fillSignedUpFactionBean(SignedUpFaction factionBean, long factionid, String factionName, long factonDisplayid, long leaderid, String leaderName)
/*     */   {
/* 268 */     factionBean.factionid = factionid;
/* 269 */     factionBean.faction_name = factionName;
/* 270 */     factionBean.faction_displayid = factonDisplayid;
/* 271 */     factionBean.leaderid = leaderid;
/* 272 */     factionBean.leader_name = leaderName;
/*     */   }
/*     */   
/*     */   static boolean needReportSignUp(CrossCompete xCompete)
/*     */   {
/* 277 */     if (xCompete == null) {
/* 278 */       return false;
/*     */     }
/* 280 */     for (Iterator i$ = xCompete.getSignup_factions().keySet().iterator(); i$.hasNext();) { long factionid = ((Long)i$.next()).longValue();
/* 281 */       if (!isFactionMatched(xCompete, factionid)) {
/* 282 */         return true;
/*     */       }
/*     */     }
/* 285 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean isFactionMatched(CrossCompete xCompete, long factionid)
/*     */   {
/* 294 */     if (xCompete == null) {
/* 295 */       return false;
/*     */     }
/*     */     
/* 298 */     Iterator<CrossCompeteMatch> matchIter = xCompete.getAgainsts().keySet().iterator();
/* 299 */     while (matchIter.hasNext()) {
/* 300 */       CrossCompeteMatch cMatch = (CrossCompeteMatch)matchIter.next();
/* 301 */       if (cMatch.getFront_factionid() == factionid) {
/* 302 */         return true;
/*     */       }
/* 304 */       if (cMatch.getBehind_factionid() == factionid) {
/* 305 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 309 */     if (xCompete.getMiss_turn_factions().contains(Long.valueOf(factionid))) {
/* 310 */       return true;
/*     */     }
/*     */     
/* 313 */     return false;
/*     */   }
/*     */   
/*     */   static boolean isAgainstEmpty(CrossCompete xCompete)
/*     */   {
/* 318 */     if (xCompete == null) {
/* 319 */       return true;
/*     */     }
/* 321 */     return xCompete.getAgainsts().isEmpty();
/*     */   }
/*     */   
/*     */   public static CrossCompeteMatch getCMatch(long factionid1, long factionid2) {
/* 325 */     if (factionid1 < factionid2) {
/* 326 */       return new CrossCompeteMatch(factionid1, factionid2);
/*     */     }
/*     */     
/* 329 */     return new CrossCompeteMatch(factionid2, factionid1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static CrossCompeteAgainst getXAgainst(CrossCompete xCompete, long factionid1, long factionid2)
/*     */   {
/* 336 */     if (xCompete == null) {
/* 337 */       return null;
/*     */     }
/* 339 */     CrossCompeteMatch cMatch = getCMatch(factionid1, factionid2);
/* 340 */     CrossCompeteAgainst xAgainst = (CrossCompeteAgainst)xCompete.getAgainsts().get(cMatch);
/* 341 */     return xAgainst;
/*     */   }
/*     */   
/*     */ 
/*     */   static void crossRoamServerFail(List<Long> roles, int reason)
/*     */   {
/* 347 */     RoleStatusInterface.unsetStatus(roles, 1501);
/*     */     
/* 349 */     RoleStatusInterface.unsetStatus(roles, 41);
/*     */     
/* 351 */     broadcastEnterCrossCompeteMapFailed(roles, reason);
/*     */   }
/*     */   
/*     */   static void broadcastEnterCrossCompeteMapInProgress(List<Long> roles, CrossCompeteMatch cMatch, CrossCompeteAgainst xAgainst)
/*     */   {
/* 356 */     SEnterCrossCompeteMapInProgressBrd brd = new SEnterCrossCompeteMapInProgressBrd();
/* 357 */     fillAgainstBean(brd.against, cMatch, xAgainst);
/* 358 */     OnlineManager.getInstance().sendMulti(brd, roles);
/*     */   }
/*     */   
/*     */   static void broadcastEnterCrossCompeteMapFailed(List<Long> roles, int reason) {
/* 362 */     SEnterCrossCompeteMapFailBrd brd = new SEnterCrossCompeteMapFailBrd();
/* 363 */     brd.reason = reason;
/* 364 */     OnlineManager.getInstance().sendMulti(brd, roles);
/*     */   }
/*     */   
/*     */   static void broadcastEnterCrossCompeteMapSucceed(List<Long> roles)
/*     */   {
/* 369 */     SEnterCrossCompeteMapSucceedBrd brd = new SEnterCrossCompeteMapSucceedBrd();
/* 370 */     OnlineManager.getInstance().sendMulti(brd, roles);
/*     */   }
/*     */   
/*     */   public static boolean isPrepareStage()
/*     */   {
/* 375 */     int stage = ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/*     */     
/* 377 */     return isPrepareStage(stage);
/*     */   }
/*     */   
/*     */   public static boolean isPrepareStage(int stage) {
/* 381 */     return (stage == 5) || (stage == 10);
/*     */   }
/*     */   
/*     */   public static boolean isFightStage()
/*     */   {
/* 386 */     int stage = ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/*     */     
/* 388 */     return isFightStage(stage);
/*     */   }
/*     */   
/*     */   public static boolean isFightStage(int stage) {
/* 392 */     return (stage == 6) || (stage == 11);
/*     */   }
/*     */   
/*     */   public static boolean isWaitForceEndStage(int stage)
/*     */   {
/* 397 */     return (stage == 7) || (stage == 12);
/*     */   }
/*     */   
/*     */ 
/*     */   public static void fillAgainstBean(Against againstBean, CrossCompeteMatch cMatch, CrossCompeteAgainst xAgainst)
/*     */   {
/* 403 */     fillAgainstFactionBean(againstBean.faction1, cMatch.getFront_factionid(), xAgainst.getFront_faction());
/*     */     
/* 405 */     fillAgainstFactionBean(againstBean.faction2, cMatch.getBehind_factionid(), xAgainst.getBehind_faction());
/*     */     
/* 407 */     againstBean.compete_index = xAgainst.getCompete_index();
/* 408 */     againstBean.winner = xAgainst.getWinner();
/*     */   }
/*     */   
/*     */   static void fillAgainstFactionBean(AgainstFaction factionBean, long factionid, CrossCompeteMatchFaction xMatchFaction)
/*     */   {
/* 413 */     factionBean.factionid = factionid;
/* 414 */     factionBean.faction_name = xMatchFaction.getName();
/* 415 */     factionBean.faction_level = xMatchFaction.getLevel();
/* 416 */     factionBean.server_level = xMatchFaction.getServer_level();
/* 417 */     factionBean.member_count = xMatchFaction.getMember_count();
/*     */   }
/*     */   
/*     */   static void tlogSignUp(Role role, Gang faction, int needRoleLevel, int levelQualifiedCount) {
/* 421 */     if ((role == null) || (faction == null)) {
/* 422 */       return;
/*     */     }
/*     */     
/* 425 */     String userid = role.getUserId();
/*     */     
/* 427 */     TLogManager.getInstance().addLog(userid, "CrossCompeteSignUp", new Object[] { GameServerInfoManager.getHostIP(), userid, Long.valueOf(role.getId()), Integer.valueOf(role.getLevel()), Long.valueOf(faction.getGangId()), Integer.valueOf(faction.getLevel()), Long.valueOf(faction.getDisplayid()), Integer.valueOf(faction.getVitality()), Integer.valueOf(needRoleLevel), Integer.valueOf(levelQualifiedCount) });
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
/*     */   public static void tlogMatch(long factionid1, int factionLevel1, int serverLevel1, long factionid2, int factionLevel2, int serverLevel2, int matchTimes)
/*     */   {
/* 443 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/* 444 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 445 */     long time = DateTimeUtils.getCurrTimeInMillis();
/* 446 */     String dtEventTime = sdf.format(Long.valueOf(time));
/*     */     
/* 448 */     String vGameAppid = "0";
/* 449 */     int PlatID = -1;
/* 450 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/* 451 */     String vopenid = "0";
/*     */     
/* 453 */     Object[] columns = { GameSvrId, dtEventTime, "0", Integer.valueOf(-1), Integer.valueOf(iZoneAreaID), "0", Long.valueOf(factionid1), Integer.valueOf(factionLevel1), Integer.valueOf(serverLevel1), Long.valueOf(factionid2), Integer.valueOf(factionLevel2), Integer.valueOf(serverLevel2), Integer.valueOf(matchTimes) };
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 458 */     TLogManager.getInstance().addLog("CrossCompeteMatch", columns);
/*     */   }
/*     */   
/*     */   public static void tlogParticipate(long factionid1, int count1, long factionid2, int count2) {
/* 462 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/* 463 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 464 */     long time = DateTimeUtils.getCurrTimeInMillis();
/* 465 */     String dtEventTime = sdf.format(Long.valueOf(time));
/*     */     
/* 467 */     String vGameAppid = "0";
/* 468 */     int PlatID = -1;
/* 469 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/* 470 */     String vopenid = "0";
/*     */     
/* 472 */     Object[] columns = { GameSvrId, dtEventTime, "0", Integer.valueOf(-1), Integer.valueOf(iZoneAreaID), "0", Long.valueOf(factionid1), Integer.valueOf(count1), Long.valueOf(factionid2), Integer.valueOf(count2) };
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 477 */     TLogManager.getInstance().addLog("CrossCompeteParticipate", columns);
/*     */   }
/*     */   
/*     */   public static void tlogResult(long factionid1, int pkScore1, int playerScore1, long factionid2, int pkScore2, int playerScore2, int result)
/*     */   {
/* 482 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/* 483 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 484 */     long time = DateTimeUtils.getCurrTimeInMillis();
/* 485 */     String dtEventTime = sdf.format(Long.valueOf(time));
/*     */     
/* 487 */     String vGameAppid = "0";
/* 488 */     int PlatID = -1;
/* 489 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/* 490 */     String vopenid = "0";
/*     */     
/* 492 */     Object[] columns = { GameSvrId, dtEventTime, "0", Integer.valueOf(-1), Integer.valueOf(iZoneAreaID), "0", Long.valueOf(factionid1), Integer.valueOf(pkScore1), Integer.valueOf(playerScore1), Long.valueOf(factionid2), Integer.valueOf(pkScore2), Integer.valueOf(playerScore2), Integer.valueOf(result) };
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 497 */     TLogManager.getInstance().addLog("CrossCompeteResult", columns);
/*     */   }
/*     */   
/*     */ 
/*     */   public static void fillXCrossCompeteMatchFaction(CrossCompeteMatchFaction xFaction, CrossCompeteAgainstFaction factionBean)
/*     */   {
/* 503 */     xFaction.setName(factionBean.faction_name);
/* 504 */     xFaction.setLevel(factionBean.faction_level);
/* 505 */     xFaction.setServer_level(factionBean.server_level);
/* 506 */     xFaction.setMember_count(factionBean.member_count);
/*     */   }
/*     */   
/*     */ 
/*     */   static void syncMatch(long roleid, int competeIndex)
/*     */   {
/* 512 */     SSyncMatch p = getSyncMatchProtocol(competeIndex);
/* 513 */     OnlineManager.getInstance().send(roleid, p);
/*     */   }
/*     */   
/*     */   static void broadcastMatch(Gang faction, int competeIndex) {
/* 517 */     SSyncMatch p = getSyncMatchProtocol(competeIndex);
/* 518 */     faction.broadcast(p);
/*     */   }
/*     */   
/*     */   static SSyncMatch getSyncMatchProtocol(int competeIndex) {
/* 522 */     SSyncMatch p = new SSyncMatch();
/* 523 */     p.compete_index = competeIndex;
/* 524 */     return p;
/*     */   }
/*     */   
/*     */   static long getCompeteBeginTime(int competeIndex) {
/* 528 */     long startTime = 0L;
/*     */     
/* 530 */     if (CrossCompeteConfigManager.isInFirstCompeteTime(competeIndex)) {
/* 531 */       startTime = ActivityInterface.getActivityStageEndTime(SCrossCompeteConsts.getInstance().Activityid, 4);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 536 */       startTime = ActivityInterface.getActivityStageEndTime(SCrossCompeteConsts.getInstance().Activityid, 9);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 541 */     return startTime;
/*     */   }
/*     */   
/*     */   static String getCompeteBeginTimeStr(int competeIndex) {
/* 545 */     long startTime = getCompeteBeginTime(competeIndex);
/* 546 */     return getDateStr(startTime);
/*     */   }
/*     */   
/*     */   static long getCompeteForbidEnterTime(int competeIndex) {
/* 550 */     long forbidEnterTime = 0L;
/* 551 */     if (CrossCompeteConfigManager.isInFirstCompeteTime(competeIndex)) {
/* 552 */       forbidEnterTime = ActivityInterface.getActivityStageEndTime(SCrossCompeteConsts.getInstance().Activityid, 5);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 557 */       forbidEnterTime = ActivityInterface.getActivityStageEndTime(SCrossCompeteConsts.getInstance().Activityid, 10);
/*     */     }
/*     */     
/*     */ 
/* 561 */     return forbidEnterTime;
/*     */   }
/*     */   
/*     */   static String getCompeteForbidEnterTimeStr(int competeIndex) {
/* 565 */     long forbidEnterTime = getCompeteForbidEnterTime(competeIndex);
/* 566 */     return getDateStr(forbidEnterTime);
/*     */   }
/*     */   
/*     */   static String getDateStr(long time) {
/* 570 */     DateFormat dateFormat = getNotifyDateFormat();
/* 571 */     return dateFormat.format(Long.valueOf(time));
/*     */   }
/*     */   
/*     */   static void mailAndBroadcastMatch(Gang faction, long opponentid, String opponentName, int competeIndex)
/*     */   {
/* 576 */     if (faction == null) {
/* 577 */       return;
/*     */     }
/* 579 */     long factionid = faction.getGangId();
/* 580 */     String startTimeStr = getCompeteBeginTimeStr(competeIndex);
/* 581 */     String forbindEndTimeStr = getCompeteForbidEnterTimeStr(competeIndex);
/*     */     
/* 583 */     TLogArg tlogArg = new TLogArg(LogReason.CROSS_COMPETE_MATCH_MAIL, competeIndex);
/* 584 */     List<String> contentArgs = new ArrayList();
/* 585 */     contentArgs.add(startTimeStr);
/* 586 */     contentArgs.add(opponentName);
/* 587 */     contentArgs.add(forbindEndTimeStr);
/*     */     
/* 589 */     GangInterface.sendGangMail(factionid, SCrossCompeteConsts.getInstance().MatchMail, contentArgs, null, tlogArg);
/*     */     
/*     */ 
/* 592 */     logInfo("CrossCompeteManager.mailAndBroadcastMatch@match mail to faction|factionid=%d|opponentid=%d|opponent_name=%s|compete_index=%d", new Object[] { Long.valueOf(factionid), Long.valueOf(opponentid), opponentName, Integer.valueOf(competeIndex) });
/*     */     
/*     */ 
/*     */ 
/* 596 */     broadcastMatch(faction, competeIndex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void mailMissTurn(long factionid)
/*     */   {
/* 604 */     TLogArg tlogArg = new TLogArg(LogReason.CROSS_COMPETE_MISS_TURN_MAIL);
/* 605 */     GangInterface.sendGangMail(factionid, SCrossCompeteConsts.getInstance().MissTurnMail, null, null, tlogArg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void broadcastCompeteResult(long winFactionid, String winName, boolean bWinnerSelf, long loseFactionid, String loseName, boolean bLoserSelf)
/*     */   {
/* 612 */     SCompeteResultBrd brd = new SCompeteResultBrd();
/* 613 */     fillCompeteResultFactionBean(brd.win_faction, winFactionid, winName, bWinnerSelf);
/* 614 */     fillCompeteResultFactionBean(brd.lose_faction, loseFactionid, loseName, bLoserSelf);
/* 615 */     OnlineManager.getInstance().sendAll(brd);
/*     */   }
/*     */   
/*     */   private static void fillCompeteResultFactionBean(CompeteResultFaction factionBean, long factionid, String name, boolean bSelfServer)
/*     */   {
/* 620 */     factionBean.factionid = factionid;
/* 621 */     factionBean.name = name;
/* 622 */     if (bSelfServer) {
/* 623 */       factionBean.self_server = 1;
/*     */     }
/*     */     else {
/* 626 */       factionBean.self_server = 0;
/*     */     }
/*     */   }
/*     */   
/*     */   static int addMatchTimes(FactionCrossCompete xFactionCrossCompete, long opponentid) {
/* 631 */     Integer matchTimes = (Integer)xFactionCrossCompete.getFactionid2matchtimes().get(Long.valueOf(opponentid));
/* 632 */     int times = 0;
/* 633 */     if (matchTimes != null) {
/* 634 */       times = matchTimes.intValue();
/*     */     }
/* 636 */     times++;
/* 637 */     xFactionCrossCompete.getFactionid2matchtimes().put(Long.valueOf(opponentid), Integer.valueOf(times));
/* 638 */     return times;
/*     */   }
/*     */   
/*     */   static int randomDelaySeconds() {
/* 642 */     int seconds = xdb.Xdb.random().nextInt(60);
/* 643 */     if (seconds <= 0) {
/* 644 */       seconds = 1;
/*     */     }
/* 646 */     return seconds;
/*     */   }
/*     */   
/*     */   static void forceRemoveTeamBackContextByRoleid(long roleid) {
/* 650 */     long contextid = TeamBackContextManager.getInstance().getContextidByRoleid(roleid);
/* 651 */     if (contextid > 0L) {
/* 652 */       TeamBackContext context = TeamBackContextManager.getInstance().removeContext(contextid);
/* 653 */       if (context != null) {
/* 654 */         mzm.gsp.timer.main.Session.removeSession(context.getSessionid());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static void onCrossBack(String userid, long roleid) {
/* 660 */     LoginManager.getInstance().onRoleCrossEnd(userid, roleid);
/*     */     
/* 662 */     RoleStatusInterface.unsetStatus(roleid, 1501);
/*     */   }
/*     */   
/*     */   static int getEstimateParticipateCount(int participateCount, int activeCount) {
/* 666 */     if (participateCount > 0) {
/* 667 */       return participateCount;
/*     */     }
/* 669 */     return Math.max(activeCount / 2, 1);
/*     */   }
/*     */   
/*     */   static void triggerParticipateEvent(long roleid, long factionid, int winTimes, int loseTimes, int escapeTimes, boolean isWinner)
/*     */   {
/* 674 */     CrossCompeteParticipateArg participateArg = new CrossCompeteParticipateArg(roleid, factionid, winTimes, loseTimes, escapeTimes, isWinner);
/*     */     
/* 676 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.crosscompete.event.CrossCompeteParticipate(), participateArg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static ArrayList<MatchFaction> createMatchFactionListIfNotExist(TreeMap<Integer, ArrayList<MatchFaction>> level2Factions, int serverLevel)
/*     */   {
/* 688 */     ArrayList<MatchFaction> factions = (ArrayList)level2Factions.get(Integer.valueOf(serverLevel));
/* 689 */     if (factions == null) {
/* 690 */       factions = new ArrayList();
/* 691 */       level2Factions.put(Integer.valueOf(serverLevel), factions);
/*     */     }
/* 693 */     return factions;
/*     */   }
/*     */   
/*     */ 
/*     */   private static int getOpponentIndex(MatchFaction faction, List<MatchFaction> otherFactions)
/*     */   {
/* 699 */     int index = tryFindOpponentIndex(faction, otherFactions, true);
/* 700 */     if (index >= 0) {
/* 701 */       return index;
/*     */     }
/* 703 */     return tryFindOpponentIndex(faction, otherFactions, false);
/*     */   }
/*     */   
/*     */ 
/*     */   private static int tryFindOpponentIndex(MatchFaction faction, List<MatchFaction> otherFactions, boolean excludeSameServer)
/*     */   {
/* 709 */     int alternativeIndex = -1;
/* 710 */     int alternativeTimes = -1;
/* 711 */     int i = 0;
/*     */     
/* 713 */     Iterator<MatchFaction> factionIter = otherFactions.iterator();
/* 714 */     while (factionIter.hasNext()) {
/* 715 */       MatchFaction opponent = (MatchFaction)factionIter.next();
/* 716 */       if ((!excludeSameServer) || 
/* 717 */         (opponent.factionid != faction.factionid))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 722 */         int matchTimes = faction.getMatchTimes(opponent.factionid);
/* 723 */         if (matchTimes == 0) {
/* 724 */           alternativeIndex = i;
/* 725 */           break;
/*     */         }
/*     */         
/* 728 */         if (alternativeTimes < 0) {
/* 729 */           alternativeIndex = i;
/* 730 */           alternativeTimes = matchTimes;
/*     */ 
/*     */         }
/* 733 */         else if (matchTimes < alternativeTimes) {
/* 734 */           alternativeIndex = i;
/* 735 */           alternativeTimes = matchTimes;
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 740 */         i++;
/*     */       } }
/* 742 */     return alternativeIndex;
/*     */   }
/*     */   
/*     */   static void match(ArrayList<MatchFaction> factions)
/*     */   {
/* 747 */     TreeMap<Integer, ArrayList<MatchFaction>> level2Factions = new TreeMap();
/*     */     
/* 749 */     for (MatchFaction faction : factions) {
/* 750 */       ArrayList<MatchFaction> factionList = createMatchFactionListIfNotExist(level2Factions, faction.serverLevel);
/*     */       
/* 752 */       factionList.add(faction);
/*     */     }
/*     */     
/* 755 */     List<MatchFaction> leftFactions = new ArrayList();
/*     */     
/*     */ 
/* 758 */     Iterator<Map.Entry<Integer, ArrayList<MatchFaction>>> iter = level2Factions.descendingMap().entrySet().iterator();
/*     */     
/*     */ 
/* 761 */     while (iter.hasNext()) {
/* 762 */       Map.Entry<Integer, ArrayList<MatchFaction>> entry = (Map.Entry)iter.next();
/* 763 */       ArrayList<MatchFaction> matchFactions = (ArrayList)entry.getValue();
/*     */       
/*     */ 
/* 766 */       iter.remove();
/*     */       
/* 768 */       matchFactions.addAll(leftFactions);
/*     */       
/*     */ 
/* 771 */       java.util.Collections.sort(matchFactions);
/*     */       
/*     */ 
/* 774 */       if ((!matchFactions.isEmpty()) && (matchFactions.size() % 2 != 0)) {
/* 775 */         int missTurnTimes = -1;
/* 776 */         int index = -1;
/* 777 */         for (int i = matchFactions.size() - 1; i >= 0; i--) {
/* 778 */           MatchFaction matchFaction = (MatchFaction)matchFactions.get(i);
/* 779 */           if (matchFaction.missTurnTimes == 0) {
/* 780 */             missTurnTimes = matchFaction.missTurnTimes;
/* 781 */             index = i;
/* 782 */             break;
/*     */           }
/*     */           
/* 785 */           if (missTurnTimes < 0) {
/* 786 */             missTurnTimes = matchFaction.missTurnTimes;
/* 787 */             index = i;
/*     */ 
/*     */           }
/* 790 */           else if (matchFaction.missTurnTimes < missTurnTimes) {
/* 791 */             missTurnTimes = matchFaction.missTurnTimes;
/* 792 */             index = i;
/*     */           }
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 798 */         MatchFaction missTurnFaction = (MatchFaction)matchFactions.remove(index);
/* 799 */         leftFactions.add(missTurnFaction);
/*     */         
/* 801 */         if (logger.isDebugEnabled()) {
/* 802 */           logDebug("CrossCompeteManager.match@miss turn or next server level|faction=%s", new Object[] { missTurnFaction.toString() });
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 807 */       while (!matchFactions.isEmpty()) {
/* 808 */         MatchFaction faction = (MatchFaction)matchFactions.remove(0);
/*     */         
/* 810 */         int opponentIndex = getOpponentIndex(faction, matchFactions);
/*     */         
/*     */ 
/* 813 */         if (opponentIndex < 0) {
/* 814 */           logError("CrossCompeteManager.match@fatal error, cannot find opponent|faction=%s|other_factions=%s", new Object[] { faction, matchFactions });
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 819 */           MatchFaction opponentFaction = (MatchFaction)matchFactions.remove(opponentIndex);
/* 820 */           faction.setOpponentFactionid(opponentFaction.factionid);
/* 821 */           opponentFaction.setOpponentFactionid(faction.factionid);
/*     */           
/* 823 */           logInfo("CrossCompeteManager.match@success|faction1=%s|faction2=%s", new Object[] { faction.toString(), opponentFaction.toString() });
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\CrossCompeteManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */