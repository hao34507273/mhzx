/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*    */ import mzm.gsp.chart.main.ChartCfgManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ 
/*    */ public class YinYangNRealMFVManager
/*    */   extends AbsNRealOMFVRankManager
/*    */ {
/*    */   private static YinYangNRealMFVManager instance;
/*    */   
/*    */   static YinYangNRealMFVManager getInstance()
/*    */   {
/* 14 */     return instance;
/*    */   }
/*    */   
/*    */   public static void init()
/*    */   {
/* 19 */     if (instance != null) {
/* 20 */       return;
/*    */     }
/* 22 */     SChartSubTypeCfg localSChartSubTypeCfg = ChartCfgManager.getChartSubTypeCfg(120);
/* 23 */     instance = new YinYangNRealMFVManager(localSChartSubTypeCfg.chartType, YinYangMFVManager.getInstance());
/*    */   }
/*    */   
/*    */   public YinYangNRealMFVManager(int paramInt, YinYangMFVManager paramYinYangMFVManager)
/*    */   {
/* 28 */     super(paramInt, paramYinYangMFVManager);
/*    */   }
/*    */   
/*    */   int getOccChartType()
/*    */   {
/* 33 */     return 120;
/*    */   }
/*    */   
/*    */   int getOccId()
/*    */   {
/* 38 */     return 12;
/*    */   }
/*    */   
/*    */   boolean isSendAward()
/*    */   {
/* 43 */     return OpenInterface.getOpenStatus(477);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\YinYangNRealMFVManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */