/*   */ package mzm.gsp.friend.main;
/*   */ 
/*   */ import mzm.gsp.online.event.PlayerEnterProtectProcedure;
/*   */ 
/*   */ public class POnRoleEnterProtect extends PlayerEnterProtectProcedure {
/*   */   protected boolean processImp() throws Exception {
/* 7 */     RemApplyInfoSession.remApplyInfoSession(((Long)this.arg).longValue());
/* 8 */     return true;
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\POnRoleEnterProtect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */