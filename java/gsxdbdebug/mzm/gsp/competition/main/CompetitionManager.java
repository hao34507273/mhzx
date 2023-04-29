/*      */ package mzm.gsp.competition.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.atomic.AtomicBoolean;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.activity.main.ActivityInterface;
/*      */ import mzm.gsp.award.main.AwardInterface;
/*      */ import mzm.gsp.award.main.AwardReason;
/*      */ import mzm.gsp.competition.CompeteFaction;
/*      */ import mzm.gsp.competition.SAgainstFactionRes;
/*      */ import mzm.gsp.competition.SBothGiveUpBrd;
/*      */ import mzm.gsp.competition.SCompetitionNormalResult;
/*      */ import mzm.gsp.competition.SCompetitionStartBrd;
/*      */ import mzm.gsp.competition.SCompetitionTitle;
/*      */ import mzm.gsp.competition.SDeductActionPointNotify;
/*      */ import mzm.gsp.competition.SRecallMercenaryBrd;
/*      */ import mzm.gsp.competition.SStageBrd;
/*      */ import mzm.gsp.competition.SSyncAgainst;
/*      */ import mzm.gsp.competition.SSyncCompeteBrd;
/*      */ import mzm.gsp.competition.SSyncFactionPlayerNumberBrd;
/*      */ import mzm.gsp.competition.SSyncMercenaryScoreBrd;
/*      */ import mzm.gsp.competition.SSyncRoleCompetition;
/*      */ import mzm.gsp.competition.STriggerMapItemsBrd;
/*      */ import mzm.gsp.competition.SWinLoseBrd;
/*      */ import mzm.gsp.competition.SWinStreakBrd;
/*      */ import mzm.gsp.competition.confbean.ItemController;
/*      */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*      */ import mzm.gsp.competition.confbean.SCompetitionMercenaryConsts;
/*      */ import mzm.gsp.competition.event.CompetitionResultArg;
/*      */ import mzm.gsp.gang.main.Gang;
/*      */ import mzm.gsp.gang.main.GangInterface;
/*      */ import mzm.gsp.map.main.ControllerInterface;
/*      */ import mzm.gsp.map.main.MapInterface;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.team.main.TeamInterface;
/*      */ import mzm.gsp.timer.main.Session;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.LogicProcedure;
/*      */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.CompetitionAgainst;
/*      */ import xbean.CompetitionMatch;
/*      */ import xbean.CompetitionTmp;
/*      */ import xbean.FactionCompetition;
/*      */ import xbean.FactionCompetitionTmp;
/*      */ import xbean.MercenaryFights;
/*      */ import xbean.MissTurn;
/*      */ import xbean.Pod;
/*      */ import xbean.RoleCompetition;
/*      */ import xtable.Competition_tmp;
/*      */ import xtable.Faction_competition;
/*      */ import xtable.Faction_competition_tmp;
/*      */ import xtable.Role_competition;
/*      */ 
/*      */ public class CompetitionManager
/*      */ {
/*   68 */   static final AtomicBoolean simplified = new AtomicBoolean(false);
/*   69 */   static Logger logger = Logger.getLogger("competition");
/*      */   
/*      */   static final String TLOG_MATCH = "CompetitionMatch";
/*      */   
/*      */   static final String TLOG_PARTICIPATE = "CompetitionParticipate";
/*      */   
/*      */   static final String TLOG_RESULT = "CompetitionResult";
/*      */   static final String TLOG_MATCH_BY_ACTIVENESS = "CompetitionMatchByActiveness";
/*      */   public static final int TLOG_RESULT_BOTH_GIVEUP = 1;
/*      */   public static final int TLOG_RESULT_FRONT_GIVEUP = 2;
/*      */   public static final int TLOG_RESULT_BEHIND_GIVEUP = 3;
/*      */   public static final int TLOG_RESULT_FRONT_WIN = 4;
/*      */   public static final int TLOG_RESULT_BEHIND_WIN = 5;
/*      */   static final String TLOG_MERCENARY = "CompetitionMercenary";
/*      */   
/*      */   static xbean.Competition getXCompetitionIfNotExist()
/*      */   {
/*   86 */     long key = GameServerInfoManager.getLocalId();
/*   87 */     xbean.Competition xCompetition = xtable.Competition.get(Long.valueOf(key));
/*   88 */     if (xCompetition == null) {
/*   89 */       xCompetition = Pod.newCompetition();
/*   90 */       xtable.Competition.insert(Long.valueOf(key), xCompetition);
/*   91 */       initXCompetition(xCompetition);
/*      */     }
/*   93 */     return xCompetition;
/*      */   }
/*      */   
/*      */ 
/*      */   static void initXCompetition(xbean.Competition xCompetition)
/*      */   {
/*   99 */     xCompetition.getMatch2times().clear();
/*      */   }
/*      */   
/*      */   static xbean.Competition getXCompetition(boolean remainLock)
/*      */   {
/*  104 */     long key = GameServerInfoManager.getLocalId();
/*  105 */     if (remainLock) {
/*  106 */       return xtable.Competition.get(Long.valueOf(key));
/*      */     }
/*      */     
/*  109 */     return xtable.Competition.select(Long.valueOf(key));
/*      */   }
/*      */   
/*      */ 
/*      */   static CompetitionTmp getXCompetitionTmpIfNotExist()
/*      */   {
/*  115 */     long key = GameServerInfoManager.getLocalId();
/*  116 */     CompetitionTmp xTmp = Competition_tmp.get(Long.valueOf(key));
/*  117 */     if (xTmp == null) {
/*  118 */       xTmp = Pod.newCompetitionTmp();
/*  119 */       Competition_tmp.insert(Long.valueOf(key), xTmp);
/*      */     }
/*  121 */     return xTmp;
/*      */   }
/*      */   
/*      */   static CompetitionTmp getXCompetitionTmp(boolean remainLock)
/*      */   {
/*  126 */     long key = GameServerInfoManager.getLocalId();
/*  127 */     if (remainLock) {
/*  128 */       return Competition_tmp.get(Long.valueOf(key));
/*      */     }
/*      */     
/*  131 */     return Competition_tmp.select(Long.valueOf(key));
/*      */   }
/*      */   
/*      */   static FactionCompetition getXFactionCompetitionIfNotExist(long faction)
/*      */   {
/*  136 */     FactionCompetition xFactionCompetition = Faction_competition.get(Long.valueOf(faction));
/*  137 */     if (xFactionCompetition == null) {
/*  138 */       xFactionCompetition = Pod.newFactionCompetition();
/*  139 */       Faction_competition.insert(Long.valueOf(faction), xFactionCompetition);
/*      */     }
/*  141 */     return xFactionCompetition;
/*      */   }
/*      */   
/*      */   static void initXFactionCompetition(FactionCompetition xFactionCompetition)
/*      */   {
/*  146 */     xFactionCompetition.setPk_score(0);
/*  147 */     xFactionCompetition.setPlayer_score(0);
/*  148 */     xFactionCompetition.setMercenary_score(0);
/*  149 */     xFactionCompetition.setParticipated(false);
/*  150 */     xFactionCompetition.setOpponent(-1L);
/*  151 */     xFactionCompetition.getParticipate_roles().clear();
/*      */   }
/*      */   
/*      */   static RoleCompetition getXRoleCompetitionIfNotExist(long roleid)
/*      */   {
/*  156 */     RoleCompetition xRoleCompetition = Role_competition.get(Long.valueOf(roleid));
/*  157 */     if (xRoleCompetition == null) {
/*  158 */       xRoleCompetition = Pod.newRoleCompetition();
/*  159 */       Role_competition.insert(Long.valueOf(roleid), xRoleCompetition);
/*  160 */       initXRoleCompetition(xRoleCompetition);
/*      */     }
/*  162 */     return xRoleCompetition;
/*      */   }
/*      */   
/*      */   static void initXRoleCompetition(RoleCompetition xRoleCompetition)
/*      */   {
/*  167 */     xRoleCompetition.setAction_point(SCompetitionConsts.getInstance().InitActionPoint);
/*  168 */     xRoleCompetition.setWin_streak(0);
/*  169 */     xRoleCompetition.setParticipated(false);
/*  170 */     xRoleCompetition.setAwarded_final(false);
/*      */   }
/*      */   
/*      */ 
/*      */   private static void asyncStartOneCompetition(long faction1, long faction2)
/*      */   {
/*  176 */     NoneRealTimeTaskManager.getInstance().addTask(new POneCompetitionStart(faction1, faction2));
/*      */   }
/*      */   
/*      */   static CompetitionMatch getXMatch(long faction1, long faction2)
/*      */   {
/*  181 */     if (faction1 < faction2) {
/*  182 */       return new CompetitionMatch(faction1, faction2);
/*      */     }
/*      */     
/*  185 */     return new CompetitionMatch(faction2, faction1);
/*      */   }
/*      */   
/*      */ 
/*      */   static FactionCompetitionTmp getXFactionCompetitionTmpIfNotExist(long faction)
/*      */   {
/*  191 */     FactionCompetitionTmp xTmp = Faction_competition_tmp.get(Long.valueOf(faction));
/*  192 */     if (xTmp == null) {
/*  193 */       xTmp = Pod.newFactionCompetitionTmp();
/*  194 */       Faction_competition_tmp.insert(Long.valueOf(faction), xTmp);
/*      */     }
/*  196 */     return xTmp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void broadcastAgainst(long faction1, long faction2)
/*      */   {
/*  207 */     Gang gang1 = GangInterface.getGang(faction1, false);
/*  208 */     Gang gang2 = GangInterface.getGang(faction2, false);
/*      */     
/*      */ 
/*  211 */     broadcastAgainst(gang1, gang2);
/*      */   }
/*      */   
/*      */   static void broadcastAgainst(Gang gang1, Gang gang2)
/*      */   {
/*  216 */     if (gang1 != null) {
/*  217 */       SCompetitionStartBrd brd1 = new SCompetitionStartBrd();
/*  218 */       if (gang2 != null) {
/*  219 */         brd1.opponent = gang2.getName();
/*      */       }
/*  221 */       gang1.brocadcast(brd1);
/*      */     }
/*      */     
/*  224 */     if (gang2 != null) {
/*  225 */       SCompetitionStartBrd brd2 = new SCompetitionStartBrd();
/*  226 */       if (gang1 != null) {
/*  227 */         brd2.opponent = gang1.getName();
/*      */       }
/*  229 */       gang2.brocadcast(brd2);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isActivityTime()
/*      */   {
/*  240 */     return ActivityInterface.isActivityOpen(SCompetitionConsts.getInstance().Activityid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isPrepareStage()
/*      */   {
/*  249 */     return ActivityInterface.getActivityStage(SCompetitionConsts.getInstance().Activityid) == 0;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean isCompeteStage()
/*      */   {
/*  255 */     int stage = ActivityInterface.getActivityStage(SCompetitionConsts.getInstance().Activityid);
/*  256 */     return isCompeteStage(stage);
/*      */   }
/*      */   
/*      */   static boolean isCompeteStage(int stage)
/*      */   {
/*  261 */     return (stage == 1) || (stage == 2) || (stage == 3);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static boolean isCompeteWaitStage()
/*      */   {
/*  268 */     return ActivityInterface.getActivityStage(SCompetitionConsts.getInstance().Activityid) == 1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void sendNormalResult(long roleid, int result, String... args)
/*      */   {
/*  275 */     SCompetitionNormalResult p = getNormalResult(result, args);
/*  276 */     OnlineManager.getInstance().sendAtOnce(roleid, p);
/*      */   }
/*      */   
/*      */   static void broadcastNormalResult(Collection<Long> roles, int result, String... args)
/*      */   {
/*  281 */     SCompetitionNormalResult p = getNormalResult(result, args);
/*  282 */     OnlineManager.getInstance().sendMultiAtOnce(p, roles);
/*      */   }
/*      */   
/*      */   private static SCompetitionNormalResult getNormalResult(int result, String... args)
/*      */   {
/*  287 */     SCompetitionNormalResult p = new SCompetitionNormalResult();
/*  288 */     p.result = result;
/*  289 */     for (String arg : args) {
/*  290 */       p.args.add(arg);
/*      */     }
/*  292 */     return p;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void broadcastStage(Collection<Long> roles)
/*      */   {
/*  301 */     int stage = ActivityInterface.getActivityStage(SCompetitionConsts.getInstance().Activityid);
/*  302 */     broadcastStage(roles, stage);
/*      */   }
/*      */   
/*      */   static void broadcastStage(Collection<Long> roles, int stage)
/*      */   {
/*  307 */     SStageBrd brd = new SStageBrd(stage);
/*  308 */     OnlineManager.getInstance().sendMulti(brd, roles);
/*      */   }
/*      */   
/*      */   static void syncStage(long roleid, int stage)
/*      */   {
/*  313 */     SStageBrd sync = new SStageBrd(stage);
/*  314 */     OnlineManager.getInstance().send(roleid, sync);
/*      */   }
/*      */   
/*      */   static void syncRoleCompetition(long roleid)
/*      */   {
/*  319 */     RoleCompetition xRoleCompetition = Role_competition.select(Long.valueOf(roleid));
/*  320 */     if (xRoleCompetition == null) {
/*  321 */       return;
/*      */     }
/*  323 */     syncRoleCompetition(roleid, xRoleCompetition);
/*      */   }
/*      */   
/*      */   static void syncRoleCompetition(long roleid, RoleCompetition xRoleCompetition)
/*      */   {
/*  328 */     SSyncRoleCompetition p = new SSyncRoleCompetition();
/*  329 */     p.action_point = xRoleCompetition.getAction_point();
/*  330 */     OnlineManager.getInstance().send(roleid, p);
/*      */   }
/*      */   
/*      */   static void addWinStreakAndGiveReward(long roleid, RoleCompetition xRoleCompetition, Gang faction)
/*      */   {
/*  335 */     xRoleCompetition.setWin_streak(xRoleCompetition.getWin_streak() + 1);
/*  336 */     if (xRoleCompetition.getWin_streak() >= SCompetitionConsts.getInstance().WinStreakTimes)
/*      */     {
/*  338 */       mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(roleid, SCompetitionConsts.getInstance().WinStreakMail, null, null, new mzm.gsp.tlog.TLogArg(LogReason.COMPETITION_WIN_STREAK_AWARD));
/*      */       
/*      */ 
/*  341 */       xRoleCompetition.setWin_streak(0);
/*      */       
/*  343 */       SWinStreakBrd brd = new SWinStreakBrd();
/*  344 */       brd.roleid = roleid;
/*  345 */       brd.name = RoleInterface.getName(roleid);
/*  346 */       brd.win_streak = SCompetitionConsts.getInstance().WinStreakTimes;
/*  347 */       faction.brocadcast(brd);
/*      */     }
/*      */   }
/*      */   
/*      */   static void deductActionPoint(long roleid, RoleCompetition xRoleCompetition, int deductValue, int reason)
/*      */   {
/*  353 */     xRoleCompetition.setAction_point(xRoleCompetition.getAction_point() - deductValue);
/*  354 */     SDeductActionPointNotify notify = new SDeductActionPointNotify();
/*  355 */     notify.deduct_value = deductValue;
/*  356 */     notify.reason = reason;
/*  357 */     OnlineManager.getInstance().send(roleid, notify);
/*      */   }
/*      */   
/*      */   static boolean clearActivityStatus(long roleid)
/*      */   {
/*  362 */     boolean ret = mzm.gsp.status.main.RoleStatusInterface.unsetStatus(roleid, 11);
/*      */     
/*      */ 
/*  365 */     mzm.gsp.buff.main.BuffInterface.uninstallBuf(roleid, SCompetitionConsts.getInstance().ProtectedBuff);
/*      */     
/*      */ 
/*  368 */     unsetFactionTitle(roleid);
/*      */     
/*  370 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean leave(String userid, long roleid, Gang faction, FactionCompetitionTmp xTmp)
/*      */   {
/*  376 */     boolean ret = clearActivityStatus(roleid);
/*      */     
/*  378 */     if (faction != null)
/*      */     {
/*  380 */       GangInterface.forceTransferToGangMap(roleid, faction.getGangId());
/*      */     }
/*      */     else
/*      */     {
/*  384 */       MapInterface.forceTransferWhenFault(roleid);
/*      */     }
/*      */     
/*      */ 
/*  388 */     if (ret)
/*      */     {
/*  390 */       if (faction != null) {
/*  391 */         addFactionPlayer(faction.getGangId(), xTmp, -1);
/*      */       }
/*      */       
/*  394 */       int stage = ActivityInterface.getActivityStage(SCompetitionConsts.getInstance().Activityid);
/*  395 */       if (stage >= 1)
/*      */       {
/*  397 */         if (faction != null) {
/*  398 */           faction.addGongXun(roleid, SCompetitionConsts.getInstance().ParticipateExploit);
/*      */         }
/*      */         
/*  401 */         AwardReason reason = new AwardReason(LogReason.COMPETITION_LEAVE_AWARD);
/*  402 */         AwardInterface.award(SCompetitionConsts.getInstance().LeaveAward, userid, roleid, false, true, reason);
/*      */         
/*  404 */         setParticipated(roleid);
/*      */       }
/*      */     }
/*      */     
/*  408 */     return ret;
/*      */   }
/*      */   
/*      */   static void leaveNoneRealTime(long roleid, long factionid)
/*      */   {
/*  413 */     NoneRealTimeTaskManager.getInstance().addTask(new PLeave(roleid, factionid));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void setParticipated(long roleid)
/*      */   {
/*  422 */     RoleCompetition xRC = getXRoleCompetitionIfNotExist(roleid);
/*  423 */     xRC.setParticipated(true);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void awardAllParticipants()
/*      */   {
/*  434 */     xbean.Competition xCompetition = getXCompetition(false);
/*  435 */     if (xCompetition == null) {
/*  436 */       return;
/*      */     }
/*  438 */     AwardReason reason = new AwardReason(LogReason.COMPETITION_PREPARE_AWARD);
/*  439 */     for (CompetitionMatch xMatch : xCompetition.getAgainsts().keySet()) {
/*  440 */       FactionCompetitionTmp xFCTmp1 = Faction_competition_tmp.select(Long.valueOf(xMatch.getFrontfaction()));
/*  441 */       if (xFCTmp1 != null) {
/*  442 */         Collection<Long> roles = MapInterface.getRoleList(xFCTmp1.getWorld());
/*      */         
/*  444 */         AwardInterface.awardToAllNoneRealTime(roles, SCompetitionConsts.getInstance().PrepareAward, -1, false, true, reason);
/*      */       }
/*  446 */       FactionCompetitionTmp xFCTmp2 = Faction_competition_tmp.select(Long.valueOf(xMatch.getBehindfaction()));
/*  447 */       if (xFCTmp2 != null) {
/*  448 */         Collection<Long> roles = MapInterface.getRoleList(xFCTmp2.getWorld());
/*      */         
/*  450 */         AwardInterface.awardToAllNoneRealTime(roles, SCompetitionConsts.getInstance().PrepareAward, -1, false, true, reason);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void broadcastAgainst()
/*      */   {
/*  462 */     xbean.Competition xCompetition = getXCompetition(false);
/*      */     
/*  464 */     for (CompetitionMatch xMatch : xCompetition.getAgainsts().keySet()) {
/*  465 */       broadcastAgainst(xMatch.getFrontfaction(), xMatch.getBehindfaction());
/*      */     }
/*      */   }
/*      */   
/*      */   static void onActivityStart(xbean.Competition xCompetition)
/*      */   {
/*  471 */     if (xCompetition == null) {
/*  472 */       return;
/*      */     }
/*      */     
/*  475 */     for (CompetitionMatch xMatch : xCompetition.getAgainsts().keySet()) {
/*  476 */       asyncStartOneCompetition(xMatch.getFrontfaction(), xMatch.getBehindfaction());
/*      */     }
/*      */     
/*      */ 
/*  480 */     new BrdAgainstObserver(SCompetitionConsts.getInstance().PrepareBrdMinutes * 60);
/*      */     
/*      */ 
/*      */ 
/*  484 */     new AwardObserver();
/*      */   }
/*      */   
/*      */   static void onActivityStart()
/*      */   {
/*  489 */     xbean.Competition xCompetition = getXCompetition(false);
/*  490 */     onActivityStart(xCompetition);
/*      */   }
/*      */   
/*      */   static CompetitionAgainst getXAgainst(xbean.Competition xCompetition, long faction1, long faction2)
/*      */   {
/*  495 */     CompetitionMatch xMatch = getXMatch(faction1, faction2);
/*  496 */     CompetitionAgainst xAgainst = (CompetitionAgainst)xCompetition.getAgainsts().get(xMatch);
/*  497 */     return xAgainst;
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
/*      */   static boolean onBothGiveUp(long factionid1, long factionid2, Gang faction1, Gang faction2, FactionCompetition xFC1, FactionCompetition xFC2, CompetitionAgainst xAgainst, long world, String tlogUserid)
/*      */   {
/*  512 */     xAgainst.setFinished(true);
/*      */     
/*      */ 
/*  515 */     destroyWorld(world);
/*      */     
/*  517 */     long displayid1 = -1L;
/*  518 */     long displayid2 = -1L;
/*      */     
/*      */ 
/*  521 */     SBothGiveUpBrd brd = new SBothGiveUpBrd();
/*  522 */     brd.id1 = factionid1;
/*  523 */     if (faction1 != null) {
/*  524 */       brd.name1 = faction1.getName();
/*  525 */       displayid1 = faction1.getDisplayid();
/*      */     }
/*  527 */     brd.id2 = factionid2;
/*  528 */     if (faction2 != null) {
/*  529 */       brd.name2 = faction2.getName();
/*  530 */       displayid2 = faction2.getDisplayid();
/*      */     }
/*  532 */     if (faction1 != null) {
/*  533 */       faction1.brocadcast(brd);
/*      */     }
/*  535 */     if (faction2 != null) {
/*  536 */       faction2.brocadcast(brd);
/*      */     }
/*      */     
/*      */ 
/*  540 */     addLoseTimes(xFC1);
/*  541 */     addLoseTimes(xFC2);
/*      */     
/*      */ 
/*  544 */     tlogResult(factionid1, factionid2, xFC1, xFC2, 1, tlogUserid, displayid1, displayid2);
/*      */     
/*      */ 
/*      */ 
/*  548 */     triggerResultEvent(factionid1, xFC1, factionid2, xFC2, 1);
/*      */     
/*  550 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void tlogResult(long factionid1, long factionid2, FactionCompetition xFC1, FactionCompetition xFC2, int result, String tlogUserid, long factionDisplayid1, long factionDisplayid2)
/*      */   {
/*  557 */     int winTimes1 = 0;
/*  558 */     int loseTimes1 = 0;
/*  559 */     int pkScore1 = 0;
/*  560 */     int playerScore1 = 0;
/*  561 */     int winTimes2 = 0;
/*  562 */     int loseTimes2 = 0;
/*  563 */     int pkScore2 = 0;
/*  564 */     int playerScore2 = 0;
/*  565 */     if (xFC1 != null) {
/*  566 */       winTimes1 = xFC1.getWin_times();
/*  567 */       loseTimes1 = xFC1.getLose_times();
/*  568 */       pkScore1 = xFC1.getPk_score();
/*  569 */       playerScore1 = xFC1.getPlayer_score();
/*      */     }
/*  571 */     if (xFC2 != null) {
/*  572 */       winTimes2 = xFC2.getWin_times();
/*  573 */       loseTimes2 = xFC2.getLose_times();
/*  574 */       pkScore2 = xFC2.getPk_score();
/*  575 */       playerScore2 = xFC2.getPlayer_score();
/*      */     }
/*      */     
/*  578 */     TLogManager.getInstance().addLog(tlogUserid, "CompetitionResult", new Object[] { Long.valueOf(factionid1), Integer.valueOf(winTimes1), Integer.valueOf(loseTimes1), Integer.valueOf(pkScore1), Integer.valueOf(playerScore1), Long.valueOf(factionid2), Integer.valueOf(winTimes2), Integer.valueOf(loseTimes2), Integer.valueOf(pkScore2), Integer.valueOf(playerScore2), Integer.valueOf(result), Long.valueOf(factionDisplayid1), Long.valueOf(factionDisplayid2) });
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
/*      */   static boolean onOneFactionGiveUp(long winFactionid, long giveUpFactionid, Gang winFaction, Gang giveUpFaction, FactionCompetition xWinFC, FactionCompetition xGiveUpFC, CompetitionAgainst xAgainst, long world, String tlogUserid)
/*      */   {
/*  599 */     xAgainst.setFinished(true);
/*      */     
/*  601 */     long winDisplayid = -1L;
/*  602 */     if (winFaction != null) {
/*  603 */       winDisplayid = winFaction.getDisplayid();
/*      */     }
/*  605 */     long giveUpDisplayid = -1L;
/*  606 */     if (giveUpFaction != null) {
/*  607 */       giveUpDisplayid = giveUpFaction.getDisplayid();
/*      */     }
/*      */     
/*      */ 
/*  611 */     int roleNumber = MapInterface.getRoleNumInWorld(world);
/*  612 */     triggerMapItems(world, roleNumber, winFactionid, winDisplayid);
/*      */     
/*      */ 
/*  615 */     addWinTimes(xWinFC);
/*  616 */     addLoseTimes(xGiveUpFC);
/*      */     
/*      */ 
/*      */ 
/*  620 */     asyncSettleFaction(winFactionid, true);
/*      */     
/*      */ 
/*  623 */     broadcastWinLose(winFactionid, giveUpFactionid, winFaction, giveUpFaction, 1);
/*      */     
/*      */ 
/*  626 */     if (winFactionid < giveUpFactionid) {
/*  627 */       tlogResult(winFactionid, giveUpFactionid, xWinFC, xGiveUpFC, 3, tlogUserid, winDisplayid, giveUpDisplayid);
/*      */       
/*  629 */       triggerResultEvent(winFactionid, xWinFC, giveUpFactionid, xGiveUpFC, 3);
/*      */     }
/*      */     else {
/*  632 */       tlogResult(giveUpFactionid, winFactionid, xGiveUpFC, xWinFC, 2, tlogUserid, winDisplayid, giveUpDisplayid);
/*      */       
/*  634 */       triggerResultEvent(giveUpFactionid, xGiveUpFC, winFactionid, xWinFC, 2);
/*      */     }
/*      */     
/*      */ 
/*  638 */     return true;
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
/*      */   static boolean onOneFactionLeft(long winFactionid, long loseFactionid, Gang winFaction, Gang loseFaction, FactionCompetition xWinFC, FactionCompetition xLoseFC, CompetitionAgainst xAgainst, MercenaryFights xFights, long world, String tlogUserid)
/*      */   {
/*  652 */     xAgainst.setFinished(true);
/*      */     
/*  654 */     long winDisplayid = -1L;
/*  655 */     if (winFaction != null) {
/*  656 */       winDisplayid = winFaction.getDisplayid();
/*      */     }
/*  658 */     long loseDisplayid = -1L;
/*  659 */     if (loseFaction != null) {
/*  660 */       loseDisplayid = loseFaction.getDisplayid();
/*      */     }
/*      */     
/*      */ 
/*  664 */     ControllerInterface.collectWorldController(world, SCompetitionMercenaryConsts.getInstance().MercenaryController);
/*      */     
/*      */     Iterator i$;
/*      */     
/*  668 */     if (xFights != null) {
/*  669 */       for (i$ = xFights.getFights().iterator(); i$.hasNext();) { long fightid = ((Long)i$.next()).longValue();
/*      */         
/*  671 */         mzm.gsp.fight.main.FightInterface.endFightNonRealTime(fightid);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  676 */     triggerMapItems(world, winFactionid, winDisplayid);
/*      */     
/*      */ 
/*  679 */     addWinTimes(xWinFC);
/*  680 */     addLoseTimes(xLoseFC);
/*      */     
/*      */ 
/*      */ 
/*  684 */     asyncSettleFaction(winFactionid, true);
/*  685 */     asyncSettleFaction(loseFactionid, false);
/*      */     
/*      */ 
/*  688 */     broadcastWinLose(winFactionid, loseFactionid, winFaction, loseFaction, 2);
/*      */     
/*      */ 
/*  691 */     if (winFactionid < loseFactionid) {
/*  692 */       tlogResult(winFactionid, loseFactionid, xWinFC, xLoseFC, 4, tlogUserid, winDisplayid, loseDisplayid);
/*      */       
/*  694 */       triggerResultEvent(winFactionid, xWinFC, loseFactionid, xLoseFC, 4);
/*      */     }
/*      */     else {
/*  697 */       tlogResult(loseFactionid, winFactionid, xLoseFC, xWinFC, 5, tlogUserid, winDisplayid, loseDisplayid);
/*      */       
/*  699 */       triggerResultEvent(loseFactionid, xLoseFC, winFactionid, xWinFC, 5);
/*      */     }
/*      */     
/*  702 */     return true;
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
/*      */   static boolean onNoFactionLeft(long factionid1, long factionid2, Gang faction1, Gang faction2, FactionCompetition xFC1, FactionCompetition xFC2, CompetitionAgainst xAgainst, String tlogUserid)
/*      */   {
/*  715 */     long winFactionid = -1L;
/*  716 */     long loseFactionid = -1L;
/*  717 */     Gang winFaction = null;
/*  718 */     Gang loseFaction = null;
/*  719 */     FactionCompetition xWinFC = null;
/*  720 */     FactionCompetition xLoseFC = null;
/*  721 */     if (isFrontWin(factionid1, xFC1, factionid2, xFC2)) {
/*  722 */       winFactionid = factionid1;
/*  723 */       loseFactionid = factionid2;
/*  724 */       winFaction = faction1;
/*  725 */       loseFaction = faction2;
/*  726 */       xWinFC = xFC1;
/*  727 */       xLoseFC = xFC2;
/*      */     }
/*      */     else {
/*  730 */       winFactionid = factionid2;
/*  731 */       loseFactionid = factionid1;
/*  732 */       winFaction = faction2;
/*  733 */       loseFaction = faction1;
/*  734 */       xWinFC = xFC2;
/*  735 */       xLoseFC = xFC1;
/*      */     }
/*      */     
/*  738 */     long winDisplayeid = -1L;
/*  739 */     long loseDisplayid = -1L;
/*  740 */     if (winFaction != null) {
/*  741 */       winDisplayeid = winFaction.getDisplayid();
/*      */     }
/*  743 */     if (loseFaction != null) {
/*  744 */       loseDisplayid = loseFaction.getDisplayid();
/*      */     }
/*      */     
/*      */ 
/*  748 */     logInfo("Competition.onNoFactionLeft@early end|winfactionid=%d|winfaction_displayid=%d|losefactionid=%d|losefaction_displayid=%d", new Object[] { Long.valueOf(winFactionid), Long.valueOf(winDisplayeid), Long.valueOf(loseFactionid), Long.valueOf(loseDisplayid) });
/*      */     
/*      */ 
/*  751 */     xAgainst.setFinished(true);
/*      */     
/*      */ 
/*      */ 
/*  755 */     asyncSettleFaction(winFactionid, true);
/*  756 */     asyncSettleFaction(loseFactionid, false);
/*      */     
/*      */ 
/*  759 */     addWinTimes(xWinFC);
/*  760 */     addLoseTimes(xLoseFC);
/*      */     
/*      */ 
/*  763 */     broadcastWinLose(winFactionid, loseFactionid, winFaction, loseFaction, 2);
/*      */     
/*      */ 
/*  766 */     if (winFactionid < loseFactionid) {
/*  767 */       tlogResult(winFactionid, loseFactionid, xWinFC, xLoseFC, 4, tlogUserid, winDisplayeid, loseDisplayid);
/*      */       
/*  769 */       triggerResultEvent(winFactionid, xWinFC, loseFactionid, xLoseFC, 4);
/*      */     }
/*      */     else {
/*  772 */       tlogResult(loseFactionid, winFactionid, xLoseFC, xWinFC, 5, tlogUserid, winDisplayeid, loseDisplayid);
/*      */       
/*  774 */       triggerResultEvent(loseFactionid, xLoseFC, winFactionid, xWinFC, 5);
/*      */     }
/*      */     
/*  777 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   static void asyncCalculateELORank(long winFaction, long loseFaction)
/*      */   {
/*  783 */     NoneRealTimeTaskManager.getInstance().addTask(new PCalculateELORank(winFaction, loseFaction));
/*      */   }
/*      */   
/*      */   static void triggerMapItems(long world, long winFactionid, long winFactionDisplayid)
/*      */   {
/*  788 */     int totalNumber = MapInterface.getRoleNumInWorld(world);
/*  789 */     triggerMapItems(world, totalNumber, winFactionid, winFactionDisplayid);
/*      */   }
/*      */   
/*      */ 
/*      */   static void triggerMapItems(long world, int totalNumber, final long winFactionid, long winFactionDisplayid)
/*      */   {
/*  795 */     if (totalNumber > 0) {
/*  796 */       int endSeconds = ActivityInterface.getActivityStageLeftTime(SCompetitionConsts.getInstance().Activityid, 4) / 1000;
/*      */       
/*      */ 
/*  799 */       int leftSeconds = SCompetitionConsts.getInstance().TriggerMapItemSeconds;
/*  800 */       if (leftSeconds >= endSeconds) {
/*  801 */         triggerMapItemsAtOnce(world, totalNumber, winFactionid, winFactionDisplayid);
/*      */       }
/*      */       else {
/*  804 */         broadcastTriggerMapItems(world, leftSeconds);
/*  805 */         new Session(leftSeconds, world)
/*      */         {
/*      */           protected void onTimeOut()
/*      */           {
/*  809 */             CompetitionManager.triggerMapItemsAtOnce(winFactionid, this.val$totalNumber, this.val$winFactionid, this.val$winFactionDisplayid);
/*      */           }
/*      */         };
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void asyncTriggerMapItems(long world, int totalNumber, final long winFactionid, final long winFactionDisplayid)
/*      */   {
/*  820 */     NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicRunnable()
/*      */     {
/*      */       public void process() throws Exception
/*      */       {
/*  824 */         CompetitionManager.triggerMapItems(this.val$world, winFactionid, winFactionDisplayid, this.val$winFactionDisplayid);
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void triggerMapItemsAtOnce(long world, int totalNumber, long winFactionid, long winFactionDisplayid)
/*      */   {
/*  834 */     totalNumber = Math.min(totalNumber, SCompetitionConsts.getInstance().MaxTreasureNum);
/*  835 */     for (ItemController itemController : SCompetitionConsts.getInstance().ItemControllers) {
/*  836 */       int sumWeight = CompetitionConfigManager.getInstance().getSumItemWeight();
/*  837 */       int number = (int)Math.ceil(itemController.Weight * totalNumber / sumWeight);
/*  838 */       number = Math.min(number, SCompetitionConsts.getInstance().MaxTreasureNum);
/*  839 */       ControllerInterface.triggerWorldControllerWithMaxSpawnNum(world, itemController.Controller, number);
/*  840 */       logInfo("CompetitionManager.triggerMapItemsAtOnce@trigger treasure|win_factionid=%d|winfaction_displayid=%d|worldid=%d|controllerid=%d|number=%d", new Object[] { Long.valueOf(winFactionid), Long.valueOf(winFactionDisplayid), Long.valueOf(world), Integer.valueOf(itemController.Controller), Integer.valueOf(number) });
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static void broadcastTriggerMapItems(long world, int leftSeconds)
/*      */   {
/*  847 */     STriggerMapItemsBrd brd = new STriggerMapItemsBrd(leftSeconds);
/*  848 */     MapInterface.brocadCastInWorld(world, brd, false);
/*      */   }
/*      */   
/*      */   static void asyncSettleFaction(long faction, boolean isWinner)
/*      */   {
/*  853 */     NoneRealTimeTaskManager.getInstance().addTask(new PSettleFaction(faction, isWinner));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static boolean isFrontWin(long faction1, FactionCompetition xFC1, long faction2, FactionCompetition xFC2)
/*      */   {
/*  860 */     int score1 = xFC1.getPk_score() + xFC1.getPlayer_score();
/*  861 */     int score2 = xFC2.getPk_score() + xFC2.getPlayer_score();
/*      */     
/*  863 */     if (score1 > score2) {
/*  864 */       return true;
/*      */     }
/*  866 */     if (score1 < score2) {
/*  867 */       return false;
/*      */     }
/*      */     
/*  870 */     if (xFC1.getPk_score() > xFC2.getPk_score()) {
/*  871 */       return true;
/*      */     }
/*  873 */     if (xFC1.getPk_score() < xFC2.getPk_score()) {
/*  874 */       return false;
/*      */     }
/*      */     
/*  877 */     return faction1 < faction2;
/*      */   }
/*      */   
/*      */   static void syncAgainstNoneRealTime(List<Long> roles, final long world)
/*      */   {
/*  882 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*      */     {
/*      */       protected boolean processImp() throws Exception
/*      */       {
/*  886 */         CompetitionManager.syncAgainst(this.val$roles, world);
/*  887 */         return true;
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void syncAgainst(long roleid, Gang selfFaction, FactionCompetition xSelfFC, FactionCompetitionTmp xSelfFCTmp, Gang oppoFaction, FactionCompetition xOppoFC, FactionCompetitionTmp xOppoFCTmp)
/*      */   {
/*  896 */     syncAgainst(Arrays.asList(new Long[] { Long.valueOf(roleid) }), selfFaction, xSelfFC, xSelfFCTmp, oppoFaction, xOppoFC, xOppoFCTmp);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void syncAgainst(Collection<Long> roles, Gang selfFaction, FactionCompetition xSelfFC, FactionCompetitionTmp xSelfFCTmp, Gang oppoFaction, FactionCompetition xOppoFC, FactionCompetitionTmp xOppoFCTmp)
/*      */   {
/*  904 */     SSyncAgainst sync = getSyncAgainstProtocol(selfFaction, xSelfFC, xSelfFCTmp, oppoFaction, xOppoFC, xOppoFCTmp);
/*  905 */     OnlineManager.getInstance().sendMulti(sync, roles);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void syncAgainst(List<Long> roles, long world)
/*      */   {
/*  941 */     Gang selfFaction = GangInterface.getGangByRoleId(((Long)roles.get(0)).longValue(), false);
/*  942 */     if (selfFaction == null) {
/*  943 */       return;
/*      */     }
/*      */     
/*  946 */     SSyncAgainst syncAgainst = getSyncAgainstProtocol(selfFaction, world);
/*  947 */     OnlineManager.getInstance().sendMulti(syncAgainst, roles);
/*      */   }
/*      */   
/*      */ 
/*      */   static SSyncAgainst getSyncAgainstProtocol(Gang selfFaction, FactionCompetition xSelfFC, FactionCompetitionTmp xSelfFCTmp, Gang oppoFaction, FactionCompetition xOppoFC, FactionCompetitionTmp xOppoFCTmp)
/*      */   {
/*  953 */     SSyncAgainst syncAgainst = new SSyncAgainst();
/*  954 */     fillCompeteFactionBean(selfFaction.getGangId(), xSelfFC, xSelfFCTmp.getPlayer_num(), syncAgainst.self_faction);
/*  955 */     syncAgainst.self_name = selfFaction.getName();
/*  956 */     fillCompeteFactionBean(oppoFaction.getGangId(), xOppoFC, xOppoFCTmp.getPlayer_num(), syncAgainst.opponent_faction);
/*  957 */     syncAgainst.opponent_name = oppoFaction.getName();
/*  958 */     return syncAgainst;
/*      */   }
/*      */   
/*      */   static SSyncAgainst getSyncAgainstProtocol(Gang selfFaction, long world)
/*      */   {
/*  963 */     FactionCompetition xFCSelf = Faction_competition.select(Long.valueOf(selfFaction.getGangId()));
/*  964 */     FactionCompetition xFCOpponent = Faction_competition.select(Long.valueOf(xFCSelf.getOpponent()));
/*      */     
/*  966 */     Gang opponentFaction = GangInterface.getGang(xFCSelf.getOpponent(), false);
/*      */     
/*  968 */     int selfNumber = 0;
/*  969 */     int opponentNumber = 0;
/*      */     
/*  971 */     List<Long> roles = MapInterface.getRoleList(world);
/*      */     
/*  973 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*  974 */       if (selfFaction.isInGang(r)) {
/*  975 */         selfNumber++;
/*      */       }
/*      */       else {
/*  978 */         opponentNumber++;
/*      */       }
/*      */     }
/*      */     
/*  982 */     SSyncAgainst syncAgainst = new SSyncAgainst();
/*  983 */     fillCompeteFactionBean(selfFaction.getGangId(), xFCSelf, selfNumber, syncAgainst.self_faction);
/*  984 */     syncAgainst.self_name = selfFaction.getName();
/*  985 */     fillCompeteFactionBean(opponentFaction.getGangId(), xFCOpponent, opponentNumber, syncAgainst.opponent_faction);
/*  986 */     syncAgainst.opponent_name = opponentFaction.getName();
/*      */     
/*  988 */     return syncAgainst;
/*      */   }
/*      */   
/*      */   static SSyncAgainst getSyncAgainstProtocol(Gang selfFaction, Gang opponentFaction, long world) {
/*  992 */     FactionCompetition xFCSelf = Faction_competition.select(Long.valueOf(selfFaction.getGangId()));
/*  993 */     FactionCompetition xFCOpponent = Faction_competition.select(Long.valueOf(opponentFaction.getGangId()));
/*      */     
/*  995 */     int selfNumber = 0;
/*  996 */     int opponentNumber = 0;
/*      */     
/*  998 */     List<Long> roles = MapInterface.getRoleList(world);
/*      */     
/* 1000 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 1001 */       if (selfFaction.isInGang(r)) {
/* 1002 */         selfNumber++;
/*      */       }
/*      */       else {
/* 1005 */         opponentNumber++;
/*      */       }
/*      */     }
/*      */     
/* 1009 */     SSyncAgainst syncAgainst = new SSyncAgainst();
/* 1010 */     fillCompeteFactionBean(selfFaction.getGangId(), xFCSelf, selfNumber, syncAgainst.self_faction);
/* 1011 */     syncAgainst.self_name = selfFaction.getName();
/* 1012 */     fillCompeteFactionBean(opponentFaction.getGangId(), xFCOpponent, opponentNumber, syncAgainst.opponent_faction);
/* 1013 */     syncAgainst.opponent_name = opponentFaction.getName();
/*      */     
/* 1015 */     return syncAgainst;
/*      */   }
/*      */   
/*      */ 
/*      */   static void fillCompeteFactionBean(long factionid, FactionCompetition xFC, FactionCompetitionTmp xFCTmp, CompeteFaction factionBean)
/*      */   {
/* 1021 */     int playerNumber = 0;
/* 1022 */     if (xFCTmp != null) {
/* 1023 */       playerNumber = xFCTmp.getPlayer_num();
/*      */     }
/* 1025 */     fillCompeteFactionBean(factionid, xFC, playerNumber, factionBean);
/*      */   }
/*      */   
/*      */   static void fillCompeteFactionBean(long factionid, FactionCompetition xFCompetiton, int playerNumber, CompeteFaction factionBean)
/*      */   {
/* 1030 */     factionBean.factionid = factionid;
/* 1031 */     factionBean.pk_score = xFCompetiton.getPk_score();
/* 1032 */     factionBean.player_score = xFCompetiton.getPlayer_score();
/* 1033 */     factionBean.player_number = playerNumber;
/* 1034 */     factionBean.mercenary_score = xFCompetiton.getMercenary_score();
/*      */   }
/*      */   
/*      */ 
/*      */   static void broadcastSyncCompete(long factionid1, FactionCompetition xFC1, FactionCompetitionTmp xFCTmp1, long factionid2, FactionCompetition xFC2, FactionCompetitionTmp xFCTmp2, long worldid)
/*      */   {
/* 1040 */     SSyncCompeteBrd brd = new SSyncCompeteBrd();
/* 1041 */     fillCompeteFactionBean(factionid1, xFC1, xFCTmp1, brd.faction1);
/* 1042 */     fillCompeteFactionBean(factionid2, xFC2, xFCTmp2, brd.faction2);
/* 1043 */     MapInterface.brocadCastInWorld(worldid, brd, true);
/*      */   }
/*      */   
/*      */   static void broadcastSyncCompete(long factionid1, long factionid2, long world)
/*      */   {
/* 1048 */     Gang faction1 = GangInterface.getGang(factionid1, false);
/*      */     
/* 1050 */     List<Long> roles = MapInterface.getRoleList(world);
/* 1051 */     int playerNumber1 = 0;
/* 1052 */     int playerNumber2 = 0;
/*      */     
/* 1054 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 1055 */       if (faction1.isInGang(r)) {
/* 1056 */         playerNumber1++;
/*      */       }
/*      */       else {
/* 1059 */         playerNumber2++;
/*      */       }
/*      */     }
/*      */     
/* 1063 */     FactionCompetition xFC1 = Faction_competition.select(Long.valueOf(factionid1));
/* 1064 */     FactionCompetition xFC2 = Faction_competition.select(Long.valueOf(factionid2));
/*      */     
/* 1066 */     SSyncCompeteBrd brd = new SSyncCompeteBrd();
/* 1067 */     fillCompeteFactionBean(factionid1, xFC1, playerNumber1, brd.faction1);
/* 1068 */     fillCompeteFactionBean(factionid2, xFC2, playerNumber2, brd.faction2);
/*      */     
/* 1070 */     OnlineManager.getInstance().sendMulti(brd, roles);
/*      */   }
/*      */   
/*      */   static void asyncBroadcastSyncCompete(long factionid1, long factionid2, final long world)
/*      */   {
/* 1075 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*      */     {
/*      */       protected boolean processImp() throws Exception
/*      */       {
/* 1079 */         CompetitionManager.broadcastSyncCompete(this.val$factionid1, world, this.val$world);
/*      */         
/* 1081 */         return true;
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */ 
/*      */   static void broadcastCompeteWhenEnterFightMap(List<Long> roles, Gang faction, long world)
/*      */   {
/* 1089 */     FactionCompetition xFCSelf = Faction_competition.select(Long.valueOf(faction.getGangId()));
/* 1090 */     FactionCompetition xFCOpponent = Faction_competition.select(Long.valueOf(xFCSelf.getOpponent()));
/*      */     
/* 1092 */     Gang opponentFaction = GangInterface.getGang(xFCSelf.getOpponent(), false);
/*      */     
/* 1094 */     int selfNumber = 0;
/* 1095 */     int opponentNumber = 0;
/*      */     
/* 1097 */     List<Long> allRoles = MapInterface.getRoleList(world);
/*      */     
/* 1099 */     for (Iterator i$ = allRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 1100 */       if (faction.isInGang(r)) {
/* 1101 */         selfNumber++;
/*      */       }
/*      */       else {
/* 1104 */         opponentNumber++;
/*      */       }
/*      */     }
/*      */     
/* 1108 */     if (logger.isDebugEnabled()) {
/* 1109 */       StringBuilder sb = new StringBuilder();
/* 1110 */       sb.append("帮派竞赛进入战场同步：进入玩家  ").append(roles).append(", 帮派：").append(faction.getName());
/* 1111 */       sb.append("(").append(faction.getGangId()).append("), 人数").append(selfNumber);
/* 1112 */       sb.append("； 敌方帮派：").append(opponentFaction.getName()).append("(").append(opponentFaction.getGangId());
/* 1113 */       sb.append("), 人数").append(opponentNumber);
/* 1114 */       logger.debug(sb.toString());
/*      */     }
/*      */     
/* 1117 */     SSyncAgainst sync = new SSyncAgainst();
/* 1118 */     fillCompeteFactionBean(faction.getGangId(), xFCSelf, selfNumber, sync.self_faction);
/* 1119 */     sync.self_name = faction.getName();
/* 1120 */     fillCompeteFactionBean(opponentFaction.getGangId(), xFCOpponent, opponentNumber, sync.opponent_faction);
/* 1121 */     sync.opponent_name = opponentFaction.getName();
/*      */     
/*      */ 
/* 1124 */     OnlineManager.getInstance().sendMulti(sync, roles);
/*      */     
/*      */ 
/* 1127 */     SSyncCompeteBrd brd = new SSyncCompeteBrd();
/* 1128 */     fillCompeteFactionBean(faction.getGangId(), xFCSelf, selfNumber, brd.faction1);
/* 1129 */     fillCompeteFactionBean(opponentFaction.getGangId(), xFCOpponent, opponentNumber, brd.faction2);
/*      */     
/* 1131 */     allRoles.removeAll(roles);
/* 1132 */     OnlineManager.getInstance().sendMulti(brd, allRoles);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void setFactionTitle(long roleid, Gang faction)
/*      */   {
/* 1142 */     SCompetitionTitle title = new SCompetitionTitle();
/* 1143 */     title.faction_id = faction.getGangId();
/* 1144 */     title.faction_name = faction.getName();
/* 1145 */     title.faction_duty = faction.getGangDuty(roleid);
/* 1146 */     title.display_type = faction.getGangTitleid();
/* 1147 */     MapInterface.setModelProtocol(roleid, title);
/*      */   }
/*      */   
/*      */   static void unsetFactionTitle(long roleid)
/*      */   {
/* 1152 */     MapInterface.unSetModelProtocol(roleid, 12598536);
/*      */   }
/*      */   
/*      */   static long createFightWorld()
/*      */   {
/* 1157 */     long world = createWorld(SCompetitionConsts.getInstance().FightMap);
/*      */     
/*      */ 
/* 1160 */     MapInterface.registerMonsterFightHandler(world, CompetitionMonsterFightHandler.instance);
/*      */     
/* 1162 */     return world;
/*      */   }
/*      */   
/*      */   static long createWorld(int map) {
/* 1166 */     return createWorld(Arrays.asList(new Integer[] { Integer.valueOf(map) }));
/*      */   }
/*      */   
/*      */   static long createWorld(Collection<Integer> maps) {
/* 1170 */     long world = MapInterface.createWorld(maps);
/*      */     
/* 1172 */     TeamInterface.registerJoinTeam(world, CompetitionTeamHandler.getInstance());
/* 1173 */     TeamInterface.registerActivityTeam(world, CompetitionTeamHandler.getInstance());
/*      */     
/* 1175 */     return world;
/*      */   }
/*      */   
/*      */ 
/*      */   static void destroyWorld(long world)
/*      */   {
/* 1181 */     TeamInterface.unRegisterJoinTeam(world);
/* 1182 */     TeamInterface.unRegisterActivityTeam(world);
/*      */     
/*      */ 
/* 1185 */     MapInterface.unregisterMonsterFightHandler(world, CompetitionMonsterFightHandler.instance);
/*      */     
/* 1187 */     MapInterface.destroyWorld(world);
/*      */   }
/*      */   
/*      */   static void broadcastWinLose(long winFactionid, long loseFactionid, Gang winFaction, Gang loseFaction, int reason)
/*      */   {
/* 1192 */     SWinLoseBrd brd = new SWinLoseBrd();
/* 1193 */     brd.winner_id = winFactionid;
/* 1194 */     brd.loser_id = loseFactionid;
/* 1195 */     if (winFaction != null) {
/* 1196 */       brd.winner_name = winFaction.getName();
/*      */     }
/* 1198 */     if (loseFaction != null) {
/* 1199 */       brd.loser_name = loseFaction.getName();
/*      */     }
/* 1201 */     brd.result = reason;
/* 1202 */     if (winFaction != null) {
/* 1203 */       winFaction.brocadcast(brd);
/*      */     }
/* 1205 */     if (loseFaction != null) {
/* 1206 */       loseFaction.brocadcast(brd);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<MatchObj> getSortedMatchFactions()
/*      */   {
/* 1217 */     logger.info("CompetitionManager.getSortedMatchFactions@begin match");
/* 1218 */     Set<Long> factions = GangInterface.getAllGangIdSet();
/*      */     
/* 1220 */     if (logger.isDebugEnabled()) {
/* 1221 */       logDebug("CompetitionManager.getSortedMatchFactions@match|factions=%s", new Object[] { factions });
/*      */     }
/*      */     
/* 1224 */     List<MatchObj> matchObjs = new ArrayList();
/*      */     
/* 1226 */     long nowMillis = DateTimeUtils.getCurrTimeInMillis();
/* 1227 */     int needRoleLevel = ActivityInterface.getActivityLevelMin(SCompetitionConsts.getInstance().Activityid);
/* 1228 */     for (Iterator i$ = factions.iterator(); i$.hasNext();) { long f = ((Long)i$.next()).longValue();
/*      */       
/* 1230 */       Gang faction = GangInterface.getGang(f, false);
/* 1231 */       if ((faction != null) && 
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1236 */         (faction.getLevel() >= SCompetitionConsts.getInstance().Scale))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1241 */         if (!simplified.get())
/*      */         {
/* 1243 */           if ((nowMillis - faction.getCreateTime() > SCompetitionConsts.getInstance().CreateDays * 86400000) && 
/*      */           
/*      */ 
/*      */ 
/*      */ 
/* 1248 */             (faction.getMemberSize() >= SCompetitionConsts.getInstance().MemberNumber) && 
/*      */             
/*      */ 
/*      */ 
/* 1252 */             (faction.getVitality() >= SCompetitionConsts.getInstance().Liveness))
/*      */           {
/*      */ 
/*      */ 
/* 1256 */             int qualifiedRoleNumber = 0;
/* 1257 */             for (Iterator i$ = faction.getMemberList().iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 1258 */               int level = RoleInterface.getLevel(r);
/* 1259 */               if (level >= needRoleLevel) {
/* 1260 */                 qualifiedRoleNumber++;
/*      */               }
/*      */             }
/* 1263 */             if (qualifiedRoleNumber < SCompetitionConsts.getInstance().PlayerNumberOfQualifiedLevel) {}
/*      */ 
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*      */         }
/* 1270 */         else if (faction.isNormalState())
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/* 1275 */           int rank = 0;
/*      */           
/* 1277 */           FactionCompetition xFactionCompetition = Faction_competition.select(Long.valueOf(f));
/* 1278 */           if (xFactionCompetition != null) {
/* 1279 */             rank = xFactionCompetition.getElo_rank();
/*      */           }
/* 1281 */           MatchObj obj = new MatchObj(f, rank, faction.getLevel());
/* 1282 */           matchObjs.add(obj);
/*      */         }
/*      */       }
/*      */     }
/* 1286 */     Collections.sort(matchObjs);
/*      */     
/* 1288 */     return matchObjs;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getSortedMatchFactionsByActiveness(List<MatchObjByActiveness> matchObjs)
/*      */   {
/* 1298 */     logger.info("CompetitionManager.getSortedMatchFactions@begin match");
/*      */     
/* 1300 */     Set<Long> factions = GangInterface.getAllGangIdSet();
/*      */     
/* 1302 */     xbean.Competition xCompetition = getXCompetition(false);
/*      */     
/* 1304 */     if (logger.isDebugEnabled()) {
/* 1305 */       logDebug("CompetitionManager.getSortedMatchFactions@match|factions=%s", new Object[] { factions });
/*      */     }
/*      */     
/* 1308 */     long nowMillis = DateTimeUtils.getCurrTimeInMillis();
/* 1309 */     int needRoleLevel = ActivityInterface.getActivityLevelMin(SCompetitionConsts.getInstance().Activityid);
/* 1310 */     for (Iterator i$ = factions.iterator(); i$.hasNext();) { long f = ((Long)i$.next()).longValue();
/*      */       
/* 1312 */       Gang faction = GangInterface.getGang(f, false);
/* 1313 */       if ((faction != null) && 
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1318 */         (faction.getLevel() >= SCompetitionConsts.getInstance().Scale))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1323 */         if (!simplified.get())
/*      */         {
/* 1325 */           if ((nowMillis - faction.getCreateTime() > SCompetitionConsts.getInstance().CreateDays * 86400000) && 
/*      */           
/*      */ 
/*      */ 
/*      */ 
/* 1330 */             (faction.getMemberSize() >= SCompetitionConsts.getInstance().MemberNumber) && 
/*      */             
/*      */ 
/*      */ 
/* 1334 */             (faction.getVitality() >= SCompetitionConsts.getInstance().Liveness))
/*      */           {
/*      */ 
/*      */ 
/* 1338 */             int qualifiedRoleNumber = 0;
/* 1339 */             for (Iterator i$ = faction.getMemberList().iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 1340 */               int level = RoleInterface.getLevel(r);
/* 1341 */               if (level >= needRoleLevel) {
/* 1342 */                 qualifiedRoleNumber++;
/*      */               }
/*      */             }
/* 1345 */             if (qualifiedRoleNumber < SCompetitionConsts.getInstance().PlayerNumberOfQualifiedLevel) {}
/*      */ 
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*      */         }
/* 1352 */         else if (faction.isNormalState())
/*      */         {
/*      */ 
/*      */ 
/* 1356 */           int activeNumber = 0;
/* 1357 */           int winTimes = 0;
/* 1358 */           int loseTimes = 0;
/*      */           
/* 1360 */           FactionCompetition xFactionCompetition = Faction_competition.select(Long.valueOf(f));
/* 1361 */           if (xFactionCompetition != null) {
/* 1362 */             activeNumber = Math.max(xFactionCompetition.getActive_number(), xFactionCompetition.getLast_active_number());
/* 1363 */             winTimes = xFactionCompetition.getWin_times();
/* 1364 */             loseTimes = xFactionCompetition.getLose_times();
/*      */           }
/*      */           
/* 1367 */           int activeness = CompetitionConfigManager.getInstance().getActiveness(activeNumber, winTimes, loseTimes);
/* 1368 */           MatchObjByActiveness obj = new MatchObjByActiveness(f, activeNumber, activeness, faction.getDisplayid());
/*      */           
/* 1370 */           matchObjs.add(obj);
/*      */         }
/*      */       }
/*      */     }
/* 1374 */     Collections.sort(matchObjs);
/*      */     
/* 1376 */     long missTurnFactionid = -1L;
/*      */     
/* 1378 */     if ((!matchObjs.isEmpty()) && (matchObjs.size() % 2 != 0)) {
/* 1379 */       int missTurnTimes = -1;
/* 1380 */       int index = -1;
/* 1381 */       for (int i = matchObjs.size() - 1; i >= 0; i--) {
/* 1382 */         MatchObjByActiveness obj = (MatchObjByActiveness)matchObjs.get(i);
/* 1383 */         long factionid = obj.getFactionid();
/* 1384 */         int times = getMissTurnTimes(xCompetition, factionid);
/* 1385 */         if (times == 0) {
/* 1386 */           missTurnTimes = times;
/* 1387 */           index = i;
/* 1388 */           break;
/*      */         }
/*      */         
/* 1391 */         if (missTurnTimes < 0) {
/* 1392 */           missTurnTimes = times;
/* 1393 */           index = i;
/*      */ 
/*      */         }
/* 1396 */         else if (times < missTurnTimes) {
/* 1397 */           missTurnTimes = times;
/* 1398 */           index = i;
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1405 */       MatchObjByActiveness missTurnObj = (MatchObjByActiveness)matchObjs.remove(index);
/* 1406 */       missTurnFactionid = missTurnObj.getFactionid();
/* 1407 */       logInfo("CompetitionManager.getSortedMatchFactionsByActiveness@miss turn|factionid=%d|active_number=%d|activeness=%d|displayid=%d", new Object[] { Long.valueOf(missTurnObj.getFactionid()), Integer.valueOf(missTurnObj.activeNumber), Integer.valueOf(missTurnObj.activeness), Long.valueOf(missTurnObj.displayid) });
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1413 */     return missTurnFactionid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static int getMissTurnTimes(xbean.Competition xCompetition, long factionid)
/*      */   {
/* 1424 */     MissTurn xMissTurn = (MissTurn)xCompetition.getMiss_turns().get(Long.valueOf(factionid));
/* 1425 */     if (xMissTurn == null) {
/* 1426 */       return 0;
/*      */     }
/* 1428 */     return xMissTurn.getTimes();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void match(xbean.Competition xCompetition, List<MatchObj> sortedMatchObjs)
/*      */   {
/* 1435 */     xCompetition.setMatchtimes(xCompetition.getMatchtimes() + 1);
/*      */     
/*      */ 
/* 1438 */     while (!sortedMatchObjs.isEmpty()) {
/* 1439 */       Iterator<MatchObj> objIter = sortedMatchObjs.iterator();
/* 1440 */       MatchObj obj = (MatchObj)objIter.next();
/* 1441 */       objIter.remove();
/* 1442 */       int alternativeIndex = -1;
/* 1443 */       int alternativeTimes = -1;
/* 1444 */       int i = 0;
/* 1445 */       while (objIter.hasNext()) {
/* 1446 */         MatchObj opponentObj = (MatchObj)objIter.next();
/* 1447 */         CompetitionMatch xMatch = getXMatch(obj.getFactionid(), opponentObj.getFactionid());
/* 1448 */         Integer times = (Integer)xCompetition.getMatch2times().get(xMatch);
/* 1449 */         if (times == null) {
/* 1450 */           alternativeIndex = i;
/* 1451 */           break;
/*      */         }
/*      */         
/* 1454 */         if (alternativeTimes < 0) {
/* 1455 */           alternativeIndex = i;
/* 1456 */           alternativeTimes = times.intValue();
/*      */ 
/*      */         }
/* 1459 */         else if (times.intValue() < alternativeTimes) {
/* 1460 */           alternativeIndex = i;
/* 1461 */           alternativeTimes = times.intValue();
/*      */         }
/*      */         
/*      */ 
/* 1465 */         i++;
/*      */       }
/*      */       
/* 1468 */       if (alternativeIndex >= 0) {
/* 1469 */         MatchObj opponentObj = (MatchObj)sortedMatchObjs.remove(alternativeIndex);
/* 1470 */         CompetitionMatch xMatch = getXMatch(obj.getFactionid(), opponentObj.getFactionid());
/* 1471 */         CompetitionAgainst xAgainst = Pod.newCompetitionAgainst();
/* 1472 */         xCompetition.getAgainsts().put(xMatch, xAgainst);
/*      */         
/* 1474 */         Integer times = (Integer)xCompetition.getMatch2times().get(xMatch);
/* 1475 */         if (times == null) {
/* 1476 */           times = new Integer(1);
/*      */         }
/*      */         else {
/* 1479 */           times = Integer.valueOf(times.intValue() + 1);
/*      */         }
/* 1481 */         xCompetition.getMatch2times().put(xMatch, Integer.valueOf(times.intValue()));
/*      */         
/* 1483 */         logger.info(String.format("CompetitionManager.match@match|faction1=%d|faction2=%d|match_times=%d", new Object[] { Long.valueOf(obj.getFactionid()), Long.valueOf(opponentObj.getFactionid()), Integer.valueOf(times.intValue()) }));
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1491 */         NoneRealTimeTaskManager.getInstance().addTask(new PMailNotifyAgainst(obj.getFactionid(), opponentObj.getFactionid(), times.intValue()));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void matchByActiveness(xbean.Competition xCompetition, List<MatchObjByActiveness> sortedMatchObjs)
/*      */   {
/* 1500 */     xCompetition.setMatchtimes(xCompetition.getMatchtimes() + 1);
/*      */     
/*      */ 
/* 1503 */     while (!sortedMatchObjs.isEmpty()) {
/* 1504 */       Iterator<MatchObjByActiveness> objIter = sortedMatchObjs.iterator();
/* 1505 */       MatchObjByActiveness obj = (MatchObjByActiveness)objIter.next();
/* 1506 */       objIter.remove();
/* 1507 */       int alternativeIndex = -1;
/* 1508 */       int alternativeTimes = -1;
/* 1509 */       int i = 0;
/* 1510 */       while (objIter.hasNext()) {
/* 1511 */         MatchObjByActiveness opponentObj = (MatchObjByActiveness)objIter.next();
/* 1512 */         CompetitionMatch xMatch = getXMatch(obj.getFactionid(), opponentObj.getFactionid());
/* 1513 */         Integer times = (Integer)xCompetition.getMatch2times().get(xMatch);
/* 1514 */         if (times == null) {
/* 1515 */           alternativeIndex = i;
/* 1516 */           break;
/*      */         }
/*      */         
/* 1519 */         if (alternativeTimes < 0) {
/* 1520 */           alternativeIndex = i;
/* 1521 */           alternativeTimes = times.intValue();
/*      */ 
/*      */         }
/* 1524 */         else if (times.intValue() < alternativeTimes) {
/* 1525 */           alternativeIndex = i;
/* 1526 */           alternativeTimes = times.intValue();
/*      */         }
/*      */         
/*      */ 
/* 1530 */         i++;
/*      */       }
/*      */       
/* 1533 */       if (alternativeIndex >= 0) {
/* 1534 */         MatchObjByActiveness opponentObj = (MatchObjByActiveness)sortedMatchObjs.remove(alternativeIndex);
/* 1535 */         CompetitionMatch xMatch = getXMatch(obj.getFactionid(), opponentObj.getFactionid());
/* 1536 */         CompetitionAgainst xAgainst = Pod.newCompetitionAgainst();
/* 1537 */         xCompetition.getAgainsts().put(xMatch, xAgainst);
/*      */         
/* 1539 */         Integer times = (Integer)xCompetition.getMatch2times().get(xMatch);
/* 1540 */         if (times == null) {
/* 1541 */           times = new Integer(1);
/*      */         }
/*      */         else {
/* 1544 */           times = Integer.valueOf(times.intValue() + 1);
/*      */         }
/* 1546 */         xCompetition.getMatch2times().put(xMatch, Integer.valueOf(times.intValue()));
/*      */         
/* 1548 */         logger.info(String.format("CompetitionManager.match@match|factionid1=%d|faction_displayid1=%d|factionid2=%d|faction_displayid2=%d|match_times=%d", new Object[] { Long.valueOf(obj.getFactionid()), Long.valueOf(obj.getDisplayid()), Long.valueOf(opponentObj.getFactionid()), Long.valueOf(opponentObj.getDisplayid()), Integer.valueOf(times.intValue()) }));
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
/* 1559 */         NoneRealTimeTaskManager.getInstance().addTask(new PMailNotifyAgainst(obj.getFactionid(), opponentObj.getFactionid(), times.intValue()));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static void addFactionPlayer(long factionid, FactionCompetitionTmp xTmp, int addNumber)
/*      */   {
/* 1567 */     if (xTmp == null) {
/* 1568 */       return;
/*      */     }
/* 1570 */     xTmp.setPlayer_num(xTmp.getPlayer_num() + addNumber);
/* 1571 */     broadcastFactionPlayerNumber(factionid, xTmp.getPlayer_num(), xTmp.getWorld());
/*      */     
/* 1573 */     if (xTmp.getPlayer_num() <= 0) {
/* 1574 */       NoneRealTimeTaskManager.getInstance().addTask(new PCheckEndByOneFactionEmpty(factionid));
/*      */     }
/*      */   }
/*      */   
/*      */   static void broadcastFactionPlayerNumber(long factionid, int playerNum, long worldid)
/*      */   {
/* 1580 */     SSyncFactionPlayerNumberBrd sync = new SSyncFactionPlayerNumberBrd();
/* 1581 */     sync.factionid = factionid;
/* 1582 */     sync.player_num = playerNum;
/* 1583 */     MapInterface.brocadCastInWorld(worldid, sync, false);
/*      */   }
/*      */   
/*      */   static void syncFactionPlayerNumber(long roleid, long factionid, FactionCompetitionTmp xFCTmp)
/*      */   {
/* 1588 */     SSyncFactionPlayerNumberBrd brd = getSyncFactionPlayerNumberProtocol(factionid, xFCTmp);
/* 1589 */     OnlineManager.getInstance().send(roleid, brd);
/*      */   }
/*      */   
/*      */   private static SSyncFactionPlayerNumberBrd getSyncFactionPlayerNumberProtocol(long factionid, FactionCompetitionTmp xFCTmp) {
/* 1593 */     int playerNum = 0;
/* 1594 */     if (xFCTmp != null) {
/* 1595 */       playerNum = xFCTmp.getPlayer_num();
/*      */     }
/* 1597 */     return getSyncFactionPlayerNumberProtocol(factionid, playerNum);
/*      */   }
/*      */   
/*      */   private static SSyncFactionPlayerNumberBrd getSyncFactionPlayerNumberProtocol(long factionid, int playerNum)
/*      */   {
/* 1602 */     SSyncFactionPlayerNumberBrd sync = new SSyncFactionPlayerNumberBrd();
/* 1603 */     sync.factionid = factionid;
/* 1604 */     sync.player_num = playerNum;
/* 1605 */     return sync;
/*      */   }
/*      */   
/*      */   static void logWarn(String formatStr, Object... args)
/*      */   {
/* 1610 */     logger.warn(String.format(formatStr, args));
/*      */   }
/*      */   
/*      */   static void logError(String formatStr, Object... args) {
/* 1614 */     logger.error(String.format(formatStr, args));
/*      */   }
/*      */   
/*      */   static void logInfo(String formatStr, Object... args) {
/* 1618 */     logger.info(String.format(formatStr, args));
/*      */   }
/*      */   
/*      */   static void logDebug(String formatStr, Object... args) {
/* 1622 */     logger.debug(String.format(formatStr, args));
/*      */   }
/*      */   
/*      */   static void sendNoAgainstFactionRes(long roleid) {
/* 1626 */     SAgainstFactionRes res = new SAgainstFactionRes();
/* 1627 */     OnlineManager.getInstance().sendAtOnce(roleid, res);
/*      */   }
/*      */   
/*      */   static void addWinTimes(FactionCompetition xFactionCompetition) {
/* 1631 */     if (xFactionCompetition == null) {
/* 1632 */       return;
/*      */     }
/* 1634 */     xFactionCompetition.setWin_times(xFactionCompetition.getWin_times() + 1);
/*      */   }
/*      */   
/*      */   static void addLoseTimes(FactionCompetition xFactionCompetition) {
/* 1638 */     if (xFactionCompetition == null) {
/* 1639 */       return;
/*      */     }
/* 1641 */     xFactionCompetition.setLose_times(xFactionCompetition.getLose_times() + 1);
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean checkRecallMercenary(CompetitionAgainst xAgainst, FactionCompetitionTmp xFCTmp1, FactionCompetitionTmp xFCTmp2, long factionid1, long displayid1, long factionid2, long displayid2, String tlogUserid)
/*      */   {
/* 1647 */     xAgainst.setMercenary_faction(-1L);
/*      */     
/* 1649 */     if ((xFCTmp1 == null) || (xFCTmp2 == null)) {
/* 1650 */       return false;
/*      */     }
/*      */     
/* 1653 */     int count1 = xFCTmp1.getPlayer_num();
/* 1654 */     int count2 = xFCTmp2.getPlayer_num();
/* 1655 */     long world = xFCTmp1.getWorld();
/*      */     
/* 1657 */     int mercenaryCount = CompetitionConfigManager.getInstance().getRecallMercenaryCount(count1, count2);
/*      */     
/*      */ 
/* 1660 */     if (mercenaryCount == 0) {
/* 1661 */       return false;
/*      */     }
/*      */     
/* 1664 */     long selfFactionid = -1L;
/* 1665 */     long opponentFactionid = -1L;
/* 1666 */     long selfDisplayid = -1L;
/* 1667 */     long opponentDisplayid = -1L;
/* 1668 */     int selfCount = 0;
/* 1669 */     int opponentCount = 0;
/*      */     
/* 1671 */     if (mercenaryCount > 0) {
/* 1672 */       selfFactionid = factionid1;
/* 1673 */       opponentFactionid = factionid2;
/* 1674 */       selfDisplayid = displayid1;
/* 1675 */       opponentDisplayid = displayid2;
/* 1676 */       selfCount = count1;
/* 1677 */       opponentCount = count2;
/*      */     }
/*      */     else {
/* 1680 */       selfFactionid = factionid2;
/* 1681 */       opponentFactionid = factionid1;
/* 1682 */       selfDisplayid = displayid2;
/* 1683 */       opponentDisplayid = displayid1;
/* 1684 */       selfCount = count2;
/* 1685 */       opponentCount = count1;
/*      */       
/* 1687 */       mercenaryCount = -mercenaryCount;
/*      */     }
/*      */     
/*      */ 
/* 1691 */     xAgainst.setMercenary_faction(selfFactionid);
/*      */     
/*      */ 
/* 1694 */     recallMercenaryAndTlog(selfFactionid, selfDisplayid, opponentFactionid, opponentDisplayid, selfCount, opponentCount, mercenaryCount, tlogUserid, world);
/*      */     
/*      */ 
/* 1697 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void recallMercenaryAndTlog(long mercenaryFactionid, long mercenaryDisplayid, long opponentFactionid, long opponentDisplayid, int selfCount, int opponentCount, int mercenaryCount, String tlogUserid, long worldid)
/*      */   {
/* 1706 */     ControllerInterface.triggerWorldControllerWithMaxSpawnNum(worldid, SCompetitionMercenaryConsts.getInstance().MercenaryController, mercenaryCount);
/*      */     
/*      */ 
/*      */ 
/* 1710 */     SRecallMercenaryBrd brd = new SRecallMercenaryBrd();
/* 1711 */     brd.mercenary_factionid = mercenaryFactionid;
/* 1712 */     brd.mercenary_count = mercenaryCount;
/* 1713 */     MapInterface.brocadCastInWorld(worldid, brd, false);
/*      */     
/*      */ 
/* 1716 */     TLogManager.getInstance().addLog(tlogUserid, "CompetitionMercenary", new Object[] { Long.valueOf(mercenaryFactionid), Long.valueOf(mercenaryDisplayid), Long.valueOf(opponentFactionid), Long.valueOf(opponentDisplayid), Integer.valueOf(selfCount), Integer.valueOf(opponentCount), Integer.valueOf(mercenaryCount), Long.valueOf(worldid) });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogMercenary(long mercenaryFactionid, long mercenaryDisplayid, long opponentFactionid, long opponentDisplayid, int selfCount, int opponentCount, int mercenaryCount, String tlogUserid, long worldid)
/*      */   {
/* 1724 */     TLogManager.getInstance().addLog(tlogUserid, "CompetitionMercenary", new Object[] { Long.valueOf(mercenaryFactionid), Long.valueOf(mercenaryDisplayid), Long.valueOf(opponentFactionid), Long.valueOf(opponentDisplayid), Integer.valueOf(selfCount), Integer.valueOf(opponentCount), Integer.valueOf(mercenaryCount), Long.valueOf(worldid) });
/*      */   }
/*      */   
/*      */ 
/*      */   static void broadcastMercenaryScore(long mercenaryFactionid, int score, long world)
/*      */   {
/* 1730 */     SSyncMercenaryScoreBrd brd = new SSyncMercenaryScoreBrd();
/* 1731 */     brd.mercenary_factionid = mercenaryFactionid;
/* 1732 */     brd.mercenary_score = score;
/*      */     
/* 1734 */     MapInterface.brocadCastInWorld(world, brd, false);
/*      */   }
/*      */   
/*      */   static MercenaryFights getXMercenaryFightsIfNotExist(CompetitionTmp xCompetitionTmp, long factionid1, long factionid2)
/*      */   {
/* 1739 */     if (xCompetitionTmp == null) {
/* 1740 */       return null;
/*      */     }
/*      */     
/* 1743 */     CompetitionMatch cMatch = getXMatch(factionid1, factionid2);
/* 1744 */     return getXMercenaryFightsIfNotExist(xCompetitionTmp, cMatch);
/*      */   }
/*      */   
/*      */   private static MercenaryFights getXMercenaryFightsIfNotExist(CompetitionTmp xCompetitionTmp, CompetitionMatch cMatch)
/*      */   {
/* 1749 */     MercenaryFights xFights = (MercenaryFights)xCompetitionTmp.getMercenary_fights().get(cMatch);
/* 1750 */     if (xFights == null) {
/* 1751 */       xFights = Pod.newMercenaryFights();
/* 1752 */       xCompetitionTmp.getMercenary_fights().put(cMatch, xFights);
/*      */     }
/* 1754 */     return xFights;
/*      */   }
/*      */   
/*      */   static MercenaryFights getXMercenaryFights(CompetitionTmp xCompetitionTmp, long factionid1, long factionid2)
/*      */   {
/* 1759 */     CompetitionMatch cMatch = getXMatch(factionid1, factionid2);
/* 1760 */     return getXMercenaryFights(xCompetitionTmp, cMatch);
/*      */   }
/*      */   
/*      */   private static MercenaryFights getXMercenaryFights(CompetitionTmp xCompetitionTmp, CompetitionMatch cMatch)
/*      */   {
/* 1765 */     return (MercenaryFights)xCompetitionTmp.getMercenary_fights().get(cMatch);
/*      */   }
/*      */   
/*      */   static void addMissTurnTimes(xbean.Competition xCompetition, long factionid) {
/* 1769 */     MissTurn xMissTurn = (MissTurn)xCompetition.getMiss_turns().get(Long.valueOf(factionid));
/* 1770 */     if (xMissTurn == null) {
/* 1771 */       xMissTurn = Pod.newMissTurn();
/* 1772 */       xMissTurn.setTimes(1);
/* 1773 */       xCompetition.getMiss_turns().put(Long.valueOf(factionid), xMissTurn);
/*      */     }
/*      */     else {
/* 1776 */       xMissTurn.setTimes(xMissTurn.getTimes() + 1);
/*      */     }
/*      */   }
/*      */   
/*      */   static void saveParticipateRoles(FactionCompetition xFaction, Collection<Long> roles) {
/* 1781 */     if ((xFaction == null) || (roles == null)) {
/* 1782 */       return;
/*      */     }
/*      */     
/* 1785 */     xFaction.getParticipate_roles().clear();
/* 1786 */     xFaction.getParticipate_roles().addAll(roles);
/* 1787 */     int count = roles.size();
/* 1788 */     xFaction.setLast_partcipate_count(xFaction.getPaticipate_count());
/* 1789 */     xFaction.setPaticipate_count(count);
/*      */   }
/*      */   
/*      */   static void triggerResultEvent(long factionid1, FactionCompetition xFaction1, long factionid2, FactionCompetition xFaction2, int result)
/*      */   {
/* 1794 */     List<Long> members1 = new ArrayList();
/* 1795 */     if (xFaction1 != null) {
/* 1796 */       members1.addAll(xFaction1.getParticipate_roles());
/*      */     }
/* 1798 */     List<Long> members2 = new ArrayList();
/* 1799 */     if (xFaction2 != null) {
/* 1800 */       members2.addAll(xFaction2.getParticipate_roles());
/*      */     }
/* 1802 */     CompetitionResultArg arg = new CompetitionResultArg(factionid1, members1, factionid2, members2, result);
/*      */     
/* 1804 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.competition.event.CompetitionResult(), arg);
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\CompetitionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */