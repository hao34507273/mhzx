/*    */ package mzm.gsp.chart.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.chart.confbean.SChartCfg;
/*    */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*    */ import xio.Protocol;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChartDataCache
/*    */ {
/* 14 */   private static ChartDataCache instance = new ChartDataCache();
/*    */   
/* 16 */   private Map<Integer, RankListUpdateObserver> observerMap = new HashMap();
/*    */   
/*    */   public static final long CHART_TABLE_KEY = 1L;
/*    */   
/*    */   public static ChartDataCache getInstance()
/*    */   {
/* 22 */     return instance;
/*    */   }
/*    */   
/*    */   public void init() {
/* 26 */     Map<Integer, SChartSubTypeCfg> typeCfgMap = new HashMap();
/* 27 */     for (SChartCfg sChartCfg : SChartCfg.getAll().values()) {
/* 28 */       for (Integer subTypeId : sChartCfg.subTypeList) {
/* 29 */         SChartSubTypeCfg subTypeCfg = SChartSubTypeCfg.get(subTypeId.intValue());
/* 30 */         typeCfgMap.put(Integer.valueOf(subTypeCfg.chartType), subTypeCfg);
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 42 */     reInit();
/*    */   }
/*    */   
/*    */   void reInit()
/*    */   {
/* 47 */     for (RankListUpdateObserver observer : this.observerMap.values()) {
/* 48 */       observer.init();
/*    */     }
/*    */   }
/*    */   
/*    */   public Protocol getRankListProtocol(long roleId, int type, int from, int to) {
/* 53 */     RankListUpdateObserver observer = (RankListUpdateObserver)this.observerMap.get(Integer.valueOf(type));
/* 54 */     if (observer == null) return null;
/* 55 */     return observer.getProtocol(roleId, from, to);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\ChartDataCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */