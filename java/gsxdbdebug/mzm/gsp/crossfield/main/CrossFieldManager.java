/*     */ package mzm.gsp.crossfield.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import hub.ExchangeDataHandlerInfo;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.changemodelcard.main.ChangeModelCardInterface;
/*     */ import mzm.gsp.crossfield.ReportRoleCrossFieldRankInfoContext;
/*     */ import mzm.gsp.crossfield.SSynCrossFieldDailyAward;
/*     */ import mzm.gsp.crossfield.SSynCrossFieldResultInfo;
/*     */ import mzm.gsp.crossfield.confbean.SCrossFieldCfg;
/*     */ import mzm.gsp.crossfield.confbean.SCrossFieldConsts;
/*     */ import mzm.gsp.crossfield.confbean.SCrossFieldSeasonTimeCfg;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.crossserver.main.ReturnFromRoamServerHandlerManager;
/*     */ import mzm.gsp.crossserver.main.SingleCrossFieldContext;
/*     */ import mzm.gsp.crossserver.main.SingleCrossFieldRoamRoleInfo;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.online.main.LoginManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleSingleCrossFieldInfo;
/*     */ import xbean.RoleSingleCrossFieldResult;
/*     */ import xbean.RoleSingleCrossFieldSeasonInfo;
/*     */ import xtable.Role_single_cross_field_infos;
/*     */ import xtable.Role_single_cross_field_results;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CrossFieldManager
/*     */ {
/*  47 */   public static final Logger logger = Logger.getLogger("crossfield");
/*  48 */   static volatile boolean postInitFlag = false;
/*  49 */   static int DEADLINE_BEFORE_SEASON_END_IN_MINUTE = 10;
/*  50 */   static int GRC_MAX_TRY_TIMES = 3;
/*  51 */   static int GET_REMOTE_RANK_MIN_DELAY_IN_SECOND = 180;
/*  52 */   static int GET_REMOTE_RANK_MAX_DELAY_IN_SECOND = 300;
/*  53 */   static int RESULT_BUFFER_DURATION_IN_SECOND = 60;
/*     */   
/*     */   static void init()
/*     */   {
/*  57 */     ActivityInterface.registerActivityByLogicType(109, new SingleCrossFieldActivityHandler());
/*     */     
/*  59 */     ActivityInterface.registerActivityByLogicType(110);
/*     */   }
/*     */   
/*     */   static void postInit()
/*     */   {
/*  64 */     postInitFlag = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isCrossFieldSwitchOpen()
/*     */   {
/*  74 */     if (!OpenInterface.getOpenStatus(398))
/*     */     {
/*  76 */       return false;
/*     */     }
/*  78 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isCrossFieldSwitchOpen(int activityCfgid)
/*     */   {
/*  89 */     if (!OpenInterface.getOpenStatus(398))
/*     */     {
/*  91 */       return false;
/*     */     }
/*  93 */     SCrossFieldCfg cfg = SCrossFieldCfg.get(activityCfgid);
/*  94 */     if (cfg == null)
/*     */     {
/*  96 */       return false;
/*     */     }
/*  98 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
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
/*     */   static boolean isCrossFieldSwitchOpenForRole(long roleid)
/*     */   {
/* 113 */     if (!OpenInterface.getOpenStatus(398))
/*     */     {
/* 115 */       return false;
/*     */     }
/* 117 */     if (OpenInterface.isBanPlay(roleid, 398))
/*     */     {
/* 119 */       OpenInterface.sendBanPlayMsg(roleid, 398);
/* 120 */       return false;
/*     */     }
/* 122 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isCrossFieldSwitchOpenForRole(long roleid, int activityCfgid)
/*     */   {
/* 134 */     if (!OpenInterface.getOpenStatus(398))
/*     */     {
/* 136 */       return false;
/*     */     }
/* 138 */     SCrossFieldCfg cfg = SCrossFieldCfg.get(activityCfgid);
/* 139 */     if (cfg == null)
/*     */     {
/* 141 */       return false;
/*     */     }
/* 143 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*     */     {
/* 145 */       return false;
/*     */     }
/* 147 */     if (OpenInterface.isBanPlay(roleid, 398))
/*     */     {
/* 149 */       OpenInterface.sendBanPlayMsg(roleid, 398);
/* 150 */       return false;
/*     */     }
/* 152 */     if (OpenInterface.isBanPlay(roleid, cfg.moduleid))
/*     */     {
/* 154 */       OpenInterface.sendBanPlayMsg(roleid, cfg.moduleid);
/* 155 */       return false;
/*     */     }
/* 157 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static SingleCrossFieldRoamRoleInfo createCrossFieldRoamRoleInfo(long roleid, int season)
/*     */   {
/* 169 */     RoleSingleCrossFieldInfo xRoleSingleCrossFieldInfo = Role_single_cross_field_infos.get(Long.valueOf(roleid));
/* 170 */     if (xRoleSingleCrossFieldInfo == null)
/*     */     {
/* 172 */       xRoleSingleCrossFieldInfo = Pod.newRoleSingleCrossFieldInfo();
/* 173 */       xRoleSingleCrossFieldInfo.setWeekly_point_sum_timestamp(DateTimeUtils.getCurrTimeInMillis());
/* 174 */       xRoleSingleCrossFieldInfo.setDaily_award_times_timestamp(DateTimeUtils.getCurrTimeInMillis());
/* 175 */       Role_single_cross_field_infos.insert(Long.valueOf(roleid), xRoleSingleCrossFieldInfo);
/*     */     }
/* 177 */     RoleSingleCrossFieldSeasonInfo xRoleSingleCrossFieldSeasonInfo = (RoleSingleCrossFieldSeasonInfo)xRoleSingleCrossFieldInfo.getSeason_infos().get(Integer.valueOf(season));
/*     */     
/* 179 */     if (xRoleSingleCrossFieldSeasonInfo == null)
/*     */     {
/* 181 */       xRoleSingleCrossFieldSeasonInfo = Pod.newRoleSingleCrossFieldSeasonInfo();
/* 182 */       xRoleSingleCrossFieldSeasonInfo.setStar_num_timestamp(DateTimeUtils.getCurrTimeInMillis());
/* 183 */       xRoleSingleCrossFieldInfo.getSeason_infos().put(Integer.valueOf(season), xRoleSingleCrossFieldSeasonInfo);
/*     */     }
/* 185 */     return new SingleCrossFieldRoamRoleInfo(RoleInterface.getUserId(roleid), roleid, season, xRoleSingleCrossFieldSeasonInfo.getStar_num(), RoleInterface.getLevel(roleid), RoleInterface.getFightValue(roleid));
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
/*     */   static boolean setMatchStatus(long roleid, boolean sendStatusTip)
/*     */   {
/* 200 */     return (RoleStatusInterface.setStatus(roleid, 40, sendStatusTip)) && (RoleStatusInterface.setStatus(roleid, 1581, sendStatusTip));
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
/*     */   static boolean unsetMatchStatus(long roleid)
/*     */   {
/* 213 */     if (RoleStatusInterface.unsetStatus(roleid, 1581))
/*     */     {
/* 215 */       return RoleStatusInterface.unsetStatus(roleid, 40);
/*     */     }
/* 217 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isMatching(long roleid)
/*     */   {
/* 229 */     if ((!RoleStatusInterface.containsStatus(roleid, 40)) || (!RoleStatusInterface.containsStatus(roleid, 1581)))
/*     */     {
/*     */ 
/* 232 */       return false;
/*     */     }
/* 234 */     long contextid = RoleSingleCrossFieldContextManager.getInstance().getContextid(roleid);
/* 235 */     if (contextid <= 0L)
/*     */     {
/* 237 */       return false;
/*     */     }
/* 239 */     return CrossServerInterface.getSingleCrossFieldContext(contextid) != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isCancelingMatch(long roleid)
/*     */   {
/* 251 */     long contextid = RoleSingleCrossFieldContextManager.getInstance().getContextid(roleid);
/* 252 */     if (contextid > 0L)
/*     */     {
/* 254 */       SingleCrossFieldContext context = CrossServerInterface.getSingleCrossFieldContext(contextid);
/* 255 */       if (context == null)
/*     */       {
/* 257 */         logger.error(String.format("[crossfield]CrossFieldManager.isCancelingMatch@context do not exist|roleid=%d|contextid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(contextid) }));
/*     */         
/*     */ 
/* 260 */         return false;
/*     */       }
/* 262 */       return context.isCanceling();
/*     */     }
/* 264 */     return false;
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
/*     */   static boolean onDataBack(String userid, long roleid, boolean isActiveLeave, int season, int result, int changePoint, boolean isMVP, long startTimestamp, int pvpFightTimes, ExchangeDataHandlerInfo exchangeDataHandlerInfo)
/*     */   {
/* 283 */     LoginManager.getInstance().onRoleCrossEnd(userid, roleid);
/*     */     
/* 285 */     SSynCrossFieldDailyAward awardProtocol = null;
/* 286 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 287 */     SSynCrossFieldResultInfo protocol = new SSynCrossFieldResultInfo();
/* 288 */     protocol.season = season;
/* 289 */     protocol.is_active_leave = ((byte)(isActiveLeave ? 1 : 0));
/* 290 */     protocol.result = ((byte)result);
/* 291 */     protocol.is_mvp = ((byte)(isMVP ? 1 : 0));
/* 292 */     RoleSingleCrossFieldInfo xRoleSingleCrossFieldInfo = Role_single_cross_field_infos.get(Long.valueOf(roleid));
/* 293 */     if (xRoleSingleCrossFieldInfo == null)
/*     */     {
/*     */ 
/* 296 */       return false;
/*     */     }
/* 298 */     RoleSingleCrossFieldSeasonInfo xRoleSingleCrossFieldSeasonInfo = (RoleSingleCrossFieldSeasonInfo)xRoleSingleCrossFieldInfo.getSeason_infos().get(Integer.valueOf(season));
/*     */     
/* 300 */     if (xRoleSingleCrossFieldSeasonInfo == null)
/*     */     {
/*     */ 
/* 303 */       return false;
/*     */     }
/*     */     
/* 306 */     ChangeModelCardInterface.consumePVPFightCount(roleid, pvpFightTimes);
/* 307 */     if (isActiveLeave)
/*     */     {
/*     */ 
/* 310 */       xRoleSingleCrossFieldInfo.setActive_leave_field_timestamp(now);
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/* 315 */     else if (xRoleSingleCrossFieldInfo.getDaily_award_times_timestamp() <= startTimestamp)
/*     */     {
/* 317 */       if (DateTimeUtils.needDailyReset(xRoleSingleCrossFieldInfo.getDaily_award_times_timestamp(), startTimestamp, 0))
/*     */       {
/* 319 */         xRoleSingleCrossFieldInfo.setDaily_award_times(0);
/* 320 */         xRoleSingleCrossFieldInfo.setDaily_award_times_timestamp(startTimestamp);
/*     */       }
/* 322 */       if ((xRoleSingleCrossFieldInfo.getDaily_award_times() < SCrossFieldConsts.getInstance().DAILY_AWARD_TIMES) && (SCrossFieldConsts.getInstance().DAILY_AWARD_ID > 0))
/*     */       {
/*     */ 
/* 325 */         AwardReason awardReason = new AwardReason(LogReason.SINGLE_CROSS_FIELD_DAILY_AWARD);
/* 326 */         AwardModel awardModel = AwardInterface.award(SCrossFieldConsts.getInstance().DAILY_AWARD_ID, userid, roleid, false, false, awardReason);
/*     */         
/* 328 */         if (awardModel == null)
/*     */         {
/*     */ 
/* 331 */           return false;
/*     */         }
/* 333 */         awardProtocol = new SSynCrossFieldDailyAward();
/* 334 */         AwardInterface.fillAwardBean(awardProtocol.award_info, awardModel);
/* 335 */         xRoleSingleCrossFieldInfo.setDaily_award_times(xRoleSingleCrossFieldInfo.getDaily_award_times() + 1);
/* 336 */         xRoleSingleCrossFieldInfo.setDaily_award_times_timestamp(startTimestamp);
/*     */       }
/*     */     }
/*     */     
/* 340 */     protocol.original_point = MallInterface.getJifen(roleid, 6);
/* 341 */     protocol.original_star_num = xRoleSingleCrossFieldSeasonInfo.getStar_num();
/* 342 */     protocol.original_win_point = xRoleSingleCrossFieldSeasonInfo.getWin_point();
/* 343 */     protocol.original_straight_win_num = xRoleSingleCrossFieldSeasonInfo.getStraight_win_num();
/* 344 */     boolean isSeasonValid = isSeasonValid(season);
/* 345 */     if (isSeasonValid)
/*     */     {
/*     */ 
/* 348 */       if (changePoint != 0)
/*     */       {
/* 350 */         if (DateTimeUtils.needWeeklyReset(xRoleSingleCrossFieldInfo.getWeekly_point_sum_timestamp(), now, 1, 0))
/*     */         {
/* 352 */           xRoleSingleCrossFieldInfo.setWeekly_point_sum(0);
/* 353 */           xRoleSingleCrossFieldInfo.setWeekly_point_sum_timestamp(now);
/*     */         }
/* 355 */         if (xRoleSingleCrossFieldInfo.getWeekly_point_sum() < SCrossFieldConsts.getInstance().WEEKLY_POINT_UPPER_LIMIT)
/*     */         {
/* 357 */           int realAddPoint = Math.min(changePoint, SCrossFieldConsts.getInstance().WEEKLY_POINT_UPPER_LIMIT - xRoleSingleCrossFieldInfo.getWeekly_point_sum());
/*     */           
/* 359 */           xRoleSingleCrossFieldInfo.setWeekly_point_sum(xRoleSingleCrossFieldInfo.getWeekly_point_sum() + realAddPoint);
/*     */           
/* 361 */           xRoleSingleCrossFieldInfo.setWeekly_point_sum_timestamp(now);
/* 362 */           MallInterface.addJifen(roleid, realAddPoint, 6, true, new TLogArg(LogReason.GET_SINGLE_CROSS_FIELD_SCORE));
/*     */         }
/*     */       }
/*     */       
/* 366 */       refreshXRoleSingleCrossFieldSeasonInfo(xRoleSingleCrossFieldSeasonInfo, result, isMVP, now);
/* 367 */       SingleCrossFieldChartManager.getInstance().rank(roleid, season);
/* 368 */       reportRoleSingleCrossFieldRankInfo(season, roleid, RoleInterface.getName(roleid), RoleInterface.getOccupationId(roleid), xRoleSingleCrossFieldSeasonInfo.getStar_num(), xRoleSingleCrossFieldSeasonInfo.getStar_num_timestamp());
/*     */     }
/*     */     
/*     */ 
/* 372 */     protocol.current_point = MallInterface.getJifen(roleid, 6);
/* 373 */     protocol.current_star_num = xRoleSingleCrossFieldSeasonInfo.getStar_num();
/* 374 */     protocol.current_win_point = xRoleSingleCrossFieldSeasonInfo.getWin_point();
/* 375 */     protocol.current_straight_win_num = xRoleSingleCrossFieldSeasonInfo.getStraight_win_num();
/* 376 */     protocol.star_num_timestamp = ((int)(xRoleSingleCrossFieldSeasonInfo.getStar_num_timestamp() / 1000L));
/* 377 */     protocol.current_week_point = xRoleSingleCrossFieldInfo.getWeekly_point_sum();
/* 378 */     protocol.last_get_point_time = xRoleSingleCrossFieldInfo.getWeekly_point_sum_timestamp();
/*     */     
/* 380 */     if (OnlineManager.getInstance().isOnline(roleid))
/*     */     {
/* 382 */       OnlineManager.getInstance().send(roleid, protocol);
/* 383 */       logger.info(String.format("[crossfield]CrossFieldManager.onDataBack@send protocol to role|userid=%s|roleid=%d|protocol_name=%s|protocol_type=%d|protocol_content=%s", new Object[] { userid, Long.valueOf(roleid), protocol.getClass().getName(), Integer.valueOf(protocol.getType()), protocol.toString() }));
/*     */       
/*     */ 
/* 386 */       if (awardProtocol != null)
/*     */       {
/* 388 */         OnlineManager.getInstance().send(roleid, awardProtocol);
/* 389 */         logger.info(String.format("[crossfield]CrossFieldManager.onDataBack@send protocol to role|userid=%s|roleid=%d|protocol_name=%s|protocol_type=%d|protocol_content=%s", new Object[] { userid, Long.valueOf(roleid), awardProtocol.getClass().getName(), Integer.valueOf(awardProtocol.getType()), awardProtocol.toString() }));
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 396 */       RoleSingleCrossFieldResult xRoleSingleCrossFieldResult = Role_single_cross_field_results.get(Long.valueOf(roleid));
/* 397 */       if (xRoleSingleCrossFieldResult == null)
/*     */       {
/* 399 */         xRoleSingleCrossFieldResult = Pod.newRoleSingleCrossFieldResult();
/* 400 */         Role_single_cross_field_results.insert(Long.valueOf(roleid), xRoleSingleCrossFieldResult);
/*     */       }
/* 402 */       if (xRoleSingleCrossFieldResult.getSession_id() >= 0L)
/*     */       {
/* 404 */         Session.removeSession(xRoleSingleCrossFieldResult.getSession_id(), roleid);
/*     */       }
/* 406 */       xRoleSingleCrossFieldResult.getResult().add(protocol);
/* 407 */       if (awardProtocol != null)
/*     */       {
/* 409 */         xRoleSingleCrossFieldResult.getResult().add(awardProtocol);
/*     */       }
/* 411 */       xRoleSingleCrossFieldResult.setSession_id(new ResultBufferSession(RESULT_BUFFER_DURATION_IN_SECOND, roleid).getSessionId());
/*     */     }
/*     */     
/*     */ 
/* 415 */     if (exchangeDataHandlerInfo != null)
/*     */     {
/* 417 */       ReturnFromRoamServerHandlerManager.unboxData(userid, roleid, exchangeDataHandlerInfo);
/*     */     }
/* 419 */     logger.info(String.format("[crossfield]CrossFieldManager.onDataBack@single cross filed data back|userid=%s|roleid=%d|current_count=%d|is_avtive_leave=%b|is_season_valid=%b|season=%d|result=%d|change_point=%d|is_mvp=%b|start_timestamp=%d|pvp_fight_times=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(xRoleSingleCrossFieldInfo.getDaily_award_times()), Boolean.valueOf(isActiveLeave), Boolean.valueOf(isSeasonValid), Integer.valueOf(season), Integer.valueOf(result), Integer.valueOf(changePoint), Boolean.valueOf(isMVP), Long.valueOf(startTimestamp), Integer.valueOf(pvpFightTimes) }));
/*     */     
/*     */ 
/*     */ 
/* 423 */     CrossFieldTLogManager.addDataBackTLog(roleid, isActiveLeave, isSeasonValid, season, result, changePoint, isMVP);
/* 424 */     return true;
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
/*     */   private static void refreshXRoleSingleCrossFieldSeasonInfo(RoleSingleCrossFieldSeasonInfo xRoleSingleCrossFieldSeasonInfo, int result, boolean isMVP, long now)
/*     */   {
/* 439 */     int addWinPoint = 0;
/*     */     
/* 441 */     if (isMVP)
/*     */     {
/* 443 */       addWinPoint += SCrossFieldConsts.getInstance().MVP_GET_WIN_POINT_NUM;
/*     */     }
/*     */     
/* 446 */     if (result == 0)
/*     */     {
/* 448 */       xRoleSingleCrossFieldSeasonInfo.setStraight_win_num(xRoleSingleCrossFieldSeasonInfo.getStraight_win_num() + 1);
/*     */     }
/* 450 */     else if (result == 1)
/*     */     {
/* 452 */       xRoleSingleCrossFieldSeasonInfo.setStraight_win_num(0);
/*     */     }
/* 454 */     if ((result == 0) && (xRoleSingleCrossFieldSeasonInfo.getStraight_win_num() >= SCrossFieldConsts.getInstance().STRAIGHT_WIN_NUM))
/*     */     {
/*     */ 
/* 457 */       addWinPoint += SCrossFieldConsts.getInstance().STRAIGHT_WIN_GET_WIN_POINT_NUM;
/*     */     }
/*     */     
/* 460 */     int changeStarNum = 0;
/* 461 */     changeStarNum += (xRoleSingleCrossFieldSeasonInfo.getWin_point() + addWinPoint) / SCrossFieldConsts.getInstance().WIN_POINT_NUM_UPPER_LIMIT;
/*     */     
/* 463 */     xRoleSingleCrossFieldSeasonInfo.setWin_point((xRoleSingleCrossFieldSeasonInfo.getWin_point() + addWinPoint) % SCrossFieldConsts.getInstance().WIN_POINT_NUM_UPPER_LIMIT);
/*     */     
/* 465 */     if (result == 0)
/*     */     {
/* 467 */       changeStarNum++;
/*     */     }
/* 469 */     else if ((result == 1) && (xRoleSingleCrossFieldSeasonInfo.getStar_num() >= SCrossFieldConsts.getInstance().TRIGGER_BAODI_STAR_NUM))
/*     */     {
/*     */ 
/* 472 */       changeStarNum--;
/*     */     }
/* 474 */     if ((changeStarNum > 0) || ((changeStarNum < 0) && (xRoleSingleCrossFieldSeasonInfo.getStar_num() > 0)))
/*     */     {
/* 476 */       xRoleSingleCrossFieldSeasonInfo.setStar_num(xRoleSingleCrossFieldSeasonInfo.getStar_num() + changeStarNum);
/* 477 */       xRoleSingleCrossFieldSeasonInfo.setStar_num_timestamp(now);
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
/*     */   static long getRoleActiveLeaveFieldTimestamp(long roleid)
/*     */   {
/* 490 */     RoleSingleCrossFieldInfo xRoleSingleCrossFieldInfo = Role_single_cross_field_infos.get(Long.valueOf(roleid));
/* 491 */     if (xRoleSingleCrossFieldInfo == null)
/*     */     {
/* 493 */       return 0L;
/*     */     }
/* 495 */     return xRoleSingleCrossFieldInfo.getActive_leave_field_timestamp();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int cancelMatch(long roleid)
/*     */   {
/* 507 */     if (!isMatching(roleid))
/*     */     {
/*     */ 
/* 510 */       return 5;
/*     */     }
/* 512 */     if (isCancelingMatch(roleid))
/*     */     {
/*     */ 
/* 515 */       return 6;
/*     */     }
/* 517 */     long contextid = RoleSingleCrossFieldContextManager.getInstance().getContextid(roleid);
/* 518 */     if (contextid <= 0L)
/*     */     {
/*     */ 
/* 521 */       return 5;
/*     */     }
/* 523 */     SingleCrossFieldContext context = CrossServerInterface.getSingleCrossFieldContext(contextid);
/* 524 */     if (context == null)
/*     */     {
/*     */ 
/* 527 */       return 5;
/*     */     }
/* 529 */     if (!CrossServerInterface.cancelSingleCrossFieldMatch(contextid))
/*     */     {
/*     */ 
/* 532 */       return 4;
/*     */     }
/* 534 */     CrossFieldTLogManager.addMatchTLog(roleid, 4, context.getActivityCfgid(), context.getContextid(), -1L);
/*     */     
/* 536 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getCurrentSeason(long timestamp)
/*     */   {
/* 547 */     TreeMap<Integer, SCrossFieldSeasonTimeCfg> treeMap = (TreeMap)SCrossFieldSeasonTimeCfg.getAll();
/* 548 */     Map.Entry<Integer, SCrossFieldSeasonTimeCfg> entry = treeMap.floorEntry(Integer.valueOf((int)(timestamp / 1000L)));
/* 549 */     if (entry == null)
/*     */     {
/* 551 */       return -1;
/*     */     }
/* 553 */     return ((SCrossFieldSeasonTimeCfg)entry.getValue()).sort_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getCurrentSeasonBeginTimestamp(long timestamp)
/*     */   {
/* 564 */     TreeMap<Integer, SCrossFieldSeasonTimeCfg> treeMap = (TreeMap)SCrossFieldSeasonTimeCfg.getAll();
/* 565 */     Map.Entry<Integer, SCrossFieldSeasonTimeCfg> entry = treeMap.floorEntry(Integer.valueOf((int)(timestamp / 1000L)));
/* 566 */     if (entry == null)
/*     */     {
/* 568 */       return -1L;
/*     */     }
/* 570 */     return ((SCrossFieldSeasonTimeCfg)entry.getValue()).begin_timestamp * 1000L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isSeasonValid(int season)
/*     */   {
/* 581 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 582 */     if (season <= 0)
/*     */     {
/* 584 */       return false;
/*     */     }
/* 586 */     int currentSeason = getCurrentSeason(now);
/* 587 */     if (currentSeason != season)
/*     */     {
/* 589 */       return false;
/*     */     }
/* 591 */     TreeMap<Integer, SCrossFieldSeasonTimeCfg> treeMap = (TreeMap)SCrossFieldSeasonTimeCfg.getAll();
/* 592 */     Map.Entry<Integer, SCrossFieldSeasonTimeCfg> entry = treeMap.higherEntry(Integer.valueOf((int)(now / 1000L)));
/* 593 */     if ((entry != null) && (((SCrossFieldSeasonTimeCfg)entry.getValue()).begin_timestamp * 1000L - now < DEADLINE_BEFORE_SEASON_END_IN_MINUTE * 60000L))
/*     */     {
/*     */ 
/*     */ 
/* 597 */       return false;
/*     */     }
/* 599 */     return true;
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
/*     */   static RoleSingleCrossFieldSeasonInfo getXRoleSingleCrossFieldSeasonInfo(long roleid, int season, boolean retainRoleLock)
/*     */   {
/* 614 */     RoleSingleCrossFieldInfo xRoleSingleCrossFieldInfo = null;
/* 615 */     if (retainRoleLock)
/*     */     {
/* 617 */       xRoleSingleCrossFieldInfo = Role_single_cross_field_infos.get(Long.valueOf(roleid));
/*     */     }
/*     */     else
/*     */     {
/* 621 */       xRoleSingleCrossFieldInfo = Role_single_cross_field_infos.select(Long.valueOf(roleid));
/*     */     }
/*     */     
/* 624 */     if (xRoleSingleCrossFieldInfo == null)
/*     */     {
/* 626 */       return null;
/*     */     }
/* 628 */     return (RoleSingleCrossFieldSeasonInfo)xRoleSingleCrossFieldInfo.getSeason_infos().get(Integer.valueOf(season));
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
/*     */   static void reportRoleSingleCrossFieldRankInfo(int season, long roleid, String name, int occupation, int starNum, long timestamp)
/*     */   {
/* 644 */     ReportRoleCrossFieldRankInfoContext context = new ReportRoleCrossFieldRankInfoContext();
/* 645 */     context.count = 1;
/* 646 */     OctetsStream os = new OctetsStream();
/* 647 */     context.marshal(os);
/* 648 */     boolean ret = CrossServerInterface.reportRoleSingleCrossFieldRankInfo(season, roleid, name, occupation, starNum, timestamp, os);
/*     */     
/* 650 */     if (!ret)
/*     */     {
/* 652 */       logger.info(String.format("[crossfield]CrossFieldManager.reportRoleSingleCrossFieldRankInfo@send report role single cross field rank info fail|count=%d|roleid=%d|star_num=%d|timestamp=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(roleid), Integer.valueOf(starNum), Long.valueOf(timestamp) }));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\CrossFieldManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */