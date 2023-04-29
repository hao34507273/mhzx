/*    */ package mzm.gsp.factiontask.event;
/*    */ 
/*    */ public class TaskArg
/*    */ {
/*    */   private final long roleId;
/*    */   private final int graphId;
/*    */   private final int taskId;
/*    */   
/*    */   public TaskArg(long roleId, int graphId, int taskId)
/*    */   {
/* 11 */     this.roleId = roleId;
/* 12 */     this.graphId = graphId;
/* 13 */     this.taskId = taskId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRoleId()
/*    */   {
/* 22 */     return this.roleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getGraphId()
/*    */   {
/* 31 */     return this.graphId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getTaskId()
/*    */   {
/* 40 */     return this.taskId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factiontask\event\TaskArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */