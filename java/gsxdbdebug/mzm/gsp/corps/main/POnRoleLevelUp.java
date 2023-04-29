/*   */ package mzm.gsp.corps.main;
/*   */ 
/*   */ import mzm.gsp.role.event.RoleLevelUpArg;
/*   */ 
/*   */ public class POnRoleLevelUp extends mzm.gsp.role.event.RoleLevelUpProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     CorpsManager.synCorpsMemberBaseChange(((RoleLevelUpArg)this.arg).roleId);
/* 9 */     return true;
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */