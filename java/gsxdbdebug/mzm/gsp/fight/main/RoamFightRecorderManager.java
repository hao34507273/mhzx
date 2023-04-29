/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ 
/*     */ public class RoamFightRecorderManager
/*     */ {
/*  10 */   private static final RoamFightRecorderManager instance = new RoamFightRecorderManager();
/*     */   
/*     */   public static final RoamFightRecorderManager getInstance()
/*     */   {
/*  14 */     return instance;
/*     */   }
/*     */   
/*  17 */   private final Map<Long, RoamFightRecorder> recorders = new java.util.HashMap();
/*  18 */   private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
/*     */   
/*  20 */   private final Map<Long, Long> observerToRecorder = new java.util.HashMap();
/*  21 */   private final ReadWriteLock observerToRecorderRWLock = new ReentrantReadWriteLock();
/*     */   
/*     */   public final RoamFightRecorder addRoamFightRecorder(long recordid)
/*     */   {
/*  25 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/*  28 */       if (this.recorders.containsKey(Long.valueOf(recordid)))
/*     */       {
/*  30 */         return null;
/*     */       }
/*     */       
/*  33 */       RoamFightRecorder recorder = new RoamFightRecorder(recordid);
/*  34 */       this.recorders.put(Long.valueOf(recordid), recorder);
/*  35 */       return recorder;
/*     */     }
/*     */     finally
/*     */     {
/*  39 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public final RoamFightRecorder removeRoamFightRecorder(long recordid)
/*     */   {
/*  45 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/*  48 */       return (RoamFightRecorder)this.recorders.remove(Long.valueOf(recordid));
/*     */     }
/*     */     finally
/*     */     {
/*  52 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public final RoamFightRecorder getRoamFightRecorder(long recordid)
/*     */   {
/*  58 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/*  61 */       return (RoamFightRecorder)this.recorders.get(Long.valueOf(recordid));
/*     */     }
/*     */     finally
/*     */     {
/*  65 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public final RoamFightRecorder getObserverRecorder(long observerid)
/*     */   {
/*  71 */     this.observerToRecorderRWLock.readLock().lock();
/*     */     try
/*     */     {
/*  74 */       Long recordid = (Long)this.observerToRecorder.get(Long.valueOf(observerid));
/*  75 */       RoamFightRecorder localRoamFightRecorder; if (recordid == null)
/*     */       {
/*  77 */         return null;
/*     */       }
/*     */       
/*  80 */       return getRoamFightRecorder(recordid.longValue());
/*     */     }
/*     */     finally
/*     */     {
/*  84 */       this.observerToRecorderRWLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public final void addObserverRecorder(long observerid, long recordid)
/*     */   {
/*  90 */     this.observerToRecorderRWLock.writeLock().lock();
/*     */     try
/*     */     {
/*  93 */       Long oldRecordid = (Long)this.observerToRecorder.put(Long.valueOf(observerid), Long.valueOf(recordid));
/*  94 */       if ((oldRecordid == null) || (oldRecordid.longValue() == recordid)) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/*  99 */       RoamFightRecorder recorder = getRoamFightRecorder(oldRecordid.longValue());
/* 100 */       if (recorder == null) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/* 105 */       recorder.removeObserver(observerid);
/*     */     }
/*     */     finally
/*     */     {
/* 109 */       this.observerToRecorderRWLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public final void removeObserverRecorder(long observerid)
/*     */   {
/* 115 */     this.observerToRecorderRWLock.writeLock().lock();
/*     */     try
/*     */     {
/* 118 */       Long recordid = (Long)this.observerToRecorder.remove(Long.valueOf(observerid));
/* 119 */       if (recordid == null) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/* 124 */       RoamFightRecorder recorder = getRoamFightRecorder(recordid.longValue());
/* 125 */       if (recorder == null) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/* 130 */       recorder.removeObserver(observerid);
/*     */     }
/*     */     finally
/*     */     {
/* 134 */       this.observerToRecorderRWLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\RoamFightRecorderManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */