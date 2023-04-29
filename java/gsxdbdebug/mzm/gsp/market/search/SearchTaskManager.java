/*    */ package mzm.gsp.market.search;
/*    */ 
/*    */ import java.util.concurrent.locks.ReentrantLock;
/*    */ import mzm.gsp.market.confbean.SMarketConsts;
/*    */ import mzm.gsp.util.TaskOneByOne;
/*    */ 
/*    */ 
/*    */ public class SearchTaskManager
/*    */ {
/* 10 */   private static SearchTaskManager instance = new SearchTaskManager();
/*    */   
/*    */   public static SearchTaskManager getInstance()
/*    */   {
/* 14 */     return instance;
/*    */   }
/*    */   
/* 17 */   private int counter = 0;
/* 18 */   private final ReentrantLock counterLock = new ReentrantLock();
/*    */   
/* 20 */   private final TaskOneByOne oneByOne = new TaskOneByOne(SMarketConsts.getInstance().SEARCH_QUEUE_NUMBER);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int addTask(SearchBaseProcedure p)
/*    */   {
/* 35 */     this.counterLock.lock();
/*    */     try {
/*    */       int i;
/* 38 */       if (this.counter >= SMarketConsts.getInstance().SEARCH_QUEUE_NUMBER)
/*    */       {
/* 40 */         return this.counter;
/*    */       }
/* 42 */       if (!this.oneByOne.add(p))
/*    */       {
/* 44 */         return this.counter;
/*    */       }
/* 46 */       this.counter += 1;
/*    */     }
/*    */     finally
/*    */     {
/* 50 */       this.counterLock.unlock();
/*    */     }
/*    */     
/* 53 */     return 0;
/*    */   }
/*    */   
/*    */   public void onTaskDone()
/*    */   {
/* 58 */     this.counterLock.lock();
/*    */     try
/*    */     {
/* 61 */       this.counter -= 1;
/*    */     }
/*    */     finally
/*    */     {
/* 65 */       this.counterLock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public int taskSize()
/*    */   {
/* 71 */     this.counterLock.lock();
/*    */     try
/*    */     {
/* 74 */       return this.counter;
/*    */     }
/*    */     finally
/*    */     {
/* 78 */       this.counterLock.unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\SearchTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */