/*    */ package mzm.gsp.chart.main;
/*    */ 
/*    */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChartCfgManager
/*    */ {
/*    */   public static SChartSubTypeCfg getChartSubTypeCfg(int type)
/*    */   {
/* 14 */     return SChartSubTypeCfg.get(type);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static int getCapacity(int type)
/*    */   {
/* 25 */     return getChartSubTypeCfg(type).capacity;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static int getExtraSize(int type)
/*    */   {
/* 36 */     return getChartSubTypeCfg(type).extraSize;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\ChartCfgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */