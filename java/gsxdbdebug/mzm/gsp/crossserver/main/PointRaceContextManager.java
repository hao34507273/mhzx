/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ import mzm.gsp.crossbattle.point.PointRaceInfo;
/*    */ import mzm.gsp.crossbattle.point.RolePointRaceMarkingInfo;
/*    */ 
/*    */ class PointRaceContextManager
/*    */ {
/* 14 */   private static final PointRaceContextManager instance = new PointRaceContextManager();
/*    */   
/*    */   public static final PointRaceContextManager getInstance()
/*    */   {
/* 18 */     return instance;
/*    */   }
/*    */   
/* 21 */   private int idGenerator = 0;
/* 22 */   private final Map<Long, PointRaceContext> contexts = new HashMap();
/* 23 */   private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
/*    */   
/*    */ 
/*    */   public PointRaceContext createPointRaceContext(long corpsid, long leaderRoleid, List<RolePointRaceMarkingInfo> rolePointRaceMarkingInfos, PointRaceInfo pointRaceInfo)
/*    */   {
/* 28 */     this.rwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 31 */       int baseContextid = ++this.idGenerator;
/* 32 */       PointRaceContext context = new PointRaceContext(baseContextid, corpsid, leaderRoleid, rolePointRaceMarkingInfos, pointRaceInfo);
/*    */       
/* 34 */       this.contexts.put(Long.valueOf(context.contextid), context);
/* 35 */       return context;
/*    */     }
/*    */     finally
/*    */     {
/* 39 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public PointRaceContext removeContext(long contextid)
/*    */   {
/* 45 */     this.rwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 48 */       PointRaceContext context = (PointRaceContext)this.contexts.remove(Long.valueOf(contextid));
/* 49 */       if (context != null)
/*    */       {
/* 51 */         context.stopTimeoutWatchDog();
/*    */       }
/* 53 */       return context;
/*    */     }
/*    */     finally
/*    */     {
/* 57 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public PointRaceContext getContext(long contextid)
/*    */   {
/* 63 */     this.rwLock.readLock().lock();
/*    */     try
/*    */     {
/* 66 */       return (PointRaceContext)this.contexts.get(Long.valueOf(contextid));
/*    */     }
/*    */     finally
/*    */     {
/* 70 */       this.rwLock.readLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\PointRaceContextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */