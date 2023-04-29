/*    */ package mzm.gsp.activitycompensate.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ 
/*    */ class GlobalData
/*    */ {
/* 10 */   private final Map<Integer, Long> activity2OpenTime = new java.util.HashMap();
/*    */   
/* 12 */   private final ReadWriteLock lock = new ReentrantReadWriteLock();
/*    */   
/* 14 */   private static GlobalData instance = new GlobalData();
/*    */   
/*    */   static GlobalData getInstance() {
/* 17 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */   long getActivityOpenTime(int activityid)
/*    */   {
/* 23 */     this.lock.readLock().lock();
/*    */     try {
/* 25 */       Long time = (Long)this.activity2OpenTime.get(Integer.valueOf(activityid));
/* 26 */       long l; if (time == null) {
/* 27 */         return -1L;
/*    */       }
/* 29 */       return time.longValue();
/*    */     }
/*    */     finally {
/* 32 */       this.lock.readLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   void setActivityOpenTime(int activityid, long openTime) {
/* 37 */     this.lock.writeLock().lock();
/*    */     try {
/* 39 */       this.activity2OpenTime.put(Integer.valueOf(activityid), Long.valueOf(openTime));
/*    */     }
/*    */     finally {
/* 42 */       this.lock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitycompensate\main\GlobalData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */