/*     */ package mzm.gsp.task.surprise;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity3.confbean.DayInfo;
/*     */ import mzm.gsp.activity3.confbean.PositionActionInfo;
/*     */ import mzm.gsp.activity3.confbean.SSurpriseAchievementCfg;
/*     */ import mzm.gsp.activity3.confbean.SSurpriseActionCfg;
/*     */ import mzm.gsp.activity3.confbean.SSurpriseActivityCfg;
/*     */ import mzm.gsp.activity3.confbean.SSurpriseItemTaskCfg;
/*     */ import mzm.gsp.activity3.confbean.STActionPositionCfg;
/*     */ import mzm.gsp.activity3.confbean.STActivityId2serverId;
/*     */ import mzm.gsp.activity3.confbean.STAllSurpriseGraph;
/*     */ import mzm.gsp.activity3.confbean.STSurpriseActionCfg;
/*     */ import mzm.gsp.activity3.confbean.ServerInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.SSurpriseNormalResult;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ 
/*     */ public class SurpriseTaskManager
/*     */ {
/*  35 */   private static String loggerTag = "[surprise]";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isActivitySwitchOpened(int activityId)
/*     */   {
/*  45 */     SSurpriseActivityCfg cfg = SSurpriseActivityCfg.get(activityId);
/*  46 */     if (cfg == null)
/*     */     {
/*  48 */       return false;
/*     */     }
/*  50 */     return mzm.gsp.open.main.OpenInterface.getOpenStatus(cfg.switchid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isSurpriseGraph(int graphId)
/*     */   {
/*  61 */     return getSurpriseGraphNeedFinishCount(graphId) > 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getSurpriseGraphNeedFinishCount(int graphId)
/*     */   {
/*  73 */     Integer count = (Integer)getSurpriseGraphInfo().get(Integer.valueOf(graphId));
/*  74 */     return count == null ? 0 : count.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Integer> getSurpriseGraphInfo()
/*     */   {
/*  84 */     STAllSurpriseGraph cfg = STAllSurpriseGraph.get(0);
/*  85 */     if (cfg == null)
/*     */     {
/*  87 */       return Collections.emptyMap();
/*     */     }
/*  89 */     return cfg.graphId2finishCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static SSurpriseActionCfg getSurpriseActionCfg(int mapId, int positionX, int positionY)
/*     */   {
/*  99 */     STSurpriseActionCfg cfg = STSurpriseActionCfg.get(mapId);
/* 100 */     if (cfg == null)
/*     */     {
/* 102 */       return null;
/*     */     }
/* 104 */     PositionActionInfo positionActionInfo = (PositionActionInfo)cfg.positinX2Info.get(Integer.valueOf(positionX));
/* 105 */     if (positionActionInfo == null)
/*     */     {
/* 107 */       return null;
/*     */     }
/* 109 */     Integer surpriseCfgId = (Integer)positionActionInfo.positionY2ActionInfo.get(Integer.valueOf(positionY));
/* 110 */     if (surpriseCfgId == null)
/*     */     {
/* 112 */       return null;
/*     */     }
/* 114 */     return SSurpriseActionCfg.get(surpriseCfgId.intValue());
/*     */   }
/*     */   
/*     */   static Set<SSurpriseActionCfg> getSurpriseActionCfg(int actionId, int mapId, int curX, int curY)
/*     */   {
/* 119 */     STSurpriseActionCfg cfg = STSurpriseActionCfg.get(mapId);
/* 120 */     if (cfg == null)
/*     */     {
/* 122 */       return null;
/*     */     }
/* 124 */     STActionPositionCfg positionCfg = STActionPositionCfg.get(actionId);
/* 125 */     if (positionCfg == null)
/*     */     {
/* 127 */       return null;
/*     */     }
/* 129 */     Set<SSurpriseActionCfg> actionCfgs = new HashSet();
/* 130 */     for (Iterator i$ = positionCfg.surpriseIds.iterator(); i$.hasNext();) { int actionCfgId = ((Integer)i$.next()).intValue();
/*     */       
/* 132 */       SSurpriseActionCfg actionCfg = SSurpriseActionCfg.get(actionCfgId);
/* 133 */       if ((actionCfg != null) && 
/*     */       
/*     */ 
/*     */ 
/* 137 */         (mapId == actionCfg.mapId) && 
/*     */         
/*     */ 
/*     */ 
/* 141 */         (isNearPosition(actionCfg.positionX, actionCfg.positionY, actionCfg.redius, curX, curY)))
/*     */       {
/*     */ 
/*     */ 
/* 145 */         actionCfgs.add(actionCfg); }
/*     */     }
/* 147 */     return actionCfgs;
/*     */   }
/*     */   
/*     */   private static boolean isNearPosition(int cfgX, int cfgY, int cfgR, int curX, int curY)
/*     */   {
/* 152 */     double curR = Math.sqrt(Math.pow(cfgX - curX, 2.0D) + Math.pow(cfgY - curY, 2.0D));
/* 153 */     return curR <= cfgR;
/*     */   }
/*     */   
/*     */   static boolean neverAcceptGraph(long roleId, int graphId, int finishCount)
/*     */   {
/* 158 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*     */ 
/* 161 */       return false;
/*     */     }
/*     */     
/* 164 */     if (!TaskInterface.isHaveGraphId(graphId))
/*     */     {
/* 166 */       loggerError("SurpriseTaskManager.neverAcceptGraph@ forbid: graph cfg is null!|roleId=%d|graphId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId) });
/*     */       
/* 168 */       return false;
/*     */     }
/*     */     
/* 171 */     if (TaskInterface.isHaveGraphId(roleId, graphId))
/*     */     {
/* 173 */       loggerError("SurpriseTaskManager.neverAcceptGraph@ in graphing!|roleId=%d|graphId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId) });
/* 174 */       return false;
/*     */     }
/*     */     
/* 177 */     int alreadyFinishCount = TaskInterface.getRoleGraphFinishCount(roleId, graphId);
/* 178 */     if (alreadyFinishCount >= finishCount)
/*     */     {
/* 180 */       loggerError("SurpriseTaskManager.neverAcceptGraph@ already finished!|roleId=%d|graphId=%d|alreadFinishedCount=%d|cfgFinishCount=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(alreadyFinishCount), Integer.valueOf(finishCount) });
/*     */       
/*     */ 
/* 183 */       return false;
/*     */     }
/* 185 */     return true;
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
/*     */   static boolean handAchievementGraph(long roleId, int achievementId, int activityId)
/*     */   {
/* 198 */     SSurpriseAchievementCfg cfg = SSurpriseAchievementCfg.get(achievementId);
/* 199 */     if (!canOpenAchievementGraph(roleId, achievementId, activityId, cfg))
/*     */     {
/*     */ 
/* 202 */       return false;
/*     */     }
/*     */     
/* 205 */     Lockeys.lock(xtable.User.getTable(), Arrays.asList(new String[] { RoleInterface.getUserId(roleId) }));
/*     */     
/* 207 */     Lockeys.lock(xtable.Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/*     */     
/* 209 */     if (!neverAcceptGraph(roleId, cfg.graphId, cfg.graphFinishCount))
/*     */     {
/* 211 */       loggerError("PAchievementGoalFinish.processImp@ already finished graph!|roleId=%d|achievementId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(achievementId) });
/*     */       
/*     */ 
/* 214 */       return false;
/*     */     }
/*     */     
/* 217 */     if (!TaskInterface.activeGraph(Long.valueOf(roleId), cfg.graphId))
/*     */     {
/* 219 */       loggerError("PAchievementGoalFinish.processImp@ activeGraph error!|roleId=%d|achievementId=%d|graphId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(achievementId), Integer.valueOf(cfg.graphId) });
/*     */       
/*     */ 
/* 222 */       return false;
/*     */     }
/*     */     
/* 225 */     tlogSurprise(RoleInterface.getUserId(roleId), roleId, 2, achievementId, cfg.graphId);
/* 226 */     return true;
/*     */   }
/*     */   
/*     */   private static boolean canOpenAchievementGraph(long roleId, int achievementId, int activityId, SSurpriseAchievementCfg cfg)
/*     */   {
/* 231 */     if (cfg == null)
/*     */     {
/* 233 */       loggerError("PAchievementGoalFinish.canOpenAchievementGraph@ not surprise achievement!|roleId=%d|achievementId=%d|activityId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(achievementId), Integer.valueOf(activityId) });
/*     */       
/*     */ 
/* 236 */       return false;
/*     */     }
/* 238 */     int level = RoleInterface.getLevel(roleId);
/* 239 */     if (level < cfg.joinLevel)
/*     */     {
/* 241 */       loggerError("PAchievementGoalFinish.canOpenAchievementGraph@ role level is not enough!|roleId=%d|level=%d|cfgLevel=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(level), Integer.valueOf(cfg.joinLevel) });
/*     */       
/*     */ 
/* 244 */       return false;
/*     */     }
/*     */     
/* 247 */     if (!isActivityValid(cfg.activityId))
/*     */     {
/* 249 */       loggerError("PAchievementGoalFinish.canOpenAchievementGraph@ activity is invalid!|roleId=%d|achievementId=%d|activityId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(achievementId), Integer.valueOf(cfg.activityId) });
/*     */       
/*     */ 
/* 252 */       return false;
/*     */     }
/* 254 */     if (!isServerlevelValid(cfg.joinServerLevel, cfg.needServerLevelTime))
/*     */     {
/* 256 */       loggerError("PAchievementGoalFinish.canOpenAchievementGraph@ server level is invalid!|roleId=%d|achievementId=%d|activityId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(achievementId), Integer.valueOf(cfg.activityId) });
/*     */       
/*     */ 
/* 259 */       return false;
/*     */     }
/* 261 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void triggerControllers(Set<Integer> serverIds)
/*     */   {
/* 271 */     Set<Integer> controllerIds = getAllControllerIds(serverIds);
/* 272 */     if (controllerIds.isEmpty())
/*     */     {
/* 274 */       return;
/*     */     }
/* 276 */     for (Iterator i$ = controllerIds.iterator(); i$.hasNext();) { int controllerId = ((Integer)i$.next()).intValue();
/*     */       
/* 278 */       mzm.gsp.map.main.ControllerInterface.triggerController(controllerId);
/*     */     }
/*     */   }
/*     */   
/*     */   private static Set<Integer> getAllControllerIds(Set<Integer> serverIds)
/*     */   {
/* 284 */     Set<Integer> controllerIds = new HashSet();
/* 285 */     for (Iterator i$ = serverIds.iterator(); i$.hasNext();) { int serverId = ((Integer)i$.next()).intValue();
/*     */       
/* 287 */       SSurpriseItemTaskCfg cfg = SSurpriseItemTaskCfg.get(serverId);
/* 288 */       if ((cfg != null) && 
/*     */       
/*     */ 
/*     */ 
/* 292 */         (cfg.npcControllerId > 0))
/*     */       {
/*     */ 
/*     */ 
/* 296 */         controllerIds.add(Integer.valueOf(serverId)); }
/*     */     }
/* 298 */     return controllerIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isActivityValid(int activityId)
/*     */   {
/* 310 */     if (!mzm.gsp.activity.main.ActivityInterface.isActivityOpen(activityId))
/*     */     {
/* 312 */       return false;
/*     */     }
/* 314 */     if (!isActivitySwitchOpened(activityId))
/*     */     {
/* 316 */       return false;
/*     */     }
/* 318 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isServerlevelValid(int joinServerLevel, int days)
/*     */   {
/* 323 */     if (mzm.gsp.server.main.ServerInterface.getCurrentServerLevel() < joinServerLevel)
/*     */     {
/* 325 */       return false;
/*     */     }
/* 327 */     if (days <= 0)
/*     */     {
/* 329 */       return true;
/*     */     }
/* 331 */     long serverLevelStartTime = ServerLevelCache.getInstance().getCeilStartTime(joinServerLevel) * 1000L;
/* 332 */     if (serverLevelStartTime <= 0L)
/*     */     {
/* 334 */       return false;
/*     */     }
/* 336 */     if (mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() - serverLevelStartTime < 86400000L * days)
/*     */     {
/* 338 */       return false;
/*     */     }
/* 340 */     return true;
/*     */   }
/*     */   
/*     */   static void checkAndInitSupriseTask(STActivityId2serverId activityCfg, int curServerLevel, long curTime)
/*     */   {
/* 345 */     if (activityCfg == null)
/*     */     {
/* 347 */       return;
/*     */     }
/* 349 */     for (Map.Entry<Integer, DayInfo> entry : activityCfg.serverLevel2DayInfo.entrySet())
/*     */     {
/* 351 */       needServerLevel = ((Integer)entry.getKey()).intValue();
/* 352 */       if (curServerLevel >= needServerLevel)
/*     */       {
/*     */ 
/*     */ 
/* 356 */         for (Map.Entry<Integer, ServerInfo> entry1 : ((DayInfo)entry.getValue()).day2ServerIds.entrySet())
/*     */         {
/* 358 */           int needDays = ((Integer)entry1.getKey()).intValue();
/* 359 */           Set<Integer> serverIds = ((ServerInfo)entry1.getValue()).serverIds;
/* 360 */           if (!serverIds.isEmpty())
/*     */           {
/*     */ 
/*     */ 
/* 364 */             long serverLevelStartTime = ServerLevelCache.getInstance().getCeilStartTime(needServerLevel) * 1000L;
/* 365 */             if (serverLevelStartTime > 0L)
/*     */             {
/*     */ 
/*     */ 
/* 369 */               long startTime = serverLevelStartTime + 86400000L * needDays;
/* 370 */               if (startTime > curTime)
/*     */               {
/*     */ 
/* 373 */                 new SurpriseItemStartSession((startTime - curTime) / 1000L, activityCfg.activityId, serverIds);
/*     */ 
/*     */               }
/*     */               else
/*     */               {
/* 378 */                 triggerControllers(serverIds);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     int needServerLevel;
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean needNoticeClient(int graphId)
/*     */   {
/* 392 */     STAllSurpriseGraph cfg = STAllSurpriseGraph.get(0);
/* 393 */     if (cfg == null)
/*     */     {
/* 395 */       return false;
/*     */     }
/* 397 */     return cfg.needSynGraphIds.contains(Integer.valueOf(graphId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getNeedSynGraphIds()
/*     */   {
/* 407 */     STAllSurpriseGraph cfg = STAllSurpriseGraph.get(0);
/* 408 */     if (cfg == null)
/*     */     {
/* 410 */       return Collections.emptySet();
/*     */     }
/* 412 */     return cfg.needSynGraphIds;
/*     */   }
/*     */   
/*     */   static void tlogSurprise(String userId, long roleId, int surpriseType, long subId, int graphId)
/*     */   {
/* 417 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 418 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 420 */     Object[] colums = { vGameIP, userId, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(surpriseType), Long.valueOf(subId), Integer.valueOf(graphId) };
/*     */     
/* 422 */     TLogManager.getInstance().addLog(roleId, "TriggerSurpriseTask", colums);
/*     */   }
/*     */   
/*     */   static void sendSurpriseNotice(long roleid, boolean afterSuc, int result, String... args)
/*     */   {
/* 427 */     SSurpriseNormalResult pro = new SSurpriseNormalResult();
/* 428 */     pro.result = result;
/* 429 */     for (String arg : args)
/*     */     {
/* 431 */       pro.args.add(arg);
/*     */     }
/* 433 */     if (afterSuc)
/*     */     {
/* 435 */       OnlineManager.getInstance().send(roleid, pro);
/*     */     }
/*     */     else
/*     */     {
/* 439 */       OnlineManager.getInstance().sendAtOnce(roleid, pro);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void loggerError(String format, Object... args)
/*     */   {
/* 448 */     GameServer.logger().error(loggerTag + String.format(format, args));
/*     */   }
/*     */   
/*     */   static void loggerInfo(String format, Object... args)
/*     */   {
/* 453 */     GameServer.logger().info(loggerTag + String.format(format, args));
/*     */   }
/*     */   
/*     */   static void loggerDebug(String format, Object... args)
/*     */   {
/* 458 */     if (!GameServer.logger().isDebugEnabled())
/*     */     {
/* 460 */       return;
/*     */     }
/* 462 */     GameServer.logger().debug(loggerTag + String.format(format, args));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\surprise\SurpriseTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */