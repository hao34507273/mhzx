/*   */ package mzm.gsp.grc.main;
/*   */ 
/*   */ import mzm.gsp.grc.event.GetRecallRebateInfoDoneArg;
/*   */ 
/*   */ public class POnGetRecallRebateInfoDone extends mzm.gsp.grc.event.GetRecallRebateInfoDoneProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     return RecallFriendManager.onGetRecallRebateInfoResponse(((GetRecallRebateInfoDoneArg)this.arg).retcode, ((GetRecallRebateInfoDoneArg)this.arg).openid, ((GetRecallRebateInfoDoneArg)this.arg).context, ((GetRecallRebateInfoDoneArg)this.arg).response);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnGetRecallRebateInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */