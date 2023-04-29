/*    */ package mzm.gsp.task.pvc;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public abstract class AbsPvcChart
/*    */   extends AbsPvcFight
/*    */ {
/*    */   public AbsPvcChart(long roleId, int graphId, int taskId, int pvcId, int conId)
/*    */   {
/* 11 */     super(roleId, graphId, taskId, pvcId, conId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   long getMrTargetRoleId()
/*    */   {
/* 18 */     return ranRoleFromChart();
/*    */   }
/*    */   
/*    */ 
/*    */   List<Long> getPassiveRoleIds()
/*    */   {
/* 24 */     List<Long> roleIds = new ArrayList();
/* 25 */     long targetRoleId = ranRoleFromChart();
/* 26 */     if (targetRoleId > 0L)
/*    */     {
/* 28 */       roleIds.add(Long.valueOf(targetRoleId));
/*    */     }
/* 30 */     return roleIds;
/*    */   }
/*    */   
/*    */   abstract long ranRoleFromChart();
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\pvc\AbsPvcChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */