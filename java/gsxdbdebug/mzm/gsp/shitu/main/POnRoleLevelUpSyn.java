/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ 
/*    */ public class POnRoleLevelUpSyn extends mzm.gsp.role.event.RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     ShiTuManager.synShiTuRoleInfoChange(((RoleLevelUpArg)this.arg).roleId);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\POnRoleLevelUpSyn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */