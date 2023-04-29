/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.atomic.AtomicLong;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ 
/*    */ public class CrossBattleKnockOutContextManager<Key, Value>
/*    */ {
/* 13 */   private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
/*    */   
/* 15 */   private final AtomicLong atomicLong = new AtomicLong(0L);
/*    */   
/* 17 */   private Map<Key, Long> key2TransKey = new HashMap();
/*    */   
/* 19 */   private Map<Long, Value> transKey2Value = new HashMap();
/*    */   
/*    */   public void putKeys(Collection<Key> keys, Value value)
/*    */   {
/* 23 */     this.readWriteLock.writeLock().lock();
/*    */     try
/*    */     {
/* 26 */       long id = this.atomicLong.addAndGet(1L);
/* 27 */       for (Key key : keys)
/*    */       {
/* 29 */         this.key2TransKey.put(key, Long.valueOf(id));
/*    */       }
/* 31 */       this.transKey2Value.put(Long.valueOf(id), value);
/*    */     }
/*    */     finally
/*    */     {
/* 35 */       this.readWriteLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public Value removeKeys(Collection<Key> keys)
/*    */   {
/* 41 */     this.readWriteLock.writeLock().lock();
/*    */     try
/*    */     {
/* 44 */       Value value = null;
/* 45 */       for (Key key : keys)
/*    */       {
/* 47 */         Long transKey = (Long)this.key2TransKey.remove(key);
/* 48 */         if (transKey != null)
/*    */         {
/* 50 */           Value tempValue = this.transKey2Value.remove(transKey);
/* 51 */           if (tempValue != null)
/*    */           {
/* 53 */             value = tempValue;
/*    */           }
/*    */         }
/*    */       }
/* 57 */       return value;
/*    */     }
/*    */     finally
/*    */     {
/* 61 */       this.readWriteLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public Value getValue(Key key)
/*    */   {
/* 67 */     this.readWriteLock.readLock().lock();
/*    */     try
/*    */     {
/* 70 */       Long transKey = (Long)this.key2TransKey.get(key);
/* 71 */       Object localObject1; if (transKey == null)
/*    */       {
/* 73 */         return null;
/*    */       }
/* 75 */       return (Value)this.transKey2Value.get(transKey);
/*    */     }
/*    */     finally
/*    */     {
/* 79 */       this.readWriteLock.readLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\CrossBattleKnockOutContextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */