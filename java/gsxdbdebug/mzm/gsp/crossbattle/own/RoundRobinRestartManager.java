/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.concurrent.locks.ReentrantLock;
/*    */ 
/*    */ public class RoundRobinRestartManager
/*    */ {
/*  8 */   private static RoundRobinRestartManager instance = new RoundRobinRestartManager();
/*    */   
/*    */   static RoundRobinRestartManager getInstance()
/*    */   {
/* 12 */     return instance;
/*    */   }
/*    */   
/* 15 */   private ReentrantLock lock = new ReentrantLock();
/* 16 */   private HashMap<Integer, RoundRobinRestartInfo> restartInfos = new HashMap();
/*    */   
/*    */   boolean addRestartInfo(int activityCfgid, RoundRobinRestartInfo restartInfo)
/*    */   {
/* 20 */     this.lock.lock();
/*    */     try
/*    */     {
/* 23 */       RoundRobinRestartInfo oldRestartInfo = (RoundRobinRestartInfo)this.restartInfos.get(Integer.valueOf(activityCfgid));
/* 24 */       boolean bool; if (oldRestartInfo != null)
/*    */       {
/* 26 */         return false;
/*    */       }
/* 28 */       this.restartInfos.put(Integer.valueOf(activityCfgid), restartInfo);
/* 29 */       return true;
/*    */     }
/*    */     finally
/*    */     {
/* 33 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   RoundRobinRestartInfo getRestartInfo(int activityCfgid)
/*    */   {
/* 39 */     this.lock.lock();
/*    */     try
/*    */     {
/* 42 */       return (RoundRobinRestartInfo)this.restartInfos.get(Integer.valueOf(activityCfgid));
/*    */     }
/*    */     finally
/*    */     {
/* 46 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   void removeRestartInfo(int activityCfgid)
/*    */   {
/* 52 */     this.lock.lock();
/*    */     try
/*    */     {
/* 55 */       this.restartInfos.remove(Integer.valueOf(activityCfgid));
/*    */     }
/*    */     finally
/*    */     {
/* 59 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\RoundRobinRestartManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */