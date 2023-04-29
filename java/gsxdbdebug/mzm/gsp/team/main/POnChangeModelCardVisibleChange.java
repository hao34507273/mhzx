/*   */ package mzm.gsp.team.main;
/*   */ 
/*   */ import mzm.gsp.changemodelcard.event.ChangeModelCardStateArg;
/*   */ 
/*   */ public class POnChangeModelCardVisibleChange extends mzm.gsp.changemodelcard.event.ChangeModelCardVisibleChangeProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     return TeamManager.onTeamMemberModelChange(((ChangeModelCardStateArg)this.arg).roleId);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnChangeModelCardVisibleChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */