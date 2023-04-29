/*    */ package mzm.gsp.task.pvc;
/*    */ 
/*    */ 
/*    */ public class FPvcFriend
/*    */   implements IPvcFactory
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   private int graphId;
/*    */   
/*    */   private int taskId;
/*    */   
/*    */   private int pvcId;
/*    */   
/*    */   private int conId;
/*    */   
/*    */   public FPvcFriend(long roleId, int graphId, int taskId, int pvcId, int conId)
/*    */   {
/* 19 */     this.roleId = roleId;
/* 20 */     this.graphId = graphId;
/* 21 */     this.taskId = taskId;
/* 22 */     this.pvcId = pvcId;
/* 23 */     this.conId = conId;
/*    */   }
/*    */   
/*    */ 
/*    */   public AbsPvcFight creatPvcFight()
/*    */   {
/* 29 */     return new PvcFriend(this.roleId, this.graphId, this.taskId, this.pvcId, this.conId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\pvc\FPvcFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */