/*    */ package mzm.gsp.timer.main;
/*    */ 
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ abstract class AbstractTimerObserver implements TimerObserver
/*    */ {
/*  7 */   private volatile boolean _needStop = false;
/*    */   private volatile long timeoutTimestamp;
/*    */   
/*    */   public void stopTimer() {
/* 11 */     this._needStop = true;
/*    */   }
/*    */   
/*    */   public final boolean needToStop()
/*    */   {
/* 16 */     return this._needStop;
/*    */   }
/*    */   
/*    */   public final long getTimeoutTimestamp()
/*    */   {
/* 21 */     return this.timeoutTimestamp;
/*    */   }
/*    */   
/*    */   public void setTimeoutTimestamp(long timeout)
/*    */   {
/* 26 */     this.timeoutTimestamp = timeout;
/*    */   }
/*    */   
/*    */   public int getLeftMillis() {
/* 30 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 31 */     int left = (int)(this.timeoutTimestamp - now);
/* 32 */     return left;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\timer\main\AbstractTimerObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */