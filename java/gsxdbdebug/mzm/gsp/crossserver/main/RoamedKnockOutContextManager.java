/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.atomic.AtomicInteger;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ 
/*    */ public class RoamedKnockOutContextManager
/*    */ {
/* 13 */   private static final RoamedKnockOutContextManager instance = new RoamedKnockOutContextManager();
/*    */   
/*    */   public static final RoamedKnockOutContextManager getInstance()
/*    */   {
/* 17 */     return instance;
/*    */   }
/*    */   
/* 20 */   private AtomicInteger idGenerator = new AtomicInteger(0);
/* 21 */   private final Map<Long, RoamedKnockOutContext> contexts = new HashMap();
/* 22 */   private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
/*    */   
/*    */   public long getRoamedRoomInstanceid()
/*    */   {
/* 26 */     return GameServerInfoManager.toGlobalId(this.idGenerator.incrementAndGet());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public RoamedKnockOutContext addRoamedCrossBattleContext(long roamedRoomInstanceid, RoamedKnockOutTeamInfo crossBattleTeamInfo, RoamedKnockOutTeamInfo opponentCrossBattleTeamInfo, int activityFightTypeId, int fightStage, int fightIndexId)
/*    */   {
/* 34 */     this.rwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 37 */       if (this.contexts.containsKey(Long.valueOf(roamedRoomInstanceid)))
/*    */       {
/* 39 */         return null;
/*    */       }
/*    */       
/* 42 */       RoamedKnockOutContext context = new RoamedKnockOutContext(roamedRoomInstanceid, crossBattleTeamInfo, opponentCrossBattleTeamInfo, activityFightTypeId, fightStage, fightIndexId);
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 48 */       this.contexts.put(Long.valueOf(context.roamedRoomInstanceid), context);
/*    */       
/* 50 */       return context;
/*    */     }
/*    */     finally
/*    */     {
/* 54 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public RoamedKnockOutContext removeRoamedMathContext(long roamedInstanceid)
/*    */   {
/* 60 */     this.rwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 63 */       return (RoamedKnockOutContext)this.contexts.remove(Long.valueOf(roamedInstanceid));
/*    */     }
/*    */     finally
/*    */     {
/* 67 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public RoamedKnockOutContext getRoamedMathContext(long roamedInstanceid)
/*    */   {
/* 73 */     this.rwLock.readLock().lock();
/*    */     try
/*    */     {
/* 76 */       return (RoamedKnockOutContext)this.contexts.get(Long.valueOf(roamedInstanceid));
/*    */     }
/*    */     finally
/*    */     {
/* 80 */       this.rwLock.readLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\RoamedKnockOutContextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */