/*   */ package mzm.gsp.addiction.main;
/*   */ 
/*   */ import mzm.gsp.fight.event.PVEFightEndArg;
/*   */ 
/*   */ public class POnPVEFightEnd extends mzm.gsp.fight.event.PVEFightEndProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     return AddictionManager.onFightEnd(((PVEFightEndArg)this.arg).roleList);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\main\POnPVEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */