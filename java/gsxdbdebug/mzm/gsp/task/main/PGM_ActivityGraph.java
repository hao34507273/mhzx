/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PGM_ActivityGraph extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int graphId;
/*    */   
/*    */   public PGM_ActivityGraph(long roleId, int graphId)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.graphId = graphId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     String userId = RoleInterface.getUserId(this.roleId);
/* 23 */     lock(xdb.Lockeys.get(User.getTable(), userId));
/* 24 */     return RoleTaskManager.activeGraph(this.graphId, this.roleId) != null;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\PGM_ActivityGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */