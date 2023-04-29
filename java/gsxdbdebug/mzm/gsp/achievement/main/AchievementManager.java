/*     */ package mzm.gsp.achievement.main;
/*     */ 
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.achievement.AchievementGoalInfo;
/*     */ import mzm.gsp.achievement.SAchievementFinishBrd;
/*     */ import mzm.gsp.achievement.SSynAchievementGoalInfo;
/*     */ import mzm.gsp.achievement.SSynAchievementInfo;
/*     */ import mzm.gsp.achievement.confbean.AchievementActivityGoalCfg;
/*     */ import mzm.gsp.achievement.confbean.AchievementConsts;
/*     */ import mzm.gsp.achievement.confbean.DouDouSongLiConsts;
/*     */ import mzm.gsp.achievement.confbean.SAchievementActivityCfg;
/*     */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*     */ import mzm.gsp.achievement.confbean.SAchievementGoalParameterCfg;
/*     */ import mzm.gsp.achievement.confbean.SAchievementGoalTypeCfg;
/*     */ import mzm.gsp.achievement.confbean.SActivityAchieveDisplayCfg;
/*     */ import mzm.gsp.achievement.confbean.SCarnivalConsts;
/*     */ import mzm.gsp.achievement.event.AchievementActivityFinishMailAward;
/*     */ import mzm.gsp.achievement.event.AchievementGoalFinish;
/*     */ import mzm.gsp.achievement.event.AchievementGoalFinishArg;
/*     */ import mzm.gsp.achievement.event.AchievementMailAwardArg;
/*     */ import mzm.gsp.achievement.event.AchievementScoreChange;
/*     */ import mzm.gsp.achievement.event.AchievementScoreChangeArg;
/*     */ import mzm.gsp.achievement.main.goaltype.IGoalType;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity3.confbean.STSurpriseAchievementCfg;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AchievementInfo;
/*     */ import xbean.ActivityAchievementInfo;
/*     */ import xbean.Role2AchievementInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2achievement;
/*     */ import xtable.User;
/*     */ 
/*     */ public class AchievementManager
/*     */ {
/*  63 */   static Map<Integer, AchievementActivityHandler> achievementModuleMap = new HashMap();
/*     */   
/*     */ 
/*  66 */   private static Map<Integer, IGoalType> goalTypeEnum2GoalTypeImpl = new HashMap();
/*     */   
/*     */   static
/*     */   {
/*  70 */     achievementModuleMap.put(Integer.valueOf(SCarnivalConsts.getInstance().carnivalActivityId), new CarnivalActivityHandler());
/*  71 */     achievementModuleMap.put(Integer.valueOf(DouDouSongLiConsts.getInstance().activityId), new DouDouSongLiActivityHandler());
/*  72 */     achievementModuleMap.put(Integer.valueOf(AchievementConsts.getInstance().activityId), new AchievementHandler());
/*     */     
/*     */ 
/*  75 */     for (Iterator i$ = STSurpriseAchievementCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityId = ((Integer)i$.next()).intValue();
/*     */       
/*  77 */       achievementModuleMap.put(Integer.valueOf(activityId), new SurpriseActivityHandler());
/*     */     }
/*     */     
/*     */ 
/*  81 */     for (Iterator i$ = SActivityAchieveDisplayCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*     */       
/*  83 */       achievementModuleMap.put(Integer.valueOf(activityCfgid), new ActivityAchievementHandler());
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
/*     */ 
/*     */   static void initGoalType()
/*     */   {
/*     */     try
/*     */     {
/* 103 */       String packageName = IGoalType.class.getPackage().getName();
/* 104 */       List<Class<?>> allClasses = util.ClassHelper.getAllClass(packageName);
/* 105 */       for (Class<?> clazz : allClasses)
/*     */       {
/*     */ 
/* 108 */         int modifier = clazz.getModifiers();
/* 109 */         if ((IGoalType.class.isAssignableFrom(clazz)) && (!Modifier.isAbstract(modifier)) && (!Modifier.isInterface(modifier)))
/*     */         {
/*     */ 
/*     */ 
/* 113 */           IGoalType instance = (IGoalType)clazz.newInstance();
/*     */           
/* 115 */           if (null != goalTypeEnum2GoalTypeImpl.put(Integer.valueOf(instance.getType()), instance))
/*     */           {
/* 117 */             throw new RuntimeException(String.format("GoalType is duplicated used. GoalType=%d", new Object[] { Integer.valueOf(instance.getType()) }));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 123 */       throw new RuntimeException(e);
/*     */     }
/*     */     
/*     */ 
/* 127 */     Set<Integer> missingGoalTypes = new HashSet();
/* 128 */     for (SAchievementGoalCfg sAchievementGoalCfg : SAchievementGoalCfg.getAll().values())
/*     */     {
/* 130 */       if (null == goalTypeEnum2GoalTypeImpl.get(Integer.valueOf(sAchievementGoalCfg.goalType)))
/*     */       {
/* 132 */         missingGoalTypes.add(Integer.valueOf(sAchievementGoalCfg.goalType));
/*     */       }
/*     */     }
/* 135 */     if (!missingGoalTypes.isEmpty())
/*     */     {
/* 137 */       throw new RuntimeException(String.format("GoalType haven't been implemented. GoalTypes=%s", new Object[] { missingGoalTypes }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static IGoalType getGoalType(int goalType)
/*     */   {
/* 149 */     return (IGoalType)goalTypeEnum2GoalTypeImpl.get(Integer.valueOf(goalType));
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
/*     */   public static AchievementInfo checkAndInitAchievementData(int activityId, int goalCfgId, ActivityAchievementInfo xActivityAchievementInfo)
/*     */   {
/* 168 */     SAchievementActivityCfg sAchievementActivityCfg = SAchievementActivityCfg.get(activityId);
/* 169 */     if (sAchievementActivityCfg == null)
/*     */     {
/* 171 */       return null;
/*     */     }
/* 173 */     AchievementInfo xAchievementInfo = (AchievementInfo)xActivityAchievementInfo.getGoal_info().get(Integer.valueOf(goalCfgId));
/* 174 */     if (xAchievementInfo != null)
/*     */     {
/* 176 */       return xAchievementInfo;
/*     */     }
/*     */     
/* 179 */     if (sAchievementActivityCfg.isNeedInit != 0)
/*     */     {
/* 181 */       return null;
/*     */     }
/*     */     
/* 184 */     xAchievementInfo = xbean.Pod.newAchievementInfo();
/* 185 */     xAchievementInfo.setGoal_state(1);
/* 186 */     xActivityAchievementInfo.getGoal_info().put(Integer.valueOf(goalCfgId), xAchievementInfo);
/*     */     
/* 188 */     return xAchievementInfo;
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
/*     */   static void updateGoalTypeState(long roleId, int goalType, Object context, String logStr)
/*     */   {
/* 202 */     String userId = RoleInterface.getUserId(roleId);
/* 203 */     Lockeys.lock(Lockeys.get(User.getTable(), userId));
/* 204 */     Lockeys.lock(Lockeys.get(xtable.Role2properties.getTable(), Long.valueOf(roleId)));
/*     */     
/* 206 */     if (!checkMutexStatus(roleId, false, true))
/*     */     {
/* 208 */       return;
/*     */     }
/*     */     
/* 211 */     SAchievementGoalTypeCfg sAchievementGoalTypeCfg = SAchievementGoalTypeCfg.get(goalType);
/* 212 */     if (sAchievementGoalTypeCfg == null)
/*     */     {
/* 214 */       GameServer.logger().warn(String.format("[achievement]PAbstractRefreshAchievement.processImp@goal type cfg data not exist|role_id=%d|goal_type=%d|log_str=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(goalType), logStr }));
/*     */       
/*     */ 
/*     */ 
/* 218 */       return;
/*     */     }
/*     */     
/* 221 */     Role2AchievementInfo xRole2AchievementInfo = Role2achievement.get(Long.valueOf(roleId));
/* 222 */     if (xRole2AchievementInfo == null)
/*     */     {
/* 224 */       return;
/*     */     }
/* 226 */     Map<Integer, ActivityAchievementInfo> xActivityAchievementInfoMap = xRole2AchievementInfo.getActivity_achievement_info();
/*     */     
/* 228 */     Map<Integer, AchievementActivityGoalCfg> achievementActivityGoalCfgMap = sAchievementGoalTypeCfg.activity_goal_cfg_map;
/* 229 */     for (Map.Entry<Integer, AchievementActivityGoalCfg> entry : achievementActivityGoalCfgMap.entrySet())
/*     */     {
/* 231 */       activityId = ((Integer)entry.getKey()).intValue();
/*     */       
/* 233 */       if (isAchievementSwitchOpen(roleId, activityId, logStr))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 238 */         achievementActivityHandler = (AchievementActivityHandler)achievementModuleMap.get(Integer.valueOf(activityId));
/* 239 */         if ((achievementActivityHandler != null) && 
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 245 */           (achievementActivityHandler.isCanTakePartIn(roleId, activityId)))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 250 */           ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, activityId);
/*     */           
/* 252 */           if (activityJoinResult.isCanJoin())
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 257 */             xActivityAchievementInfo = (ActivityAchievementInfo)xActivityAchievementInfoMap.get(Integer.valueOf(activityId));
/* 258 */             if (xActivityAchievementInfo != null)
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/* 263 */               List<Integer> goalCfgIdList = ((AchievementActivityGoalCfg)entry.getValue()).goalCfgIdList;
/* 264 */               for (i$ = goalCfgIdList.iterator(); i$.hasNext();) { int goalCfgId = ((Integer)i$.next()).intValue();
/*     */                 
/* 266 */                 SAchievementGoalCfg sAchievementGoalCfg = SAchievementGoalCfg.get(goalCfgId);
/*     */                 
/* 268 */                 AchievementInfo xAchievementInfo = checkAndInitAchievementData(activityId, goalCfgId, xActivityAchievementInfo);
/*     */                 
/* 270 */                 if ((xAchievementInfo != null) && 
/*     */                 
/*     */ 
/*     */ 
/*     */ 
/* 275 */                   (achievementActivityHandler.isGoalCanTakePartIn(roleId, activityId, goalCfgId)))
/*     */                 {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 281 */                   IGoalType goalTypeImpl = getGoalType(goalType);
/*     */                   
/* 283 */                   if (xAchievementInfo.getGoal_parameters().size() == 0)
/*     */                   {
/* 285 */                     goalTypeImpl.initParams(xAchievementInfo);
/*     */                   }
/*     */                   
/* 288 */                   if ((xAchievementInfo.getGoal_state() == 1) && 
/*     */                   
/*     */ 
/*     */ 
/*     */ 
/* 293 */                     (goalTypeImpl.updateState(roleId, xAchievementInfo, sAchievementGoalCfg, context)))
/*     */                   {
/*     */ 
/*     */ 
/*     */ 
/* 298 */                     SAchievementGoalParameterCfg sAchievementGoalParameterCfg = SAchievementGoalParameterCfg.get(goalCfgId);
/* 299 */                     if (sAchievementGoalParameterCfg != null)
/*     */                     {
/*     */ 
/*     */ 
/*     */ 
/* 304 */                       List<Integer> goalParams = sAchievementGoalParameterCfg.parameterList;
/* 305 */                       sSyncGoalRefreshInfo(roleId, activityId, goalCfgId, xActivityAchievementInfo, xAchievementInfo, goalParams, logStr);
/*     */                     }
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     int activityId;
/*     */     AchievementActivityHandler achievementActivityHandler;
/*     */     ActivityAchievementInfo xActivityAchievementInfo;
/*     */     Iterator i$;
/*     */   }
/*     */   
/*     */   public static boolean checkIsGoalFinish(List<Integer> roleParams, List<Integer> goalParams) {
/* 322 */     if (roleParams.size() != goalParams.size())
/*     */     {
/* 324 */       return false;
/*     */     }
/* 326 */     Iterator<Integer> e1 = roleParams.iterator();
/*     */     
/* 328 */     Iterator<Integer> e2 = goalParams.iterator();
/* 329 */     while ((e1.hasNext()) && (e2.hasNext()))
/*     */     {
/* 331 */       Integer o1 = (Integer)e1.next();
/* 332 */       Integer o2 = (Integer)e2.next();
/* 333 */       if (o2.intValue() - o1.intValue() > 0)
/* 334 */         return false;
/*     */     }
/* 336 */     return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void sSyncGoalRefreshInfo(long roleId, int activityCfgId, int goalCfgId, ActivityAchievementInfo xActivityAchievementInfo, AchievementInfo xAchievementInfo, List<Integer> goalParams, String logStr)
/*     */   {
/* 362 */     SAchievementActivityCfg sAchievementActivityCfg = SAchievementActivityCfg.get(activityCfgId);
/*     */     
/* 364 */     SSynAchievementGoalInfo sSynAchievementGoalInfo = new SSynAchievementGoalInfo();
/* 365 */     sSynAchievementGoalInfo.activity_cfg_id = activityCfgId;
/* 366 */     sSynAchievementGoalInfo.goal_cfg_id = goalCfgId;
/* 367 */     sSynAchievementGoalInfo.now_score_value = xActivityAchievementInfo.getScore_value();
/*     */     
/* 369 */     AchievementGoalInfo goalInfo = sSynAchievementGoalInfo.goal_info;
/*     */     
/* 371 */     goalInfo.parameters.addAll(xAchievementInfo.getGoal_parameters());
/* 372 */     if (checkIsGoalFinish(xAchievementInfo.getGoal_parameters(), goalParams))
/*     */     {
/* 374 */       goalInfo.state = 2;
/* 375 */       finishAchievementGoal(roleId, goalCfgId, xActivityAchievementInfo, xAchievementInfo, true);
/*     */       
/*     */ 
/* 378 */       AchievementActivityHandler achievementActivityHandler = (AchievementActivityHandler)achievementModuleMap.get(Integer.valueOf(activityCfgId));
/* 379 */       if ((achievementActivityHandler != null) && (achievementActivityHandler.isTriggerGoalFinishEvent()))
/*     */       {
/* 381 */         AchievementGoalFinishArg achievementGoalFinishArg = new AchievementGoalFinishArg(roleId, activityCfgId, goalCfgId);
/*     */         
/*     */ 
/* 384 */         TriggerEventsManger.getInstance().triggerEvent(new AchievementGoalFinish(), achievementGoalFinishArg);
/*     */       }
/*     */     }
/* 387 */     else if (sAchievementActivityCfg.isNeedSyncProcess == 2)
/*     */     {
/* 389 */       goalInfo.state = 1;
/*     */     }
/*     */     else
/*     */     {
/* 393 */       return;
/*     */     }
/* 395 */     goalInfo.achieve_time = xAchievementInfo.getGoal_achieve_time();
/* 396 */     OnlineManager.getInstance().send(roleId, sSynAchievementGoalInfo);
/*     */     
/* 398 */     GameServer.logger().info(String.format("[achievement]%s|role_id=%d|activiti_cfg_id=%d|goal_cfg_id=%d|now_parameters=%s|now_state=%d", new Object[] { logStr, Long.valueOf(roleId), Integer.valueOf(activityCfgId), Integer.valueOf(goalCfgId), goalInfo.parameters.toString(), Integer.valueOf(goalInfo.state) }));
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
/*     */   static boolean isAchievementSwitchOpen(long roleId, int activityId, String logString)
/*     */   {
/* 415 */     AchievementActivityHandler achievementActivityHandler = (AchievementActivityHandler)achievementModuleMap.get(Integer.valueOf(activityId));
/* 416 */     if (achievementActivityHandler == null)
/*     */     {
/* 418 */       return true;
/*     */     }
/* 420 */     Integer moduleType = Integer.valueOf(achievementActivityHandler.getSwitchModule(activityId));
/* 421 */     if (!OpenInterface.getOpenStatus(moduleType.intValue()))
/*     */     {
/* 423 */       return false;
/*     */     }
/*     */     
/* 426 */     if (OpenInterface.isBanPlay(roleId, moduleType.intValue()))
/*     */     {
/* 428 */       OpenInterface.sendBanPlayMsg(roleId, moduleType.intValue());
/* 429 */       return false;
/*     */     }
/*     */     
/* 432 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void triggerActivityFinishMailAward(AchievementMailAwardArg eventArg)
/*     */   {
/* 442 */     TriggerEventsManger.getInstance().triggerEvent(new AchievementActivityFinishMailAward(), eventArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(eventArg.roleId)));
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
/*     */   static boolean isNeedSync(long roleId, int activityCfgId, ActivityAchievementInfo xActivityAchievementInfo)
/*     */   {
/* 458 */     AchievementActivityHandler achievementActivityHandler = (AchievementActivityHandler)achievementModuleMap.get(Integer.valueOf(activityCfgId));
/* 459 */     if (achievementActivityHandler == null)
/*     */     {
/* 461 */       return true;
/*     */     }
/* 463 */     return achievementActivityHandler.isNeedSync(roleId, activityCfgId, xActivityAchievementInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isCanTakePartIn(long roleId, int activityCfgId)
/*     */   {
/* 475 */     AchievementActivityHandler achievementActivityHandler = (AchievementActivityHandler)achievementModuleMap.get(Integer.valueOf(activityCfgId));
/* 476 */     if (achievementActivityHandler == null)
/*     */     {
/* 478 */       return true;
/*     */     }
/* 480 */     return achievementActivityHandler.isCanTakePartIn(roleId, activityCfgId);
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
/*     */   static void tlogGoalStateStatis(long roleId, int activityCfgId, int goalCfgId, int currentScore, GoalStateTlogEnum goalStateTlogEnum)
/*     */   {
/* 500 */     AchievementActivityHandler achievementActivityHandler = (AchievementActivityHandler)achievementModuleMap.get(Integer.valueOf(activityCfgId));
/* 501 */     if (achievementActivityHandler == null)
/*     */     {
/* 503 */       return;
/*     */     }
/* 505 */     String tlogName = achievementActivityHandler.getGoalStatisTlogName();
/* 506 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 507 */     String userId = RoleInterface.getUserId(roleId);
/*     */     
/* 509 */     StringBuilder sbLog = new StringBuilder();
/* 510 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 511 */     sbLog.append(userId).append('|');
/* 512 */     sbLog.append(roleId).append('|');
/* 513 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 515 */     sbLog.append(goalCfgId).append('|');
/* 516 */     sbLog.append(goalStateTlogEnum.getOperator()).append('|');
/* 517 */     sbLog.append(currentScore).append('|');
/* 518 */     sbLog.append(activityCfgId);
/*     */     
/* 520 */     TLogManager.getInstance().addLog(roleId, tlogName, sbLog.toString());
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
/*     */   static void tlogScoreAwarded(long roleId, int activityCfgId, int scoreIndex, int score)
/*     */   {
/* 537 */     AchievementActivityHandler achievementActivityHandler = (AchievementActivityHandler)achievementModuleMap.get(Integer.valueOf(activityCfgId));
/* 538 */     if (achievementActivityHandler == null)
/*     */     {
/* 540 */       return;
/*     */     }
/* 542 */     String tlogName = achievementActivityHandler.getScoreAwardedTlogName();
/* 543 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 544 */     String userId = RoleInterface.getUserId(roleId);
/*     */     
/* 546 */     StringBuilder sbLog = new StringBuilder();
/* 547 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 548 */     sbLog.append(userId).append('|');
/* 549 */     sbLog.append(roleId).append('|');
/* 550 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 552 */     sbLog.append(scoreIndex).append('|');
/* 553 */     sbLog.append(score).append('1');
/* 554 */     sbLog.append(activityCfgId);
/*     */     
/* 556 */     TLogManager.getInstance().addLog(roleId, tlogName, sbLog.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void collectLocksToCorrectAchievement(long roleId)
/*     */   {
/* 568 */     List<Long> roleIds = new LinkedList();
/* 569 */     roleIds.add(Long.valueOf(roleId));
/* 570 */     long partnerId = MarriageInterface.getMarriedRoleid(roleId);
/* 571 */     if (partnerId > 0L)
/*     */     {
/* 573 */       roleIds.add(Long.valueOf(partnerId));
/*     */     }
/* 575 */     collectLocks(roleIds);
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
/*     */   static void correctAchievementGoalStateOnLogin(long roleId, int activityCfgId, ActivityAchievementInfo xActivityAchievementInfo)
/*     */   {
/* 588 */     SAchievementActivityCfg sAchievementActivityCfg = SAchievementActivityCfg.get(activityCfgId);
/* 589 */     if (sAchievementActivityCfg == null)
/*     */     {
/* 591 */       return;
/*     */     }
/* 593 */     List<Integer> goalCfgIdList = sAchievementActivityCfg.goalCfgIdList;
/* 594 */     for (Integer goalCfgId : goalCfgIdList)
/*     */     {
/* 596 */       SAchievementGoalCfg sAchievementGoalCfg = SAchievementGoalCfg.get(goalCfgId.intValue());
/* 597 */       if (sAchievementActivityCfg != null)
/*     */       {
/*     */ 
/*     */ 
/* 601 */         IGoalType goalTypeImpl = getGoalType(sAchievementGoalCfg.goalType);
/*     */         boolean result;
/*     */         try
/*     */         {
/* 605 */           result = goalTypeImpl.correctState(roleId, sAchievementGoalCfg, xActivityAchievementInfo);
/*     */         }
/*     */         catch (RuntimeException e)
/*     */         {
/* 609 */           GameServer.logger().warn(String.format("[achievement]AchievementManager.correctAchievementGoalStateOnLogin@achievement correctState exception, e=%s,goalCfgId=%d,roleId=%d", new Object[] { e, Integer.valueOf(sAchievementGoalCfg.id), Long.valueOf(roleId) }));
/*     */         }
/*     */         
/*     */ 
/* 613 */         continue;
/*     */         
/* 615 */         if (result)
/*     */         {
/*     */ 
/* 618 */           SAchievementGoalParameterCfg sAchievementGoalParameterCfg = SAchievementGoalParameterCfg.get(goalCfgId.intValue());
/* 619 */           List<Integer> goalParameters = sAchievementGoalParameterCfg.parameterList;
/* 620 */           AchievementInfo xAchievementInfo = (AchievementInfo)xActivityAchievementInfo.getGoal_info().get(goalCfgId);
/* 621 */           if (checkIsGoalFinish(xAchievementInfo.getGoal_parameters(), goalParameters))
/*     */           {
/* 623 */             finishAchievementGoal(roleId, goalCfgId.intValue(), xActivityAchievementInfo, xAchievementInfo, false);
/*     */             
/* 625 */             SSynAchievementGoalInfo proto = new SSynAchievementGoalInfo();
/* 626 */             proto.activity_cfg_id = activityCfgId;
/* 627 */             proto.goal_cfg_id = goalCfgId.intValue();
/* 628 */             proto.now_score_value = xActivityAchievementInfo.getScore_value();
/* 629 */             AchievementGoalInfo goalInfo = proto.goal_info;
/* 630 */             goalInfo.state = 2;
/* 631 */             goalInfo.achieve_time = xAchievementInfo.getGoal_achieve_time();
/* 632 */             goalInfo.parameters.addAll(xAchievementInfo.getGoal_parameters());
/* 633 */             OnlineManager.getInstance().send(roleId, proto);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkMutexStatus(long roleId, boolean sendTip, boolean retainLock)
/*     */   {
/* 645 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, 78, sendTip, retainLock))
/*     */     {
/* 647 */       GameServer.logger().warn(String.format("[achievement]AchievementManager.checkMutexStatus@contains mutex state|role_id=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/* 649 */       return false;
/*     */     }
/* 651 */     return true;
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
/*     */   public static void finishAchievementGoal(long roleId, int goalCfgId, ActivityAchievementInfo xActivityAchievementInfo, AchievementInfo xAchievementInfo, boolean sendServerBulletin)
/*     */   {
/* 667 */     SAchievementGoalCfg sAchievementGoalCfg = SAchievementGoalCfg.get(goalCfgId);
/*     */     int goalState;
/*     */     int goalState;
/* 670 */     if (offerAutoAward(roleId, goalCfgId, xActivityAchievementInfo))
/*     */     {
/* 672 */       goalState = 3;
/*     */     }
/*     */     else
/*     */     {
/* 676 */       goalState = 2;
/*     */     }
/*     */     
/* 679 */     xAchievementInfo.setGoal_state(goalState);
/* 680 */     xAchievementInfo.setGoal_achieve_time(DateTimeUtils.getCurrTimeInMillis());
/*     */     
/* 682 */     tlogGoalStateStatis(roleId, sAchievementGoalCfg.activityCfgId, goalCfgId, xActivityAchievementInfo.getScore_value(), GoalStateTlogEnum.FINISH);
/*     */     
/*     */ 
/* 685 */     sendAchievementBulletin(roleId, sAchievementGoalCfg, sendServerBulletin);
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
/*     */   private static boolean offerAutoAward(long roleId, int goalCfgId, ActivityAchievementInfo xActivityAchievementInfo)
/*     */   {
/* 701 */     SAchievementGoalCfg sAchievementGoalCfg = SAchievementGoalCfg.get(goalCfgId);
/* 702 */     SAchievementActivityCfg sAchievementActivityCfg = SAchievementActivityCfg.get(sAchievementGoalCfg.activityCfgId);
/* 703 */     if (sAchievementActivityCfg.goalAwardType != 2)
/*     */     {
/* 705 */       return false;
/*     */     }
/*     */     
/* 708 */     offerAchievementScore(roleId, xActivityAchievementInfo, sAchievementGoalCfg.score, sAchievementGoalCfg.activityCfgId);
/*     */     
/* 710 */     int fixedAwardId = sAchievementGoalCfg.fixAwardId;
/* 711 */     if (fixedAwardId != 0)
/*     */     {
/* 713 */       String userId = RoleInterface.getUserId(roleId);
/* 714 */       AwardReason awardReason = new AwardReason(LogReason.ACHIEVEMENT_GET_GOAL_AWARD, sAchievementGoalCfg.activityCfgId);
/*     */       
/* 716 */       AwardModel awardModel = mzm.gsp.award.main.AwardInterface.awardFixAward(fixedAwardId, userId, roleId, false, true, awardReason);
/* 717 */       if (null != awardModel)
/*     */       {
/* 719 */         return true;
/*     */       }
/* 721 */       GameServer.logger().warn(String.format("[achievement]AchievementManager.finishAchievementGoal@award failed|role_id=%d|award_id=%d|activity_cfg_id=%d|goal_cfg_id=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(fixedAwardId), Integer.valueOf(sAchievementGoalCfg.activityCfgId), Integer.valueOf(goalCfgId) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 726 */     return false;
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
/*     */   static void offerAchievementScore(long roleId, ActivityAchievementInfo xActivityAchievementInfo, int score, int activityCfgId)
/*     */   {
/* 741 */     int nowScore = xActivityAchievementInfo.getScore_value() + score;
/* 742 */     xActivityAchievementInfo.setScore_value(nowScore);
/*     */     
/* 744 */     AchievementScoreChangeArg arg = new AchievementScoreChangeArg(roleId, activityCfgId, nowScore);
/* 745 */     TriggerEventsManger.getInstance().triggerEvent(new AchievementScoreChange(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void sendAchievementBulletin(long roleId, SAchievementGoalCfg sAchievementGoalCfg, boolean sendServerBulletin)
/*     */   {
/* 755 */     if (sAchievementGoalCfg.bulletinType == 0)
/*     */     {
/* 757 */       return;
/*     */     }
/* 759 */     SAchievementFinishBrd protocol = new SAchievementFinishBrd();
/* 760 */     protocol.role_name = RoleInterface.getName(roleId);
/* 761 */     protocol.goal_cfg_id = sAchievementGoalCfg.id;
/* 762 */     protocol.faction_id = GangInterface.getGangId(roleId);
/* 763 */     switch (sAchievementGoalCfg.bulletinType)
/*     */     {
/*     */ 
/*     */     case 3: 
/*     */     case 4: 
/* 768 */       if (sendServerBulletin)
/*     */       {
/* 770 */         OnlineManager.getInstance().sendAll(protocol); }
/* 771 */       break;
/*     */     
/*     */ 
/*     */     case 2: 
/* 775 */       long gangId = GangInterface.getGangId(roleId);
/* 776 */       if (gangId != 0L)
/*     */       {
/* 778 */         GangInterface.brocastInGang(protocol, GangInterface.getGangId(roleId)); }
/* 779 */       break;
/*     */     
/*     */ 
/*     */     case 1: 
/* 783 */       OnlineManager.getInstance().send(roleId, protocol);
/* 784 */       break;
/*     */     }
/*     */     
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
/*     */   static void synAchievementInfo(long roleId, int activityId, ActivityAchievementInfo xActivityAchievementInfo)
/*     */   {
/* 800 */     SSynAchievementInfo sSynAchievementInfo = new SSynAchievementInfo();
/* 801 */     sSynAchievementInfo.activity_cfg_id = activityId;
/* 802 */     sSynAchievementInfo.now_score_value = xActivityAchievementInfo.getScore_value();
/* 803 */     sSynAchievementInfo.aleardy_awarded_score.addAll(xActivityAchievementInfo.getAleardy_awarded_score());
/* 804 */     for (Map.Entry<Integer, AchievementInfo> achievementEntry : xActivityAchievementInfo.getGoal_info().entrySet())
/*     */     {
/* 806 */       AchievementInfo xAchievementState = (AchievementInfo)achievementEntry.getValue();
/*     */       
/* 808 */       int goalCfgId = ((Integer)achievementEntry.getKey()).intValue();
/* 809 */       if (null != SAchievementGoalCfg.get(goalCfgId))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 814 */         AchievementGoalInfo achievementGoalInfo = new AchievementGoalInfo();
/* 815 */         achievementGoalInfo.state = xAchievementState.getGoal_state();
/* 816 */         achievementGoalInfo.parameters.addAll(xAchievementState.getGoal_parameters());
/* 817 */         achievementGoalInfo.achieve_time = xAchievementState.getGoal_achieve_time();
/* 818 */         sSynAchievementInfo.goal_map_info.put(Integer.valueOf(goalCfgId), achievementGoalInfo);
/*     */       }
/*     */     }
/* 821 */     OnlineManager.getInstance().send(roleId, sSynAchievementInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void collectLocks(Collection<Long> roleIds)
/*     */   {
/* 832 */     List<String> userIds = new LinkedList();
/* 833 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 835 */       String userId = RoleInterface.getUserId(roleId);
/* 836 */       if (null != userId)
/*     */       {
/* 838 */         userIds.add(userId);
/*     */       }
/*     */     }
/* 841 */     Lockeys.lock(Lockeys.get(User.getTable(), userIds));
/* 842 */     Lockeys.lock(Lockeys.get(Basic.getTable(), roleIds));
/*     */   }
/*     */   
/*     */   static void init() {}
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\AchievementManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */