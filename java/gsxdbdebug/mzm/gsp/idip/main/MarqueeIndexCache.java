/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ 
/*    */ public class MarqueeIndexCache
/*    */ {
/* 12 */   private static final MarqueeIndexCache instance = new MarqueeIndexCache();
/*    */   
/*    */   public static MarqueeIndexCache getInstance()
/*    */   {
/* 16 */     return instance;
/*    */   }
/*    */   
/* 19 */   private final Lock lock = new java.util.concurrent.locks.ReentrantLock();
/* 20 */   private final Map<Long, Long> indexToIds = new HashMap();
/*    */   
/*    */   public void put(long index, long id)
/*    */   {
/* 24 */     this.lock.lock();
/*    */     try
/*    */     {
/* 27 */       this.indexToIds.put(Long.valueOf(index), Long.valueOf(id));
/*    */     }
/*    */     finally
/*    */     {
/* 31 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean contains(long index)
/*    */   {
/* 37 */     this.lock.lock();
/*    */     try
/*    */     {
/* 40 */       return this.indexToIds.containsKey(Long.valueOf(index));
/*    */     }
/*    */     finally
/*    */     {
/* 44 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public void remove(long index)
/*    */   {
/* 50 */     this.lock.lock();
/*    */     try
/*    */     {
/* 53 */       this.indexToIds.remove(Long.valueOf(index));
/*    */     }
/*    */     finally
/*    */     {
/* 57 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public void removeByValue(long id)
/*    */   {
/* 63 */     this.lock.lock();
/*    */     try
/*    */     {
/* 66 */       Iterator<Map.Entry<Long, Long>> it = this.indexToIds.entrySet().iterator();
/* 67 */       while (it.hasNext())
/*    */       {
/* 69 */         if (id == ((Long)((Map.Entry)it.next()).getValue()).longValue())
/*    */         {
/* 71 */           it.remove();
/*    */         }
/*    */         
/*    */       }
/*    */     }
/*    */     finally
/*    */     {
/* 78 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public Long get(long index)
/*    */   {
/* 84 */     this.lock.lock();
/*    */     try
/*    */     {
/* 87 */       return (Long)this.indexToIds.get(Long.valueOf(index));
/*    */     }
/*    */     finally
/*    */     {
/* 91 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\MarqueeIndexCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */