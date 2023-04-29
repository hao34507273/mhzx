/*    */ package mzm.gsp.shimen.main;
/*    */ 
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class ShimenSwitchClosed
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public ShimenSwitchClosed(long roleId)
/*    */   {
/* 16 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     int roleOcp = RoleInterface.getOccupationId(this.roleId);
/* 24 */     int graphid = ShimenManager.getShimenGraphIdByMenpai(roleOcp);
/* 25 */     if (TaskInterface.isHaveGraphId(this.roleId, graphid))
/*    */     {
/* 27 */       OpenInterface.sendCloseProtocol(this.roleId, 0, null);
/* 28 */       TaskInterface.closeActivityGraphWithoutEvent(this.roleId, graphid);
/*    */     }
/*    */     
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shimen\main\ShimenSwitchClosed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */