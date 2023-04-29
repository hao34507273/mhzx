/*    */ package mzm.gsp.seasontask.event;
/*    */ 
/*    */ public class FinishOneTaskArg
/*    */ {
/*    */   private final long roleId;
/*    */   private final int graphId;
/*    */   private final int taskId;
/*    */   private final int count;
/*    */   
/*    */   public FinishOneTaskArg(long roleId, int graphId, int taskId, int count)
/*    */   {
/* 12 */     this.roleId = roleId;
/* 13 */     this.graphId = graphId;
/* 14 */     this.taskId = taskId;
/* 15 */     this.count = count;
/*    */   }
/*    */   
/*    */   public long getRoleId()
/*    */   {
/* 20 */     return this.roleId;
/*    */   }
/*    */   
/*    */   public int getGraphId()
/*    */   {
/* 25 */     return this.graphId;
/*    */   }
/*    */   
/*    */   public int getTaskId()
/*    */   {
/* 30 */     return this.taskId;
/*    */   }
/*    */   
/*    */   public int getCount()
/*    */   {
/* 35 */     return this.count;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\seasontask\event\FinishOneTaskArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */