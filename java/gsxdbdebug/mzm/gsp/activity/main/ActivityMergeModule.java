/*     */ package mzm.gsp.activity.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ActivityGlobalBean;
/*     */ import xbean.OpenBeanStore;
/*     */ import xbean.Pod;
/*     */ import xdb.Table;
/*     */ import xtable.Activity;
/*     */ import xtable.Role2activity;
/*     */ import xtable.Role2activitycare;
/*     */ import xtable.User2activity;
/*     */ 
/*     */ 
/*     */ public class ActivityMergeModule
/*     */   implements MergeModule
/*     */ {
/*  26 */   private static final Logger logger = Logger.getLogger(ActivityMergeModule.class);
/*     */   
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  30 */     List<Table> tables = new ArrayList();
/*     */     
/*  32 */     tables.add(Role2activity.getTable());
/*     */     
/*  34 */     tables.add(User2activity.getTable());
/*     */     
/*  36 */     tables.add(Role2activitycare.getTable());
/*     */     
/*  38 */     tables.add(Activity.getTable());
/*  39 */     return tables;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  46 */     final long viceZoneid = MergeMain.getViceZoneid();
/*  47 */     long mainZoneid = MergeMain.getMainZoneid();
/*  48 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/*  52 */         lock(Activity.getTable(), Arrays.asList(new Long[] { Long.valueOf(viceZoneid), Long.valueOf(this.val$mainZoneid) }));
/*     */         
/*  54 */         ActivityGlobalBean xViceActivityGlobalBean = Activity.get(Long.valueOf(viceZoneid));
/*  55 */         if (xViceActivityGlobalBean == null) {
/*  56 */           ActivityMergeModule.logger.info(String.format("[Merge]ActivityMergeModule.handleMerge@vice server donot has data", new Object[0]));
/*  57 */           return false;
/*     */         }
/*     */         
/*  60 */         ActivityGlobalBean xMainActivityGlobalBean = Activity.get(Long.valueOf(this.val$mainZoneid));
/*  61 */         if (xMainActivityGlobalBean == null) {
/*  62 */           ActivityMergeModule.logger.info(String.format("[Merge]ActivityMergeModule.handleMerge@main server donot has data", new Object[0]));
/*  63 */           xMainActivityGlobalBean = Pod.newActivityGlobalBean();
/*  64 */           Activity.insert(Long.valueOf(this.val$mainZoneid), xMainActivityGlobalBean);
/*     */         }
/*     */         
/*     */ 
/*  68 */         for (Map.Entry<Integer, OpenBeanStore> entry : xViceActivityGlobalBean.getActivityopenmap().entrySet())
/*     */         {
/*  70 */           int activityid = ((Integer)entry.getKey()).intValue();
/*  71 */           OpenBeanStore xViceOpenBeanStore = (OpenBeanStore)entry.getValue();
/*     */           
/*  73 */           OpenBeanStore xMainOpenBeanStore = (OpenBeanStore)xMainActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(activityid));
/*     */           
/*  75 */           if (xMainOpenBeanStore == null) {
/*  76 */             xMainActivityGlobalBean.getActivityopenmap().put(Integer.valueOf(activityid), xViceOpenBeanStore.toBean());
/*     */ 
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/*  83 */             SActivityCfg sActivityCfg = SActivityCfg.get(activityid);
/*  84 */             if (sActivityCfg == null) {
/*  85 */               ActivityMergeModule.logger.error(String.format("[Merge]ActivityMergeModule.handleMerge@策划删除了配置的活动,策划必须要确认是不是合服不处理这个活动没有问题|activityid=%d", new Object[] { Integer.valueOf(activityid) }));
/*     */ 
/*     */ 
/*     */             }
/*     */             else
/*     */             {
/*     */ 
/*  92 */               if (sActivityCfg.activityTimeIds.size() <= 0) {
/*  93 */                 doUseMinClearTime(xViceOpenBeanStore, xMainOpenBeanStore);
/*     */ 
/*     */               }
/*  96 */               else if (xViceOpenBeanStore.getEndtime() > xMainOpenBeanStore.getEndtime())
/*     */               {
/*  98 */                 doUseMinClearTime(xViceOpenBeanStore, xMainOpenBeanStore);
/*     */               } else {
/* 100 */                 long durationMill = ActivityManager.getActivityDuationMill(activityid);
/* 101 */                 if (durationMill <= 0L) {
/* 102 */                   throw new RuntimeException(String.format("[Merge]ActivityMergeModule.handleMerge@活动持续时间小于0,bug|activityid=%d|durationMil=%d", new Object[] { Integer.valueOf(activityid), Long.valueOf(durationMill) }));
/*     */                 }
/*     */                 
/*     */ 
/*     */ 
/*     */ 
/* 108 */                 long startTime = xMainOpenBeanStore.getEndtime() - durationMill;
/* 109 */                 if (xViceOpenBeanStore.getEndtime() > startTime) {
/* 110 */                   doUseMinClearTime(xViceOpenBeanStore, xMainOpenBeanStore);
/*     */                 }
/*     */               }
/*     */               
/*     */ 
/*     */ 
/*     */ 
/* 117 */               doHandleOpenState(activityid, xViceOpenBeanStore, xMainOpenBeanStore);
/*     */             }
/*     */           }
/*     */         }
/* 121 */         boolean ret = Activity.remove(Long.valueOf(viceZoneid));
/* 122 */         if (ret) {
/* 123 */           ActivityMergeModule.logger.info(String.format("[Merge]ActivityMergeModule.handleMerge@delete vice actvity data|viceZoneid=%d", new Object[] { Long.valueOf(viceZoneid) }));
/*     */         }
/*     */         
/*     */ 
/* 127 */         return true;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       private void doHandleOpenState(int activityid, OpenBeanStore xViceOpenBeanStore, OpenBeanStore xMainOpenBeanStore)
/*     */       {
/* 138 */         int viceOpenState = xViceOpenBeanStore.getOpenstate();
/* 139 */         if (ActivityManager.isForceCloseState(viceOpenState)) {
/* 140 */           xMainOpenBeanStore.setOpenstate(xMainOpenBeanStore.getOpenstate() | 0x4);
/*     */           
/* 142 */           ActivityMergeModule.logger.warn(String.format("[Merge]ActivityMergeModule.doHandleOpenState@actvity is in forceclose state|activityid=%d", new Object[] { Integer.valueOf(activityid) }));
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 148 */         if (ActivityManager.isActivityPauseState(viceOpenState)) {
/* 149 */           xMainOpenBeanStore.setOpenstate(xMainOpenBeanStore.getOpenstate() | 0x1);
/* 150 */           ActivityMergeModule.logger.warn(String.format("[Merge]ActivityMergeModule.doHandleOpenState@actvity is in pause state|activityid=%d", new Object[] { Integer.valueOf(activityid) }));
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       private void doUseMinClearTime(OpenBeanStore xViceOpenBeanStore, OpenBeanStore xMainOpenBeanStore)
/*     */       {
/* 158 */         long mainClearTime = xMainOpenBeanStore.getCleardatatime();
/* 159 */         long viceClearTime = xViceOpenBeanStore.getCleardatatime();
/* 160 */         if (mainClearTime > viceClearTime) {
/* 161 */           xMainOpenBeanStore.setCleardatatime(viceClearTime);
/*     */         }
/*     */       }
/* 164 */     }.call();
/* 165 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\ActivityMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */