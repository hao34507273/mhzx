/*    */ package mzm.gsp.util;
/*    */ 
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
/*    */ import mzm.gsp.CfgManager;
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Executor;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class LogicRunnable
/*    */   implements Runnable
/*    */ {
/*    */   public final void run()
/*    */   {
/* 18 */     ReentrantReadWriteLock.ReadLock readLock = CfgManager.getInstance().getReadLock();
/* 19 */     readLock.lock();
/*    */     try
/*    */     {
/* 22 */       process();
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 26 */       GameServer.logger().error(getClass().getSimpleName() + " Exception.", e);
/*    */     }
/*    */     finally
/*    */     {
/* 30 */       readLock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public abstract void process() throws Exception;
/*    */   
/*    */   public final void execute()
/*    */   {
/* 38 */     Executor.getInstance().execute(this);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\LogicRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */