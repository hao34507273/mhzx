/*   */ package mzm.gsp.title.main;
/*   */ 
/*   */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*   */ 
/*   */ public class POnRoleLogoff extends PlayerOfflineProcedure {
/*   */   protected boolean processImp() throws Exception {
/* 7 */     return TitleManager.onRoleLogoff(((Long)this.arg).longValue());
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */