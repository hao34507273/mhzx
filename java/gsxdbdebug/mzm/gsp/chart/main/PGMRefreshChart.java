/*    */ package mzm.gsp.chart.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGMRefreshChart
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 11 */     ChartDataCache.getInstance().reInit();
/* 12 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\PGMRefreshChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */