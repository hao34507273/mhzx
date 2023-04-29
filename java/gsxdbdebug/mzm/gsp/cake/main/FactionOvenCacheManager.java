/*     */ package mzm.gsp.cake.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ 
/*     */ public class FactionOvenCacheManager
/*     */ {
/*  12 */   private static final FactionOvenCacheManager instance = new FactionOvenCacheManager();
/*     */   
/*     */   public static FactionOvenCacheManager getInstance()
/*     */   {
/*  16 */     return instance;
/*     */   }
/*     */   
/*  19 */   private final ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*     */   
/*  21 */   private Map<Integer, Map<Long, Set<Long>>> factionOvenInfos = new HashMap();
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
/*     */ 
/*     */ 
/*     */   Set<Long> getFactionOvenInstanceIds(int activityId, long factionId)
/*     */   {
/*  36 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/*  39 */       Map<Long, Set<Long>> factionInfos = (Map)this.factionOvenInfos.get(Integer.valueOf(activityId));
/*  40 */       Object localObject1; if (factionInfos == null)
/*     */       {
/*  42 */         return null;
/*     */       }
/*  44 */       return (Set)factionInfos.get(Long.valueOf(factionId));
/*     */     }
/*     */     finally
/*     */     {
/*  48 */       this.lock.readLock().unlock();
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
/*     */   void putFactionOvenInstanceIds(int activityId, long factionId, Set<Long> ovenInstanceIds)
/*     */   {
/*  61 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/*  64 */       Map<Long, Set<Long>> factionInfos = (Map)this.factionOvenInfos.get(Integer.valueOf(activityId));
/*  65 */       if (factionInfos == null)
/*     */       {
/*  67 */         this.factionOvenInfos.put(Integer.valueOf(activityId), factionInfos = new HashMap());
/*     */       }
/*  69 */       factionInfos.put(Long.valueOf(factionId), ovenInstanceIds);
/*     */     }
/*     */     finally
/*     */     {
/*  73 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Map<Integer, Set<Long>> removeAllFactionData(long factionId)
/*     */   {
/*  85 */     Map<Integer, Set<Long>> activityId2OvenInstanceIds = new HashMap();
/*  86 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/*  89 */       for (Map.Entry<Integer, Map<Long, Set<Long>>> entry : this.factionOvenInfos.entrySet())
/*     */       {
/*  91 */         int activityId = ((Integer)entry.getKey()).intValue();
/*  92 */         Map<Long, Set<Long>> factionInfos = (Map)entry.getValue();
/*  93 */         Set<Long> ovenInstanceIds = (Set)factionInfos.remove(Long.valueOf(factionId));
/*  94 */         if (ovenInstanceIds != null)
/*     */         {
/*     */ 
/*     */ 
/*  98 */           activityId2OvenInstanceIds.put(Integer.valueOf(activityId), ovenInstanceIds);
/*     */         }
/*     */       }
/*     */     }
/*     */     finally {
/* 103 */       this.lock.writeLock().unlock();
/*     */     }
/* 105 */     return activityId2OvenInstanceIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Set<Long> removeFactionOvenInstanceIds(int activityId, long factionId)
/*     */   {
/* 117 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/* 120 */       Map<Long, Set<Long>> factionInfos = (Map)this.factionOvenInfos.get(Integer.valueOf(activityId));
/* 121 */       Object localObject1; if (factionInfos == null)
/*     */       {
/* 123 */         return null;
/*     */       }
/* 125 */       return (Set)factionInfos.remove(Long.valueOf(factionId));
/*     */     }
/*     */     finally
/*     */     {
/* 129 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Set<Long> removeActivityOvens(int activityId)
/*     */   {
/* 141 */     Set<Long> allOvenInstanceIds = new java.util.HashSet();
/* 142 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/* 145 */       Map<Long, Set<Long>> factionInfos = (Map)this.factionOvenInfos.remove(Integer.valueOf(activityId));
/* 146 */       if (factionInfos != null)
/*     */       {
/* 148 */         for (Map.Entry<Long, Set<Long>> entry : factionInfos.entrySet())
/*     */         {
/* 150 */           allOvenInstanceIds.addAll((java.util.Collection)entry.getValue());
/*     */         }
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 156 */       this.lock.writeLock().unlock();
/*     */     }
/* 158 */     return allOvenInstanceIds;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\main\FactionOvenCacheManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */