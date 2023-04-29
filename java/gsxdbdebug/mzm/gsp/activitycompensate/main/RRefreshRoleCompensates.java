/*    */ package mzm.gsp.activitycompensate.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activitycompensate.confbean.SActivityCompensateConsts;
/*    */ 
/*    */ class RRefreshRoleCompensates extends mzm.gsp.util.LogicRunnable
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   RRefreshRoleCompensates(long roleid)
/*    */   {
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 19 */     int level = mzm.gsp.role.main.RoleInterface.getLevel(this.roleid);
/*    */     
/* 21 */     if (level < SActivityCompensateConsts.getInstance().NeedLevel) {
/* 22 */       return;
/*    */     }
/*    */     
/* 25 */     for (Iterator i$ = mzm.gsp.activitycompensate.confbean.SActivityCompensateCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityid = ((Integer)i$.next()).intValue();
/* 26 */       boolean ret = new PRefreshCompensate(this.roleid, activityid).call();
/* 27 */       if (!ret) {
/* 28 */         ActivityCompensateManager.logError("RRefreshRoleCompensates.process@failed|roleid=%d|activityid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(activityid) });
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 34 */     new PSyncCompensates(this.roleid).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitycompensate\main\RRefreshRoleCompensates.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */