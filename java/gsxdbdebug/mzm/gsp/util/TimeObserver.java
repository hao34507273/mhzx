/*     */ package mzm.gsp.util;
/*     */ 
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ScheduledExecutorService;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ 
/*     */ public abstract class TimeObserver
/*     */   implements Runnable
/*     */ {
/*  14 */   private static final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory()
/*     */   {
/*     */ 
/*     */     public Thread newThread(Runnable r)
/*     */     {
/*  19 */       Thread thread = new Thread(r, "task module time observer thread");
/*  20 */       thread.setDaemon(true);
/*  21 */       return thread;
/*     */     }
/*  14 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  25 */   private long period = -1L;
/*  26 */   private ScheduledFuture<?> scheduled = null;
/*  27 */   private Lock lock = new ReentrantLock();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract void onTimeOut(long paramLong);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void start(long delay)
/*     */   {
/*  42 */     this.lock.lock();
/*     */     
/*     */     try
/*     */     {
/*  46 */       if (this.scheduled != null) {
/*  47 */         throw new RuntimeException("timer already started");
/*     */       }
/*  49 */       _start(delay);
/*     */     }
/*     */     finally
/*     */     {
/*  53 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void start(long delay, long period)
/*     */   {
/*  66 */     this.lock.lock();
/*     */     
/*     */     try
/*     */     {
/*  70 */       if (this.scheduled != null) {
/*  71 */         throw new RuntimeException("timer already started");
/*     */       }
/*  73 */       _start(delay, period);
/*     */     }
/*     */     finally
/*     */     {
/*  77 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean checkAndStart(long startTime, long delay)
/*     */   {
/*  91 */     this.lock.lock();
/*     */     
/*     */     try
/*     */     {
/*  95 */       if (this.scheduled != null) {
/*  96 */         throw new RuntimeException("timer already started");
/*     */       }
/*  98 */       long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  99 */       long timeStamp = startTime + delay;
/* 100 */       boolean bool; if (timeStamp > curTime)
/*     */       {
/* 102 */         _start(timeStamp - curTime);
/* 103 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 107 */       trigger(timeStamp);
/* 108 */       return true;
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/* 113 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean cancel()
/*     */   {
/* 119 */     this.lock.lock();
/*     */     
/*     */     try
/*     */     {
/* 123 */       return _cancel();
/*     */     }
/*     */     finally
/*     */     {
/* 127 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long reduceDelay(long delay)
/*     */   {
/* 139 */     if (delay <= 0L) {
/* 140 */       throw new RuntimeException("delay must > 0");
/*     */     }
/* 142 */     this.lock.lock();
/*     */     
/*     */     try
/*     */     {
/* 146 */       if (this.scheduled == null) {
/* 147 */         throw new RuntimeException("timer not started");
/*     */       }
/* 149 */       if (this.period > 0L) {
/* 150 */         throw new RuntimeException("timer with period can not reduce delay");
/*     */       }
/* 152 */       long remain = _getRemainTime();
/* 153 */       long l1; if (remain <= 0L) {
/* 154 */         return 0L;
/*     */       }
/* 156 */       if (!_cancel()) {
/* 157 */         return 0L;
/*     */       }
/* 159 */       if (remain <= delay)
/*     */       {
/* 161 */         run();
/* 162 */         return remain;
/*     */       }
/*     */       
/*     */ 
/* 166 */       _start(remain - delay);
/* 167 */       return delay;
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/* 172 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getRemainTime()
/*     */   {
/* 183 */     this.lock.lock();
/*     */     
/*     */     try
/*     */     {
/* 187 */       if (this.scheduled == null) {
/* 188 */         throw new RuntimeException("timer not started");
/*     */       }
/* 190 */       return _getRemainTime();
/*     */     }
/*     */     finally
/*     */     {
/* 194 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public long getPeriod()
/*     */   {
/* 200 */     this.lock.lock();
/*     */     
/*     */     try
/*     */     {
/* 204 */       return this.period;
/*     */     }
/*     */     finally
/*     */     {
/* 208 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getNextTime()
/*     */   {
/* 216 */     this.lock.lock();
/*     */     
/*     */     try
/*     */     {
/* 220 */       if (this.scheduled == null) {
/* 221 */         throw new RuntimeException("timer not started");
/*     */       }
/* 223 */       return _getNextTime();
/*     */     }
/*     */     finally
/*     */     {
/* 227 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public final void run()
/*     */   {
/* 234 */     trigger(DateTimeUtils.getCurrTimeInMillis());
/*     */   }
/*     */   
/*     */   protected void trigger(long time)
/*     */   {
/* 239 */     onTimeOut(time);
/*     */   }
/*     */   
/*     */   protected long _getRemainTime()
/*     */   {
/* 244 */     long remain = this.scheduled.getDelay(TimeUnit.MILLISECONDS);
/* 245 */     return remain < 0L ? 0L : remain;
/*     */   }
/*     */   
/*     */   protected long _getNextTime()
/*     */   {
/* 250 */     return DateTimeUtils.getCurrTimeInMillis() + this.scheduled.getDelay(TimeUnit.MILLISECONDS);
/*     */   }
/*     */   
/*     */   protected void _start(long delay)
/*     */   {
/* 255 */     this.scheduled = getExecutor().schedule(this, delay, TimeUnit.MILLISECONDS);
/* 256 */     this.period = -1L;
/*     */   }
/*     */   
/*     */   protected void _start(long delay, long period)
/*     */   {
/* 261 */     this.scheduled = getExecutor().scheduleAtFixedRate(this, delay, period, TimeUnit.MILLISECONDS);
/* 262 */     this.period = period;
/*     */   }
/*     */   
/*     */   protected boolean _cancel()
/*     */   {
/* 267 */     this.period = -1L;
/* 268 */     boolean result = this.scheduled == null ? false : this.scheduled.cancel(false);
/* 269 */     this.scheduled = null;
/* 270 */     return result;
/*     */   }
/*     */   
/*     */   protected ScheduledExecutorService getExecutor()
/*     */   {
/* 275 */     return executor;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\TimeObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */