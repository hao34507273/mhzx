/*    */ package mzm.gsp.active.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.zhenyao.event.ZhenyaoActivityArg;
/*    */ 
/*    */ public class POnZhenyaoFinished extends mzm.gsp.zhenyao.event.ZhenyaoActivityFinishedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     int activityid = mzm.gsp.zhenyao.main.ZhenyaoInterface.getZhenYaoActivityId();
/* 11 */     lock(xtable.Role2active.getTable(), ((ZhenyaoActivityArg)this.arg).getRoleids());
/* 12 */     for (Iterator i$ = ((ZhenyaoActivityArg)this.arg).getRoleids().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 13 */       xbean.Active xActive = ActiveManager.checkAndInitActive(roleid, mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/* 14 */       if (ActiveManager.addActivityCount(roleid, xActive, activityid)) {
/* 15 */         ActiveManager.sendUpdateActiveMsg(roleid, activityid, ActiveManager.getActivityCount(xActive, activityid));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\active\main\POnZhenyaoFinished.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */