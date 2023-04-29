/*    */ package mzm.gsp.worldgoal.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.concurrent.locks.ReentrantLock;
/*    */ import mzm.gsp.worldgoal.confbean.SWorldGoalCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGoalObserverManager
/*    */ {
/* 16 */   private static WorldGoalObserverManager instance = new WorldGoalObserverManager();
/*    */   
/*    */   static WorldGoalObserverManager getInstance()
/*    */   {
/* 20 */     return instance;
/*    */   }
/*    */   
/* 23 */   private ReentrantLock lock = new ReentrantLock();
/* 24 */   private HashMap<Integer, RefreshItemObserver> refreshItemObservers = new HashMap();
/* 25 */   private HashMap<Integer, RefreshMonsterObserver> refreshMonsterObservers = new HashMap();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   void startObserver(long worldid, int activityCfgid)
/*    */   {
/* 34 */     this.lock.lock();
/*    */     try
/*    */     {
/* 37 */       SWorldGoalCfg cfg = SWorldGoalCfg.get(activityCfgid);
/* 38 */       if (cfg.item_controller_id > 0)
/*    */       {
/* 40 */         RefreshItemObserver refreshItemObserver = (RefreshItemObserver)this.refreshItemObservers.put(Integer.valueOf(activityCfgid), new RefreshItemObserver(worldid, activityCfgid));
/*    */         
/* 42 */         if (refreshItemObserver != null)
/*    */         {
/* 44 */           refreshItemObserver.stopTimer();
/*    */         }
/*    */       }
/* 47 */       if (cfg.monster_controller_id > 0)
/*    */       {
/* 49 */         RefreshMonsterObserver refreshMonsterObserver = (RefreshMonsterObserver)this.refreshMonsterObservers.put(Integer.valueOf(activityCfgid), new RefreshMonsterObserver(worldid, activityCfgid));
/*    */         
/* 51 */         if (refreshMonsterObserver != null)
/*    */         {
/* 53 */           refreshMonsterObserver.stopTimer();
/*    */         }
/*    */       }
/*    */     }
/*    */     finally
/*    */     {
/* 59 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   void stopObserver(int activityCfgid)
/*    */   {
/* 70 */     this.lock.lock();
/*    */     try
/*    */     {
/* 73 */       RefreshItemObserver refreshItemObserver = (RefreshItemObserver)this.refreshItemObservers.remove(Integer.valueOf(activityCfgid));
/* 74 */       if (refreshItemObserver != null)
/*    */       {
/* 76 */         refreshItemObserver.stopTimer();
/*    */       }
/* 78 */       RefreshMonsterObserver refreshMonsterObserver = (RefreshMonsterObserver)this.refreshMonsterObservers.remove(Integer.valueOf(activityCfgid));
/* 79 */       if (refreshMonsterObserver != null)
/*    */       {
/* 81 */         refreshMonsterObserver.stopTimer();
/*    */       }
/*    */     }
/*    */     finally
/*    */     {
/* 86 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\WorldGoalObserverManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */