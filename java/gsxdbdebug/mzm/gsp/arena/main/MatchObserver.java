/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
/*    */ import mzm.gsp.arena.confbean.SArenaConsts;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ class MatchObserver
/*    */   extends Observer
/*    */ {
/* 16 */   private static MatchObserver instance = null;
/* 17 */   private static ReentrantReadWriteLock observerLock = new ReentrantReadWriteLock();
/*    */   
/* 19 */   private final boolean[] ret = new boolean[1];
/*    */   
/*    */   public MatchObserver() {
/* 22 */     super(SArenaConsts.getInstance().MatchInterval);
/* 23 */     this.ret[0] = true;
/* 24 */     setInstance(this);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 30 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 34 */         if (!ArenaManager.isMatchStage()) {
/* 35 */           MatchObserver.this.ret[0] = 0;
/* 36 */           MatchObserver.clearInstance();
/* 37 */           return false;
/*    */         }
/* 39 */         ArenaManager.matchFight();
/* 40 */         return true;
/*    */       }
/*    */       
/* 43 */     });
/* 44 */     return this.ret[0];
/*    */   }
/*    */   
/*    */   private static void setInstance(MatchObserver observer) {
/* 48 */     observerLock.writeLock().lock();
/*    */     try {
/* 50 */       if (instance != null) {
/* 51 */         instance.stopTimer();
/*    */       }
/* 53 */       instance = observer;
/*    */     }
/*    */     finally {
/* 56 */       observerLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   static void clearInstance() {
/* 61 */     observerLock.writeLock().lock();
/*    */     try {
/* 63 */       instance = null;
/*    */     }
/*    */     finally {
/* 66 */       observerLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   static int getLeftSeconds() {
/* 71 */     int left = -1;
/* 72 */     observerLock.readLock().lock();
/*    */     try {
/* 74 */       if (instance != null) {
/* 75 */         left = instance.getLeftMillis() / 1000;
/*    */       }
/*    */     }
/*    */     finally {
/* 79 */       observerLock.readLock().unlock();
/*    */     }
/* 81 */     return left;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\MatchObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */