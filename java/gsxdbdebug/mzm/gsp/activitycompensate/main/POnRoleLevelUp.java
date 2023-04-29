/*    */ package mzm.gsp.activitycompensate.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.activitycompensate.confbean.SActivityCompensateCfg;
/*    */ import mzm.gsp.activitycompensate.confbean.SActivityCompensateConsts;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.role.event.RoleLevelUpProcedure;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.ActivityCompensate;
/*    */ import xbean.ActivityCompensates;
/*    */ 
/*    */ public class POnRoleLevelUp
/*    */   extends RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     long roleid = ((RoleLevelUpArg)this.arg).roleId;
/*    */     
/*    */ 
/* 24 */     ActivityCompensates xCompensates = ActivityCompensateManager.createXActivityCompensatesIfNotExist(roleid);
/* 25 */     long nowMillis = DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 27 */     for (Iterator i$ = SActivityCompensateCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityid = ((Integer)i$.next()).intValue();
/* 28 */       if ((ActivityCompensateManager.canJoinActivity(((RoleLevelUpArg)this.arg).newLevel, activityid)) && (!ActivityCompensateManager.canJoinActivity(((RoleLevelUpArg)this.arg).oldLevel, activityid)))
/*    */       {
/* 30 */         ActivityCompensate xCompensate = ActivityCompensateManager.createXCompensateIfNotExist(xCompensates, activityid);
/* 31 */         xCompensate.setCan_join_time(nowMillis);
/* 32 */         ActivityCompensateManager.logInfo("POnRoleLevelUp.processImp@save can join time|roleid=%d|activityid=%d|old_level=%d|new_level=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityid), Integer.valueOf(((RoleLevelUpArg)this.arg).oldLevel), Integer.valueOf(((RoleLevelUpArg)this.arg).newLevel) });
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 39 */     if (!OpenInterface.getOpenStatus(544)) {
/* 40 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 44 */     if (!RoleStatusInterface.checkCanSetStatus(roleid, 2061, false))
/*    */     {
/* 46 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 50 */     if (((RoleLevelUpArg)this.arg).newLevel >= SActivityCompensateConsts.getInstance().NeedLevel) {
/* 51 */       ActivityCompensateManager.syncActivityCompensates(roleid, xCompensates, nowMillis);
/*    */     }
/*    */     
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitycompensate\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */