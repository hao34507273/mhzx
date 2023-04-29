/*   */ package mzm.gsp.grc.main;
/*   */ 
/*   */ import mzm.gsp.grc.event.BindFriendDoneArg;
/*   */ 
/*   */ public class POnBindFriendDone extends mzm.gsp.grc.event.BindFriendDoneProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     return RecallFriendManager.onBindFriendResponse(((BindFriendDoneArg)this.arg).retcode, ((BindFriendDoneArg)this.arg).openid, ((BindFriendDoneArg)this.arg).friendOpenid, ((BindFriendDoneArg)this.arg).serialNo, ((BindFriendDoneArg)this.arg).context, ((BindFriendDoneArg)this.arg).rsp);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnBindFriendDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */