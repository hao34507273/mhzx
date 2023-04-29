/*     */ package mzm.gsp.activity.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activity.confbean.SLogicType2Activitys;
/*     */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogManager;
/*     */ import xbean.ActivityBean;
/*     */ import xbean.ActivityGlobalBean;
/*     */ import xbean.OpenBeanStore;
/*     */ 
/*     */ 
/*     */ public class ActivityInterface
/*     */ {
/*     */   private static final String TLOG_ACTIVITY = "Activity";
/*     */   
/*     */   public static ActivityForIDIPResult pauseActivityForIDIP(int activityid, boolean doOrRecovery)
/*     */   {
/*  31 */     SActivityCfg sActivityCfg = SActivityCfg.get(activityid);
/*  32 */     if (sActivityCfg == null) {
/*  33 */       return ActivityForIDIPResult.CFG_NOT_EXIST;
/*     */     }
/*  35 */     ActivityPauseLogicProcedure pauseLogicProcedure = new ActivityPauseLogicProcedure(activityid, doOrRecovery);
/*  36 */     pauseLogicProcedure.call();
/*  37 */     return pauseLogicProcedure.getResult();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ActivityForIDIPResult forceCloseActivityForIDIP(int activityid, boolean doOrRecovery)
/*     */   {
/*  49 */     SActivityCfg sActivityCfg = SActivityCfg.get(activityid);
/*  50 */     if (sActivityCfg == null) {
/*  51 */       return ActivityForIDIPResult.CFG_NOT_EXIST;
/*     */     }
/*  53 */     RIDIPActivityForceClose pauseLogicProcedure = new RIDIPActivityForceClose(activityid, doOrRecovery);
/*  54 */     pauseLogicProcedure.call();
/*  55 */     return pauseLogicProcedure.getResult();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ActivityForIDIPResult closeActivityForIDIP(int activityid)
/*     */   {
/*  65 */     SActivityCfg sActivityCfg = SActivityCfg.get(activityid);
/*  66 */     if (sActivityCfg == null) {
/*  67 */       return ActivityForIDIPResult.CFG_NOT_EXIST;
/*     */     }
/*  69 */     RIDIPActivityClose closeLogicProcedure = new RIDIPActivityClose(activityid);
/*  70 */     closeLogicProcedure.call();
/*  71 */     return closeLogicProcedure.getResult();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ActivityForIDIPResult forceOpenActivityForIDIP(int activityid)
/*     */   {
/*  82 */     long minute = ActivityManager.getActivityDurationMinute(activityid);
/*  83 */     return forceOpenActivityForIDIP(activityid, minute);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ActivityForIDIPResult forceOpenActivityForIDIP(int activityid, long minute)
/*     */   {
/*  95 */     SActivityCfg sActivityCfg = SActivityCfg.get(activityid);
/*  96 */     if (sActivityCfg == null) {
/*  97 */       return ActivityForIDIPResult.CFG_NOT_EXIST;
/*     */     }
/*  99 */     if (minute <= 0L) {
/* 100 */       return ActivityForIDIPResult.MINUTE_PARAMETER_ERROR;
/*     */     }
/* 102 */     if (minute > ActivityManager.getActivityDurationMinute(activityid)) {
/* 103 */       return ActivityForIDIPResult.MINUTE_PARAMETER_TOO_LONG;
/*     */     }
/* 105 */     ActivityForceOpenLogicProcedure forceOpenLogicProcedure = new ActivityForceOpenLogicProcedure(activityid, minute);
/*     */     
/* 107 */     forceOpenLogicProcedure.call();
/* 108 */     return forceOpenLogicProcedure.getResult();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ActivityForIDIPResult reJustActivityEndTimeForIDIP(int activityid)
/*     */   {
/* 120 */     SActivityCfg sActivityCfg = SActivityCfg.get(activityid);
/* 121 */     if (sActivityCfg == null) {
/* 122 */       return ActivityForIDIPResult.CFG_NOT_EXIST;
/*     */     }
/* 124 */     ActivityReJustEndTimeLogicProcedure reJustEndTimeLogicProcedure = new ActivityReJustEndTimeLogicProcedure(activityid);
/*     */     
/* 126 */     reJustEndTimeLogicProcedure.call();
/* 127 */     return reJustEndTimeLogicProcedure.getResult();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean addActivityCount(String userid, long roleId, int activityId)
/*     */   {
/* 138 */     return ActivityManager.addActivityCount(userid, roleId, activityId, 1);
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
/*     */   public static boolean addActivityCount(String userid, long roleId, int activityId, int addCount)
/*     */   {
/* 151 */     return ActivityManager.addActivityCount(userid, roleId, activityId, addCount);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isActivityOpen(int activityId)
/*     */   {
/* 162 */     return ActivityManager.isActivityOpen(activityId);
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
/*     */   public static boolean isInActivityLevel(String userid, long roleid, int activityId)
/*     */   {
/* 176 */     return ActivityManager.isInActivityLevel(userid, roleid, activityId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isInActivityLevelByLevel(int activityid, int level)
/*     */   {
/* 187 */     return ActivityManager.isInActivityLevelByLevel(activityid, level);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getActivityLevelMin(int activityid)
/*     */   {
/* 197 */     SActivityCfg activityCfg = SActivityCfg.get(activityid);
/* 198 */     return activityCfg.levelMin;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getActivityLevelMax(int activityid)
/*     */   {
/* 208 */     SActivityCfg activityCfg = SActivityCfg.get(activityid);
/* 209 */     return activityCfg.levelMax;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isToMaxCount(String userid, long roleid, int activityId)
/*     */   {
/* 221 */     return ActivityManager.isToMaxCount(userid, roleid, activityId, false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isPersonCountOK(int count, int activityId)
/*     */   {
/* 232 */     return ActivityManager.isPersonCountOK(count, activityId);
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
/*     */   public static boolean isActivityDataValidate(String userid, long roleid, int activityId)
/*     */   {
/* 246 */     return ActivityManager.isActivityDataValidate(userid, roleid, activityId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean setActivityDataForGM(String userid, long roleId, int activityId, int count)
/*     */   {
/* 258 */     return ActivityManager.setActivityDataForGM(userid, roleId, activityId, count);
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
/*     */   public static ActivityJoinResult canJoinAndCheckInitActivityData(String userid, long roleid, int activityid)
/*     */   {
/* 275 */     Map<Long, String> roleidToUserid = new HashMap(1, 1.0F);
/* 276 */     roleidToUserid.put(Long.valueOf(roleid), userid);
/* 277 */     return canJoinAndCheckInitActivityData(roleidToUserid, Arrays.asList(new Long[] { Long.valueOf(roleid) }), activityid);
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
/*     */   public static ActivityJoinResult canJoinAndCheckTeamInstanceInitActivityData(Map<Long, String> roleidToUserid, List<Long> roleIds, int activityId, int instanceId)
/*     */   {
/* 294 */     ActivityJoinResult activityJoinResult = new ActivityJoinResult();
/*     */     
/* 296 */     SActivityCfg activityCfg = SActivityCfg.get(activityId);
/*     */     
/* 298 */     ActivityGlobalBean xActivityGlobalBean = xtable.Activity.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 299 */     OpenBeanStore xOpenBeanStore = (OpenBeanStore)xActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(activityId));
/* 300 */     if (xOpenBeanStore == null) {
/* 301 */       activityJoinResult.setReason(ActivityJoinResult.Reason.ActivityNotOpen);
/* 302 */       activityJoinResult.setCanJoin(false);
/* 303 */       long roleid = ((Long)roleIds.get(0)).longValue();
/* 304 */       activityJoinResult.setUserid((String)roleidToUserid.get(Long.valueOf(roleid)));
/* 305 */       activityJoinResult.setRoleId(roleid);
/* 306 */       return activityJoinResult;
/*     */     }
/* 308 */     int openState = xOpenBeanStore.getOpenstate();
/* 309 */     if (ActivityManager.isActivityPauseState(openState)) {
/* 310 */       activityJoinResult.setReason(ActivityJoinResult.Reason.ActivityInPause);
/* 311 */       activityJoinResult.setCanJoin(false);
/* 312 */       long roleid = ((Long)roleIds.get(0)).longValue();
/* 313 */       activityJoinResult.setUserid((String)roleidToUserid.get(Long.valueOf(roleid)));
/* 314 */       activityJoinResult.setRoleId(roleid);
/* 315 */       return activityJoinResult;
/*     */     }
/* 317 */     if (ActivityManager.isForceCloseState(openState)) {
/* 318 */       activityJoinResult.setReason(ActivityJoinResult.Reason.ActivityInForceClose);
/* 319 */       activityJoinResult.setCanJoin(false);
/* 320 */       long roleid = ((Long)roleIds.get(0)).longValue();
/* 321 */       activityJoinResult.setUserid((String)roleidToUserid.get(Long.valueOf(roleid)));
/* 322 */       activityJoinResult.setRoleId(roleid);
/* 323 */       return activityJoinResult;
/*     */     }
/*     */     
/* 326 */     if (!ActivityManager.isActivityOpen(activityId)) {
/* 327 */       activityJoinResult.setReason(ActivityJoinResult.Reason.ActivityNotOpen);
/* 328 */       activityJoinResult.setCanJoin(false);
/* 329 */       long roleid = ((Long)roleIds.get(0)).longValue();
/* 330 */       activityJoinResult.setUserid((String)roleidToUserid.get(Long.valueOf(roleid)));
/* 331 */       activityJoinResult.setRoleId(roleid);
/* 332 */       return activityJoinResult;
/*     */     }
/*     */     
/*     */ 
/* 336 */     if (!ActivityManager.isPersonCountOK(roleIds.size(), activityId)) {
/* 337 */       activityJoinResult.setReason(ActivityJoinResult.Reason.PersonCount);
/* 338 */       activityJoinResult.setCanJoin(false);
/* 339 */       long roleid = ((Long)roleIds.get(0)).longValue();
/* 340 */       activityJoinResult.setUserid((String)roleidToUserid.get(Long.valueOf(roleid)));
/* 341 */       activityJoinResult.setRoleId(roleid);
/* 342 */       return activityJoinResult;
/*     */     }
/*     */     
/* 345 */     if ((activityCfg.personMax <= 1) && 
/* 346 */       (!activityCfg.couldBeSingleTeam) && 
/* 347 */       (TeamInterface.isRoleInTeam(((Long)roleIds.get(0)).longValue(), false))) {
/* 348 */       activityJoinResult.setReason(ActivityJoinResult.Reason.SingleRoleTeam);
/* 349 */       activityJoinResult.setCanJoin(false);
/* 350 */       return activityJoinResult;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 357 */     long roleId = ((Long)roleIds.get(0)).longValue();
/* 358 */     String userid = (String)roleidToUserid.get(Long.valueOf(roleId));
/* 359 */     if (!ActivityManager.isInActivityLevel(userid, roleId, activityId)) {
/* 360 */       activityJoinResult.setReason(ActivityJoinResult.Reason.RoleLevel);
/* 361 */       activityJoinResult.setCanJoin(false);
/* 362 */       activityJoinResult.setUserid(userid);
/* 363 */       activityJoinResult.setRoleId(roleId);
/* 364 */       return activityJoinResult;
/*     */     }
/*     */     
/*     */ 
/* 368 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 369 */       String userid = (String)roleidToUserid.get(Long.valueOf(roleId));
/* 370 */       xbean.Activity xActivity = ActivityManager.createXActivityIfNotExist(userid, roleId, activityId);
/* 371 */       boolean ret = ActivityManager.checkAndinitData(activityId, userid, roleId, xActivity, xActivityGlobalBean);
/* 372 */       if (!ret) {
/* 373 */         activityJoinResult.setCanJoin(false);
/* 374 */         activityJoinResult.setReason(ActivityJoinResult.Reason.DataError);
/* 375 */         return activityJoinResult;
/*     */       }
/*     */     }
/* 378 */     SInstanceCfg instanceCfg = SInstanceCfg.get(instanceId);
/* 379 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 381 */       int roleLevel = RoleInterface.getLevel(roleId);
/* 382 */       if ((instanceCfg.closeLevel <= 0) || (roleLevel <= instanceCfg.closeLevel)) {
/* 383 */         String userid = (String)roleidToUserid.get(Long.valueOf(roleId));
/* 384 */         if (ActivityManager.isToMaxCount(userid, roleId, activityId, false)) {
/* 385 */           activityJoinResult.setReason(ActivityJoinResult.Reason.ActivityCountToMax);
/* 386 */           activityJoinResult.setCanJoin(false);
/* 387 */           activityJoinResult.setUserid(userid);
/* 388 */           activityJoinResult.setRoleId(roleId);
/* 389 */           return activityJoinResult;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 394 */     activityJoinResult.setCanJoin(true);
/* 395 */     return activityJoinResult;
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
/*     */   public static ActivityJoinResult canJoinAndCheckInitActivityData(Map<Long, String> roleidToUserid, List<Long> roleIds, int activityId)
/*     */   {
/* 413 */     ActivityJoinResult activityJoinResult = new ActivityJoinResult();
/*     */     
/* 415 */     SActivityCfg activityCfg = SActivityCfg.get(activityId);
/*     */     
/* 417 */     ActivityGlobalBean xActivityGlobalBean = xtable.Activity.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 418 */     OpenBeanStore xOpenBeanStore = (OpenBeanStore)xActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(activityId));
/* 419 */     if (xOpenBeanStore == null) {
/* 420 */       activityJoinResult.setReason(ActivityJoinResult.Reason.ActivityNotOpen);
/* 421 */       activityJoinResult.setCanJoin(false);
/* 422 */       long roleid = ((Long)roleIds.get(0)).longValue();
/* 423 */       activityJoinResult.setUserid((String)roleidToUserid.get(Long.valueOf(roleid)));
/* 424 */       activityJoinResult.setRoleId(roleid);
/* 425 */       return activityJoinResult;
/*     */     }
/* 427 */     int openState = xOpenBeanStore.getOpenstate();
/* 428 */     if (ActivityManager.isActivityPauseState(openState)) {
/* 429 */       activityJoinResult.setReason(ActivityJoinResult.Reason.ActivityInPause);
/* 430 */       activityJoinResult.setCanJoin(false);
/* 431 */       long roleid = ((Long)roleIds.get(0)).longValue();
/* 432 */       activityJoinResult.setUserid((String)roleidToUserid.get(Long.valueOf(roleid)));
/* 433 */       activityJoinResult.setRoleId(roleid);
/* 434 */       return activityJoinResult;
/*     */     }
/* 436 */     if (ActivityManager.isForceCloseState(openState)) {
/* 437 */       activityJoinResult.setReason(ActivityJoinResult.Reason.ActivityInForceClose);
/* 438 */       activityJoinResult.setCanJoin(false);
/* 439 */       long roleid = ((Long)roleIds.get(0)).longValue();
/* 440 */       activityJoinResult.setUserid((String)roleidToUserid.get(Long.valueOf(roleid)));
/* 441 */       activityJoinResult.setRoleId(roleid);
/* 442 */       return activityJoinResult;
/*     */     }
/*     */     
/* 445 */     if (!ActivityManager.isActivityOpen(activityId)) {
/* 446 */       activityJoinResult.setReason(ActivityJoinResult.Reason.ActivityNotOpen);
/* 447 */       activityJoinResult.setCanJoin(false);
/* 448 */       long roleid = ((Long)roleIds.get(0)).longValue();
/* 449 */       activityJoinResult.setUserid((String)roleidToUserid.get(Long.valueOf(roleid)));
/* 450 */       activityJoinResult.setRoleId(roleid);
/* 451 */       return activityJoinResult;
/*     */     }
/*     */     
/*     */ 
/* 455 */     if (!ActivityManager.isPersonCountOK(roleIds.size(), activityId)) {
/* 456 */       activityJoinResult.setReason(ActivityJoinResult.Reason.PersonCount);
/* 457 */       activityJoinResult.setCanJoin(false);
/* 458 */       long roleid = ((Long)roleIds.get(0)).longValue();
/* 459 */       activityJoinResult.setUserid((String)roleidToUserid.get(Long.valueOf(roleid)));
/* 460 */       activityJoinResult.setRoleId(roleid);
/* 461 */       return activityJoinResult;
/*     */     }
/*     */     
/* 464 */     if ((activityCfg.personMax <= 1) && 
/* 465 */       (!activityCfg.couldBeSingleTeam) && 
/* 466 */       (TeamInterface.isRoleInTeam(((Long)roleIds.get(0)).longValue(), false))) {
/* 467 */       activityJoinResult.setReason(ActivityJoinResult.Reason.SingleRoleTeam);
/* 468 */       activityJoinResult.setCanJoin(false);
/* 469 */       return activityJoinResult;
/*     */     }
/*     */     
/*     */ 
/* 473 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 475 */       String userid = (String)roleidToUserid.get(Long.valueOf(roleId));
/* 476 */       if (!ActivityManager.isInActivityLevel(userid, roleId, activityId)) {
/* 477 */         activityJoinResult.setReason(ActivityJoinResult.Reason.RoleLevel);
/* 478 */         activityJoinResult.setCanJoin(false);
/* 479 */         activityJoinResult.setUserid(userid);
/* 480 */         activityJoinResult.setRoleId(roleId);
/* 481 */         return activityJoinResult;
/*     */       }
/*     */     }
/*     */     
/* 485 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 486 */       String userid = (String)roleidToUserid.get(Long.valueOf(roleId));
/* 487 */       xbean.Activity xActivity = ActivityManager.createXActivityIfNotExist(userid, roleId, activityId);
/* 488 */       boolean ret = ActivityManager.checkAndinitData(activityId, userid, roleId, xActivity, xActivityGlobalBean);
/* 489 */       if (!ret) {
/* 490 */         activityJoinResult.setCanJoin(false);
/* 491 */         activityJoinResult.setReason(ActivityJoinResult.Reason.DataError);
/* 492 */         return activityJoinResult;
/*     */       }
/*     */     }
/* 495 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 497 */       String userid = (String)roleidToUserid.get(Long.valueOf(roleId));
/* 498 */       if (ActivityManager.isToMaxCount(userid, roleId, activityId, false)) {
/* 499 */         activityJoinResult.setReason(ActivityJoinResult.Reason.ActivityCountToMax);
/* 500 */         activityJoinResult.setCanJoin(false);
/* 501 */         activityJoinResult.setUserid(userid);
/* 502 */         activityJoinResult.setRoleId(roleId);
/* 503 */         return activityJoinResult;
/*     */       }
/*     */     }
/*     */     
/* 507 */     activityJoinResult.setCanJoin(true);
/* 508 */     return activityJoinResult;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SActivityCfg getActivityCfg(int activityId)
/*     */   {
/* 519 */     return SActivityCfg.get(activityId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getPersonCountMin(int activityid)
/*     */   {
/* 529 */     return SActivityCfg.get(activityid).personMin;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getPersonCountMax(int activityid)
/*     */   {
/* 539 */     return SActivityCfg.get(activityid).personMax;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getActivityStartTime(int activityid)
/*     */   {
/* 551 */     return ActivityManager.getActivityStartTime(activityid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getActivityEndTime(int activityid)
/*     */   {
/* 563 */     return ActivityManager.getActivityEndTime(activityid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getActivityDurationMinute(int activityid)
/*     */   {
/* 573 */     return ActivityManager.getActivityDurationMinute(activityid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getActivityDurationMillis(int activityid)
/*     */   {
/* 583 */     return ActivityManager.getActivityDuationMill(activityid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getNextActivityStartTime(int activityid)
/*     */   {
/* 593 */     return ActivityManager.getNextStartTime(DateTimeUtils.getCurrTimeInMillis(), activityid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void registerActivityByLogicType(int activityLogicType)
/*     */   {
/* 603 */     ActivityManager.registerActivityByLogicType(activityLogicType, EmptyActivityHandler.instance, false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void registerActivityByLogicType(int activityLogicType, boolean userModeActivity)
/*     */   {
/* 615 */     ActivityManager.registerActivityByLogicType(activityLogicType, EmptyActivityHandler.instance, userModeActivity);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void registerActivityByLogicType(int activityLogicType, ActivityHandler activityHandler)
/*     */   {
/* 626 */     ActivityManager.registerActivityByLogicType(activityLogicType, activityHandler, false);
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
/*     */   public static void registerActivityByLogicType(int activityLogicType, ActivityHandler activityHandler, boolean userModeActivity)
/*     */   {
/* 640 */     ActivityManager.registerActivityByLogicType(activityLogicType, activityHandler, userModeActivity);
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
/*     */   public static int getActivityCount(String userid, long roleId, int activityId, boolean retainRoleLock)
/*     */   {
/* 656 */     return ActivityManager.getActivityCount(userid, roleId, activityId, retainRoleLock);
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
/*     */   public static int getStoreActivityCount(String userid, long roleId, int activityId, boolean retainRoleLock)
/*     */   {
/* 669 */     xbean.Activity xActivity = null;
/* 670 */     if (retainRoleLock) {
/* 671 */       xActivity = ActivityManager.getXActivity(userid, roleId, activityId);
/*     */     } else {
/* 673 */       xActivity = ActivityManager.selectXActivity(userid, roleId, activityId);
/*     */     }
/* 675 */     if (xActivity == null) {
/* 676 */       return 0;
/*     */     }
/* 678 */     ActivityBean xActivityBean = (ActivityBean)xActivity.getActivitymap().get(Integer.valueOf(activityId));
/* 679 */     if (xActivityBean == null) {
/* 680 */       return 0;
/*     */     }
/* 682 */     return xActivityBean.getCount();
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
/*     */   public static int getActivityStage(int activityid)
/*     */   {
/* 695 */     return ActivityManager.getActivityStage(activityid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getActivityStageEndTime(int activityid, int stage)
/*     */   {
/* 706 */     return ActivityManager.getActivityStageEndTime(activityid, stage);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getActivityStageLeftTime(int activityid, int stage)
/*     */   {
/* 717 */     return ActivityManager.getActivityStageLeftTime(activityid, stage);
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
/*     */   public static boolean canJoinActivityToday(String userid, long roleid, int activityid)
/*     */   {
/* 731 */     return ActivityManager.canJoinActivityToday(userid, roleid, activityid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> getActivityids(String userid, long roleid)
/*     */   {
/* 742 */     Set<Integer> activityids = new HashSet();
/* 743 */     for (SActivityCfg activityCfg : SActivityCfg.getAll().values()) {
/* 744 */       if ((ActivityManager.isInActivityLevel(userid, roleid, activityCfg.id)) && 
/*     */       
/*     */ 
/* 747 */         (isActivityOpen(activityCfg.id)))
/*     */       {
/*     */ 
/* 750 */         activityids.add(Integer.valueOf(activityCfg.id)); }
/*     */     }
/* 752 */     return activityids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> getAllActivityids()
/*     */   {
/* 761 */     Set<Integer> activityids = new HashSet();
/* 762 */     for (SActivityCfg activityCfg : SActivityCfg.getAll().values())
/*     */     {
/* 764 */       activityids.add(Integer.valueOf(activityCfg.id));
/*     */     }
/* 766 */     return activityids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getActivityLimitTimeBegin(int activityid)
/*     */   {
/* 776 */     return ActivityManager.getActivityLimitTimeBegin(activityid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getActivityLimitTimeEnd(int activityid)
/*     */   {
/* 786 */     return ActivityManager.getActivityLimitTimeEnd(activityid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ActivityLimitTimeStageEnum getActivityLimitTimeStage(int activityid, long curTime)
/*     */   {
/* 798 */     SActivityCfg activityCfg = SActivityCfg.get(activityid);
/* 799 */     if (activityCfg == null) {
/* 800 */       return ActivityLimitTimeStageEnum.CFG_ERROR;
/*     */     }
/* 802 */     if (activityCfg.activityLimitTimeid <= 0) {
/* 803 */       return ActivityLimitTimeStageEnum.NO_LIMIT;
/*     */     }
/* 805 */     long activityLimitBegin = getActivityLimitTimeBegin(activityid);
/* 806 */     if (curTime < activityLimitBegin) {
/* 807 */       return ActivityLimitTimeStageEnum.LIMIT_TIME_BEFORE;
/*     */     }
/* 809 */     long activityLimitEnd = getActivityLimitTimeEnd(activityid);
/* 810 */     if (curTime <= activityLimitEnd) {
/* 811 */       return ActivityLimitTimeStageEnum.LIMIT_TIME_NOW;
/*     */     }
/* 813 */     return ActivityLimitTimeStageEnum.LIMIT_TIME_AFTER;
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
/*     */   public static int getActivityTurnNumIncludeBeginTime(int actvityid, long timeBegin, long timeEnd)
/*     */   {
/* 830 */     return ActivityManager.getFullTurnBetweenTime(timeBegin, timeEnd, actvityid, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> getActivityIdsByLogicType(int activityLogicType)
/*     */   {
/* 841 */     SLogicType2Activitys logicType2Activitys = SLogicType2Activitys.get(activityLogicType);
/* 842 */     if (logicType2Activitys == null) {
/* 843 */       return Collections.EMPTY_SET;
/*     */     }
/* 845 */     return new HashSet(logicType2Activitys.activityids);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getLogicTypeByActivityId(int activityId)
/*     */   {
/* 857 */     return ActivityManager.getLogicTypeByActivityId(activityId);
/*     */   }
/*     */   
/*     */   public static void logActivity(long roleid, int activityid, ActivityLogStatus status)
/*     */   {
/* 862 */     int platform = RoleInterface.getPlatform(roleid);
/* 863 */     String channel = RoleInterface.getChannel(roleid);
/* 864 */     String mac = RoleInterface.getMac(roleid);
/*     */     
/* 866 */     String userid = RoleInterface.getUserId(roleid);
/* 867 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/* 869 */     Object[] args = new Object[8];
/* 870 */     args[0] = Integer.valueOf(platform);
/* 871 */     args[1] = channel;
/* 872 */     args[2] = mac;
/* 873 */     args[3] = userid;
/* 874 */     args[4] = Long.valueOf(roleid);
/* 875 */     args[5] = Integer.valueOf(rolelevel);
/* 876 */     args[6] = Integer.valueOf(activityid);
/* 877 */     args[7] = Integer.valueOf(status.value);
/*     */     
/* 879 */     String logStr = String.format("%d|%s|%s|%s|%d|%d|%d|%d", args);
/* 880 */     LogManager.getInstance().addLog("activity", logStr);
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
/*     */   public static void tlogActivity(long roleid, int activityid, ActivityLogStatus status)
/*     */   {
/* 894 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 895 */     String userid = RoleInterface.getUserId(roleid);
/* 896 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/* 898 */     tlogActivity(userid, roleid, rolelevel, vGameIP, activityid, status);
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
/*     */   public static void tlogActivity(String userid, long roleid, int rolelevel, String vGameIP, int activityid, ActivityLogStatus status)
/*     */   {
/* 913 */     String logStr = String.format("%s|%s|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(activityid), Integer.valueOf(status.value) });
/*     */     
/* 915 */     TLogManager.getInstance().addLog(userid, "Activity", logStr);
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
/*     */   public static void checkAndFreshCompensate(String userid, long roleid, int activityid)
/*     */   {
/* 928 */     xbean.Activity xActivity = ActivityManager.createXActivityIfNotExist(userid, roleid, activityid);
/* 929 */     ActivityBean xActivityBean = (ActivityBean)xActivity.getActivitymap().get(Integer.valueOf(activityid));
/* 930 */     long freshTime = -1L;
/* 931 */     int count = 0;
/* 932 */     if (xActivityBean != null) {
/* 933 */       freshTime = xActivityBean.getEndtime();
/* 934 */       count = xActivityBean.getCount();
/*     */     }
/* 936 */     ActivityManager.checkAndRefreshCompensate(roleid, activityid, freshTime, count);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isUserMode(int activityLogicType)
/*     */   {
/* 948 */     return ActivityManager.isUserMode(activityLogicType);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\ActivityInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */