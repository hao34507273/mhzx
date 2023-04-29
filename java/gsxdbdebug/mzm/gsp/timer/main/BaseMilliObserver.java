/*    */ package mzm.gsp.timer.main;
/*    */ 
/*    */ abstract class BaseMilliObserver extends AbstractTimerObserver
/*    */ {
/*  5 */   private volatile long _intervalMilliSeconds = 0L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public BaseMilliObserver(long intervalMilliSeconds)
/*    */   {
/* 14 */     this._intervalMilliSeconds = intervalMilliSeconds;
/* 15 */     TimerTaskManager.getInstance().attachTimerObserver(this);
/*    */   }
/*    */   
/*    */ 
/*    */   public final long getIntervalMilliSeconds()
/*    */   {
/* 21 */     return this._intervalMilliSeconds;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected final void setIntervalMilliSeconds(long intervalMilliSeconds)
/*    */   {
/* 33 */     this._intervalMilliSeconds = intervalMilliSeconds;
/*    */   }
/*    */   
/*    */   public abstract boolean update();
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\timer\main\BaseMilliObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */