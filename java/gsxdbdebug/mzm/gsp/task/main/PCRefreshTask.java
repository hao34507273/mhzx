/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCRefreshTask
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int npcId;
/*    */   
/*    */   public PCRefreshTask(long roleId, int npcId)
/*    */   {
/* 13 */     this.roleId = roleId;
/* 14 */     this.npcId = npcId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     return RoleTaskManager.reqRefreshTaskSet(this.roleId, this.npcId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\PCRefreshTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */