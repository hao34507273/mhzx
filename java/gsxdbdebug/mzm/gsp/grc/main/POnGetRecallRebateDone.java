/*   */ package mzm.gsp.grc.main;
/*   */ 
/*   */ import mzm.gsp.grc.event.GetRecallRebateDoneArg;
/*   */ 
/*   */ public class POnGetRecallRebateDone extends mzm.gsp.grc.event.GetRecallRebateDoneProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     return RecallFriendManager.onGetRecallRebateResponse(((GetRecallRebateDoneArg)this.arg).retcode, ((GetRecallRebateDoneArg)this.arg).openid, ((GetRecallRebateDoneArg)this.arg).num, ((GetRecallRebateDoneArg)this.arg).serialNo, ((GetRecallRebateDoneArg)this.arg).context, ((GetRecallRebateDoneArg)this.arg).response);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnGetRecallRebateDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */