/*     */ package mzm.gsp.crosscompete.roam;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import mzm.gsp.crossserver.main.CollectServerBalanceInfoHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoamLoadManager
/*     */   implements CollectServerBalanceInfoHandler
/*     */ {
/*  17 */   public static final RoamLoadManager instance = new RoamLoadManager();
/*     */   
/*  19 */   private final Map<Long, Integer> faction2OnlineCount = new HashMap();
/*  20 */   private final Map<Long, Integer> faction2MaxCount = new HashMap();
/*     */   
/*  22 */   private final ReadWriteLock lock = new ReentrantReadWriteLock();
/*     */   
/*     */ 
/*     */   void syncFactionOnlineCount(long factionid, int count)
/*     */   {
/*  27 */     this.lock.writeLock().lock();
/*     */     try {
/*  29 */       if (count <= 0) {
/*  30 */         this.faction2OnlineCount.remove(Long.valueOf(factionid));
/*     */       }
/*     */       else {
/*  33 */         this.faction2OnlineCount.put(Long.valueOf(factionid), Integer.valueOf(count));
/*     */         
/*  35 */         Integer maxCount = (Integer)this.faction2MaxCount.get(Long.valueOf(factionid));
/*  36 */         if ((maxCount == null) || (maxCount.intValue() < count)) {
/*  37 */           this.faction2MaxCount.put(Long.valueOf(factionid), maxCount);
/*     */         }
/*     */       }
/*     */     }
/*     */     finally {
/*  42 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   void syncFactionOnlineCountWithMax(long factionid, int count) {
/*  47 */     this.lock.writeLock().lock();
/*     */     try {
/*  49 */       if (count <= 0) {
/*  50 */         this.faction2OnlineCount.remove(Long.valueOf(factionid));
/*  51 */         this.faction2MaxCount.remove(Long.valueOf(factionid));
/*     */       }
/*     */       else {
/*  54 */         this.faction2OnlineCount.put(Long.valueOf(factionid), Integer.valueOf(count));
/*  55 */         this.faction2MaxCount.put(Long.valueOf(factionid), Integer.valueOf(count));
/*     */       }
/*     */     }
/*     */     finally {
/*  59 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   void addFaction(long factionid, int maxCount)
/*     */   {
/*  65 */     this.lock.writeLock().lock();
/*     */     try {
/*  67 */       this.faction2MaxCount.put(Long.valueOf(factionid), Integer.valueOf(maxCount));
/*     */     }
/*     */     finally {
/*  70 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   void removeFaction(long factionid) {
/*  75 */     this.lock.writeLock().lock();
/*     */     try {
/*  77 */       this.faction2OnlineCount.remove(Long.valueOf(factionid));
/*  78 */       this.faction2MaxCount.remove(Long.valueOf(factionid));
/*     */     }
/*     */     finally {
/*  81 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public int getOnlineNum()
/*     */   {
/*  87 */     int onlineCount = 0;
/*  88 */     this.lock.readLock().lock();
/*     */     try {
/*  90 */       for (i$ = this.faction2OnlineCount.values().iterator(); i$.hasNext();) { long count = ((Integer)i$.next()).intValue();
/*  91 */         onlineCount = (int)(onlineCount + count);
/*     */       }
/*     */     } finally {
/*     */       Iterator i$;
/*  95 */       this.lock.readLock().unlock();
/*     */     }
/*  97 */     return onlineCount;
/*     */   }
/*     */   
/*     */   public int getReservedNum()
/*     */   {
/* 102 */     int maxCount = 0;
/* 103 */     this.lock.readLock().lock();
/*     */     try {
/* 105 */       for (i$ = this.faction2MaxCount.values().iterator(); i$.hasNext();) { long count = ((Integer)i$.next()).intValue();
/* 106 */         maxCount = (int)(maxCount + count);
/*     */       }
/*     */     } finally {
/*     */       Iterator i$;
/* 110 */       this.lock.readLock().unlock();
/*     */     }
/* 112 */     return maxCount;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\RoamLoadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */