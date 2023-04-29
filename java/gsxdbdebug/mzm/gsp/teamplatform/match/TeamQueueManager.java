/*     */ package mzm.gsp.teamplatform.match;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.confbean.TeamPlatformConsts;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.teamplatform.MatchCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MatchActivityCfg;
/*     */ import xbean.MatchKey;
/*     */ import xbean.MatchQueue;
/*     */ import xbean.Pod;
/*     */ import xbean.TeamMatchBeans;
/*     */ import xbean.TeamMatchQueue;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class TeamQueueManager
/*     */ {
/*  23 */   static final Logger logger = Logger.getLogger(TeamQueueManager.class);
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
/*     */ 
/*     */ 
/*     */   static boolean startMatch(long roleId, long teamId, MatchCfg matchCfg, int level_low, int level_high)
/*     */   {
/*  41 */     MatchQueue matchQueue = TeamMatchMananger.getMatchQueue(true);
/*  42 */     if (matchQueue == null)
/*     */     {
/*  44 */       TeamMatchMananger.creatMatchQueue();
/*  45 */       matchQueue = TeamMatchMananger.getMatchQueue(true);
/*     */     }
/*  47 */     if (!addTeamToQueue(roleId, matchCfg, level_low, level_high, matchQueue))
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     tryMatch(roleId, matchCfg, level_low, level_high, matchQueue);
/*  53 */     if (!TeamMatchMananger.beginSession(matchQueue, roleId, level_low, level_high, 1))
/*     */     {
/*  55 */       return false;
/*     */     }
/*  57 */     if (isNeedSendToWorld(teamId, roleId))
/*     */     {
/*     */ 
/*     */ 
/*  61 */       new Bro2AllSession(TeamPlatformConsts.getInstance().BRO_2_ALL__BAN_INTERVAL, roleId);
/*     */     }
/*  63 */     setSameTeamData(roleId, matchQueue);
/*  64 */     return true;
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
/*     */   static boolean isNeedSendToWorld(long teamId, long leaderId)
/*     */   {
/*  77 */     MatchQueue matchQueue = TeamMatchMananger.getMatchQueue(false);
/*  78 */     if (matchQueue.getRepeatleaderids().contains(Long.valueOf(leaderId)))
/*     */     {
/*  80 */       if (logger.isDebugEnabled())
/*     */       {
/*  82 */         logger.debug(String.format("[teamMatch]TeamQueueManager.isNeedSendToWorld@同一个队长，队伍信息不允许广播到世界！|roleId=%d|teamId=%d", new Object[] { Long.valueOf(leaderId), Long.valueOf(teamId) }));
/*     */       }
/*     */       
/*  85 */       return false;
/*     */     }
/*  87 */     if (matchQueue.getRepeatteamids().contains(Long.valueOf(teamId)))
/*     */     {
/*  89 */       if (logger.isDebugEnabled())
/*     */       {
/*  91 */         logger.debug(String.format("[teamMatch]TeamQueueManager.isNeedSendToWorld@同一个队伍，队伍信息不允许广播到世界！|roleId=%d|teamId=%d", new Object[] { Long.valueOf(leaderId), Long.valueOf(teamId) }));
/*     */       }
/*     */       
/*  94 */       return false;
/*     */     }
/*  96 */     return true;
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
/*     */ 
/*     */ 
/*     */   static void tryMatch(long roleId, MatchCfg matchCfg, int level_low, int level_high, MatchQueue xMatchQueue)
/*     */   {
/* 115 */     List<Long> rolesSelected = findRightMember(roleId, matchCfg, level_low, level_high, xMatchQueue);
/* 116 */     if (rolesSelected.size() > 0)
/*     */     {
/* 118 */       tryJoinLeaderTeam(roleId, rolesSelected, matchCfg.matchcfgid, xMatchQueue);
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
/*     */   static boolean cancelMatch(long leaderId, CancelMatchType cancelMatchType)
/*     */   {
/* 131 */     Long teamId = TeamInterface.getTeamidByRoleid(leaderId, false);
/* 132 */     if (teamId != null)
/*     */     {
/* 134 */       if (cancelMatchType != CancelMatchType.TEAM_FULL_SUC_CANCEL)
/*     */       {
/* 136 */         TeamMatchMananger.synTeamInfo(leaderId, teamId.longValue(), true);
/*     */         
/* 138 */         TeamMatchMananger.noticeTeamerCancel(teamId);
/*     */       }
/*     */       
/*     */     }
/*     */     else {
/* 143 */       TeamMatchMananger.synTeamInfo(leaderId, 0L, true);
/*     */     }
/* 145 */     if (!TeamMatchMananger.rmRoleMatchData(leaderId, 1, cancelMatchType))
/*     */     {
/* 147 */       TeamMatchMananger.logger.error(String.format("[teamMatch]TeamQueueManager.cancelMatch@队长取消匹配失败！|roleId=%d|cancelMatchType=%d", new Object[] { Long.valueOf(leaderId), Integer.valueOf(cancelMatchType.value) }));
/*     */       
/*     */ 
/* 150 */       return false;
/*     */     }
/* 152 */     if (!TeamMatchMananger.afterCancelMatch(leaderId))
/*     */     {
/* 154 */       return false;
/*     */     }
/* 156 */     return true;
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
/*     */   static boolean onRoleLevelUp(long roleId, int newLevel, int oldLevel)
/*     */   {
/* 170 */     xdb.Lockeys.lock(Basic.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/*     */     
/*     */ 
/* 173 */     MatchQueue xMatchQueue = TeamMatchMananger.getMatchQueue(true);
/* 174 */     if (xMatchQueue == null)
/*     */     {
/* 176 */       return false;
/*     */     }
/*     */     
/* 179 */     MatchActivityCfg xRoleMatchInfo = (MatchActivityCfg)xMatchQueue.getRoleinfo().get(Long.valueOf(roleId));
/* 180 */     if (xRoleMatchInfo == null)
/*     */     {
/* 182 */       return false;
/*     */     }
/*     */     
/* 185 */     GameServer.logger().info(String.format("[teammatch]TeamQueue@level change |roleId=%d|oldLevel=%d|newLevel=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(oldLevel), Integer.valueOf(newLevel) }));
/*     */     
/*     */ 
/*     */ 
/* 189 */     int xRoleOldLevel = xRoleMatchInfo.getRolelevel();
/* 190 */     xRoleMatchInfo.setRolelevel(newLevel);
/*     */     
/* 192 */     MatchKey matchKey = xRoleMatchInfo.getActivity();
/* 193 */     TeamMatchQueue xTeamMatchQueue = (TeamMatchQueue)xMatchQueue.getTeamqueue().get(matchKey);
/* 194 */     if (xTeamMatchQueue == null)
/*     */     {
/* 196 */       GameServer.logger().error(String.format("[teammatch]TeamQueuemanager.onRoleLevelUp@ teamMatchQueue not exist!|roleId=%d|roleLevel=%d|momCfg=%d|index=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(newLevel), Integer.valueOf(matchKey.getActivityid()), Integer.valueOf(matchKey.getIndex()) }));
/*     */       
/*     */ 
/*     */ 
/* 200 */       return false;
/*     */     }
/* 202 */     if (!rmOldLevelBean(roleId, xRoleOldLevel, xTeamMatchQueue))
/*     */     {
/* 204 */       GameServer.logger().error(String.format("[teammatch]TeamQueuemanager.onRoleLevelUp@ rmOldLevelBean error!|roleId=%d|roleLevel=%d|momCfg=%d|index=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(newLevel), Integer.valueOf(matchKey.getActivityid()), Integer.valueOf(matchKey.getIndex()) }));
/*     */       
/*     */ 
/*     */ 
/* 208 */       return false;
/*     */     }
/*     */     
/* 211 */     addNewLevelBean(roleId, newLevel, xTeamMatchQueue);
/*     */     
/* 213 */     tryMatch(roleId, xRoleMatchInfo.getNeedlevellow(), xRoleMatchInfo.getNeedlevelhigh(), xMatchQueue, xRoleMatchInfo.getActivity().getActivityid(), xRoleMatchInfo.getActivity().getIndex());
/*     */     
/* 215 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void addNewLevelBean(long roleId, int newLevel, TeamMatchQueue xTeamMatchQueue)
/*     */   {
/* 227 */     TeamMatchBeans xNextLevelBeans = (TeamMatchBeans)xTeamMatchQueue.getActivitys().get(Integer.valueOf(newLevel));
/* 228 */     if (xNextLevelBeans == null)
/*     */     {
/* 230 */       xNextLevelBeans = Pod.newTeamMatchBeans();
/* 231 */       xTeamMatchQueue.getActivitys().put(Integer.valueOf(newLevel), xNextLevelBeans);
/*     */     }
/* 233 */     xNextLevelBeans.getTeammatchmembers().add(Long.valueOf(roleId));
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
/*     */   private static boolean rmOldLevelBean(long roleId, int oldLevel, TeamMatchQueue xTeamMatchQueue)
/*     */   {
/* 246 */     TeamMatchBeans xTeamMatchBeans = (TeamMatchBeans)xTeamMatchQueue.getActivitys().get(Integer.valueOf(oldLevel));
/* 247 */     if (xTeamMatchBeans == null)
/*     */     {
/* 249 */       GameServer.logger().error(String.format("[teammatch]TeamQueueManager.rmOldLevelBean@ TeamMatchBeans not exist!|roleId=%d|oldLevel=%d|", new Object[] { Long.valueOf(roleId), Integer.valueOf(oldLevel) }));
/*     */       
/*     */ 
/*     */ 
/* 253 */       return false;
/*     */     }
/*     */     
/* 256 */     Set<Long> xMatchMembers = xTeamMatchBeans.getTeammatchmembers();
/* 257 */     if ((xMatchMembers == null) || (xMatchMembers.size() == 0))
/*     */     {
/* 259 */       return false;
/*     */     }
/*     */     
/* 262 */     if (!xMatchMembers.remove(Long.valueOf(roleId)))
/*     */     {
/*     */ 
/* 265 */       TeamMatchMananger.logger.error(String.format("[teamMatch]TeamQueueManager.rmOldLevelBean@ rm matchMember error! no this matchMember|roleId=%d|oldLevel=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(oldLevel) }));
/*     */       
/*     */ 
/* 268 */       return false;
/*     */     }
/* 270 */     return true;
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
/*     */ 
/*     */   static boolean onLeaderNeedLevelChange(long roleId, int levelLow, int levelHigh)
/*     */   {
/* 288 */     xdb.Lockeys.lock(Basic.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/*     */     
/*     */ 
/* 291 */     MatchQueue xMatchQueue = TeamMatchMananger.getMatchQueue(true);
/* 292 */     if (xMatchQueue == null)
/*     */     {
/* 294 */       return false;
/*     */     }
/*     */     
/* 297 */     MatchActivityCfg xRoleMatchInfo = (MatchActivityCfg)xMatchQueue.getRoleinfo().get(Long.valueOf(roleId));
/* 298 */     if (xRoleMatchInfo == null)
/*     */     {
/* 300 */       return false;
/*     */     }
/*     */     
/* 303 */     return onLeaderNeedLevelChange(roleId, levelLow, levelHigh, xMatchQueue, xRoleMatchInfo);
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean onLeaderNeedLevelChange(long roleId, int levelLow, int levelHigh, MatchQueue xMatchQueue, MatchActivityCfg xRoleMatchInfo)
/*     */   {
/* 309 */     int matchId = xRoleMatchInfo.getActivity().getActivityid();
/* 310 */     int index = xRoleMatchInfo.getActivity().getIndex();
/* 311 */     if (!changeRoleNeedLevel(roleId, levelLow, levelHigh, xRoleMatchInfo, matchId, index))
/*     */     {
/* 313 */       return false;
/*     */     }
/* 315 */     tryMatch(roleId, levelLow, levelHigh, xMatchQueue, matchId, index);
/*     */     
/* 317 */     return true;
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
/*     */   private static boolean changeRoleNeedLevel(long roleId, int levelLow, int levelHigh, MatchActivityCfg xRoleMatchInfo, int matchId, int index)
/*     */   {
/* 333 */     int level = RoleInterface.getLevel(roleId);
/* 334 */     List<Integer> levelArgs = TeamMatchMananger.getRealLevelGap(matchId, index, levelLow, levelHigh, level);
/* 335 */     if (!needChangeLevel(xRoleMatchInfo, levelArgs))
/*     */     {
/* 337 */       return false;
/*     */     }
/* 339 */     xRoleMatchInfo.setNeedlevellow(((Integer)levelArgs.get(0)).intValue());
/* 340 */     xRoleMatchInfo.setNeedlevelhigh(((Integer)levelArgs.get(1)).intValue());
/* 341 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean needChangeLevel(MatchActivityCfg roleInfo, List<Integer> levelArgs)
/*     */   {
/* 353 */     if ((levelArgs == null) || (levelArgs.size() <= 0))
/*     */     {
/* 355 */       return false;
/*     */     }
/* 357 */     int needLevelLowOld = roleInfo.getNeedlevellow();
/* 358 */     int needLevelLowHigh = roleInfo.getNeedlevelhigh();
/*     */     
/* 360 */     if ((needLevelLowOld <= ((Integer)levelArgs.get(0)).intValue()) && (needLevelLowHigh >= ((Integer)levelArgs.get(1)).intValue()))
/*     */     {
/* 362 */       return false;
/*     */     }
/* 364 */     return true;
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
/*     */   private static void tryMatch(long roleId, int levelLow, int levelHigh, MatchQueue matchQueue, int matchId, int index)
/*     */   {
/* 379 */     MatchCfg matchCfg = new MatchCfg();
/* 380 */     matchCfg.matchcfgid = matchId;
/* 381 */     matchCfg.index = index;
/* 382 */     tryMatch(roleId, matchCfg, levelLow, levelHigh, matchQueue);
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
/*     */   static boolean tryJoinLeaderTeam(long leaderId, List<Long> rolesSelected, int matchCfgId, MatchQueue xMatchQueue)
/*     */   {
/* 396 */     if (rolesSelected.size() > 0)
/*     */     {
/* 398 */       TeamInterface.rolesJoinTeamByLeaderId(leaderId, rolesSelected, matchCfgId);
/*     */     }
/* 400 */     return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<Long> findRightMember(long teamLeaderId, MatchCfg matchcfg, int level_low, int level_high, MatchQueue xMatchQueue)
/*     */   {
/* 421 */     List<Long> membersSelected = new java.util.ArrayList();
/* 422 */     int leaderLevel = RoleInterface.getLevel(teamLeaderId);
/* 423 */     List<Integer> levelArgs = TeamMatchMananger.getRealLevelGap(matchcfg.matchcfgid, matchcfg.index, level_low, level_high, leaderLevel);
/*     */     
/* 425 */     if ((levelArgs == null) || (levelArgs.size() == 0))
/*     */     {
/* 427 */       GameServer.logger().error(String.format("[teamMatch]RoleQueueManager.findRightTeams@队长查找队员时，取等级上下限失败!|roleId=%d|level=%d|matchcfgid=%d|index=%d|levelLow=%d|levelHigh=%d", new Object[] { Long.valueOf(teamLeaderId), Integer.valueOf(leaderLevel), Integer.valueOf(matchcfg.matchcfgid), Integer.valueOf(matchcfg.index), Integer.valueOf(level_low), Integer.valueOf(level_high) }));
/*     */       
/*     */ 
/*     */ 
/* 431 */       return membersSelected;
/*     */     }
/* 433 */     findRightMembersInActivityQueue(((Integer)levelArgs.get(0)).intValue(), ((Integer)levelArgs.get(1)).intValue(), xMatchQueue, membersSelected, matchcfg);
/* 434 */     TeamMatchMananger.rmUnNeedRoles(xMatchQueue, teamLeaderId, membersSelected);
/* 435 */     return membersSelected;
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
/*     */   static void findRightMembersInActivityQueue(int level_low, int level_high, MatchQueue xMatchQueue, List<Long> rolesSelected, MatchCfg matchCfg)
/*     */   {
/* 450 */     if (level_high < level_low)
/*     */     {
/* 452 */       return;
/*     */     }
/* 454 */     MatchKey xMatchKey = new MatchKey(matchCfg.matchcfgid, matchCfg.index);
/* 455 */     TeamMatchQueue xTeamMatchQueue = (TeamMatchQueue)xMatchQueue.getTeamqueue().get(xMatchKey);
/* 456 */     if (xTeamMatchQueue == null)
/*     */     {
/* 458 */       xTeamMatchQueue = Pod.newTeamMatchQueue();
/* 459 */       xMatchQueue.getTeamqueue().put(xMatchKey, xTeamMatchQueue);
/*     */     }
/*     */     
/*     */ 
/* 463 */     TeamMatchQueue xRoleMatchQueue = (TeamMatchQueue)xMatchQueue.getRolequeue().get(xMatchKey);
/* 464 */     if (xRoleMatchQueue == null)
/*     */     {
/* 466 */       return;
/*     */     }
/*     */     
/* 469 */     NavigableMap<Integer, TeamMatchBeans> selectRoleMap = xRoleMatchQueue.getActivitys().subMap(Integer.valueOf(level_low), true, Integer.valueOf(level_high), true);
/*     */     
/*     */ 
/* 472 */     for (TeamMatchBeans bean : selectRoleMap.values())
/*     */     {
/* 474 */       rolesSelected.addAll(bean.getTeammatchmembers());
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
/*     */   static boolean addTeamToQueue(long leaderId, MatchCfg matchCfg, int level_low, int level_high, MatchQueue xMatchQueue)
/*     */   {
/* 489 */     int level = RoleInterface.getLevel(leaderId);
/* 490 */     List<Integer> levelArgs = TeamMatchMananger.getRealLevelGap(matchCfg.matchcfgid, matchCfg.index, level_low, level_high, level);
/*     */     
/* 492 */     if ((levelArgs == null) || (levelArgs.size() == 0))
/*     */     {
/* 494 */       GameServer.logger().error(String.format("[teamMatch]TeamQueueManager.addTeamToQueue@获取活动等级上下限出错 |roleId=%d|roleLevel=%d|matchCfgId=%d|index=%d|level_low=%d|level_high=%d", new Object[] { Long.valueOf(leaderId), Integer.valueOf(level), Integer.valueOf(matchCfg.matchcfgid), Integer.valueOf(matchCfg.index), Integer.valueOf(level_low), Integer.valueOf(level_high) }));
/*     */       
/*     */ 
/*     */ 
/* 498 */       return false;
/*     */     }
/* 500 */     MatchKey xMatchKey = new MatchKey(matchCfg.matchcfgid, matchCfg.index);
/* 501 */     addTeamToActivityQueue(leaderId, level, ((Integer)levelArgs.get(0)).intValue(), ((Integer)levelArgs.get(1)).intValue(), xMatchQueue, matchCfg, xMatchKey);
/*     */     
/* 503 */     TeamMatchMananger.setMatchRoleBaseInfo(xMatchQueue, leaderId, level, level_low, level_high, levelArgs, xMatchKey, 1);
/*     */     
/* 505 */     return true;
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
/*     */   static void setSameTeamData(long leaderId, MatchQueue xMatchQueue)
/*     */   {
/* 519 */     Long teamId = TeamInterface.getTeamidByRoleid(leaderId, false);
/* 520 */     if (teamId == null)
/*     */     {
/*     */ 
/* 523 */       return;
/*     */     }
/* 525 */     if (!xMatchQueue.getRepeatleaderids().contains(Long.valueOf(leaderId)))
/*     */     {
/* 527 */       xMatchQueue.getRepeatleaderids().add(Long.valueOf(leaderId));
/* 528 */       new RepeatLeaderSession(TeamPlatformConsts.getInstance().MSG_IN_SEC, leaderId);
/*     */     }
/* 530 */     if (!xMatchQueue.getRepeatteamids().contains(teamId))
/*     */     {
/* 532 */       xMatchQueue.getRepeatteamids().add(teamId);
/* 533 */       new RepeatTeamSession(TeamPlatformConsts.getInstance().MSG_IN_SEC, teamId.longValue());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addTeamToActivityQueue(long leaderId, int roleLevel, int level_low, int level_high, MatchQueue matchQueue, MatchCfg activityCfg, MatchKey xMatchKey)
/*     */   {
/* 557 */     TeamMatchQueue xTeamMatchQueue = (TeamMatchQueue)matchQueue.getTeamqueue().get(xMatchKey);
/* 558 */     if (xTeamMatchQueue == null)
/*     */     {
/* 560 */       xTeamMatchQueue = Pod.newTeamMatchQueue();
/* 561 */       matchQueue.getTeamqueue().put(xMatchKey, xTeamMatchQueue);
/*     */     }
/*     */     
/* 564 */     TeamMatchBeans xTeamMatchBeans = (TeamMatchBeans)xTeamMatchQueue.getActivitys().get(Integer.valueOf(roleLevel));
/* 565 */     if (xTeamMatchBeans == null)
/*     */     {
/* 567 */       xTeamMatchBeans = Pod.newTeamMatchBeans();
/* 568 */       xTeamMatchQueue.getActivitys().put(Integer.valueOf(roleLevel), xTeamMatchBeans);
/*     */     }
/*     */     
/* 571 */     xTeamMatchBeans.getTeammatchmembers().add(Long.valueOf(leaderId));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\TeamQueueManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */