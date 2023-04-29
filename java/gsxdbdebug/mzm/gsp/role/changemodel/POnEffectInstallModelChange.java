/*   */ package mzm.gsp.role.changemodel;
/*   */ 
/*   */ import mzm.gsp.effect.outfight.event.EffectInstallModelChangeArg;
/*   */ 
/*   */ public class POnEffectInstallModelChange extends mzm.gsp.effect.outfight.event.EffectInstallModelChangeProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception
/*   */   {
/* 9 */     return new PAddNewChangePlan(((EffectInstallModelChangeArg)this.arg).getRoleId(), ((EffectInstallModelChangeArg)this.arg).getBuffModelChangeCfgId()).call();
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\changemodel\POnEffectInstallModelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */