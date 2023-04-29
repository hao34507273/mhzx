/*     */ package mzm.gsp.storageexp.activity;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity2.confbean.LostExpConst;
/*     */ import mzm.gsp.activity2.confbean.SActivityLostExpCfg;
/*     */ import mzm.gsp.award.SSynAllLostExpInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AllLostExpInfo;
/*     */ import xbean.Pod;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2alllostexpinfo;
/*     */ import xtable.User;
/*     */ 
/*     */ public class LostAwardManager
/*     */ {
/*  35 */   static Map<Integer, ActivityLostExpHandler> activityHandlers = new ConcurrentHashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void rgActivityHandler(int activityId, ActivityLostExpHandler handler)
/*     */   {
/*  45 */     activityHandlers.put(Integer.valueOf(activityId), handler);
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
/*     */   public static String getEachActivityStorageExpMaxPerDay(long roleId)
/*     */   {
/*  59 */     StringBuffer sb = new StringBuffer();
/*  60 */     Iterator<Map.Entry<Integer, ActivityLostExpHandler>> it = activityHandlers.entrySet().iterator();
/*  61 */     while (it.hasNext())
/*     */     {
/*  63 */       sb.append("\r\n");
/*  64 */       Map.Entry<Integer, ActivityLostExpHandler> entry = (Map.Entry)it.next();
/*  65 */       ActivityLostExpHandler handler = (ActivityLostExpHandler)entry.getValue();
/*  66 */       sb.append(handler.getActivityCHNName());
/*  67 */       sb.append("=");
/*  68 */       sb.append(handler.getAllStorageExpValue(roleId, ((Integer)entry.getKey()).intValue()));
/*     */     }
/*  70 */     return sb.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static ActivityLostExpHandler getHandler(int activityId)
/*     */   {
/*  82 */     return (ActivityLostExpHandler)activityHandlers.get(Integer.valueOf(activityId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getLostActivityId()
/*     */   {
/*  92 */     return LostExpConst.getInstance().activityid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void synAndRefreshLostInfo(long roleId, boolean needSend)
/*     */   {
/* 103 */     String userid = RoleInterface.getUserId(roleId);
/* 104 */     Lockeys.lock(Lockeys.get(User.getTable(), userid));
/*     */     
/* 106 */     Lockeys.lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/* 107 */     AllLostExpInfo xAllLostExpInfo = Role2alllostexpinfo.get(Long.valueOf(roleId));
/* 108 */     if (xAllLostExpInfo == null)
/*     */     {
/* 110 */       xAllLostExpInfo = Pod.newAllLostExpInfo();
/* 111 */       Role2alllostexpinfo.insert(Long.valueOf(roleId), xAllLostExpInfo);
/*     */     }
/* 113 */     checkAndInit(userid, roleId, xAllLostExpInfo, needSend);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkAndInit(String userId, long roleId, AllLostExpInfo xAllLostExpInfo, boolean needSend)
/*     */   {
/* 124 */     if (xAllLostExpInfo == null)
/*     */     {
/* 126 */       return;
/*     */     }
/*     */     
/* 129 */     boolean doInit = initData(userId, roleId, xAllLostExpInfo);
/*     */     
/* 131 */     if ((!doInit) && (!needSend))
/*     */     {
/*     */ 
/* 134 */       return;
/*     */     }
/* 136 */     recoverDBData(xAllLostExpInfo);
/* 137 */     synAllActivityLostInfo(roleId, xAllLostExpInfo.getActivityid2lostexpinfo());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void recoverDBData(AllLostExpInfo xAllLostExpInfo)
/*     */   {
/* 147 */     if (xAllLostExpInfo == null)
/*     */     {
/* 149 */       return;
/*     */     }
/* 151 */     for (xbean.LostExpInfo xLostExpInfo : xAllLostExpInfo.getActivityid2lostexpinfo().values())
/*     */     {
/* 153 */       int gainCollectExp = xLostExpInfo.getGaincollectexp();
/* 154 */       int totalExpValue = xLostExpInfo.getTotalloststoragevalue();
/* 155 */       if (gainCollectExp > totalExpValue)
/*     */       {
/*     */ 
/*     */ 
/* 159 */         xLostExpInfo.setTotalloststoragevalue(gainCollectExp);
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
/*     */ 
/*     */   private static boolean initData(String userId, long roleId, AllLostExpInfo xAllLostExpInfo)
/*     */   {
/* 173 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 174 */     if (!needUpdate(xAllLostExpInfo.getLastupdatetime(), curTime))
/*     */     {
/* 176 */       return false;
/*     */     }
/*     */     
/* 179 */     boolean needRefreshTotalValue = needRefreshTotalValue(xAllLostExpInfo.getLastupdatetime(), curTime);
/*     */     
/* 181 */     xAllLostExpInfo.setLastupdatetime(curTime);
/*     */     
/* 183 */     long lostActivityStartTime = ActivityInterface.getActivityStartTime(getLostActivityId());
/* 184 */     Map<Integer, xbean.LostExpInfo> xActivityLostExpInfos = initActivityDataByCfg(xAllLostExpInfo, lostActivityStartTime);
/* 185 */     Map<Integer, Integer> activity2emailExp = new HashMap();
/* 186 */     Iterator<Map.Entry<Integer, xbean.LostExpInfo>> it = xActivityLostExpInfos.entrySet().iterator();
/* 187 */     while (it.hasNext())
/*     */     {
/* 189 */       Map.Entry<Integer, xbean.LostExpInfo> entry = (Map.Entry)it.next();
/* 190 */       initSingleActivity(roleId, curTime, lostActivityStartTime, ((Integer)entry.getKey()).intValue(), (xbean.LostExpInfo)entry.getValue(), activity2emailExp, needRefreshTotalValue);
/*     */     }
/*     */     
/*     */ 
/* 194 */     emailForgetExp(userId, roleId, activity2emailExp);
/* 195 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Map<Integer, xbean.LostExpInfo> initActivityDataByCfg(AllLostExpInfo xAllLostExpInfo, long lostActivityStartTime)
/*     */   {
/* 207 */     Map<Integer, xbean.LostExpInfo> xActivityLostExpInfos = xAllLostExpInfo.getActivityid2lostexpinfo();
/* 208 */     for (Iterator i$ = SActivityLostExpCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityId = ((Integer)i$.next()).intValue();
/*     */       
/* 210 */       xbean.LostExpInfo xLostExpInfo = (xbean.LostExpInfo)xActivityLostExpInfos.get(Integer.valueOf(activityId));
/* 211 */       if (xLostExpInfo == null)
/*     */       {
/* 213 */         xLostExpInfo = Pod.newLostExpInfo();
/* 214 */         xActivityLostExpInfos.put(Integer.valueOf(activityId), xLostExpInfo);
/*     */       }
/*     */     }
/*     */     
/* 218 */     return xActivityLostExpInfos;
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
/*     */   private static void emailForgetExp(String userId, long roleId, Map<Integer, Integer> activity2emailExp)
/*     */   {
/* 233 */     if ((activity2emailExp == null) || (activity2emailExp.size() == 0))
/*     */     {
/* 235 */       return;
/*     */     }
/*     */     
/* 238 */     int totalEmailExpValue = 0;
/* 239 */     for (Integer exp : activity2emailExp.values())
/*     */     {
/* 241 */       totalEmailExpValue += exp.intValue();
/*     */     }
/* 243 */     if (totalEmailExpValue <= 0)
/*     */     {
/* 245 */       return;
/*     */     }
/*     */     
/* 248 */     RoleInterface.addExp(userId, roleId, totalEmailExpValue, new TLogArg(LogReason.AWARD_EMAIL_LOST_STORAGE_EXP));
/*     */     
/* 250 */     List<String> contentArgs = new ArrayList();
/* 251 */     contentArgs.add(String.valueOf(totalEmailExpValue));
/* 252 */     mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(roleId, LostExpConst.getInstance().getLostExpTipMailId, new ArrayList(), contentArgs, new TLogArg(LogReason.AWARD_EMAIL_TIP_LOST_STORAGE_EXP));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void synAllActivityLostInfo(long roleId, Map<Integer, xbean.LostExpInfo> xActivityLostExpInfos)
/*     */   {
/* 264 */     if ((xActivityLostExpInfos == null) || (xActivityLostExpInfos.size() == 0))
/*     */     {
/* 266 */       return;
/*     */     }
/* 268 */     if (!ActivityInterface.isActivityOpen(getLostActivityId()))
/*     */     {
/*     */ 
/* 271 */       return;
/*     */     }
/* 273 */     SSynAllLostExpInfo p = new SSynAllLostExpInfo();
/* 274 */     Iterator<Map.Entry<Integer, xbean.LostExpInfo>> it = xActivityLostExpInfos.entrySet().iterator();
/* 275 */     while (it.hasNext())
/*     */     {
/* 277 */       Map.Entry<Integer, xbean.LostExpInfo> entry = (Map.Entry)it.next();
/* 278 */       int activityId = ((Integer)entry.getKey()).intValue();
/* 279 */       xbean.LostExpInfo xLostExpInfo = (xbean.LostExpInfo)entry.getValue();
/*     */       
/* 281 */       mzm.gsp.award.LostExpInfo pLostExpInfo = new mzm.gsp.award.LostExpInfo();
/* 282 */       fillSIngleLostInfo(roleId, activityId, xLostExpInfo, pLostExpInfo);
/* 283 */       p.activityid2lostexpinfo.put(Integer.valueOf(activityId), pLostExpInfo);
/*     */     }
/* 285 */     OnlineManager.getInstance().send(roleId, p);
/*     */   }
/*     */   
/*     */   static void fillSIngleLostInfo(long roleId, int activityId, xbean.LostExpInfo xLostExpInfo, mzm.gsp.award.LostExpInfo pLostExpInfo)
/*     */   {
/* 290 */     pLostExpInfo.totalvalue = xLostExpInfo.getTotalloststoragevalue();
/* 291 */     pLostExpInfo.alreadygetvalue = xLostExpInfo.getGaincollectexp();
/* 292 */     pLostExpInfo.cangetvalue = getProNeedCanGainCount(roleId, activityId, xLostExpInfo);
/* 293 */     pLostExpInfo.alreadygetexp = (xLostExpInfo.getAlreadygainlostexp() ? 1 : 0);
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
/*     */   static int getProNeedCanGainCount(long roleId, int activityId, xbean.LostExpInfo xLostExpInfo)
/*     */   {
/* 306 */     if (!withinReturnTime())
/*     */     {
/* 308 */       return 0;
/*     */     }
/* 310 */     if (xLostExpInfo.getAlreadygainlostexp())
/*     */     {
/* 312 */       return 0;
/*     */     }
/* 314 */     return getCanGetExp(roleId, activityId, xLostExpInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean withinCollectTime()
/*     */   {
/* 324 */     int stage = ActivityInterface.getActivityStage(getLostActivityId());
/* 325 */     if (stage != 0)
/*     */     {
/* 327 */       return false;
/*     */     }
/* 329 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean withinReturnTime()
/*     */   {
/* 339 */     int stage = ActivityInterface.getActivityStage(getLostActivityId());
/* 340 */     if (stage != 1)
/*     */     {
/* 342 */       return false;
/*     */     }
/* 344 */     return true;
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
/*     */   private static void initSingleActivity(long roleId, long curTime, long lostActivityStartTime, int activityId, xbean.LostExpInfo xLostExpInfo, Map<Integer, Integer> activity2emailExp, boolean needRefreshTotalValue)
/*     */   {
/* 361 */     if (lostActivityStartTime <= 0L)
/*     */     {
/*     */ 
/* 364 */       return;
/*     */     }
/* 366 */     if (!ActivityInterface.isInActivityLevel(RoleInterface.getUserId(roleId), roleId, activityId))
/*     */     {
/*     */ 
/* 369 */       return;
/*     */     }
/*     */     
/* 372 */     if (xLostExpInfo.getBegintime() <= 0L)
/*     */     {
/* 374 */       xLostExpInfo.setBegintime(lostActivityStartTime);
/*     */     }
/*     */     
/* 377 */     int oldGainExp = xLostExpInfo.getTotalgainloststoragevalue();
/* 378 */     xLostExpInfo.setTotalgainloststoragevalue(oldGainExp + xLostExpInfo.getAlreadygetstoragevalue());
/*     */     
/* 380 */     xLostExpInfo.setAlreadygetstoragevalue(0);
/*     */     
/* 382 */     if (needRefreshTotalValue)
/*     */     {
/* 384 */       int totalLostExp = getTotalLostExp(roleId, activityId, curTime, xLostExpInfo);
/* 385 */       xLostExpInfo.setTotalloststoragevalue(totalLostExp);
/*     */     }
/*     */     
/* 388 */     int emailValue = giveLastLostExp(roleId, activityId, xLostExpInfo);
/* 389 */     if (emailValue > 0)
/*     */     {
/* 391 */       activity2emailExp.put(Integer.valueOf(activityId), Integer.valueOf(emailValue));
/*     */     }
/*     */     
/* 394 */     xLostExpInfo.setAlreadygainlostexp(false);
/* 395 */     xLostExpInfo.setCangainlostexp(false);
/*     */   }
/*     */   
/*     */   private static int giveLastLostExp(long roleId, int activityId, xbean.LostExpInfo xLostExpInfo)
/*     */   {
/* 400 */     if ((!xLostExpInfo.getCangainlostexp()) || (xLostExpInfo.getAlreadygainlostexp()))
/*     */     {
/* 402 */       return 0;
/*     */     }
/* 404 */     int returnValue = getCanGetExp(roleId, activityId, xLostExpInfo);
/* 405 */     if (returnValue > 0)
/*     */     {
/* 407 */       int gainCollectExp = xLostExpInfo.getGaincollectexp();
/* 408 */       xLostExpInfo.setGaincollectexp(gainCollectExp + returnValue);
/*     */     }
/* 410 */     GameServer.logger().info(String.format("[lostexp]LostAwardManager.giveLastLostExp@ email last lost exp!|roleId=%d|activityId=%d|returnValue=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(activityId), Integer.valueOf(returnValue) }));
/*     */     
/*     */ 
/*     */ 
/* 414 */     return returnValue;
/*     */   }
/*     */   
/*     */   static int getCanGetExp(long roleId, int activityId, xbean.LostExpInfo xLostExpInfo)
/*     */   {
/* 419 */     int singleCanLostExp = getSingleCircleCanGetExp(roleId, activityId);
/* 420 */     int totalExp = xLostExpInfo.getTotalloststoragevalue();
/* 421 */     int gainCollectExp = xLostExpInfo.getGaincollectexp();
/* 422 */     int xLeftExp = totalExp - gainCollectExp;
/* 423 */     if (xLeftExp <= 0)
/*     */     {
/* 425 */       return 0;
/*     */     }
/* 427 */     int returnValue = singleCanLostExp;
/* 428 */     int leftValue = xLeftExp - singleCanLostExp;
/* 429 */     if (leftValue <= singleCanLostExp * (LostExpConst.getInstance().remainExpRet / 10000))
/*     */     {
/* 431 */       returnValue = xLeftExp;
/*     */     }
/* 433 */     return returnValue;
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
/*     */   private static boolean needUpdate(long lastUpdateTime, long curTime)
/*     */   {
/* 447 */     long activityStartTime = ActivityInterface.getActivityStartTime(getLostActivityId());
/* 448 */     if (activityStartTime <= 0L)
/*     */     {
/*     */ 
/* 451 */       return false;
/*     */     }
/* 453 */     long activityEndTime = ActivityInterface.getActivityEndTime(getLostActivityId());
/* 454 */     if (lastUpdateTime > activityEndTime)
/*     */     {
/*     */ 
/* 457 */       return false;
/*     */     }
/* 459 */     if ((lastUpdateTime == 0L) && (curTime > activityEndTime))
/*     */     {
/*     */ 
/* 462 */       return false;
/*     */     }
/* 464 */     return DateTimeUtils.needDailyReset(lastUpdateTime, curTime, 0);
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
/*     */   static int getCanLostCircleExp(long roleId, int activityId, long lostActivityStartTime, long curTime)
/*     */   {
/* 478 */     int circle = getActivityCircle(activityId, lostActivityStartTime, getCheckTime(curTime));
/* 479 */     if (circle <= 0)
/*     */     {
/* 481 */       return 0;
/*     */     }
/* 483 */     return circle * getSingleCircleCanGetExp(roleId, activityId);
/*     */   }
/*     */   
/*     */   private static long getCheckTime(long curTime)
/*     */   {
/* 488 */     long checkTime = curTime;
/* 489 */     long collectEndTime = getCollectEndTime();
/* 490 */     if (curTime > collectEndTime)
/*     */     {
/* 492 */       checkTime = collectEndTime;
/*     */     }
/* 494 */     return checkTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static long getCollectEndTime()
/*     */   {
/* 504 */     long activityStartTime = ActivityInterface.getActivityStartTime(getLostActivityId());
/* 505 */     long interval = TimeUnit.DAYS.toMillis(LostExpConst.getInstance().collectExpInterval);
/* 506 */     return activityStartTime + interval + 10000L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean needRefreshTotalValue(long startTime, long endTime)
/*     */   {
/* 518 */     if (startTime > endTime)
/*     */     {
/* 520 */       return false;
/*     */     }
/* 522 */     long activityStartTime = ActivityInterface.getActivityStartTime(getLostActivityId());
/* 523 */     long collectEndTime = getCollectEndTime();
/* 524 */     if (startTime > collectEndTime)
/*     */     {
/* 526 */       return false;
/*     */     }
/* 528 */     if (endTime < activityStartTime)
/*     */     {
/* 530 */       return false;
/*     */     }
/* 532 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getSingleCircleCanGetExp(long roleId, int activityId)
/*     */   {
/* 544 */     ActivityLostExpHandler handler = getHandler(activityId);
/* 545 */     if (handler == null)
/*     */     {
/* 547 */       GameServer.logger().error(String.format("[lostexp]LostAwardManager.getCanLostCircleExp@ not hava ActivityLostExpHandler!|roleId=%d|activityId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(activityId) }));
/*     */       
/*     */ 
/*     */ 
/* 551 */       return 0;
/*     */     }
/* 553 */     return handler.getAllStorageExpValue(roleId, activityId);
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
/*     */   static int getActivityLittleNumExp(long roleId, int activityId, int activityLittleNum)
/*     */   {
/* 569 */     ActivityLostExpHandler handler = getHandler(activityId);
/* 570 */     if (handler == null)
/*     */     {
/* 572 */       GameServer.logger().error(String.format("[lostexp]LostAwardManager.getActivityLittleNumExp@ not hava ActivityLostExpHandler!|roleId=%d|activityId=%d", new Object[] { Integer.valueOf(activityId) }));
/*     */       
/*     */ 
/*     */ 
/* 576 */       return 0;
/*     */     }
/* 578 */     return handler.getCanGetStorageExpValue(roleId, activityId, activityLittleNum);
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
/*     */   static int getTotalLostExp(long roleId, int activityId, long curTime, xbean.LostExpInfo xLostExpInfo)
/*     */   {
/* 592 */     int canTotalLostExp = getCanLostCircleExp(roleId, activityId, xLostExpInfo.getBegintime(), curTime);
/* 593 */     if (canTotalLostExp <= 0)
/*     */     {
/*     */ 
/* 596 */       return 0;
/*     */     }
/* 598 */     int canLostExp = canTotalLostExp - xLostExpInfo.getTotalgainloststoragevalue();
/* 599 */     return canLostExp > 0 ? canLostExp : 0;
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
/*     */   static int getActivityCircle(int activityId, long timeBegin, long timeEnd)
/*     */   {
/* 617 */     if (timeBegin >= timeEnd)
/*     */     {
/* 619 */       GameServer.logger().error(String.format("[lostexp]LostAwardManager.getActivityCircle@ time illegal!|activityId=%d|time_0=%d|time_1=%d", new Object[] { Integer.valueOf(activityId), Long.valueOf(timeBegin), Long.valueOf(timeEnd) }));
/*     */       
/*     */ 
/*     */ 
/* 623 */       return 0;
/*     */     }
/* 625 */     return ActivityInterface.getActivityTurnNumIncludeBeginTime(activityId, timeBegin, timeEnd);
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
/*     */   static boolean onActivityCountAdd(long roleId, int activityId, int activityLittleNum)
/*     */   {
/* 641 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/* 643 */       return false;
/*     */     }
/* 645 */     if (!ActivityInterface.isActivityOpen(LostExpConst.getInstance().activityid))
/*     */     {
/* 647 */       return false;
/*     */     }
/* 649 */     if (activityLittleNum <= 0)
/*     */     {
/* 651 */       GameServer.logger().error(String.format("[lostexp]AbsActivityLostPro.addAlreadyGetStorageExpValue@ activityLittleNum is illegal!|roleId=%d|acitivityId=%d|activityLittleNum=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(activityId), Integer.valueOf(activityLittleNum) }));
/*     */       
/*     */ 
/*     */ 
/* 655 */       return false;
/*     */     }
/* 657 */     SActivityLostExpCfg cfg = SActivityLostExpCfg.get(activityId);
/* 658 */     if (cfg == null)
/*     */     {
/* 660 */       GameServer.logger().error(String.format("[lostexp]AbsActivityLostPro.addAlreadyGetStorageExpValue@ SActivityLostExpCfg is null!|roleId=%d|acitivityId=%d|activityLittleNum=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(activityId), Integer.valueOf(activityLittleNum) }));
/*     */       
/*     */ 
/*     */ 
/* 664 */       return false;
/*     */     }
/*     */     
/* 667 */     String userid = RoleInterface.getUserId(roleId);
/* 668 */     Lockeys.lock(Lockeys.get(User.getTable(), userid));
/*     */     
/* 670 */     Lockeys.lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/* 671 */     AllLostExpInfo xAllLostExpInfo = Role2alllostexpinfo.get(Long.valueOf(roleId));
/* 672 */     if (xAllLostExpInfo == null)
/*     */     {
/* 674 */       xAllLostExpInfo = Pod.newAllLostExpInfo();
/* 675 */       Role2alllostexpinfo.insert(Long.valueOf(roleId), xAllLostExpInfo);
/*     */     }
/*     */     
/* 678 */     checkAndInit(userid, roleId, xAllLostExpInfo, false);
/* 679 */     Map<Integer, xbean.LostExpInfo> xActivityLostInfos = xAllLostExpInfo.getActivityid2lostexpinfo();
/* 680 */     xbean.LostExpInfo xLostExpInfo = (xbean.LostExpInfo)xActivityLostInfos.get(Integer.valueOf(activityId));
/* 681 */     if (xLostExpInfo == null)
/*     */     {
/* 683 */       xLostExpInfo = Pod.newLostExpInfo();
/* 684 */       xActivityLostInfos.put(Integer.valueOf(activityId), xLostExpInfo);
/*     */     }
/* 686 */     int stage = ActivityInterface.getActivityStage(getLostActivityId());
/*     */     
/* 688 */     if (stage == 0)
/*     */     {
/* 690 */       return handInCollectionTime(roleId, activityId, activityLittleNum, xLostExpInfo);
/*     */     }
/*     */     
/* 693 */     if (stage == 1)
/*     */     {
/* 695 */       return handInReturnTime(activityLittleNum, cfg, xLostExpInfo);
/*     */     }
/* 697 */     GameServer.logger().error(String.format("[lostexp]AbsActivityLostPro.addAlreadyGetStorageExpValue@ illegal stage!|roleId=%d|acitivityId=%d|activityLittleNum=%d|stage=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(activityId), Integer.valueOf(activityLittleNum), Integer.valueOf(stage) }));
/*     */     
/*     */ 
/*     */ 
/* 701 */     return false;
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
/*     */   private static boolean handInReturnTime(int activityLittleNum, SActivityLostExpCfg cfg, xbean.LostExpInfo xLostExpInfo)
/*     */   {
/* 714 */     int finishCount = cfg.finishCount;
/* 715 */     if (finishCount <= 0)
/*     */     {
/* 717 */       return false;
/*     */     }
/* 719 */     if (finishCount <= activityLittleNum)
/*     */     {
/*     */ 
/* 722 */       xLostExpInfo.setCangainlostexp(true);
/*     */     }
/* 724 */     return true;
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
/*     */   private static boolean handInCollectionTime(long roleId, int activityId, int activityLittleNum, xbean.LostExpInfo xLostExpInfo)
/*     */   {
/* 740 */     int addStorageValue = getActivityLittleNumExp(roleId, activityId, activityLittleNum);
/* 741 */     if (addStorageValue <= 0)
/*     */     {
/* 743 */       return false;
/*     */     }
/* 745 */     int oldValue = xLostExpInfo.getAlreadygetstoragevalue();
/* 746 */     xLostExpInfo.setAlreadygetstoragevalue(oldValue + addStorageValue);
/*     */     
/* 748 */     GameServer.logger().info(String.format("[lostexp]AbsActivityLostPro.addAlreadyGetStorageExpValue@ add storage exp!|roleId=%d|acitivityId=%d|activityLittleNum=%d|addValue=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(activityId), Integer.valueOf(activityLittleNum), Integer.valueOf(addStorageValue) }));
/*     */     
/*     */ 
/*     */ 
/* 752 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isLostExpOpen(long roleId, boolean needSendMsg)
/*     */   {
/* 764 */     if (!OpenInterface.getOpenStatus(199))
/*     */     {
/* 766 */       return false;
/*     */     }
/* 768 */     if (OpenInterface.isBanPlay(roleId, 199))
/*     */     {
/* 770 */       if (needSendMsg)
/*     */       {
/* 772 */         OpenInterface.sendBanPlayMsg(roleId, 199);
/*     */       }
/* 774 */       return false;
/*     */     }
/* 776 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isDebugLogEnabled()
/*     */   {
/* 781 */     return GameServer.logger().isDebugEnabled();
/*     */   }
/*     */   
/*     */   public static void logDebug(String format, Object... args)
/*     */   {
/* 786 */     GameServer.logger().debug(String.format(format, args));
/*     */   }
/*     */   
/*     */   public static void logInfo(String format, Object... args)
/*     */   {
/* 791 */     GameServer.logger().info(String.format(format, args));
/*     */   }
/*     */   
/*     */   public static void logWarn(String format, Object... args)
/*     */   {
/* 796 */     GameServer.logger().warn(String.format(format, args));
/*     */   }
/*     */   
/*     */   public static void logError(String format, Object... args)
/*     */   {
/* 801 */     GameServer.logger().error(String.format(format, args));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storageexp\activity\LostAwardManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */