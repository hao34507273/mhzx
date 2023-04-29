/*     */ package mzm.gsp.activity.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.SynActivityInitRes;
/*     */ import mzm.gsp.activity.SynActivitySpecialControlRes;
/*     */ import mzm.gsp.activity.SynLimitTimeActivityOpened;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.ActivityBean;
/*     */ import xbean.ActivityGlobalBean;
/*     */ import xbean.OpenBeanStore;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2activitycare;
/*     */ 
/*     */ public class ROnRoleLogin extends mzm.gsp.online.event.PlayerLoginRunnable
/*     */ {
/*     */   public void process() throws Exception
/*     */   {
/*  26 */     ActivityGlobalBean xActivityGlobalBean = xtable.Activity.select(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/*  27 */     if (xActivityGlobalBean == null) {
/*  28 */       return;
/*     */     }
/*     */     
/*  31 */     final long roleId = ((Long)this.arg).longValue();
/*  32 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleId);
/*     */     
/*  34 */     List<xbean.Activity> xActivities = new ArrayList();
/*     */     
/*     */ 
/*  37 */     xbean.Activity xActivity = xtable.User2activity.select(userid);
/*  38 */     if (xActivity == null) {
/*  39 */       xActivity = Pod.newActivityData();
/*     */     }
/*  41 */     xActivities.add(xActivity);
/*     */     
/*     */ 
/*     */ 
/*  45 */     xbean.Activity xActivity = xtable.Role2activity.select(Long.valueOf(roleId));
/*  46 */     if (xActivity == null) {
/*  47 */       xActivity = Pod.newActivityData();
/*     */     }
/*  49 */     xActivities.add(xActivity);
/*     */     
/*  51 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  52 */     for (xbean.Activity xActivity : xActivities)
/*     */     {
/*  54 */       Set<Integer> initActivityids = new HashSet();
/*     */       
/*  56 */       for (Map.Entry<Integer, OpenBeanStore> activityBeanEntry : xActivityGlobalBean.getActivityopenmap().entrySet())
/*     */       {
/*  58 */         int activityid = ((Integer)activityBeanEntry.getKey()).intValue();
/*  59 */         OpenBeanStore xOpenBeanStore = (OpenBeanStore)activityBeanEntry.getValue();
/*  60 */         if (!ActivityManager.isForceCloseState(xOpenBeanStore.getOpenstate()))
/*     */         {
/*     */ 
/*  63 */           if (xActivity.getActivitymap().containsKey(Integer.valueOf(activityid))) {
/*  64 */             ActivityBean xActivityBean = (ActivityBean)xActivity.getActivitymap().get(Integer.valueOf(activityid));
/*  65 */             if (xActivityBean.getEndtime() < xOpenBeanStore.getCleardatatime()) {
/*  66 */               initActivityids.add(Integer.valueOf(activityid));
/*     */             }
/*     */           }
/*  69 */           else if ((curTime < xOpenBeanStore.getEndtime()) && (ActivityManager.isInActivityLevel(userid, roleId, activityid)))
/*     */           {
/*  71 */             initActivityids.add(Integer.valueOf(activityid));
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*  76 */       for (i$ = initActivityids.iterator(); i$.hasNext();) { int activityid = ((Integer)i$.next()).intValue();
/*  77 */         new ActivityInitProcedure(activityid, userid, roleId).call();
/*     */       }
/*     */     }
/*     */     
/*     */     Iterator i$;
/*     */     
/*  83 */     SynActivityInitRes synActivityInitRes = new SynActivityInitRes();
/*     */     
/*  85 */     List<xbean.Activity> xActivities = new ArrayList();
/*     */     
/*     */ 
/*  88 */     xbean.Activity xActivity = xtable.User2activity.select(userid);
/*  89 */     if (xActivity != null) {
/*  90 */       xActivities.add(xActivity);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  95 */     xbean.Activity xActivity = xtable.Role2activity.select(Long.valueOf(roleId));
/*  96 */     if (xActivity != null) {
/*  97 */       xActivities.add(xActivity);
/*     */     }
/*     */     
/*     */ 
/* 101 */     for (xbean.Activity xActivity : xActivities) {
/* 102 */       for (Map.Entry<Integer, ActivityBean> activityEntry : xActivity.getActivitymap().entrySet()) {
/* 103 */         mzm.gsp.activity.ActivityData activityData = new mzm.gsp.activity.ActivityData();
/* 104 */         ActivityManager.fillActivityData(((Integer)activityEntry.getKey()).intValue(), (ActivityBean)activityEntry.getValue(), activityData);
/* 105 */         synActivityInitRes.activityinfos.add(activityData);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 110 */     if (synActivityInitRes.activityinfos.size() > 0) {
/* 111 */       OnlineManager.getInstance().sendAtOnce(roleId, synActivityInitRes);
/*     */     }
/*     */     
/* 114 */     SynActivitySpecialControlRes specialControlRes = new SynActivitySpecialControlRes();
/*     */     
/* 116 */     SynLimitTimeActivityOpened synLimitTimeActivityOpened = new SynLimitTimeActivityOpened();
/* 117 */     long curtime = DateTimeUtils.getCurrTimeInMillis();
/* 118 */     for (Map.Entry<Integer, OpenBeanStore> entry : xActivityGlobalBean.getActivityopenmap().entrySet()) {
/* 119 */       int activityid = ((Integer)entry.getKey()).intValue();
/* 120 */       SActivityCfg activityCfg = SActivityCfg.get(activityid);
/* 121 */       if (activityCfg == null) {
/* 122 */         mzm.gsp.GameServer.logger().info("活动表中存储的活动id不存在了,activityid:" + activityid);
/*     */       }
/*     */       else {
/* 125 */         if ((activityCfg.activityType != 1) && 
/* 126 */           (((OpenBeanStore)entry.getValue()).getEndtime() > curtime)) {
/* 127 */           synLimitTimeActivityOpened.activityids.add(Integer.valueOf(activityid));
/*     */         }
/*     */         
/* 130 */         OpenBeanStore xOpenBeanStore = (OpenBeanStore)entry.getValue();
/* 131 */         if (xOpenBeanStore.getOpenstate() != 0) {
/* 132 */           mzm.gsp.activity.SpecialControlData specialControlData = new mzm.gsp.activity.SpecialControlData();
/* 133 */           ActivityManager.fillSpecialControlData(specialControlData, activityid, xOpenBeanStore);
/* 134 */           specialControlRes.specialcontroldatas.add(specialControlData);
/*     */         }
/*     */       } }
/* 137 */     OnlineManager.getInstance().send(roleId, synLimitTimeActivityOpened);
/* 138 */     OnlineManager.getInstance().send(roleId, specialControlRes);
/*     */     
/*     */ 
/* 141 */     new mzm.gsp.util.LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception {
/* 144 */         xbean.ActivityCareMap xActivityCareMap = Role2activitycare.select(Long.valueOf(roleId));
/* 145 */         if (xActivityCareMap == null) {
/* 146 */           xActivityCareMap = Pod.newActivityCareMap();
/* 147 */           for (SActivityCfg sActivityCfg : SActivityCfg.getAll().values()) {
/* 148 */             xActivityCareMap.getActivitycaremap().put(Integer.valueOf(sActivityCfg.id), Integer.valueOf(0));
/*     */           }
/* 150 */           Role2activitycare.insert(Long.valueOf(roleId), xActivityCareMap);
/*     */         }
/* 152 */         return true;
/*     */       }
/*     */     }.call();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\ROnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */