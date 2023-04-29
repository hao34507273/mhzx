/*    */ package mzm.gsp.active.main;
/*    */ 
/*    */ import mzm.gsp.husong.event.HuSongArg;
/*    */ import mzm.gsp.husong.event.HuSongEventProcedure;
/*    */ 
/*    */ public class POnHuSongEvent extends HuSongEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     if (((HuSongArg)this.arg).success) {
/* 11 */       long roleid = ((HuSongArg)this.arg).roleid;
/* 12 */       xbean.Active xActive = ActiveManager.checkAndInitActive(roleid, mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/* 13 */       int activityid = mzm.gsp.husong.main.HuSongInterface.getHuSongActivityid();
/* 14 */       if (ActiveManager.addActivityCount(roleid, xActive, activityid)) {
/* 15 */         ActiveManager.sendUpdateActiveMsg(roleid, activityid, ActiveManager.getActivityCount(xActive, activityid));
/*    */         
/* 17 */         return true;
/*    */       }
/* 19 */       return false;
/*    */     }
/*    */     
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\active\main\POnHuSongEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */