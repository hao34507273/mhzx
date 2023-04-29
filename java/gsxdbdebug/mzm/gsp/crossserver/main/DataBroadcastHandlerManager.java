/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ 
/*    */ class DataBroadcastHandlerManager
/*    */ {
/* 10 */   private static final DataBroadcastHandlerManager instance = new DataBroadcastHandlerManager();
/*    */   
/*    */   public static final DataBroadcastHandlerManager getInstance()
/*    */   {
/* 14 */     return instance;
/*    */   }
/*    */   
/* 17 */   private final Map<Integer, DataBroadcastHandler<?>> handlers = new java.util.HashMap();
/* 18 */   private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
/*    */   
/*    */   public final boolean regisHandler(int handlerType, DataBroadcastHandler<?> handler)
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
/*    */   public final DataBroadcastHandler<?> getHandler(int handlerType)
/*    */   {
/* 55 */     this.rwLock.readLock().lock();
/*    */     try
/*    */     {
/* 58 */       return (DataBroadcastHandler)this.handlers.get(Integer.valueOf(handlerType));
/*    */     }
/*    */     finally
/*    */     {
/* 62 */       this.rwLock.readLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DataBroadcastHandlerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */