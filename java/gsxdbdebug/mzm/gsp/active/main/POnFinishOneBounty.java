/*    */ package mzm.gsp.active.main;
/*    */ 
/*    */ import mzm.gsp.bounty.event.FinishOneTaskArg;
/*    */ import mzm.gsp.bounty.event.FinishOneTaskProcedure;
/*    */ 
/*    */ public class POnFinishOneBounty extends FinishOneTaskProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     long roleid = ((FinishOneTaskArg)this.arg).getRoleId();
/* 11 */     xbean.Active xActive = ActiveManager.checkAndInitActive(roleid, mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/* 12 */     int activityid = mzm.gsp.bounty.main.BountyInterface.getBountyActivityId();
/* 13 */     if (ActiveManager.addActivityCount(roleid, xActive, activityid)) {
/* 14 */       ActiveManager.sendUpdateActiveMsg(roleid, activityid, ActiveManager.getActivityCount(xActive, activityid));
/* 15 */       return true;
/*    */     }
/* 17 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\active\main\POnFinishOneBounty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */