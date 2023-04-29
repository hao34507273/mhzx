/*    */ package mzm.gsp.shitu.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FinishOneTaskArg
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   private final int graphId;
/*    */   
/*    */   private final int taskId;
/*    */   
/*    */ 
/*    */   public FinishOneTaskArg(long roleId, int graphId, int taskId)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.graphId = graphId;
/* 18 */     this.taskId = taskId;
/*    */   }
/*    */   
/*    */   public long getRoleId() {
/* 22 */     return this.roleId;
/*    */   }
/*    */   
/*    */   public int getGraphId() {
/* 26 */     return this.graphId;
/*    */   }
/*    */   
/*    */   public int getTaskId() {
/* 30 */     return this.taskId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\event\FinishOneTaskArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */