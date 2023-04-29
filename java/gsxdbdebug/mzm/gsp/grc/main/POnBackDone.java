/*   */ package mzm.gsp.grc.main;
/*   */ 
/*   */ import mzm.gsp.grc.event.BackDoneArg;
/*   */ 
/*   */ public class POnBackDone extends mzm.gsp.grc.event.BackDoneProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     return RecallFriendManager.onBackResponse(((BackDoneArg)this.arg).retcode, ((BackDoneArg)this.arg).openid, ((BackDoneArg)this.arg).activityCfgid, ((BackDoneArg)this.arg).serialNo, ((BackDoneArg)this.arg).context, ((BackDoneArg)this.arg).userBackInfo);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnBackDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */