/*     */ package mzm.gsp.redgift.main;
/*     */ 
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.confbean.RedGiftActivityConst;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.RedgiftRoleidSet;
/*     */ import xdb.Xdb;
/*     */ import xtable.Redgift;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class RedGiftManager
/*     */ {
/*  26 */   private static int RATE_BASE = 10000;
/*     */   
/*  28 */   public static int REDGIFT_TYPE_RATE_BASE = 10000;
/*     */   
/*  30 */   public static final Logger LOGGER = Logger.getLogger("redgift");
/*     */   
/*  32 */   private static long REDGIFT_ACTIVITY_TIME = 0L;
/*     */   private static final String REDGIFT_TLOG = "RedGiftLog";
/*     */   
/*     */   AwardReason getRecommendAwardReason()
/*     */   {
/*  37 */     return new AwardReason(LogReason.REDGIFT_AWARD_ADD);
/*     */   }
/*     */   
/*     */   static void onRedgiftStart(int redgiftTimeCfgId)
/*     */   {
/*  42 */     if (!isRedGiftFunOpen()) {
/*  43 */       return;
/*     */     }
/*     */     
/*  46 */     REDGIFT_TYPE_RATE_BASE = RedGiftActivityConst.getInstance().commonRewardRate + RedGiftActivityConst.getInstance().nullRewardRate + RedGiftActivityConst.getInstance().topRewardId;
/*     */     
/*  48 */     int randomValue = Xdb.random().nextInt(RATE_BASE);
/*     */     
/*  50 */     int baseRate = RedGiftActivityConst.getInstance().activityStartRate;
/*  51 */     if ((redgiftTimeCfgId == RedGiftActivityConst.getInstance().highStartRateId1) || (redgiftTimeCfgId == RedGiftActivityConst.getInstance().highStartRateId2)) {
/*  52 */       baseRate = RedGiftActivityConst.getInstance().highStartRate;
/*     */     }
/*  54 */     if (randomValue <= baseRate)
/*     */     {
/*  56 */       long localId = GameServerInfoManager.getLocalId();
/*  57 */       RedgiftRoleidSet xrRedgiftRoleidSet = Redgift.get(Long.valueOf(localId));
/*  58 */       if (xrRedgiftRoleidSet == null) {
/*  59 */         xrRedgiftRoleidSet = Pod.newRedgiftRoleidSet();
/*  60 */         Redgift.add(Long.valueOf(localId), xrRedgiftRoleidSet);
/*     */       }
/*  62 */       xrRedgiftRoleidSet.getRoleidset().clear();
/*  63 */       REDGIFT_ACTIVITY_TIME = DateTimeUtils.getCurrTimeInMillis() + TimeUnit.MINUTES.toMillis(RedGiftActivityConst.getInstance().activityBroadcastTime);
/*     */       
/*  65 */       new PRedgiftCountdownProcedure(RedGiftActivityConst.getInstance().activityBroadcastTime).execute();
/*     */       
/*  67 */       new RedgiftCountDownObserver(TimeUnit.MINUTES.toSeconds(RedGiftActivityConst.getInstance().activityBroadcastTime));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static void onRedgiftEnd()
/*     */   {
/*  74 */     long localId = GameServerInfoManager.getLocalId();
/*  75 */     RedgiftRoleidSet xrRedgiftRoleidSet = Redgift.get(Long.valueOf(localId));
/*  76 */     if (xrRedgiftRoleidSet != null) {
/*  77 */       xrRedgiftRoleidSet.getRoleidset().clear();
/*     */     } else {
/*  79 */       xrRedgiftRoleidSet = Pod.newRedgiftRoleidSet();
/*  80 */       Redgift.add(Long.valueOf(localId), xrRedgiftRoleidSet);
/*     */     }
/*  82 */     reSetRedgiftActivityLeftTime();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendRedgiftToOnlinePlayer()
/*     */   {
/*  92 */     if (!isRedGiftFunOpen()) {
/*  93 */       return;
/*     */     }
/*  95 */     reSetRedgiftActivityLeftTime();
/*  96 */     NoneRealTimeTaskManager.getInstance().addTask(new RCheckAddAllToGiftList());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void autoGetReward()
/*     */   {
/* 106 */     new PAutoGetRedgiftActivityRewardReq().execute();
/*     */   }
/*     */   
/*     */ 
/*     */   static void init() {}
/*     */   
/*     */ 
/*     */   static void postInit()
/*     */   {
/* 115 */     new RedgiftStartObserver(RedGiftActivityConst.getInstance().activityTime1);
/* 116 */     new RedgiftStartObserver(RedGiftActivityConst.getInstance().activityTime2);
/* 117 */     new RedgiftStartObserver(RedGiftActivityConst.getInstance().activityTime3);
/* 118 */     new RedgiftStartObserver(RedGiftActivityConst.getInstance().activityTime4);
/* 119 */     new RedgiftStartObserver(RedGiftActivityConst.getInstance().activityTime5);
/* 120 */     new RedgiftStartObserver(RedGiftActivityConst.getInstance().activityTime6);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRedGiftFunOpen()
/*     */   {
/* 129 */     if (GameServerInfoManager.isRoamServer()) {
/* 130 */       return false;
/*     */     }
/* 132 */     if (OpenInterface.getOpenStatus(26)) {
/* 133 */       return true;
/*     */     }
/* 135 */     LOGGER.info("IDIP关闭红包活动功能！");
/* 136 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRedGiftFunOpenWithRoleId(long roleid)
/*     */   {
/* 146 */     if (OpenInterface.isBanPlay(roleid, 27))
/*     */     {
/* 148 */       OpenInterface.sendBanPlayMsg(roleid, 27);
/* 149 */       return false;
/*     */     }
/* 151 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static long getRedgiftActivityLeftTime()
/*     */   {
/* 158 */     return REDGIFT_ACTIVITY_TIME;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void reSetRedgiftActivityLeftTime()
/*     */   {
/* 165 */     REDGIFT_ACTIVITY_TIME = 0L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isLevelOnGetRedgiftRange(int level)
/*     */   {
/* 174 */     if ((level >= ActivityInterface.getActivityLevelMin(RedGiftActivityConst.getInstance().activityId)) && (level <= ActivityInterface.getActivityLevelMax(RedGiftActivityConst.getInstance().activityId)))
/*     */     {
/* 176 */       return true;
/*     */     }
/* 178 */     return false;
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
/*     */   static void addRedGiftTlog(String userId, long roleId, int roleLevel, int yuanbao, int gold, int silver, int itemId1, int itemId2)
/*     */   {
/* 193 */     StringBuilder tLogStr = new StringBuilder();
/* 194 */     tLogStr.append(GameServerInfoManager.getHostIP()).append("|").append(userId).append("|").append(roleId).append("|").append(roleLevel).append("|").append(yuanbao).append("|").append(gold).append("|").append(silver).append("|").append(itemId1).append("|").append(itemId2);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 203 */     TLogManager.getInstance().addLog(roleId, "RedGiftLog", tLogStr.toString());
/*     */   }
/*     */   
/*     */   static void logWarn(String formatStr, Object... args) {
/* 207 */     LOGGER.warn(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   static void logError(String formatStr, Object... args) {
/* 211 */     LOGGER.error(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   static void logInfo(String formatStr, Object... args) {
/* 215 */     LOGGER.info(String.format(formatStr, args));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\redgift\main\RedGiftManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */