/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCAcceptTaskReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int graphId;
/*    */   private final int taskId;
/*    */   
/*    */   public PCAcceptTaskReq(long roleId, int graphId, int taskId)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.graphId = graphId;
/* 22 */     this.taskId = taskId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     new RCAcceptTaskReq().execute();
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   class RCAcceptTaskReq extends LogicRunnable
/*    */   {
/*    */     RCAcceptTaskReq() {}
/*    */     
/*    */     public void process() throws Exception
/*    */     {
/* 39 */       if (!PCAcceptTaskReq.this.isPermit())
/*    */       {
/* 41 */         return;
/*    */       }
/*    */       
/* 44 */       new AccpetTaskProcedure(PCAcceptTaskReq.this.roleId, PCAcceptTaskReq.this.graphId, PCAcceptTaskReq.this.taskId).call();
/*    */     }
/*    */   }
/*    */   
/*    */   private boolean isPermit()
/*    */   {
/* 50 */     ActiveAcceptCheck checkPro = new ActiveAcceptCheck();
/* 51 */     checkPro.call();
/* 52 */     return checkPro.isPermit;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   class ActiveAcceptCheck
/*    */     extends LogicProcedure
/*    */   {
/* 63 */     boolean isPermit = true;
/*    */     
/*    */     ActiveAcceptCheck() {}
/*    */     
/*    */     protected boolean processImp() throws Exception {
/* 68 */       ActiveAcceptTaskHandler handler = ActiveAcceptTaskManager.getInstance().getHandler(PCAcceptTaskReq.this.graphId);
/* 69 */       if (handler != null)
/*    */       {
/* 71 */         this.isPermit = handler.canAcceptTask(PCAcceptTaskReq.this.roleId, PCAcceptTaskReq.this.graphId, PCAcceptTaskReq.this.taskId);
/*    */       }
/* 73 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\PCAcceptTaskReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */