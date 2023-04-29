/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ class ChatToSpeakerIntervalChecker
/*    */ {
/* 10 */   private static final ChatToSpeakerIntervalChecker instance = new ChatToSpeakerIntervalChecker();
/*    */   
/*    */   public static final ChatToSpeakerIntervalChecker getInstance()
/*    */   {
/* 14 */     return instance;
/*    */   }
/*    */   
/* 17 */   private volatile long interval = 10000L;
/*    */   
/* 19 */   private final ReadWriteLock locker = new ReentrantReadWriteLock();
/* 20 */   private long lastChatTimestamp = 0L;
/*    */   
/*    */   public final void setInterval(long interval)
/*    */   {
/* 24 */     this.interval = interval;
/*    */   }
/*    */   
/*    */   public final boolean canSend()
/*    */   {
/* 29 */     long intervalTime = this.interval;
/*    */     
/* 31 */     this.locker.readLock().lock();
/*    */     boolean bool;
/*    */     try {
/* 34 */       long currTime = DateTimeUtils.getCurrTimeInMillis();
/* 35 */       if (currTime - this.lastChatTimestamp < intervalTime)
/*    */       {
/* 37 */         return false;
/*    */       }
/*    */     }
/*    */     finally
/*    */     {
/* 42 */       this.locker.readLock().unlock();
/*    */     }
/*    */     
/* 45 */     this.locker.writeLock().lock();
/*    */     try
/*    */     {
/* 48 */       long currTime = DateTimeUtils.getCurrTimeInMillis();
/* 49 */       if (currTime - this.lastChatTimestamp < intervalTime)
/*    */       {
/* 51 */         return false;
/*    */       }
/*    */       
/* 54 */       this.lastChatTimestamp = currTime;
/*    */       
/* 56 */       return true;
/*    */     }
/*    */     finally
/*    */     {
/* 60 */       this.locker.writeLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\ChatToSpeakerIntervalChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */