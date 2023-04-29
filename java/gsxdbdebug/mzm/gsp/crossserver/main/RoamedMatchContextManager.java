/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.atomic.AtomicInteger;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ 
/*    */ class RoamedMatchContextManager
/*    */ {
/* 14 */   private static final RoamedMatchContextManager instance = new RoamedMatchContextManager();
/*    */   
/*    */   public static final RoamedMatchContextManager getInstance()
/*    */   {
/* 18 */     return instance;
/*    */   }
/*    */   
/* 21 */   private AtomicInteger idGenerator = new AtomicInteger(0);
/* 22 */   private final Map<Long, RoamedMatchContext> contexts = new HashMap();
/* 23 */   private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
/*    */   
/*    */   public long getRoamedRoomInstanceid()
/*    */   {
/* 27 */     return GameServerInfoManager.toGlobalId(this.idGenerator.incrementAndGet());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public RoamedMatchContext addRoamedMathContext(long roamedRoomInstanceid, int activityContextTypeid, List<RoamedRoleMatchMarkingInfo> roleMatchMarkingInfos, List<RoamedRoleMatchMarkingInfo> opponentRoleMatchMarkingInfos)
/*    */   {
/* 34 */     this.rwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 37 */       if (this.contexts.containsKey(Long.valueOf(roamedRoomInstanceid)))
/*    */       {
/* 39 */         return null;
/*    */       }
/*    */       
/* 42 */       RoamedMatchContext context = new RoamedMatchContext(roamedRoomInstanceid, activityContextTypeid, roleMatchMarkingInfos, opponentRoleMatchMarkingInfos);
/*    */       
/*    */ 
/* 45 */       this.contexts.put(Long.valueOf(context.roamedRoomInstanceid), context);
/*    */       
/* 47 */       return context;
/*    */     }
/*    */     finally
/*    */     {
/* 51 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public RoamedMatchContext removeRoamedMathContext(long roamedInstanceid)
/*    */   {
/* 57 */     this.rwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 60 */       return (RoamedMatchContext)this.contexts.remove(Long.valueOf(roamedInstanceid));
/*    */     }
/*    */     finally
/*    */     {
/* 64 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public RoamedMatchContext getRoamedMathContext(long roamedInstanceid)
/*    */   {
/* 70 */     this.rwLock.readLock().lock();
/*    */     try
/*    */     {
/* 73 */       return (RoamedMatchContext)this.contexts.get(Long.valueOf(roamedInstanceid));
/*    */     }
/*    */     finally
/*    */     {
/* 77 */       this.rwLock.readLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\RoamedMatchContextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */