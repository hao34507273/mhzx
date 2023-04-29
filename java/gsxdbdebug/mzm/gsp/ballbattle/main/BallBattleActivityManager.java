/*     */ package mzm.gsp.ballbattle.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityHandler;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.ballbattle.SNotifyInsufficientPlayerNumber;
/*     */ import mzm.gsp.ballbattle.SSyncActivityStatus;
/*     */ import mzm.gsp.ballbattle.confbean.SBallBattleActivityCfg;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.npc.confbean.SNpc;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.event.JoinTeamArg;
/*     */ import mzm.gsp.team.event.LeaveTeamArg;
/*     */ import mzm.gsp.team.event.TeamCreateArg;
/*     */ import mzm.gsp.team.event.TeamDissolveArg;
/*     */ import mzm.gsp.team.event.TeamMember;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import mzm.gsp.util.TaskOneByOne;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class BallBattleActivityManager
/*     */ {
/*  46 */   private static final TaskOneByOne executor = new TaskOneByOne();
/*     */   
/*     */   static void addTask(LogicRunnable runnable) {
/*  49 */     executor.add(runnable);
/*     */   }
/*     */   
/*     */   static void addTask(LogicProcedure procedure) {
/*  53 */     executor.add(procedure);
/*     */   }
/*     */   
/*     */   private static void newSession(long seconds, LogicRunnable runnable) {
/*  57 */     new Session(seconds, 0L)
/*     */     {
/*     */ 
/*     */       protected void onTimeOut()
/*     */       {
/*  62 */         BallBattleActivityManager.addTask(this.val$runnable);
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */ 
/*  68 */   private static int activityId = 0;
/*     */   private static int round;
/*     */   
/*  71 */   static int getActivityId() { return activityId; }
/*     */   
/*     */ 
/*     */   private static ActivityStage stage;
/*     */   
/*     */   static enum ActivityStage
/*     */   {
/*  78 */     PREPARE_STAGE,  GAME_STAGE;
/*     */     
/*     */ 
/*     */     private ActivityStage() {}
/*     */   }
/*     */   
/*     */ 
/*     */   private static int currentStageEndTime;
/*     */   
/*     */   private static long worldId;
/*  88 */   private static final Map<Long, Set<Long>> team2attenders = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */   private static int attenderCount;
/*     */   
/*     */ 
/*     */ 
/*     */   static boolean isOpen()
/*     */   {
/*  98 */     return OpenInterface.getOpenStatus(578);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void initialize(int currentActivityId)
/*     */   {
/* 106 */     SBallBattleActivityCfg activityCfg = SBallBattleActivityCfg.get(currentActivityId);
/* 107 */     if (activityCfg == null)
/*     */     {
/* 109 */       BallBattleLogger.error(String.format("BallBattleActivityManager.initialize()@invalid activity id|activityid=%d", new Object[] { Integer.valueOf(activityId) }));
/*     */       
/* 111 */       return;
/*     */     }
/*     */     
/*     */ 
/* 115 */     activityId = currentActivityId;
/* 116 */     round = 1;
/* 117 */     stage = ActivityStage.PREPARE_STAGE;
/*     */     
/* 119 */     worldId = MapInterface.createWorld(Collections.singleton(Integer.valueOf(activityCfg.prepareMapId)));
/*     */     
/* 121 */     team2attenders.clear();
/* 122 */     attenderCount = 0;
/*     */     
/*     */ 
/* 125 */     SNpc activityNpcCfg = SNpc.get(activityCfg.activityNpcId);
/* 126 */     ControllerInterface.triggerController(activityNpcCfg.controllerId);
/* 127 */     SNpc prepareNpcCfg = SNpc.get(activityCfg.prepareNpcId);
/* 128 */     ControllerInterface.triggerWorldController(worldId, prepareNpcCfg.controllerId);
/*     */     
/*     */ 
/* 131 */     long stageLength = activityCfg.firstPrepareMinutes * 60L;
/* 132 */     currentStageEndTime = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L + stageLength);
/* 133 */     newSession(stageLength, new LogicRunnable()
/*     */     {
/*     */ 
/*     */       public void process()
/*     */         throws Exception
/*     */       {}
/*     */ 
/*     */ 
/* 141 */     });
/* 142 */     BallBattleLogger.info(String.format("BallBattleActivityManager.initialize()@done|activityid=%d|worldid=%d", new Object[] { Integer.valueOf(activityId), Long.valueOf(worldId) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void clean()
/*     */   {
/* 151 */     SBallBattleActivityCfg activityCfg = SBallBattleActivityCfg.get(activityId);
/*     */     
/* 153 */     SNpc activityNpcCfg = SNpc.get(activityCfg.activityNpcId);
/* 154 */     ControllerInterface.collectController(activityNpcCfg.controllerId);
/* 155 */     SNpc prepareNpcCfg = SNpc.get(activityCfg.prepareNpcId);
/* 156 */     ControllerInterface.collectWorldController(worldId, prepareNpcCfg.controllerId);
/*     */     
/* 158 */     activityId = 0;
/*     */     
/*     */ 
/* 161 */     for (Set<Long> roleIds : team2attenders.values())
/*     */     {
/* 163 */       for (Long roleId : roleIds)
/*     */       {
/* 165 */         new LogicProcedure()
/*     */         {
/*     */           protected boolean processImp()
/*     */             throws Exception
/*     */           {
/* 170 */             return RoleStatusInterface.unsetStatus(this.val$roleId.longValue(), 2161);
/*     */           }
/*     */         }.call();
/*     */       }
/*     */     }
/* 175 */     team2attenders.clear();
/* 176 */     MapInterface.dragAllRoleToTargetWorld(worldId, MapInterface.getCenterWorldid(), activityCfg.exitMapId);
/* 177 */     MapInterface.destroyWorld(worldId);
/*     */     
/* 179 */     BallBattleLogger.info(String.format("BallBattleActivityManager.clean()@done|activityid=%d", new Object[] { Integer.valueOf(activityCfg.activityId) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void onPrepareStageEnd()
/*     */   {
/* 187 */     SBallBattleActivityCfg activityCfg = SBallBattleActivityCfg.get(activityId);
/*     */     
/* 189 */     int defaultPlayerNumber = activityCfg.defaultPlayerNumber;
/* 190 */     int minPlayerNumber = activityCfg.minPlayerNumber;
/*     */     
/* 192 */     if (attenderCount < minPlayerNumber)
/*     */     {
/* 194 */       notifyInsufficientPlayerNumber();
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 199 */       List<Long> singlePlayerList = new ArrayList();
/* 200 */       Map<Integer, List<Set<Long>>> teamSize2teamList = new HashMap();
/* 201 */       for (int i = 2; i <= 5; i++)
/*     */       {
/* 203 */         teamSize2teamList.put(Integer.valueOf(i), new ArrayList());
/*     */       }
/* 205 */       for (Map.Entry<Long, Set<Long>> entry : team2attenders.entrySet())
/*     */       {
/* 207 */         long teamId = ((Long)entry.getKey()).longValue();
/* 208 */         Set<Long> roleIds = (Set)entry.getValue();
/*     */         
/* 210 */         if (teamId == 0L)
/*     */         {
/* 212 */           singlePlayerList.addAll(roleIds);
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 217 */           int teamSize = roleIds.size();
/* 218 */           if ((1 < teamSize) && (teamSize <= 5))
/*     */           {
/* 220 */             ((List)teamSize2teamList.get(Integer.valueOf(teamSize))).add(roleIds);
/*     */           }
/* 222 */           else if (teamSize == 1)
/*     */           {
/* 224 */             singlePlayerList.addAll(roleIds);
/*     */           }
/*     */         }
/*     */       }
/* 228 */       final List<Set<Long>> matchResult = new ArrayList();
/* 229 */       int remainToMatchCount = attenderCount;
/* 230 */       while (remainToMatchCount > 0)
/*     */       {
/*     */ 
/* 233 */         if (remainToMatchCount < minPlayerNumber)
/*     */         {
/* 235 */           int lastIndex = matchResult.size() - 1;
/* 236 */           Set<Long> lastMatchedPlayers = (Set)matchResult.get(lastIndex);
/* 237 */           lastMatchedPlayers.addAll(singlePlayerList);
/* 238 */           for (List<Set<Long>> listOfTeams : teamSize2teamList.values())
/*     */           {
/* 240 */             for (Set<Long> roleIds : listOfTeams)
/*     */             {
/* 242 */               lastMatchedPlayers.addAll(roleIds);
/*     */             }
/*     */           }
/* 245 */           break;
/*     */         }
/*     */         
/*     */ 
/* 249 */         int toMatchCount = defaultPlayerNumber;
/* 250 */         Set<Long> matchedRoles = new HashSet();
/* 251 */         while (toMatchCount > 0)
/*     */         {
/*     */ 
/* 254 */           for (int teamSize = 5;; teamSize--) { if (teamSize < 2)
/*     */               break label488;
/* 256 */             if (toMatchCount >= teamSize)
/*     */             {
/* 258 */               List<Set<Long>> teamList = (List)teamSize2teamList.get(Integer.valueOf(teamSize));
/* 259 */               if (!teamList.isEmpty())
/*     */               {
/* 261 */                 int randomIndex = CommonUtils.random(0, teamList.size());
/* 262 */                 Set<Long> roleIds = (Set)teamList.remove(randomIndex);
/* 263 */                 matchedRoles.addAll(roleIds);
/* 264 */                 toMatchCount -= teamSize;
/* 265 */                 break;
/*     */               }
/*     */             } }
/*     */           label488:
/* 269 */           if (singlePlayerList.isEmpty())
/*     */             break;
/* 271 */           int randomIndex = CommonUtils.random(0, singlePlayerList.size());
/* 272 */           long roleId = ((Long)singlePlayerList.remove(randomIndex)).longValue();
/* 273 */           matchedRoles.add(Long.valueOf(roleId));
/* 274 */           toMatchCount--;
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 279 */         matchResult.add(matchedRoles);
/* 280 */         remainToMatchCount -= matchedRoles.size();
/*     */       }
/*     */       
/*     */ 
/* 284 */       attenderCount = 0;
/* 285 */       team2attenders.clear();
/* 286 */       new LogicRunnable()
/*     */       {
/*     */         public void process()
/*     */           throws Exception
/*     */         {
/* 291 */           BallBattleGameInstance.newInstances(BallBattleActivityManager.activityId, BallBattleActivityManager.round == this.val$activityCfg.totalRounds, matchResult);
/*     */         }
/*     */       }.execute();
/*     */     }
/*     */     
/*     */ 
/* 297 */     stage = ActivityStage.GAME_STAGE;
/* 298 */     long stageLength = activityCfg.roundMinutes * 60L;
/* 299 */     currentStageEndTime = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L + stageLength);
/* 300 */     newSession(stageLength, new LogicRunnable()
/*     */     {
/*     */ 
/*     */       public void process()
/*     */         throws Exception
/*     */       {}
/*     */ 
/* 307 */     });
/* 308 */     syncActivityStatus();
/*     */     
/* 310 */     BallBattleLogger.info(String.format("BallBattleActivityManager.onPrepareStageEnd()@done|activityid=%d|round=%d", new Object[] { Integer.valueOf(activityId), Integer.valueOf(round) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void onGameStageEnd()
/*     */   {
/* 319 */     SBallBattleActivityCfg activityCfg = SBallBattleActivityCfg.get(activityId);
/* 320 */     if (round >= activityCfg.totalRounds)
/*     */     {
/* 322 */       clean();
/* 323 */       return;
/*     */     }
/*     */     
/* 326 */     stage = ActivityStage.PREPARE_STAGE;
/* 327 */     round += 1;
/*     */     
/* 329 */     long stageLength = activityCfg.prepareMinutes * 60L;
/* 330 */     currentStageEndTime = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L + stageLength);
/* 331 */     newSession(stageLength, new LogicRunnable()
/*     */     {
/*     */ 
/*     */       public void process()
/*     */         throws Exception
/*     */       {}
/*     */ 
/*     */ 
/* 339 */     });
/* 340 */     syncActivityStatus();
/*     */     
/* 342 */     BallBattleLogger.info(String.format("BallBattleActivityManager.onGameStageEnd()done|activityid=%d|round=%d", new Object[] { Integer.valueOf(activityId), Integer.valueOf(round - 1) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static enum EnterPrepareMapResult
/*     */   {
/* 351 */     SUCCESS, 
/* 352 */     ACTIVITY_IN_LAST_ROUND, 
/* 353 */     CANNOT_PARTICIPATE, 
/* 354 */     ROLE_STATUS_CONFLICT, 
/* 355 */     ALREADY_IN_PREPARE_MAP, 
/* 356 */     EXCEPTION;
/*     */     
/*     */ 
/*     */     private EnterPrepareMapResult() {}
/*     */   }
/*     */   
/*     */   static EnterPrepareMapResult enterPrepareMap(long roleId)
/*     */   {
/* 364 */     if (activityId == 0)
/*     */     {
/* 366 */       return EnterPrepareMapResult.EXCEPTION;
/*     */     }
/*     */     
/* 369 */     String userId = RoleInterface.getUserId(roleId);
/* 370 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, activityId).isCanJoin())
/*     */     {
/* 372 */       return EnterPrepareMapResult.CANNOT_PARTICIPATE;
/*     */     }
/*     */     
/* 375 */     Set<Long> singleAttenders = (Set)team2attenders.get(Long.valueOf(0L));
/* 376 */     if (singleAttenders == null)
/*     */     {
/* 378 */       singleAttenders = new HashSet();
/* 379 */       team2attenders.put(Long.valueOf(0L), singleAttenders);
/*     */     }
/* 381 */     if (singleAttenders.contains(Long.valueOf(roleId)))
/*     */     {
/* 383 */       return EnterPrepareMapResult.ALREADY_IN_PREPARE_MAP;
/*     */     }
/*     */     
/* 386 */     SBallBattleActivityCfg activityCfg = SBallBattleActivityCfg.get(activityId);
/* 387 */     if (activityCfg == null)
/*     */     {
/* 389 */       return EnterPrepareMapResult.EXCEPTION;
/*     */     }
/* 391 */     if ((stage == ActivityStage.GAME_STAGE) && (round >= activityCfg.totalRounds))
/*     */     {
/* 393 */       return EnterPrepareMapResult.ACTIVITY_IN_LAST_ROUND;
/*     */     }
/*     */     
/* 396 */     if (!RoleStatusInterface.setStatus(roleId, 2161, true))
/*     */     {
/* 398 */       return EnterPrepareMapResult.ROLE_STATUS_CONFLICT;
/*     */     }
/*     */     
/* 401 */     MapInterface.transferToScene(roleId, worldId, activityCfg.prepareMapId);
/* 402 */     singleAttenders.add(Long.valueOf(roleId));
/* 403 */     attenderCount += 1;
/* 404 */     syncActivityStatus();
/* 405 */     return EnterPrepareMapResult.SUCCESS;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static EnterPrepareMapResult enterPrepareMap(long teamId, List<Long> roleIds)
/*     */   {
/* 413 */     if (activityId == 0)
/*     */     {
/* 415 */       return EnterPrepareMapResult.EXCEPTION;
/*     */     }
/*     */     
/* 418 */     Map<Long, String> roleId2userId = new HashMap();
/* 419 */     for (Long roleId : roleIds)
/*     */     {
/* 421 */       roleId2userId.put(roleId, RoleInterface.getUserId(roleId.longValue()));
/*     */     }
/* 423 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(roleId2userId, roleIds, activityId).isCanJoin())
/*     */     {
/* 425 */       return EnterPrepareMapResult.CANNOT_PARTICIPATE;
/*     */     }
/*     */     
/* 428 */     Set<Long> teamAttenders = (Set)team2attenders.get(Long.valueOf(teamId));
/* 429 */     if (teamAttenders == null)
/*     */     {
/* 431 */       teamAttenders = new HashSet();
/* 432 */       team2attenders.put(Long.valueOf(teamId), teamAttenders);
/*     */     }
/* 434 */     for (Long roleId : roleIds)
/*     */     {
/* 436 */       if (teamAttenders.contains(roleId))
/*     */       {
/* 438 */         return EnterPrepareMapResult.ALREADY_IN_PREPARE_MAP;
/*     */       }
/*     */     }
/*     */     
/* 442 */     SBallBattleActivityCfg activityCfg = SBallBattleActivityCfg.get(activityId);
/* 443 */     if ((stage == ActivityStage.GAME_STAGE) && (round >= activityCfg.totalRounds))
/*     */     {
/* 445 */       return EnterPrepareMapResult.ACTIVITY_IN_LAST_ROUND;
/*     */     }
/*     */     
/* 448 */     if (!RoleStatusInterface.setStatus(roleIds, 2161, true))
/*     */     {
/* 450 */       return EnterPrepareMapResult.ROLE_STATUS_CONFLICT;
/*     */     }
/*     */     
/* 453 */     MapInterface.transferAllRole(roleIds, worldId, activityCfg.prepareMapId);
/* 454 */     teamAttenders.addAll(roleIds);
/* 455 */     attenderCount += roleIds.size();
/* 456 */     syncActivityStatus();
/* 457 */     return EnterPrepareMapResult.SUCCESS;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static enum LeavePrepareMapResult
/*     */   {
/* 465 */     SUCCESS, 
/* 466 */     NOT_IN_PREPARE_MAP, 
/* 467 */     EXCEPTION;
/*     */     
/*     */ 
/*     */     private LeavePrepareMapResult() {}
/*     */   }
/*     */   
/*     */   static LeavePrepareMapResult leavePrepareMap(long roleId)
/*     */   {
/* 475 */     if (activityId == 0)
/*     */     {
/* 477 */       return LeavePrepareMapResult.EXCEPTION;
/*     */     }
/*     */     
/* 480 */     Set<Long> singleAttenders = (Set)team2attenders.get(Long.valueOf(0L));
/* 481 */     if ((singleAttenders == null) || (!singleAttenders.contains(Long.valueOf(roleId))))
/*     */     {
/* 483 */       return LeavePrepareMapResult.NOT_IN_PREPARE_MAP;
/*     */     }
/*     */     
/* 486 */     SBallBattleActivityCfg activityCfg = SBallBattleActivityCfg.get(activityId);
/* 487 */     MapInterface.transferToScene(roleId, MapInterface.getCenterWorldid(), activityCfg.exitMapId);
/* 488 */     RoleStatusInterface.unsetStatus(roleId, 2161);
/* 489 */     singleAttenders.remove(Long.valueOf(roleId));
/* 490 */     attenderCount -= 1;
/* 491 */     syncActivityStatus();
/* 492 */     return LeavePrepareMapResult.SUCCESS;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static LeavePrepareMapResult leavePrepareMap(long teamId, List<Long> roleIds)
/*     */   {
/* 500 */     if (activityId == 0)
/*     */     {
/* 502 */       return LeavePrepareMapResult.EXCEPTION;
/*     */     }
/*     */     
/* 505 */     Set<Long> teamAttenders = (Set)team2attenders.get(Long.valueOf(teamId));
/* 506 */     if ((teamAttenders == null) || (!teamAttenders.containsAll(roleIds)))
/*     */     {
/* 508 */       return LeavePrepareMapResult.NOT_IN_PREPARE_MAP;
/*     */     }
/*     */     
/* 511 */     SBallBattleActivityCfg activityCfg = SBallBattleActivityCfg.get(activityId);
/* 512 */     MapInterface.transferAllRole(roleIds, MapInterface.getCenterWorldid(), activityCfg.exitMapId);
/* 513 */     RoleStatusInterface.unsetStatus(roleIds, 2161);
/* 514 */     teamAttenders.removeAll(roleIds);
/* 515 */     if (teamAttenders.isEmpty())
/*     */     {
/* 517 */       team2attenders.remove(Long.valueOf(teamId));
/*     */     }
/* 519 */     attenderCount -= roleIds.size();
/* 520 */     syncActivityStatus();
/* 521 */     return LeavePrepareMapResult.SUCCESS;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onJoinTeam(JoinTeamArg arg)
/*     */   {
/* 529 */     if (activityId == 0)
/*     */     {
/* 531 */       return;
/*     */     }
/*     */     
/* 534 */     long teamId = arg.teamid;
/* 535 */     long roleId = arg.member.roleid;
/* 536 */     Set<Long> singleAttenders = (Set)team2attenders.get(Long.valueOf(0L));
/* 537 */     if ((singleAttenders == null) || (!singleAttenders.remove(Long.valueOf(roleId))))
/*     */     {
/* 539 */       return;
/*     */     }
/* 541 */     Set<Long> teamAttenders = (Set)team2attenders.get(Long.valueOf(teamId));
/* 542 */     if (teamAttenders == null)
/*     */     {
/* 544 */       teamAttenders = new HashSet();
/* 545 */       team2attenders.put(Long.valueOf(teamId), teamAttenders);
/*     */     }
/* 547 */     teamAttenders.add(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onLeaveTeam(LeaveTeamArg arg)
/*     */   {
/* 555 */     if (activityId == 0)
/*     */     {
/* 557 */       return;
/*     */     }
/*     */     
/* 560 */     long teamId = arg.teamid;
/* 561 */     long roleId = arg.roleid;
/* 562 */     Set<Long> teamAttenders = (Set)team2attenders.get(Long.valueOf(teamId));
/* 563 */     if ((teamAttenders == null) || (!teamAttenders.remove(Long.valueOf(roleId))))
/*     */     {
/* 565 */       return;
/*     */     }
/* 567 */     Set<Long> singleAttenders = (Set)team2attenders.get(Long.valueOf(0L));
/* 568 */     if (singleAttenders == null)
/*     */     {
/* 570 */       singleAttenders = new HashSet();
/* 571 */       team2attenders.put(Long.valueOf(0L), singleAttenders);
/*     */     }
/* 573 */     singleAttenders.add(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onTeamCreated(TeamCreateArg arg)
/*     */   {
/* 581 */     if (activityId == 0)
/*     */     {
/* 583 */       return;
/*     */     }
/*     */     
/* 586 */     Set<Long> singleAttenders = (Set)team2attenders.get(Long.valueOf(0L));
/* 587 */     if (singleAttenders == null)
/*     */     {
/* 589 */       return;
/*     */     }
/*     */     
/* 592 */     long teamId = arg.teamid;
/* 593 */     Set<Long> roleIds = new HashSet();
/* 594 */     for (TeamMember member : arg.members)
/*     */     {
/* 596 */       roleIds.add(Long.valueOf(member.roleid));
/*     */     }
/*     */     
/* 599 */     Set<Long> inPrepareMapRoleIds = new HashSet();
/* 600 */     for (Long roleId : roleIds)
/*     */     {
/* 602 */       if (singleAttenders.remove(roleId))
/*     */       {
/* 604 */         inPrepareMapRoleIds.add(roleId);
/*     */       }
/*     */     }
/* 607 */     if (inPrepareMapRoleIds.isEmpty())
/*     */     {
/* 609 */       return;
/*     */     }
/*     */     
/* 612 */     Set<Long> teamAttenders = (Set)team2attenders.get(Long.valueOf(teamId));
/* 613 */     if (teamAttenders == null)
/*     */     {
/* 615 */       teamAttenders = new HashSet();
/* 616 */       team2attenders.put(Long.valueOf(teamId), teamAttenders);
/*     */     }
/* 618 */     teamAttenders.addAll(inPrepareMapRoleIds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onTeamDisposed(TeamDissolveArg arg)
/*     */   {
/* 626 */     if (activityId == 0)
/*     */     {
/* 628 */       return;
/*     */     }
/*     */     
/* 631 */     long teamId = arg.teamid;
/* 632 */     Set<Long> teamAttenders = (Set)team2attenders.remove(Long.valueOf(teamId));
/* 633 */     if ((teamAttenders == null) || (teamAttenders.isEmpty()))
/*     */     {
/* 635 */       return;
/*     */     }
/* 637 */     Set<Long> singleAttenders = (Set)team2attenders.get(Long.valueOf(0L));
/* 638 */     if (singleAttenders == null)
/*     */     {
/* 640 */       singleAttenders = new HashSet();
/* 641 */       team2attenders.put(Long.valueOf(0L), singleAttenders);
/*     */     }
/* 643 */     singleAttenders.addAll(teamAttenders);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onFunctionSwitchToggleOff()
/*     */   {
/* 651 */     if (activityId == 0)
/*     */     {
/* 653 */       return;
/*     */     }
/*     */     
/*     */ 
/* 657 */     SBallBattleActivityCfg activityCfg = SBallBattleActivityCfg.get(activityId);
/* 658 */     for (Set<Long> roleIds : team2attenders.values())
/*     */     {
/* 660 */       for (Long roleId : roleIds)
/*     */       {
/* 662 */         new LogicProcedure()
/*     */         {
/*     */           protected boolean processImp()
/*     */             throws Exception
/*     */           {
/* 667 */             return RoleStatusInterface.unsetStatus(this.val$roleId.longValue(), 2161);
/*     */           }
/*     */         }.call();
/*     */       }
/*     */     }
/* 672 */     team2attenders.clear();
/* 673 */     MapInterface.dragAllRoleToTargetWorld(worldId, MapInterface.getCenterWorldid(), activityCfg.exitMapId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void notifyInsufficientPlayerNumber()
/*     */   {
/* 681 */     SNotifyInsufficientPlayerNumber p = new SNotifyInsufficientPlayerNumber();
/* 682 */     MapInterface.brocadCastInWorld(worldId, p, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void syncActivityStatus()
/*     */   {
/* 690 */     SSyncActivityStatus p = new SSyncActivityStatus();
/* 691 */     p.status.round = round;
/* 692 */     p.status.role_number = attenderCount;
/* 693 */     p.status.is_preparing = (stage == ActivityStage.PREPARE_STAGE ? 1 : 0);
/* 694 */     p.status.stage_end_time = currentStageEndTime;
/* 695 */     MapInterface.brocadCastInWorld(worldId, p, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void syncActivityStatus(long roleId)
/*     */   {
/* 703 */     SSyncActivityStatus p = new SSyncActivityStatus();
/* 704 */     p.status.round = round;
/* 705 */     p.status.role_number = attenderCount;
/* 706 */     p.status.is_preparing = (stage == ActivityStage.PREPARE_STAGE ? 1 : 0);
/* 707 */     p.status.stage_end_time = currentStageEndTime;
/* 708 */     OnlineManager.getInstance().send(roleId, p);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static ActivityHandler newActivityHandler()
/*     */   {
/* 716 */     return new BallBattleActivityHandler(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static class BallBattleActivityHandler
/*     */     implements ActivityHandler
/*     */   {
/*     */     public void initData(String userId, long roleId, int turn, int activityId) {}
/*     */     
/*     */ 
/*     */     public AwardReason getRecommendAwardReason()
/*     */     {
/* 729 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */     public List<ActivityStage> getActivityStages()
/*     */     {
/* 735 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */     public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, final int activityId)
/*     */     {
/* 741 */       BallBattleActivityManager.addTask(new LogicRunnable()
/*     */       {
/*     */         public void process()
/*     */           throws Exception
/*     */         {
/* 746 */           BallBattleActivityManager.initialize(activityId);
/*     */         }
/*     */       });
/*     */     }
/*     */     
/*     */     public void onActivityStageStart(int stage, boolean startAgain, int activityId) {}
/*     */     
/*     */     public void onActivityEnd(int activityId) {}
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\main\BallBattleActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */