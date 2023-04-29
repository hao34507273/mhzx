/*    */ package mzm.gsp.task.pvc;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PvcRoleLevelChart
/*    */   extends AbsPvcChart
/*    */ {
/*    */   public PvcRoleLevelChart(long roleId, int graphId, int taskId, int pvcId, int conId)
/*    */   {
/* 16 */     super(roleId, graphId, taskId, pvcId, conId);
/*    */   }
/*    */   
/*    */ 
/*    */   long ranRoleFromChart()
/*    */   {
/* 22 */     return RoleInterface.ranRoleFromLevelRankList();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\pvc\PvcRoleLevelChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */