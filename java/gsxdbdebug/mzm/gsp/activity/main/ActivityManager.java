/*      */ package mzm.gsp.activity.main;
/*      */ 
/*      */ import java.lang.reflect.Field;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.activity.ActivityData;
/*      */ import mzm.gsp.activity.SpecialControlData;
/*      */ import mzm.gsp.activity.SynActivityChangeRes;
/*      */ import mzm.gsp.activity.confbean.SActivityCfg;
/*      */ import mzm.gsp.activity.event.AddActivityCountArg;
/*      */ import mzm.gsp.activitycompensate.main.ActivityCompensateInterface;
/*      */ import mzm.gsp.common.TimeCommonUtil;
/*      */ import mzm.gsp.common.confbean.STimeCommonCfg;
/*      */ import mzm.gsp.common.confbean.STimeDurationCommonCfg;
/*      */ import mzm.gsp.common.confbean.STimeLimitCommonCfg;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.timer.main.Session;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.LogicProcedure;
/*      */ import mzm.gsp.util.LogicRunnable;
/*      */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.ActivityBean;
/*      */ import xbean.ActivityGlobalBean;
/*      */ import xbean.OpenBeanStore;
/*      */ import xbean.Pod;
/*      */ import xbean.StageBean;
/*      */ import xtable.Role2activity;
/*      */ import xtable.User2activity;
/*      */ 
/*      */ public class ActivityManager
/*      */ {
/*   43 */   static final Set<Integer> userModeActivities = new java.util.HashSet();
/*   44 */   static final Map<Integer, ActivityHandler> activityLogicTypeToActivityMap = new HashMap(32);
/*      */   
/*   46 */   static final Map<Integer, List<ActivityStage>> activityLogicTypeToActivityStageMap = new HashMap(32);
/*      */   
/*      */ 
/*      */ 
/*      */   static final int UPDATE_SECOND = 20;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean init()
/*      */   {
/*   57 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static void _initDateObeser()
/*      */   {
/*   64 */     for (SActivityCfg sActivityCfg : SActivityCfg.getAll().values()) {
/*   65 */       initDateObserver(sActivityCfg);
/*      */     }
/*      */   }
/*      */   
/*      */   static void initDateObserver(SActivityCfg sActivityCfg) {
/*   70 */     for (Iterator i$ = sActivityCfg.activityTimeIds.iterator(); i$.hasNext();) { int cfgTimeId = ((Integer)i$.next()).intValue();
/*   71 */       new ActivityObsever.ActivityDurationObserver(sActivityCfg.id, cfgTimeId);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static long getActivityEndTime(int activityid, ActivityGlobalBean xActivityGlobalBean)
/*      */   {
/*   82 */     if (xActivityGlobalBean == null) {
/*   83 */       return 0L;
/*      */     }
/*   85 */     OpenBeanStore xOpenBeanStore = (OpenBeanStore)xActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(activityid));
/*   86 */     if (xOpenBeanStore == null) {
/*   87 */       return 0L;
/*      */     }
/*   89 */     return xOpenBeanStore.getEndtime();
/*      */   }
/*      */   
/*      */   private static long getActivityClearDataTime(int activityid, ActivityGlobalBean xActivityGlobalBean) {
/*   93 */     if (xActivityGlobalBean == null) {
/*   94 */       return 0L;
/*      */     }
/*   96 */     OpenBeanStore xOpenBeanStore = (OpenBeanStore)xActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(activityid));
/*   97 */     if (xOpenBeanStore == null) {
/*   98 */       return 0L;
/*      */     }
/*  100 */     return xOpenBeanStore.getCleardatatime();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean checkAndInitActiviyData(String userid, long roleId, int activityId, ActivityBean xActivityBean, ActivityGlobalBean xActivityGlobalBean)
/*      */   {
/*  112 */     long cleartime = getActivityClearDataTime(activityId, xActivityGlobalBean);
/*      */     
/*  114 */     long storeEndTime = xActivityBean.getEndtime();
/*  115 */     if (storeEndTime < cleartime)
/*      */     {
/*  117 */       checkAndRefreshCompensate(roleId, activityId, xActivityBean.getEndtime(), xActivityBean.getCount());
/*      */       
/*  119 */       initActivityData(xActivityBean, userid, roleId, activityId);
/*      */     }
/*  121 */     return true;
/*      */   }
/*      */   
/*      */   static xbean.Activity getXActivity(String userid, long roleid, int activityid) {
/*  125 */     SActivityCfg activityCfg = SActivityCfg.get(activityid);
/*  126 */     if ((activityCfg != null) && (userModeActivities.contains(Integer.valueOf(activityCfg.activityLogicType)))) {
/*  127 */       return User2activity.get(userid);
/*      */     }
/*  129 */     return Role2activity.get(Long.valueOf(roleid));
/*      */   }
/*      */   
/*      */   static xbean.Activity createXActivityIfNotExist(String userid, long roleid, int activityid)
/*      */   {
/*  134 */     SActivityCfg activityCfg = SActivityCfg.get(activityid);
/*  135 */     if ((activityCfg != null) && (userModeActivities.contains(Integer.valueOf(activityCfg.activityLogicType)))) {
/*  136 */       xbean.Activity xActivity = User2activity.get(userid);
/*  137 */       if (xActivity == null) {
/*  138 */         xActivity = Pod.newActivity();
/*  139 */         User2activity.insert(userid, xActivity);
/*      */       }
/*  141 */       return xActivity;
/*      */     }
/*  143 */     xbean.Activity xActivity = Role2activity.get(Long.valueOf(roleid));
/*  144 */     if (xActivity == null) {
/*  145 */       xActivity = Pod.newActivity();
/*  146 */       Role2activity.insert(Long.valueOf(roleid), xActivity);
/*      */     }
/*  148 */     return xActivity;
/*      */   }
/*      */   
/*      */   static xbean.Activity selectXActivity(String userid, long roleid, int activityid)
/*      */   {
/*  153 */     SActivityCfg activityCfg = SActivityCfg.get(activityid);
/*  154 */     if ((activityCfg != null) && (userModeActivities.contains(Integer.valueOf(activityCfg.activityLogicType)))) {
/*  155 */       return User2activity.select(userid);
/*      */     }
/*  157 */     return Role2activity.select(Long.valueOf(roleid));
/*      */   }
/*      */   
/*      */   static void initActivityData(ActivityBean xActivityBean, String userid, long roleid, int activityid)
/*      */   {
/*  162 */     long storeEndClearTime = xActivityBean.getEndtime();
/*      */     
/*      */ 
/*  165 */     long curTime = DateTimeUtils.getCurrTimeInMillis() + 10000L;
/*      */     
/*  167 */     int turn = getFullTurnBetweenTime(storeEndClearTime, curTime, activityid);
/*      */     
/*  169 */     ActivityHandler activityHandler = getActivityHandler(activityid);
/*  170 */     if (activityHandler != null) {
/*  171 */       activityHandler.initData(userid, roleid, turn, activityid);
/*      */     }
/*  173 */     xActivityBean.setCount(0);
/*  174 */     xActivityBean.setRecommendrewarded(false);
/*  175 */     xActivityBean.setEndtime(curTime);
/*      */   }
/*      */   
/*      */   static ActivityHandler getActivityHandler(int activityid) {
/*  179 */     SActivityCfg activityCfg = SActivityCfg.get(activityid);
/*  180 */     if (activityCfg != null) {
/*  181 */       return (ActivityHandler)activityLogicTypeToActivityMap.get(Integer.valueOf(activityCfg.activityLogicType));
/*      */     }
/*  183 */     return null;
/*      */   }
/*      */   
/*      */   static int getLogicTypeByActivityId(int activityid) {
/*  187 */     SActivityCfg activityCfg = SActivityCfg.get(activityid);
/*  188 */     if (activityCfg == null) {
/*  189 */       return -1;
/*      */     }
/*  191 */     return activityCfg.activityLogicType;
/*      */   }
/*      */   
/*      */   static List<ActivityStage> getActivityStages(int activityid) {
/*  195 */     SActivityCfg activityCfg = SActivityCfg.get(activityid);
/*  196 */     if (activityCfg != null) {
/*  197 */       return (List)activityLogicTypeToActivityStageMap.get(Integer.valueOf(activityCfg.activityLogicType));
/*      */     }
/*  199 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isActivityDataValidate(String userid, long roleid, int activityid)
/*      */   {
/*  211 */     xbean.Activity xActivity = selectXActivity(userid, roleid, activityid);
/*  212 */     if ((xActivity == null) || (!xActivity.getActivitymap().containsKey(Integer.valueOf(activityid)))) {
/*  213 */       return false;
/*      */     }
/*  215 */     ActivityBean xActivityBean = (ActivityBean)xActivity.getActivitymap().get(Integer.valueOf(activityid));
/*  216 */     ActivityGlobalBean xActivityGlobalBean = xtable.Activity.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  217 */     long cleartime = getActivityClearDataTime(activityid, xActivityGlobalBean);
/*      */     
/*  219 */     long storeEndTime = xActivityBean.getEndtime();
/*  220 */     return storeEndTime >= cleartime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getBeforeStartTime(long curTime, int activityid)
/*      */   {
/*  231 */     SActivityCfg activityCfg = SActivityCfg.get(activityid);
/*  232 */     long beforeStartTime = -1L;
/*  233 */     Iterator i$; if (activityCfg.activityTimeIds.size() <= 0) {
/*  234 */       long limitBeginTime = TimeCommonUtil.getLimitTimeBegin(activityCfg.activityLimitTimeid);
/*  235 */       if (limitBeginTime <= curTime) {
/*  236 */         return limitBeginTime;
/*      */       }
/*      */     } else {
/*  239 */       for (i$ = activityCfg.activityTimeIds.iterator(); i$.hasNext();) { int durationCfgid = ((Integer)i$.next()).intValue();
/*  240 */         STimeDurationCommonCfg durationCommonCfg = STimeDurationCommonCfg.get(durationCfgid);
/*  241 */         long startTime = TimeCommonUtil.getBeforeStartTime(curTime, durationCommonCfg.timeCommonCfgId);
/*  242 */         if ((startTime <= curTime) && (startTime > beforeStartTime)) {
/*  243 */           beforeStartTime = startTime;
/*      */         }
/*      */       }
/*      */     }
/*  247 */     return beforeStartTime;
/*      */   }
/*      */   
/*      */   static void fillActivityData(int activityId, ActivityBean xActivityBean, ActivityData activityData) {
/*  251 */     activityData.actvityid = activityId;
/*  252 */     activityData.count = xActivityBean.getCount();
/*  253 */     if (xActivityBean.getRecommendrewarded()) {
/*  254 */       activityData.awarded = 1;
/*      */     } else {
/*  256 */       activityData.awarded = 0;
/*      */     }
/*  258 */     activityData.cleartime = (xActivityBean.getEndtime() / 1000L);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onActivityStart(int activityId, ActivityHandler.ActivityStartType activityStartType)
/*      */   {
/*  270 */     ActivityHandler activityHandler = getActivityHandler(activityId);
/*  271 */     if (activityHandler != null) {
/*  272 */       activityHandler.onActivityStart(activityStartType, activityId);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getNextStartTime(long curTime, int activityid)
/*      */   {
/*  284 */     SActivityCfg activityCfg = SActivityCfg.get(activityid);
/*  285 */     long nextStartTime = 0L;
/*  286 */     boolean circleActivity = activityCfg.activityTimeIds.size() > 0;
/*  287 */     if (activityCfg.activityLimitTimeid > 0) {
/*  288 */       long limitBeginTime = TimeCommonUtil.getLimitTimeBegin(activityCfg.activityLimitTimeid);
/*  289 */       if (curTime < limitBeginTime) {
/*  290 */         if (!circleActivity)
/*      */         {
/*  292 */           return limitBeginTime;
/*      */         }
/*  294 */         curTime = limitBeginTime;
/*      */       }
/*      */       
/*  297 */       long limitEndTime = TimeCommonUtil.getLimitTimeEnd(activityCfg.activityLimitTimeid);
/*  298 */       if (curTime >= limitEndTime) {
/*  299 */         return Long.MAX_VALUE;
/*      */       }
/*      */     }
/*      */     
/*  303 */     for (Iterator i$ = activityCfg.activityTimeIds.iterator(); i$.hasNext();) { int durationCfgid = ((Integer)i$.next()).intValue();
/*  304 */       STimeDurationCommonCfg durationCommonCfg = STimeDurationCommonCfg.get(durationCfgid);
/*  305 */       long startTime = TimeCommonUtil.getNextStartTime(curTime, durationCommonCfg.timeCommonCfgId);
/*  306 */       if (nextStartTime == 0L) {
/*  307 */         nextStartTime = startTime;
/*      */ 
/*      */       }
/*  310 */       else if ((startTime >= curTime) && (startTime < nextStartTime)) {
/*  311 */         nextStartTime = startTime;
/*      */       }
/*      */     }
/*  314 */     if (!inActivityLimitTime(nextStartTime, activityCfg)) {
/*  315 */       return Long.MAX_VALUE;
/*      */     }
/*  317 */     return nextStartTime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getLastStartTime(long curTime, int activityid, boolean canInDurationTime)
/*      */   {
/*  330 */     SActivityCfg activityCfg = SActivityCfg.get(activityid);
/*  331 */     long lastStartTime = 0L;
/*  332 */     if (activityCfg.activityTimeIds.isEmpty())
/*      */     {
/*  334 */       return Long.MIN_VALUE;
/*      */     }
/*      */     
/*  337 */     long limitBeginTime = -1L;
/*  338 */     long limitEndTime = -1L;
/*  339 */     if (activityCfg.activityLimitTimeid > 0) {
/*  340 */       limitBeginTime = TimeCommonUtil.getLimitTimeBegin(activityCfg.activityLimitTimeid);
/*  341 */       if (curTime < limitBeginTime) {
/*  342 */         return -1L;
/*      */       }
/*  344 */       limitEndTime = TimeCommonUtil.getLimitTimeEnd(activityCfg.activityLimitTimeid);
/*  345 */       if ((curTime <= limitEndTime) && (!canInDurationTime)) {
/*  346 */         return -2L;
/*      */       }
/*      */     }
/*      */     
/*  350 */     for (Iterator i$ = activityCfg.activityTimeIds.iterator(); i$.hasNext();) { int durationCfgid = ((Integer)i$.next()).intValue();
/*  351 */       long startTime = TimeCommonUtil.getLastStartTime(curTime, durationCfgid);
/*  352 */       if (((limitBeginTime <= 0L) || (startTime >= limitBeginTime)) && (
/*      */       
/*      */ 
/*  355 */         (limitEndTime <= 0L) || (startTime <= limitEndTime)))
/*      */       {
/*      */ 
/*  358 */         if (lastStartTime == 0L) {
/*  359 */           lastStartTime = startTime;
/*      */ 
/*      */         }
/*  362 */         else if (startTime > lastStartTime)
/*  363 */           lastStartTime = startTime;
/*      */       }
/*      */     }
/*  366 */     return lastStartTime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getFullTurnBetweenTime(long timeBegin, long timeEnd, int activityid)
/*      */   {
/*  381 */     if ((timeEnd <= timeBegin) || (timeBegin <= 0L)) {
/*  382 */       return 0;
/*      */     }
/*  384 */     SActivityCfg activityCfg = SActivityCfg.get(activityid);
/*  385 */     if (activityCfg == null) {
/*  386 */       return 0;
/*      */     }
/*  388 */     if (activityCfg.activityLimitTimeid > 0) {
/*  389 */       long limitTimeBegin = TimeCommonUtil.getLimitTimeBegin(activityCfg.activityLimitTimeid);
/*  390 */       long limitTimeEnd = TimeCommonUtil.getLimitTimeEnd(activityCfg.activityLimitTimeid);
/*  391 */       if (timeEnd <= limitTimeBegin) {
/*  392 */         return 0;
/*      */       }
/*  394 */       if (timeBegin >= limitTimeEnd) {
/*  395 */         return 0;
/*      */       }
/*  397 */       if (timeBegin <= limitTimeBegin) {
/*  398 */         timeBegin = limitTimeBegin;
/*      */       }
/*  400 */       if (timeEnd >= limitTimeEnd) {
/*  401 */         timeEnd = limitTimeEnd;
/*      */       }
/*  403 */       if (activityCfg.activityTimeIds.size() <= 0)
/*      */       {
/*  405 */         if ((timeBegin <= limitTimeBegin) && (timeEnd >= limitTimeEnd)) {
/*  406 */           return 1;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  411 */     int fullTurn = 0;
/*  412 */     for (Iterator i$ = activityCfg.activityTimeIds.iterator(); i$.hasNext();) { int durationCfgid = ((Integer)i$.next()).intValue();
/*  413 */       STimeDurationCommonCfg durationCommonCfg = STimeDurationCommonCfg.get(durationCfgid);
/*  414 */       fullTurn += TimeCommonUtil.getFullTurn(timeBegin, timeEnd, durationCommonCfg);
/*      */     }
/*  416 */     return fullTurn;
/*      */   }
/*      */   
/*      */   static int getFullTurnBetweenTime(long timeBegin, long timeEnd, int activityid, boolean inCludeBegin) {
/*  420 */     if ((timeEnd <= timeBegin) || (timeBegin <= 0L)) {
/*  421 */       return 0;
/*      */     }
/*  423 */     SActivityCfg activityCfg = SActivityCfg.get(activityid);
/*  424 */     if (activityCfg == null) {
/*  425 */       return 0;
/*      */     }
/*  427 */     if (activityCfg.activityLimitTimeid > 0) {
/*  428 */       long limitTimeBegin = TimeCommonUtil.getLimitTimeBegin(activityCfg.activityLimitTimeid);
/*  429 */       long limitTimeEnd = TimeCommonUtil.getLimitTimeEnd(activityCfg.activityLimitTimeid);
/*  430 */       if (timeEnd <= limitTimeBegin) {
/*  431 */         return 0;
/*      */       }
/*  433 */       if (timeBegin >= limitTimeEnd) {
/*  434 */         return 0;
/*      */       }
/*  436 */       if (timeBegin <= limitTimeBegin) {
/*  437 */         timeBegin = limitTimeBegin;
/*      */       }
/*  439 */       if (timeEnd >= limitTimeEnd) {
/*  440 */         timeEnd = limitTimeEnd;
/*      */       }
/*  442 */       if (activityCfg.activityTimeIds.size() <= 0)
/*      */       {
/*  444 */         if ((timeBegin <= limitTimeBegin) && (timeEnd >= limitTimeEnd)) {
/*  445 */           return 1;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  450 */     int fullTurn = 0;
/*  451 */     for (Iterator i$ = activityCfg.activityTimeIds.iterator(); i$.hasNext();) { int durationCfgid = ((Integer)i$.next()).intValue();
/*  452 */       STimeDurationCommonCfg durationCommonCfg = STimeDurationCommonCfg.get(durationCfgid);
/*  453 */       fullTurn += TimeCommonUtil.getFullTurn(timeBegin, timeEnd, durationCommonCfg, inCludeBegin);
/*      */     }
/*  455 */     return fullTurn;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean canJoinActivityToday(String userid, long roleid, int activityid)
/*      */   {
/*  467 */     int level = RoleInterface.getLevel(roleid);
/*  468 */     SActivityCfg activity = SActivityCfg.get(activityid);
/*  469 */     if (activity == null) {
/*  470 */       return false;
/*      */     }
/*  472 */     if ((level < activity.levelMin) || (level > activity.levelMax)) {
/*  473 */       return false;
/*      */     }
/*  475 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  476 */     long beginTime = DateTimeUtils.getBeginTimeOfCurrDay(curTime);
/*  477 */     long endTime = 86400000L + beginTime;
/*  478 */     long LimitTimeBegin = getActivityLimitTimeBegin(activityid);
/*  479 */     if ((LimitTimeBegin > 0L) && 
/*  480 */       (endTime <= LimitTimeBegin)) {
/*  481 */       return false;
/*      */     }
/*      */     
/*  484 */     long limitTimeEnd = getActivityLimitTimeEnd(activityid);
/*  485 */     if ((limitTimeEnd > 0L) && 
/*  486 */       (beginTime >= limitTimeEnd)) {
/*  487 */       return false;
/*      */     }
/*      */     
/*  490 */     if (activity.activityTimeIds.size() <= 0)
/*      */     {
/*  492 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  496 */     STimeDurationCommonCfg durationCommonCfg = STimeDurationCommonCfg.get(((Integer)activity.activityTimeIds.get(0)).intValue());
/*  497 */     if (durationCommonCfg == null) {
/*  498 */       return false;
/*      */     }
/*  500 */     STimeCommonCfg timeCommonCfg = STimeCommonCfg.get(durationCommonCfg.timeCommonCfgId);
/*  501 */     if (timeCommonCfg == null) {
/*  502 */       return false;
/*      */     }
/*  504 */     if (TimeCommonUtil.isDayCircle(timeCommonCfg)) {
/*  505 */       return true;
/*      */     }
/*  507 */     if (TimeCommonUtil.isHourCircle(timeCommonCfg)) {
/*  508 */       return true;
/*      */     }
/*      */     
/*  511 */     if (ActivityInterface.isActivityOpen(activityid)) {
/*  512 */       return true;
/*      */     }
/*      */     
/*  515 */     long nextStartTime = getNextStartTime(curTime, activityid);
/*  516 */     if (nextStartTime < endTime) {
/*  517 */       return true;
/*      */     }
/*  519 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean checkAndinitData(int activityId, String userid, long roleId, xbean.Activity xActivity, ActivityGlobalBean xActivityGlobalBean)
/*      */   {
/*  535 */     long endTime = getActivityEndTime(activityId, xActivityGlobalBean);
/*  536 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  537 */     if (endTime < curTime) {
/*  538 */       return false;
/*      */     }
/*  540 */     ActivityBean xActivityBean = (ActivityBean)xActivity.getActivitymap().get(Integer.valueOf(activityId));
/*  541 */     if (xActivityBean == null) {
/*  542 */       xActivityBean = Pod.newActivityBean();
/*  543 */       xActivityBean.setEndtime(curTime + 10000L);
/*  544 */       xActivity.getActivitymap().put(Integer.valueOf(activityId), xActivityBean);
/*      */       
/*  546 */       checkAndRefreshCompensate(roleId, activityId, -1L, xActivityBean.getCount());
/*  547 */       initActivityData(xActivityBean, userid, roleId, activityId);
/*  548 */       return true;
/*      */     }
/*  550 */     return checkAndInitActiviyData(userid, roleId, activityId, xActivityBean, xActivityGlobalBean);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void PGM_clearActivityData(int activityId, String userid, long roleId, xbean.Activity xActivity)
/*      */   {
/*  563 */     if (xActivity == null) {
/*  564 */       return;
/*      */     }
/*  566 */     ActivityBean xActivityBean = (ActivityBean)xActivity.getActivitymap().get(Integer.valueOf(activityId));
/*  567 */     if (xActivityBean == null) {
/*  568 */       return;
/*      */     }
/*      */     
/*  571 */     checkAndRefreshCompensate(roleId, activityId, xActivityBean.getEndtime(), xActivityBean.getCount());
/*  572 */     initActivityData(xActivityBean, userid, roleId, activityId);
/*  573 */     SynActivityChangeRes activityChangeRes = new SynActivityChangeRes();
/*  574 */     fillActivityData(activityId, xActivityBean, activityChangeRes.activityinfo);
/*  575 */     OnlineManager.getInstance().send(roleId, activityChangeRes);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean setActivityDataForGM(String userid, long roleId, int activityId, int count)
/*      */   {
/*  587 */     if (count < 0) {
/*  588 */       return false;
/*      */     }
/*      */     
/*  591 */     SActivityCfg activityCfg = SActivityCfg.get(activityId);
/*  592 */     if (activityCfg == null) {
/*  593 */       return false;
/*      */     }
/*      */     
/*  596 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  597 */     xbean.Activity xActivity = createXActivityIfNotExist(userid, roleId, activityId);
/*  598 */     ActivityBean xActivityBean = (ActivityBean)xActivity.getActivitymap().get(Integer.valueOf(activityId));
/*  599 */     long storeEndTime = -1L;
/*  600 */     if (xActivityBean == null) {
/*  601 */       xActivityBean = Pod.newActivityBean();
/*  602 */       xActivity.getActivitymap().put(Integer.valueOf(activityId), xActivityBean);
/*  603 */       xActivityBean.setCount(0);
/*  604 */       xActivityBean.setRecommendrewarded(false);
/*      */     }
/*      */     else {
/*  607 */       storeEndTime = xActivityBean.getEndtime();
/*      */     }
/*      */     
/*  610 */     checkAndRefreshCompensate(roleId, activityId, storeEndTime, xActivityBean.getCount());
/*      */     
/*  612 */     xActivityBean.setCount(count);
/*  613 */     xActivityBean.setEndtime(curTime + 10000L);
/*      */     
/*      */ 
/*  616 */     SynActivityChangeRes activityChangeRes = new SynActivityChangeRes();
/*  617 */     fillActivityData(activityId, xActivityBean, activityChangeRes.activityinfo);
/*  618 */     OnlineManager.getInstance().send(roleId, activityChangeRes);
/*      */     
/*  620 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isInActivityLevel(String userid, long roleId, int activityId)
/*      */   {
/*  632 */     int level = RoleInterface.getLevel(roleId);
/*  633 */     return isInActivityLevelByLevel(activityId, level);
/*      */   }
/*      */   
/*      */   static boolean isInActivityLevelByLevel(int activityId, int level) {
/*  637 */     SActivityCfg activityCfg = SActivityCfg.get(activityId);
/*  638 */     if (activityCfg == null) {
/*  639 */       GameServer.logger().info("活动的配置数据不存在了,activityid:" + activityId);
/*  640 */       return false;
/*      */     }
/*  642 */     if ((level >= activityCfg.levelMin) && (level <= activityCfg.levelMax)) {
/*  643 */       return true;
/*      */     }
/*  645 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onActivityEnd(int activityId)
/*      */   {
/*  656 */     ActivityGlobalBean xSelectActivityGlobalBean = xtable.Activity.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  657 */     if (xSelectActivityGlobalBean == null) {
/*  658 */       return;
/*      */     }
/*      */     
/*  661 */     OpenBeanStore xSelectOpenBeanStore = (OpenBeanStore)xSelectActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(activityId));
/*  662 */     if (xSelectOpenBeanStore == null) {
/*  663 */       return;
/*      */     }
/*      */     
/*  666 */     int stage = xSelectOpenBeanStore.getStage();
/*  667 */     if (stage == Integer.MAX_VALUE) {
/*  668 */       GameServer.logger().info("活动之前已经关闭了,activityid:" + activityId);
/*  669 */       return;
/*      */     }
/*      */     
/*  672 */     List<ActivityStage> stages = getActivityStages(activityId);
/*  673 */     if (stages != null) {
/*  674 */       int size = stages.size();
/*  675 */       if (size > 0) {
/*  676 */         ActivityStage activityStage = (ActivityStage)stages.get(size - 1);
/*  677 */         int endStage = activityStage.stage;
/*  678 */         long startTime = xSelectOpenBeanStore.getEndtime() - getActivityDuationMill(activityId);
/*  679 */         for (int i = stage + 1; i <= endStage; i++)
/*      */         {
/*  681 */           if (i < 0) {
/*  682 */             ActivityStage tempStage = getActivityStage(activityId, i);
/*  683 */             if (tempStage != null)
/*      */             {
/*  685 */               new BeforeActivityStartStageProcedure(activityId, i, startTime - tempStage.minute * 60000).call();
/*      */             }
/*      */             
/*      */           }
/*  689 */           else if (i == 0) {
/*  690 */             new ActivityStartProcedure(activityId, startTime, false).call();
/*  691 */           } else if (i > 0)
/*      */           {
/*  693 */             new ActivityStageProcedure(activityId, i, false).call();
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  700 */     new LogicProcedure()
/*      */     {
/*      */       protected boolean processImp() throws Exception
/*      */       {
/*  704 */         ActivityHandler activityHandler = ActivityManager.getActivityHandler(this.val$activityId);
/*  705 */         if (activityHandler != null) {
/*  706 */           activityHandler.onActivityEnd(this.val$activityId);
/*      */         }
/*      */         
/*      */ 
/*  710 */         ActivityGlobalBean xActivityGlobalBean = xtable.Activity.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  711 */         OpenBeanStore xOpenBeanStore = (OpenBeanStore)xActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(this.val$activityId));
/*  712 */         xOpenBeanStore.setStage(Integer.MAX_VALUE);
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  726 */         ActivityManager.initActvityBeforeStartSession(this.val$activityId);
/*  727 */         return true;
/*      */       }
/*      */     }.call();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean addActivityCount(String userid, long roleId, int activityId, int count)
/*      */   {
/*  743 */     ActivityGlobalBean xActivityGlobalBean = xtable.Activity.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  744 */     OpenBeanStore xOpenBeanStore = (OpenBeanStore)xActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(activityId));
/*  745 */     if (xOpenBeanStore == null) {
/*  746 */       return false;
/*      */     }
/*  748 */     int openState = xOpenBeanStore.getOpenstate();
/*  749 */     if (isActivityPauseState(openState)) {
/*  750 */       return false;
/*      */     }
/*  752 */     if (isForceCloseState(openState)) {
/*  753 */       return false;
/*      */     }
/*  755 */     long endTime = getActivityEndTime(activityId, xActivityGlobalBean);
/*  756 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  757 */     if (endTime > curTime) {
/*  758 */       xbean.Activity xActivity = createXActivityIfNotExist(userid, roleId, activityId);
/*  759 */       ActivityBean xActivityBean = (ActivityBean)xActivity.getActivitymap().get(Integer.valueOf(activityId));
/*  760 */       if (xActivityBean == null) {
/*  761 */         xActivityBean = Pod.newActivityBean();
/*  762 */         xActivity.getActivitymap().put(Integer.valueOf(activityId), xActivityBean);
/*  763 */         xActivityBean.setCount(0);
/*  764 */         xActivityBean.setRecommendrewarded(false);
/*      */         
/*      */ 
/*  767 */         checkAndRefreshCompensate(roleId, activityId, -1L, xActivityBean.getCount());
/*      */         
/*  769 */         xActivityBean.setEndtime(curTime + 10000L);
/*      */       }
/*      */       
/*  772 */       SActivityCfg activityCfg = SActivityCfg.get(activityId);
/*  773 */       if (activityCfg == null) {
/*  774 */         return false;
/*      */       }
/*  776 */       xActivityBean.setCount(xActivityBean.getCount() + count);
/*      */       
/*  778 */       SynActivityChangeRes activityChangeRes = new SynActivityChangeRes();
/*  779 */       fillActivityData(activityId, xActivityBean, activityChangeRes.activityinfo);
/*  780 */       OnlineManager.getInstance().send(roleId, activityChangeRes);
/*      */       
/*      */ 
/*  783 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.activity.event.AddActivityCountEvent(), new AddActivityCountArg(roleId, activityId, xActivityBean.getCount(), count));
/*      */       
/*      */ 
/*  786 */       return true;
/*      */     }
/*      */     
/*  789 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isToMaxCount(String userid, long roleId, int activityId, boolean retainRoleLock)
/*      */   {
/*  802 */     xbean.Activity xActivity = null;
/*  803 */     if (retainRoleLock) {
/*  804 */       xActivity = getXActivity(userid, roleId, activityId);
/*      */     } else {
/*  806 */       xActivity = selectXActivity(userid, roleId, activityId);
/*      */     }
/*  808 */     if (xActivity == null) {
/*  809 */       return false;
/*      */     }
/*  811 */     ActivityGlobalBean xActivityGlobalBean = xtable.Activity.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  812 */     long endTime = getActivityEndTime(activityId, xActivityGlobalBean);
/*  813 */     if (endTime > DateTimeUtils.getCurrTimeInMillis()) {
/*  814 */       SActivityCfg sActivityCfg = SActivityCfg.get(activityId);
/*  815 */       if (sActivityCfg.count <= 0) {
/*  816 */         return false;
/*      */       }
/*  818 */       if (xActivity.getActivitymap().containsKey(Integer.valueOf(activityId))) {
/*  819 */         ActivityBean xActivityBean = (ActivityBean)xActivity.getActivitymap().get(Integer.valueOf(activityId));
/*  820 */         return xActivityBean.getCount() >= sActivityCfg.count;
/*      */       }
/*  822 */       return false;
/*      */     }
/*      */     
/*  825 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isActivityOpen(int activityId)
/*      */   {
/*  836 */     ActivityGlobalBean xActivityGlobalBean = xtable.Activity.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  837 */     if (xActivityGlobalBean == null) {
/*  838 */       return false;
/*      */     }
/*  840 */     OpenBeanStore xOpenBeanStore = (OpenBeanStore)xActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(activityId));
/*  841 */     if (xOpenBeanStore == null) {
/*  842 */       return false;
/*      */     }
/*  844 */     int openState = xOpenBeanStore.getOpenstate();
/*  845 */     if (isForceCloseState(openState)) {
/*  846 */       return false;
/*      */     }
/*  848 */     return getActivityEndTime(activityId, xActivityGlobalBean) > DateTimeUtils.getCurrTimeInMillis();
/*      */   }
/*      */   
/*      */   static boolean isForceCloseState(int openState) {
/*  852 */     return (openState & 0x4) > 0;
/*      */   }
/*      */   
/*      */   static boolean isActivityPauseState(int openState) {
/*  856 */     return (openState & 0x1) > 0;
/*      */   }
/*      */   
/*      */   static boolean isForceOpenState(int openState) {
/*  860 */     return (openState & 0x2) > 0;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isPersonCountOK(int personCount, int activityId)
/*      */   {
/*  871 */     SActivityCfg activityCfg = SActivityCfg.get(activityId);
/*  872 */     if ((activityCfg.personMin <= personCount) && (activityCfg.personMax >= personCount)) {
/*  873 */       return true;
/*      */     }
/*  875 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getActivityCount(String userid, long roleId, int activityId, boolean retainRoleLock)
/*      */   {
/*  887 */     ActivityGlobalBean xActivityGlobalBean = xtable.Activity.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  888 */     long endTime = getActivityEndTime(activityId, xActivityGlobalBean);
/*  889 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  890 */     if (endTime > curTime) {
/*  891 */       xbean.Activity xActivity = null;
/*  892 */       if (retainRoleLock) {
/*  893 */         xActivity = getXActivity(userid, roleId, activityId);
/*      */       } else {
/*  895 */         xActivity = selectXActivity(userid, roleId, activityId);
/*      */       }
/*  897 */       if (xActivity == null) {
/*  898 */         return 0;
/*      */       }
/*  900 */       if (xActivity.getActivitymap().containsKey(Integer.valueOf(activityId))) {
/*  901 */         ActivityBean xActivityBean = (ActivityBean)xActivity.getActivitymap().get(Integer.valueOf(activityId));
/*      */         
/*  903 */         long clearTime = getActivityClearDataTime(activityId, xActivityGlobalBean);
/*  904 */         if ((clearTime > 0L) && (xActivityBean.getEndtime() >= clearTime)) {
/*  905 */           return xActivityBean.getCount();
/*      */         }
/*  907 */         return 0;
/*      */       }
/*      */       
/*  910 */       return 0;
/*      */     }
/*      */     
/*  913 */     return -1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean takeRecommendAward(String userId, long roleId, int activityId, xbean.Activity xActivity)
/*      */   {
/*  924 */     SActivityCfg sActivityCfg = SActivityCfg.get(activityId);
/*  925 */     if (sActivityCfg.recommendCount > 0) {
/*  926 */       if (xActivity == null) {
/*  927 */         return false;
/*      */       }
/*  929 */       if (xActivity.getActivitymap().containsKey(Integer.valueOf(activityId))) {
/*  930 */         ActivityBean xActivityBean = (ActivityBean)xActivity.getActivitymap().get(Integer.valueOf(activityId));
/*  931 */         if ((!xActivityBean.getRecommendrewarded()) && (xActivityBean.getCount() >= sActivityCfg.recommendCount))
/*      */         {
/*  933 */           boolean send = false;
/*  934 */           ActivityHandler activityHandler = getActivityHandler(activityId);
/*  935 */           if (activityHandler != null) {
/*  936 */             send = mzm.gsp.award.main.AwardInterface.awardFixAward(sActivityCfg.recommendAwardId, userId, roleId, true, true, activityHandler.getRecommendAwardReason()) != null;
/*      */           }
/*      */           
/*  939 */           if (!send) {
/*  940 */             return false;
/*      */           }
/*      */           
/*  943 */           xActivityBean.setRecommendrewarded(true);
/*  944 */           SynActivityChangeRes activityChangeRes = new SynActivityChangeRes();
/*  945 */           fillActivityData(activityId, xActivityBean, activityChangeRes.activityinfo);
/*  946 */           OnlineManager.getInstance().send(roleId, activityChangeRes);
/*  947 */           return true;
/*      */         }
/*      */       }
/*      */     }
/*  951 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void postInit()
/*      */   {
/*  958 */     registerActivityByLogicType(33, EmptyActivityHandler.instance, false);
/*  959 */     registerActivityByLogicType(41, EmptyActivityHandler.instance, false);
/*  960 */     registerActivityByLogicType(111, EmptyActivityHandler.instance, false);
/*      */     try
/*      */     {
/*  963 */       Field[] fields = mzm.gsp.activity.confbean.ActivityLogicType.class.getFields();
/*  964 */       for (Field field : fields) {
/*  965 */         int activityLogicType = field.getInt(null);
/*  966 */         if (!activityLogicTypeToActivityMap.containsKey(Integer.valueOf(activityLogicType))) {
/*  967 */           throw new RuntimeException(String.format("[activity]ActivityManager.postInit@not register activity handler of the logic type(%s)|activity_logic_type=%d", new Object[] { field.getName(), Integer.valueOf(activityLogicType) }));
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  974 */       throw new RuntimeException(e);
/*      */     }
/*      */     
/*  977 */     _initDateObeser();
/*      */     
/*  979 */     Map<Integer, Long> openActivityidToTime = new HashMap();
/*  980 */     final long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  981 */     for (SActivityCfg sActivityCfg : SActivityCfg.getAll().values())
/*      */     {
/*  983 */       initLimitTimeSession(sActivityCfg);
/*  984 */       if (sActivityCfg.restartOpen)
/*      */       {
/*      */ 
/*  987 */         initOpenTime(openActivityidToTime, curTime, sActivityCfg);
/*      */       }
/*      */     }
/*  990 */     List<Integer> conflictEActivityIds = new ArrayList();
/*      */     
/*      */ 
/*  993 */     new LogicProcedure()
/*      */     {
/*      */       protected boolean processImp() throws Exception
/*      */       {
/*  997 */         ActivityGlobalBean xActivityGlobalBean = xtable.Activity.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  998 */         if (xActivityGlobalBean != null) {
/*  999 */           Iterator<Map.Entry<Integer, OpenBeanStore>> iterator = xActivityGlobalBean.getActivityopenmap().entrySet().iterator();
/*      */           
/* 1001 */           while (iterator.hasNext()) {
/* 1002 */             Map.Entry<Integer, OpenBeanStore> entry = (Map.Entry)iterator.next();
/* 1003 */             int activityid = ((Integer)entry.getKey()).intValue();
/* 1004 */             OpenBeanStore xOpenBeanStore = (OpenBeanStore)entry.getValue();
/* 1005 */             if (!this.val$openActivityidToTime.containsKey(Integer.valueOf(activityid))) {
/* 1006 */               long endTime = xOpenBeanStore.getEndtime();
/* 1007 */               if (endTime > curTime) {
/* 1008 */                 if (ActivityManager.isForceOpenState(xOpenBeanStore.getOpenstate())) {
/* 1009 */                   long startTime = endTime - ActivityManager.getActivityDuationMill(activityid);
/* 1010 */                   this.val$openActivityidToTime.put(Integer.valueOf(activityid), Long.valueOf(startTime));
/*      */                 }
/*      */                 else {
/* 1013 */                   GameServer.logger().info("配置时间没开启， 但是结束时间是在开启中,冲突,结束活动:" + activityid);
/* 1014 */                   xOpenBeanStore.setEndtime(curTime - 2000L);
/* 1015 */                   this.val$conflictEActivityIds.add(Integer.valueOf(activityid));
/*      */                 }
/*      */               }
/*      */             }
/* 1019 */             else if (ActivityManager.isForceOpenState(xOpenBeanStore.getOpenstate())) {
/* 1020 */               long endTime = xOpenBeanStore.getEndtime();
/* 1021 */               if (endTime > curTime) {
/* 1022 */                 long startTime = endTime - ActivityManager.getActivityDuationMill(activityid);
/* 1023 */                 this.val$openActivityidToTime.put(Integer.valueOf(activityid), Long.valueOf(startTime));
/*      */               } else {
/* 1025 */                 Long startTime = (Long)this.val$openActivityidToTime.get(Integer.valueOf(activityid));
/* 1026 */                 if ((startTime != null) && 
/* 1027 */                   (startTime.longValue() < xOpenBeanStore.getEndtime()))
/*      */                 {
/* 1029 */                   this.val$openActivityidToTime.remove(Integer.valueOf(activityid));
/*      */                 }
/*      */               }
/*      */             }
/*      */             
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1038 */             xOpenBeanStore.setStage(Integer.MAX_VALUE);
/*      */           }
/*      */         }
/* 1041 */         return true;
/*      */       }
/*      */     }.call();
/*      */     
/*      */ 
/* 1046 */     for (Iterator i$ = conflictEActivityIds.iterator(); i$.hasNext();) { int activityid = ((Integer)i$.next()).intValue();
/* 1047 */       onActivityEnd(activityid);
/*      */     }
/*      */     
/*      */ 
/* 1051 */     for (Iterator i$ = SActivityCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityid = ((Integer)i$.next()).intValue();
/* 1052 */       if (!openActivityidToTime.containsKey(Integer.valueOf(activityid)))
/*      */       {
/*      */ 
/* 1055 */         initActvityBeforeStartSession(activityid);
/*      */       }
/*      */     }
/* 1058 */     initOpenActivity(openActivityidToTime, curTime);
/*      */     
/* 1060 */     new ActivityUpdateObserver(20L);
/*      */   }
/*      */   
/*      */   static void initOpenActivity(Map<Integer, Long> openActivityidToTime, long curTime)
/*      */   {
/* 1065 */     for (Map.Entry<Integer, Long> entry : openActivityidToTime.entrySet()) {
/* 1066 */       activityid = ((Integer)entry.getKey()).intValue();
/* 1067 */       startTime = ((Long)entry.getValue()).longValue();
/* 1068 */       List<ActivityStage> stages = getActivityStages(activityid);
/* 1069 */       if (stages != null) {
/* 1070 */         for (ActivityStage stage : stages) {
/* 1071 */           if (stage.stage >= 0) break;
/* 1072 */           long triggerTime = startTime - stage.minute * 60 * 1000;
/* 1073 */           NoneRealTimeTaskManager.getInstance().addTask(new BeforeActivityStartStageProcedure(activityid, stage.stage, triggerTime));
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */     int activityid;
/*      */     
/*      */     long startTime;
/*      */     
/* 1083 */     for (Map.Entry<Integer, Long> entry : openActivityidToTime.entrySet()) {
/* 1084 */       int activityid = ((Integer)entry.getKey()).intValue();
/* 1085 */       long startTime = ((Long)entry.getValue()).longValue();
/* 1086 */       NoneRealTimeTaskManager.getInstance().addTask(new ActivityStartProcedure(activityid, startTime));
/*      */       
/* 1088 */       long minute = getActivityDurationMinute(activityid);
/* 1089 */       long endTime = startTime + minute * 60L * 1000L;
/* 1090 */       long interval = (endTime - curTime) / 1000L;
/* 1091 */       new CloseSession(interval, activityid);
/*      */     }
/*      */   }
/*      */   
/*      */   public static class CloseSession extends Session
/*      */   {
/*      */     public CloseSession(long interval, long activityid) {
/* 1098 */       super(activityid);
/*      */     }
/*      */     
/*      */     protected void onTimeOut()
/*      */     {
/* 1103 */       NoneRealTimeTaskManager.getInstance().addTask(new LogicRunnable()
/*      */       {
/*      */         public void process() throws Exception
/*      */         {
/* 1107 */           int activityid = (int)ActivityManager.CloseSession.this.getOwerId();
/* 1108 */           long activityEndTime = ActivityInterface.getActivityEndTime(activityid);
/* 1109 */           long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 1110 */           long intervalTime = Math.abs(curTime - activityEndTime);
/* 1111 */           if ((curTime < activityEndTime) && (intervalTime > 60000L)) {
/* 1112 */             GameServer.logger().info("活动已经在开启了,不执行关闭!!!activityid:" + activityid);
/* 1113 */             return;
/*      */           }
/* 1115 */           ActivityManager.onActivityEnd(activityid);
/*      */         }
/*      */       });
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void initOpenTime(Map<Integer, Long> openActivityidToTime, long curTime, SActivityCfg sActivityCfg)
/*      */   {
/* 1125 */     if (!inActivityLimitTime(curTime, sActivityCfg))
/*      */       return;
/*      */     Iterator i$;
/* 1128 */     if (sActivityCfg.activityTimeIds.size() <= 0) {
/* 1129 */       STimeLimitCommonCfg timeLimitCommonCfg = STimeLimitCommonCfg.get(sActivityCfg.activityLimitTimeid);
/* 1130 */       if (timeLimitCommonCfg == null) {
/* 1131 */         throw new RuntimeException(String.format("[Activity]ActivityManager.initOpenTime@活动不能既没有限制时间也没有周期时间|activityid=%d", new Object[] { Integer.valueOf(sActivityCfg.id) }));
/*      */       }
/*      */       
/* 1134 */       long beginTime = getActivityLimitTimeBegin(sActivityCfg.id);
/* 1135 */       if (beginTime <= 0L)
/*      */       {
/* 1137 */         beginTime = curTime;
/*      */       }
/* 1139 */       openActivityidToTime.put(Integer.valueOf(sActivityCfg.id), Long.valueOf(beginTime));
/*      */     } else {
/* 1141 */       for (i$ = sActivityCfg.activityTimeIds.iterator(); i$.hasNext();) { int activityTimeCfgId = ((Integer)i$.next()).intValue();
/* 1142 */         int activityDuratiomCfgId = activityTimeCfgId;
/* 1143 */         long trueStartTime = 0L;
/* 1144 */         STimeDurationCommonCfg durationCommonCfg = STimeDurationCommonCfg.get(activityDuratiomCfgId);
/* 1145 */         STimeCommonCfg commonCfg = STimeCommonCfg.get(durationCommonCfg.timeCommonCfgId);
/* 1146 */         long beforeStartTime = TimeCommonUtil.getBeforeStartTime(curTime, commonCfg.id);
/*      */         
/* 1148 */         if ((curTime >= beforeStartTime) && (curTime <= beforeStartTime + TimeUnit.MINUTES.toMillis(TimeCommonUtil.getDurationMinute(durationCommonCfg)) - 5000L))
/*      */         {
/*      */ 
/* 1151 */           trueStartTime = beforeStartTime;
/*      */         }
/* 1153 */         if (trueStartTime > 0L) {
/* 1154 */           int activityid = sActivityCfg.id;
/* 1155 */           openActivityidToTime.put(Integer.valueOf(sActivityCfg.id), Long.valueOf(trueStartTime));
/* 1156 */           ActivityHandler activityHandler = getActivityHandler(activityid);
/* 1157 */           if (activityHandler == null) {
/* 1158 */             GameServer.logger().warn("活动" + activityid + "没有注册活动触发器!! 不关心活动开启和结束行为!!");
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   static void initLimitTimeSession(SActivityCfg activityCfg) {
/* 1166 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 1167 */     long limitTimeBegin = getActivityLimitTimeBegin(activityCfg.id);
/* 1168 */     long limitTimeEnd = getActivityLimitTimeEnd(activityCfg.id);
/* 1169 */     if ((limitTimeBegin > 0L) && (limitTimeBegin > curTime)) {
/* 1170 */       new ActivityLimitBeginSession(Math.ceil((limitTimeBegin - curTime) * 1.0D / 1000.0D), activityCfg.id, limitTimeBegin);
/*      */     }
/*      */     
/* 1173 */     if ((limitTimeEnd > 0L) && (limitTimeEnd > curTime)) {
/* 1174 */       new ActivityLimitEndSession(Math.ceil((limitTimeEnd - curTime) * 1.0D / 1000.0D), activityCfg.id, limitTimeEnd);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void initActvityBeforeStartSession(int activityid)
/*      */   {
/* 1185 */     ActivityHandler activityHandler = getActivityHandler(activityid);
/* 1186 */     if (activityHandler == null) {
/* 1187 */       return;
/*      */     }
/* 1189 */     List<ActivityStage> stagets = getActivityStages(activityid);
/* 1190 */     if ((stagets == null) || (stagets.size() <= 0)) {
/* 1191 */       return;
/*      */     }
/* 1193 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*      */     
/* 1195 */     long nextStartTime = getNextStartTime(curTime, activityid);
/* 1196 */     if (!inActivityLimitTime(nextStartTime, SActivityCfg.get(activityid))) {
/* 1197 */       return;
/*      */     }
/* 1199 */     for (ActivityStage stage : stagets) {
/* 1200 */       if (stage.stage >= 0) break;
/* 1201 */       long triggerTime = nextStartTime - stage.minute * 60 * 1000;
/* 1202 */       long interval = (triggerTime - curTime) / 1000L + 1L;
/* 1203 */       interval = Math.max(interval, 1L);
/* 1204 */       new BeforeActivityStartStageSession(activityid, stage.stage, triggerTime, interval);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean inActivityLimitTime(long curTime, SActivityCfg activityCfg)
/*      */   {
/* 1220 */     long LimitTimeBegin = getActivityLimitTimeBegin(activityCfg.id);
/* 1221 */     if ((LimitTimeBegin > 0L) && 
/* 1222 */       (curTime < LimitTimeBegin)) {
/* 1223 */       return false;
/*      */     }
/*      */     
/* 1226 */     long limitTimeEnd = getActivityLimitTimeEnd(activityCfg.id);
/* 1227 */     if ((limitTimeEnd > 0L) && 
/* 1228 */       (curTime >= limitTimeEnd)) {
/* 1229 */       return false;
/*      */     }
/*      */     
/* 1232 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected static long getActivityLimitTimeBegin(int activityid)
/*      */   {
/* 1242 */     SActivityCfg sActivityCfg = SActivityCfg.get(activityid);
/* 1243 */     if (sActivityCfg == null) {
/* 1244 */       return -1L;
/*      */     }
/* 1246 */     if (sActivityCfg.activityLimitTimeid <= 0) {
/* 1247 */       return -1L;
/*      */     }
/* 1249 */     return TimeCommonUtil.getLimitTimeBegin(sActivityCfg.activityLimitTimeid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected static long getActivityLimitTimeEnd(int activityid)
/*      */   {
/* 1259 */     SActivityCfg sActivityCfg = SActivityCfg.get(activityid);
/* 1260 */     if (sActivityCfg == null) {
/* 1261 */       return -1L;
/*      */     }
/* 1263 */     if (sActivityCfg.activityLimitTimeid <= 0) {
/* 1264 */       return -1L;
/*      */     }
/* 1266 */     return TimeCommonUtil.getLimitTimeEnd(sActivityCfg.activityLimitTimeid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getActivityDurationMinute(int activityid)
/*      */   {
/* 1276 */     SActivityCfg sActivityCfg = SActivityCfg.get(activityid);
/* 1277 */     if (sActivityCfg == null) {
/* 1278 */       return -1L;
/*      */     }
/* 1280 */     if (sActivityCfg.activityTimeIds.size() <= 0) {
/* 1281 */       long limitTimeBegin = TimeCommonUtil.getLimitTimeBegin(sActivityCfg.activityLimitTimeid);
/* 1282 */       long limitTimeEnd = TimeCommonUtil.getLimitTimeEnd(sActivityCfg.activityLimitTimeid);
/* 1283 */       return (limitTimeEnd - limitTimeBegin) / 60L / 1000L;
/*      */     }
/* 1285 */     int durationTimeCfgid = ((Integer)sActivityCfg.activityTimeIds.get(0)).intValue();
/* 1286 */     return TimeCommonUtil.getDurationMinute(STimeDurationCommonCfg.get(durationTimeCfgid));
/*      */   }
/*      */   
/*      */   static long getActivityDuationMill(int activityid) {
/* 1290 */     long durationMinute = getActivityDurationMinute(activityid);
/* 1291 */     if (durationMinute < 0L) {
/* 1292 */       return durationMinute;
/*      */     }
/* 1294 */     return durationMinute * 60L * 1000L;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void registerActivityByLogicType(int activityType, ActivityHandler activityHandler, boolean userModeActivity)
/*      */   {
/* 1305 */     if (activityLogicTypeToActivityMap.containsKey(Integer.valueOf(activityType))) {
/* 1306 */       throw new RuntimeException(String.format("[Activity]ActivityManager.registerActivityByType@活动已经被注册了|activityType=%d|handlerName=%s", new Object[] { Integer.valueOf(activityType), ((ActivityHandler)activityLogicTypeToActivityMap.get(Integer.valueOf(activityType))).getClass().getName() }));
/*      */     }
/*      */     
/*      */ 
/* 1310 */     if (userModeActivity) {
/* 1311 */       userModeActivities.add(Integer.valueOf(activityType));
/*      */     }
/* 1313 */     activityLogicTypeToActivityMap.put(Integer.valueOf(activityType), activityHandler);
/*      */     
/* 1315 */     List<ActivityStage> activityStages = activityHandler.getActivityStages();
/* 1316 */     if ((activityStages != null) && (activityStages.size() > 0)) {
/* 1317 */       initActivityStage(activityStages);
/* 1318 */       activityLogicTypeToActivityStageMap.put(Integer.valueOf(activityType), activityStages);
/*      */     }
/*      */   }
/*      */   
/*      */   private static void initActivityStage(List<ActivityStage> activityStages) {
/* 1323 */     int sign = 0;
/* 1324 */     for (int i = 0; i < activityStages.size(); i++) {
/* 1325 */       ActivityStage activityStage = (ActivityStage)activityStages.get(i);
/* 1326 */       if (!activityStage.isTimeBeseLineBeginBefore())
/*      */       {
/*      */ 
/* 1329 */         sign = i;
/* 1330 */         break;
/*      */       }
/*      */     }
/*      */     
/* 1334 */     for (int i = 0; i < sign; i++) {
/* 1335 */       ActivityStage activityStage = (ActivityStage)activityStages.get(i);
/* 1336 */       activityStage.setStage(i - sign);
/*      */     }
/*      */     
/*      */ 
/* 1340 */     for (int j = sign; j < activityStages.size(); j++) {
/* 1341 */       ActivityStage activityStage = (ActivityStage)activityStages.get(j);
/* 1342 */       activityStage.setStage(j - sign + 1);
/*      */     }
/*      */   }
/*      */   
/*      */   static boolean stageStartAgain(long startTime, long endTime, StageBean stageBean) {
/* 1347 */     boolean stageStartAgain = false;
/* 1348 */     if (stageBean != null) {
/* 1349 */       long triggerTime = stageBean.getTriggertime();
/* 1350 */       if ((triggerTime <= endTime) && (triggerTime >= startTime)) {
/* 1351 */         stageStartAgain = true;
/*      */       }
/*      */     }
/* 1354 */     return stageStartAgain;
/*      */   }
/*      */   
/*      */   static void openTimeBeginStage(OpenBeanStore xOpenBeanStore, ActivityStage activityStage, int activityid)
/*      */   {
/* 1359 */     long endTime = xOpenBeanStore.getEndtime();
/* 1360 */     long startTime = endTime - getActivityDuationMill(activityid);
/* 1361 */     StageBean stageBean = (StageBean)xOpenBeanStore.getStagemap().get(Integer.valueOf(activityStage.stage));
/* 1362 */     boolean stageStartAgain = stageStartAgain(startTime, endTime, stageBean);
/* 1363 */     if (!stageStartAgain)
/*      */     {
/* 1365 */       long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 1366 */       if (activityStage.isTimeLogicRelative()) {
/* 1367 */         int sec = xOpenBeanStore.getActivityduration();
/* 1368 */         int interval = activityStage.minute * 60 - sec;
/* 1369 */         if (interval > 0) {
/* 1370 */           new Session(interval, activityid)
/*      */           {
/*      */             protected void onTimeOut()
/*      */             {
/* 1374 */               NoneRealTimeTaskManager.getInstance().addTask(new ActivityStageProcedure(this.val$activityid, this.val$activityStage.stage));
/*      */             }
/*      */             
/*      */           };
/*      */         } else {
/* 1379 */           NoneRealTimeTaskManager.getInstance().addTask(new ActivityStageProcedure(activityid, activityStage.stage));
/*      */         }
/*      */         
/*      */       }
/* 1383 */       else if (activityStage.isTimeLogicFix())
/*      */       {
/* 1385 */         long stageEndTime = endTime - getActivityDuationMill(activityid) + activityStage.minute * 60 * 1000;
/* 1386 */         long sec = (stageEndTime - curTime) / 1000L;
/* 1387 */         if (sec > 0L) {
/* 1388 */           new Session(sec, activityid)
/*      */           {
/*      */             protected void onTimeOut() {
/* 1391 */               NoneRealTimeTaskManager.getInstance().addTask(new ActivityStageProcedure(this.val$activityid, this.val$activityStage.stage));
/*      */             }
/*      */             
/*      */           };
/*      */         } else {
/* 1396 */           NoneRealTimeTaskManager.getInstance().addTask(new ActivityStageProcedure(activityid, activityStage.stage));
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/* 1403 */       NoneRealTimeTaskManager.getInstance().addTask(new ActivityStageProcedure(activityid, activityStage.stage));
/*      */     }
/*      */   }
/*      */   
/*      */   static void openTimeEndStage(OpenBeanStore xOpenBeanStore, ActivityStage activityStage, int activityid)
/*      */   {
/* 1409 */     long endTime = xOpenBeanStore.getEndtime();
/* 1410 */     long startTime = endTime - getActivityDuationMill(activityid);
/* 1411 */     StageBean xStageBean = (StageBean)xOpenBeanStore.getStagemap().get(Integer.valueOf(activityStage.stage));
/* 1412 */     boolean startAgain = stageStartAgain(startTime, endTime, xStageBean);
/* 1413 */     if (!startAgain)
/*      */     {
/*      */ 
/* 1416 */       long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 1417 */       long triggerTime = endTime - activityStage.minute * 60 * 1000;
/* 1418 */       long interval = (triggerTime - curTime) / 1000L;
/* 1419 */       if (interval > 0L) {
/* 1420 */         new Session(interval, activityid)
/*      */         {
/*      */           protected void onTimeOut()
/*      */           {
/* 1424 */             NoneRealTimeTaskManager.getInstance().addTask(new ActivityStageProcedure(this.val$activityid, this.val$activityStage.stage));
/*      */           }
/*      */           
/*      */         };
/*      */       } else {
/* 1429 */         NoneRealTimeTaskManager.getInstance().addTask(new ActivityStageProcedure(activityid, activityStage.stage));
/*      */       }
/*      */       
/*      */     }
/*      */     else
/*      */     {
/* 1435 */       NoneRealTimeTaskManager.getInstance().addTask(new ActivityStageProcedure(activityid, activityStage.stage));
/*      */     }
/*      */   }
/*      */   
/*      */   static int getActivityStage(int activityid) {
/* 1440 */     ActivityGlobalBean xActivityGlobalBean = xtable.Activity.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 1441 */     if (xActivityGlobalBean != null) {
/* 1442 */       OpenBeanStore xOpenBeanStore = (OpenBeanStore)xActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(activityid));
/* 1443 */       if (xOpenBeanStore != null) {
/* 1444 */         long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 1445 */         if (curTime >= xOpenBeanStore.getEndtime()) {
/* 1446 */           return -1;
/*      */         }
/* 1448 */         return xOpenBeanStore.getStage();
/*      */       }
/*      */     }
/*      */     
/* 1452 */     return -1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Integer getActivityStoreStage(int activityid)
/*      */   {
/* 1462 */     ActivityGlobalBean xActivityGlobalBean = xtable.Activity.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 1463 */     if (xActivityGlobalBean != null) {
/* 1464 */       OpenBeanStore xOpenBeanStore = (OpenBeanStore)xActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(activityid));
/* 1465 */       if (xOpenBeanStore != null) {
/* 1466 */         return Integer.valueOf(xOpenBeanStore.getStage());
/*      */       }
/*      */     }
/*      */     
/* 1470 */     return null;
/*      */   }
/*      */   
/*      */   public static long getActivityStartTime(int activityid) {
/* 1474 */     ActivityGlobalBean xActivityGlobalBean = xtable.Activity.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 1475 */     if (xActivityGlobalBean != null) {
/* 1476 */       OpenBeanStore xOpenBeanStore = (OpenBeanStore)xActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(activityid));
/* 1477 */       if (xOpenBeanStore != null) {
/* 1478 */         return xOpenBeanStore.getEndtime() - getActivityDuationMill(activityid);
/*      */       }
/*      */     }
/*      */     
/* 1482 */     return 0L;
/*      */   }
/*      */   
/*      */   public static long getActivityEndTime(int activityid) {
/* 1486 */     ActivityGlobalBean xActivityGlobalBean = xtable.Activity.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 1487 */     if (xActivityGlobalBean != null) {
/* 1488 */       OpenBeanStore xOpenBeanStore = (OpenBeanStore)xActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(activityid));
/* 1489 */       if (xOpenBeanStore != null) {
/* 1490 */         return xOpenBeanStore.getEndtime();
/*      */       }
/*      */     }
/*      */     
/* 1494 */     return 0L;
/*      */   }
/*      */   
/*      */   static int getActivityStageLeftTime(int activityid, int stage) {
/* 1498 */     long stageEndTime = getActivityStageEndTime(activityid, stage);
/* 1499 */     if (stageEndTime < 0L) {
/* 1500 */       return (int)stageEndTime;
/*      */     }
/* 1502 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 1503 */     if (stageEndTime <= curTime) {
/* 1504 */       return 0;
/*      */     }
/* 1506 */     return (int)(stageEndTime - curTime);
/*      */   }
/*      */   
/*      */   public static long getActivityStageEndTime(int activityid, int stage) {
/* 1510 */     ActivityGlobalBean xActivityGlobalBean = xtable.Activity.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 1511 */     if (xActivityGlobalBean != null) {
/* 1512 */       OpenBeanStore xOpenBeanStore = (OpenBeanStore)xActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(activityid));
/* 1513 */       if (xOpenBeanStore != null) {
/* 1514 */         long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 1515 */         if (curTime > xOpenBeanStore.getEndtime()) {
/* 1516 */           return -1L;
/*      */         }
/* 1518 */         return getStageEndtime(activityid, stage, xOpenBeanStore);
/*      */       }
/*      */     }
/*      */     
/* 1522 */     return -1L;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static ActivityStage getActivityStage(int activityid, int stage)
/*      */   {
/* 1533 */     ActivityStage activityStage = null;
/* 1534 */     if (stage == 0) {
/* 1535 */       return null;
/*      */     }
/* 1537 */     List<ActivityStage> activityStages = getActivityStages(activityid);
/* 1538 */     if ((activityStages != null) && (activityStages.size() > 0)) {
/* 1539 */       for (ActivityStage tempStage : activityStages) {
/* 1540 */         if (tempStage.stage == stage) {
/* 1541 */           return tempStage;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1546 */     return activityStage;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static long getStageEndtime(int activityid, int stage, OpenBeanStore xOpenBeanStore)
/*      */   {
/* 1559 */     if (stage < 0) {
/* 1560 */       return xOpenBeanStore.getEndtime() - getActivityDuationMill(activityid);
/*      */     }
/* 1562 */     int nextStage = stage + 1;
/* 1563 */     ActivityStage activityStage = getActivityStage(activityid, nextStage);
/* 1564 */     if (activityStage == null) {
/* 1565 */       return xOpenBeanStore.getEndtime();
/*      */     }
/*      */     
/*      */ 
/* 1569 */     if (activityStage.isTimeLogicFix()) {
/* 1570 */       long fixMinute = 0L;
/* 1571 */       long durationMinute = getActivityDurationMinute(activityid);
/* 1572 */       if (activityStage.isTimeBaseLineBefore()) {
/* 1573 */         for (int i = 1; i <= nextStage; i++) {
/* 1574 */           ActivityStage tempStage = getActivityStage(activityid, i);
/* 1575 */           if (tempStage.isTimeBaseLineBefore()) {
/* 1576 */             fixMinute += tempStage.minute;
/* 1577 */           } else if (tempStage.isTimeBaseLineBegin()) {
/* 1578 */             fixMinute = tempStage.minute;
/* 1579 */           } else if (tempStage.isTimeBaseLineEnd()) {
/* 1580 */             fixMinute = durationMinute - tempStage.minute;
/*      */           }
/*      */         }
/* 1583 */       } else if (activityStage.isTimeBaseLineBegin()) {
/* 1584 */         fixMinute = activityStage.minute;
/* 1585 */       } else if (activityStage.isTimeBaseLineEnd()) {
/* 1586 */         fixMinute = durationMinute - activityStage.minute;
/*      */       }
/*      */       
/*      */ 
/* 1590 */       long stageEndTime = xOpenBeanStore.getEndtime() - getActivityDuationMill(activityid) + fixMinute * 60L * 1000L;
/*      */       
/* 1592 */       return stageEndTime;
/*      */     }
/* 1594 */     if (activityStage.isTimeLogicRelative()) {
/* 1595 */       if (xOpenBeanStore.getStagemap().containsKey(Integer.valueOf(nextStage))) {
/* 1596 */         int sec = ((StageBean)xOpenBeanStore.getStagemap().get(Integer.valueOf(nextStage))).getDuration();
/* 1597 */         return DateTimeUtils.getCurrTimeInMillis() - sec * 1000;
/*      */       }
/* 1599 */       if (activityStage.isTimeBaseLineBefore()) {
/* 1600 */         StageBean xStageBean = (StageBean)xOpenBeanStore.getStagemap().get(Integer.valueOf(nextStage - 1));
/* 1601 */         if (xStageBean == null) {
/* 1602 */           return activityStage.minute * 60 * 1000 + getStageEndtime(activityid, stage - 1, xOpenBeanStore);
/*      */         }
/*      */         
/* 1605 */         int sec = xStageBean.getDuration();
/* 1606 */         int interval = activityStage.minute * 60 - sec;
/* 1607 */         return DateTimeUtils.getCurrTimeInMillis() + interval * 1000;
/*      */       }
/* 1609 */       if (activityStage.isTimeBaseLineBegin()) {
/* 1610 */         int sec = xOpenBeanStore.getActivityduration();
/* 1611 */         int interval = activityStage.minute * 60 - sec;
/* 1612 */         return DateTimeUtils.getCurrTimeInMillis() + interval * 1000; }
/* 1613 */       if (activityStage.isTimeBaseLineEnd()) {
/* 1614 */         long endTime = xOpenBeanStore.getEndtime() - activityStage.minute * 60 * 1000;
/* 1615 */         if ((endTime < DateTimeUtils.getCurrTimeInMillis()) && (!xOpenBeanStore.getStagemap().containsKey(Integer.valueOf(nextStage))))
/*      */         {
/*      */ 
/* 1618 */           return getStageEndtime(activityid, stage - 1, xOpenBeanStore);
/*      */         }
/* 1620 */         return endTime;
/*      */       }
/* 1622 */       return -1L;
/*      */     }
/*      */     
/*      */ 
/* 1626 */     return -1L;
/*      */   }
/*      */   
/*      */ 
/*      */   static void fillSpecialControlData(SpecialControlData specialControlData, int activityid, OpenBeanStore xOpenBeanStore)
/*      */   {
/* 1632 */     specialControlData.actvityid = activityid;
/* 1633 */     specialControlData.openstate = xOpenBeanStore.getOpenstate();
/* 1634 */     specialControlData.endtime = (xOpenBeanStore.getEndtime() / 1000L);
/*      */   }
/*      */   
/*      */ 
/*      */   static void checkAndRefreshCompensate(long roleid, int activityid, long activityFreshTime, int count)
/*      */   {
/* 1640 */     if (!ActivityCompensateInterface.hasCompensate(activityid)) {
/* 1641 */       return;
/*      */     }
/*      */     
/* 1644 */     int minLevel = ActivityInterface.getActivityLevelMin(activityid);
/* 1645 */     int maxLevel = ActivityInterface.getActivityLevelMax(activityid);
/*      */     
/* 1647 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 1648 */     if ((roleLevel < minLevel) || (roleLevel > maxLevel)) {
/* 1649 */       return;
/*      */     }
/* 1651 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*      */     
/* 1653 */     long limitEarliestTime = ActivityCompensateInterface.getLimitEarliestCompensateTime(roleid, activityid, now);
/* 1654 */     if (limitEarliestTime <= 0L) {
/* 1655 */       return;
/*      */     }
/*      */     
/*      */ 
/* 1659 */     long earliestTime = ActivityCompensateInterface.getEarliestCompensateTime(roleid, activityid, now);
/*      */     
/* 1661 */     List<Long> completeTimeList = new ArrayList();
/* 1662 */     long earliestStartTime = -1L;
/*      */     
/* 1664 */     long durationMillis = getActivityDuationMill(activityid);
/*      */     
/* 1666 */     long lastStartTime = getLastStartTime(now, activityid, false);
/* 1667 */     while (lastStartTime > earliestTime) {
/* 1668 */       long endMillis = lastStartTime + durationMillis;
/* 1669 */       if (endMillis <= limitEarliestTime) {
/*      */         break;
/*      */       }
/* 1672 */       if (lastStartTime > activityFreshTime)
/*      */       {
/* 1674 */         if (endMillis < now) {
/* 1675 */           completeTimeList.add(Long.valueOf(lastStartTime));
/*      */         }
/*      */       }
/*      */       else {
/* 1679 */         if ((endMillis <= activityFreshTime) || (endMillis >= now)) break;
/* 1680 */         earliestStartTime = lastStartTime; break;
/*      */       }
/*      */       
/*      */ 
/* 1684 */       lastStartTime = getLastStartTime(lastStartTime, activityid, false);
/*      */     }
/*      */     
/* 1687 */     ActivityCompensateInterface.refreshCompensate(roleid, activityid, earliestStartTime, count, completeTimeList);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isUserMode(int activityLogicType)
/*      */   {
/* 1699 */     return userModeActivities.contains(Integer.valueOf(activityLogicType));
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\ActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */