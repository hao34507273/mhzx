/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.SynActivitySpecialControlChangeRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.ActivityGlobalBean;
/*    */ import xbean.OpenBeanStore;
/*    */ import xtable.Activity;
/*    */ 
/*    */ public class ActivityForceOpenLogicProcedure extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private int activityid;
/*    */   private long lastMinute;
/* 15 */   private ActivityForIDIPResult activityForIDIPResult = ActivityForIDIPResult.UNKNOWN_ERROR;
/*    */   
/*    */   public ActivityForceOpenLogicProcedure(int activityid, long lastMinute) {
/* 18 */     this.activityid = activityid;
/* 19 */     this.lastMinute = lastMinute;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 24 */     if (ActivityInterface.isActivityOpen(this.activityid)) {
/* 25 */       this.activityForIDIPResult = ActivityForIDIPResult.ACTIVITY_ALREADY_OPEN;
/* 26 */       return false;
/*    */     }
/* 28 */     ActivityGlobalBean xSelectActivityGlobalBean = Activity.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 29 */     if (xSelectActivityGlobalBean != null) {
/* 30 */       OpenBeanStore xOpenBeanStore = (OpenBeanStore)xSelectActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(this.activityid));
/* 31 */       if ((xOpenBeanStore != null) && 
/* 32 */         (ActivityManager.isForceCloseState(xOpenBeanStore.getOpenstate()))) {
/* 33 */         this.activityForIDIPResult = ActivityForIDIPResult.ACTIVITY_IN_FORCE_CLOSE;
/* 34 */         return false;
/*    */       }
/*    */     }
/*    */     
/* 38 */     boolean ret = new ActivityStartProcedure(this.activityid, mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis(), true, this.lastMinute).call();
/*    */     
/* 40 */     if (!ret) {
/* 41 */       this.activityForIDIPResult = ActivityForIDIPResult.UNKNOWN_ERROR;
/*    */     } else {
/* 43 */       this.activityForIDIPResult = ActivityForIDIPResult.SUCCESS;
/*    */       
/* 45 */       ActivityGlobalBean xActivityGlobalBean = Activity.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 46 */       OpenBeanStore xOpenBeanStore = (OpenBeanStore)xActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(this.activityid));
/* 47 */       xOpenBeanStore.setOpenstate(xOpenBeanStore.getOpenstate() | 0x2);
/*    */       
/* 49 */       SynActivitySpecialControlChangeRes controlChangeRes = new SynActivitySpecialControlChangeRes();
/* 50 */       ActivityManager.fillSpecialControlData(controlChangeRes.specialcontroldata, this.activityid, xOpenBeanStore);
/* 51 */       OnlineManager.getInstance().sendAll(controlChangeRes);
/*    */       
/* 53 */       long interval = this.lastMinute * 60L;
/*    */       
/* 55 */       new ActivityManager.CloseSession(interval, this.activityid);
/*    */       
/* 57 */       mzm.gsp.GameServer.logger().info(String.format("excute force open activity success|activityid=%d", new Object[] { Integer.valueOf(this.activityid) }));
/*    */     }
/*    */     
/*    */ 
/* 61 */     return ret;
/*    */   }
/*    */   
/*    */   public ActivityForIDIPResult getResult() {
/* 65 */     return this.activityForIDIPResult;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\ActivityForceOpenLogicProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */