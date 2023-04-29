/*   */ package mzm.gsp.couple.main;
/*   */ 
/*   */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*   */ 
/*   */ public class POnRoleLogoff extends PlayerOfflineProcedure {
/*   */   protected boolean processImp() throws Exception {
/* 7 */     if (xtable.Role2coupleride.select((Long)this.arg) != null)
/* 8 */       return new PCLeaveRideReq(((Long)this.arg).longValue()).call();
/* 9 */     return false;
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\couple\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */