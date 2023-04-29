/*   */ package mzm.gsp.team.main;
/*   */ 
/*   */ import mzm.gsp.changemodelcard.event.ChangeModelCardStateArg;
/*   */ 
/*   */ public class POnChangeModelCardStateAdd extends mzm.gsp.changemodelcard.event.ChangeModelCardStateAddProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     return TeamManager.onTeamMemberModelChange(((ChangeModelCardStateArg)this.arg).roleId);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnChangeModelCardStateAdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */