/*    */ package mzm.gsp.util;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ 
/*    */ public class CommonHandlerManager<HANDLERTYPE, HANDLER>
/*    */ {
/* 10 */   private final Map<HANDLERTYPE, HANDLER> handlers = new java.util.HashMap();
/* 11 */   private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
/*    */   
/*    */   public final boolean addHandler(HANDLERTYPE handlerType, HANDLER handler)
/*    */   {
/* 15 */     this.rwLock.readLock().lock();
/*    */     boolean bool;
/*    */     try {
/* 18 */       if (this.handlers.containsKey(handlerType))
/*    */       {
/* 20 */         return false;
/*    */       }
/*    */     }
/*    */     finally
/*    */     {
/* 25 */       this.rwLock.readLock().unlock();
/*    */     }
/*    */     
/* 28 */     this.rwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 31 */       if (this.handlers.containsKey(handlerType))
/*    */       {
/* 33 */         return false;
/*    */       }
/*    */       
/* 36 */       this.handlers.put(handlerType, handler);
/*    */       
/* 38 */       return true;
/*    */     }
/*    */     finally
/*    */     {
/* 42 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public final HANDLER removeHandler(HANDLERTYPE handlerType)
/*    */   {
/* 48 */     this.rwLock.readLock().lock();
/*    */     Object localObject1;
/*    */     try {
/* 51 */       if (!this.handlers.containsKey(handlerType))
/*    */       {
/* 53 */         return null;
/*    */       }
/*    */     }
/*    */     finally
/*    */     {
/* 58 */       this.rwLock.readLock().unlock();
/*    */     }
/*    */     
/* 61 */     this.rwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 64 */       return (HANDLER)this.handlers.remove(handlerType);
/*    */     }
/*    */     finally
/*    */     {
/* 68 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public final HANDLER getHandler(HANDLERTYPE handlerType)
/*    */   {
/* 74 */     this.rwLock.readLock().lock();
/*    */     try
/*    */     {
/* 77 */       return (HANDLER)this.handlers.get(handlerType);
/*    */     }
/*    */     finally
/*    */     {
/* 81 */       this.rwLock.readLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\CommonHandlerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */