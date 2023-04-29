/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.online.event.PlayerRealDelete;
/*    */ import mzm.gsp.online.main.RoleDeleteLogManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.DeleteState;
/*    */ import xtable.Role2delete;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PSetRoleRealDel
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PSetRoleRealDel(long roleId)
/*    */   {
/* 21 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     DeleteState xDeleteState = Role2delete.get(Long.valueOf(this.roleId));
/* 29 */     if (xDeleteState == null)
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     if (xDeleteState.getDeletestate() != 0)
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     long interval = xDeleteState.getDeleteendtime() - DateTimeUtils.getCurrTimeInMillis();
/* 38 */     if (interval > 0L)
/*    */     {
/* 40 */       return false;
/*    */     }
/* 42 */     xDeleteState.setDeletestate(2);
/*    */     
/* 44 */     TriggerEventsManger.getInstance().triggerEvent(new PlayerRealDelete(), Long.valueOf(this.roleId), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*    */     
/*    */ 
/* 47 */     RoleDeleteLogManager.tlogRoleDel(this.roleId, 2);
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PSetRoleRealDel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */