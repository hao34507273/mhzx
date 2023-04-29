/*     */ package mzm.gsp.activity.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.OpenBeanStore;
/*     */ import xbean.StageBean;
/*     */ 
/*     */ class ActivityStageProcedure extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private int activityid;
/*     */   private int stage;
/*     */   private boolean triggerNextStage;
/*     */   
/*     */   public ActivityStageProcedure(int activityid, int stageindex)
/*     */   {
/*  16 */     this(activityid, stageindex, true);
/*     */   }
/*     */   
/*     */   public ActivityStageProcedure(int activityid, int stageindex, boolean triggerNextStage) {
/*  20 */     this.activityid = activityid;
/*  21 */     this.stage = stageindex;
/*  22 */     this.triggerNextStage = triggerNextStage;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  27 */     if (this.stage <= 0) {
/*  28 */       mzm.gsp.GameServer.logger().error("活动开始后阶段不可能小于等于0,activityid:" + this.activityid + ",stage:" + this.stage);
/*  29 */       return false;
/*     */     }
/*  31 */     xbean.ActivityGlobalBean xSelectActivityOpenBean = xtable.Activity.select(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/*  32 */     if (xSelectActivityOpenBean == null) {
/*  33 */       return false;
/*     */     }
/*  35 */     OpenBeanStore xSelectOpenBeanStore = (OpenBeanStore)xSelectActivityOpenBean.getActivityopenmap().get(Integer.valueOf(this.activityid));
/*  36 */     if ((xSelectOpenBeanStore == null) || (xSelectOpenBeanStore.getStage() >= this.stage))
/*     */     {
/*  38 */       mzm.gsp.GameServer.logger().info("活动阶段已经执行过了,activityid:" + this.activityid + " stage:" + this.stage);
/*  39 */       return false;
/*     */     }
/*  41 */     long activityEndTime = xSelectOpenBeanStore.getEndtime();
/*  42 */     long activityStartTime = activityEndTime - ActivityManager.getActivityDuationMill(this.activityid);
/*     */     
/*  44 */     ActivityHandler activityHandler = ActivityManager.getActivityHandler(this.activityid);
/*  45 */     long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  46 */     StageBean xSelectStageBean = (StageBean)xSelectOpenBeanStore.getStagemap().get(Integer.valueOf(this.stage));
/*     */     
/*  48 */     boolean startAgain = ActivityManager.stageStartAgain(activityStartTime, activityEndTime, xSelectStageBean);
/*     */     
/*  50 */     activityHandler.onActivityStageStart(this.stage, startAgain, this.activityid);
/*     */     
/*  52 */     xbean.ActivityGlobalBean activityGlobalBean = xtable.Activity.get(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/*  53 */     OpenBeanStore xOpenBeanStore = (OpenBeanStore)activityGlobalBean.getActivityopenmap().get(Integer.valueOf(this.activityid));
/*  54 */     if (xOpenBeanStore == null) {
/*  55 */       return false;
/*     */     }
/*  57 */     xOpenBeanStore.setStage(this.stage);
/*  58 */     StageBean stageBean = (StageBean)xOpenBeanStore.getStagemap().get(Integer.valueOf(this.stage));
/*  59 */     if (stageBean == null) {
/*  60 */       stageBean = xbean.Pod.newStageBean();
/*  61 */       xOpenBeanStore.getStagemap().put(Integer.valueOf(this.stage), stageBean);
/*     */     }
/*  63 */     if (!startAgain) {
/*  64 */       stageBean.setDuration(0);
/*  65 */       stageBean.setTriggertime(curTime);
/*     */     }
/*     */     
/*  68 */     if (!this.triggerNextStage) {
/*  69 */       return true;
/*     */     }
/*     */     
/*  72 */     int nextStage = this.stage + 1;
/*  73 */     ActivityStage nextActivityStage = ActivityManager.getActivityStage(this.activityid, nextStage);
/*  74 */     if (nextActivityStage != null) {
/*  75 */       if (nextActivityStage.isTimeBaseLineBefore()) {
/*  76 */         long durationMinute = ActivityManager.getActivityDurationMinute(this.activityid);
/*  77 */         StageBean xNextStageBean = (StageBean)xOpenBeanStore.getStagemap().get(Integer.valueOf(nextStage));
/*  78 */         boolean nextStageStartAgain = ActivityManager.stageStartAgain(activityStartTime, activityEndTime, xNextStageBean);
/*     */         
/*  80 */         if (!nextStageStartAgain)
/*     */         {
/*  82 */           if (nextActivityStage.isTimeLogicRelative()) {
/*  83 */             int sec = stageBean.getDuration();
/*  84 */             int interval = nextActivityStage.minute * 60 - sec;
/*  85 */             if (interval > 0) {
/*  86 */               new mzm.gsp.timer.main.Session(interval, this.activityid)
/*     */               {
/*     */                 protected void onTimeOut()
/*     */                 {
/*  90 */                   NoneRealTimeTaskManager.getInstance().addTask(new ActivityStageProcedure(ActivityStageProcedure.this.activityid, this.val$nextStage));
/*     */                 }
/*     */                 
/*     */               };
/*     */             } else {
/*  95 */               NoneRealTimeTaskManager.getInstance().addTask(new ActivityStageProcedure(this.activityid, nextStage));
/*     */             }
/*     */             
/*     */           }
/*  99 */           else if (nextActivityStage.isTimeLogicFix()) {
/* 100 */             long fixMinute = 0L;
/* 101 */             for (int i = 1; i <= nextStage; i++) {
/* 102 */               ActivityStage tempStage = ActivityManager.getActivityStage(this.activityid, i);
/* 103 */               if (tempStage.isTimeBaseLineBefore()) {
/* 104 */                 fixMinute += tempStage.minute;
/* 105 */               } else if (tempStage.isTimeBaseLineBegin()) {
/* 106 */                 fixMinute = tempStage.minute;
/* 107 */               } else if (tempStage.isTimeBaseLineEnd()) {
/* 108 */                 fixMinute = durationMinute - tempStage.minute;
/*     */               }
/*     */             }
/*     */             
/*     */ 
/* 113 */             long stageEndTime = activityStartTime + fixMinute * 60L * 1000L;
/* 114 */             long sec = (stageEndTime - curTime) / 1000L;
/* 115 */             if (sec > 0L) {
/* 116 */               new mzm.gsp.timer.main.Session(sec, this.activityid)
/*     */               {
/*     */                 protected void onTimeOut() {
/* 119 */                   NoneRealTimeTaskManager.getInstance().addTask(new ActivityStageProcedure(ActivityStageProcedure.this.activityid, this.val$nextStage));
/*     */                 }
/*     */                 
/*     */               };
/*     */             } else {
/* 124 */               NoneRealTimeTaskManager.getInstance().addTask(new ActivityStageProcedure(this.activityid, nextStage));
/*     */             }
/*     */             
/*     */           }
/*     */           
/*     */         }
/*     */         else {
/* 131 */           NoneRealTimeTaskManager.getInstance().addTask(new ActivityStageProcedure(this.activityid, nextStage));
/*     */         }
/*     */       }
/* 134 */       else if (nextActivityStage.isTimeBaseLineBegin()) {
/* 135 */         ActivityManager.openTimeBeginStage(xOpenBeanStore, nextActivityStage, this.activityid);
/*     */       }
/* 137 */       else if (nextActivityStage.isTimeBaseLineEnd()) {
/* 138 */         ActivityManager.openTimeEndStage(xOpenBeanStore, nextActivityStage, this.activityid);
/*     */       }
/*     */     }
/*     */     
/* 142 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\ActivityStageProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */