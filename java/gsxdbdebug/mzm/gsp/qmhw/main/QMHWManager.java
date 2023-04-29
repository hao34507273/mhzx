/*     */ package mzm.gsp.qmhw.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qmhw.QMHWAwardInfo;
/*     */ import mzm.gsp.qmhw.QMHWInfo;
/*     */ import mzm.gsp.qmhw.SSynQMHWAwardInfoChange;
/*     */ import mzm.gsp.qmhw.SSynQMHWInfoChange;
/*     */ import mzm.gsp.qmhw.SSynRoleQMHWToTalInfo;
/*     */ import mzm.gsp.qmhw.SSynStageChange;
/*     */ import mzm.gsp.qmhw.confbean.SQMHWCfgConsts;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.QMHWActivity;
/*     */ import xbean.RoleQMHWScore;
/*     */ import xdb.Procedure;
/*     */ import xtable.Qmhw;
/*     */ import xtable.Role2qmhw;
/*     */ 
/*     */ class QMHWManager
/*     */ {
/*     */   static Logger logger;
/*     */   
/*     */   static void init()
/*     */   {
/*  41 */     logger = Logger.getLogger("qmhw");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isInPrepareStage()
/*     */   {
/*  50 */     return ActivityInterface.getActivityStage(SQMHWCfgConsts.getInstance().ACTIVITY_ID) == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isInMathStage()
/*     */   {
/*  59 */     return ActivityInterface.getActivityStage(SQMHWCfgConsts.getInstance().ACTIVITY_ID) == 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static RoleQMHWScore getXQMHWRoleCreateIfNotExist(long roleid)
/*     */   {
/*  69 */     RoleQMHWScore xRoleQMHWScore = Role2qmhw.get(Long.valueOf(roleid));
/*  70 */     if (xRoleQMHWScore == null) {
/*  71 */       xRoleQMHWScore = Pod.newRoleQMHWScore();
/*  72 */       xRoleQMHWScore.setScore(SQMHWCfgConsts.getInstance().INI_SCORE);
/*  73 */       Role2qmhw.insert(Long.valueOf(roleid), xRoleQMHWScore);
/*     */     }
/*  75 */     return xRoleQMHWScore;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static QMHWActivity getXQmhwCreateIfNotExist()
/*     */   {
/*  84 */     long localid = GameServerInfoManager.getLocalId();
/*  85 */     QMHWActivity xQmhwActivity = Qmhw.get(Long.valueOf(localid));
/*  86 */     if (xQmhwActivity == null) {
/*  87 */       xQmhwActivity = Pod.newQMHWActivity();
/*  88 */       Qmhw.insert(Long.valueOf(localid), xQmhwActivity);
/*     */     }
/*  90 */     return xQmhwActivity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static QMHWActivity getQmhwActivity(boolean isRetainLock)
/*     */   {
/* 100 */     long localid = GameServerInfoManager.getLocalId();
/* 101 */     if (isRetainLock) {
/* 102 */       return Qmhw.get(Long.valueOf(localid));
/*     */     }
/* 104 */     return Qmhw.select(Long.valueOf(localid));
/*     */   }
/*     */   
/*     */   static void brocastStage(QMHWActivity xQmhwActivity, int stage)
/*     */   {
/* 109 */     long worldid = xQmhwActivity.getWorldid();
/* 110 */     List<Long> roleids = MapInterface.getRoleList(worldid);
/* 111 */     SSynStageChange synStageChange = new SSynStageChange();
/* 112 */     synStageChange.stage = stage;
/* 113 */     OnlineManager.getInstance().sendMulti(synStageChange, roleids);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void commonAward(QMHWActivity xQmhwActivity)
/*     */   {
/* 122 */     long worldid = xQmhwActivity.getWorldid();
/* 123 */     List<Long> roleids = MapInterface.getRoleList(worldid);
/* 124 */     mzm.gsp.award.main.AwardInterface.awardToAllNoneRealTime(roleids, SQMHWCfgConsts.getInstance().COMMON_AWARD_ID, -1, false, true, new mzm.gsp.award.main.AwardReason(mzm.gsp.tlog.LogReason.JIU_XIAO_FIX_AWARD));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void matchFight()
/*     */   {
/* 133 */     QMHWActivity xQmhwActivity = Qmhw.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 134 */     if (xQmhwActivity == null) {
/* 135 */       GameServer.logger().info("[QMHW]QMHWManager.matchFight@data is null");
/* 136 */       return;
/*     */     }
/* 138 */     List<List<Long>> singleOrTeamRoles = MapInterface.getSingleRoleAndTeam(xQmhwActivity.getWorldid());
/* 139 */     Map<Integer, List<MatchObj>> matchObjMap = new HashMap();
/* 140 */     for (List<Long> roleids : singleOrTeamRoles) {
/* 141 */       int roleSize = roleids.size();
/* 142 */       if (roleSize <= 0) {
/* 143 */         GameServer.logger().error("[QMHW]QMHWManager.matchFight@MapInterface.getSingleRoleAndTeam rolelist size is zero");
/*     */       }
/*     */       else
/*     */       {
/* 147 */         int score = 0;
/* 148 */         int times = 0;
/* 149 */         boolean isInfight = false;
/* 150 */         boolean isNoNNormalState = false;
/* 151 */         for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */           
/* 153 */           if (FightInterface.isInFight(roleid)) {
/* 154 */             isInfight = true;
/* 155 */             break;
/*     */           }
/* 157 */           if (roleSize == 1) {
/* 158 */             List<Long> normalList = mzm.gsp.team.main.TeamInterface.getNormalRoleList(roleid);
/* 159 */             if ((normalList != null) && (normalList.size() > 0) && (!normalList.contains(Long.valueOf(roleid)))) {
/* 160 */               isNoNNormalState = true;
/* 161 */               break;
/*     */             }
/*     */           }
/*     */           
/* 165 */           RoleQMHWScore xRoleQMHWScore = Role2qmhw.select(Long.valueOf(roleid));
/* 166 */           if (xRoleQMHWScore != null) {
/* 167 */             score += xRoleQMHWScore.getScore();
/* 168 */             times += xRoleQMHWScore.getWincount() + xRoleQMHWScore.getLosecount();
/*     */           } else {
/* 170 */             score += SQMHWCfgConsts.getInstance().INI_SCORE;
/*     */           }
/*     */         }
/* 173 */         if ((!isInfight) && (!isNoNNormalState))
/*     */         {
/*     */ 
/* 176 */           MatchObj matchObj = new MatchObj(roleids, (int)Math.floor(score * 1.0D / roleSize), (int)Math.ceil(times * 1.0D / roleSize));
/*     */           
/*     */ 
/* 179 */           int interval = (matchObj.score - SQMHWCfgConsts.getInstance().INI_SCORE) / SQMHWCfgConsts.getInstance().MATCH_SCORE_INTERVAL;
/*     */           
/* 181 */           List<MatchObj> matchObjs = (List)matchObjMap.get(Integer.valueOf(interval));
/* 182 */           if (matchObjs == null) {
/* 183 */             matchObjs = new ArrayList();
/* 184 */             matchObjMap.put(Integer.valueOf(interval), matchObjs);
/*     */           }
/* 186 */           matchObjs.add(matchObj);
/*     */         } } }
/* 188 */     if (matchObjMap.size() <= 0) {
/* 189 */       if (GameServer.logger().isDebugEnabled()) {
/* 190 */         GameServer.logger().debug(String.format("[QMHW]QMHWManager.matchFight@there is no one to match", new Object[0]));
/*     */       }
/* 192 */       return;
/*     */     }
/*     */     
/*     */ 
/* 196 */     List<MatchObj> reMatchObjs = new ArrayList();
/* 197 */     boolean isSwitchOpen = isQMHWChange1Open();
/* 198 */     for (Map.Entry<Integer, List<MatchObj>> entry : matchObjMap.entrySet()) {
/* 199 */       List<MatchObj> matchObjs = (List)entry.getValue();
/* 200 */       Collections.sort(matchObjs);
/* 201 */       while (matchObjs.size() > 1) {
/* 202 */         MatchObj matchObj = (MatchObj)matchObjs.remove(0);
/*     */         
/* 204 */         boolean ret = innerMatch(matchObj, matchObjs);
/* 205 */         if ((!ret) && (isSwitchOpen)) {
/* 206 */           reMatchObjs.add(matchObj);
/*     */         }
/*     */       }
/* 209 */       if (isSwitchOpen) {
/* 210 */         reMatchObjs.addAll(matchObjs);
/*     */       }
/*     */     }
/*     */     
/* 214 */     if (isSwitchOpen) {
/* 215 */       Collections.sort(reMatchObjs);
/* 216 */       while (reMatchObjs.size() > 1) {
/* 217 */         MatchObj matchObj = (MatchObj)reMatchObjs.remove(0);
/* 218 */         boolean ret = innerReMatch(matchObj, reMatchObjs);
/* 219 */         if (!ret) {
/* 220 */           Procedure.execute(new PExtendMatchScore(matchObj));
/*     */         }
/*     */       }
/* 223 */       for (MatchObj matchObj : reMatchObjs) {
/* 224 */         Procedure.execute(new PExtendMatchScore(matchObj));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean innerReMatch(MatchObj matchObj, List<MatchObj> reMatchObjs) {
/* 230 */     long matchRoleLeaderid = ((Long)matchObj.getRoleids().get(0)).longValue();
/* 231 */     Set<Long> lastestMatchRoleids = getLastestMatchRoleid(matchRoleLeaderid);
/* 232 */     for (int i = 0; i < reMatchObjs.size(); i++) {
/* 233 */       MatchObj tempMatchObj = (MatchObj)reMatchObjs.get(i);
/* 234 */       long matchedRoleLeaderid = ((Long)tempMatchObj.getRoleids().get(0)).longValue();
/* 235 */       if ((!lastestMatchRoleids.contains(Long.valueOf(matchedRoleLeaderid))) && (!isLastestFightWithRole2(matchedRoleLeaderid, matchRoleLeaderid)))
/*     */       {
/*     */ 
/*     */ 
/* 239 */         int[] matchScoreScacle = calMatchScoreScacle(matchRoleLeaderid);
/* 240 */         int matchScore = getScore(matchRoleLeaderid);
/* 241 */         int[] matchedScoreScacle = calMatchScoreScacle(matchedRoleLeaderid);
/* 242 */         int matchedScore = getScore(matchedRoleLeaderid);
/* 243 */         if ((inScacle(matchScoreScacle, matchedScore)) || (inScacle(matchedScoreScacle, matchScore)))
/*     */         {
/*     */ 
/* 246 */           reMatchObjs.remove(i);
/* 247 */           FightInterface.startPVPFight(matchRoleLeaderid, matchedRoleLeaderid, new QMHWFightContext(), 11, FightReason.QMHW_MATCH_FIGHT);
/*     */           
/* 249 */           return true;
/*     */         } } }
/* 251 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean inScacle(int[] matchScoreScacle, int score) {
/* 255 */     int a = matchScoreScacle[0];
/* 256 */     int b = matchScoreScacle[1];
/* 257 */     if ((score >= a) && (score < b)) {
/* 258 */       return true;
/*     */     }
/* 260 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int[] calMatchScoreScacle(long matchRoleLeaderid)
/*     */   {
/* 270 */     int[] result = new int[2];
/* 271 */     Integer extendMatchScore = Role2qmhw.selectExtendmatchscore(Long.valueOf(matchRoleLeaderid));
/* 272 */     Integer matchScore = Role2qmhw.selectScore(Long.valueOf(matchRoleLeaderid));
/* 273 */     if (matchScore != null) {
/* 274 */       int interval = (matchScore.intValue() - SQMHWCfgConsts.getInstance().INI_SCORE) / SQMHWCfgConsts.getInstance().MATCH_SCORE_INTERVAL;
/*     */       
/* 276 */       result[0] = (SQMHWCfgConsts.getInstance().MATCH_SCORE_INTERVAL * interval + SQMHWCfgConsts.getInstance().INI_SCORE);
/*     */       
/* 278 */       result[1] = (result[0] + SQMHWCfgConsts.getInstance().MATCH_SCORE_INTERVAL);
/*     */     } else {
/* 280 */       result[0] = SQMHWCfgConsts.getInstance().INI_SCORE;
/* 281 */       result[1] = (result[0] + SQMHWCfgConsts.getInstance().MATCH_SCORE_INTERVAL);
/*     */     }
/* 283 */     if (extendMatchScore != null) {
/* 284 */       result[0] -= extendMatchScore.intValue();
/* 285 */       result[1] += extendMatchScore.intValue();
/*     */     }
/*     */     
/* 288 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isQMHWChange1Open()
/*     */   {
/* 297 */     return mzm.gsp.open.main.OpenInterface.getOpenStatus(281);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Set<Long> getLastestMatchRoleid(long roleid)
/*     */   {
/* 307 */     Set<Long> lastestMatchRoleids = Role2qmhw.selectLatestmatchroles(Long.valueOf(roleid));
/* 308 */     if (lastestMatchRoleids == null) {
/* 309 */       return Collections.emptySet();
/*     */     }
/* 311 */     return lastestMatchRoleids;
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
/*     */   private static boolean innerMatch(MatchObj matchObj, List<MatchObj> matchObjs)
/*     */   {
/* 324 */     long matchRoleLeaderid = ((Long)matchObj.getRoleids().get(0)).longValue();
/* 325 */     RoleQMHWScore xRoleQMHWScore = Role2qmhw.select(Long.valueOf(matchRoleLeaderid));
/* 326 */     if (xRoleQMHWScore == null) {
/* 327 */       doMatchFight(matchObj, matchObjs, (MatchObj)matchObjs.get(0), 0);
/* 328 */       return true;
/*     */     }
/*     */     
/* 331 */     Set<Long> lastMatchRoleids = xRoleQMHWScore.getLatestmatchroles();
/*     */     
/* 333 */     MatchObj matchedObj = null;
/* 334 */     int matchedObjIndex = -1;
/* 335 */     int matchedCount = 0;
/* 336 */     for (int i = 0; i < matchObjs.size(); i++) {
/* 337 */       MatchObj tempMatchObj = (MatchObj)matchObjs.get(i);
/* 338 */       long tempMatchObjLeaderid = ((Long)tempMatchObj.getRoleids().get(0)).longValue();
/* 339 */       if ((!isQMHWChange1Open()) || (
/* 340 */         (!lastMatchRoleids.contains(Long.valueOf(tempMatchObjLeaderid))) && (!isLastestFightWithRole2(tempMatchObjLeaderid, matchRoleLeaderid))))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 345 */         if (matchedObj == null) {
/* 346 */           matchedObjIndex = i;
/* 347 */           matchedObj = tempMatchObj;
/* 348 */           Integer tempCount = (Integer)xRoleQMHWScore.getMatchroles().get(Long.valueOf(tempMatchObjLeaderid));
/* 349 */           if (tempCount == null) {
/* 350 */             tempCount = Integer.valueOf(0);
/*     */           }
/* 352 */           matchedCount = tempCount.intValue();
/*     */         } else {
/* 354 */           if (tempMatchObj.compareTo(matchedObj) != 0) break;
/* 355 */           Integer tempCount = (Integer)xRoleQMHWScore.getMatchroles().get(Long.valueOf(tempMatchObjLeaderid));
/* 356 */           if ((tempCount != null) && 
/* 357 */             (tempCount.intValue() < matchedCount)) {
/* 358 */             matchedCount = tempCount.intValue();
/* 359 */             matchedObjIndex = i;
/* 360 */             matchedObj = tempMatchObj;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 367 */     if (matchedObj == null) {
/* 368 */       return false;
/*     */     }
/* 370 */     doMatchFight(matchObj, matchObjs, matchedObj, matchedObjIndex);
/* 371 */     return true;
/*     */   }
/*     */   
/*     */   private static void doMatchFight(MatchObj matchObj, List<MatchObj> matchObjs, MatchObj matchedObj, int matchedObjIndex)
/*     */   {
/* 376 */     matchObjs.remove(matchedObjIndex);
/* 377 */     FightInterface.startPVPFight(((Long)matchObj.getRoleids().get(0)).longValue(), ((Long)matchedObj.getRoleids().get(0)).longValue(), new QMHWFightContext(), 11, FightReason.QMHW_MATCH_FIGHT);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean isLastestFightWithRole2(long roleid1, long roleid2)
/*     */   {
/* 389 */     Set<Long> lastestMatchRoleids = Role2qmhw.selectLatestmatchroles(Long.valueOf(roleid1));
/* 390 */     if (lastestMatchRoleids == null) {
/* 391 */       return false;
/*     */     }
/* 393 */     return lastestMatchRoleids.contains(Long.valueOf(roleid2));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getScore(long roleid)
/*     */   {
/* 404 */     RoleQMHWScore xQmhwScore = Role2qmhw.select(Long.valueOf(roleid));
/* 405 */     if (xQmhwScore != null) {
/* 406 */       return xQmhwScore.getScore();
/*     */     }
/* 408 */     return SQMHWCfgConsts.getInstance().INI_SCORE;
/*     */   }
/*     */   
/*     */   static void sendQMHWAwardInfo(long roleid, RoleQMHWScore xQmhwScore) {
/* 412 */     SSynQMHWAwardInfoChange synQMHWAwardInfoChange = new SSynQMHWAwardInfoChange();
/* 413 */     fillInAwardInfo(synQMHWAwardInfoChange.qmhwawardinfo, xQmhwScore);
/* 414 */     OnlineManager.getInstance().send(roleid, synQMHWAwardInfoChange);
/*     */   }
/*     */   
/*     */   static void fillInAwardInfo(QMHWAwardInfo qmhwawardinfo, RoleQMHWScore xQmhwScore) {
/* 418 */     qmhwawardinfo.joinawards.addAll(xQmhwScore.getGetjoinawards());
/* 419 */     qmhwawardinfo.winawards.addAll(xQmhwScore.getGetawards());
/*     */   }
/*     */   
/*     */   static void sendQMHWRoleInfo(long roleid, RoleQMHWScore xQmhwScore) {
/* 423 */     SSynQMHWInfoChange synQMHWInfoChange = new SSynQMHWInfoChange();
/* 424 */     fillQMHWRoleInfo(synQMHWInfoChange.qmhwinfo, xQmhwScore);
/* 425 */     OnlineManager.getInstance().send(roleid, synQMHWInfoChange);
/*     */   }
/*     */   
/*     */   static void fillQMHWRoleInfo(QMHWInfo qmhwinfo, RoleQMHWScore xQmhwScore) {
/* 429 */     qmhwinfo.continuewincount = xQmhwScore.getContinuewincount();
/* 430 */     qmhwinfo.losecount = xQmhwScore.getLosecount();
/* 431 */     qmhwinfo.score = xQmhwScore.getScore();
/* 432 */     qmhwinfo.wincount = xQmhwScore.getWincount();
/*     */   }
/*     */   
/*     */   static void sendRoleQMHWTotalInfo(long roleid, RoleQMHWScore xRoleQMHWScore) {
/* 436 */     SSynRoleQMHWToTalInfo synRoleQMHWToTalInfo = new SSynRoleQMHWToTalInfo();
/* 437 */     fillInAwardInfo(synRoleQMHWToTalInfo.awardinfo, xRoleQMHWScore);
/* 438 */     fillQMHWRoleInfo(synRoleQMHWToTalInfo.qmhwinfo, xRoleQMHWScore);
/* 439 */     OnlineManager.getInstance().send(roleid, synRoleQMHWToTalInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean checkInCross(long roleid)
/*     */   {
/* 449 */     if (RoleStatusInterface.containsStatus(roleid, 41)) {
/* 450 */       return true;
/*     */     }
/* 452 */     if (RoleStatusInterface.containsStatus(roleid, 44)) {
/* 453 */       return true;
/*     */     }
/* 455 */     return false;
/*     */   }
/*     */   
/*     */   static void logWarn(String formatStr, Object... args) {
/* 459 */     logger.warn(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   static void logError(String formatStr, Object... args) {
/* 463 */     logger.error(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   static void logInfo(String formatStr, Object... args) {
/* 467 */     logger.info(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   static void logDebug(String formatStr, Object... args) {
/* 471 */     logger.debug(String.format(formatStr, args));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\QMHWManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */