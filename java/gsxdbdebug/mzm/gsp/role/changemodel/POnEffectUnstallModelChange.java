/*   */ package mzm.gsp.role.changemodel;
/*   */ 
/*   */ import mzm.gsp.effect.outfight.event.EffectUnstallModelChangeArg;
/*   */ 
/*   */ public class POnEffectUnstallModelChange extends mzm.gsp.effect.outfight.event.EffectUnstallModelChangeProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception
/*   */   {
/* 9 */     return new PRmChangePlan(((EffectUnstallModelChangeArg)this.arg).getRoleId(), ((EffectUnstallModelChangeArg)this.arg).getBuffModelChangeCfgId()).call();
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\changemodel\POnEffectUnstallModelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */