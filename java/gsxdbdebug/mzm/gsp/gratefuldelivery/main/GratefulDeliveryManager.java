/*     */ package mzm.gsp.gratefuldelivery.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.gratefuldelivery.SNotifyReward;
/*     */ import mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg;
/*     */ import mzm.gsp.gratefuldelivery.confbean.SDeliveryStageCfg;
/*     */ import mzm.gsp.gratefuldelivery.confbean.SStageInformation;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.DeliveryStatus;
/*     */ import xbean.DeliveryStatuses;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleDeliveryRecord;
/*     */ import xbean.RoleDeliveryRecords;
/*     */ import xbean.RoleDeliveryStatus;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Xdb;
/*     */ import xtable.Grateful_delivery_status;
/*     */ import xtable.Role2gratefuldelivery;
/*     */ 
/*     */ class GratefulDeliveryManager
/*     */ {
/*  37 */   static boolean postInitFlag = false;
/*     */   
/*  39 */   private static final Logger logger = Logger.getLogger("GratefulDelivery");
/*     */   private static final String TLOG_DISTRIBUTE = "DeliveryDistributed";
/*     */   
/*  42 */   static void debug(Object cls, String str, Object... args) { if (logger.isDebugEnabled())
/*  43 */       logger.debug(String.format("[GratefulDelivery]" + cls.getClass().getSimpleName() + str, args));
/*     */   }
/*     */   
/*     */   static void info(Object cls, String str, Object... args) {
/*  47 */     logger.info(String.format("[GratefulDelivery]" + cls.getClass().getSimpleName() + str, args));
/*     */   }
/*     */   
/*     */   static void error(Object cls, String str, Object... args) {
/*  51 */     logger.error(String.format("[GratefulDelivery]" + cls.getClass().getSimpleName() + str, args));
/*     */   }
/*     */   
/*     */   private static void debug(String str, Object... args) {
/*  55 */     if (logger.isDebugEnabled())
/*  56 */       logger.debug(String.format("[GratefulDelivery]GratefulDeliveryManager" + str, args));
/*     */   }
/*     */   
/*     */   private static void info(String str, Object... args) {
/*  60 */     logger.info(String.format("[GratefulDelivery]GratefulDeliveryManager" + str, args));
/*     */   }
/*     */   
/*     */   private static void error(String str, Object... args) {
/*  64 */     logger.error(String.format("[GratefulDelivery]GratefulDeliveryManager" + str, args));
/*     */   }
/*     */   
/*     */ 
/*     */   private static final String TLOG_MANUAL = "ManualDelivery";
/*     */   
/*     */   private static void tlog(long roleId, String logName, Object... args)
/*     */   {
/*  72 */     String userId = RoleInterface.getUserId(roleId);
/*  73 */     if (userId == null)
/*  74 */       return;
/*  75 */     List<Object> list = new ArrayList();
/*  76 */     list.add(GameServerInfoManager.getHostIP());
/*  77 */     list.add(userId);
/*  78 */     list.add(Long.valueOf(roleId));
/*  79 */     list.add(Integer.valueOf(RoleInterface.getLevel(roleId)));
/*  80 */     Collections.addAll(list, args);
/*  81 */     mzm.gsp.tlog.TLogManager.getInstance().addLog(userId, logName, list.toArray());
/*     */   }
/*     */   
/*     */ 
/*     */   static void tlogDistribute(long roleId, int activityId)
/*     */   {
/*  87 */     tlog(roleId, "DeliveryDistributed", new Object[] { Integer.valueOf(activityId) });
/*     */   }
/*     */   
/*     */ 
/*     */   static void tlogManualDelivery(long roleId, int activityId, long targetRoleId)
/*     */   {
/*  93 */     tlog(roleId, "ManualDelivery", new Object[] { Integer.valueOf(activityId), Long.valueOf(targetRoleId) });
/*     */   }
/*     */   
/*     */ 
/*     */   static void tlogAutoDelivery(long roleId, int activityId, long targetRoleId)
/*     */   {
/*  99 */     tlog(roleId, "AutoDelivery", new Object[] { Integer.valueOf(activityId), Long.valueOf(targetRoleId) });
/*     */   }
/*     */   
/*     */ 
/*     */   static void tlogRecycled(long roleId, int activityId)
/*     */   {
/* 105 */     tlog(roleId, "DeliveryRecycled", new Object[] { Integer.valueOf(activityId) });
/*     */   }
/*     */   
/*     */ 
/*     */   private static final String TLOG_AUTO = "AutoDelivery";
/*     */   
/*     */   private static final String TLOG_RECYCLED = "DeliveryRecycled";
/* 112 */   private static final Map<Integer, Set<Long>> availableRoleMap = new java.util.HashMap();
/* 113 */   private static final ReadWriteLock availableRoleMapLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*     */   
/*     */   private static void getCacheReadLock() {
/* 116 */     availableRoleMapLock.readLock().lock();
/*     */   }
/*     */   
/*     */   private static void releaseCacheReadLock() {
/* 120 */     availableRoleMapLock.readLock().unlock();
/*     */   }
/*     */   
/*     */   private static void getCacheWriteLock() {
/* 124 */     availableRoleMapLock.writeLock().lock();
/*     */   }
/*     */   
/*     */   private static void releaseCacheWriteLock() {
/* 128 */     availableRoleMapLock.writeLock().unlock();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void init()
/*     */   {
/*     */     
/*     */     
/*     */ 
/*     */     try
/*     */     {
/* 141 */       for (SDeliveryCfg cfg : SDeliveryCfg.getAll().values())
/*     */       {
/*     */ 
/* 144 */         SActivityCfg sActivityCfg = SActivityCfg.get(cfg.activityId);
/* 145 */         if (sActivityCfg == null)
/*     */         {
/* 147 */           error(".init()@SActivityCfg not found|activity_cfgid=%d", new Object[] { Integer.valueOf(cfg.activityId) });
/*     */         }
/*     */         else
/*     */         {
/* 151 */           int logicType = sActivityCfg.activityLogicType;
/* 152 */           ActivityInterface.registerActivityByLogicType(logicType, new GratefulDeliveryActivityHandler());
/*     */           
/*     */ 
/* 155 */           availableRoleMap.put(Integer.valueOf(cfg.activityId), new HashSet());
/*     */         }
/*     */       }
/*     */     }
/*     */     finally {
/* 160 */       releaseCacheWriteLock();
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
/*     */   static void initRoleData(int activityId, long roleId)
/*     */   {
/* 174 */     int currentDate = getCurrentDate();
/*     */     
/*     */ 
/* 177 */     RoleDeliveryRecords xRoleDeliveryRecords = Role2gratefuldelivery.get(Long.valueOf(roleId));
/* 178 */     if (xRoleDeliveryRecords == null)
/*     */     {
/* 180 */       xRoleDeliveryRecords = Pod.newRoleDeliveryRecords();
/* 181 */       Role2gratefuldelivery.insert(Long.valueOf(roleId), xRoleDeliveryRecords);
/*     */     }
/*     */     
/*     */ 
/* 185 */     RoleDeliveryRecord xRoleDeliveryRecord = (RoleDeliveryRecord)xRoleDeliveryRecords.getRecords().get(Integer.valueOf(activityId));
/* 186 */     if (xRoleDeliveryRecord == null)
/*     */     {
/* 188 */       xRoleDeliveryRecord = Pod.newRoleDeliveryRecord();
/* 189 */       xRoleDeliveryRecords.getRecords().put(Integer.valueOf(activityId), xRoleDeliveryRecord);
/*     */     }
/*     */     
/*     */ 
/* 193 */     RoleDeliveryStatus xRoleDeliveryStatus = (RoleDeliveryStatus)xRoleDeliveryRecord.getStatuses().get(Integer.valueOf(currentDate));
/* 194 */     if (xRoleDeliveryStatus == null)
/*     */     {
/* 196 */       xRoleDeliveryStatus = Pod.newRoleDeliveryStatus();
/* 197 */       xRoleDeliveryStatus.setSource_id(-1L);
/* 198 */       xRoleDeliveryStatus.setTarget_id(-1L);
/* 199 */       xRoleDeliveryRecord.getStatuses().put(Integer.valueOf(currentDate), xRoleDeliveryStatus);
/*     */     }
/*     */     
/* 202 */     debug(".initRoleData()@done|activity_cfgid=%d|roleid=%d", new Object[] { Integer.valueOf(activityId), Long.valueOf(roleId) });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void initActivityData(int activityId)
/*     */   {
/* 214 */     long key = GameServerInfoManager.toGlobalId(activityId);
/* 215 */     DeliveryStatuses xDeliveryStatuses = Grateful_delivery_status.get(Long.valueOf(key));
/* 216 */     if (xDeliveryStatuses == null)
/*     */     {
/* 218 */       xDeliveryStatuses = Pod.newDeliveryStatuses();
/* 219 */       Grateful_delivery_status.insert(Long.valueOf(key), xDeliveryStatuses);
/*     */     }
/*     */     
/*     */ 
/* 223 */     int date = getCurrentDate();
/* 224 */     xDeliveryStatuses.setDate(date);
/*     */     
/* 226 */     DeliveryStatus xDeliveryStatus = Pod.newDeliveryStatus();
/* 227 */     xDeliveryStatuses.getStatuses().put(Integer.valueOf(date), xDeliveryStatus);
/*     */     
/* 229 */     info(".initActivityData()@done|activity_cfgid=%d|date=%d", new Object[] { Integer.valueOf(activityId), Integer.valueOf(date) });
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean canReceiveItem(int activityId, long roleId)
/*     */   {
/* 250 */     SDeliveryCfg sDeliveryCfg = SDeliveryCfg.get(activityId);
/* 251 */     if (sDeliveryCfg == null) {
/* 252 */       return false;
/*     */     }
/* 254 */     String userId = RoleInterface.getUserId(roleId);
/* 255 */     if (userId == null) {
/* 256 */       return false;
/*     */     }
/* 258 */     int deliveryCount = ActivityInterface.getActivityCount(userId, roleId, activityId, true);
/* 259 */     if (deliveryCount == -1) {
/* 260 */       return false;
/*     */     }
/* 262 */     DeliveryStatus xDeliveryStatus = getLatestDeliveryStatus(activityId, true);
/* 263 */     if (xDeliveryStatus == null) {
/* 264 */       return false;
/*     */     }
/* 266 */     if (xDeliveryStatus.getItem_holders().containsKey(Long.valueOf(roleId))) {
/* 267 */       deliveryCount++;
/*     */     }
/* 269 */     return (RoleInterface.getLevel(roleId) >= sDeliveryCfg.minLevel) && (deliveryCount < sDeliveryCfg.maxDeliveryCountPerDay);
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
/*     */   static boolean canReceiveItemNow(int activityId, long roleId)
/*     */   {
/* 283 */     return (!hasItem(activityId, roleId)) && (removeFromAvailableRoleMap(activityId, roleId));
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
/*     */   static boolean hasItem(int activityId, long roleId)
/*     */   {
/* 296 */     DeliveryStatus xDeliveryStatus = getLatestDeliveryStatus(activityId, false);
/* 297 */     return (xDeliveryStatus != null) && (xDeliveryStatus.getItem_holders().containsKey(Long.valueOf(roleId)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void clearAvailableRoleMap(int activityId)
/*     */   {
/*     */     
/*     */     
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 312 */       Set<Long> set = (Set)availableRoleMap.get(Integer.valueOf(activityId));
/* 313 */       if (set != null) {
/* 314 */         set.clear();
/*     */       }
/*     */     }
/*     */     finally {
/* 318 */       releaseCacheWriteLock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getAvailableRoleCount(int activityId)
/*     */   {
/*     */     
/*     */     
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 334 */       Set<Long> set = (Set)availableRoleMap.get(Integer.valueOf(activityId));
/* 335 */       int i; if (set != null) {
/* 336 */         return set.size();
/*     */       }
/* 338 */       return 0;
/*     */     }
/*     */     finally
/*     */     {
/* 342 */       releaseCacheReadLock();
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
/*     */   static void updateRoleInAvailableRoleMap(int activityId, long roleId)
/*     */   {
/* 357 */     if ((canReceiveItem(activityId, roleId)) && (OnlineManager.getInstance().isOnline(roleId))) {
/* 358 */       addIntoAvailableRoleMap(activityId, roleId);
/*     */     } else {
/* 360 */       removeFromAvailableRoleMap(activityId, roleId);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addIntoAvailableRoleMap(int activityId, long roleId)
/*     */   {
/*     */     
/*     */     
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 375 */       Set<Long> availableRoleSet = (Set)availableRoleMap.get(Integer.valueOf(activityId));
/* 376 */       if (availableRoleSet != null) {
/* 377 */         availableRoleSet.add(Long.valueOf(roleId));
/*     */       }
/*     */     }
/*     */     finally {
/* 381 */       releaseCacheWriteLock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean removeFromAvailableRoleMap(int activityId, long roleId)
/*     */   {
/*     */     
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 398 */       Set<Long> availableRoleSet = (Set)availableRoleMap.get(Integer.valueOf(activityId));
/* 399 */       return (availableRoleSet != null) && (availableRoleSet.remove(Long.valueOf(roleId)));
/*     */     }
/*     */     finally
/*     */     {
/* 403 */       releaseCacheWriteLock();
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
/*     */ 
/*     */ 
/*     */   static Long getAndRemoveAvailableRoleId(int activityId, long roleId)
/*     */   {
/* 420 */     Set<Long> friendSet = new HashSet(FriendInterface.getAllFriends(roleId, false));
/* 421 */     getCacheWriteLock();
/*     */     try
/*     */     {
/* 424 */       Set<Long> availableRoleSet = (Set)availableRoleMap.get(Integer.valueOf(activityId));
/* 425 */       if (availableRoleSet == null) {
/* 426 */         return null;
/*     */       }
/* 428 */       Long targetRoleId = null;
/*     */       
/* 430 */       friendSet.retainAll(availableRoleSet);
/* 431 */       List<Long> allAvailableRoles; if (friendSet.size() > 0)
/*     */       {
/* 433 */         List<Long> friendList = new ArrayList(friendSet);
/* 434 */         targetRoleId = (Long)friendList.get(Xdb.random().nextInt(friendList.size()));
/*     */       }
/*     */       else
/*     */       {
/* 438 */         allAvailableRoles = new ArrayList(availableRoleSet);
/* 439 */         if (allAvailableRoles.size() > 0) {
/* 440 */           targetRoleId = (Long)allAvailableRoles.get(Xdb.random().nextInt(allAvailableRoles.size()));
/*     */         }
/*     */       }
/* 443 */       if (targetRoleId != null) {
/* 444 */         availableRoleSet.remove(targetRoleId);
/*     */       }
/* 446 */       return targetRoleId;
/*     */     }
/*     */     finally
/*     */     {
/* 450 */       releaseCacheWriteLock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Long getAndRemoveAvailableRoleId(int activityId)
/*     */   {
/*     */     
/*     */     
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 466 */       Set<Long> availableRoleSet = (Set)availableRoleMap.get(Integer.valueOf(activityId));
/* 467 */       if (availableRoleSet == null) {
/* 468 */         return null;
/*     */       }
/* 470 */       Long targetRoleId = null;
/*     */       List<Long> availableRoleList;
/* 472 */       if (availableRoleSet.size() > 0)
/*     */       {
/* 474 */         availableRoleList = new ArrayList(availableRoleSet);
/* 475 */         targetRoleId = (Long)availableRoleList.get(Xdb.random().nextInt(availableRoleList.size()));
/*     */       }
/*     */       
/* 478 */       if (targetRoleId != null) {
/* 479 */         availableRoleSet.remove(targetRoleId);
/*     */       }
/* 481 */       return targetRoleId;
/*     */     }
/*     */     finally
/*     */     {
/* 485 */       releaseCacheWriteLock();
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
/*     */ 
/*     */ 
/*     */   static Set<Long> getAvailableFriends(int activityId, long roleId)
/*     */   {
/* 502 */     Set<Long> friendSet = new HashSet(FriendInterface.getAllFriends(roleId, false));
/* 503 */     getCacheReadLock();
/*     */     try
/*     */     {
/* 506 */       Set<Long> availableRoleSet = (Set)availableRoleMap.get(Integer.valueOf(activityId));
/* 507 */       Object localObject1; if (availableRoleSet == null) {
/* 508 */         return new HashSet();
/*     */       }
/* 510 */       friendSet.retainAll(availableRoleSet);
/* 511 */       return friendSet;
/*     */     }
/*     */     finally
/*     */     {
/* 515 */       releaseCacheReadLock();
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
/*     */ 
/*     */ 
/*     */   static boolean recycleItem(int activityId, long sourceId)
/*     */   {
/* 532 */     if (sourceId != 0L)
/*     */     {
/* 534 */       SDeliveryCfg sDeliveryCfg = SDeliveryCfg.get(activityId);
/* 535 */       if (sDeliveryCfg == null) {
/* 536 */         return false;
/*     */       }
/* 538 */       String sourceUserId = RoleInterface.getUserId(sourceId);
/* 539 */       if (sourceUserId == null) {
/* 540 */         return false;
/*     */       }
/*     */       
/* 543 */       Lockeys.lock(xtable.User.getTable(), Collections.singletonList(sourceUserId));
/* 544 */       Lockeys.lock(Role2gratefuldelivery.getTable(), Collections.singletonList(Long.valueOf(sourceId)));
/* 545 */       Lockeys.lock(Grateful_delivery_status.getTable(), Collections.singletonList(Long.valueOf(GameServerInfoManager.toGlobalId(activityId))));
/*     */       
/* 547 */       RoleDeliveryStatus xRoleDeliveryStatus = getLatestRoleDeliveryStatus(activityId, sourceId, true);
/* 548 */       DeliveryStatus xDeliveryStatus = getLatestDeliveryStatus(activityId, true);
/* 549 */       if ((xRoleDeliveryStatus == null) || (xDeliveryStatus == null))
/*     */       {
/* 551 */         error(".recycleItem@data not found|activity_cfgid=%d|roleid=%d", new Object[] { Integer.valueOf(activityId), Long.valueOf(sourceId) });
/* 552 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 556 */       ActivityInterface.addActivityCount(sourceUserId, sourceId, activityId);
/* 557 */       xRoleDeliveryStatus.setTarget_id(0L);
/* 558 */       xDeliveryStatus.getRecycled_item_list().add(Long.valueOf(sourceId));
/* 559 */       xDeliveryStatus.getItem_holders().remove(Long.valueOf(sourceId));
/*     */       
/*     */ 
/* 562 */       updateRoleInAvailableRoleMap(activityId, sourceId);
/*     */       
/*     */ 
/* 565 */       mzm.gsp.gratefuldelivery.SNotifyAutoDelivery sNotifyAutoDelivery = new mzm.gsp.gratefuldelivery.SNotifyAutoDelivery();
/* 566 */       sNotifyAutoDelivery.activity_id = activityId;
/* 567 */       sNotifyAutoDelivery.target_id = 0L;
/* 568 */       OnlineManager.getInstance().send(sourceId, sNotifyAutoDelivery);
/*     */       
/*     */ 
/* 571 */       mzm.gsp.award.main.AwardReason reason = new mzm.gsp.award.main.AwardReason(mzm.gsp.tlog.LogReason.AUTO_REDELIVERY_REWARD, sDeliveryCfg.activitySubtype);
/* 572 */       mzm.gsp.award.main.AwardInterface.award(sDeliveryCfg.autoDeliveryRewardId, sourceUserId, sourceId, false, true, reason);
/*     */       
/* 574 */       tlogRecycled(sourceId, activityId);
/* 575 */       info(".recycleItem()@item recycled|activity_cfgid=%d|source_roleid=%d", new Object[] { Integer.valueOf(activityId), Long.valueOf(sourceId) });
/*     */     }
/*     */     else
/*     */     {
/* 579 */       DeliveryStatus xDeliveryStatus = getLatestDeliveryStatus(activityId, true);
/* 580 */       if (xDeliveryStatus == null)
/*     */       {
/* 582 */         error(".recycleItem@data not found|activity_cfgid=%d", new Object[] { Integer.valueOf(activityId) });
/* 583 */         return false;
/*     */       }
/*     */       
/* 586 */       xDeliveryStatus.getRecycled_item_list().add(Long.valueOf(0L));
/*     */     }
/*     */     
/* 589 */     return true;
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
/*     */   static boolean checkAndBroadcastReward(int activityId)
/*     */   {
/* 602 */     SActivityCfg sActivityCfg = SActivityCfg.get(activityId);
/* 603 */     SDeliveryStageCfg sDeliveryStageCfg = SDeliveryStageCfg.get(activityId);
/* 604 */     if ((sActivityCfg == null) || (sDeliveryStageCfg == null)) {
/* 605 */       return false;
/*     */     }
/* 607 */     DeliveryStatus xDeliveryStatus = getLatestDeliveryStatus(activityId, true);
/* 608 */     if (xDeliveryStatus == null) {
/* 609 */       return false;
/*     */     }
/* 611 */     int currentCount = xDeliveryStatus.getDelivery_count();
/* 612 */     ArrayList<SStageInformation> stages = sDeliveryStageCfg.stages;
/* 613 */     for (SStageInformation stage : stages)
/*     */     {
/* 615 */       if (currentCount < stage.count) {
/* 616 */         return false;
/*     */       }
/*     */       
/* 619 */       if (currentCount == stage.count)
/*     */       {
/* 621 */         int minLevel = sActivityCfg.levelMin - 1;
/* 622 */         Set<Long> roleSet = OnlineManager.getInstance().getOnlineHigherRoleidSet(minLevel);
/*     */         
/* 624 */         SNotifyReward sNotifyReward = new SNotifyReward();
/* 625 */         sNotifyReward.count = currentCount;
/* 626 */         sNotifyReward.activity_id = activityId;
/* 627 */         OnlineManager.getInstance().sendMulti(sNotifyReward, roleSet);
/*     */         
/* 629 */         info(".checkAndBroadcastReward()@delivery stage reached|activity_cfgid=%d|stageCount=%d", new Object[] { Integer.valueOf(activityId), Integer.valueOf(currentCount) });
/*     */         
/* 631 */         return true;
/*     */       }
/*     */     }
/* 634 */     return false;
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
/*     */   static int getCurrentDeliveryCountStage(int activityId)
/*     */   {
/* 647 */     SDeliveryStageCfg sDeliveryStageCfg = SDeliveryStageCfg.get(activityId);
/* 648 */     DeliveryStatus xDeliveryStatus = getLatestDeliveryStatus(activityId, false);
/* 649 */     if ((sDeliveryStageCfg == null) || (xDeliveryStatus == null)) {
/* 650 */       return -1;
/*     */     }
/* 652 */     int currentCount = xDeliveryStatus.getDelivery_count();
/* 653 */     ArrayList<SStageInformation> stages = sDeliveryStageCfg.stages;
/*     */     
/* 655 */     int i = 0;
/* 656 */     while ((i < stages.size()) && (currentCount >= ((SStageInformation)stages.get(i)).count))
/* 657 */       i++;
/* 658 */     return i;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int getCurrentDate()
/*     */   {
/* 666 */     Calendar calendar = mzm.gsp.util.DateTimeUtils.getCalendar();
/* 667 */     calendar.setTimeInMillis(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/*     */     
/* 669 */     int year = calendar.get(1);
/* 670 */     int month = calendar.get(2) + 1;
/* 671 */     int day = calendar.get(5);
/*     */     
/* 673 */     return year * 10000 + month * 100 + day;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static DeliveryStatus getLatestDeliveryStatus(int activityId, boolean holdLock)
/*     */   {
/* 684 */     DeliveryStatuses xDeliveryStatuses = holdLock ? Grateful_delivery_status.get(Long.valueOf(GameServerInfoManager.toGlobalId(activityId))) : Grateful_delivery_status.select(Long.valueOf(GameServerInfoManager.toGlobalId(activityId)));
/*     */     
/*     */ 
/* 687 */     if (xDeliveryStatuses == null)
/* 688 */       return null;
/* 689 */     return (DeliveryStatus)xDeliveryStatuses.getStatuses().get(Integer.valueOf(getCurrentDate()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static RoleDeliveryStatus getLatestRoleDeliveryStatus(int activityId, long roleId, boolean holdLock)
/*     */   {
/* 700 */     RoleDeliveryRecords xRoleDeliveryRecords = holdLock ? Role2gratefuldelivery.get(Long.valueOf(roleId)) : Role2gratefuldelivery.select(Long.valueOf(roleId));
/*     */     
/*     */ 
/* 703 */     if (xRoleDeliveryRecords == null)
/* 704 */       return null;
/* 705 */     RoleDeliveryRecord xRoleDeliveryRecord = (RoleDeliveryRecord)xRoleDeliveryRecords.getRecords().get(Integer.valueOf(activityId));
/* 706 */     if (xRoleDeliveryRecord == null)
/* 707 */       return null;
/* 708 */     return (RoleDeliveryStatus)xRoleDeliveryRecord.getStatuses().get(Integer.valueOf(getCurrentDate()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isDeliveryInitialized(int activityId)
/*     */   {
/* 718 */     DeliveryStatuses xDeliveryStatuses = Grateful_delivery_status.select(Long.valueOf(GameServerInfoManager.toGlobalId(activityId)));
/*     */     
/* 720 */     return (xDeliveryStatuses != null) && (xDeliveryStatuses.getStatuses().get(Integer.valueOf(getCurrentDate())) != null);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\main\GratefulDeliveryManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */