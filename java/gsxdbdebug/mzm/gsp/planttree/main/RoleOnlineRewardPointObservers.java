/*    */ package mzm.gsp.planttree.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.locks.ReentrantLock;
/*    */ import mzm.gsp.planttree.confbean.SPlantTreeCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleOnlineRewardPointObservers
/*    */ {
/*    */   private final long roleid;
/* 18 */   private final ReentrantLock lock = new ReentrantLock();
/* 19 */   private final Map<Integer, OnlineRewardPointObserver> observers = new HashMap();
/*    */   
/*    */   public RoleOnlineRewardPointObservers(long roleid)
/*    */   {
/* 23 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   void startObserver(int activityCfgid)
/*    */   {
/* 34 */     SPlantTreeCfg cfg = SPlantTreeCfg.get(activityCfgid);
/* 35 */     if ((cfg == null) || (cfg.special_state_refresh_interval <= 0))
/*    */     {
/* 37 */       return;
/*    */     }
/* 39 */     this.lock.lock();
/*    */     try
/*    */     {
/* 42 */       OnlineRewardPointObserver observer = (OnlineRewardPointObserver)this.observers.get(Integer.valueOf(activityCfgid));
/* 43 */       if (observer == null)
/*    */       {
/* 45 */         observer = new OnlineRewardPointObserver(cfg.online_unit_interval, this.roleid, activityCfgid);
/* 46 */         this.observers.put(Integer.valueOf(activityCfgid), observer);
/*    */       }
/*    */     }
/*    */     finally
/*    */     {
/* 51 */       this.lock.unlock();
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
/* 62 */     this.lock.lock();
/*    */     try
/*    */     {
/* 65 */       OnlineRewardPointObserver oldObserver = (OnlineRewardPointObserver)this.observers.remove(Integer.valueOf(activityCfgid));
/* 66 */       if (oldObserver != null)
/*    */       {
/* 68 */         oldObserver.stopTimer();
/*    */       }
/*    */     }
/*    */     finally
/*    */     {
/* 73 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   void stopAllObserver()
/*    */   {
/* 82 */     this.lock.lock();
/*    */     try
/*    */     {
/* 85 */       for (OnlineRewardPointObserver observer : this.observers.values())
/*    */       {
/* 87 */         observer.stopTimer();
/*    */       }
/* 89 */       this.observers.clear();
/*    */     }
/*    */     finally
/*    */     {
/* 93 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\main\RoleOnlineRewardPointObservers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */