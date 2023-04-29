/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.confbean.SGraph;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class GiveupTaskProcedure extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int graphId;
/*    */   private int taskId;
/*    */   
/*    */   public GiveupTaskProcedure(long roleId, int graphId, int taskId)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.graphId = graphId;
/* 18 */     this.taskId = taskId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     Graph graph = GraphManager.getGraphById(this.graphId);
/* 26 */     Task task = TaskManager.getTaskById(this.taskId);
/* 27 */     if ((graph == null) || (task == null))
/*    */     {
/* 29 */       return true;
/*    */     }
/* 31 */     if (graph.getSgraph().canGiveUpTask)
/*    */     {
/* 33 */       if (task.getStask().teamType == 3)
/*    */       {
/* 35 */         return RoleTaskManager.giveUpTeamTask(this.roleId, task, graph);
/*    */       }
/*    */       
/*    */ 
/*    */ 
/* 40 */       String userId = RoleInterface.getUserId(this.roleId);
/* 41 */       lock(Lockeys.get(User.getTable(), userId));
/* 42 */       return RoleTaskManager.giveUpTask(this.roleId, task, graph);
/*    */     }
/*    */     
/*    */ 
/* 46 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\GiveupTaskProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */