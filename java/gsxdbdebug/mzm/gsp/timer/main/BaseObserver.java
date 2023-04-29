/*    */ package mzm.gsp.timer.main;
/*    */ 
/*    */ abstract class BaseObserver extends AbstractTimerObserver
/*    */ {
/*  5 */   private volatile long _intervalSeconds = 0L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public BaseObserver(long intervalSeconds)
/*    */   {
/* 14 */     this._intervalSeconds = intervalSeconds;
/* 15 */     TimerTaskManager.getInstance().attachTimerObserver(this);
/*    */   }
/*    */   
/*    */   public final long getIntervalSeconds()
/*    */   {
/* 20 */     return this._intervalSeconds;
/*    */   }
/*    */   
/*    */   protected final void setIntervalSeconds(long intervalSeconds)
/*    */   {
/* 25 */     this._intervalSeconds = intervalSeconds;
/*    */   }
/*    */   
/*    */ 
/*    */   public final long getIntervalMilliSeconds()
/*    */   {
/* 31 */     return this._intervalSeconds * 1000L;
/*    */   }
/*    */   
/*    */   public abstract boolean update();
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\timer\main\BaseObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */