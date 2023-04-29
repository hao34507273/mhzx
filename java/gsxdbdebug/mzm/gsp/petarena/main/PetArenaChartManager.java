/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*    */ import mzm.gsp.chart.main.ChartCfgManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PetArenaChartManager
/*    */ {
/*    */   private static final PetArenaChart chart;
/*    */   
/*    */   static
/*    */   {
/* 15 */     SChartSubTypeCfg chartSubTypeCfg = ChartCfgManager.getChartSubTypeCfg(69);
/* 16 */     if (chartSubTypeCfg != null)
/*    */     {
/* 18 */       chart = new PetArenaChart(chartSubTypeCfg.capacity, chartSubTypeCfg.extraSize);
/*    */     }
/*    */     else
/*    */     {
/* 22 */       chart = new PetArenaChart(100, 10);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void rank(PetArenaChartObj chartObj)
/*    */   {
/* 32 */     chart.rank(chartObj);
/*    */   }
/*    */   
/*    */   static List<PetArenaChartObj> getChartObjs(int startRank, int num)
/*    */   {
/* 37 */     return chart.getRankObjs(startRank, startRank + num - 1);
/*    */   }
/*    */   
/*    */   static int capacity()
/*    */   {
/* 42 */     return chart.getCapacity();
/*    */   }
/*    */   
/*    */   static void init() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PetArenaChartManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */