/*   */ package mzm.gsp.addiction.main;
/*   */ 
/*   */ import mzm.gsp.fight.event.PVCFightEndArg;
/*   */ 
/*   */ public class POnPVCFightEnd extends mzm.gsp.fight.event.PVCFightEndProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     return AddictionManager.onFightEnd(((PVCFightEndArg)this.arg).activeRoleList);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\main\POnPVCFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */