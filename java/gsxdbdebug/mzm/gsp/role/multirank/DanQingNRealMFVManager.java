/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*    */ import mzm.gsp.chart.main.ChartCfgManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DanQingNRealMFVManager
/*    */   extends AbsNRealOMFVRankManager
/*    */ {
/*    */   private static DanQingNRealMFVManager instance;
/*    */   
/*    */   static DanQingNRealMFVManager getInstance()
/*    */   {
/* 23 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void init()
/*    */   {
/* 31 */     if (instance != null)
/*    */     {
/* 33 */       return;
/*    */     }
/* 35 */     SChartSubTypeCfg chartSubTypeCfg = ChartCfgManager.getChartSubTypeCfg(95);
/* 36 */     instance = new DanQingNRealMFVManager(chartSubTypeCfg.chartType, DanQingMFVManager.getInstance());
/*    */   }
/*    */   
/*    */   public DanQingNRealMFVManager(int chartType, DanQingMFVManager rankManagerNew)
/*    */   {
/* 41 */     super(chartType, rankManagerNew);
/*    */   }
/*    */   
/*    */ 
/*    */   int getOccChartType()
/*    */   {
/* 47 */     return 95;
/*    */   }
/*    */   
/*    */ 
/*    */   int getOccId()
/*    */   {
/* 53 */     return 11;
/*    */   }
/*    */   
/*    */ 
/*    */   boolean isSendAward()
/*    */   {
/* 59 */     return OpenInterface.getOpenStatus(477);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\DanQingNRealMFVManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */