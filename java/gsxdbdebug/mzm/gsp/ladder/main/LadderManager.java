/*      */ package mzm.gsp.ladder.main;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import hub.DataTransferReq;
/*      */ import hub.ExchangeDataHandlerInfo;
/*      */ import hub.FightResult;
/*      */ import hub.GHubHelper;
/*      */ import hub.LadderDataBackReq;
/*      */ import hub.LadderUserDataBack;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.NavigableMap;
/*      */ import java.util.Set;
/*      */ import java.util.TreeMap;
/*      */ import java.util.concurrent.atomic.AtomicInteger;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.activity.main.ActivityInterface;
/*      */ import mzm.gsp.award.main.AwardInterface;
/*      */ import mzm.gsp.award.main.AwardModel;
/*      */ import mzm.gsp.award.main.AwardReason;
/*      */ import mzm.gsp.changemodelcard.main.ChangeModelCardInterface;
/*      */ import mzm.gsp.children.main.ChildrenInterface;
/*      */ import mzm.gsp.children.main.ChildrenOutFightObj;
/*      */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*      */ import mzm.gsp.crossserver.main.MatchActivityContext;
/*      */ import mzm.gsp.crossserver.main.ReturnFromRoamServerHandlerManager;
/*      */ import mzm.gsp.crossserver.main.RoleMatchMarkingInfo;
/*      */ import mzm.gsp.ladder.CrossMatchProcessInfo;
/*      */ import mzm.gsp.ladder.RemoveLadderRankInfoContext;
/*      */ import mzm.gsp.ladder.ReportLadderRankInfoContext;
/*      */ import mzm.gsp.ladder.RoleLadderInfo;
/*      */ import mzm.gsp.ladder.SLadderCancelReadyRes;
/*      */ import mzm.gsp.ladder.SLadderCrossMatchFailRes;
/*      */ import mzm.gsp.ladder.SLadderUnMatchRes;
/*      */ import mzm.gsp.ladder.SUpdateCrossMatchProcessInfo;
/*      */ import mzm.gsp.ladder.confbean.SLadderConsts;
/*      */ import mzm.gsp.ladder.confbean.SLadderCountAwardCfg;
/*      */ import mzm.gsp.ladder.confbean.SLadderGradeCfg;
/*      */ import mzm.gsp.ladder.confbean.SLadderGradeInfo;
/*      */ import mzm.gsp.ladder.confbean.SLadderKCfg;
/*      */ import mzm.gsp.ladder.confbean.SLadderLevelStageCfg;
/*      */ import mzm.gsp.ladder.confbean.SLadderSeasonCfg;
/*      */ import mzm.gsp.ladder.confbean.SLadderWeekSeasonAwardCfg;
/*      */ import mzm.gsp.ladder.event.RoleAttendLadder;
/*      */ import mzm.gsp.ladder.event.RoleAttendLadderArg;
/*      */ import mzm.gsp.mail.main.MailAttachment;
/*      */ import mzm.gsp.mall.main.MallInterface;
/*      */ import mzm.gsp.online.main.LoginManager;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.pet.main.Pet;
/*      */ import mzm.gsp.pet.main.PetInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.role.main.RoleOneByOneManager;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.LogicProcedure;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.FightAwardTip;
/*      */ import xbean.FightCountAwardTip;
/*      */ import xbean.Ladder;
/*      */ import xbean.Pod;
/*      */ import xtable.Role2ladder;
/*      */ import xtable.Role2ladderfightawardtip;
/*      */ import xtable.Role2ladderfightcountawardtip;
/*      */ import xtable.Role2matchcontextid;
/*      */ 
/*      */ class LadderManager
/*      */ {
/*   80 */   static volatile boolean postInitFlag = false;
/*      */   static final int TEN_THOUSAND = 10000;
/*   82 */   static int GRC_MAX_TRY_TIMES = 3;
/*   83 */   static int GRC_MIN_DELAY_IN_SECOND = 300;
/*   84 */   static int GRC_MAX_DELAY_IN_SECOND = 600;
/*      */   
/*   86 */   private static final AtomicInteger idGenerator = new AtomicInteger(0);
/*      */   
/*      */   private static final int minStage = 1;
/*      */   
/*   90 */   static int sessionEndDelayReportSec = 120;
/*      */   static final int MATCH_STATUS_SUC = 0;
/*      */   
/*      */   static void postInit() {
/*   94 */     postInitFlag = true;
/*      */   }
/*      */   
/*      */   static int getNextId() {
/*   98 */     return idGenerator.addAndGet(1);
/*      */   }
/*      */   
/*      */   static int getLevelStage(int level) {
/*  102 */     NavigableMap<Integer, SLadderLevelStageCfg> ladderStageMap = (NavigableMap)SLadderLevelStageCfg.getAll();
/*      */     
/*  104 */     NavigableMap<Integer, SLadderLevelStageCfg> headLadderStageMap = ladderStageMap.headMap(Integer.valueOf(level), true);
/*  105 */     if (headLadderStageMap.isEmpty()) {
/*  106 */       return 0;
/*      */     }
/*  108 */     return ((SLadderLevelStageCfg)headLadderStageMap.lastEntry().getValue()).level;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isInCancelMatch(List<Long> roleids)
/*      */   {
/*  118 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  119 */       Long contextid = Role2matchcontextid.get(Long.valueOf(roleid));
/*  120 */       if (contextid != null) {
/*  121 */         MatchActivityContext matchActivityContext = CrossServerInterface.getMatchActivityContext(contextid.longValue());
/*  122 */         if (matchActivityContext != null) {
/*  123 */           if ((matchActivityContext instanceof LadderMatchContext)) {
/*  124 */             LadderMatchContext ladderMatchContext = (LadderMatchContext)matchActivityContext;
/*  125 */             if (ladderMatchContext.getCancelMatchContext() != null) {
/*  126 */               return true;
/*      */             }
/*      */           } else {
/*  129 */             GameServer.logger().error(String.format("[Ladder]LadderManager.isInCancelMatch@matchActivityContext is not LadderContext|roleid=%d|contextid=%d", new Object[] { Long.valueOf(roleid), contextid }));
/*      */           }
/*      */           
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/*  136 */           GameServer.logger().error(String.format("[Ladder]LadderManager.isInCancelMatch@do not exist matchActivityContext|roleid=%d|contextid=%d", new Object[] { Long.valueOf(roleid), contextid }));
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  144 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void removeCancelMatchId(List<Long> roleids)
/*      */   {
/*  154 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  155 */       Role2matchcontextid.remove(Long.valueOf(roleid));
/*      */     }
/*      */   }
/*      */   
/*      */   static boolean tryDoUnMatch(Map<Long, String> role2UserMap, List<Long> roleids, CancelMatchContext cancelMatchContext)
/*      */   {
/*  161 */     Long contextid = null;
/*  162 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  163 */       contextid = Role2matchcontextid.get(Long.valueOf(roleid));
/*  164 */       if (contextid != null) {
/*  165 */         MatchActivityContext matchActivityContext = CrossServerInterface.getMatchActivityContext(contextid.longValue());
/*  166 */         if ((matchActivityContext instanceof LadderMatchContext)) {
/*  167 */           boolean ret = CrossServerInterface.cancelMatch(contextid.longValue());
/*  168 */           if (ret) {
/*  169 */             ((LadderMatchContext)matchActivityContext).setCancelMatchContext(cancelMatchContext);
/*  170 */             return true;
/*      */           }
/*  172 */           GameServer.logger().error(String.format("[Ladder]LadderManager.tryDoUnMatch@cancelMatch return false|roleid=%d|contextid=%d", new Object[] { Long.valueOf(roleid), contextid }));
/*      */ 
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/*      */ 
/*  179 */           GameServer.logger().error(String.format("[Ladder]LadderManager.tryDoUnMatch@match context is not LadderMatchContext|roleid=%d|contextid=%d", new Object[] { Long.valueOf(roleid), contextid }));
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  187 */     return false;
/*      */   }
/*      */   
/*      */   static boolean doUnMatch(Map<Long, String> role2UserMap, List<Long> roleids, long unMatchRoleid, boolean sendAll) {
/*  191 */     RoleStatusInterface.unsetStatus(roleids, 42);
/*  192 */     RoleStatusInterface.unsetStatus(roleids, 40);
/*  193 */     if (sendAll) {
/*  194 */       SLadderUnMatchRes ladderUnMatchRes = new SLadderUnMatchRes();
/*  195 */       ladderUnMatchRes.roleid = unMatchRoleid;
/*  196 */       OnlineManager.getInstance().sendMulti(ladderUnMatchRes, role2UserMap.keySet());
/*      */     }
/*  198 */     return true;
/*      */   }
/*      */   
/*      */   static boolean doUnMatch(Map<Long, String> role2UserMap, List<Long> roleids) {
/*  202 */     return doUnMatch(role2UserMap, roleids, 0L, true);
/*      */   }
/*      */   
/*      */   static void doCancelReady(long roleid) {
/*  206 */     RoleStatusInterface.unsetStatus(roleid, 43);
/*      */   }
/*      */   
/*      */   static void doCancelReady(long roleid, List<Long> notifyRoleids) {
/*  210 */     doCancelReady(roleid);
/*  211 */     SLadderCancelReadyRes ladderCancelReadyRes = new SLadderCancelReadyRes();
/*  212 */     ladderCancelReadyRes.roleid = roleid;
/*  213 */     OnlineManager.getInstance().sendMulti(ladderCancelReadyRes, notifyRoleids);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean onMatchFightEnd(LadderMatchEndContext matchEndContext)
/*      */   {
/*  223 */     ActivityInterface.canJoinAndCheckInitActivityData(matchEndContext.getRole2UserMap(), matchEndContext.getAllRoleList(), SLadderConsts.getInstance().activityid);
/*      */     
/*  225 */     long endTime = matchEndContext.fightResult.starttime + matchEndContext.fightResult.intervalmilltime;
/*      */     
/*  227 */     Long beforeSeasonTime = getBeforeSessionTimeMilSec(DateTimeUtils.getCurrTimeInMillis());
/*      */     
/*  229 */     for (LadderMatchEndContext.LadderMatchEnd ladderMatchEnd : matchEndContext.matchEndList) {
/*  230 */       if (ladderMatchEnd.exchangeDataHandlerInfo != null)
/*      */       {
/*  232 */         ReturnFromRoamServerHandlerManager.unboxData(ladderMatchEnd.userid, ladderMatchEnd.roleid, ladderMatchEnd.exchangeDataHandlerInfo);
/*      */       }
/*      */       
/*  235 */       Ladder xLadder = getAndCreateXLadder(ladderMatchEnd.roleid);
/*  236 */       Octets tokenOctets = LoginManager.getLocalToken(ladderMatchEnd.userid);
/*  237 */       if (tokenOctets == null) {
/*  238 */         GameServer.logger().error(String.format("[Ladder]LadderManager.onMatchFightEnd@local token is null|roleid=%d|userid=%s|des=%s", new Object[] { Long.valueOf(ladderMatchEnd.roleid), ladderMatchEnd.userid, ladderMatchEnd.toString() }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       }
/*  244 */       else if (ladderMatchEnd.token == null) {
/*  245 */         GameServer.logger().error(String.format("[Ladder]LadderManager.onMatchFightEnd@remote token is null|roleid=%d|userid=%s|des=%s", new Object[] { Long.valueOf(ladderMatchEnd.roleid), ladderMatchEnd.userid, ladderMatchEnd.toString() }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       }
/*  252 */       else if (!tokenOctets.equals(ladderMatchEnd.token)) {
/*  253 */         GameServer.logger().error(String.format("[Ladder]LadderManager.onMatchFightEnd@token not equial|roleid=%d|userid=%s|des=%s|localToken=%s", new Object[] { Long.valueOf(ladderMatchEnd.roleid), ladderMatchEnd.userid, ladderMatchEnd.toString(), tokenOctets.getString("UTF-8") }));
/*      */ 
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*      */ 
/*      */ 
/*  261 */         if (ladderMatchEnd.changeMatchScore >= 0) {
/*  262 */           xLadder.setScore(xLadder.getScore() + ladderMatchEnd.changeMatchScore);
/*  263 */           calAndSetHonor(ladderMatchEnd.roleid, xLadder);
/*      */         } else {
/*  265 */           int minScore = getMinScore(RoleInterface.getLevel(ladderMatchEnd.roleid));
/*  266 */           int score = getScore(ladderMatchEnd.roleid, xLadder);
/*  267 */           int retScore = score + ladderMatchEnd.changeMatchScore;
/*  268 */           if (retScore >= minScore) {
/*  269 */             xLadder.setScore(xLadder.getScore() + ladderMatchEnd.changeMatchScore);
/*      */           }
/*  271 */           else if (score >= minScore) {
/*  272 */             xLadder.setScore(0);
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*  277 */           calAndSetHonor(ladderMatchEnd.roleid, xLadder);
/*      */         }
/*  279 */         boolean isWin = matchEndContext.isWin();
/*  280 */         if (isWin) {
/*  281 */           xLadder.setWincount(xLadder.getWincount() + 1);
/*      */         } else {
/*  283 */           xLadder.setLosecount(xLadder.getLosecount() + 1);
/*      */         }
/*  285 */         xLadder.setWeekfightcount(xLadder.getWeekfightcount() + 1);
/*      */         
/*  287 */         int weekFightCount = xLadder.getWeekfightcount();
/*  288 */         SLadderWeekSeasonAwardCfg ladderWeekSeasonAwardCfg = SLadderWeekSeasonAwardCfg.get(weekFightCount);
/*  289 */         if (ladderWeekSeasonAwardCfg != null) {
/*  290 */           AwardModel awardModel = null;
/*  291 */           if (ladderWeekSeasonAwardCfg.fightFixAwardid > 0) {
/*  292 */             awardModel = AwardInterface.getRoleFixAwardModel(ladderWeekSeasonAwardCfg.fightFixAwardid, ladderMatchEnd.roleid, new AwardReason(LogReason.LADDER_MATCH_WEEK_FIGHT_COUNT, ladderWeekSeasonAwardCfg.fightFixAwardid));
/*      */             
/*      */ 
/*  295 */             if (awardModel == null) {
/*  296 */               GameServer.logger().info(String.format("[Ladder]LadderManager.onMatchFightEnd@awardModel null|roleid=%d|fightcount=%d", new Object[] { Long.valueOf(ladderMatchEnd.roleid), Integer.valueOf(weekFightCount) }));
/*      */             }
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  304 */           MailAttachment mailAttachment = null;
/*  305 */           if (awardModel != null) {
/*  306 */             mailAttachment = AwardInterface.getMailAttachmentBy(awardModel);
/*      */           } else {
/*  308 */             mailAttachment = new MailAttachment();
/*      */           }
/*  310 */           List<String> titleStrings = null;
/*  311 */           List<String> contentStrings = new ArrayList();
/*  312 */           contentStrings.add(String.valueOf(weekFightCount));
/*  313 */           mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(ladderMatchEnd.roleid, ladderWeekSeasonAwardCfg.mailCfgid, titleStrings, contentStrings, mailAttachment, new TLogArg(LogReason.LADDER_MATCH_WEEK_FIGHT_COUNT, ladderWeekSeasonAwardCfg.fightFixAwardid));
/*      */         }
/*      */         else
/*      */         {
/*  317 */           GameServer.logger().info(String.format("[Ladder]LadderManager.onMatchFightEnd@do not has ladder week season award data|fightCount=%d", new Object[] { Integer.valueOf(weekFightCount) }));
/*      */         }
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  325 */         long getFightScore = ladderMatchEnd.ladderScore;
/*  326 */         if (getFightScore < 0L) {
/*  327 */           GameServer.logger().info(String.format("[Ladder]LadderManager.onMatchFightEnd@get fight score less than zero|roleid=%d|getFightScore=%d", new Object[] { Long.valueOf(ladderMatchEnd.roleid), Long.valueOf(getFightScore) }));
/*      */           
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  333 */           xLadder.setWeekgotfightscore(xLadder.getWeekgotfightscore() + getFightScore);
/*  334 */           MallInterface.cutJifen(ladderMatchEnd.roleid, -getFightScore, 5, new TLogArg(LogReason.LADDER_MATCH_FIGHT_GET_FIGHT_SCORE));
/*      */         }
/*  336 */         else if (getFightScore > 0L) {
/*  337 */           long canAddFightScore = SLadderConsts.getInstance().weekFightScoreLimit - xLadder.getWeekgotfightscore();
/*      */           
/*  339 */           if (canAddFightScore > 0L) {
/*  340 */             canAddFightScore = Math.min(canAddFightScore, getFightScore);
/*  341 */             xLadder.setWeekgotfightscore(xLadder.getWeekgotfightscore() + canAddFightScore);
/*  342 */             MallInterface.addJifen(ladderMatchEnd.roleid, canAddFightScore, 5, true, new TLogArg(LogReason.LADDER_MATCH_FIGHT_GET_FIGHT_SCORE));
/*      */           }
/*      */         }
/*  345 */         else if (getFightScore == 0L) {
/*  346 */           GameServer.logger().info(String.format("[Ladder]LadderManager.onMatchFightEnd@get ladder fightScore is zero|fightScore=%d", new Object[] { Long.valueOf(getFightScore) }));
/*      */         }
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  353 */         AwardModel fightAwardModel = AwardInterface.award(SLadderConsts.getInstance().fightAwardid, ladderMatchEnd.userid, ladderMatchEnd.roleid, false, true, new AwardReason(LogReason.LADDER_MATCH_FIGHT_END));
/*      */         
/*      */ 
/*  356 */         if (fightAwardModel != null) {
/*  357 */           FightAwardTip xFightAwardTip = Role2ladderfightawardtip.get(Long.valueOf(ladderMatchEnd.roleid));
/*  358 */           if (xFightAwardTip == null) {
/*  359 */             xFightAwardTip = Pod.newFightAwardTip();
/*  360 */             Role2ladderfightawardtip.add(Long.valueOf(ladderMatchEnd.roleid), xFightAwardTip);
/*      */           }
/*  362 */           xFightAwardTip.setFightawardtip(fightAwardModel);
/*      */         }
/*      */         
/*  365 */         if (matchEndContext.isWin()) {
/*  366 */           int count = ActivityInterface.getActivityCount(ladderMatchEnd.userid, ladderMatchEnd.roleid, SLadderConsts.getInstance().activityid, true);
/*      */           
/*  368 */           ActivityInterface.addActivityCount(ladderMatchEnd.userid, ladderMatchEnd.roleid, SLadderConsts.getInstance().activityid);
/*      */           
/*  370 */           count++;
/*  371 */           SLadderCountAwardCfg ladderCountAwardCfg = SLadderCountAwardCfg.get(count);
/*  372 */           if (ladderCountAwardCfg != null) {
/*  373 */             AwardModel fightCountModel = AwardInterface.award(ladderCountAwardCfg.awardid, ladderMatchEnd.userid, ladderMatchEnd.roleid, false, true, new AwardReason(LogReason.LADDER_MATCH_DAY_FIGHT_WIN_COUNT));
/*      */             
/*      */ 
/*  376 */             if (fightCountModel != null) {
/*  377 */               FightCountAwardTip xFightCountAwardTip = Role2ladderfightcountawardtip.get(Long.valueOf(ladderMatchEnd.roleid));
/*      */               
/*  379 */               if (xFightCountAwardTip == null) {
/*  380 */                 xFightCountAwardTip = Pod.newFightCountAwardTip();
/*  381 */                 Role2ladderfightcountawardtip.add(Long.valueOf(ladderMatchEnd.roleid), xFightCountAwardTip);
/*      */               }
/*  383 */               xFightCountAwardTip.setFightcountawardtip(fightCountModel);
/*      */             }
/*      */           }
/*      */         }
/*      */         
/*  388 */         LoginManager.getInstance().onRoleCrossEnd(ladderMatchEnd.userid, ladderMatchEnd.roleid);
/*  389 */         int score = getScore(ladderMatchEnd.roleid, xLadder);
/*  390 */         if (beforeSeasonTime != null)
/*      */         {
/*  392 */           LadderRankManager.getInstance().rank(ladderMatchEnd.roleid, beforeSeasonTime.longValue());
/*      */         }
/*      */         
/*      */ 
/*  396 */         ChangeModelCardInterface.consumePVPFightCount(ladderMatchEnd.roleid, 1);
/*      */         
/*      */ 
/*  399 */         if (ladderMatchEnd.childrenLostChaMap != null) {
/*  400 */           for (Map.Entry<Long, Integer> childrenLostChaEntry : ladderMatchEnd.childrenLostChaMap.entrySet()) {
/*  401 */             long childid = ((Long)childrenLostChaEntry.getKey()).longValue();
/*  402 */             int cutCharater = ((Integer)childrenLostChaEntry.getValue()).intValue();
/*  403 */             xdb.Procedure.execute(new PCutChildCharater(ladderMatchEnd.roleid, childid, cutCharater));
/*      */           }
/*      */         }
/*      */         
/*  407 */         int fightResult = isWin ? 0 : 1;
/*  408 */         int cutSign = ladderMatchEnd.changeMatchScore > 0 ? 0 : 1;
/*  409 */         List<Integer> petPowers = new ArrayList();
/*  410 */         for (Iterator i$ = ladderMatchEnd.petids.iterator(); i$.hasNext();) { long petid = ((Long)i$.next()).longValue();
/*  411 */           Pet pet = PetInterface.getPetById(ladderMatchEnd.roleid, petid);
/*  412 */           if (pet != null) {
/*  413 */             petPowers.add(Integer.valueOf(pet.getPetYaoli()));
/*      */           }
/*      */         }
/*      */         
/*  417 */         triggerRoleRoleAttendLadderEvent(ladderMatchEnd.roleid, isWin);
/*  418 */         logMatchFightEnd(endTime, ladderMatchEnd.userid, ladderMatchEnd.roleid, matchEndContext.fightResult.contextid, matchEndContext.fightResult.fightid, matchEndContext.fightResult.intervalmilltime, matchEndContext.fightResult.rounds, fightResult, score - ladderMatchEnd.changeMatchScore, score, cutSign, RoleInterface.getFightValue(ladderMatchEnd.roleid), petPowers);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  424 */     return true;
/*      */   }
/*      */   
/*      */   private static void triggerRoleRoleAttendLadderEvent(long roleid, boolean isWin)
/*      */   {
/*  429 */     TriggerEventsManger.getInstance().triggerEvent(new RoleAttendLadder(), new RoleAttendLadderArg(roleid, isWin), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleid)));
/*      */   }
/*      */   
/*      */   static class PCutChildCharater extends LogicProcedure
/*      */   {
/*      */     private final long roleid;
/*      */     private final long childid;
/*      */     private final int cutCharater;
/*      */     
/*      */     public PCutChildCharater(long roleid, long childid, int cutCharater)
/*      */     {
/*  440 */       this.roleid = roleid;
/*  441 */       this.childid = childid;
/*  442 */       this.cutCharater = cutCharater;
/*      */     }
/*      */     
/*      */     protected boolean processImp() throws Exception
/*      */     {
/*  447 */       lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*  448 */       ChildrenOutFightObj childrenOutFightObj = ChildrenInterface.getChildrenOutFightObj(this.roleid, this.childid);
/*  449 */       if (childrenOutFightObj != null) {
/*  450 */         childrenOutFightObj.addCharater(-this.cutCharater, 1);
/*  451 */         return true;
/*      */       }
/*  453 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static void calAndSetHonor(long roleid, Ladder xLadder)
/*      */   {
/*  460 */     boolean needDoAgain = true;
/*  461 */     for (int i = 0; i < 100; i++) {
/*  462 */       if (!needDoAgain) break;
/*  463 */       needDoAgain = _calAndSetHonor(roleid, xLadder);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean _calAndSetHonor(long roleid, Ladder xLadder)
/*      */   {
/*  472 */     int level = RoleInterface.getLevel(roleid);
/*  473 */     int nowScore = getScore(roleid, xLadder);
/*  474 */     int nowStage = xLadder.getStage();
/*  475 */     SLadderGradeInfo preGradeInfo = getGradeInfo(level, nowStage - 1);
/*  476 */     if ((preGradeInfo != null) && 
/*  477 */       (preGradeInfo.levelDownScoreMin > nowScore))
/*      */     {
/*  479 */       xLadder.setStage(nowStage - 1);
/*  480 */       return true;
/*      */     }
/*      */     
/*  483 */     SLadderGradeInfo nextGradeInfo = getGradeInfo(level, nowStage + 1);
/*  484 */     if ((nextGradeInfo != null) && 
/*  485 */       (nextGradeInfo.levelUpScoreMin <= nowScore)) {
/*  486 */       xLadder.setStage(nowStage + 1);
/*  487 */       return true;
/*      */     }
/*      */     
/*  490 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void fillRoleLadderInfo(RoleLadderInfo roleLadderInfo, long roleid)
/*      */   {
/*  500 */     Ladder xLadder = getAndInitXLadder(roleid, false);
/*  501 */     fillRoleLadderInfo(roleLadderInfo, roleid, xLadder);
/*      */   }
/*      */   
/*      */   static void fillRoleLadderInfo(RoleLadderInfo roleLadderInfo, long roleid, Ladder xLadder) {
/*  505 */     roleLadderInfo.roleid = roleid;
/*  506 */     if (xLadder != null) {
/*  507 */       roleLadderInfo.losecount = xLadder.getLosecount();
/*  508 */       roleLadderInfo.wincount = xLadder.getWincount();
/*  509 */       roleLadderInfo.score = getScore(roleid, xLadder);
/*  510 */       roleLadderInfo.stage = xLadder.getStage();
/*      */     }
/*      */   }
/*      */   
/*      */   static int getScore(long roleid, Ladder xLadder) {
/*  515 */     int level = RoleInterface.getLevel(roleid);
/*  516 */     if (xLadder == null) {
/*  517 */       return levelScore(level);
/*      */     }
/*  519 */     return xLadder.getScore() + levelScore(level);
/*      */   }
/*      */   
/*      */   static int levelScore(int level) {
/*  523 */     NavigableMap<Integer, SLadderLevelStageCfg> ladderStageMap = (NavigableMap)SLadderLevelStageCfg.getAll();
/*      */     
/*  525 */     NavigableMap<Integer, SLadderLevelStageCfg> headLadderStageMap = ladderStageMap.headMap(Integer.valueOf(level), true);
/*  526 */     if (headLadderStageMap.isEmpty()) {
/*  527 */       return 0;
/*      */     }
/*  529 */     return ((SLadderLevelStageCfg)headLadderStageMap.lastEntry().getValue()).initScore;
/*      */   }
/*      */   
/*      */   static int getMinScore(int level) {
/*  533 */     NavigableMap<Integer, SLadderLevelStageCfg> ladderStageMap = (NavigableMap)SLadderLevelStageCfg.getAll();
/*      */     
/*  535 */     NavigableMap<Integer, SLadderLevelStageCfg> headLadderStageMap = ladderStageMap.headMap(Integer.valueOf(level), true);
/*  536 */     if (headLadderStageMap.isEmpty()) {
/*  537 */       return 0;
/*      */     }
/*  539 */     return ((SLadderLevelStageCfg)headLadderStageMap.lastEntry().getValue()).initScore;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Ladder getAndCreateXLadder(long roleid)
/*      */   {
/*  549 */     Ladder xLadder = Role2ladder.get(Long.valueOf(roleid));
/*  550 */     if (xLadder == null) {
/*  551 */       xLadder = Pod.newLadder();
/*  552 */       Role2ladder.insert(Long.valueOf(roleid), xLadder);
/*  553 */       calAndSetHonor(roleid, xLadder);
/*  554 */       int stage = xLadder.getStage();
/*  555 */       if (getGradeInfo(RoleInterface.getLevel(roleid), stage) == null) {
/*  556 */         xLadder.setStage(1);
/*      */       }
/*  558 */       long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  559 */       xLadder.setInittime(curTime);
/*  560 */       xLadder.setWeekinittime(curTime);
/*  561 */       Long beforeSeasonTime = getBeforeSessionTimeMilSec(curTime);
/*  562 */       if (beforeSeasonTime != null) {
/*  563 */         int score = getScore(roleid, xLadder);
/*  564 */         if (score > 0) {
/*  565 */           LadderRankManager.getInstance().rank(roleid, beforeSeasonTime.longValue());
/*      */         }
/*      */       }
/*      */     } else {
/*  569 */       initXLadder(roleid, xLadder);
/*      */     }
/*  571 */     return xLadder;
/*      */   }
/*      */   
/*      */   private static void initXLadder(long roleid, Ladder xLadder) {
/*  575 */     int beforeScore = getScore(roleid, xLadder);
/*  576 */     int beforeStage = xLadder.getStage();
/*  577 */     NavigableMap<Integer, SLadderSeasonCfg> navigableMap = (NavigableMap)SLadderSeasonCfg.getAll();
/*      */     
/*  579 */     long initTime = xLadder.getInittime();
/*  580 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  581 */     int level = RoleInterface.getLevel(roleid);
/*      */     
/*  583 */     Long beforeSeasonTime = getBeforeSessionTimeMilSec(curTime);
/*  584 */     if (beforeSeasonTime == null) {
/*  585 */       GameServer.logger().info(String.format("[Ladder]LadderManager.initXLadder@do not has before season data!|curTime=%d", new Object[] { Long.valueOf(curTime) }));
/*      */       
/*      */ 
/*  588 */       return;
/*      */     }
/*      */     
/*      */ 
/*  592 */     if (xLadder.getWeekinittime() <= 0L) {
/*  593 */       xLadder.setWeekinittime(curTime);
/*      */     }
/*      */     else {
/*  596 */       long weekInitTime = xLadder.getWeekinittime();
/*  597 */       if (!DateTimeUtils.isInSameWeek(curTime, xLadder.getWeekinittime()))
/*      */       {
/*  599 */         GameServer.logger().info(String.format("[Ladder]LadderManager.initXLadder@not in same week|curTime=%d|weekInitTime=%d|roleid=%d", new Object[] { Long.valueOf(curTime), Long.valueOf(weekInitTime), Long.valueOf(roleid) }));
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*  604 */         xLadder.setWeekinittime(curTime);
/*  605 */         xLadder.setWeekgotfightscore(0L);
/*  606 */         xLadder.setWeekfightcount(0);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  611 */     NavigableMap<Integer, SLadderSeasonCfg> tailMap = navigableMap.tailMap(Integer.valueOf((int)(xLadder.getInittime() - 1L) / 1000 + 1), true);
/*      */     
/*  613 */     for (Map.Entry<Integer, SLadderSeasonCfg> entry : tailMap.entrySet()) {
/*  614 */       int timeSec = ((Integer)entry.getKey()).intValue();
/*  615 */       long millSec = timeSec * 1000L;
/*  616 */       if (initTime < millSec)
/*      */       {
/*      */ 
/*      */ 
/*  620 */         if (curTime < millSec) {
/*      */           break;
/*      */         }
/*      */         
/*  624 */         SLadderGradeInfo gradeInfo = getGradeInfo(level, xLadder.getStage());
/*  625 */         if (gradeInfo == null) {
/*  626 */           GameServer.logger().error(String.format("[Ladder]LadderManage.initXLadder@do not has ladder honorStage config|level=%d|stage=%d|roleid=%d", new Object[] { Integer.valueOf(level), Integer.valueOf(xLadder.getStage()), Long.valueOf(roleid) }));
/*      */           
/*      */ 
/*      */ 
/*      */ 
/*  631 */           break;
/*      */         }
/*  633 */         int score = getScore(roleid, xLadder);
/*  634 */         int minScore = getMinScore(level);
/*  635 */         if (score > minScore) {
/*  636 */           score = (int)Math.round(score * (gradeInfo.reductionRate * 1.0D / 10000.0D));
/*  637 */           if (score > minScore) {
/*  638 */             xLadder.setScore(score - minScore);
/*      */           } else {
/*  640 */             xLadder.setScore(0);
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/*  645 */           xLadder.setScore(0);
/*      */         }
/*  647 */         calAndSetHonor(roleid, xLadder);
/*  648 */         initTime = millSec;
/*  649 */         xLadder.getAwardstages().clear();
/*      */       } }
/*  651 */     calAndSetHonor(roleid, xLadder);
/*  652 */     xLadder.setInittime(curTime);
/*  653 */     int nowScore = getScore(roleid, xLadder);
/*  654 */     int nowStage = xLadder.getStage();
/*  655 */     if ((nowScore != beforeScore) || (nowStage != beforeStage)) {
/*  656 */       LadderRankManager.getInstance().rank(roleid, beforeSeasonTime.longValue());
/*      */     }
/*      */   }
/*      */   
/*      */   static Ladder getAndInitXLadder(long roleid, boolean retainLock) {
/*  661 */     Ladder xLadder = null;
/*  662 */     if (retainLock) {
/*  663 */       xLadder = Role2ladder.get(Long.valueOf(roleid));
/*      */     } else {
/*  665 */       xLadder = Role2ladder.select(Long.valueOf(roleid));
/*      */     }
/*  667 */     if (xLadder != null) {
/*  668 */       initXLadder(roleid, xLadder);
/*      */     }
/*  670 */     return xLadder;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static final int MATCH_STATUS_FAIL = 1;
/*      */   
/*      */ 
/*      */   static final int MATCH_STATUS_BEGIN = 2;
/*      */   
/*      */ 
/*      */   static final int MATCH_STATUS_CACEL = 3;
/*      */   
/*      */ 
/*      */   static final int MATCH_FAIL_CONNECT_ROAM = 1;
/*      */   
/*      */ 
/*      */   static final int MATCH_FAIL_ROAM_MATCH = 2;
/*      */   
/*      */ 
/*      */   static final int MATCH_FAIL_GEN_TOKEN = 3;
/*      */   
/*      */ 
/*      */   static final int MATCH_FAIL_ROAM_ROLE_DATA = 4;
/*      */   
/*      */ 
/*      */   static final int FIGHT_WIN = 0;
/*      */   
/*      */   static final int FIGHT_LOSE = 1;
/*      */   
/*      */   static final int SIGN_ADD = 0;
/*      */   
/*      */   static final int SIGN_CUT = 1;
/*      */   
/*      */   static void onReturnOriginalServer(Map<Long, String> role2Users, List<Long> rolesList, boolean win, Map<Long, Integer> role2RankChangeMap, Map<Long, Long> role2Token, Map<Long, List<Long>> role2Petids, Map<Long, Map<Long, Integer>> role2childrenLostCha, FightResult fightResult)
/*      */   {
/*  706 */     int zoneid = GameServerInfoManager.getZoneidFromRoleid(((Long)rolesList.get(0)).longValue());
/*  707 */     onReturnOriginalServer(role2Users, rolesList, zoneid, win, role2RankChangeMap, role2Token, role2Petids, role2childrenLostCha, fightResult);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static void onReturnOriginalServer(Map<Long, String> role2Users, List<Long> rolesList, int dstZoneid, boolean win, Map<Long, Integer> role2RankChangeMap, Map<Long, Long> role2Token, Map<Long, List<Long>> role2Petids, Map<Long, Map<Long, Integer>> role2childLostCha, FightResult fightResult)
/*      */   {
/*  714 */     LadderDataBackReq ladderDataBackReq = new LadderDataBackReq();
/*  715 */     ladderDataBackReq.fightresult = fightResult;
/*  716 */     for (Iterator i$ = rolesList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  717 */       String userid = (String)role2Users.get(Long.valueOf(roleid));
/*  718 */       if (userid == null) {
/*  719 */         userid = RoleInterface.getUserId(roleid);
/*      */       }
/*  721 */       LadderUserDataBack ladderUserDataBack = new LadderUserDataBack();
/*  722 */       ExchangeDataHandlerInfo handlerInfo = new ExchangeDataHandlerInfo();
/*  723 */       if (ReturnFromRoamServerHandlerManager.boxData(userid, roleid, handlerInfo))
/*      */       {
/*  725 */         ladderUserDataBack.exchange_data_handler_info.add(handlerInfo);
/*      */       }
/*  727 */       ladderUserDataBack.roleid = roleid;
/*      */       try {
/*  729 */         ladderUserDataBack.userid.setString(userid, "UTF-8");
/*      */       } catch (Exception e) {
/*  731 */         GameServer.logger().error(String.format("[Ladder]LadderManager.onReturnOriginalServer@transfor data error!!!", new Object[0]), e);
/*      */       }
/*      */       
/*  734 */       Octets tokenOctets = LoginManager.getRoamToken(userid);
/*  735 */       if (tokenOctets != null) {
/*  736 */         ladderUserDataBack.usertokenmap.put(userid, tokenOctets);
/*      */       }
/*      */       
/*  739 */       if (role2Users.containsKey(Long.valueOf(roleid))) {
/*  740 */         Long changeCoin = (Long)role2Token.get(Long.valueOf(roleid));
/*  741 */         if (changeCoin != null) {
/*  742 */           ladderUserDataBack.ladderscore = changeCoin.longValue();
/*      */         }
/*  744 */         Integer changeScore = (Integer)role2RankChangeMap.get(Long.valueOf(roleid));
/*  745 */         if (changeScore == null) {
/*  746 */           changeScore = Integer.valueOf(0);
/*      */         }
/*  748 */         ladderUserDataBack.changescore = changeScore.intValue();
/*      */       }
/*      */       
/*  751 */       List<Long> petids = (List)role2Petids.get(Long.valueOf(roleid));
/*  752 */       if (petids != null) {
/*  753 */         ladderUserDataBack.petids.addAll(petids);
/*      */       }
/*  755 */       Map<Long, Integer> child2LostCha = (Map)role2childLostCha.get(Long.valueOf(roleid));
/*  756 */       if (child2LostCha != null) {
/*  757 */         ladderUserDataBack.childrenmap.putAll(child2LostCha);
/*      */       }
/*  759 */       ladderDataBackReq.ladderuserbackdatas.add(ladderUserDataBack);
/*      */     }
/*  761 */     if (win) {
/*  762 */       ladderDataBackReq.winorlose = 0;
/*      */     } else {
/*  764 */       ladderDataBackReq.winorlose = 1;
/*      */     }
/*  766 */     DataTransferReq req = new DataTransferReq();
/*  767 */     req.direction = 0;
/*  768 */     req.data_type = 4;
/*  769 */     req.src_id = GameServerInfoManager.getZoneId();
/*  770 */     req.dst_id = dstZoneid;
/*  771 */     OctetsStream os = new OctetsStream();
/*  772 */     os.marshal(ladderDataBackReq);
/*  773 */     req.data = os;
/*  774 */     Iterator i$; if (!GHubHelper.sendDataTransferReq(req, true, 5)) {
/*  775 */       GameServer.logger().error(String.format("[Ladder]LadderManager.onReturnOriginalServer@can not transfor data|des=%s", new Object[] { ladderDataBackReq.toString() }));
/*      */       
/*      */ 
/*  778 */       for (i$ = rolesList.iterator(); i$.hasNext();) { final long roleid = ((Long)i$.next()).longValue();
/*  779 */         String userid = (String)role2Users.get(Long.valueOf(roleid));
/*  780 */         new LogicProcedure()
/*      */         {
/*      */           protected boolean processImp() throws Exception
/*      */           {
/*  784 */             lock(xtable.User.getTable(), Arrays.asList(new String[] { this.val$userid }));
/*  785 */             LoginManager.getInstance().onReturnOrigianServer(this.val$userid, roleid);
/*  786 */             return true;
/*      */           }
/*      */         }.call();
/*      */       }
/*      */     }
/*  791 */     GameServer.logger().info(String.format("[Ladder]LadderManager.onReturnOriginalServer@send msg succeed|des=%s", new Object[] { ladderDataBackReq.toString() }));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void goToCenterServerFail(Map<Long, String> role2Users, int errorCode)
/*      */   {
/*  804 */     List<Long> allRoles = new ArrayList(role2Users.keySet());
/*  805 */     RoleStatusInterface.unsetStatus(allRoles, 41);
/*      */     
/*  807 */     removeCancelMatchId(allRoles);
/*      */     
/*  809 */     SLadderCrossMatchFailRes ladderCrossMatchFailRes = new SLadderCrossMatchFailRes();
/*  810 */     ladderCrossMatchFailRes.ret = errorCode;
/*  811 */     OnlineManager.getInstance().sendMulti(ladderCrossMatchFailRes, allRoles);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void sendUpdateCrossMatchProcessInfo(List<RoleMatchMarkingInfo> roleMatchMarkingInfos, int process)
/*      */   {
/*  821 */     SUpdateCrossMatchProcessInfo updateCrossMatchProcessInfo = new SUpdateCrossMatchProcessInfo();
/*  822 */     List<Long> roleids = new ArrayList();
/*  823 */     for (RoleMatchMarkingInfo roleMatchMarkingInfo : roleMatchMarkingInfos) {
/*  824 */       long roleid = roleMatchMarkingInfo.getRoleid();
/*  825 */       roleids.add(Long.valueOf(roleid));
/*  826 */       CrossMatchProcessInfo crossMatchProcessInfo = new CrossMatchProcessInfo();
/*  827 */       crossMatchProcessInfo.process = process;
/*  828 */       crossMatchProcessInfo.roleid = roleid;
/*  829 */       updateCrossMatchProcessInfo.crossmatchprocessinfos.add(crossMatchProcessInfo);
/*      */     }
/*  831 */     OnlineManager.getInstance().sendMultiAtOnce(updateCrossMatchProcessInfo, roleids);
/*      */   }
/*      */   
/*      */   static RoleMatchMarkingInfo createMatchMarkingInfo(long roleid) {
/*  835 */     Ladder xLadder = getAndCreateXLadder(roleid);
/*  836 */     RoleMatchMarkingInfo roleMatchMarkingInfo = new RoleMatchMarkingInfo(RoleInterface.getUserId(roleid), roleid, getScore(roleid, xLadder), xLadder.getWincount(), xLadder.getLosecount(), xLadder.getStage(), RoleInterface.getName(roleid), RoleInterface.getLevel(roleid), RoleInterface.getGender(roleid), RoleInterface.getOccupationId(roleid), mzm.gsp.avatar.main.AvatarInterface.getCurrentAvatar(roleid), mzm.gsp.avatar.frame.AvatarFrameInterface.getCurrentAvatarFrameId(roleid, false));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  841 */     return roleMatchMarkingInfo;
/*      */   }
/*      */   
/*      */   static int getToken(long roleid, int displayRank, boolean isWin) {
/*  845 */     int level = RoleInterface.getLevel(roleid);
/*  846 */     SLadderGradeInfo gradeInfo = getGradeInfo(RoleInterface.getLevel(roleid), displayRank);
/*  847 */     if (gradeInfo == null) {
/*  848 */       GameServer.logger().error(String.format("[Ladder]LadderManager.getToken@ladder honor cfg is null|roleid=%d|level=%d|displayRank=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(level), Integer.valueOf(displayRank) }));
/*      */       
/*      */ 
/*  851 */       return 0;
/*      */     }
/*  853 */     if (isWin) {
/*  854 */       return gradeInfo.winToken;
/*      */     }
/*  856 */     return gradeInfo.loseToken;
/*      */   }
/*      */   
/*      */   static boolean checkInCross(long roleid)
/*      */   {
/*  861 */     if (RoleStatusInterface.containsStatus(roleid, 41)) {
/*  862 */       return true;
/*      */     }
/*  864 */     if (RoleStatusInterface.containsStatus(roleid, 44)) {
/*  865 */       return true;
/*      */     }
/*  867 */     return false;
/*      */   }
/*      */   
/*      */   static int getEloK(int rankScore) {
/*  871 */     NavigableMap<Integer, SLadderKCfg> ladderKCfgMap = (NavigableMap)SLadderKCfg.getAll();
/*  872 */     Map.Entry<Integer, SLadderKCfg> entry = ladderKCfgMap.floorEntry(Integer.valueOf(rankScore));
/*  873 */     if (entry == null) {
/*  874 */       return SLadderConsts.getInstance().k;
/*      */     }
/*  876 */     return ((SLadderKCfg)entry.getValue()).k;
/*      */   }
/*      */   
/*      */   static void onRoleLogin(long roleid)
/*      */   {
/*  881 */     Ladder xLadder = getAndInitXLadder(roleid, true);
/*  882 */     if (xLadder == null) {
/*  883 */       return;
/*      */     }
/*  885 */     Long beforeSeasonTime = getBeforeSessionTimeMilSec(DateTimeUtils.getCurrTimeInMillis());
/*  886 */     if (beforeSeasonTime != null) {
/*  887 */       LadderRankManager.getInstance().rank(roleid, beforeSeasonTime.longValue());
/*      */     }
/*      */   }
/*      */   
/*      */   static void reportRoleLadderInfo(long roleid, Ladder xLadder, int score, Long beforeSeasonTime)
/*      */   {
/*  893 */     int levelRange = getLevelRange(RoleInterface.getLevel(roleid));
/*  894 */     if (levelRange <= 0)
/*      */     {
/*  896 */       return;
/*      */     }
/*  898 */     ReportLadderRankInfoContext reportLadderRankInfoContext = new ReportLadderRankInfoContext();
/*  899 */     reportLadderRankInfoContext.count = 1;
/*  900 */     OctetsStream os = new OctetsStream();
/*  901 */     reportLadderRankInfoContext.marshal(os);
/*  902 */     CrossServerInterface.asyncReportLadderRankInfo(getRemoteRankid(beforeSeasonTime.longValue(), levelRange), roleid, RoleInterface.getName(roleid), RoleInterface.getOccupationId(roleid), xLadder.getStage(), score, os);
/*      */     
/*  904 */     for (Iterator i$ = SLadderGradeCfg.getAll().keySet().iterator(); i$.hasNext();) { int otherLevelRange = ((Integer)i$.next()).intValue();
/*      */       
/*  906 */       if (otherLevelRange != levelRange)
/*      */       {
/*      */ 
/*      */ 
/*  910 */         RemoveLadderRankInfoContext context = new RemoveLadderRankInfoContext();
/*  911 */         context.count = 1;
/*  912 */         CrossServerInterface.asyncRemoveLadderRankInfo(getRemoteRankid(beforeSeasonTime.longValue(), otherLevelRange), roleid, context.marshal(new OctetsStream()));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   static void init() {
/*  918 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  919 */     int count = 1;
/*  920 */     NavigableMap<Integer, SLadderSeasonCfg> ladderSeasonCfgMap = (NavigableMap)SLadderSeasonCfg.getAll();
/*      */     
/*  922 */     for (SLadderSeasonCfg ladderSeasonCfg : ladderSeasonCfgMap.values()) {
/*  923 */       if (count == 1) {
/*  924 */         count++;
/*      */       }
/*      */       else {
/*  927 */         long seasonEndTimeMill = ladderSeasonCfg.beginTime * 1000L;
/*  928 */         if (seasonEndTimeMill > curTime) {
/*  929 */           new LadderSeasonSession((seasonEndTimeMill - curTime - 1L) / 1000L + 1L, seasonEndTimeMill);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Long getBeforeSessionTimeMilSec(long curTime)
/*      */   {
/*  941 */     NavigableMap<Integer, SLadderSeasonCfg> navigableMap = (NavigableMap)SLadderSeasonCfg.getAll();
/*      */     
/*  943 */     Map.Entry<Integer, SLadderSeasonCfg> entry = navigableMap.floorEntry(Integer.valueOf((int)((curTime - 1L) / 1000L + 1L)));
/*  944 */     if (entry == null) {
/*  945 */       return null;
/*      */     }
/*  947 */     return Long.valueOf(((Integer)entry.getKey()).intValue() * 1000L);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Long getNextSessionTimeMilSec(long curTime)
/*      */   {
/*  958 */     NavigableMap<Integer, SLadderSeasonCfg> navigableMap = (NavigableMap)SLadderSeasonCfg.getAll();
/*  959 */     Map.Entry<Integer, SLadderSeasonCfg> entry = navigableMap.higherEntry(Integer.valueOf((int)((curTime - 1L) / 1000L + 1L)));
/*  960 */     if (entry == null)
/*      */     {
/*  962 */       return null;
/*      */     }
/*  964 */     return Long.valueOf(((Integer)entry.getKey()).intValue() * 1000L);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<Long> getPreSeasonBeginTimestamp(long curTime)
/*      */   {
/*  975 */     List<Long> preSeasonBeginTimestamp = new ArrayList();
/*  976 */     NavigableMap<Integer, SLadderSeasonCfg> navigableMap = (NavigableMap)SLadderSeasonCfg.getAll();
/*  977 */     Map.Entry<Integer, SLadderSeasonCfg> entry = navigableMap.floorEntry(Integer.valueOf((int)((curTime - 1L) / 1000L + 1L)));
/*  978 */     Iterator i$; if (entry != null)
/*      */     {
/*  980 */       NavigableMap<Integer, SLadderSeasonCfg> headMap = navigableMap.headMap(entry.getKey(), false);
/*  981 */       for (i$ = headMap.keySet().iterator(); i$.hasNext();) { int seasonTimeSec = ((Integer)i$.next()).intValue();
/*      */         
/*  983 */         preSeasonBeginTimestamp.add(Long.valueOf(seasonTimeSec * 1000L));
/*      */       }
/*      */     }
/*  986 */     return preSeasonBeginTimestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Long getFirstSeasonBeginTimestamp()
/*      */   {
/*  997 */     NavigableMap<Integer, SLadderSeasonCfg> navigableMap = (NavigableMap)SLadderSeasonCfg.getAll();
/*  998 */     Map.Entry<Integer, SLadderSeasonCfg> entry = navigableMap.firstEntry();
/*  999 */     if (entry == null)
/*      */     {
/* 1001 */       return null;
/*      */     }
/* 1003 */     return Long.valueOf(((Integer)entry.getKey()).intValue() * 1000L);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void logMatch(List<Long> roleids, Map<Long, String> role2UserMap, long matchTimeMill, int status, long contextid, int failReason)
/*      */   {
/* 1028 */     if (roleids.size() <= 0) {
/* 1029 */       return;
/*      */     }
/*      */     
/* 1032 */     StringBuilder stringBuilder = new StringBuilder();
/* 1033 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 1034 */     stringBuilder.append(vGameIp).append("|");
/* 1035 */     int roleSize = roleids.size();
/* 1036 */     for (int i = 0; i < roleSize; i++) {
/* 1037 */       long roleid = ((Long)roleids.get(i)).longValue();
/* 1038 */       String userid = (String)role2UserMap.get(Long.valueOf(roleid));
/* 1039 */       int level = RoleInterface.getLevel(roleid);
/* 1040 */       stringBuilder.append(String.format("%s|%d|%d|", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(level) }));
/*      */     }
/* 1042 */     for (; roleSize < 5; roleSize++) {
/* 1043 */       stringBuilder.append(String.format("|%d|%d|", new Object[] { Integer.valueOf(0), Integer.valueOf(0) }));
/*      */     }
/* 1045 */     stringBuilder.append(String.format("%d|%d|%d|%d", new Object[] { Long.valueOf(matchTimeMill), Integer.valueOf(status), Long.valueOf(contextid), Integer.valueOf(failReason) }));
/* 1046 */     TLogManager.getInstance().addLog(((Long)roleids.get(0)).longValue(), "LadderMatch", stringBuilder.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void logMatchFightEnd(long endTime, String userid, long roleid, long contextid, long fightid, long fightTimeMill, int round, int result, int beforeScore, int afterScore, int addOrCut, int rolePower, List<Integer> petPowers)
/*      */   {
/* 1074 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 1075 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(RoleInterface.getLevel(roleid)), Long.valueOf(contextid), Long.valueOf(fightid), Long.valueOf(fightTimeMill), Integer.valueOf(round), Integer.valueOf(result), Integer.valueOf(beforeScore), Integer.valueOf(afterScore), Integer.valueOf(addOrCut), Integer.valueOf(rolePower) });
/*      */     
/*      */ 
/* 1078 */     StringBuilder stringBuilder = new StringBuilder(logStr);
/* 1079 */     int petPowerSize = petPowers.size();
/* 1080 */     for (int i = 0; i < 5; i++) {
/* 1081 */       if (i < petPowerSize) {
/* 1082 */         stringBuilder.append("|").append(petPowers.get(i));
/*      */       } else {
/* 1084 */         stringBuilder.append("|").append(String.valueOf(0));
/*      */       }
/*      */     }
/* 1087 */     TLogManager.getInstance().addLog(userid, "LadderMatchFightEnd", stringBuilder.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void logLadderSeasonRank(String userid, long roleid, int rank)
/*      */   {
/* 1098 */     String vGameIp = GameServerInfoManager.getHostIP();
/*      */     
/* 1100 */     String logStr = String.format("%s|%s|%d|%d", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(rank) });
/* 1101 */     TLogManager.getInstance().addLog(userid, "LadderSeasonRankLog", logStr);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getLevelRange(List<Long> roleids)
/*      */   {
/* 1114 */     if ((roleids == null) || (roleids.isEmpty()))
/*      */     {
/* 1116 */       return -1;
/*      */     }
/* 1118 */     TreeMap<Integer, SLadderGradeCfg> treeMap = (TreeMap)SLadderGradeCfg.getAll();
/* 1119 */     int allLevelRangeLowerLimit = -1;
/* 1120 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/* 1122 */       int level = RoleInterface.getLevel(roleid);
/* 1123 */       Integer levelRangeLowerLimit = (Integer)treeMap.floorKey(Integer.valueOf(level));
/* 1124 */       if (levelRangeLowerLimit == null)
/*      */       {
/* 1126 */         return -1;
/*      */       }
/* 1128 */       if (allLevelRangeLowerLimit <= 0)
/*      */       {
/* 1130 */         allLevelRangeLowerLimit = levelRangeLowerLimit.intValue();
/*      */       }
/* 1132 */       else if (allLevelRangeLowerLimit != levelRangeLowerLimit.intValue())
/*      */       {
/* 1134 */         return -1;
/*      */       }
/*      */     }
/* 1137 */     return allLevelRangeLowerLimit;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static SLadderGradeInfo getGradeInfo(int level, int grade)
/*      */   {
/* 1150 */     TreeMap<Integer, SLadderGradeCfg> treeMap = (TreeMap)SLadderGradeCfg.getAll();
/* 1151 */     Map.Entry<Integer, SLadderGradeCfg> entry = treeMap.floorEntry(Integer.valueOf(level));
/* 1152 */     if (entry == null)
/*      */     {
/* 1154 */       return null;
/*      */     }
/* 1156 */     return (SLadderGradeInfo)((SLadderGradeCfg)entry.getValue()).grade_infos.get(Integer.valueOf(grade));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getLevelRange(int level)
/*      */   {
/* 1167 */     TreeMap<Integer, SLadderGradeCfg> treeMap = (TreeMap)SLadderGradeCfg.getAll();
/* 1168 */     Map.Entry<Integer, SLadderGradeCfg> entry = treeMap.floorEntry(Integer.valueOf(level));
/* 1169 */     if (entry == null)
/*      */     {
/* 1171 */       return 0;
/*      */     }
/* 1173 */     return ((Integer)entry.getKey()).intValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getRemoteRankid(long seasonBeginTimestamp, int levelRange)
/*      */   {
/* 1184 */     return mzm.gsp.util.CommonUtils.getLong((int)(seasonBeginTimestamp / 1000L), levelRange);
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\LadderManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */