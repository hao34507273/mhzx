/*   */ package mzm.gsp.magicmark.main;
/*   */ 
/*   */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*   */ 
/*   */ public class POnRoleLogoff extends PlayerOfflineProcedure {
/*   */   protected boolean processImp() throws Exception {
/* 7 */     MagicMarkSessionManager.clearRoleSession(((Long)this.arg).longValue());
/* 8 */     return true;
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */