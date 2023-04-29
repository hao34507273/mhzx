/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_FinishTask
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int graphId;
/*    */   private final int taskId;
/*    */   
/*    */   public PGM_FinishTask(long roleId, int graphId, int taskId)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.graphId = graphId;
/* 16 */     this.taskId = taskId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     return new PActiveFinishTask(this.roleId, this.graphId, this.taskId).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\PGM_FinishTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */