/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ 
/*    */ public class PointRaceBackContextManager
/*    */ {
/* 10 */   private static final PointRaceBackContextManager instance = new PointRaceBackContextManager();
/*    */   
/*    */   public static final PointRaceBackContextManager getInstance()
/*    */   {
/* 14 */     return instance;
/*    */   }
/*    */   
/* 17 */   private final Map<Long, PointRaceBackContext> contexts = new java.util.HashMap();
/* 18 */   private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
/*    */   
/*    */   public void put(long corpsid, PointRaceBackContext backContext)
/*    */   {
/* 22 */     this.rwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 25 */       this.contexts.put(Long.valueOf(corpsid), backContext);
/*    */     }
/*    */     finally
/*    */     {
/* 29 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public PointRaceBackContext remove(long corpsid)
/*    */   {
/* 35 */     this.rwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 38 */       return (PointRaceBackContext)this.contexts.remove(Long.valueOf(corpsid));
/*    */     }
/*    */     finally
/*    */     {
/* 42 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public PointRaceBackContext getContext(long corpsid)
/*    */   {
/* 48 */     this.rwLock.readLock().lock();
/*    */     try
/*    */     {
/* 51 */       return (PointRaceBackContext)this.contexts.get(Long.valueOf(corpsid));
/*    */     }
/*    */     finally
/*    */     {
/* 55 */       this.rwLock.readLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PointRaceBackContextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */