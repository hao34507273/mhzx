/*   */ package mzm.gsp.grc.main;
/*   */ 
/*   */ import mzm.gsp.grc.event.GetVitalityRewardDoneArg;
/*   */ 
/*   */ public class POnGetVitalityRewardDone extends mzm.gsp.grc.event.GetVitalityRewardDoneProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     return RecallFriendManager.onGetVitalityRewardResponse(((GetVitalityRewardDoneArg)this.arg).retcode, ((GetVitalityRewardDoneArg)this.arg).openid, ((GetVitalityRewardDoneArg)this.arg).friendOpenid, ((GetVitalityRewardDoneArg)this.arg).bindType, ((GetVitalityRewardDoneArg)this.arg).serialNo, ((GetVitalityRewardDoneArg)this.arg).context, ((GetVitalityRewardDoneArg)this.arg).rsp);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnGetVitalityRewardDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */