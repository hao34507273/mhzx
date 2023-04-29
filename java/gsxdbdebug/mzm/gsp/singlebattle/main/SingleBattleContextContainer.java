/*    */ package mzm.gsp.singlebattle.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.atomic.AtomicLong;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SingleBattleContextContainer
/*    */ {
/* 22 */   private final Map<Long, SingleBattleContext> contexts = new HashMap();
/*    */   
/* 24 */   private final ReadWriteLock lock = new ReentrantReadWriteLock();
/*    */   
/* 26 */   private static final SingleBattleContextContainer instance = new SingleBattleContextContainer();
/*    */   
/* 28 */   private static AtomicLong nextContextId = new AtomicLong(0L);
/*    */   
/*    */   static SingleBattleContextContainer getInstance()
/*    */   {
/* 32 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   long addContext(SingleBattleContext context)
/*    */   {
/* 44 */     long contextId = nextContextId.addAndGet(1L);
/* 45 */     this.lock.writeLock().lock();
/*    */     try
/*    */     {
/* 48 */       this.contexts.put(Long.valueOf(contextId), context);
/*    */     }
/*    */     finally
/*    */     {
/* 52 */       this.lock.writeLock().unlock();
/*    */     }
/* 54 */     return contextId;
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
/*    */   SingleBattleContext removeContext(long contextId)
/*    */   {
/* 67 */     this.lock.writeLock().lock();
/*    */     SingleBattleContext context;
/*    */     try {
/* 70 */       context = (SingleBattleContext)this.contexts.remove(Long.valueOf(contextId));
/*    */     }
/*    */     finally
/*    */     {
/* 74 */       this.lock.writeLock().unlock();
/*    */     }
/* 76 */     return context;
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
/*    */   SingleBattleContext getContext(long contextId)
/*    */   {
/* 89 */     this.lock.readLock().lock();
/*    */     SingleBattleContext context;
/*    */     try {
/* 92 */       context = (SingleBattleContext)this.contexts.get(Long.valueOf(contextId));
/*    */     }
/*    */     finally
/*    */     {
/* 96 */       this.lock.readLock().unlock();
/*    */     }
/* 98 */     return context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\SingleBattleContextContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */