/*    */ package mzm.gsp.util;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ 
/*    */ public class CommonContextManager<CTX>
/*    */ {
/* 10 */   private final Map<Long, CTX> contextes = new java.util.HashMap();
/* 11 */   private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
/*    */   
/* 13 */   private long idgenerator = 0L;
/*    */   
/*    */   public final long addContext(CTX ctx)
/*    */   {
/* 17 */     this.rwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 20 */       long id = ++this.idgenerator;
/* 21 */       this.contextes.put(Long.valueOf(id), ctx);
/* 22 */       return id;
/*    */     }
/*    */     finally
/*    */     {
/* 26 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public final CTX removeContext(long id)
/*    */   {
/* 32 */     this.rwLock.readLock().lock();
/*    */     Object localObject1;
/*    */     try {
/* 35 */       if (!this.contextes.containsKey(Long.valueOf(id)))
/*    */       {
/* 37 */         return null;
/*    */       }
/*    */     }
/*    */     finally
/*    */     {
/* 42 */       this.rwLock.readLock().unlock();
/*    */     }
/*    */     
/* 45 */     this.rwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 48 */       return (CTX)this.contextes.remove(Long.valueOf(id));
/*    */     }
/*    */     finally
/*    */     {
/* 52 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public final CTX getContext(long id)
/*    */   {
/* 58 */     this.rwLock.readLock().lock();
/*    */     try
/*    */     {
/* 61 */       return (CTX)this.contextes.get(Long.valueOf(id));
/*    */     }
/*    */     finally
/*    */     {
/* 65 */       this.rwLock.readLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\CommonContextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */