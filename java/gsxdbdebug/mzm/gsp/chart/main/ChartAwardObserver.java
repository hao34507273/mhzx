/*    */ package mzm.gsp.chart.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ public class ChartAwardObserver extends DateObserver
/*    */ {
/*    */   private final int chartType;
/*    */   
/*    */   public ChartAwardObserver(int timeCommonCfgId, int chartType)
/*    */   {
/* 12 */     super(timeCommonCfgId);
/* 13 */     this.chartType = chartType;
/*    */   }
/*    */   
/*    */   protected boolean onTimeOut()
/*    */   {
/* 18 */     NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 22 */         ((RankAwardHandler)RankCacheManager.rankAwardHandlerMap.get(Integer.valueOf(ChartAwardObserver.this.chartType))).doAward();
/* 23 */         return true;
/*    */       }
/* 25 */     });
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\ChartAwardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */