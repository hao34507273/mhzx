/*    */ package mzm.gsp.groupshopping.main;
/*    */ 
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReentrantLock;
/*    */ import mzm.gsp.groupshopping.confbean.SGroupShoppingConsts;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.TaskOneByOne;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GroupShoppingTaskManager
/*    */ {
/* 17 */   private static final GroupShoppingTaskManager INSTANCE = new GroupShoppingTaskManager();
/* 18 */   private static final int MAX_QUEUE_SIZE = SGroupShoppingConsts.getInstance().MAX_TASK_QUEUE_SIZE;
/*    */   
/* 20 */   private final TaskOneByOne taskOneByOne = new TaskOneByOne();
/*    */   
/* 22 */   private final Lock queueSizeLock = new ReentrantLock();
/* 23 */   private int queueSize = 0;
/*    */   
/*    */   public static boolean addTask(LogicProcedure procedure)
/*    */   {
/* 27 */     INSTANCE.queueSizeLock.lock();
/*    */     try
/*    */     {
/* 30 */       if (INSTANCE.queueSize < MAX_QUEUE_SIZE)
/*    */       {
/* 32 */         INSTANCE.taskOneByOne.add(procedure);
/* 33 */         INSTANCE.queueSize += 1;
/* 34 */         return true;
/*    */       }
/*    */     }
/*    */     finally
/*    */     {
/* 39 */       INSTANCE.queueSizeLock.unlock();
/*    */     }
/* 41 */     return false;
/*    */   }
/*    */   
/*    */   public static void onTaskFinished()
/*    */   {
/* 46 */     INSTANCE.queueSizeLock.lock();
/*    */     try
/*    */     {
/* 49 */       INSTANCE.queueSize -= 1;
/*    */     }
/*    */     finally
/*    */     {
/* 53 */       INSTANCE.queueSizeLock.unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\main\GroupShoppingTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */