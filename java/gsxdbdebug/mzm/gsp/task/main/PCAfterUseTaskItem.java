/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.task.conParamObj.UseTaskGoodsObj;
/*    */ import mzm.gsp.task.confbean.SGraph;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.GraphBean;
/*    */ import xbean.TaskBean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCAfterUseTaskItem
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int graphId;
/*    */   private final int taskId;
/*    */   private final int taskItemId;
/*    */   
/*    */   public PCAfterUseTaskItem(long roleId, int graphId, int taskId, int taskItemId)
/*    */   {
/* 26 */     this.roleId = roleId;
/* 27 */     this.graphId = graphId;
/* 28 */     this.taskId = taskId;
/* 29 */     this.taskItemId = taskItemId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 35 */     Graph graph = GraphManager.getGraphById(this.graphId);
/* 36 */     if (graph == null)
/*    */     {
/* 38 */       return false;
/*    */     }
/* 40 */     RoleTask roleTask = RoleTaskManager.getRoleTask(this.roleId, true);
/* 41 */     if (roleTask == null)
/*    */     {
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     GraphBean graphBean = roleTask.getGraphBean(this.graphId);
/* 47 */     if (graphBean == null)
/*    */     {
/* 49 */       return false;
/*    */     }
/* 51 */     Task task = TaskManager.getTaskById(this.taskId);
/* 52 */     if (task == null)
/*    */     {
/* 54 */       return false;
/*    */     }
/* 56 */     TaskBean taskBean = roleTask.getTaskBean(graph.getSgraph().id, this.taskId);
/* 57 */     if (taskBean == null)
/*    */     {
/* 59 */       return false;
/*    */     }
/* 61 */     if (taskBean.getTaskstate() == 2)
/*    */     {
/* 63 */       UseTaskGoodsObj obj = new UseTaskGoodsObj();
/* 64 */       obj.setTaskGoodsId(this.taskItemId);
/* 65 */       TaskInterface.updateTaskCondition(this.roleId, this.taskId, 15, obj);
/*    */     }
/* 67 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\PCAfterUseTaskItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */