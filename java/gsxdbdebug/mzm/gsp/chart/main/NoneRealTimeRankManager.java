/*     */ package mzm.gsp.chart.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
/*     */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*     */ 
/*     */ public abstract class NoneRealTimeRankManager<TKey, TChartObj extends ChartObj<TKey, TChartObj>>
/*     */ {
/*     */   protected RankManagerNew<TKey, TChartObj> rankManagerNew;
/*     */   private List<TChartObj> rankDatas;
/*     */   private Map<TKey, Integer> rankChangeMap;
/*     */   private volatile long saveDbTime;
/*     */   private Map<TKey, Integer> keyToIndex;
/*     */   private ReentrantReadWriteLock rankCacheDataLock;
/*     */   private ReentrantReadWriteLock rankChangeLock;
/*     */   
/*     */   public NoneRealTimeRankManager(int rankType, RankManagerNew<TKey, TChartObj> rankManagerNew)
/*     */   {
/*  21 */     this.rankDatas = new java.util.ArrayList();
/*  22 */     this.rankChangeMap = new java.util.HashMap();
/*  23 */     this.keyToIndex = new java.util.HashMap();
/*  24 */     this.rankCacheDataLock = new ReentrantReadWriteLock();
/*  25 */     this.rankChangeLock = new ReentrantReadWriteLock();
/*  26 */     final SChartSubTypeCfg chartSubTypeCfg = ChartCfgManager.getChartSubTypeCfg(rankType);
/*  27 */     if (chartSubTypeCfg.intervalSec <= 0) {
/*  28 */       throw new RuntimeException(String.format("NoneRealTimeRankManager.NoneRealTimeRankManager@非实时的排行榜配置的间隔刷新时间为0|chartType=%d", new Object[] { Integer.valueOf(chartSubTypeCfg.chartType) }));
/*     */     }
/*  30 */     if (rankManagerNew == null) {
/*  31 */       throw new RuntimeException("实时的排行榜的manager不能为null");
/*     */     }
/*  33 */     this.rankManagerNew = rankManagerNew;
/*  34 */     mzm.gsp.util.NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicRunnable()
/*     */     {
/*     */ 
/*     */ 
/*     */       public void process()
/*     */         throws Exception
/*     */       {
/*     */ 
/*     */ 
/*  43 */         new mzm.gsp.util.LogicProcedure()
/*     */         {
/*     */           protected boolean processImp()
/*     */             throws Exception
/*     */           {
/*  40 */             NoneRealTimeRankManager.this.initCachDataFromDb();
/*  41 */             return true;
/*     */           }
/*  43 */         }.call();
/*  44 */         long beforeNeedSaveTime = 0L;
/*  45 */         long timeNow = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  46 */         boolean isExist = mzm.gsp.common.TimeCommonUtil.isTimeCommonCfgExist(chartSubTypeCfg.timeCfgId);
/*  47 */         long beforeSaveTime = 0L;
/*  48 */         if (isExist) {
/*  49 */           beforeSaveTime = mzm.gsp.common.TimeCommonUtil.getBeforeStartTime(timeNow, chartSubTypeCfg.timeCfgId);
/*     */         }
/*     */         else {
/*  52 */           beforeSaveTime = NoneRealTimeRankManager.this.getSaveDbTime();
/*     */         }
/*  54 */         long modMil = (timeNow - beforeSaveTime) % (chartSubTypeCfg.intervalSec * 1000);
/*  55 */         beforeNeedSaveTime = timeNow - modMil;
/*  56 */         new NoneRealtimeUpdateObserver(chartSubTypeCfg.intervalSec - modMil / 1000L, chartSubTypeCfg.intervalSec);
/*     */         {
/*     */           public boolean update() {
/*  59 */             mzm.gsp.util.NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*     */             {
/*     */               protected boolean processImp() throws Exception {
/*  62 */                 NoneRealTimeRankManager.this._initAndSaveToDB();
/*  63 */                 return true;
/*     */               }
/*  65 */             });
/*  66 */             return true;
/*     */           }
/*  68 */         };
/*  69 */         final long finalBeforeSaveTime = beforeNeedSaveTime;
/*  70 */         new mzm.gsp.util.LogicProcedure()
/*     */         {
/*     */           protected boolean processImp() throws Exception {
/*  73 */             long saveDataTime = NoneRealTimeRankManager.this.getSaveDbTime();
/*  74 */             if (saveDataTime < finalBeforeSaveTime) {
/*  75 */               NoneRealTimeRankManager.this._initAndSaveToDB();
/*     */             }
/*  77 */             return true;
/*     */           }
/*     */         }.call();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private void _initAndSaveToDB() {
/*  85 */     List<TChartObj> chartObjs = this.rankManagerNew.getAllChartObjs();
/*  86 */     Map<TKey, Integer> newRankChangeMap = new java.util.HashMap();
/*  87 */     for (int i = 0; i < chartObjs.size(); i++) {
/*  88 */       TChartObj chartObj = (ChartObj)chartObjs.get(i);
/*  89 */       TKey tKey = chartObj.getKey();
/*  90 */       int index = getRank(tKey);
/*  91 */       if (index >= 0) {
/*  92 */         int change = index - i;
/*  93 */         newRankChangeMap.put(tKey, Integer.valueOf(change));
/*     */       }
/*     */     }
/*  96 */     _initSaveDbTime(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/*  97 */     _initCacheRankDatas(chartObjs);
/*  98 */     _initCacheRankChangeMap(newRankChangeMap);
/*  99 */     saveToDB();
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public void _initCacheRankDatas(List<TChartObj> allCacheList)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 43	mzm/gsp/chart/main/NoneRealTimeRankManager:rankCacheDataLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   4: invokevirtual 176	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
/*     */     //   7: invokevirtual 180	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
/*     */     //   10: aload_0
/*     */     //   11: getfield 31	mzm/gsp/chart/main/NoneRealTimeRankManager:rankDatas	Ljava/util/List;
/*     */     //   14: invokeinterface 185 1 0
/*     */     //   19: aload_0
/*     */     //   20: getfield 38	mzm/gsp/chart/main/NoneRealTimeRankManager:keyToIndex	Ljava/util/Map;
/*     */     //   23: invokeinterface 188 1 0
/*     */     //   28: iconst_0
/*     */     //   29: istore_2
/*     */     //   30: goto +46 -> 76
/*     */     //   33: aload_1
/*     */     //   34: iload_2
/*     */     //   35: invokeinterface 117 2 0
/*     */     //   40: checkcast 123	mzm/gsp/chart/main/ChartObj
/*     */     //   43: astore_3
/*     */     //   44: aload_0
/*     */     //   45: getfield 31	mzm/gsp/chart/main/NoneRealTimeRankManager:rankDatas	Ljava/util/List;
/*     */     //   48: aload_3
/*     */     //   49: invokeinterface 189 2 0
/*     */     //   54: pop
/*     */     //   55: aload_0
/*     */     //   56: getfield 38	mzm/gsp/chart/main/NoneRealTimeRankManager:keyToIndex	Ljava/util/Map;
/*     */     //   59: aload_3
/*     */     //   60: invokevirtual 125	mzm/gsp/chart/main/ChartObj:getKey	()Ljava/lang/Object;
/*     */     //   63: iload_2
/*     */     //   64: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   67: invokeinterface 133 3 0
/*     */     //   72: pop
/*     */     //   73: iinc 2 1
/*     */     //   76: iload_2
/*     */     //   77: aload_1
/*     */     //   78: invokeinterface 139 1 0
/*     */     //   83: if_icmplt -50 -> 33
/*     */     //   86: goto +41 -> 127
/*     */     //   89: astore_2
/*     */     //   90: invokestatic 193	mzm/gsp/GameServer:logger	()Lorg/apache/log4j/Logger;
/*     */     //   93: ldc -57
/*     */     //   95: aload_2
/*     */     //   96: invokevirtual 201	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*     */     //   99: aload_0
/*     */     //   100: getfield 43	mzm/gsp/chart/main/NoneRealTimeRankManager:rankCacheDataLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   103: invokevirtual 176	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
/*     */     //   106: invokevirtual 207	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
/*     */     //   109: goto +28 -> 137
/*     */     //   112: astore 4
/*     */     //   114: aload_0
/*     */     //   115: getfield 43	mzm/gsp/chart/main/NoneRealTimeRankManager:rankCacheDataLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   118: invokevirtual 176	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
/*     */     //   121: invokevirtual 207	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
/*     */     //   124: aload 4
/*     */     //   126: athrow
/*     */     //   127: aload_0
/*     */     //   128: getfield 43	mzm/gsp/chart/main/NoneRealTimeRankManager:rankCacheDataLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   131: invokevirtual 176	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
/*     */     //   134: invokevirtual 207	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
/*     */     //   137: return
/*     */     // Line number table:
/*     */     //   Java source line #103	-> byte code offset #0
/*     */     //   Java source line #105	-> byte code offset #10
/*     */     //   Java source line #106	-> byte code offset #19
/*     */     //   Java source line #107	-> byte code offset #28
/*     */     //   Java source line #108	-> byte code offset #33
/*     */     //   Java source line #109	-> byte code offset #44
/*     */     //   Java source line #110	-> byte code offset #55
/*     */     //   Java source line #107	-> byte code offset #73
/*     */     //   Java source line #112	-> byte code offset #86
/*     */     //   Java source line #113	-> byte code offset #89
/*     */     //   Java source line #114	-> byte code offset #90
/*     */     //   Java source line #117	-> byte code offset #99
/*     */     //   Java source line #116	-> byte code offset #112
/*     */     //   Java source line #117	-> byte code offset #114
/*     */     //   Java source line #118	-> byte code offset #124
/*     */     //   Java source line #117	-> byte code offset #127
/*     */     //   Java source line #119	-> byte code offset #137
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	138	0	this	NoneRealTimeRankManager<TKey, TChartObj>
/*     */     //   0	138	1	allCacheList	List<TChartObj>
/*     */     //   29	48	2	i	int
/*     */     //   89	7	2	e	Exception
/*     */     //   43	17	3	chartObj	TChartObj
/*     */     //   112	13	4	localObject	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   10	86	89	java/lang/Exception
/*     */     //   10	99	112	finally
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public void _initCacheRankChangeMap(Map<TKey, Integer> allRankChangeMap)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 45	mzm/gsp/chart/main/NoneRealTimeRankManager:rankChangeLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   4: invokevirtual 176	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
/*     */     //   7: invokevirtual 180	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
/*     */     //   10: aload_0
/*     */     //   11: getfield 36	mzm/gsp/chart/main/NoneRealTimeRankManager:rankChangeMap	Ljava/util/Map;
/*     */     //   14: invokeinterface 188 1 0
/*     */     //   19: aload_0
/*     */     //   20: getfield 36	mzm/gsp/chart/main/NoneRealTimeRankManager:rankChangeMap	Ljava/util/Map;
/*     */     //   23: aload_1
/*     */     //   24: invokeinterface 218 2 0
/*     */     //   29: goto +39 -> 68
/*     */     //   32: astore_2
/*     */     //   33: invokestatic 193	mzm/gsp/GameServer:logger	()Lorg/apache/log4j/Logger;
/*     */     //   36: ldc -35
/*     */     //   38: aload_2
/*     */     //   39: invokevirtual 201	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*     */     //   42: aload_0
/*     */     //   43: getfield 45	mzm/gsp/chart/main/NoneRealTimeRankManager:rankChangeLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   46: invokevirtual 176	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
/*     */     //   49: invokevirtual 207	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
/*     */     //   52: goto +26 -> 78
/*     */     //   55: astore_3
/*     */     //   56: aload_0
/*     */     //   57: getfield 45	mzm/gsp/chart/main/NoneRealTimeRankManager:rankChangeLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   60: invokevirtual 176	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
/*     */     //   63: invokevirtual 207	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
/*     */     //   66: aload_3
/*     */     //   67: athrow
/*     */     //   68: aload_0
/*     */     //   69: getfield 45	mzm/gsp/chart/main/NoneRealTimeRankManager:rankChangeLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   72: invokevirtual 176	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
/*     */     //   75: invokevirtual 207	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
/*     */     //   78: return
/*     */     // Line number table:
/*     */     //   Java source line #122	-> byte code offset #0
/*     */     //   Java source line #124	-> byte code offset #10
/*     */     //   Java source line #125	-> byte code offset #19
/*     */     //   Java source line #126	-> byte code offset #29
/*     */     //   Java source line #127	-> byte code offset #32
/*     */     //   Java source line #128	-> byte code offset #33
/*     */     //   Java source line #131	-> byte code offset #42
/*     */     //   Java source line #130	-> byte code offset #55
/*     */     //   Java source line #131	-> byte code offset #56
/*     */     //   Java source line #132	-> byte code offset #66
/*     */     //   Java source line #131	-> byte code offset #68
/*     */     //   Java source line #133	-> byte code offset #78
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	79	0	this	NoneRealTimeRankManager<TKey, TChartObj>
/*     */     //   0	79	1	allRankChangeMap	Map<TKey, Integer>
/*     */     //   32	7	2	e	Exception
/*     */     //   55	12	3	localObject	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   10	29	32	java/lang/Exception
/*     */     //   10	42	55	finally
/*     */   }
/*     */   
/*     */   public void _initSaveDbTime(long saveDbTime)
/*     */   {
/* 136 */     this.saveDbTime = saveDbTime;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public List<TChartObj> getCacheRankDatas()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: new 28	java/util/ArrayList
/*     */     //   3: dup
/*     */     //   4: invokespecial 30	java/util/ArrayList:<init>	()V
/*     */     //   7: astore_1
/*     */     //   8: aload_0
/*     */     //   9: getfield 43	mzm/gsp/chart/main/NoneRealTimeRankManager:rankCacheDataLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   12: invokevirtual 228	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
/*     */     //   15: invokevirtual 232	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
/*     */     //   18: aload_1
/*     */     //   19: aload_0
/*     */     //   20: getfield 31	mzm/gsp/chart/main/NoneRealTimeRankManager:rankDatas	Ljava/util/List;
/*     */     //   23: invokeinterface 235 2 0
/*     */     //   28: pop
/*     */     //   29: goto +39 -> 68
/*     */     //   32: astore_2
/*     */     //   33: invokestatic 193	mzm/gsp/GameServer:logger	()Lorg/apache/log4j/Logger;
/*     */     //   36: ldc -17
/*     */     //   38: aload_2
/*     */     //   39: invokevirtual 201	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*     */     //   42: aload_0
/*     */     //   43: getfield 43	mzm/gsp/chart/main/NoneRealTimeRankManager:rankCacheDataLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   46: invokevirtual 228	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
/*     */     //   49: invokevirtual 241	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
/*     */     //   52: goto +26 -> 78
/*     */     //   55: astore_3
/*     */     //   56: aload_0
/*     */     //   57: getfield 43	mzm/gsp/chart/main/NoneRealTimeRankManager:rankCacheDataLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   60: invokevirtual 228	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
/*     */     //   63: invokevirtual 241	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
/*     */     //   66: aload_3
/*     */     //   67: athrow
/*     */     //   68: aload_0
/*     */     //   69: getfield 43	mzm/gsp/chart/main/NoneRealTimeRankManager:rankCacheDataLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   72: invokevirtual 228	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
/*     */     //   75: invokevirtual 241	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
/*     */     //   78: aload_1
/*     */     //   79: areturn
/*     */     // Line number table:
/*     */     //   Java source line #140	-> byte code offset #0
/*     */     //   Java source line #141	-> byte code offset #8
/*     */     //   Java source line #143	-> byte code offset #18
/*     */     //   Java source line #144	-> byte code offset #29
/*     */     //   Java source line #145	-> byte code offset #32
/*     */     //   Java source line #146	-> byte code offset #33
/*     */     //   Java source line #149	-> byte code offset #42
/*     */     //   Java source line #148	-> byte code offset #55
/*     */     //   Java source line #149	-> byte code offset #56
/*     */     //   Java source line #150	-> byte code offset #66
/*     */     //   Java source line #149	-> byte code offset #68
/*     */     //   Java source line #151	-> byte code offset #78
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	80	0	this	NoneRealTimeRankManager<TKey, TChartObj>
/*     */     //   7	72	1	allCacheRankList	List<TChartObj>
/*     */     //   32	7	2	e	Exception
/*     */     //   55	12	3	localObject	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   18	29	32	java/lang/Exception
/*     */     //   18	42	55	finally
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public Map<TKey, Integer> getCacheRankChangeMap()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: new 33	java/util/HashMap
/*     */     //   3: dup
/*     */     //   4: invokespecial 35	java/util/HashMap:<init>	()V
/*     */     //   7: astore_1
/*     */     //   8: aload_0
/*     */     //   9: getfield 45	mzm/gsp/chart/main/NoneRealTimeRankManager:rankChangeLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   12: invokevirtual 228	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
/*     */     //   15: invokevirtual 232	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
/*     */     //   18: aload_1
/*     */     //   19: aload_0
/*     */     //   20: getfield 36	mzm/gsp/chart/main/NoneRealTimeRankManager:rankChangeMap	Ljava/util/Map;
/*     */     //   23: invokeinterface 218 2 0
/*     */     //   28: goto +39 -> 67
/*     */     //   31: astore_2
/*     */     //   32: invokestatic 193	mzm/gsp/GameServer:logger	()Lorg/apache/log4j/Logger;
/*     */     //   35: ldc -10
/*     */     //   37: aload_2
/*     */     //   38: invokevirtual 201	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*     */     //   41: aload_0
/*     */     //   42: getfield 45	mzm/gsp/chart/main/NoneRealTimeRankManager:rankChangeLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   45: invokevirtual 228	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
/*     */     //   48: invokevirtual 241	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
/*     */     //   51: goto +26 -> 77
/*     */     //   54: astore_3
/*     */     //   55: aload_0
/*     */     //   56: getfield 45	mzm/gsp/chart/main/NoneRealTimeRankManager:rankChangeLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   59: invokevirtual 228	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
/*     */     //   62: invokevirtual 241	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
/*     */     //   65: aload_3
/*     */     //   66: athrow
/*     */     //   67: aload_0
/*     */     //   68: getfield 45	mzm/gsp/chart/main/NoneRealTimeRankManager:rankChangeLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   71: invokevirtual 228	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
/*     */     //   74: invokevirtual 241	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
/*     */     //   77: aload_1
/*     */     //   78: areturn
/*     */     // Line number table:
/*     */     //   Java source line #155	-> byte code offset #0
/*     */     //   Java source line #156	-> byte code offset #8
/*     */     //   Java source line #158	-> byte code offset #18
/*     */     //   Java source line #159	-> byte code offset #28
/*     */     //   Java source line #160	-> byte code offset #31
/*     */     //   Java source line #161	-> byte code offset #32
/*     */     //   Java source line #164	-> byte code offset #41
/*     */     //   Java source line #163	-> byte code offset #54
/*     */     //   Java source line #164	-> byte code offset #55
/*     */     //   Java source line #165	-> byte code offset #65
/*     */     //   Java source line #164	-> byte code offset #67
/*     */     //   Java source line #166	-> byte code offset #77
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	79	0	this	NoneRealTimeRankManager<TKey, TChartObj>
/*     */     //   7	71	1	rankChangeRetMap	Map<TKey, Integer>
/*     */     //   31	7	2	e	Exception
/*     */     //   54	12	3	localObject	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   18	28	31	java/lang/Exception
/*     */     //   18	41	54	finally
/*     */   }
/*     */   
/*     */   public long getSaveDbTime()
/*     */   {
/* 170 */     return this.saveDbTime;
/*     */   }
/*     */   
/*     */   public int getRank(TKey tKey) {
/* 174 */     this.rankCacheDataLock.readLock().lock();
/*     */     try {
/* 176 */       Integer rank = (Integer)this.keyToIndex.get(tKey);
/* 177 */       if ((rank != null) && (rank.intValue() < this.rankManagerNew.getCapacity())) {
/* 178 */         return rank.intValue();
/*     */       }
/* 180 */       return -1;
/*     */     }
/*     */     catch (Exception e) {
/* 183 */       mzm.gsp.GameServer.logger().error("获取非实时缓存排行出错!!,", e);
/*     */     }
/*     */     finally {
/* 186 */       this.rankCacheDataLock.readLock().unlock();
/*     */     }
/* 188 */     return -1;
/*     */   }
/*     */   
/*     */   public List<TChartObj> getRankObjs(int fromOrder, int toOrder) {
/* 192 */     List<TChartObj> list = new java.util.ArrayList();
/* 193 */     if (fromOrder < 0) {
/* 194 */       return list;
/*     */     }
/* 196 */     if (fromOrder > toOrder) {
/* 197 */       return list;
/*     */     }
/* 199 */     int capacity = this.rankManagerNew.getCapacity();
/* 200 */     this.rankCacheDataLock.readLock().lock();
/*     */     try {
/* 202 */       int max = this.rankDatas.size() - 1;
/* 203 */       if (max > capacity - 1) {
/* 204 */         max = capacity - 1;
/*     */       }
/* 206 */       if (toOrder > max) {
/* 207 */         toOrder = max;
/*     */       }
/* 209 */       for (int i = fromOrder; i <= toOrder; i++) {
/* 210 */         list.add((ChartObj)this.rankDatas.get(i));
/*     */       }
/* 212 */       return list;
/*     */     }
/*     */     catch (Exception e) {
/* 215 */       mzm.gsp.GameServer.logger().error("获取非实时排行数据出错!!,from:" + fromOrder + ",to:" + toOrder, e);
/*     */     }
/*     */     finally {
/* 218 */       this.rankCacheDataLock.readLock().unlock();
/*     */     }
/* 220 */     return list;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public List<TChartObj> getAllChartObjs()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: new 28	java/util/ArrayList
/*     */     //   3: dup
/*     */     //   4: invokespecial 30	java/util/ArrayList:<init>	()V
/*     */     //   7: astore_1
/*     */     //   8: aload_0
/*     */     //   9: getfield 43	mzm/gsp/chart/main/NoneRealTimeRankManager:rankCacheDataLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   12: invokevirtual 228	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
/*     */     //   15: invokevirtual 232	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
/*     */     //   18: aload_1
/*     */     //   19: aload_0
/*     */     //   20: getfield 31	mzm/gsp/chart/main/NoneRealTimeRankManager:rankDatas	Ljava/util/List;
/*     */     //   23: invokeinterface 235 2 0
/*     */     //   28: pop
/*     */     //   29: goto +30 -> 59
/*     */     //   32: astore_2
/*     */     //   33: aload_0
/*     */     //   34: getfield 43	mzm/gsp/chart/main/NoneRealTimeRankManager:rankCacheDataLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   37: invokevirtual 228	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
/*     */     //   40: invokevirtual 241	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
/*     */     //   43: goto +26 -> 69
/*     */     //   46: astore_3
/*     */     //   47: aload_0
/*     */     //   48: getfield 43	mzm/gsp/chart/main/NoneRealTimeRankManager:rankCacheDataLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   51: invokevirtual 228	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
/*     */     //   54: invokevirtual 241	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
/*     */     //   57: aload_3
/*     */     //   58: athrow
/*     */     //   59: aload_0
/*     */     //   60: getfield 43	mzm/gsp/chart/main/NoneRealTimeRankManager:rankCacheDataLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   63: invokevirtual 228	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
/*     */     //   66: invokevirtual 241	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
/*     */     //   69: aload_1
/*     */     //   70: areturn
/*     */     // Line number table:
/*     */     //   Java source line #224	-> byte code offset #0
/*     */     //   Java source line #225	-> byte code offset #8
/*     */     //   Java source line #227	-> byte code offset #18
/*     */     //   Java source line #228	-> byte code offset #29
/*     */     //   Java source line #229	-> byte code offset #32
/*     */     //   Java source line #231	-> byte code offset #33
/*     */     //   Java source line #230	-> byte code offset #46
/*     */     //   Java source line #231	-> byte code offset #47
/*     */     //   Java source line #232	-> byte code offset #57
/*     */     //   Java source line #231	-> byte code offset #59
/*     */     //   Java source line #233	-> byte code offset #69
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	71	0	this	NoneRealTimeRankManager<TKey, TChartObj>
/*     */     //   7	63	1	allChartObjs	List<TChartObj>
/*     */     //   32	1	2	localException	Exception
/*     */     //   46	12	3	localObject	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   18	29	32	java/lang/Exception
/*     */     //   18	33	46	finally
/*     */   }
/*     */   
/*     */   public List<TChartObj> getRanObjsFromPage(int pageNum, int pageSize)
/*     */   {
/* 237 */     int fromOrder = pageNum * pageSize;
/* 238 */     int toOrder = (pageNum + 1) * pageSize - 1;
/* 239 */     return getRankObjs(fromOrder, toOrder);
/*     */   }
/*     */   
/*     */   public TChartObj getObjByKey(TKey tKey) {
/* 243 */     this.rankCacheDataLock.readLock().lock();
/*     */     try {
/* 245 */       Integer index = (Integer)this.keyToIndex.get(tKey);
/* 246 */       if (index != null) {
/* 247 */         return (ChartObj)this.rankDatas.get(index.intValue());
/*     */       }
/*     */     }
/*     */     catch (Exception localException) {}finally
/*     */     {
/* 252 */       this.rankCacheDataLock.readLock().unlock(); } this.rankCacheDataLock.readLock().unlock();
/*     */     
/* 254 */     return null;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public boolean delete(TKey tKey)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: iconst_0
/*     */     //   1: istore_2
/*     */     //   2: aload_1
/*     */     //   3: ifnonnull +5 -> 8
/*     */     //   6: iconst_0
/*     */     //   7: ireturn
/*     */     //   8: aload_0
/*     */     //   9: getfield 43	mzm/gsp/chart/main/NoneRealTimeRankManager:rankCacheDataLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   12: invokevirtual 176	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
/*     */     //   15: invokevirtual 180	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
/*     */     //   18: aload_0
/*     */     //   19: getfield 38	mzm/gsp/chart/main/NoneRealTimeRankManager:keyToIndex	Ljava/util/Map;
/*     */     //   22: aload_1
/*     */     //   23: invokeinterface 251 2 0
/*     */     //   28: checkcast 67	java/lang/Integer
/*     */     //   31: astore_3
/*     */     //   32: aload_3
/*     */     //   33: ifnull +134 -> 167
/*     */     //   36: aload_0
/*     */     //   37: getfield 31	mzm/gsp/chart/main/NoneRealTimeRankManager:rankDatas	Ljava/util/List;
/*     */     //   40: aload_3
/*     */     //   41: invokevirtual 254	java/lang/Integer:intValue	()I
/*     */     //   44: invokeinterface 301 2 0
/*     */     //   49: pop
/*     */     //   50: aload_0
/*     */     //   51: getfield 38	mzm/gsp/chart/main/NoneRealTimeRankManager:keyToIndex	Ljava/util/Map;
/*     */     //   54: aload_1
/*     */     //   55: invokeinterface 304 2 0
/*     */     //   60: pop
/*     */     //   61: aload_3
/*     */     //   62: invokevirtual 254	java/lang/Integer:intValue	()I
/*     */     //   65: istore 4
/*     */     //   67: goto +42 -> 109
/*     */     //   70: aload_0
/*     */     //   71: getfield 31	mzm/gsp/chart/main/NoneRealTimeRankManager:rankDatas	Ljava/util/List;
/*     */     //   74: iload 4
/*     */     //   76: invokeinterface 117 2 0
/*     */     //   81: checkcast 123	mzm/gsp/chart/main/ChartObj
/*     */     //   84: astore 5
/*     */     //   86: aload_0
/*     */     //   87: getfield 38	mzm/gsp/chart/main/NoneRealTimeRankManager:keyToIndex	Ljava/util/Map;
/*     */     //   90: aload 5
/*     */     //   92: invokevirtual 125	mzm/gsp/chart/main/ChartObj:getKey	()Ljava/lang/Object;
/*     */     //   95: iload 4
/*     */     //   97: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   100: invokeinterface 133 3 0
/*     */     //   105: pop
/*     */     //   106: iinc 4 1
/*     */     //   109: iload 4
/*     */     //   111: aload_0
/*     */     //   112: getfield 31	mzm/gsp/chart/main/NoneRealTimeRankManager:rankDatas	Ljava/util/List;
/*     */     //   115: invokeinterface 139 1 0
/*     */     //   120: if_icmplt -50 -> 70
/*     */     //   123: iconst_1
/*     */     //   124: istore_2
/*     */     //   125: goto +42 -> 167
/*     */     //   128: astore_3
/*     */     //   129: invokestatic 193	mzm/gsp/GameServer:logger	()Lorg/apache/log4j/Logger;
/*     */     //   132: ldc_w 306
/*     */     //   135: aload_3
/*     */     //   136: invokevirtual 201	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*     */     //   139: aload_0
/*     */     //   140: getfield 43	mzm/gsp/chart/main/NoneRealTimeRankManager:rankCacheDataLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   143: invokevirtual 176	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
/*     */     //   146: invokevirtual 207	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
/*     */     //   149: goto +28 -> 177
/*     */     //   152: astore 6
/*     */     //   154: aload_0
/*     */     //   155: getfield 43	mzm/gsp/chart/main/NoneRealTimeRankManager:rankCacheDataLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   158: invokevirtual 176	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
/*     */     //   161: invokevirtual 207	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
/*     */     //   164: aload 6
/*     */     //   166: athrow
/*     */     //   167: aload_0
/*     */     //   168: getfield 43	mzm/gsp/chart/main/NoneRealTimeRankManager:rankCacheDataLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   171: invokevirtual 176	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
/*     */     //   174: invokevirtual 207	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
/*     */     //   177: aload_0
/*     */     //   178: getfield 45	mzm/gsp/chart/main/NoneRealTimeRankManager:rankChangeLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   181: invokevirtual 176	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
/*     */     //   184: invokevirtual 180	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
/*     */     //   187: aload_0
/*     */     //   188: getfield 36	mzm/gsp/chart/main/NoneRealTimeRankManager:rankChangeMap	Ljava/util/Map;
/*     */     //   191: aload_1
/*     */     //   192: invokeinterface 304 2 0
/*     */     //   197: pop
/*     */     //   198: goto +42 -> 240
/*     */     //   201: astore_3
/*     */     //   202: invokestatic 193	mzm/gsp/GameServer:logger	()Lorg/apache/log4j/Logger;
/*     */     //   205: ldc_w 308
/*     */     //   208: aload_3
/*     */     //   209: invokevirtual 201	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*     */     //   212: aload_0
/*     */     //   213: getfield 45	mzm/gsp/chart/main/NoneRealTimeRankManager:rankChangeLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   216: invokevirtual 176	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
/*     */     //   219: invokevirtual 207	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
/*     */     //   222: goto +28 -> 250
/*     */     //   225: astore 4
/*     */     //   227: aload_0
/*     */     //   228: getfield 45	mzm/gsp/chart/main/NoneRealTimeRankManager:rankChangeLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   231: invokevirtual 176	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
/*     */     //   234: invokevirtual 207	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
/*     */     //   237: aload 4
/*     */     //   239: athrow
/*     */     //   240: aload_0
/*     */     //   241: getfield 45	mzm/gsp/chart/main/NoneRealTimeRankManager:rankChangeLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */     //   244: invokevirtual 176	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
/*     */     //   247: invokevirtual 207	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
/*     */     //   250: aload_0
/*     */     //   251: getfield 83	mzm/gsp/chart/main/NoneRealTimeRankManager:rankManagerNew	Lmzm/gsp/chart/main/RankManagerNew;
/*     */     //   254: aload_1
/*     */     //   255: invokevirtual 310	mzm/gsp/chart/main/RankManagerNew:delete	(Ljava/lang/Object;)Z
/*     */     //   258: ifeq +5 -> 263
/*     */     //   261: iconst_1
/*     */     //   262: istore_2
/*     */     //   263: iload_2
/*     */     //   264: ireturn
/*     */     // Line number table:
/*     */     //   Java source line #258	-> byte code offset #0
/*     */     //   Java source line #259	-> byte code offset #2
/*     */     //   Java source line #260	-> byte code offset #6
/*     */     //   Java source line #262	-> byte code offset #8
/*     */     //   Java source line #264	-> byte code offset #18
/*     */     //   Java source line #265	-> byte code offset #32
/*     */     //   Java source line #266	-> byte code offset #36
/*     */     //   Java source line #267	-> byte code offset #50
/*     */     //   Java source line #268	-> byte code offset #61
/*     */     //   Java source line #269	-> byte code offset #70
/*     */     //   Java source line #270	-> byte code offset #86
/*     */     //   Java source line #268	-> byte code offset #106
/*     */     //   Java source line #272	-> byte code offset #123
/*     */     //   Java source line #274	-> byte code offset #125
/*     */     //   Java source line #275	-> byte code offset #128
/*     */     //   Java source line #276	-> byte code offset #129
/*     */     //   Java source line #279	-> byte code offset #139
/*     */     //   Java source line #278	-> byte code offset #152
/*     */     //   Java source line #279	-> byte code offset #154
/*     */     //   Java source line #280	-> byte code offset #164
/*     */     //   Java source line #279	-> byte code offset #167
/*     */     //   Java source line #281	-> byte code offset #177
/*     */     //   Java source line #283	-> byte code offset #187
/*     */     //   Java source line #284	-> byte code offset #198
/*     */     //   Java source line #285	-> byte code offset #201
/*     */     //   Java source line #286	-> byte code offset #202
/*     */     //   Java source line #289	-> byte code offset #212
/*     */     //   Java source line #288	-> byte code offset #225
/*     */     //   Java source line #289	-> byte code offset #227
/*     */     //   Java source line #290	-> byte code offset #237
/*     */     //   Java source line #289	-> byte code offset #240
/*     */     //   Java source line #291	-> byte code offset #250
/*     */     //   Java source line #292	-> byte code offset #261
/*     */     //   Java source line #294	-> byte code offset #263
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	265	0	this	NoneRealTimeRankManager<TKey, TChartObj>
/*     */     //   0	265	1	tKey	TKey
/*     */     //   1	263	2	ret	boolean
/*     */     //   31	31	3	index	Integer
/*     */     //   128	8	3	e	Exception
/*     */     //   201	8	3	e	Exception
/*     */     //   65	173	4	i	int
/*     */     //   84	7	5	moveChartObj	TChartObj
/*     */     //   152	13	6	localObject	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   18	125	128	java/lang/Exception
/*     */     //   18	139	152	finally
/*     */     //   187	198	201	java/lang/Exception
/*     */     //   187	212	225	finally
/*     */   }
/*     */   
/*     */   private int index(TKey tKey)
/*     */   {
/* 298 */     if (this.keyToIndex.containsKey(tKey)) {
/* 299 */       return ((Integer)this.keyToIndex.get(tKey)).intValue();
/*     */     }
/* 301 */     return -1;
/*     */   }
/*     */   
/*     */   public boolean rank(TChartObj rankObj) {
/* 305 */     if (!rankObj.isAvailable()) {
/* 306 */       return false;
/*     */     }
/* 308 */     this.rankManagerNew.rank(rankObj);
/* 309 */     this.rankCacheDataLock.writeLock().lock();
/*     */     try {
/* 311 */       int index = index(rankObj.getKey());
/* 312 */       if (index >= 0) {
/* 313 */         TChartObj originalObj = (ChartObj)this.rankDatas.get(index);
/* 314 */         int nowRank = index;
/* 315 */         if (rankObj.isTopThan(originalObj)) {
/* 316 */           while (nowRank > 0) {
/* 317 */             TChartObj topObj = (ChartObj)this.rankDatas.get(nowRank - 1);
/* 318 */             if (!rankObj.isTopThan(topObj)) {
/*     */               break;
/*     */             }
/* 321 */             this.rankDatas.set(nowRank, topObj);
/* 322 */             this.keyToIndex.put(topObj.getKey(), Integer.valueOf(nowRank));
/* 323 */             nowRank--;
/*     */           }
/*     */           
/*     */         } else {
/* 327 */           for (int maxRank = this.rankDatas.size() - 1; nowRank < maxRank; nowRank++) {
/* 328 */             TChartObj lowObj = (ChartObj)this.rankDatas.get(nowRank + 1);
/* 329 */             if (!lowObj.isTopThan(rankObj)) {
/*     */               break;
/*     */             }
/* 332 */             this.rankDatas.set(nowRank, lowObj);
/* 333 */             this.keyToIndex.put(lowObj.getKey(), Integer.valueOf(nowRank));
/*     */           }
/*     */         }
/* 336 */         this.rankDatas.set(nowRank, rankObj);
/* 337 */         this.keyToIndex.put(rankObj.getKey(), Integer.valueOf(nowRank));
/* 338 */         return true;
/*     */       }
/* 340 */       index = topIndex(rankObj);
/* 341 */       if (index >= 0) {
/* 342 */         this.rankDatas.add(index, rankObj);
/* 343 */         this.keyToIndex.put(rankObj.getKey(), Integer.valueOf(index));
/* 344 */         for (int i = index + 1; i < this.rankDatas.size(); i++) {
/* 345 */           this.keyToIndex.put(((ChartObj)this.rankDatas.get(i)).getKey(), Integer.valueOf(i));
/*     */         }
/* 347 */         if (this.rankDatas.size() > this.rankManagerNew.getCapacity() + this.rankManagerNew.getExtraSize()) {
/* 348 */           TChartObj remTChartObj = (ChartObj)this.rankDatas.remove(this.rankDatas.size() - 1);
/* 349 */           this.keyToIndex.remove(remTChartObj.getKey());
/*     */         }
/* 351 */         return true;
/*     */       }
/* 353 */       if (this.rankDatas.size() < this.rankManagerNew.getCapacity() + this.rankManagerNew.getExtraSize()) {
/* 354 */         this.rankDatas.add(rankObj);
/* 355 */         this.keyToIndex.put(rankObj.getKey(), Integer.valueOf(this.rankDatas.size() - 1));
/* 356 */         return true;
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 360 */       mzm.gsp.GameServer.logger().error("rank error,", e);
/*     */     }
/*     */     finally {
/* 363 */       this.rankCacheDataLock.writeLock().unlock(); } this.rankCacheDataLock.writeLock().unlock();
/*     */     
/* 365 */     return false;
/*     */   }
/*     */   
/*     */   private int topIndex(TChartObj rankObj) {
/* 369 */     if (this.rankDatas.size() <= 0) {
/* 370 */       return -1;
/*     */     }
/* 372 */     int begin = 0;
/* 373 */     int end = this.rankDatas.size() - 1;
/* 374 */     TChartObj endObj = (ChartObj)this.rankDatas.get(end);
/* 375 */     if (!rankObj.isTopThan(endObj)) {
/* 376 */       return -1;
/*     */     }
/* 378 */     if (rankObj.isTopThan((ChartObj)this.rankDatas.get(0))) {
/* 379 */       return 0;
/*     */     }
/* 381 */     while (begin != end) {
/* 382 */       int middle = (begin + end) / 2;
/* 383 */       TChartObj middleChartObj = (ChartObj)this.rankDatas.get(middle);
/* 384 */       if (rankObj.isTopThan(middleChartObj)) {
/* 385 */         if (end == middle) {
/* 386 */           return middle;
/*     */         }
/* 388 */         end = middle;
/*     */       }
/*     */       else {
/* 391 */         if (begin == middle) {
/* 392 */           return begin + 1;
/*     */         }
/* 394 */         begin = middle;
/*     */       }
/*     */     }
/* 397 */     return end;
/*     */   }
/*     */   
/*     */   public void delete(TChartObj rankObj) {
/* 401 */     if (rankObj == null) {
/* 402 */       return;
/*     */     }
/* 404 */     delete(rankObj.getKey());
/*     */   }
/*     */   
/*     */   public abstract void saveToDB();
/*     */   
/*     */   public abstract void initCachDataFromDb();
/*     */   
/*     */   public void pGM_ReRank() {
/* 412 */     _initAndSaveToDB();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\NoneRealTimeRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */