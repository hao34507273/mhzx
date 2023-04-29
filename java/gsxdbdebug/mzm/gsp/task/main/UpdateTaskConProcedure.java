/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UpdateTaskConProcedure
/*    */   extends LogicProcedure
/*    */ {
/*    */   private int type;
/*    */   private long roleId;
/*    */   private int taskId;
/*    */   private Object param;
/*    */   
/*    */   public UpdateTaskConProcedure(long roleId, int taskId, int type, Object param)
/*    */   {
/* 20 */     this.type = type;
/* 21 */     this.roleId = roleId;
/* 22 */     this.taskId = taskId;
/* 23 */     this.param = param;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     String userid = RoleInterface.getUserId(this.roleId);
/* 31 */     Lockeys.lock(Lockeys.get(User.getTable(), userid));
/* 32 */     return RoleTaskManager.updateCondition(this.roleId, this.taskId, this.type, this.param);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\UpdateTaskConProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */