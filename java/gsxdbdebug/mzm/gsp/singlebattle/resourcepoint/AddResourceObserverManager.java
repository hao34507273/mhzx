/*    */ package mzm.gsp.singlebattle.resourcepoint;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.concurrent.locks.ReentrantLock;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.singlebattle.confbean.SResourcePointCfg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AddResourceObserverManager
/*    */ {
/* 15 */   private static AddResourceObserverManager instance = new AddResourceObserverManager();
/*    */   
/*    */   static AddResourceObserverManager getInstance()
/*    */   {
/* 19 */     return instance;
/*    */   }
/*    */   
/* 22 */   private ReentrantLock lock = new ReentrantLock();
/* 23 */   private HashMap<Long, AddResourceObserver> observers = new HashMap();
/*    */   
/*    */   void startObserver(long battleid, int playCfgid)
/*    */   {
/* 27 */     this.lock.lock();
/*    */     try
/*    */     {
/* 30 */       SResourcePointCfg cfg = SResourcePointCfg.get(playCfgid);
/* 31 */       AddResourceObserver oldObserver = (AddResourceObserver)this.observers.put(Long.valueOf(battleid), new AddResourceObserver(cfg.add_resource_interval_in_second, battleid));
/*    */       
/* 33 */       if (oldObserver != null)
/*    */       {
/* 35 */         oldObserver.stopTimer();
/*    */       }
/* 37 */       GameServer.logger().info(String.format("[resourcepoint]AddResourceObserverManager.startObserver@start observer|battleid=%d|play_cfg_id=%d", new Object[] { Long.valueOf(battleid), Integer.valueOf(playCfgid) }));
/*    */ 
/*    */ 
/*    */     }
/*    */     finally
/*    */     {
/*    */ 
/* 44 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   void stopObserver(long battleid)
/*    */   {
/* 50 */     this.lock.lock();
/*    */     try
/*    */     {
/* 53 */       AddResourceObserver oldObserver = (AddResourceObserver)this.observers.remove(Long.valueOf(battleid));
/* 54 */       if (oldObserver != null)
/*    */       {
/* 56 */         oldObserver.stopTimer();
/* 57 */         GameServer.logger().info(String.format("[resourcepoint]AddResourceObserverManager.stopObserver@stop observer|battleid=%d", new Object[] { Long.valueOf(battleid) }));
/*    */       }
/*    */       
/*    */ 
/*    */     }
/*    */     finally
/*    */     {
/* 64 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\resourcepoint\AddResourceObserverManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */