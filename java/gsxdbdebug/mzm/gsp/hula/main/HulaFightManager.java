/*    */ package mzm.gsp.hula.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ 
/*    */ public class HulaFightManager
/*    */ {
/* 13 */   private static final HulaFightManager instance = new HulaFightManager();
/*    */   
/*    */   public static HulaFightManager getInstance()
/*    */   {
/* 17 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 25 */   private final Set<Long> fihgtIds = new HashSet();
/*    */   
/* 27 */   private final ReadWriteLock locker = new ReentrantReadWriteLock();
/*    */   
/*    */   boolean addFightId(long fightid)
/*    */   {
/*    */     try
/*    */     {
/* 33 */       this.locker.writeLock().lock();
/* 34 */       return this.fihgtIds.add(Long.valueOf(fightid));
/*    */ 
/*    */     }
/*    */     finally
/*    */     {
/* 39 */       this.locker.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   boolean removeFightId(long worldId)
/*    */   {
/*    */     try
/*    */     {
/* 47 */       this.locker.writeLock().lock();
/* 48 */       return this.fihgtIds.remove(Long.valueOf(worldId));
/*    */     }
/*    */     finally
/*    */     {
/* 52 */       this.locker.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   void clear()
/*    */   {
/*    */     try
/*    */     {
/* 60 */       this.locker.writeLock().lock();
/* 61 */       this.fihgtIds.clear();
/*    */     }
/*    */     finally
/*    */     {
/* 65 */       this.locker.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   void closeFight()
/*    */   {
/*    */     try
/*    */     {
/* 73 */       this.locker.writeLock().lock();
/* 74 */       for (Iterator i$ = this.fihgtIds.iterator(); i$.hasNext();) { long fightid = ((Long)i$.next()).longValue();
/*    */         
/* 76 */         FightInterface.endFight(fightid);
/*    */       }
/* 78 */       this.fihgtIds.clear();
/*    */     }
/*    */     finally
/*    */     {
/* 82 */       this.locker.writeLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\HulaFightManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */