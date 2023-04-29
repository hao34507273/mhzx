/*     */ package mzm.gsp.shimen.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.activity.SShimenDayPerfectAward;
/*     */ import mzm.gsp.activity.SShimenWeekPerfectAward;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.shimen.confbean.SOcp2graphnpcs;
/*     */ import mzm.gsp.shimen.confbean.SShimenModifyCfg;
/*     */ import mzm.gsp.shimen.confbean.ShimenActivityCfgConsts;
/*     */ import mzm.gsp.shimen.event.ShimenActivityArg;
/*     */ import mzm.gsp.shimen.event.ShimenActivityFinished;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.storageexp.main.StorageExpInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.DayPerfectRingCout;
/*     */ import xbean.Pod;
/*     */ import xbean.WeekPerfectRingCout;
/*     */ import xtable.Role2dayperfectringcount;
/*     */ import xtable.Role2weekperfectringcount;
/*     */ 
/*     */ 
/*     */ 
/*     */ class ShimenManager
/*     */ {
/*  42 */   static final Logger logger = Logger.getLogger("ShimenManager");
/*     */   
/*     */ 
/*     */   private static final int WAN = 10000;
/*     */   
/*     */ 
/*     */   static void init()
/*     */   {
/*     */     try
/*     */     {
/*  52 */       ActivityInterface.registerActivityByLogicType(0, new PerfectRingActivityInit());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  56 */       throw new RuntimeException(e);
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
/*     */   static int getModifyId(int ringcount)
/*     */   {
/*  69 */     SShimenModifyCfg s = SShimenModifyCfg.get(ringcount);
/*  70 */     if (s == null)
/*     */     {
/*  72 */       return ShimenActivityCfgConsts.getInstance().SHIMEN_DEFAULT_MODIFY_ID;
/*     */     }
/*     */     
/*  75 */     return s.modifyId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getShimenGraphIdByMenpai(int menpai)
/*     */   {
/*  86 */     if (SOcp2graphnpcs.get(menpai) == null)
/*     */     {
/*  88 */       return -1;
/*     */     }
/*  90 */     return SOcp2graphnpcs.get(menpai).graphid;
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean isShimenActivity(long roleId, int graphId)
/*     */   {
/*  96 */     int roleOcp = RoleInterface.getOccupationId(roleId);
/*  97 */     int rolegraph = getShimenGraphIdByMenpai(roleOcp);
/*  98 */     if ((rolegraph == -1) || (rolegraph != graphId))
/*     */     {
/* 100 */       return false;
/*     */     }
/* 102 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getShimenNPCByMenpai(int menpai)
/*     */   {
/* 113 */     if (SOcp2graphnpcs.get(menpai) == null)
/*     */     {
/* 115 */       return -1;
/*     */     }
/* 117 */     return SOcp2graphnpcs.get(menpai).npc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getShimenServiceByMenpai(int menpai)
/*     */   {
/* 128 */     if (SOcp2graphnpcs.get(menpai) == null)
/*     */     {
/* 130 */       return -1;
/*     */     }
/* 132 */     return SOcp2graphnpcs.get(menpai).npcservice;
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
/*     */   static void computeReserveExp(String userid, long roleid, int shimencount, int turn)
/*     */   {
/* 145 */     if (shimencount < 0)
/*     */     {
/* 147 */       return;
/*     */     }
/*     */     
/* 150 */     if (!ActivityInterface.isInActivityLevel(userid, roleid, ShimenActivityCfgConsts.getInstance().ACTIVITYID))
/*     */     {
/* 152 */       return;
/*     */     }
/*     */     
/* 155 */     int oneturnexp = getShimenExp(userid, roleid, 1, ShimenActivityCfgConsts.getInstance().DAY_PERFECT_CIRCLE_COUNT);
/* 156 */     double exp = oneturnexp * turn;
/* 157 */     if (shimencount >= 0)
/*     */     {
/* 159 */       exp += getShimenExp(userid, roleid, shimencount + 1, ShimenActivityCfgConsts.getInstance().DAY_PERFECT_CIRCLE_COUNT);
/*     */     }
/* 161 */     int desaddexp = (int)(exp * ShimenActivityCfgConsts.getInstance().EXP_CHANGE_RATE / 10000.0D);
/* 162 */     if (desaddexp > 0)
/*     */     {
/* 164 */       StorageExpInterface.addStorageExp(roleid, desaddexp);
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
/*     */   static int getShimenExp(String userid, long roleid, int startcount, int endcount)
/*     */   {
/* 180 */     if (!ActivityInterface.isInActivityLevel(userid, roleid, ShimenActivityCfgConsts.getInstance().ACTIVITYID))
/*     */     {
/* 182 */       return 0;
/*     */     }
/* 184 */     return getShimenExp(roleid, startcount, endcount);
/*     */   }
/*     */   
/*     */ 
/*     */   static int getShimenExp(long roleid, int startcount, int endcount)
/*     */   {
/* 190 */     int exp = 0;
/* 191 */     for (int i = startcount; i <= endcount; i++)
/*     */     {
/* 193 */       exp += getShimenExpByRing(roleid, i);
/*     */     }
/*     */     
/* 196 */     return exp;
/*     */   }
/*     */   
/*     */   static boolean isShimenSwitchOpenForRole(long roleid)
/*     */   {
/* 201 */     return isShimenSwitchOpenForRole(roleid, true);
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean isShimenSwitchOpenForRole(long roleid, boolean isSendTip)
/*     */   {
/* 207 */     if (!OpenInterface.getOpenStatus(0))
/*     */     {
/* 209 */       return false;
/*     */     }
/* 211 */     if (OpenInterface.isBanPlay(roleid, 0))
/*     */     {
/* 213 */       if (isSendTip)
/*     */       {
/* 215 */         OpenInterface.sendBanPlayMsg(roleid, 0);
/*     */       }
/* 217 */       return false;
/*     */     }
/* 219 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRoleStateCanJoinShimenActivity(long roleid)
/*     */   {
/* 231 */     return RoleStatusInterface.checkCanSetStatus(roleid, 139, true);
/*     */   }
/*     */   
/*     */   static boolean switchShimeGraph(long roleid, int newOcp, int oldOcp)
/*     */   {
/* 236 */     int oldGraphid = getShimenGraphIdByMenpai(oldOcp);
/* 237 */     int newGraphid = getShimenGraphIdByMenpai(newOcp);
/* 238 */     boolean ret = TaskInterface.replaceGraphData(roleid, oldGraphid, newGraphid);
/* 239 */     if (!ret)
/*     */     {
/* 241 */       String logStr = String.format("[shimen]ShimenManager.switchShimeGraph@replace shimen graph failed|roleid=%d|oldocp=%d|oldgraphid=%d|newocp=%d|newgraphid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(oldOcp), Integer.valueOf(oldGraphid), Integer.valueOf(newOcp), Integer.valueOf(newGraphid) });
/*     */       
/*     */ 
/* 244 */       logger.error(logStr);
/* 245 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 249 */     return true;
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
/*     */   static int getDayRestShimenExp(long roleid, int finishCount)
/*     */   {
/* 264 */     if (finishCount < 0)
/*     */     {
/* 266 */       return 0;
/*     */     }
/* 268 */     if (finishCount >= ShimenActivityCfgConsts.getInstance().DAY_PERFECT_CIRCLE_COUNT)
/*     */     {
/* 270 */       return 0;
/*     */     }
/*     */     
/* 273 */     int total = getShimenExp(roleid, finishCount + 1, ShimenActivityCfgConsts.getInstance().DAY_PERFECT_CIRCLE_COUNT);
/* 274 */     return total;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getShimenExpByRing(long roleid, int ring)
/*     */   {
/* 286 */     if (ring <= 0)
/*     */     {
/* 288 */       return 0;
/*     */     }
/* 290 */     AwardReason awardReason = new AwardReason(LogReason.SHIMEN_DAY_STORAGE_AWARD, ShimenActivityCfgConsts.getInstance().REWARD_ID);
/*     */     
/* 292 */     awardReason.setJustQuery(true);
/* 293 */     int modify = getModifyId(ring);
/*     */     
/* 295 */     AwardModel award = AwardInterface.getRoleAwardModel(ShimenActivityCfgConsts.getInstance().REWARD_ID, roleid, modify, awardReason);
/*     */     
/* 297 */     if (award == null)
/*     */     {
/* 299 */       return 0;
/*     */     }
/* 301 */     return award.getRoleExp();
/*     */   }
/*     */   
/*     */ 
/*     */   static float getRate()
/*     */   {
/* 307 */     return ShimenActivityCfgConsts.getInstance().RETURN_BACK_EXP_CHANGE_RATE / 10000.0F;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addDayPerfectRingCout(long roleId)
/*     */   {
/* 315 */     DayPerfectRingCout dayPerfectRingCout = Role2dayperfectringcount.get(Long.valueOf(roleId));
/* 316 */     if (dayPerfectRingCout == null)
/*     */     {
/* 318 */       dayPerfectRingCout = Pod.newDayPerfectRingCout();
/* 319 */       dayPerfectRingCout.setHasgiveup(false);
/* 320 */       dayPerfectRingCout.setCurrentring(1);
/* 321 */       dayPerfectRingCout.setShimencount(1);
/* 322 */       Role2dayperfectringcount.add(Long.valueOf(roleId), dayPerfectRingCout);
/*     */     }
/*     */     else
/*     */     {
/* 326 */       dayPerfectRingCout.setCurrentring(dayPerfectRingCout.getCurrentring() + 1);
/* 327 */       dayPerfectRingCout.setShimencount(dayPerfectRingCout.getShimencount() + 1);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void awardShimenReward(String userid, long roleId, int currentRing)
/*     */   {
/* 337 */     int modifyId = getModifyId(currentRing);
/* 338 */     AwardReason awardReason = new AwardReason(LogReason.SHIMEN_ACTIVITY_ADD, ShimenActivityCfgConsts.getInstance().REWARD_ID);
/*     */     
/*     */ 
/* 341 */     AwardModel awardModel = AwardInterface.getRoleAwardModel(ShimenActivityCfgConsts.getInstance().REWARD_ID, roleId, modifyId, awardReason);
/*     */     
/*     */ 
/* 344 */     if (awardModel != null)
/*     */     {
/* 346 */       StorageExpInterface.award(userid, roleId, awardModel, awardReason);
/* 347 */       String logstr = String.format("[shimen]ShimenManager.awardShimenReward@Award shimen suc|roleid=%d|rewardid=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(ShimenActivityCfgConsts.getInstance().REWARD_ID) });
/*     */       
/* 349 */       logger.info(logstr);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 354 */       String logstr = String.format("[shimen]ShimenManager.awardShimenReward@Award shimen failed award null|roleid=%d|rewardid=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(ShimenActivityCfgConsts.getInstance().REWARD_ID) });
/*     */       
/*     */ 
/* 357 */       logger.error(logstr);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void awardPerfectReward(String userId, long roleId)
/*     */   {
/* 368 */     DayPerfectRingCout dayPerfectRingCout = Role2dayperfectringcount.get(Long.valueOf(roleId));
/* 369 */     if ((dayPerfectRingCout.getCurrentring() == ShimenActivityCfgConsts.getInstance().DAY_PERFECT_CIRCLE_COUNT) && (!dayPerfectRingCout.getHasgiveup()))
/*     */     {
/*     */ 
/* 372 */       AwardModel awardRes = AwardInterface.award(ShimenActivityCfgConsts.getInstance().DAY_PERFECT_CIRCLE_REWARD_ID, userId, roleId, false, false, new AwardReason(LogReason.SHIMEN_DAY_PERFECT_ADD, ShimenActivityCfgConsts.getInstance().DAY_PERFECT_CIRCLE_REWARD_ID));
/*     */       
/*     */ 
/*     */ 
/* 376 */       if (awardRes != null)
/*     */       {
/* 378 */         SShimenDayPerfectAward shimenDayPerfectAward = new SShimenDayPerfectAward();
/* 379 */         AwardInterface.fillAwardBean(shimenDayPerfectAward.awardbean, awardRes);
/* 380 */         OnlineManager.getInstance().send(roleId, shimenDayPerfectAward);
/* 381 */         String logstr = String.format("[shimen]ShimenManager.awardShimenReward@Award perfect shimen suc|roleid=%d|rewardid=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(ShimenActivityCfgConsts.getInstance().DAY_PERFECT_CIRCLE_REWARD_ID) });
/*     */         
/*     */ 
/* 384 */         logger.info(logstr);
/*     */       }
/*     */       else
/*     */       {
/* 388 */         String logstr = String.format("[shimen]ShimenManager.awardShimenReward@Award perfect shimen failed award null|roleid=%d|rewardid=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(ShimenActivityCfgConsts.getInstance().DAY_PERFECT_CIRCLE_REWARD_ID) });
/*     */         
/*     */ 
/* 391 */         logger.error(logstr);
/*     */       }
/* 393 */       doPerfectWeekAward(userId, roleId);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static void doPerfectWeekAward(String userId, long roleId)
/*     */   {
/* 400 */     WeekPerfectRingCout weekPerfectRingCout = Role2weekperfectringcount.get(Long.valueOf(roleId));
/* 401 */     if (weekPerfectRingCout == null)
/*     */     {
/* 403 */       weekPerfectRingCout = Pod.newWeekPerfectRingCout();
/* 404 */       weekPerfectRingCout.setWeekperfectringcount(1);
/* 405 */       Role2weekperfectringcount.add(Long.valueOf(roleId), weekPerfectRingCout);
/*     */     }
/*     */     else
/*     */     {
/* 409 */       weekPerfectRingCout.setWeekperfectringcount(weekPerfectRingCout.getWeekperfectringcount() + 1);
/*     */     }
/* 411 */     int weekPerfectCount = weekPerfectRingCout.getWeekperfectringcount();
/* 412 */     if (weekPerfectCount == ShimenActivityCfgConsts.getInstance().WEEK_PERFECT_CIRCLE_COUNT)
/*     */     {
/*     */ 
/* 415 */       AwardModel awardRes = AwardInterface.award(ShimenActivityCfgConsts.getInstance().WEEK_PERFECT_CIRCLE_REWARD_ID, userId, roleId, false, false, new AwardReason(LogReason.SHIMEN_WEEK_PERFECT_ADD, ShimenActivityCfgConsts.getInstance().WEEK_PERFECT_CIRCLE_REWARD_ID));
/*     */       
/*     */ 
/*     */ 
/* 419 */       if (awardRes != null)
/*     */       {
/* 421 */         SShimenWeekPerfectAward shimenWeekPerfectAward = new SShimenWeekPerfectAward();
/* 422 */         AwardInterface.fillAwardBean(shimenWeekPerfectAward.awardbean, awardRes);
/* 423 */         OnlineManager.getInstance().send(roleId, shimenWeekPerfectAward);
/*     */         
/* 425 */         String logstr = String.format("[shimen]ShimenManager.awardShimenReward@Award week perfect shimen suc|roleid=%d|rewardid=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(ShimenActivityCfgConsts.getInstance().WEEK_PERFECT_CIRCLE_REWARD_ID) });
/*     */         
/*     */ 
/* 428 */         logger.info(logstr);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 433 */         String logstr = String.format("[shimen]ShimenManager.awardShimenReward@Award week perfect shimen failed award null|roleid=%d|rewardid=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(ShimenActivityCfgConsts.getInstance().WEEK_PERFECT_CIRCLE_REWARD_ID) });
/*     */         
/*     */ 
/* 436 */         logger.error(logstr);
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
/*     */ 
/*     */   static boolean autoFinishShiMen(String userId, long roleId)
/*     */   {
/* 451 */     if (!isRoleStateCanJoinShimenActivity(roleId))
/*     */     {
/* 453 */       logger.info(String.format("[shimen]ShimenManager.autoFinishShiMen@role state can not join shimen activity|roleid=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/* 455 */       return false;
/*     */     }
/*     */     
/* 458 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, ShimenActivityCfgConsts.getInstance().ACTIVITYID);
/*     */     
/*     */ 
/*     */ 
/* 462 */     int oldCount = ActivityInterface.getActivityCount(userId, roleId, ShimenActivityCfgConsts.getInstance().ACTIVITYID, true);
/*     */     
/*     */ 
/* 465 */     if (!res.isCanJoin())
/*     */     {
/* 467 */       String logstr = String.format("[shimen]ShimenManager.autoFinishShiMen@can join shi men activity|roleid=%d|count=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(oldCount) });
/*     */       
/* 469 */       logger.error(logstr);
/* 470 */       return false;
/*     */     }
/*     */     
/* 473 */     SActivityCfg activityCfg = SActivityCfg.get(ShimenActivityCfgConsts.getInstance().ACTIVITYID);
/* 474 */     if (activityCfg == null)
/*     */     {
/* 476 */       return false;
/*     */     }
/* 478 */     int needMoreCount = activityCfg.recommendCount - oldCount;
/* 479 */     if (needMoreCount <= 0)
/*     */     {
/* 481 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 485 */     boolean ret = ActivityInterface.addActivityCount(userId, roleId, ShimenActivityCfgConsts.getInstance().ACTIVITYID, needMoreCount);
/*     */     
/* 487 */     if (!ret)
/*     */     {
/* 489 */       logger.error(String.format("[shimen]ShimenManager.autoFinishShiMen@Add Shimen Activity Count failed|roleid=%d|count=%d|countToAdd=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(oldCount), Integer.valueOf(needMoreCount) }));
/*     */       
/*     */ 
/* 492 */       return false;
/*     */     }
/*     */     
/* 495 */     int shiMenCount = oldCount;
/* 496 */     int graphId = getShimenGraphIdByMenpai(RoleInterface.getOccupationId(roleId));
/* 497 */     List<Long> roleList = Collections.singletonList(Long.valueOf(roleId));
/* 498 */     for (int i = 0; i < needMoreCount; i++)
/*     */     {
/* 500 */       ActivityInterface.logActivity(roleId, ShimenActivityCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.ATTEND);
/* 501 */       ActivityInterface.tlogActivity(roleId, ShimenActivityCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.ATTEND);
/*     */       
/* 503 */       ActivityInterface.logActivity(roleId, ShimenActivityCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.FINISH);
/* 504 */       ActivityInterface.tlogActivity(roleId, ShimenActivityCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.FINISH);
/*     */       
/* 506 */       shiMenCount++;
/* 507 */       if (shiMenCount == 1)
/*     */       {
/* 509 */         TaskInterface.setGraphFinishNum(roleId, graphId, 1);
/*     */       }
/*     */       
/* 512 */       if (shiMenCount <= ShimenActivityCfgConsts.getInstance().DAY_TOTAL_COUNT)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 518 */         addDayPerfectRingCout(roleId);
/*     */         
/* 520 */         awardShimenReward(userId, roleId, shiMenCount);
/*     */         
/* 522 */         awardPerfectReward(userId, roleId);
/*     */         
/*     */ 
/* 525 */         if (shiMenCount == ShimenActivityCfgConsts.getInstance().COUNT_FOR_BOUND_TIP)
/*     */         {
/*     */ 
/* 528 */           randomOneCanAcceptTask(roleId, graphId);
/* 529 */           AwardPoolInterface.awardLottery(roleList, ShimenActivityCfgConsts.getInstance().LOTTERY_VIEW_ID, false, ShimenActivityCfgConsts.getInstance().DELAY_OFFER_TIME, new TLogArg(LogReason.SHIMEN_LOTTERY_AWARD, ShimenActivityCfgConsts.getInstance().LOTTERY_VIEW_ID));
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 535 */         TriggerEventsManger.getInstance().triggerEvent(new ShimenActivityFinished(), new ShimenActivityArg(roleId, ShimenActivityCfgConsts.getInstance().ACTIVITYID, shiMenCount - 1, shiMenCount, Collections.emptySet()));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 540 */         logger.info(String.format("[shimen]ShimenManager.autoFinishShiMen@shi men auto|roleid=%d|count=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(shiMenCount) }));
/*     */       }
/*     */     }
/*     */     
/* 544 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void randomOneCanAcceptTask(long roleId, int graphId)
/*     */   {
/* 552 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 558 */         TaskInterface.closeActivityGraphWithoutEvent(this.val$roleId, this.val$graphId);
/* 559 */         return true;
/*     */       }
/* 561 */     });
/* 562 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 568 */         return TaskInterface.synRanOneCanAcceptTask(this.val$roleId, this.val$graphId);
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shimen\main\ShimenManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */