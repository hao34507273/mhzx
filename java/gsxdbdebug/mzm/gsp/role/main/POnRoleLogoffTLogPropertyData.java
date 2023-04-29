/*   */ package mzm.gsp.role.main;
/*   */ 
/*   */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*   */ 
/*   */ public class POnRoleLogoffTLogPropertyData extends PlayerOfflineProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     RoleTLogManager.tLogRolePropertyData(((Long)this.arg).longValue());
/* 9 */     return true;
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnRoleLogoffTLogPropertyData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */