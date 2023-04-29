/*    */ package mzm.gsp.menpaipvp.main;
/*    */ 
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.MenpaiPVP;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ class MatchObserver
/*    */   extends Observer
/*    */ {
/* 15 */   private static volatile MatchObserver instance = null;
/* 16 */   private static ReentrantReadWriteLock observerLock = new ReentrantReadWriteLock();
/*    */   
/*    */   public MatchObserver()
/*    */   {
/* 20 */     super(MenpaiPVPConfigManager.getInstance().getMatchInterval());
/* 21 */     setInstance(this);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 27 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 31 */         if (!MenpaiPVPManager.isMatchStage()) {
/* 32 */           MatchObserver.clearInstance();
/* 33 */           return false;
/*    */         }
/*    */         
/* 36 */         MenpaiPVP xMenpaiPVP = MenpaiPVPManager.getXMenpaiPVP(false);
/* 37 */         MenpaiPVPManager.matchFight(xMenpaiPVP);
/* 38 */         return true;
/*    */       }
/*    */       
/* 41 */     });
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   private static void setInstance(MatchObserver observer)
/*    */   {
/* 47 */     observerLock.writeLock().lock();
/*    */     try {
/* 49 */       if (instance != null) {
/* 50 */         instance.stopTimer();
/*    */       }
/* 52 */       instance = observer;
/*    */     }
/*    */     finally {
/* 55 */       observerLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   static void clearInstance() {
/* 60 */     observerLock.writeLock().lock();
/*    */     try {
/* 62 */       if (instance != null) {
/* 63 */         instance.stopTimer();
/*    */       }
/* 65 */       instance = null;
/*    */     }
/*    */     finally {
/* 68 */       observerLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   static int getLeftSeconds() {
/* 73 */     int left = -1;
/* 74 */     observerLock.readLock().lock();
/*    */     try {
/* 76 */       if (instance != null) {
/* 77 */         left = instance.getLeftMillis() / 1000;
/*    */       }
/*    */     }
/*    */     finally {
/* 81 */       observerLock.readLock().unlock();
/*    */     }
/* 83 */     return left;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\MatchObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */