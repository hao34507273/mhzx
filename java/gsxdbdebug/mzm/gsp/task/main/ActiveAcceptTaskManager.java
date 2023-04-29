/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ 
/*    */ public class ActiveAcceptTaskManager
/*    */ {
/* 10 */   private final Map<Integer, ActiveAcceptTaskHandler> graph2handler = new java.util.HashMap();
/*    */   
/* 12 */   private final ReadWriteLock lock = new ReentrantReadWriteLock();
/*    */   
/* 14 */   private static volatile ActiveAcceptTaskManager instance = null;
/*    */   
/*    */   public static ActiveAcceptTaskManager getInstance()
/*    */   {
/* 18 */     if (instance == null)
/*    */     {
/* 20 */       synchronized (ActiveAcceptTaskManager.class)
/*    */       {
/*    */ 
/* 23 */         if (instance == null)
/*    */         {
/* 25 */           instance = new ActiveAcceptTaskManager();
/*    */         }
/*    */       }
/*    */     }
/* 29 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public ActiveAcceptTaskHandler getHandler(int graphId)
/*    */   {
/* 41 */     this.lock.readLock().lock();
/*    */     try
/*    */     {
/* 44 */       return (ActiveAcceptTaskHandler)this.graph2handler.get(Integer.valueOf(graphId));
/*    */     }
/*    */     finally
/*    */     {
/* 48 */       this.lock.readLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void regHandler(int graphId, ActiveAcceptTaskHandler handler)
/*    */   {
/* 62 */     this.lock.writeLock().lock();
/*    */     try
/*    */     {
/* 65 */       if (this.graph2handler.containsKey(Integer.valueOf(graphId))) {
/*    */         return;
/*    */       }
/*    */       
/* 69 */       this.graph2handler.put(Integer.valueOf(graphId), handler);
/*    */     }
/*    */     finally
/*    */     {
/* 73 */       this.lock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void unRegHandler(int graphId)
/*    */   {
/* 85 */     this.lock.writeLock().lock();
/*    */     try
/*    */     {
/* 88 */       this.graph2handler.remove(Integer.valueOf(graphId));
/*    */     }
/*    */     finally
/*    */     {
/* 92 */       this.lock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\ActiveAcceptTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */