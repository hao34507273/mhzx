/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ 
/*    */ class MatchContextManager
/*    */ {
/* 11 */   private static final MatchContextManager instance = new MatchContextManager();
/*    */   
/*    */   public static final MatchContextManager getInstance()
/*    */   {
/* 15 */     return instance;
/*    */   }
/*    */   
/* 18 */   private int idGenerator = 0;
/* 19 */   private final Map<Long, MatchContext> contexts = new java.util.HashMap();
/* 20 */   private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
/*    */   
/*    */ 
/*    */   public MatchContext createMatchContext(int levelRange, long leaderRoleid, List<RoleMatchMarkingInfo> roleMatchMarkingInfos, MatchActivityContext activityContext)
/*    */   {
/* 25 */     this.rwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 28 */       int baseContextid = ++this.idGenerator;
/* 29 */       MatchContext context = new MatchContext(baseContextid, levelRange, leaderRoleid, roleMatchMarkingInfos, activityContext);
/*    */       
/* 31 */       this.contexts.put(Long.valueOf(context.contextid), context);
/*    */       
/* 33 */       return context;
/*    */     }
/*    */     finally
/*    */     {
/* 37 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public MatchContext removeContext(long contextid)
/*    */   {
/* 43 */     this.rwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 46 */       MatchContext context = (MatchContext)this.contexts.remove(Long.valueOf(contextid));
/* 47 */       if (context != null)
/*    */       {
/* 49 */         context.stopTimeoutWatchDog();
/*    */       }
/* 51 */       return context;
/*    */     }
/*    */     finally
/*    */     {
/* 55 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public MatchContext getContext(long contextid)
/*    */   {
/* 61 */     this.rwLock.readLock().lock();
/*    */     try
/*    */     {
/* 64 */       return (MatchContext)this.contexts.get(Long.valueOf(contextid));
/*    */     }
/*    */     finally
/*    */     {
/* 68 */       this.rwLock.readLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\MatchContextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */