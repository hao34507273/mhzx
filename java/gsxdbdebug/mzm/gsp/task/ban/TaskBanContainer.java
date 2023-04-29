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
/*    */ public class TaskBanContainer
/*    */ {
/* 13 */   private final Map<Integer, TaskBanCache> banType2BanInfo = new HashMap();
/*    */   
/* 15 */   private final ReadWriteLock lock = new ReentrantReadWriteLock();
/*    */   
/* 17 */   private static final TaskBanContainer instance = new TaskBanContainer();
/*    */   
/*    */   static TaskBanContainer getInstance()
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
/*    */   TaskBanCache getCountInfo(int banType)
/*    */   {
/* 34 */     TaskBanCache banTaskCache = null;
/*    */     
/* 36 */     this.lock.readLock().lock();
/*    */     try
/*    */     {
/* 39 */       banTaskCache = (TaskBanCache)this.banType2BanInfo.get(Integer.valueOf(banType));
/*    */     }
/*    */     finally
/*    */     {
/* 43 */       this.lock.readLock().unlock();
/*    */     }
/* 45 */     if (banTaskCache != null)
/*    */     {
/* 47 */       return banTaskCache;
/*    */     }
/*    */     
/* 50 */     this.lock.writeLock().lock();
/*    */     try
/*    */     {
/* 53 */       banTaskCache = (TaskBanCache)this.banType2BanInfo.get(Integer.valueOf(banType));
/* 54 */       TaskBanCache localTaskBanCache1; if (banTaskCache != null)
/*    */       {
/* 56 */         return banTaskCache;
/*    */       }
/*    */       
/* 59 */       banTaskCache = new TaskBanCache(banType);
/* 60 */       this.banType2BanInfo.put(Integer.valueOf(banType), banTaskCache);
/* 61 */       return banTaskCache;
/*    */     }
/*    */     finally
/*    */     {
/* 65 */       this.lock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\ban\TaskBanContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */