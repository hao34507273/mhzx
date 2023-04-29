/*    */ package mzm.gsp.server.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.tlog.TlogUtil;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ class TlogServerStateObserver extends Observer
/*    */ {
/*    */   TlogServerStateObserver(long intervalSeconds)
/*    */   {
/* 12 */     super(intervalSeconds);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 20 */     Xdb.executor().execute(new LogGameStatePro(null));
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   private static class LogGameStatePro
/*    */     extends mzm.gsp.util.LogicRunnable
/*    */   {
/*    */     public void process()
/*    */       throws Exception
/*    */     {}
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\server\main\TlogServerStateObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */