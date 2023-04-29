/*    */ package mzm.gsp.chart.main;
/*    */ 
/*    */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import xio.Protocol;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class RankListUpdateObserver
/*    */   extends DateObserver
/*    */ {
/*    */   protected SChartSubTypeCfg cfg;
/*    */   protected static final int TOP_THREE = 3;
/* 16 */   protected boolean isUpdate = false;
/*    */   
/*    */   public RankListUpdateObserver(SChartSubTypeCfg cfg) {
/* 19 */     super(cfg.timeCfgId);
/* 20 */     this.cfg = cfg;
/*    */   }
/*    */   
/*    */   protected boolean onTimeOut()
/*    */   {
/* 25 */     this.isUpdate = true;
/* 26 */     init();
/* 27 */     this.isUpdate = false;
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public abstract void init();
/*    */   
/*    */   public abstract Protocol getProtocol(long paramLong, int paramInt1, int paramInt2);
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\RankListUpdateObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */