/*     */ package mzm.gsp.util;
/*     */ 
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import mzm.gsp.timer.main.MilliObserver;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class DelayTimeObserver
/*     */ {
/*  12 */   private AtomicBoolean started = new AtomicBoolean(false);
/*     */   
/*     */ 
/*     */   private MilliObserver delayObserver;
/*     */   
/*     */ 
/*     */   private MilliObserver handleObserver;
/*     */   
/*     */   protected final long interval;
/*     */   
/*     */   protected final boolean repeatable;
/*     */   
/*     */ 
/*     */   public DelayTimeObserver(long interval)
/*     */   {
/*  27 */     this(interval, false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public DelayTimeObserver(long interval, boolean repeatable)
/*     */   {
/*  39 */     this.interval = interval;
/*  40 */     this.repeatable = repeatable;
/*     */   }
/*     */   
/*     */   public long getInterval()
/*     */   {
/*  45 */     return this.interval;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean start(long delay)
/*     */   {
/*  56 */     if (this.started.getAndSet(true))
/*     */     {
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     if (delay <= 0L)
/*     */     {
/*  63 */       this.handleObserver = new HandleObserver();
/*  64 */       this.handleObserver.update();
/*  65 */       if (!this.repeatable)
/*     */       {
/*  67 */         this.handleObserver.stopTimer();
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  72 */       this.delayObserver = new DelayObserver(delay);
/*     */     }
/*     */     
/*  75 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void stop()
/*     */   {
/*  83 */     if (this.delayObserver != null)
/*     */     {
/*  85 */       this.delayObserver.stopTimer();
/*     */     }
/*     */     
/*  88 */     if (this.handleObserver != null)
/*     */     {
/*  90 */       this.handleObserver.stopTimer();
/*     */     }
/*     */   }
/*     */   
/*     */   protected abstract void onTimeOut(long paramLong);
/*     */   
/*     */   private class DelayObserver extends MilliObserver {
/*     */     public DelayObserver(long intervalMilliSeconds) {
/*  98 */       super();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean update()
/*     */     {
/* 104 */       DelayTimeObserver.this.onTimeOut(DateTimeUtils.getCurrTimeInMillis());
/*     */       
/* 106 */       DelayTimeObserver.this.handleObserver = new DelayTimeObserver.HandleObserver(DelayTimeObserver.this);
/*     */       
/* 108 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   private class HandleObserver extends MilliObserver
/*     */   {
/*     */     public HandleObserver()
/*     */     {
/* 116 */       super();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean update()
/*     */     {
/* 122 */       DelayTimeObserver.this.onTimeOut(DateTimeUtils.getCurrTimeInMillis());
/*     */       
/* 124 */       return DelayTimeObserver.this.repeatable;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\DelayTimeObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */