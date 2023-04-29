/*      */ package mzm.gsp.teamplatform.match;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.NavigableMap;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.activity.confbean.SActivityCfg;
/*      */ import mzm.gsp.activity.main.ActivityInterface;
/*      */ import mzm.gsp.buff.main.BuffInterface;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.role.main.Role;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.team.SSynRolesUnderProtect;
/*      */ import mzm.gsp.team.confbean.OpertionCfg;
/*      */ import mzm.gsp.team.confbean.STeamPlatformChildCfg;
/*      */ import mzm.gsp.team.confbean.STeamPlatformMomCfg;
/*      */ import mzm.gsp.team.confbean.TeamConsts;
/*      */ import mzm.gsp.team.confbean.TeamPlatformConsts;
/*      */ import mzm.gsp.team.main.TeamInterface;
/*      */ import mzm.gsp.teamplatform.LevelCfg;
/*      */ import mzm.gsp.teamplatform.MatchCfg;
/*      */ import mzm.gsp.teamplatform.SCancelMatch;
/*      */ import mzm.gsp.teamplatform.SSynLeaderMatchInfo;
/*      */ import mzm.gsp.teamplatform.SSynMatchState;
/*      */ import mzm.gsp.teamplatform.TeamInfo;
/*      */ import mzm.gsp.teamplatform.session.BroadTeamInfoToAllTimer;
/*      */ import mzm.gsp.timer.main.Session;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.LogicProcedure;
/*      */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.MatchActivityCfg;
/*      */ import xbean.MatchKey;
/*      */ import xbean.MatchQueue;
/*      */ import xbean.Pod;
/*      */ import xbean.TeamMatchBeans;
/*      */ import xbean.TeamMatchQueue;
/*      */ import xdb.Procedure;
/*      */ import xtable.Matchqueue;
/*      */ 
/*      */ public class TeamMatchMananger
/*      */ {
/*   52 */   static TeamPlatformConsts teamPlatformConsts = ;
/*      */   
/*   54 */   private static Map<Integer, STeamPlatformMomCfg> activityId2STeamPlatformMomCfg = new HashMap();
/*      */   
/*   56 */   static Logger logger = Logger.getLogger("teammatch");
/*      */   
/*      */   public static void init()
/*      */   {
/*   60 */     Map<Integer, STeamPlatformMomCfg> momMap = STeamPlatformMomCfg.getAll();
/*   61 */     for (STeamPlatformMomCfg sTeamPlatformMomCfg : momMap.values())
/*      */     {
/*   63 */       if (sTeamPlatformMomCfg.matchType == 2)
/*      */       {
/*      */ 
/*      */ 
/*   67 */         if (activityId2STeamPlatformMomCfg.get(Integer.valueOf(sTeamPlatformMomCfg.activityId)) != null)
/*      */         {
/*   69 */           throw new RuntimeException(" 3419_组队平台配置母表.xls :包含了相同的活动id[" + sTeamPlatformMomCfg.activityId + "]");
/*      */         }
/*   71 */         activityId2STeamPlatformMomCfg.put(Integer.valueOf(sTeamPlatformMomCfg.activityId), sTeamPlatformMomCfg);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static Map<Integer, STeamPlatformMomCfg> getActivityId2STeamPlatformMomCfg()
/*      */   {
/*   79 */     return activityId2STeamPlatformMomCfg;
/*      */   }
/*      */   
/*      */   public static void setActivityId2STeamPlatformMomCfg(Map<Integer, STeamPlatformMomCfg> activityId2STeamPlatformMomCfg)
/*      */   {
/*   84 */     activityId2STeamPlatformMomCfg = activityId2STeamPlatformMomCfg;
/*      */   }
/*      */   
/*      */ 
/*      */   static void postInit()
/*      */   {
/*   90 */     for (STeamPlatformMomCfg cfg : activityId2STeamPlatformMomCfg.values())
/*      */     {
/*   92 */       if (cfg.occupationFristCount > 0)
/*      */       {
/*   94 */         if (cfg.occupationFristList.size() == 0)
/*      */         {
/*   96 */           throw new RuntimeException("3419_组队平台配置母表.xls,模板id=" + cfg.id + " 配置了门派优先个数，但没有配置门派！");
/*      */         }
/*      */       }
/*   99 */       if (ActivityInterface.getActivityCfg(cfg.activityCfgId) != null) {}
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  104 */     regTeamMatchBuff();
/*  105 */     BroadTeamInfoToAllTimer.init(MatchArgs.getInstance().cacheSize);
/*  106 */     new BroadTeamInfoToAllTimer(MatchArgs.getInstance().intervalMil);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void regTeamMatchBuff()
/*      */   {
/*  115 */     BuffInterface.registerBuffChange(Integer.valueOf(TeamConsts.getInstance().ROLE_MATCH_TEAM_BUF), new mzm.gsp.buff.main.BuffChangeHandler()
/*      */     {
/*      */ 
/*      */       public void changeHandler(long roleId, int buffId, int state)
/*      */       {
/*      */ 
/*  121 */         Procedure.execute(new POnTeamMatchBuffChange(roleId, buffId, state));
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
/*      */   public static MatchQueue getMatchQueue(boolean isRemainQueueLock)
/*      */   {
/*  136 */     MatchQueue matchqueue = null;
/*  137 */     if (isRemainQueueLock)
/*      */     {
/*  139 */       matchqueue = Matchqueue.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*      */     }
/*      */     else
/*      */     {
/*  143 */       matchqueue = Matchqueue.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/*      */     }
/*  145 */     return matchqueue;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean creatMatchQueue()
/*      */   {
/*  156 */     MatchQueue matchqueue = Pod.newMatchQueue();
/*  157 */     Matchqueue.insert(Long.valueOf(GameServerInfoManager.getLocalId()), matchqueue);
/*  158 */     return true;
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
/*      */   static boolean isRoleInMatchQueue(long roleId)
/*      */   {
/*  171 */     return getRoleActivity(roleId, false) != null;
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
/*      */   static MatchActivityCfg getRoleActivity(long roleId, boolean remainMatchLock)
/*      */   {
/*  186 */     MatchQueue matchQueue = getMatchQueue(remainMatchLock);
/*  187 */     if (matchQueue == null)
/*      */     {
/*  189 */       return null;
/*      */     }
/*  191 */     return (MatchActivityCfg)matchQueue.getRoleinfo().get(Long.valueOf(roleId));
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
/*      */   static boolean beginSession(MatchQueue matchQueue, long roleId, int level_low, int level_high, int matchType)
/*      */   {
/*  205 */     int level = RoleInterface.getLevel(roleId);
/*  206 */     MatchActivityCfg roleMatchInfo = (MatchActivityCfg)matchQueue.getRoleinfo().get(Long.valueOf(roleId));
/*  207 */     if (roleMatchInfo == null)
/*      */     {
/*  209 */       GameServer.logger().error(String.format("[teammatch]TeamMatchMananger.beginSession@ no roleMatchInfo!|roleId=%d|level_low=%d|level_high=%d|matchType=%d|roleLevel=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(level_low), Integer.valueOf(level_high), Integer.valueOf(matchType), Integer.valueOf(level) }));
/*      */       
/*      */ 
/*      */ 
/*  213 */       return false;
/*      */     }
/*      */     
/*  216 */     long insistWaitSessionId = -1L;
/*  217 */     long beRemovedSessionId = -1L;
/*  218 */     long roleBeLeaderHintSessionId = -1L;
/*  219 */     long expandLvSessionId = -1L;
/*      */     
/*  221 */     boolean isTakeNew = false;
/*  222 */     if ((level_high == 0) && (level_low == 0))
/*      */     {
/*  224 */       isTakeNew = true;
/*      */     }
/*      */     
/*  227 */     int levelGap = (level_high - level_low) / 2;
/*  228 */     if (levelGap == TeamPlatformConsts.getInstance().LEVEL_LITTLE_TOP)
/*      */     {
/*  230 */       level_low = level - TeamPlatformConsts.getInstance().LEVEL_BIG_TOP;
/*  231 */       level_high = level + TeamPlatformConsts.getInstance().LEVEL_BIG_TOP;
/*      */     }
/*      */     else
/*      */     {
/*  235 */       level_low = 0;
/*  236 */       level_high = RoleInterface.getRoleMaxLevel();
/*      */     }
/*      */     
/*  239 */     switch (matchType)
/*      */     {
/*      */     case 0: 
/*  242 */       beRemovedSessionId = RoleBeRemovedSession.beginRoleBeRemovedSession(TeamPlatformConsts.getInstance().LET_GO_SEC, roleId, matchType);
/*      */       
/*  244 */       insistWaitSessionId = InsistWaitSession.beginInsistWaitSession(roleId, TeamPlatformConsts.getInstance().HINT_ROLE_REIN_SEC);
/*      */       
/*  246 */       expandLvSessionId = NeedExpandLvSession.beginTeamExpandLvSession(roleId, TeamPlatformConsts.getInstance().EXPAND_LEVEL_SEC, level_low, level_high, matchType);
/*      */       
/*  248 */       roleBeLeaderHintSessionId = RoleBeLeaderHintSession.beginRoleBeLeaderHintSession(TeamPlatformConsts.getInstance().HINT_BE_LEADER_SEC, roleId);
/*      */       
/*  250 */       roleMatchInfo.setRolebeleaderhintsessionid(roleBeLeaderHintSessionId);
/*  251 */       break;
/*      */     
/*      */     case 1: 
/*  254 */       beRemovedSessionId = RoleBeRemovedSession.beginRoleBeRemovedSession(TeamPlatformConsts.getInstance().LET_GO_SEC, roleId, matchType);
/*      */       
/*  256 */       insistWaitSessionId = InsistWaitSession.beginInsistWaitSession(roleId, TeamPlatformConsts.getInstance().HINT_LEADER_REIN_SEC);
/*      */       
/*  258 */       if (!isTakeNew)
/*      */       {
/*  260 */         expandLvSessionId = NeedExpandLvSession.beginTeamExpandLvSession(roleId, TeamPlatformConsts.getInstance().EXPAND_LEVEL_SEC, level_low, level_high, matchType);
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*  265 */         new LeaderTakeNewSession(TeamPlatformConsts.getInstance().BE_NORMAL_SEC, roleId);
/*      */       }
/*  267 */       break;
/*      */     
/*      */     default: 
/*  270 */       GameServer.logger().error(String.format("[teammatch]TeamMatchMananger.beginSession@ no this kind of matchType!|roleId=%d|level_low=%d|level_high=%d|matchType=%d|roleLevel=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(level_low), Integer.valueOf(level_high), Integer.valueOf(matchType), Integer.valueOf(level) }));
/*      */       
/*      */ 
/*      */ 
/*  274 */       return false;
/*      */     }
/*      */     
/*  277 */     roleMatchInfo.setInsistwaitsessionid(insistWaitSessionId);
/*  278 */     roleMatchInfo.setBeremovedsessionid(beRemovedSessionId);
/*  279 */     roleMatchInfo.setExpandlvsessionid(expandLvSessionId);
/*  280 */     return true;
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
/*      */   static boolean cancelMatch(long roleId, CancelMatchType cancelMatchType)
/*      */   {
/*  294 */     MatchActivityCfg matchData = getRoleActivity(roleId, false);
/*  295 */     if (matchData == null)
/*      */     {
/*      */ 
/*  298 */       return false;
/*      */     }
/*  300 */     return cancelMatch(roleId, cancelMatchType, matchData);
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
/*      */   static boolean cancelMatch(long roleId, CancelMatchType cancelMatchType, MatchActivityCfg matchData)
/*      */   {
/*  317 */     if (matchData == null)
/*      */     {
/*  319 */       return false;
/*      */     }
/*      */     
/*  322 */     int matchType = matchData.getMatchtype();
/*  323 */     switch (matchType)
/*      */     {
/*      */     case 0: 
/*  326 */       return RoleQueueManager.cancelMatch(roleId, cancelMatchType);
/*      */     case 1: 
/*  328 */       return TeamQueueManager.cancelMatch(roleId, cancelMatchType);
/*      */     }
/*      */     
/*  331 */     return false;
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
/*      */   static boolean afterCancelMatch(long roleId)
/*      */   {
/*  344 */     return afterCancelMatch(roleId, true);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean afterCancelMatch(long roleId, boolean needSend)
/*      */   {
/*  356 */     if (!rmSession(roleId))
/*      */     {
/*  358 */       GameServer.logger().error(String.format("[teammatch]TeamMatchMananger.afterCancelMatch@rm role matchInfo err!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*      */       
/*  360 */       return false;
/*      */     }
/*  362 */     sendCancelMsg(roleId, needSend);
/*  363 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean rmSession(long roleId)
/*      */   {
/*  375 */     MatchQueue xMatchQueue = getMatchQueue(true);
/*  376 */     if (xMatchQueue == null)
/*      */     {
/*  378 */       GameServer.logger().error(String.format("[teammatch]TeamMatchManager.rmSession@ xMatchQueue not exist!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*      */       
/*  380 */       return false;
/*      */     }
/*      */     
/*  383 */     MatchActivityCfg xRoleMatchInfo = (MatchActivityCfg)xMatchQueue.getRoleinfo().get(Long.valueOf(roleId));
/*  384 */     if (xRoleMatchInfo == null)
/*      */     {
/*  386 */       GameServer.logger().error(String.format("[teammatch]TeamMatchManager.rmSession@ xRoleMatchInfo not exist!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*      */       
/*  388 */       return false;
/*      */     }
/*  390 */     long insistWaitSessionId = xRoleMatchInfo.getInsistwaitsessionid();
/*  391 */     Session insistWaitSession = Session.getSession(insistWaitSessionId);
/*  392 */     if ((insistWaitSession != null) && ((insistWaitSession instanceof InsistWaitSession)))
/*      */     {
/*  394 */       Session.removeSession(insistWaitSessionId);
/*      */     }
/*  396 */     long beRemovedSessionId = xRoleMatchInfo.getBeremovedsessionid();
/*  397 */     Session beRemovedSession = Session.getSession(beRemovedSessionId);
/*  398 */     if ((beRemovedSession != null) && ((beRemovedSession instanceof RoleBeRemovedSession)))
/*      */     {
/*  400 */       Session.removeSession(beRemovedSessionId);
/*      */     }
/*  402 */     long roleBeLeaderHintSessionId = xRoleMatchInfo.getRolebeleaderhintsessionid();
/*  403 */     Session roleBeLeaderHintSession = Session.getSession(roleBeLeaderHintSessionId);
/*  404 */     if ((roleBeLeaderHintSession != null) && ((roleBeLeaderHintSession instanceof RoleBeLeaderHintSession)))
/*      */     {
/*  406 */       Session.removeSession(roleBeLeaderHintSessionId);
/*      */     }
/*  408 */     long expandLvSessionId = xRoleMatchInfo.getExpandlvsessionid();
/*  409 */     Session expandLvSession = Session.getSession(expandLvSessionId);
/*  410 */     if ((expandLvSession != null) && ((expandLvSession instanceof NeedExpandLvSession)))
/*      */     {
/*  412 */       Session.removeSession(expandLvSessionId);
/*      */     }
/*  414 */     xMatchQueue.getRoleinfo().remove(Long.valueOf(roleId));
/*  415 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void sendCancelMsg(long roleId)
/*      */   {
/*  425 */     sendCancelMsg(roleId, true);
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
/*      */   static void sendCancelMsg(long roleId, boolean needSend)
/*      */   {
/*  438 */     SSynMatchState sSynMatchState = new SSynMatchState();
/*  439 */     sSynMatchState.matchstate = 2;
/*  440 */     OnlineManager.getInstance().send(roleId, sSynMatchState);
/*      */     
/*  442 */     if (!needSend)
/*      */     {
/*  444 */       return;
/*      */     }
/*      */     
/*  447 */     SCancelMatch sCancelMatch = new SCancelMatch();
/*  448 */     OnlineManager.getInstance().send(roleId, sCancelMatch);
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
/*      */   static List<Integer> getRealLevelGap(MatchCfg activityCfg, int level_low, int level_high)
/*      */   {
/*  464 */     List<Integer> levelArg = new ArrayList();
/*  465 */     int activityId = activityCfg.matchcfgid;
/*  466 */     SActivityCfg sActivityCfg = ActivityInterface.getActivityCfg(activityId);
/*  467 */     int activityLevel_max = sActivityCfg.levelMax;
/*  468 */     int activityLevel_min = sActivityCfg.levelMin;
/*      */     
/*  470 */     int finalLevel_min = level_low;
/*  471 */     int finalLevel_max = level_high;
/*      */     
/*  473 */     if (activityCfg.index == 0)
/*      */     {
/*  475 */       if (level_low <= activityLevel_min)
/*      */       {
/*  477 */         finalLevel_min = activityLevel_min;
/*      */       }
/*  479 */       if (level_high >= activityLevel_max)
/*      */       {
/*  481 */         finalLevel_max = activityLevel_max;
/*      */       }
/*      */     }
/*  484 */     else if (activityCfg.index >= 0)
/*      */     {
/*  486 */       if (level_low <= getChildCfgLevelMin(activityCfg))
/*      */       {
/*  488 */         finalLevel_min = getChildCfgLevelMin(activityCfg);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  495 */     if (finalLevel_min > finalLevel_max)
/*      */     {
/*  497 */       return levelArg;
/*      */     }
/*      */     
/*  500 */     levelArg.add(0, Integer.valueOf(finalLevel_min));
/*  501 */     levelArg.add(1, Integer.valueOf(finalLevel_max));
/*  502 */     return levelArg;
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
/*      */   static List<Integer> getRealLevelGap(int momCfgId, int index, int level_low, int level_high, int roleLevel)
/*      */   {
/*  516 */     List<Integer> levelArg = new ArrayList();
/*  517 */     STeamPlatformMomCfg cfg = STeamPlatformMomCfg.get(momCfgId);
/*  518 */     if (cfg == null)
/*      */     {
/*  520 */       return levelArg;
/*      */     }
/*      */     
/*  523 */     int matchType = cfg.matchType;
/*      */     
/*  525 */     switch (matchType)
/*      */     {
/*      */     case 1: 
/*  528 */       levelArg.add(0, Integer.valueOf(level_low));
/*  529 */       levelArg.add(1, Integer.valueOf(level_high));
/*  530 */       return levelArg;
/*      */     case 2: 
/*  532 */       return activityHand(index, level_low, level_high, levelArg, cfg, roleLevel);
/*      */     }
/*      */     
/*  535 */     return levelArg;
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
/*      */   static List<Integer> getRoleNewGuyRange(int momCfgId, int index, long roleId)
/*      */   {
/*  555 */     STeamPlatformMomCfg cfg = STeamPlatformMomCfg.get(momCfgId);
/*  556 */     if ((cfg == null) || (cfg.matchType != 2))
/*      */     {
/*  558 */       return new ArrayList();
/*      */     }
/*  560 */     return activityHand(index, 0, 0, new ArrayList(), cfg, RoleInterface.getLevel(roleId));
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
/*      */   static List<Integer> activityHand(int index, int level_low, int level_high, List<Integer> levelArg, STeamPlatformMomCfg cfg, int roleLevel)
/*      */   {
/*  576 */     int activityId = cfg.activityId;
/*  577 */     SActivityCfg sActivityCfg = ActivityInterface.getActivityCfg(activityId);
/*  578 */     if (sActivityCfg == null)
/*      */     {
/*  580 */       return levelArg;
/*      */     }
/*  582 */     int finalLevel_min = level_low;
/*  583 */     int finalLevel_max = level_high;
/*      */     
/*  585 */     int activityLevel_max = sActivityCfg.levelMax;
/*  586 */     int activityLevel_min = sActivityCfg.levelMin;
/*      */     
/*  588 */     boolean isTakeNew = false;
/*      */     
/*  590 */     if ((level_high == 0) && (level_low == 0))
/*      */     {
/*  592 */       isTakeNew = true;
/*      */     }
/*  594 */     if (index == 0)
/*      */     {
/*  596 */       if (level_low <= activityLevel_min)
/*      */       {
/*  598 */         finalLevel_min = activityLevel_min;
/*      */       }
/*  600 */       if (level_high >= activityLevel_max)
/*      */       {
/*  602 */         finalLevel_max = activityLevel_max;
/*      */       }
/*      */     }
/*  605 */     else if (index > 0)
/*      */     {
/*  607 */       OpertionCfg opertionCfg = getChildCfgById(index, cfg.activityCfgId);
/*  608 */       if (opertionCfg == null)
/*      */       {
/*  610 */         return levelArg;
/*      */       }
/*  612 */       int indexLevelLow = opertionCfg.optionLvFloor;
/*  613 */       if (level_low <= indexLevelLow)
/*      */       {
/*  615 */         finalLevel_min = indexLevelLow;
/*      */       }
/*      */     }
/*      */     
/*  619 */     if (isTakeNew)
/*      */     {
/*  621 */       if (roleLevel > 0)
/*      */       {
/*  623 */         finalLevel_max = roleLevel - teamPlatformConsts.NEW_GUY_LEVEL__DIFF;
/*      */       }
/*      */     }
/*      */     
/*  627 */     if (finalLevel_max < finalLevel_min)
/*      */     {
/*  629 */       return levelArg;
/*      */     }
/*      */     
/*  632 */     levelArg.add(0, Integer.valueOf(finalLevel_min));
/*  633 */     levelArg.add(1, Integer.valueOf(finalLevel_max));
/*  634 */     return levelArg;
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
/*      */   static boolean isNewGuy(long leaderId, long roleId, int activityId)
/*      */   {
/*  647 */     List<Integer> levelArg = getNewGuyLevel(leaderId, activityId);
/*  648 */     if (levelArg.size() != 2)
/*      */     {
/*  650 */       return false;
/*      */     }
/*  652 */     int roleLevel = RoleInterface.getLevel(roleId);
/*  653 */     if ((roleLevel >= ((Integer)levelArg.get(0)).intValue()) && (roleLevel <= ((Integer)levelArg.get(1)).intValue()))
/*      */     {
/*  655 */       return true;
/*      */     }
/*  657 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<Integer> getNewGuyLevel(long leaderId, int activityId)
/*      */   {
/*  669 */     List<Integer> levelArg = new ArrayList();
/*  670 */     SActivityCfg sActivityCfg = ActivityInterface.getActivityCfg(activityId);
/*  671 */     if (sActivityCfg == null)
/*      */     {
/*  673 */       return levelArg;
/*      */     }
/*  675 */     int leaderLevel = RoleInterface.getLevel(leaderId);
/*  676 */     int activityLevel_max = sActivityCfg.levelMax;
/*  677 */     int activityLevel_min = sActivityCfg.levelMin;
/*  678 */     int newGuylevel = leaderLevel - 10;
/*  679 */     if (newGuylevel >= activityLevel_min)
/*      */     {
/*  681 */       levelArg.add(Integer.valueOf(activityLevel_min));
/*  682 */       if (newGuylevel <= activityLevel_max)
/*      */       {
/*  684 */         levelArg.add(Integer.valueOf(newGuylevel));
/*      */       }
/*      */       else
/*      */       {
/*  688 */         levelArg.add(Integer.valueOf(activityLevel_max));
/*      */       }
/*      */     }
/*  691 */     return levelArg;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getChildCfgLevelMin(MatchCfg activityCfg)
/*      */   {
/*  703 */     OpertionCfg opertionCfg = getOpertionCfg(activityCfg);
/*  704 */     if (opertionCfg == null)
/*      */     {
/*  706 */       return -1;
/*      */     }
/*  708 */     return opertionCfg.optionLvFloor;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getChildCfgLevelMax(MatchCfg activityCfg)
/*      */   {
/*  720 */     OpertionCfg opertionCfg = getOpertionCfg(activityCfg);
/*  721 */     if (opertionCfg == null)
/*      */     {
/*  723 */       return -1;
/*      */     }
/*  725 */     return opertionCfg.optionLvTop;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static STeamPlatformMomCfg getSTeamPlatformMomCfg(MatchCfg matchCfg)
/*      */   {
/*  736 */     return STeamPlatformMomCfg.get(matchCfg.matchcfgid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static OpertionCfg getOpertionCfg(MatchCfg activityCfg)
/*      */   {
/*  747 */     if (activityCfg.index <= 0)
/*      */     {
/*  749 */       return null;
/*      */     }
/*      */     
/*  752 */     STeamPlatformMomCfg sTeamPlatformMomCfg = STeamPlatformMomCfg.get(activityCfg.matchcfgid);
/*  753 */     if (sTeamPlatformMomCfg == null)
/*      */     {
/*  755 */       return null;
/*      */     }
/*      */     
/*  758 */     int childId = sTeamPlatformMomCfg.activityCfgId;
/*  759 */     return getChildCfgById(activityCfg.index, childId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static OpertionCfg getChildCfgById(int index, int childId)
/*      */   {
/*  771 */     STeamPlatformChildCfg sTeamPlatformChildCfg = STeamPlatformChildCfg.get(childId);
/*  772 */     if (sTeamPlatformChildCfg == null)
/*      */     {
/*  774 */       return null;
/*      */     }
/*  776 */     if (sTeamPlatformChildCfg.opertionCfgList.size() < index)
/*      */     {
/*  778 */       return null;
/*      */     }
/*  780 */     int index_temp = index - 1;
/*  781 */     return (OpertionCfg)sTeamPlatformChildCfg.opertionCfgList.get(index_temp);
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
/*      */   static boolean onRoleLogin(long roleId)
/*      */   {
/*  794 */     if (!TeamInterface.isRoleInTeam(roleId, false))
/*      */     {
/*  796 */       BuffInterface.uninstallBuf(roleId, getMemberBuffId());
/*  797 */       BuffInterface.uninstallBuf(roleId, getLeaderBuffId());
/*      */     }
/*  799 */     if (isRoleInMatchQueue(roleId))
/*      */     {
/*  801 */       MatchNRTimeTaskManager.getInstance().addTask(new PCancelMatch(roleId));
/*      */     }
/*      */     
/*  804 */     MatchNRTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*      */     {
/*      */       protected boolean processImp()
/*      */         throws Exception
/*      */       {
/*  809 */         return TeamMatchMananger.leaderInMatchNotice(this.val$roleId);
/*      */       }
/*      */       
/*  812 */     });
/*  813 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean leaderInMatchNotice(long roleId)
/*      */   {
/*  824 */     long leaderId = TeamInterface.getTeamLeaderByRoleid(roleId, false, false);
/*  825 */     if (leaderId <= 0L)
/*      */     {
/*  827 */       return false;
/*      */     }
/*  829 */     if (!isRoleInMatchQueue(leaderId))
/*      */     {
/*  831 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  835 */     synLeaderMatchInfo(leaderId, Arrays.asList(new Long[] { Long.valueOf(roleId) }), 3);
/*  836 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void noticeTeamerCancel(Long teamId)
/*      */   {
/*  846 */     Procedure.execute(new LogicProcedure()
/*      */     {
/*      */ 
/*      */       protected boolean processImp()
/*      */         throws Exception
/*      */       {
/*  852 */         if (this.val$teamId == null)
/*      */         {
/*  854 */           return false;
/*      */         }
/*  856 */         List<Long> members = TeamInterface.getTeamMemberList(this.val$teamId.longValue(), false);
/*  857 */         if ((members == null) || (members.size() == 0))
/*      */         {
/*  859 */           return false;
/*      */         }
/*      */         
/*  862 */         OnlineManager.getInstance().sendMulti(new mzm.gsp.teamplatform.SLeaderCancelMatch(), members);
/*  863 */         return true;
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
/*      */   static boolean onGetTeamInfo(long roleId, List<Long> teamIds)
/*      */   {
/*  878 */     if (teamIds.size() == 0)
/*      */     {
/*  880 */       return false;
/*      */     }
/*  882 */     Map<Long, Integer> teamId2num = new HashMap();
/*  883 */     for (Iterator i$ = teamIds.iterator(); i$.hasNext();) { long teamId = ((Long)i$.next()).longValue();
/*      */       
/*  885 */       int teamMembernum = TeamInterface.getTeamMemberCount(teamId, false);
/*  886 */       if ((teamMembernum > 0) && (teamMembernum < TeamInterface.getTeamCapacity()))
/*      */       {
/*  888 */         teamId2num.put(Long.valueOf(teamId), Integer.valueOf(teamMembernum));
/*      */       }
/*      */     }
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
/*  917 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void synLeaderMatchInfo(long leaderId, List<Long> members, int type)
/*      */   {
/*  929 */     if ((members == null) || (members.size() == 0))
/*      */     {
/*  931 */       return;
/*      */     }
/*  933 */     MatchActivityCfg activity = getRoleActivity(leaderId, false);
/*  934 */     if (activity == null)
/*      */     {
/*  936 */       return;
/*      */     }
/*  938 */     SSynLeaderMatchInfo pro = new SSynLeaderMatchInfo();
/*      */     
/*  940 */     if (!fillLeaderMatchInfo(activity, pro, type))
/*      */     {
/*  942 */       return;
/*      */     }
/*      */     
/*  945 */     OnlineManager.getInstance().sendMulti(pro, members);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean fillLeaderMatchInfo(MatchActivityCfg matchActivityCfg, SSynLeaderMatchInfo pro, int type)
/*      */   {
/*  955 */     pro.activityinfo.matchcfgid = matchActivityCfg.getActivity().getActivityid();
/*  956 */     pro.activityinfo.index = matchActivityCfg.getActivity().getIndex();
/*  957 */     pro.levelrange.levelhigh = matchActivityCfg.getLevelhigh();
/*  958 */     pro.levelrange.levellow = matchActivityCfg.getLevellow();
/*  959 */     pro.syntype = type;
/*  960 */     return true;
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
/*      */   static void broToAll(long teamId, long teamLeaderId, int levelLow, int levelHigh, int activityId, int index, boolean isCancle)
/*      */   {
/*  975 */     NoneRealTimeTaskManager.getInstance().addTask(new PBro2All(teamId, teamLeaderId, activityId, index, levelLow, levelHigh, isCancle));
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
/*      */   static void fillTeamInfo(long teamId, long teamLeaderId, TeamInfo newTeaminfo, int levelLow, int levelHigh, int matchcfgid, int index, boolean isCancle)
/*      */   {
/*  994 */     newTeaminfo.teamid = teamId;
/*  995 */     newTeaminfo.leaderid = teamLeaderId;
/*      */     
/*  997 */     Role roleInfo = RoleInterface.getRole(teamLeaderId, false);
/*  998 */     newTeaminfo.teamleadername = roleInfo.getName();
/*  999 */     newTeaminfo.teamleaderlevel = roleInfo.getLevel();
/* 1000 */     newTeaminfo.teamleadersex = roleInfo.getGender();
/* 1001 */     newTeaminfo.teamleaderoccupation = roleInfo.getOccupationId();
/* 1002 */     newTeaminfo.avatarid = mzm.gsp.avatar.main.AvatarInterface.getCurrentAvatar(teamLeaderId);
/* 1003 */     newTeaminfo.avatarframeid = mzm.gsp.avatar.frame.AvatarFrameInterface.getCurrentAvatarFrameId(teamLeaderId, false);
/* 1004 */     newTeaminfo.chatbubblecfgid = mzm.gsp.chatbubble.main.ChatBubbleInterface.getRoleChatBubbleCfgId(teamLeaderId, false);
/*      */     
/* 1006 */     List<Long> members = TeamInterface.getTeamMemberList(teamId, false);
/* 1007 */     newTeaminfo.num = members.size();
/*      */     
/* 1009 */     if (isCancle)
/*      */     {
/* 1011 */       newTeaminfo.num = 0;
/*      */     }
/*      */     
/* 1014 */     LevelCfg levelCfg = new LevelCfg();
/* 1015 */     levelCfg.levellow = levelLow;
/* 1016 */     levelCfg.levelhigh = levelHigh;
/*      */     
/* 1018 */     newTeaminfo.level = levelCfg;
/*      */     
/* 1020 */     MatchCfg activitycfg = new MatchCfg();
/* 1021 */     activitycfg.matchcfgid = matchcfgid;
/* 1022 */     activitycfg.index = index;
/*      */     
/* 1024 */     newTeaminfo.activitycfg = activitycfg;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean synTeamInfo(long leaderId, long teamId, boolean isCancle)
/*      */   {
/* 1034 */     MatchActivityCfg xMatchInfo = getRoleActivity(leaderId, false);
/* 1035 */     if (xMatchInfo == null)
/*      */     {
/* 1037 */       return false;
/*      */     }
/* 1039 */     MatchKey matchKey = xMatchInfo.getActivity();
/* 1040 */     if (matchKey == null)
/*      */     {
/* 1042 */       return false;
/*      */     }
/* 1044 */     long startTime = xMatchInfo.getStarttime();
/* 1045 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 1046 */     int interval = (int)((curTime - startTime) / 1000L);
/* 1047 */     if (interval < TeamPlatformConsts.getInstance().BRO_2_ALL__BAN_INTERVAL)
/*      */     {
/* 1049 */       if (GameServer.logger().isDebugEnabled())
/*      */       {
/* 1051 */         GameServer.logger().debug(String.format("[teammatch]TeamMatchManager.synTeamInfo@ no need send teamInfo 2 all!|interval=%d", new Object[] { Integer.valueOf(interval) }));
/*      */       }
/*      */       
/*      */ 
/* 1055 */       return false;
/*      */     }
/* 1057 */     broToAll(teamId, leaderId, xMatchInfo.getLevellow(), xMatchInfo.getLevelhigh(), matchKey.getActivityid(), matchKey.getIndex(), isCancle);
/*      */     
/* 1059 */     return true;
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
/*      */   static void fillLeadersInfo(MatchQueue matchQueue, MatchKey matchKey, int matchCfgId, int index, int level, ArrayList<TeamInfo> leadersinfo)
/*      */   {
/* 1076 */     TeamMatchQueue teamMatchQueue = (TeamMatchQueue)matchQueue.getTeamqueue().get(matchKey);
/* 1077 */     if (teamMatchQueue == null)
/*      */     {
/* 1079 */       return;
/*      */     }
/* 1081 */     List<Long> teamBeansSelected = getMatchQueueTeams(matchQueue, matchCfgId, index, level);
/* 1082 */     int size = teamBeansSelected.size();
/* 1083 */     if (size == 0)
/*      */     {
/* 1085 */       return;
/*      */     }
/* 1087 */     List<Long> needSendTeamInfo = getNeedSendTeams(teamBeansSelected);
/* 1088 */     fillTeamInfos(leadersinfo, needSendTeamInfo);
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
/*      */   static List<Long> getMatchQueueTeams(MatchQueue matchQueue, int matchCfgId, int index, int level)
/*      */   {
/* 1101 */     int level_high = level + 5;
/* 1102 */     int level_low = level - 5;
/* 1103 */     if (level_low <= 0)
/* 1104 */       level_low = 1;
/* 1105 */     MatchCfg matchCfg = new MatchCfg();
/* 1106 */     matchCfg.matchcfgid = matchCfgId;
/* 1107 */     matchCfg.index = index;
/* 1108 */     List<Long> teamBeansSelected = new ArrayList();
/* 1109 */     RoleQueueManager.findRightTeamsInActivityQueue(level_low, level_high, matchQueue, teamBeansSelected, matchCfg);
/* 1110 */     return teamBeansSelected;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<Long> getNeedSendTeams(List<Long> teamBeansSelected)
/*      */   {
/* 1120 */     List<Long> needSendTeamInfo = new ArrayList();
/* 1121 */     int size = teamBeansSelected.size();
/* 1122 */     if (size == 0)
/*      */     {
/* 1124 */       return needSendTeamInfo;
/*      */     }
/* 1126 */     if (size <= TeamPlatformConsts.getInstance().TEAM_SHOW__NUM)
/*      */     {
/* 1128 */       needSendTeamInfo = teamBeansSelected;
/*      */     }
/*      */     else
/*      */     {
/* 1132 */       Random r = xdb.Xdb.random();
/*      */       for (;;)
/*      */       {
/* 1135 */         int ran = r.nextInt(size);
/* 1136 */         needSendTeamInfo.add(teamBeansSelected.get(ran));
/* 1137 */         size--;
/* 1138 */         if ((size <= 0) || (needSendTeamInfo.size() >= TeamPlatformConsts.getInstance().TEAM_SHOW__NUM)) {
/*      */           break;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1144 */     return needSendTeamInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void fillTeamInfos(ArrayList<TeamInfo> leadersinfo, List<Long> needSendTeamInfo)
/*      */   {
/* 1153 */     for (Iterator i$ = needSendTeamInfo.iterator(); i$.hasNext();) { long leaderId = ((Long)i$.next()).longValue();
/*      */       
/* 1155 */       TeamInfo teamInfo = new TeamInfo();
/* 1156 */       if (fillLeaderInfo(leaderId, teamInfo))
/*      */       {
/*      */ 
/*      */ 
/* 1160 */         leadersinfo.add(teamInfo);
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
/*      */   static boolean fillLeaderInfo(long leaderId, TeamInfo teamInfo)
/*      */   {
/* 1175 */     String name = RoleInterface.getName(leaderId);
/* 1176 */     int leaderLevel = RoleInterface.getLevel(leaderId);
/* 1177 */     int occupation = RoleInterface.getOccupationId(leaderId);
/* 1178 */     Long teamId = TeamInterface.getTeamidByRoleid(leaderId, false);
/* 1179 */     if (teamId == null)
/*      */     {
/* 1181 */       return false;
/*      */     }
/*      */     
/* 1184 */     int teamMemberCount = TeamInterface.getTeamMemberCount(teamId.longValue(), false);
/*      */     
/*      */ 
/* 1187 */     RoleMatchInfo roleMatchInfo = new RoleMatchInfo(leaderId, false);
/* 1188 */     if (!roleMatchInfo.inMatchQueue())
/*      */     {
/* 1190 */       return false;
/*      */     }
/* 1192 */     List<Integer> levelRange = roleMatchInfo.getNeedShowLevelRange();
/* 1193 */     LevelCfg level = new LevelCfg();
/* 1194 */     level.levellow = ((Integer)levelRange.get(0)).intValue();
/* 1195 */     level.levelhigh = ((Integer)levelRange.get(1)).intValue();
/*      */     
/* 1197 */     RoleActivityCfg cfg = roleMatchInfo.getRoleMatchActivityCfg();
/* 1198 */     MatchCfg matchcfg = new MatchCfg();
/* 1199 */     matchcfg.matchcfgid = cfg.getMomCfgId();
/* 1200 */     matchcfg.index = cfg.getIndex();
/*      */     
/* 1202 */     teamInfo.activitycfg = matchcfg;
/* 1203 */     teamInfo.leaderid = leaderId;
/* 1204 */     teamInfo.level = level;
/* 1205 */     teamInfo.teamleaderoccupation = occupation;
/* 1206 */     teamInfo.teamleadername = name;
/* 1207 */     teamInfo.teamleaderlevel = leaderLevel;
/* 1208 */     teamInfo.teamid = teamId.longValue();
/* 1209 */     teamInfo.num = teamMemberCount;
/*      */     
/* 1211 */     return true;
/*      */   }
/*      */   
/*      */   static int getMatchQueueLeadersNum(MatchQueue matchQueue, MatchKey matchKey)
/*      */   {
/* 1216 */     TeamMatchQueue teamMatchQueue = (TeamMatchQueue)matchQueue.getTeamqueue().get(matchKey);
/* 1217 */     if (teamMatchQueue == null)
/*      */     {
/* 1219 */       return 0;
/*      */     }
/* 1221 */     int num = 0;
/* 1222 */     for (TeamMatchBeans teamMatchBeans : teamMatchQueue.getActivitys().values())
/*      */     {
/* 1224 */       Set<Long> leaderMatchBeanList = teamMatchBeans.getTeammatchmembers();
/* 1225 */       if ((leaderMatchBeanList != null) && (leaderMatchBeanList.size() != 0))
/*      */       {
/* 1227 */         num += leaderMatchBeanList.size(); }
/*      */     }
/* 1229 */     return num;
/*      */   }
/*      */   
/*      */   static int getMatchQueueRolesNum(MatchQueue matchQueue, MatchKey matchKey)
/*      */   {
/* 1234 */     TeamMatchQueue roleMatchQueue = (TeamMatchQueue)matchQueue.getRolequeue().get(matchKey);
/* 1235 */     if (roleMatchQueue == null)
/*      */     {
/* 1237 */       return 0;
/*      */     }
/* 1239 */     int num = 0;
/* 1240 */     for (TeamMatchBeans roleMatchBeans : roleMatchQueue.getActivitys().values())
/*      */     {
/* 1242 */       Set<Long> roleMatchBeanList = roleMatchBeans.getTeammatchmembers();
/* 1243 */       if ((roleMatchBeanList != null) && (roleMatchBeanList.size() != 0))
/*      */       {
/* 1245 */         num += roleMatchBeanList.size(); }
/*      */     }
/* 1247 */     return num;
/*      */   }
/*      */   
/*      */   static int getCutMemberVigour()
/*      */   {
/* 1252 */     return TeamConsts.getInstance().CUT_MEMBER_VIGOUR_VALUE;
/*      */   }
/*      */   
/*      */   static int getCutLeaderVigour()
/*      */   {
/* 1257 */     return TeamConsts.getInstance().CUT_LEADER_VIGOUR_VALUE;
/*      */   }
/*      */   
/*      */   static int getCutMemberSilver()
/*      */   {
/* 1262 */     return TeamConsts.getInstance().CUT_MEMBER_SILVER_VALUE;
/*      */   }
/*      */   
/*      */   static int getCutLeaderSilver()
/*      */   {
/* 1267 */     return TeamConsts.getInstance().CUT_LEADER_SILVER_VALUE;
/*      */   }
/*      */   
/*      */   static int getMemberBuffId()
/*      */   {
/* 1272 */     return TeamConsts.getInstance().ROLE_MATCH_TEAM_BUF;
/*      */   }
/*      */   
/*      */   static int getLeaderBuffId()
/*      */   {
/* 1277 */     return TeamConsts.getInstance().LEADERMATCH_ROLE_BUF;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void cutRoleProperty(long roleId, boolean isLeader)
/*      */   {
/* 1287 */     if (cutVigour(roleId, isLeader))
/*      */     {
/* 1289 */       return;
/*      */     }
/*      */     
/* 1292 */     cutSilver(roleId, isLeader);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void cutSilver(long roleId, boolean isLeader)
/*      */   {
/* 1303 */     int cutSilver = isLeader ? getCutLeaderSilver() : getCutMemberSilver();
/* 1304 */     TLogArg logSilverArg = isLeader ? new TLogArg(LogReason.SILVER_CUT__TEAM_LEADER_FIRE_MATCH_MEMBER) : new TLogArg(LogReason.SILVER_CUT__TEAM_MATCH_MEMBER_ACTIVE_LEAVE);
/*      */     
/*      */ 
/* 1307 */     RoleInterface.cutSilver(roleId, cutSilver, logSilverArg);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean cutVigour(long roleId, boolean isLeader)
/*      */   {
/* 1318 */     int cutVigour = isLeader ? getCutLeaderVigour() : getCutMemberVigour();
/* 1319 */     TLogArg logVigourArg = isLeader ? new TLogArg(LogReason.VIGOR_CUT__TEAM_LEADER_FIRE_MATCH_MEMBER) : new TLogArg(LogReason.VIGOR_CUT__TEAM_MATCH_MEMBER_ACTIVE_LEAVE);
/*      */     
/*      */ 
/* 1322 */     return RoleInterface.cutVigor(roleId, cutVigour, logVigourArg);
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
/*      */   protected static void setMatchRoleBaseInfo(MatchQueue matchQueue, long roleId, int roleLevel, int level_low, int level_high, List<Integer> levelArgs, MatchKey matchKey, int matchType)
/*      */   {
/* 1338 */     MatchActivityCfg xMatchActivityCfg = Pod.newMatchActivityCfg();
/* 1339 */     xMatchActivityCfg.setMatchtype(matchType);
/* 1340 */     xMatchActivityCfg.setStarttime(DateTimeUtils.getCurrTimeInMillis());
/* 1341 */     xMatchActivityCfg.setActivity(matchKey);
/* 1342 */     xMatchActivityCfg.setLevelhigh(level_high);
/* 1343 */     xMatchActivityCfg.setLevellow(level_low);
/* 1344 */     xMatchActivityCfg.setNeedlevellow(((Integer)levelArgs.get(0)).intValue());
/* 1345 */     xMatchActivityCfg.setNeedlevelhigh(((Integer)levelArgs.get(1)).intValue());
/* 1346 */     xMatchActivityCfg.setRolelevel(roleLevel);
/*      */     
/* 1348 */     matchQueue.getRoleinfo().put(Long.valueOf(roleId), xMatchActivityCfg);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void rmUnNeedRoles(MatchQueue matchQueue, long roleId, List<Long> rolesSelected)
/*      */   {
/* 1359 */     int leaderLevel = RoleInterface.getLevel(roleId);
/*      */     
/* 1361 */     Iterator<Long> it = rolesSelected.iterator();
/* 1362 */     while (it.hasNext())
/*      */     {
/* 1364 */       long matchRoleId = ((Long)it.next()).longValue();
/* 1365 */       MatchActivityCfg cfg = (MatchActivityCfg)matchQueue.getRoleinfo().get(Long.valueOf(matchRoleId));
/* 1366 */       if (cfg == null)
/*      */       {
/* 1368 */         GameServer.logger().error(String.format("[teammatch]TeamMatchManager.rmUnNeedRoles@ no such roleMatchInfo!|matchRoleId=%d", new Object[] { Long.valueOf(matchRoleId) }));
/*      */         
/*      */ 
/* 1371 */         it.remove();
/*      */ 
/*      */       }
/* 1374 */       else if ((leaderLevel < cfg.getNeedlevellow()) || (leaderLevel > cfg.getNeedlevelhigh()))
/*      */       {
/* 1376 */         it.remove();
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
/*      */   static boolean rmRoleMatchData(long roleId, int matchType, CancelMatchType type)
/*      */   {
/* 1392 */     xdb.Lockeys.lock(xtable.Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/*      */     
/* 1394 */     MatchQueue xMatchQueue = getMatchQueue(true);
/* 1395 */     if (xMatchQueue == null)
/*      */     {
/* 1397 */       return false;
/*      */     }
/* 1399 */     MatchActivityCfg xRoleMatchInfo = getRoleActivity(roleId, true);
/* 1400 */     if ((xRoleMatchInfo == null) || (xRoleMatchInfo.getActivity() == null))
/*      */     {
/* 1402 */       return false;
/*      */     }
/*      */     
/* 1405 */     MatchKey xMatchKey = xRoleMatchInfo.getActivity();
/* 1406 */     TeamMatchQueue xTeamMatchQueue = getMatchQueue(matchType, xMatchQueue, xMatchKey);
/* 1407 */     if (xTeamMatchQueue == null)
/*      */     {
/*      */ 
/* 1410 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 1414 */     TeamMatchLogManager.tlogCancelMatch(roleId, xMatchKey.getActivityid(), xMatchKey.getIndex(), type, matchType);
/*      */     
/* 1416 */     int level = xRoleMatchInfo.getRolelevel();
/*      */     
/* 1418 */     TeamMatchBeans xTeamMatchBeans = (TeamMatchBeans)xTeamMatchQueue.getActivitys().get(Integer.valueOf(level));
/* 1419 */     if ((xTeamMatchBeans == null) || (xTeamMatchBeans.getTeammatchmembers() == null) || (xTeamMatchBeans.getTeammatchmembers().size() == 0))
/*      */     {
/*      */ 
/* 1422 */       GameServer.logger().error(String.format("[teammatch]TeamMatchManager.rmRoleMatchData@ xTeamMatchBeans not exsit!|roleId=%d|level=%d|matchType=%d|cancelType=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(level), Integer.valueOf(matchType), Integer.valueOf(type.value) }));
/*      */       
/*      */ 
/*      */ 
/* 1426 */       return false;
/*      */     }
/* 1428 */     boolean isContains = xTeamMatchBeans.getTeammatchmembers().remove(Long.valueOf(roleId));
/* 1429 */     if (!isContains)
/*      */     {
/* 1431 */       GameServer.logger().error(String.format("[teammatch]TeamMatchManager.rmRoleMatchData@ not contain role!|roleId=%d|level=%d|matchType=%d|cancelType=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(level), Integer.valueOf(matchType), Integer.valueOf(type.value) }));
/*      */       
/*      */ 
/*      */ 
/* 1435 */       return false;
/*      */     }
/* 1437 */     return true;
/*      */   }
/*      */   
/*      */   private static TeamMatchQueue getMatchQueue(int matchType, MatchQueue matchQueue, MatchKey matchKey)
/*      */   {
/* 1442 */     TeamMatchQueue teamMatchQueue = null;
/* 1443 */     switch (matchType)
/*      */     {
/*      */     case 1: 
/* 1446 */       teamMatchQueue = (TeamMatchQueue)matchQueue.getTeamqueue().get(matchKey);
/* 1447 */       break;
/*      */     case 0: 
/* 1449 */       teamMatchQueue = (TeamMatchQueue)matchQueue.getRolequeue().get(matchKey);
/* 1450 */       break;
/*      */     }
/*      */     
/*      */     
/*      */ 
/* 1455 */     return teamMatchQueue;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void checkMembersProtectState(List<Long> members, long roleId)
/*      */   {
/* 1466 */     List<Long> rolesUnderProtect = getBeProtectedMembers(members);
/* 1467 */     protectedMembersBro(roleId, rolesUnderProtect);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void protectedMembersBro(long roleId, List<Long> rolesUnderProtect)
/*      */   {
/* 1478 */     if (rolesUnderProtect.size() <= 0)
/*      */     {
/* 1480 */       return;
/*      */     }
/* 1482 */     SSynRolesUnderProtect pro = new SSynRolesUnderProtect();
/* 1483 */     pro.rolesunderprotect.addAll(rolesUnderProtect);
/* 1484 */     OnlineManager.getInstance().send(roleId, pro);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<Long> getBeProtectedMembers(List<Long> members)
/*      */   {
/* 1495 */     List<Long> rolesUnderProtect = new ArrayList();
/* 1496 */     for (Iterator i$ = members.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*      */       
/* 1498 */       if (BuffInterface.isContainBuff(member, TeamConsts.getInstance().ROLE_MATCH_TEAM_BUF))
/*      */       {
/*      */ 
/*      */ 
/* 1502 */         rolesUnderProtect.add(Long.valueOf(member)); }
/*      */     }
/* 1504 */     return rolesUnderProtect;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\TeamMatchMananger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */