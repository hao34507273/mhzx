/*   */ package mzm.gsp.children.main;
/*   */ 
/*   */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*   */ 
/*   */ public class POnRoleOffLine extends PlayerOfflineProcedure {
/*   */   protected boolean processImp() throws Exception {
/* 7 */     xtable.Role2childoutfightbean.remove((Long)this.arg);
/* 8 */     return true;
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\POnRoleOffLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */