/*     */ package mzm.gsp.map.main.scene.object;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.map.SMapCommonResult;
/*     */ import mzm.gsp.map.SMapMonsterFightEnd;
/*     */ import mzm.gsp.map.SMapMonsterFightStart;
/*     */ import mzm.gsp.map.SMapMonsterStartMove;
/*     */ import mzm.gsp.map.SMapMonsterStopMove;
/*     */ import mzm.gsp.map.SMonsterEnterView;
/*     */ import mzm.gsp.map.SMonsterLeaveView;
/*     */ import mzm.gsp.map.SSyncMonsterNameChange;
/*     */ import mzm.gsp.map.confbean.Loc;
/*     */ import mzm.gsp.map.confbean.SMapRegionConfig;
/*     */ import mzm.gsp.map.confbean.SMapVisibleMonster;
/*     */ import mzm.gsp.map.main.IdGenerator;
/*     */ import mzm.gsp.map.main.MapConfiguration;
/*     */ import mzm.gsp.map.main.MapManager;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.MapObjectManager;
/*     */ import mzm.gsp.map.main.WorldInstance;
/*     */ import mzm.gsp.map.main.ai.fsm.AIManager;
/*     */ import mzm.gsp.map.main.ai.fsm.AttackState;
/*     */ import mzm.gsp.map.main.ai.fsm.MoveState;
/*     */ import mzm.gsp.map.main.ai.fsm.NormalState;
/*     */ import mzm.gsp.map.main.ai.path.MoveController;
/*     */ import mzm.gsp.map.main.ai.path.Path;
/*     */ import mzm.gsp.map.main.ai.path.PathNode;
/*     */ import mzm.gsp.map.main.message.MapProtocolSendQueue;
/*     */ import mzm.gsp.map.main.proto.MapMonsterStarLevelPrototype;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.SceneManager;
/*     */ import mzm.gsp.map.main.scene.TransferType;
/*     */ import mzm.gsp.map.main.scene.view.ActiveMonsterView;
/*     */ import mzm.gsp.map.main.scene.view.CircleView;
/*     */ import mzm.gsp.map.main.scene.view.IView;
/*     */ import mzm.gsp.monster.confbean.SActiveBrightMonster;
/*     */ import mzm.gsp.monster.confbean.SBaseBrightMonster;
/*     */ import mzm.gsp.monster.confbean.SBrightMonster;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
/*     */ import xio.Protocol;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MapMonster
/*     */   extends BaseMapAIObjectAndControllerObject
/*     */ {
/*  56 */   private static final Logger logger = Logger.getLogger(MapMonster.class);
/*     */   
/*     */   private static final int STAR_LEVEL_UNINIT = -2;
/*     */   
/*     */   private static final int STAR_LEVEL_INITED = -1;
/*     */   
/*     */   private final MapMonsterId objid;
/*     */   private final SMapVisibleMonster mapVisibleMonster;
/*     */   private long lastAttackTime;
/*     */   private int attackRadius;
/*  66 */   private int bornSceneId = 0;
/*  67 */   private int starLevel = -2;
/*  68 */   private int fightCfgid = 0;
/*  69 */   private long fightid = -1L;
/*  70 */   private int killedTimes = 0;
/*     */   
/*     */ 
/*     */ 
/*     */   public MapMonster(SMapVisibleMonster mapVisibleMonster, SBaseBrightMonster baseBrightMonster)
/*     */   {
/*  76 */     this.objid = new MapMonsterId(sceneObjIdGenerator.nextId());
/*  77 */     this.mapVisibleMonster = mapVisibleMonster;
/*  78 */     this.controllerId = baseBrightMonster.controllerId;
/*  79 */     this.modelId = baseBrightMonster.monsterModelTableId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public MapMonster(SMapVisibleMonster mapVisibleMonster, int modelId)
/*     */   {
/*  86 */     this.objid = new MapMonsterId(sceneObjIdGenerator.nextId());
/*  87 */     this.mapVisibleMonster = mapVisibleMonster;
/*  88 */     this.modelId = modelId;
/*     */   }
/*     */   
/*     */   public void initializeAi(int pathType, Path path)
/*     */   {
/*  93 */     AttackState attackState = null;
/*  94 */     if (this.mapVisibleMonster.monsterType == 1)
/*     */     {
/*  96 */       this.aiManager = new AIManager(this);
/*  97 */       attackState = new AttackState(this.aiManager);
/*     */       
/*  99 */       this.isActiveAttack = true;
/*     */       
/* 101 */       SBaseBrightMonster baseBrightMonster = MapManager.getBaseBrightMonster(this.mapVisibleMonster);
/* 102 */       this.attackRadius = ((SActiveBrightMonster)baseBrightMonster).attackRadius;
/* 103 */       this.view = new ActiveMonsterView(this, MapConfiguration.VIEW_WIDTH, this.attackRadius);
/*     */     }
/*     */     else
/*     */     {
/* 107 */       this.view = new CircleView(this, MapConfiguration.VIEW_WIDTH);
/*     */     }
/*     */     
/* 110 */     MoveState moveState = null;
/* 111 */     if (pathType == 2)
/*     */     {
/* 113 */       if (this.aiManager == null)
/*     */       {
/* 115 */         this.aiManager = new AIManager(this);
/*     */       }
/* 117 */       MoveController mc = new MoveController(this);
/* 118 */       mc.resetPath(path, 4);
/* 119 */       moveState = new MoveState(this.aiManager, mc);
/*     */     }
/*     */     
/* 122 */     if (this.aiManager != null)
/*     */     {
/* 124 */       NormalState normalState = new NormalState(this.aiManager);
/* 125 */       this.aiManager.initialize(normalState, attackState, moveState);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public MapMonsterId getObjectId()
/*     */   {
/* 135 */     return this.objid;
/*     */   }
/*     */   
/*     */   public int getMonsterId()
/*     */   {
/* 140 */     return this.objid.getId().intValue();
/*     */   }
/*     */   
/*     */   public SMapVisibleMonster getMapVisibleMonster()
/*     */   {
/* 145 */     return this.mapVisibleMonster;
/*     */   }
/*     */   
/*     */   public Integer getCfgId()
/*     */   {
/* 150 */     return Integer.valueOf(this.mapVisibleMonster.cfgid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getStarLevel()
/*     */   {
/* 160 */     initStartLevelIfNeeded();
/*     */     
/* 162 */     return this.starLevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getFightCfgid()
/*     */   {
/* 172 */     initStartLevelIfNeeded();
/*     */     
/* 174 */     if (this.fightCfgid > 0)
/*     */     {
/* 176 */       return this.fightCfgid;
/*     */     }
/*     */     
/* 179 */     SBaseBrightMonster baseBrightMonster = getBaseBrightMonster();
/* 180 */     if (baseBrightMonster == null)
/*     */     {
/* 182 */       return -1;
/*     */     }
/*     */     
/* 185 */     int monsterFightTableId = baseBrightMonster.monsterFightTableId;
/* 186 */     if (monsterFightTableId <= 0)
/*     */     {
/* 188 */       return -1;
/*     */     }
/*     */     
/* 191 */     return monsterFightTableId;
/*     */   }
/*     */   
/*     */   private void initStartLevelIfNeeded()
/*     */   {
/* 196 */     initStartLevelIfNeeded(null);
/*     */   }
/*     */   
/*     */   private void initStartLevelIfNeeded(MapMonsterStarLevelPrototype prototype)
/*     */   {
/* 201 */     if (this.starLevel >= -1)
/*     */     {
/* 203 */       return;
/*     */     }
/*     */     
/* 206 */     if (prototype == null)
/*     */     {
/* 208 */       prototype = MapObjectManager.getInstance().getMonsterStarLevelPrototype(getCfgId().intValue());
/*     */     }
/*     */     
/* 211 */     if ((prototype != null) && (prototype.isValid()))
/*     */     {
/* 213 */       this.starLevel = prototype.getInitStarLevel();
/* 214 */       this.fightCfgid = prototype.getFightid(this.starLevel).intValue();
/*     */     }
/*     */     else
/*     */     {
/* 218 */       this.starLevel = -1;
/* 219 */       this.fightCfgid = 0;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void spawnMe(TransferType type)
/*     */   {
/* 226 */     reset();
/*     */     
/* 228 */     initStartLevelIfNeeded();
/*     */     
/* 230 */     unsetInFight();
/*     */     
/* 232 */     if (this.mapVisibleMonster.isRandomInRange)
/*     */     {
/* 234 */       boolean isInAirMonster = false;
/*     */       
/* 236 */       SBaseBrightMonster baseBrightMonster = getBaseBrightMonster();
/* 237 */       if (baseBrightMonster != null)
/*     */       {
/* 239 */         isInAirMonster = baseBrightMonster.isInAir;
/*     */       }
/*     */       
/*     */ 
/* 243 */       Scene scene = SceneManager.getInstance().getScene(this.bornSceneId);
/* 244 */       int regionSize = this.mapVisibleMonster.regions.size();
/* 245 */       if (regionSize > 0)
/*     */       {
/* 247 */         int regionCfgid = 0;
/* 248 */         if (isInAirMonster)
/*     */         {
/* 250 */           regionCfgid = ((Integer)this.mapVisibleMonster.regions.get(Xdb.random().nextInt(regionSize))).intValue();
/* 251 */           this.position = scene.randomPosFromAirRegion(regionCfgid);
/*     */         }
/*     */         else
/*     */         {
/* 255 */           int probBase = Xdb.random().nextInt(this.mapVisibleMonster.randomRegionProbBase);
/* 256 */           Map.Entry<Integer, Integer> entry = this.mapVisibleMonster.randomRegions.ceilingEntry(Integer.valueOf(probBase));
/* 257 */           if (entry == null)
/*     */           {
/* 259 */             logger.warn(String.format("[map]MapMonster.spawnMe@map monster born region is empty|map_cfgid=%d|map_monster_cfgid=%d", new Object[] { Integer.valueOf(this.mapVisibleMonster.mapCfgId), Integer.valueOf(this.mapVisibleMonster.cfgid) }));
/*     */             
/*     */ 
/* 262 */             return;
/*     */           }
/*     */           
/* 265 */           regionCfgid = ((Integer)entry.getValue()).intValue();
/* 266 */           this.position = scene.randomPosFromRegion(regionCfgid);
/*     */         }
/*     */         
/* 269 */         if (this.position == null)
/*     */         {
/* 271 */           logger.warn(String.format("[map]MapMonster.spawnMe@map monster born position is null|map_cfgid=%d|map_monster_cfgid=%d|region_cfgid=%d", new Object[] { Integer.valueOf(this.mapVisibleMonster.mapCfgId), Integer.valueOf(this.mapVisibleMonster.cfgid), Integer.valueOf(regionCfgid) }));
/*     */           
/*     */ 
/* 274 */           return;
/*     */         }
/*     */         
/* 277 */         SMapRegionConfig regionCfg = SMapRegionConfig.get(regionCfgid);
/* 278 */         Path path = new Path();
/* 279 */         path.add(new PathNode(this.position.getX(), this.position.getY(), this.position.getZ()));
/* 280 */         path.add(new PathNode(regionCfg.x, regionCfg.y, 0));
/* 281 */         path.add(new PathNode(regionCfg.x + regionCfg.w, regionCfg.y, 0));
/* 282 */         path.add(new PathNode(regionCfg.x + regionCfg.w, regionCfg.y + regionCfg.h, 0));
/* 283 */         path.add(new PathNode(regionCfg.x, regionCfg.y + regionCfg.h, 0));
/* 284 */         initializeAi(2, path);
/*     */       }
/*     */       else
/*     */       {
/* 288 */         if (isInAirMonster)
/*     */         {
/* 290 */           this.position = scene.randomPosInAir();
/*     */         }
/*     */         else
/*     */         {
/* 294 */           this.position = scene.randomPos();
/*     */         }
/*     */         
/* 297 */         if (this.position == null)
/*     */         {
/* 299 */           logger.warn(String.format("[map]MapMonster.spawnMe@map monster born position is null|map_cfgid=%d|map_monster_cfgid=%d", new Object[] { Integer.valueOf(this.mapVisibleMonster.mapCfgId), Integer.valueOf(this.mapVisibleMonster.cfgid) }));
/*     */           
/*     */ 
/*     */ 
/* 303 */           return;
/*     */         }
/*     */         
/* 306 */         initializeAi(0, null);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 311 */       this.position = new Position(this.mapVisibleMonster.location.x, this.mapVisibleMonster.location.y, 0, this.bornSceneId);
/*     */       
/*     */ 
/* 314 */       initializeAi(0, null);
/*     */     }
/*     */     
/* 317 */     this.targetPos = new Position(this.position);
/*     */     
/* 319 */     MapObjectInstanceManager.getInstance().addMapMonster(this);
/*     */     
/* 321 */     super.spawnMe(type);
/*     */   }
/*     */   
/*     */   public void onMonsterLose()
/*     */   {
/* 326 */     unsetInFight();
/*     */     
/* 328 */     SBaseBrightMonster baseBrightMonster = getBaseBrightMonster();
/* 329 */     if (baseBrightMonster != null)
/*     */     {
/* 331 */       broadcastPlayEffectInScene(baseBrightMonster.killedEffect);
/*     */     }
/*     */     
/* 334 */     int maxKilledTimes = getMaxKilledTimes(baseBrightMonster);
/* 335 */     if (isDieVanish(baseBrightMonster))
/*     */     {
/* 337 */       if (++this.killedTimes >= maxKilledTimes)
/*     */       {
/* 339 */         destroy();
/* 340 */         return;
/*     */       }
/*     */     }
/*     */     
/* 344 */     sendMonsterFightEnd();
/*     */   }
/*     */   
/*     */ 
/*     */   public void destroy()
/*     */   {
/* 350 */     if (!this.isAlive)
/*     */     {
/* 352 */       return;
/*     */     }
/*     */     
/* 355 */     super.destroy();
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onDestroy()
/*     */   {
/* 361 */     int monsterid = getMonsterId();
/* 362 */     MapObjectInstanceManager.getInstance().removeMapMonster(monsterid);
/*     */   }
/*     */   
/*     */   public void onMonsterWin()
/*     */   {
/* 367 */     this.lastAttackTime = DateTimeUtils.getCurrTimeInMillis();
/* 368 */     this.isVisible = true;
/*     */     
/* 370 */     unsetInFight();
/*     */     
/* 372 */     sendMonsterFightEnd();
/*     */     
/* 374 */     MapMonsterStarLevelPrototype starLevelPrototype = MapObjectManager.getInstance().getMonsterStarLevelPrototype(getCfgId().intValue());
/*     */     
/* 376 */     if (starLevelPrototype != null)
/*     */     {
/* 378 */       initStartLevelIfNeeded();
/*     */       
/* 380 */       if (!starLevelPrototype.isMaxStarLevel(this.starLevel))
/*     */       {
/* 382 */         this.starLevel += 1;
/* 383 */         this.fightCfgid = starLevelPrototype.getFightid(this.starLevel).intValue();
/*     */         
/* 385 */         SSyncMonsterNameChange core = new SSyncMonsterNameChange();
/* 386 */         core.monsterinstanceid = getMonsterId();
/* 387 */         core.newname = getName(starLevelPrototype);
/* 388 */         sendToView(core);
/*     */       }
/*     */     }
/*     */     
/* 392 */     if (this.aiManager != null)
/*     */     {
/* 394 */       this.aiManager.switchState(this.aiManager.getNormal());
/*     */     }
/*     */   }
/*     */   
/*     */   public long getLastAttackTime()
/*     */   {
/* 400 */     return this.lastAttackTime;
/*     */   }
/*     */   
/*     */   public SBaseBrightMonster getBaseBrightMonster()
/*     */   {
/* 405 */     return MapManager.getBaseBrightMonster(this.mapVisibleMonster);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int tryStartFight(MapRole role)
/*     */   {
/* 416 */     if (isInFight())
/*     */     {
/* 418 */       SMapCommonResult res = new SMapCommonResult();
/* 419 */       res.result = 2;
/* 420 */       MapProtocolSendQueue.getInstance().send(role.getRoleId(), res);
/* 421 */       return -1;
/*     */     }
/*     */     
/* 424 */     setInFight();
/*     */     
/*     */     try
/*     */     {
/* 428 */       SBaseBrightMonster baseBrightMonster = getBaseBrightMonster();
/* 429 */       if (baseBrightMonster == null)
/*     */       {
/* 431 */         unsetInFight();
/* 432 */         return -1;
/*     */       }
/* 434 */       int fightId = baseBrightMonster.monsterFightTableId;
/* 435 */       if (fightId <= 0)
/*     */       {
/* 437 */         unsetInFight();
/* 438 */         return -1;
/*     */       }
/*     */       
/*     */ 
/* 442 */       Scene scene = SceneManager.getInstance().getScene(getPositionForInner());
/* 443 */       if (scene == null)
/*     */       {
/* 445 */         unsetInFight();
/* 446 */         return -1;
/*     */       }
/*     */       
/* 449 */       if (!scene.getWorld().handleFight(role.getRoleId(), this, baseBrightMonster))
/*     */       {
/* 451 */         unsetInFight();
/* 452 */         return -1;
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 457 */       unsetInFight();
/* 458 */       return -1;
/*     */     }
/*     */     
/* 461 */     return 0;
/*     */   }
/*     */   
/*     */   public void onStartFightResult(long roleid, int retcode, long fightid)
/*     */   {
/* 466 */     if (retcode == -1)
/*     */     {
/* 468 */       unsetInFight();
/* 469 */       return;
/*     */     }
/*     */     
/* 472 */     if (retcode != 1)
/*     */     {
/* 474 */       SMapCommonResult res = new SMapCommonResult();
/* 475 */       res.result = retcode;
/* 476 */       MapProtocolSendQueue.getInstance().send(roleid, res);
/*     */       
/* 478 */       unsetInFight();
/*     */       
/* 480 */       return;
/*     */     }
/*     */     
/*     */ 
/* 484 */     onStartFightSuccess(fightid);
/*     */     
/* 486 */     if (this.mapVisibleMonster.monsterType == 2)
/*     */     {
/* 488 */       SBaseBrightMonster baseBrightMonster = getBaseBrightMonster();
/* 489 */       if (baseBrightMonster == null)
/*     */       {
/* 491 */         destroy();
/* 492 */         return;
/*     */       }
/*     */       
/* 495 */       SBrightMonster brightMonster = (SBrightMonster)baseBrightMonster;
/* 496 */       if (brightMonster.vanishType == 1)
/*     */       {
/* 498 */         destroy();
/* 499 */         return;
/*     */       }
/* 501 */       if (brightMonster.vanishType == 3)
/*     */       {
/* 503 */         this.isVisible = false;
/*     */       }
/*     */     }
/*     */     
/* 507 */     sendMonsterFightStart();
/*     */   }
/*     */   
/*     */   private int getMaxKilledTimes(SBaseBrightMonster baseBrightMonster)
/*     */   {
/* 512 */     if (baseBrightMonster == null)
/*     */     {
/* 514 */       return 0;
/*     */     }
/*     */     
/* 517 */     return baseBrightMonster.maxKilledTimes;
/*     */   }
/*     */   
/*     */   private boolean isDieVanish(SBaseBrightMonster baseBrightMonster)
/*     */   {
/* 522 */     if (this.mapVisibleMonster.monsterType != 1)
/*     */     {
/* 524 */       return true;
/*     */     }
/*     */     
/* 527 */     if (baseBrightMonster == null)
/*     */     {
/* 529 */       return true;
/*     */     }
/*     */     
/* 532 */     return ((SActiveBrightMonster)baseBrightMonster).isDieVanish;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCanSee(MapRole role)
/*     */   {
/* 538 */     return this.isVisible;
/*     */   }
/*     */   
/*     */ 
/*     */   public Protocol createEnterView()
/*     */   {
/* 544 */     SMonsterEnterView enterView = new SMonsterEnterView();
/* 545 */     enterView.monsterinstanceid = getMonsterId();
/* 546 */     enterView.monsterid = getCfgId().intValue();
/* 547 */     enterView.monstername = getName();
/* 548 */     Position pos = getPositionForInner();
/* 549 */     enterView.posinit.curx = pos.getX();
/* 550 */     enterView.posinit.cury = pos.getY();
/* 551 */     enterView.isactive = (this.mapVisibleMonster.monsterType == 1 ? 1 : 0);
/* 552 */     enterView.posinit.direction = getDirection();
/* 553 */     Position target = getTargetPosForInner();
/* 554 */     enterView.posinit.targetx = target.getX();
/* 555 */     enterView.posinit.targety = target.getY();
/* 556 */     enterView.is_fighting = ((byte)(isInFight() ? 1 : 0));
/*     */     
/* 558 */     return enterView;
/*     */   }
/*     */   
/*     */ 
/*     */   public Protocol createLeaveView()
/*     */   {
/* 564 */     SMonsterLeaveView leaveView = new SMonsterLeaveView();
/* 565 */     leaveView.monsterinstanceid = getMonsterId();
/*     */     
/* 567 */     return leaveView;
/*     */   }
/*     */   
/*     */ 
/*     */   public Protocol createMoveProtocol()
/*     */   {
/* 573 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public void stay(long time)
/*     */   {
/* 579 */     SMapMonsterStopMove mapMonsterStopMove = new SMapMonsterStopMove();
/* 580 */     Position pos = getPositionForInner();
/* 581 */     mapMonsterStopMove.currentloc.x = pos.getX();
/* 582 */     mapMonsterStopMove.currentloc.y = pos.getY();
/* 583 */     mapMonsterStopMove.instanceid = getMonsterId();
/* 584 */     sendToView(mapMonsterStopMove);
/*     */     
/* 586 */     this.stayTime = time;
/*     */   }
/*     */   
/*     */ 
/*     */   public int tryStartFight()
/*     */   {
/* 592 */     IView view = getView();
/* 593 */     if ((view == null) || (!(view instanceof ActiveMonsterView)))
/*     */     {
/* 595 */       return -1;
/*     */     }
/*     */     
/* 598 */     ActiveMonsterView activeView = (ActiveMonsterView)view;
/* 599 */     Collection<MapRole> roles = activeView.getAttackablePlayer();
/* 600 */     if (roles.isEmpty())
/*     */     {
/* 602 */       return -1;
/*     */     }
/*     */     
/* 605 */     for (MapRole role : roles)
/*     */     {
/* 607 */       if ((role != null) && (role.isAlive()) && (!role.isFollower()))
/*     */       {
/* 609 */         return tryStartFight(role);
/*     */       }
/*     */     }
/*     */     
/* 613 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isStartFightSuccess()
/*     */   {
/* 619 */     return isFightState();
/*     */   }
/*     */   
/*     */   public void onStartFightSuccess(long fightid)
/*     */   {
/* 624 */     this.fightid = fightid;
/*     */   }
/*     */   
/*     */   public void observeFight(long obseverRoleid)
/*     */   {
/* 629 */     if (!isInFight())
/*     */     {
/* 631 */       return;
/*     */     }
/*     */     
/*     */ 
/* 635 */     new RObserveMonsterFight(obseverRoleid, this.fightid, getMonsterId()).execute();
/*     */   }
/*     */   
/*     */   public boolean isInFight()
/*     */   {
/* 640 */     return isState(1);
/*     */   }
/*     */   
/*     */   public void setInFight()
/*     */   {
/* 645 */     setState(1);
/*     */   }
/*     */   
/*     */   public void unsetInFight()
/*     */   {
/* 650 */     unsetState(1);
/*     */   }
/*     */   
/*     */ 
/*     */   public void onMove()
/*     */   {
/* 656 */     SBaseBrightMonster baseBrightMonster = getBaseBrightMonster();
/* 657 */     if (baseBrightMonster == null)
/*     */     {
/* 659 */       return;
/*     */     }
/*     */     
/* 662 */     SMapMonsterStartMove move = new SMapMonsterStartMove();
/* 663 */     Position curPos = getPositionForInner();
/* 664 */     move.currentloc.x = curPos.getX();
/* 665 */     move.currentloc.y = curPos.getY();
/* 666 */     Position tarPos = getPositionForInner();
/* 667 */     move.targetloc.x = tarPos.getX();
/* 668 */     move.targetloc.y = tarPos.getY();
/* 669 */     move.velocity = baseBrightMonster.velocity;
/* 670 */     move.instanceid = getMonsterId();
/*     */     
/* 672 */     sendToView(move);
/*     */   }
/*     */   
/*     */   public void setBornSceneId(int bornSceneId)
/*     */   {
/* 677 */     this.bornSceneId = bornSceneId;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSceneId()
/*     */   {
/* 683 */     int superScene = super.getSceneId();
/* 684 */     if (superScene == 0)
/*     */     {
/* 686 */       return this.bornSceneId;
/*     */     }
/*     */     
/* 689 */     return superScene;
/*     */   }
/*     */   
/*     */ 
/*     */   public int acceptMoveView(SceneObject other, boolean delaySync)
/*     */   {
/* 695 */     if (isActiveAttack())
/*     */     {
/* 697 */       return this.view.onMove(other, delaySync);
/*     */     }
/*     */     
/* 700 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getName()
/*     */   {
/* 706 */     MapMonsterStarLevelPrototype prototype = MapObjectManager.getInstance().getMonsterStarLevelPrototype(getCfgId().intValue());
/*     */     
/*     */ 
/* 709 */     return getName(prototype);
/*     */   }
/*     */   
/*     */   private String getName(MapMonsterStarLevelPrototype prototype)
/*     */   {
/* 714 */     if (prototype != null)
/*     */     {
/* 716 */       initStartLevelIfNeeded(prototype);
/*     */       
/* 718 */       String name = prototype.getName(this.starLevel);
/* 719 */       if (name != null)
/*     */       {
/* 721 */         return name;
/*     */       }
/*     */     }
/*     */     
/* 725 */     SBaseBrightMonster baseBrightMonster = getBaseBrightMonster();
/* 726 */     if (baseBrightMonster == null)
/*     */     {
/* 728 */       return "";
/*     */     }
/*     */     
/* 731 */     return baseBrightMonster.name;
/*     */   }
/*     */   
/*     */   private void sendMonsterFightStart()
/*     */   {
/* 736 */     SMapMonsterFightStart monsterFightStart = new SMapMonsterFightStart();
/* 737 */     monsterFightStart.instanceid = getMonsterId();
/* 738 */     sendToView(monsterFightStart);
/*     */   }
/*     */   
/*     */   private void sendMonsterFightEnd()
/*     */   {
/* 743 */     SMapMonsterFightEnd monsterFightEnd = new SMapMonsterFightEnd();
/* 744 */     monsterFightEnd.instanceid = getMonsterId();
/* 745 */     sendToView(monsterFightEnd);
/*     */   }
/*     */   
/*     */ 
/*     */   private void reset()
/*     */   {
/* 751 */     this.starLevel = -2;
/* 752 */     this.fightCfgid = 0;
/* 753 */     this.lastAttackTime = 0L;
/* 754 */     this.attackRadius = 0;
/* 755 */     this.fightid = -1L;
/* 756 */     this.killedTimes = 0;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\object\MapMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */