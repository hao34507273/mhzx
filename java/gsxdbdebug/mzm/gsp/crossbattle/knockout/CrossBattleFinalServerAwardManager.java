/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ 
/*    */ public class CrossBattleFinalServerAwardManager
/*    */ {
/* 11 */   static ReadWriteLock readWriteLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*    */   
/* 13 */   private static final Map<Integer, Map<Integer, Set<Integer>>> activityId2FinalServerAwardInfo = new HashMap();
/*    */   
/*    */   static void addNewActivityServerAwardInfo(int activityCfgId, Map<Integer, Set<Integer>> rank2validZoneIdSetMap)
/*    */   {
/* 17 */     readWriteLock.writeLock().lock();
/*    */     try
/*    */     {
/* 20 */       activityId2FinalServerAwardInfo.put(Integer.valueOf(activityCfgId), rank2validZoneIdSetMap);
/*    */     }
/*    */     finally
/*    */     {
/* 24 */       readWriteLock.writeLock().unlock();
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
/*    */   static Map<Integer, Set<Integer>> getFinalServerAwardInfo(int activityCfgId)
/*    */   {
/* 37 */     readWriteLock.readLock().lock();
/*    */     try
/*    */     {
/* 40 */       return (Map)activityId2FinalServerAwardInfo.get(Integer.valueOf(activityCfgId));
/*    */     }
/*    */     finally
/*    */     {
/* 44 */       readWriteLock.readLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\CrossBattleFinalServerAwardManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */