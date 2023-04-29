/*     */ package mzm.gsp.backgameactivity.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity3.confbean.BackGameActivityPointGet;
/*     */ import mzm.gsp.activity3.confbean.SBackGameActivityAwardCfg;
/*     */ import mzm.gsp.activity3.confbean.SBackGameActivityCfg;
/*     */ import mzm.gsp.activity3.confbean.SBackGameActivityRechargeCfg;
/*     */ import mzm.gsp.activity3.confbean.STBackGameActivityAccumulateRechargeCfg;
/*     */ import mzm.gsp.activity3.confbean.STBackGameActivityPointCfg;
/*     */ import mzm.gsp.activity3.confbean.STBackGameActivityRechargeAwardCfg;
/*     */ import mzm.gsp.backgameactivity.BackGameActivityAwardInfo;
/*     */ import mzm.gsp.backgameactivity.BackGameActivityExpAwardInfo;
/*     */ import mzm.gsp.backgameactivity.BackGameActivityGiftInfo;
/*     */ import mzm.gsp.backgameactivity.BackGameActivitySignInfo;
/*     */ import mzm.gsp.backgameactivity.BackGameActivityTaskInfo;
/*     */ import mzm.gsp.backgameactivity.RechargeInfo;
/*     */ import mzm.gsp.backgameactivity.SSynBackGameActivityInfo;
/*     */ import mzm.gsp.chat.main.ChatInterface;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.mall.main.JifenOperateResult;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BackGameActivityAmendInfo;
/*     */ import xbean.BackGameActivityInfo;
/*     */ import xbean.BackGameActivityRechargeInfo;
/*     */ import xbean.BackGameActivityUserInfo;
/*     */ import xbean.BackGameActivityUserMap;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2backgameactivity;
/*     */ import xtable.Role2backgameactivitypointamend;
/*     */ import xtable.User2backgameactivity;
/*     */ 
/*     */ class BackGameActivityManager
/*     */ {
/*     */   static boolean isBackGameActivityOpen(long roleId)
/*     */   {
/*  52 */     if (!OpenInterface.getOpenStatus(419))
/*     */     {
/*  54 */       return false;
/*     */     }
/*  56 */     if (OpenInterface.isBanPlay(roleId, 419))
/*     */     {
/*  58 */       OpenInterface.sendBanPlayMsg(roleId, 419);
/*  59 */       return false;
/*     */     }
/*  61 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isBackGameActivityInfoAvailable(BackGameActivityInfo xBackGameActivityInfo)
/*     */   {
/*  72 */     SBackGameActivityCfg sBackGameActivityCfg = SBackGameActivityCfg.get(xBackGameActivityInfo.getActivity_id());
/*  73 */     if (null == sBackGameActivityCfg)
/*     */     {
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     long activityBeginTime = DateTimeUtils.getBeginTimeOfCurrDay(xBackGameActivityInfo.getJoin_time());
/*  79 */     long activityEndTime = activityBeginTime + sBackGameActivityCfg.backGameCycleDay * 86400000L;
/*     */     
/*  81 */     if (activityEndTime < DateTimeUtils.getCurrTimeInMillis())
/*     */     {
/*  83 */       return false;
/*     */     }
/*  85 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getOpenBackGameActivityId()
/*     */   {
/*  94 */     Set<Integer> openActivitys = ActivityInterface.getActivityIdsByLogicType(113);
/*     */     
/*     */ 
/*  97 */     int openActivityId = -1;
/*  98 */     for (Iterator i$ = openActivitys.iterator(); i$.hasNext();) { int activityId = ((Integer)i$.next()).intValue();
/*     */       
/* 100 */       if (ActivityInterface.isActivityOpen(activityId))
/*     */       {
/* 102 */         openActivityId = activityId;
/* 103 */         break;
/*     */       }
/*     */     }
/*     */     
/* 107 */     return openActivityId;
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
/*     */   static BackGameActivityInfo initBackGameActivityInfo(String userId, long roleId, int activityId)
/*     */   {
/* 121 */     Role2backgameactivity.remove(Long.valueOf(roleId));
/*     */     
/* 123 */     BackGameActivityInfo xBackGameActivityInfo = Pod.newBackGameActivityInfo();
/* 124 */     xBackGameActivityInfo.setActivity_id(activityId);
/* 125 */     xBackGameActivityInfo.setJoin_time(DateTimeUtils.getCurrTimeInMillis());
/* 126 */     xBackGameActivityInfo.setJoin_level(RoleInterface.getLevel(roleId));
/*     */     
/* 128 */     int totalRechargeYuanbao = (int)QingfuInterface.getSaveAmt(userId, true);
/* 129 */     xBackGameActivityInfo.setJoin_recharge(totalRechargeYuanbao);
/* 130 */     Role2backgameactivity.insert(Long.valueOf(roleId), xBackGameActivityInfo);
/*     */     
/* 132 */     clearLastBackGameActivityPoint(roleId, activityId);
/*     */     
/*     */ 
/* 135 */     insertAmendInfo(roleId, activityId);
/*     */     
/* 137 */     return xBackGameActivityInfo;
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
/*     */   static BackGameActivityInfo initEmptyBackGameActivityInfo(long roleId)
/*     */   {
/* 152 */     Role2backgameactivity.remove(Long.valueOf(roleId));
/*     */     
/* 154 */     BackGameActivityInfo xBackGameActivityInfo = Pod.newBackGameActivityInfo();
/* 155 */     Role2backgameactivity.insert(Long.valueOf(roleId), xBackGameActivityInfo);
/* 156 */     return xBackGameActivityInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendBackGameNotify(long roleId, SBackGameActivityCfg sBackGameActivityCfg)
/*     */   {
/* 165 */     for (Iterator i$ = FriendInterface.getAllFriends(roleId, true).iterator(); i$.hasNext();) { long targetRoleId = ((Long)i$.next()).longValue();
/*     */       
/* 167 */       ChatInterface.chatToSbNoneRealTime(roleId, targetRoleId, sBackGameActivityCfg.backGameMessageId);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void updateLoginCountOnLogin(BackGameActivityInfo xBackGameActivityInfo)
/*     */   {
/* 178 */     long currentTime = DateTimeUtils.getCurrTimeInMillis();
/* 179 */     if (DateTimeUtils.needDailyReset(xBackGameActivityInfo.getLast_login_time(), currentTime, 0))
/*     */     {
/* 181 */       xBackGameActivityInfo.setLast_login_time(currentTime);
/* 182 */       xBackGameActivityInfo.setLogin_count(xBackGameActivityInfo.getLogin_count() + 1);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void updateLoginCountOnline(BackGameActivityInfo xBackGameActivityInfo)
/*     */   {
/* 194 */     long lastLoginTime = xBackGameActivityInfo.getLast_login_time();
/* 195 */     if (lastLoginTime == 0L)
/*     */     {
/* 197 */       String logStr = String.format("[backgameactivity]BackGameExpAwardManager.updateLoginCountOnline@last login time == 0!|xBackGameActivityInfo=%s", new Object[] { xBackGameActivityInfo });
/*     */       
/*     */ 
/* 200 */       GameServer.logger().error(logStr);
/* 201 */       return;
/*     */     }
/* 203 */     long currentTime = DateTimeUtils.getCurrTimeInMillis();
/* 204 */     int diffDays = DateTimeUtils.diffDays(currentTime, xBackGameActivityInfo.getLast_login_time());
/* 205 */     if (diffDays > 0)
/*     */     {
/* 207 */       xBackGameActivityInfo.setLast_login_time(currentTime);
/* 208 */       xBackGameActivityInfo.setLogin_count(xBackGameActivityInfo.getLogin_count() + diffDays);
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
/*     */   static int getBackGameAwardCfgId(int recharge, int backGameActivityCfgId)
/*     */   {
/* 221 */     int awardCfgId = SBackGameActivityCfg.get(backGameActivityCfgId).awardCfgId;
/* 222 */     SBackGameActivityAwardCfg sBackGameActivityAwardCfg = SBackGameActivityAwardCfg.get(awardCfgId);
/* 223 */     TreeMap<Integer, Integer> recharge2AwardTierId = sBackGameActivityAwardCfg.needRecharge2AwardTierId;
/* 224 */     Map.Entry<Integer, Integer> matchEntry = recharge2AwardTierId.floorEntry(Integer.valueOf(recharge));
/* 225 */     if (null == matchEntry)
/*     */     {
/* 227 */       String logStr = String.format("[backgameactivity]BackGameExpAwardManager.getBackGameAwardCfgId@no match tier!|activityId=%d,recharge2AwardTierId=%s,recharge=%d", new Object[] { Integer.valueOf(backGameActivityCfgId), recharge2AwardTierId, Integer.valueOf(recharge) });
/*     */       
/*     */ 
/* 230 */       GameServer.logger().error(logStr);
/* 231 */       matchEntry = recharge2AwardTierId.firstEntry();
/*     */     }
/* 233 */     return ((Integer)matchEntry.getValue()).intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getBackGameDayIndex(long currTime, BackGameActivityInfo xBackGameActivityInfo)
/*     */   {
/* 244 */     return DateTimeUtils.diffDays(currTime, xBackGameActivityInfo.getJoin_time());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void synBackGameActivityInfoToClient(String userId, long roleId, Set<Long> roleIdSet, BackGameActivityInfo xBackGameActivityInfo)
/*     */   {
/* 256 */     long currentTime = DateTimeUtils.getCurrTimeInMillis();
/* 257 */     SSynBackGameActivityInfo protocol = new SSynBackGameActivityInfo();
/* 258 */     protocol.activity_id = xBackGameActivityInfo.getActivity_id();
/* 259 */     protocol.current_time = currentTime;
/* 260 */     protocol.join_time = xBackGameActivityInfo.getJoin_time();
/* 261 */     protocol.join_level = xBackGameActivityInfo.getJoin_level();
/* 262 */     protocol.sign_info = getSignInfoProto(xBackGameActivityInfo);
/* 263 */     protocol.exp_award_info = getExpRewardInfoProto(xBackGameActivityInfo, currentTime);
/* 264 */     protocol.task_info = getTaskInfoProto(xBackGameActivityInfo, currentTime);
/* 265 */     protocol.award_info = getAwardInfoProto(xBackGameActivityInfo);
/* 266 */     protocol.gift_info = getGiftInfoProto(xBackGameActivityInfo, currentTime);
/*     */     
/* 268 */     getRechargeInfo(userId, roleId, roleIdSet, xBackGameActivityInfo, protocol.rechargeinfo);
/*     */     
/* 270 */     OnlineManager.getInstance().send(roleId, protocol);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static BackGameActivitySignInfo getSignInfoProto(BackGameActivityInfo xBackGameActivityInfo)
/*     */   {
/* 281 */     BackGameActivitySignInfo signInfo = new BackGameActivitySignInfo();
/* 282 */     signInfo.sign_count = xBackGameActivityInfo.getSign_count();
/* 283 */     signInfo.last_sign_time = xBackGameActivityInfo.getLast_sign_time();
/* 284 */     return signInfo;
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
/*     */   private static BackGameActivityExpAwardInfo getExpRewardInfoProto(BackGameActivityInfo xBackGameActivityInfo, long currentTime)
/*     */   {
/* 298 */     updateLoginCountOnLogin(xBackGameActivityInfo);
/* 299 */     BackGameActivityExpAwardInfo expAwardInfo = new BackGameActivityExpAwardInfo();
/* 300 */     expAwardInfo.login_count = xBackGameActivityInfo.getLogin_count();
/* 301 */     expAwardInfo.already_get_exp_awards.addAll(xBackGameActivityInfo.getAlready_get_exp_awards());
/* 302 */     return expAwardInfo;
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
/*     */   private static BackGameActivityTaskInfo getTaskInfoProto(BackGameActivityInfo xBackGameActivityInfo, long currentTime)
/*     */   {
/* 315 */     BackGameActivityTaskInfo taskInfo = new BackGameActivityTaskInfo();
/*     */     int taskState;
/* 317 */     int taskState; if (DateTimeUtils.needDailyReset(xBackGameActivityInfo.getLast_get_task_award_time(), currentTime, 0))
/*     */     {
/* 319 */       taskState = 0;
/*     */     }
/*     */     else
/*     */     {
/* 323 */       taskState = 1;
/*     */     }
/* 325 */     taskInfo.task_state = taskState;
/* 326 */     return taskInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static BackGameActivityAwardInfo getAwardInfoProto(BackGameActivityInfo xBackGameActivityInfo)
/*     */   {
/* 337 */     BackGameActivityAwardInfo awardInfo = new BackGameActivityAwardInfo();
/*     */     int available;
/* 339 */     int available; if (xBackGameActivityInfo.getHave_got_back_game_award())
/*     */     {
/* 341 */       available = 1;
/*     */     }
/*     */     else
/*     */     {
/* 345 */       available = 0;
/*     */     }
/* 347 */     awardInfo.back_game_award_available = available;
/*     */     
/* 349 */     int userAwardTierCfgId = getBackGameAwardCfgId(xBackGameActivityInfo.getJoin_recharge(), xBackGameActivityInfo.getActivity_id());
/*     */     
/* 351 */     awardInfo.back_game_award_tier_cfg_id = userAwardTierCfgId;
/* 352 */     return awardInfo;
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
/*     */   private static BackGameActivityGiftInfo getGiftInfoProto(BackGameActivityInfo xBackGameActivityInfo, long currentTime)
/*     */   {
/* 366 */     PCBuyBackGameGiftReq.checkRefreshGiftInfo(currentTime, xBackGameActivityInfo);
/* 367 */     BackGameActivityGiftInfo giftInfo = new BackGameActivityGiftInfo();
/* 368 */     giftInfo.gift_buy_count.putAll(xBackGameActivityInfo.getGift_buy_count_map());
/* 369 */     return giftInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addPointOnFinishedActivity(long roleId, int activityId, int currentActivityTotalCount, int activityAddedCount)
/*     */   {
/* 379 */     BackGameActivityInfo xBackGameActivityInfo = getRoleCurrentBackGameActivityInfo(roleId);
/* 380 */     if (xBackGameActivityInfo == null)
/*     */     {
/* 382 */       return;
/*     */     }
/* 384 */     int backGameActivityId = xBackGameActivityInfo.getActivity_id();
/*     */     
/* 386 */     SBackGameActivityCfg backGameActivityCfg = SBackGameActivityCfg.get(backGameActivityId);
/* 387 */     if (backGameActivityCfg == null)
/*     */     {
/* 389 */       return;
/*     */     }
/* 391 */     STBackGameActivityPointCfg stBackGameActivityPointCfg = STBackGameActivityPointCfg.get(backGameActivityCfg.pointCfgId);
/*     */     
/* 393 */     if (stBackGameActivityPointCfg == null)
/*     */     {
/* 395 */       return;
/*     */     }
/* 397 */     BackGameActivityPointGet backGameActivityPointGet = (BackGameActivityPointGet)stBackGameActivityPointCfg.activityId2pointGetCfg.get(Integer.valueOf(activityId));
/*     */     
/* 399 */     if (backGameActivityPointGet == null)
/*     */     {
/* 401 */       return;
/*     */     }
/* 403 */     addBackGameActivityPoint(roleId, activityId, currentActivityTotalCount, activityAddedCount, backGameActivityId, backGameActivityPointGet);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void addBackGameActivityPoint(long roleId, int activityId, int currentActivityTotalCount, int activityAddedCount, int backGameActivityId, BackGameActivityPointGet backGameActivityPointGet)
/*     */   {
/* 410 */     int lastActivityTotalCount = currentActivityTotalCount - activityAddedCount;
/* 411 */     int activityCountForPoint = backGameActivityPointGet.activityMaxCount >= currentActivityTotalCount ? activityAddedCount : backGameActivityPointGet.activityMaxCount - lastActivityTotalCount;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 416 */     int pointCountToAdd = activityCountForPoint * backGameActivityPointGet.pointCountEachRun;
/*     */     
/* 418 */     JifenOperateResult jifenOperateResult = MallInterface.addJifen(roleId, pointCountToAdd, 11, true, new TLogArg(LogReason.BACK_GAME_ACTIVITY_FINISH_ACTIVITY_GET_POINT, activityId));
/*     */     
/*     */ 
/* 421 */     if (!jifenOperateResult.isSuccess())
/*     */     {
/* 423 */       GameServer.logger().error(String.format("[backgameactivity]BackGameActivityManager.addPointOnFinishedActivity@ add ji fen fail|roleId=%d|backGameActivityId=%d|activityId=%d|pointCountToAdd=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(backGameActivityId), Integer.valueOf(activityId), Integer.valueOf(pointCountToAdd) }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void clearLastBackGameActivityPoint(long roleId, int backGameActivityId)
/*     */   {
/* 434 */     long lastActivityJiFen = MallInterface.getJifen(roleId, 11);
/* 435 */     if (lastActivityJiFen == 0L)
/*     */     {
/* 437 */       return;
/*     */     }
/*     */     
/* 440 */     JifenOperateResult jifenOperateResult = MallInterface.cutJifen(roleId, lastActivityJiFen, 11, new TLogArg(LogReason.BACK_GAME_ACTIVITY_CLEAR_LAST_ACTIVITY_JI_FEN, backGameActivityId));
/*     */     
/*     */ 
/* 443 */     if (!jifenOperateResult.isSuccess())
/*     */     {
/* 445 */       GameServer.logger().error(String.format("[backgameactivity]BackGameActivityManager.clearLastActivityPoint@ cut ji fen fail|roleId=%d|backGameActivityId=%d|pointCountToCut=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(backGameActivityId), Long.valueOf(lastActivityJiFen) }));
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
/*     */   static void addPointForCurrentBackGameActivity(long roleId, int backGameActivityId)
/*     */   {
/* 459 */     long currentActivityJiFen = MallInterface.getJifen(roleId, 11);
/* 460 */     if (currentActivityJiFen != 0L)
/*     */     {
/* 462 */       return;
/*     */     }
/*     */     
/* 465 */     BackGameActivityAmendInfo xBackGameActivityAmendInfo = Role2backgameactivitypointamend.get(Long.valueOf(roleId));
/* 466 */     if (xBackGameActivityAmendInfo == null)
/*     */     {
/* 468 */       xBackGameActivityAmendInfo = Pod.newBackGameActivityAmendInfo();
/* 469 */       Role2backgameactivitypointamend.insert(Long.valueOf(roleId), xBackGameActivityAmendInfo);
/*     */     }
/* 471 */     if (xBackGameActivityAmendInfo.getActivityidset().contains(Integer.valueOf(backGameActivityId)))
/*     */     {
/* 473 */       return;
/*     */     }
/* 475 */     xBackGameActivityAmendInfo.getActivityidset().add(Integer.valueOf(backGameActivityId));
/*     */     
/* 477 */     SBackGameActivityCfg backGameActivityCfg = SBackGameActivityCfg.get(backGameActivityId);
/* 478 */     if (backGameActivityCfg == null)
/*     */     {
/* 480 */       return;
/*     */     }
/* 482 */     STBackGameActivityPointCfg stBackGameActivityPointCfg = STBackGameActivityPointCfg.get(backGameActivityCfg.pointCfgId);
/*     */     
/* 484 */     if (stBackGameActivityPointCfg == null)
/*     */     {
/* 486 */       return;
/*     */     }
/*     */     
/*     */ 
/* 490 */     String userId = RoleInterface.getUserId(roleId);
/*     */     
/* 492 */     for (Map.Entry<Integer, BackGameActivityPointGet> entry : stBackGameActivityPointCfg.activityId2pointGetCfg.entrySet())
/*     */     {
/* 494 */       int activityId = ((Integer)entry.getKey()).intValue();
/* 495 */       BackGameActivityPointGet backGameActivityPointGet = (BackGameActivityPointGet)entry.getValue();
/* 496 */       int activityCount = ActivityInterface.getActivityCount(userId, roleId, activityId, false);
/* 497 */       if (activityCount > 0)
/*     */       {
/*     */ 
/*     */ 
/* 501 */         addBackGameActivityPoint(roleId, activityId, activityCount, activityCount, backGameActivityId, backGameActivityPointGet);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static BackGameActivityInfo getRoleCurrentBackGameActivityInfo(long roleId)
/*     */   {
/* 508 */     BackGameActivityInfo xBackGameActivityInfo = Role2backgameactivity.get(Long.valueOf(roleId));
/* 509 */     if (xBackGameActivityInfo == null)
/*     */     {
/* 511 */       return null;
/*     */     }
/* 513 */     if (!isBackGameActivityInfoAvailable(xBackGameActivityInfo))
/*     */     {
/* 515 */       return null;
/*     */     }
/* 517 */     return xBackGameActivityInfo;
/*     */   }
/*     */   
/*     */ 
/*     */   static void getRechargeInfo(String userId, long roleId, Set<Long> roleIdSet, BackGameActivityInfo xBackGameActivityInfo, RechargeInfo rechargeInfo)
/*     */   {
/* 523 */     int activityId = xBackGameActivityInfo.getActivity_id();
/*     */     
/* 525 */     BackGameActivityUserInfo xBackGameActivityUserInfo = getBackGameActivityUserInfoCreateIfNotExist(userId, roleIdSet, activityId);
/*     */     
/*     */ 
/* 528 */     BackGameActivityRechargeInfo xBackGameActivityRechargeInfo = xBackGameActivityUserInfo.getRechargeinfo();
/*     */     
/* 530 */     addManekiTokenOnRecharge(userId, roleId, xBackGameActivityRechargeInfo, activityId);
/*     */     
/* 532 */     rechargeInfo.manekitokencfgid2count.putAll(xBackGameActivityRechargeInfo.getManekitokencfgid2count());
/* 533 */     rechargeInfo.accumulaterechargecount = xBackGameActivityRechargeInfo.getAccumulaterechargecount();
/*     */   }
/*     */   
/*     */ 
/*     */   private static void addManekiTokenOnRecharge(String userId, long roleId, BackGameActivityRechargeInfo xBackGameActivityRechargeInfo, int activityId)
/*     */   {
/* 539 */     long accumulateRechargeCountInGame = QingfuInterface.getSaveAmt(userId, true);
/* 540 */     long accumulateRechargeCountInActivity = accumulateRechargeCountInGame - xBackGameActivityRechargeInfo.getInitrechargecount();
/*     */     
/* 542 */     long xAccumulateRechargeCount = xBackGameActivityRechargeInfo.getAccumulaterechargecount();
/* 543 */     if (xAccumulateRechargeCount == accumulateRechargeCountInActivity)
/*     */     {
/* 545 */       return;
/*     */     }
/*     */     
/* 548 */     STBackGameActivityAccumulateRechargeCfg backGameActivityAccumulateRechargeCfg = getSTBackGameActivityAccumulateRechargeCfg(activityId);
/*     */     
/* 550 */     if (backGameActivityAccumulateRechargeCfg == null)
/*     */     {
/* 552 */       return;
/*     */     }
/*     */     
/* 555 */     Map<Integer, Integer> beforeManekiTokenCfgId2count = new HashMap();
/* 556 */     beforeManekiTokenCfgId2count.putAll(xBackGameActivityRechargeInfo.getManekitokencfgid2count());
/*     */     
/* 558 */     Map.Entry<Integer, Integer> entry = backGameActivityAccumulateRechargeCfg.rechargeCount2awardTypeId.higherEntry(Integer.valueOf((int)xAccumulateRechargeCount));
/*     */     
/*     */     int accumulateRechargeCount;
/*     */     
/* 562 */     while ((entry != null) && ((accumulateRechargeCount = ((Integer)entry.getKey()).intValue()) <= accumulateRechargeCountInActivity))
/*     */     {
/* 564 */       int rechargeAwardTypeId = ((Integer)entry.getValue()).intValue();
/* 565 */       STBackGameActivityRechargeAwardCfg stBackGameActivityRechargeAwardCfg = STBackGameActivityRechargeAwardCfg.get(rechargeAwardTypeId);
/* 566 */       if (stBackGameActivityRechargeAwardCfg != null)
/*     */       {
/* 568 */         addManekiToken(stBackGameActivityRechargeAwardCfg, xBackGameActivityRechargeInfo);
/*     */       }
/*     */       
/* 571 */       entry = backGameActivityAccumulateRechargeCfg.rechargeCount2awardTypeId.higherEntry(Integer.valueOf(accumulateRechargeCount));
/*     */     }
/* 573 */     xBackGameActivityRechargeInfo.setAccumulaterechargecount(accumulateRechargeCountInActivity);
/*     */     
/*     */ 
/* 576 */     BackGameActivityTlogManager.addBackGameActivityRechargeTLog(roleId, activityId, xBackGameActivityRechargeInfo.getInitrechargecount(), xAccumulateRechargeCount, accumulateRechargeCountInActivity, beforeManekiTokenCfgId2count, xBackGameActivityRechargeInfo.getManekitokencfgid2count());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addManekiToken(STBackGameActivityRechargeAwardCfg stBackGameActivityRechargeAwardCfg, BackGameActivityRechargeInfo xBackGameActivityRechargeInfo)
/*     */   {
/* 586 */     Map<Integer, Integer> xManekiTokenCfgId2count = xBackGameActivityRechargeInfo.getManekitokencfgid2count();
/*     */     
/* 588 */     for (Map.Entry<Integer, Integer> entry : stBackGameActivityRechargeAwardCfg.manekiTokenCfgId2manekiTokenCount.entrySet())
/*     */     {
/* 590 */       int manekiTokenCfgId = ((Integer)entry.getKey()).intValue();
/* 591 */       int xManekiTokenCount; int xManekiTokenCount; if (xManekiTokenCfgId2count.containsKey(Integer.valueOf(manekiTokenCfgId)))
/*     */       {
/* 593 */         xManekiTokenCount = ((Integer)xManekiTokenCfgId2count.get(Integer.valueOf(manekiTokenCfgId))).intValue();
/*     */       }
/*     */       else
/*     */       {
/* 597 */         xManekiTokenCount = 0;
/*     */       }
/* 599 */       xManekiTokenCount += ((Integer)entry.getValue()).intValue();
/* 600 */       xManekiTokenCfgId2count.put(Integer.valueOf(manekiTokenCfgId), Integer.valueOf(xManekiTokenCount));
/*     */     }
/*     */   }
/*     */   
/*     */   static STBackGameActivityAccumulateRechargeCfg getSTBackGameActivityAccumulateRechargeCfg(int activityId)
/*     */   {
/* 606 */     SBackGameActivityCfg backGameActivityCfg = SBackGameActivityCfg.get(activityId);
/* 607 */     if (backGameActivityCfg == null)
/*     */     {
/* 609 */       return null;
/*     */     }
/* 611 */     SBackGameActivityRechargeCfg backGameActivityRechargeCfg = SBackGameActivityRechargeCfg.get(backGameActivityCfg.rechargeCfgId);
/*     */     
/* 613 */     if (backGameActivityRechargeCfg == null)
/*     */     {
/* 615 */       return null;
/*     */     }
/* 617 */     return STBackGameActivityAccumulateRechargeCfg.get(backGameActivityRechargeCfg.accumulateRechargeTypeId);
/*     */   }
/*     */   
/*     */   static BackGameActivityRechargeInfo getBackGameActivityRechargeInfo(String userId, int activityId)
/*     */   {
/* 622 */     BackGameActivityUserMap xBackGameActivityUserMap = User2backgameactivity.get(userId);
/* 623 */     if (xBackGameActivityUserMap == null)
/*     */     {
/* 625 */       return null;
/*     */     }
/* 627 */     BackGameActivityUserInfo xBackGameActivityUserInfo = (BackGameActivityUserInfo)xBackGameActivityUserMap.getActivityid2userinfo().get(Integer.valueOf(activityId));
/*     */     
/* 629 */     if (xBackGameActivityUserInfo == null)
/*     */     {
/* 631 */       return null;
/*     */     }
/* 633 */     return xBackGameActivityUserInfo.getRechargeinfo();
/*     */   }
/*     */   
/*     */ 
/*     */   static BackGameActivityUserInfo getBackGameActivityUserInfoCreateIfNotExist(String userId, Set<Long> roleIdSet, int activityId)
/*     */   {
/* 639 */     BackGameActivityUserMap xBackGameActivityUserMap = User2backgameactivity.get(userId);
/* 640 */     if (xBackGameActivityUserMap == null)
/*     */     {
/* 642 */       xBackGameActivityUserMap = Pod.newBackGameActivityUserMap();
/* 643 */       User2backgameactivity.insert(userId, xBackGameActivityUserMap);
/*     */     }
/* 645 */     BackGameActivityUserInfo xBackGameActivityUserInfo = (BackGameActivityUserInfo)xBackGameActivityUserMap.getActivityid2userinfo().get(Integer.valueOf(activityId));
/*     */     
/* 647 */     if (xBackGameActivityUserInfo == null)
/*     */     {
/* 649 */       xBackGameActivityUserInfo = Pod.newBackGameActivityUserInfo();
/* 650 */       xBackGameActivityUserInfo.getRechargeinfo().setInitrechargecount(getUserActivityInitRechargeCount(roleIdSet, activityId));
/*     */       
/* 652 */       xBackGameActivityUserMap.getActivityid2userinfo().put(Integer.valueOf(activityId), xBackGameActivityUserInfo);
/*     */     }
/* 654 */     return xBackGameActivityUserInfo;
/*     */   }
/*     */   
/*     */   static boolean isRoleInBackGameActivity(long roleId, int activityId)
/*     */   {
/* 659 */     BackGameActivityInfo xBackGameActivityInfo = getRoleCurrentBackGameActivityInfo(roleId);
/* 660 */     return (xBackGameActivityInfo != null) && (xBackGameActivityInfo.getActivity_id() == activityId);
/*     */   }
/*     */   
/*     */   static int getUserActivityInitRechargeCount(Set<Long> roleIdSet, int activityId)
/*     */   {
/* 665 */     if ((roleIdSet == null) || (roleIdSet.isEmpty()))
/*     */     {
/* 667 */       return 0;
/*     */     }
/*     */     
/* 670 */     int minJoinRecharge = Integer.MAX_VALUE;
/* 671 */     boolean isGot = false;
/* 672 */     for (Iterator i$ = roleIdSet.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 674 */       BackGameActivityInfo xBackGameActivityInfo = Role2backgameactivity.select(Long.valueOf(roleId));
/* 675 */       if ((xBackGameActivityInfo != null) && 
/*     */       
/*     */ 
/*     */ 
/* 679 */         (xBackGameActivityInfo.getActivity_id() == activityId))
/*     */       {
/*     */ 
/*     */ 
/* 683 */         if (xBackGameActivityInfo.getJoin_recharge() < minJoinRecharge)
/*     */         {
/* 685 */           isGot = true;
/* 686 */           minJoinRecharge = xBackGameActivityInfo.getJoin_recharge();
/*     */         } }
/*     */     }
/* 689 */     if (!isGot)
/*     */     {
/* 691 */       return 0;
/*     */     }
/* 693 */     return minJoinRecharge;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void insertAmendInfo(long roleId, int activityId)
/*     */   {
/* 704 */     BackGameActivityAmendInfo xBackGameActivityAmendInfo = Role2backgameactivitypointamend.get(Long.valueOf(roleId));
/* 705 */     if (xBackGameActivityAmendInfo == null)
/*     */     {
/* 707 */       xBackGameActivityAmendInfo = Pod.newBackGameActivityAmendInfo();
/* 708 */       Role2backgameactivitypointamend.insert(Long.valueOf(roleId), xBackGameActivityAmendInfo);
/*     */     }
/* 710 */     xBackGameActivityAmendInfo.getActivityidset().add(Integer.valueOf(activityId));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\main\BackGameActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */