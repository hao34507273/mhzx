/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ 
/*     */ public class PointRaceManager
/*     */ {
/*  10 */   private static final PointRaceManager instance = new PointRaceManager();
/*     */   
/*     */   public static PointRaceManager getInstance()
/*     */   {
/*  14 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  21 */   private final ReadWriteLock rwLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*  22 */   private final Map<Long, PointRaceZoneManager> zones = new HashMap();
/*     */   
/*     */   public boolean putZoneManager(long worldid, PointRaceZoneManager manager)
/*     */   {
/*  26 */     this.rwLock.writeLock().lock();
/*     */     try {
/*     */       boolean bool;
/*  29 */       if (this.zones.containsKey(Long.valueOf(worldid)))
/*     */       {
/*  31 */         return false;
/*     */       }
/*  33 */       this.zones.put(Long.valueOf(worldid), manager);
/*  34 */       return true;
/*     */     }
/*     */     finally
/*     */     {
/*  38 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public PointRaceZoneManager removeZoneManager(long worldid)
/*     */   {
/*  44 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/*  47 */       return (PointRaceZoneManager)this.zones.remove(Long.valueOf(worldid));
/*     */     }
/*     */     finally
/*     */     {
/*  51 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public PointRaceZoneManager getZoneManager(long worldid)
/*     */   {
/*  57 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/*  60 */       return (PointRaceZoneManager)this.zones.get(Long.valueOf(worldid));
/*     */     }
/*     */     finally
/*     */     {
/*  64 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public int getReservedNum()
/*     */   {
/*  70 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/*  73 */       int num = 0;
/*  74 */       for (PointRaceZoneManager zoneManager : this.zones.values())
/*     */       {
/*  76 */         num += zoneManager.getReservedNum();
/*     */       }
/*  78 */       return num;
/*     */     }
/*     */     finally
/*     */     {
/*  82 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public int getOnlineNum()
/*     */   {
/*  88 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/*  91 */       int num = 0;
/*  92 */       for (PointRaceZoneManager zoneManager : this.zones.values())
/*     */       {
/*  94 */         num += zoneManager.getOnlineNum();
/*     */       }
/*  96 */       return num;
/*     */     }
/*     */     finally
/*     */     {
/* 100 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PointRaceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */