/*   */ package mzm.gsp.addiction.main;
/*   */ 
/*   */ import mzm.gsp.fight.event.PVIMonsterFightEndArg;
/*   */ 
/*   */ public class POnPVIMonsterFightEnd extends mzm.gsp.fight.event.PVIMonsterFightEndProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     return AddictionManager.onFightEnd(((PVIMonsterFightEndArg)this.arg).roleList);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\main\POnPVIMonsterFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */