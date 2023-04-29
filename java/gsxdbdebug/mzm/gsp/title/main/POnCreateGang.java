/*   */ package mzm.gsp.title.main;
/*   */ 
/*   */ import mzm.gsp.gang.event.GangArg;
/*   */ 
/*   */ public class POnCreateGang extends mzm.gsp.gang.event.CreateGangProcedure {
/*   */   protected boolean processImp() throws Exception {
/* 7 */     return new PGangMemberAppellationChange(((GangArg)this.arg).roleId, ((GangArg)this.arg).gangId, TitleManager.getGangAppId()).call();
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\POnCreateGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */