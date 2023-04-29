/*     */ package mzm.gsp.gang.cache;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import mzm.gsp.gang.main.GangManager;
/*     */ import xdb.TTable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GangLRUCache
/*     */ {
/*  21 */   private GangMap gangs = null;
/*     */   
/*  23 */   private final ReadWriteLock lock = new ReentrantReadWriteLock();
/*     */   
/*     */   private static final int CAPACITY = 1024;
/*  26 */   private static volatile GangLRUCache instance = null;
/*     */   
/*     */   public static GangLRUCache getInstance() {
/*  29 */     if (instance == null) {
/*  30 */       synchronized (GangLRUCache.class)
/*     */       {
/*  32 */         if (instance == null) {
/*  33 */           instance = new GangLRUCache();
/*     */         }
/*     */       }
/*     */     }
/*  37 */     return instance;
/*     */   }
/*     */   
/*     */   private GangLRUCache()
/*     */   {
/*  42 */     int capacity = xtable.Gang.getTable().getCacheCapacity();
/*  43 */     if (capacity < 1024) {
/*  44 */       capacity = 1024;
/*     */     }
/*  46 */     this.gangs = new GangMap(capacity);
/*     */   }
/*     */   
/*     */   public boolean addGang(long gangid, Gang gang)
/*     */   {
/*  51 */     this.lock.writeLock().lock();
/*     */     try {
/*  53 */       Gang old = (Gang)this.gangs.put(Long.valueOf(gangid), gang);
/*  54 */       boolean bool; if (old != null) {
/*  55 */         GangManager.logError("GangCacheManager.addGang@duplicated gang when add|gangid=%d", new Object[] { Long.valueOf(gangid) });
/*  56 */         return false;
/*     */       }
/*  58 */       return true;
/*     */     } finally {
/*  60 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean removeGang(long gangid)
/*     */   {
/*  67 */     this.lock.writeLock().lock();
/*     */     try {
/*  69 */       Gang gang = (Gang)this.gangs.remove(Long.valueOf(gangid));
/*  70 */       boolean bool; if (gang == null) {
/*  71 */         GangManager.logError("GangCacheManager.removeGang@no gang when remove|gangid=%d", new Object[] { Long.valueOf(gangid) });
/*  72 */         return false;
/*     */       }
/*  74 */       return true;
/*     */     } finally {
/*  76 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public Gang getGang(long gangid) {
/*  81 */     this.lock.readLock().lock();
/*     */     try {
/*  83 */       return (Gang)this.gangs.get(Long.valueOf(gangid));
/*     */     } finally {
/*  85 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public Map<Long, Gang> getGangs()
/*     */   {
/*  91 */     this.lock.readLock().lock();
/*     */     try {
/*  93 */       return new HashMap(this.gangs);
/*     */     } finally {
/*  95 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public Set<Long> getGangIdSet() {
/* 100 */     this.lock.readLock().lock();
/*     */     try {
/* 102 */       return new HashSet(this.gangs.keySet());
/*     */     } finally {
/* 104 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class GangMap
/*     */     extends LinkedHashMap<Long, Gang>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     private final int capacity;
/*     */     
/*     */     GangMap(int capacity)
/*     */     {
/* 117 */       this.capacity = capacity;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean removeEldestEntry(Map.Entry<Long, Gang> eldest)
/*     */     {
/* 123 */       if (size() > this.capacity) {
/* 124 */         GangManager.logInfo("GangMap.removeEldestEntry@remove eldest entry|gangid=%d|size=%d|capacity=%d", new Object[] { eldest.getKey(), Integer.valueOf(size()), Integer.valueOf(this.capacity) });
/*     */         
/* 126 */         return true;
/*     */       }
/* 128 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\cache\GangLRUCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */