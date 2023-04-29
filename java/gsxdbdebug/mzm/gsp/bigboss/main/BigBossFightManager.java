/*    */ package mzm.gsp.bigboss.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import java.util.concurrent.locks.ReentrantLock;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BigBossFightManager
/*    */ {
/* 15 */   private static BigBossFightManager instance = new BigBossFightManager();
/*    */   
/*    */   static BigBossFightManager getInstance()
/*    */   {
/* 19 */     return instance;
/*    */   }
/*    */   
/* 22 */   private ReentrantLock lock = new ReentrantLock();
/* 23 */   private Set<Long> fightids = new HashSet();
/*    */   
/*    */   void onActivityStart()
/*    */   {
/* 27 */     this.lock.lock();
/*    */     try
/*    */     {
/* 30 */       this.fightids.clear();
/*    */     }
/*    */     finally
/*    */     {
/* 34 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   void onActivityEnd()
/*    */   {
/* 40 */     this.lock.lock();
/*    */     try
/*    */     {
/* 43 */       for (i$ = this.fightids.iterator(); i$.hasNext();) { long fightid = ((Long)i$.next()).longValue();
/*    */         
/* 45 */         FightInterface.endFightNonRealTime(fightid);
/*    */       }
/*    */     }
/*    */     finally {
/*    */       Iterator i$;
/* 50 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   void onFightStart(long fightid)
/*    */   {
/* 56 */     this.lock.lock();
/*    */     try
/*    */     {
/* 59 */       this.fightids.add(Long.valueOf(fightid));
/*    */     }
/*    */     finally
/*    */     {
/* 63 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   void onFightEnd(long fightid)
/*    */   {
/* 69 */     this.lock.lock();
/*    */     try
/*    */     {
/* 72 */       this.fightids.remove(Long.valueOf(fightid));
/*    */     }
/*    */     finally
/*    */     {
/* 76 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\BigBossFightManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */