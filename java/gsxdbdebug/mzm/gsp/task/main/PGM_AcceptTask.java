/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.task.confbean.SGraph;
/*    */ import mzm.gsp.task.event.GraphStart;
/*    */ import xbean.GraphBean;
/*    */ import xbean.NodeBean;
/*    */ import xbean.TaskBean;
/*    */ import xbean.TaskDataBean;
/*    */ import xdb.Lockeys;
/*    */ import xdb.Procedure;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PGM_AcceptTask extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int graphId;
/*    */   private final int taskId;
/*    */   
/*    */   public PGM_AcceptTask(long roleId, int graphId, int taskId)
/*    */   {
/* 24 */     this.roleId = roleId;
/* 25 */     this.graphId = graphId;
/* 26 */     this.taskId = taskId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 34 */     lock(Lockeys.get(User.getTable(), userId));
/* 35 */     RoleTask roleTask = RoleTaskManager.getRoleTask(this.roleId, true);
/* 36 */     GraphBean graphBean = roleTask.getGraphBean(this.graphId);
/* 37 */     Graph graph = GraphManager.getGraphById(this.graphId);
/* 38 */     if (graphBean == null)
/*    */     {
/* 40 */       if (graph == null)
/*    */       {
/* 42 */         return false;
/*    */       }
/* 44 */       int rootNodeId = graph.getSgraph().rootNodeId;
/*    */       
/* 46 */       graphBean = xbean.Pod.newGraphBean();
/* 47 */       graphBean.setGraphid(this.graphId);
/* 48 */       graphBean.getNodebean().setNodeid(rootNodeId);
/* 49 */       graphBean.getNodebean().setFinishcount(0);
/* 50 */       roleTask.getTaskDataBean().getGraphbeans().put(Integer.valueOf(graphBean.getGraphid()), graphBean);
/*    */     }
/* 52 */     for (TaskBean taskBean : graphBean.getNodebean().getTaskbeans().values())
/*    */     {
/* 54 */       RoleTaskManager.sendUpdateTaskState(this.roleId, this.graphId, taskBean.getTaskid(), 4);
/*    */     }
/* 56 */     graphBean.getNodebean().getTaskbeans().clear();
/* 57 */     Task task = TaskManager.getTaskById(this.taskId);
/* 58 */     if (task == null)
/*    */     {
/* 60 */       return false;
/*    */     }
/* 62 */     AcceptTaskCheckResult ret = task.iscanTake(this.roleId, new HashMap(), new HashMap(), this.graphId);
/*    */     
/* 64 */     if (ret.isCanTake())
/*    */     {
/*    */ 
/* 67 */       TaskBean taskBean = RoleTaskManager.createTaskBean(this.roleId, graphBean.getGraphid(), this.taskId, 1);
/*    */       
/*    */ 
/* 70 */       RoleTaskManager.sendUpdateTaskState(this.roleId, graphBean.getGraphid(), taskBean.getTaskid(), taskBean.getTaskstate());
/*    */       
/* 72 */       graphBean.getNodebean().getTaskbeans().put(Integer.valueOf(taskBean.getTaskid()), taskBean);
/* 73 */       Procedure.execute(new AccpetTaskProcedure(this.roleId, graphBean.getGraphid(), this.taskId));
/* 74 */       TriggerEventsManger.getInstance().triggerEvent(new GraphStart(), new GraphStartArg(this.roleId, this.graphId));
/* 75 */       return true;
/*    */     }
/*    */     
/* 78 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\PGM_AcceptTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */