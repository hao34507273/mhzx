/*   */ package mzm.gsp.award.gift;
/*   */ 
/*   */ import mzm.gsp.config.event.ConfigReloadedProcedure;
/*   */ 
/*   */ public class POnConfigReloaded extends ConfigReloadedProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     new PInitXAwarGiftInfo().execute();
/* 9 */     return true;
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gift\POnConfigReloaded.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */