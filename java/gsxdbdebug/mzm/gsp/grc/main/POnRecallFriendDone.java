/*   */ package mzm.gsp.grc.main;
/*   */ 
/*   */ import mzm.gsp.grc.event.RecallFriendDoneArg;
/*   */ 
/*   */ public class POnRecallFriendDone extends mzm.gsp.grc.event.RecallFriendDoneProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     return RecallFriendManager.onRecallFriendResponse(((RecallFriendDoneArg)this.arg).retcode, ((RecallFriendDoneArg)this.arg).openid, ((RecallFriendDoneArg)this.arg).friendOpenid, ((RecallFriendDoneArg)this.arg).serialNo, ((RecallFriendDoneArg)this.arg).context, ((RecallFriendDoneArg)this.arg).recallResponse);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnRecallFriendDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */