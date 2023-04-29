/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ 
/*    */ public class TaskStateInfo
/*    */ {
/*    */   private int graphId;
/*    */   private int taskId;
/*    */   private int taskState;
/*    */   
/*    */   public TaskStateInfo(int graphId, int taskId, int taskState)
/*    */   {
/* 12 */     this.graphId = graphId;
/* 13 */     this.taskId = taskId;
/* 14 */     this.taskState = taskState;
/*    */   }
/*    */   
/*    */   public int getGraphId()
/*    */   {
/* 19 */     return this.graphId;
/*    */   }
/*    */   
/*    */   public void setGraphId(int graphId)
/*    */   {
/* 24 */     this.graphId = graphId;
/*    */   }
/*    */   
/*    */   public int getTaskId()
/*    */   {
/* 29 */     return this.taskId;
/*    */   }
/*    */   
/*    */   public void setTaskId(int taskId)
/*    */   {
/* 34 */     this.taskId = taskId;
/*    */   }
/*    */   
/*    */   public int getTaskState()
/*    */   {
/* 39 */     return this.taskState;
/*    */   }
/*    */   
/*    */   public void setTaskState(int taskState)
/*    */   {
/* 44 */     this.taskState = taskState;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\TaskStateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */