/*     */ package mzm.gsp.activitypointexchange.main;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ActivityPointExchangeTLogManager
/*     */ {
/*     */   private static final String T_LOG_POINT_EXCHANGE = "ActivityPointExchangeLog";
/*     */   private static final String T_LOG_MANUAL_REFRESH = "ActivityPointExchangeCountManualRefreshLog";
/*     */   private static final String T_LOG_POINT_EXCHANGE_COUNT_RESET = "ActivityPointExchangeCountResetLog";
/*     */   private static final String T_LOG_MANUAL_REFRESH_COUNT_RESET = "ActivityPointExchangeManualRefreshCountResetLog";
/*     */   private static final String T_LOG_GOODS_SOLD_OUT = "ActivityPointExchangeGoodsSoldOutLog";
/*     */   
/*     */   private static void doTLog(long roleId, String tLogName, Object[] logColumns)
/*     */   {
/*  26 */     String userid = RoleInterface.getUserId(roleId);
/*     */     
/*  28 */     logColumns[0] = GameServerInfoManager.getHostIP();
/*  29 */     logColumns[1] = userid;
/*  30 */     logColumns[2] = Long.valueOf(roleId);
/*  31 */     logColumns[3] = Integer.valueOf(RoleInterface.getLevel(roleId));
/*     */     
/*  33 */     TLogManager.getInstance().addLog(userid, tLogName, logColumns);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void tLogActivityPointExchangeLog(long roleId, int activityId, int mallCfgId, int goodsCfgId, int count, int tokenType, long lastPointCount, long currentPointCount, int lastExchangeCount, int currentExchangeCount)
/*     */   {
/*  40 */     Object[] logColumns = new Object[13];
/*     */     
/*  42 */     logColumns[4] = Integer.valueOf(activityId);
/*  43 */     logColumns[5] = Integer.valueOf(mallCfgId);
/*  44 */     logColumns[6] = Integer.valueOf(goodsCfgId);
/*  45 */     logColumns[7] = Integer.valueOf(count);
/*  46 */     logColumns[8] = Integer.valueOf(tokenType);
/*  47 */     logColumns[9] = Long.valueOf(lastPointCount);
/*  48 */     logColumns[10] = Long.valueOf(currentPointCount);
/*  49 */     logColumns[11] = Integer.valueOf(lastExchangeCount);
/*  50 */     logColumns[12] = Integer.valueOf(currentExchangeCount);
/*     */     
/*  52 */     doTLog(roleId, "ActivityPointExchangeLog", logColumns);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void tLogActivityPointExchangeCountManualRefreshLog(long roleId, int activityId, int mallCfgId, int beforeRefreshCount, Map<Integer, Integer> beforeCfgId2count, int moneyType, int moneyCount)
/*     */   {
/*  59 */     Object[] logColumns = new Object[10];
/*     */     
/*  61 */     logColumns[4] = Integer.valueOf(activityId);
/*  62 */     logColumns[5] = Integer.valueOf(mallCfgId);
/*  63 */     logColumns[6] = Integer.valueOf(beforeRefreshCount);
/*  64 */     logColumns[7] = beforeCfgId2count.toString();
/*  65 */     logColumns[8] = Integer.valueOf(moneyType);
/*  66 */     logColumns[9] = Integer.valueOf(moneyCount);
/*     */     
/*  68 */     doTLog(roleId, "ActivityPointExchangeCountManualRefreshLog", logColumns);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void tLgoActivityPointExchangeCountResetLog(long roleId, int activityId, int mallCfgId, Map<Integer, Integer> beforeCfgId2count, long lastResetTimeStamp, long currentTimeStamp, long nextResetTimeStamp)
/*     */   {
/*  76 */     Object[] logColumns = new Object[10];
/*     */     
/*  78 */     logColumns[4] = Integer.valueOf(activityId);
/*  79 */     logColumns[5] = Integer.valueOf(mallCfgId);
/*  80 */     logColumns[6] = beforeCfgId2count.toString();
/*  81 */     logColumns[7] = Long.valueOf(lastResetTimeStamp);
/*  82 */     logColumns[8] = Long.valueOf(currentTimeStamp);
/*  83 */     logColumns[9] = Long.valueOf(nextResetTimeStamp);
/*     */     
/*  85 */     doTLog(roleId, "ActivityPointExchangeCountResetLog", logColumns);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void tLogActivityPointExchangeManualRefreshCountResetLog(long roleId, int activityId, int mallCfgId, int beforeRefreshCount, long lastResetTimeStamp, long currentTimeStamp, long nextResetTimeStamp)
/*     */   {
/*  92 */     Object[] logColumns = new Object[10];
/*     */     
/*  94 */     logColumns[4] = Integer.valueOf(activityId);
/*  95 */     logColumns[5] = Integer.valueOf(mallCfgId);
/*  96 */     logColumns[6] = Integer.valueOf(beforeRefreshCount);
/*  97 */     logColumns[7] = Long.valueOf(lastResetTimeStamp);
/*  98 */     logColumns[8] = Long.valueOf(currentTimeStamp);
/*  99 */     logColumns[9] = Long.valueOf(nextResetTimeStamp);
/*     */     
/* 101 */     doTLog(roleId, "ActivityPointExchangeManualRefreshCountResetLog", logColumns);
/*     */   }
/*     */   
/*     */ 
/*     */   static void tLogActivityPointExchangeGoodsSoldOutLog(int activityId, int mallCfgId, Collection<Integer> beforeSoldOutGoodsCfgIds, Collection<Integer> afterSoldOutGoodsCfgIds)
/*     */   {
/* 107 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/* 108 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 109 */     long time = DateTimeUtils.getCurrTimeInMillis();
/* 110 */     String dtEventTime = sdf.format(Long.valueOf(time));
/*     */     
/* 112 */     String vGameAppid = "0";
/* 113 */     int PlatID = -1;
/* 114 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/* 115 */     String vopenid = "0";
/*     */     
/* 117 */     Object[] logColumns = { GameSvrId, dtEventTime, "0", Integer.valueOf(-1), Integer.valueOf(iZoneAreaID), "0", Integer.valueOf(activityId), Integer.valueOf(mallCfgId), beforeSoldOutGoodsCfgIds.toString(), afterSoldOutGoodsCfgIds.toString() };
/*     */     
/*     */ 
/* 120 */     TLogManager.getInstance().addLog("ActivityPointExchangeGoodsSoldOutLog", logColumns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\main\ActivityPointExchangeTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */