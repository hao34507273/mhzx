/*    */ package mzm.gsp.active.main;
/*    */ 
/*    */ import mzm.gsp.instance.event.MultiInstanceProArg;
/*    */ import mzm.gsp.instance.main.InstanceInterface;
/*    */ 
/*    */ public class POnMultiInstanceProEvent extends mzm.gsp.instance.event.MultiInstanceProEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     long roleid = ((MultiInstanceProArg)this.arg).roleid;
/* 11 */     xbean.Active xActive = ActiveManager.checkAndInitActive(roleid, mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/* 12 */     int activityid = InstanceInterface.getMulInstanceActivityid(((MultiInstanceProArg)this.arg).instanceCfgid);
/* 13 */     if (ActiveManager.addActivityCount(roleid, xActive, activityid)) {
/* 14 */       ActiveManager.sendUpdateActiveMsg(roleid, activityid, ActiveManager.getActivityCount(xActive, activityid));
/* 15 */       return true;
/*    */     }
/* 17 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\active\main\POnMultiInstanceProEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */