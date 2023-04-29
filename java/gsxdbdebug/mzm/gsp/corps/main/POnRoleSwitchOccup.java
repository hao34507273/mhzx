/*   */ package mzm.gsp.corps.main;
/*   */ 
/*   */ import mzm.gsp.multioccupation.event.SwitchOccupArg;
/*   */ 
/*   */ public class POnRoleSwitchOccup extends mzm.gsp.multioccupation.event.SwitchOccupProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     CorpsManager.synCorpsMemberBaseChange(((SwitchOccupArg)this.arg).roleid);
/* 9 */     return true;
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\POnRoleSwitchOccup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */