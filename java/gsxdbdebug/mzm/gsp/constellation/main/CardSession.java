/*     */ package mzm.gsp.constellation.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.constellation.confbean.SConstellationConsts;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.Constellation;
/*     */ import xdb.Procedure;
/*     */ 
/*     */ 
/*     */ class CardSession
/*     */   extends Session
/*     */ {
/*     */   private static volatile CardSession instance;
/*  20 */   private static ReadWriteLock lock = new ReentrantReadWriteLock();
/*     */   
/*     */   private CardSession(long seconds) {
/*  23 */     super(seconds, -1L);
/*     */   }
/*     */   
/*     */   protected void onTimeOut()
/*     */   {
/*  28 */     Procedure.execute(new POnCardTurnEnd());
/*     */   }
/*     */   
/*     */   static class POnCardTurnEnd
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  36 */       if (!ActivityInterface.isActivityOpen(SConstellationConsts.getInstance().Activityid)) {
/*  37 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  41 */       Constellation xConstellation = ConstellationManager.getXConstellationIfNotExist();
/*  42 */       int nextIndex = xConstellation.getIndex() + 1;
/*  43 */       xConstellation.setIndex(nextIndex);
/*     */       
/*  45 */       if (nextIndex < xConstellation.getCards().size())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  50 */         if (OpenInterface.getOpenStatus(227))
/*     */         {
/*  52 */           ConstellationManager.broadcastConstellationCards(xConstellation);
/*     */           
/*  54 */           ConstellationManager.logInfo("POnCardTurnEnd.processImp@next card|constellation_index=%d", new Object[] { Integer.valueOf(nextIndex) });
/*     */         }
/*     */         
/*     */ 
/*  58 */         int seconds = ConstellationConfigManager.getNextConstellationSeconds(nextIndex);
/*  59 */         CardSession.newSession(seconds);
/*     */       }
/*     */       
/*  62 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static CardSession newSession(int seconds)
/*     */   {
/*  69 */     lock.writeLock().lock();
/*     */     try {
/*  71 */       if (instance != null) {
/*  72 */         instance.stopTimer();
/*     */       }
/*  74 */       instance = new CardSession(seconds);
/*     */     } finally {
/*  76 */       lock.writeLock().unlock();
/*     */     }
/*  78 */     return instance;
/*     */   }
/*     */   
/*     */   static void clearSession() {
/*  82 */     lock.writeLock().lock();
/*     */     try {
/*  84 */       if (instance != null) {
/*  85 */         instance.stopTimer();
/*  86 */         instance = null;
/*     */       }
/*     */     } finally {
/*  89 */       lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   static long getEndMillis() {
/*  94 */     lock.readLock().lock();
/*     */     try { long l;
/*  96 */       if (instance == null) {
/*  97 */         return -1L;
/*     */       }
/*  99 */       return instance.getTimeoutTimestamp();
/*     */     } finally {
/* 101 */       lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\constellation\main\CardSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */