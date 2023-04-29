/*    */ package mzm.gsp.cake.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ 
/*    */ public class CreateSceneFactionCache
/*    */ {
/* 10 */   private final Set<Long> joinFactionIds = new HashSet();
/*    */   
/* 12 */   private final ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*    */   
/* 14 */   private static final CreateSceneFactionCache instance = new CreateSceneFactionCache();
/*    */   
/*    */   static CreateSceneFactionCache getInstance()
/*    */   {
/* 18 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   Set<Long> getAllJoinedFactionIds()
/*    */   {
/* 28 */     this.lock.readLock().lock();
/*    */     try
/*    */     {
/* 31 */       return new HashSet(this.joinFactionIds);
/*    */     }
/*    */     finally
/*    */     {
/* 35 */       this.lock.readLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   boolean alreadyCreateScene(long factionId)
/*    */   {
/* 46 */     this.lock.readLock().lock();
/*    */     try
/*    */     {
/* 49 */       return this.joinFactionIds.contains(Long.valueOf(factionId));
/*    */     }
/*    */     finally
/*    */     {
/* 53 */       this.lock.readLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   boolean removeFactionId(long factionId)
/*    */   {
/* 65 */     this.lock.writeLock().lock();
/*    */     try
/*    */     {
/* 68 */       return this.joinFactionIds.remove(Long.valueOf(factionId));
/*    */     }
/*    */     finally
/*    */     {
/* 72 */       this.lock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   boolean addFactionId(long factionId)
/*    */   {
/* 83 */     this.lock.writeLock().lock();
/*    */     try
/*    */     {
/* 86 */       return this.joinFactionIds.add(Long.valueOf(factionId));
/*    */     }
/*    */     finally
/*    */     {
/* 90 */       this.lock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\main\CreateSceneFactionCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */