/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ import mzm.gsp.timer.main.MilliObserver;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ApplyObserver
/*    */   extends MilliObserver
/*    */ {
/* 19 */   private static Map<Long, Map<Long, ApplyObserver>> observerMap = new ConcurrentHashMap();
/*    */   
/*    */   private long gangid;
/*    */   
/*    */   private long roleid;
/*    */   
/*    */   public ApplyObserver(long gangid, long roleid)
/*    */   {
/* 27 */     super(TimeUnit.HOURS.toMillis(SGangConst.getInstance().GANG_APPLY_LIST_PERSIST_TIME_H));
/* 28 */     this.gangid = gangid;
/* 29 */     this.roleid = roleid;
/* 30 */     addObserver(this.gangid, this.roleid, this);
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 35 */     Procedure.execute(new PRemoveJoinApplyRelation(this.gangid, this.roleid));
/*    */     
/* 37 */     removeObserver(this.gangid, this.roleid);
/* 38 */     return false;
/*    */   }
/*    */   
/*    */   private static void addObserver(long gangid, long roleid, ApplyObserver observer)
/*    */   {
/* 43 */     synchronized (observerMap) {
/* 44 */       Map<Long, ApplyObserver> gangObserMap = (Map)observerMap.get(Long.valueOf(gangid));
/* 45 */       if (gangObserMap == null) {
/* 46 */         gangObserMap = new ConcurrentHashMap();
/* 47 */         observerMap.put(Long.valueOf(gangid), gangObserMap);
/*    */       }
/* 49 */       gangObserMap.put(Long.valueOf(roleid), observer);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void removeObserver(long gangId, long roleId)
/*    */   {
/* 55 */     synchronized (observerMap) {
/* 56 */       Map<Long, ApplyObserver> gangObserMap = (Map)observerMap.get(Long.valueOf(gangId));
/* 57 */       if (gangObserMap != null) {
/* 58 */         ApplyObserver observer = (ApplyObserver)gangObserMap.remove(Long.valueOf(roleId));
/* 59 */         if (observer != null)
/* 60 */           observer.stopTimer();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public static void removeObserver(long gangId) {
/* 66 */     synchronized (observerMap) {
/* 67 */       Map<Long, ApplyObserver> gangObserMap = (Map)observerMap.remove(Long.valueOf(gangId));
/* 68 */       if (gangObserMap != null) {
/* 69 */         for (ApplyObserver observer : gangObserMap.values()) {
/* 70 */           observer.stopTimer();
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\ApplyObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */