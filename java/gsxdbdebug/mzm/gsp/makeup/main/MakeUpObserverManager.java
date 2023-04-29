/*    */ package mzm.gsp.makeup.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ 
/*    */ public class MakeUpObserverManager
/*    */ {
/* 12 */   private Map<Integer, Observer> activity2observer = new HashMap();
/* 13 */   private final ReadWriteLock locker = new ReentrantReadWriteLock();
/*    */   
/* 15 */   private static final MakeUpObserverManager instance = new MakeUpObserverManager();
/*    */   
/*    */   static MakeUpObserverManager getInstance()
/*    */   {
/* 19 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   boolean addObserver(int activityId, Observer ob)
/*    */   {
/* 31 */     this.locker.writeLock().lock();
/*    */     try {
/*    */       boolean bool;
/* 34 */       if (this.activity2observer.containsKey(Integer.valueOf(activityId)))
/*    */       {
/* 36 */         return false;
/*    */       }
/* 38 */       this.activity2observer.put(Integer.valueOf(activityId), ob);
/* 39 */       return true;
/*    */     }
/*    */     finally
/*    */     {
/* 43 */       this.locker.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   void stopObserver(int activityId)
/*    */   {
/* 49 */     this.locker.writeLock().lock();
/*    */     
/*    */     try
/*    */     {
/* 53 */       Observer ob = (Observer)this.activity2observer.remove(Integer.valueOf(activityId));
/* 54 */       if (ob == null) {
/*    */         return;
/*    */       }
/*    */       
/*    */ 
/* 59 */       ob.stopTimer();
/* 60 */       MakeUpManager.loggerInfo("--stop observer!|activityId=%d", new Object[] { Integer.valueOf(activityId) });
/*    */     }
/*    */     finally
/*    */     {
/* 64 */       this.locker.writeLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\makeup\main\MakeUpObserverManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */