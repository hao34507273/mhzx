/*   */ package mzm.gsp.xiulian.main;
/*   */ 
/*   */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*   */ 
/*   */ public class POnRoleLogin extends PlayerLoginProcedure {
/*   */   protected boolean processImp() throws Exception {
/* 7 */     XiuLianSkillManager.tryOpenFunction(((Long)this.arg).longValue());
/* 8 */     XiuLianSkillManager.syncXiuLianInfo(((Long)this.arg).longValue());
/* 9 */     return true;
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiulian\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */