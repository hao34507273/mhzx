/*    */ package mzm.gsp.task.operation;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.task.confbean.STask;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbsOperation
/*    */ {
/*    */   int operId;
/*    */   int operType;
/*    */   int teamType;
/*    */   private int taskId;
/*    */   
/*    */   public AbsOperation(int operId, int operType, int teamType, int taskId)
/*    */   {
/* 17 */     this.operId = operId;
/* 18 */     this.operType = operType;
/* 19 */     this.teamType = teamType;
/* 20 */     this.taskId = taskId;
/*    */   }
/*    */   
/*    */   public int getOperId()
/*    */   {
/* 25 */     return this.operId;
/*    */   }
/*    */   
/*    */   public int getOperType()
/*    */   {
/* 30 */     return this.operType;
/*    */   }
/*    */   
/*    */   public int getTeamType()
/*    */   {
/* 35 */     return this.teamType;
/*    */   }
/*    */   
/*    */   public STask getsTask()
/*    */   {
/* 40 */     return STask.get(this.taskId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getTaskId()
/*    */   {
/* 50 */     return this.taskId;
/*    */   }
/*    */   
/*    */   public abstract boolean check(long paramLong, Map<Integer, Object> paramMap);
/*    */   
/*    */   public abstract boolean execute(long paramLong, Map<Integer, Object> paramMap, int paramInt);
/*    */   
/*    */   public abstract void checkCfg();
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\operation\AbsOperation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */