/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg;
/*     */ import mzm.gsp.crossserver.main.RoamedPointRaceContext;
/*     */ 
/*     */ public class PointRaceZoneManager
/*     */ {
/*     */   public final long worldid;
/*     */   public final int activityCfgid;
/*     */   public final int zone;
/*     */   public final int timePointCfgid;
/*     */   public final long startTime;
/*     */   public final SCrossBattlePointCfg crossBattlePointCfg;
/*     */   public final int index;
/*     */   public final byte backup;
/*     */   
/*     */   public PointRaceZoneManager(long worldid, int activityCfgid, int zone, int timePointCfgid, long startTime, int index, byte backup)
/*     */   {
/*  22 */     this.worldid = worldid;
/*  23 */     this.activityCfgid = activityCfgid;
/*  24 */     this.zone = zone;
/*  25 */     this.timePointCfgid = timePointCfgid;
/*  26 */     this.startTime = startTime;
/*  27 */     this.crossBattlePointCfg = SCrossBattlePointCfg.get(this.activityCfgid);
/*  28 */     if (this.crossBattlePointCfg == null)
/*     */     {
/*  30 */       throw new java.security.InvalidParameterException("activity_cfgid)");
/*     */     }
/*  32 */     this.index = index;
/*  33 */     this.backup = backup;
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
/*  48 */   private PointRaceCorpsManager corpsManager = new PointRaceCorpsManager();
/*     */   
/*  50 */   private final PointRaceChart chart = new PointRaceChart(500, 500);
/*  51 */   private final PointRaceGatherChart gatherChart = new PointRaceGatherChart(500, 500);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  56 */   private final ReadWriteLock rwLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*  57 */   private final Map<Long, RoamedPointRaceContext> roamedContexts = new java.util.HashMap();
/*  58 */   private final Map<Long, Long> role2Corps = new java.util.HashMap();
/*     */   
/*     */ 
/*     */   private MatchObserver matchObserver;
/*     */   
/*     */ 
/*     */   private ReportCVCObserver cvcObserver;
/*     */   
/*     */ 
/*     */   private long checkCVCTime;
/*     */   
/*     */ 
/*     */ 
/*     */   public PointRaceCorpsManager getCorpsManager()
/*     */   {
/*  73 */     return this.corpsManager;
/*     */   }
/*     */   
/*     */   public PointRaceChart getChart()
/*     */   {
/*  78 */     return this.chart;
/*     */   }
/*     */   
/*     */   public PointRaceGatherChart getGatherChart()
/*     */   {
/*  83 */     return this.gatherChart;
/*     */   }
/*     */   
/*     */   public void put(long corpsid, int zoneid, PointRaceCorpsPreInfo preInfo)
/*     */   {
/*  88 */     this.corpsManager.put(corpsid, zoneid, preInfo);
/*     */     
/*  90 */     PointRaceChartObj chartObj = new PointRaceChartObj(corpsid, 0, preInfo.zoneid, preInfo.name, preInfo.icon, 0L);
/*  91 */     this.chart.rank(chartObj);
/*     */     
/*  93 */     PointRaceChartObj gatherChartObj = new PointRaceChartObj(corpsid, preInfo.point, preInfo.zoneid, preInfo.name, preInfo.icon, preInfo.updateTime);
/*     */     
/*  95 */     this.gatherChart.rank(gatherChartObj);
/*     */   }
/*     */   
/*     */   public boolean put(long corpsid, java.util.List<Long> roleids, PointRaceCorpsCurInfo corpsCurInfo)
/*     */   {
/* 100 */     this.corpsManager.put(corpsid, roleids, corpsCurInfo);
/*     */     
/* 102 */     PointRaceCorpsPreInfo corpsPreInfo = this.corpsManager.getCorpsPreInfo(corpsid);
/* 103 */     if (corpsPreInfo == null)
/*     */     {
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     long curUpdateTime = corpsCurInfo.updateTime;
/* 109 */     PointRaceChartObj chartObj = new PointRaceChartObj(corpsid, corpsCurInfo.point, corpsPreInfo.zoneid, corpsPreInfo.name, corpsPreInfo.icon, curUpdateTime);
/*     */     
/* 111 */     this.chart.rank(chartObj);
/*     */     
/* 113 */     long preUpdateTime = corpsPreInfo.updateTime;
/* 114 */     long time = curUpdateTime > preUpdateTime ? curUpdateTime : preUpdateTime;
/* 115 */     PointRaceChartObj gatherChartObj = new PointRaceChartObj(corpsid, corpsCurInfo.point + corpsPreInfo.point, corpsPreInfo.zoneid, corpsPreInfo.name, corpsPreInfo.icon, time);
/*     */     
/*     */ 
/* 118 */     this.gatherChart.rank(gatherChartObj);
/*     */     
/* 120 */     return true;
/*     */   }
/*     */   
/*     */   public void updateChart(long corpsid)
/*     */   {
/* 125 */     PointRaceCorpsPreInfo corpsPreInfo = this.corpsManager.getCorpsPreInfo(corpsid);
/* 126 */     if (corpsPreInfo == null)
/*     */     {
/* 128 */       return;
/*     */     }
/* 130 */     PointRaceCorpsCurInfo corpsCurInfo = this.corpsManager.getCorpsCurInfo(corpsid);
/* 131 */     if (corpsCurInfo == null)
/*     */     {
/* 133 */       return;
/*     */     }
/* 135 */     PointRaceCorpsFightInfo corpsFightInfo = this.corpsManager.getCorpsFightInfo(corpsid);
/* 136 */     if (corpsFightInfo == null)
/*     */     {
/* 138 */       return;
/*     */     }
/*     */     
/* 141 */     long curUpdateTime = corpsCurInfo.updateTime;
/* 142 */     PointRaceChartObj chartObj = new PointRaceChartObj(corpsid, corpsCurInfo.point, corpsPreInfo.zoneid, corpsPreInfo.name, corpsPreInfo.icon, curUpdateTime);
/*     */     
/* 144 */     this.chart.rank(chartObj);
/*     */     
/* 146 */     PointRaceChartObj gatherChartObj = new PointRaceChartObj(corpsid, corpsCurInfo.point + corpsPreInfo.point, corpsPreInfo.zoneid, corpsPreInfo.name, corpsPreInfo.icon, curUpdateTime);
/*     */     
/*     */ 
/* 149 */     this.gatherChart.rank(gatherChartObj);
/*     */   }
/*     */   
/*     */   public void setMatchObserver(MatchObserver observer)
/*     */   {
/* 154 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 157 */       this.matchObserver = observer;
/*     */     }
/*     */     finally
/*     */     {
/* 161 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeMatchObserver()
/*     */   {
/* 167 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 170 */       if (this.matchObserver != null)
/*     */       {
/* 172 */         this.matchObserver.stopTimer();
/* 173 */         this.matchObserver = null;
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 178 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setCVCObserver(ReportCVCObserver observer)
/*     */   {
/* 184 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 187 */       this.cvcObserver = observer;
/*     */     }
/*     */     finally
/*     */     {
/* 191 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public long getAndSetCheckCVCTime(long time)
/*     */   {
/* 197 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 200 */       long result = this.checkCVCTime;
/* 201 */       this.checkCVCTime = time;
/* 202 */       return result;
/*     */     }
/*     */     finally
/*     */     {
/* 206 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void clear()
/*     */   {
/* 212 */     this.chart.clear();
/* 213 */     this.gatherChart.clear();
/* 214 */     this.corpsManager.clear();
/*     */     
/* 216 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 219 */       for (RoamedPointRaceContext context : this.roamedContexts.values())
/*     */       {
/* 221 */         for (mzm.gsp.crossserver.main.RoamedRolePointRaceMarkingInfo roamedRoleInfo : context.roamedRoleInfos)
/*     */         {
/* 223 */           new PPointRaceReturnSourceServer(this.worldid, roamedRoleInfo.getUserid(), roamedRoleInfo.getRoleid()).execute();
/*     */         }
/*     */       }
/* 226 */       this.roamedContexts.clear();
/*     */       
/* 228 */       if (this.matchObserver != null)
/*     */       {
/* 230 */         this.matchObserver.stopTimer();
/* 231 */         this.matchObserver = null;
/*     */       }
/* 233 */       if (this.cvcObserver != null)
/*     */       {
/* 235 */         this.cvcObserver.stopTimer();
/* 236 */         this.cvcObserver = null;
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 241 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public RoamedPointRaceContext addRoamedContext(long corpsid, java.util.List<mzm.gsp.crossserver.main.RoamedRolePointRaceMarkingInfo> roleInfos, PointRaceCorpsCurInfo corpsCurInfo)
/*     */   {
/* 249 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 252 */       if (this.roamedContexts.containsKey(Long.valueOf(corpsid)))
/*     */       {
/* 254 */         return null;
/*     */       }
/* 256 */       RoamedPointRaceContext context = new RoamedPointRaceContext(this.worldid, corpsid, roleInfos, corpsCurInfo);
/* 257 */       for (mzm.gsp.crossserver.main.RoamedRolePointRaceMarkingInfo info : roleInfos)
/*     */       {
/* 259 */         this.role2Corps.put(Long.valueOf(info.getRoleid()), Long.valueOf(corpsid));
/*     */       }
/* 261 */       this.roamedContexts.put(Long.valueOf(corpsid), context);
/* 262 */       return context;
/*     */     }
/*     */     finally
/*     */     {
/* 266 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public RoamedPointRaceContext removeRoamedContext(long corpsid)
/*     */   {
/* 272 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 275 */       RoamedPointRaceContext context = (RoamedPointRaceContext)this.roamedContexts.remove(Long.valueOf(corpsid));
/* 276 */       if (context != null)
/*     */       {
/* 278 */         for (mzm.gsp.crossserver.main.RoamedRolePointRaceMarkingInfo roleInfo : context.roamedRoleInfos)
/*     */         {
/* 280 */           this.role2Corps.remove(Long.valueOf(roleInfo.getRoleid()));
/*     */         }
/*     */       }
/* 283 */       return context;
/*     */     }
/*     */     finally
/*     */     {
/* 287 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public RoamedPointRaceContext getRoamedContext(long corpsid)
/*     */   {
/* 293 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 296 */       return (RoamedPointRaceContext)this.roamedContexts.get(Long.valueOf(corpsid));
/*     */     }
/*     */     finally
/*     */     {
/* 300 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public RoamedPointRaceContext getRoamedContextByRoleid(long roleid)
/*     */   {
/* 306 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 309 */       Long corpsid = (Long)this.role2Corps.get(Long.valueOf(roleid));
/* 310 */       RoamedPointRaceContext localRoamedPointRaceContext; if (corpsid == null)
/*     */       {
/* 312 */         return null;
/*     */       }
/* 314 */       return (RoamedPointRaceContext)this.roamedContexts.get(corpsid);
/*     */     }
/*     */     finally
/*     */     {
/* 318 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isReLogin(long roleid)
/*     */   {
/* 324 */     return this.corpsManager.getCorpsid(roleid) != null;
/*     */   }
/*     */   
/*     */   public int getMatchDurationInMinute()
/*     */   {
/* 329 */     return this.crossBattlePointCfg.matchDurationInMinute;
/*     */   }
/*     */   
/*     */   public int getUnMatchDurationInMinute()
/*     */   {
/* 334 */     return this.crossBattlePointCfg.durationInMinute - this.crossBattlePointCfg.prepareDurationInMinute - this.crossBattlePointCfg.matchDurationInMinute;
/*     */   }
/*     */   
/*     */   public int getReturnOriginalCountDown()
/*     */   {
/* 339 */     return this.crossBattlePointCfg.endFightCountDown;
/*     */   }
/*     */   
/*     */   public int getMatchInterval()
/*     */   {
/* 344 */     return this.crossBattlePointCfg.matchIntervalSecond;
/*     */   }
/*     */   
/*     */   public int getReservedNum()
/*     */   {
/* 349 */     int corpsNum = this.corpsManager.getCorpsNum();
/* 350 */     return corpsNum * CrossBattlePointManager.TEAM_SIZE;
/*     */   }
/*     */   
/*     */   public int getOnlineNum()
/*     */   {
/* 355 */     int onlineCorpsNum = this.corpsManager.getOnlineCorpsNum();
/* 356 */     return onlineCorpsNum * CrossBattlePointManager.TEAM_SIZE;
/*     */   }
/*     */   
/*     */   public void sendStage(java.util.List<Long> roleids)
/*     */   {
/* 361 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 362 */     long startTime = this.startTime;
/* 363 */     SCrossBattlePointCfg crossBattlePointCfg = this.crossBattlePointCfg;
/* 364 */     int prepareDurationInMinute = crossBattlePointCfg.prepareDurationInMinute;
/*     */     
/* 366 */     long delay = startTime + java.util.concurrent.TimeUnit.MINUTES.toMillis(prepareDurationInMinute) - now;
/* 367 */     if (delay > 0L)
/*     */     {
/* 369 */       for (java.util.Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/* 371 */         CrossBattlePointManager.syncPointRaceStage(roleid, this.zone, this.index, this.backup, 0, delay);
/*     */       }
/*     */       
/* 374 */       return;
/*     */     }
/*     */     
/* 377 */     int matchDurationInMinute = crossBattlePointCfg.matchDurationInMinute;
/* 378 */     delay += java.util.concurrent.TimeUnit.MINUTES.toMillis(matchDurationInMinute);
/* 379 */     if (delay > 0L)
/*     */     {
/* 381 */       for (java.util.Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/* 383 */         CrossBattlePointManager.syncPointRaceStage(roleid, this.zone, this.index, this.backup, 1, delay);
/*     */       }
/*     */       
/* 386 */       return;
/*     */     }
/*     */     
/* 389 */     delay += java.util.concurrent.TimeUnit.MINUTES.toMillis(crossBattlePointCfg.durationInMinute - prepareDurationInMinute - matchDurationInMinute);
/*     */     
/*     */ 
/* 392 */     if (delay > 0L)
/*     */     {
/* 394 */       for (java.util.Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/* 396 */         CrossBattlePointManager.syncPointRaceStage(roleid, this.zone, this.index, this.backup, 2, delay);
/*     */       }
/*     */       
/* 399 */       return;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PointRaceZoneManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */