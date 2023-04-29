/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.ActivityBean;
/*    */ import xbean.ActivityGlobalBean;
/*    */ import xbean.OpenBeanStore;
/*    */ import xdb.Lockeys;
/*    */ 
/*    */ class ActivityInitProcedure extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final int activityid;
/*    */   private final long roleid;
/*    */   
/*    */   public ActivityInitProcedure(int activityid, String userid, long roleid)
/*    */   {
/* 16 */     this.activityid = activityid;
/* 17 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/* 24 */     Lockeys.lock(Lockeys.get(xtable.User.getTable(), userid));
/* 25 */     xbean.Activity xActivity = ActivityManager.createXActivityIfNotExist(userid, this.roleid, this.activityid);
/* 26 */     ActivityBean xActivityBean = (ActivityBean)xActivity.getActivitymap().get(Integer.valueOf(this.activityid));
/* 27 */     if (xActivityBean == null) {
/* 28 */       xActivityBean = xbean.Pod.newActivityBean();
/*    */       
/* 30 */       xActivityBean.setEndtime(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() + 10000L);
/*    */       
/* 32 */       xActivity.getActivitymap().put(Integer.valueOf(this.activityid), xActivityBean);
/*    */       
/* 34 */       ActivityManager.checkAndRefreshCompensate(this.roleid, this.activityid, -1L, xActivityBean.getCount());
/*    */       
/* 36 */       ActivityManager.initActivityData(xActivityBean, userid, this.roleid, this.activityid);
/*    */     } else {
/* 38 */       ActivityGlobalBean xActivityGlobalBean = xtable.Activity.select(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 39 */       if (xActivityGlobalBean != null) {
/* 40 */         OpenBeanStore openBeanStore = (OpenBeanStore)xActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(this.activityid));
/* 41 */         if ((openBeanStore != null) && 
/* 42 */           (openBeanStore.getCleardatatime() > xActivityBean.getEndtime()))
/*    */         {
/* 44 */           ActivityManager.checkAndRefreshCompensate(this.roleid, this.activityid, xActivityBean.getEndtime(), xActivityBean.getCount());
/*    */           
/* 46 */           ActivityManager.initActivityData(xActivityBean, userid, this.roleid, this.activityid);
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\ActivityInitProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */