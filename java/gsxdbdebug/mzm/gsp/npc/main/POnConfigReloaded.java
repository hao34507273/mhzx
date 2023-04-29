/*   */ package mzm.gsp.npc.main;
/*   */ 
/*   */ import mzm.gsp.config.event.ConfigReloadedProcedure;
/*   */ 
/*   */ public class POnConfigReloaded extends ConfigReloadedProcedure {
/*   */   protected boolean processImp() throws Exception {
/* 7 */     NpcServiceManager.initCondition();
/* 8 */     return true;
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\main\POnConfigReloaded.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */