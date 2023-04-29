/*   */ package mzm.gsp.menpaistar.main;
/*   */ 
/*   */ import mzm.gsp.multioccupation.event.ActivateNewOccupArg;
/*   */ 
/*   */ public class POnRoleActivateNewOccup extends mzm.gsp.multioccupation.event.ActivateNewOccupProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     MenPaiStarManager.onRoleSwitchOccup(((ActivateNewOccupArg)this.arg).roleid, ((ActivateNewOccupArg)this.arg).oldOccup, ((ActivateNewOccupArg)this.arg).newOccup);
/* 9 */     return true;
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\POnRoleActivateNewOccup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */