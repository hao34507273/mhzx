/*     */ package mzm.gsp.activity.main;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.common.TimeCommonDurationObserver;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.OpenBeanStore;
/*     */ 
/*     */ public class ActivityObsever
/*     */ {
/*     */   public static class ActivityDurationObserver
/*     */   {
/*     */     private final int activityId;
/*     */     
/*     */     public ActivityDurationObserver(int activityid, int activityTimeId)
/*     */     {
/*  16 */       this.activityId = activityid;
/*  17 */       int durationTimeId = activityTimeId;
/*  18 */       new TimeCommonDurationObserver(durationTimeId)
/*     */       {
/*     */         protected boolean onStartTimeOut()
/*     */         {
/*  22 */           long currentTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() + 2000L;
/*  23 */           long startTime = ActivityManager.getActivityLimitTimeBegin(ActivityObsever.ActivityDurationObserver.this.activityId);
/*  24 */           long endTime = ActivityManager.getActivityLimitTimeEnd(ActivityObsever.ActivityDurationObserver.this.activityId);
/*  25 */           if (startTime <= 0L) {
/*  26 */             if (endTime <= 0L) {
/*  27 */               ActivityObsever.ActivityDurationObserver.this.onBegin(this);
/*  28 */               return true;
/*     */             }
/*  30 */             if (currentTime < endTime) {
/*  31 */               ActivityObsever.ActivityDurationObserver.this.onBegin(this);
/*  32 */               return true;
/*     */             }
/*  34 */             return false;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*  39 */           if ((currentTime >= startTime) && (currentTime < endTime)) {
/*  40 */             ActivityObsever.ActivityDurationObserver.this.onBegin(this);
/*  41 */             return true;
/*     */           }
/*  43 */           return currentTime < endTime;
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */         protected void onLastTimeOut()
/*     */         {
/*  50 */           ActivityObsever.ActivityDurationObserver.this.onEnd();
/*     */         }
/*     */       };
/*     */     }
/*     */     
/*     */     public int getActivityId()
/*     */     {
/*  57 */       return this.activityId;
/*     */     }
/*     */     
/*     */     protected void onBegin(TimeCommonDurationObserver durationObserver) {
/*  61 */       mzm.gsp.util.NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicRunnable()
/*     */       {
/*     */         public void process() throws Exception
/*     */         {
/*  65 */           long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  66 */           long startTime = ActivityManager.getBeforeStartTime(curTime + 20000L, ActivityObsever.ActivityDurationObserver.this.activityId);
/*     */           
/*  68 */           if (startTime <= 0L) {
/*  69 */             GameServer.logger().error(String.format("[Activity]ActivityObsever.process@activity startTimeError|activityid=%d|startTime=%d", new Object[] { Integer.valueOf(ActivityObsever.ActivityDurationObserver.this.activityId), Long.valueOf(startTime) }));
/*     */             
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  76 */             return;
/*     */           }
/*  78 */           ActivityObsever.handleOnTimerActivityStart(curTime, startTime, ActivityObsever.ActivityDurationObserver.this.activityId);
/*     */         }
/*     */       });
/*     */     }
/*     */     
/*     */ 
/*     */     protected void onEnd()
/*     */     {
/*  86 */       mzm.gsp.util.NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicRunnable()
/*     */       {
/*     */         public void process() throws Exception
/*     */         {
/*  90 */           ActivityObsever.handleonTimerActivityEnd(ActivityObsever.ActivityDurationObserver.this.activityId);
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void handleOnTimerActivityStart(long curTime, long startTime, int activityId)
/*     */   {
/* 106 */     xbean.ActivityGlobalBean xSelectActivityGlobalBean = xtable.Activity.select(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 107 */     if (xSelectActivityGlobalBean != null) {
/* 108 */       OpenBeanStore xOpenBeanStore = (OpenBeanStore)xSelectActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(activityId));
/* 109 */       if (xOpenBeanStore != null) {
/* 110 */         int openState = xOpenBeanStore.getOpenstate();
/* 111 */         if (ActivityManager.isForceCloseState(openState)) {
/* 112 */           GameServer.logger().info(String.format("activity is force closed|activityid=%d|state=%d", new Object[] { Integer.valueOf(activityId), Integer.valueOf(openState) }));
/*     */           
/* 114 */           return;
/*     */         }
/*     */       }
/*     */     }
/* 118 */     long activityEndTime = ActivityInterface.getActivityEndTime(activityId);
/* 119 */     long intervalTime = Math.abs(curTime - activityEndTime);
/* 120 */     if ((curTime < activityEndTime) && (intervalTime > 60000L)) {
/* 121 */       GameServer.logger().info("活动在开启中,不再开启!!!activityid:" + activityId);
/* 122 */       return;
/*     */     }
/* 124 */     Integer stageInteger = ActivityManager.getActivityStoreStage(activityId);
/* 125 */     if ((stageInteger != null) && (stageInteger.intValue() != Integer.MAX_VALUE) && (stageInteger.intValue() >= 0))
/*     */     {
/* 127 */       if (GameServer.logger().isDebugEnabled()) {
/* 128 */         GameServer.logger().debug("活动在开始的时候发现还没有关闭,先执行了一下关闭! activityid:" + activityId + " stage:" + stageInteger);
/*     */       }
/*     */       
/* 131 */       ActivityManager.onActivityEnd(activityId);
/*     */     }
/* 133 */     new ActivityStartProcedure(activityId, startTime).call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void handleonTimerActivityEnd(int activityId)
/*     */   {
/* 143 */     xbean.ActivityGlobalBean xSelectActivityGlobalBean = xtable.Activity.select(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 144 */     if (xSelectActivityGlobalBean != null) {
/* 145 */       OpenBeanStore xOpenBeanStore = (OpenBeanStore)xSelectActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(activityId));
/* 146 */       if (xOpenBeanStore != null) {
/* 147 */         int openState = xOpenBeanStore.getOpenstate();
/* 148 */         if (ActivityManager.isForceCloseState(openState)) {
/* 149 */           GameServer.logger().info(String.format("activity is force closed|activityid=%d|state=%d", new Object[] { Integer.valueOf(activityId), Integer.valueOf(openState) }));
/*     */           
/* 151 */           return;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 156 */     long activityEndTime = ActivityInterface.getActivityEndTime(activityId);
/* 157 */     long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 158 */     long intervalTime = Math.abs(curTime - activityEndTime);
/* 159 */     if ((curTime < activityEndTime) && (intervalTime > 60000L)) {
/* 160 */       GameServer.logger().info("活动已经在开启了,不执行关闭!!!activityid:" + activityId);
/* 161 */       return;
/*     */     }
/* 163 */     ActivityManager.onActivityEnd(activityId);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\ActivityObsever.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */