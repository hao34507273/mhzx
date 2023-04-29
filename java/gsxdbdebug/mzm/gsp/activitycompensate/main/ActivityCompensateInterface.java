/*     */ package mzm.gsp.activitycompensate.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activitycompensate.confbean.SActivityCompensateCfg;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import xbean.ActivityCompensates;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ActivityCompensateInterface
/*     */ {
/*     */   public static void registerCompensateHandler(int activityLogicType, ActivityCompensateHandler handler)
/*     */   {
/*  27 */     Set<Integer> activityids = ActivityInterface.getActivityIdsByLogicType(activityLogicType);
/*  28 */     if ((activityids == null) || (activityids.isEmpty())) {
/*  29 */       throw new RuntimeException(String.format("ActivityCompensateInterface.registerCompensateHandler@invalid activity logic type|logic_type=%d|handler=%s", new Object[] { Integer.valueOf(activityLogicType), handler }));
/*     */     }
/*     */     
/*     */ 
/*  33 */     ActivityCompensateHandlerManager.getInstance().addHandler(activityLogicType, handler);
/*  34 */     for (Iterator i$ = activityids.iterator(); i$.hasNext();) { int activityid = ((Integer)i$.next()).intValue();
/*  35 */       if (SActivityCompensateCfg.get(activityid) != null)
/*     */       {
/*     */ 
/*  38 */         List<Integer> switchList = handler.getActivitySwitchList(activityid);
/*  39 */         if ((switchList != null) && (!switchList.isEmpty()))
/*     */         {
/*     */ 
/*  42 */           for (Iterator i$ = switchList.iterator(); i$.hasNext();) { int switchid = ((Integer)i$.next()).intValue();
/*  43 */             if (!OpenInterface.isModuleidValid(switchid)) {
/*  44 */               throw new RuntimeException(String.format("ActivityCompensateInterface.registerCompensateHandler@invalid switchid|logic_type=%d|activityid=%d|handler=%s|switchid=%d", new Object[] { Integer.valueOf(activityLogicType), Integer.valueOf(activityid), handler, Integer.valueOf(switchid) }));
/*     */             }
/*     */           }
/*     */           
/*     */ 
/*  49 */           ActivityCompensateHandlerManager.getInstance().registerActivitySwitches(activityid, switchList);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean hasCompensate(int activityid)
/*     */   {
/*  60 */     if (SActivityCompensateCfg.get(activityid) == null) {
/*  61 */       return false;
/*     */     }
/*  63 */     ActivityCompensateHandler handler = ActivityCompensateManager.getCompensateHandler(activityid);
/*  64 */     if (handler == null) {
/*  65 */       return false;
/*     */     }
/*  67 */     if (!ActivityCompensateManager.isActivitySwitchOpen(activityid)) {
/*  68 */       return false;
/*     */     }
/*  70 */     return true;
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
/*     */   public static void refreshCompensate(long roleid, int activityid, long earliestStartTime, int count, List<Long> completeTimeList)
/*     */   {
/*  83 */     if (!RoleStatusInterface.checkCanSetStatus(roleid, 2061, false))
/*     */     {
/*  85 */       return;
/*     */     }
/*     */     
/*  88 */     ActivityCompensates xCompensates = ActivityCompensateManager.createXActivityCompensatesIfNotExist(roleid);
/*  89 */     ActivityCompensateManager.refreshCompensate(roleid, xCompensates, activityid, earliestStartTime, count, completeTimeList);
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
/*     */ 
/*     */   public static long getEarliestCompensateTime(long roleid, int activityid, long nowMillis)
/*     */   {
/* 103 */     ActivityCompensates xCompensates = ActivityCompensateManager.getXActivityCompensates(roleid, true);
/* 104 */     return ActivityCompensateManager.getEarliestCompensateTime(xCompensates, activityid, nowMillis);
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
/*     */   public static long getLimitEarliestCompensateTime(long roleid, int activityid, long nowMillis)
/*     */   {
/* 117 */     ActivityCompensates xCompensates = ActivityCompensateManager.createXActivityCompensatesIfNotExist(roleid);
/* 118 */     return ActivityCompensateManager.getLimitEarliestCompensateTime(xCompensates, activityid, nowMillis);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitycompensate\main\ActivityCompensateInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */