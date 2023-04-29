/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class TaskInitProcedure extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   public TaskInitProcedure(long roleId) {
/* 10 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     return RoleTaskManager.initRoleTaskData(this.roleId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\TaskInitProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */