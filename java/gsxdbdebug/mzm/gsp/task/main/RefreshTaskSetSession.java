/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RefreshTaskSetSession
/*    */   extends Session
/*    */ {
/* 19 */   private static Map<Long, Map<Integer, RefreshTaskSetSession>> sessionMap = Collections.synchronizedMap(new HashMap());
/*    */   
/*    */   private int graphId;
/*    */   
/*    */   private long refreshTime;
/*    */   
/*    */   private RefreshTaskSetSession(long interval, long roleId, int graphId, long refreshTime)
/*    */   {
/* 27 */     super(interval, roleId);
/* 28 */     this.graphId = graphId;
/* 29 */     this.refreshTime = refreshTime;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 35 */     final long roleId = getOwerId();
/*    */     
/* 37 */     Xdb.executor().execute(new LogicRunnable()
/*    */     {
/*    */ 
/*    */       public void process()
/*    */         throws Exception
/*    */       {
/* 43 */         new RefreshTaskSetProcedure(roleId, RefreshTaskSetSession.this.graphId, RefreshTaskSetSession.this.refreshTime).call();
/*    */       }
/*    */     });
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
/*    */   static void addRefreshTaskSession(long intervalSec, long roleId, int graphId, long refreshTime)
/*    */   {
/* 58 */     if (sessionMap.containsKey(Long.valueOf(roleId)))
/*    */     {
/* 60 */       Map<Integer, RefreshTaskSetSession> graphIdToSessionMap = (Map)sessionMap.get(Long.valueOf(roleId));
/* 61 */       if (graphIdToSessionMap.containsKey(Integer.valueOf(graphId)))
/*    */       {
/* 63 */         RefreshTaskSetSession session = (RefreshTaskSetSession)graphIdToSessionMap.get(Integer.valueOf(graphId));
/* 64 */         session.stopTimer();
/* 65 */         graphIdToSessionMap.remove(Integer.valueOf(graphId));
/*    */       }
/*    */     }
/*    */     else
/*    */     {
/* 70 */       Map<Integer, RefreshTaskSetSession> graphIdToSessionMap = Collections.synchronizedMap(new HashMap());
/* 71 */       sessionMap.put(Long.valueOf(roleId), graphIdToSessionMap);
/*    */     }
/* 73 */     RefreshTaskSetSession refreshTaskSetSession = new RefreshTaskSetSession(intervalSec, roleId, graphId, refreshTime);
/* 74 */     ((Map)sessionMap.get(Long.valueOf(roleId))).put(Integer.valueOf(graphId), refreshTaskSetSession);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void remRefreshTaskSession(long roleId)
/*    */   {
/* 84 */     if (sessionMap.containsKey(Long.valueOf(roleId)))
/*    */     {
/* 86 */       Map<Integer, RefreshTaskSetSession> graphIdToSessionMap = (Map)sessionMap.remove(Long.valueOf(roleId));
/* 87 */       for (Map.Entry<Integer, RefreshTaskSetSession> entry : graphIdToSessionMap.entrySet())
/*    */       {
/* 89 */         ((RefreshTaskSetSession)entry.getValue()).stopTimer();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\RefreshTaskSetSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */