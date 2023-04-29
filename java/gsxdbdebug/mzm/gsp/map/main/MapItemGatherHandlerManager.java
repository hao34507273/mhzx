/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ 
/*    */ class MapItemGatherHandlerManager
/*    */ {
/* 10 */   private static final MapItemGatherHandlerManager instance = new MapItemGatherHandlerManager();
/*    */   
/*    */   public static final MapItemGatherHandlerManager getInstance()
/*    */   {
/* 14 */     return instance;
/*    */   }
/*    */   
/* 17 */   private final Map<Integer, MapItemGatherHandler> handlers = new java.util.HashMap();
/* 18 */   private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
/*    */   
/*    */   public final boolean regisHandler(int handlerType, MapItemGatherHandler handler)
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
/*    */   public final MapItemGatherHandler getHandler(int handlerType)
/*    */   {
/* 55 */     this.rwLock.readLock().lock();
/*    */     try
/*    */     {
/* 58 */       return (MapItemGatherHandler)this.handlers.get(Integer.valueOf(handlerType));
/*    */     }
/*    */     finally
/*    */     {
/* 62 */       this.rwLock.readLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\MapItemGatherHandlerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */