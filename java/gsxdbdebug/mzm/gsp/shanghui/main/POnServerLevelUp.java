/*   */ package mzm.gsp.shanghui.main;
/*   */ 
/*   */ import mzm.gsp.server.event.ServerLevelArg;
/*   */ 
/*   */ public class POnServerLevelUp extends mzm.gsp.server.event.ServerLevelUpProcedure {
/*   */   protected boolean processImp() throws Exception {
/* 7 */     ShanghuiManager.onServerLevelUp(((ServerLevelArg)this.arg).currentLevel);
/* 8 */     return true;
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\POnServerLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */