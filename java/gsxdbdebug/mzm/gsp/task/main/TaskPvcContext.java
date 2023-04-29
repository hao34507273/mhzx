/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TaskPvcContext
/*    */   implements FightContext
/*    */ {
/*    */   private final int taskId;
/*    */   private final int taskUseId;
/*    */   private final long targetRoleId;
/*    */   
/*    */   public TaskPvcContext(int taskId, int taskUseId, long targetRoleId)
/*    */   {
/* 19 */     this.taskId = taskId;
/* 20 */     this.taskUseId = taskUseId;
/* 21 */     this.targetRoleId = targetRoleId;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isRecordEnable()
/*    */   {
/* 27 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getTaskId()
/*    */   {
/* 37 */     return this.taskId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getTaskUseId()
/*    */   {
/* 47 */     return this.taskUseId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getTargetRoleId()
/*    */   {
/* 57 */     return this.targetRoleId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\TaskPvcContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */