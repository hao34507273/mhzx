/*    */ package mzm.gsp.task.operation;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.role.main.Role;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.confbean.STaskOpertakeMoney;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
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
/*    */ public class Oper_TakeMoney
/*    */   extends AbsOperation
/*    */ {
/*    */   public Oper_TakeMoney(int operId, STaskOpertakeMoney takeMoney, int taskId)
/*    */   {
/* 24 */     super(operId, takeMoney.operType, takeMoney.teamType, taskId);
/*    */   }
/*    */   
/*    */   STaskOpertakeMoney getSTaskOpertakeMoney()
/*    */   {
/* 29 */     return STaskOpertakeMoney.get(getOperId());
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean check(long roleId, Map<Integer, Object> operParamsMap)
/*    */   {
/* 35 */     STaskOpertakeMoney takeMoney = getSTaskOpertakeMoney();
/* 36 */     Role role = RoleInterface.getRole(roleId, false);
/* 37 */     return role.getSilver() >= takeMoney.takeMoney;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean execute(long roleId, Map<Integer, Object> operParamsMap, int graphId)
/*    */   {
/* 43 */     STaskOpertakeMoney takeMoney = getSTaskOpertakeMoney();
/* 44 */     return RoleInterface.cutSilver(roleId, takeMoney.takeMoney, new TLogArg(LogReason.TASK_OPER_REM));
/*    */   }
/*    */   
/*    */   public void checkCfg() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\operation\Oper_TakeMoney.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */