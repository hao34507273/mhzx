/*     */ package mzm.gsp.onlinetreasurebox.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.confbean.OnlineTreasureBoxActivityConst;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.TreasureBoxAwardInfo;
/*     */ import xbean.TreasureBoxExpInfo;
/*     */ import xdb.Xdb;
/*     */ import xtable.Treasureboxaward;
/*     */ import xtable.Treasureboxexp;
/*     */ 
/*     */ 
/*     */ class OnlineTreasureBoxManager
/*     */ {
/*  30 */   private static int RATE_BASE = 10000;
/*     */   
/*  32 */   public static final Logger LOGGER = Logger.getLogger(OnlineTreasureBoxManager.class);
/*     */   
/*  34 */   public static long TREASUREBOX_ACTIVITY_END_TIME = 0L;
/*     */   
/*  36 */   public static long TREASUREBOX_BROADCAST_TIME = 0L;
/*     */   
/*  38 */   public static OnlineTreasureBoxActionEnum onlineTreasureBoxActionEnum = OnlineTreasureBoxActionEnum.CLOSE_STAGE;
/*     */   
/*  40 */   private static String ONLINE_TREASURE_BOX = "OnlineTreasureBoxLog";
/*     */   
/*     */   public AwardReason getRecommendAwardReason() {
/*  43 */     return new AwardReason(LogReason.REDGIFT_AWARD_ADD);
/*     */   }
/*     */   
/*     */   public static void onTreasureBoxStartWithRate(int treasureStartRate)
/*     */   {
/*  48 */     if (!isOnlineTreasureBoxFunOpen()) {
/*  49 */       return;
/*     */     }
/*     */     
/*     */ 
/*  53 */     int randomValue = Xdb.random().nextInt(RATE_BASE);
/*     */     
/*  55 */     if (randomValue <= treasureStartRate)
/*     */     {
/*  57 */       long localId = GameServerInfoManager.getLocalId();
/*     */       
/*  59 */       TreasureBoxExpInfo xTreasureBoxExpInfo = Treasureboxexp.get(Long.valueOf(localId));
/*  60 */       if (xTreasureBoxExpInfo == null) {
/*  61 */         xTreasureBoxExpInfo = Pod.newTreasureBoxExpInfo();
/*  62 */         Treasureboxexp.add(Long.valueOf(localId), xTreasureBoxExpInfo);
/*     */       }
/*  64 */       TreasureBoxAwardInfo xTreasureBoxAwardInfo = Treasureboxaward.get(Long.valueOf(localId));
/*  65 */       if (xTreasureBoxAwardInfo == null) {
/*  66 */         xTreasureBoxAwardInfo = Pod.newTreasureBoxAwardInfo();
/*  67 */         Treasureboxaward.add(Long.valueOf(localId), xTreasureBoxAwardInfo);
/*     */       }
/*     */       
/*  70 */       onlineTreasureBoxActionEnum = OnlineTreasureBoxActionEnum.BROADCAST_STAGE;
/*     */       
/*  72 */       TREASUREBOX_BROADCAST_TIME = DateTimeUtils.getCurrTimeInMillis() + TimeUnit.MINUTES.toMillis(OnlineTreasureBoxActivityConst.getInstance().activityBroadcastTime);
/*  73 */       TREASUREBOX_ACTIVITY_END_TIME = TREASUREBOX_BROADCAST_TIME + TimeUnit.MINUTES.toMillis(OnlineTreasureBoxActivityConst.getInstance().activityIntervalTime);
/*     */       
/*  75 */       long time1 = TimeUnit.MINUTES.toSeconds(OnlineTreasureBoxActivityConst.getInstance().activityBroadcastTime);
/*  76 */       long time2 = TimeUnit.MINUTES.toSeconds(OnlineTreasureBoxActivityConst.getInstance().activityBroadcastTime + OnlineTreasureBoxActivityConst.getInstance().activityIntervalTime);
/*     */       
/*  78 */       new OnlineTreasureBoxBoradcastEndObserver(time1);
/*     */       
/*  80 */       new OnlineTreasureBoxEndObserver(time2);
/*     */       
/*  82 */       new POnlineTreasureBoxBroadcastProcedure(time1, time2).execute();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void init() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public static void postInit()
/*     */   {
/*  95 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  97 */       return;
/*     */     }
/*  99 */     new OnlineTreasureBoxStartObserver(OnlineTreasureBoxActivityConst.getInstance().activityTime1, OnlineTreasureBoxActivityConst.getInstance().activityRate1);
/* 100 */     new OnlineTreasureBoxStartObserver(OnlineTreasureBoxActivityConst.getInstance().activityTime2, OnlineTreasureBoxActivityConst.getInstance().activityRate2);
/* 101 */     new OnlineTreasureBoxStartObserver(OnlineTreasureBoxActivityConst.getInstance().activityTime3, OnlineTreasureBoxActivityConst.getInstance().activityRate3);
/* 102 */     new OnlineTreasureBoxStartObserver(OnlineTreasureBoxActivityConst.getInstance().activityTime4, OnlineTreasureBoxActivityConst.getInstance().activityRate4);
/* 103 */     new OnlineTreasureBoxStartObserver(OnlineTreasureBoxActivityConst.getInstance().activityTime5, OnlineTreasureBoxActivityConst.getInstance().activityRate5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isOnlineTreasureBoxSwitchOpenForRole(long roleid)
/*     */   {
/* 114 */     if (!isOnlineTreasureBoxFunOpen())
/*     */     {
/* 116 */       OpenInterface.sendCloseProtocol(roleid, 109, null);
/*     */       
/* 118 */       return false;
/*     */     }
/* 120 */     if (OpenInterface.isBanPlay(roleid, 109))
/*     */     {
/* 122 */       OpenInterface.sendBanPlayMsg(roleid, 109);
/* 123 */       return false;
/*     */     }
/* 125 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isOnlineTreasureBoxFunOpen()
/*     */   {
/* 136 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/* 138 */       return false;
/*     */     }
/* 140 */     if (!OpenInterface.getOpenStatus(109))
/*     */     {
/* 142 */       if (LOGGER.isDebugEnabled()) {
/* 143 */         LOGGER.debug("OnlineTreasureBoxManager.isOnlineTreasureBoxFunOpen@onlinetreasurebox activity not open!");
/*     */       }
/* 145 */       return false;
/*     */     }
/* 147 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 148 */     SActivityCfg sActivityCfg = SActivityCfg.get(OnlineTreasureBoxActivityConst.getInstance().activityId);
/* 149 */     if ((sActivityCfg != null) && 
/* 150 */       (!inActivityLimitTime(curTime, sActivityCfg))) {
/* 151 */       if (LOGGER.isDebugEnabled()) {
/* 152 */         LOGGER.debug("OnlineTreasureBoxManager.isOnlineTreasureBoxFunOpen@activity time not at start time!");
/*     */       }
/* 154 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 158 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean inActivityLimitTime(long curTime, SActivityCfg activityCfg)
/*     */   {
/* 169 */     long LimitTimeBegin = getActivityLimitTimeBegin(activityCfg.id);
/* 170 */     if ((LimitTimeBegin > 0L) && 
/* 171 */       (curTime < LimitTimeBegin)) {
/* 172 */       return false;
/*     */     }
/*     */     
/* 175 */     long limitTimeEnd = getActivityLimitTimeEnd(activityCfg.id);
/* 176 */     if ((limitTimeEnd > 0L) && 
/* 177 */       (curTime >= limitTimeEnd)) {
/* 178 */       return false;
/*     */     }
/*     */     
/* 181 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static long getActivityLimitTimeBegin(int activityid)
/*     */   {
/* 192 */     SActivityCfg sActivityCfg = SActivityCfg.get(activityid);
/* 193 */     if (sActivityCfg == null) {
/* 194 */       return -1L;
/*     */     }
/* 196 */     if (sActivityCfg.activityLimitTimeid <= 0) {
/* 197 */       return -1L;
/*     */     }
/* 199 */     return TimeCommonUtil.getLimitTimeBegin(sActivityCfg.activityLimitTimeid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static long getActivityLimitTimeEnd(int activityid)
/*     */   {
/* 209 */     SActivityCfg sActivityCfg = SActivityCfg.get(activityid);
/* 210 */     if (sActivityCfg == null) {
/* 211 */       return -1L;
/*     */     }
/* 213 */     if (sActivityCfg.activityLimitTimeid <= 0) {
/* 214 */       return -1L;
/*     */     }
/* 216 */     return TimeCommonUtil.getLimitTimeEnd(sActivityCfg.activityLimitTimeid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static boolean canJoinOnlineTreasureBoxWithLevel(int level)
/*     */   {
/* 226 */     if ((level >= ActivityInterface.getActivityLevelMin(OnlineTreasureBoxActivityConst.getInstance().activityId)) && (level <= ActivityInterface.getActivityLevelMax(OnlineTreasureBoxActivityConst.getInstance().activityId)))
/*     */     {
/* 228 */       return true;
/*     */     }
/* 230 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static List<Long> getOnlineReceiverRoleId()
/*     */   {
/* 238 */     List<Long> levelHighSet = OnlineManager.getInstance().getOnlineHigherRoleidList(ActivityInterface.getActivityLevelMin(OnlineTreasureBoxActivityConst.getInstance().activityId));
/* 239 */     List<Long> levelLowSet = OnlineManager.getInstance().getOnlineLowererRoleidList(ActivityInterface.getActivityLevelMax(OnlineTreasureBoxActivityConst.getInstance().activityId));
/* 240 */     List<Long> receiverSet = new ArrayList();
/* 241 */     for (Iterator i$ = levelHighSet.iterator(); i$.hasNext();) { long rolid = ((Long)i$.next()).longValue();
/* 242 */       if (levelLowSet.contains(Long.valueOf(rolid))) {
/* 243 */         receiverSet.add(Long.valueOf(rolid));
/*     */       }
/*     */     }
/* 246 */     return receiverSet;
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
/*     */   static void addOnlineTreasureBoxTlog(String userId, long roleId, int roleLevel, int yuanbao, int gold, int silver, int itemId1, int itemId2)
/*     */   {
/* 261 */     StringBuilder tLogStr = new StringBuilder();
/* 262 */     tLogStr.append(GameServerInfoManager.getHostIP()).append("|").append(userId).append("|").append(roleId).append("|").append(roleLevel).append("|").append(yuanbao).append("|").append(gold).append("|").append(silver).append("|").append(itemId1).append("|").append(itemId2);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 271 */     TLogManager.getInstance().addLog(roleId, ONLINE_TREASURE_BOX, tLogStr.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\onlinetreasurebox\main\OnlineTreasureBoxManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */