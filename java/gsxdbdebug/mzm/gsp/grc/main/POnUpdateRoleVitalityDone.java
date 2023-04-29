/*   */ package mzm.gsp.grc.main;
/*   */ 
/*   */ import mzm.gsp.grc.event.UpdateRoleVitalityDoneArg;
/*   */ 
/*   */ public class POnUpdateRoleVitalityDone extends mzm.gsp.grc.event.UpdateRoleVitalityDoneProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     return RecallFriendManager.onUpdateRoleVitalityResponse(((UpdateRoleVitalityDoneArg)this.arg).retcode, ((UpdateRoleVitalityDoneArg)this.arg).openid, ((UpdateRoleVitalityDoneArg)this.arg).vitalityInfo, ((UpdateRoleVitalityDoneArg)this.arg).context);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnUpdateRoleVitalityDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */