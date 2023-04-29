/*     */ package mzm.gsp.activitycompensate.main;
/*     */ 
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activitycompensate.SActivityCompensateNormalResult;
/*     */ import mzm.gsp.activitycompensate.SSyncActivityCompensates;
/*     */ import mzm.gsp.activitycompensate.confbean.SActivityCompensateCfg;
/*     */ import mzm.gsp.activitycompensate.confbean.SActivityCompensateConsts;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ActivityCompensateGlobal;
/*     */ import xbean.ActivityCompensates;
/*     */ import xbean.ActivityCompensatesGlobal;
/*     */ import xbean.Pod;
/*     */ import xtable.Activitycompensate_global;
/*     */ import xtable.Role2activitycompensate;
/*     */ 
/*     */ class ActivityCompensateManager
/*     */ {
/*     */   static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
/*     */   static Logger logger;
/*     */   static RefreshCompensateObserver observer;
/*     */   static final String TLOG_GET_AWARD = "ActivityCompensate";
/*     */   
/*     */   static void init()
/*     */   {
/*  43 */     logger = Logger.getLogger("activitycompensate");
/*     */   }
/*     */   
/*     */   static void postInit()
/*     */   {
/*  48 */     for (Iterator i$ = SActivityCompensateCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityid = ((Integer)i$.next()).intValue();
/*  49 */       int activityLogicType = ActivityInterface.getLogicTypeByActivityId(activityid);
/*  50 */       if (!ActivityCompensateHandlerManager.getInstance().containsActivity(activityLogicType)) {
/*  51 */         String str = String.format("ActivityCompensateManager.postInit@activity not registered|activityid=%d|logic_type=%d", new Object[] { Integer.valueOf(activityid), Integer.valueOf(activityLogicType) });
/*     */         
/*     */ 
/*  54 */         logger.error(str);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  59 */       if (ActivityInterface.isUserMode(activityLogicType)) {
/*  60 */         String str = String.format("ActivityCompensateManager.postInit@not support user mode|activityid=%d|logic_type=%d", new Object[] { Integer.valueOf(activityid), Integer.valueOf(activityLogicType) });
/*     */         
/*     */ 
/*  63 */         logger.error(str);
/*  64 */         throw new RuntimeException(str);
/*     */       }
/*     */     }
/*     */     
/*  68 */     observer = new RefreshCompensateObserver(SActivityCompensateConsts.getInstance().RefreshTimeCfgid);
/*     */   }
/*     */   
/*     */   static void logWarn(String formatStr, Object... args)
/*     */   {
/*  73 */     logger.warn(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   static void logError(String formatStr, Object... args) {
/*  77 */     logger.error(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   static void logInfo(String formatStr, Object... args) {
/*  81 */     logger.info(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   static void logDebug(String formatStr, Object... args) {
/*  85 */     logger.debug(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   static ActivityCompensateHandler getCompensateHandler(int activityid) {
/*  89 */     int logicType = ActivityInterface.getLogicTypeByActivityId(activityid);
/*  90 */     return ActivityCompensateHandlerManager.getInstance().getHandler(logicType);
/*     */   }
/*     */   
/*     */   static ActivityCompensatesGlobal createXCompensatesGlobalIfNotExist() {
/*  94 */     long key = GameServerInfoManager.getLocalId();
/*  95 */     ActivityCompensatesGlobal xCompensatesGlobal = Activitycompensate_global.get(Long.valueOf(key));
/*  96 */     if (xCompensatesGlobal == null) {
/*  97 */       xCompensatesGlobal = Pod.newActivityCompensatesGlobal();
/*  98 */       Activitycompensate_global.insert(Long.valueOf(key), xCompensatesGlobal);
/*     */     }
/* 100 */     return xCompensatesGlobal;
/*     */   }
/*     */   
/*     */   static ActivityCompensatesGlobal getXCompensatesGlobal(boolean holdLock) {
/* 104 */     ActivityCompensatesGlobal xCompensatesGlobal = null;
/* 105 */     long key = GameServerInfoManager.getLocalId();
/* 106 */     if (holdLock) {
/* 107 */       xCompensatesGlobal = Activitycompensate_global.get(Long.valueOf(key));
/*     */     }
/*     */     else {
/* 110 */       xCompensatesGlobal = Activitycompensate_global.select(Long.valueOf(key));
/*     */     }
/* 112 */     return xCompensatesGlobal;
/*     */   }
/*     */   
/*     */   static ActivityCompensateGlobal createXCompensateGlobalIfNotExist(ActivityCompensatesGlobal xCompensatesGlobal, int activityid)
/*     */   {
/* 117 */     ActivityCompensateGlobal xCompensateGlobal = (ActivityCompensateGlobal)xCompensatesGlobal.getActivity2compensateglobal().get(Integer.valueOf(activityid));
/* 118 */     if (xCompensateGlobal == null) {
/* 119 */       xCompensateGlobal = Pod.newActivityCompensateGlobal();
/* 120 */       xCompensatesGlobal.getActivity2compensateglobal().put(Integer.valueOf(activityid), xCompensateGlobal);
/*     */     }
/* 122 */     return xCompensateGlobal;
/*     */   }
/*     */   
/*     */   static ActivityCompensates createXActivityCompensatesIfNotExist(long roleid) {
/* 126 */     ActivityCompensates xCompensates = Role2activitycompensate.get(Long.valueOf(roleid));
/* 127 */     if (xCompensates == null) {
/* 128 */       xCompensates = Pod.newActivityCompensates();
/* 129 */       Role2activitycompensate.insert(Long.valueOf(roleid), xCompensates);
/*     */     }
/* 131 */     return xCompensates;
/*     */   }
/*     */   
/*     */   static ActivityCompensates getXActivityCompensates(long roleid, boolean holdLock) {
/* 135 */     ActivityCompensates xCompensates = null;
/* 136 */     if (holdLock) {
/* 137 */       xCompensates = Role2activitycompensate.get(Long.valueOf(roleid));
/*     */     }
/*     */     else {
/* 140 */       xCompensates = Role2activitycompensate.select(Long.valueOf(roleid));
/*     */     }
/* 142 */     return xCompensates;
/*     */   }
/*     */   
/*     */   static xbean.ActivityCompensate createXCompensateIfNotExist(ActivityCompensates xCompensates, int activityid) {
/* 146 */     xbean.ActivityCompensate xCompensate = (xbean.ActivityCompensate)xCompensates.getCompensates().get(Integer.valueOf(activityid));
/* 147 */     if (xCompensate == null) {
/* 148 */       xCompensate = Pod.newActivityCompensate();
/* 149 */       xCompensates.getCompensates().put(Integer.valueOf(activityid), xCompensate);
/*     */     }
/* 151 */     return xCompensate;
/*     */   }
/*     */   
/*     */   static long getEarliestCompensateTime(ActivityCompensates xCompensates, int activityid, long nowMillis)
/*     */   {
/* 156 */     xbean.ActivityCompensate xCompensate = null;
/* 157 */     if (xCompensates != null) {
/* 158 */       xCompensate = (xbean.ActivityCompensate)xCompensates.getCompensates().get(Integer.valueOf(activityid));
/*     */     }
/* 160 */     return getEarliestCompensateTime(xCompensate, activityid, nowMillis);
/*     */   }
/*     */   
/*     */   static long getEarliestCompensateTime(xbean.ActivityCompensate xCompensate, int activityid, long nowMillis) {
/* 164 */     long earliestTime = -1L;
/* 165 */     if ((xCompensate != null) && 
/* 166 */       (xCompensate.getLatest_start_time() > 0L)) {
/* 167 */       earliestTime = xCompensate.getLatest_start_time();
/*     */     }
/*     */     
/* 170 */     return earliestTime;
/*     */   }
/*     */   
/*     */   static long getActivityLimitEarlisetCompensateTime(int activityid, long nowMillis) {
/* 174 */     long openTime = GlobalData.getInstance().getActivityOpenTime(activityid);
/* 175 */     long earliestTime = TimeCommonUtil.getBeforeStartTime(nowMillis, SActivityCompensateConsts.getInstance().MaxCompensateDays + 1, SActivityCompensateConsts.getInstance().RefreshTimeCfgid);
/*     */     
/*     */ 
/* 178 */     if (openTime <= 0L) {
/* 179 */       return earliestTime;
/*     */     }
/*     */     
/* 182 */     if (earliestTime <= 0L) {
/* 183 */       return openTime;
/*     */     }
/* 185 */     return Math.max(openTime, earliestTime);
/*     */   }
/*     */   
/*     */   static long getLimitLatestCompensateTime(long nowMillis)
/*     */   {
/* 190 */     long latestTime = TimeCommonUtil.getBeforeStartTime(nowMillis, 1, SActivityCompensateConsts.getInstance().RefreshTimeCfgid);
/*     */     
/* 192 */     return latestTime;
/*     */   }
/*     */   
/*     */   static long getCanJoinTime(ActivityCompensates xCompensates, int activityid) {
/* 196 */     xbean.ActivityCompensate xCompensate = (xbean.ActivityCompensate)xCompensates.getCompensates().get(Integer.valueOf(activityid));
/* 197 */     return getCanJoinTime(xCompensate);
/*     */   }
/*     */   
/*     */   static long getCanJoinTime(xbean.ActivityCompensate xCompensate) {
/* 201 */     if (xCompensate == null) {
/* 202 */       return -1L;
/*     */     }
/* 204 */     return xCompensate.getCan_join_time();
/*     */   }
/*     */   
/*     */   static long getLimitEarliestCompensateTime(ActivityCompensates xCompensates, int activityid, long nowMillis)
/*     */   {
/* 209 */     long activityLimitTime = getActivityLimitEarlisetCompensateTime(activityid, nowMillis);
/* 210 */     long selfLimitTime = getCanJoinTime(xCompensates, activityid);
/* 211 */     return Math.max(activityLimitTime, selfLimitTime);
/*     */   }
/*     */   
/*     */   static long getLimitEarliestCompensateTime(xbean.ActivityCompensate xCompensate, int activityid, long nowMillis) {
/* 215 */     long activityLimitTime = getActivityLimitEarlisetCompensateTime(activityid, nowMillis);
/* 216 */     long selfLimitTime = getCanJoinTime(xCompensate);
/* 217 */     return Math.max(activityLimitTime, selfLimitTime);
/*     */   }
/*     */   
/*     */   static void refreshCompensate(long roleid, ActivityCompensates xCompensates, int activityid, long earliestStartTime, int count, List<Long> completeTimeList)
/*     */   {
/* 222 */     ActivityCompensateHandler handler = getCompensateHandler(activityid);
/* 223 */     if (handler == null) {
/* 224 */       logError("ActivityCompensateManager.refreshCompensate@handler null|roleid=%d|activityid=%d|earliest_start_time=%d|count=%d|time_list=%s", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityid), Long.valueOf(earliestStartTime), Integer.valueOf(count), completeTimeList });
/*     */       
/*     */ 
/* 227 */       return;
/*     */     }
/* 229 */     SActivityCompensateCfg compensateCfg = SActivityCompensateCfg.get(activityid);
/* 230 */     if (compensateCfg == null) {
/* 231 */       logError("ActivityCompensateManager.refreshCompensate@compensate cfg null|roleid=%d|activityid=%d|earliest_start_time=%d|count=%d|time_list=%s", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityid), Long.valueOf(earliestStartTime), Integer.valueOf(count), completeTimeList });
/*     */       
/*     */ 
/* 234 */       return;
/*     */     }
/*     */     
/* 237 */     xbean.ActivityCompensate xCompensate = createXCompensateIfNotExist(xCompensates, activityid);
/* 238 */     int maxCompensateTimes = compensateCfg.maxPeriodCompensateTimes;
/* 239 */     if (earliestStartTime > 0L) {
/* 240 */       int curTimes = handler.getCompensateAwardTimes(roleid, count, activityid);
/* 241 */       if (logger.isDebugEnabled()) {
/* 242 */         String startDate = getDateStr(earliestStartTime);
/* 243 */         logDebug("ActivityCompensateManager.refreshCompensate@calculate compensate times by handler|roleid=%d|activityid=%d|date=%s|handler=%s|compensate_times=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityid), startDate, handler.toString(), Integer.valueOf(curTimes) });
/*     */       }
/*     */       
/* 246 */       if (curTimes > 0) {
/* 247 */         if (curTimes > maxCompensateTimes) {
/* 248 */           curTimes = maxCompensateTimes;
/* 249 */           logError("ActivityCompensateManager.refreshCompensate@current times larger than max compensate times|roleid=%d|activityid=%d|earliest_start_time=%d|count=%d|time_list=%s|cur_times=%d|max_times=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityid), Long.valueOf(earliestStartTime), Integer.valueOf(count), completeTimeList, Integer.valueOf(curTimes), Integer.valueOf(maxCompensateTimes) });
/*     */         }
/*     */         
/*     */ 
/* 253 */         xCompensate.getStart_time2get_times().put(Long.valueOf(earliestStartTime), Integer.valueOf(curTimes));
/*     */       }
/*     */     }
/* 256 */     for (Iterator i$ = completeTimeList.iterator(); i$.hasNext();) { long startTime = ((Long)i$.next()).longValue();
/* 257 */       xCompensate.getStart_time2get_times().put(Long.valueOf(startTime), Integer.valueOf(maxCompensateTimes));
/*     */     }
/*     */     
/* 260 */     if (!xCompensate.getStart_time2get_times().isEmpty()) {
/* 261 */       long latestTime = ((Long)xCompensate.getStart_time2get_times().lastKey()).longValue();
/* 262 */       if (xCompensate.getLatest_start_time() < latestTime) {
/* 263 */         xCompensate.setLatest_start_time(latestTime);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static void sendNormalResult(long roleid, int result) {
/* 269 */     SActivityCompensateNormalResult p = new SActivityCompensateNormalResult();
/* 270 */     p.result = result;
/* 271 */     OnlineManager.getInstance().sendAtOnce(roleid, p);
/*     */   }
/*     */   
/*     */   static String getDateStr(long timeMillis) {
/* 275 */     DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
/* 276 */     return format.format(Long.valueOf(timeMillis));
/*     */   }
/*     */   
/*     */   static Map<Integer, Integer> checkAndRefreshAllAwardTimes(long roleid, ActivityCompensates xCompensates, long nowMillis)
/*     */   {
/* 281 */     Map<Integer, Integer> activity2AwardTimes = new HashMap();
/* 282 */     for (Map.Entry<Integer, SActivityCompensateCfg> entry : SActivityCompensateCfg.getAll().entrySet()) {
/* 283 */       int activityid = ((Integer)entry.getKey()).intValue();
/*     */       
/* 285 */       if (isActivitySwitchOpen(activityid))
/*     */       {
/*     */ 
/*     */ 
/* 289 */         xbean.ActivityCompensate xCompensate = createXCompensateIfNotExist(xCompensates, activityid);
/* 290 */         int awardTimes = checkAndRefreshOneAwardTimes(roleid, xCompensate, activityid, nowMillis);
/* 291 */         if (awardTimes > 0)
/* 292 */           activity2AwardTimes.put(Integer.valueOf(activityid), Integer.valueOf(awardTimes));
/*     */       }
/*     */     }
/* 295 */     return activity2AwardTimes;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int checkAndRefreshOneAwardTimes(long roleid, xbean.ActivityCompensate xCompensate, int activityid, long nowMillis)
/*     */   {
/* 306 */     long limitEarliestTime = getLimitEarliestCompensateTime(xCompensate, activityid, nowMillis);
/* 307 */     long limitLatestTime = getLimitLatestCompensateTime(nowMillis);
/*     */     
/* 309 */     if (logger.isDebugEnabled()) {
/* 310 */       String limitEarliestDate = getDateStr(limitEarliestTime);
/* 311 */       String limitLatestDate = getDateStr(limitLatestTime);
/* 312 */       logDebug("ActivityCompensateManager.checkAndRefreshOneAwardTimes@refresh|roleid=%d|activityid=%d|limit_earliest_date=%s|limit_latest_date=%s", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityid), limitEarliestDate, limitLatestDate });
/*     */     }
/*     */     
/*     */ 
/* 316 */     Iterator<Map.Entry<Long, Integer>> xIter = xCompensate.getStart_time2get_times().entrySet().iterator();
/* 317 */     int awardTimes = 0;
/*     */     
/* 319 */     long durationMillis = ActivityInterface.getActivityDurationMillis(activityid);
/*     */     
/* 321 */     while (xIter.hasNext()) {
/* 322 */       Map.Entry<Long, Integer> xEntry = (Map.Entry)xIter.next();
/* 323 */       long startTime = ((Long)xEntry.getKey()).longValue();
/* 324 */       int times = ((Integer)xEntry.getValue()).intValue();
/*     */       
/* 326 */       long endMillis = startTime + durationMillis;
/*     */       
/* 328 */       if (endMillis <= limitEarliestTime) {
/* 329 */         xIter.remove();
/*     */         
/* 331 */         String startDate = getDateStr(startTime);
/* 332 */         String limitEarliestDate = getDateStr(limitEarliestTime);
/* 333 */         logInfo("ActivityCompensateManager.checkAndRefreshOneAwardTimes@remove outdated|roleid=%d|activityid=%d|start_date=%s|limit_earliest_date=%s|left_times=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityid), startDate, limitEarliestDate, Integer.valueOf(times) });
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 338 */       else if (startTime < limitLatestTime)
/*     */       {
/*     */ 
/*     */ 
/* 342 */         if (times <= 0) {
/* 343 */           String startDate = getDateStr(startTime);
/* 344 */           String limitEarliestDate = getDateStr(limitEarliestTime);
/* 345 */           xIter.remove();
/* 346 */           logInfo("ActivityCompensateManager.checkAndRefreshOneAwardTimes@remove invalid left times|roleid=%d|activityid=%d|start_date=%s|limit_earliest_date=%s|left_times=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityid), startDate, limitEarliestDate, Integer.valueOf(times) });
/*     */         }
/*     */         else
/*     */         {
/* 350 */           awardTimes += times;
/*     */         } } }
/* 352 */     return awardTimes;
/*     */   }
/*     */   
/*     */   static void syncActivityCompensates(long roleid, ActivityCompensates xCompensates, long nowMillis)
/*     */   {
/* 357 */     SSyncActivityCompensates sync = new SSyncActivityCompensates();
/* 358 */     Map<Integer, Integer> activity2AwardTimes = checkAndRefreshAllAwardTimes(roleid, xCompensates, nowMillis);
/* 359 */     for (Map.Entry<Integer, Integer> entry : activity2AwardTimes.entrySet()) {
/* 360 */       int activityid = ((Integer)entry.getKey()).intValue();
/* 361 */       int times = ((Integer)entry.getValue()).intValue();
/*     */       
/* 363 */       SActivityCompensateCfg compensateCfg = SActivityCompensateCfg.get(activityid);
/* 364 */       if (compensateCfg != null)
/*     */       {
/*     */ 
/*     */ 
/* 368 */         AwardReason awardReason = new AwardReason(mzm.gsp.tlog.LogReason.ACTIVITY_COMPENSATE_GET_ONCE);
/*     */         
/* 370 */         AwardModel freeModel = AwardInterface.getRoleAwardModel(compensateCfg.freeAward, roleid, SActivityCompensateConsts.getInstance().FreeAwardModifyid, awardReason);
/*     */         
/* 372 */         AwardModel goldModel = AwardInterface.getRoleAwardModel(compensateCfg.goldAward, roleid, SActivityCompensateConsts.getInstance().GoldAwardModifyid, awardReason);
/*     */         
/* 374 */         AwardModel yuanbaoModel = AwardInterface.getRoleAwardModel(compensateCfg.yuanbaoAward, roleid, SActivityCompensateConsts.getInstance().YuanBaoAwardModifyid, awardReason);
/*     */         
/*     */ 
/* 377 */         mzm.gsp.activitycompensate.ActivityCompensate compensateBean = new mzm.gsp.activitycompensate.ActivityCompensate();
/* 378 */         compensateBean.activityid = activityid;
/* 379 */         if (freeModel != null) {
/* 380 */           compensateBean.free_exp = freeModel.getRoleExp();
/*     */         }
/* 382 */         if (goldModel != null) {
/* 383 */           compensateBean.gold_exp = goldModel.getRoleExp();
/*     */         }
/* 385 */         if (yuanbaoModel != null) {
/* 386 */           compensateBean.yuanbao_exp = yuanbaoModel.getRoleExp();
/*     */         }
/*     */         
/* 389 */         compensateBean.times = times;
/* 390 */         sync.compensates.add(compensateBean);
/*     */       }
/*     */     }
/* 393 */     OnlineManager.getInstance().send(roleid, sync);
/*     */   }
/*     */   
/*     */   static boolean canJoinActivity(int roleLevel, int activityid) {
/* 397 */     int maxLevel = ActivityInterface.getActivityLevelMax(activityid);
/* 398 */     int minLevel = ActivityInterface.getActivityLevelMin(activityid);
/* 399 */     return (roleLevel >= minLevel) && (roleLevel <= maxLevel);
/*     */   }
/*     */   
/*     */   private static List<Integer> getActivitySwitchList(int activityid) {
/* 403 */     ActivityCompensateHandler handler = getCompensateHandler(activityid);
/* 404 */     if (handler == null) {
/* 405 */       return new ArrayList();
/*     */     }
/* 407 */     return handler.getActivitySwitchList(activityid);
/*     */   }
/*     */   
/*     */   static boolean isActivitySwitchOpen(int activityid) {
/* 411 */     List<Integer> switchList = getActivitySwitchList(activityid);
/* 412 */     if ((switchList == null) || (switchList.isEmpty())) {
/* 413 */       return true;
/*     */     }
/* 415 */     for (Iterator i$ = switchList.iterator(); i$.hasNext();) { int switchid = ((Integer)i$.next()).intValue();
/* 416 */       if (!OpenInterface.getOpenStatus(switchid)) {
/* 417 */         return false;
/*     */       }
/*     */     }
/* 420 */     return true;
/*     */   }
/*     */   
/*     */   static void tlogGetAward(String userid, long roleid, int level, int activityid, int getType, int times)
/*     */   {
/* 425 */     TLogManager.getInstance().addLog(userid, "ActivityCompensate", new Object[] { GameServerInfoManager.getHostIP(), userid, Long.valueOf(roleid), Integer.valueOf(level), Integer.valueOf(activityid), Integer.valueOf(getType), Integer.valueOf(times) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitycompensate\main\ActivityCompensateManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */