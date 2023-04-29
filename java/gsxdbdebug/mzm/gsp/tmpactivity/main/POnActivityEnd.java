/*    */ package mzm.gsp.tmpactivity.main;
/*    */ 
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnActivityEnd
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     ControllerInterface.collectController(TmpActivityManager.getNpcControllerId());
/* 26 */     Xdb.executor().execute(new LogicRunnable()
/*    */     {
/*    */       public void process()
/*    */         throws Exception
/*    */       {
/* 31 */         for (Long roleId : OnlineManager.getInstance().getAllRolesInWorld())
/*    */         {
/* 33 */           NoneRealTimeTaskManager.getInstance().addTask(new POnActivityEnd.PClearTmpActivityData(roleId.longValue()));
/*    */         }
/*    */         
/*    */       }
/* 37 */     });
/* 38 */     return true;
/*    */   }
/*    */   
/*    */   private static class PClearTmpActivityData
/*    */     extends LogicProcedure
/*    */   {
/*    */     private long roleid;
/*    */     
/*    */     PClearTmpActivityData(long roleid)
/*    */     {
/* 48 */       this.roleid = roleid;
/*    */     }
/*    */     
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 55 */       TaskInterface.closeActivityGraphWithoutEvent(this.roleid, TmpActivityManager.getGraphId());
/* 56 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\tmpactivity\main\POnActivityEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */