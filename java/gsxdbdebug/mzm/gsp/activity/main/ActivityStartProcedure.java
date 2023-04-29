/*     */ package mzm.gsp.activity.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.SynActivitySpecialControlChangeRes;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.common.confbean.STimeDurationCommonCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import xbean.ActivityGlobalBean;
/*     */ import xbean.OpenBeanStore;
/*     */ import xbean.Pod;
/*     */ import xbean.StageBean;
/*     */ import xtable.Activity;
/*     */ 
/*     */ class ActivityStartProcedure extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private int activityid;
/*     */   private long startTime;
/*     */   private boolean triggerNext;
/*     */   private long durationMinute;
/*     */   
/*     */   ActivityStartProcedure(int activityid, long startTime)
/*     */   {
/*  29 */     this(activityid, startTime, true);
/*     */   }
/*     */   
/*     */   ActivityStartProcedure(int activityid, long startTime, boolean triggerNext) {
/*  33 */     this(activityid, startTime, triggerNext, 0L);
/*     */   }
/*     */   
/*     */   public ActivityStartProcedure(int activityid, long startTime, boolean triggerNext, long durationMinute) {
/*  37 */     this.activityid = activityid;
/*  38 */     this.startTime = startTime;
/*  39 */     this.triggerNext = triggerNext;
/*  40 */     this.durationMinute = durationMinute;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  45 */     GameServer.logger().info(String.format("[Activity]ActivityStartProcedure.processImp@activity start|activityid=%d|startTime=%d", new Object[] { Integer.valueOf(this.activityid), Long.valueOf(this.startTime) }));
/*     */     
/*     */ 
/*  48 */     ActivityHandler.ActivityStartType activityStartType = ActivityHandler.ActivityStartType.BIG_TURN;
/*  49 */     long oriEndTime = 0L;
/*  50 */     ActivityGlobalBean xSelectOpenBean = Activity.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  51 */     if (xSelectOpenBean != null) {
/*  52 */       OpenBeanStore xSelectOpenBeanStore = (OpenBeanStore)xSelectOpenBean.getActivityopenmap().get(Integer.valueOf(this.activityid));
/*  53 */       if (xSelectOpenBeanStore != null)
/*     */       {
/*  55 */         SActivityCfg activityCfg = SActivityCfg.get(this.activityid);
/*  56 */         if (activityCfg.activityTimeIds.size() <= 0)
/*     */         {
/*     */ 
/*     */ 
/*  60 */           activityStartType = ActivityHandler.ActivityStartType.START_AGAIN;
/*     */         } else {
/*  62 */           long clearDataTime = xSelectOpenBeanStore.getCleardatatime();
/*  63 */           oriEndTime = xSelectOpenBeanStore.getEndtime();
/*  64 */           if (activityCfg.bigReset) {
/*  65 */             STimeDurationCommonCfg durationCommonCfg = STimeDurationCommonCfg.get(((Integer)activityCfg.activityTimeIds.get(0)).intValue());
/*     */             
/*  67 */             long tempclearTime = mzm.gsp.common.TimeCommonUtil.getBeforeStartTime(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() + 300000L, activityCfg.resetDataBigTurn, durationCommonCfg.timeCommonCfgId);
/*     */             
/*     */ 
/*     */ 
/*  71 */             if (tempclearTime > clearDataTime) {
/*  72 */               activityStartType = ActivityHandler.ActivityStartType.BIG_TURN;
/*     */             }
/*  74 */             else if (this.startTime < oriEndTime) {
/*  75 */               activityStartType = ActivityHandler.ActivityStartType.START_AGAIN;
/*     */             } else {
/*  77 */               activityStartType = ActivityHandler.ActivityStartType.LITTLE_TURN_FIRST;
/*     */             }
/*     */             
/*     */ 
/*     */           }
/*  82 */           else if (this.startTime > clearDataTime) {
/*  83 */             activityStartType = ActivityHandler.ActivityStartType.BIG_TURN;
/*     */           } else {
/*  85 */             activityStartType = ActivityHandler.ActivityStartType.START_AGAIN;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  94 */     long durationMill = ActivityManager.getActivityDuationMill(this.activityid);
/*  95 */     if (this.durationMinute > 0L) {
/*  96 */       durationMill = this.durationMinute * 60L * 1000L;
/*     */     }
/*  98 */     long nowEndTime = this.startTime + durationMill;
/*     */     
/* 100 */     if (nowEndTime == oriEndTime) {
/* 101 */       activityStartType = ActivityHandler.ActivityStartType.START_AGAIN;
/*     */     }
/*     */     
/* 104 */     ActivityManager.onActivityStart(this.activityid, activityStartType);
/*     */     
/* 106 */     ActivityGlobalBean xOpenBean = Activity.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 107 */     if (xOpenBean == null) {
/* 108 */       xOpenBean = Pod.newActivityGlobalBean();
/* 109 */       Activity.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xOpenBean);
/*     */     }
/* 111 */     OpenBeanStore xOpenBeanStore = (OpenBeanStore)xOpenBean.getActivityopenmap().get(Integer.valueOf(this.activityid));
/* 112 */     if (xOpenBeanStore == null) {
/* 113 */       xOpenBeanStore = Pod.newOpenBeanStore();
/* 114 */       xOpenBean.getActivityopenmap().put(Integer.valueOf(this.activityid), xOpenBeanStore);
/* 115 */       xOpenBeanStore.setCleardatatime(this.startTime);
/*     */     }
/*     */     
/* 118 */     xOpenBeanStore.setStage(0);
/*     */     
/* 120 */     if (activityStartType == ActivityHandler.ActivityStartType.BIG_TURN) {
/* 121 */       xOpenBeanStore.setCleardatatime(this.startTime);
/* 122 */       xOpenBeanStore.setActivityduration(0);
/* 123 */       Iterator<Map.Entry<Integer, StageBean>> iterator = xOpenBeanStore.getStagemap().entrySet().iterator();
/* 124 */       while (iterator.hasNext()) {
/* 125 */         Map.Entry<Integer, StageBean> entry = (Map.Entry)iterator.next();
/* 126 */         if (((Integer)entry.getKey()).intValue() >= 0) {
/* 127 */           iterator.remove();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 132 */     if (activityStartType == ActivityHandler.ActivityStartType.LITTLE_TURN_FIRST) {
/* 133 */       xOpenBeanStore.setActivityduration(0);
/* 134 */       Iterator<Map.Entry<Integer, StageBean>> iterator = xOpenBeanStore.getStagemap().entrySet().iterator();
/* 135 */       while (iterator.hasNext()) {
/* 136 */         Map.Entry<Integer, StageBean> entry = (Map.Entry)iterator.next();
/* 137 */         if (((Integer)entry.getKey()).intValue() >= 0) {
/* 138 */           iterator.remove();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 144 */     xOpenBeanStore.setEndtime(nowEndTime);
/*     */     
/* 146 */     if (ActivityManager.isForceOpenState(xOpenBeanStore.getOpenstate()))
/*     */     {
/*     */ 
/* 149 */       SynActivitySpecialControlChangeRes controlChangeRes = new SynActivitySpecialControlChangeRes();
/* 150 */       ActivityManager.fillSpecialControlData(controlChangeRes.specialcontroldata, this.activityid, xOpenBeanStore);
/* 151 */       OnlineManager.getInstance().sendAll(controlChangeRes);
/*     */       
/* 153 */       if ((this.startTime >= oriEndTime) && (oriEndTime > 0L)) {
/* 154 */         xOpenBeanStore.setOpenstate(xOpenBeanStore.getOpenstate() & 0xFFFFFFFD);
/* 155 */         SynActivitySpecialControlChangeRes controlChangeRes1 = new SynActivitySpecialControlChangeRes();
/* 156 */         ActivityManager.fillSpecialControlData(controlChangeRes1.specialcontroldata, this.activityid, xOpenBeanStore);
/*     */         
/* 158 */         OnlineManager.getInstance().sendAll(controlChangeRes1);
/*     */       }
/*     */     }
/*     */     
/* 162 */     if (this.triggerNext) {
/* 163 */       ActivityStage activityStage = ActivityManager.getActivityStage(this.activityid, 1);
/* 164 */       if (activityStage != null) {
/* 165 */         if (activityStage.isTimeBaseLineBegin()) {
/* 166 */           ActivityManager.openTimeBeginStage(xOpenBeanStore, activityStage, this.activityid);
/* 167 */         } else if (activityStage.isTimeBaseLineEnd()) {
/* 168 */           ActivityManager.openTimeEndStage(xOpenBeanStore, activityStage, this.activityid);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 173 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\ActivityStartProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */