/*    */ package mzm.gsp.npc.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class RoleFinishDlgProcedure extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int npcId;
/*    */   private int taskId;
/*    */   
/*    */   public RoleFinishDlgProcedure(long roleId, int npcId, int taskId) {
/* 12 */     this.roleId = roleId;
/* 13 */     this.taskId = taskId;
/* 14 */     this.npcId = npcId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     return RoleNpcManager.roleFinishDlg(this.roleId, this.npcId, this.taskId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\main\RoleFinishDlgProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */