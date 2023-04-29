/*    */ package mzm.gsp.task.pvc;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PvcSelf
/*    */   extends AbsPvcFight
/*    */ {
/*    */   public PvcSelf(long roleId, int graphId, int taskId, int pvcId, int conId)
/*    */   {
/* 16 */     super(roleId, graphId, taskId, pvcId, conId);
/*    */   }
/*    */   
/*    */ 
/*    */   long getMrTargetRoleId()
/*    */   {
/* 22 */     return getRoleId();
/*    */   }
/*    */   
/*    */ 
/*    */   List<Long> getPassiveRoleIds()
/*    */   {
/* 28 */     List<Long> roleIds = new ArrayList();
/* 29 */     roleIds.add(Long.valueOf(getRoleId()));
/* 30 */     return roleIds;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\pvc\PvcSelf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */