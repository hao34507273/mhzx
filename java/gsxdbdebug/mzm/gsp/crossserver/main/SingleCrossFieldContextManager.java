/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SingleCrossFieldContextManager
/*    */ {
/* 16 */   private static final SingleCrossFieldContextManager instance = new SingleCrossFieldContextManager();
/*    */   
/*    */   public static final SingleCrossFieldContextManager getInstance()
/*    */   {
/* 20 */     return instance;
/*    */   }
/*    */   
/* 23 */   private int idGenerator = 0;
/* 24 */   private final Map<Long, SingleCrossFieldContext> contexts = new HashMap();
/* 25 */   private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
/*    */   
/*    */   public SingleCrossFieldContext createContext(SingleCrossFieldRoamRoleInfo roleInfo, int activityCfgid)
/*    */   {
/* 29 */     this.rwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 32 */       int contextid = ++this.idGenerator;
/* 33 */       SingleCrossFieldContext context = new SingleCrossFieldContext(contextid, roleInfo, activityCfgid);
/* 34 */       this.contexts.put(Long.valueOf(context.getContextid()), context);
/* 35 */       GameServer.logger().info(String.format("[crossserver]SingleCrossFieldContextManager.createContext@create context|context_id=%d|role_info=%s|activity_cfg_id=%d", new Object[] { Integer.valueOf(contextid), roleInfo, Integer.valueOf(activityCfgid) }));
/*    */       
/*    */ 
/*    */ 
/* 39 */       return context;
/*    */     }
/*    */     finally
/*    */     {
/* 43 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public SingleCrossFieldContext removeContext(long contextid)
/*    */   {
/* 49 */     this.rwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 52 */       SingleCrossFieldContext context = (SingleCrossFieldContext)this.contexts.remove(Long.valueOf(contextid));
/* 53 */       if (context != null)
/*    */       {
/* 55 */         context.stopWatchDog();
/* 56 */         GameServer.logger().info(String.format("[crossserver]SingleCrossFieldContextManager.removeContext@remove context|context_id=%d|role_info=%s|activity_cfg_id=%d", new Object[] { Long.valueOf(contextid), context.getRoamRoleInfos().get(0), Integer.valueOf(context.getActivityCfgid()) }));
/*    */       }
/*    */       
/*    */ 
/*    */ 
/* 61 */       return context;
/*    */     }
/*    */     finally
/*    */     {
/* 65 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public SingleCrossFieldContext getContext(long contextid)
/*    */   {
/* 71 */     this.rwLock.readLock().lock();
/*    */     try
/*    */     {
/* 74 */       return (SingleCrossFieldContext)this.contexts.get(Long.valueOf(contextid));
/*    */     }
/*    */     finally
/*    */     {
/* 78 */       this.rwLock.readLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\SingleCrossFieldContextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */