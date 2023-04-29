/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ 
/*    */ public class AdvertChartCache
/*    */ {
/* 11 */   private static final AdvertChartCache INSTANCE = new AdvertChartCache();
/*    */   
/*    */   public static final AdvertChartCache getInstance()
/*    */   {
/* 15 */     return INSTANCE;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 22 */   private final ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/* 23 */   private final Map<Long, AdvertChart> cache = new HashMap();
/*    */   
/*    */   public AdvertChart put(long advertId, AdvertChart advertChart)
/*    */   {
/* 27 */     this.lock.writeLock().lock();
/*    */     try
/*    */     {
/* 30 */       return (AdvertChart)this.cache.put(Long.valueOf(advertId), advertChart);
/*    */     }
/*    */     finally
/*    */     {
/* 34 */       this.lock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public void remove(long advertId)
/*    */   {
/* 40 */     this.lock.writeLock().lock();
/*    */     try
/*    */     {
/* 43 */       this.cache.remove(Long.valueOf(advertId));
/*    */     }
/*    */     finally
/*    */     {
/* 47 */       this.lock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public AdvertChart get(long advertId)
/*    */   {
/* 53 */     this.lock.readLock().lock();
/*    */     try
/*    */     {
/* 56 */       return (AdvertChart)this.cache.get(Long.valueOf(advertId));
/*    */     }
/*    */     finally
/*    */     {
/* 60 */       this.lock.readLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public void buildRank(Collection<Long> advertids, AdvertRank rank)
/*    */   {
/* 66 */     this.lock.readLock().lock();
/*    */     try
/*    */     {
/* 69 */       for (Long advertId : advertids)
/*    */       {
/* 71 */         AdvertChart advertChart = (AdvertChart)this.cache.get(advertId);
/* 72 */         if (advertChart != null)
/*    */         {
/* 74 */           rank.rank(advertChart);
/*    */         }
/*    */       }
/*    */     }
/*    */     finally
/*    */     {
/* 80 */       this.lock.readLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\AdvertChartCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */