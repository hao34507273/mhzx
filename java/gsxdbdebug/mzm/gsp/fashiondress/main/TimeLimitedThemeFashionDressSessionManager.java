/*     */ package mzm.gsp.fashiondress.main;
/*     */ 
/*     */ import java.util.TreeMap;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fashiondress.confbean.STimeLimitedThemeFashionDressCfg;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TimeLimitedThemeFashionDressSessionManager
/*     */ {
/*  17 */   private static TimeLimitedThemeFashionDressSessionManager instance = new TimeLimitedThemeFashionDressSessionManager();
/*     */   private ReentrantLock lock;
/*     */   private Session session;
/*     */   
/*  21 */   static TimeLimitedThemeFashionDressSessionManager getInstance() { return instance; }
/*     */   
/*     */   public TimeLimitedThemeFashionDressSessionManager() {
/*  24 */     this.lock = new ReentrantLock();
/*  25 */     this.session = null;
/*     */   }
/*     */   
/*     */   void postInit() {
/*  29 */     int startTimestamp = FashionDressManager.getCurrentActiveTimeLimitedThemeFashionDressStartTimestamp();
/*  30 */     if (startTimestamp > 0)
/*     */     {
/*  32 */       FashionDressManager.onTimeLimitedThemeFashionDressStart(startTimestamp);
/*     */     }
/*     */     else
/*     */     {
/*  36 */       long now = DateTimeUtils.getCurrTimeInMillis();
/*  37 */       TreeMap<Integer, STimeLimitedThemeFashionDressCfg> treeMap = (TreeMap)STimeLimitedThemeFashionDressCfg.getAll();
/*  38 */       Integer nextStartTimestamp = (Integer)treeMap.higherKey(Integer.valueOf((int)(now / 1000L)));
/*  39 */       if (nextStartTimestamp != null)
/*     */       {
/*  41 */         STimeLimitedThemeFashionDressCfg nextCfg = STimeLimitedThemeFashionDressCfg.get(nextStartTimestamp.intValue());
/*  42 */         if (nextCfg == null)
/*     */         {
/*     */ 
/*  45 */           return;
/*     */         }
/*  47 */         long interval = nextCfg.end_timestamp - now / 1000L;
/*  48 */         if (interval > 0L)
/*     */         {
/*  50 */           getInstance().setStartSession(interval, startTimestamp);
/*     */         }
/*     */         else
/*     */         {
/*  54 */           FashionDressManager.onTimeLimitedThemeFashionDressStart(nextStartTimestamp.intValue());
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   void setStartSession(long interval, int startTimestamp)
/*     */   {
/*  62 */     this.lock.lock();
/*     */     try
/*     */     {
/*  65 */       if (this.session != null)
/*     */       {
/*  67 */         this.session.stopTimer();
/*     */       }
/*  69 */       this.session = new StartSession(interval, startTimestamp);
/*     */     }
/*     */     finally
/*     */     {
/*  73 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   void setEndSession(long interval, int startTimestamp)
/*     */   {
/*  79 */     this.lock.lock();
/*     */     try
/*     */     {
/*  82 */       if (this.session != null)
/*     */       {
/*  84 */         this.session.stopTimer();
/*     */       }
/*  86 */       this.session = new EndSession(interval, startTimestamp);
/*     */     }
/*     */     finally
/*     */     {
/*  90 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   void stopSession()
/*     */   {
/*  96 */     this.lock.lock();
/*     */     try
/*     */     {
/*  99 */       if (this.session != null)
/*     */       {
/* 101 */         this.session.stopTimer();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 106 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   class StartSession extends Session
/*     */   {
/*     */     private final int startTimestamp;
/*     */     
/*     */     public StartSession(long interval, int startTimestamp)
/*     */     {
/* 116 */       super(0L);
/* 117 */       this.startTimestamp = startTimestamp;
/* 118 */       GameServer.logger().info(String.format("[fashiondress]TimeLimitedThemeFashionDressSessionManager.StartSession@start session start|interval=%d|start_timestamp=%d", new Object[] { Long.valueOf(interval), Integer.valueOf(startTimestamp) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     protected void onTimeOut()
/*     */     {
/* 127 */       FashionDressManager.onTimeLimitedThemeFashionDressStart(this.startTimestamp);
/*     */     }
/*     */   }
/*     */   
/*     */   class EndSession extends Session
/*     */   {
/*     */     private final int startTimestamp;
/*     */     
/*     */     public EndSession(long interval, int startTimestamp)
/*     */     {
/* 137 */       super(0L);
/* 138 */       this.startTimestamp = startTimestamp;
/* 139 */       GameServer.logger().info(String.format("[fashiondress]TimeLimitedThemeFashionDressSessionManager.EndSession@end session start|interval=%d|start_timestamp=%d", new Object[] { Long.valueOf(interval), Integer.valueOf(startTimestamp) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     protected void onTimeOut()
/*     */     {
/* 148 */       FashionDressManager.onTimeLimitedThemeFashionDressEnd(this.startTimestamp);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\TimeLimitedThemeFashionDressSessionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */