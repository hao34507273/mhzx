/*     */ package mzm.gsp.activity.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.gm.SGMMessageTipRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import xbean.ActivityGlobalBean;
/*     */ import xbean.OpenBeanStore;
/*     */ import xtable.Activity;
/*     */ 
/*     */ public class PGMOpenActivtiyNotClear extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private int activityid;
/*     */   private long roleid;
/*     */   
/*     */   public PGMOpenActivtiyNotClear(int activityid, long roleid)
/*     */   {
/*  20 */     this.activityid = activityid;
/*  21 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     int curStage = Integer.MAX_VALUE;
/*  28 */     ActivityGlobalBean xSelectBean = Activity.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  29 */     if (xSelectBean != null) {
/*  30 */       OpenBeanStore xOpenBeanStore = (OpenBeanStore)xSelectBean.getActivityopenmap().get(Integer.valueOf(this.activityid));
/*  31 */       if (xOpenBeanStore != null) {
/*  32 */         curStage = xOpenBeanStore.getStage();
/*     */       }
/*     */     }
/*     */     
/*  36 */     ActivityStage beforeActivityStage = ActivityManager.getActivityStage(this.activityid, -1);
/*  37 */     if (beforeActivityStage == null) {
/*  38 */       if (curStage != Integer.MAX_VALUE) {
/*  39 */         SGMMessageTipRes gmMessageTipRes = new SGMMessageTipRes();
/*  40 */         gmMessageTipRes.result = 2;
/*  41 */         gmMessageTipRes.args.add(curStage + "");
/*  42 */         OnlineManager.getInstance().sendAtOnce(this.roleid, gmMessageTipRes);
/*  43 */         return false;
/*     */       }
/*     */     } else {
/*  46 */       int nextStage = curStage + 1;
/*  47 */       if (0 != nextStage) {
/*  48 */         SGMMessageTipRes gmMessageTipRes = new SGMMessageTipRes();
/*  49 */         gmMessageTipRes.result = 3;
/*  50 */         gmMessageTipRes.args.add("" + nextStage);
/*  51 */         OnlineManager.getInstance().sendAtOnce(this.roleid, gmMessageTipRes);
/*  52 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  56 */     ActivityHandler.ActivityStartType activityStartType = ActivityHandler.ActivityStartType.LITTLE_TURN_FIRST;
/*  57 */     if (xSelectBean == null) {
/*  58 */       activityStartType = ActivityHandler.ActivityStartType.BIG_TURN;
/*     */     }
/*  60 */     else if (!xSelectBean.getActivityopenmap().containsKey(Integer.valueOf(this.activityid))) {
/*  61 */       activityStartType = ActivityHandler.ActivityStartType.BIG_TURN;
/*     */     }
/*     */     
/*     */ 
/*  65 */     long startTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  66 */     ActivityManager.onActivityStart(this.activityid, activityStartType);
/*     */     
/*  68 */     ActivityGlobalBean xOpenBean = Activity.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  69 */     if (xOpenBean == null) {
/*  70 */       xOpenBean = xbean.Pod.newActivityGlobalBean();
/*  71 */       Activity.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xOpenBean);
/*     */     }
/*  73 */     OpenBeanStore xOpenBeanStore = (OpenBeanStore)xOpenBean.getActivityopenmap().get(Integer.valueOf(this.activityid));
/*  74 */     if (xOpenBeanStore == null) {
/*  75 */       xOpenBeanStore = xbean.Pod.newOpenBeanStore();
/*  76 */       xOpenBean.getActivityopenmap().put(Integer.valueOf(this.activityid), xOpenBeanStore);
/*  77 */       xOpenBeanStore.setStage(0);
/*  78 */       xOpenBeanStore.setCleardatatime(startTime);
/*     */     }
/*     */     
/*  81 */     xOpenBeanStore.setEndtime(startTime + ActivityManager.getActivityDuationMill(this.activityid));
/*     */     
/*  83 */     ActivityStage activityStage = ActivityManager.getActivityStage(this.activityid, 1);
/*  84 */     if (activityStage != null) {
/*  85 */       if (activityStage.isTimeBaseLineBegin()) {
/*  86 */         ActivityManager.openTimeBeginStage(xOpenBeanStore, activityStage, this.activityid);
/*  87 */       } else if (activityStage.isTimeBaseLineEnd()) {
/*  88 */         ActivityManager.openTimeEndStage(xOpenBeanStore, activityStage, this.activityid);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  93 */     long interval = ActivityManager.getActivityDurationMinute(this.activityid) * 60L;
/*     */     
/*  95 */     new Session(interval, this.activityid)
/*     */     {
/*     */       protected void onTimeOut()
/*     */       {
/*  99 */         mzm.gsp.util.NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicRunnable()
/*     */         {
/*     */           public void process() throws Exception
/*     */           {
/* 103 */             int activityid = (int)PGMOpenActivtiyNotClear.1.this.getOwerId();
/* 104 */             long activityEndTime = ActivityInterface.getActivityEndTime(activityid);
/* 105 */             long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 106 */             long intervalTime = Math.abs(curTime - activityEndTime);
/* 107 */             if ((curTime < activityEndTime) && (intervalTime > 60000L)) {
/* 108 */               mzm.gsp.GameServer.logger().info("活动已经在开启了,不执行关闭!!!activityid:" + activityid);
/* 109 */               return;
/*     */             }
/* 111 */             ActivityManager.onActivityEnd(activityid);
/*     */           }
/*     */           
/*     */ 
/*     */         });
/*     */       }
/* 117 */     };
/* 118 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\PGMOpenActivtiyNotClear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */