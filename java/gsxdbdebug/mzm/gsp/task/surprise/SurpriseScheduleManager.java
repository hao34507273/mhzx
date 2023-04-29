/*     */ package mzm.gsp.task.surprise;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity3.confbean.SSurpriseGraphTotalInfo;
/*     */ import mzm.gsp.activity3.confbean.SSurpriseScheduleCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.task.SNewSurpriseGraphNotice;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.DaySessionInfo;
/*     */ import xbean.GlobalSurpriseScheduleInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Globalsurpriseschedule;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SurpriseScheduleManager
/*     */ {
/*     */   static Set<Integer> getNeedOpenGraphIds(int needServerLevel, int needDay)
/*     */   {
/*  34 */     Set<Integer> newGraphIds = new HashSet();
/*  35 */     SSurpriseScheduleCfg cfg = SSurpriseScheduleCfg.get(needServerLevel);
/*  36 */     if (cfg == null)
/*     */     {
/*  38 */       return newGraphIds;
/*     */     }
/*  40 */     SSurpriseGraphTotalInfo totalInfo = (SSurpriseGraphTotalInfo)cfg.dayScheduleInfos.get(Integer.valueOf(needDay));
/*  41 */     if (totalInfo == null)
/*     */     {
/*  43 */       return newGraphIds;
/*     */     }
/*  45 */     newGraphIds.addAll(totalInfo.graphInfos.keySet());
/*  46 */     return newGraphIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void newGraphNotice(long roleId, Set<Integer> newGraphIds)
/*     */   {
/*  57 */     if ((newGraphIds == null) || (newGraphIds.isEmpty()))
/*     */     {
/*  59 */       return;
/*     */     }
/*  61 */     SNewSurpriseGraphNotice p = new SNewSurpriseGraphNotice();
/*  62 */     p.newgraphids.addAll(newGraphIds);
/*  63 */     OnlineManager.getInstance().send(roleId, p);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onServerStarted()
/*     */   {
/*  71 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*     */ 
/*  78 */         SurpriseTaskScheduleInfo scheduleInfo = SurpriseScheduleManager.getSchedule();
/*  79 */         SurpriseTaskManager.loggerInfo(String.format("surprise init:%s", new Object[] { scheduleInfo.getSessionOverTime() }), new Object[0]);
/*  80 */         GlobalSurpriseScheduleInfo xGlobalSurpriseScheduleInfo = SurpriseScheduleManager.getXGlobalSurpriseScheduleInfoIfAbsent();
/*     */         
/*  82 */         SurpriseScheduleManager.initGlobalSessions(xGlobalSurpriseScheduleInfo, scheduleInfo.needMonitorInfo);
/*     */         
/*  84 */         SurpriseScheduleManager.initGlobalOpenedGraphIds(scheduleInfo.doneGraphIds, xGlobalSurpriseScheduleInfo);
/*  85 */         return true;
/*     */       }
/*     */     }.execute();
/*     */   }
/*     */   
/*     */   static GlobalSurpriseScheduleInfo getXGlobalSurpriseScheduleInfoIfAbsent()
/*     */   {
/*  92 */     GlobalSurpriseScheduleInfo xGlobalSurpriseScheduleInfo = Globalsurpriseschedule.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  93 */     if (xGlobalSurpriseScheduleInfo == null)
/*     */     {
/*  95 */       Globalsurpriseschedule.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xGlobalSurpriseScheduleInfo = Pod.newGlobalSurpriseScheduleInfo());
/*     */     }
/*     */     
/*  98 */     return xGlobalSurpriseScheduleInfo;
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
/*     */   Set<Long> initXOpenedGraphIds(Set<Long> newGraphIds, Set<Long> orgGraphIds)
/*     */   {
/* 111 */     Set<Long> addGraphIds = getNewAddGraphIds(newGraphIds, orgGraphIds);
/*     */     
/* 113 */     orgGraphIds.clear();
/*     */     
/* 115 */     orgGraphIds.addAll(newGraphIds);
/* 116 */     return addGraphIds;
/*     */   }
/*     */   
/*     */   private Set<Long> getNewAddGraphIds(Set<Long> newGraphIds, Set<Long> orgGraphIds)
/*     */   {
/* 121 */     Set<Long> addGraphIds = new HashSet();
/* 122 */     if (orgGraphIds.isEmpty())
/*     */     {
/* 124 */       addGraphIds.addAll(newGraphIds);
/* 125 */       return addGraphIds;
/*     */     }
/* 127 */     for (Iterator i$ = newGraphIds.iterator(); i$.hasNext();) { long graphId = ((Long)i$.next()).longValue();
/*     */       
/* 129 */       if (!orgGraphIds.contains(Long.valueOf(graphId)))
/*     */       {
/*     */ 
/*     */ 
/* 133 */         addGraphIds.add(Long.valueOf(graphId)); }
/*     */     }
/* 135 */     return addGraphIds;
/*     */   }
/*     */   
/*     */   static SurpriseTaskScheduleInfo getSchedule()
/*     */   {
/* 140 */     SurpriseTaskScheduleInfo info = new SurpriseTaskScheduleInfo();
/* 141 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 142 */     int curServerLevel = ServerInterface.getCurrentServerLevel();
/* 143 */     for (SSurpriseScheduleCfg cfg : SSurpriseScheduleCfg.getAll().values())
/*     */     {
/* 145 */       int needServerLevel = cfg.needServerLevel;
/* 146 */       if (curServerLevel >= needServerLevel)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 151 */         long serverLevelStartTime = ServerLevelCache.getInstance().getCeilStartTime(needServerLevel) * 1000L;
/* 152 */         if (serverLevelStartTime > 0L)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 157 */           checkAllDayGraphInfo(curTime, cfg, needServerLevel, serverLevelStartTime, info); }
/*     */       } }
/* 159 */     return info;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void checkAllDayGraphInfo(long curTime, SSurpriseScheduleCfg cfg, int needServerLevel, long serverLevelStartTime, SurpriseTaskScheduleInfo info)
/*     */   {
/* 171 */     for (Map.Entry<Integer, SSurpriseGraphTotalInfo> entry : cfg.dayScheduleInfos.entrySet())
/*     */     {
/*     */ 
/* 174 */       long interval = serverLevelStartTime + 86400000L * ((Integer)entry.getKey()).intValue() - curTime;
/* 175 */       if (interval <= 0L)
/*     */       {
/*     */ 
/* 178 */         info.doneGraphIds.addAll(((SSurpriseGraphTotalInfo)entry.getValue()).graphInfos.keySet());
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 183 */         addMonitor(needServerLevel, interval, ((Integer)entry.getKey()).intValue(), info);
/*     */       }
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
/*     */   private static void addMonitor(int needServerLevel, long interval, int day, SurpriseTaskScheduleInfo info)
/*     */   {
/* 197 */     Map<Integer, Long> dayInfos = (Map)info.needMonitorInfo.get(Integer.valueOf(needServerLevel));
/* 198 */     if (dayInfos == null)
/*     */     {
/* 200 */       info.needMonitorInfo.put(Integer.valueOf(needServerLevel), dayInfos = new HashMap());
/*     */     }
/* 202 */     dayInfos.put(Integer.valueOf(day), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(interval)));
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
/*     */   static void initGlobalOpenedGraphIds(Set<Integer> cfgOpenedGraphIds, GlobalSurpriseScheduleInfo xGlobalSurpriseScheduleInfo)
/*     */   {
/* 215 */     xGlobalSurpriseScheduleInfo.getOpenedgraphids().clear();
/*     */     
/* 217 */     xGlobalSurpriseScheduleInfo.getOpenedgraphids().addAll(cfgOpenedGraphIds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Map<Integer, Long>> startSections(Map<Integer, Map<Integer, Long>> needMonitorInfo)
/*     */   {
/* 228 */     Map<Integer, Map<Integer, Long>> sessionInfos = new HashMap();
/* 229 */     for (Map.Entry<Integer, Map<Integer, Long>> entry : needMonitorInfo.entrySet())
/*     */     {
/* 231 */       needServerLevel = ((Integer)entry.getKey()).intValue();
/* 232 */       for (Map.Entry<Integer, Long> dayEntry : ((Map)entry.getValue()).entrySet())
/*     */       {
/* 234 */         int needDay = ((Integer)dayEntry.getKey()).intValue();
/* 235 */         long sessionId = new PStartServerLevelSession(((Long)dayEntry.getValue()).longValue(), needServerLevel, needDay).getSessionId();
/* 236 */         Map<Integer, Long> day2SessionId = (Map)sessionInfos.get(Integer.valueOf(needServerLevel));
/* 237 */         if (day2SessionId == null)
/*     */         {
/* 239 */           sessionInfos.put(Integer.valueOf(needServerLevel), day2SessionId = new HashMap());
/*     */         }
/* 241 */         day2SessionId.put(Integer.valueOf(needDay), Long.valueOf(sessionId));
/*     */       } }
/*     */     int needServerLevel;
/* 244 */     return sessionInfos;
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
/*     */   static void initGlobalSessions(GlobalSurpriseScheduleInfo xGlobalSurpriseScheduleInfo, Map<Integer, Map<Integer, Long>> sessionInfos)
/*     */   {
/* 257 */     stopAllGlobalSessions(xGlobalSurpriseScheduleInfo);
/*     */     
/* 259 */     xGlobalSurpriseScheduleInfo.getSessioninfos().clear();
/*     */     
/* 261 */     Map<Integer, Map<Integer, Long>> startedSessionIds = startSections(sessionInfos);
/*     */     
/* 263 */     recordNewSessions(xGlobalSurpriseScheduleInfo, startedSessionIds);
/*     */     
/* 265 */     xGlobalSurpriseScheduleInfo.setEffectserverlevel(ServerInterface.getCurrentServerLevel());
/*     */   }
/*     */   
/*     */   static boolean onServerLevelChange()
/*     */   {
/* 270 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 271 */     int curServerLevel = ServerInterface.getCurrentServerLevel();
/* 272 */     GlobalSurpriseScheduleInfo xGlobalScheduleInfo = getXGlobalSurpriseScheduleInfoIfAbsent();
/* 273 */     int effectServerLevel = xGlobalScheduleInfo.getEffectserverlevel();
/* 274 */     if (effectServerLevel >= curServerLevel)
/*     */     {
/* 276 */       return false;
/*     */     }
/* 278 */     SurpriseTaskScheduleInfo info = new SurpriseTaskScheduleInfo();
/* 279 */     for (SSurpriseScheduleCfg cfg : SSurpriseScheduleCfg.getAll().values())
/*     */     {
/* 281 */       int needServerLevel = cfg.needServerLevel;
/* 282 */       if ((curServerLevel >= needServerLevel) && 
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 287 */         (effectServerLevel < needServerLevel))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 292 */         long serverLevelStartTime = ServerLevelCache.getInstance().getCeilStartTime(needServerLevel) * 1000L;
/* 293 */         if (serverLevelStartTime > 0L)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 298 */           checkAllDayGraphInfo(curTime, cfg, needServerLevel, serverLevelStartTime, info); }
/*     */       }
/*     */     }
/* 301 */     updateGlobalSchedule(xGlobalScheduleInfo, info);
/* 302 */     return true;
/*     */   }
/*     */   
/*     */   private static void updateGlobalSchedule(GlobalSurpriseScheduleInfo xGlobalScheduleInfo, SurpriseTaskScheduleInfo info)
/*     */   {
/* 307 */     if (info.needMonitorInfo.isEmpty())
/*     */     {
/* 309 */       return;
/*     */     }
/*     */     
/* 312 */     Map<Integer, Map<Integer, Long>> startedSessionIds = startSections(info.needMonitorInfo);
/*     */     
/* 314 */     recordNewSessions(xGlobalScheduleInfo, startedSessionIds);
/*     */     
/* 316 */     xGlobalScheduleInfo.setEffectserverlevel(ServerInterface.getCurrentServerLevel());
/*     */     
/* 318 */     xGlobalScheduleInfo.getOpenedgraphids().addAll(info.doneGraphIds);
/*     */     
/* 320 */     synNewSurpriseGraph();
/*     */   }
/*     */   
/*     */   static void synNewSurpriseGraph()
/*     */   {
/* 325 */     for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 327 */       NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */       {
/*     */ 
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/* 333 */           return RoleCheckSurpriseGraph.checkRoleSurpriseSchedule(this.val$roleId);
/*     */         }
/*     */       });
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
/*     */   private static void recordNewSessions(GlobalSurpriseScheduleInfo xGlobalSurpriseScheduleInfo, Map<Integer, Map<Integer, Long>> sessionInfos)
/*     */   {
/* 348 */     for (Map.Entry<Integer, Map<Integer, Long>> entry : sessionInfos.entrySet())
/*     */     {
/* 350 */       int needServerLevel = ((Integer)entry.getKey()).intValue();
/* 351 */       DaySessionInfo xDaySessionInfo = (DaySessionInfo)xGlobalSurpriseScheduleInfo.getSessioninfos().get(Integer.valueOf(needServerLevel));
/* 352 */       if (xDaySessionInfo == null)
/*     */       {
/* 354 */         xGlobalSurpriseScheduleInfo.getSessioninfos().put(Integer.valueOf(needServerLevel), xDaySessionInfo = Pod.newDaySessionInfo());
/*     */       }
/*     */       
/* 357 */       xDaySessionInfo.getSessionids().clear();
/* 358 */       xDaySessionInfo.getSessionids().putAll((Map)entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void stopAllGlobalSessions(GlobalSurpriseScheduleInfo xGlobalSurpriseScheduleInfo)
/*     */   {
/* 369 */     for (Map.Entry<Integer, DaySessionInfo> xEntry : xGlobalSurpriseScheduleInfo.getSessioninfos().entrySet())
/*     */     {
/* 371 */       for (i$ = ((DaySessionInfo)xEntry.getValue()).getSessionids().values().iterator(); i$.hasNext();) { long sessionId = ((Long)i$.next()).longValue();
/*     */         
/* 373 */         Session.removeSession(sessionId);
/*     */       }
/*     */     }
/*     */     Iterator i$;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\surprise\SurpriseScheduleManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */