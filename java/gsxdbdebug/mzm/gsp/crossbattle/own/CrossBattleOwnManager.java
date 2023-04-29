/*      */ package mzm.gsp.crossbattle.own;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.activity.confbean.SActivityCfg;
/*      */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*      */ import mzm.gsp.activity.main.ActivityInterface;
/*      */ import mzm.gsp.common.TimeCommonUtil;
/*      */ import mzm.gsp.common.confbean.STimePointCommonCfg;
/*      */ import mzm.gsp.corps.main.CorpsInfo;
/*      */ import mzm.gsp.corps.main.CorpsInterface;
/*      */ import mzm.gsp.crossbattle.CorpsBriefInfo;
/*      */ import mzm.gsp.crossbattle.CrossBattleVoteRankData;
/*      */ import mzm.gsp.crossbattle.CrossBattleVoteRoundRobinPointRankData;
/*      */ import mzm.gsp.crossbattle.SRoundRobinTitle;
/*      */ import mzm.gsp.crossbattle.SSynCrossBattleRoundRobinIdipRestartInfo;
/*      */ import mzm.gsp.crossbattle.SSynRoundRobinResultInCrossBattle;
/*      */ import mzm.gsp.crossbattle.SSynRoundRobinRoundFightResultInCrossBattle;
/*      */ import mzm.gsp.crossbattle.SSynRoundRobinRoundInfoInCrossBattle;
/*      */ import mzm.gsp.crossbattle.SSynVoteStageResultInCrossBattle;
/*      */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*      */ import mzm.gsp.crossbattle.confbean.SCrossBattleStageDurationCfg;
/*      */ import mzm.gsp.crossbattle.event.RoundRobinFightEnd;
/*      */ import mzm.gsp.crossbattle.event.RoundRobinFightEndArg;
/*      */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*      */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*      */ import mzm.gsp.fight.main.FightInterface;
/*      */ import mzm.gsp.mail.main.MailInterface;
/*      */ import mzm.gsp.map.main.MapInterface;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.server.main.ServerInterface;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.AttendCorpsInfo;
/*      */ import xbean.CrossBattleOwn;
/*      */ import xbean.Pod;
/*      */ import xbean.RoundRobinRoundInfo;
/*      */ import xtable.Cross_battle_owns;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class CrossBattleOwnManager
/*      */ {
/*   63 */   static final Logger logger = Logger.getLogger("crossbattle_own");
/*   64 */   static volatile boolean postInitFlag = false;
/*      */   
/*      */   private static final float ERROR = 1.0E-8F;
/*      */   private static final long GRC_RETRY_INTERVAL = 60L;
/*   68 */   private static int PROTECT_DURATION_IN_MINUTE = 10;
/*   69 */   private static int RESTART_LEVEL_NORMAL_END = 1;
/*   70 */   private static int RESTART_LEVEL_ALL_ABSTAIN = 2;
/*   71 */   private static int RESTART_LEVEL_EXCEPTION_END = 4;
/*      */   
/*      */   static void postInit()
/*      */   {
/*   75 */     postInitFlag = true;
/*   76 */     for (Iterator i$ = SCrossBattleOwnCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*      */       
/*   78 */       CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PTryReportCrossBattleOwnResult(activityCfgid));
/*      */     }
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
/*      */   static List<Long> getAllCrossBattleOwnPromotionCorpsids(int activityCfgid, boolean remainLock)
/*      */   {
/*   95 */     List<Long> corpsids = new ArrayList();
/*   96 */     CrossBattleOwn xCrossBattleOwn = null;
/*   97 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/*   98 */     if (!remainLock)
/*      */     {
/*  100 */       xCrossBattleOwn = Cross_battle_owns.select(Long.valueOf(globalActivityCfgid));
/*      */     }
/*      */     else
/*      */     {
/*  104 */       xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/*      */     }
/*  106 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() == -1))
/*      */     {
/*  108 */       return corpsids;
/*      */     }
/*  110 */     corpsids.addAll(xCrossBattleOwn.getRound_robin_stage_promotion_corps_list());
/*  111 */     return corpsids;
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
/*      */   static boolean isCorpsPromotionInCrossBattleOwn(long corpsid, int activityCfgid, boolean remainLock)
/*      */   {
/*  128 */     CrossBattleOwn xCrossBattleOwn = null;
/*  129 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/*  130 */     if (!remainLock)
/*      */     {
/*  132 */       xCrossBattleOwn = Cross_battle_owns.select(Long.valueOf(globalActivityCfgid));
/*      */     }
/*      */     else
/*      */     {
/*  136 */       xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/*      */     }
/*  138 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() == -1))
/*      */     {
/*  140 */       return false;
/*      */     }
/*  142 */     if (!xCrossBattleOwn.getRound_robin_stage_promotion_corps_list().contains(Long.valueOf(corpsid)))
/*      */     {
/*  144 */       return false;
/*      */     }
/*  146 */     return true;
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
/*      */   static List<Long> getCrossBattleRegisterRoleList(long corpsid, int activityCfgid, boolean remainLock)
/*      */   {
/*  163 */     CrossBattleOwn xCrossBattleOwn = null;
/*  164 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/*  165 */     if (!remainLock)
/*      */     {
/*  167 */       xCrossBattleOwn = Cross_battle_owns.select(Long.valueOf(globalActivityCfgid));
/*      */     }
/*      */     else
/*      */     {
/*  171 */       xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/*      */     }
/*  173 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() == -1))
/*      */     {
/*  175 */       return null;
/*      */     }
/*  177 */     AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsid));
/*  178 */     if (xAttendCorpsInfo == null)
/*      */     {
/*  180 */       return null;
/*      */     }
/*  182 */     return new ArrayList(xAttendCorpsInfo.getMembers());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isCrossBattleActivitySwitchOpen(int activityCfgid)
/*      */   {
/*  193 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(activityCfgid);
/*  194 */     if (cfg == null)
/*      */     {
/*  196 */       return false;
/*      */     }
/*  198 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*      */     {
/*  200 */       return false;
/*      */     }
/*  202 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isCrossBattleRegisterStageSwitchOpen(int activityCfgid)
/*      */   {
/*  213 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(activityCfgid);
/*  214 */     if (cfg == null)
/*      */     {
/*  216 */       return false;
/*      */     }
/*  218 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*      */     {
/*  220 */       return false;
/*      */     }
/*  222 */     if (!OpenInterface.getOpenStatus(cfg.register_stage_moduleid))
/*      */     {
/*  224 */       return false;
/*      */     }
/*  226 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isCrossBattleVoteStageSwitchOpen(int activityCfgid)
/*      */   {
/*  237 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(activityCfgid);
/*  238 */     if (cfg == null)
/*      */     {
/*  240 */       return false;
/*      */     }
/*  242 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*      */     {
/*  244 */       return false;
/*      */     }
/*  246 */     if (!OpenInterface.getOpenStatus(cfg.vote_stage_moduleid))
/*      */     {
/*  248 */       return false;
/*      */     }
/*  250 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isCrossBattleRoundRobinStageSwitchOpen(int activityCfgid)
/*      */   {
/*  261 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(activityCfgid);
/*  262 */     if (cfg == null)
/*      */     {
/*  264 */       return false;
/*      */     }
/*  266 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*      */     {
/*  268 */       return false;
/*      */     }
/*  270 */     if (!OpenInterface.getOpenStatus(cfg.round_robin_stage_moduleid))
/*      */     {
/*  272 */       return false;
/*      */     }
/*  274 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isCrossBattleActivitySwitchOpenForRole(long roleid, int activityCfgid)
/*      */   {
/*  286 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(activityCfgid);
/*  287 */     if (cfg == null)
/*      */     {
/*  289 */       return false;
/*      */     }
/*  291 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*      */     {
/*  293 */       return false;
/*      */     }
/*  295 */     if (OpenInterface.isBanPlay(roleid, cfg.moduleid))
/*      */     {
/*  297 */       OpenInterface.sendBanPlayMsg(roleid, cfg.moduleid);
/*  298 */       return false;
/*      */     }
/*  300 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isCrossBattleRegisterStageSwitchOpenForRole(long roleid, int activityCfgid)
/*      */   {
/*  312 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(activityCfgid);
/*  313 */     if (cfg == null)
/*      */     {
/*  315 */       return false;
/*      */     }
/*  317 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*      */     {
/*  319 */       return false;
/*      */     }
/*  321 */     if (!OpenInterface.getOpenStatus(cfg.register_stage_moduleid))
/*      */     {
/*  323 */       return false;
/*      */     }
/*  325 */     if (OpenInterface.isBanPlay(roleid, cfg.moduleid))
/*      */     {
/*  327 */       OpenInterface.sendBanPlayMsg(roleid, cfg.moduleid);
/*  328 */       return false;
/*      */     }
/*  330 */     if (OpenInterface.isBanPlay(roleid, cfg.register_stage_moduleid))
/*      */     {
/*  332 */       OpenInterface.sendBanPlayMsg(roleid, cfg.register_stage_moduleid);
/*  333 */       return false;
/*      */     }
/*  335 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isCrossBattleVoteStageSwitchOpenForRole(long roleid, int activityCfgid)
/*      */   {
/*  347 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(activityCfgid);
/*  348 */     if (cfg == null)
/*      */     {
/*  350 */       return false;
/*      */     }
/*  352 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*      */     {
/*  354 */       return false;
/*      */     }
/*  356 */     if (!OpenInterface.getOpenStatus(cfg.vote_stage_moduleid))
/*      */     {
/*  358 */       return false;
/*      */     }
/*  360 */     if (OpenInterface.isBanPlay(roleid, cfg.moduleid))
/*      */     {
/*  362 */       OpenInterface.sendBanPlayMsg(roleid, cfg.moduleid);
/*  363 */       return false;
/*      */     }
/*  365 */     if (OpenInterface.isBanPlay(roleid, cfg.vote_stage_moduleid))
/*      */     {
/*  367 */       OpenInterface.sendBanPlayMsg(roleid, cfg.vote_stage_moduleid);
/*  368 */       return false;
/*      */     }
/*  370 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isCrossBattleRoundRobinStageSwitchOpenForRole(long roleid, int activityCfgid)
/*      */   {
/*  382 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(activityCfgid);
/*  383 */     if (cfg == null)
/*      */     {
/*  385 */       return false;
/*      */     }
/*  387 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*      */     {
/*  389 */       return false;
/*      */     }
/*  391 */     if (!OpenInterface.getOpenStatus(cfg.round_robin_stage_moduleid))
/*      */     {
/*  393 */       return false;
/*      */     }
/*  395 */     if (OpenInterface.isBanPlay(roleid, cfg.moduleid))
/*      */     {
/*  397 */       OpenInterface.sendBanPlayMsg(roleid, cfg.moduleid);
/*  398 */       return false;
/*      */     }
/*  400 */     if (OpenInterface.isBanPlay(roleid, cfg.round_robin_stage_moduleid))
/*      */     {
/*  402 */       OpenInterface.sendBanPlayMsg(roleid, cfg.round_robin_stage_moduleid);
/*  403 */       return false;
/*      */     }
/*  405 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void OnCrossBattleActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityCfgid)
/*      */   {
/*  417 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(activityCfgid);
/*  418 */     if (cfg == null)
/*      */     {
/*      */ 
/*  421 */       return;
/*      */     }
/*  423 */     if (GameServerInfoManager.isRoamServer())
/*      */     {
/*  425 */       return;
/*      */     }
/*      */     
/*  428 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/*  429 */     CrossBattleOwn xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/*  430 */     if (xCrossBattleOwn == null)
/*      */     {
/*  432 */       xCrossBattleOwn = Pod.newCrossBattleOwn();
/*  433 */       Cross_battle_owns.insert(Long.valueOf(globalActivityCfgid), xCrossBattleOwn);
/*      */     }
/*      */     
/*  436 */     if ((!activityStartType.startAgain()) && (ServerInterface.getCurrentServerLevel() >= cfg.serverlevel))
/*      */     {
/*  438 */       xCrossBattleOwn.setStage(0);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void OnCrossBattleVoteStageStart(boolean startAgain, int activityCfgid)
/*      */   {
/*  451 */     SCrossBattleStageDurationCfg durationCfg = SCrossBattleStageDurationCfg.get(activityCfgid);
/*  452 */     if (durationCfg == null)
/*      */     {
/*      */ 
/*  455 */       return;
/*      */     }
/*  457 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(activityCfgid);
/*  458 */     if (cfg == null)
/*      */     {
/*      */ 
/*  461 */       return;
/*      */     }
/*  463 */     if (GameServerInfoManager.isRoamServer()) {
/*      */       return;
/*      */     }
/*      */     
/*      */     Iterator i$;
/*  468 */     if (!startAgain)
/*      */     {
/*      */ 
/*      */ 
/*  472 */       long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/*  473 */       CrossBattleOwn xSelectCrossBattleOwn = Cross_battle_owns.select(Long.valueOf(globalActivityCfgid));
/*  474 */       if ((xSelectCrossBattleOwn == null) || (xSelectCrossBattleOwn.getStage() == -1))
/*      */       {
/*      */ 
/*  477 */         return;
/*      */       }
/*      */       
/*  480 */       Map<Long, CorpsInfo> corpsInfos = new HashMap();
/*  481 */       for (Iterator i$ = xSelectCrossBattleOwn.getAttend_corps_infos().keySet().iterator(); i$.hasNext();) { long corpsid = ((Long)i$.next()).longValue();
/*      */         
/*  483 */         CorpsInfo corpsInfo = CorpsInterface.getCorpsInfoByCorpsId(corpsid, false);
/*  484 */         if (corpsInfo != null)
/*      */         {
/*      */ 
/*      */ 
/*  488 */           corpsInfos.put(Long.valueOf(corpsid), corpsInfo); }
/*      */       }
/*  490 */       Map<Long, Float> averageFightValues = new HashMap();
/*  491 */       for (CorpsInfo corpsInfo : corpsInfos.values())
/*      */       {
/*  493 */         averageFightValues.put(Long.valueOf(corpsInfo.getCorpsId()), Float.valueOf(corpsInfo.getMultiFightValueAVG()));
/*      */       }
/*      */       
/*      */ 
/*  497 */       CrossBattleOwn xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/*  498 */       if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() == -1))
/*      */       {
/*  500 */         return;
/*      */       }
/*  502 */       if (xCrossBattleOwn.getStage() != 0)
/*      */       {
/*  504 */         logger.error(String.format("[crossbattle_own]CrossBattleOwnManager.OnCrossBattleVoteStageStart@stage error|activity_cfg_id=%d|stage=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(xCrossBattleOwn.getStage()) }));
/*      */         
/*      */ 
/*  507 */         return;
/*      */       }
/*  509 */       xCrossBattleOwn.setStage(1);
/*  510 */       Set<Long> allattendCorpsMembers = new HashSet();
/*  511 */       Set<Long> needRemoveCorpsids = new HashSet();
/*  512 */       long now = DateTimeUtils.getCurrTimeInMillis();
/*  513 */       for (Map.Entry<Long, AttendCorpsInfo> entry : xCrossBattleOwn.getAttend_corps_infos().entrySet())
/*      */       {
/*  515 */         long corpsid = ((Long)entry.getKey()).longValue();
/*  516 */         AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)entry.getValue();
/*  517 */         if ((!corpsInfos.containsKey(Long.valueOf(corpsid))) || (!averageFightValues.containsKey(Long.valueOf(corpsid))))
/*      */         {
/*  519 */           needRemoveCorpsids.add(Long.valueOf(corpsid));
/*  520 */           logger.error(String.format("[crossbattle_own]CrossBattleOwnManager.OnCrossBattleVoteStageStart@no attend corps info|corpsid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(corpsid), Integer.valueOf(activityCfgid) }));
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/*  525 */           xAttendCorpsInfo.setZoneid(((Integer)GameServerInfoManager.getZoneIds().get(0)).intValue());
/*  526 */           xAttendCorpsInfo.getMembers().clear();
/*  527 */           xAttendCorpsInfo.getMembers().add(Long.valueOf(((CorpsInfo)corpsInfos.get(Long.valueOf(corpsid))).getCaptain()));
/*  528 */           xAttendCorpsInfo.getMembers().addAll(((CorpsInfo)corpsInfos.get(Long.valueOf(corpsid))).getNormalMemberIds());
/*  529 */           xAttendCorpsInfo.setVote_num(0);
/*  530 */           xAttendCorpsInfo.setVote_num_timestamp(now);
/*  531 */           xAttendCorpsInfo.setVote_stage_start_average_fight_value(((Float)averageFightValues.get(Long.valueOf(corpsid))).floatValue());
/*  532 */           xAttendCorpsInfo.setName(((CorpsInfo)corpsInfos.get(Long.valueOf(corpsid))).getCorpsName());
/*  533 */           xAttendCorpsInfo.setBadge(((CorpsInfo)corpsInfos.get(Long.valueOf(corpsid))).getCorpsBadgeId());
/*  534 */           allattendCorpsMembers.addAll(((CorpsInfo)corpsInfos.get(Long.valueOf(corpsid))).getAllMemberIds());
/*  535 */           logger.info(String.format("[crossbattle_own]CrossBattleOwnManager.OnCrossBattleVoteStageStart@set attend corps info|corpsid=%d|activity_cfg_id=%d|zoneid=%d|member_list=%s|average_fight_value=%f", new Object[] { Long.valueOf(corpsid), Integer.valueOf(activityCfgid), Integer.valueOf(xAttendCorpsInfo.getZoneid()), xAttendCorpsInfo.getMembers().toString(), Float.valueOf(xAttendCorpsInfo.getVote_stage_start_average_fight_value()) }));
/*      */           
/*      */ 
/*      */ 
/*  539 */           CrossBattleOwnTLogManager.addRegisterRoleListTLog(activityCfgid, corpsid, xAttendCorpsInfo.getMembers());
/*      */         }
/*      */       }
/*  542 */       for (Iterator i$ = needRemoveCorpsids.iterator(); i$.hasNext();) { long corpsid = ((Long)i$.next()).longValue();
/*      */         
/*  544 */         xCrossBattleOwn.getAttend_corps_infos().remove(Long.valueOf(corpsid));
/*      */       }
/*      */       
/*  547 */       if (isCrossBattleVoteStageSwitchOpen(activityCfgid))
/*      */       {
/*  549 */         for (i$ = allattendCorpsMembers.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */           
/*  551 */           MailInterface.asynBuildAndSendMail(roleid, cfg.vote_stage_notice_mail_cfg_id, null, Arrays.asList(new String[] { String.valueOf(durationCfg.voteStageDurationInDay), String.valueOf(cfg.vote_stage_direct_promotion_corps_num + cfg.round_robin_max_corps_num) }), new TLogArg(LogReason.CROSS_BATTLE_OWN_VOTE_STAGE_NOTICE_MAIL, activityCfgid));
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  559 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/*  560 */     CrossBattleOwn xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/*  561 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() == -1))
/*      */     {
/*  563 */       return;
/*      */     }
/*  565 */     for (Map.Entry<Long, AttendCorpsInfo> entry : xCrossBattleOwn.getAttend_corps_infos().entrySet())
/*      */     {
/*  567 */       long corpsid = ((Long)entry.getKey()).longValue();
/*  568 */       AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)entry.getValue();
/*  569 */       VoteStageVoteNumChartManager.getInstance().getChart(activityCfgid).rank(new VoteStageVoteNumChartObj(corpsid, xAttendCorpsInfo.getVote_stage_start_average_fight_value(), xAttendCorpsInfo.getVote_num(), xAttendCorpsInfo.getVote_num_timestamp()));
/*      */       
/*      */ 
/*  572 */       VoteStageAverageFightValueChartManager.getInstance().getChart(activityCfgid).rank(new VoteStageAverageFightValueChartObj(corpsid, xAttendCorpsInfo.getVote_stage_start_average_fight_value(), xAttendCorpsInfo.getVote_num(), xAttendCorpsInfo.getVote_num_timestamp()));
/*      */     }
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
/*      */   static void OnCrossBattleRoundRobinStageStart(boolean startAgain, int activityCfgid)
/*      */   {
/*  588 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(activityCfgid);
/*  589 */     if (cfg == null)
/*      */     {
/*      */ 
/*  592 */       return;
/*      */     }
/*  594 */     if (GameServerInfoManager.isRoamServer())
/*      */     {
/*  596 */       return;
/*      */     }
/*      */     
/*  599 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/*  600 */     CrossBattleOwn xSelectCrossBattleOwn = Cross_battle_owns.select(Long.valueOf(globalActivityCfgid));
/*  601 */     if ((xSelectCrossBattleOwn == null) || (xSelectCrossBattleOwn.getStage() == -1))
/*      */     {
/*  603 */       return;
/*      */     }
/*      */     
/*  606 */     Map<Long, Float> averageFightValues = new HashMap();
/*  607 */     for (Map.Entry<Long, AttendCorpsInfo> entry : xSelectCrossBattleOwn.getAttend_corps_infos().entrySet())
/*      */     {
/*  609 */       averageFightValues.put(entry.getKey(), Float.valueOf(getAverageFightValue(((AttendCorpsInfo)entry.getValue()).getMembers())));
/*      */     }
/*      */     
/*  612 */     CrossBattleOwn xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/*  613 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() == -1))
/*      */     {
/*  615 */       return;
/*      */     }
/*      */     
/*  618 */     if (!startAgain)
/*      */     {
/*  620 */       if (xCrossBattleOwn.getStage() != 1)
/*      */       {
/*  622 */         logger.error(String.format("[crossbattle_own]CrossBattleOwnManager.OnCrossBattleRoundRobinStageStart@stage error|activity_cfg_id=%d|stage=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(xCrossBattleOwn.getStage()) }));
/*      */         
/*      */ 
/*  625 */         return;
/*      */       }
/*  627 */       xCrossBattleOwn.setStage(2);
/*  628 */       List<VoteStageVoteNumChartObj> chartObjs = VoteStageVoteNumChartManager.getInstance().getChart(activityCfgid).getAllChartObjs();
/*      */       
/*  630 */       if (chartObjs.size() == 0)
/*      */       {
/*      */ 
/*  633 */         xCrossBattleOwn.getVote_stage_direct_promotion_corps_list().clear();
/*  634 */         xCrossBattleOwn.getRound_robin_point_rank_list().clear();
/*      */       }
/*  636 */       else if (chartObjs.size() <= cfg.vote_stage_direct_promotion_corps_num + cfg.round_robin_stage_promotion_corps_num)
/*      */       {
/*      */ 
/*  639 */         int rank = 1;
/*  640 */         xCrossBattleOwn.getVote_stage_direct_promotion_corps_list().clear();
/*  641 */         for (VoteStageVoteNumChartObj chartObj : chartObjs)
/*      */         {
/*  643 */           if (!xCrossBattleOwn.getAttend_corps_infos().containsKey(chartObj.getKey()))
/*      */           {
/*  645 */             logger.error(String.format("[crossbattle_own]CrossBattleOwnManager.OnCrossBattleRoundRobinStageStart@no attend corps info|corpsid=%d|activity_cfg_id=%d", new Object[] { chartObj.getKey(), Integer.valueOf(activityCfgid) }));
/*      */ 
/*      */           }
/*      */           else
/*      */           {
/*  650 */             xCrossBattleOwn.getVote_stage_direct_promotion_corps_list().add(chartObj.getKey());
/*  651 */             Iterator i$; if (isCrossBattleRoundRobinStageSwitchOpen(activityCfgid))
/*      */             {
/*  653 */               for (i$ = ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(chartObj.getKey())).getMembers().iterator(); i$.hasNext();) { long memberid = ((Long)i$.next()).longValue();
/*      */                 
/*  655 */                 MailInterface.asynBuildAndSendMail(memberid, cfg.vote_stage_direct_promotion_mail_cfg_id, null, Arrays.asList(new String[] { String.valueOf(chartObj.getVoteNum()), String.valueOf(rank) }), new TLogArg(LogReason.CROSS_BATTLE_OWN_VOTE_STAGE_DIRECT_PROMOTION_MAIL, activityCfgid));
/*      */               }
/*      */             }
/*      */             
/*      */ 
/*  660 */             rank++;
/*      */           } }
/*  662 */         xCrossBattleOwn.getRound_robin_point_rank_list().clear();
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*  667 */         int rank = 1;
/*      */         
/*  669 */         xCrossBattleOwn.getVote_stage_direct_promotion_corps_list().clear();
/*  670 */         for (int i = 0; i < cfg.vote_stage_direct_promotion_corps_num; i++)
/*      */         {
/*  672 */           if (!xCrossBattleOwn.getAttend_corps_infos().containsKey(((VoteStageVoteNumChartObj)chartObjs.get(i)).getKey()))
/*      */           {
/*  674 */             logger.error(String.format("[crossbattle_own]CrossBattleOwnManager.OnCrossBattleRoundRobinStageStart@no attend corps info|corpsid=%d|activity_cfg_id=%d", new Object[] { ((VoteStageVoteNumChartObj)chartObjs.get(i)).getKey(), Integer.valueOf(activityCfgid) }));
/*      */ 
/*      */           }
/*      */           else
/*      */           {
/*  679 */             xCrossBattleOwn.getVote_stage_direct_promotion_corps_list().add(((VoteStageVoteNumChartObj)chartObjs.get(i)).getKey());
/*  680 */             Iterator i$; if (isCrossBattleRoundRobinStageSwitchOpen(activityCfgid))
/*      */             {
/*  682 */               for (i$ = ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(((VoteStageVoteNumChartObj)chartObjs.get(i)).getKey())).getMembers().iterator(); i$.hasNext();) { long memberid = ((Long)i$.next()).longValue();
/*      */                 
/*  684 */                 MailInterface.asynBuildAndSendMail(memberid, cfg.vote_stage_most_votes_mail_cfg_id, null, Arrays.asList(new String[] { String.valueOf(((VoteStageVoteNumChartObj)chartObjs.get(i)).getVoteNum()), String.valueOf(rank) }), new TLogArg(LogReason.CROSS_BATTLE_OWN_VOTE_STAGE_MOST_VOTES_MAIL, activityCfgid));
/*      */               }
/*      */             }
/*      */             
/*      */ 
/*  689 */             rank++;
/*      */           }
/*      */         }
/*  692 */         xCrossBattleOwn.getRound_robin_point_rank_list().clear();
/*  693 */         for (int i = cfg.vote_stage_direct_promotion_corps_num; i < Math.min(chartObjs.size(), cfg.vote_stage_direct_promotion_corps_num + cfg.round_robin_max_corps_num); 
/*  694 */             i++)
/*      */         {
/*  696 */           if (!xCrossBattleOwn.getAttend_corps_infos().containsKey(((VoteStageVoteNumChartObj)chartObjs.get(i)).getKey()))
/*      */           {
/*  698 */             logger.error(String.format("[crossbattle_own]CrossBattleOwnManager.OnCrossBattleRoundRobinStageStart@no attend corps info|corpsid=%d|activity_cfg_id=%d", new Object[] { ((VoteStageVoteNumChartObj)chartObjs.get(i)).getKey(), Integer.valueOf(activityCfgid) }));
/*      */ 
/*      */           }
/*      */           else
/*      */           {
/*  703 */             xCrossBattleOwn.getRound_robin_point_rank_list().add(((VoteStageVoteNumChartObj)chartObjs.get(i)).getKey());
/*  704 */             Iterator i$; if (isCrossBattleRoundRobinStageSwitchOpen(activityCfgid))
/*      */             {
/*  706 */               for (i$ = ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(((VoteStageVoteNumChartObj)chartObjs.get(i)).getKey())).getMembers().iterator(); i$.hasNext();) { long memberid = ((Long)i$.next()).longValue();
/*      */                 
/*  708 */                 MailInterface.asynBuildAndSendMail(memberid, cfg.vote_stage_round_robin_notice_mail_cfg_id, null, Arrays.asList(new String[] { String.valueOf(((VoteStageVoteNumChartObj)chartObjs.get(i)).getVoteNum()), String.valueOf(rank), String.valueOf(cfg.vote_stage_direct_promotion_corps_num + cfg.round_robin_max_corps_num) }), new TLogArg(LogReason.CROSS_BATTLE_OWN_VOTE_STAGE_ROUND_ROBIN_NOTICE_MAIL, activityCfgid));
/*      */               }
/*      */             }
/*      */             
/*      */ 
/*      */ 
/*      */ 
/*  715 */             rank++;
/*      */           }
/*      */         }
/*  718 */         for (int i = Math.min(chartObjs.size(), cfg.vote_stage_direct_promotion_corps_num + cfg.round_robin_max_corps_num); 
/*  719 */             i < chartObjs.size(); i++)
/*      */         {
/*  721 */           if (!xCrossBattleOwn.getAttend_corps_infos().containsKey(((VoteStageVoteNumChartObj)chartObjs.get(i)).getKey()))
/*      */           {
/*  723 */             logger.error(String.format("[crossbattle_own]CrossBattleOwnManager.OnCrossBattleRoundRobinStageStart@no attend corps info|corpsid=%d|activity_cfg_id=%d", new Object[] { ((VoteStageVoteNumChartObj)chartObjs.get(i)).getKey(), Integer.valueOf(activityCfgid) }));
/*      */           }
/*      */           else
/*      */           {
/*      */             Iterator i$;
/*  728 */             if (isCrossBattleRoundRobinStageSwitchOpen(activityCfgid))
/*      */             {
/*  730 */               for (i$ = ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(((VoteStageVoteNumChartObj)chartObjs.get(i)).getKey())).getMembers().iterator(); i$.hasNext();) { long memberid = ((Long)i$.next()).longValue();
/*      */                 
/*  732 */                 MailInterface.asynBuildAndSendMail(memberid, cfg.vote_stage_encourage_mail_cfg_id, null, Arrays.asList(new String[] { String.valueOf(((VoteStageVoteNumChartObj)chartObjs.get(i)).getVoteNum()), String.valueOf(rank), String.valueOf(cfg.vote_stage_direct_promotion_corps_num + cfg.round_robin_max_corps_num) }), new TLogArg(LogReason.CROSS_BATTLE_OWN_VOTE_STAGE_ENCOURAGE_MAIL, activityCfgid));
/*      */               }
/*      */             }
/*      */             
/*      */ 
/*      */ 
/*      */ 
/*  739 */             rank++;
/*      */           }
/*      */         }
/*      */       }
/*  743 */       if (isCrossBattleRoundRobinStageSwitchOpen(activityCfgid))
/*      */       {
/*  745 */         int rank = 1;
/*  746 */         SSynVoteStageResultInCrossBattle protocol = new SSynVoteStageResultInCrossBattle();
/*  747 */         protocol.activity_cfg_id = activityCfgid;
/*  748 */         for (int i = 0; i < xCrossBattleOwn.getVote_stage_direct_promotion_corps_list().size(); i++)
/*      */         {
/*  750 */           long corpsid = ((VoteStageVoteNumChartObj)chartObjs.get(rank - 1)).getKey().longValue();
/*  751 */           AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsid));
/*  752 */           CrossBattleVoteRankData rankdata = new CrossBattleVoteRankData();
/*  753 */           rankdata.rank = rank;
/*  754 */           fillCorpsBriefInfo(rankdata.corps_brief_info, corpsid, xAttendCorpsInfo);
/*  755 */           rankdata.vote_num = ((VoteStageVoteNumChartObj)chartObjs.get(rank - 1)).getVoteNum();
/*  756 */           rankdata.vote_timestamp = ((int)(((VoteStageVoteNumChartObj)chartObjs.get(rank - 1)).getVoteTimestamp() / 1000L));
/*  757 */           rankdata.average_fight_value = ((VoteStageVoteNumChartObj)chartObjs.get(rank - 1)).getAverageFightValue();
/*  758 */           protocol.vote_stage_direct_promotion_corps_list.add(rankdata);
/*  759 */           rank++;
/*      */         }
/*  761 */         for (int i = 0; i < xCrossBattleOwn.getRound_robin_point_rank_list().size(); i++)
/*      */         {
/*  763 */           long corpsid = ((VoteStageVoteNumChartObj)chartObjs.get(rank - 1)).getKey().longValue();
/*  764 */           AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsid));
/*  765 */           CrossBattleVoteRankData rankdata = new CrossBattleVoteRankData();
/*  766 */           rankdata.rank = rank;
/*  767 */           fillCorpsBriefInfo(rankdata.corps_brief_info, corpsid, xAttendCorpsInfo);
/*  768 */           rankdata.vote_num = ((VoteStageVoteNumChartObj)chartObjs.get(rank - 1)).getVoteNum();
/*  769 */           rankdata.vote_timestamp = ((int)(((VoteStageVoteNumChartObj)chartObjs.get(rank - 1)).getVoteTimestamp() / 1000L));
/*  770 */           rankdata.average_fight_value = ((VoteStageVoteNumChartObj)chartObjs.get(rank - 1)).getAverageFightValue();
/*  771 */           protocol.round_robin_point_rank_list.add(rankdata);
/*  772 */           rank++;
/*      */         }
/*  774 */         OnlineManager.getInstance().sendAll(protocol);
/*      */       }
/*  776 */       CrossBattleOwnTLogManager.addVoteStagePromotionTLog(activityCfgid, xCrossBattleOwn.getVote_stage_direct_promotion_corps_list(), xCrossBattleOwn.getRound_robin_point_rank_list());
/*      */       
/*      */ 
/*  779 */       if (xCrossBattleOwn.getRound_robin_point_rank_list().size() == 0)
/*      */       {
/*      */ 
/*  782 */         trySettleRoundRobin(xCrossBattleOwn, activityCfgid, averageFightValues);
/*  783 */         return;
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  788 */       generateRoundRobinSchedule(activityCfgid, xCrossBattleOwn);
/*      */     }
/*      */     
/*  791 */     tryStartNextRoundRobinRound(xCrossBattleOwn, activityCfgid, averageFightValues);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void generateRoundRobinSchedule(int activityCfgid, CrossBattleOwn xCrossBattleOwn)
/*      */   {
/*  801 */     xCrossBattleOwn.setRound_robin_round_index(1);
/*  802 */     int corpsNum = xCrossBattleOwn.getRound_robin_point_rank_list().size();
/*  803 */     List<ArrayList<Integer>> schedule = new RoundRobinScheduleGenerator(corpsNum).getSchedule();
/*  804 */     xCrossBattleOwn.getRound_robin_round_infos().clear();
/*  805 */     int roundIndex = 1;
/*  806 */     for (ArrayList<Integer> round : schedule)
/*      */     {
/*  808 */       RoundRobinRoundInfo xRoundRobinRoundInfo = Pod.newRoundRobinRoundInfo();
/*  809 */       xRoundRobinRoundInfo.setStage(-1);
/*  810 */       xCrossBattleOwn.getRound_robin_round_infos().add(xRoundRobinRoundInfo);
/*  811 */       for (int i = 0; i < round.size(); i += 2)
/*      */       {
/*  813 */         if ((((Integer)round.get(i)).intValue() < corpsNum) && (((Integer)round.get(i + 1)).intValue() < corpsNum))
/*      */         {
/*      */ 
/*      */ 
/*  817 */           xbean.RoundRobinFightInfo xRoundRobinFightInfo = Pod.newRoundRobinFightInfo();
/*  818 */           xRoundRobinFightInfo.setCorps_a_id(((Long)xCrossBattleOwn.getRound_robin_point_rank_list().get(((Integer)round.get(i)).intValue())).longValue());
/*  819 */           xRoundRobinFightInfo.setCorps_b_id(((Long)xCrossBattleOwn.getRound_robin_point_rank_list().get(((Integer)round.get(i + 1)).intValue())).longValue());
/*  820 */           xRoundRobinFightInfo.setState(0);
/*  821 */           xRoundRobinRoundInfo.getFight_infos().add(xRoundRobinFightInfo);
/*  822 */           CrossBattleOwnTLogManager.addRoundRobinFightStateTLog(activityCfgid, roundIndex, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_b_id(), -1, 0);
/*      */         }
/*      */       }
/*      */       
/*  826 */       roundIndex++;
/*      */     }
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
/*      */   static void tryStartNextRoundRobinRound(CrossBattleOwn xCrossBattleOwn, int activityCfgid, Map<Long, Float> averageFightValues)
/*      */   {
/*  841 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(activityCfgid);
/*  842 */     if (cfg == null)
/*      */     {
/*      */ 
/*  845 */       return;
/*      */     }
/*  847 */     if (xCrossBattleOwn.getStage() != 2)
/*      */     {
/*  849 */       return;
/*      */     }
/*  851 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  852 */     int nextMainTimePointIndex = getNextTimePointIndex(now, cfg.round_robin_time_points);
/*  853 */     int nextBackupTimePointIndex = getNextTimePointIndex(now, cfg.round_robin_backup_time_points);
/*  854 */     if ((nextMainTimePointIndex < 0) && (nextBackupTimePointIndex < 0))
/*      */     {
/*      */ 
/*  857 */       repairRoundRobinData(xCrossBattleOwn, activityCfgid, xCrossBattleOwn.getRound_robin_round_infos().size());
/*  858 */       trySettleRoundRobin(xCrossBattleOwn, activityCfgid, averageFightValues);
/*  859 */       return;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  864 */     if (nextMainTimePointIndex == nextBackupTimePointIndex)
/*      */     {
/*      */ 
/*  867 */       repairRoundRobinData(xCrossBattleOwn, activityCfgid, nextMainTimePointIndex);
/*  868 */       if (isRoundRobinRoundAllEnd(xCrossBattleOwn))
/*      */       {
/*  870 */         trySettleRoundRobin(xCrossBattleOwn, activityCfgid, averageFightValues);
/*  871 */         return;
/*      */       }
/*      */       
/*  874 */       repairRoundRobinRoundData(xCrossBattleOwn, activityCfgid, nextMainTimePointIndex + 1);
/*      */       
/*  876 */       CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PSendRoundRobinRemindMail(activityCfgid, nextMainTimePointIndex + 1, true, DateTimeUtils.formatTimestamp(TimeCommonUtil.getTimePoint(STimePointCommonCfg.get(((Integer)cfg.round_robin_time_points.get(nextMainTimePointIndex)).intValue())) - cfg.round_robin_stage_prepare_duration_in_minute * 60000L)));
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  885 */       long interval = (TimeCommonUtil.getTimePoint(STimePointCommonCfg.get(((Integer)cfg.round_robin_time_points.get(nextMainTimePointIndex)).intValue())) - cfg.round_robin_stage_prepare_duration_in_minute * 60000L - now) / 1000L;
/*      */       
/*  887 */       if (interval <= 0L)
/*      */       {
/*  889 */         CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new POnRoundRobinRoundPrepareStageStart(activityCfgid, nextMainTimePointIndex + 1, true));
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*  894 */         RoundRobinRoundSessionManager.getInstance().startPrepareSession(interval, activityCfgid, nextMainTimePointIndex + 1, true);
/*      */       }
/*      */       
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/*  901 */       repairRoundRobinData(xCrossBattleOwn, activityCfgid, nextBackupTimePointIndex);
/*  902 */       if (isRoundRobinRoundAllEnd(xCrossBattleOwn))
/*      */       {
/*  904 */         trySettleRoundRobin(xCrossBattleOwn, activityCfgid, averageFightValues);
/*  905 */         return;
/*      */       }
/*  907 */       if (!isRoundRobinRoundEnd(xCrossBattleOwn, nextBackupTimePointIndex + 1))
/*      */       {
/*      */ 
/*  910 */         repairRoundRobinRoundData(xCrossBattleOwn, activityCfgid, nextBackupTimePointIndex + 1);
/*      */         
/*  912 */         CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PSendRoundRobinRemindMail(activityCfgid, nextBackupTimePointIndex + 1, false, DateTimeUtils.formatTimestamp(TimeCommonUtil.getTimePoint(STimePointCommonCfg.get(((Integer)cfg.round_robin_backup_time_points.get(nextBackupTimePointIndex)).intValue())) - cfg.round_robin_stage_prepare_duration_in_minute * 60000L)));
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  921 */         long interval = (TimeCommonUtil.getTimePoint(STimePointCommonCfg.get(((Integer)cfg.round_robin_backup_time_points.get(nextBackupTimePointIndex)).intValue())) - cfg.round_robin_stage_prepare_duration_in_minute * 60000L - now) / 1000L;
/*      */         
/*  923 */         if (interval <= 0L)
/*      */         {
/*  925 */           CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new POnRoundRobinRoundPrepareStageStart(activityCfgid, nextBackupTimePointIndex + 1, false));
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/*  930 */           RoundRobinRoundSessionManager.getInstance().startPrepareSession(interval, activityCfgid, nextBackupTimePointIndex + 1, false);
/*      */         }
/*      */         
/*      */       }
/*  934 */       else if (nextMainTimePointIndex >= 0)
/*      */       {
/*      */ 
/*      */ 
/*  938 */         repairRoundRobinRoundData(xCrossBattleOwn, activityCfgid, nextMainTimePointIndex + 1);
/*  939 */         CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PSendRoundRobinRemindMail(activityCfgid, nextMainTimePointIndex + 1, true, DateTimeUtils.formatTimestamp(TimeCommonUtil.getTimePoint(STimePointCommonCfg.get(((Integer)cfg.round_robin_time_points.get(nextMainTimePointIndex)).intValue())) - cfg.round_robin_stage_prepare_duration_in_minute * 60000L)));
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  948 */         long interval = (TimeCommonUtil.getTimePoint(STimePointCommonCfg.get(((Integer)cfg.round_robin_time_points.get(nextMainTimePointIndex)).intValue())) - cfg.round_robin_stage_prepare_duration_in_minute * 60000L - now) / 1000L;
/*      */         
/*  950 */         if (interval <= 0L)
/*      */         {
/*  952 */           CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new POnRoundRobinRoundPrepareStageStart(activityCfgid, nextMainTimePointIndex + 1, true));
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/*  957 */           RoundRobinRoundSessionManager.getInstance().startPrepareSession(interval, activityCfgid, nextMainTimePointIndex + 1, true);
/*      */         }
/*      */       }
/*      */     }
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
/*      */   private static void repairRoundRobinData(CrossBattleOwn xCrossBattleOwn, int activityCfgid, int nextRoundIndex)
/*      */   {
/*  976 */     if (xCrossBattleOwn.getRound_robin_round_index() == 0)
/*      */     {
/*  978 */       return;
/*      */     }
/*  980 */     int currentRoundIndexInData = xCrossBattleOwn.getRound_robin_round_index();
/*      */     
/*  982 */     for (int i = 0; i < currentRoundIndexInData - 1; i++)
/*      */     {
/*  984 */       RoundRobinRoundInfo xRoundRobinRoundInfo = (RoundRobinRoundInfo)xCrossBattleOwn.getRound_robin_round_infos().get(i);
/*  985 */       xRoundRobinRoundInfo.setStage(2);
/*  986 */       for (xbean.RoundRobinFightInfo xRoundRobinFightInfo : xRoundRobinRoundInfo.getFight_infos())
/*      */       {
/*  988 */         if (!isRoundRobinFightEnd(xRoundRobinFightInfo))
/*      */         {
/*  990 */           CrossBattleOwnTLogManager.addRoundRobinFightStateTLog(activityCfgid, i + 1, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getState(), 7);
/*      */           
/*      */ 
/*  993 */           xRoundRobinFightInfo.setState(7);
/*  994 */           xRoundRobinFightInfo.setWatch_roleid(-1L);
/*  995 */           xRoundRobinFightInfo.setRecordid(-1L);
/*  996 */           triggerRoundRobinFightEndEvent(activityCfgid, i + 1, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_b_id(), xRoundRobinFightInfo.getState());
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1003 */     for (int i = currentRoundIndexInData - 1; i < Math.min(xCrossBattleOwn.getRound_robin_round_infos().size(), nextRoundIndex); 
/* 1004 */         i++)
/*      */     {
/* 1006 */       RoundRobinRoundInfo xRoundRobinRoundInfo = (RoundRobinRoundInfo)xCrossBattleOwn.getRound_robin_round_infos().get(i);
/* 1007 */       xRoundRobinRoundInfo.setStage(2);
/* 1008 */       for (xbean.RoundRobinFightInfo xRoundRobinFightInfo : xRoundRobinRoundInfo.getFight_infos())
/*      */       {
/* 1010 */         if (!isRoundRobinFightEnd(xRoundRobinFightInfo))
/*      */         {
/* 1012 */           CrossBattleOwnTLogManager.addRoundRobinFightStateTLog(activityCfgid, i + 1, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getState(), 7);
/*      */           
/*      */ 
/* 1015 */           xRoundRobinFightInfo.setState(7);
/* 1016 */           xRoundRobinFightInfo.setWatch_roleid(-1L);
/* 1017 */           xRoundRobinFightInfo.setRecordid(-1L);
/* 1018 */           triggerRoundRobinFightEndEvent(activityCfgid, i + 1, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_b_id(), xRoundRobinFightInfo.getState());
/*      */         }
/*      */       }
/*      */       
/*      */ 
/* 1023 */       if (i < xCrossBattleOwn.getRound_robin_round_infos().size() - 1)
/*      */       {
/* 1025 */         xCrossBattleOwn.setRound_robin_round_index(xCrossBattleOwn.getRound_robin_round_index() + 1);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean isRoundRobinRoundAllEnd(CrossBattleOwn xCrossBattleOwn)
/*      */   {
/* 1038 */     if ((xCrossBattleOwn.getRound_robin_round_infos().size() == 0) || ((xCrossBattleOwn.getRound_robin_round_infos().size() == xCrossBattleOwn.getRound_robin_round_index()) && (((RoundRobinRoundInfo)xCrossBattleOwn.getRound_robin_round_infos().get(xCrossBattleOwn.getRound_robin_round_index() - 1)).getStage() == 2)))
/*      */     {
/*      */ 
/*      */ 
/* 1042 */       return true;
/*      */     }
/* 1044 */     return false;
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
/*      */   static boolean isRoundRobinRoundEnd(CrossBattleOwn xCrossBattleOwn, int roundIndex)
/*      */   {
/* 1057 */     if ((xCrossBattleOwn.getRound_robin_round_index() == 0) || ((xCrossBattleOwn.getRound_robin_round_index() >= roundIndex) && (((RoundRobinRoundInfo)xCrossBattleOwn.getRound_robin_round_infos().get(roundIndex - 1)).getStage() == 2)))
/*      */     {
/*      */ 
/*      */ 
/* 1061 */       return true;
/*      */     }
/* 1063 */     return false;
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
/*      */   private static int getNextTimePointIndex(long now, List<Integer> timePointCfgids)
/*      */   {
/* 1076 */     int nextTimePointIndex = -1;
/* 1077 */     for (int i = 0; i < timePointCfgids.size(); i++)
/*      */     {
/* 1079 */       if (TimeCommonUtil.getTimePoint(STimePointCommonCfg.get(((Integer)timePointCfgids.get(i)).intValue())) > now + 60000L)
/*      */       {
/* 1081 */         nextTimePointIndex = i;
/* 1082 */         break;
/*      */       }
/*      */     }
/* 1085 */     return nextTimePointIndex;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isActivityOpen(int activityCfgid)
/*      */   {
/* 1097 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/* 1098 */     CrossBattleOwn xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/* 1099 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() == -1))
/*      */     {
/* 1101 */       return false;
/*      */     }
/* 1103 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isInRegisterStage(int activityCfgid)
/*      */   {
/* 1115 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/* 1116 */     CrossBattleOwn xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/* 1117 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() == -1))
/*      */     {
/* 1119 */       return false;
/*      */     }
/* 1121 */     return xCrossBattleOwn.getStage() == 0;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isInVoteStage(int activityCfgid)
/*      */   {
/* 1133 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/* 1134 */     CrossBattleOwn xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/* 1135 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() == -1))
/*      */     {
/* 1137 */       return false;
/*      */     }
/* 1139 */     return xCrossBattleOwn.getStage() == 1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isInRoundRobinStage(int activityCfgid)
/*      */   {
/* 1151 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/* 1152 */     CrossBattleOwn xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/* 1153 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() == -1))
/*      */     {
/* 1155 */       return false;
/*      */     }
/* 1157 */     return xCrossBattleOwn.getStage() == 2;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void fillVoteRankDataByVoteNumChartObj(CrossBattleVoteRankData rankdata, VoteStageVoteNumChartObj chartObj, CrossBattleOwn xCrossBattleOwn)
/*      */   {
/* 1169 */     long corpsid = chartObj.getKey().longValue();
/* 1170 */     AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsid));
/* 1171 */     fillCorpsBriefInfo(rankdata.corps_brief_info, corpsid, xAttendCorpsInfo);
/* 1172 */     rankdata.vote_num = chartObj.getVoteNum();
/* 1173 */     rankdata.vote_timestamp = ((int)(chartObj.getVoteTimestamp() / 1000L));
/* 1174 */     rankdata.average_fight_value = chartObj.getAverageFightValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void fillVoteRankDataByAverageFightValueChartObj(CrossBattleVoteRankData rankdata, VoteStageAverageFightValueChartObj chartObj, CrossBattleOwn xCrossBattleOwn)
/*      */   {
/* 1186 */     long corpsid = chartObj.getKey().longValue();
/* 1187 */     AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsid));
/* 1188 */     fillCorpsBriefInfo(rankdata.corps_brief_info, corpsid, xAttendCorpsInfo);
/* 1189 */     rankdata.vote_num = chartObj.getVoteNum();
/* 1190 */     rankdata.vote_timestamp = ((int)(chartObj.getVoteTimestamp() / 1000L));
/* 1191 */     rankdata.average_fight_value = chartObj.getAverageFightValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isRoundRobinFightEnd(xbean.RoundRobinFightInfo xRoundRobinFightInfo)
/*      */   {
/* 1202 */     return (xRoundRobinFightInfo.getState() != 0) && (xRoundRobinFightInfo.getState() != 1);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isRoundRobinFightNormalEnd(xbean.RoundRobinFightInfo xRoundRobinFightInfo)
/*      */   {
/* 1214 */     return (xRoundRobinFightInfo.getState() == 2) || (xRoundRobinFightInfo.getState() == 3) || (xRoundRobinFightInfo.getState() == 4) || (xRoundRobinFightInfo.getState() == 5);
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
/*      */   static boolean isRoundRobinFightAllAbstainEnd(xbean.RoundRobinFightInfo xRoundRobinFightInfo)
/*      */   {
/* 1228 */     return xRoundRobinFightInfo.getState() == 6;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isRoundRobinFightExceptionEnd(xbean.RoundRobinFightInfo xRoundRobinFightInfo)
/*      */   {
/* 1239 */     return xRoundRobinFightInfo.getState() == 7;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void repairRoundRobinRoundData(CrossBattleOwn xCrossBattleOwn, int activityCfgid, int roundIndex)
/*      */   {
/* 1250 */     if (xCrossBattleOwn.getRound_robin_round_index() == 0)
/*      */     {
/* 1252 */       return;
/*      */     }
/* 1254 */     if ((roundIndex <= 0) || (roundIndex > xCrossBattleOwn.getRound_robin_round_infos().size()) || (roundIndex > xCrossBattleOwn.getRound_robin_round_index()))
/*      */     {
/*      */ 
/* 1257 */       return;
/*      */     }
/* 1259 */     RoundRobinRoundInfo xRoundRobinRoundInfo = (RoundRobinRoundInfo)xCrossBattleOwn.getRound_robin_round_infos().get(roundIndex - 1);
/* 1260 */     xRoundRobinRoundInfo.setStage(-1);
/* 1261 */     for (xbean.RoundRobinFightInfo xRoundRobinFightInfo : xRoundRobinRoundInfo.getFight_infos())
/*      */     {
/* 1263 */       if (xRoundRobinFightInfo.getState() == 1)
/*      */       {
/* 1265 */         xRoundRobinFightInfo.setState(0);
/* 1266 */         xRoundRobinFightInfo.setWatch_roleid(-1L);
/* 1267 */         xRoundRobinFightInfo.setRecordid(-1L);
/* 1268 */         CrossBattleOwnTLogManager.addRoundRobinFightStateTLog(activityCfgid, roundIndex, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_a_id(), 1, 0);
/*      */       }
/*      */     }
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
/*      */   static boolean checkCorpsCanAttendCurrentRound(CrossBattleOwn xCrossBattleOwn, long corpsid, int activityCfgid)
/*      */   {
/* 1285 */     if (xCrossBattleOwn.getRound_robin_round_index() <= 0)
/*      */     {
/* 1287 */       return false;
/*      */     }
/* 1289 */     if (!xCrossBattleOwn.getRound_robin_point_rank_list().contains(Long.valueOf(corpsid)))
/*      */     {
/* 1291 */       return false;
/*      */     }
/* 1293 */     int currentRoundIndex = 0;
/* 1294 */     RoundRobinRestartInfo restartInfo = RoundRobinRestartManager.getInstance().getRestartInfo(activityCfgid);
/* 1295 */     if (restartInfo != null)
/*      */     {
/* 1297 */       currentRoundIndex = restartInfo.roundIndex;
/*      */     }
/*      */     else
/*      */     {
/* 1301 */       currentRoundIndex = xCrossBattleOwn.getRound_robin_round_index();
/*      */     }
/* 1303 */     RoundRobinRoundInfo xRoundRobinRoundInfo = (RoundRobinRoundInfo)xCrossBattleOwn.getRound_robin_round_infos().get(currentRoundIndex - 1);
/*      */     
/* 1305 */     if (xRoundRobinRoundInfo.getStage() != 0)
/*      */     {
/* 1307 */       return false;
/*      */     }
/* 1309 */     for (xbean.RoundRobinFightInfo xRoundRobinFightInfo : xRoundRobinRoundInfo.getFight_infos())
/*      */     {
/* 1311 */       if ((!isRoundRobinFightEnd(xRoundRobinFightInfo)) && ((xRoundRobinFightInfo.getCorps_a_id() == corpsid) || (xRoundRobinFightInfo.getCorps_b_id() == corpsid)))
/*      */       {
/*      */ 
/* 1314 */         return true;
/*      */       }
/*      */     }
/* 1317 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void refreshRoundRobinPointRankList(CrossBattleOwn xCrossBattleOwn)
/*      */   {
/* 1327 */     Collections.sort(xCrossBattleOwn.getRound_robin_point_rank_list(), new Comparator()
/*      */     {
/*      */ 
/*      */       public int compare(Long o1, Long o2)
/*      */       {
/*      */ 
/* 1333 */         AttendCorpsInfo xAttendCorpsInfo1 = (AttendCorpsInfo)this.val$xCrossBattleOwn.getAttend_corps_infos().get(o1);
/* 1334 */         AttendCorpsInfo xAttendCorpsInfo2 = (AttendCorpsInfo)this.val$xCrossBattleOwn.getAttend_corps_infos().get(o2);
/* 1335 */         if ((xAttendCorpsInfo1 == null) || (xAttendCorpsInfo2 == null))
/*      */         {
/*      */ 
/* 1338 */           return 0;
/*      */         }
/* 1340 */         if (xAttendCorpsInfo1.getRound_robin_point() != xAttendCorpsInfo2.getRound_robin_point())
/*      */         {
/* 1342 */           return xAttendCorpsInfo2.getRound_robin_point() - xAttendCorpsInfo1.getRound_robin_point();
/*      */         }
/* 1344 */         if (xAttendCorpsInfo1.getVote_num() != xAttendCorpsInfo2.getVote_num())
/*      */         {
/* 1346 */           return xAttendCorpsInfo2.getVote_num() - xAttendCorpsInfo1.getVote_num();
/*      */         }
/* 1348 */         if (Math.abs(xAttendCorpsInfo1.getVote_stage_start_average_fight_value() - xAttendCorpsInfo2.getVote_stage_start_average_fight_value()) > 1.0E-8F)
/*      */         {
/*      */ 
/* 1351 */           return xAttendCorpsInfo1.getVote_stage_start_average_fight_value() - xAttendCorpsInfo2.getVote_stage_start_average_fight_value() > 1.0E-8F ? 1 : -1;
/*      */         }
/*      */         
/* 1354 */         return o1.longValue() - o2.longValue() > 0L ? 1 : -1;
/*      */       }
/*      */     });
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
/*      */   static void trySettleRoundRobinRound(CrossBattleOwn xCrossBattleOwn, int activityCfgid, int roundIndex, Map<Long, Float> averageFightValues)
/*      */   {
/* 1369 */     if ((roundIndex <= 0) || (roundIndex > xCrossBattleOwn.getRound_robin_point_rank_list().size()))
/*      */     {
/* 1371 */       return;
/*      */     }
/* 1373 */     RoundRobinRoundInfo xRoundRobinRoundInfo = (RoundRobinRoundInfo)xCrossBattleOwn.getRound_robin_round_infos().get(roundIndex - 1);
/* 1374 */     if (xRoundRobinRoundInfo == null)
/*      */     {
/* 1376 */       return;
/*      */     }
/* 1378 */     if (xRoundRobinRoundInfo.getStage() != 1)
/*      */     {
/* 1380 */       return;
/*      */     }
/* 1382 */     boolean isAllFightEnd = true;
/* 1383 */     for (xbean.RoundRobinFightInfo xRoundRobinFightInfo : xRoundRobinRoundInfo.getFight_infos())
/*      */     {
/* 1385 */       if (!isRoundRobinFightEnd(xRoundRobinFightInfo))
/*      */       {
/* 1387 */         isAllFightEnd = false;
/* 1388 */         break;
/*      */       }
/*      */     }
/* 1391 */     if (!isAllFightEnd)
/*      */     {
/* 1393 */       return;
/*      */     }
/* 1395 */     xRoundRobinRoundInfo.setStage(2);
/* 1396 */     if ((roundIndex == xCrossBattleOwn.getRound_robin_round_index()) && (xCrossBattleOwn.getRound_robin_round_index() < xCrossBattleOwn.getRound_robin_round_infos().size()))
/*      */     {
/*      */ 
/* 1399 */       xCrossBattleOwn.setRound_robin_round_index(xCrossBattleOwn.getRound_robin_round_index() + 1);
/*      */     }
/*      */     
/* 1402 */     if (isCrossBattleRoundRobinStageSwitchOpen(activityCfgid))
/*      */     {
/* 1404 */       SSynRoundRobinRoundInfoInCrossBattle protocol = new SSynRoundRobinRoundInfoInCrossBattle();
/* 1405 */       protocol.activity_cfg_id = activityCfgid;
/* 1406 */       protocol.index = roundIndex;
/* 1407 */       protocol.stage = 2;
/* 1408 */       for (xbean.RoundRobinFightInfo xRoundRobinFightInfo : xRoundRobinRoundInfo.getFight_infos())
/*      */       {
/* 1410 */         if ((!xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))) || (!xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))))
/*      */         {
/*      */ 
/* 1413 */           logger.error(String.format("[crossbattle_own]CrossBattleOwnManager.trySettleRoundRobinRound@no corps info|corps_a_id=%d|corps_b_id=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()), Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()), Integer.valueOf(activityCfgid) }));
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/* 1418 */           mzm.gsp.crossbattle.RoundRobinFightInfo fightInfo = new mzm.gsp.crossbattle.RoundRobinFightInfo();
/* 1419 */           fillCorpsBriefInfo(fightInfo.corps_a_brief_info, xRoundRobinFightInfo.getCorps_a_id(), (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id())));
/*      */           
/* 1421 */           fillCorpsBriefInfo(fightInfo.corps_b_brief_info, xRoundRobinFightInfo.getCorps_b_id(), (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id())));
/*      */           
/* 1423 */           fightInfo.state = xRoundRobinFightInfo.getState();
/* 1424 */           protocol.fight_infos.add(fightInfo);
/*      */         } }
/* 1426 */       OnlineManager.getInstance().sendAll(protocol);
/*      */     }
/*      */     
/* 1429 */     CrossBattleOneByOneManager.getInstance().addLogicRunnable(Integer.valueOf(activityCfgid), new ROnRoundRobinRoundEnd(activityCfgid));
/* 1430 */     RoundRobinRestartManager.getInstance().removeRestartInfo(activityCfgid);
/*      */     
/* 1432 */     tryStartNextRoundRobinRound(xCrossBattleOwn, activityCfgid, averageFightValues);
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
/*      */   static void trySettleRoundRobin(CrossBattleOwn xCrossBattleOwn, int activityCfgid, Map<Long, Float> averageFightValues)
/*      */   {
/* 1445 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(activityCfgid);
/* 1446 */     if (cfg == null)
/*      */     {
/*      */ 
/* 1449 */       return;
/*      */     }
/* 1451 */     if (xCrossBattleOwn.getStage() != 2)
/*      */     {
/* 1453 */       return;
/*      */     }
/* 1455 */     if (!isRoundRobinRoundAllEnd(xCrossBattleOwn))
/*      */     {
/* 1457 */       return;
/*      */     }
/*      */     
/* 1460 */     refreshRoundRobinPointRankList(xCrossBattleOwn);
/*      */     
/* 1462 */     xCrossBattleOwn.setStage(3);
/* 1463 */     for (Iterator i$ = xCrossBattleOwn.getVote_stage_direct_promotion_corps_list().iterator(); i$.hasNext();) { long corpsid = ((Long)i$.next()).longValue();
/*      */       
/* 1465 */       xCrossBattleOwn.getRound_robin_stage_promotion_corps_list().add(Long.valueOf(corpsid));
/*      */     }
/* 1467 */     for (int i = 0; i < xCrossBattleOwn.getRound_robin_point_rank_list().size(); i++)
/*      */     {
/* 1469 */       if (i < cfg.round_robin_stage_promotion_corps_num)
/*      */       {
/* 1471 */         xCrossBattleOwn.getRound_robin_stage_promotion_corps_list().add(xCrossBattleOwn.getRound_robin_point_rank_list().get(i));
/*      */       }
/*      */     }
/*      */     
/* 1475 */     for (Iterator i$ = xCrossBattleOwn.getRound_robin_stage_promotion_corps_list().iterator(); i$.hasNext();) { long corpsid = ((Long)i$.next()).longValue();
/*      */       
/* 1477 */       AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsid));
/* 1478 */       if ((xAttendCorpsInfo == null) || (!averageFightValues.containsKey(Long.valueOf(corpsid))))
/*      */       {
/* 1480 */         logger.error(String.format("[crossbattle_own]CrossBattleOwnManager.trySettleRoundRobin@no corps info|corps_id=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(corpsid), Integer.valueOf(activityCfgid) }));
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/* 1485 */         xAttendCorpsInfo.setRound_robin_end_average_fight_value(((Float)averageFightValues.get(Long.valueOf(corpsid))).floatValue());
/*      */       }
/*      */     }
/* 1488 */     if (isCrossBattleRoundRobinStageSwitchOpen(activityCfgid))
/*      */     {
/* 1490 */       SSynRoundRobinResultInCrossBattle protocol = new SSynRoundRobinResultInCrossBattle();
/* 1491 */       protocol.activity_cfg_id = activityCfgid;
/* 1492 */       for (int i = 0; i < xCrossBattleOwn.getRound_robin_point_rank_list().size(); i++)
/*      */       {
/* 1494 */         long corpsid = ((Long)xCrossBattleOwn.getRound_robin_point_rank_list().get(i)).longValue();
/* 1495 */         AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsid));
/* 1496 */         if (xAttendCorpsInfo == null)
/*      */         {
/* 1498 */           logger.error(String.format("[crossbattle_own]CrossBattleOwnManager.trySettleRoundRobin@no corps info|corps_id=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(corpsid), Integer.valueOf(activityCfgid) }));
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/* 1503 */           CrossBattleVoteRoundRobinPointRankData rankdata = new CrossBattleVoteRoundRobinPointRankData();
/* 1504 */           rankdata.rank = (i + 1);
/* 1505 */           fillCorpsBriefInfo(rankdata.corps_brief_info, corpsid, xAttendCorpsInfo);
/* 1506 */           rankdata.point = xAttendCorpsInfo.getRound_robin_point();
/* 1507 */           rankdata.win_num = xAttendCorpsInfo.getRound_robin_win_num();
/* 1508 */           rankdata.lose_num = xAttendCorpsInfo.getRound_robin_lose_num();
/* 1509 */           rankdata.vote_num = xAttendCorpsInfo.getVote_num();
/* 1510 */           rankdata.vote_timestamp = ((int)(xAttendCorpsInfo.getVote_num_timestamp() / 1000L));
/* 1511 */           protocol.ranklist.add(rankdata);
/*      */         } }
/* 1513 */       OnlineManager.getInstance().sendAll(protocol);
/*      */       AttendCorpsInfo xAttendCorpsInfo;
/* 1515 */       Iterator i$; for (int i = 0; i < xCrossBattleOwn.getRound_robin_point_rank_list().size(); i++)
/*      */       {
/* 1517 */         long corpsid = ((Long)xCrossBattleOwn.getRound_robin_point_rank_list().get(i)).longValue();
/* 1518 */         xAttendCorpsInfo = (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsid));
/* 1519 */         if (xAttendCorpsInfo == null)
/*      */         {
/* 1521 */           logger.error(String.format("[crossbattle_own]CrossBattleOwnManager.trySettleRoundRobin@no corps info|corps_id=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(corpsid), Integer.valueOf(activityCfgid) }));
/*      */         }
/*      */         else
/*      */         {
/*      */           Iterator i$;
/* 1526 */           if (i < cfg.round_robin_stage_promotion_corps_num)
/*      */           {
/* 1528 */             for (i$ = xAttendCorpsInfo.getMembers().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */               
/* 1530 */               MailInterface.asynBuildAndSendMail(roleid, cfg.round_robin_stage_promotion_mail_cfg_id, null, Arrays.asList(new String[] { String.valueOf(xAttendCorpsInfo.getRound_robin_win_num()), String.valueOf(xAttendCorpsInfo.getRound_robin_lose_num()), String.valueOf(xAttendCorpsInfo.getRound_robin_point()), String.valueOf(i + 1) }), new TLogArg(LogReason.CROSS_BATTLE_OWN_ROUND_ROBIN_STAGE_PROMOTION_MAIL, activityCfgid));
/*      */ 
/*      */             }
/*      */             
/*      */ 
/*      */           }
/*      */           else
/*      */           {
/*      */ 
/* 1539 */             for (i$ = xAttendCorpsInfo.getMembers().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */               
/* 1541 */               MailInterface.asynBuildAndSendMail(roleid, cfg.round_robin_stage_encourage_mail_cfg_id, null, Arrays.asList(new String[] { String.valueOf(xAttendCorpsInfo.getRound_robin_win_num()), String.valueOf(xAttendCorpsInfo.getRound_robin_lose_num()), String.valueOf(xAttendCorpsInfo.getRound_robin_point()), String.valueOf(i + 1) }), new TLogArg(LogReason.CROSS_BATTLE_OWN_ROUND_ROBIN_STAGE_ENCOURAGE_MAIL, activityCfgid));
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1550 */     reportCrossBattleOwnResult(xCrossBattleOwn, activityCfgid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void reportCrossBattleOwnResult(CrossBattleOwn xCrossBattleOwn, int activityCfgid)
/*      */   {
/* 1561 */     if (xCrossBattleOwn.getReport_result_success())
/*      */     {
/* 1563 */       logger.info(String.format("[crossbattle_own]CrossBattleOwnManager.reportCrossBattleOwnResult@already report|activity_cfg_id=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*      */       
/*      */ 
/* 1566 */       return;
/*      */     }
/* 1568 */     if (xCrossBattleOwn.getRound_robin_stage_promotion_corps_list().isEmpty())
/*      */     {
/* 1570 */       xCrossBattleOwn.setReport_result_success(true);
/* 1571 */       logger.info(String.format("[crossbattle_own]CrossBattleOwnManager.reportCrossBattleOwnResult@do not need report|activity_cfg_id=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*      */       
/*      */ 
/* 1574 */       CrossBattleOwnTLogManager.addReportOwnResultTLog(activityCfgid, 5, xCrossBattleOwn.getRound_robin_stage_promotion_corps_list());
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/* 1579 */       Map<Long, Octets> result = new HashMap();
/* 1580 */       for (Iterator i$ = xCrossBattleOwn.getRound_robin_stage_promotion_corps_list().iterator(); i$.hasNext();) { long corpsid = ((Long)i$.next()).longValue();
/*      */         
/* 1582 */         AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsid));
/* 1583 */         if (xAttendCorpsInfo == null)
/*      */         {
/* 1585 */           logger.error(String.format("[crossbattle_own]CrossBattleOwnManager.trySettleRoundRobin@no corps info|corps_id=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(corpsid), Integer.valueOf(activityCfgid) }));
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/* 1590 */           OctetsStream corpsInfo = new OctetsStream();
/* 1591 */           corpsInfo.marshal(xAttendCorpsInfo.getZoneid());
/* 1592 */           corpsInfo.marshal(xAttendCorpsInfo.getName(), "UTF-8");
/* 1593 */           corpsInfo.marshal(xAttendCorpsInfo.getBadge());
/* 1594 */           corpsInfo.marshal(xAttendCorpsInfo.getRound_robin_end_average_fight_value());
/* 1595 */           result.put(Long.valueOf(corpsid), corpsInfo);
/*      */         } }
/* 1597 */       if (CrossServerInterface.reportCrossBattleOwnResult(activityCfgid, result))
/*      */       {
/* 1599 */         logger.info(String.format("[crossbattle_own]CrossBattleOwnManager.reportCrossBattleOwnResult@try report|activity_cfg_id=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*      */ 
/* 1605 */         new ReportCrossBattleOwnResultSession(60L, activityCfgid);
/* 1606 */         logger.info(String.format("[crossbattle_own]CrossBattleOwnManager.reportCrossBattleOwnResult@send protocol fail|activity_cfg_id=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*      */       }
/*      */     }
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
/*      */   static QueryResult queryReportCrossBattleOwnResultInfoByIdip(int activityCfgid)
/*      */   {
/* 1623 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(activityCfgid);
/* 1624 */     if (cfg == null)
/*      */     {
/*      */ 
/* 1627 */       return QueryResult.ParamError;
/*      */     }
/*      */     
/* 1630 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/* 1631 */     CrossBattleOwn xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/* 1632 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() != 3))
/*      */     {
/* 1634 */       return QueryResult.DoNotNeedReport;
/*      */     }
/* 1636 */     if (!xCrossBattleOwn.getReport_result_success())
/*      */     {
/* 1638 */       return QueryResult.NotReport;
/*      */     }
/* 1640 */     return QueryResult.AlreadyReport;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static ClearResult clearCrossBattleOwnResultByIdip(int activityCfgid)
/*      */   {
/* 1652 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(activityCfgid);
/* 1653 */     if (cfg == null)
/*      */     {
/*      */ 
/* 1656 */       return ClearResult.ParamError;
/*      */     }
/*      */     
/* 1659 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/* 1660 */     CrossBattleOwn xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/* 1661 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() != 3))
/*      */     {
/* 1663 */       return ClearResult.DoNotNeedReport;
/*      */     }
/* 1665 */     if (!xCrossBattleOwn.getReport_result_success())
/*      */     {
/* 1667 */       return ClearResult.NotReport;
/*      */     }
/* 1669 */     if (xCrossBattleOwn.getRound_robin_stage_promotion_corps_list().isEmpty())
/*      */     {
/* 1671 */       xCrossBattleOwn.setReport_result_success(false);
/* 1672 */       xCrossBattleOwn.setStage(2);
/* 1673 */       logger.info(String.format("[crossbattle_own]CrossBattleOwnManager.clearCrossBattleOwnResult@set report result success to false|activity_cfg_id=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*      */       
/*      */ 
/* 1676 */       CrossBattleOwnTLogManager.addReportOwnResultTLog(activityCfgid, 6, xCrossBattleOwn.getRound_robin_stage_promotion_corps_list());
/*      */       
/* 1678 */       return ClearResult.AlreadyClear;
/*      */     }
/* 1680 */     Map<Long, Octets> result = new HashMap();
/* 1681 */     for (Iterator i$ = xCrossBattleOwn.getRound_robin_stage_promotion_corps_list().iterator(); i$.hasNext();) { long corpsid = ((Long)i$.next()).longValue();
/*      */       
/* 1683 */       AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsid));
/* 1684 */       if (xAttendCorpsInfo == null)
/*      */       {
/* 1686 */         logger.error(String.format("[crossbattle_own]CrossBattleOwnManager.trySettleRoundRobin@no corps info|corps_id=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(corpsid), Integer.valueOf(activityCfgid) }));
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/* 1691 */         OctetsStream corpsInfo = new OctetsStream();
/* 1692 */         corpsInfo.marshal(xAttendCorpsInfo.getZoneid());
/* 1693 */         corpsInfo.marshal(xAttendCorpsInfo.getName(), "UTF-8");
/* 1694 */         corpsInfo.marshal(xAttendCorpsInfo.getBadge());
/* 1695 */         corpsInfo.marshal(xAttendCorpsInfo.getRound_robin_end_average_fight_value());
/* 1696 */         result.put(Long.valueOf(corpsid), corpsInfo);
/*      */       } }
/* 1698 */     if (CrossServerInterface.clearCrossBattleOwnResult(activityCfgid, result))
/*      */     {
/* 1700 */       logger.info(String.format("[crossbattle_own]CrossBattleOwnManager.clearCrossBattleOwnResult@try clear|activity_cfg_id=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*      */       
/*      */ 
/* 1703 */       return ClearResult.AlreadyReport;
/*      */     }
/*      */     
/*      */ 
/* 1707 */     logger.info(String.format("[crossbattle_own]CrossBattleOwnManager.clearCrossBattleOwnResult@send protocol fail|activity_cfg_id=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*      */     
/*      */ 
/* 1710 */     return ClearResult.CommunicationError;
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
/*      */   static RestartResult restartRoundRobinRoundByIdip(int activityCfgid, int roundIndex, int restartLevel, long timestamp)
/*      */   {
/* 1731 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(activityCfgid);
/* 1732 */     if (cfg == null)
/*      */     {
/*      */ 
/* 1735 */       return RestartResult.ParamError;
/*      */     }
/* 1737 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 1738 */     long interval = timestamp - now;
/* 1739 */     if (interval < PROTECT_DURATION_IN_MINUTE * 60000L)
/*      */     {
/*      */ 
/* 1742 */       return RestartResult.TimestampError;
/*      */     }
/*      */     
/*      */ 
/* 1746 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/* 1747 */     CrossBattleOwn xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/* 1748 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() != 2))
/*      */     {
/*      */ 
/* 1751 */       return RestartResult.ActivityStageError;
/*      */     }
/* 1753 */     if ((xCrossBattleOwn.getRound_robin_round_infos().size() == 0) || (roundIndex < 1) || (roundIndex > xCrossBattleOwn.getRound_robin_round_infos().size()))
/*      */     {
/*      */ 
/*      */ 
/* 1757 */       return RestartResult.RoundIndexError;
/*      */     }
/* 1759 */     if (!isRoundRobinRoundEnd(xCrossBattleOwn, roundIndex))
/*      */     {
/*      */ 
/* 1762 */       return RestartResult.RoundNotEndError;
/*      */     }
/*      */     
/* 1765 */     if (isRoundRobinRoundAllEnd(xCrossBattleOwn))
/*      */     {
/* 1767 */       if (getRoundRobinStageEndTimestamp(activityCfgid) - timestamp < (PROTECT_DURATION_IN_MINUTE + cfg.round_robin_stage_prepare_duration_in_minute + cfg.round_robin_stage_fight_max_duration_in_minute) * 60000L)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1772 */         return RestartResult.TimestampError;
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/* 1777 */       int nextMainTimePointIndex = getNextTimePointIndex(now, cfg.round_robin_time_points);
/* 1778 */       int nextBackupTimePointIndex = getNextTimePointIndex(now, cfg.round_robin_backup_time_points);
/* 1779 */       if ((nextMainTimePointIndex < 0) && (nextBackupTimePointIndex > 0))
/*      */       {
/* 1781 */         long lastTimestamp = TimeCommonUtil.getTimePoint(STimePointCommonCfg.get(((Integer)cfg.round_robin_time_points.get(cfg.round_robin_time_points.size() - 1)).intValue()));
/* 1782 */         long nextTimestamp = TimeCommonUtil.getTimePoint(STimePointCommonCfg.get(((Integer)cfg.round_robin_backup_time_points.get(cfg.round_robin_backup_time_points.size() - 1)).intValue()));
/* 1783 */         if ((timestamp - lastTimestamp < (PROTECT_DURATION_IN_MINUTE + cfg.round_robin_stage_fight_max_duration_in_minute) * 60000L) || (nextTimestamp - timestamp < (PROTECT_DURATION_IN_MINUTE + 2 * cfg.round_robin_stage_prepare_duration_in_minute + cfg.round_robin_stage_fight_max_duration_in_minute) * 60000L))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1790 */           return RestartResult.TimestampError;
/*      */         }
/*      */       }
/* 1793 */       else if (nextMainTimePointIndex == nextBackupTimePointIndex)
/*      */       {
/* 1795 */         long lastTimestamp = TimeCommonUtil.getTimePoint(STimePointCommonCfg.get(((Integer)cfg.round_robin_backup_time_points.get(nextMainTimePointIndex - 1)).intValue()));
/* 1796 */         long nextTimestamp = TimeCommonUtil.getTimePoint(STimePointCommonCfg.get(((Integer)cfg.round_robin_time_points.get(nextMainTimePointIndex)).intValue()));
/* 1797 */         if ((timestamp - lastTimestamp < (PROTECT_DURATION_IN_MINUTE + cfg.round_robin_stage_fight_max_duration_in_minute) * 60000L) || (nextTimestamp - timestamp < (PROTECT_DURATION_IN_MINUTE + 2 * cfg.round_robin_stage_prepare_duration_in_minute + cfg.round_robin_stage_fight_max_duration_in_minute) * 60000L))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1804 */           return RestartResult.TimestampError;
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 1809 */         long lastTimestamp = TimeCommonUtil.getTimePoint(STimePointCommonCfg.get(((Integer)cfg.round_robin_time_points.get(nextMainTimePointIndex - 1)).intValue()));
/* 1810 */         long nextTimestamp = TimeCommonUtil.getTimePoint(STimePointCommonCfg.get(((Integer)cfg.round_robin_backup_time_points.get(nextBackupTimePointIndex)).intValue()));
/* 1811 */         if ((timestamp - lastTimestamp < (PROTECT_DURATION_IN_MINUTE + cfg.round_robin_stage_fight_max_duration_in_minute) * 60000L) || (nextTimestamp - timestamp < (PROTECT_DURATION_IN_MINUTE + 2 * cfg.round_robin_stage_prepare_duration_in_minute + cfg.round_robin_stage_fight_max_duration_in_minute) * 60000L))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1818 */           return RestartResult.TimestampError;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1823 */     for (RoundRobinRoundInfo xRoundRobinRoundInfo : xCrossBattleOwn.getRound_robin_round_infos())
/*      */     {
/* 1825 */       if (xRoundRobinRoundInfo.getStage() != 1) {}
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1830 */     if (!RoundRobinRestartManager.getInstance().addRestartInfo(activityCfgid, new RoundRobinRestartInfo(roundIndex, restartLevel, timestamp + cfg.round_robin_stage_prepare_duration_in_minute * 60000L)))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1836 */       return RestartResult.AlreadyHaveRestartRoundError;
/*      */     }
/* 1838 */     RoundRobinRoundInfo xRoundRobinRoundInfo = (RoundRobinRoundInfo)xCrossBattleOwn.getRound_robin_round_infos().get(roundIndex - 1);
/* 1839 */     xRoundRobinRoundInfo.setStage(-1);
/* 1840 */     if ((restartLevel & RESTART_LEVEL_NORMAL_END) != 0)
/*      */     {
/* 1842 */       for (xbean.RoundRobinFightInfo xRoundRobinFightInfo : xRoundRobinRoundInfo.getFight_infos())
/*      */       {
/* 1844 */         if (isRoundRobinFightNormalEnd(xRoundRobinFightInfo))
/*      */         {
/* 1846 */           if ((xRoundRobinFightInfo.getState() == 2) || (xRoundRobinFightInfo.getState() == 5))
/*      */           {
/*      */ 
/* 1849 */             ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).setRound_robin_win_num(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).getRound_robin_win_num() - 1);
/*      */             
/* 1851 */             ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).setRound_robin_point(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).getRound_robin_point() - cfg.round_robin_win_point);
/*      */             
/*      */ 
/* 1854 */             ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).setRound_robin_lose_num(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).getRound_robin_lose_num() - 1);
/*      */             
/* 1856 */             ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).setRound_robin_point(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).getRound_robin_point() - cfg.round_robin_lose_point);
/*      */ 
/*      */           }
/*      */           else
/*      */           {
/*      */ 
/* 1862 */             ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).setRound_robin_win_num(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).getRound_robin_win_num() - 1);
/*      */             
/* 1864 */             ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).setRound_robin_point(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).getRound_robin_point() - cfg.round_robin_win_point);
/*      */             
/*      */ 
/* 1867 */             ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).setRound_robin_lose_num(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).getRound_robin_lose_num() - 1);
/*      */             
/* 1869 */             ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).setRound_robin_point(((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).getRound_robin_point() - cfg.round_robin_lose_point);
/*      */           }
/*      */           
/*      */ 
/* 1873 */           logger.info(String.format("[crossbattle_own]CrossBattleOwnManager.restartRoundRobinRound@revert round robin fight state|activity_cfg_id=%d|round_index=%d|corps_a_id=%d|corps_b_id=%d|pre_state=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(roundIndex), Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()), Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()), Integer.valueOf(xRoundRobinFightInfo.getState()) }));
/*      */           
/*      */ 
/*      */ 
/* 1877 */           CrossBattleOwnTLogManager.addRoundRobinFightStateTLog(activityCfgid, roundIndex, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_b_id(), xRoundRobinFightInfo.getState(), 0);
/*      */           
/*      */ 
/* 1880 */           xRoundRobinFightInfo.setState(0);
/* 1881 */           xRoundRobinFightInfo.setWatch_roleid(-1L);
/* 1882 */           if (xRoundRobinFightInfo.getRecordid() > 0L)
/*      */           {
/* 1884 */             FightInterface.removeFightRecord(xRoundRobinFightInfo.getRecordid());
/*      */           }
/* 1886 */           xRoundRobinFightInfo.setRecordid(-1L);
/*      */         }
/*      */       }
/*      */     }
/* 1890 */     if ((restartLevel & RESTART_LEVEL_ALL_ABSTAIN) != 0)
/*      */     {
/* 1892 */       for (xbean.RoundRobinFightInfo xRoundRobinFightInfo : xRoundRobinRoundInfo.getFight_infos())
/*      */       {
/* 1894 */         if (isRoundRobinFightAllAbstainEnd(xRoundRobinFightInfo))
/*      */         {
/* 1896 */           logger.info(String.format("[crossbattle_own]CrossBattleOwnManager.restartRoundRobinRound@revert round robin fight state|activity_cfg_id=%d|round_index=%d|corps_a_id=%d|corps_b_id=%d|pre_state=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(roundIndex), Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()), Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()), Integer.valueOf(xRoundRobinFightInfo.getState()) }));
/*      */           
/*      */ 
/*      */ 
/* 1900 */           CrossBattleOwnTLogManager.addRoundRobinFightStateTLog(activityCfgid, roundIndex, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_b_id(), xRoundRobinFightInfo.getState(), 0);
/*      */           
/*      */ 
/* 1903 */           xRoundRobinFightInfo.setState(0);
/* 1904 */           xRoundRobinFightInfo.setWatch_roleid(-1L);
/* 1905 */           xRoundRobinFightInfo.setRecordid(-1L);
/*      */         }
/*      */       }
/*      */     }
/* 1909 */     if ((restartLevel & RESTART_LEVEL_EXCEPTION_END) != 0)
/*      */     {
/* 1911 */       for (xbean.RoundRobinFightInfo xRoundRobinFightInfo : xRoundRobinRoundInfo.getFight_infos())
/*      */       {
/* 1913 */         if (isRoundRobinFightExceptionEnd(xRoundRobinFightInfo))
/*      */         {
/* 1915 */           logger.info(String.format("[crossbattle_own]CrossBattleOwnManager.restartRoundRobinRound@revert round robin fight state|activity_cfg_id=%d|round_index=%d|corps_a_id=%d|corps_b_id=%d|pre_state=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(roundIndex), Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()), Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()), Integer.valueOf(xRoundRobinFightInfo.getState()) }));
/*      */           
/*      */ 
/*      */ 
/* 1919 */           CrossBattleOwnTLogManager.addRoundRobinFightStateTLog(activityCfgid, roundIndex, xRoundRobinFightInfo.getCorps_a_id(), xRoundRobinFightInfo.getCorps_b_id(), xRoundRobinFightInfo.getState(), 0);
/*      */           
/*      */ 
/* 1922 */           xRoundRobinFightInfo.setState(0);
/* 1923 */           xRoundRobinFightInfo.setWatch_roleid(-1L);
/* 1924 */           xRoundRobinFightInfo.setRecordid(-1L);
/*      */         }
/*      */       }
/*      */     }
/* 1928 */     refreshRoundRobinPointRankList(xCrossBattleOwn);
/*      */     
/* 1930 */     boolean isAllFightEnd = true;
/* 1931 */     for (xbean.RoundRobinFightInfo xRoundRobinFightInfo : xRoundRobinRoundInfo.getFight_infos())
/*      */     {
/* 1933 */       if (!isRoundRobinFightEnd(xRoundRobinFightInfo))
/*      */       {
/* 1935 */         isAllFightEnd = false;
/* 1936 */         break;
/*      */       }
/*      */     }
/* 1939 */     if (isAllFightEnd)
/*      */     {
/* 1941 */       RoundRobinRestartManager.getInstance().removeRestartInfo(activityCfgid);
/* 1942 */       return RestartResult.NoNeedRestartFightError;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1947 */     SSynCrossBattleRoundRobinIdipRestartInfo protocol = new SSynCrossBattleRoundRobinIdipRestartInfo();
/* 1948 */     protocol.activity_cfg_id = activityCfgid;
/* 1949 */     protocol.round_index = roundIndex;
/* 1950 */     protocol.timestamp = ((int)((timestamp + cfg.round_robin_stage_prepare_duration_in_minute * 60000L) / 1000L));
/*      */     
/* 1952 */     OnlineManager.getInstance().sendAll(protocol);
/*      */     
/* 1954 */     RoundRobinRoundSessionManager.getInstance().startPrepareSession(interval / 1000L, activityCfgid, roundIndex, false);
/* 1955 */     CrossBattleOwnTLogManager.addRestartRoundRobinRoundTLog(activityCfgid, roundIndex, restartLevel, timestamp);
/* 1956 */     return RestartResult.Success;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static long getRoundRobinStageEndTimestamp(int activityCfgid)
/*      */   {
/* 1967 */     SActivityCfg activityCfg = ActivityInterface.getActivityCfg(activityCfgid);
/* 1968 */     if (activityCfg == null)
/*      */     {
/*      */ 
/* 1971 */       return 0L;
/*      */     }
/* 1973 */     SCrossBattleStageDurationCfg durationCfg = SCrossBattleStageDurationCfg.get(activityCfgid);
/* 1974 */     if (durationCfg == null)
/*      */     {
/*      */ 
/* 1977 */       return 0L;
/*      */     }
/* 1979 */     long activityStartTimestamp = TimeCommonUtil.getLimitTimeBegin(activityCfg.activityLimitTimeid);
/* 1980 */     return activityStartTimestamp + (durationCfg.registerStageDurationInDay + durationCfg.voteStageDurationInDay + durationCfg.roundRobinStageDurationInDay) * 86400000L;
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
/*      */   static long getVoteStageStartTimestamp(int activityCfgid)
/*      */   {
/* 1993 */     SActivityCfg activityCfg = ActivityInterface.getActivityCfg(activityCfgid);
/* 1994 */     if (activityCfg == null)
/*      */     {
/*      */ 
/* 1997 */       return 0L;
/*      */     }
/* 1999 */     SCrossBattleStageDurationCfg durationCfg = SCrossBattleStageDurationCfg.get(activityCfgid);
/* 2000 */     if (durationCfg == null)
/*      */     {
/*      */ 
/* 2003 */       return 0L;
/*      */     }
/* 2005 */     long activityStartTimestamp = TimeCommonUtil.getLimitTimeBegin(activityCfg.activityLimitTimeid);
/* 2006 */     return activityStartTimestamp + durationCfg.registerStageDurationInDay * 86400000L;
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
/*      */   static void fillCorpsBriefInfo(CorpsBriefInfo corpsBriefInfo, long corpsid, AttendCorpsInfo xAttendCorpsInfo)
/*      */   {
/* 2019 */     corpsBriefInfo.corpsid = corpsid;
/*      */     try
/*      */     {
/* 2022 */       corpsBriefInfo.name.setString(xAttendCorpsInfo.getName(), "UTF-8");
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*      */ 
/* 2028 */     corpsBriefInfo.corpsbadgeid = xAttendCorpsInfo.getBadge();
/* 2029 */     corpsBriefInfo.average_fight_value = xAttendCorpsInfo.getVote_stage_start_average_fight_value();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static float getAverageFightValue(List<Long> roleList)
/*      */   {
/* 2041 */     if ((roleList == null) || (roleList.size() == 0))
/*      */     {
/* 2043 */       return 0.0F;
/*      */     }
/* 2045 */     float totalValue = 0.0F;
/* 2046 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*      */       
/* 2048 */       totalValue += RoleInterface.getRoleMFValue(roleId);
/*      */     }
/* 2050 */     if (totalValue <= 0.0F)
/*      */     {
/* 2052 */       return 0.0F;
/*      */     }
/* 2054 */     return totalValue / roleList.size();
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
/*      */   static void setRoundRobinTitle(long roleid, long corpsid, String corpsName, int corpsDuty, int badgeid)
/*      */   {
/* 2068 */     SRoundRobinTitle protocol = new SRoundRobinTitle();
/* 2069 */     protocol.corps_id = corpsid;
/*      */     try
/*      */     {
/* 2072 */       protocol.corps_name.setString(corpsName, "UTF-8");
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*      */ 
/* 2078 */     protocol.corps_duty = corpsDuty;
/* 2079 */     protocol.corps_badge_id = badgeid;
/* 2080 */     MapInterface.setModelProtocol(roleid, protocol);
/* 2081 */     logger.info(String.format("[crossbattle_own]CrossBattleOwnManager.setRoundRobinTitle@set round robin title|roleid=%d|corpsid=%d|corps_name=%s|corps_duty=%d|badgeid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(corpsid), corpsName, Integer.valueOf(corpsDuty), Integer.valueOf(badgeid) }));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void unsetRoundRobinTitle(long roleid)
/*      */   {
/* 2093 */     MapInterface.unSetModelProtocol(roleid, 12617033);
/* 2094 */     logger.info(String.format("[crossbattle_own]CrossBattleOwnManager.unsetRoundRobinTitle@unset round robin title|roleid=%d", new Object[] { Long.valueOf(roleid) }));
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
/*      */   static void brdRoundRobinFightResult(int activityCfgid, int roundIndex, CrossBattleOwn xCrossBattleOwn, long corpsAid, long corpsBid, int state)
/*      */   {
/* 2111 */     SSynRoundRobinRoundFightResultInCrossBattle protocol = new SSynRoundRobinRoundFightResultInCrossBattle();
/* 2112 */     protocol.activity_cfg_id = activityCfgid;
/* 2113 */     protocol.index = roundIndex;
/* 2114 */     protocol.stage = 1;
/* 2115 */     if ((!xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(corpsAid))) || (!xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(corpsBid))))
/*      */     {
/*      */ 
/* 2118 */       logger.error(String.format("[crossbattle_own]CrossBattleOwnManager.brdRoundRobinFightResult@no corps info|corps_a_id=%d|corps_b_id=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(corpsAid), Long.valueOf(corpsBid), Integer.valueOf(activityCfgid) }));
/*      */       
/*      */ 
/* 2121 */       return;
/*      */     }
/* 2123 */     fillCorpsBriefInfo(protocol.fight_info.corps_a_brief_info, corpsAid, (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsAid)));
/*      */     
/* 2125 */     fillCorpsBriefInfo(protocol.fight_info.corps_b_brief_info, corpsBid, (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsBid)));
/*      */     
/* 2127 */     protocol.fight_info.state = state;
/* 2128 */     OnlineManager.getInstance().sendAll(protocol);
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
/*      */   static void triggerRoundRobinFightEndEvent(int activityCfgid, int roundIndex, long corpsAid, long corpsBid, int state)
/*      */   {
/* 2143 */     TriggerEventsManger.getInstance().triggerEvent(new RoundRobinFightEnd(), new RoundRobinFightEndArg(activityCfgid, roundIndex, corpsAid, corpsBid, state), CrossBattleOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(activityCfgid)));
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
/*      */   static CrossBattleOwnInfo getCrossBattleOwnInfo(int activityCfgid, boolean remainLock)
/*      */   {
/* 2160 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/* 2161 */     CrossBattleOwn xCrossBattleOwn = null;
/* 2162 */     if (!remainLock)
/*      */     {
/* 2164 */       xCrossBattleOwn = Cross_battle_owns.select(Long.valueOf(globalActivityCfgid));
/*      */     }
/*      */     else
/*      */     {
/* 2168 */       xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/*      */     }
/* 2170 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() == -1))
/*      */     {
/* 2172 */       return null;
/*      */     }
/* 2174 */     return new CrossBattleOwnInfo(xCrossBattleOwn);
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\CrossBattleOwnManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */