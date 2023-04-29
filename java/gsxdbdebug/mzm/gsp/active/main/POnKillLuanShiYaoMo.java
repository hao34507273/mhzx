/*    */ package mzm.gsp.active.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.visiblemonsterfight.event.KillLuanShiYaoMoArg;
/*    */ 
/*    */ public class POnKillLuanShiYaoMo extends mzm.gsp.visiblemonsterfight.event.KillLuanShiYaoMoProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     int activityid = mzm.gsp.visiblemonsterfight.main.VisibleMonsterFightInterface.getLuanShiYaoMoActivityId();
/* 11 */     lock(xtable.Role2active.getTable(), ((KillLuanShiYaoMoArg)this.arg).roleIds);
/* 12 */     for (Iterator i$ = ((KillLuanShiYaoMoArg)this.arg).roleIds.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 13 */       xbean.Active xActive = ActiveManager.checkAndInitActive(roleid, mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/* 14 */       if (ActiveManager.addActivityCount(roleid, xActive, activityid)) {
/* 15 */         ActiveManager.sendUpdateActiveMsg(roleid, activityid, ActiveManager.getActivityCount(xActive, activityid));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\active\main\POnKillLuanShiYaoMo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */