/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ 
/*     */ public class RoamFightRecorderCacheManager
/*     */ {
/*     */   private static final int CACHE_NUM = 10;
/*  15 */   private static final RoamFightRecorderCacheManager instance = new RoamFightRecorderCacheManager();
/*     */   
/*     */   public static final RoamFightRecorderCacheManager getInstance()
/*     */   {
/*  19 */     return instance;
/*     */   }
/*     */   
/*  22 */   private final LinkedHashMap<Long, RoamFightRecorderCache> recorders = new LinkedHashMap()
/*     */   {
/*     */     private static final long serialVersionUID = -4748446189881103460L;
/*     */     
/*     */     protected boolean removeEldestEntry(Map.Entry<Long, RoamFightRecorderCache> eldest)
/*     */     {
/*  28 */       if (size() <= 10)
/*     */       {
/*  30 */         return false;
/*     */       }
/*     */       
/*  33 */       return ((RoamFightRecorderCache)eldest.getValue()).isReady();
/*     */     }
/*     */   };
/*  36 */   private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
/*     */   
/*  38 */   private final Map<Long, Long> observerToRecorder = new HashMap();
/*  39 */   private final Lock observerToRecorderLock = new ReentrantLock();
/*     */   
/*     */   public final RoamFightRecorderCache addRoamFightRecorderCache(long recordid)
/*     */   {
/*  43 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/*  46 */       RoamFightRecorderCache recorderCache = (RoamFightRecorderCache)this.recorders.get(Long.valueOf(recordid));
/*  47 */       RoamFightRecorderCache localRoamFightRecorderCache1; if (recorderCache != null)
/*     */       {
/*  49 */         return recorderCache;
/*     */       }
/*     */       
/*  52 */       recorderCache = new RoamFightRecorderCache(recordid);
/*  53 */       this.recorders.put(Long.valueOf(recordid), recorderCache);
/*  54 */       return recorderCache;
/*     */     }
/*     */     finally
/*     */     {
/*  58 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public final RoamFightRecorderCache removeRoamFightRecorderCache(long recordid)
/*     */   {
/*  64 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/*  67 */       return (RoamFightRecorderCache)this.recorders.remove(Long.valueOf(recordid));
/*     */     }
/*     */     finally
/*     */     {
/*  71 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public final RoamFightRecorderCache getRoamFightRecorderCache(long recordid)
/*     */   {
/*  77 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/*  80 */       return (RoamFightRecorderCache)this.recorders.get(Long.valueOf(recordid));
/*     */     }
/*     */     finally
/*     */     {
/*  84 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public final void addObserverRecorderCache(long observerid, long recordid)
/*     */   {
/*  90 */     this.observerToRecorderLock.lock();
/*     */     try
/*     */     {
/*  93 */       Long oldRecordid = (Long)this.observerToRecorder.put(Long.valueOf(observerid), Long.valueOf(recordid));
/*     */       
/*  95 */       if ((oldRecordid == null) || (oldRecordid.longValue() == recordid)) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/* 100 */       RoamFightRecorderCache recorderCache = getRoamFightRecorderCache(oldRecordid.longValue());
/* 101 */       if (recorderCache == null) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/* 106 */       recorderCache.removeObserver(observerid);
/*     */     }
/*     */     finally
/*     */     {
/* 110 */       this.observerToRecorderLock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public final void removeObserverRecorderCache(long observerid)
/*     */   {
/* 116 */     this.observerToRecorderLock.lock();
/*     */     try
/*     */     {
/* 119 */       Long recordid = (Long)this.observerToRecorder.remove(Long.valueOf(observerid));
/* 120 */       if (recordid == null) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/* 125 */       RoamFightRecorderCache recorderCache = getRoamFightRecorderCache(recordid.longValue());
/* 126 */       if (recorderCache == null) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/* 131 */       recorderCache.removeObserver(observerid);
/*     */     }
/*     */     finally
/*     */     {
/* 135 */       this.observerToRecorderLock.unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\RoamFightRecorderCacheManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */