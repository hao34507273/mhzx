/*    */ package mzm.gsp.task.pvc;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PvcOwnTeam
/*    */   extends AbsPvcFight
/*    */ {
/*    */   public PvcOwnTeam(long roleId, int graphId, int taskId, int pvcId, int conId)
/*    */   {
/* 18 */     super(roleId, graphId, taskId, pvcId, conId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   long getMrTargetRoleId()
/*    */   {
/* 25 */     return -1L;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   List<Long> getPassiveRoleIds()
/*    */   {
/* 32 */     List<Long> normalRoleIds = TeamInterface.getNormalRoleList(getRoleId());
/* 33 */     if (normalRoleIds.size() == 0)
/*    */     {
/* 35 */       normalRoleIds.add(Long.valueOf(getRoleId()));
/*    */     }
/* 37 */     return normalRoleIds;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\pvc\PvcOwnTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */