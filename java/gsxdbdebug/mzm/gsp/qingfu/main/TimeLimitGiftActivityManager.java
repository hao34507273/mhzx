/*     */ package mzm.gsp.qingfu.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.PushAwardConst;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLimitTimeStageEnum;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.GiftBagId2Count;
/*     */ import mzm.gsp.qingfu.SSynGiftActivityAwardRes;
/*     */ import mzm.gsp.qingfu.SSyncTimeLimitGiftActivityInfo;
/*     */ import mzm.gsp.qingfu.confbean.ActivityId2GiftBagType;
/*     */ import mzm.gsp.qingfu.confbean.SOpenWelfareConst;
/*     */ import mzm.gsp.qingfu.confbean.STimeLimitGiftBagCfg;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Giftid2count;
/*     */ import xbean.Pod;
/*     */ import xbean.TimeLimitGift;
/*     */ import xbean.TimeLimitGiftInfo;
/*     */ import xdb.Executor;
/*     */ import xtable.Role2timelimitgift;
/*     */ 
/*     */ public class TimeLimitGiftActivityManager
/*     */ {
/*  39 */   private static final Map<Integer, WeeklyTimeLimitGetAwardHandler> activityId2WeeklyGetAwardHandler = new HashMap();
/*     */   
/*     */   static final void init()
/*     */   {
/*  43 */     TimeLimitGiftActivtiyHandler handler = new TimeLimitGiftActivtiyHandler();
/*  44 */     ActivityInterface.registerActivityByLogicType(45, handler);
/*  45 */     for (STimeLimitGiftBagCfg s : STimeLimitGiftBagCfg.getAll().values())
/*     */     {
/*  47 */       mzm.gsp.item.main.access.ItemAccessManager.registerActivityFixReward(s.activityId, s.rewardId);
/*     */     }
/*  49 */     registerWeeklyGetAwardHandler(SOpenWelfareConst.getInstance().activity_cfg_id, new OpenWelfareGetAwardHandler());
/*  50 */     registerWeeklyGetAwardHandler(PushAwardConst.getInstance().activityid, PushAwardHandler.getInstance());
/*     */   }
/*     */   
/*     */ 
/*     */   static synchronized void registerWeeklyGetAwardHandler(int activityid, WeeklyTimeLimitGetAwardHandler weeklyTimeLimitGetAwardHandler)
/*     */   {
/*  56 */     activityId2WeeklyGetAwardHandler.put(Integer.valueOf(activityid), weeklyTimeLimitGetAwardHandler);
/*     */   }
/*     */   
/*     */   static synchronized WeeklyTimeLimitGetAwardHandler getAwardHandler(int activityid)
/*     */   {
/*  61 */     return (WeeklyTimeLimitGetAwardHandler)activityId2WeeklyGetAwardHandler.get(Integer.valueOf(activityid));
/*     */   }
/*     */   
/*     */ 
/*     */   static final boolean onActivityStartSendActivityInfo(int activityCfgid)
/*     */   {
/*  67 */     SSynGiftActivityAwardRes s = new SSynGiftActivityAwardRes();
/*  68 */     s.activity_id = activityCfgid;
/*  69 */     Map<Integer, Integer> giftbagid2mapMap = getGiftId2BuyCount(activityCfgid);
/*  70 */     if ((giftbagid2mapMap != null) && (!giftbagid2mapMap.isEmpty()))
/*     */     {
/*  72 */       s.gift_bag_id_2_remain_count.gift_bag_id_2_remain_count.putAll(getGiftId2BuyCount(activityCfgid));
/*     */     }
/*     */     
/*  75 */     OnlineManager.getInstance().sendAll(s);
/*     */     
/*  77 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static final boolean onRoleLogin(String userid, long roleid, TimeLimitGift xTimeLimitGift)
/*     */   {
/*  83 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  84 */     SSyncTimeLimitGiftActivityInfo res = new SSyncTimeLimitGiftActivityInfo();
/*  85 */     for (Iterator i$ = ActivityId2GiftBagType.getAll().keySet().iterator(); i$.hasNext();) { int activityId = ((Integer)i$.next()).intValue();
/*     */       
/*  87 */       ActivityLimitTimeStageEnum activityStateEnum = ActivityInterface.getActivityLimitTimeStage(activityId, now);
/*  88 */       if ((activityStateEnum == ActivityLimitTimeStageEnum.CFG_ERROR) || (activityStateEnum == ActivityLimitTimeStageEnum.LIMIT_TIME_AFTER))
/*     */       {
/*     */ 
/*  91 */         xTimeLimitGift.getActivityid2giftids().remove(Integer.valueOf(activityId));
/*     */         
/*  93 */         GameServer.logger().info(String.format("[timelimit]TimeLimitGiftActivityManager.onRoleLogin@not in activity time,remove role activity info |roleid=%d|userid=%s|activityId=%d", new Object[] { Long.valueOf(roleid), userid, Integer.valueOf(activityId) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/*  99 */       else if (!ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, activityId).isCanJoin())
/*     */       {
/* 101 */         GameServer.logger().info(String.format("[timelimit]TimeLimitGiftActivityManager.onRoleLogin@can not join activity |roleid=%d|userid=%s|activityId=%d", new Object[] { Long.valueOf(roleid), userid, Integer.valueOf(activityId) }));
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*     */ 
/* 110 */         Giftid2count xGiftid2count = (Giftid2count)xTimeLimitGift.getActivityid2giftids().get(Integer.valueOf(activityId));
/*     */         
/* 112 */         Map<Integer, Integer> giftbagid2Map = getGiftId2BuyCount(activityId);
/* 113 */         if ((giftbagid2Map != null) && (!giftbagid2Map.isEmpty()))
/*     */         {
/* 115 */           GiftBagId2Count giftBagId2Count = new GiftBagId2Count();
/*     */           
/* 117 */           for (Iterator i$ = giftbagid2Map.keySet().iterator(); i$.hasNext();) { int giftId = ((Integer)i$.next()).intValue();
/*     */             
/* 119 */             int maxBuyCount = ((Integer)giftbagid2Map.get(Integer.valueOf(giftId))).intValue();
/* 120 */             Integer alreadyBuyCount = null;
/* 121 */             if (xGiftid2count != null)
/*     */             {
/* 123 */               alreadyBuyCount = (Integer)xGiftid2count.getGiftid2count().get(Integer.valueOf(giftId));
/*     */             }
/*     */             
/* 126 */             if (alreadyBuyCount == null)
/*     */             {
/* 128 */               alreadyBuyCount = Integer.valueOf(0);
/*     */             }
/* 130 */             giftBagId2Count.gift_bag_id_2_remain_count.put(Integer.valueOf(giftId), Integer.valueOf(Math.max(0, maxBuyCount - alreadyBuyCount.intValue())));
/*     */           }
/*     */           
/* 133 */           res.activity_id_2_gift_info.put(Integer.valueOf(activityId), giftBagId2Count);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 138 */     OnlineManager.getInstance().send(roleid, res);
/*     */     
/* 140 */     long activity_start_time = ActivityInterface.getActivityStartTime(SOpenWelfareConst.getInstance().activity_cfg_id);
/* 141 */     sendMailToRole(userid, roleid, xTimeLimitGift, activity_start_time, now);
/* 142 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static final Map<Integer, Integer> getGiftId2BuyCount(int activityCfgid)
/*     */   {
/* 153 */     ActivityId2GiftBagType activityId2GiftBagType = ActivityId2GiftBagType.get(activityCfgid);
/* 154 */     if (activityId2GiftBagType == null)
/*     */     {
/* 156 */       return null;
/*     */     }
/* 158 */     Map<Integer, Integer> giftBagId2BuyCount = new HashMap();
/* 159 */     for (Iterator i$ = activityId2GiftBagType.giftBagTypeIds.iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/*     */       
/* 161 */       STimeLimitGiftBagCfg sTimeLimitGiftBagCfg = STimeLimitGiftBagCfg.get(id);
/* 162 */       if (sTimeLimitGiftBagCfg != null)
/*     */       {
/* 164 */         giftBagId2BuyCount.put(Integer.valueOf(sTimeLimitGiftBagCfg.id), Integer.valueOf(sTimeLimitGiftBagCfg.maxCount));
/*     */       }
/*     */     }
/*     */     
/* 168 */     return giftBagId2BuyCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isFreeGiftSwitchOpenForRole(long roleid)
/*     */   {
/* 179 */     if (!OpenInterface.getOpenStatus(116))
/*     */     {
/* 181 */       OpenInterface.sendCloseProtocol(roleid, 116, null);
/*     */       
/* 183 */       return false;
/*     */     }
/* 185 */     if (OpenInterface.isBanPlay(roleid, 116))
/*     */     {
/* 187 */       OpenInterface.sendBanPlayMsg(roleid, 116);
/* 188 */       return false;
/*     */     }
/* 190 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isTimeLimitGiftSwitchOpenForRole(long roleid)
/*     */   {
/* 202 */     if (!OpenInterface.getOpenStatus(115))
/*     */     {
/* 204 */       OpenInterface.sendCloseProtocol(roleid, 115, null);
/*     */       
/* 206 */       return false;
/*     */     }
/* 208 */     if (OpenInterface.isBanPlay(roleid, 115))
/*     */     {
/* 210 */       OpenInterface.sendBanPlayMsg(roleid, 115);
/* 211 */       return false;
/*     */     }
/* 213 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static final void initData(String userid, long roleId, int turn, int activityid)
/*     */   {
/* 219 */     TimeLimitGift xTimeLimitGift = Role2timelimitgift.get(Long.valueOf(roleId));
/* 220 */     if (xTimeLimitGift == null)
/*     */     {
/* 222 */       xTimeLimitGift = Pod.newTimeLimitGift();
/* 223 */       Role2timelimitgift.insert(Long.valueOf(roleId), xTimeLimitGift);
/*     */     }
/*     */     
/* 226 */     xTimeLimitGift.getActivityid2giftids().remove(Integer.valueOf(activityid));
/* 227 */     if (activityid == SOpenWelfareConst.getInstance().activity_cfg_id)
/*     */     {
/* 229 */       xTimeLimitGift.setIssendmail(false);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isOpenWelfareSwitchOpenForRole(long roleid)
/*     */   {
/* 241 */     if (!OpenInterface.getOpenStatus(139))
/*     */     {
/* 243 */       OpenInterface.sendCloseProtocol(roleid, 139, null);
/*     */       
/* 245 */       return false;
/*     */     }
/* 247 */     if (OpenInterface.isBanPlay(roleid, 139))
/*     */     {
/* 249 */       OpenInterface.sendBanPlayMsg(roleid, 139);
/* 250 */       return false;
/*     */     }
/* 252 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static void startOpenWelfareMailObserver(ActivityHandler.ActivityStartType activityStartType, int activity_id)
/*     */   {
/* 258 */     if (activity_id != SOpenWelfareConst.getInstance().activity_cfg_id)
/*     */     {
/* 260 */       return;
/*     */     }
/* 262 */     if (activityStartType.startAgain())
/*     */     {
/*     */ 
/* 265 */       long starttime = ActivityInterface.getActivityStartTime(activity_id);
/* 266 */       long startobservertime = starttime + TimeUnit.HOURS.toMillis(SOpenWelfareConst.getInstance().hour_after_activity_start);
/*     */       
/* 268 */       long curtime = DateTimeUtils.getCurrTimeInMillis();
/* 269 */       long length = startobservertime - curtime;
/* 270 */       if (length > 0L)
/*     */       {
/* 272 */         new OpenWelfareObserver(TimeUnit.MILLISECONDS.toSeconds(length));
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 277 */       new OpenWelfareObserver(TimeUnit.HOURS.toSeconds(SOpenWelfareConst.getInstance().hour_after_activity_start));
/*     */     }
/*     */   }
/*     */   
/*     */   private static class OpenWelfareObserver
/*     */     extends Observer
/*     */   {
/*     */     OpenWelfareObserver(long intervalSeconds)
/*     */     {
/* 286 */       super();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean update()
/*     */     {
/* 293 */       xdb.Xdb.executor().execute(new TimeLimitGiftActivityManager.OpenWelfareObserverTimeoutRunnable(null));
/* 294 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static class OpenWelfareObserverTimeoutRunnable
/*     */     extends mzm.gsp.util.LogicRunnable
/*     */   {
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/* 306 */       long activityStartTime = ActivityInterface.getActivityStartTime(SOpenWelfareConst.getInstance().activity_cfg_id);
/* 307 */       long curtime = DateTimeUtils.getCurrTimeInMillis();
/* 308 */       List<Long> roleList = OnlineManager.getInstance().getAllRolesInWorld();
/* 309 */       Iterator<Long> iterator = roleList.iterator();
/* 310 */       while (iterator.hasNext())
/*     */       {
/* 312 */         long roleid = ((Long)iterator.next()).longValue();
/*     */         
/* 314 */         new TimeLimitGiftActivityManager.SendOpenWelfarePro(roleid, activityStartTime, curtime).call();
/*     */         
/* 316 */         iterator.remove();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class SendOpenWelfarePro
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     
/*     */     private final long activity_start_time;
/*     */     
/*     */     private final long curtime;
/*     */     
/*     */     public SendOpenWelfarePro(long roleid, long activity_start_time, long curtime)
/*     */     {
/* 333 */       this.roleid = roleid;
/* 334 */       this.activity_start_time = activity_start_time;
/* 335 */       this.curtime = curtime;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 341 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/* 342 */       TimeLimitGift xTimeLimitGift = Role2timelimitgift.get(Long.valueOf(this.roleid));
/* 343 */       if (xTimeLimitGift == null)
/*     */       {
/* 345 */         xTimeLimitGift = Pod.newTimeLimitGift();
/* 346 */         Role2timelimitgift.insert(Long.valueOf(this.roleid), xTimeLimitGift);
/*     */       }
/* 348 */       return TimeLimitGiftActivityManager.sendMailToRole(userid, this.roleid, xTimeLimitGift, this.activity_start_time, this.curtime);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static boolean sendMailToRole(String userid, long roleid, TimeLimitGift xTimeLimitGift, long activity_start_time, long curtime)
/*     */   {
/* 356 */     if (!isOpenWelfareSwitchOpenForRole(roleid))
/*     */     {
/* 358 */       GameServer.logger().info(String.format("[qingfu]TimeLimitGiftActivityManager.sendMailToRole@openwelfare switch closed|roleid=%d|maidid=%d|activityId=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(SOpenWelfareConst.getInstance().mail_id), Integer.valueOf(SOpenWelfareConst.getInstance().activity_cfg_id) }));
/*     */       
/*     */ 
/*     */ 
/* 362 */       return false;
/*     */     }
/* 364 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, SOpenWelfareConst.getInstance().activity_cfg_id);
/*     */     
/* 366 */     if (!res.isCanJoin())
/*     */     {
/* 368 */       GameServer.logger().info(String.format("[qingfu]TimeLimitGiftActivityManager.sendMailToRole@role can not join activity|roleid=%d|maidid=%d|activityId=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(SOpenWelfareConst.getInstance().mail_id), Integer.valueOf(SOpenWelfareConst.getInstance().activity_cfg_id) }));
/*     */       
/*     */ 
/*     */ 
/* 372 */       return false;
/*     */     }
/* 374 */     if (xTimeLimitGift.getIssendmail())
/*     */     {
/* 376 */       GameServer.logger().info(String.format("[qingfu]TimeLimitGiftActivityManager.sendMailToRole@role already send openwelfare mail|roleid=%d|maidid=%d|activityId=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(SOpenWelfareConst.getInstance().mail_id), Integer.valueOf(SOpenWelfareConst.getInstance().activity_cfg_id) }));
/*     */       
/*     */ 
/*     */ 
/* 380 */       return false;
/*     */     }
/* 382 */     long startime = activity_start_time + TimeUnit.HOURS.toMillis(SOpenWelfareConst.getInstance().hour_after_activity_start);
/*     */     
/* 384 */     long endtime = startime + TimeUnit.HOURS.toMillis(SOpenWelfareConst.getInstance().persist_hour);
/*     */     
/* 386 */     if ((endtime < curtime) || (curtime < startime))
/*     */     {
/* 388 */       GameServer.logger().info(String.format("[qingfu]TimeLimitGiftActivityManager.sendMailToRole@exceed effect time|roleid=%d|curtime=%d|endtime=%d|starttime=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(curtime), Long.valueOf(endtime), Long.valueOf(startime) }));
/*     */       
/*     */ 
/*     */ 
/* 392 */       return false;
/*     */     }
/* 394 */     TLogArg tLogArg = new TLogArg(mzm.gsp.tlog.LogReason.OPEN_WELFARE_MAIL, SOpenWelfareConst.getInstance().mail_id);
/* 395 */     SendMailRet ret = mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(roleid, SOpenWelfareConst.getInstance().mail_id, null, null, tLogArg);
/*     */     
/* 397 */     if (ret.isOK())
/*     */     {
/* 399 */       xTimeLimitGift.setIssendmail(true);
/* 400 */       GameServer.logger().info(String.format("[qingfu]TimeLimitGiftActivityManager.sendMailToRole@send mail to role success|roleid=%d|maidid=%d|activityId=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(SOpenWelfareConst.getInstance().mail_id), Integer.valueOf(SOpenWelfareConst.getInstance().activity_cfg_id) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 405 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 409 */     GameServer.logger().error(String.format("[qingfu]TimeLimitGiftActivityManager.sendMailToRole@send mail to role error|roleid=%d|maidid=%d|activityId=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(SOpenWelfareConst.getInstance().mail_id), Integer.valueOf(SOpenWelfareConst.getInstance().activity_cfg_id) }));
/*     */     
/*     */ 
/*     */ 
/* 413 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static Map<Long, Integer> getCloseFriendsByIntimacy(long roleId, int intimacyMin, boolean isHoldRoleLock)
/*     */   {
/* 420 */     Map<Long, Integer> friendId2intimacyMap = FriendInterface.getAllFriendValue(roleId, isHoldRoleLock);
/*     */     
/* 422 */     Map<Long, Integer> closeFriendId2intimacyMap = new HashMap();
/*     */     
/*     */ 
/* 425 */     for (Map.Entry<Long, Integer> entry : friendId2intimacyMap.entrySet())
/*     */     {
/* 427 */       int intimacy = ((Integer)entry.getValue()).intValue();
/* 428 */       if (intimacy >= intimacyMin)
/*     */       {
/*     */ 
/*     */ 
/* 432 */         closeFriendId2intimacyMap.put(entry.getKey(), Integer.valueOf(intimacy)); }
/*     */     }
/* 434 */     return closeFriendId2intimacyMap;
/*     */   }
/*     */   
/*     */ 
/*     */   static TimeLimitGiftInfo getTimeLimitGiftInfo(long roleId, int activityId, int giftBagCfgId, boolean isHoldRoleLock)
/*     */   {
/* 440 */     TimeLimitGift xTimeLimitGift = isHoldRoleLock ? Role2timelimitgift.get(Long.valueOf(roleId)) : Role2timelimitgift.select(Long.valueOf(roleId));
/*     */     
/*     */ 
/* 443 */     if (xTimeLimitGift == null)
/*     */     {
/* 445 */       return null;
/*     */     }
/*     */     
/* 448 */     Giftid2count xGiftid2count = (Giftid2count)xTimeLimitGift.getActivityid2giftids().get(Integer.valueOf(activityId));
/* 449 */     if (xGiftid2count == null)
/*     */     {
/* 451 */       return null;
/*     */     }
/* 453 */     return (TimeLimitGiftInfo)xGiftid2count.getGift_cfg_id2gift_info().get(Integer.valueOf(giftBagCfgId));
/*     */   }
/*     */   
/*     */ 
/*     */   static TimeLimitGiftInfo getTimeLimitGiftInfoCreateIfNotExist(long roleId, int activityId, int giftBagCfgId)
/*     */   {
/* 459 */     TimeLimitGift xTimeLimitGift = Role2timelimitgift.get(Long.valueOf(roleId));
/* 460 */     if (xTimeLimitGift == null)
/*     */     {
/* 462 */       xTimeLimitGift = Pod.newTimeLimitGift();
/* 463 */       Role2timelimitgift.insert(Long.valueOf(roleId), xTimeLimitGift);
/*     */     }
/*     */     
/* 466 */     Giftid2count xGiftid2count = (Giftid2count)xTimeLimitGift.getActivityid2giftids().get(Integer.valueOf(activityId));
/* 467 */     if (xGiftid2count == null)
/*     */     {
/* 469 */       xGiftid2count = Pod.newGiftid2count();
/* 470 */       xTimeLimitGift.getActivityid2giftids().put(Integer.valueOf(activityId), xGiftid2count);
/*     */     }
/* 472 */     TimeLimitGiftInfo xTimeLimitGiftInfo = (TimeLimitGiftInfo)xGiftid2count.getGift_cfg_id2gift_info().get(Integer.valueOf(giftBagCfgId));
/* 473 */     if (xTimeLimitGiftInfo == null)
/*     */     {
/* 475 */       xTimeLimitGiftInfo = Pod.newTimeLimitGiftInfo();
/* 476 */       xGiftid2count.getGift_cfg_id2gift_info().put(Integer.valueOf(giftBagCfgId), xTimeLimitGiftInfo);
/*     */     }
/* 478 */     return xTimeLimitGiftInfo;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\TimeLimitGiftActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */