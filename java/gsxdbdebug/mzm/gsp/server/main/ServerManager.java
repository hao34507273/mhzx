/*     */ package mzm.gsp.server.main;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.SortedMap;
/*     */ import java.util.TreeMap;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.server.SSyncServerLevel;
/*     */ import mzm.gsp.serverconf.confbean.SServerLevelConfig;
/*     */ import mzm.gsp.serverconf.confbean.ServerConfigConsts;
/*     */ import mzm.gsp.task.surprise.SurpriseTaskInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.LevelTimeBean;
/*     */ import xbean.Pod;
/*     */ import xtable.Level2time;
/*     */ 
/*     */ class ServerManager
/*     */ {
/*  28 */   static final Logger logger = Logger.getLogger("ServerManager");
/*  29 */   private static ServerLevelObserver serverObserver = null;
/*     */   
/*     */   static final int ServerLevelChangeReason_GM = 1;
/*     */   static final int ServerLevelChangeReason_TIME_OUT = 2;
/*     */   static final int ServerLevelChangeReason_IDIP = 3;
/*     */   
/*     */   static void init() {}
/*     */   
/*     */   static LevelTimeBean getOrAddLevelTimeBean()
/*     */   {
/*  39 */     LevelTimeBean xLevelTimeBean = Level2time.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  40 */     if (xLevelTimeBean == null)
/*     */     {
/*  42 */       xLevelTimeBean = Pod.newLevelTimeBean();
/*  43 */       Level2time.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xLevelTimeBean);
/*     */     }
/*  45 */     return xLevelTimeBean;
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
/*     */ 
/*     */ 
/*     */   static void setCurrentLevel(LevelTimeBean xLevelTimeBean, int level, long nextUpgradeTimeSec, long startTimeSec)
/*     */   {
/*  61 */     xLevelTimeBean.setUpgradetime(nextUpgradeTimeSec);
/*  62 */     xLevelTimeBean.setStarttime(startTimeSec);
/*  63 */     xLevelTimeBean.setServerlevel(level);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getMaxServerLevel()
/*     */   {
/*  74 */     Map<Integer, SServerLevelConfig> map = SServerLevelConfig.getAll();
/*     */     
/*  76 */     if ((map instanceof TreeMap))
/*     */     {
/*  78 */       TreeMap<Integer, SServerLevelConfig> treeMap = (TreeMap)map;
/*  79 */       return ((Integer)treeMap.lastKey()).intValue();
/*     */     }
/*     */     
/*     */ 
/*  83 */     List<Integer> list = new ArrayList(SServerLevelConfig.getAll().keySet());
/*  84 */     return ((Integer)Collections.max(list)).intValue();
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
/*     */   static SServerLevelConfig getNextServerLevelBean(int level)
/*     */   {
/*  98 */     Map<Integer, SServerLevelConfig> map = SServerLevelConfig.getAll();
/*     */     
/* 100 */     if ((map instanceof TreeMap))
/*     */     {
/* 102 */       TreeMap<Integer, SServerLevelConfig> treeMap = (TreeMap)map;
/* 103 */       Map.Entry<Integer, SServerLevelConfig> entry = treeMap.higherEntry(Integer.valueOf(level));
/* 104 */       if (entry == null)
/*     */       {
/* 106 */         return null;
/*     */       }
/* 108 */       return (SServerLevelConfig)entry.getValue();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 114 */     List<Integer> list = new ArrayList(SServerLevelConfig.getAll().keySet());
/* 115 */     Collections.sort(list);
/* 116 */     int i = list.indexOf(Integer.valueOf(level));
/* 117 */     if (i == list.size() - 1)
/*     */     {
/* 119 */       return null;
/*     */     }
/* 121 */     if (i == -1)
/*     */     {
/* 123 */       int k = -1;
/* 124 */       for (int j = 0; j < list.size(); j++)
/*     */       {
/* 126 */         if (((Integer)list.get(j)).intValue() >= level)
/*     */         {
/* 128 */           k = j;
/* 129 */           break;
/*     */         }
/*     */       }
/* 132 */       if (k == -1)
/*     */       {
/* 134 */         return null;
/*     */       }
/* 136 */       if (((Integer)list.get(k)).intValue() > level)
/*     */       {
/* 138 */         return SServerLevelConfig.get(((Integer)list.get(k)).intValue());
/*     */       }
/*     */       
/*     */ 
/* 142 */       if (k == list.size() - 1)
/*     */       {
/* 144 */         return null;
/*     */       }
/*     */       
/*     */ 
/* 148 */       return SServerLevelConfig.get(((Integer)list.get(k + 1)).intValue());
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 156 */     return SServerLevelConfig.get(((Integer)list.get(i + 1)).intValue());
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
/*     */ 
/*     */ 
/*     */   static SServerLevelConfig getNextServerLevelBeanByTime(int level, long levelEndTime, long nowSec)
/*     */   {
/* 172 */     Map<Integer, SServerLevelConfig> map = SServerLevelConfig.getAll();
/* 173 */     TreeMap<Integer, SServerLevelConfig> treeMap = (TreeMap)map;
/* 174 */     Map.Entry<Integer, SServerLevelConfig> entry = treeMap.higherEntry(Integer.valueOf(level));
/* 175 */     long upgradeTime = levelEndTime;
/* 176 */     while ((entry != null) && (upgradeTime + TimeUnit.HOURS.toSeconds(((SServerLevelConfig)entry.getValue()).duration) < nowSec))
/*     */     {
/* 178 */       upgradeTime += TimeUnit.HOURS.toSeconds(((SServerLevelConfig)entry.getValue()).duration);
/* 179 */       entry = treeMap.higherEntry(entry.getKey());
/*     */     }
/* 181 */     if (entry == null)
/*     */     {
/* 183 */       return (SServerLevelConfig)treeMap.lastEntry().getValue();
/*     */     }
/*     */     
/*     */ 
/* 187 */     return (SServerLevelConfig)entry.getValue();
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
/*     */   static long getDurationBetweenLevel(int startLevel, int endLevel)
/*     */   {
/* 201 */     Map<Integer, SServerLevelConfig> map = SServerLevelConfig.getAll();
/* 202 */     TreeMap<Integer, SServerLevelConfig> treeMap = (TreeMap)map;
/* 203 */     long time = 0L;
/* 204 */     SortedMap<Integer, SServerLevelConfig> res = treeMap.subMap(Integer.valueOf(startLevel), false, Integer.valueOf(endLevel), true);
/* 205 */     for (SServerLevelConfig s : res.values())
/*     */     {
/* 207 */       time += TimeUnit.HOURS.toSeconds(s.duration);
/*     */     }
/* 209 */     return time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static SServerLevelConfig getServerLevelBeanBylevel(int level)
/*     */   {
/* 221 */     return SServerLevelConfig.get(level);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static SServerLevelConfig getFirstServerLevelBean()
/*     */   {
/* 228 */     Map<Integer, SServerLevelConfig> map = SServerLevelConfig.getAll();
/*     */     
/* 230 */     if ((map instanceof TreeMap))
/*     */     {
/* 232 */       TreeMap<Integer, SServerLevelConfig> treeMap = (TreeMap)map;
/* 233 */       return (SServerLevelConfig)treeMap.firstEntry().getValue();
/*     */     }
/*     */     
/*     */ 
/* 237 */     List<Integer> list = new ArrayList(SServerLevelConfig.getAll().keySet());
/* 238 */     int mimLevel = ((Integer)Collections.min(list)).intValue();
/*     */     
/* 240 */     return SServerLevelConfig.get(mimLevel);
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
/*     */   static void initServerLever()
/*     */   {
/* 253 */     if (isOpenServerTimeInit())
/*     */     {
/* 255 */       PSetServerLevel pSetServerLevel = new PSetServerLevel(null);
/* 256 */       if (pSetServerLevel.call())
/*     */       {
/* 258 */         resetObserver(pSetServerLevel.getInterval());
/* 259 */         String logStr = String.format("[serverlevel]ServerManager.initServerLever@init server level observer success |serverlevel=%d|persisttime=%d", new Object[] { Integer.valueOf(ServerLevelObject.getInstance().getLevel()), Long.valueOf(pSetServerLevel.getInterval()) });
/*     */         
/*     */ 
/*     */ 
/* 263 */         logger.info(logStr);
/*     */       }
/*     */       else
/*     */       {
/* 267 */         String logStr = String.format("[serverlevel]ServerManager.initServerLever@init server level observer fail|serverlevel=%d", new Object[] { Integer.valueOf(ServerLevelObject.getInstance().getLevel()) });
/*     */         
/*     */ 
/*     */ 
/* 271 */         logger.error(logStr);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 276 */       SServerLevelConfig firstConfig = getFirstServerLevelBean();
/* 277 */       if (firstConfig == null)
/*     */       {
/* 279 */         throw new RuntimeException("找不到第一个服务器等级配置");
/*     */       }
/* 281 */       long currenttime = DateTimeUtils.getCurrTimeInMillis();
/* 282 */       long endtime = DateTimeUtils.getTimeInToday(currenttime, 0, 0, 0) + TimeUnit.DAYS.toMillis(1L);
/*     */       
/* 284 */       ServerLevelObject.getInstance().update(firstConfig.level, TimeUnit.MILLISECONDS.toSeconds(currenttime), TimeUnit.MILLISECONDS.toSeconds(endtime));
/*     */       
/*     */ 
/* 287 */       String logStr = String.format("[serverlevel]ServerManager.initServerLever@openServerTime is not init currentServerLevel=%d", new Object[] { Integer.valueOf(firstConfig.level) });
/*     */       
/*     */ 
/*     */ 
/* 291 */       logger.warn(logStr);
/*     */     }
/*     */     
/*     */ 
/* 295 */     SurpriseTaskInterface.checkAndInitCurrentServerLevel();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isOpenServerTimeInit()
/*     */   {
/* 305 */     long openServerTime = GameServerInfoManager.getOpenServerTimestamp();
/* 306 */     return openServerTime > 0L;
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
/*     */ 
/*     */ 
/*     */   static void syncServerLevelToAll(int level, long startTime, long upgradeTime)
/*     */   {
/* 322 */     SSyncServerLevel serverLevel = new SSyncServerLevel();
/* 323 */     serverLevel.level = level;
/* 324 */     serverLevel.starttime = startTime;
/* 325 */     serverLevel.upgradetime = upgradeTime;
/*     */     
/* 327 */     serverLevel.ismaxlevel = (serverLevel.level == getMaxServerLevel() ? 1 : 0);
/*     */     
/* 329 */     OnlineManager.getInstance().sendAll(serverLevel);
/*     */   }
/*     */   
/*     */ 
/*     */   private static class PSetServerLevel
/*     */     extends LogicProcedure
/*     */   {
/*     */     private long interval;
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 341 */       SServerLevelConfig serverLevelConfig = ServerManager.getServerLevelBeanBylevel(ServerConfigConsts.getInstance().SERVER_STARTUP_LEVEL);
/*     */       
/* 343 */       long now = DateTimeUtils.getCurrTimeInMillis();
/* 344 */       long nowSec = TimeUnit.MILLISECONDS.toSeconds(now);
/* 345 */       if ((ServerConfigConsts.getInstance().SERVER_STARTUP_LEVEL == 0) || (serverLevelConfig == null))
/*     */       {
/* 347 */         LevelTimeBean xLevelTimeBean = Level2time.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 348 */         if (xLevelTimeBean == null)
/*     */         {
/*     */ 
/* 351 */           xLevelTimeBean = Pod.newLevelTimeBean();
/* 352 */           Level2time.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xLevelTimeBean);
/*     */           
/* 354 */           SServerLevelConfig nextBean = ServerManager.getFirstServerLevelBean();
/* 355 */           if (nextBean == null)
/*     */           {
/* 357 */             throw new RuntimeException("找不到第一个服务器等级配置");
/*     */           }
/*     */           
/* 360 */           long endtimeSec = TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getTimeInToday(now, 0, 0, 0) + TimeUnit.DAYS.toMillis(1L));
/*     */           
/* 362 */           long length = endtimeSec - nowSec;
/*     */           
/* 364 */           ServerManager.setCurrentLevel(xLevelTimeBean, nextBean.level, endtimeSec, nowSec);
/* 365 */           this.interval = length;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/* 372 */         else if (nowSec >= xLevelTimeBean.getUpgradetime())
/*     */         {
/* 374 */           long levelEndTime = ServerManager.getZeroTimeSec(xLevelTimeBean.getUpgradetime());
/* 375 */           SServerLevelConfig nextBean = ServerManager.getNextServerLevelBeanByTime(xLevelTimeBean.getServerlevel(), levelEndTime, nowSec);
/*     */           
/* 377 */           if ((nextBean != null) && (nextBean.level > xLevelTimeBean.getServerlevel()))
/*     */           {
/* 379 */             long duration = ServerManager.getDurationBetweenLevel(xLevelTimeBean.getServerlevel(), nextBean.level);
/*     */             
/*     */ 
/* 382 */             long nextLevelEndTime = levelEndTime + duration;
/* 383 */             if (nextLevelEndTime > nowSec)
/*     */             {
/* 385 */               ServerManager.setCurrentLevel(xLevelTimeBean, nextBean.level, nextLevelEndTime, levelEndTime);
/* 386 */               this.interval = (nextLevelEndTime - nowSec);
/*     */             }
/*     */             else
/*     */             {
/* 390 */               ServerManager.setCurrentLevel(xLevelTimeBean, nextBean.level, nextLevelEndTime, levelEndTime);
/* 391 */               this.interval = TimeUnit.HOURS.toSeconds(nextBean.duration);
/*     */             }
/*     */             
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/* 398 */             String logStr = String.format("[serverlevel]PSetServerLevel.processImp@not found next server level config|serverlevel=%d|maxconfiglevel=%d", new Object[] { Integer.valueOf(xLevelTimeBean.getServerlevel()), Integer.valueOf(ServerManager.getMaxServerLevel()) });
/*     */             
/*     */ 
/*     */ 
/* 402 */             ServerManager.logger.error(logStr);
/* 403 */             this.interval = (xLevelTimeBean.getUpgradetime() - xLevelTimeBean.getStarttime());
/*     */           }
/*     */           
/*     */         }
/*     */         else
/*     */         {
/* 409 */           this.interval = (xLevelTimeBean.getUpgradetime() - nowSec);
/*     */         }
/*     */         
/*     */ 
/* 413 */         ServerLevelObject.getInstance().update(xLevelTimeBean.getServerlevel(), xLevelTimeBean.getStarttime(), xLevelTimeBean.getUpgradetime());
/*     */         
/*     */ 
/* 416 */         return true;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 422 */       LevelTimeBean xLevelTimeBean = Level2time.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 423 */       if (xLevelTimeBean == null)
/*     */       {
/*     */ 
/* 426 */         xLevelTimeBean = Pod.newLevelTimeBean();
/* 427 */         Level2time.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xLevelTimeBean);
/*     */       }
/* 429 */       long duration = TimeUnit.HOURS.toSeconds(serverLevelConfig.duration);
/* 430 */       ServerManager.setCurrentLevel(xLevelTimeBean, serverLevelConfig.level, nowSec + duration, nowSec);
/*     */       
/* 432 */       this.interval = duration;
/*     */       
/* 434 */       ServerLevelObject.getInstance().update(xLevelTimeBean.getServerlevel(), xLevelTimeBean.getStarttime(), xLevelTimeBean.getUpgradetime());
/*     */       
/*     */ 
/* 437 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public long getInterval()
/*     */     {
/* 445 */       return this.interval;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static void resetObserver(long sec)
/*     */   {
/* 452 */     if (serverObserver != null)
/*     */     {
/* 454 */       serverObserver.stopTimer();
/*     */     }
/*     */     
/* 457 */     serverObserver = new ServerLevelObserver(sec);
/*     */   }
/*     */   
/*     */ 
/*     */   static List<Integer> getServerLevelList()
/*     */   {
/* 463 */     List<Integer> list = new ArrayList(SServerLevelConfig.getAll().keySet());
/*     */     
/* 465 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getServerStateSynInteval()
/*     */   {
/* 475 */     return TimeUnit.MINUTES.toSeconds(ServerConfigConsts.getInstance().SERVER_STATE_LOG_LENGTH);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getOpenServerDay(long curtime)
/*     */   {
/* 487 */     return Math.abs(DateTimeUtils.diffDays(curtime, getOpenServertime())) + 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getOpenServertime()
/*     */   {
/* 499 */     return GameServerInfoManager.getOpenServerTimestamp();
/*     */   }
/*     */   
/*     */ 
/*     */   static long computeEndTime(long now, long lengthSec)
/*     */   {
/* 505 */     long endTime = now + TimeUnit.SECONDS.toMillis(lengthSec);
/*     */     
/* 507 */     long zeroTime = DateTimeUtils.getTimeInToday(endTime, 0);
/* 508 */     if (Math.abs(endTime - zeroTime) < TimeUnit.MINUTES.toMillis(5L))
/*     */     {
/* 510 */       endTime = zeroTime;
/*     */     }
/*     */     else
/*     */     {
/* 514 */       long zeroAddOneDayTime = zeroTime + TimeUnit.DAYS.toMillis(1L);
/* 515 */       if (Math.abs(endTime - zeroAddOneDayTime) < TimeUnit.MINUTES.toMillis(5L))
/*     */       {
/* 517 */         endTime = zeroAddOneDayTime;
/*     */       }
/*     */     }
/*     */     
/* 521 */     return endTime;
/*     */   }
/*     */   
/*     */ 
/*     */   public static long computeEndTimeInMills(String endTime)
/*     */   {
/* 527 */     String ten = endTime.substring(0, 10);
/* 528 */     long end = DateTimeUtils.valueOf(ten);
/*     */     
/* 530 */     String min = null;
/* 531 */     if (endTime.length() >= 12)
/*     */     {
/* 533 */       min = endTime.substring(10, 12);
/*     */     }
/* 535 */     if (min != null)
/*     */     {
/* 537 */       end += TimeUnit.MINUTES.toMillis(Integer.valueOf(min).intValue());
/*     */     }
/*     */     
/* 540 */     String ss = null;
/* 541 */     if (endTime.length() >= 14)
/*     */     {
/* 543 */       ss = endTime.substring(12, 14);
/*     */     }
/* 545 */     if (ss != null)
/*     */     {
/* 547 */       end += TimeUnit.SECONDS.toMillis(Integer.valueOf(ss).intValue());
/*     */     }
/* 549 */     return end;
/*     */   }
/*     */   
/*     */ 
/*     */   static long getZeroTimeSec(long timeSec)
/*     */   {
/* 555 */     long time = timeSec + TimeUnit.HOURS.toSeconds(12L);
/* 556 */     return TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getTimeInToday(TimeUnit.SECONDS.toMillis(time), 0, 0, 0));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void tlogServerLevelChange(int curServerLevel, int orgServerLevel, long length, int reason)
/*     */   {
/* 564 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/* 565 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 566 */     long time = DateTimeUtils.getCurrTimeInMillis();
/* 567 */     String dtEventTime = sdf.format(Long.valueOf(time));
/*     */     
/* 569 */     String vGameAppid = "0";
/* 570 */     int PlatID = -1;
/* 571 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/* 572 */     String vopenid = "0";
/*     */     
/* 574 */     Object[] columns = { GameSvrId, dtEventTime, "0", Integer.valueOf(-1), Integer.valueOf(iZoneAreaID), "0", Integer.valueOf(curServerLevel), Integer.valueOf(orgServerLevel), Long.valueOf(length), Integer.valueOf(reason) };
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 579 */     TLogManager.getInstance().addLog("ServerLevelChange", columns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\server\main\ServerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */