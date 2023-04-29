/*    */ package mzm.gsp.constellation.main;
/*    */ 
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.constellation.confbean.SConstellationConsts;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Constellation;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ class StartCountDownSession
/*    */   extends Session
/*    */ {
/*    */   private static volatile StartCountDownSession instance;
/* 20 */   private static ReadWriteLock lock = new ReentrantReadWriteLock();
/*    */   
/*    */   private StartCountDownSession() {
/* 23 */     super(SConstellationConsts.getInstance().StartCountDown, -1L);
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 28 */     Procedure.execute(new PStart());
/*    */   }
/*    */   
/*    */   static class PStart
/*    */     extends LogicProcedure
/*    */   {
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 36 */       if (!ActivityInterface.isActivityOpen(SConstellationConsts.getInstance().Activityid)) {
/* 37 */         return false;
/*    */       }
/*    */       
/*    */ 
/* 41 */       Constellation xConstellation = ConstellationManager.getXConstellationIfNotExist();
/* 42 */       xConstellation.setIndex(0);
/*    */       
/*    */ 
/* 45 */       if (OpenInterface.getOpenStatus(227))
/*    */       {
/* 47 */         ConstellationManager.broadcastConstellationCards(xConstellation);
/*    */       }
/*    */       
/*    */ 
/* 51 */       StartCountDownSession.clearSession();
/*    */       
/*    */ 
/* 54 */       int seconds = ConstellationConfigManager.getNextConstellationSeconds(xConstellation.getIndex());
/* 55 */       CardSession.newSession(seconds);
/*    */       
/* 57 */       return true;
/*    */     }
/*    */   }
/*    */   
/*    */   static StartCountDownSession newInstance()
/*    */   {
/* 63 */     lock.writeLock().lock();
/*    */     try {
/* 65 */       if (instance != null) {
/* 66 */         instance.stopTimer();
/*    */       }
/* 68 */       instance = new StartCountDownSession();
/*    */     } finally {
/* 70 */       lock.writeLock().unlock();
/*    */     }
/* 72 */     return instance;
/*    */   }
/*    */   
/*    */   static long getEndMillis() {
/* 76 */     lock.readLock().lock();
/*    */     try { long l;
/* 78 */       if (instance == null) {
/* 79 */         return -1L;
/*    */       }
/* 81 */       return instance.getTimeoutTimestamp();
/*    */     } finally {
/* 83 */       lock.readLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   static void clearSession() {
/* 88 */     lock.writeLock().lock();
/*    */     try {
/* 90 */       instance = null;
/*    */     } finally {
/* 92 */       lock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\constellation\main\StartCountDownSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */