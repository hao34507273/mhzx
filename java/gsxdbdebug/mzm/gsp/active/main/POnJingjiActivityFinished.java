/*    */ package mzm.gsp.active.main;
/*    */ 
/*    */ import mzm.gsp.jingji.event.JingjiActivityArg;
/*    */ 
/*    */ public class POnJingjiActivityFinished extends mzm.gsp.jingji.event.JingjiActivityFinishedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     long roleid = ((JingjiActivityArg)this.arg).getRoleid();
/* 10 */     xbean.Active xActive = ActiveManager.checkAndInitActive(roleid, mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/* 11 */     int activityid = ((JingjiActivityArg)this.arg).getActivityId();
/* 12 */     if (ActiveManager.addActivityCount(roleid, xActive, activityid)) {
/* 13 */       ActiveManager.sendUpdateActiveMsg(roleid, activityid, ActiveManager.getActivityCount(xActive, activityid));
/* 14 */       return true;
/*    */     }
/* 16 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\active\main\POnJingjiActivityFinished.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */