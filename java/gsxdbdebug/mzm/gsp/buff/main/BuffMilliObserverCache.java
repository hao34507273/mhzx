/*    */ package mzm.gsp.buff.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BuffMilliObserverCache
/*    */ {
/* 12 */   private static Map<Long, Map<Integer, BuffMilliObserver>> roleId2buffCfgId2ObserverMap = new HashMap();
/*    */   
/* 14 */   private static BuffMilliObserverCache instance = new BuffMilliObserverCache();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static BuffMilliObserverCache getInstance()
/*    */   {
/* 22 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   void addMillObserver(long roleId, int buffCfgId, BuffMilliObserver observer)
/*    */   {
/* 31 */     synchronized (roleId2buffCfgId2ObserverMap) {
/* 32 */       Map<Integer, BuffMilliObserver> observerMap = (Map)roleId2buffCfgId2ObserverMap.get(Long.valueOf(roleId));
/* 33 */       if (observerMap == null) {
/* 34 */         observerMap = new HashMap();
/* 35 */         roleId2buffCfgId2ObserverMap.put(Long.valueOf(roleId), observerMap);
/*    */       }
/* 37 */       observerMap.put(Integer.valueOf(buffCfgId), observer);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   void stopMillObserver(long roleId, int buffCfgId)
/*    */   {
/* 47 */     synchronized (roleId2buffCfgId2ObserverMap) {
/* 48 */       Map<Integer, BuffMilliObserver> observerMap = (Map)roleId2buffCfgId2ObserverMap.get(Long.valueOf(roleId));
/* 49 */       if (observerMap != null) {
/* 50 */         BuffMilliObserver observer = (BuffMilliObserver)observerMap.remove(Integer.valueOf(buffCfgId));
/* 51 */         if (observer != null) {
/* 52 */           observer.stopTimer();
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\BuffMilliObserverCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */