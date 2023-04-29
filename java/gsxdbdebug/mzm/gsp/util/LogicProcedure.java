/*    */ package mzm.gsp.util;
/*    */ 
/*    */ import java.util.Stack;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.CfgManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class LogicProcedure
/*    */   extends Procedure
/*    */ {
/* 26 */   private static final ThreadLocal<Integer> localNestCount = new ThreadLocal();
/* 27 */   private static final ThreadLocal<Stack<LogicProcedure>> currentProcedure = new ThreadLocal();
/*    */   
/*    */   public static LogicProcedure getCurrentProcedure()
/*    */   {
/* 31 */     Stack<LogicProcedure> curStack = (Stack)currentProcedure.get();
/* 32 */     if ((curStack == null) || (curStack.empty())) {
/* 33 */       return null;
/*    */     }
/* 35 */     return (LogicProcedure)curStack.peek();
/*    */   }
/*    */   
/*    */   protected final boolean process()
/*    */     throws Exception
/*    */   {
/* 41 */     Integer nestCount = (Integer)localNestCount.get();
/* 42 */     if (nestCount == null)
/* 43 */       nestCount = new Integer(0);
/* 44 */     localNestCount.set(nestCount = Integer.valueOf(nestCount.intValue() + 1));
/*    */     
/* 46 */     Stack<LogicProcedure> procedureStack = (Stack)currentProcedure.get();
/* 47 */     if (procedureStack == null) {
/* 48 */       procedureStack = new Stack();
/* 49 */       currentProcedure.set(procedureStack);
/*    */     }
/* 51 */     procedureStack.push(this);
/*    */     
/* 53 */     boolean ret = false;
/* 54 */     int sendSavePoint = -1;int logSavePoint = -1;int eventSavePoint = -1;int tlogSavePoint = -1;
/*    */     try
/*    */     {
/* 57 */       sendSavePoint = OnlineManager.getInstance().sendBeforeTransaction();
/* 58 */       logSavePoint = LogManager.getInstance().logBeforeTransaction();
/* 59 */       tlogSavePoint = TLogManager.getInstance().logBeforeTransaction();
/* 60 */       eventSavePoint = TriggerEventsManger.getInstance().triggerBeforeTransaction();
/*    */       
/* 62 */       ReentrantReadWriteLock.ReadLock readLock = CfgManager.getInstance().getReadLock();
/* 63 */       readLock.lock();
/*    */       try {
/* 65 */         ret = processImp();
/*    */       }
/*    */       finally {
/* 68 */         readLock.unlock();
/*    */       }
/*    */     } finally {
/* 71 */       localNestCount.set(nestCount = Integer.valueOf(nestCount.intValue() - 1));
/* 72 */       procedureStack.pop();
/*    */       
/*    */       try
/*    */       {
/* 76 */         OnlineManager.getInstance().sendAfterTransaction(ret, sendSavePoint, nestCount.intValue());
/*    */         
/*    */ 
/* 79 */         TriggerEventsManger.getInstance().triggerAfterTransaction(ret, eventSavePoint, nestCount.intValue());
/*    */       }
/*    */       finally {
/* 82 */         LogManager.getInstance().logAfterTransaction(ret, logSavePoint, nestCount.intValue());
/* 83 */         TLogManager.getInstance().logAfterTransaction(ret, tlogSavePoint, nestCount.intValue());
/*    */       }
/*    */     }
/*    */     
/* 87 */     return ret;
/*    */   }
/*    */   
/*    */   protected abstract boolean processImp()
/*    */     throws Exception;
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\LogicProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */