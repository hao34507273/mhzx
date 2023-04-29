/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.SingleCrossFieldRoleMatchInfo;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.atomic.AtomicInteger;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SingleCrossFieldRoamedContextManager
/*    */ {
/* 18 */   private static final SingleCrossFieldRoamedContextManager instance = new SingleCrossFieldRoamedContextManager();
/*    */   
/*    */   public static final SingleCrossFieldRoamedContextManager getInstance()
/*    */   {
/* 22 */     return instance;
/*    */   }
/*    */   
/* 25 */   private AtomicInteger idGenerator = new AtomicInteger(0);
/* 26 */   private final Map<Long, SingleCrossFieldRoamedContext> contexts = new HashMap();
/* 27 */   private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
/*    */   
/*    */   public long getRoamedRoomInstanceid()
/*    */   {
/* 31 */     return GameServerInfoManager.toGlobalId(this.idGenerator.incrementAndGet());
/*    */   }
/*    */   
/*    */ 
/*    */   public SingleCrossFieldRoamedContext addContext(long roamedRoomInstanceid, int activityCfgid, List<SingleCrossFieldRoleMatchInfo> roleMatchInfos)
/*    */   {
/* 37 */     this.rwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 40 */       if (this.contexts.containsKey(Long.valueOf(roamedRoomInstanceid)))
/*    */       {
/* 42 */         return null;
/*    */       }
/* 44 */       SingleCrossFieldRoamedContext context = new SingleCrossFieldRoamedContext(roamedRoomInstanceid, activityCfgid, roleMatchInfos);
/*    */       
/* 46 */       this.contexts.put(Long.valueOf(context.getRoamedRoomInstanceid()), context);
/* 47 */       return context;
/*    */     }
/*    */     finally
/*    */     {
/* 51 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public SingleCrossFieldRoamedContext removeContext(long roamedRoomInstanceid)
/*    */   {
/* 57 */     this.rwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 60 */       SingleCrossFieldRoamedContext context = (SingleCrossFieldRoamedContext)this.contexts.remove(Long.valueOf(roamedRoomInstanceid));
/* 61 */       if (context != null)
/*    */       {
/* 63 */         context.stopTimeoutObserver();
/*    */       }
/* 65 */       return context;
/*    */     }
/*    */     finally
/*    */     {
/* 69 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public SingleCrossFieldRoamedContext getContext(long roamedRoomInstanceid)
/*    */   {
/* 75 */     this.rwLock.readLock().lock();
/*    */     try
/*    */     {
/* 78 */       return (SingleCrossFieldRoamedContext)this.contexts.get(Long.valueOf(roamedRoomInstanceid));
/*    */     }
/*    */     finally
/*    */     {
/* 82 */       this.rwLock.readLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\SingleCrossFieldRoamedContextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */