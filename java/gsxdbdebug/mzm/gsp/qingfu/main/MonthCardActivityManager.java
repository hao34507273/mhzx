/*     */ package mzm.gsp.qingfu.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.common.confbean.STimeCommonCfg;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.SSyncMonthCardActivityInfo;
/*     */ import mzm.gsp.qingfu.confbean.MonthCardActivityPhaseInfo;
/*     */ import mzm.gsp.qingfu.confbean.SMonthCardActivityCfg;
/*     */ import mzm.gsp.qingfu.confbean.SQingfuCfg;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.Pair;
/*     */ import xbean.QingfuInfo;
/*     */ import xbean.TssSumInfo;
/*     */ import xtable.Qingfu;
/*     */ 
/*     */ public class MonthCardActivityManager
/*     */ {
/*     */   static final void init()
/*     */   {
/*  34 */     MonthCardActivtiyHandler handler = new MonthCardActivtiyHandler();
/*  35 */     ActivityInterface.registerActivityByLogicType(32, handler, true);
/*     */   }
/*     */   
/*     */   static final void initData(String userid, long roleid, int activityCfgid)
/*     */   {
/*  40 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/*  41 */     if (xQingfuInfo == null)
/*     */     {
/*  43 */       return;
/*     */     }
/*     */     
/*  46 */     xbean.MonthCardActivityInfo xMonthCardActivityInfo = (xbean.MonthCardActivityInfo)xQingfuInfo.getMoth_card_activity_infos().get(Integer.valueOf(activityCfgid));
/*  47 */     if (xMonthCardActivityInfo == null)
/*     */     {
/*  49 */       xMonthCardActivityInfo = xbean.Pod.newMonthCardActivityInfo();
/*  50 */       xQingfuInfo.getMoth_card_activity_infos().put(Integer.valueOf(activityCfgid), xMonthCardActivityInfo);
/*     */     }
/*  52 */     xMonthCardActivityInfo.setStart_time(0L);
/*  53 */     xMonthCardActivityInfo.setBuy_time(0L);
/*  54 */     xMonthCardActivityInfo.setLast_award_time(0L);
/*  55 */     xMonthCardActivityInfo.setPhase(1);
/*  56 */     xMonthCardActivityInfo.setIs_present_award(false);
/*  57 */     xMonthCardActivityInfo.setIs_fix_same_serviceid_bug(true);
/*  58 */     xMonthCardActivityInfo.setTss_end_time(0L);
/*     */     
/*  60 */     TssSumInfo xTssSumInfo = getTssInfo(userid, activityCfgid, xQingfuInfo, xMonthCardActivityInfo);
/*  61 */     tryUpdateActivityInfo(userid, roleid, activityCfgid, xQingfuInfo, xMonthCardActivityInfo, xTssSumInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static final void tryUpdateActivityInfo(String userid, long roleid, int activityCfgid, QingfuInfo xQingfuInfo, xbean.MonthCardActivityInfo xMonthCardActivityInfo, TssSumInfo xTssSumInfo)
/*     */   {
/*  68 */     if ((xTssSumInfo == null) || (xMonthCardActivityInfo.getBuy_time() > 0L))
/*     */     {
/*  70 */       return;
/*     */     }
/*     */     
/*  73 */     SMonthCardActivityCfg monthCardActivityCfg = SMonthCardActivityCfg.get(activityCfgid);
/*  74 */     MonthCardActivityPhaseInfo prevMonthCardActivityPhaseInfo = (MonthCardActivityPhaseInfo)monthCardActivityCfg.phases.get(Integer.valueOf(xMonthCardActivityInfo.getPhase() - 1));
/*  75 */     MonthCardActivityPhaseInfo monthCardActivityPhaseInfo = (MonthCardActivityPhaseInfo)monthCardActivityCfg.phases.get(Integer.valueOf(xMonthCardActivityInfo.getPhase()));
/*  76 */     boolean isSameServiceid = (prevMonthCardActivityPhaseInfo != null) && (prevMonthCardActivityPhaseInfo.serviceId == monthCardActivityPhaseInfo.serviceId);
/*  77 */     long currTime = DateTimeUtils.getCurrTimeInMillis();
/*  78 */     if ((xTssSumInfo.getBegin_time() < currTime) && (currTime < xTssSumInfo.getEnd_time()))
/*     */     {
/*  80 */       if (isSameServiceid)
/*     */       {
/*  82 */         if (xTssSumInfo.getEnd_time() == xMonthCardActivityInfo.getTss_end_time())
/*     */         {
/*  84 */           return;
/*     */         }
/*     */       }
/*     */       
/*  88 */       xMonthCardActivityInfo.setStart_time(currTime);
/*  89 */       xMonthCardActivityInfo.setBuy_time(currTime);
/*  90 */       xMonthCardActivityInfo.setTss_end_time(xTssSumInfo.getEnd_time());
/*     */       
/*  92 */       if (xMonthCardActivityInfo.getIs_present_award())
/*     */       {
/*     */ 
/*  95 */         addMothCardTlog(userid, roleid, activityCfgid, xMonthCardActivityInfo.getPhase(), 2);
/*     */         
/*     */ 
/*  98 */         TLogArg tLogArg = new TLogArg(LogReason.MONTH_CARD_ACTIVITY_FIX_BUG_AWARD, activityCfgid);
/*  99 */         MailInterface.synBuildAndSendMail(roleid, 340006300, null, null, tLogArg);
/*     */         
/* 101 */         return;
/*     */       }
/*     */       
/* 104 */       xMonthCardActivityInfo.setIs_present_award(true);
/*     */       
/* 106 */       AwardReason monthCardActivityAwardReason = new AwardReason(LogReason.MONTH_CARD_ACTIVITY_AWARD_ADD, activityCfgid, PresentType.PRESENT_BIND_MONTH_CARD_ACTIVITY);
/*     */       
/*     */ 
/* 109 */       monthCardActivityAwardReason.setAwardItemBind(true);
/*     */       
/* 111 */       AwardModel awardModel = AwardInterface.awardFixAward(monthCardActivityPhaseInfo.present_award_cfg_id, userid, roleid, false, true, monthCardActivityAwardReason);
/*     */       
/* 113 */       if (awardModel == null)
/*     */       {
/*     */ 
/* 116 */         return;
/*     */       }
/*     */       
/*     */ 
/* 120 */       addMothCardTlog(userid, roleid, activityCfgid, xMonthCardActivityInfo.getPhase(), 1);
/*     */     }
/*     */   }
/*     */   
/*     */   static final boolean onRoleLogin(String userid, long roleid)
/*     */   {
/* 126 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/* 127 */     if (xQingfuInfo == null)
/*     */     {
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     long currTime = DateTimeUtils.getCurrTimeInMillis();
/* 133 */     SSyncMonthCardActivityInfo core = new SSyncMonthCardActivityInfo();
/* 134 */     for (SMonthCardActivityCfg cfg : SMonthCardActivityCfg.getAll().values())
/*     */     {
/* 136 */       int activityCfgid = cfg.id;
/* 137 */       if (ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, activityCfgid).isCanJoin())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 142 */         xbean.MonthCardActivityInfo xMonthCardActivityInfo = (xbean.MonthCardActivityInfo)xQingfuInfo.getMoth_card_activity_infos().get(Integer.valueOf(activityCfgid));
/*     */         
/* 144 */         if (xMonthCardActivityInfo != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 149 */           fixSameServiceidBug(userid, roleid, cfg, xQingfuInfo, xMonthCardActivityInfo);
/*     */           
/* 151 */           TssSumInfo xTssSumInfo = getTssInfo(userid, activityCfgid, xQingfuInfo, xMonthCardActivityInfo);
/* 152 */           if (xMonthCardActivityInfo.getBuy_time() <= 0L)
/*     */           {
/* 154 */             tryUpdateActivityInfo(userid, roleid, activityCfgid, xQingfuInfo, xMonthCardActivityInfo, xTssSumInfo);
/*     */           }
/*     */           
/* 157 */           mzm.gsp.qingfu.MonthCardActivityInfo info = new mzm.gsp.qingfu.MonthCardActivityInfo();
/* 158 */           boxMonthCardActivityInfo(activityCfgid, xMonthCardActivityInfo, xTssSumInfo, currTime, info);
/* 159 */           core.activity_infos.put(Integer.valueOf(activityCfgid), info);
/*     */         }
/*     */       } }
/* 162 */     if (core.activity_infos.size() > 0)
/*     */     {
/* 164 */       OnlineManager.getInstance().send(roleid, core);
/*     */     }
/*     */     
/* 167 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static final void fixSameServiceidBug(String userid, long roleid, int activityCfgid, QingfuInfo xQingfuInfo, xbean.MonthCardActivityInfo xMonthCardActivityInfo)
/*     */   {
/* 173 */     SMonthCardActivityCfg cfg = SMonthCardActivityCfg.get(activityCfgid);
/* 174 */     if (cfg == null)
/*     */     {
/* 176 */       return;
/*     */     }
/*     */     
/* 179 */     fixSameServiceidBug(userid, roleid, cfg, xQingfuInfo, xMonthCardActivityInfo);
/*     */   }
/*     */   
/*     */ 
/*     */   static final void fixSameServiceidBug(String userid, long roleid, SMonthCardActivityCfg cfg, QingfuInfo xQingfuInfo, xbean.MonthCardActivityInfo xMonthCardActivityInfo)
/*     */   {
/* 185 */     if (xMonthCardActivityInfo.getIs_fix_same_serviceid_bug())
/*     */     {
/* 187 */       return;
/*     */     }
/*     */     
/* 190 */     xMonthCardActivityInfo.setIs_fix_same_serviceid_bug(true);
/*     */     
/* 192 */     if (xMonthCardActivityInfo.getBuy_time() <= 0L)
/*     */     {
/* 194 */       return;
/*     */     }
/*     */     
/* 197 */     MonthCardActivityPhaseInfo monthCardActivityPhaseInfo = (MonthCardActivityPhaseInfo)cfg.phases.get(Integer.valueOf(xMonthCardActivityInfo.getPhase()));
/* 198 */     TssSumInfo xTssSumInfo = QingfuManager.getTssInfo(userid, xQingfuInfo, monthCardActivityPhaseInfo.serviceId);
/* 199 */     if (xTssSumInfo == null)
/*     */     {
/* 201 */       return;
/*     */     }
/*     */     
/* 204 */     MonthCardActivityPhaseInfo prevMonthCardActivityPhaseInfo = (MonthCardActivityPhaseInfo)cfg.phases.get(Integer.valueOf(xMonthCardActivityInfo.getPhase() - 1));
/* 205 */     boolean isSameServiceid = (prevMonthCardActivityPhaseInfo != null) && (prevMonthCardActivityPhaseInfo.serviceId == monthCardActivityPhaseInfo.serviceId);
/* 206 */     if (!isSameServiceid)
/*     */     {
/* 208 */       return;
/*     */     }
/*     */     
/* 211 */     long delta = xTssSumInfo.getEnd_time() - xMonthCardActivityInfo.getBuy_time();
/* 212 */     if ((delta > 0L) && (delta < 172800000L))
/*     */     {
/* 214 */       xMonthCardActivityInfo.setBuy_time(0L);
/* 215 */       xMonthCardActivityInfo.setStart_time(0L);
/* 216 */       xMonthCardActivityInfo.setLast_award_time(0L);
/* 217 */       xMonthCardActivityInfo.setIs_present_award(true);
/* 218 */       xMonthCardActivityInfo.setTss_end_time(xTssSumInfo.getEnd_time());
/*     */       
/*     */ 
/* 221 */       addMothCardTlog(userid, roleid, cfg.id, xMonthCardActivityInfo.getPhase(), 3);
/*     */     }
/*     */   }
/*     */   
/*     */   static final boolean onPurchaseService(String userid)
/*     */   {
/* 227 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/* 228 */     if (xQingfuInfo == null)
/*     */     {
/* 230 */       return false;
/*     */     }
/*     */     
/* 233 */     Long roleid = QingfuManager.getSuitableRoleId(userid);
/* 234 */     if (roleid == null)
/*     */     {
/* 236 */       return false;
/*     */     }
/*     */     
/* 239 */     long currTime = DateTimeUtils.getCurrTimeInMillis();
/* 240 */     SSyncMonthCardActivityInfo core = new SSyncMonthCardActivityInfo();
/* 241 */     for (Map.Entry<Integer, xbean.MonthCardActivityInfo> entry : xQingfuInfo.getMoth_card_activity_infos().entrySet())
/*     */     {
/* 243 */       int activityCfgid = ((Integer)entry.getKey()).intValue();
/* 244 */       if (ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid.longValue(), activityCfgid).isCanJoin())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 249 */         xbean.MonthCardActivityInfo xMonthCardActivityInfo = (xbean.MonthCardActivityInfo)xQingfuInfo.getMoth_card_activity_infos().get(Integer.valueOf(activityCfgid));
/*     */         
/* 251 */         if (xMonthCardActivityInfo != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 256 */           fixSameServiceidBug(userid, roleid.longValue(), activityCfgid, xQingfuInfo, xMonthCardActivityInfo);
/*     */           
/* 258 */           TssSumInfo xTssSumInfo = getTssInfo(userid, activityCfgid, xQingfuInfo, xMonthCardActivityInfo);
/* 259 */           if (xMonthCardActivityInfo.getBuy_time() <= 0L)
/*     */           {
/* 261 */             tryUpdateActivityInfo(userid, roleid.longValue(), activityCfgid, xQingfuInfo, xMonthCardActivityInfo, xTssSumInfo);
/*     */           }
/*     */           
/* 264 */           mzm.gsp.qingfu.MonthCardActivityInfo info = new mzm.gsp.qingfu.MonthCardActivityInfo();
/* 265 */           boxMonthCardActivityInfo(activityCfgid, xMonthCardActivityInfo, xTssSumInfo, currTime, info);
/* 266 */           core.activity_infos.put(Integer.valueOf(activityCfgid), info);
/*     */         }
/*     */       } }
/* 269 */     if (core.activity_infos.size() > 0)
/*     */     {
/* 271 */       OnlineManager.getInstance().send(userid, core);
/*     */     }
/*     */     
/* 274 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static final void boxMonthCardActivityInfo(int activityCfgid, xbean.MonthCardActivityInfo xMonthCardActivityInfo, TssSumInfo xTssSumInfo, long currTime, mzm.gsp.qingfu.MonthCardActivityInfo info)
/*     */   {
/* 281 */     info.phase = xMonthCardActivityInfo.getPhase();
/* 282 */     if ((xTssSumInfo == null) || (xMonthCardActivityInfo.getBuy_time() <= 0L))
/*     */     {
/* 284 */       info.remain_days = 0;
/* 285 */       info.status = 1;
/*     */     }
/*     */     else
/*     */     {
/* 289 */       Pair<Integer, Integer> result = new Pair(Integer.valueOf(0), Integer.valueOf(1));
/* 290 */       getStatusInfo(activityCfgid, xMonthCardActivityInfo, xTssSumInfo, currTime, result);
/* 291 */       info.remain_days = ((Integer)result.first).intValue();
/* 292 */       info.status = ((Integer)result.second).byteValue();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static final void getStatusInfo(int activityCfgid, xbean.MonthCardActivityInfo xMonthCardActivityInfo, TssSumInfo xTssSumInfo, long currTime, Pair<Integer, Integer> result)
/*     */   {
/* 299 */     SMonthCardActivityCfg cfg = SMonthCardActivityCfg.get(activityCfgid);
/* 300 */     STimeCommonCfg timeCommonCfg = TimeCommonUtil.getCommonCfg(cfg.daily_reset_time_cfg_id);
/* 301 */     long currRefTime = DateTimeUtils.getDailyResetTime(currTime, timeCommonCfg.activeHour, timeCommonCfg.activeMinute);
/* 302 */     long endTime = DateTimeUtils.getDailyResetTime(xTssSumInfo.getEnd_time(), timeCommonCfg.activeHour, timeCommonCfg.activeMinute);
/*     */     
/* 304 */     long diffTime = endTime - currRefTime;
/* 305 */     if (diffTime < 1L)
/*     */     {
/* 307 */       result.first = Integer.valueOf(0);
/*     */     }
/*     */     else
/*     */     {
/* 311 */       result.first = Integer.valueOf((int)(diffTime / 86400000L));
/*     */     }
/* 313 */     result.second = Integer.valueOf(xMonthCardActivityInfo.getLast_award_time() < currRefTime ? 3 : 2);
/*     */   }
/*     */   
/*     */ 
/*     */   static final int getAward(String userid, long roleid, int activityCfgid)
/*     */   {
/* 319 */     SMonthCardActivityCfg monthCardActivityCfg = SMonthCardActivityCfg.get(activityCfgid);
/* 320 */     if (monthCardActivityCfg == null)
/*     */     {
/* 322 */       return 1;
/*     */     }
/*     */     
/*     */ 
/* 326 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, activityCfgid).isCanJoin())
/*     */     {
/* 328 */       return 2;
/*     */     }
/*     */     
/* 331 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/* 332 */     if (xQingfuInfo == null)
/*     */     {
/* 334 */       return 3;
/*     */     }
/*     */     
/* 337 */     xbean.MonthCardActivityInfo xMonthCardActivityInfo = (xbean.MonthCardActivityInfo)xQingfuInfo.getMoth_card_activity_infos().get(Integer.valueOf(activityCfgid));
/* 338 */     if (xMonthCardActivityInfo == null)
/*     */     {
/* 340 */       return 4;
/*     */     }
/*     */     
/* 343 */     fixSameServiceidBug(userid, roleid, activityCfgid, xQingfuInfo, xMonthCardActivityInfo);
/*     */     
/* 345 */     TssSumInfo xTssSumInfo = getTssInfo(userid, activityCfgid, xQingfuInfo, xMonthCardActivityInfo);
/* 346 */     if (xTssSumInfo == null)
/*     */     {
/* 348 */       return -1;
/*     */     }
/*     */     
/* 351 */     if (xMonthCardActivityInfo.getBuy_time() <= 0L)
/*     */     {
/* 353 */       tryUpdateActivityInfo(userid, roleid, activityCfgid, xQingfuInfo, xMonthCardActivityInfo, xTssSumInfo);
/*     */     }
/*     */     
/* 356 */     if (xMonthCardActivityInfo.getBuy_time() <= 0L)
/*     */     {
/* 358 */       return -1;
/*     */     }
/*     */     
/* 361 */     long currTime = DateTimeUtils.getCurrTimeInMillis();
/* 362 */     Pair<Integer, Integer> result = new Pair(Integer.valueOf(0), Integer.valueOf(1));
/* 363 */     getStatusInfo(activityCfgid, xMonthCardActivityInfo, xTssSumInfo, currTime, result);
/*     */     
/* 365 */     if (((Integer)result.first).intValue() < 1)
/*     */     {
/* 367 */       return -2;
/*     */     }
/*     */     
/*     */ 
/* 371 */     if (((Integer)result.second).intValue() == 2)
/*     */     {
/* 373 */       return -3;
/*     */     }
/*     */     
/* 376 */     AwardReason monthCardActivityAwardReason = new AwardReason(LogReason.MONTH_CARD_ACTIVITY_DAILY_AWARD_ADD, activityCfgid, PresentType.PRESENT_BIND_MONTH_CARD_ACTIVITY_DAILY_AWARD);
/*     */     
/*     */ 
/*     */ 
/* 380 */     MonthCardActivityPhaseInfo monthCardActivityPhaseInfo = (MonthCardActivityPhaseInfo)monthCardActivityCfg.phases.get(Integer.valueOf(xMonthCardActivityInfo.getPhase()));
/* 381 */     AwardModel awardModel = AwardInterface.awardFixAward(monthCardActivityPhaseInfo.daily_award_cfg_id, userid, roleid, true, true, monthCardActivityAwardReason);
/*     */     
/* 383 */     if (awardModel == null)
/*     */     {
/*     */ 
/* 386 */       return 5;
/*     */     }
/*     */     
/* 389 */     xMonthCardActivityInfo.setLast_award_time(currTime);
/*     */     
/* 391 */     GameServer.logger().info(String.format("[qingfu]MonthCardActivityManager.getAward@get month card activity award|roleid=%d|userid=%s|activity_cfgid=%d|award_cfg_id=%d|buy_time=%d|start_time=%d|remain_days=%d", new Object[] { Long.valueOf(roleid), userid, Integer.valueOf(activityCfgid), Integer.valueOf(monthCardActivityPhaseInfo.daily_award_cfg_id), Long.valueOf(xMonthCardActivityInfo.getBuy_time()), Long.valueOf(xMonthCardActivityInfo.getStart_time()), result.first }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 398 */     ChangePhaseResult changePhaseResult = tryChangePhase(userid, activityCfgid, xQingfuInfo, xMonthCardActivityInfo);
/* 399 */     if (changePhaseResult == ChangePhaseResult.ERROR)
/*     */     {
/* 401 */       return 6;
/*     */     }
/*     */     
/* 404 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   static final TssSumInfo getTssInfo(String userid, int activityCfgid, QingfuInfo xQingfuInfo, xbean.MonthCardActivityInfo xMonthCardActivityInfo)
/*     */   {
/* 410 */     if (tryChangePhase(userid, activityCfgid, xQingfuInfo, xMonthCardActivityInfo) == ChangePhaseResult.ERROR)
/*     */     {
/* 412 */       return null;
/*     */     }
/*     */     
/* 415 */     SMonthCardActivityCfg cfg = SMonthCardActivityCfg.get(activityCfgid);
/* 416 */     if (cfg == null)
/*     */     {
/* 418 */       return null;
/*     */     }
/*     */     
/* 421 */     int phase = xMonthCardActivityInfo.getPhase();
/* 422 */     MonthCardActivityPhaseInfo monthCardActivityPhaseInfo = (MonthCardActivityPhaseInfo)cfg.phases.get(Integer.valueOf(phase));
/*     */     
/* 424 */     if (monthCardActivityPhaseInfo == null)
/*     */     {
/* 426 */       return null;
/*     */     }
/*     */     
/* 429 */     return QingfuManager.getTssInfo(userid, xQingfuInfo, monthCardActivityPhaseInfo.serviceId);
/*     */   }
/*     */   
/*     */ 
/*     */   static final ChangePhaseResult tryChangePhase(String userid, int activityCfgid, QingfuInfo xQingfuInfo, xbean.MonthCardActivityInfo xMonthCardActivityInfo)
/*     */   {
/* 435 */     long buyTime = xMonthCardActivityInfo.getBuy_time();
/* 436 */     if (buyTime <= 0L)
/*     */     {
/*     */ 
/* 439 */       return ChangePhaseResult.UNCHANG;
/*     */     }
/*     */     
/* 442 */     SMonthCardActivityCfg cfg = SMonthCardActivityCfg.get(activityCfgid);
/* 443 */     if (cfg == null)
/*     */     {
/* 445 */       return ChangePhaseResult.ERROR;
/*     */     }
/*     */     
/* 448 */     int phase = xMonthCardActivityInfo.getPhase();
/* 449 */     MonthCardActivityPhaseInfo monthCardActivityPhaseInfo = (MonthCardActivityPhaseInfo)cfg.phases.get(Integer.valueOf(phase));
/* 450 */     if (monthCardActivityPhaseInfo == null)
/*     */     {
/* 452 */       return ChangePhaseResult.ERROR;
/*     */     }
/*     */     
/* 455 */     long currTime = DateTimeUtils.getCurrTimeInMillis();
/* 456 */     SQingfuCfg qingfuCfg = QingfuManager.getQingfuCfg(userid, monthCardActivityPhaseInfo.serviceId);
/* 457 */     TssSumInfo xTssSumInfo = (TssSumInfo)xQingfuInfo.getTss_sum_map().get(String.valueOf(qingfuCfg.productServiceId));
/* 458 */     if (xTssSumInfo != null)
/*     */     {
/* 460 */       Pair<Integer, Integer> result = new Pair(Integer.valueOf(0), Integer.valueOf(1));
/* 461 */       getStatusInfo(activityCfgid, xMonthCardActivityInfo, xTssSumInfo, currTime, result);
/*     */       
/* 463 */       if ((((Integer)result.first).intValue() > 1) || ((((Integer)result.first).intValue() == 1) && (((Integer)result.second).intValue() == 3)))
/*     */       {
/* 465 */         return ChangePhaseResult.UNCHANG;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 470 */       STimeCommonCfg timeCommonCfg = TimeCommonUtil.getCommonCfg(cfg.daily_reset_time_cfg_id);
/* 471 */       long buyRefTime = DateTimeUtils.getDailyResetTime(buyTime, timeCommonCfg.activeHour, timeCommonCfg.activeMinute);
/*     */       
/* 473 */       int lastDays = 0;
/* 474 */       switch (qingfuCfg.productServiceType)
/*     */       {
/*     */       case 1: 
/* 477 */         lastDays = 7;
/* 478 */         break;
/*     */       
/*     */       case 2: 
/* 481 */         lastDays = 14;
/* 482 */         break;
/*     */       
/*     */       case 3: 
/* 485 */         lastDays = 30;
/* 486 */         break;
/*     */       
/*     */       default: 
/* 489 */         return ChangePhaseResult.ERROR;
/*     */       }
/* 491 */       long deadline = buyRefTime + lastDays * 86400000L;
/* 492 */       if (deadline > currTime)
/*     */       {
/* 494 */         return ChangePhaseResult.UNCHANG;
/*     */       }
/*     */     }
/*     */     
/* 498 */     int nextPhase = phase + 1;
/* 499 */     if (cfg.phases.containsKey(Integer.valueOf(nextPhase)))
/*     */     {
/* 501 */       xMonthCardActivityInfo.setStart_time(0L);
/* 502 */       xMonthCardActivityInfo.setBuy_time(0L);
/* 503 */       xMonthCardActivityInfo.setLast_award_time(0L);
/* 504 */       xMonthCardActivityInfo.setPhase(nextPhase);
/* 505 */       xMonthCardActivityInfo.setIs_present_award(false);
/* 506 */       xMonthCardActivityInfo.setIs_fix_same_serviceid_bug(true);
/*     */       
/* 508 */       return ChangePhaseResult.CHANGE;
/*     */     }
/*     */     
/* 511 */     return ChangePhaseResult.UNCHANG;
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
/*     */   static final void addMothCardTlog(String userid, long roleid, int activityCfgid, int phase, int status)
/*     */   {
/* 531 */     int roleLevel = mzm.gsp.role.main.RoleInterface.getLevel(roleid);
/* 532 */     StringBuilder sbLog = new StringBuilder();
/* 533 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|').append(userid).append('|').append(roleid).append('|').append(roleLevel).append('|');
/*     */     
/* 535 */     sbLog.append(activityCfgid).append('|').append(phase).append('|').append(status);
/* 536 */     TLogManager.getInstance().addLog(roleid, "MonthCardForServer", sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\MonthCardActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */