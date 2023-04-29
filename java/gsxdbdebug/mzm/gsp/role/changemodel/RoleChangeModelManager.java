/*    */ package mzm.gsp.role.changemodel;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.role.event.RoleExteriorReplace;
/*    */ import mzm.gsp.util.confbean.SRoleChangeOutlookCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleChangeModelManager
/*    */ {
/*    */   static boolean isChangeIdExist(int changeId)
/*    */   {
/* 18 */     return SRoleChangeOutlookCfg.get(changeId) != null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean triggerChangeEvent(long roleId, int oldChangeId, int newChangeId)
/*    */   {
/* 34 */     TriggerEventsManger.getInstance().triggerEvent(new RoleExteriorReplace(), new ExteriorReplaceArg(roleId, oldChangeId, newChangeId));
/*    */     
/* 36 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void notice2OtherAfterChange(long roleId, int oldChangeId, int newChangeId)
/*    */   {
/* 48 */     triggerChangeEvent(roleId, oldChangeId, newChangeId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\changemodel\RoleChangeModelManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */