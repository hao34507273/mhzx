/*    */ package mzm.gsp.activitycompensate.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.activitycompensate.confbean.SActivityCompensateCfg;
/*    */ import mzm.gsp.online.event.PlayerCreateProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.ActivityCompensate;
/*    */ 
/*    */ public class POnPlayerCreate extends PlayerCreateProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/* 19 */     xbean.ActivityCompensates xCompensates = ActivityCompensateManager.createXActivityCompensatesIfNotExist(roleid);
/*    */     
/* 21 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 22 */     long nowMillis = DateTimeUtils.getCurrTimeInMillis();
/* 23 */     for (Iterator i$ = SActivityCompensateCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityid = ((Integer)i$.next()).intValue();
/* 24 */       if (ActivityCompensateManager.canJoinActivity(roleLevel, activityid)) {
/* 25 */         ActivityCompensate xCompensate = ActivityCompensateManager.createXCompensateIfNotExist(xCompensates, activityid);
/* 26 */         xCompensate.setCan_join_time(nowMillis);
/*    */         
/* 28 */         ActivityCompensateManager.logInfo("POnPlayerCreate.processImp@set can join time|roleid=%d|activityid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityid) });
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitycompensate\main\POnPlayerCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */