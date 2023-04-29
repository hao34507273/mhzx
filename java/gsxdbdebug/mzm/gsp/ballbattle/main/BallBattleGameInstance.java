/*      */ package mzm.gsp.ballbattle.main;
/*      */ 
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.atomic.AtomicLong;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.award.main.AwardInterface;
/*      */ import mzm.gsp.award.main.AwardReason;
/*      */ import mzm.gsp.ballbattle.GameStatus;
/*      */ import mzm.gsp.ballbattle.PlayerScoreInfo;
/*      */ import mzm.gsp.ballbattle.SBallBattlePlayerStatus;
/*      */ import mzm.gsp.ballbattle.SLeaveGameMapFail;
/*      */ import mzm.gsp.ballbattle.SNotifyBuffEvent;
/*      */ import mzm.gsp.ballbattle.SNotifyCircleReduceEvent;
/*      */ import mzm.gsp.ballbattle.SNotifyGameEnded;
/*      */ import mzm.gsp.ballbattle.SNotifyKillEvent;
/*      */ import mzm.gsp.ballbattle.SNotifyMaxLevelEvent;
/*      */ import mzm.gsp.ballbattle.SNotifyNearbyEnemy;
/*      */ import mzm.gsp.ballbattle.SSyncGameStatus;
/*      */ import mzm.gsp.ballbattle.SSyncPlayerScoreInfo;
/*      */ import mzm.gsp.ballbattle.confbean.SAwardBean;
/*      */ import mzm.gsp.ballbattle.confbean.SBallBattleActivityCfg;
/*      */ import mzm.gsp.ballbattle.confbean.SBallBattleAwardCfg;
/*      */ import mzm.gsp.ballbattle.confbean.SBallBattleCircleBean;
/*      */ import mzm.gsp.ballbattle.confbean.SBallBattleCircleCfg;
/*      */ import mzm.gsp.ballbattle.confbean.SBallBattleGroundItemCfg;
/*      */ import mzm.gsp.ballbattle.confbean.SBallBattleGroundItemPositionCfg;
/*      */ import mzm.gsp.ballbattle.confbean.SBallBattleLevelBean;
/*      */ import mzm.gsp.ballbattle.confbean.SBallBattleLevelCfg;
/*      */ import mzm.gsp.ballbattle.confbean.SBallBattlePlayerRespawnRegionCfg;
/*      */ import mzm.gsp.ballbattle.confbean.SGroundItemPosition;
/*      */ import mzm.gsp.buff.main.BuffInterface;
/*      */ import mzm.gsp.map.main.MapCallback;
/*      */ import mzm.gsp.map.main.MapInterface;
/*      */ import mzm.gsp.map.main.scene.Position;
/*      */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*      */ import mzm.gsp.map.main.scene.zone.ZoneForm;
/*      */ import mzm.gsp.mounts.main.MountsInterface.RideMountsObj;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.role.main.RoleOneByOneManager;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.timer.main.MilliObserver;
/*      */ import mzm.gsp.timer.main.MilliSession;
/*      */ import mzm.gsp.timer.main.Observer;
/*      */ import mzm.gsp.timer.main.Session;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.CommonUtils;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.LogicProcedure;
/*      */ import mzm.gsp.util.LogicRunnable;
/*      */ import mzm.gsp.util.TaskOneByOne;
/*      */ 
/*      */ class BallBattleGameInstance
/*      */ {
/*   65 */   private static final Map<Long, BallBattleGameInstance> role2instance = new java.util.concurrent.ConcurrentHashMap();
/*      */   
/*      */ 
/*      */ 
/*   69 */   private static final AtomicLong mapEntityInstanceIdGenerator = new AtomicLong();
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void newInstances(int activityId, boolean isLastRound, List<Set<Long>> matchedList)
/*      */   {
/*   76 */     for (Set<Long> roleIds : matchedList)
/*      */     {
/*   78 */       new BallBattleGameInstance(activityId, isLastRound, roleIds);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void handleLeaveRequest(final long roleId)
/*      */   {
/*   87 */     BallBattleGameInstance instance = (BallBattleGameInstance)role2instance.get(Long.valueOf(roleId));
/*   88 */     if (instance != null)
/*      */     {
/*   90 */       instance.addRoleRelatedTaskIgnoringGameOver(roleId, new LogicRunnable()
/*      */       {
/*      */ 
/*      */         public void process()
/*      */         {
/*   95 */           this.val$instance.playerLeaveGameScene(roleId, true, false);
/*      */         }
/*      */       });
/*      */     }
/*      */     else
/*      */     {
/*  101 */       SLeaveGameMapFail fail = new SLeaveGameMapFail();
/*  102 */       fail.reason = 1;
/*  103 */       OnlineManager.getInstance().sendAtOnce(roleId, fail);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void handlePlayerReconnect(final long roleId)
/*      */   {
/*  112 */     BallBattleGameInstance instance = (BallBattleGameInstance)role2instance.get(Long.valueOf(roleId));
/*  113 */     if (instance != null)
/*      */     {
/*  115 */       instance.addRoleRelatedTaskIgnoringGameOver(roleId, new LogicRunnable()
/*      */       {
/*      */ 
/*      */         public void process()
/*      */         {
/*  120 */           this.val$instance.onPlayerReconnect(roleId);
/*      */         }
/*      */       });
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void handlePlayerLogout(final long roleId)
/*      */   {
/*  131 */     BallBattleGameInstance instance = (BallBattleGameInstance)role2instance.get(Long.valueOf(roleId));
/*  132 */     if (instance != null)
/*      */     {
/*  134 */       instance.addRoleRelatedTaskIgnoringGameOver(roleId, new LogicRunnable()
/*      */       {
/*      */ 
/*      */         public void process()
/*      */         {
/*  139 */           this.val$instance.onPlayerLogout(roleId);
/*      */         }
/*      */       });
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void handlePlayerLeaveTeam(final long roleId)
/*      */   {
/*  150 */     BallBattleGameInstance instance = (BallBattleGameInstance)role2instance.get(Long.valueOf(roleId));
/*  151 */     if (instance != null)
/*      */     {
/*  153 */       instance.addTaskIgnoringGameOver(new LogicRunnable()
/*      */       {
/*      */ 
/*      */         public void process()
/*      */         {
/*  158 */           this.val$instance.teleportPlayerToRespawnRegion(roleId);
/*      */         }
/*      */       });
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*  167 */   private final TaskOneByOne executor = new TaskOneByOne();
/*      */   
/*      */ 
/*  170 */   private final Set<Integer> zoneEventIds = new HashSet();
/*      */   
/*      */ 
/*  173 */   private boolean gameStarted = false;
/*      */   
/*  175 */   private volatile boolean gameOver = false;
/*      */   
/*      */ 
/*      */   private final boolean isLastRound;
/*      */   
/*      */ 
/*      */   private int startTime;
/*      */   
/*      */ 
/*      */   private int endTime;
/*      */   
/*      */   private final SBallBattleActivityCfg activityCfg;
/*      */   
/*      */   private final SBallBattleCircleCfg circleCfg;
/*      */   
/*      */   private final SBallBattleLevelCfg levelCfg;
/*      */   
/*      */   private final SBallBattleAwardCfg awardCfg;
/*      */   
/*  194 */   private final List<Integer> availableRespawnRegions = new ArrayList();
/*      */   
/*      */ 
/*      */   private final long worldId;
/*      */   
/*      */ 
/*      */   private final int sceneId;
/*      */   
/*      */ 
/*      */ 
/*      */   private static class PlayerInformation
/*      */   {
/*      */     private int score;
/*      */     
/*      */     private int killCount;
/*      */     
/*      */     private int deathCount;
/*      */     
/*      */     private int scoreUpdateTime;
/*      */     
/*      */     private int life;
/*      */     
/*      */     private int level;
/*      */     
/*      */     private int gene;
/*      */     
/*      */     private int speedOffset;
/*      */     
/*  222 */     private final Set<Integer> states = new HashSet();
/*      */   }
/*      */   
/*  225 */   private final Map<Long, PlayerInformation> playerInfos = new HashMap();
/*      */   
/*  227 */   private final Set<Long> inSceneRoleIds = new HashSet();
/*      */   
/*      */ 
/*  230 */   private final Map<Long, Set<Long>> ignoredNearbyEnemyAlerts = new HashMap();
/*      */   
/*      */ 
/*  233 */   private int circleReduceCount = 0;
/*      */   
/*  235 */   private int nextCircleReduceTime = 0;
/*      */   
/*      */ 
/*  238 */   private final List<GroundItemPosition> availableGroundItemPositions = new ArrayList();
/*      */   
/*  240 */   private final Set<GroundItemPosition> geneItemPositions = new HashSet();
/*      */   
/*  242 */   private final Map<Integer, GroundItemPosition> buffItemPositions = new HashMap();
/*      */   
/*  244 */   private final Map<GroundItemPosition, Long> groundItemPosition2mapEntityInstance = new HashMap();
/*      */   
/*      */ 
/*  247 */   private final Map<Long, GroundItemPosition> role2groundItemPositions = new HashMap();
/*      */   
/*      */ 
/*  250 */   private final Map<Long, Set<Long>> role2sessions = new HashMap();
/*      */   
/*  252 */   private final Map<Long, Set<Integer>> role2buffs = new HashMap();
/*      */   
/*      */ 
/*  255 */   private final Map<Long, Long> role2mount = new HashMap();
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private BallBattleGameInstance(int activityId, boolean isLastRound, Set<Long> roleIds)
/*      */   {
/*  264 */     this.isLastRound = isLastRound;
/*      */     
/*      */ 
/*  267 */     this.activityCfg = SBallBattleActivityCfg.get(activityId);
/*  268 */     this.circleCfg = SBallBattleCircleCfg.get(this.activityCfg.circleCfgId);
/*  269 */     this.levelCfg = SBallBattleLevelCfg.get(this.activityCfg.levelCfgId);
/*  270 */     this.awardCfg = SBallBattleAwardCfg.get(activityId);
/*  271 */     SBallBattlePlayerRespawnRegionCfg regionCfg = SBallBattlePlayerRespawnRegionCfg.get(this.activityCfg.playerRespawnRegionCfgId);
/*      */     
/*  273 */     this.availableRespawnRegions.addAll(regionCfg.regions.subList(0, regionCfg.regionNumber));
/*      */     
/*      */ 
/*  276 */     this.worldId = MapInterface.createWorld(Collections.singleton(Integer.valueOf(this.activityCfg.gameMapId)));
/*  277 */     this.sceneId = MapInterface.getSceneInstanceId(this.worldId, this.activityCfg.gameMapId, true);
/*      */     
/*      */ 
/*  280 */     for (Long roleId : roleIds)
/*      */     {
/*  282 */       PlayerInformation playerInformation = new PlayerInformation(null);
/*  283 */       playerInformation.score = 0;
/*  284 */       playerInformation.killCount = 0;
/*  285 */       playerInformation.deathCount = 0;
/*  286 */       playerInformation.scoreUpdateTime = 0;
/*  287 */       playerInformation.life = this.activityCfg.playerLifeNumber;
/*  288 */       playerInformation.level = 1;
/*  289 */       playerInformation.gene = 0;
/*  290 */       playerInformation.speedOffset = 0;
/*  291 */       this.playerInfos.put(roleId, playerInformation);
/*      */     }
/*      */     
/*  294 */     ZoneEventRegisterCallback zoneEventRegisterCallback = new ZoneEventRegisterCallback(null);
/*      */     
/*      */ 
/*  297 */     SBallBattleGroundItemPositionCfg groundItemPositionCfg = SBallBattleGroundItemPositionCfg.get(activityId);
/*  298 */     GroundItemZoneListener groundItemZoneListener = new GroundItemZoneListener(null);
/*  299 */     for (SGroundItemPosition sGroundItemPosition : groundItemPositionCfg.positions)
/*      */     {
/*  301 */       if (isInSafeCircle(sGroundItemPosition.x, sGroundItemPosition.y))
/*      */       {
/*  303 */         GroundItemPosition position = new GroundItemPosition(sGroundItemPosition, null);
/*  304 */         this.availableGroundItemPositions.add(position);
/*  305 */         GroundItemZone groundItemZone = new GroundItemZone(position, this.activityCfg.groundItemCheckRadius, null);
/*  306 */         MapInterface.registerZoneEvent(this.sceneId, groundItemZone, groundItemZoneListener, zoneEventRegisterCallback);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  311 */     newMilliSessionIgnoringGameOver(CommonUtils.random(0, this.activityCfg.maxRandomDelayInitMilliseconds), new LogicRunnable()
/*      */     {
/*      */ 
/*      */       public void process()
/*      */       {
/*  316 */         BallBattleGameInstance.this.teleportAllPlayerIntoGameScene();
/*      */       }
/*      */     });
/*      */     
/*  320 */     if (BallBattleLogger.isDebugEnabled())
/*      */     {
/*  322 */       BallBattleLogger.debug(String.format("BallBattleGameInstance.BallBattleGameInstance()@done|sceneid=%d", new Object[] { Integer.valueOf(this.sceneId) }));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void teleportAllPlayerIntoGameScene()
/*      */   {
/*  345 */     for (final Long roleId : this.playerInfos.keySet())
/*      */     {
/*  347 */       MapInterface.transferToScene(roleId.longValue(), this.sceneId, new MapCallback()
/*      */       {
/*      */ 
/*      */         public boolean isCallInProcedure()
/*      */         {
/*  352 */           return false;
/*      */         }
/*      */         
/*      */ 
/*      */         public boolean onResult(Boolean result)
/*      */         {
/*  358 */           BallBattleGameInstance.this.addTaskIgnoringGameOver(new LogicProcedure()
/*      */           {
/*      */ 
/*      */             protected boolean processImp()
/*      */             {
/*      */ 
/*  364 */               RoleStatusInterface.unsetStatus(BallBattleGameInstance.6.this.val$roleId.longValue(), 2161);
/*  365 */               RoleStatusInterface.setStatus(BallBattleGameInstance.6.this.val$roleId.longValue(), 2162, false);
/*      */               
/*      */ 
/*  368 */               BallBattleGameInstance.this.applyRoleBuff(BallBattleGameInstance.6.this.val$roleId.longValue(), BallBattleGameInstance.this.activityCfg.gamePrepareBuff, false);
/*      */               
/*      */ 
/*  371 */               MountsInterface.RideMountsObj mountObj = mzm.gsp.mounts.main.MountsInterface.getRideMountsObj(BallBattleGameInstance.6.this.val$roleId.longValue(), true);
/*  372 */               if (mountObj.getMountsCfgId() != 0)
/*      */               {
/*  374 */                 mzm.gsp.mounts.main.MountsInterface.unRideMounts(BallBattleGameInstance.6.this.val$roleId.longValue());
/*  375 */                 BallBattleGameInstance.this.role2mount.put(BallBattleGameInstance.6.this.val$roleId, Long.valueOf(mountObj.getMountsId()));
/*      */               }
/*      */               
/*      */ 
/*  379 */               mzm.gsp.pet.main.PetInterface.hidePet(BallBattleGameInstance.6.this.val$roleId.longValue(), true);
/*  380 */               mzm.gsp.children.main.ChildrenInterface.hideChild(BallBattleGameInstance.6.this.val$roleId.longValue(), true);
/*      */               
/*      */ 
/*  383 */               int speedOffset = ((SBallBattleLevelBean)BallBattleGameInstance.this.levelCfg.levels.get(0)).speedOffset;
/*  384 */               ((BallBattleGameInstance.PlayerInformation)BallBattleGameInstance.this.playerInfos.get(BallBattleGameInstance.6.this.val$roleId)).speedOffset = speedOffset;
/*  385 */               ((BallBattleGameInstance.PlayerInformation)BallBattleGameInstance.access$2200(BallBattleGameInstance.this).get(BallBattleGameInstance.6.this.val$roleId)).states.add(Integer.valueOf(0));
/*  386 */               MapInterface.addRoleSpeedFixAdded(BallBattleGameInstance.6.this.val$roleId.longValue(), speedOffset, null);
/*      */               
/*      */ 
/*  389 */               BallBattleGameInstance.this.syncPlayerStatus(BallBattleGameInstance.6.this.val$roleId.longValue());
/*      */               
/*      */ 
/*      */ 
/*  393 */               BallBattleGameInstance.this.inSceneRoleIds.add(BallBattleGameInstance.6.this.val$roleId);
/*  394 */               if (BallBattleGameInstance.this.inSceneRoleIds.size() == BallBattleGameInstance.this.playerInfos.size())
/*      */               {
/*  396 */                 BallBattleGameInstance.this.addTaskIgnoringGameOver(new LogicRunnable()
/*      */                 {
/*      */ 
/*      */                   public void process()
/*      */                   {
/*  401 */                     BallBattleGameInstance.this.onAllPlayerTeleported();
/*      */                   }
/*      */                 });
/*      */               }
/*  405 */               return true;
/*      */             }
/*  407 */           });
/*  408 */           return true;
/*      */         }
/*      */       });
/*      */     }
/*      */     
/*  413 */     if (BallBattleLogger.isDebugEnabled())
/*      */     {
/*  415 */       BallBattleLogger.debug(String.format("BallBattleGameInstance.teleportAllPlayerIntoGameScene()@done|sceneid=%d", new Object[] { Integer.valueOf(this.sceneId) }));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void onAllPlayerTeleported()
/*      */   {
/*  427 */     for (Long roleId : this.inSceneRoleIds)
/*      */     {
/*      */ 
/*  430 */       role2instance.put(roleId, this);
/*      */       
/*      */ 
/*      */ 
/*  434 */       mzm.gsp.team.main.TeamInfo teamInfo = mzm.gsp.team.main.TeamInterface.getTeamInfoByRoleId(roleId.longValue());
/*  435 */       if (teamInfo == null)
/*      */       {
/*  437 */         teleportPlayerToRespawnRegion(roleId.longValue());
/*      */       }
/*      */       else
/*      */       {
/*  441 */         mzm.gsp.team.main.TeamInterface.leaveTeamNoneRealTime(roleId.longValue());
/*  442 */         if (BallBattleLogger.isDebugEnabled())
/*      */         {
/*  444 */           BallBattleLogger.debug(String.format("BallBattleGameInstance.onAllPlayerTeleported()@leaving team scheduled|sceneid=%d|roleid=%d", new Object[] { Integer.valueOf(this.sceneId), roleId }));
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  451 */     int now = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/*  452 */     this.startTime = (now + this.activityCfg.gamePrepareSeconds);
/*  453 */     this.endTime = (this.startTime + this.activityCfg.gameSeconds);
/*  454 */     this.nextCircleReduceTime = (this.startTime + ((SBallBattleCircleBean)this.circleCfg.circles.get(0)).circleReduceSeconds);
/*  455 */     syncGameStatusToInSceneRoles();
/*      */     
/*      */ 
/*  458 */     respawnGeneItems(true);
/*  459 */     respawnBuffItems(true);
/*      */     
/*      */ 
/*  462 */     newSessionIgnoringGameOver(this.activityCfg.gamePrepareSeconds, new LogicRunnable()
/*      */     {
/*      */ 
/*      */       public void process()
/*      */       {
/*  467 */         BallBattleGameInstance.this.onGameStart();
/*      */       }
/*      */     });
/*      */     
/*  471 */     if (BallBattleLogger.isDebugEnabled())
/*      */     {
/*  473 */       BallBattleLogger.debug(String.format("BallBattleGameInstance.onAllPlayerTeleported()@done|sceneid=%d", new Object[] { Integer.valueOf(this.sceneId) }));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void teleportPlayerToRespawnRegion(long roleId)
/*      */   {
/*  482 */     int index = CommonUtils.random(0, this.availableRespawnRegions.size());
/*  483 */     int regionId = ((Integer)this.availableRespawnRegions.remove(index)).intValue();
/*  484 */     Position randomPosition = MapInterface.randomPosFromRegion(this.activityCfg.gameMapId, regionId);
/*  485 */     while (!isInSafeCircle(randomPosition.getX(), randomPosition.getY()))
/*      */     {
/*  487 */       randomPosition = MapInterface.randomPosFromRegion(this.activityCfg.gameMapId, regionId);
/*      */     }
/*  489 */     MapInterface.transferToScene(roleId, this.sceneId, randomPosition.getX(), randomPosition.getY());
/*      */     
/*  491 */     if (BallBattleLogger.isDebugEnabled())
/*      */     {
/*  493 */       BallBattleLogger.debug(String.format("BallBattleGameInstance.teleportPlayerToRespawnRegion()@done|sceneid=%d|roleid=%d|x=%d|y=%d", new Object[] { Integer.valueOf(this.sceneId), Long.valueOf(roleId), Integer.valueOf(randomPosition.getX()), Integer.valueOf(randomPosition.getY()) }));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void onGameStart()
/*      */   {
/*  513 */     this.gameStarted = true;
/*      */     
/*      */ 
/*  516 */     for (final Long roleId : this.inSceneRoleIds)
/*      */     {
/*  518 */       removeRoleBuff(roleId.longValue(), this.activityCfg.gamePrepareBuff);
/*  519 */       newRoleRelatedSession(roleId.longValue(), this.activityCfg.initProtectSeconds, new LogicRunnable()
/*      */       {
/*      */ 
/*      */         public void process()
/*      */         {
/*  524 */           ((BallBattleGameInstance.PlayerInformation)BallBattleGameInstance.access$2200(BallBattleGameInstance.this).get(roleId)).states.remove(Integer.valueOf(0));
/*  525 */           BallBattleGameInstance.this.syncPlayerStatus(roleId.longValue());
/*      */         }
/*      */       });
/*      */     }
/*      */     
/*      */ 
/*  531 */     new CollisionObserver(this.activityCfg.collisionCheckMilliseconds, null);
/*      */     
/*      */ 
/*  534 */     new GeneItemRespawnObserver(this.activityCfg.geneItemRespawnSeconds, null);
/*      */     
/*      */ 
/*  537 */     new BuffItemRespawnObserver(this.activityCfg.buffItemRespawnSeconds, null);
/*  538 */     newSession(this.activityCfg.buffItemDisappearSeconds, new LogicRunnable()
/*      */     {
/*      */ 
/*      */       public void process()
/*      */       {
/*  543 */         BallBattleGameInstance.this.destroyBuffItems();
/*      */       }
/*      */       
/*      */ 
/*  547 */     });
/*  548 */     newSession(((SBallBattleCircleBean)this.circleCfg.circles.get(0)).circleReduceSeconds, new LogicRunnable()
/*      */     {
/*      */ 
/*      */       public void process()
/*      */       {
/*  553 */         BallBattleGameInstance.this.onCircleReduce();
/*      */       }
/*      */       
/*      */ 
/*  557 */     });
/*  558 */     newSession(this.activityCfg.gameSeconds, new LogicRunnable()
/*      */     {
/*      */ 
/*      */       public void process()
/*      */       {
/*  563 */         BallBattleGameInstance.this.onGameEnd();
/*      */       }
/*      */     });
/*      */     
/*      */ 
/*  568 */     for (Long roleId : this.inSceneRoleIds)
/*      */     {
/*  570 */       tlogPlayGame(roleId.longValue());
/*      */     }
/*      */     
/*  573 */     if (BallBattleLogger.isDebugEnabled())
/*      */     {
/*  575 */       BallBattleLogger.debug(String.format("BallBattleGameInstance.onGameStart()@done|sceneid=%d|roleids=%s", new Object[] { Integer.valueOf(this.sceneId), this.playerInfos.keySet() }));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void onGameEnd()
/*      */   {
/*  592 */     this.gameOver = true;
/*  593 */     this.endTime = ((int)(DateTimeUtils.getCurrTimeInMillis() / 1000L));
/*      */     
/*  595 */     notifyGameEndedToInSceneRoles();
/*      */     
/*      */ 
/*  598 */     List<Long> rankedRoleIds = new ArrayList(this.playerInfos.keySet());
/*  599 */     Collections.sort(rankedRoleIds, new java.util.Comparator()
/*      */     {
/*      */ 
/*      */       public int compare(Long o1, Long o2)
/*      */       {
/*  604 */         BallBattleGameInstance.PlayerInformation i1 = (BallBattleGameInstance.PlayerInformation)BallBattleGameInstance.this.playerInfos.get(o1);
/*  605 */         BallBattleGameInstance.PlayerInformation i2 = (BallBattleGameInstance.PlayerInformation)BallBattleGameInstance.this.playerInfos.get(o2);
/*  606 */         if ((i1 == null) || (i2 == null))
/*      */         {
/*  608 */           return 0;
/*      */         }
/*      */         
/*      */ 
/*      */ 
/*  613 */         int result = -(i1.score - i2.score);
/*  614 */         if (result != 0)
/*      */         {
/*  616 */           return result;
/*      */         }
/*      */         
/*  619 */         result = -(i1.killCount - i2.killCount);
/*  620 */         if (result != 0)
/*      */         {
/*  622 */           return result;
/*      */         }
/*      */         
/*  625 */         result = i1.deathCount - i2.deathCount;
/*  626 */         if (result != 0)
/*      */         {
/*  628 */           return result;
/*      */         }
/*      */         
/*  631 */         return (int)(o1.longValue() - o2.longValue());
/*      */       }
/*      */       
/*  634 */     });
/*  635 */     AwardReason awardReason = new AwardReason(mzm.gsp.tlog.LogReason.BALL_BATTLE_AWARD);
/*  636 */     mzm.gsp.tlog.TLogArg tLogArg = new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.BALL_BATTLE_AWARD);
/*  637 */     int i = 0; for (int j = 0; i < rankedRoleIds.size(); i++)
/*      */     {
/*  639 */       int rank = i + 1;
/*  640 */       final long roleId = ((Long)rankedRoleIds.get(i)).longValue();
/*      */       
/*  642 */       int awardId = -1;
/*  643 */       while (j < this.awardCfg.awards.size())
/*      */       {
/*  645 */         SAwardBean awardBean = (SAwardBean)this.awardCfg.awards.get(j);
/*  646 */         if (rank <= awardBean.lowestAwardPosition)
/*      */         {
/*  648 */           awardId = awardBean.awardId;
/*  649 */           break;
/*      */         }
/*  651 */         j++;
/*      */       }
/*      */       
/*      */ 
/*  655 */       if (this.inSceneRoleIds.contains(Long.valueOf(roleId)))
/*      */       {
/*  657 */         final int finalAwardId = awardId;
/*  658 */         new LogicProcedure()
/*      */         {
/*      */ 
/*      */           protected boolean processImp()
/*      */           {
/*  663 */             AwardInterface.award(finalAwardId, RoleInterface.getUserId(roleId), roleId, false, true, this.val$awardReason);
/*  664 */             return true;
/*      */           }
/*      */           
/*      */         }.call();
/*      */       }
/*      */       else
/*      */       {
/*  671 */         mzm.gsp.mail.main.MailAttachment attachment = AwardInterface.getMailAttachmentBy(AwardInterface.getRoleAwardModel(awardId, roleId, -1, awardReason));
/*      */         
/*  673 */         mzm.gsp.mail.main.MailInterface.asynBuildAndSendMail(roleId, this.activityCfg.awardMailId, null, Collections.singletonList(String.valueOf(rank)), attachment, tLogArg);
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  678 */       tlogGetAward(roleId, rank);
/*      */     }
/*      */     
/*      */ 
/*  682 */     if (!this.inSceneRoleIds.isEmpty())
/*      */     {
/*  684 */       for (final Long roleId : this.inSceneRoleIds)
/*      */       {
/*  686 */         newSessionIgnoringGameOver(this.activityCfg.gameEndForceLeaveSeconds, new LogicRunnable()
/*      */         {
/*      */ 
/*      */           public void process()
/*      */           {
/*  691 */             if (BallBattleGameInstance.this.inSceneRoleIds.contains(roleId))
/*      */             {
/*  693 */               BallBattleGameInstance.this.playerLeaveGameScene(roleId.longValue(), false, false);
/*      */             }
/*      */             
/*      */           }
/*      */           
/*      */         });
/*      */       }
/*      */     } else {
/*  701 */       onAllPlayerLeave();
/*      */     }
/*      */     
/*  704 */     if (BallBattleLogger.isDebugEnabled())
/*      */     {
/*  706 */       BallBattleLogger.debug(String.format("BallBattleGameInstance.onGameEnd()@done|sceneid=%d", new Object[] { Integer.valueOf(this.sceneId) }));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void onGameForceEnd()
/*      */   {
/*  715 */     this.gameOver = true;
/*  716 */     this.endTime = ((int)(DateTimeUtils.getCurrTimeInMillis() / 1000L));
/*      */     
/*  718 */     if (!this.inSceneRoleIds.isEmpty())
/*      */     {
/*  720 */       for (final Long roleId : this.inSceneRoleIds)
/*      */       {
/*  722 */         addTaskIgnoringGameOver(new LogicRunnable()
/*      */         {
/*      */ 
/*      */           public void process()
/*      */           {
/*  727 */             if (BallBattleGameInstance.this.inSceneRoleIds.contains(roleId))
/*      */             {
/*  729 */               BallBattleGameInstance.this.playerLeaveGameScene(roleId.longValue(), false, true);
/*      */             }
/*      */             
/*      */           }
/*      */           
/*      */         });
/*      */       }
/*      */     } else {
/*  737 */       onAllPlayerLeave();
/*      */     }
/*      */     
/*  740 */     if (BallBattleLogger.isDebugEnabled())
/*      */     {
/*  742 */       BallBattleLogger.debug(String.format("BallBattleGameInstance.onGameForceEnd()@done|sceneid=%d", new Object[] { Integer.valueOf(this.sceneId) }));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void onAllPlayerLeave()
/*      */   {
/*  759 */     this.playerInfos.clear();
/*  760 */     this.role2sessions.clear();
/*  761 */     this.role2buffs.clear();
/*  762 */     this.ignoredNearbyEnemyAlerts.clear();
/*      */     
/*  764 */     destroyAllGroundItems();
/*  765 */     this.availableGroundItemPositions.clear();
/*  766 */     this.role2groundItemPositions.clear();
/*      */     
/*  768 */     synchronized (this.zoneEventIds)
/*      */     {
/*  770 */       for (Integer zoneEventId : this.zoneEventIds)
/*      */       {
/*  772 */         MapInterface.unregisterZoneEvent(this.sceneId, zoneEventId.intValue());
/*      */       }
/*      */     }
/*  775 */     this.zoneEventIds.clear();
/*      */     
/*  777 */     MapInterface.destroyWorld(this.worldId);
/*      */     
/*  779 */     if (BallBattleLogger.isDebugEnabled())
/*      */     {
/*  781 */       BallBattleLogger.debug(String.format("BallBattleGameInstance.onAllPlayerLeave()@done|sceneid=%d", new Object[] { Integer.valueOf(this.sceneId) }));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void onPlayerEnterGroundItemPosition(long roleId, GroundItemPosition position)
/*      */   {
/*  794 */     this.role2groundItemPositions.put(Long.valueOf(roleId), position);
/*      */     
/*  796 */     if (isPlayerDead(roleId))
/*      */     {
/*  798 */       return;
/*      */     }
/*      */     
/*      */ 
/*  802 */     if (this.geneItemPositions.contains(position))
/*      */     {
/*  804 */       playerGetGeneItem(roleId, position);
/*  805 */       if (BallBattleLogger.isDebugEnabled())
/*      */       {
/*  807 */         BallBattleLogger.debug(String.format("BallBattleGameInstance.onPlayerEnterGroundItemPosition()@player get gene item|sceneid=%d|roleid=%d", new Object[] { Integer.valueOf(this.sceneId), Long.valueOf(roleId) }));
/*      */       }
/*      */       
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/*  814 */       for (Map.Entry<Integer, GroundItemPosition> entry : this.buffItemPositions.entrySet())
/*      */       {
/*  816 */         if (((GroundItemPosition)entry.getValue()).equals(position))
/*      */         {
/*  818 */           playerGetBuffItem(roleId, ((Integer)entry.getKey()).intValue(), null);
/*  819 */           if (!BallBattleLogger.isDebugEnabled())
/*      */             break;
/*  821 */           BallBattleLogger.debug(String.format("BallBattleGameInstance.onPlayerEnterGroundItemPosition()@player get buff item|sceneid=%d|roleid=%d|buff_item_cfgid=%d", new Object[] { Integer.valueOf(this.sceneId), Long.valueOf(roleId), entry.getKey() })); break;
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void onPlayerLeaveGroundItemPosition(long roleId)
/*      */   {
/*  838 */     this.role2groundItemPositions.remove(Long.valueOf(roleId));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void playerGetGeneItem(long roleId, GroundItemPosition position)
/*      */   {
/*  851 */     if (position != null)
/*      */     {
/*  853 */       this.availableGroundItemPositions.add(position);
/*  854 */       this.geneItemPositions.remove(position);
/*  855 */       Long instanceId = (Long)this.groundItemPosition2mapEntityInstance.remove(position);
/*  856 */       if (instanceId == null)
/*      */       {
/*  858 */         return;
/*      */       }
/*  860 */       MapInterface.removeMapEntity(MapEntityType.MET_BALL_BATTLE_GROUND_ITEM, instanceId.longValue(), null);
/*      */     }
/*      */     
/*      */ 
/*  864 */     SBallBattleGroundItemCfg geneItemCfg = SBallBattleGroundItemCfg.get(this.activityCfg.geneItemCfgId);
/*  865 */     if (geneItemCfg == null)
/*      */     {
/*  867 */       return;
/*      */     }
/*  869 */     addGeneToPlayer(roleId, geneItemCfg.providedGene, true);
/*      */     
/*  871 */     if (BallBattleLogger.isDebugEnabled())
/*      */     {
/*  873 */       BallBattleLogger.debug(String.format("BallBattleGameInstance.playerGetGeneItem()@done|sceneid=%d|roleid=%d", new Object[] { Integer.valueOf(this.sceneId), Long.valueOf(roleId) }));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void addGeneToPlayer(final long roleId, int gene, boolean syncPlayerStatusNow)
/*      */   {
/*  886 */     final PlayerInformation playerInformation = (PlayerInformation)this.playerInfos.get(Long.valueOf(roleId));
/*  887 */     if (playerInformation == null)
/*      */     {
/*  889 */       return;
/*      */     }
/*  891 */     if (playerInformation.states.contains(Integer.valueOf(5)))
/*      */     {
/*  893 */       return;
/*      */     }
/*      */     
/*      */ 
/*  897 */     SBallBattleLevelBean currentLevel = (SBallBattleLevelBean)this.levelCfg.levels.get(playerInformation.level - 1);
/*  898 */     if (currentLevel == null)
/*      */     {
/*  900 */       return;
/*      */     }
/*  902 */     PlayerInformation.access$1112(playerInformation, gene);
/*      */     
/*      */ 
/*  905 */     if (playerInformation.gene >= currentLevel.requiredGene)
/*      */     {
/*      */ 
/*  908 */       PlayerInformation.access$1120(playerInformation, currentLevel.requiredGene);
/*  909 */       PlayerInformation.access$1008(playerInformation);
/*      */       
/*      */ 
/*  912 */       SBallBattleLevelBean newLevel = (SBallBattleLevelBean)this.levelCfg.levels.get(playerInformation.level - 1);
/*  913 */       if (newLevel == null)
/*      */       {
/*  915 */         return;
/*      */       }
/*  917 */       MapInterface.addRoleSpeedFixAdded(roleId, newLevel.speedOffset - playerInformation.speedOffset, null);
/*  918 */       playerInformation.speedOffset = newLevel.speedOffset;
/*      */       
/*      */ 
/*  921 */       if (playerInformation.level >= this.levelCfg.levels.size())
/*      */       {
/*  923 */         playerInformation.states.add(Integer.valueOf(5));
/*  924 */         notifyMaxLevelEventToInSceneRoles(roleId, (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L) + this.activityCfg.maxLevelResetSeconds);
/*      */         
/*  926 */         newRoleRelatedSession(roleId, this.activityCfg.maxLevelResetSeconds, new LogicRunnable()
/*      */         {
/*      */ 
/*      */           public void process()
/*      */           {
/*      */ 
/*  932 */             playerInformation.level = 1;
/*  933 */             playerInformation.gene = 0;
/*  934 */             int level1SpeedOffset = ((SBallBattleLevelBean)BallBattleGameInstance.this.levelCfg.levels.get(0)).speedOffset;
/*  935 */             MapInterface.addRoleSpeedFixAdded(roleId, level1SpeedOffset - playerInformation.speedOffset, null);
/*      */             
/*  937 */             playerInformation.speedOffset = level1SpeedOffset;
/*  938 */             playerInformation.states.remove(Integer.valueOf(5));
/*  939 */             BallBattleGameInstance.this.syncPlayerStatus(roleId);
/*      */           }
/*      */         });
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  947 */     if (syncPlayerStatusNow)
/*      */     {
/*  949 */       syncPlayerStatus(roleId);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void playerGetBuffItem(long roleId, int groundItemCfgId, GroundItemPosition respawnPosition)
/*      */   {
/*  963 */     GroundItemPosition entityPosition = (GroundItemPosition)this.buffItemPositions.remove(Integer.valueOf(groundItemCfgId));
/*  964 */     if (entityPosition != null)
/*      */     {
/*  966 */       this.availableGroundItemPositions.add(entityPosition);
/*  967 */       Long instanceId = (Long)this.groundItemPosition2mapEntityInstance.remove(entityPosition);
/*  968 */       if (instanceId == null)
/*      */       {
/*  970 */         return;
/*      */       }
/*  972 */       MapInterface.removeMapEntity(MapEntityType.MET_BALL_BATTLE_GROUND_ITEM, instanceId.longValue(), null);
/*      */     }
/*  974 */     else if (respawnPosition == null)
/*      */     {
/*  976 */       return;
/*      */     }
/*      */     
/*      */ 
/*  980 */     SBallBattleGroundItemCfg groundItemCfg = SBallBattleGroundItemCfg.get(groundItemCfgId);
/*  981 */     if (groundItemCfg == null)
/*      */     {
/*  983 */       return;
/*      */     }
/*  985 */     GroundItemPosition position = entityPosition != null ? entityPosition : respawnPosition;
/*  986 */     switch (groundItemCfg.type)
/*      */     {
/*      */     case 1: 
/*  989 */       playerGetSpeedItem(roleId, groundItemCfg, position);
/*  990 */       break;
/*      */     case 2: 
/*  992 */       playerGetFreezeItem(roleId, groundItemCfg, position);
/*  993 */       break;
/*      */     case 3: 
/*  995 */       playerGetShadowItem(roleId, groundItemCfg, position);
/*  996 */       break;
/*      */     case 4: 
/*  998 */       playerGetGhostItem(roleId, groundItemCfg, position);
/*      */     }
/*      */     
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void playerGetSpeedItem(long roleId, SBallBattleGroundItemCfg buffItemCfg, GroundItemPosition position)
/*      */   {
/* 1011 */     playerGetBuffItemEffectiveToSelf(roleId, buffItemCfg, position, 1, 1);
/* 1012 */     if (BallBattleLogger.isDebugEnabled())
/*      */     {
/* 1014 */       BallBattleLogger.debug(String.format("BallBattleGameInstance.playerGetSpeedItem()@done|sceneid=%d|roleid=%d", new Object[] { Integer.valueOf(this.sceneId), Long.valueOf(roleId) }));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void playerGetFreezeItem(long roleId, SBallBattleGroundItemCfg buffItemCfg, GroundItemPosition position)
/*      */   {
/* 1027 */     playerGetBuffItemEffectiveToOthers(roleId, buffItemCfg, position, 2, 2);
/* 1028 */     if (BallBattleLogger.isDebugEnabled())
/*      */     {
/* 1030 */       BallBattleLogger.debug(String.format("BallBattleGameInstance.playerGetFreezeItem()@done|sceneid=%d|roleid=%d", new Object[] { Integer.valueOf(this.sceneId), Long.valueOf(roleId) }));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void playerGetShadowItem(long roleId, SBallBattleGroundItemCfg buffItemCfg, GroundItemPosition position)
/*      */   {
/* 1043 */     playerGetBuffItemEffectiveToOthers(roleId, buffItemCfg, position, 3, 3);
/* 1044 */     if (BallBattleLogger.isDebugEnabled())
/*      */     {
/* 1046 */       BallBattleLogger.debug(String.format("BallBattleGameInstance.playerGetShadowItem()@done|sceneid=%d|roleId=%d", new Object[] { Integer.valueOf(this.sceneId), Long.valueOf(roleId) }));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void playerGetGhostItem(long roleId, SBallBattleGroundItemCfg buffItemCfg, GroundItemPosition position)
/*      */   {
/* 1059 */     playerGetBuffItemEffectiveToSelf(roleId, buffItemCfg, position, 4, 4);
/* 1060 */     if (BallBattleLogger.isDebugEnabled())
/*      */     {
/* 1062 */       BallBattleLogger.debug(String.format("BallBattleGameInstance.playerGetGhostItem()@done|sceneid=%d|roleid=%d", new Object[] { Integer.valueOf(this.sceneId), Long.valueOf(roleId) }));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void playerGetBuffItemEffectiveToSelf(final long roleId, final SBallBattleGroundItemCfg buffItemCfg, GroundItemPosition position, int type, final int state)
/*      */   {
/* 1078 */     PlayerInformation playerInformation = (PlayerInformation)this.playerInfos.get(Long.valueOf(roleId));
/* 1079 */     if (playerInformation == null)
/*      */     {
/* 1081 */       return;
/*      */     }
/* 1083 */     if (buffItemCfg.buff != 0)
/*      */     {
/* 1085 */       applyRoleBuff(roleId, buffItemCfg.buff, true);
/*      */     }
/* 1087 */     playerInformation.states.add(Integer.valueOf(state));
/* 1088 */     syncPlayerStatus(roleId);
/* 1089 */     notifyBuffEventToInSceneRoles(roleId, type, position.x, position.y);
/* 1090 */     newRoleRelatedSession(roleId, buffItemCfg.buffSeconds, new LogicRunnable()
/*      */     {
/*      */ 
/*      */       public void process()
/*      */       {
/* 1095 */         if (buffItemCfg.buff != 0)
/*      */         {
/* 1097 */           BallBattleGameInstance.this.removeRoleBuff(roleId, buffItemCfg.buff);
/*      */         }
/* 1099 */         state.states.remove(Integer.valueOf(this.val$state));
/* 1100 */         BallBattleGameInstance.this.syncPlayerStatus(roleId);
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void playerGetBuffItemEffectiveToOthers(final long roleId, SBallBattleGroundItemCfg buffItemCfg, final GroundItemPosition position, final int type, final int state)
/*      */   {
/* 1117 */     MapInterface.getRolesPosition(this.inSceneRoleIds, new MapCallback()
/*      */     {
/*      */ 
/*      */       public boolean isCallInProcedure()
/*      */       {
/* 1122 */         return false;
/*      */       }
/*      */       
/*      */ 
/*      */       public boolean onResult(final Map<Long, Position> result)
/*      */       {
/* 1128 */         BallBattleGameInstance.this.addTask(new LogicRunnable()
/*      */         {
/*      */ 
/*      */           public void process()
/*      */           {
/*      */ 
/* 1134 */             Position rolePosition = (Position)result.get(Long.valueOf(BallBattleGameInstance.18.this.val$roleId));
/* 1135 */             if (rolePosition == null)
/*      */             {
/* 1137 */               return;
/*      */             }
/* 1139 */             int radiusSquare = BallBattleGameInstance.18.this.val$buffItemCfg.buffRadius * BallBattleGameInstance.18.this.val$buffItemCfg.buffRadius;
/* 1140 */             Set<Long> affectedRoles = new HashSet();
/* 1141 */             for (Map.Entry<Long, Position> entry : result.entrySet())
/*      */             {
/* 1143 */               if ((((Long)entry.getKey()).longValue() != BallBattleGameInstance.18.this.val$roleId) && (BallBattleGameInstance.this.inSceneRoleIds.contains(entry.getKey())))
/*      */               {
/* 1145 */                 int distanceSquare = BallBattleGameInstance.this.getDistanceSquareBetweenPositions(rolePosition.getX(), rolePosition.getY(), ((Position)entry.getValue()).getX(), ((Position)entry.getValue()).getY());
/*      */                 
/*      */ 
/* 1148 */                 if (distanceSquare <= radiusSquare)
/*      */                 {
/* 1150 */                   affectedRoles.add(entry.getKey());
/*      */                 }
/*      */               }
/*      */             }
/*      */             
/*      */ 
/* 1156 */             for (final Long affectedRoleId : affectedRoles)
/*      */             {
/* 1158 */               final BallBattleGameInstance.PlayerInformation playerInformation = (BallBattleGameInstance.PlayerInformation)BallBattleGameInstance.this.playerInfos.get(affectedRoleId);
/* 1159 */               if (playerInformation != null)
/*      */               {
/*      */ 
/*      */ 
/* 1163 */                 if (BallBattleGameInstance.18.this.val$buffItemCfg.buff != 0)
/*      */                 {
/* 1165 */                   BallBattleGameInstance.this.applyRoleBuff(affectedRoleId.longValue(), BallBattleGameInstance.18.this.val$buffItemCfg.buff, true);
/*      */                 }
/* 1167 */                 playerInformation.states.add(Integer.valueOf(BallBattleGameInstance.18.this.val$state));
/* 1168 */                 BallBattleGameInstance.this.syncPlayerStatus(affectedRoleId.longValue());
/* 1169 */                 BallBattleGameInstance.this.newRoleRelatedSession(affectedRoleId.longValue(), BallBattleGameInstance.18.this.val$buffItemCfg.buffSeconds, new LogicRunnable()
/*      */                 {
/*      */ 
/*      */                   public void process()
/*      */                   {
/* 1174 */                     if (BallBattleGameInstance.18.this.val$buffItemCfg.buff != 0)
/*      */                     {
/* 1176 */                       BallBattleGameInstance.this.removeRoleBuff(affectedRoleId.longValue(), BallBattleGameInstance.18.this.val$buffItemCfg.buff);
/*      */                     }
/* 1178 */                     playerInformation.states.remove(Integer.valueOf(BallBattleGameInstance.18.this.val$state));
/* 1179 */                     BallBattleGameInstance.this.syncPlayerStatus(affectedRoleId.longValue());
/*      */                   }
/*      */                 });
/*      */               } }
/* 1183 */             BallBattleGameInstance.this.notifyBuffEventToInSceneRoles(BallBattleGameInstance.18.this.val$roleId, BallBattleGameInstance.18.this.val$type, BallBattleGameInstance.18.this.val$position.x, BallBattleGameInstance.18.this.val$position.y);
/*      */           }
/* 1185 */         });
/* 1186 */         return true;
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void killPlayer(final long roleId, boolean syncPlayerScoreInfoNow)
/*      */   {
/* 1199 */     PlayerInformation playerInformation = (PlayerInformation)this.playerInfos.get(Long.valueOf(roleId));
/* 1200 */     if (playerInformation == null)
/*      */     {
/* 1202 */       return;
/*      */     }
/*      */     
/* 1205 */     PlayerInformation.access$910(playerInformation);
/* 1206 */     PlayerInformation.access$708(playerInformation);
/* 1207 */     playerInformation.states.clear();
/*      */     
/* 1209 */     closeRoleRelatedSessions(roleId);
/*      */     
/* 1211 */     new LogicProcedure()
/*      */     {
/*      */ 
/*      */       protected boolean processImp()
/*      */       {
/* 1216 */         BallBattleGameInstance.this.removeAllThenApplyRoleBuff(roleId, BallBattleGameInstance.this.activityCfg.deathBuff);
/* 1217 */         return true;
/*      */       }
/*      */     }.call();
/*      */     
/*      */ 
/* 1222 */     if (playerInformation.life > 0)
/*      */     {
/* 1224 */       playerInformation.states.add(Integer.valueOf(-2));
/* 1225 */       newRoleRelatedSession(roleId, this.activityCfg.respawnSeconds, new LogicRunnable()
/*      */       {
/*      */ 
/*      */         public void process()
/*      */         {
/* 1230 */           BallBattleGameInstance.this.respawnPlayer(roleId);
/*      */         }
/*      */       });
/*      */     }
/*      */     else
/*      */     {
/* 1236 */       playerInformation.states.add(Integer.valueOf(-1));
/*      */     }
/* 1238 */     syncPlayerStatus(roleId);
/*      */     
/*      */ 
/* 1241 */     if (syncPlayerScoreInfoNow)
/*      */     {
/* 1243 */       syncPlayerScoreInfoToInSceneRoles();
/*      */     }
/*      */     
/*      */ 
/* 1247 */     if (getInSceneAliveRoleNumber() <= 1)
/*      */     {
/* 1249 */       addTask(new LogicRunnable()
/*      */       {
/*      */ 
/*      */         public void process()
/*      */         {
/* 1254 */           BallBattleGameInstance.this.onGameEnd();
/*      */         }
/*      */       });
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void respawnPlayer(final long roleId)
/*      */   {
/*      */     int x;
/*      */     
/*      */     int y;
/*      */     
/*      */     for (;;)
/*      */     {
/* 1269 */       int circleRadius = this.circleReduceCount < this.circleCfg.circles.size() ? ((SBallBattleCircleBean)this.circleCfg.circles.get(this.circleReduceCount)).circleRadius : ((SBallBattleCircleBean)this.circleCfg.circles.get(this.circleReduceCount - 1)).circleRadius;
/*      */       
/*      */ 
/* 1272 */       double theta = CommonUtils.random(0, 360) * 3.141592653589793D / 180.0D;
/* 1273 */       int radius = CommonUtils.random(0, circleRadius);
/* 1274 */       x = this.circleCfg.circleCenterX + (int)(radius * Math.cos(theta));
/* 1275 */       y = this.circleCfg.circleCenterY + (int)(radius * Math.sin(theta));
/* 1276 */       if (MapInterface.isReachable(this.activityCfg.gameMapId, x, y)) {
/*      */         break;
/*      */       }
/*      */     }
/*      */     
/* 1281 */     MapInterface.transferToScene(roleId, this.sceneId, x, y, new MapCallback()
/*      */     {
/*      */ 
/*      */       public boolean isCallInProcedure()
/*      */       {
/* 1286 */         return false;
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */       public boolean onResult(Boolean result)
/*      */       {
/* 1293 */         BallBattleGameInstance.this.addRoleRelatedTask(roleId, new LogicRunnable()
/*      */         {
/*      */ 
/*      */           public void process()
/*      */           {
/*      */ 
/* 1299 */             BallBattleGameInstance.this.removeRoleBuff(BallBattleGameInstance.22.this.val$roleId, BallBattleGameInstance.this.activityCfg.deathBuff);
/*      */             
/*      */ 
/* 1302 */             final BallBattleGameInstance.PlayerInformation playerInformation = (BallBattleGameInstance.PlayerInformation)BallBattleGameInstance.this.playerInfos.get(Long.valueOf(BallBattleGameInstance.22.this.val$roleId));
/* 1303 */             if (playerInformation == null)
/*      */             {
/* 1305 */               return;
/*      */             }
/* 1307 */             playerInformation.level = 1;
/* 1308 */             playerInformation.gene = 0;
/* 1309 */             playerInformation.states.remove(Integer.valueOf(-2));
/*      */             
/*      */ 
/* 1312 */             int speedOffset = ((SBallBattleLevelBean)BallBattleGameInstance.this.levelCfg.levels.get(0)).speedOffset;
/* 1313 */             MapInterface.addRoleSpeedFixAdded(BallBattleGameInstance.22.this.val$roleId, speedOffset - playerInformation.speedOffset, null);
/* 1314 */             playerInformation.speedOffset = speedOffset;
/*      */             
/*      */ 
/* 1317 */             playerInformation.states.add(Integer.valueOf(0));
/* 1318 */             BallBattleGameInstance.this.newRoleRelatedSession(BallBattleGameInstance.22.this.val$roleId, BallBattleGameInstance.this.activityCfg.initProtectSeconds, new LogicRunnable()
/*      */             {
/*      */ 
/*      */               public void process()
/*      */               {
/* 1323 */                 playerInformation.states.remove(Integer.valueOf(0));
/* 1324 */                 BallBattleGameInstance.this.syncPlayerStatus(BallBattleGameInstance.22.this.val$roleId);
/*      */               }
/*      */               
/* 1327 */             });
/* 1328 */             BallBattleGameInstance.this.syncPlayerStatus(BallBattleGameInstance.22.this.val$roleId);
/*      */           }
/* 1330 */         });
/* 1331 */         return true;
/*      */       }
/*      */     });
/*      */     
/* 1335 */     if (BallBattleLogger.isDebugEnabled())
/*      */     {
/* 1337 */       BallBattleLogger.debug(String.format("BallBattleGameInstance.respawnPlayer()@done|sceneid=%d|roleid=%d", new Object[] { Integer.valueOf(this.sceneId), Long.valueOf(roleId) }));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void playerLeaveGameScene(final long roleId, boolean sendNotification, boolean isForceLeave)
/*      */   {
/* 1370 */     role2instance.remove(Long.valueOf(roleId));
/*      */     
/*      */ 
/* 1373 */     this.inSceneRoleIds.remove(Long.valueOf(roleId));
/*      */     
/* 1375 */     PlayerInformation playerInformation = (PlayerInformation)this.playerInfos.get(Long.valueOf(roleId));
/* 1376 */     if (playerInformation == null)
/*      */     {
/* 1378 */       return;
/*      */     }
/*      */     
/*      */ 
/* 1382 */     MapInterface.addRoleSpeedFixAdded(roleId, -playerInformation.speedOffset, null);
/* 1383 */     playerInformation.speedOffset = 0;
/*      */     
/*      */ 
/* 1386 */     closeRoleRelatedSessions(roleId);
/*      */     
/*      */ 
/* 1389 */     removeAllRoleBuffs(roleId);
/*      */     
/*      */ 
/* 1392 */     MapInterface.unSetModelProtocol(roleId, 12629260);
/*      */     
/*      */ 
/* 1395 */     RoleOneByOneManager.getInstance().addLogicProcedure(Long.valueOf(roleId), new LogicProcedure()
/*      */     {
/*      */ 
/*      */       protected boolean processImp()
/*      */       {
/* 1400 */         RoleStatusInterface.unsetStatus(roleId, 2162);
/* 1401 */         return true;
/*      */       }
/*      */       
/*      */ 
/* 1405 */     });
/* 1406 */     Long mountInstanceId = (Long)this.role2mount.remove(Long.valueOf(roleId));
/* 1407 */     if (mountInstanceId != null)
/*      */     {
/* 1409 */       RoleOneByOneManager.getInstance().addLogicProcedure(Long.valueOf(roleId), new mzm.gsp.mounts.main.PCRideMounts(roleId, mountInstanceId.longValue()));
/*      */     }
/*      */     
/*      */ 
/* 1413 */     if ((this.isLastRound) || (isForceLeave))
/*      */     {
/* 1415 */       MapInterface.transferToScene(roleId, MapInterface.getCenterWorldid(), this.activityCfg.exitMapId);
/*      */     }
/*      */     else
/*      */     {
/* 1419 */       RoleOneByOneManager.getInstance().addLogicProcedure(Long.valueOf(roleId), new LogicProcedure()
/*      */       {
/*      */ 
/*      */         protected boolean processImp()
/*      */         {
/* 1424 */           if (BallBattleActivityManager.enterPrepareMap(roleId) == BallBattleActivityManager.EnterPrepareMapResult.SUCCESS)
/*      */           {
/*      */ 
/* 1427 */             return true;
/*      */           }
/*      */           
/* 1430 */           MapInterface.transferToScene(roleId, MapInterface.getCenterWorldid(), BallBattleGameInstance.this.activityCfg.exitMapId);
/* 1431 */           return false;
/*      */         }
/*      */       });
/*      */     }
/*      */     
/*      */ 
/* 1437 */     if (sendNotification)
/*      */     {
/* 1439 */       OnlineManager.getInstance().sendAtOnce(roleId, new mzm.gsp.ballbattle.SLeaveGameMapSuccess());
/*      */     }
/*      */     
/*      */ 
/* 1443 */     if (!this.gameOver)
/*      */     {
/* 1445 */       syncPlayerScoreInfoToInSceneRoles();
/*      */     }
/*      */     
/*      */ 
/* 1449 */     if ((!this.gameOver) && (this.inSceneRoleIds.size() <= 1))
/*      */     {
/* 1451 */       addTask(new LogicRunnable()
/*      */       {
/*      */ 
/*      */         public void process()
/*      */         {
/* 1456 */           BallBattleGameInstance.this.onGameEnd();
/*      */         }
/*      */       });
/*      */     }
/*      */     
/*      */ 
/* 1462 */     if ((this.gameOver) && (this.inSceneRoleIds.isEmpty()))
/*      */     {
/* 1464 */       addTaskIgnoringGameOver(new LogicRunnable()
/*      */       {
/*      */ 
/*      */         public void process()
/*      */         {
/* 1469 */           BallBattleGameInstance.this.onAllPlayerLeave();
/*      */         }
/*      */       });
/*      */     }
/*      */     
/* 1474 */     if (BallBattleLogger.isDebugEnabled())
/*      */     {
/* 1476 */       BallBattleLogger.debug(String.format("BallBattleGameInstance.playerLeaveGameScene()@done|sceneid=%d|roleid=%d", new Object[] { Integer.valueOf(this.sceneId), Long.valueOf(roleId) }));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void onPlayerLogout(final long roleId)
/*      */   {
/* 1487 */     role2instance.remove(Long.valueOf(roleId));
/*      */     
/*      */ 
/* 1490 */     this.inSceneRoleIds.remove(Long.valueOf(roleId));
/*      */     
/* 1492 */     PlayerInformation playerInformation = (PlayerInformation)this.playerInfos.get(Long.valueOf(roleId));
/* 1493 */     if (playerInformation == null)
/*      */     {
/* 1495 */       return;
/*      */     }
/*      */     
/*      */ 
/* 1499 */     MapInterface.addRoleSpeedFixAdded(roleId, -playerInformation.speedOffset, null);
/* 1500 */     playerInformation.speedOffset = 0;
/*      */     
/*      */ 
/* 1503 */     closeRoleRelatedSessions(roleId);
/*      */     
/*      */ 
/* 1506 */     removeAllRoleBuffs(roleId);
/*      */     
/*      */ 
/* 1509 */     MapInterface.unSetModelProtocol(roleId, 12629260);
/*      */     
/*      */ 
/* 1512 */     RoleOneByOneManager.getInstance().addLogicProcedure(Long.valueOf(roleId), new LogicProcedure()
/*      */     {
/*      */ 
/*      */       protected boolean processImp()
/*      */       {
/* 1517 */         RoleStatusInterface.unsetStatus(roleId, 2162);
/* 1518 */         return true;
/*      */       }
/*      */       
/*      */ 
/* 1522 */     });
/* 1523 */     MapInterface.forceTransferToScene(roleId, MapInterface.getCenterWorldid(), this.activityCfg.exitMapId);
/*      */     
/*      */ 
/* 1526 */     if (!this.gameOver)
/*      */     {
/* 1528 */       syncPlayerScoreInfoToInSceneRoles();
/*      */     }
/*      */     
/*      */ 
/* 1532 */     if ((!this.gameOver) && (this.inSceneRoleIds.size() <= 1))
/*      */     {
/* 1534 */       addTask(new LogicRunnable()
/*      */       {
/*      */ 
/*      */         public void process()
/*      */         {
/* 1539 */           BallBattleGameInstance.this.onGameEnd();
/*      */         }
/*      */       });
/*      */     }
/*      */     
/* 1544 */     if (BallBattleLogger.isDebugEnabled())
/*      */     {
/* 1546 */       BallBattleLogger.debug(String.format("BallBattleGameInstance.onPlayerLogout()@done|sceneid=%d|roleid=%d", new Object[] { Integer.valueOf(this.sceneId), Long.valueOf(roleId) }));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void onPlayerReconnect(long roleId)
/*      */   {
/* 1558 */     syncGameStatus(Collections.singleton(Long.valueOf(roleId)));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void onCollisionCheckQueryPlayerPosition()
/*      */   {
/* 1569 */     Set<Long> inSceneAliveRoles = new HashSet();
/* 1570 */     for (Long roleId : this.inSceneRoleIds)
/*      */     {
/* 1572 */       if (!isPlayerDead(roleId.longValue()))
/*      */       {
/* 1574 */         inSceneAliveRoles.add(roleId);
/*      */       }
/*      */     }
/* 1577 */     MapInterface.getRolesPosition(inSceneAliveRoles, new MapCallback()
/*      */     {
/*      */ 
/*      */       public boolean isCallInProcedure()
/*      */       {
/* 1582 */         return false;
/*      */       }
/*      */       
/*      */ 
/*      */       public boolean onResult(final Map<Long, Position> result)
/*      */       {
/* 1588 */         BallBattleGameInstance.this.addTask(new LogicRunnable()
/*      */         {
/*      */ 
/*      */           public void process()
/*      */           {
/* 1593 */             BallBattleGameInstance.this.onCollisionCheck(result);
/*      */           }
/* 1595 */         });
/* 1596 */         return true;
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void onCollisionCheck(Map<Long, Position> positions)
/*      */   {
/* 1609 */     List<Long> sortedRoleIds = new ArrayList();
/* 1610 */     for (Long roleId : this.inSceneRoleIds)
/*      */     {
/* 1612 */       if (!isPlayerDead(roleId.longValue()))
/*      */       {
/* 1614 */         sortedRoleIds.add(roleId);
/*      */       }
/*      */     }
/* 1617 */     Collections.sort(sortedRoleIds, new java.util.Comparator()
/*      */     {
/*      */ 
/*      */       public int compare(Long o1, Long o2)
/*      */       {
/* 1622 */         BallBattleGameInstance.PlayerInformation i1 = (BallBattleGameInstance.PlayerInformation)BallBattleGameInstance.this.playerInfos.get(o1);
/* 1623 */         BallBattleGameInstance.PlayerInformation i2 = (BallBattleGameInstance.PlayerInformation)BallBattleGameInstance.this.playerInfos.get(o2);
/* 1624 */         if ((i1 == null) || (i2 == null))
/*      */         {
/* 1626 */           return 0;
/*      */         }
/* 1628 */         return -(i1.level - i2.level);
/*      */       }
/*      */       
/*      */ 
/* 1632 */     });
/* 1633 */     boolean updatePlayerScoreInfo = false;
/* 1634 */     int alertDistanceSquare = this.activityCfg.alertRadius * this.activityCfg.alertRadius;
/* 1635 */     for (int i = 0; i < sortedRoleIds.size(); i++)
/*      */     {
/* 1637 */       boolean updatePlayerStatus = false;
/* 1638 */       final long roleId1 = ((Long)sortedRoleIds.get(i)).longValue();
/* 1639 */       if (!isPlayerDead(roleId1))
/*      */       {
/*      */ 
/*      */ 
/* 1643 */         Position position1 = (Position)positions.get(Long.valueOf(roleId1));
/* 1644 */         if (position1 != null)
/*      */         {
/*      */ 
/*      */ 
/* 1648 */           PlayerInformation playerInformation1 = (PlayerInformation)this.playerInfos.get(Long.valueOf(roleId1));
/* 1649 */           if (playerInformation1 != null)
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1655 */             if (!isInSafeCircle(position1.getX(), position1.getY()))
/*      */             {
/* 1657 */               killPlayer(roleId1, false);
/* 1658 */               notifyDeathEventToInSceneRoles(roleId1);
/* 1659 */               updatePlayerScoreInfo = true;
/* 1660 */               if (BallBattleLogger.isDebugEnabled())
/*      */               {
/* 1662 */                 BallBattleLogger.debug(String.format("BallBattleGameInstance.onCollisionCheck()@out of circle|sceneid=%d|roleid=%d", new Object[] { Integer.valueOf(this.sceneId), Long.valueOf(roleId1) }));
/*      */ 
/*      */               }
/*      */               
/*      */ 
/*      */ 
/*      */             }
/* 1669 */             else if ((!isPlayerProtected(roleId1)) && (!isPlayerHasGhostBuff(roleId1)))
/*      */             {
/*      */ 
/*      */ 
/*      */ 
/* 1674 */               for (int j = 1; j < sortedRoleIds.size(); j++)
/*      */               {
/* 1676 */                 long roleId2 = ((Long)sortedRoleIds.get(j)).longValue();
/* 1677 */                 if (!isPlayerDead(roleId2))
/*      */                 {
/*      */ 
/*      */ 
/* 1681 */                   Position position2 = (Position)positions.get(Long.valueOf(roleId2));
/* 1682 */                   if (position2 != null)
/*      */                   {
/*      */ 
/*      */ 
/* 1686 */                     PlayerInformation playerInformation2 = (PlayerInformation)this.playerInfos.get(Long.valueOf(roleId2));
/* 1687 */                     if (playerInformation2 != null)
/*      */                     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1693 */                       if ((playerInformation1.level != playerInformation2.level) && (!isPlayerProtected(roleId2)) && (!isPlayerHasGhostBuff(roleId2)))
/*      */                       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1699 */                         int a = (position1.getX() - position2.getX()) * (position1.getX() - position2.getX());
/* 1700 */                         int b = (position1.getY() - position2.getY()) * (position1.getY() - position2.getY());
/*      */                         
/*      */ 
/* 1703 */                         int collisionDistanceSquare = getPlayerCollisionDistanceSquare(playerInformation1.level, playerInformation2.level);
/*      */                         
/* 1705 */                         if (a + b <= collisionDistanceSquare)
/*      */                         {
/* 1707 */                           int collisionPosX = position1.getX() + (position1.getX() - position2.getX()) / 2;
/* 1708 */                           int collisionPosY = position1.getY() + (position1.getY() - position2.getY()) / 2;
/* 1709 */                           killPlayer(roleId1, roleId2, collisionPosX, collisionPosY);
/* 1710 */                           updatePlayerScoreInfo = true;
/* 1711 */                           updatePlayerStatus = true;
/* 1712 */                           if (BallBattleLogger.isDebugEnabled())
/*      */                           {
/* 1714 */                             BallBattleLogger.debug(String.format("BallBattleGameInstance.onCollisionCheck()@kill event|sceneid=%d|killer=%d|killed=%d", new Object[] { Integer.valueOf(this.sceneId), Long.valueOf(roleId1), Long.valueOf(roleId2) }));
/*      */ 
/*      */ 
/*      */                           }
/*      */                           
/*      */ 
/*      */ 
/*      */                         }
/* 1722 */                         else if ((a + b <= alertDistanceSquare) && (!isNearbyEnemyAlertIgnored(roleId1, roleId2)))
/*      */                         {
/* 1724 */                           markNearbyEnemyAlertIgnored(roleId1, roleId2);
/* 1725 */                           notifyNearbyEnemy(roleId1, roleId2);
/*      */                           
/* 1727 */                           newSession(this.activityCfg.alertCoolDownSeconds, new LogicRunnable()
/*      */                           {
/*      */ 
/*      */ 
/*      */                             public void process() {
/* 1732 */                               BallBattleGameInstance.this.unmarkNearbyEnemyAlertIgnored(roleId1, this.val$roleId2); }
/*      */                           });
/*      */                         }
/*      */                       } }
/*      */                   }
/*      */                 } }
/* 1738 */               if (updatePlayerStatus)
/*      */               {
/* 1740 */                 syncPlayerStatus(roleId1); }
/*      */             } }
/*      */         }
/*      */       } }
/* 1744 */     if (updatePlayerScoreInfo)
/*      */     {
/* 1746 */       syncPlayerScoreInfoToInSceneRoles();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void killPlayer(long killerRoleId, long killedRoleId, int collisionPosX, int collisionPosY)
/*      */   {
/* 1755 */     PlayerInformation killerInformation = (PlayerInformation)this.playerInfos.get(Long.valueOf(killerRoleId));
/* 1756 */     PlayerInformation killedInformation = (PlayerInformation)this.playerInfos.get(Long.valueOf(killedRoleId));
/* 1757 */     if ((killerInformation == null) || (killedInformation == null))
/*      */     {
/* 1759 */       return;
/*      */     }
/* 1761 */     int providedScore = ((SBallBattleLevelBean)this.levelCfg.levels.get(killedInformation.level - 1)).providedScore;
/* 1762 */     PlayerInformation.access$512(killerInformation, killerInformation.states.contains(Integer.valueOf(5)) ? providedScore * 2 : providedScore);
/*      */     
/* 1764 */     PlayerInformation.access$608(killerInformation);
/* 1765 */     killerInformation.scoreUpdateTime = ((int)(DateTimeUtils.getCurrTimeInMillis() / 1000L));
/*      */     
/* 1767 */     int providedGene = ((SBallBattleLevelBean)this.levelCfg.levels.get(killedInformation.level - 1)).providedGene;
/* 1768 */     addGeneToPlayer(killerRoleId, providedGene, false);
/*      */     
/* 1770 */     killPlayer(killedRoleId, false);
/*      */     
/* 1772 */     notifyKillEventToInSceneRoles(killerRoleId, killedRoleId, collisionPosX, collisionPosY);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getPlayerCollisionDistanceSquare(int level1, int level2)
/*      */   {
/* 1780 */     if ((level1 > this.levelCfg.levels.size()) || (level2 > this.levelCfg.levels.size()))
/*      */     {
/* 1782 */       return -1;
/*      */     }
/* 1784 */     int distance = ((SBallBattleLevelBean)this.levelCfg.levels.get(level1 - 1)).radius + ((SBallBattleLevelBean)this.levelCfg.levels.get(level2 - 1)).radius;
/* 1785 */     return distance * distance;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void onGeneItemRespawn()
/*      */   {
/* 1795 */     respawnGeneItems(false);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void onBuffItemRespawn()
/*      */   {
/* 1805 */     respawnBuffItems(false);
/* 1806 */     newSession(this.activityCfg.buffItemDisappearSeconds, new LogicRunnable()
/*      */     {
/*      */ 
/*      */       public void process()
/*      */       {
/* 1811 */         BallBattleGameInstance.this.destroyBuffItems();
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void respawnGeneItems(boolean avoidPlayer)
/*      */   {
/* 1824 */     int respawnNumber = this.circleReduceCount == 0 ? this.circleCfg.initGeneItemNumber : ((SBallBattleCircleBean)this.circleCfg.circles.get(this.circleReduceCount - 1)).geneItemNumber;
/*      */     
/* 1826 */     List<GroundItemPosition> ignoredPositions = new ArrayList();
/* 1827 */     for (int i = 0; (i < respawnNumber) && (!this.availableGroundItemPositions.isEmpty()); i++)
/*      */     {
/*      */       GroundItemPosition position;
/*      */       long roleInPosition;
/*      */       for (;;)
/*      */       {
/* 1833 */         if (this.availableGroundItemPositions.isEmpty()) {
/*      */           break label276;
/*      */         }
/*      */         
/* 1837 */         int index = CommonUtils.random(0, this.availableGroundItemPositions.size());
/* 1838 */         position = (GroundItemPosition)this.availableGroundItemPositions.remove(index);
/* 1839 */         roleInPosition = getRoleIdInGroundItemPosition(position);
/* 1840 */         if ((!avoidPlayer) || (roleInPosition == 0L)) {
/*      */           break;
/*      */         }
/*      */         
/* 1844 */         ignoredPositions.add(position);
/*      */       }
/*      */       
/*      */       boolean directGet;
/*      */       boolean directGet;
/* 1849 */       if (roleInPosition != 0L)
/*      */       {
/* 1851 */         directGet = !isPlayerDead(roleInPosition);
/*      */       }
/*      */       else
/*      */       {
/* 1855 */         directGet = false;
/*      */       }
/* 1857 */       if (directGet)
/*      */       {
/* 1859 */         playerGetGeneItem(roleInPosition, null);
/*      */       }
/*      */       else
/*      */       {
/* 1863 */         long entityInstanceId = mapEntityInstanceIdGenerator.getAndIncrement();
/* 1864 */         MapInterface.addMapEntity(MapEntityType.MET_BALL_BATTLE_GROUND_ITEM, entityInstanceId, this.worldId, this.activityCfg.gameMapId, position.x, position.y, this.activityCfg.geneItemCfgId, null, null, null, null);
/*      */         
/*      */ 
/*      */ 
/* 1868 */         this.geneItemPositions.add(position);
/* 1869 */         this.groundItemPosition2mapEntityInstance.put(position, Long.valueOf(entityInstanceId));
/*      */       } }
/*      */     label276:
/* 1872 */     this.availableGroundItemPositions.addAll(ignoredPositions);
/*      */     
/* 1874 */     if (BallBattleLogger.isDebugEnabled())
/*      */     {
/* 1876 */       BallBattleLogger.debug(String.format("BallBattleGameInstance.respawnGeneItems()@done|sceneid=%d", new Object[] { Integer.valueOf(this.sceneId) }));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void respawnBuffItems(boolean avoidPlayer)
/*      */   {
/* 1887 */     List<GroundItemPosition> ignoredPositions = new ArrayList();
/* 1888 */     for (int id = this.activityCfg.minBuffItemCfgId; 
/* 1889 */         (id <= this.activityCfg.maxBuffItemCfgId) && (!this.availableGroundItemPositions.isEmpty()); id++)
/*      */     {
/* 1891 */       if (!this.buffItemPositions.containsKey(Integer.valueOf(id)))
/*      */       {
/*      */         GroundItemPosition position;
/*      */         long roleInPosition;
/*      */         for (;;)
/*      */         {
/* 1897 */           if (this.availableGroundItemPositions.isEmpty()) {
/*      */             break label262;
/*      */           }
/*      */           
/* 1901 */           int index = CommonUtils.random(0, this.availableGroundItemPositions.size());
/* 1902 */           position = (GroundItemPosition)this.availableGroundItemPositions.remove(index);
/* 1903 */           roleInPosition = getRoleIdInGroundItemPosition(position);
/* 1904 */           if ((!avoidPlayer) || (roleInPosition == 0L)) {
/*      */             break;
/*      */           }
/*      */           
/* 1908 */           ignoredPositions.add(position);
/*      */         }
/*      */         
/*      */         boolean directGet;
/*      */         boolean directGet;
/* 1913 */         if (roleInPosition != 0L)
/*      */         {
/* 1915 */           directGet = !isPlayerDead(roleInPosition);
/*      */         }
/*      */         else
/*      */         {
/* 1919 */           directGet = false;
/*      */         }
/* 1921 */         if (directGet)
/*      */         {
/* 1923 */           playerGetBuffItem(roleInPosition, id, position);
/*      */         }
/*      */         else
/*      */         {
/* 1927 */           long entityInstanceId = mapEntityInstanceIdGenerator.getAndIncrement();
/* 1928 */           MapInterface.addMapEntity(MapEntityType.MET_BALL_BATTLE_GROUND_ITEM, entityInstanceId, this.worldId, this.activityCfg.gameMapId, position.x, position.y, id, null, null, null, null);
/*      */           
/* 1930 */           this.buffItemPositions.put(Integer.valueOf(id), position);
/* 1931 */           this.groundItemPosition2mapEntityInstance.put(position, Long.valueOf(entityInstanceId));
/*      */         }
/*      */       } }
/*      */     label262:
/* 1935 */     this.availableGroundItemPositions.addAll(ignoredPositions);
/*      */     
/* 1937 */     if (BallBattleLogger.isDebugEnabled())
/*      */     {
/* 1939 */       BallBattleLogger.debug(String.format("BallBattleGameInstance.respawnBuffItems()@done|sceneid=%d", new Object[] { Integer.valueOf(this.sceneId) }));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void destroyBuffItems()
/*      */   {
/* 1948 */     for (GroundItemPosition position : this.buffItemPositions.values())
/*      */     {
/* 1950 */       Long instanceId = (Long)this.groundItemPosition2mapEntityInstance.remove(position);
/* 1951 */       if (instanceId != null)
/*      */       {
/* 1953 */         MapInterface.removeMapEntity(MapEntityType.MET_BALL_BATTLE_GROUND_ITEM, instanceId.longValue(), null);
/*      */       }
/*      */     }
/* 1956 */     this.buffItemPositions.clear();
/* 1957 */     if (BallBattleLogger.isDebugEnabled())
/*      */     {
/* 1959 */       BallBattleLogger.debug(String.format("BallBattleGameInstance.destroyBuffItems()@done|sceneid=%d", new Object[] { Integer.valueOf(this.sceneId) }));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void destroyAllGroundItems()
/*      */   {
/* 1968 */     this.geneItemPositions.clear();
/* 1969 */     this.buffItemPositions.clear();
/* 1970 */     for (Long instanceId : this.groundItemPosition2mapEntityInstance.values())
/*      */     {
/* 1972 */       MapInterface.removeMapEntity(MapEntityType.MET_BALL_BATTLE_GROUND_ITEM, instanceId.longValue(), null);
/*      */     }
/* 1974 */     this.groundItemPosition2mapEntityInstance.clear();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void onCircleReduce()
/*      */   {
/* 1987 */     this.circleReduceCount += 1;
/* 1988 */     notifyCircleReduceEventToInSceneRoles();
/*      */     
/*      */ 
/* 1991 */     if (this.circleReduceCount < this.circleCfg.circles.size())
/*      */     {
/* 1993 */       SBallBattleCircleBean nextCircle = (SBallBattleCircleBean)this.circleCfg.circles.get(this.circleReduceCount);
/* 1994 */       this.nextCircleReduceTime = ((int)(DateTimeUtils.getCurrTimeInMillis() / 1000L) + nextCircle.circleReduceSeconds);
/* 1995 */       newSession(nextCircle.circleReduceSeconds, new LogicRunnable()
/*      */       {
/*      */ 
/*      */         public void process()
/*      */         {
/* 2000 */           BallBattleGameInstance.this.onCircleReduce();
/*      */         }
/*      */       });
/*      */     }
/*      */     
/*      */ 
/* 2006 */     Iterator<GroundItemPosition> iterator = this.availableGroundItemPositions.iterator();
/* 2007 */     while (iterator.hasNext())
/*      */     {
/* 2009 */       GroundItemPosition position = (GroundItemPosition)iterator.next();
/* 2010 */       if (!isInSafeCircle(position.x, position.y))
/*      */       {
/* 2012 */         iterator.remove();
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 2017 */     Set<GroundItemPosition> invalidGroundItemPositions = new HashSet();
/* 2018 */     for (GroundItemPosition position : this.geneItemPositions)
/*      */     {
/* 2020 */       if (!isInSafeCircle(position.x, position.y))
/*      */       {
/* 2022 */         invalidGroundItemPositions.add(position);
/*      */       }
/*      */     }
/* 2025 */     this.geneItemPositions.removeAll(invalidGroundItemPositions);
/* 2026 */     Set<Integer> invalidBuffItemIds = new HashSet();
/* 2027 */     for (Map.Entry<Integer, GroundItemPosition> entry : this.buffItemPositions.entrySet())
/*      */     {
/* 2029 */       if (!isInSafeCircle(((GroundItemPosition)entry.getValue()).x, ((GroundItemPosition)entry.getValue()).y))
/*      */       {
/* 2031 */         invalidBuffItemIds.add(entry.getKey());
/*      */       }
/*      */     }
/* 2034 */     for (Integer buffItemId : invalidBuffItemIds)
/*      */     {
/* 2036 */       invalidGroundItemPositions.add(this.buffItemPositions.remove(buffItemId));
/*      */     }
/* 2038 */     for (GroundItemPosition position : invalidGroundItemPositions)
/*      */     {
/* 2040 */       Long instanceId = (Long)this.groundItemPosition2mapEntityInstance.remove(position);
/* 2041 */       if (instanceId != null)
/*      */       {
/* 2043 */         MapInterface.removeMapEntity(MapEntityType.MET_BALL_BATTLE_GROUND_ITEM, instanceId.longValue(), null);
/*      */       }
/*      */     }
/*      */     
/* 2047 */     if (BallBattleLogger.isDebugEnabled())
/*      */     {
/* 2049 */       BallBattleLogger.debug(String.format("BallBattleGameInstance.onCircleReduce()@done|sceneid=%d", new Object[] { Integer.valueOf(this.sceneId) }));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean isInSafeCircle(int x, int y)
/*      */   {
/* 2058 */     int radius = this.circleReduceCount == 0 ? this.circleCfg.initRadius : ((SBallBattleCircleBean)this.circleCfg.circles.get(this.circleReduceCount - 1)).circleRadius;
/*      */     
/* 2060 */     int a = (x - this.circleCfg.circleCenterX) * (x - this.circleCfg.circleCenterX);
/* 2061 */     int b = (y - this.circleCfg.circleCenterY) * (y - this.circleCfg.circleCenterY);
/* 2062 */     return a + b <= radius * radius;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getDistanceSquareBetweenPositions(int x1, int y1, int x2, int y2)
/*      */   {
/* 2070 */     int a = (x1 - x2) * (x1 - x2);
/* 2071 */     int b = (y1 - y2) * (y1 - y2);
/* 2072 */     return a + b;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private long getRoleIdInGroundItemPosition(GroundItemPosition position)
/*      */   {
/* 2081 */     for (Long roleId : this.inSceneRoleIds)
/*      */     {
/* 2083 */       if (position.equals(this.role2groundItemPositions.get(roleId)))
/*      */       {
/* 2085 */         return roleId.longValue();
/*      */       }
/*      */     }
/* 2088 */     return 0L;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getInSceneAliveRoleNumber()
/*      */   {
/* 2098 */     int count = 0;
/* 2099 */     for (Long roleId : this.inSceneRoleIds)
/*      */     {
/* 2101 */       if (((PlayerInformation)this.playerInfos.get(roleId)).life > 0)
/*      */       {
/* 2103 */         count++;
/*      */       }
/*      */     }
/* 2106 */     return count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean isPlayerHasState(long roleId, int state)
/*      */   {
/* 2116 */     PlayerInformation playerInformation = (PlayerInformation)this.playerInfos.get(Long.valueOf(roleId));
/* 2117 */     if (playerInformation == null)
/*      */     {
/* 2119 */       return false;
/*      */     }
/* 2121 */     return playerInformation.states.contains(Integer.valueOf(state));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean isPlayerDead(long roleId)
/*      */   {
/* 2129 */     return (isPlayerHasState(roleId, -1)) || (isPlayerHasState(roleId, -2));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean isPlayerProtected(long roleId)
/*      */   {
/* 2137 */     return isPlayerHasState(roleId, 0);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean isPlayerHasGhostBuff(long roleId)
/*      */   {
/* 2145 */     return isPlayerHasState(roleId, 4);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean isNearbyEnemyAlertIgnored(long roleId1, long roleId2)
/*      */   {
/* 2153 */     Set<Long> ignoredSet = (Set)this.ignoredNearbyEnemyAlerts.get(Long.valueOf(roleId1));
/* 2154 */     if (ignoredSet == null)
/*      */     {
/* 2156 */       return false;
/*      */     }
/* 2158 */     return ignoredSet.contains(Long.valueOf(roleId2));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void markNearbyEnemyAlertIgnored(long roleId1, long roleId2)
/*      */   {
/* 2166 */     Set<Long> ignoredSet1 = (Set)this.ignoredNearbyEnemyAlerts.get(Long.valueOf(roleId1));
/* 2167 */     if (ignoredSet1 == null)
/*      */     {
/* 2169 */       ignoredSet1 = new HashSet();
/* 2170 */       this.ignoredNearbyEnemyAlerts.put(Long.valueOf(roleId1), ignoredSet1);
/*      */     }
/* 2172 */     ignoredSet1.add(Long.valueOf(roleId2));
/*      */     
/* 2174 */     Set<Long> ignoredSet2 = (Set)this.ignoredNearbyEnemyAlerts.get(Long.valueOf(roleId2));
/* 2175 */     if (ignoredSet2 == null)
/*      */     {
/* 2177 */       ignoredSet2 = new HashSet();
/* 2178 */       this.ignoredNearbyEnemyAlerts.put(Long.valueOf(roleId2), ignoredSet2);
/*      */     }
/* 2180 */     ignoredSet2.add(Long.valueOf(roleId1));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void unmarkNearbyEnemyAlertIgnored(long roleId1, long roleId2)
/*      */   {
/* 2188 */     Set<Long> ignoreSet1 = (Set)this.ignoredNearbyEnemyAlerts.get(Long.valueOf(roleId1));
/* 2189 */     if (ignoreSet1 != null)
/*      */     {
/* 2191 */       ignoreSet1.remove(Long.valueOf(roleId2));
/*      */     }
/*      */     
/* 2194 */     Set<Long> ignoreSet2 = (Set)this.ignoredNearbyEnemyAlerts.get(Long.valueOf(roleId2));
/* 2195 */     if (ignoreSet2 != null)
/*      */     {
/* 2197 */       ignoreSet2.remove(Long.valueOf(roleId1));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void applyRoleBuff(long roleId, int buffId, boolean async)
/*      */   {
/* 2206 */     Set<Integer> buffs = (Set)this.role2buffs.get(Long.valueOf(roleId));
/* 2207 */     if (buffs == null)
/*      */     {
/* 2209 */       buffs = new HashSet();
/* 2210 */       this.role2buffs.put(Long.valueOf(roleId), buffs);
/*      */     }
/* 2212 */     buffs.add(Integer.valueOf(buffId));
/* 2213 */     if (async)
/*      */     {
/* 2215 */       BuffInterface.installBuffAsyc(roleId, buffId);
/*      */     }
/*      */     else
/*      */     {
/* 2219 */       BuffInterface.installBuff(roleId, buffId);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void removeRoleBuff(long roleId, int buffId)
/*      */   {
/* 2228 */     Set<Integer> buffs = (Set)this.role2buffs.get(Long.valueOf(roleId));
/* 2229 */     if (buffs == null)
/*      */     {
/* 2231 */       return;
/*      */     }
/* 2233 */     if (!buffs.remove(Integer.valueOf(buffId)))
/*      */     {
/* 2235 */       return;
/*      */     }
/* 2237 */     BuffInterface.uninstallBufAsyc(roleId, buffId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void removeAllRoleBuffs(long roleId)
/*      */   {
/* 2245 */     Set<Integer> buffs = (Set)this.role2buffs.get(Long.valueOf(roleId));
/* 2246 */     if (buffs == null)
/*      */     {
/* 2248 */       return;
/*      */     }
/* 2250 */     for (Integer buffId : buffs)
/*      */     {
/* 2252 */       BuffInterface.uninstallBufAsyc(roleId, buffId.intValue());
/*      */     }
/* 2254 */     buffs.clear();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void removeAllThenApplyRoleBuff(long roleId, int buffId)
/*      */   {
/* 2262 */     Set<Integer> buffs = (Set)this.role2buffs.get(Long.valueOf(roleId));
/* 2263 */     if (buffs == null)
/*      */     {
/* 2265 */       return;
/*      */     }
/* 2267 */     for (Integer buff : buffs)
/*      */     {
/* 2269 */       BuffInterface.uninstallBuf(roleId, buff.intValue());
/*      */     }
/* 2271 */     buffs.clear();
/* 2272 */     BuffInterface.installBuff(roleId, buffId);
/* 2273 */     buffs.add(Integer.valueOf(buffId));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void addTask(final LogicRunnable logicRunnable)
/*      */   {
/* 2283 */     this.executor.add(new LogicRunnable()
/*      */     {
/*      */       public void process()
/*      */         throws Exception
/*      */       {
/* 2288 */         if (!BallBattleGameInstance.this.gameOver)
/*      */         {
/* 2290 */           logicRunnable.process();
/*      */         }
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void addTaskIgnoringGameOver(LogicRunnable logicRunnable)
/*      */   {
/* 2301 */     this.executor.add(logicRunnable);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void addTaskIgnoringGameOver(LogicProcedure logicProcedure)
/*      */   {
/* 2309 */     this.executor.add(logicProcedure);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void addRoleRelatedTask(final long roleId, LogicRunnable logicRunnable)
/*      */   {
/* 2317 */     this.executor.add(new LogicRunnable()
/*      */     {
/*      */       public void process()
/*      */         throws Exception
/*      */       {
/* 2322 */         if ((!BallBattleGameInstance.this.gameOver) && (BallBattleGameInstance.this.inSceneRoleIds.contains(Long.valueOf(roleId))))
/*      */         {
/* 2324 */           this.val$logicRunnable.process();
/*      */         }
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void addRoleRelatedTaskIgnoringGameOver(final long roleId, LogicRunnable logicRunnable)
/*      */   {
/* 2335 */     this.executor.add(new LogicRunnable()
/*      */     {
/*      */       public void process()
/*      */         throws Exception
/*      */       {
/* 2340 */         if (BallBattleGameInstance.this.inSceneRoleIds.contains(Long.valueOf(roleId)))
/*      */         {
/* 2342 */           this.val$logicRunnable.process();
/*      */         }
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void newSession(int seconds, LogicRunnable logicRunnable)
/*      */   {
/* 2353 */     new Session(seconds, 0L)
/*      */     {
/*      */ 
/*      */       protected void onTimeOut()
/*      */       {
/* 2358 */         BallBattleGameInstance.this.addTask(new LogicRunnable()
/*      */         {
/*      */           public void process()
/*      */             throws Exception
/*      */           {
/* 2363 */             if (!BallBattleGameInstance.this.gameOver)
/*      */             {
/* 2365 */               BallBattleGameInstance.37.this.val$logicRunnable.process();
/*      */             }
/*      */           }
/*      */         });
/*      */       }
/*      */     };
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void newSessionIgnoringGameOver(int seconds, LogicRunnable logicRunnable)
/*      */   {
/* 2378 */     new Session(seconds, 0L)
/*      */     {
/*      */ 
/*      */       protected void onTimeOut()
/*      */       {
/* 2383 */         BallBattleGameInstance.this.addTaskIgnoringGameOver(this.val$logicRunnable);
/*      */       }
/*      */     };
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void newMilliSessionIgnoringGameOver(int milliseconds, LogicRunnable logicRunnable)
/*      */   {
/* 2393 */     new MilliSession(milliseconds, 0L)
/*      */     {
/*      */ 
/*      */       protected void onTimeOut()
/*      */       {
/* 2398 */         BallBattleGameInstance.this.addTaskIgnoringGameOver(this.val$logicRunnable);
/*      */       }
/*      */     };
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void newRoleRelatedSession(long roleId, int seconds, LogicRunnable logicRunnable)
/*      */   {
/* 2410 */     Session session = new Session(seconds, roleId)
/*      */     {
/*      */ 
/*      */       protected void onTimeOut()
/*      */       {
/* 2415 */         final long sessionId = getSessionId();
/* 2416 */         BallBattleGameInstance.this.addRoleRelatedTask(this.val$roleId, new LogicRunnable()
/*      */         {
/*      */           public void process()
/*      */             throws Exception
/*      */           {
/* 2421 */             BallBattleGameInstance.this.unmarkRoleRelatedSession(BallBattleGameInstance.40.this.val$roleId, sessionId);
/* 2422 */             BallBattleGameInstance.40.this.val$logicRunnable.process();
/*      */           }
/*      */         });
/*      */       }
/* 2426 */     };
/* 2427 */     markRoleRelatedSession(roleId, session.getSessionId());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void markRoleRelatedSession(long roleId, long sessionId)
/*      */   {
/* 2435 */     Set<Long> sessionIds = (Set)this.role2sessions.get(Long.valueOf(roleId));
/* 2436 */     if (sessionIds == null)
/*      */     {
/* 2438 */       sessionIds = new HashSet();
/* 2439 */       this.role2sessions.put(Long.valueOf(roleId), sessionIds);
/*      */     }
/* 2441 */     sessionIds.add(Long.valueOf(sessionId));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void unmarkRoleRelatedSession(long roleId, long sessionId)
/*      */   {
/* 2449 */     Set<Long> sessionIds = (Set)this.role2sessions.get(Long.valueOf(roleId));
/* 2450 */     if (sessionIds != null)
/*      */     {
/* 2452 */       sessionIds.remove(Long.valueOf(sessionId));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void closeRoleRelatedSessions(long roleId)
/*      */   {
/* 2461 */     Set<Long> sessionIds = (Set)this.role2sessions.get(Long.valueOf(roleId));
/* 2462 */     if (sessionIds != null)
/*      */     {
/* 2464 */       for (Long sessionId : sessionIds)
/*      */       {
/* 2466 */         Session.removeSession(sessionId.longValue(), roleId);
/*      */       }
/* 2468 */       sessionIds.clear();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void syncPlayerStatus(long roleId)
/*      */   {
/* 2481 */     PlayerInformation playerInformation = (PlayerInformation)this.playerInfos.get(Long.valueOf(roleId));
/* 2482 */     if (playerInformation == null)
/*      */     {
/* 2484 */       return;
/*      */     }
/* 2486 */     SBallBattlePlayerStatus sBallBattlePlayerStatus = new SBallBattlePlayerStatus();
/* 2487 */     sBallBattlePlayerStatus.status.level = playerInformation.level;
/* 2488 */     sBallBattlePlayerStatus.status.gene = playerInformation.gene;
/* 2489 */     sBallBattlePlayerStatus.status.states.addAll(playerInformation.states);
/* 2490 */     MapInterface.setModelProtocol(roleId, sBallBattlePlayerStatus);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void syncGameStatusToInSceneRoles()
/*      */   {
/* 2498 */     syncGameStatus(this.inSceneRoleIds);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void syncGameStatus(Collection<Long> roleIds)
/*      */   {
/* 2506 */     SSyncGameStatus syncGameStatus = new SSyncGameStatus();
/* 2507 */     syncGameStatus.status.start_time = this.startTime;
/* 2508 */     syncGameStatus.status.stop_time = this.endTime;
/* 2509 */     syncGameStatus.status.circle_reduce_count = this.circleReduceCount;
/* 2510 */     syncGameStatus.status.next_circle_reduce_time = this.nextCircleReduceTime;
/* 2511 */     for (Map.Entry<Long, PlayerInformation> entry : this.playerInfos.entrySet())
/*      */     {
/* 2513 */       long roleId = ((Long)entry.getKey()).longValue();
/*      */       try
/*      */       {
/* 2516 */         Octets name = new Octets();
/* 2517 */         name.setString(RoleInterface.getName(roleId), "UTF-8");
/* 2518 */         syncGameStatus.status.player_names.put(Long.valueOf(roleId), name);
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e) {}
/*      */       
/*      */ 
/*      */ 
/* 2524 */       PlayerInformation playerInformation = (PlayerInformation)entry.getValue();
/* 2525 */       PlayerScoreInfo playerScoreInfo = new PlayerScoreInfo();
/* 2526 */       playerScoreInfo.score = playerInformation.score;
/* 2527 */       playerScoreInfo.kill = playerInformation.killCount;
/* 2528 */       playerScoreInfo.death = playerInformation.deathCount;
/* 2529 */       playerScoreInfo.update_time = playerInformation.scoreUpdateTime;
/* 2530 */       playerScoreInfo.in_game_scene = (this.inSceneRoleIds.contains(Long.valueOf(roleId)) ? 1 : 0);
/* 2531 */       syncGameStatus.status.player_score_infos.put(Long.valueOf(roleId), playerScoreInfo);
/*      */     }
/* 2533 */     OnlineManager.getInstance().sendMultiAtOnce(syncGameStatus, roleIds);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void syncPlayerScoreInfoToInSceneRoles()
/*      */   {
/* 2541 */     SSyncPlayerScoreInfo syncPlayerScoreInfo = new SSyncPlayerScoreInfo();
/* 2542 */     for (Map.Entry<Long, PlayerInformation> entry : this.playerInfos.entrySet())
/*      */     {
/* 2544 */       long roleId = ((Long)entry.getKey()).longValue();
/* 2545 */       PlayerInformation playerInformation = (PlayerInformation)entry.getValue();
/* 2546 */       PlayerScoreInfo playerScoreInfo = new PlayerScoreInfo();
/* 2547 */       playerScoreInfo.score = playerInformation.score;
/* 2548 */       playerScoreInfo.kill = playerInformation.killCount;
/* 2549 */       playerScoreInfo.death = playerInformation.deathCount;
/* 2550 */       playerScoreInfo.update_time = playerInformation.scoreUpdateTime;
/* 2551 */       playerScoreInfo.in_game_scene = (this.inSceneRoleIds.contains(Long.valueOf(roleId)) ? 1 : 0);
/* 2552 */       syncPlayerScoreInfo.player_score_infos.put(Long.valueOf(roleId), playerScoreInfo);
/*      */     }
/* 2554 */     OnlineManager.getInstance().sendMultiAtOnce(syncPlayerScoreInfo, this.inSceneRoleIds);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void notifyGameEndedToInSceneRoles()
/*      */   {
/* 2562 */     SNotifyGameEnded notification = new SNotifyGameEnded();
/* 2563 */     for (Map.Entry<Long, PlayerInformation> entry : this.playerInfos.entrySet())
/*      */     {
/* 2565 */       long roleId = ((Long)entry.getKey()).longValue();
/* 2566 */       PlayerInformation playerInformation = (PlayerInformation)entry.getValue();
/* 2567 */       PlayerScoreInfo playerScoreInfo = new PlayerScoreInfo();
/* 2568 */       playerScoreInfo.score = playerInformation.score;
/* 2569 */       playerScoreInfo.kill = playerInformation.killCount;
/* 2570 */       playerScoreInfo.death = playerInformation.deathCount;
/* 2571 */       playerScoreInfo.update_time = playerInformation.scoreUpdateTime;
/* 2572 */       playerScoreInfo.in_game_scene = (this.inSceneRoleIds.contains(Long.valueOf(roleId)) ? 1 : 0);
/* 2573 */       notification.player_score_infos.put(Long.valueOf(roleId), playerScoreInfo);
/*      */     }
/* 2575 */     OnlineManager.getInstance().sendMultiAtOnce(notification, this.inSceneRoleIds);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void notifyCircleReduceEventToInSceneRoles()
/*      */   {
/* 2583 */     SNotifyCircleReduceEvent notification = new SNotifyCircleReduceEvent();
/* 2584 */     notification.circle_number = this.circleReduceCount;
/* 2585 */     OnlineManager.getInstance().sendMultiAtOnce(notification, this.inSceneRoleIds);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void notifyKillEventToInSceneRoles(long killerRoleId, long killedRoleId, int collisionPosX, int collisionPosY)
/*      */   {
/* 2594 */     SNotifyKillEvent notification = new SNotifyKillEvent();
/* 2595 */     notification.killer_role_id = killerRoleId;
/* 2596 */     notification.killer_avatar_id = mzm.gsp.avatar.main.AvatarInterface.getCurrentAvatar(killerRoleId, false);
/* 2597 */     notification.killer_avatar_frame_id = mzm.gsp.avatar.frame.AvatarFrameInterface.getCurrentAvatarFrameId(killerRoleId, false);
/* 2598 */     notification.killed_role_id = killedRoleId;
/* 2599 */     notification.killed_avatar_id = mzm.gsp.avatar.main.AvatarInterface.getCurrentAvatar(killedRoleId, false);
/* 2600 */     notification.killed_avatar_frame_id = mzm.gsp.avatar.frame.AvatarFrameInterface.getCurrentAvatarFrameId(killedRoleId, false);
/* 2601 */     notification.position_x = collisionPosX;
/* 2602 */     notification.position_y = collisionPosY;
/* 2603 */     OnlineManager.getInstance().sendMultiAtOnce(notification, this.inSceneRoleIds);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void notifyDeathEventToInSceneRoles(long deadRoleId)
/*      */   {
/* 2611 */     SNotifyKillEvent notification = new SNotifyKillEvent();
/* 2612 */     notification.killed_role_id = deadRoleId;
/* 2613 */     OnlineManager.getInstance().sendMultiAtOnce(notification, this.inSceneRoleIds);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void notifyMaxLevelEventToInSceneRoles(long roleId, int levelResetTime)
/*      */   {
/* 2621 */     SNotifyMaxLevelEvent notification = new SNotifyMaxLevelEvent();
/* 2622 */     notification.role_id = roleId;
/* 2623 */     notification.level_reset_time = levelResetTime;
/* 2624 */     OnlineManager.getInstance().sendMultiAtOnce(notification, this.inSceneRoleIds);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void notifyBuffEventToInSceneRoles(long roleId, int buffType, int x, int y)
/*      */   {
/* 2632 */     SNotifyBuffEvent notification = new SNotifyBuffEvent();
/* 2633 */     notification.role_id = roleId;
/* 2634 */     notification.buff_type = buffType;
/* 2635 */     notification.position_x = x;
/* 2636 */     notification.position_y = y;
/* 2637 */     OnlineManager.getInstance().sendMultiAtOnce(notification, this.inSceneRoleIds);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void notifyNearbyEnemy(long higherLevelRoleId, long lowerLevelRoleId)
/*      */   {
/* 2645 */     SNotifyNearbyEnemy notificationForHigherLevelRole = new SNotifyNearbyEnemy();
/* 2646 */     notificationForHigherLevelRole.role_id = lowerLevelRoleId;
/* 2647 */     notificationForHigherLevelRole.is_level_higher = 0;
/* 2648 */     OnlineManager.getInstance().sendAtOnce(higherLevelRoleId, notificationForHigherLevelRole);
/*      */     
/* 2650 */     SNotifyNearbyEnemy notificationForLowerLevelRole = new SNotifyNearbyEnemy();
/* 2651 */     notificationForLowerLevelRole.role_id = higherLevelRoleId;
/* 2652 */     notificationForLowerLevelRole.is_level_higher = 1;
/* 2653 */     OnlineManager.getInstance().sendAtOnce(lowerLevelRoleId, notificationForLowerLevelRole);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void tlogPlayGame(long roleId)
/*      */   {
/* 2663 */     String userId = RoleInterface.getUserId(roleId);
/* 2664 */     if (userId == null)
/* 2665 */       return;
/* 2666 */     List<Object> list = new ArrayList();
/* 2667 */     list.add(GameServerInfoManager.getHostIP());
/* 2668 */     list.add(userId);
/* 2669 */     list.add(Long.valueOf(roleId));
/* 2670 */     list.add(Integer.valueOf(RoleInterface.getLevel(roleId)));
/* 2671 */     list.add(Integer.valueOf(this.activityCfg.activityId));
/* 2672 */     TLogManager.getInstance().addLog(userId, "BallBattlePlayGame", list.toArray());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void tlogGetAward(long roleId, int rank)
/*      */   {
/* 2680 */     String userId = RoleInterface.getUserId(roleId);
/* 2681 */     if (userId == null)
/* 2682 */       return;
/* 2683 */     List<Object> list = new ArrayList();
/* 2684 */     list.add(GameServerInfoManager.getHostIP());
/* 2685 */     list.add(userId);
/* 2686 */     list.add(Long.valueOf(roleId));
/* 2687 */     list.add(Integer.valueOf(RoleInterface.getLevel(roleId)));
/* 2688 */     list.add(Integer.valueOf(this.activityCfg.activityId));
/* 2689 */     list.add(Integer.valueOf(rank));
/* 2690 */     TLogManager.getInstance().addLog(userId, "BallBattleAward", list.toArray());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private class ZoneEventRegisterCallback
/*      */     implements MapCallback<Integer>
/*      */   {
/*      */     private ZoneEventRegisterCallback() {}
/*      */     
/*      */ 
/*      */     public boolean isCallInProcedure()
/*      */     {
/* 2703 */       return false;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean onResult(Integer zoneEventId)
/*      */     {
/* 2709 */       synchronized (BallBattleGameInstance.this.zoneEventIds)
/*      */       {
/* 2711 */         BallBattleGameInstance.this.zoneEventIds.add(zoneEventId);
/*      */       }
/* 2713 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static class GroundItemPosition
/*      */   {
/*      */     private final int x;
/*      */     
/*      */ 
/*      */     private final int y;
/*      */     
/*      */ 
/*      */     private GroundItemPosition(SGroundItemPosition sGroundItemPosition)
/*      */     {
/* 2729 */       this.x = sGroundItemPosition.x;
/* 2730 */       this.y = sGroundItemPosition.y;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object o)
/*      */     {
/* 2736 */       if (this == o)
/*      */       {
/* 2738 */         return true;
/*      */       }
/* 2740 */       if ((o instanceof GroundItemPosition))
/*      */       {
/* 2742 */         GroundItemPosition that = (GroundItemPosition)o;
/* 2743 */         return (this.x == that.x) && (this.y == that.y);
/*      */       }
/* 2745 */       return false;
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 2751 */       int result = 17;
/* 2752 */       result = result * 31 + this.x;
/* 2753 */       result = result * 31 + this.y;
/* 2754 */       return result;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private static class GroundItemZone
/*      */     extends mzm.gsp.map.main.scene.zone.bounding.CylinderBounding
/*      */   {
/*      */     private final BallBattleGameInstance.GroundItemPosition position;
/*      */     
/*      */ 
/*      */     private GroundItemZone(BallBattleGameInstance.GroundItemPosition position, int radius)
/*      */     {
/* 2767 */       super(BallBattleGameInstance.GroundItemPosition.access$3700(position), 0, radius);
/* 2768 */       this.position = position;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private class GroundItemZoneListener
/*      */     implements mzm.gsp.map.main.scene.zone.type.event.IZoneListener
/*      */   {
/*      */     private GroundItemZoneListener() {}
/*      */     
/*      */     public void onEnterRole(final long roleId, ZoneForm zoneForm)
/*      */     {
/* 2780 */       if (!(zoneForm instanceof BallBattleGameInstance.GroundItemZone))
/*      */       {
/* 2782 */         return;
/*      */       }
/* 2784 */       BallBattleGameInstance.GroundItemPosition position = BallBattleGameInstance.GroundItemZone.access$5200((BallBattleGameInstance.GroundItemZone)zoneForm);
/* 2785 */       BallBattleGameInstance.this.addRoleRelatedTask(roleId, new LogicRunnable()
/*      */       {
/*      */ 
/*      */         public void process()
/*      */         {
/* 2790 */           BallBattleGameInstance.this.onPlayerEnterGroundItemPosition(roleId, this.val$position);
/*      */         }
/*      */       });
/*      */     }
/*      */     
/*      */ 
/*      */     public void onLeaveRole(final long roleId, ZoneForm zoneForm)
/*      */     {
/* 2798 */       BallBattleGameInstance.this.addRoleRelatedTask(roleId, new LogicRunnable()
/*      */       {
/*      */ 
/*      */         public void process()
/*      */         {
/* 2803 */           BallBattleGameInstance.this.onPlayerLeaveGroundItemPosition(roleId);
/*      */         }
/*      */       });
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private class CollisionObserver
/*      */     extends MilliObserver
/*      */   {
/*      */     private CollisionObserver(long milliseconds)
/*      */     {
/* 2818 */       super();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean update()
/*      */     {
/* 2824 */       if (!BallBattleGameInstance.this.gameOver)
/*      */       {
/* 2826 */         BallBattleGameInstance.this.addTask(new LogicRunnable()
/*      */         {
/*      */ 
/*      */           public void process()
/*      */           {
/* 2831 */             BallBattleGameInstance.this.onCollisionCheckQueryPlayerPosition();
/*      */           }
/* 2833 */         });
/* 2834 */         return true;
/*      */       }
/* 2836 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private class GeneItemRespawnObserver
/*      */     extends Observer
/*      */   {
/*      */     private GeneItemRespawnObserver(long seconds)
/*      */     {
/* 2847 */       super();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean update()
/*      */     {
/* 2853 */       if (!BallBattleGameInstance.this.gameOver)
/*      */       {
/* 2855 */         BallBattleGameInstance.this.addTask(new LogicRunnable()
/*      */         {
/*      */ 
/*      */           public void process()
/*      */           {
/* 2860 */             BallBattleGameInstance.this.onGeneItemRespawn();
/*      */           }
/* 2862 */         });
/* 2863 */         return true;
/*      */       }
/* 2865 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private class BuffItemRespawnObserver
/*      */     extends Observer
/*      */   {
/*      */     private BuffItemRespawnObserver(long seconds)
/*      */     {
/* 2876 */       super();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean update()
/*      */     {
/* 2882 */       if (!BallBattleGameInstance.this.gameOver)
/*      */       {
/* 2884 */         BallBattleGameInstance.this.addTask(new LogicRunnable()
/*      */         {
/*      */ 
/*      */           public void process()
/*      */           {
/* 2889 */             BallBattleGameInstance.this.onBuffItemRespawn();
/*      */           }
/* 2891 */         });
/* 2892 */         return true;
/*      */       }
/* 2894 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void forceStopAllGameInstances()
/*      */   {
/* 2905 */     Set<BallBattleGameInstance> instances = new HashSet(role2instance.values());
/* 2906 */     for (BallBattleGameInstance instance : instances)
/*      */     {
/* 2908 */       instance.addTask(new LogicRunnable()
/*      */       {
/*      */ 
/*      */         public void process()
/*      */         {
/* 2913 */           this.val$instance.onGameForceEnd();
/*      */         }
/*      */       });
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean forceStopGameInstance(long roleId)
/*      */   {
/* 2926 */     BallBattleGameInstance instance = (BallBattleGameInstance)role2instance.get(Long.valueOf(roleId));
/* 2927 */     if (instance == null)
/*      */     {
/* 2929 */       return false;
/*      */     }
/* 2931 */     instance.addTask(new LogicRunnable()
/*      */     {
/*      */ 
/*      */       public void process()
/*      */       {
/* 2936 */         this.val$instance.onGameEnd();
/*      */       }
/* 2938 */     });
/* 2939 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean forceSuicide(final long roleId)
/*      */   {
/* 2947 */     BallBattleGameInstance instance = (BallBattleGameInstance)role2instance.get(Long.valueOf(roleId));
/* 2948 */     if (instance == null)
/*      */     {
/* 2950 */       return false;
/*      */     }
/* 2952 */     instance.addRoleRelatedTask(roleId, new LogicRunnable()
/*      */     {
/*      */ 
/*      */       public void process()
/*      */       {
/* 2957 */         this.val$instance.killPlayer(roleId, true);
/* 2958 */         this.val$instance.notifyDeathEventToInSceneRoles(roleId);
/*      */       }
/* 2960 */     });
/* 2961 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean forceRemoveGroundItems(long roleId)
/*      */   {
/* 2969 */     BallBattleGameInstance instance = (BallBattleGameInstance)role2instance.get(Long.valueOf(roleId));
/* 2970 */     if (instance == null)
/*      */     {
/* 2972 */       return false;
/*      */     }
/* 2974 */     instance.addTask(new LogicRunnable()
/*      */     {
/*      */ 
/*      */       public void process()
/*      */       {
/* 2979 */         this.val$instance.destroyAllGroundItems();
/*      */       }
/* 2981 */     });
/* 2982 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean forceGetBuffItem(final long roleId, int buffItemCfgId)
/*      */   {
/* 2990 */     BallBattleGameInstance instance = (BallBattleGameInstance)role2instance.get(Long.valueOf(roleId));
/* 2991 */     if (instance == null)
/*      */     {
/* 2993 */       return false;
/*      */     }
/* 2995 */     instance.addRoleRelatedTask(roleId, new LogicRunnable()
/*      */     {
/*      */ 
/*      */       public void process()
/*      */       {
/* 3000 */         this.val$instance.playerGetBuffItem(roleId, this.val$buffItemCfgId, null);
/*      */       }
/* 3002 */     });
/* 3003 */     return true;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\main\BallBattleGameInstance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */