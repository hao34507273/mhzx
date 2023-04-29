/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import xbean.ActivityGlobalBean;
/*    */ import xbean.OpenBeanStore;
/*    */ import xtable.Activity;
/*    */ 
/*    */ public class ActivityReJustEndTimeLogicProcedure extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private int activityid;
/* 11 */   private ActivityForIDIPResult activityForIDIPResult = ActivityForIDIPResult.UNKNOWN_ERROR;
/*    */   
/*    */   public ActivityReJustEndTimeLogicProcedure(int activityid) {
/* 14 */     this.activityid = activityid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     ActivityGlobalBean xActivityGlobalBean = Activity.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 21 */     if (xActivityGlobalBean != null) {
/* 22 */       OpenBeanStore xOpenBeanStore = (OpenBeanStore)xActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(this.activityid));
/* 23 */       long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 24 */       if (xOpenBeanStore != null) {
/* 25 */         long endTime = xOpenBeanStore.getEndtime();
/* 26 */         if (curTime < endTime)
/*    */         {
/* 28 */           long nextStartTime = ActivityManager.getNextStartTime(curTime, this.activityid);
/* 29 */           if (endTime > nextStartTime) {
/* 30 */             xOpenBeanStore.setEndtime(nextStartTime);
/* 31 */             long interval = (nextStartTime - curTime) / 1000L;
/* 32 */             new ActivityManager.CloseSession(interval, this.activityid);
/* 33 */             mzm.gsp.GameServer.logger().info(String.format("[Activity]ActivityReJustEndTimeLogicProcedure.processImp@ajust endTime|curTime=%d|beforeEndTime=%d|nowEndTime=%d", new Object[] { Long.valueOf(curTime), Long.valueOf(endTime), Long.valueOf(nextStartTime) }));
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 46 */     this.activityForIDIPResult = ActivityForIDIPResult.SUCCESS;
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public ActivityForIDIPResult getResult() {
/* 51 */     return this.activityForIDIPResult;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\ActivityReJustEndTimeLogicProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */