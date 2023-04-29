/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*    */ import mzm.gsp.chart.main.ChartCfgManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ 
/*    */ public class HuangJinNRealMFVManager
/*    */   extends AbsNRealOMFVRankManager
/*    */ {
/*    */   private static HuangJinNRealMFVManager instance;
/*    */   
/*    */   static HuangJinNRealMFVManager getInstance()
/*    */   {
/* 14 */     return instance;
/*    */   }
/*    */   
/*    */   public static void init()
/*    */   {
/* 19 */     if (instance != null) {
/* 20 */       return;
/*    */     }
/* 22 */     SChartSubTypeCfg localSChartSubTypeCfg = ChartCfgManager.getChartSubTypeCfg(125);
/* 23 */     instance = new HuangJinNRealMFVManager(localSChartSubTypeCfg.chartType, HuangJinMFVManager.getInstance());
/*    */   }
/*    */   
/*    */   public HuangJinNRealMFVManager(int paramInt, HuangJinMFVManager paramHuangJinMFVManager)
/*    */   {
/* 28 */     super(paramInt, paramHuangJinMFVManager);
/*    */   }
/*    */   
/*    */   int getOccChartType()
/*    */   {
/* 33 */     return 125;
/*    */   }
/*    */   
/*    */   int getOccId()
/*    */   {
/* 38 */     return 13;
/*    */   }
/*    */   
/*    */   boolean isSendAward()
/*    */   {
/* 43 */     return OpenInterface.getOpenStatus(477);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\HuangJinNRealMFVManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */