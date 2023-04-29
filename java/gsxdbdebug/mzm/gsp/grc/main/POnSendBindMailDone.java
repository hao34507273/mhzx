/*   */ package mzm.gsp.grc.main;
/*   */ 
/*   */ import mzm.gsp.grc.event.SendBindMailDoneArg;
/*   */ 
/*   */ public class POnSendBindMailDone extends mzm.gsp.grc.event.SendBindMailDoneProcedure {
/*   */   protected boolean processImp() throws Exception {
/* 7 */     return RecallFriendManager.onSendFriendMailResponse(((SendBindMailDoneArg)this.arg).retcode, ((SendBindMailDoneArg)this.arg).openid, ((SendBindMailDoneArg)this.arg).friendOpenid, ((SendBindMailDoneArg)this.arg).serialNo, ((SendBindMailDoneArg)this.arg).context, ((SendBindMailDoneArg)this.arg).friendName);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnSendBindMailDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */