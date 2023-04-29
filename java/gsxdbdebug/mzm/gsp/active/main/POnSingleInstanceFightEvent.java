/*    */ package mzm.gsp.active.main;
/*    */ 
/*    */ import mzm.gsp.instance.event.SingleFightArg;
/*    */ import mzm.gsp.instance.event.SingleInstanceFightEventProcedure;
/*    */ 
/*    */ public class POnSingleInstanceFightEvent extends SingleInstanceFightEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     if (((SingleFightArg)this.arg).win) {
/* 11 */       long roleid = ((SingleFightArg)this.arg).roleid;
/* 12 */       xbean.Active xActive = ActiveManager.checkAndInitActive(roleid, mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/* 13 */       int activityid = mzm.gsp.instance.main.InstanceInterface.getSingleInstanceActivityid();
/* 14 */       if (ActiveManager.addActivityCount(roleid, xActive, activityid)) {
/* 15 */         ActiveManager.sendUpdateActiveMsg(roleid, activityid, ActiveManager.getActivityCount(xActive, activityid));
/*    */         
/* 17 */         return true;
/*    */       }
/* 19 */       return false;
/*    */     }
/*    */     
/* 22 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\active\main\POnSingleInstanceFightEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */