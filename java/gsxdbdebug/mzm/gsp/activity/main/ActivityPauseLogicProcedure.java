/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.SynActivitySpecialControlChangeRes;
/*    */ import mzm.gsp.activity.event.ActivityPauseArg;
/*    */ import mzm.gsp.activity.event.ActivityRecovery;
/*    */ import mzm.gsp.activity.event.ActivityRecoveryArg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.ActivityGlobalBean;
/*    */ import xbean.OpenBeanStore;
/*    */ import xbean.Pod;
/*    */ import xtable.Activity;
/*    */ 
/*    */ public class ActivityPauseLogicProcedure extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final int activityid;
/*    */   private final boolean doOrRecovery;
/* 20 */   private ActivityForIDIPResult activityForIDIPResult = ActivityForIDIPResult.UNKNOWN_ERROR;
/*    */   
/*    */   public ActivityPauseLogicProcedure(int activityid, boolean doOrRecovery) {
/* 23 */     this.activityid = activityid;
/* 24 */     this.doOrRecovery = doOrRecovery;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 29 */     long localid = mzm.gsp.GameServerInfoManager.getLocalId();
/*    */     
/* 31 */     ActivityGlobalBean xActivityGlobalBean = Activity.get(Long.valueOf(localid));
/* 32 */     if (xActivityGlobalBean == null) {
/* 33 */       xActivityGlobalBean = Pod.newActivityGlobalBean();
/* 34 */       Activity.insert(Long.valueOf(localid), xActivityGlobalBean);
/*    */     }
/*    */     
/* 37 */     OpenBeanStore xOpenBeanStore = (OpenBeanStore)xActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(this.activityid));
/* 38 */     if (xOpenBeanStore == null) {
/* 39 */       xOpenBeanStore = Pod.newOpenBeanStore();
/* 40 */       long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 41 */       xOpenBeanStore.setCleardatatime(curTime);
/* 42 */       xOpenBeanStore.setEndtime(curTime);
/* 43 */       xActivityGlobalBean.getActivityopenmap().put(Integer.valueOf(this.activityid), xOpenBeanStore);
/*    */     }
/* 45 */     if (this.doOrRecovery) {
/* 46 */       xOpenBeanStore.setOpenstate(xOpenBeanStore.getOpenstate() | 0x1);
/*    */       
/* 48 */       ActivityPauseArg activityPauseArg = new ActivityPauseArg(this.activityid);
/* 49 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.activity.event.ActivityPause(), activityPauseArg);
/*    */     } else {
/* 51 */       xOpenBeanStore.setOpenstate(xOpenBeanStore.getOpenstate() & 0xFFFFFFFE);
/*    */       
/* 53 */       ActivityRecoveryArg activityRecoveryArg = new ActivityRecoveryArg(this.activityid);
/* 54 */       TriggerEventsManger.getInstance().triggerEvent(new ActivityRecovery(), activityRecoveryArg);
/*    */     }
/*    */     
/*    */ 
/* 58 */     SynActivitySpecialControlChangeRes controlChangeRes = new SynActivitySpecialControlChangeRes();
/* 59 */     ActivityManager.fillSpecialControlData(controlChangeRes.specialcontroldata, this.activityid, xOpenBeanStore);
/* 60 */     OnlineManager.getInstance().sendAll(controlChangeRes);
/*    */     
/* 62 */     this.activityForIDIPResult = ActivityForIDIPResult.SUCCESS;
/*    */     
/* 64 */     GameServer.logger().info(String.format("excute pause activity success|activityid=%d|doOrRecovery=%b", new Object[] { Integer.valueOf(this.activityid), Boolean.valueOf(this.doOrRecovery) }));
/*    */     
/*    */ 
/* 67 */     return true;
/*    */   }
/*    */   
/*    */   public ActivityForIDIPResult getResult() {
/* 71 */     return this.activityForIDIPResult;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\ActivityPauseLogicProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */