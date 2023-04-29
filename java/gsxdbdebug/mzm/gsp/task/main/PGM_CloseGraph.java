/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PGM_CloseGraph extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int graphId;
/*    */   
/*    */   public PGM_CloseGraph(long roleId, int graphId)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.graphId = graphId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     String userId = RoleInterface.getUserId(this.roleId);
/* 24 */     lock(Lockeys.get(User.getTable(), userId));
/* 25 */     return RoleTaskManager.closeGraphWithoutEvent(this.graphId, this.roleId, true);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\PGM_CloseGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */