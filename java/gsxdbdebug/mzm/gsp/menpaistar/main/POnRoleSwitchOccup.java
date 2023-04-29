/*   */ package mzm.gsp.menpaistar.main;
/*   */ 
/*   */ import mzm.gsp.multioccupation.event.SwitchOccupArg;
/*   */ 
/*   */ public class POnRoleSwitchOccup extends mzm.gsp.multioccupation.event.SwitchOccupProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     MenPaiStarManager.onRoleSwitchOccup(((SwitchOccupArg)this.arg).roleid, ((SwitchOccupArg)this.arg).oldOccup, ((SwitchOccupArg)this.arg).newOccup);
/* 9 */     return true;
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\POnRoleSwitchOccup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */