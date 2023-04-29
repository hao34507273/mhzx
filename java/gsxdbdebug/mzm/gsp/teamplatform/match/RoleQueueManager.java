/*     */ package mzm.gsp.teamplatform.match;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.teamplatform.MatchCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MatchActivityCfg;
/*     */ import xbean.MatchKey;
/*     */ import xbean.MatchQueue;
/*     */ import xbean.Pod;
/*     */ import xbean.TeamMatchBeans;
/*     */ import xbean.TeamMatchQueue;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class RoleQueueManager
/*     */ {
/*  23 */   private static final Logger logger = Logger.getLogger(RoleQueueManager.class);
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
/*     */   static boolean startMatch(long roleId, MatchCfg matchCfg, int level_low, int level_high)
/*     */   {
/*  41 */     MatchQueue matchQueue = TeamMatchMananger.getMatchQueue(true);
/*  42 */     if (matchQueue == null)
/*     */     {
/*  44 */       TeamMatchMananger.creatMatchQueue();
/*  45 */       matchQueue = TeamMatchMananger.getMatchQueue(true);
/*     */     }
/*     */     
/*  48 */     if (!addRoleToQueue(roleId, matchCfg, level_low, level_high, matchQueue))
/*     */     {
/*  50 */       return false;
/*     */     }
/*  52 */     tryMatch(roleId, matchCfg, level_low, level_high, matchQueue);
/*  53 */     if (!TeamMatchMananger.beginSession(matchQueue, roleId, level_low, level_high, 0))
/*     */     {
/*  55 */       return false;
/*     */     }
/*  57 */     return true;
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
/*     */   static void tryMatch(long roleId, MatchCfg matchCfg, int level_low, int level_high, MatchQueue xMatchQueue)
/*     */   {
/*  71 */     List<Long> leadersSelected = findRightTeams(roleId, matchCfg, level_low, level_high, xMatchQueue);
/*  72 */     if (leadersSelected.size() > 0)
/*     */     {
/*  74 */       tryJoinTeam(roleId, leadersSelected, xMatchQueue);
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
/*     */   static boolean cancelMatch(long roleId, CancelMatchType cancelMatchType)
/*     */   {
/*  87 */     return cancelMatch(roleId, true, cancelMatchType);
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
/*     */   static boolean cancelMatch(long roleId, boolean needSend, CancelMatchType cancelMatchType)
/*     */   {
/* 100 */     if (!TeamMatchMananger.rmRoleMatchData(roleId, 0, cancelMatchType))
/*     */     {
/* 102 */       TeamMatchMananger.logger.error(String.format("[teamMatch]RoleQueueManager.cancelMatch@单人取消匹配失败！|roleId=%d|cancelMatchType=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(cancelMatchType.value) }));
/*     */       
/*     */ 
/* 105 */       return false;
/*     */     }
/* 107 */     if (!TeamMatchMananger.afterCancelMatch(roleId, needSend))
/*     */     {
/* 109 */       return false;
/*     */     }
/* 111 */     return true;
/*     */   }
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
/* 123 */     Lockeys.lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/*     */     
/*     */ 
/* 126 */     MatchQueue xMatchQueue = TeamMatchMananger.getMatchQueue(true);
/* 127 */     if (xMatchQueue == null)
/*     */     {
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     MatchActivityCfg xRoleMatchInfo = (MatchActivityCfg)xMatchQueue.getRoleinfo().get(Long.valueOf(roleId));
/* 133 */     if (xRoleMatchInfo == null)
/*     */     {
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     GameServer.logger().info(String.format("[teammatch]RoleQueue@level change |roleId=%d|oldLevel=%d|newLevel=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(oldLevel), Integer.valueOf(newLevel) }));
/*     */     
/*     */ 
/*     */ 
/* 142 */     int xRoleOldLevel = xRoleMatchInfo.getRolelevel();
/* 143 */     xRoleMatchInfo.setRolelevel(newLevel);
/*     */     
/* 145 */     MatchKey xMatchKey = xRoleMatchInfo.getActivity();
/*     */     
/* 147 */     TeamMatchQueue xRoleMatchQueue = (TeamMatchQueue)xMatchQueue.getRolequeue().get(xMatchKey);
/* 148 */     if (xRoleMatchQueue == null)
/*     */     {
/* 150 */       TeamMatchMananger.logger.error(String.format("[teamMatch]RoleQueueManager.onRoleLevelUp@xRoleMatchQueue not exist！|roleId=%d|oldLevel=%d|monCfgId=%d|index=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(xRoleOldLevel), Integer.valueOf(xMatchKey.getActivityid()), Integer.valueOf(xMatchKey.getIndex()) }));
/*     */       
/*     */ 
/* 153 */       return false;
/*     */     }
/* 155 */     TeamMatchBeans xRoleMatchBeans = (TeamMatchBeans)xRoleMatchQueue.getActivitys().get(Integer.valueOf(xRoleOldLevel));
/* 156 */     if (xRoleMatchBeans == null)
/*     */     {
/* 158 */       TeamMatchMananger.logger.error(String.format("[teamMatch]RoleQueueManager.onRoleLevelUp@xRoleMatchBeans not exist！|roleId=%d|oldLevel=%d|monCfgId=%d|index=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(xRoleOldLevel), Integer.valueOf(xMatchKey.getActivityid()), Integer.valueOf(xMatchKey.getIndex()) }));
/*     */       
/*     */ 
/* 161 */       return false;
/*     */     }
/* 163 */     Set<Long> xMembers = xRoleMatchBeans.getTeammatchmembers();
/* 164 */     if ((xMembers == null) || (xMembers.size() == 0))
/*     */     {
/* 166 */       return false;
/*     */     }
/* 168 */     if (!xMembers.remove(Long.valueOf(roleId)))
/*     */     {
/*     */ 
/* 171 */       TeamMatchMananger.logger.error(String.format("[teamMatch]RoleQueueManager.onRoleLevelUp@将玩家从原先等级队列中移除失败！|roleId=%d|oldLevel=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(xRoleOldLevel) }));
/*     */       
/* 173 */       return false;
/*     */     }
/*     */     
/* 176 */     TeamMatchBeans xNextLevelBeans = (TeamMatchBeans)xRoleMatchQueue.getActivitys().get(Integer.valueOf(newLevel));
/* 177 */     if (xNextLevelBeans == null)
/*     */     {
/* 179 */       xNextLevelBeans = Pod.newTeamMatchBeans();
/* 180 */       xRoleMatchQueue.getActivitys().put(Integer.valueOf(newLevel), xNextLevelBeans);
/*     */     }
/* 182 */     xNextLevelBeans.getTeammatchmembers().add(Long.valueOf(roleId));
/*     */     
/* 184 */     tryMatch(roleId, xRoleMatchInfo.getNeedlevellow(), xRoleMatchInfo.getNeedlevelhigh(), xMatchQueue, xRoleMatchInfo.getActivity().getActivityid(), xRoleMatchInfo.getActivity().getIndex());
/*     */     
/* 186 */     return true;
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
/*     */   static boolean onRoleNeedLevelChange(long roleId, int levelLow, int levelHigh)
/*     */   {
/* 200 */     Lockeys.lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/*     */     
/*     */ 
/* 203 */     MatchQueue xMatchQueue = TeamMatchMananger.getMatchQueue(true);
/* 204 */     if (xMatchQueue == null)
/*     */     {
/* 206 */       return false;
/*     */     }
/*     */     
/* 209 */     MatchActivityCfg xRoleMatchInfo = (MatchActivityCfg)xMatchQueue.getRoleinfo().get(Long.valueOf(roleId));
/* 210 */     if (xRoleMatchInfo == null)
/*     */     {
/* 212 */       return false;
/*     */     }
/*     */     
/* 215 */     int matchId = xRoleMatchInfo.getActivity().getActivityid();
/* 216 */     int index = xRoleMatchInfo.getActivity().getIndex();
/* 217 */     if (!changeRoleNeedLevel(levelLow, levelHigh, xRoleMatchInfo, matchId, index))
/*     */     {
/* 219 */       return false;
/*     */     }
/* 221 */     tryMatch(roleId, levelLow, levelHigh, xMatchQueue, matchId, index);
/* 222 */     return true;
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
/*     */   private static boolean changeRoleNeedLevel(int levelLow, int levelHigh, MatchActivityCfg xRoleMatchInfo, int matchId, int index)
/*     */   {
/* 237 */     List<Integer> levelArgs = TeamMatchMananger.getRealLevelGap(matchId, index, levelLow, levelHigh, -1);
/* 238 */     if ((levelArgs == null) || (levelArgs.size() <= 0))
/*     */     {
/* 240 */       return false;
/*     */     }
/* 242 */     xRoleMatchInfo.setNeedlevellow(((Integer)levelArgs.get(0)).intValue());
/* 243 */     xRoleMatchInfo.setNeedlevelhigh(((Integer)levelArgs.get(1)).intValue());
/* 244 */     return true;
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
/* 259 */     MatchCfg matchCfg = new MatchCfg();
/* 260 */     matchCfg.matchcfgid = matchId;
/* 261 */     matchCfg.index = index;
/*     */     
/* 263 */     tryMatch(roleId, matchCfg, levelLow, levelHigh, matchQueue);
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
/*     */   static boolean tryJoinTeam(long roleId, List<Long> leadersSelected, MatchQueue xMatchQueue)
/*     */   {
/* 277 */     if (leadersSelected.size() > 0)
/*     */     {
/* 279 */       mzm.gsp.team.main.TeamInterface.roleTryJoinTeamByLeaders(roleId, leadersSelected);
/*     */     }
/* 281 */     return true;
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
/*     */   static List<Long> findRightTeams(long roleId, MatchCfg matchCfg, int level_low, int level_high, MatchQueue xMatchQueue)
/*     */   {
/* 296 */     List<Long> leadersSelected = new java.util.ArrayList();
/* 297 */     List<Integer> levelArgs = TeamMatchMananger.getRealLevelGap(matchCfg.matchcfgid, matchCfg.index, level_low, level_high, -1);
/*     */     
/* 299 */     if ((levelArgs == null) || (levelArgs.size() <= 0))
/*     */     {
/* 301 */       GameServer.logger().error(String.format("[teamMatch]RoleQueueManager.findRightTeams@队员查找队伍时，取等级上下限失败!|roleId=%d|level=%d|matchcfgid=%d|index=%d|levelLow=%d|levelHigh=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(RoleInterface.getLevel(roleId)), Integer.valueOf(matchCfg.matchcfgid), Integer.valueOf(matchCfg.index), Integer.valueOf(level_low), Integer.valueOf(level_high) }));
/*     */       
/*     */ 
/*     */ 
/* 305 */       return leadersSelected;
/*     */     }
/* 307 */     findRightTeamsInActivityQueue(((Integer)levelArgs.get(0)).intValue(), ((Integer)levelArgs.get(1)).intValue(), xMatchQueue, leadersSelected, matchCfg);
/* 308 */     TeamMatchMananger.rmUnNeedRoles(xMatchQueue, roleId, leadersSelected);
/* 309 */     return leadersSelected;
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
/*     */   static void findRightTeamsInActivityQueue(int level_low, int level_high, MatchQueue matchQueue, List<Long> teamsSelected, MatchCfg matchCfg)
/*     */   {
/* 324 */     if (level_low > level_high)
/*     */     {
/* 326 */       return;
/*     */     }
/* 328 */     MatchKey xMatchKey = new MatchKey(matchCfg.matchcfgid, matchCfg.index);
/* 329 */     TeamMatchQueue xRoleMatchQueue = (TeamMatchQueue)matchQueue.getRolequeue().get(xMatchKey);
/* 330 */     if (xRoleMatchQueue == null)
/*     */     {
/* 332 */       xRoleMatchQueue = Pod.newTeamMatchQueue();
/* 333 */       matchQueue.getRolequeue().put(xMatchKey, xRoleMatchQueue);
/*     */     }
/* 335 */     TeamMatchQueue xTeamMatchQueue = (TeamMatchQueue)matchQueue.getTeamqueue().get(xMatchKey);
/* 336 */     if (xTeamMatchQueue == null)
/*     */     {
/* 338 */       return;
/*     */     }
/*     */     
/* 341 */     NavigableMap<Integer, TeamMatchBeans> selectRoleMap = xTeamMatchQueue.getActivitys().subMap(Integer.valueOf(level_low), true, Integer.valueOf(level_high), true);
/*     */     
/*     */ 
/* 344 */     for (TeamMatchBeans bean : selectRoleMap.values())
/*     */     {
/* 346 */       teamsSelected.addAll(bean.getTeammatchmembers());
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
/*     */   static boolean addRoleToQueue(long roleId, MatchCfg matchCfg, int level_low, int level_high, MatchQueue xMatchQueue)
/*     */   {
/* 361 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 362 */     List<Integer> levelArgs = TeamMatchMananger.getRealLevelGap(matchCfg.matchcfgid, matchCfg.index, level_low, level_high, -1);
/*     */     
/* 364 */     if ((levelArgs == null) || (levelArgs.size() == 0))
/*     */     {
/* 366 */       GameServer.logger().error(String.format("[teamMatch]RoleQueueManager.addRoleToQueue@ 加入组队平台失败，获取活动等级上下限出错|roleId=%d|roleLevel=%d|matchCfgId=%d|index=%d|levelLow=%d|levelHigh=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(roleLevel), Integer.valueOf(matchCfg.matchcfgid), Integer.valueOf(matchCfg.index), Integer.valueOf(level_low), Integer.valueOf(level_high) }));
/*     */       
/*     */ 
/*     */ 
/* 370 */       return false;
/*     */     }
/* 372 */     MatchKey xMatchKey = new MatchKey(matchCfg.matchcfgid, matchCfg.index);
/* 373 */     addRoleToActivityQueue(roleId, ((Integer)levelArgs.get(0)).intValue(), ((Integer)levelArgs.get(1)).intValue(), xMatchQueue, matchCfg, xMatchKey);
/* 374 */     TeamMatchMananger.setMatchRoleBaseInfo(xMatchQueue, roleId, roleLevel, level_low, level_high, levelArgs, xMatchKey, 0);
/*     */     
/* 376 */     return true;
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
/*     */   static void addRoleToActivityQueue(long roleId, int level_low, int level_high, MatchQueue xMatchQueue, MatchCfg matchCfg, MatchKey matchKey)
/*     */   {
/* 391 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 392 */     TeamMatchQueue xRoleMatchQueue = (TeamMatchQueue)xMatchQueue.getRolequeue().get(matchKey);
/* 393 */     if (xRoleMatchQueue == null)
/*     */     {
/* 395 */       xRoleMatchQueue = Pod.newTeamMatchQueue();
/* 396 */       xMatchQueue.getRolequeue().put(matchKey, xRoleMatchQueue);
/*     */     }
/*     */     
/* 399 */     TeamMatchBeans xRoleMatchBeans = (TeamMatchBeans)xRoleMatchQueue.getActivitys().get(Integer.valueOf(roleLevel));
/* 400 */     if (xRoleMatchBeans == null)
/*     */     {
/* 402 */       xRoleMatchBeans = Pod.newTeamMatchBeans();
/* 403 */       xRoleMatchQueue.getActivitys().put(Integer.valueOf(roleLevel), xRoleMatchBeans);
/*     */     }
/*     */     
/* 406 */     xRoleMatchBeans.getTeammatchmembers().add(Long.valueOf(roleId));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\RoleQueueManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */