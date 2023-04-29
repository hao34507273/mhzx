/*     */ package mzm.gsp.jiuxiao.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.confbean.SJiuXiaoActivityInfoCfg;
/*     */ import xbean.JiuXiaoRank;
/*     */ import xtable.Jiuxiaorank;
/*     */ 
/*     */ public class JiuXiaoRankManager
/*     */ {
/*  15 */   private static final JiuXiaoRankManager instance = new JiuXiaoRankManager();
/*     */   
/*  17 */   private Map<Integer, JiuXiaoChart> chartMap = new HashMap();
/*     */   
/*     */   public static JiuXiaoRankManager getInstance() {
/*  20 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void init()
/*     */   {
/*  28 */     Map<Long, Long> originalKeyToNewKeyMap = new HashMap();
/*  29 */     for (SJiuXiaoActivityInfoCfg jiuXiaoActivityInfoCfg : SJiuXiaoActivityInfoCfg.getAll().values()) {
/*  30 */       long originalKey = mzm.gsp.GameServerInfoManager.getLocalId() + jiuXiaoActivityInfoCfg.rankType;
/*  31 */       long newKey = getInstance().getRankUniqKey(jiuXiaoActivityInfoCfg.rankType);
/*  32 */       originalKeyToNewKeyMap.put(Long.valueOf(originalKey), Long.valueOf(newKey));
/*     */     }
/*  34 */     new mzm.gsp.util.LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/*  38 */         Set<Long> allKeys = new java.util.HashSet();
/*  39 */         allKeys.addAll(this.val$originalKeyToNewKeyMap.keySet());
/*  40 */         allKeys.addAll(this.val$originalKeyToNewKeyMap.values());
/*  41 */         lock(Jiuxiaorank.getTable(), allKeys);
/*     */         
/*  43 */         Map<Long, JiuXiaoRank> originalToDataMap = new HashMap();
/*     */         
/*  45 */         for (Iterator i$ = this.val$originalKeyToNewKeyMap.keySet().iterator(); i$.hasNext();) { long originalKey = ((Long)i$.next()).longValue();
/*  46 */           JiuXiaoRank xJiuXiaoOriginalRank = Jiuxiaorank.get(Long.valueOf(originalKey));
/*  47 */           if (xJiuXiaoOriginalRank != null) {
/*  48 */             originalToDataMap.put(Long.valueOf(originalKey), xJiuXiaoOriginalRank);
/*     */             
/*  50 */             Jiuxiaorank.remove(Long.valueOf(originalKey));
/*     */           }
/*     */         }
/*     */         
/*  54 */         for (Map.Entry<Long, Long> originalToNewEntry : this.val$originalKeyToNewKeyMap.entrySet()) {
/*  55 */           JiuXiaoRank xJiuXiaoOriginalRank = (JiuXiaoRank)originalToDataMap.get(originalToNewEntry.getKey());
/*  56 */           if (xJiuXiaoOriginalRank != null) {
/*  57 */             JiuXiaoRank xJiuXiaoRank = xJiuXiaoOriginalRank.toBean();
/*     */             
/*  59 */             Jiuxiaorank.insert((Long)originalToNewEntry.getValue(), xJiuXiaoRank);
/*     */           }
/*     */         }
/*     */         
/*  63 */         return true;
/*     */       }
/*     */     }.call();
/*     */     
/*  67 */     for (SJiuXiaoActivityInfoCfg jiuXiaoActivityInfoCfg : SJiuXiaoActivityInfoCfg.getAll().values()) {
/*  68 */       if (!instance.chartMap.containsKey(Integer.valueOf(jiuXiaoActivityInfoCfg.rankType)))
/*     */       {
/*  70 */         JiuXiaoChart jiuXiaoChart = new JiuXiaoChart(jiuXiaoActivityInfoCfg.rankType);
/*  71 */         instance.chartMap.put(Integer.valueOf(jiuXiaoActivityInfoCfg.rankType), jiuXiaoChart);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public JiuXiaoChart getJiuXiaoChart(int chartType) {
/*  77 */     return (JiuXiaoChart)this.chartMap.get(Integer.valueOf(chartType));
/*     */   }
/*     */   
/*     */   public void saveToDB() {
/*  81 */     for (JiuXiaoChart jiuXiaoChart : this.chartMap.values()) {
/*  82 */       jiuXiaoChart.saveToDB();
/*     */     }
/*     */   }
/*     */   
/*     */   public void clear(int rankType) {
/*  87 */     JiuXiaoChart jiuXiaoChart = (JiuXiaoChart)this.chartMap.get(Integer.valueOf(rankType));
/*  88 */     if (jiuXiaoChart != null) {
/*  89 */       jiuXiaoChart.clear();
/*     */     }
/*     */   }
/*     */   
/*     */   public long getRankUniqKey(int rankType) {
/*  94 */     return mzm.gsp.GameServerInfoManager.toGlobalId(rankType);
/*     */   }
/*     */   
/*     */   public int getRankLayer(long roleId, int rankType) {
/*  98 */     JiuXiaoChart jiuXiaoChart = (JiuXiaoChart)this.chartMap.get(Integer.valueOf(rankType));
/*  99 */     return jiuXiaoChart.getRankLayer(roleId);
/*     */   }
/*     */   
/*     */   public void PGM_SetChartNum(int capacity) {
/* 103 */     for (final JiuXiaoChart jiuXiaoChart : this.chartMap.values()) {
/* 104 */       List<JiuXiaoRankObj> rankList = jiuXiaoChart.getAllChartObjs();
/* 105 */       for (int i = capacity; i < rankList.size(); i++) {
/* 106 */         jiuXiaoChart.delete((mzm.gsp.chart.main.ChartObj)rankList.get(i));
/*     */       }
/* 108 */       jiuXiaoChart.pgm_setCapacity(capacity);
/* 109 */       xdb.Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*     */       {
/*     */         protected boolean processImp() throws Exception
/*     */         {
/* 113 */           jiuXiaoChart.saveToDB();
/* 114 */           return true;
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\JiuXiaoRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */