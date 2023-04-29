/*   */ package mzm.gsp.superequipment.wushi.main;
/*   */ 
/*   */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*   */ 
/*   */ public class POnRoleLogin extends PlayerLoginProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception
/*   */   {
/* 9 */     return WuShiManager.synWuShiInfo(((Long)this.arg).longValue());
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */