/*   */ package mzm.gsp.huanhun.main;
/*   */ 
/*   */ import mzm.gsp.gang.event.GangArg;
/*   */ 
/*   */ public class POnJoinGang extends mzm.gsp.gang.event.JoinGangProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     return new PSynGangHelpInfo(((GangArg)this.arg).roleId).call();
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\POnJoinGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */