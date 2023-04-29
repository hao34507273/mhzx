/*    */ package mzm.gsp.task.ban;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GraphBanContainer
/*    */ {
/* 13 */   private final Map<Integer, GraphBanCache> banType2BanInfo = new HashMap();
/*    */   
/* 15 */   private final ReadWriteLock lock = new ReentrantReadWriteLock();
/*    */   
/* 17 */   private static final GraphBanContainer instance = new GraphBanContainer();
/*    */   
/*    */   static GraphBanContainer getInstance()
/*    */   {
/* 21 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   GraphBanCache getBanInfo(int banType)
/*    */   {
/* 34 */     GraphBanCache graphBanCache = null;
/*    */     
/* 36 */     this.lock.readLock().lock();
/*    */     try
/*    */     {
/* 39 */       graphBanCache = (GraphBanCache)this.banType2BanInfo.get(Integer.valueOf(banType));
/*    */     }
/*    */     finally
/*    */     {
/* 43 */       this.lock.readLock().unlock();
/*    */     }
/* 45 */     if (graphBanCache != null)
/*    */     {
/* 47 */       return graphBanCache;
/*    */     }
/*    */     
/* 50 */     this.lock.writeLock().lock();
/*    */     try
/*    */     {
/* 53 */       graphBanCache = (GraphBanCache)this.banType2BanInfo.get(Integer.valueOf(banType));
/* 54 */       GraphBanCache localGraphBanCache1; if (graphBanCache != null)
/*    */       {
/* 56 */         return graphBanCache;
/*    */       }
/*    */       
/* 59 */       graphBanCache = new GraphBanCache(banType);
/* 60 */       this.banType2BanInfo.put(Integer.valueOf(banType), graphBanCache);
/* 61 */       return graphBanCache;
/*    */     }
/*    */     finally
/*    */     {
/* 65 */       this.lock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\ban\GraphBanContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */