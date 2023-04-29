/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import java.util.concurrent.locks.ReentrantLock;
/*    */ import mzm.gsp.role.main.RoleOneByOneManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleSingleCrossFieldContextManager
/*    */ {
/* 14 */   private static RoleSingleCrossFieldContextManager instance = new RoleSingleCrossFieldContextManager();
/*    */   
/*    */   static RoleSingleCrossFieldContextManager getInstance()
/*    */   {
/* 18 */     return instance;
/*    */   }
/*    */   
/* 21 */   private ReentrantLock lock = new ReentrantLock();
/* 22 */   private HashMap<Long, Long> contextids = new HashMap();
/*    */   
/*    */   void addContextid(long roleid, long contextid)
/*    */   {
/* 26 */     this.lock.lock();
/*    */     try
/*    */     {
/* 29 */       this.contextids.put(Long.valueOf(roleid), Long.valueOf(contextid));
/*    */     }
/*    */     finally
/*    */     {
/* 33 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   void removeContextid(long roleid)
/*    */   {
/* 39 */     this.lock.lock();
/*    */     try
/*    */     {
/* 42 */       this.contextids.remove(Long.valueOf(roleid));
/*    */     }
/*    */     finally
/*    */     {
/* 46 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   long getContextid(long roleid)
/*    */   {
/* 52 */     this.lock.lock();
/*    */     try {
/*    */       long l;
/* 55 */       if (!this.contextids.containsKey(Long.valueOf(roleid)))
/*    */       {
/* 57 */         return -1L;
/*    */       }
/* 59 */       return ((Long)this.contextids.get(Long.valueOf(roleid))).longValue();
/*    */     }
/*    */     finally
/*    */     {
/* 63 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   void cancelAllMatch()
/*    */   {
/* 69 */     this.lock.lock();
/*    */     try
/*    */     {
/* 72 */       for (i$ = this.contextids.keySet().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */         
/* 74 */         RoleOneByOneManager.getInstance().addLogicProcedure(Long.valueOf(roleid), new PCancelCrossFieldMatch(roleid));
/*    */       }
/*    */     }
/*    */     finally {
/*    */       Iterator i$;
/* 79 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\RoleSingleCrossFieldContextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */