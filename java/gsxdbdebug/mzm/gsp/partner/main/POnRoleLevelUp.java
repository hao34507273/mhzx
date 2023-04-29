/*   */ package mzm.gsp.partner.main;
/*   */ 
/*   */ import mzm.gsp.role.event.RoleLevelUpArg;
/*   */ 
/*   */ public class POnRoleLevelUp extends mzm.gsp.role.event.RoleLevelUpProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception
/*   */   {
/* 9 */     return PartnerManager.onRoleLevelUp(((RoleLevelUpArg)this.arg).roleId);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */