/*   */ package mzm.gsp.chart.main;
/*   */ 
/*   */ import mzm.gsp.timer.main.Observer;
/*   */ 
/*   */ public abstract class NoneRealtimeUpdateObserver extends Observer
/*   */ {
/*   */   public NoneRealtimeUpdateObserver(long firstIntervalSeconds, long otherIntervalSeconds) {
/* 8 */     super(firstIntervalSeconds);
/* 9 */     setIntervalSeconds(otherIntervalSeconds);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\NoneRealtimeUpdateObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */