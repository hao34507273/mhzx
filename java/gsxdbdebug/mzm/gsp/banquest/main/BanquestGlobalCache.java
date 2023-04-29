/*    */ package mzm.gsp.banquest.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ import mzm.gsp.GameServer;
/*    */ 
/*    */ public class BanquestGlobalCache
/*    */ {
/* 12 */   private final Map<Long, Long> role2startTime = new HashMap();
/*    */   
/* 14 */   private final ReadWriteLock lock = new ReentrantReadWriteLock();
/*    */   
/* 16 */   private static final BanquestGlobalCache instance = new BanquestGlobalCache();
/*    */   
/*    */   static BanquestGlobalCache getInstance()
/*    */   {
/* 20 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   void addRoleStartTime(long roleId, long startTime)
/*    */   {
/* 31 */     this.lock.writeLock().lock();
/*    */     try
/*    */     {
/* 34 */       Long cacheStartTime = (Long)this.role2startTime.get(Long.valueOf(roleId));
/* 35 */       if (cacheStartTime != null)
/*    */       {
/* 37 */         GameServer.logger().error(String.format("[banquest]BanquestGlobalCache.addRoleStartTime@ has old startTime!|roleId=%d|oldTime=%d|newTime=%d", new Object[] { Long.valueOf(roleId), cacheStartTime, Long.valueOf(startTime) }));
/*    */       }
/*    */       
/*    */ 
/*    */ 
/* 42 */       this.role2startTime.put(Long.valueOf(roleId), cacheStartTime);
/*    */     }
/*    */     finally
/*    */     {
/* 46 */       this.lock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   void rmRoleStartTime(long roleId)
/*    */   {
/* 57 */     this.lock.writeLock().lock();
/*    */     try
/*    */     {
/* 60 */       this.role2startTime.remove(Long.valueOf(roleId));
/*    */     }
/*    */     finally
/*    */     {
/* 64 */       this.lock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   long getBanquestStartTime(long roleId)
/*    */   {
/* 76 */     this.lock.readLock().lock();
/*    */     try
/*    */     {
/* 79 */       Long cacheStartTime = (Long)this.role2startTime.get(Long.valueOf(roleId));
/* 80 */       return cacheStartTime == null ? -1L : cacheStartTime.longValue();
/*    */     }
/*    */     finally
/*    */     {
/* 84 */       this.lock.readLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\banquest\main\BanquestGlobalCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */