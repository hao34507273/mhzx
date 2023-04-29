/*    */ package mzm.gsp.award.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public class BuffAwardTipRegManager
/*    */ {
/* 20 */   private static final Map<Integer, Integer> buffId2AddType = new HashMap();
/* 21 */   private static final ReadWriteLock buffId2AddTypeRwLock = new ReentrantReadWriteLock();
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
/*    */   static boolean registerBuffAddType(int buffId, int addType)
/*    */   {
/* 34 */     buffId2AddTypeRwLock.writeLock().lock();
/*    */     try {
/*    */       boolean bool;
/* 37 */       if (buffId2AddType.containsKey(Integer.valueOf(buffId)))
/*    */       {
/* 39 */         return false;
/*    */       }
/* 41 */       buffId2AddType.put(Integer.valueOf(buffId), Integer.valueOf(addType));
/* 42 */       return true;
/*    */     }
/*    */     finally
/*    */     {
/* 46 */       buffId2AddTypeRwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void unRegisterBuffAddType(int buffId)
/*    */   {
/* 57 */     buffId2AddTypeRwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 60 */       buffId2AddType.remove(Integer.valueOf(buffId));
/*    */     }
/*    */     finally
/*    */     {
/* 64 */       buffId2AddTypeRwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static int getBuffType(int buffId)
/*    */   {
/* 76 */     buffId2AddTypeRwLock.readLock().lock();
/*    */     try
/*    */     {
/* 79 */       Integer addType = (Integer)buffId2AddType.get(Integer.valueOf(buffId));
/* 80 */       return addType == null ? -1 : addType.intValue();
/*    */     }
/*    */     finally
/*    */     {
/* 84 */       buffId2AddTypeRwLock.readLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\BuffAwardTipRegManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */