/*     */ package mzm.gsp.firework.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity3.confbean.SFireworkCfg;
/*     */ import mzm.gsp.activity3.confbean.SFireworkCollectCfg;
/*     */ import mzm.gsp.activity3.confbean.STFireworkCollectCfg;
/*     */ import mzm.gsp.common.confbean.STimeCommonCfg;
/*     */ import mzm.gsp.firework.SSynFireworkShowStage;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FireworkInfo;
/*     */ import xbean.FireworkRecord;
/*     */ import xbean.Pod;
/*     */ import xtable.Globalfirework;
/*     */ 
/*     */ public class FireworkManager
/*     */ {
/*  34 */   private static String loggerTag = "[firework]";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static final String ENCODING = "UTF-8";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void refreshFirework(int activityId, int controllerId)
/*     */   {
/*  46 */     SFireworkCfg cfg = SFireworkCfg.get(activityId);
/*  47 */     if (cfg == null)
/*     */     {
/*  49 */       loggerError("FireworkManager.refreshFirework@ no SFireworkCfg!|activityId=%d", new Object[] { Integer.valueOf(activityId) });
/*  50 */       return;
/*     */     }
/*  52 */     if (!OpenInterface.getOpenStatus(cfg.switchId))
/*     */     {
/*  54 */       loggerInfo("FireworkManager.refreshFirework@ forbid!|activityId=%d", new Object[] { Integer.valueOf(activityId) });
/*  55 */       return;
/*     */     }
/*  57 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  59 */     FireworkRecord xFireworkRecord = getXFireworkRecordIfAbsent(activityId);
/*     */     
/*  61 */     cleanLastData(activityId, xFireworkRecord);
/*     */     
/*  63 */     ControllerInterface.triggerWorldControllerWithMaxSpawnNum(MapInterface.getBigWorldid(), controllerId, FireworkGmDataCache.getInstance().getTriggerCount(cfg));
/*     */     
/*     */ 
/*  66 */     long cleanSessionId = new CleanFireworkSession(FireworkGmDataCache.getInstance().getFindLastInterval(cfg), activityId).getSessionId();
/*     */     
/*  68 */     xFireworkRecord.setCleansessionid(cleanSessionId);
/*     */     
/*  70 */     xFireworkRecord.setFindfireworkstarttime(curTime);
/*     */     
/*  72 */     OnlineManager.getInstance().sendAll(getSynStageProtocol(activityId, 1, curTime));
/*     */   }
/*     */   
/*     */ 
/*     */   static FireworkRecord getXFireworkRecordIfAbsent(int activityId)
/*     */   {
/*  78 */     FireworkInfo xFireworkInfo = Globalfirework.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  79 */     if (xFireworkInfo == null)
/*     */     {
/*  81 */       Globalfirework.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xFireworkInfo = Pod.newFireworkInfo());
/*     */     }
/*  83 */     FireworkRecord xFireworkRecord = (FireworkRecord)xFireworkInfo.getActivityid2record().get(Integer.valueOf(activityId));
/*  84 */     if (xFireworkRecord == null)
/*     */     {
/*  86 */       xFireworkInfo.getActivityid2record().put(Integer.valueOf(activityId), xFireworkRecord = Pod.newFireworkRecord());
/*     */     }
/*  88 */     return xFireworkRecord;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void cleanLastData(int activityId, FireworkRecord xFireworkRecord)
/*     */   {
/* 100 */     collectAllControllers(activityId);
/*     */     
/* 102 */     Session.removeSession(xFireworkRecord.getCleansessionid());
/* 103 */     xFireworkRecord.setAlreadygetnum(0);
/* 104 */     xFireworkRecord.setCleansessionid(0L);
/* 105 */     xFireworkRecord.setFireworkstarttime(0L);
/* 106 */     xFireworkRecord.setFireworkcountdowntime(0L);
/* 107 */     xFireworkRecord.setFindfireworkstarttime(0L);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void initActivity(int activityId, OperFireorkReason reason)
/*     */   {
/* 118 */     for (Iterator i$ = getCurNeedTriggerTimeIds().iterator(); i$.hasNext();) { int cfgId = ((Integer)i$.next()).intValue();
/*     */       
/* 120 */       SFireworkCollectCfg cfg = SFireworkCollectCfg.get(cfgId);
/* 121 */       if (cfg != null)
/*     */       {
/*     */ 
/*     */ 
/* 125 */         Observer refreshObserver = new FindFireworkObserver(cfg.triggerTime, activityId, cfg.controllerId);
/* 126 */         if (!FObserverManager.getInstance().putIfAbsent(activityId, cfg.triggerTime, refreshObserver))
/*     */         {
/* 128 */           refreshObserver.stopTimer(); }
/*     */       }
/*     */     }
/* 131 */     loggerInfo("FireworkManager.initActivity@init activity done|activityId=%d|reason=%s", new Object[] { Integer.valueOf(activityId), reason.name() });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static List<Integer> getCurNeedTriggerTimeIds()
/*     */   {
/* 141 */     Calendar calendar = DateTimeUtils.getCalendar();
/* 142 */     calendar.setTimeInMillis(DateTimeUtils.getCurrTimeInMillis());
/* 143 */     return getNeedTriggerTimeCfgId(calendar.get(12), calendar.get(11));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static List<Integer> getNeedTriggerTimeCfgId(int curMinute, int curHour)
/*     */   {
/* 155 */     List<Integer> result = new ArrayList();
/* 156 */     for (SFireworkCollectCfg cfg : SFireworkCollectCfg.getAll().values())
/*     */     {
/* 158 */       if (!missTime(curMinute, curHour, STimeCommonCfg.get(cfg.triggerTime)))
/*     */       {
/*     */ 
/*     */ 
/* 162 */         result.add(Integer.valueOf(cfg.id)); }
/*     */     }
/* 164 */     return result;
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
/*     */   private static boolean missTime(int curMinute, int curHour, STimeCommonCfg timeCommonCfg)
/*     */   {
/* 177 */     if (timeCommonCfg.activeHour > curHour)
/*     */     {
/* 179 */       return false;
/*     */     }
/* 181 */     if (timeCommonCfg.activeHour < curHour)
/*     */     {
/* 183 */       return true;
/*     */     }
/* 185 */     return timeCommonCfg.activeMinute < curMinute;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void stopActivity(int activityId, OperFireorkReason reason)
/*     */   {
/* 197 */     clearActivityData(activityId);
/*     */     
/* 199 */     FObserverManager.getInstance().stop(activityId);
/*     */     
/* 201 */     collectAllControllers(activityId);
/*     */     
/* 203 */     loggerInfo("FireworkManager.stopActivity@stop activity done|activityId=%d|reason=%s", new Object[] { Integer.valueOf(activityId), reason.name() });
/*     */   }
/*     */   
/*     */   private static void clearActivityData(int activityId)
/*     */   {
/* 208 */     SFireworkCfg cfg = SFireworkCfg.get(activityId);
/* 209 */     if (cfg == null)
/*     */     {
/* 211 */       return;
/*     */     }
/*     */     
/* 214 */     FireworkInfo xFireworkInfo = Globalfirework.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 215 */     if (xFireworkInfo == null)
/*     */     {
/* 217 */       return;
/*     */     }
/* 219 */     FireworkRecord xFireworkRecord = (FireworkRecord)xFireworkInfo.getActivityid2record().get(Integer.valueOf(activityId));
/* 220 */     if (xFireworkRecord == null)
/*     */     {
/* 222 */       return;
/*     */     }
/*     */     
/* 225 */     Session.removeSession(xFireworkRecord.getCleansessionid());
/*     */     
/* 227 */     xFireworkRecord.setAlreadygetnum(0);
/* 228 */     xFireworkRecord.setCleansessionid(0L);
/* 229 */     xFireworkRecord.setFireworkstarttime(0L);
/* 230 */     xFireworkRecord.setFireworkcountdowntime(0L);
/* 231 */     xFireworkRecord.setFindfireworkstarttime(0L);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void collectAllControllers(int activityId)
/*     */   {
/* 242 */     Set<Integer> allControllers = getAllControllerIds(activityId);
/* 243 */     if ((allControllers == null) || (allControllers.isEmpty()))
/*     */     {
/* 245 */       return;
/*     */     }
/* 247 */     for (Iterator i$ = allControllers.iterator(); i$.hasNext();) { int controllerId = ((Integer)i$.next()).intValue();
/*     */       
/* 249 */       ControllerInterface.collectController(controllerId);
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
/*     */ 
/*     */   static void startFirework(int activityId, OperFireorkReason reason, FireworkRecord xFireworkRecord)
/*     */   {
/* 264 */     SFireworkCfg cfg = SFireworkCfg.get(activityId);
/* 265 */     if (cfg == null)
/*     */     {
/* 267 */       return;
/*     */     }
/* 269 */     if (!OpenInterface.getOpenStatus(cfg.switchId))
/*     */     {
/* 271 */       return;
/*     */     }
/* 273 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/* 275 */     collectAllControllers(activityId);
/*     */     
/* 277 */     noticeAllFireworkComing(activityId, reason, curTime);
/*     */     
/* 279 */     new FireworkShowCountDownSession(cfg.countDown, activityId);
/*     */     
/* 281 */     xFireworkRecord.setFireworkcountdowntime(curTime);
/*     */     
/* 283 */     loggerInfo("FireworkManager.startFirework@ show count down!|activityId=%d|reason=%s", new Object[] { Integer.valueOf(activityId), reason.name() });
/*     */   }
/*     */   
/*     */   private static void noticeAllFireworkComing(int activityId, OperFireorkReason reason, long startTime)
/*     */   {
/* 288 */     if (!needSendNotice(reason))
/*     */     {
/* 290 */       return;
/*     */     }
/*     */     
/* 293 */     OnlineManager.getInstance().sendAll(getSynStageProtocol(activityId, 2, startTime));
/*     */   }
/*     */   
/*     */   static xio.Protocol getSynStageProtocol(int activityId, int stage, long startTime)
/*     */   {
/* 298 */     SSynFireworkShowStage p = new SSynFireworkShowStage();
/* 299 */     p.activityid = activityId;
/* 300 */     p.stageinfo.stage = stage;
/* 301 */     p.stageinfo.stagestarttime = (startTime / 1000L);
/* 302 */     return p;
/*     */   }
/*     */   
/*     */   private static boolean needSendNotice(OperFireorkReason reason)
/*     */   {
/* 307 */     switch (reason)
/*     */     {
/*     */     case TIG_TIME_OUT: 
/*     */     case TIG_FINISH_COLLECT: 
/*     */     case TIG_GM: 
/* 312 */       return true;
/*     */     }
/*     */     
/* 315 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Set<Integer> getAllControllerIds(int activityId)
/*     */   {
/* 327 */     STFireworkCollectCfg cfg = STFireworkCollectCfg.get(activityId);
/* 328 */     if (cfg == null)
/*     */     {
/* 330 */       return java.util.Collections.emptySet();
/*     */     }
/* 332 */     Set<Integer> allControllers = new HashSet();
/* 333 */     for (Iterator i$ = cfg.triggerInfos.iterator(); i$.hasNext();) { int collectId = ((Integer)i$.next()).intValue();
/*     */       
/* 335 */       SFireworkCollectCfg fireCollectCfg = SFireworkCollectCfg.get(collectId);
/* 336 */       if (fireCollectCfg != null)
/*     */       {
/*     */ 
/*     */ 
/* 340 */         allControllers.add(Integer.valueOf(fireCollectCfg.controllerId)); }
/*     */     }
/* 342 */     return allControllers;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void tlogFindFirework(String userId, long roleId, int activityId, int findCount)
/*     */   {
/* 350 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 351 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 353 */     Object[] colums = { vGameIP, userId, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(activityId), Integer.valueOf(findCount) };
/*     */     
/* 355 */     TLogManager.getInstance().addLog(roleId, "FindFirework", colums);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void tlogFireworkHitAward(String userId, long roleId, int activityId, int awardCount)
/*     */   {
/* 363 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 364 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 366 */     Object[] colums = { vGameIP, userId, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(activityId), Integer.valueOf(awardCount) };
/*     */     
/* 368 */     TLogManager.getInstance().addLog(roleId, "FireworkHitAward", colums);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void loggerError(String format, Object... args)
/*     */   {
/* 376 */     GameServer.logger().error(loggerTag + String.format(format, args));
/*     */   }
/*     */   
/*     */   static void loggerInfo(String format, Object... args)
/*     */   {
/* 381 */     GameServer.logger().info(loggerTag + String.format(format, args));
/*     */   }
/*     */   
/*     */   static void loggerDebug(String format, Object... args)
/*     */   {
/* 386 */     if (!GameServer.logger().isDebugEnabled())
/*     */     {
/* 388 */       return;
/*     */     }
/* 390 */     GameServer.logger().debug(loggerTag + String.format(format, args));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\main\FireworkManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */