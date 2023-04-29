/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*    */ import mzm.gsp.chart.main.ChartCfgManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShenMuNRealMFVManager
/*    */   extends AbsNRealOMFVRankManager
/*    */ {
/*    */   private static ShenMuNRealMFVManager instance;
/*    */   
/*    */   static ShenMuNRealMFVManager getInstance()
/*    */   {
/* 16 */     return instance;
/*    */   }
/*    */   
/*    */   public static void init() {
/* 20 */     if (instance == null) {
/* 21 */       SChartSubTypeCfg var0 = ChartCfgManager.getChartSubTypeCfg(134);
/* 22 */       instance = new ShenMuNRealMFVManager(var0.chartType, ShenMuMFVManager.getInstance());
/*    */     }
/*    */   }
/*    */   
/*    */   public ShenMuNRealMFVManager(int var1, ShenMuMFVManager var2) {
/* 27 */     super(var1, var2);
/*    */   }
/*    */   
/*    */   int getOccChartType() {
/* 31 */     return 134;
/*    */   }
/*    */   
/*    */   int getOccId() {
/* 35 */     return 14;
/*    */   }
/*    */   
/*    */   boolean isSendAward() {
/* 39 */     return OpenInterface.getOpenStatus(477);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\ShenMuNRealMFVManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */