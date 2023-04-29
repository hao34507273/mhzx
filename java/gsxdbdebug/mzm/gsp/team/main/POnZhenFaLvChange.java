/*   */ package mzm.gsp.team.main;
/*   */ 
/*   */ import mzm.gsp.zhenfa.event.ZhenfaLevelUpArg;
/*   */ 
/*   */ public class POnZhenFaLvChange extends mzm.gsp.zhenfa.event.ZhenfaLevelUpProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     return new PZhenFaLvChange(((ZhenfaLevelUpArg)this.arg).roleId, ((ZhenfaLevelUpArg)this.arg).zhenfaId).call();
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnZhenFaLvChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */