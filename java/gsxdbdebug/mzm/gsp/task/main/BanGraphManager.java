/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
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
/*    */ public class BanGraphManager
/*    */ {
/* 20 */   private static final Set<Integer> banGraphIds = new HashSet();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 25 */   private static final ReadWriteLock banGraphLock = new ReentrantReadWriteLock();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void regisBanGraph(Set<Integer> graphIds)
/*    */   {
/* 34 */     banGraphLock.writeLock().lock();
/*    */     try
/*    */     {
/* 37 */       banGraphIds.addAll(graphIds);
/*    */     }
/*    */     finally
/*    */     {
/* 41 */       banGraphLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void unRegisBanGraph(Set<Integer> graphIds)
/*    */   {
/* 52 */     banGraphLock.writeLock().lock();
/*    */     try
/*    */     {
/* 55 */       banGraphIds.removeAll(graphIds);
/*    */     }
/*    */     finally
/*    */     {
/* 59 */       banGraphLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isValidate(int graphId)
/*    */   {
/* 71 */     banGraphLock.readLock().lock();
/*    */     try
/*    */     {
/* 74 */       return !banGraphIds.contains(Integer.valueOf(graphId));
/*    */     }
/*    */     finally
/*    */     {
/* 78 */       banGraphLock.readLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\BanGraphManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */