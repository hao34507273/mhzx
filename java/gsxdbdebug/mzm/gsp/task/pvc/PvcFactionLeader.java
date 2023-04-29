/*    */ package mzm.gsp.task.pvc;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ 
/*    */ 
/*    */ public class PvcFactionLeader
/*    */   extends AbsPvcFight
/*    */ {
/*    */   public PvcFactionLeader(long roleId, int graphId, int taskId, int pvcId, int conId)
/*    */   {
/* 13 */     super(roleId, graphId, taskId, pvcId, conId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   long getMrTargetRoleId()
/*    */   {
/* 20 */     return getOwnFactionLeaderId();
/*    */   }
/*    */   
/*    */ 
/*    */   List<Long> getPassiveRoleIds()
/*    */   {
/* 26 */     List<Long> roleIds = new ArrayList();
/* 27 */     long factionLeader = getOwnFactionLeaderId();
/* 28 */     if (factionLeader > 0L)
/*    */     {
/* 30 */       roleIds.add(Long.valueOf(getOwnFactionLeaderId()));
/*    */     }
/* 32 */     return roleIds;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   long getOwnFactionLeaderId()
/*    */   {
/* 44 */     return GangInterface.getBangZhuId(getRoleId());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\pvc\PvcFactionLeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */