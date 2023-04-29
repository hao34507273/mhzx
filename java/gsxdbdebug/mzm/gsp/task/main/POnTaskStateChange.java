/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.task.conParamObj.ActivityFinishParamObj;
/*    */ import mzm.gsp.task.event.TaskStateChangeProcedure;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnTaskStateChange
/*    */   extends TaskStateChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     checkTaskDel((TaskEventArg)this.arg);
/*    */     
/* 20 */     if (((TaskEventArg)this.arg).taskState != 8)
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     ActivityFinishParamObj obj = new ActivityFinishParamObj();
/* 26 */     obj.setGraphId(((TaskEventArg)this.arg).graphId);
/* 27 */     obj.setFinishCount(1);
/*    */     
/* 29 */     TaskInterface.updateTaskCondition(((TaskEventArg)this.arg).roleId, 17, obj);
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   private final void checkTaskDel(TaskEventArg arg)
/*    */   {
/* 35 */     if (arg.taskState != 4)
/*    */     {
/* 37 */       return;
/*    */     }
/* 39 */     new AfterTaskDel(arg.roleId, arg.graphId, arg.taskId).execute();
/*    */   }
/*    */   
/*    */   private class AfterTaskDel extends LogicProcedure
/*    */   {
/*    */     private final long roleId;
/*    */     private final int graphId;
/*    */     private final int taskId;
/*    */     
/*    */     public AfterTaskDel(long roleId, int graphId, int taskId)
/*    */     {
/* 50 */       this.roleId = roleId;
/* 51 */       this.graphId = graphId;
/* 52 */       this.taskId = taskId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 58 */       Task task = TaskManager.getTaskById(this.taskId);
/* 59 */       if (!task.checkOperation(this.roleId, 5, 3, new HashMap(), true))
/*    */       {
/*    */ 
/* 62 */         GameServer.logger().error(String.format("[task]AfterTaskDel.processImp@ checkOperation err!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.graphId), Integer.valueOf(this.taskId) }));
/*    */         
/*    */ 
/* 65 */         return false;
/*    */       }
/* 67 */       if (!task.excuteOperation(this.roleId, 5, 3, new HashMap(), this.graphId, true))
/*    */       {
/*    */ 
/* 70 */         GameServer.logger().error(String.format("[task]AfterTaskDel.processImp@ excuteOperation err!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.graphId), Integer.valueOf(this.taskId) }));
/*    */         
/*    */ 
/* 73 */         return false;
/*    */       }
/* 75 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\POnTaskStateChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */