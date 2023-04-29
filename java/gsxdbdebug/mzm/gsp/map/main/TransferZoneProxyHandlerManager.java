/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ 
/*    */ class TransferZoneProxyHandlerManager
/*    */ {
/* 10 */   private static final TransferZoneProxyHandlerManager instance = new TransferZoneProxyHandlerManager();
/*    */   
/*    */   public static final TransferZoneProxyHandlerManager getInstance()
/*    */   {
/* 14 */     return instance;
/*    */   }
/*    */   
/* 17 */   private final Map<Integer, TransferZoneProxyHandler> handlers = new java.util.HashMap();
/* 18 */   private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
/*    */   
/*    */   public final boolean regisHandler(int handlerType, TransferZoneProxyHandler handler)
/*    */   {
/* 22 */     this.rwLock.writeLock().lock();
/*    */     try {
/*    */       boolean bool;
/* 25 */       if (this.handlers.containsKey(Integer.valueOf(handlerType)))
/*    */       {
/* 27 */         return false;
/*    */       }
/*    */       
/* 30 */       this.handlers.put(Integer.valueOf(handlerType), handler);
/*    */       
/* 32 */       return true;
/*    */     }
/*    */     finally
/*    */     {
/* 36 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public final boolean unregisHandler(int handlerType)
/*    */   {
/* 42 */     this.rwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 45 */       return this.handlers.remove(Integer.valueOf(handlerType)) != null;
/*    */     }
/*    */     finally
/*    */     {
/* 49 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public final TransferZoneProxyHandler getHandler(int handlerType)
/*    */   {
/* 55 */     this.rwLock.readLock().lock();
/*    */     try
/*    */     {
/* 58 */       return (TransferZoneProxyHandler)this.handlers.get(Integer.valueOf(handlerType));
/*    */     }
/*    */     finally
/*    */     {
/* 62 */       this.rwLock.readLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\TransferZoneProxyHandlerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */