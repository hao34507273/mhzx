/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.ActivityGlobalBean;
/*    */ import xbean.OpenBeanStore;
/*    */ import xbean.Pod;
/*    */ import xbean.StageBean;
/*    */ import xtable.Activity;
/*    */ 
/*    */ class BeforeActivityStartStageProcedure extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private int activityid;
/*    */   private int stageindex;
/*    */   private long triggerTime;
/*    */   
/*    */   public BeforeActivityStartStageProcedure(int activityid, int stageindex, long triggerTime)
/*    */   {
/* 21 */     this.activityid = activityid;
/* 22 */     this.stageindex = stageindex;
/* 23 */     this.triggerTime = triggerTime;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 28 */     if (this.stageindex >= 0) {
/* 29 */       GameServer.logger().error("活动开始前阶段不可能是正数,activityid:" + this.activityid + ",stage:" + this.stageindex);
/* 30 */       return false;
/*    */     }
/* 32 */     boolean startAgain = false;
/* 33 */     ActivityGlobalBean xSelectActivityOpenBean = Activity.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 34 */     OpenBeanStore xSelectOpenBeanStore = null;
/* 35 */     if (xSelectActivityOpenBean != null) {
/* 36 */       xSelectOpenBeanStore = (OpenBeanStore)xSelectActivityOpenBean.getActivityopenmap().get(Integer.valueOf(this.activityid));
/*    */     }
/*    */     
/* 39 */     int beforeStage = this.stageindex - 1;
/* 40 */     ActivityStage activityStage = ActivityManager.getActivityStage(this.activityid, beforeStage);
/* 41 */     if (activityStage != null) {
/* 42 */       if ((xSelectActivityOpenBean == null) || (xSelectOpenBeanStore == null) || (xSelectOpenBeanStore.getStage() >= this.stageindex))
/*    */       {
/* 44 */         if (GameServer.logger().isDebugEnabled()) {
/* 45 */           GameServer.logger().debug("活动阶段已经执行过了,activityid:" + this.activityid + " stage:" + this.stageindex);
/*    */         }
/* 47 */         return false;
/*    */       }
/*    */     }
/* 50 */     else if ((xSelectActivityOpenBean != null) && (xSelectOpenBeanStore != null) && (xSelectOpenBeanStore.getStage() != Integer.MAX_VALUE))
/*    */     {
/*    */ 
/* 53 */       if (GameServer.logger().isDebugEnabled()) {
/* 54 */         GameServer.logger().debug("活动阶段已经执行过了,activityid:" + this.activityid + " stage:" + this.stageindex);
/*    */       }
/* 56 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 60 */     if ((xSelectOpenBeanStore != null) && 
/* 61 */       (xSelectOpenBeanStore.getStagemap().containsKey(Integer.valueOf(this.stageindex)))) {
/* 62 */       StageBean xStageBean = (StageBean)xSelectOpenBeanStore.getStagemap().get(Integer.valueOf(this.stageindex));
/* 63 */       if (xStageBean != null) {
/* 64 */         startAgain = xStageBean.getTriggertime() == this.triggerTime;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 69 */     ActivityHandler activityHandler = ActivityManager.getActivityHandler(this.activityid);
/*    */     
/* 71 */     activityHandler.onActivityStageStart(this.stageindex, startAgain, this.activityid);
/*    */     
/* 73 */     ActivityGlobalBean activityGlobalBean = Activity.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 74 */     if (activityGlobalBean == null) {
/* 75 */       activityGlobalBean = Pod.newActivityGlobalBean();
/* 76 */       Activity.insert(Long.valueOf(GameServerInfoManager.getLocalId()), activityGlobalBean);
/*    */     }
/*    */     
/* 79 */     OpenBeanStore xOpenBeanStore = (OpenBeanStore)activityGlobalBean.getActivityopenmap().get(Integer.valueOf(this.activityid));
/* 80 */     if (xOpenBeanStore == null) {
/* 81 */       xOpenBeanStore = Pod.newOpenBeanStore();
/* 82 */       activityGlobalBean.getActivityopenmap().put(Integer.valueOf(this.activityid), xOpenBeanStore);
/*    */     }
/* 84 */     StageBean xStageBean = (StageBean)xOpenBeanStore.getStagemap().get(Integer.valueOf(this.stageindex));
/* 85 */     if (xStageBean == null) {
/* 86 */       xStageBean = Pod.newStageBean();
/* 87 */       xOpenBeanStore.getStagemap().put(Integer.valueOf(this.stageindex), xStageBean);
/*    */     }
/* 89 */     if (!startAgain) {
/* 90 */       xStageBean.setDuration(0);
/* 91 */       xStageBean.setTriggertime(this.triggerTime);
/*    */     }
/* 93 */     xOpenBeanStore.setStage(this.stageindex);
/* 94 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\BeforeActivityStartStageProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */