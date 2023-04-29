/*     */ package mzm.gsp.banquest.main;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.banquest.SBanquetNormalResult;
/*     */ import mzm.gsp.banquest.SSyncBanquetEndBrd;
/*     */ import mzm.gsp.banquest.SSyncBanquetInfo;
/*     */ import mzm.gsp.homeland.confbean.SBanquetConsts;
/*     */ import mzm.gsp.homeland.confbean.STBRankCalCfg;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BanquestInfo;
/*     */ import xbean.BanquestSessionInfo;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Procedure;
/*     */ import xtable.Role2banquestinfo;
/*     */ import xtable.Role2banqustsession;
/*     */ import xtable.User;
/*     */ 
/*     */ public class BanquestManager
/*     */ {
/*     */   static void initBanquestModule()
/*     */   {
/*  38 */     ActivityInterface.registerActivityByLogicType(57, new BanquestActivityInit());
/*  39 */     mzm.gsp.activitycompensate.main.ActivityCompensateInterface.registerCompensateHandler(57, new BanquestActivityInit());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void regMapItemCheck()
/*     */   {
/*  47 */     for (Iterator i$ = getAllBanquestMapItemHandlerType().iterator(); i$.hasNext();) { int checkType = ((Integer)i$.next()).intValue();
/*     */       
/*  49 */       if (!MapInterface.regisMapItemGatherHandler(checkType, PMapItemHandler.getInstance()))
/*     */       {
/*  51 */         throw new RuntimeException(String.format("[banquest]BanquestManager.regMapItemCheck@regisMapItemGatherHandler err!|checkType=%d", new Object[] { Integer.valueOf(checkType) }));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getActivityId()
/*     */   {
/*  64 */     return SBanquetConsts.getInstance().ACTIVITY_ID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getHoldMaxCount()
/*     */   {
/*  74 */     return SBanquetConsts.getInstance().DAY_CAN_HOLD_BANQUEST_MAX;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean needLimitGuyNum()
/*     */   {
/*  84 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getHoldMinRoleLv()
/*     */   {
/*  94 */     return SBanquetConsts.getInstance().HOLD_BANQUEST_ROLE_LEVEL;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getJoinMinRoleLv()
/*     */   {
/* 104 */     return SBanquetConsts.getInstance().JOIN_LEVEL_MIN;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getBanqustGuyUpLimit()
/*     */   {
/* 114 */     return SBanquetConsts.getInstance().JOIN_BANQUEST_PEOPLE_UPPER;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getDishesMax()
/*     */   {
/* 124 */     return SBanquetConsts.getInstance().DISHES_COUNT_MAX;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getDayCanGetDishesMax()
/*     */   {
/* 134 */     return SBanquetConsts.getInstance().DAY_CAN_GET_MAX;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getEachOwnDishesMax()
/*     */   {
/* 144 */     return SBanquetConsts.getInstance().EACH_DISH_CAN_GET_MAX;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getEachBanquestOwnMax()
/*     */   {
/* 154 */     return SBanquetConsts.getInstance().EACH_BANQUEST_CAN_GET_MAX;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getAllBanquestMapItemHandlerType()
/*     */   {
/* 164 */     Set<Integer> handlerTypes = new HashSet();
/* 165 */     handlerTypes.add(Integer.valueOf(SBanquetConsts.getInstance().CHECK_ID));
/* 166 */     return handlerTypes;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getDishesInterval()
/*     */   {
/* 176 */     return SBanquetConsts.getInstance().DISHES_INTERVAL_TIME;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getClearControllerInterval()
/*     */   {
/* 186 */     return SBanquetConsts.getInstance().CLEAR_CONTROLLER_INTERVAL;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getBanquestDishInterval()
/*     */   {
/* 196 */     return 60000L * SBanquetConsts.getInstance().HOLD_BANQUEST_TIME_LIMIT;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getReserveTime()
/*     */   {
/* 206 */     return 1000 * SBanquetConsts.getInstance().BANQUEST_RESERVE_TIME;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getAllBanquestInterval()
/*     */   {
/* 218 */     return getBanquestDishInterval();
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
/*     */   static int getBanquestGuyNum(long masterId)
/*     */   {
/* 233 */     long homelandWorldId = getHomeLandWorldId(masterId);
/* 234 */     if (homelandWorldId <= 0L)
/*     */     {
/* 236 */       return 0;
/*     */     }
/* 238 */     return MapInterface.getRoleNumInWorld(homelandWorldId);
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
/*     */   static long getHomeLandWorldId(long masterId)
/*     */   {
/* 252 */     return HomelandInterface.getHomeWorldIdByRoleId(masterId, false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getMasterIdBy(long worldId)
/*     */   {
/* 263 */     return HomelandInterface.getRoleByHomeWorldId(worldId, false);
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
/*     */   static boolean isInMasterHome(long roleId, long masterId)
/*     */   {
/* 279 */     long homelandWorldId = getHomeLandWorldId(masterId);
/* 280 */     if (homelandWorldId <= 0L)
/*     */     {
/* 282 */       return false;
/*     */     }
/* 284 */     long roleWorldId = MapInterface.getRoleWorldInstanceId(roleId);
/* 285 */     if (roleWorldId < 0L)
/*     */     {
/* 287 */       return false;
/*     */     }
/* 289 */     return roleWorldId == homelandWorldId;
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
/*     */   static Collection<Long> getBanquestGuyIds(long masterId)
/*     */   {
/* 303 */     long homelandWorldId = getHomeLandWorldId(masterId);
/* 304 */     if (homelandWorldId <= 0L)
/*     */     {
/* 306 */       return new ArrayList();
/*     */     }
/* 308 */     return MapInterface.getRoleList(homelandWorldId);
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
/*     */   static int getBanquestScore(long masterId)
/*     */   {
/* 322 */     int guyNum = getBanquestGuyNum(masterId);
/*     */     
/* 324 */     int fengShui = HomelandInterface.getFengshui(masterId);
/*     */     
/* 326 */     return getBanquestScore(fengShui, guyNum);
/*     */   }
/*     */   
/*     */   static int getBanquestScore(int fengshui, int guyNum)
/*     */   {
/* 331 */     return Math.min(guyNum, getBanqustGuyUpLimit()) + fengshui;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static STBRankCalCfg getSTBRankCalCfg(long score)
/*     */   {
/* 342 */     STBRankCalCfg rankCfg = null;
/* 343 */     for (STBRankCalCfg cfg : STBRankCalCfg.getAll().values())
/*     */     {
/* 345 */       if ((score >= cfg.scoreLow) && 
/*     */       
/*     */ 
/*     */ 
/* 349 */         (score <= cfg.scoreHigh))
/*     */       {
/*     */ 
/*     */ 
/* 353 */         rankCfg = cfg;
/*     */       }
/*     */     }
/* 356 */     return rankCfg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getAllBanqustContrller()
/*     */   {
/* 368 */     Set<Integer> controller = new HashSet();
/* 369 */     for (STBRankCalCfg cfg : STBRankCalCfg.getAll().values())
/*     */     {
/* 371 */       controller.addAll(cfg.controllerIds);
/*     */     }
/* 373 */     return controller;
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
/*     */   static STBRankCalCfg getSTBRankCalCfgBy(long masterId)
/*     */   {
/* 386 */     return getSTBRankCalCfg(getBanquestScore(masterId));
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
/*     */   static void synBanquestInfo(long masterId, Collection<Long> roleIds, int guyNum, long startTime)
/*     */   {
/* 403 */     if ((roleIds == null) || (roleIds.size() == 0))
/*     */     {
/* 405 */       return;
/*     */     }
/* 407 */     SSyncBanquetInfo p = new SSyncBanquetInfo(masterId, guyNum, startTime / 1000L);
/* 408 */     OnlineManager.getInstance().sendMulti(p, roleIds);
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
/*     */   static void synBanquestGuyNum(long masterId, Collection<Long> roleIds)
/*     */   {
/* 421 */     if ((roleIds == null) || (roleIds.size() == 0))
/*     */     {
/* 423 */       return;
/*     */     }
/* 425 */     OnlineManager.getInstance().sendMulti(new mzm.gsp.banquest.SSyncBanquetPlayerNumberBrd(masterId, roleIds.size()), roleIds);
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
/*     */   static void noticeBanquestEnd(Collection<Long> roleIds, long masterId)
/*     */   {
/* 438 */     if ((roleIds == null) || (roleIds.size() == 0))
/*     */     {
/* 440 */       return;
/*     */     }
/* 442 */     SSyncBanquetEndBrd bro = new SSyncBanquetEndBrd(masterId);
/* 443 */     OnlineManager.getInstance().sendMultiAtOnce(bro, roleIds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void clearController(long roleId)
/*     */   {
/* 453 */     long homeWorldId = getHomeLandWorldId(roleId);
/* 454 */     if (homeWorldId <= 0L)
/*     */     {
/* 456 */       GameServer.logger().info(String.format("[banquest]BanquestManager.clearController@ homeland not exist!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/* 458 */       return;
/*     */     }
/* 460 */     for (Iterator i$ = getAllBanqustContrller().iterator(); i$.hasNext();) { int controllerId = ((Integer)i$.next()).intValue();
/*     */       
/* 462 */       mzm.gsp.map.main.ControllerInterface.collectWorldController(homeWorldId, controllerId);
/*     */     }
/* 464 */     GameServer.logger().info(String.format("[banquest]BanquestManager.clearController@ clear all controller!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
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
/*     */   static boolean setHoldBanquestRoleState(Collection<Long> roleIds)
/*     */   {
/* 479 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 481 */       if (!setHoldBanquestRoleState(roleId))
/*     */       {
/* 483 */         return false;
/*     */       }
/*     */     }
/* 486 */     return true;
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
/*     */   static boolean setHoldBanquestRoleState(long roleId)
/*     */   {
/* 499 */     if ((RoleStatusInterface.checkCanSetStatus(roleId, 35, true)) && (RoleStatusInterface.setStatus(roleId, 35, true)))
/*     */     {
/*     */ 
/* 502 */       return true;
/*     */     }
/* 504 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void rmHoldBanquestRoleState(Collection<Long> roleIds)
/*     */   {
/* 515 */     if ((roleIds == null) || (roleIds.size() == 0))
/*     */     {
/* 517 */       return;
/*     */     }
/* 519 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 521 */       rmHoldBanquestRoleState(roleId);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void rmHoldBanquestRoleState(long roleId)
/*     */   {
/* 532 */     RoleStatusInterface.unsetStatus(roleId, 35);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkAndInitJoinBanqustData(BanquestInfo xBanquestInfo, long startTime)
/*     */   {
/* 543 */     long fristJoinBanquestTime = xBanquestInfo.getFristjoinbanquesttime();
/* 544 */     if (DateTimeUtils.isInSameDay(fristJoinBanquestTime, startTime))
/*     */     {
/* 546 */       return;
/*     */     }
/* 548 */     initJoinBanquestData(xBanquestInfo, startTime);
/*     */   }
/*     */   
/*     */   private static void initJoinBanquestData(BanquestInfo xBanquestInfo, long startTime)
/*     */   {
/* 553 */     xBanquestInfo.setFristjoinbanquesttime(startTime);
/* 554 */     xBanquestInfo.getOwndishes().clear();
/* 555 */     xBanquestInfo.getJoinbanquestinfo().clear();
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
/*     */   static boolean isBanquestOpen(long roleId, boolean isSend)
/*     */   {
/* 568 */     if (!OpenInterface.getOpenStatus(165))
/*     */     {
/* 570 */       return false;
/*     */     }
/* 572 */     if (OpenInterface.isBanPlay(roleId, 165))
/*     */     {
/* 574 */       if (isSend)
/*     */       {
/* 576 */         OpenInterface.sendBanPlayMsg(roleId, 165);
/*     */       }
/* 578 */       return false;
/*     */     }
/* 580 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void clearBanquest(long masterId)
/*     */   {
/* 591 */     clearController(masterId);
/*     */     
/* 593 */     noticeBanquestEnd(getBanquestGuyIds(masterId), masterId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onBanquestEnd(BanquestInfo xBanquestInfo, long roleId, Collection<Long> roleIds)
/*     */   {
/* 605 */     xBanquestInfo.setHoldbanqueststate(false);
/*     */     
/* 607 */     xBanquestInfo.setDishescount(0);
/*     */     
/* 609 */     rmHoldBanquestRoleState(roleIds);
/*     */     
/* 611 */     clearBanquestSession(roleId);
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
/*     */   private static void clearBanquestSession(long roleId)
/*     */   {
/* 624 */     BanquestSessionInfo xSessionInfo = Role2banqustsession.get(Long.valueOf(roleId));
/* 625 */     if (xSessionInfo == null)
/*     */     {
/* 627 */       return;
/*     */     }
/*     */     
/* 630 */     long endSessionId = xSessionInfo.getBanquestendsessionid();
/* 631 */     Session endSession = Session.getSession(endSessionId);
/* 632 */     if ((endSession != null) && ((endSession instanceof PBanquestEndSession)))
/*     */     {
/* 634 */       PBanquestEndSession endSessionTmp = (PBanquestEndSession)endSession;
/* 635 */       Session.removeSession(endSessionId);
/* 636 */       GameServer.logger().error(String.format("[banquest]BanquestManager.clearBanquestSession@ banquest end but PBanquestEndSession not end!|roleId=%d|startTime=%s", new Object[] { Long.valueOf(roleId), endSessionTmp.getStartTimeStr() }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 643 */     long dishSessionId = xSessionInfo.getBanquestsessionid();
/* 644 */     Session dishSession = Session.getSession(dishSessionId);
/* 645 */     if ((dishSession != null) && ((dishSession instanceof PBanquestSession)))
/*     */     {
/* 647 */       PBanquestSession dishSessionTmp = (PBanquestSession)dishSession;
/* 648 */       Session.removeSession(dishSessionId);
/* 649 */       GameServer.logger().error(String.format("[banquest]BanquestManager.clearBanquestSession@ banquest end but PBanquestSession not end!|roleId=%d|startTime=%s", new Object[] { Long.valueOf(roleId), dishSessionTmp.getStartTimeStr() }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 656 */     long clearSessionId = xSessionInfo.getClearcontrollersessionid();
/* 657 */     Session clearSession = Session.getSession(clearSessionId);
/* 658 */     if ((clearSession != null) && ((clearSession instanceof PClearControllerSession)))
/*     */     {
/*     */ 
/* 661 */       PClearControllerSession clearSessionTmp = (PClearControllerSession)clearSession;
/* 662 */       Session.removeSession(clearSessionId);
/* 663 */       GameServer.logger().error(String.format("[banquest]BanquestManager.clearBanquestSession@ banquest end but PClearControllerSession not end!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 670 */     Role2banqustsession.remove(Long.valueOf(roleId));
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
/*     */   static void sendBanquestNotice(long roleid, boolean afterSuc, int result, String... args)
/*     */   {
/* 683 */     sendBanquestNotice(java.util.Arrays.asList(new Long[] { Long.valueOf(roleid) }), afterSuc, result, args);
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
/*     */   static void sendBanquestNotice(Collection<Long> roleIds, boolean afterSuc, int result, String... args)
/*     */   {
/* 696 */     if ((roleIds == null) || (roleIds.size() == 0))
/*     */     {
/* 698 */       return;
/*     */     }
/* 700 */     SBanquetNormalResult pro = new SBanquetNormalResult();
/* 701 */     pro.result = result;
/* 702 */     for (String arg : args)
/*     */     {
/* 704 */       pro.args.add(arg);
/*     */     }
/* 706 */     if (afterSuc)
/*     */     {
/* 708 */       OnlineManager.getInstance().sendMulti(pro, roleIds);
/*     */     }
/*     */     else
/*     */     {
/* 712 */       OnlineManager.getInstance().sendMultiAtOnce(pro, roleIds);
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
/*     */   static boolean reCheckAndInitBanquest(long masterId, BanquestInfo xBanquestInfo, BanquestSessionInfo xBanquestSessionInfo)
/*     */   {
/* 727 */     int dishesCount = xBanquestInfo.getDishescount();
/* 728 */     if (dishesCount >= getDishesMax())
/*     */     {
/* 730 */       GameServer.logger().info(String.format("[banquest]BanquestManager.reCheckAndInitBanquest@ in hold banquest state, dishes finished: no need offer dishes!|roleId=%d", new Object[] { Long.valueOf(masterId) }));
/*     */       
/*     */ 
/*     */ 
/* 734 */       Procedure.execute(new PBanquestEnd(masterId, xBanquestInfo.getLastbanqueststarttime()));
/* 735 */       return false;
/*     */     }
/* 737 */     long startTime = xBanquestInfo.getLastbanqueststarttime();
/* 738 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/* 740 */     long interval = curTime - startTime;
/* 741 */     if (interval + 3000L > getBanquestDishInterval())
/*     */     {
/* 743 */       GameServer.logger().info(String.format("[banquest]BanquestManager.reCheckAndInitBanquest@ in hold banquest state, time out: no need offer dishes!|roleId=%d", new Object[] { Long.valueOf(masterId) }));
/*     */       
/*     */ 
/*     */ 
/* 747 */       Procedure.execute(new PBanquestEnd(masterId, startTime));
/* 748 */       return false;
/*     */     }
/* 750 */     GameServer.logger().info(String.format("[banquest]BanquestManager.reCheckAndInitBanquest@ recover banquest!|roleId=%d", new Object[] { Long.valueOf(masterId) }));
/*     */     
/* 752 */     long intervalSec = interval / 1000L;
/* 753 */     int count = (int)(intervalSec / getDishesInterval());
/* 754 */     int nextInterval = (int)(intervalSec % getDishesInterval());
/*     */     
/* 756 */     int endTimeSec = (int)(getBanquestDishInterval() - interval) / 1000;
/* 757 */     if (endTimeSec <= 0)
/*     */     {
/* 759 */       GameServer.logger().error(String.format("[banquest]BanquestManager.reCheckAndInitBanquest@ in hold banquest state, time out: endTimeSec < 0!|roleId=%d|startTime=%d", new Object[] { Long.valueOf(masterId), Long.valueOf(startTime) }));
/*     */       
/*     */ 
/*     */ 
/* 763 */       Procedure.execute(new PBanquestEnd(masterId, startTime));
/* 764 */       return false;
/*     */     }
/* 766 */     if (count <= getDishesMax())
/*     */     {
/* 768 */       xBanquestInfo.setDishescount(count);
/*     */     }
/*     */     else
/*     */     {
/* 772 */       xBanquestInfo.setDishescount(getDishesMax());
/*     */     }
/*     */     
/*     */ 
/* 776 */     if (xBanquestInfo.getDishescount() < getDishesMax())
/*     */     {
/* 778 */       if (nextInterval < 0)
/*     */       {
/* 780 */         GameServer.logger().info(String.format("[banquest]BanquestManager.reCheckAndInitBanquest@ nextInterval is not enough!|roleId=%d", new Object[] { Long.valueOf(masterId) }));
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 787 */         PBanquestSession pBanquestSession = new PBanquestSession(nextInterval, masterId, startTime);
/* 788 */         xBanquestSessionInfo.setBanquestendsessionid(pBanquestSession.getSessionId());
/*     */       }
/*     */     }
/*     */     
/* 792 */     PBanquestEndSession endSession = new PBanquestEndSession(endTimeSec, masterId, startTime);
/* 793 */     xBanquestSessionInfo.setBanquestendsessionid(endSession.getSessionId());
/*     */     
/* 795 */     Collection<Long> guestIds = getBanquestGuyIds(masterId);
/* 796 */     synBanquestInfo(masterId, guestIds, guestIds.size(), startTime);
/* 797 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isInBanquestTime(BanquestInfo xBanquestInfo, long curTime)
/*     */   {
/* 809 */     if (xBanquestInfo == null)
/*     */     {
/* 811 */       return false;
/*     */     }
/* 813 */     if (!xBanquestInfo.getHoldbanqueststate())
/*     */     {
/*     */ 
/* 816 */       return false;
/*     */     }
/* 818 */     long interval = curTime - xBanquestInfo.getLastbanqueststarttime();
/* 819 */     if (interval + 3000L > getBanquestDishInterval())
/*     */     {
/* 821 */       return false;
/*     */     }
/* 823 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static String getFormatDate(long mills)
/*     */   {
/* 835 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 836 */     String startDate = sdf.format(Long.valueOf(mills));
/* 837 */     return startDate;
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
/*     */   static boolean synBanquestInfo(List<Long> members, long masterId)
/*     */   {
/* 853 */     if (masterId <= 0L)
/*     */     {
/* 855 */       return false;
/*     */     }
/* 857 */     if ((members == null) || (members.size() == 0))
/*     */     {
/* 859 */       return false;
/*     */     }
/* 861 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/* 863 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(masterId);
/* 864 */     Lockeys.lock(Lockeys.get(User.getTable(), userId));
/*     */     
/* 866 */     BanquestInfo xBanquestInfo = Role2banquestinfo.get(Long.valueOf(masterId));
/* 867 */     if (!isInBanquestTime(xBanquestInfo, curTime))
/*     */     {
/* 869 */       return false;
/*     */     }
/* 871 */     long startTime = xBanquestInfo.getLastbanqueststarttime();
/* 872 */     Collection<Long> guestIds = getBanquestGuyIds(masterId);
/* 873 */     synBanquestGuyNum(masterId, guestIds);
/* 874 */     synBanquestInfo(masterId, members, guestIds.size(), startTime);
/* 875 */     return true;
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
/*     */   static long getMasterId(long roleId, long marriedRoleId)
/*     */   {
/* 890 */     if ((roleId > 0L) && (HomelandInterface.isCurrentHomeCreator(roleId)))
/*     */     {
/*     */ 
/* 893 */       return roleId;
/*     */     }
/*     */     
/* 896 */     if ((marriedRoleId > 0L) && (HomelandInterface.isCurrentHomeCreator(marriedRoleId)))
/*     */     {
/* 898 */       return marriedRoleId;
/*     */     }
/* 900 */     return -1L;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\banquest\main\BanquestManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */