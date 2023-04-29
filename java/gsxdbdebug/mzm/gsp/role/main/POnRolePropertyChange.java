/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.role.event.RolePropertyChangeProcedure;
/*    */ 
/*    */ public class POnRolePropertyChange extends RolePropertyChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(((Long)this.arg).longValue());
/* 10 */     role.syncClientRoleProperty();
/* 11 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnRolePropertyChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */