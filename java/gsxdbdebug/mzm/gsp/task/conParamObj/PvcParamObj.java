/*    */ package mzm.gsp.task.conParamObj;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PvcParamObj
/*    */ {
/*    */   private int taskUseId;
/*    */   private List<Long> targetRoleIds;
/*    */   
/*    */   public PvcParamObj()
/*    */   {
/* 20 */     this.targetRoleIds = new ArrayList();
/*    */   }
/*    */   
/*    */   public int getTaskUseId()
/*    */   {
/* 25 */     return this.taskUseId;
/*    */   }
/*    */   
/*    */   public void setTaskUseId(int taskUseId)
/*    */   {
/* 30 */     this.taskUseId = taskUseId;
/*    */   }
/*    */   
/*    */   public List<Long> getTargetRoleIds()
/*    */   {
/* 35 */     return this.targetRoleIds;
/*    */   }
/*    */   
/*    */   public void setTargetRoleIds(List<Long> targetRoleIds)
/*    */   {
/* 40 */     this.targetRoleIds = targetRoleIds;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\conParamObj\PvcParamObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */