/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.task.confbean.STask;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.GraphBean;
/*    */ 
/*    */ public class AccpetTaskProcedure extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int graphId;
/*    */   private int taskId;
/*    */   private final int tryCount;
/*    */   
/*    */   public AccpetTaskProcedure(long roleId, int graphId, int taskId)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.graphId = graphId;
/* 20 */     this.taskId = taskId;
/*    */     
/* 22 */     this.tryCount = 0;
/*    */   }
/*    */   
/*    */   public AccpetTaskProcedure(long roleId, int graphId, int taskId, int tryCount)
/*    */   {
/* 27 */     this.roleId = roleId;
/* 28 */     this.graphId = graphId;
/* 29 */     this.taskId = taskId;
/*    */     
/* 31 */     this.tryCount = tryCount;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 38 */     Graph graph = GraphManager.getGraphById(this.graphId);
/* 39 */     Task task = TaskManager.getTaskById(this.taskId);
/* 40 */     if (task.getStask().id != this.taskId)
/*    */     {
/* 42 */       GameServer.logger().error(String.format("[task]AccpetTaskProcedure.processImp@任务id不匹配！|roleId=%d|graphId=%d|taskId=%d|cfgTaskId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.graphId), Integer.valueOf(this.taskId), Integer.valueOf(task.getStask().id) }));
/*    */       
/*    */ 
/* 45 */       return false;
/*    */     }
/* 47 */     if ((graph == null) || (task == null))
/*    */     {
/* 49 */       return false;
/*    */     }
/* 51 */     RoleTask roleTask = RoleTaskManager.getRoleTask(this.roleId, false);
/* 52 */     if (roleTask == null)
/*    */     {
/* 54 */       return false;
/*    */     }
/* 56 */     GraphBean graphBean = roleTask.getGraphBean(this.graphId);
/* 57 */     if (graphBean == null)
/*    */     {
/* 59 */       return false;
/*    */     }
/* 61 */     if (task.getStask().teamType == 3)
/*    */     {
/* 63 */       return RoleTaskManager.acceptTeamTask(this.roleId, task, graph, this.tryCount);
/*    */     }
/*    */     
/*    */ 
/* 67 */     return RoleTaskManager.acceptTask(this.roleId, task, graph);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\AccpetTaskProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */