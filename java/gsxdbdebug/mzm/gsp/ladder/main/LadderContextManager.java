/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.atomic.AtomicLong;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ 
/*    */ public class LadderContextManager<Key, Value>
/*    */ {
/* 12 */   private final ReadWriteLock readWriteLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*    */   
/* 14 */   private final AtomicLong atomicLong = new AtomicLong(0L);
/*    */   
/* 16 */   private Map<Key, Long> key2TransKey = new HashMap();
/*    */   
/* 18 */   private Map<Long, Value> transKey2Value = new HashMap();
/*    */   
/*    */   public void putKeys(Collection<Key> keys, Value value) {
/* 21 */     this.readWriteLock.writeLock().lock();
/*    */     try {
/* 23 */       long id = this.atomicLong.addAndGet(1L);
/* 24 */       for (Key key : keys) {
/* 25 */         this.key2TransKey.put(key, Long.valueOf(id));
/*    */       }
/* 27 */       this.transKey2Value.put(Long.valueOf(id), value);
/*    */     } finally {
/* 29 */       this.readWriteLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public Value removeKeys(Collection<Key> keys) {
/* 34 */     this.readWriteLock.writeLock().lock();
/*    */     try {
/* 36 */       Value value = null;
/* 37 */       for (Key key : keys) {
/* 38 */         Long transKey = (Long)this.key2TransKey.remove(key);
/* 39 */         if (transKey != null) {
/* 40 */           Value tempValue = this.transKey2Value.remove(transKey);
/* 41 */           if (tempValue != null) {
/* 42 */             value = tempValue;
/*    */           }
/*    */         }
/*    */       }
/* 46 */       return value;
/*    */     } finally {
/* 48 */       this.readWriteLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public Value getValue(Key key) {
/* 53 */     this.readWriteLock.readLock().lock();
/*    */     try {
/* 55 */       Long transKey = (Long)this.key2TransKey.get(key);
/* 56 */       Object localObject1; if (transKey == null) {
/* 57 */         return null;
/*    */       }
/* 59 */       return (Value)this.transKey2Value.get(transKey);
/*    */     } finally {
/* 61 */       this.readWriteLock.readLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\LadderContextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */