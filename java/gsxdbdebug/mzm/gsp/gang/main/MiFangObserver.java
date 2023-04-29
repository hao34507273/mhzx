/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import mzm.gsp.gang.SSyncGangMiFangTimeEnd;
/*    */ import mzm.gsp.gang.confbean.GangMiFangConst;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.timer.main.MilliObserver;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ 
/*    */ public class MiFangObserver
/*    */   extends MilliObserver
/*    */ {
/*    */   private long gangId;
/* 19 */   private static Map<Long, MiFangObserver> observerMap = new ConcurrentHashMap();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public MiFangObserver(long gangId, long intervalMilliSeconds)
/*    */   {
/* 26 */     super(intervalMilliSeconds);
/* 27 */     this.gangId = gangId;
/* 28 */     MiFangObserver observer = (MiFangObserver)observerMap.put(Long.valueOf(gangId), this);
/* 29 */     if (observer != null) {
/* 30 */       observer.stopTimer();
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean update() {
/* 35 */     new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception {
/* 38 */         xbean.Gang xGang = xtable.Gang.get(Long.valueOf(MiFangObserver.this.gangId));
/* 39 */         if (xGang == null) return false;
/* 40 */         for (Iterator i$ = GangManager.getMembers(xGang).iterator(); i$.hasNext();) { final long roleId = ((Long)i$.next()).longValue();
/* 41 */           NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */           {
/*    */             protected boolean processImp() throws Exception
/*    */             {
/* 45 */               TaskInterface.closeActivityGraphWithoutEvent(roleId, GangMiFangConst.getInstance().TASK_GRAPH_ID);
/* 46 */               return true;
/*    */             }
/*    */           });
/*    */         }
/* 50 */         SSyncGangMiFangTimeEnd sSyncGangMiFangTimeEnd = new SSyncGangMiFangTimeEnd();
/* 51 */         GangManager.broadcast(xGang, sSyncGangMiFangTimeEnd);
/* 52 */         return true;
/*    */       }
/* 54 */     }.execute();
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public static void stopObserver(long gangId) {
/* 59 */     MiFangObserver observer = (MiFangObserver)observerMap.get(Long.valueOf(gangId));
/* 60 */     if (observer != null) {
/* 61 */       observer.stopTimer();
/* 62 */       observer.update();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\MiFangObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */