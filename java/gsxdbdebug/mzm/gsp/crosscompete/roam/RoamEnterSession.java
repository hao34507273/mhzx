/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteConfigManager;
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ class RoamEnterSession
/*    */   extends Session
/*    */ {
/*    */   RoamEnterSession(long contextid)
/*    */   {
/* 16 */     super(CrossCompeteConfigManager.getCrossEnterSeconds(), contextid);
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 21 */     Xdb.executor().execute(new RRoamEnterTimeout(getOwerId()));
/*    */   }
/*    */   
/*    */   static class RRoamEnterTimeout extends LogicRunnable
/*    */   {
/*    */     private final long contextid;
/*    */     
/*    */     RRoamEnterTimeout(long contextid)
/*    */     {
/* 30 */       this.contextid = contextid;
/*    */     }
/*    */     
/*    */     public void process() throws Exception
/*    */     {
/* 35 */       RoamEnterContext context = RoamEnterContextManager.getInstance().getContext(this.contextid);
/* 36 */       if (context == null) {
/* 37 */         return;
/*    */       }
/*    */       
/*    */ 
/* 41 */       RoamEnterContextManager.getInstance().removeContext(this.contextid);
/*    */       
/*    */ 
/* 44 */       if (!context.isDataPrepared())
/*    */       {
/* 46 */         context.returnOriginalServer();
/*    */         
/* 48 */         CrossCompeteManager.logError("RRoamEnterTimeout.process@data not prepared, return original server@context=%s", new Object[] { context });
/*    */         
/*    */ 
/*    */ 
/* 52 */         return;
/*    */       }
/*    */       
/* 55 */       context.onAllRoleReady();
/*    */       
/* 57 */       CrossCompeteManager.logError("RRoamEnterTimeout.process@timeout|context=%s", new Object[] { context });
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\RoamEnterSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */