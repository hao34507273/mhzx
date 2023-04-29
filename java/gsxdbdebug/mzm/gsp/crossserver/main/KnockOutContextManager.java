/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ 
/*    */ public class KnockOutContextManager
/*    */ {
/* 10 */   private static final KnockOutContextManager instance = new KnockOutContextManager();
/*    */   
/*    */   public static final KnockOutContextManager getInstance()
/*    */   {
/* 14 */     return instance;
/*    */   }
/*    */   
/* 17 */   private int idGenerator = 0;
/* 18 */   private final Map<Long, KnockOutContext> contexts = new java.util.HashMap();
/* 19 */   private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public KnockOutContext createCrossBattleContext(int fightType, int fightStage, long leaderRoleid, int fightIndexId, KnockOutTeamInfo crossBattleTeamInfo, KnockOutProcessContext crossBattleProcessContext)
/*    */   {
/* 37 */     this.rwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 40 */       int baseContextid = ++this.idGenerator;
/* 41 */       KnockOutContext context = new KnockOutContext(baseContextid, fightType, fightStage, leaderRoleid, fightIndexId, crossBattleTeamInfo, crossBattleProcessContext);
/*    */       
/*    */ 
/* 44 */       this.contexts.put(Long.valueOf(context.gameServerContextId), context);
/*    */       
/* 46 */       return context;
/*    */     }
/*    */     finally
/*    */     {
/* 50 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public KnockOutContext removeContext(long contextid)
/*    */   {
/* 63 */     this.rwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 66 */       KnockOutContext context = (KnockOutContext)this.contexts.remove(Long.valueOf(contextid));
/* 67 */       if (context != null)
/*    */       {
/* 69 */         context.stopTimeoutWatchDog();
/*    */       }
/* 71 */       return context;
/*    */     }
/*    */     finally
/*    */     {
/* 75 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public KnockOutContext getContext(long contextid)
/*    */   {
/* 81 */     this.rwLock.readLock().lock();
/*    */     try
/*    */     {
/* 84 */       return (KnockOutContext)this.contexts.get(Long.valueOf(contextid));
/*    */     }
/*    */     finally
/*    */     {
/* 88 */       this.rwLock.readLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\KnockOutContextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */