/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import xbean.CombiningGangsKey;
/*    */ 
/*    */ class CombineSessionManager
/*    */ {
/* 10 */   private final Map<CombiningGangsKey, Long> cCombineKey2Sessionid = new java.util.HashMap();
/* 11 */   private final ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*    */   
/* 13 */   private static final CombineSessionManager instance = new CombineSessionManager();
/*    */   
/*    */   static CombineSessionManager getInstance() {
/* 16 */     return instance;
/*    */   }
/*    */   
/*    */   Long put(CombiningGangsKey cCombineKey, long sessionid) {
/* 20 */     Long old = null;
/* 21 */     this.lock.writeLock().lock();
/*    */     try {
/* 23 */       old = (Long)this.cCombineKey2Sessionid.put(cCombineKey, Long.valueOf(sessionid));
/*    */     }
/*    */     finally {
/* 26 */       this.lock.writeLock().unlock();
/*    */     }
/* 28 */     return old;
/*    */   }
/*    */   
/*    */   Long remove(CombiningGangsKey cCombineKey) {
/* 32 */     Long sessionid = null;
/* 33 */     this.lock.writeLock().lock();
/*    */     try {
/* 35 */       sessionid = (Long)this.cCombineKey2Sessionid.remove(cCombineKey);
/*    */     }
/*    */     finally {
/* 38 */       this.lock.writeLock().unlock();
/*    */     }
/* 40 */     return sessionid;
/*    */   }
/*    */   
/*    */   boolean remove(CombiningGangsKey cCombineKey, long sessionid) {
/* 44 */     this.lock.writeLock().lock();
/*    */     try {
/* 46 */       Long s = (Long)this.cCombineKey2Sessionid.get(cCombineKey);
/* 47 */       boolean bool; if ((s != null) && (s.longValue() == sessionid)) {
/* 48 */         this.cCombineKey2Sessionid.remove(cCombineKey);
/* 49 */         return true;
/*    */       }
/* 51 */       return false;
/*    */     }
/*    */     finally {
/* 54 */       this.lock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   Long getSessionid(CombiningGangsKey cCombineKey) {
/* 59 */     this.lock.readLock().lock();
/*    */     try {
/* 61 */       return (Long)this.cCombineKey2Sessionid.get(cCombineKey);
/*    */     }
/*    */     finally {
/* 64 */       this.lock.readLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\CombineSessionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */