/*   */ package mzm.gsp.buff.main;
/*   */ 
/*   */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*   */ 
/*   */ public class POnRoleLogin extends PlayerLoginProcedure {
/*   */   protected boolean processImp() throws Exception {
/* 7 */     BuffManager.roleLogin(((Long)this.arg).longValue());
/* 8 */     return true;
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */