/*   */ package mzm.gsp.grc.main;
/*   */ 
/*   */ import mzm.gsp.grc.event.RecallRechargeRebateDoneArg;
/*   */ 
/*   */ public class POnRecallRechargeRebateDone extends mzm.gsp.grc.event.RecallRechargeRebateDoneProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     return RecallFriendManager.onRecallRechargeRebateResponse(((RecallRechargeRebateDoneArg)this.arg).retcode, ((RecallRechargeRebateDoneArg)this.arg).openid, ((RecallRechargeRebateDoneArg)this.arg).rebate, ((RecallRechargeRebateDoneArg)this.arg).serialNo, ((RecallRechargeRebateDoneArg)this.arg).context);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnRecallRechargeRebateDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */