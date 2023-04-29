/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xtable.User;
/*    */ 
/*    */ public class CloseGraphProcedure extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int graphId;
/*    */   
/*    */   public CloseGraphProcedure(long roleId, int graphId)
/*    */   {
/* 13 */     this.roleId = roleId;
/* 14 */     this.graphId = graphId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     String userId = RoleInterface.getUserId(this.roleId);
/* 22 */     lock(xdb.Lockeys.get(User.getTable(), userId));
/* 23 */     return RoleTaskManager.closeGraphWithoutEvent(this.graphId, this.roleId, true);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\CloseGraphProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */