/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.map.main.message.MMH_RoleOnTaskStateChange;
/*    */ import mzm.gsp.task.event.TaskStateChangeProcedure;
/*    */ import mzm.gsp.task.main.TaskEventArg;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.task.main.TaskInterface.TaskState;
/*    */ 
/*    */ public class POnTaskStateChange extends TaskStateChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     long roleid = ((TaskEventArg)this.arg).roleId;
/* 15 */     Map<Integer, TaskInterface.TaskState> taskStatues = TaskInterface.getAllRoleTaskBean(((TaskEventArg)this.arg).roleId, true);
/* 16 */     MMH_RoleOnTaskStateChange handler = new MMH_RoleOnTaskStateChange(roleid, taskStatues);
/* 17 */     handler.execute();
/*    */     
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnTaskStateChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */