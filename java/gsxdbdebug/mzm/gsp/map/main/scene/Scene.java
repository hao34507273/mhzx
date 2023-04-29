/*      */ package mzm.gsp.map.main.scene;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.fight.main.FightReason;
/*      */ import mzm.gsp.map.confbean.SMapConfig;
/*      */ import mzm.gsp.map.confbean.SMapItemCfg;
/*      */ import mzm.gsp.map.confbean.SMapItemConfig;
/*      */ import mzm.gsp.map.confbean.SMapNPC;
/*      */ import mzm.gsp.map.confbean.SMapTransferRegion;
/*      */ import mzm.gsp.map.confbean.SMapTransportObjCfg;
/*      */ import mzm.gsp.map.confbean.SMapVisibleMonster;
/*      */ import mzm.gsp.map.main.IdGenerator;
/*      */ import mzm.gsp.map.main.MapCfgManager;
/*      */ import mzm.gsp.map.main.MapConfiguration;
/*      */ import mzm.gsp.map.main.MapDarkMonsterFightContext;
/*      */ import mzm.gsp.map.main.MapManager;
/*      */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*      */ import mzm.gsp.map.main.PTryStartDrakMonsterPVEFight;
/*      */ import mzm.gsp.map.main.WorldInstance;
/*      */ import mzm.gsp.map.main.controller.Controller;
/*      */ import mzm.gsp.map.main.message.MMH_DestroyScene;
/*      */ import mzm.gsp.map.main.message.MapProtocolSendQueue;
/*      */ import mzm.gsp.map.main.proto.Cell;
/*      */ import mzm.gsp.map.main.proto.MapItemControllerObject;
/*      */ import mzm.gsp.map.main.proto.MapMonsterControllerObject;
/*      */ import mzm.gsp.map.main.proto.MapPrototype;
/*      */ import mzm.gsp.map.main.scene.darkmonsterhandle.MeetDarkMonsterHandle;
/*      */ import mzm.gsp.map.main.scene.darkmonsterhandle.MeetMonsterManager;
/*      */ import mzm.gsp.map.main.scene.object.MapEntity;
/*      */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*      */ import mzm.gsp.map.main.scene.object.MapItem;
/*      */ import mzm.gsp.map.main.scene.object.MapMonster;
/*      */ import mzm.gsp.map.main.scene.object.MapNPC;
/*      */ import mzm.gsp.map.main.scene.object.MapRole;
/*      */ import mzm.gsp.map.main.scene.object.MapTransferZoneObject;
/*      */ import mzm.gsp.map.main.scene.object.SceneObject;
/*      */ import mzm.gsp.map.main.scene.zone.ZoneForm;
/*      */ import mzm.gsp.map.main.scene.zone.type.EventZone;
/*      */ import mzm.gsp.map.main.scene.zone.type.PKZone;
/*      */ import mzm.gsp.map.main.scene.zone.type.event.IInnerZoneListener;
/*      */ import mzm.gsp.map.main.team.MapTeamData;
/*      */ import mzm.gsp.map.main.team.MapTeamManager;
/*      */ import mzm.gsp.monster.confbean.SBaseBrightMonster;
/*      */ import mzm.gsp.monster.confbean.SInstanceMonster;
/*      */ import mzm.gsp.timer.main.MilliObserver;
/*      */ import mzm.gsp.worldai.confbean.SWorldAIParam;
/*      */ import org.apache.log4j.Logger;
/*      */ import xdb.Xdb;
/*      */ import xio.Protocol;
/*      */ 
/*      */ public final class Scene
/*      */ {
/*   64 */   private static final Logger logger = Logger.getLogger(Scene.class);
/*      */   
/*   66 */   private static final IdGenerator sceneIdGenerator = new IdGenerator(-1, -1);
/*      */   
/*   68 */   private static final IdGenerator channelIdGenerator = new IdGenerator(0, 1);
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private MapPrototype prototype;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private WorldInstance worldInstance;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private int instanceId;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private Grid[][] grids;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*   94 */   private Map<Integer, Map<Integer, Cell>> cellsMap = new HashMap();
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*   99 */   private Map<Integer, EventZone> regisEventZoneMap = new HashMap();
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private PKZone pkZone;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*  109 */   private int eventIdGen = 1;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private MeetMonsterManager meetMonsterManager;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*  119 */   private Map<Integer, Integer> worldAiParam = new HashMap();
/*      */   
/*  121 */   private boolean isAutoRelease = false;
/*      */   
/*  123 */   private boolean isRepeatLazyInit = false;
/*      */   
/*  125 */   private boolean destroyed = false;
/*      */   
/*  127 */   private MilliObserver sceneProtectObserver = null;
/*      */   
/*  129 */   private final Set<Long> roleSet = new HashSet();
/*  130 */   private final Set<Integer> npcSet = new HashSet();
/*  131 */   private final Set<Integer> monsterSet = new HashSet();
/*  132 */   private final Set<Integer> itemSet = new HashSet();
/*  133 */   private final Set<Integer> transferZoneObjectSet = new HashSet();
/*  134 */   private final Map<Integer, Set<Long>> entityTypeToEntities = new HashMap();
/*  135 */   private final Map<Integer, Integer> channels = new HashMap();
/*      */   
/*      */   public Scene(int mapCfgid, WorldInstance world)
/*      */   {
/*  139 */     this.prototype = MapCfgManager.getInstance().getMapProtoById(mapCfgid);
/*  140 */     if (this.prototype == null)
/*      */     {
/*  142 */       throw new NullPointerException(String.format("[map]Scene.Scene@map prototype is null|map_cfgid=%d", new Object[] { Integer.valueOf(mapCfgid) }));
/*      */     }
/*      */     
/*  145 */     SMapConfig mapConfig = this.prototype.getMapConfig();
/*  146 */     if (mapConfig == null)
/*      */     {
/*  148 */       throw new NullPointerException(String.format("[map]Scene.Scene@map config is null|map_cfgid=%d", new Object[] { Integer.valueOf(mapCfgid) }));
/*      */     }
/*      */     
/*  151 */     this.worldInstance = world;
/*  152 */     this.instanceId = this.prototype.getTemplateId();
/*      */     
/*  154 */     initGrid(mapConfig);
/*      */     
/*  156 */     initPKZone(mapConfig);
/*      */     
/*  158 */     if (this.prototype.getMinMeetMonsterProb() > 0.0D)
/*      */     {
/*  160 */       this.meetMonsterManager = new MeetMonsterManager(this);
/*      */     }
/*      */   }
/*      */   
/*      */   public void autoRelease()
/*      */   {
/*  166 */     this.isAutoRelease = true;
/*      */   }
/*      */   
/*      */   public void unAutoRelease()
/*      */   {
/*  171 */     this.isAutoRelease = false;
/*      */   }
/*      */   
/*      */   public void repeatLazyInit()
/*      */   {
/*  176 */     this.isRepeatLazyInit = true;
/*      */   }
/*      */   
/*      */   public void unRepeatLazyInit()
/*      */   {
/*  181 */     this.isRepeatLazyInit = false;
/*      */   }
/*      */   
/*      */   public boolean isWorldMap()
/*      */   {
/*  186 */     return this.prototype.isWorldMap();
/*      */   }
/*      */   
/*      */   public boolean isFuBen()
/*      */   {
/*  191 */     return this.prototype.isFubenMap();
/*      */   }
/*      */   
/*      */   public boolean isHomelandMap()
/*      */   {
/*  196 */     return this.prototype.isHomelandMap();
/*      */   }
/*      */   
/*      */   public boolean isGangMap()
/*      */   {
/*  201 */     return this.prototype.isGangMap();
/*      */   }
/*      */   
/*      */   private void initGrid(SMapConfig mapConfig)
/*      */   {
/*  206 */     int gridRows = mapConfig.gridRows;
/*  207 */     int gridCols = mapConfig.gridCols;
/*  208 */     this.grids = new Grid[gridRows][gridCols];
/*  209 */     for (int i = 0; i < gridRows; i++)
/*      */     {
/*  211 */       for (int j = 0; j < gridCols; j++)
/*      */       {
/*  213 */         this.grids[i][j] = new Grid();
/*      */       }
/*      */     }
/*      */     
/*  217 */     for (int row = 0; row < gridRows; row++)
/*      */     {
/*  219 */       for (int col = 0; col < gridCols; col++)
/*      */       {
/*  221 */         for (int offsetCol = -4; offsetCol <= 4; offsetCol++)
/*      */         {
/*  223 */           for (int offsetRow = -4; offsetRow <= 4; offsetRow++)
/*      */           {
/*  225 */             int newCol = col + offsetCol;
/*  226 */             int newRow = row + offsetRow;
/*  227 */             if ((newCol >= 0) && (newRow >= 0) && (newCol < gridCols) && (newRow < gridRows))
/*      */             {
/*  229 */               this.grids[row][col].addSurroundingGrid(this.grids[newRow][newCol]);
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void initPKZone(SMapConfig mapConfig)
/*      */   {
/*  240 */     if (!mapConfig.pkCellInfos.isEmpty())
/*      */     {
/*  242 */       this.pkZone = new PKZone();
/*      */       
/*  244 */       int cellCols = mapConfig.cellCols;
/*  245 */       int cellRows = mapConfig.cellRows;
/*  246 */       for (int i = 0; i < cellCols; i++)
/*      */       {
/*  248 */         for (int j = 0; j < cellRows; j++)
/*      */         {
/*  250 */           int cellIndex = j * cellCols + i;
/*  251 */           if (mapConfig.pkCellInfos.contains(Integer.valueOf(cellIndex)))
/*      */           {
/*  253 */             Cell cell = createCellIfNeedForSelf(mapConfig, i, j);
/*  254 */             cell.addZone(this.pkZone);
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void initNPC(SMapConfig mapConfig, boolean skipControllerRegis)
/*      */   {
/*  263 */     List<SMapNPC> npcList = MapPrototype.getNpcCfgList(mapConfig);
/*  264 */     if (npcList == null)
/*      */     {
/*  266 */       return;
/*      */     }
/*      */     
/*  269 */     for (SMapNPC cfg : npcList)
/*      */     {
/*      */       try
/*      */       {
/*  273 */         MapNPC mapNPC = new MapNPC(this, mapConfig, cfg);
/*  274 */         Controller controller = this.worldInstance.getController(mapNPC.getControllerId());
/*  275 */         if ((controller != null) && (!skipControllerRegis))
/*      */         {
/*  277 */           controller.addRefreshObject(mapNPC);
/*      */         }
/*      */         
/*  280 */         Position pos = mapNPC.getPosition();
/*  281 */         mapNPC.spawnMe(pos.getX(), pos.getY(), pos.getZ(), this.instanceId, TransferType.SOMMON);
/*      */       }
/*      */       catch (Exception e)
/*      */       {
/*  285 */         logger.error(String.format("[map]Scene.initNPC@npc init error|scene=%s|sceneid=%d|map_cfgid=%d|npc_name=%s|npc_cfgid=%d", new Object[] { getName(), Integer.valueOf(getId()), Integer.valueOf(mapConfig.id), cfg.name, Integer.valueOf(cfg.templateId) }), e);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private void initVisibleMonster(SMapConfig mapConfig, boolean skipControllerRegis)
/*      */   {
/*  294 */     List<SMapVisibleMonster> visibleMonsters = MapPrototype.getVisibleMonsterList(mapConfig);
/*  295 */     if (visibleMonsters == null)
/*      */     {
/*  297 */       return;
/*      */     }
/*      */     
/*  300 */     for (SMapVisibleMonster mapVisibleMonster : visibleMonsters)
/*      */     {
/*  302 */       Integer controllerCfgid = MapManager.getVisibleMonsterControllerCfgid(mapVisibleMonster);
/*  303 */       if (controllerCfgid != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  308 */         Controller controller = this.worldInstance.getController(controllerCfgid.intValue());
/*  309 */         if ((controller != null) && (!skipControllerRegis))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*  314 */           controller.addRefreshObject(new MapMonsterControllerObject(mapVisibleMonster));
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void initTransforObject(SMapConfig mapConfig, boolean skipControllerRegis)
/*      */   {
/*  323 */     List<SMapTransferRegion> transferRegions = MapPrototype.getTransferRegions(mapConfig);
/*  324 */     if (transferRegions == null)
/*      */     {
/*  326 */       return;
/*      */     }
/*      */     
/*  329 */     Map<Integer, SMapTransportObjCfg> cfgMap = new HashMap();
/*  330 */     for (SMapTransportObjCfg cfg : SMapTransportObjCfg.getAll().values())
/*      */     {
/*  332 */       if (cfg.mapId == getCfgId())
/*      */       {
/*  334 */         cfgMap.put(Integer.valueOf(cfg.transportId), cfg);
/*      */       }
/*      */     }
/*  337 */     for (SMapTransferRegion transferRegion : transferRegions)
/*      */     {
/*  339 */       MapTransferZoneObject object = new MapTransferZoneObject(transferRegion, this.instanceId);
/*  340 */       SMapTransportObjCfg cfg = (SMapTransportObjCfg)cfgMap.get(Integer.valueOf(transferRegion.id));
/*  341 */       if (cfg == null)
/*      */       {
/*  343 */         object.spawnMe();
/*      */       }
/*      */       else
/*      */       {
/*  347 */         Controller controller = this.worldInstance.getController(cfg.controllerId);
/*  348 */         if (controller == null)
/*      */         {
/*  350 */           object.spawnMe();
/*      */ 
/*      */ 
/*      */         }
/*  354 */         else if (!skipControllerRegis)
/*      */         {
/*  356 */           controller.addRefreshObject(object);
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
/*      */   public int spawnMonster(int cfgid)
/*      */   {
/*  370 */     SMapVisibleMonster mapVisibleMonster = this.prototype.getVisibleMonster(cfgid);
/*  371 */     if (mapVisibleMonster == null)
/*      */     {
/*  373 */       return -1;
/*      */     }
/*      */     
/*  376 */     MapMonster monster = null;
/*  377 */     if (mapVisibleMonster.monsterType == 3)
/*      */     {
/*  379 */       SInstanceMonster instanceMonster = SInstanceMonster.get(cfgid);
/*  380 */       if (instanceMonster == null)
/*      */       {
/*  382 */         return -1;
/*      */       }
/*  384 */       monster = new MapMonster(mapVisibleMonster, instanceMonster.monsterModelTableId);
/*      */     }
/*      */     else
/*      */     {
/*  388 */       SBaseBrightMonster baseBrightMonster = MapManager.getBaseBrightMonster(mapVisibleMonster);
/*  389 */       if (baseBrightMonster == null)
/*      */       {
/*  391 */         return -1;
/*      */       }
/*  393 */       monster = new MapMonster(mapVisibleMonster, baseBrightMonster);
/*      */     }
/*      */     
/*  396 */     monster.setBornSceneId(this.instanceId);
/*  397 */     monster.spawnMe(TransferType.SOMMON);
/*  398 */     return monster.getMonsterId();
/*      */   }
/*      */   
/*      */   private void initMapItem(SMapConfig mapConfig, boolean skipControllerRegis)
/*      */   {
/*  403 */     Set<Integer> mapItems = MapPrototype.getMapItems(mapConfig);
/*  404 */     if (mapItems == null)
/*      */     {
/*  406 */       return;
/*      */     }
/*      */     
/*  409 */     for (Iterator i$ = mapItems.iterator(); i$.hasNext();) { mapItemCfgid = (Integer)i$.next();
/*      */       
/*  411 */       SMapItemCfg mapItemCfg = SMapItemCfg.get(mapItemCfgid.intValue());
/*  412 */       SMapItemConfig mapItemConfig = SMapItemConfig.get(mapItemCfgid.intValue());
/*  413 */       if ((mapItemCfg != null) && (mapItemConfig != null))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  418 */         Controller controller = this.worldInstance.getController(mapItemCfg.controllerId);
/*  419 */         if (mapItemConfig.visibleByTaskState.isEmpty())
/*      */         {
/*  421 */           if ((controller != null) && (!skipControllerRegis))
/*      */           {
/*  423 */             controller.addRefreshObject(new MapItemControllerObject(mapItemCfgid.intValue()));
/*      */           }
/*      */           
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/*  430 */           List<Position> positions = MapItemControllerObject.getBornPositions(mapItemConfig);
/*  431 */           for (Position pos : positions)
/*      */           {
/*  433 */             MapItem mine = new MapItem(mapItemCfgid.intValue());
/*  434 */             mine.setPosition(pos.getX(), pos.getY(), pos.getZ(), this.instanceId);
/*  435 */             mine.spawnMe(TransferType.SOMMON);
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     Integer mapItemCfgid; }
/*      */   
/*  442 */   void initId(SMapConfig mapConfig) { if (MapPrototype.isWorldMap(mapConfig))
/*      */     {
/*  444 */       return;
/*      */     }
/*      */     
/*  447 */     this.instanceId = sceneIdGenerator.nextId();
/*      */   }
/*      */   
/*      */   public int getId()
/*      */   {
/*  452 */     return this.instanceId;
/*      */   }
/*      */   
/*      */   public MapPrototype getMapPrototype()
/*      */   {
/*  457 */     return this.prototype;
/*      */   }
/*      */   
/*      */   public int getCfgId()
/*      */   {
/*  462 */     return this.prototype.getTemplateId();
/*      */   }
/*      */   
/*      */   public SMapConfig getMapConfig()
/*      */   {
/*  467 */     return this.prototype.getMapConfig();
/*      */   }
/*      */   
/*      */   public int getDarkMonsterTableId()
/*      */   {
/*  472 */     return this.prototype.getDarkMonsterTableId();
/*      */   }
/*      */   
/*      */   public int start()
/*      */   {
/*  477 */     SMapConfig mapConfig = this.prototype.getMapConfig();
/*  478 */     if (mapConfig == null)
/*      */     {
/*  480 */       throw new NullPointerException(String.format("map config is null|map_cfgid=%d", new Object[] { Integer.valueOf(getCfgId()) }));
/*      */     }
/*      */     
/*  483 */     initId(mapConfig);
/*      */     
/*  485 */     SceneManager.getInstance().addScene(this);
/*      */     
/*  487 */     this.worldInstance.addScene(this);
/*      */     
/*  489 */     boolean skipControllerRegis = !this.worldInstance.addInitializedMapCfgid(mapConfig.id);
/*      */     
/*  491 */     initNPC(mapConfig, skipControllerRegis);
/*      */     
/*  493 */     initVisibleMonster(mapConfig, skipControllerRegis);
/*      */     
/*  495 */     initMapItem(mapConfig, skipControllerRegis);
/*      */     
/*  497 */     initTransforObject(mapConfig, skipControllerRegis);
/*      */     
/*  499 */     return this.instanceId;
/*      */   }
/*      */   
/*      */   private void resetSceneProtectObserver()
/*      */   {
/*  504 */     if (this.sceneProtectObserver != null)
/*      */     {
/*  506 */       this.sceneProtectObserver.stopTimer();
/*  507 */       this.sceneProtectObserver = null;
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
/*      */   public void stop(boolean forceStop, boolean fromWorldInstance)
/*      */   {
/*  521 */     if ((!forceStop) && (this.roleSet.size() > 0))
/*      */     {
/*  523 */       resetSceneProtectObserver();
/*      */       
/*  525 */       return;
/*      */     }
/*      */     
/*  528 */     if (!fromWorldInstance)
/*      */     {
/*  530 */       this.worldInstance.onReleaseScene(this);
/*      */     }
/*      */     
/*  533 */     release();
/*      */   }
/*      */   
/*      */   void kickAllRole()
/*      */   {
/*  538 */     int gridRows = this.grids.length;
/*  539 */     for (int i = 0; i < gridRows; i++)
/*      */     {
/*  541 */       int gridCols = this.grids[i].length;
/*  542 */       for (int j = 0; j < gridCols; j++)
/*      */       {
/*  544 */         this.grids[i][j].kickOutAllRole();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   boolean isDestroyed()
/*      */   {
/*  551 */     return this.destroyed;
/*      */   }
/*      */   
/*      */   void release()
/*      */   {
/*  556 */     if (this.destroyed)
/*      */     {
/*  558 */       return;
/*      */     }
/*      */     
/*      */ 
/*      */     try
/*      */     {
/*  564 */       if (this.isRepeatLazyInit)
/*      */       {
/*  566 */         this.worldInstance.lazyInit(getCfgId());
/*      */       }
/*      */       
/*  569 */       kickAllRole();
/*      */       
/*      */ 
/*  572 */       if (!this.npcSet.isEmpty())
/*      */       {
/*  574 */         List<Integer> npcInstanceids = new ArrayList(this.npcSet);
/*  575 */         for (Integer npcInstanceid : npcInstanceids)
/*      */         {
/*  577 */           MapNPC npc = MapObjectInstanceManager.getInstance().getMapNpc(npcInstanceid.intValue());
/*  578 */           if (npc != null)
/*      */           {
/*      */ 
/*      */ 
/*  582 */             npc.destroy();
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*  587 */       if (!this.monsterSet.isEmpty())
/*      */       {
/*  589 */         List<Integer> monsterInstanceids = new ArrayList(this.monsterSet);
/*  590 */         for (Integer monsterInstanceid : monsterInstanceids)
/*      */         {
/*  592 */           MapMonster monster = MapObjectInstanceManager.getInstance().getMapMonster(monsterInstanceid.intValue());
/*  593 */           if (monster != null)
/*      */           {
/*      */ 
/*      */ 
/*  597 */             monster.destroy();
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*  602 */       if (!this.itemSet.isEmpty())
/*      */       {
/*  604 */         List<Integer> itemInstanceids = new ArrayList(this.itemSet);
/*  605 */         for (Integer itemInstanceid : itemInstanceids)
/*      */         {
/*  607 */           MapItem item = MapObjectInstanceManager.getInstance().getMapItem(itemInstanceid.intValue());
/*  608 */           if (item != null)
/*      */           {
/*      */ 
/*      */ 
/*  612 */             item.destroy();
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*  617 */       if (!this.transferZoneObjectSet.isEmpty())
/*      */       {
/*  619 */         List<Integer> transferObjInstanceids = new ArrayList(this.transferZoneObjectSet);
/*  620 */         for (Integer transferObjInstanceid : transferObjInstanceids)
/*      */         {
/*  622 */           MapTransferZoneObject transferObj = MapObjectInstanceManager.getInstance().getMapTransferZoneObject(transferObjInstanceid.intValue());
/*      */           
/*  624 */           if (transferObj != null)
/*      */           {
/*      */ 
/*      */ 
/*  628 */             transferObj.destroy();
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*  633 */       for (Map.Entry<Integer, Set<Long>> entry : this.entityTypeToEntities.entrySet())
/*      */       {
/*  635 */         Set<Long> entityInstanceSet = (Set)entry.getValue();
/*  636 */         if (!entityInstanceSet.isEmpty())
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*  641 */           entityType = ((Integer)entry.getKey()).intValue();
/*  642 */           List<Long> instanceids = new ArrayList(entityInstanceSet);
/*  643 */           for (Long entityInstanceId : instanceids)
/*      */           {
/*  645 */             MapEntity mapEntity = MapObjectInstanceManager.getInstance().getMapEntity(entityType, entityInstanceId.longValue());
/*      */             
/*  647 */             if (mapEntity != null)
/*      */             {
/*      */ 
/*      */ 
/*  651 */               mapEntity.destroy(); }
/*      */           }
/*      */         } }
/*      */       int entityType;
/*  655 */       resetSceneProtectObserver();
/*      */       
/*  657 */       if (this.pkZone != null)
/*      */       {
/*  659 */         this.pkZone.release();
/*  660 */         this.pkZone = null;
/*      */       }
/*      */       
/*  663 */       Iterator<Map.Entry<Integer, EventZone>> iter = this.regisEventZoneMap.entrySet().iterator();
/*  664 */       while (iter.hasNext())
/*      */       {
/*  666 */         ((EventZone)((Map.Entry)iter.next()).getValue()).release();
/*  667 */         iter.remove();
/*      */       }
/*      */       
/*  670 */       if (this.meetMonsterManager != null)
/*      */       {
/*  672 */         this.meetMonsterManager.release();
/*  673 */         this.meetMonsterManager = null;
/*      */       }
/*      */       
/*  676 */       this.cellsMap.clear();
/*  677 */       this.cellsMap = null;
/*  678 */       int gridRows = this.grids.length;
/*  679 */       for (int i = 0; i < gridRows; i++)
/*      */       {
/*  681 */         int gridCols = this.grids[i].length;
/*  682 */         for (int j = 0; j < gridCols; j++)
/*      */         {
/*  684 */           this.grids[i][j].release();
/*      */         }
/*      */       }
/*      */       
/*  688 */       GameServer.logger().info(String.format("[map]Scene.release@scene release done|sceneid=%d|map_cfgid=%d", new Object[] { Integer.valueOf(this.instanceId), Integer.valueOf(getCfgId()) }));
/*      */       
/*      */ 
/*      */ 
/*  692 */       this.grids = ((Grid[][])null);
/*  693 */       this.worldInstance = null;
/*  694 */       this.prototype = null;
/*      */     }
/*      */     finally
/*      */     {
/*  698 */       this.destroyed = true;
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean add(MapEntity mapEntity)
/*      */   {
/*  704 */     MapEntityType enumEntityType = mapEntity.getEntityType();
/*  705 */     int entityType = enumEntityType.ordinal();
/*  706 */     Set<Long> entities = (Set)this.entityTypeToEntities.get(Integer.valueOf(entityType));
/*  707 */     if (entities == null)
/*      */     {
/*  709 */       entities = new HashSet();
/*  710 */       this.entityTypeToEntities.put(Integer.valueOf(entityType), entities);
/*      */     }
/*  712 */     return entities.add(mapEntity.getInstanceid());
/*      */   }
/*      */   
/*      */   private void onEnter(SceneObject obj, TransferType type)
/*      */   {
/*  717 */     Position pos = obj.getPositionForInner();
/*  718 */     Grid grid = getGrid(pos);
/*  719 */     if (grid == null)
/*      */     {
/*  721 */       logger.error(String.format("[map]Scene.onEnter@map grid pos out of boundary|map_cfgid=%d|x=%d|y=%d|scene_objid=%s", new Object[] { Integer.valueOf(this.prototype.getTemplateId()), Integer.valueOf(pos.getX()), Integer.valueOf(pos.getY()), obj.getObjectId().toString() }));
/*      */       
/*  723 */       return;
/*      */     }
/*      */     
/*  726 */     obj.setGrid(grid);
/*  727 */     if ((obj instanceof MapTransferZoneObject))
/*      */     {
/*  729 */       this.transferZoneObjectSet.add(Integer.valueOf(((MapTransferZoneObject)obj).getTransferZoneId()));
/*  730 */       broadcast(obj.createEnterView());
/*      */       
/*  732 */       return;
/*      */     }
/*  734 */     if ((obj instanceof MapEntity))
/*      */     {
/*  736 */       MapEntity mapEntity = (MapEntity)obj;
/*  737 */       if (!mapEntity.getEntityType().isOwnView())
/*      */       {
/*  739 */         add(mapEntity);
/*  740 */         broadcast(obj.createEnterView());
/*  741 */         return;
/*      */       }
/*      */     }
/*      */     
/*  745 */     if ((obj instanceof MapRole))
/*      */     {
/*  747 */       this.roleSet.add(Long.valueOf(((MapRole)obj).getRoleId()));
/*      */     }
/*  749 */     else if ((obj instanceof MapNPC))
/*      */     {
/*  751 */       this.npcSet.add(Integer.valueOf(((MapNPC)obj).getNpcId()));
/*      */     }
/*  753 */     else if ((obj instanceof MapMonster))
/*      */     {
/*  755 */       this.monsterSet.add(Integer.valueOf(((MapMonster)obj).getMonsterId()));
/*      */     }
/*  757 */     else if ((obj instanceof MapItem))
/*      */     {
/*  759 */       this.itemSet.add(Integer.valueOf(((MapItem)obj).getItemId()));
/*      */     }
/*  761 */     else if ((obj instanceof MapEntity))
/*      */     {
/*  763 */       add((MapEntity)obj);
/*      */     }
/*      */     
/*  766 */     grid.addSceneObj(obj);
/*      */     
/*  768 */     grid.testView(obj);
/*      */   }
/*      */   
/*      */   public Set<Long> getRoleIds()
/*      */   {
/*  773 */     Set<Long> roles = new HashSet();
/*  774 */     int gridRows = this.grids.length;
/*  775 */     for (int i = 0; i < gridRows; i++)
/*      */     {
/*  777 */       int gridCols = this.grids[i].length;
/*  778 */       for (int j = 0; j < gridCols; j++)
/*      */       {
/*  780 */         Collection<Long> gridRoleIds = this.grids[i][j].getAllRoleIds();
/*  781 */         if (gridRoleIds != null)
/*      */         {
/*      */ 
/*      */ 
/*  785 */           roles.addAll(gridRoleIds);
/*      */         }
/*      */       }
/*      */     }
/*  789 */     return roles;
/*      */   }
/*      */   
/*      */   public void broadcast(Protocol protocol)
/*      */   {
/*  794 */     if (this.roleSet.size() > 0)
/*      */     {
/*  796 */       MapProtocolSendQueue.getInstance().sendMulti(new ArrayList(this.roleSet), protocol);
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean remove(MapEntity mapEntity)
/*      */   {
/*  802 */     MapEntityType enumEntityType = mapEntity.getEntityType();
/*  803 */     int entityType = enumEntityType.ordinal();
/*  804 */     Set<Long> entities = (Set)this.entityTypeToEntities.get(Integer.valueOf(entityType));
/*  805 */     if (entities != null)
/*      */     {
/*  807 */       return entities.remove(mapEntity.getInstanceid());
/*      */     }
/*      */     
/*  810 */     return false;
/*      */   }
/*      */   
/*      */   private void onLeave(SceneObject obj)
/*      */   {
/*  815 */     if ((obj instanceof MapTransferZoneObject))
/*      */     {
/*  817 */       obj.clearView();
/*  818 */       obj.setGrid(null);
/*      */       
/*  820 */       this.transferZoneObjectSet.remove(Integer.valueOf(((MapTransferZoneObject)obj).getTransferZoneId()));
/*  821 */       broadcast(obj.createLeaveView());
/*      */       
/*  823 */       return;
/*      */     }
/*  825 */     if ((obj instanceof MapEntity))
/*      */     {
/*  827 */       MapEntity mapEntity = (MapEntity)obj;
/*  828 */       if (!mapEntity.getEntityType().isOwnView())
/*      */       {
/*  830 */         obj.clearView();
/*  831 */         obj.setGrid(null);
/*      */         
/*  833 */         remove(mapEntity);
/*      */         
/*  835 */         broadcast(obj.createLeaveView());
/*      */         
/*  837 */         return;
/*      */       }
/*      */     }
/*      */     
/*  841 */     Grid grid = obj.getGrid();
/*  842 */     if (grid != null)
/*      */     {
/*  844 */       grid.removeSceneObj(obj);
/*      */     }
/*  846 */     obj.clearView();
/*  847 */     obj.setGrid(null);
/*      */     
/*  849 */     if ((obj instanceof MapRole))
/*      */     {
/*  851 */       this.roleSet.remove(Long.valueOf(((MapRole)obj).getRoleId()));
/*      */       
/*  853 */       if (this.pkZone != null)
/*      */       {
/*  855 */         this.pkZone.leaveRole((MapRole)obj);
/*      */       }
/*      */     }
/*  858 */     else if ((obj instanceof MapNPC))
/*      */     {
/*  860 */       this.npcSet.remove(Integer.valueOf(((MapNPC)obj).getNpcId()));
/*      */     }
/*  862 */     else if ((obj instanceof MapMonster))
/*      */     {
/*  864 */       this.monsterSet.remove(Integer.valueOf(((MapMonster)obj).getMonsterId()));
/*      */     }
/*  866 */     else if ((obj instanceof MapItem))
/*      */     {
/*  868 */       this.itemSet.remove(Integer.valueOf(((MapItem)obj).getItemId()));
/*      */     }
/*  870 */     else if ((obj instanceof MapEntity))
/*      */     {
/*  872 */       remove((MapEntity)obj);
/*      */       
/*  874 */       if (this.pkZone != null)
/*      */       {
/*  876 */         this.pkZone.leaveEntity((MapEntity)obj);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void update()
/*      */   {
/*  883 */     tryRelease();
/*      */   }
/*      */   
/*      */   private void tryRelease()
/*      */   {
/*  888 */     if (!isFuBen())
/*      */     {
/*  890 */       return;
/*      */     }
/*      */     
/*  893 */     if (!this.isAutoRelease)
/*      */     {
/*  895 */       return;
/*      */     }
/*      */     
/*  898 */     if (!this.roleSet.isEmpty())
/*      */     {
/*  900 */       return;
/*      */     }
/*      */     
/*  903 */     if (MapConfiguration.SCENE_PROTECT_DURATION <= 0L)
/*      */     {
/*  905 */       stop(true, false);
/*      */       
/*  907 */       return;
/*      */     }
/*      */     
/*  910 */     if (this.sceneProtectObserver == null)
/*      */     {
/*  912 */       this.sceneProtectObserver = new SceneProtectObserver(this.instanceId);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeRole(MapRole role)
/*      */   {
/*  918 */     onLeave(role);
/*      */     
/*  920 */     removeRoleFormChannel(role);
/*      */     
/*      */ 
/*  923 */     sendTransferLeaveViewToRole(role);
/*      */     
/*      */ 
/*  926 */     sendNotOwnViewMapEntityLeaveViewToRole(role);
/*      */     
/*  928 */     tryRelease();
/*      */   }
/*      */   
/*      */   public void removeSceneObject(SceneObject obj)
/*      */   {
/*  933 */     onLeave(obj);
/*      */   }
/*      */   
/*      */   private void addRole(MapRole role, int channelid, TransferType type)
/*      */   {
/*  938 */     addRoleIntoChannel(role, channelid);
/*      */     
/*      */ 
/*  941 */     sendWorldShareMapEntityEnterViewToRole(role);
/*      */     
/*      */ 
/*  944 */     sendNotOwnViewMapEntityEnterViewToRole(role);
/*      */     
/*      */ 
/*  947 */     sendTransferEnterViewToRole(role);
/*      */     
/*  949 */     onEnter(role, type);
/*      */     
/*  951 */     this.worldInstance.onRoleJoin(role.getRoleId());
/*      */     
/*  953 */     resetSceneProtectObserver();
/*      */   }
/*      */   
/*      */   public void addSceneObject(SceneObject obj, TransferType type)
/*      */   {
/*  958 */     addSceneObject(obj, Integer.MAX_VALUE, type);
/*      */   }
/*      */   
/*      */   public void addSceneObject(SceneObject obj, int channelid, TransferType type)
/*      */   {
/*  963 */     if (isDestroyed())
/*      */     {
/*  965 */       return;
/*      */     }
/*      */     
/*  968 */     if ((obj instanceof MapRole))
/*      */     {
/*  970 */       addRole((MapRole)obj, channelid, type);
/*  971 */       return;
/*      */     }
/*      */     
/*  974 */     onEnter(obj, type);
/*      */   }
/*      */   
/*      */   public Grid getGrid(Position pos)
/*      */   {
/*  979 */     return getGrid(pos.getX(), pos.getY());
/*      */   }
/*      */   
/*      */   public Grid getGrid(int x, int y)
/*      */   {
/*  984 */     return getGrid(this.prototype.getMapConfig(), x, y);
/*      */   }
/*      */   
/*      */   public Grid getGrid(SMapConfig mapConfig, int x, int y)
/*      */   {
/*  989 */     if (mapConfig == null)
/*      */     {
/*  991 */       return null;
/*      */     }
/*      */     
/*  994 */     int row = y / mapConfig.cellHeight / MapConfiguration.GRID_SIZE;
/*  995 */     int col = x / mapConfig.cellWidth / MapConfiguration.GRID_SIZE;
/*  996 */     if ((row < 0) || (row >= this.grids.length) || (col < 0) || (col >= this.grids[row].length))
/*      */     {
/*  998 */       return null;
/*      */     }
/*      */     
/* 1001 */     return this.grids[row][col];
/*      */   }
/*      */   
/*      */   public List<Grid> getGrids(Position pos, int radius)
/*      */   {
/* 1006 */     return getGrids(pos.getX(), pos.getY(), radius);
/*      */   }
/*      */   
/*      */   public List<Grid> getGrids(int x, int y, int radius)
/*      */   {
/* 1011 */     return getGrids(this.prototype.getMapConfig(), x, y, radius);
/*      */   }
/*      */   
/*      */   public List<Grid> getGrids(SMapConfig mapConfig, int x, int y, int radius)
/*      */   {
/* 1016 */     if ((mapConfig == null) || (radius <= 0))
/*      */     {
/* 1018 */       return null;
/*      */     }
/*      */     
/* 1021 */     int row = y / mapConfig.cellHeight / MapConfiguration.GRID_SIZE;
/* 1022 */     int col = x / mapConfig.cellWidth / MapConfiguration.GRID_SIZE;
/* 1023 */     if ((row < 0) || (row >= this.grids.length) || (col < 0) || (col >= this.grids[row].length))
/*      */     {
/* 1025 */       return null;
/*      */     }
/*      */     
/* 1028 */     List<Grid> retGrids = new ArrayList();
/* 1029 */     int gridRows = this.grids.length;
/* 1030 */     int gridCols = this.grids[row].length;
/* 1031 */     for (int offsetCol = -radius; offsetCol <= radius; offsetCol++)
/*      */     {
/* 1033 */       for (int offsetRow = -radius; offsetRow <= radius; offsetRow++)
/*      */       {
/* 1035 */         int newCol = col + offsetCol;
/* 1036 */         int newRow = row + offsetRow;
/* 1037 */         if ((newCol >= 0) && (newRow >= 0) && (newCol < gridCols) && (newRow < gridRows))
/*      */         {
/* 1039 */           retGrids.add(this.grids[newRow][newCol]);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1044 */     return retGrids;
/*      */   }
/*      */   
/*      */   public String getName()
/*      */   {
/* 1049 */     return this.prototype.getName();
/*      */   }
/*      */   
/*      */   public boolean isReachable(SMapConfig mapConfig, int x, int y)
/*      */   {
/* 1054 */     Cell cell = getCell(mapConfig, x, y);
/* 1055 */     if (cell == null)
/*      */     {
/* 1057 */       return false;
/*      */     }
/* 1059 */     return cell.isReachable();
/*      */   }
/*      */   
/*      */   public Cell createCellIfNeed(int x, int y)
/*      */   {
/* 1064 */     return createCellIfNeed(getMapConfig(), x, y);
/*      */   }
/*      */   
/*      */   public Cell createCellIfNeed(SMapConfig mapConfig, int x, int y)
/*      */   {
/* 1069 */     return createCellIfNeedForSelf(mapConfig, x / mapConfig.cellWidth, y / mapConfig.cellHeight);
/*      */   }
/*      */   
/*      */   public Cell createCellIfNeedForSelf(int col, int row)
/*      */   {
/* 1074 */     return createCellIfNeedForSelf(getMapConfig(), col, row);
/*      */   }
/*      */   
/*      */   public Cell createCellIfNeedForSelf(SMapConfig mapConfig, int col, int row)
/*      */   {
/* 1079 */     Cell cell = getCellForSelfByColRow(mapConfig, col, row);
/* 1080 */     if (cell.isPrototypeCell())
/*      */     {
/* 1082 */       cell = new Cell(MapPrototype.getCellPrototype(mapConfig, col, row));
/*      */       
/* 1084 */       Map<Integer, Cell> cells = (Map)this.cellsMap.get(Integer.valueOf(col));
/* 1085 */       if (cells == null)
/*      */       {
/* 1087 */         cells = new HashMap();
/* 1088 */         this.cellsMap.put(Integer.valueOf(col), cells);
/*      */       }
/* 1090 */       cells.put(Integer.valueOf(row), cell);
/*      */     }
/*      */     
/* 1093 */     return cell;
/*      */   }
/*      */   
/*      */   public Cell getCell(int x, int y)
/*      */   {
/* 1098 */     return getCellForSelfByColRow(getMapConfig(), x, y);
/*      */   }
/*      */   
/*      */   public Cell getCell(SMapConfig mapConfig, int x, int y)
/*      */   {
/* 1103 */     return getCellForSelfByColRow(mapConfig, x / mapConfig.cellWidth, y / mapConfig.cellHeight);
/*      */   }
/*      */   
/*      */   public Cell getCellByColRow(int col, int row)
/*      */   {
/* 1108 */     return getCellByColRow(getMapConfig(), col, row);
/*      */   }
/*      */   
/*      */   public Cell getCellByColRow(SMapConfig mapConfig, int col, int row)
/*      */   {
/* 1113 */     return getCellForSelfByColRow(mapConfig, col, row);
/*      */   }
/*      */   
/*      */   private Cell getCellForSelfByColRow(SMapConfig mapConfig, int col, int row)
/*      */   {
/* 1118 */     Map<Integer, Cell> cellMap = (Map)this.cellsMap.get(Integer.valueOf(col));
/* 1119 */     if (cellMap != null)
/*      */     {
/* 1121 */       Cell cell = (Cell)cellMap.get(Integer.valueOf(row));
/* 1122 */       if (cell != null)
/*      */       {
/* 1124 */         return cell;
/*      */       }
/*      */     }
/*      */     
/* 1128 */     return MapPrototype.getCellPrototype(mapConfig, col, row);
/*      */   }
/*      */   
/*      */   boolean isOutBoundary(SMapConfig mapConfig, int cellCol, int cellRow)
/*      */   {
/* 1133 */     if ((cellCol < 0) || (cellRow < 0))
/*      */     {
/* 1135 */       return false;
/*      */     }
/*      */     
/* 1138 */     if ((cellCol >= mapConfig.cellCols) || (cellRow >= mapConfig.cellRows))
/*      */     {
/* 1140 */       return false;
/*      */     }
/*      */     
/* 1143 */     return true;
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
/*      */   private Cell getReachableCell(SMapConfig mapConfig, int cx, int cy)
/*      */   {
/* 1156 */     int cellWidth = mapConfig.cellWidth;
/* 1157 */     int cellHeight = mapConfig.cellHeight;
/* 1158 */     int col = cx / cellWidth;
/* 1159 */     int row = cy / cellHeight;
/* 1160 */     Cell cell = getCellForSelfByColRow(mapConfig, col, row);
/* 1161 */     if (cell.isReachable())
/*      */     {
/* 1163 */       return cell;
/*      */     }
/*      */     
/* 1166 */     int colr = cx % cellWidth;
/* 1167 */     int rowr = cy % cellHeight;
/*      */     
/*      */ 
/*      */ 
/* 1171 */     int min = 5;
/* 1172 */     int max = 11;
/* 1173 */     int[] colArray; int[] colArray; if (colr <= min)
/*      */     {
/* 1175 */       colArray = new int[] { col - 1, col };
/*      */     } else { int[] colArray;
/* 1177 */       if (colr >= max)
/*      */       {
/* 1179 */         colArray = new int[] { col, col + 1 };
/*      */       }
/*      */       else
/*      */       {
/* 1183 */         colArray = new int[] { col }; }
/*      */     }
/*      */     int[] rowArray;
/*      */     int[] rowArray;
/* 1187 */     if (rowr <= min)
/*      */     {
/* 1189 */       rowArray = new int[] { row - 1, row };
/*      */     } else { int[] rowArray;
/* 1191 */       if (rowr >= max)
/*      */       {
/* 1193 */         rowArray = new int[] { row, row + 1 };
/*      */       }
/*      */       else
/*      */       {
/* 1197 */         rowArray = new int[] { row };
/*      */       }
/*      */     }
/* 1200 */     for (int tmpCol : colArray)
/*      */     {
/* 1202 */       if ((tmpCol >= 0) && (tmpCol < mapConfig.cellCols))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1207 */         for (int tmpRow : rowArray)
/*      */         {
/* 1209 */           if ((tmpRow >= 0) && (tmpRow <= mapConfig.cellRows))
/*      */           {
/*      */ 
/*      */ 
/* 1213 */             Cell tmpcell = getCellForSelfByColRow(mapConfig, tmpCol, tmpRow);
/* 1214 */             if (tmpcell.isReachable())
/*      */             {
/* 1216 */               return tmpcell; }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 1221 */     return cell;
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
/*      */   public List<Cell> bresenhamLine(int cx, int cy, int tx, int ty)
/*      */   {
/* 1235 */     SMapConfig mapConfig = this.prototype.getMapConfig();
/* 1236 */     if (mapConfig == null)
/*      */     {
/* 1238 */       logger.error(String.format("[map]Scene.bresenhamLine@map config is null|map_cfgid", new Object[] { Integer.valueOf(getCfgId()) }));
/* 1239 */       return null;
/*      */     }
/*      */     
/* 1242 */     int cellWidth = mapConfig.cellWidth;
/* 1243 */     int cellHeight = mapConfig.cellHeight;
/* 1244 */     if (!isOutBoundary(mapConfig, cx / cellWidth, cy / cellHeight))
/*      */     {
/* 1246 */       logger.error(String.format("[map]Scene.bresenhamLine@key point out of boundary|map_cfgid=%d|x=%d|y=%d", new Object[] { Integer.valueOf(getCfgId()), Integer.valueOf(cx), Integer.valueOf(cy) }));
/*      */       
/* 1248 */       return null;
/*      */     }
/* 1250 */     if (!isOutBoundary(mapConfig, tx / cellWidth, ty / cellHeight))
/*      */     {
/* 1252 */       logger.error(String.format("[map]Scene.bresenhamLine@key point out of boundary|map_cfgid=%d|x=%d|y=%d", new Object[] { Integer.valueOf(getCfgId()), Integer.valueOf(tx), Integer.valueOf(ty) }));
/*      */       
/* 1254 */       return null;
/*      */     }
/*      */     
/* 1257 */     Cell cell0 = getReachableCell(mapConfig, cx, cy);
/* 1258 */     if (cell0 == null)
/*      */     {
/* 1260 */       logger.error(String.format("[map]Scene.bresenhamLine@get reachable cell of key point return null|map_cfgid=%d|x=%d|y=%d", new Object[] { Integer.valueOf(getCfgId()), Integer.valueOf(cx), Integer.valueOf(cy) }));
/*      */       
/*      */ 
/* 1263 */       return null;
/*      */     }
/* 1265 */     if (!cell0.isReachable())
/*      */     {
/* 1267 */       logger.error(String.format("[map]Scene.bresenhamLine@key point not reachable|map_cfgid=%d|x=%d|y=%d", new Object[] { Integer.valueOf(getCfgId()), Integer.valueOf(cx), Integer.valueOf(cy) }));
/*      */       
/* 1269 */       return null;
/*      */     }
/*      */     
/* 1272 */     Cell cell1 = getReachableCell(mapConfig, tx, ty);
/* 1273 */     if (cell1 == null)
/*      */     {
/* 1275 */       logger.error(String.format("[map]Scene.bresenhamLine@get reachable cell of key point return null|map_cfgid=%d|x=%d|y=%d", new Object[] { Integer.valueOf(getCfgId()), Integer.valueOf(tx), Integer.valueOf(ty) }));
/*      */       
/*      */ 
/*      */ 
/* 1279 */       return null;
/*      */     }
/* 1281 */     if (!cell1.isReachable())
/*      */     {
/* 1283 */       logger.error(String.format("[map]Scene.bresenhamLine@key point not reachable|map_cfgid=%d|x=%d|y=%d", new Object[] { Integer.valueOf(getCfgId()), Integer.valueOf(tx), Integer.valueOf(ty) }));
/*      */       
/*      */ 
/* 1286 */       return null;
/*      */     }
/*      */     
/* 1289 */     int delta = 1;
/*      */     
/* 1291 */     int x0 = cx;
/* 1292 */     int y0 = cy;
/* 1293 */     int x1 = tx;
/* 1294 */     int y1 = ty;
/* 1295 */     List<Cell> pathList = new ArrayList();
/* 1296 */     Set<Cell> pathSet = new HashSet();
/* 1297 */     pathSet.add(cell0);
/* 1298 */     pathList.add(cell0);
/*      */     
/* 1300 */     boolean flag = Math.abs(y1 - y0) > Math.abs(x1 - x0);
/* 1301 */     if (flag)
/*      */     {
/* 1303 */       int t = x0;
/* 1304 */       x0 = y0;
/* 1305 */       y0 = t;
/* 1306 */       t = x1;
/* 1307 */       x1 = y1;
/* 1308 */       y1 = t;
/*      */     }
/* 1310 */     if (x0 > x1)
/*      */     {
/* 1312 */       int t = x0;
/* 1313 */       x0 = x1;
/* 1314 */       x1 = t;
/* 1315 */       t = y0;
/* 1316 */       y0 = y1;
/* 1317 */       y1 = t;
/*      */     }
/* 1319 */     int dx = x1 - x0;
/* 1320 */     int dy = Math.abs(y1 - y0);
/* 1321 */     int e = dx / 2;
/* 1322 */     int x = x0; for (int y = y0; x <= x1; x += delta)
/*      */     {
/* 1324 */       Cell pn = null;
/* 1325 */       if (flag)
/*      */       {
/* 1327 */         pn = getReachableCell(mapConfig, y, x);
/*      */       }
/*      */       else
/*      */       {
/* 1331 */         pn = getReachableCell(mapConfig, x, y);
/*      */       }
/* 1333 */       if (!pn.isReachable())
/*      */       {
/* 1335 */         logger.warn("经过不可达格子 x = " + x + " y= " + y);
/* 1336 */         return null;
/*      */       }
/* 1338 */       if (pathSet.add(pn))
/*      */       {
/* 1340 */         pathList.add(pn);
/*      */       }
/* 1342 */       e -= dy;
/* 1343 */       if (e < 0)
/*      */       {
/* 1345 */         if (y0 < y1)
/*      */         {
/* 1347 */           y += delta;
/*      */         }
/*      */         else
/*      */         {
/* 1351 */           y -= delta;
/*      */         }
/* 1353 */         e += dx;
/*      */       }
/*      */     }
/* 1356 */     if (pathSet.add(cell1))
/*      */     {
/* 1358 */       pathList.add(cell1);
/*      */     }
/* 1360 */     return pathList;
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
/*      */   public int registerZoneEvent(ZoneForm zoneForm, int spaceFlags, IInnerZoneListener listener)
/*      */   {
/* 1373 */     SMapConfig mapConfig = this.prototype.getMapConfig();
/* 1374 */     if (mapConfig == null)
/*      */     {
/* 1376 */       return -1;
/*      */     }
/*      */     
/* 1379 */     int id = this.eventIdGen++;
/* 1380 */     EventZone zone = new EventZone(zoneForm, spaceFlags);
/* 1381 */     zone.addZoneListener(listener);
/* 1382 */     this.regisEventZoneMap.put(Integer.valueOf(id), zone);
/*      */     
/* 1384 */     int cellWidth = mapConfig.cellWidth;
/* 1385 */     int cellHeight = mapConfig.cellHeight;
/*      */     
/* 1387 */     for (int i = 0; i < mapConfig.cellCols; i++)
/*      */     {
/* 1389 */       for (int j = 0; j < mapConfig.cellRows; j++)
/*      */       {
/* 1391 */         int ax = i * cellWidth;
/* 1392 */         int ay = j * cellHeight;
/* 1393 */         int bx = (i + 1) * cellWidth;
/* 1394 */         int by = (j + 1) * cellHeight;
/* 1395 */         if (zone.intersectsRectangle(ax, bx, ay, by))
/*      */         {
/* 1397 */           Cell cell = createCellIfNeedForSelf(mapConfig, i, j);
/* 1398 */           cell.addZone(zone);
/* 1399 */           zone.addCell(cell);
/*      */         }
/*      */       }
/*      */     }
/* 1403 */     return id;
/*      */   }
/*      */   
/*      */   public void unregisterZoneEvent(int id)
/*      */   {
/* 1408 */     EventZone zone = (EventZone)this.regisEventZoneMap.remove(Integer.valueOf(id));
/* 1409 */     if (zone != null)
/*      */     {
/* 1411 */       zone.release();
/*      */     }
/*      */   }
/*      */   
/*      */   public static class HandleContext
/*      */   {
/*      */     public FightReason reason;
/* 1418 */     public long doublePointRoleId = -1L;
/*      */   }
/*      */   
/*      */   public void tryMeetMonster(MapRole role)
/*      */   {
/* 1423 */     if (this.meetMonsterManager == null)
/*      */     {
/* 1425 */       role.setMoveDistance(0);
/* 1426 */       return;
/*      */     }
/*      */     
/* 1429 */     SMapConfig mapConfig = this.prototype.getMapConfig();
/* 1430 */     if (mapConfig == null)
/*      */     {
/* 1432 */       role.setMoveDistance(0);
/* 1433 */       return;
/*      */     }
/*      */     
/* 1436 */     int totalDist = role.getMoveDistance();
/* 1437 */     long roleId = role.getRoleId();
/* 1438 */     if (totalDist / mapConfig.cellWidth >= mapConfig.minMeetMonsterCellNum)
/*      */     {
/* 1440 */       if (Xdb.random().nextFloat() <= mapConfig.minMeetMonsterProb)
/*      */       {
/* 1442 */         role.setMoveDistance(0);
/*      */         
/* 1444 */         MapDarkMonsterFightContext context = new MapDarkMonsterFightContext(roleId, getCfgId(), this.worldInstance.getId());
/*      */         
/* 1446 */         new PTryStartDrakMonsterPVEFight(roleId, this.meetMonsterManager, context).execute();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void onRoleMove(long roleId, int x, int y, int z)
/*      */   {
/* 1453 */     this.worldInstance.onRoleMove(roleId, x, y, z, getId());
/*      */   }
/*      */   
/*      */   public Position randomPosFromAllRegions()
/*      */   {
/* 1458 */     Position pos = this.prototype.randomPosFromAllRegions();
/* 1459 */     if (pos == null)
/*      */     {
/* 1461 */       return null;
/*      */     }
/* 1463 */     pos.setSceneId(getId());
/* 1464 */     return pos;
/*      */   }
/*      */   
/*      */   public Position randomPosFromRegion(int regionCfgid)
/*      */   {
/* 1469 */     Position pos = this.prototype.randomPosFromRegion(regionCfgid);
/* 1470 */     pos.setSceneId(getId());
/* 1471 */     return pos;
/*      */   }
/*      */   
/*      */   public Position randomPosFromAirRegion(int regionCfgid)
/*      */   {
/* 1476 */     Position pos = this.prototype.randomPosFromAirRegion(regionCfgid);
/* 1477 */     pos.setSceneId(getId());
/* 1478 */     return pos;
/*      */   }
/*      */   
/*      */   public Position randomPos()
/*      */   {
/* 1483 */     return this.prototype.randomPos(this.instanceId);
/*      */   }
/*      */   
/*      */   public Position randomPosInAir()
/*      */   {
/* 1488 */     return this.prototype.randomPosInAir(this.instanceId);
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
/*      */   public List<Position> getPositionsInRect(int x, int y, int w, int h, int size)
/*      */   {
/* 1503 */     SMapConfig mapConfig = this.prototype.getMapConfig();
/* 1504 */     if (mapConfig == null)
/*      */     {
/* 1506 */       return null;
/*      */     }
/*      */     
/* 1509 */     int cellCols = mapConfig.cellCols;
/* 1510 */     int cellWidth = mapConfig.cellWidth;
/* 1511 */     int cellHeight = mapConfig.cellHeight;
/* 1512 */     List<Integer> cells = new ArrayList();
/* 1513 */     for (int xx = x; xx < x + w; xx += cellWidth)
/*      */     {
/* 1515 */       for (int yy = y; yy < y + h; yy += cellHeight)
/*      */       {
/* 1517 */         Cell cell = getCell(mapConfig, xx, yy);
/* 1518 */         if (cell != null)
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/* 1523 */           if (cell.isReachable())
/*      */           {
/* 1525 */             int index = xx / cellWidth + yy / cellHeight * cellCols;
/* 1526 */             cells.add(Integer.valueOf(index));
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 1531 */     List<Position> posList = new ArrayList(size);
/* 1532 */     int cellsSize = cells.size();
/* 1533 */     if (cellsSize > 0)
/*      */     {
/* 1535 */       for (int i = 0; i < size; i++)
/*      */       {
/* 1537 */         int cellIndex = ((Integer)cells.get(Xdb.random().nextInt(cellsSize))).intValue();
/*      */         
/* 1539 */         int col = cellIndex % cellCols;
/* 1540 */         int row = cellIndex / cellCols;
/* 1541 */         int xx = col * cellWidth + Xdb.random().nextInt(cellWidth);
/* 1542 */         int yy = row * cellHeight + Xdb.random().nextInt(cellHeight);
/* 1543 */         Position pos = new Position(xx, yy, 0, this.instanceId);
/* 1544 */         posList.add(pos);
/*      */       }
/*      */     }
/* 1547 */     return posList;
/*      */   }
/*      */   
/*      */   public void putMapAiParam(int id, int value)
/*      */   {
/* 1552 */     SWorldAIParam param = SWorldAIParam.get(id);
/* 1553 */     if (param == null)
/*      */     {
/* 1555 */       throw new RuntimeException("do not exist world ai param id = " + id);
/*      */     }
/* 1557 */     if ((param.highLimit < value) || (param.lowLimit > value))
/*      */     {
/* 1559 */       throw new RuntimeException(String.format("[map]Scene.putMapAiParam@set map param id = %d %d not in (%d,%d)|sceneid=%d|map_cfgid=%d", new Object[] { Integer.valueOf(id), Integer.valueOf(value), Integer.valueOf(param.lowLimit), Integer.valueOf(param.highLimit), Integer.valueOf(getId()), Integer.valueOf(this.prototype.getTemplateId()) }));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1564 */     this.worldAiParam.put(Integer.valueOf(id), Integer.valueOf(value));
/*      */   }
/*      */   
/*      */   public int getMapAiParam(int id)
/*      */   {
/* 1569 */     Integer value = (Integer)this.worldAiParam.get(Integer.valueOf(id));
/* 1570 */     if (value == null)
/*      */     {
/* 1572 */       return 0;
/*      */     }
/* 1574 */     return value.intValue();
/*      */   }
/*      */   
/*      */   WorldInstance getWorldInstance()
/*      */   {
/* 1579 */     return this.worldInstance;
/*      */   }
/*      */   
/*      */   public void addBeforeMeetMonsterHandle(MeetDarkMonsterHandle handle)
/*      */   {
/* 1584 */     this.meetMonsterManager.addBefore(handle);
/*      */   }
/*      */   
/*      */   public void removeBeforeMeetMonsterHandle(MeetDarkMonsterHandle handle)
/*      */   {
/* 1589 */     this.meetMonsterManager.removeHandle(handle);
/*      */   }
/*      */   
/*      */   public Position getFlyLandPosition(Position pos)
/*      */   {
/* 1594 */     SMapConfig mapConfig = getMapConfig();
/* 1595 */     if (mapConfig == null)
/*      */     {
/* 1597 */       return null;
/*      */     }
/*      */     
/* 1600 */     int cellIndex = MapPrototype.getNearbyReachableCellIndex(mapConfig, pos.getX(), pos.getY());
/* 1601 */     if (cellIndex < -1)
/*      */     {
/* 1603 */       return null;
/*      */     }
/*      */     
/* 1606 */     if (cellIndex == -1)
/*      */     {
/* 1608 */       return new UnModifyPosition(pos);
/*      */     }
/*      */     
/* 1611 */     return MapPrototype.getPositionByCellIndex(mapConfig, cellIndex);
/*      */   }
/*      */   
/*      */   public Position getFlyLandPositionForInner(Position pos)
/*      */   {
/* 1616 */     SMapConfig mapConfig = getMapConfig();
/* 1617 */     if (mapConfig == null)
/*      */     {
/* 1619 */       return null;
/*      */     }
/*      */     
/* 1622 */     int cellIndex = MapPrototype.getNearbyReachableCellIndex(mapConfig, pos.getX(), pos.getY());
/* 1623 */     if (cellIndex < -1)
/*      */     {
/* 1625 */       return null;
/*      */     }
/*      */     
/* 1628 */     if (cellIndex == -1)
/*      */     {
/* 1630 */       return pos;
/*      */     }
/*      */     
/* 1633 */     return MapPrototype.getPositionByCellIndex(mapConfig, cellIndex);
/*      */   }
/*      */   
/*      */   public PKZone getPkZone()
/*      */   {
/* 1638 */     return this.pkZone;
/*      */   }
/*      */   
/*      */   public WorldInstance getWorld()
/*      */   {
/* 1643 */     return this.worldInstance;
/*      */   }
/*      */   
/*      */   public int getRoleCount()
/*      */   {
/* 1648 */     return this.roleSet.size();
/*      */   }
/*      */   
/*      */   public int getMonsterCount()
/*      */   {
/* 1653 */     return this.monsterSet.size();
/*      */   }
/*      */   
/*      */   public int getMapItemCount()
/*      */   {
/* 1658 */     return this.itemSet.size();
/*      */   }
/*      */   
/*      */   public String getSceneLog()
/*      */   {
/* 1663 */     return String.format("%d/%d/%d", new Object[] { Integer.valueOf(this.npcSet.size()), Integer.valueOf(this.monsterSet.size()), Integer.valueOf(this.itemSet.size()) });
/*      */   }
/*      */   
/*      */   static class SceneProtectObserver extends MilliObserver
/*      */   {
/*      */     private final int sceneInstanceid;
/*      */     
/*      */     public SceneProtectObserver(int sceneInstanceid)
/*      */     {
/* 1672 */       super();
/*      */       
/* 1674 */       this.sceneInstanceid = sceneInstanceid;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean update()
/*      */     {
/* 1680 */       new MMH_DestroyScene(this.sceneInstanceid, false).execute();
/*      */       
/* 1682 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   public List<Long> getRoleList()
/*      */   {
/* 1688 */     return new ArrayList(this.roleSet);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public List<Position> getSurroundScene()
/*      */   {
/* 1698 */     List<Position> positions = new ArrayList();
/* 1699 */     for (Integer transferObjectId : this.transferZoneObjectSet)
/*      */     {
/* 1701 */       MapTransferZoneObject transferZoneObject = MapObjectInstanceManager.getInstance().getMapTransferZoneObject(transferObjectId.intValue());
/*      */       
/* 1703 */       if (transferZoneObject != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1708 */         Position target = transferZoneObject.getPositionForInner();
/* 1709 */         Position position = new Position(target.getX(), target.getY(), 0, transferZoneObject.getTargetSceneId());
/* 1710 */         positions.add(position);
/*      */       }
/*      */     }
/* 1713 */     return positions;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   boolean isNpcExistByCfgId(int cfgid)
/*      */   {
/* 1722 */     for (Integer npcid : this.npcSet)
/*      */     {
/* 1724 */       MapNPC npc = MapObjectInstanceManager.getInstance().getMapNpc(npcid.intValue());
/* 1725 */       if (npc.getCfgId().intValue() == cfgid)
/*      */       {
/* 1727 */         return true;
/*      */       }
/*      */     }
/* 1730 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   boolean isMonsterExistByCfgId(int cfgid)
/*      */   {
/* 1739 */     for (Integer monsterid : this.monsterSet)
/*      */     {
/* 1741 */       MapMonster monster = MapObjectInstanceManager.getInstance().getMapMonster(monsterid.intValue());
/* 1742 */       if (monster.getCfgId().intValue() == cfgid)
/*      */       {
/* 1744 */         return true;
/*      */       }
/*      */     }
/* 1747 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   int getMonsterNumberCfgId(int cfgid)
/*      */   {
/* 1756 */     int count = 0;
/* 1757 */     for (Integer monsterid : this.monsterSet)
/*      */     {
/* 1759 */       MapMonster monster = MapObjectInstanceManager.getInstance().getMapMonster(monsterid.intValue());
/* 1760 */       if (monster.getCfgId().intValue() == cfgid)
/*      */       {
/* 1762 */         count++;
/*      */       }
/*      */     }
/* 1765 */     return count;
/*      */   }
/*      */   
/*      */   public MapNPC getNpcByCfgId(int cfgId)
/*      */   {
/* 1770 */     for (Integer npcid : this.npcSet)
/*      */     {
/* 1772 */       MapNPC npc = MapObjectInstanceManager.getInstance().getMapNpc(npcid.intValue());
/* 1773 */       if (npc != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1778 */         if (npc.getCfgId().intValue() == cfgId)
/*      */         {
/* 1780 */           return npc; }
/*      */       }
/*      */     }
/* 1783 */     return null;
/*      */   }
/*      */   
/*      */   public List<MapMonster> getMonsterByCfgId(int cfgId)
/*      */   {
/* 1788 */     List<MapMonster> monsters = new ArrayList();
/* 1789 */     for (Integer monsterid : this.monsterSet)
/*      */     {
/* 1791 */       MapMonster monster = MapObjectInstanceManager.getInstance().getMapMonster(monsterid.intValue());
/* 1792 */       if (monster != null)
/*      */       {
/*      */ 
/*      */ 
/* 1796 */         if (monster.getCfgId().intValue() == cfgId)
/*      */         {
/* 1798 */           monsters.add(monster); }
/*      */       }
/*      */     }
/* 1801 */     return monsters;
/*      */   }
/*      */   
/*      */   public List<MapMonster> getMonsterList(int cfgId)
/*      */   {
/* 1806 */     List<MapMonster> monsters = new ArrayList();
/* 1807 */     for (Integer monsterid : this.monsterSet)
/*      */     {
/* 1809 */       MapMonster mapMonster = MapObjectInstanceManager.getInstance().getMapMonster(monsterid.intValue());
/* 1810 */       if (mapMonster != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1815 */         if (mapMonster.getCfgId().intValue() == cfgId)
/*      */         {
/* 1817 */           monsters.add(mapMonster); }
/*      */       }
/*      */     }
/* 1820 */     return monsters;
/*      */   }
/*      */   
/*      */   public List<List<Long>> getAllTeamMemberList()
/*      */   {
/* 1825 */     List<List<Long>> memList = new ArrayList();
/* 1826 */     for (Iterator i$ = this.roleSet.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/* 1828 */       MapRole role = MapObjectInstanceManager.getInstance().getMapRole(roleid);
/* 1829 */       if (role != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1834 */         MapTeamData teamData = MapTeamManager.getInstance().getTeamById(role.getTeamId());
/* 1835 */         if (teamData == null)
/*      */         {
/* 1837 */           List<Long> roleList = new ArrayList(1);
/* 1838 */           roleList.add(Long.valueOf(role.getRoleId()));
/* 1839 */           memList.add(roleList);
/*      */ 
/*      */ 
/*      */         }
/* 1843 */         else if (teamData.isLeader(role.getRoleId()))
/*      */         {
/* 1845 */           List<Long> roleList = new ArrayList(5);
/* 1846 */           roleList.add(Long.valueOf(role.getRoleId()));
/* 1847 */           roleList.addAll(teamData.getInTeamMember());
/* 1848 */           memList.add(roleList);
/*      */         }
/*      */       }
/*      */     }
/* 1852 */     return memList;
/*      */   }
/*      */   
/*      */   public List<Long> getAllTeamIdList()
/*      */   {
/* 1857 */     List<Long> memList = new ArrayList();
/* 1858 */     for (Iterator i$ = this.roleSet.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/* 1860 */       MapRole role = MapObjectInstanceManager.getInstance().getMapRole(roleid);
/* 1861 */       if (role != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1866 */         MapTeamData teamData = MapTeamManager.getInstance().getTeamById(role.getTeamId());
/* 1867 */         if (teamData != null)
/*      */         {
/*      */ 
/*      */ 
/* 1871 */           if (teamData.isLeader(role.getRoleId()))
/*      */           {
/* 1873 */             memList.add(Long.valueOf(teamData.getId())); }
/*      */         }
/*      */       }
/*      */     }
/* 1877 */     return memList;
/*      */   }
/*      */   
/*      */   public List<Long> getAllSingleRoleList()
/*      */   {
/* 1882 */     List<Long> memList = new ArrayList();
/* 1883 */     for (Iterator i$ = this.roleSet.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/* 1885 */       MapRole role = MapObjectInstanceManager.getInstance().getMapRole(roleid);
/* 1886 */       if (role != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1891 */         MapTeamData teamData = MapTeamManager.getInstance().getTeamById(role.getTeamId());
/* 1892 */         if (teamData == null)
/*      */         {
/* 1894 */           memList.add(Long.valueOf(role.getRoleId())); }
/*      */       }
/*      */     }
/* 1897 */     return memList;
/*      */   }
/*      */   
/*      */   public List<Long> getAllSingleRoleAndTeamLeader()
/*      */   {
/* 1902 */     List<Long> memList = new ArrayList();
/* 1903 */     for (Iterator i$ = this.roleSet.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/* 1905 */       MapRole role = MapObjectInstanceManager.getInstance().getMapRole(roleid);
/* 1906 */       if (role != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1911 */         MapTeamData teamData = MapTeamManager.getInstance().getTeamById(role.getTeamId());
/* 1912 */         if ((teamData == null) || (teamData.isLeader(role.getRoleId())))
/*      */         {
/* 1914 */           memList.add(Long.valueOf(role.getRoleId())); }
/*      */       }
/*      */     }
/* 1917 */     return memList;
/*      */   }
/*      */   
/*      */   public boolean hasRole()
/*      */   {
/* 1922 */     return !this.roleSet.isEmpty();
/*      */   }
/*      */   
/*      */   public void sendTransferEnterViewToRole(MapRole mapRole)
/*      */   {
/* 1927 */     for (Integer transferObjectId : this.transferZoneObjectSet)
/*      */     {
/* 1929 */       MapTransferZoneObject transferZoneObject = MapObjectInstanceManager.getInstance().getMapTransferZoneObject(transferObjectId.intValue());
/*      */       
/* 1931 */       if (transferZoneObject != null)
/*      */       {
/*      */ 
/*      */ 
/* 1935 */         mapRole.sendMapProtocol(transferZoneObject.createEnterView());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void sendTransferLeaveViewToRole(MapRole mapRole) {
/* 1941 */     for (Integer tranferObjid : this.transferZoneObjectSet)
/*      */     {
/* 1943 */       MapTransferZoneObject transferObject = MapObjectInstanceManager.getInstance().getMapTransferZoneObject(tranferObjid.intValue());
/*      */       
/* 1945 */       if (transferObject != null)
/*      */       {
/*      */ 
/*      */ 
/* 1949 */         mapRole.sendMapProtocol(transferObject.createLeaveView());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void sendNotOwnViewMapEntityEnterViewToRole(MapRole mapRole) {
/* 1955 */     for (MapEntityType enumEntityType : )
/*      */     {
/* 1957 */       entityType = enumEntityType.ordinal();
/* 1958 */       Set<Long> entityInstanceids = (Set)this.entityTypeToEntities.get(Integer.valueOf(entityType));
/* 1959 */       if (entityInstanceids != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1964 */         for (Long entityInstanceid : entityInstanceids)
/*      */         {
/* 1966 */           MapEntity mapEntity = MapObjectInstanceManager.getInstance().getMapEntity(entityType, entityInstanceid.longValue());
/* 1967 */           if (mapEntity != null)
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/* 1972 */             mapRole.sendMapProtocol(mapEntity.createEnterView()); }
/*      */         } }
/*      */     }
/*      */     int entityType;
/*      */   }
/*      */   
/*      */   public void sendNotOwnViewMapEntityLeaveViewToRole(MapRole mapRole) {
/* 1979 */     for (MapEntityType enumEntityType : )
/*      */     {
/* 1981 */       entityType = enumEntityType.ordinal();
/* 1982 */       Set<Long> entityInstanceids = (Set)this.entityTypeToEntities.get(Integer.valueOf(entityType));
/* 1983 */       if (entityInstanceids != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1988 */         for (Long entityInstanceid : entityInstanceids)
/*      */         {
/* 1990 */           MapEntity mapEntity = MapObjectInstanceManager.getInstance().getMapEntity(entityType, entityInstanceid.longValue());
/* 1991 */           if (mapEntity != null)
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/* 1996 */             mapRole.sendMapProtocol(mapEntity.createLeaveView()); }
/*      */         } }
/*      */     }
/*      */     int entityType;
/*      */   }
/*      */   
/*      */   public void sendWorldShareMapEntityEnterViewToRole(MapRole mapRole) {
/* 2003 */     if (this.worldInstance == null)
/*      */     {
/* 2005 */       return;
/*      */     }
/*      */     
/* 2008 */     this.worldInstance.sendMapEntityEnterViewToRole(mapRole);
/*      */   }
/*      */   
/*      */   private int getAndCreateDefaultChannel()
/*      */   {
/* 2013 */     int minChannelid = -1;
/* 2014 */     int minChannelRoleNum = Integer.MAX_VALUE;
/* 2015 */     for (Map.Entry<Integer, Integer> entry : this.channels.entrySet())
/*      */     {
/* 2017 */       int channelid = ((Integer)entry.getKey()).intValue();
/* 2018 */       int channelRoleNum = ((Integer)entry.getValue()).intValue();
/* 2019 */       if (channelRoleNum < minChannelRoleNum)
/*      */       {
/* 2021 */         minChannelid = channelid;
/* 2022 */         minChannelRoleNum = channelRoleNum;
/*      */       }
/*      */     }
/*      */     
/* 2026 */     if ((minChannelRoleNum == Integer.MAX_VALUE) || (minChannelRoleNum >= this.prototype.getChannelCapacity()))
/*      */     {
/* 2028 */       minChannelid = channelIdGenerator.nextId();
/*      */       
/* 2030 */       this.channels.put(Integer.valueOf(minChannelid), Integer.valueOf(0));
/*      */       
/* 2032 */       logger.info(String.format("Scene.getAndCreateDefaultChannel@create channel|map_cfgid=%d|sceneid=%d|channel=%s", new Object[] { Integer.valueOf(this.prototype.getTemplateId()), Integer.valueOf(this.instanceId), Integer.valueOf(minChannelid) }));
/*      */     }
/*      */     
/*      */ 
/* 2036 */     return minChannelid;
/*      */   }
/*      */   
/*      */   private void addRoleIntoChannel(MapRole role, int channelid)
/*      */   {
/* 2041 */     int roleChannelId = -1;
/* 2042 */     Integer channelRoleNum = (Integer)this.channels.get(Integer.valueOf(channelid));
/* 2043 */     if (channelRoleNum != null)
/*      */     {
/* 2045 */       roleChannelId = channelid;
/*      */     }
/*      */     else
/*      */     {
/* 2049 */       roleChannelId = getAndCreateDefaultChannel();
/* 2050 */       channelRoleNum = (Integer)this.channels.get(Integer.valueOf(roleChannelId));
/*      */     }
/* 2052 */     this.channels.put(Integer.valueOf(roleChannelId), Integer.valueOf(channelRoleNum.intValue() + 1));
/* 2053 */     role.setChannelid(roleChannelId);
/*      */   }
/*      */   
/*      */   private void removeRoleFormChannel(MapRole role)
/*      */   {
/* 2058 */     int channelid = role.getChannelid();
/* 2059 */     Integer roleNum = (Integer)this.channels.get(Integer.valueOf(channelid));
/* 2060 */     if (roleNum != null)
/*      */     {
/* 2062 */       if (roleNum.intValue() > 1)
/*      */       {
/* 2064 */         this.channels.put(Integer.valueOf(channelid), Integer.valueOf(roleNum.intValue() - 1));
/*      */       }
/*      */       else
/*      */       {
/* 2068 */         this.channels.remove(Integer.valueOf(channelid));
/*      */         
/* 2070 */         logger.info(String.format("Scene.removeRoleFormChannel@destroy channel|map_cfgid=%d|sceneid=%d|channelid=%d", new Object[] { Integer.valueOf(this.prototype.getTemplateId()), Integer.valueOf(this.instanceId), Integer.valueOf(channelid) }));
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 2075 */     role.setChannelid(Integer.MAX_VALUE);
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\Scene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */