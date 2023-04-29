/*    */ package mzm.gsp.bounty.event;
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
/*    */   private final int count;
/*    */   
/*    */   public FinishOneTaskArg(long roleId, int graphId, int taskId, int count)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.graphId = graphId;
/* 18 */     this.taskId = taskId;
/* 19 */     this.count = count;
/*    */   }
/*    */   
/*    */   public long getRoleId() {
/* 23 */     return this.roleId;
/*    */   }
/*    */   
/*    */   public int getGraphId() {
/* 27 */     return this.graphId;
/*    */   }
/*    */   
/*    */   public int getTaskId() {
/* 31 */     return this.taskId;
/*    */   }
/*    */   
/*    */   public int getCount() {
/* 35 */     return this.count;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bounty\event\FinishOneTaskArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */