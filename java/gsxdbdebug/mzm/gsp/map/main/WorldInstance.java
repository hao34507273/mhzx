/*     */ package mzm.gsp.map.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import java.util.concurrent.atomic.AtomicLong;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.map.event.WorldDestroyEvent;
/*     */ import mzm.gsp.map.main.controller.Controller;
/*     */ import mzm.gsp.map.main.message.MMH_SetWorldAppMsgHandler;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.SceneManager;
/*     */ import mzm.gsp.map.main.scene.object.MapEntity;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import mzm.gsp.map.main.scene.object.MapMonster;
/*     */ import mzm.gsp.map.main.scene.object.MapNPC;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import mzm.gsp.monster.confbean.SBaseBrightMonster;
/*     */ import mzm.gsp.worldai.confbean.SWorldAIParam;
/*     */ import xio.Protocol;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldInstance
/*     */ {
/*  40 */   private static final AtomicLong idGen = new AtomicLong(0L);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private final long id;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  50 */   private Map<Integer, Controller> controllerMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  55 */   private Set<Integer> sceneSet = new HashSet();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  60 */   private final Map<Integer, Set<Long>> entityTypeToEntities = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  65 */   private Map<Long, Position> rolePositionMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  70 */   private Set<Integer> uninitializedMapids = new HashSet();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  75 */   private Set<Integer> initializedMapids = new HashSet();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  80 */   private Map<Integer, Integer> worldAiParam = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  85 */   private Map<Long, RoleParam> roleWorldParam = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  90 */   private List<IMonsterFightHandler> fightHandlers = new CopyOnWriteArrayList();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  95 */   private Map<Integer, Octets> cloneRoleNpcModelInfoMap = null;
/*     */   
/*     */ 
/*     */   public static class RoleParam
/*     */   {
/*     */     public static final int APP_COLOR_ID = 0;
/*     */     public static final int APP_TEXT = 1;
/* 102 */     final Map<Integer, Integer> intMap = new HashMap();
/* 103 */     final Map<Integer, String> stringMap = new HashMap();
/*     */     
/*     */     void putStringMap(int key, String val)
/*     */     {
/* 107 */       this.stringMap.put(Integer.valueOf(key), val);
/*     */     }
/*     */     
/*     */     void putIntMap(int key, int val)
/*     */     {
/* 112 */       this.intMap.put(Integer.valueOf(key), Integer.valueOf(val));
/*     */     }
/*     */     
/*     */     String getStringVal(int key)
/*     */     {
/* 117 */       return (String)this.stringMap.get(Integer.valueOf(key));
/*     */     }
/*     */     
/*     */     Integer getIntVal(int key)
/*     */     {
/* 122 */       return (Integer)this.intMap.get(Integer.valueOf(key));
/*     */     }
/*     */   }
/*     */   
/*     */   public WorldInstance()
/*     */   {
/* 128 */     this.id = idGen.incrementAndGet();
/*     */   }
/*     */   
/*     */   public long getId()
/*     */   {
/* 133 */     return this.id;
/*     */   }
/*     */   
/*     */   public void lazyInit(Collection<Integer> mapIds)
/*     */   {
/* 138 */     if (this.uninitializedMapids != null)
/*     */     {
/* 140 */       this.uninitializedMapids.addAll(mapIds);
/*     */     }
/*     */   }
/*     */   
/*     */   public void lazyInit(int mapCfgid)
/*     */   {
/* 146 */     if (this.uninitializedMapids != null)
/*     */     {
/* 148 */       this.uninitializedMapids.add(Integer.valueOf(mapCfgid));
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean addInitializedMapCfgid(int mapCfgid)
/*     */   {
/* 154 */     return this.initializedMapids.add(Integer.valueOf(mapCfgid));
/*     */   }
/*     */   
/*     */   public void addScene(Scene scene)
/*     */   {
/* 159 */     this.sceneSet.add(Integer.valueOf(scene.getId()));
/*     */   }
/*     */   
/*     */   private void createCloneRoleNpcModelInfoMapIfNeeded()
/*     */   {
/* 164 */     if (this.cloneRoleNpcModelInfoMap == null)
/*     */     {
/* 166 */       this.cloneRoleNpcModelInfoMap = new HashMap();
/*     */     }
/*     */   }
/*     */   
/*     */   public void addCloneRoleNpcModelData(int npcCfgid, Octets mapNpcModelData)
/*     */   {
/* 172 */     createCloneRoleNpcModelInfoMapIfNeeded();
/*     */     
/* 174 */     this.cloneRoleNpcModelInfoMap.put(Integer.valueOf(npcCfgid), mapNpcModelData);
/*     */     
/* 176 */     for (Integer sceneId : this.sceneSet)
/*     */     {
/* 178 */       Scene scene = SceneManager.getInstance().getScene(sceneId.intValue());
/* 179 */       if (scene != null)
/*     */       {
/*     */ 
/*     */ 
/* 183 */         MapNPC npc = scene.getNpcByCfgId(npcCfgid);
/* 184 */         if (npc != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 189 */           npc.updateModel(mapNpcModelData); }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCloneRoleNpcModelData(int npcCfgid) {
/* 195 */     if (this.cloneRoleNpcModelInfoMap == null)
/*     */     {
/* 197 */       return;
/*     */     }
/*     */     
/* 200 */     if (this.cloneRoleNpcModelInfoMap.remove(Integer.valueOf(npcCfgid)) == null)
/*     */     {
/* 202 */       return;
/*     */     }
/*     */     
/* 205 */     for (Integer sceneId : this.sceneSet)
/*     */     {
/* 207 */       Scene scene = SceneManager.getInstance().getScene(sceneId.intValue());
/* 208 */       if (scene != null)
/*     */       {
/*     */ 
/*     */ 
/* 212 */         MapNPC npc = scene.getNpcByCfgId(npcCfgid);
/* 213 */         if (npc != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 218 */           npc.updateModel(null); }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public Octets getCloneRoleNpcModelData(int npcCfgid) {
/* 224 */     if (this.cloneRoleNpcModelInfoMap == null)
/*     */     {
/* 226 */       return null;
/*     */     }
/*     */     
/* 229 */     return (Octets)this.cloneRoleNpcModelInfoMap.get(Integer.valueOf(npcCfgid));
/*     */   }
/*     */   
/*     */   public boolean addMapEntity(MapEntity mapEntity)
/*     */   {
/* 234 */     MapEntityType enumEntityType = mapEntity.getEntityType();
/* 235 */     int entityType = enumEntityType.ordinal();
/* 236 */     Set<Long> entities = (Set)this.entityTypeToEntities.get(Integer.valueOf(entityType));
/* 237 */     if (entities == null)
/*     */     {
/* 239 */       entities = new HashSet();
/* 240 */       this.entityTypeToEntities.put(Integer.valueOf(entityType), entities);
/*     */     }
/* 242 */     return entities.add(mapEntity.getInstanceid());
/*     */   }
/*     */   
/*     */   public boolean removeMapEntity(MapEntity mapEntity)
/*     */   {
/* 247 */     MapEntityType enumEntityType = mapEntity.getEntityType();
/* 248 */     int entityType = enumEntityType.ordinal();
/* 249 */     Set<Long> entities = (Set)this.entityTypeToEntities.get(Integer.valueOf(entityType));
/* 250 */     if (entities != null)
/*     */     {
/* 252 */       return entities.remove(mapEntity.getInstanceid());
/*     */     }
/*     */     
/* 255 */     return false;
/*     */   }
/*     */   
/*     */   public void sendMapEntityEnterViewToRole(MapRole mapRole)
/*     */   {
/* 260 */     for (Map.Entry<Integer, Set<Long>> entry : this.entityTypeToEntities.entrySet())
/*     */     {
/* 262 */       entityType = ((Integer)entry.getKey()).intValue();
/* 263 */       Set<Long> entityInstanceids = (Set)entry.getValue();
/* 264 */       for (Long entityInstanceid : entityInstanceids)
/*     */       {
/* 266 */         MapEntity mapEntity = MapObjectInstanceManager.getInstance().getMapEntity(entityType, entityInstanceid.longValue());
/* 267 */         if (mapEntity != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 272 */           mapRole.sendMapProtocol(mapEntity.createEnterView()); }
/*     */       }
/*     */     }
/*     */     int entityType;
/*     */   }
/*     */   
/*     */   public void broadcast(Protocol protocol) {
/* 279 */     for (Integer sceneId : this.sceneSet)
/*     */     {
/* 281 */       Scene scene = SceneManager.getInstance().getScene(sceneId.intValue());
/* 282 */       if (scene != null)
/*     */       {
/*     */ 
/*     */ 
/* 286 */         scene.broadcast(protocol);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void onRoleMove(long roleId, int x, int y, int z, int sceneId) {
/* 292 */     Position pos = (Position)this.rolePositionMap.get(Long.valueOf(roleId));
/* 293 */     if (pos == null)
/*     */     {
/* 295 */       onRoleJoin(roleId);
/* 296 */       return;
/*     */     }
/*     */     
/* 299 */     pos.setXYZ(x, y, z);
/* 300 */     pos.setSceneId(sceneId);
/*     */   }
/*     */   
/*     */   public void onRoleJoin(long roleId)
/*     */   {
/* 305 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(roleId);
/* 306 */     if (role == null)
/*     */     {
/* 308 */       return;
/*     */     }
/* 310 */     Position pos = role.getPositionForInner();
/* 311 */     this.rolePositionMap.put(Long.valueOf(roleId), new Position(pos));
/* 312 */     WorldManager.getInstance().addRoleWorldInstanceIntoStack(roleId, this);
/*     */   }
/*     */   
/*     */   public void forceSetPosition(long roleid, Position pos)
/*     */   {
/* 317 */     this.rolePositionMap.put(Long.valueOf(roleid), pos);
/*     */     
/* 319 */     WorldManager.getInstance().addRoleWorldInstanceIntoStack(roleid, this);
/* 320 */     WorldManager.getInstance().checkTopStack(roleid, getId());
/*     */   }
/*     */   
/*     */   public void onRoleLeave(long roleId)
/*     */   {
/* 325 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(roleId);
/* 326 */     if (role == null)
/*     */     {
/* 328 */       return;
/*     */     }
/*     */     
/* 331 */     RoleParam rp = (RoleParam)this.roleWorldParam.remove(Long.valueOf(roleId));
/* 332 */     if (rp != null)
/*     */     {
/* 334 */       if (rp.getIntVal(0) != null)
/*     */       {
/* 336 */         new MMH_SetWorldAppMsgHandler(roleId, 0, null).doProcess();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void addFightHandler(IMonsterFightHandler handler)
/*     */   {
/* 343 */     this.fightHandlers.add(handler);
/*     */   }
/*     */   
/*     */   public void removeFightHandler(IMonsterFightHandler handler)
/*     */   {
/* 348 */     this.fightHandlers.remove(handler);
/*     */   }
/*     */   
/*     */   public boolean handleFight(long roleId, MapMonster mapMonster, SBaseBrightMonster baseBrightMonster)
/*     */   {
/* 353 */     if (this.fightHandlers.isEmpty())
/*     */     {
/* 355 */       return false;
/*     */     }
/*     */     
/* 358 */     Scene scene = SceneManager.getInstance().getScene(mapMonster.getSceneId());
/* 359 */     if (scene == null)
/*     */     {
/* 361 */       return false;
/*     */     }
/*     */     
/* 364 */     MapVisibleMonsterFightContext context = new MapVisibleMonsterFightContext(roleId, mapMonster.getMonsterId(), mapMonster.getCfgId().intValue(), scene.getCfgId(), getId());
/*     */     
/*     */ 
/*     */ 
/* 368 */     int startLevel = mapMonster.getStarLevel();
/* 369 */     if (startLevel > -1)
/*     */     {
/* 371 */       context.putExtra(MapFightContext.EXTRADATA_TYPE.MONSTER_STAR_LEVEL, startLevel);
/*     */     }
/* 373 */     context.putExtra(MapFightContext.EXTRADATA_TYPE.ENTER_FIGHT_LOW_LEVEL_LIMIT, baseBrightMonster.enterFightMinLevel);
/* 374 */     new PTryStartMapVisibileMonsterFight(roleId, mapMonster.getFightCfgid(), context, this.fightHandlers).execute();
/*     */     
/* 376 */     return true;
/*     */   }
/*     */   
/*     */   public Position getPosition(long roleId)
/*     */   {
/* 381 */     return (Position)this.rolePositionMap.get(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Controller getController(int id)
/*     */   {
/* 393 */     Controller controller = (Controller)this.controllerMap.get(Integer.valueOf(id));
/* 394 */     if (controller == null)
/*     */     {
/* 396 */       controller = ControllerManager.getInstance().getController(id);
/* 397 */       if (controller == null)
/*     */       {
/* 399 */         return null;
/*     */       }
/* 401 */       controller = controller.duplicate();
/* 402 */       controller.setWorldId(getId());
/*     */     }
/* 404 */     this.controllerMap.put(Integer.valueOf(id), controller);
/* 405 */     return controller;
/*     */   }
/*     */   
/*     */   public void onReleaseScene(Scene scene)
/*     */   {
/* 410 */     if (!this.sceneSet.remove(Integer.valueOf(scene.getId())))
/*     */     {
/* 412 */       return;
/*     */     }
/*     */     
/* 415 */     if (this.sceneSet.isEmpty())
/*     */     {
/* 417 */       release();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void release()
/*     */   {
/* 424 */     WorldManager.getInstance().removeWorldInstance(this);
/*     */     
/*     */ 
/* 427 */     for (Integer sceneId : this.sceneSet)
/*     */     {
/* 429 */       Scene scene = SceneManager.getInstance().getScene(sceneId.intValue());
/* 430 */       if (scene != null)
/*     */       {
/*     */ 
/*     */ 
/* 434 */         scene.stop(true, true);
/*     */       }
/*     */     }
/*     */     
/* 438 */     for (Map.Entry<Integer, Set<Long>> entry : this.entityTypeToEntities.entrySet())
/*     */     {
/* 440 */       Set<Long> entityInstanceSet = (Set)entry.getValue();
/* 441 */       if (!entityInstanceSet.isEmpty())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 446 */         entityType = ((Integer)entry.getKey()).intValue();
/* 447 */         List<Long> instanceids = new ArrayList(entityInstanceSet);
/* 448 */         for (Long entityInstanceId : instanceids)
/*     */         {
/* 450 */           MapEntity mapEntity = MapObjectInstanceManager.getInstance().getMapEntity(entityType, entityInstanceId.longValue());
/* 451 */           if (mapEntity != null)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 456 */             mapEntity.destroy(); }
/*     */         }
/*     */       }
/*     */     }
/*     */     int entityType;
/* 461 */     Iterator<Map.Entry<Long, Position>> rolePosItr = this.rolePositionMap.entrySet().iterator();
/* 462 */     while (rolePosItr.hasNext())
/*     */     {
/* 464 */       long roleId = ((Long)((Map.Entry)rolePosItr.next()).getKey()).longValue();
/* 465 */       WorldManager.getInstance().removeRoleWorldInstanceFromStack(roleId, this);
/* 466 */       rolePosItr.remove();
/*     */     }
/* 468 */     this.rolePositionMap = null;
/*     */     
/* 470 */     Iterator<Map.Entry<Integer, Controller>> controllerItr = this.controllerMap.entrySet().iterator();
/* 471 */     while (controllerItr.hasNext())
/*     */     {
/* 473 */       Controller controller = (Controller)((Map.Entry)controllerItr.next()).getValue();
/* 474 */       controller.collectObject();
/* 475 */       controller.release();
/* 476 */       controllerItr.remove();
/*     */     }
/*     */     
/* 479 */     this.uninitializedMapids.clear();
/* 480 */     this.uninitializedMapids = null;
/*     */     
/* 482 */     this.initializedMapids.clear();
/* 483 */     this.initializedMapids = null;
/*     */     
/* 485 */     this.worldAiParam.clear();
/* 486 */     this.worldAiParam = null;
/*     */     
/* 488 */     this.fightHandlers.clear();
/* 489 */     this.fightHandlers = null;
/*     */     
/* 491 */     this.roleWorldParam.clear();
/* 492 */     this.roleWorldParam = null;
/*     */     
/* 494 */     if (this.cloneRoleNpcModelInfoMap != null)
/*     */     {
/* 496 */       this.cloneRoleNpcModelInfoMap.clear();
/* 497 */       this.cloneRoleNpcModelInfoMap = null;
/*     */     }
/*     */     
/* 500 */     TriggerEventsManger.getInstance().triggerEventAtOnce(new WorldDestroyEvent(), Long.valueOf(getId()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Scene nextScene(int mapCfgId)
/*     */   {
/* 511 */     Scene scene = null;
/* 512 */     scene = getSceneByCfgId(mapCfgId);
/* 513 */     if (scene == null)
/*     */     {
/* 515 */       if (this.uninitializedMapids.remove(Integer.valueOf(mapCfgId)))
/*     */       {
/* 517 */         scene = new Scene(mapCfgId, this);
/* 518 */         scene.start();
/*     */         
/* 520 */         addScene(scene);
/*     */       }
/*     */     }
/* 523 */     return scene;
/*     */   }
/*     */   
/*     */   public void triggerController(int id)
/*     */   {
/* 528 */     Controller controller = getController(id);
/* 529 */     if (controller != null)
/*     */     {
/* 531 */       controller.refresh();
/*     */     }
/*     */   }
/*     */   
/*     */   public void triggerController(int id, int maxSpawnNum)
/*     */   {
/* 537 */     Controller controller = getController(id);
/* 538 */     if (controller != null)
/*     */     {
/* 540 */       controller.refresh(maxSpawnNum);
/*     */     }
/*     */   }
/*     */   
/*     */   public void triggerController(int id, int count, int maxSpawnNum)
/*     */   {
/* 546 */     Controller controller = getController(id);
/* 547 */     if (controller != null)
/*     */     {
/* 549 */       controller.refresh(count, maxSpawnNum);
/*     */     }
/*     */   }
/*     */   
/*     */   public void collectController(int id)
/*     */   {
/* 555 */     Controller controller = (Controller)this.controllerMap.get(Integer.valueOf(id));
/* 556 */     if (controller != null)
/*     */     {
/* 558 */       controller.collectObject();
/*     */     }
/*     */   }
/*     */   
/*     */   public void putWorldAiParam(int id, int value)
/*     */   {
/* 564 */     SWorldAIParam param = SWorldAIParam.get(id);
/* 565 */     if (param == null)
/*     */     {
/* 567 */       throw new RuntimeException("do not exist world ai param id = " + id);
/*     */     }
/* 569 */     if ((param.highLimit < value) || (param.lowLimit > value))
/*     */     {
/* 571 */       throw new RuntimeException(String.format("set world param id = %d %d not in (%d,%d)", new Object[] { Integer.valueOf(id), Integer.valueOf(value), Integer.valueOf(param.lowLimit), Integer.valueOf(param.highLimit) }));
/*     */     }
/*     */     
/* 574 */     this.worldAiParam.put(Integer.valueOf(id), Integer.valueOf(value));
/*     */   }
/*     */   
/*     */   public int getWorldAiParam(int id)
/*     */   {
/* 579 */     Integer value = (Integer)this.worldAiParam.get(Integer.valueOf(id));
/* 580 */     if (value == null)
/*     */     {
/* 582 */       return 0;
/*     */     }
/* 584 */     return value.intValue();
/*     */   }
/*     */   
/*     */   public Scene getSceneByCfgId(int id)
/*     */   {
/* 589 */     for (Integer sceneId : this.sceneSet)
/*     */     {
/* 591 */       Scene scene = SceneManager.getInstance().getScene(sceneId.intValue());
/* 592 */       if (scene != null)
/*     */       {
/*     */ 
/*     */ 
/* 596 */         if (scene.getCfgId() == id)
/*     */         {
/* 598 */           return scene; }
/*     */       }
/*     */     }
/* 601 */     return null;
/*     */   }
/*     */   
/*     */   public List<Long> getAllRole()
/*     */   {
/* 606 */     List<Long> roleIdList = new ArrayList();
/* 607 */     for (Integer sceneId : this.sceneSet)
/*     */     {
/* 609 */       Scene scene = SceneManager.getInstance().getScene(sceneId.intValue());
/* 610 */       if (scene != null)
/*     */       {
/*     */ 
/*     */ 
/* 614 */         roleIdList.addAll(scene.getRoleList()); }
/*     */     }
/* 616 */     return roleIdList;
/*     */   }
/*     */   
/*     */   public boolean hasRole()
/*     */   {
/* 621 */     for (Integer sceneId : this.sceneSet)
/*     */     {
/* 623 */       Scene scene = SceneManager.getInstance().getScene(sceneId.intValue());
/* 624 */       if (scene != null)
/*     */       {
/*     */ 
/*     */ 
/* 628 */         if (scene.hasRole())
/*     */         {
/* 630 */           return true; }
/*     */       }
/*     */     }
/* 633 */     return false;
/*     */   }
/*     */   
/*     */   public List<List<Long>> getAllTeamMemberList()
/*     */   {
/* 638 */     List<List<Long>> lists = new ArrayList();
/* 639 */     for (Integer sceneId : this.sceneSet)
/*     */     {
/* 641 */       Scene scene = SceneManager.getInstance().getScene(sceneId.intValue());
/* 642 */       if (scene != null)
/*     */       {
/*     */ 
/*     */ 
/* 646 */         lists.addAll(scene.getAllTeamMemberList()); }
/*     */     }
/* 648 */     return lists;
/*     */   }
/*     */   
/*     */   public List<Long> getAllTeamIdList()
/*     */   {
/* 653 */     List<Long> lists = new ArrayList();
/* 654 */     for (Integer sceneId : this.sceneSet)
/*     */     {
/* 656 */       Scene scene = SceneManager.getInstance().getScene(sceneId.intValue());
/* 657 */       if (scene != null)
/*     */       {
/*     */ 
/*     */ 
/* 661 */         lists.addAll(scene.getAllTeamIdList()); }
/*     */     }
/* 663 */     return lists;
/*     */   }
/*     */   
/*     */   public List<Long> getAllSingleRoleList()
/*     */   {
/* 668 */     List<Long> lists = new ArrayList();
/* 669 */     for (Integer sceneId : this.sceneSet)
/*     */     {
/* 671 */       Scene scene = SceneManager.getInstance().getScene(sceneId.intValue());
/* 672 */       if (scene != null)
/*     */       {
/*     */ 
/*     */ 
/* 676 */         lists.addAll(scene.getAllSingleRoleList()); }
/*     */     }
/* 678 */     return lists;
/*     */   }
/*     */   
/*     */   public List<Long> getAllSingleRoleAndTeamLeader()
/*     */   {
/* 683 */     List<Long> lists = new ArrayList();
/* 684 */     for (Integer sceneId : this.sceneSet)
/*     */     {
/* 686 */       Scene scene = SceneManager.getInstance().getScene(sceneId.intValue());
/* 687 */       if (scene != null)
/*     */       {
/*     */ 
/*     */ 
/* 691 */         lists.addAll(scene.getAllSingleRoleAndTeamLeader()); }
/*     */     }
/* 693 */     return lists;
/*     */   }
/*     */   
/*     */   public int getRoleNumInWorld()
/*     */   {
/* 698 */     int totalNum = 0;
/* 699 */     for (Integer sceneId : this.sceneSet)
/*     */     {
/* 701 */       Scene scene = SceneManager.getInstance().getScene(sceneId.intValue());
/* 702 */       if (scene != null)
/*     */       {
/*     */ 
/*     */ 
/* 706 */         totalNum += scene.getRoleCount(); }
/*     */     }
/* 708 */     return totalNum;
/*     */   }
/*     */   
/*     */   public int getMonsterNumInWorld()
/*     */   {
/* 713 */     int totalNum = 0;
/* 714 */     for (Integer sceneId : this.sceneSet)
/*     */     {
/* 716 */       Scene scene = SceneManager.getInstance().getScene(sceneId.intValue());
/* 717 */       if (scene != null)
/*     */       {
/*     */ 
/*     */ 
/* 721 */         totalNum += scene.getMonsterCount(); }
/*     */     }
/* 723 */     return totalNum;
/*     */   }
/*     */   
/*     */   private RoleParam getParam(long roleId)
/*     */   {
/* 728 */     RoleParam param = (RoleParam)this.roleWorldParam.get(Long.valueOf(roleId));
/* 729 */     if (param == null)
/*     */     {
/* 731 */       param = new RoleParam();
/* 732 */       this.roleWorldParam.put(Long.valueOf(roleId), param);
/*     */     }
/* 734 */     return param;
/*     */   }
/*     */   
/*     */   public void putRoleStringParam(long roleId, int key, String val)
/*     */   {
/* 739 */     RoleParam rp = getParam(roleId);
/* 740 */     rp.putStringMap(key, val);
/*     */   }
/*     */   
/*     */   public String getRoleStringParam(long roleId, int key)
/*     */   {
/* 745 */     RoleParam param = (RoleParam)this.roleWorldParam.get(Long.valueOf(roleId));
/* 746 */     if (param == null)
/*     */     {
/* 748 */       return null;
/*     */     }
/* 750 */     return param.getStringVal(key);
/*     */   }
/*     */   
/*     */   public void putRoleIntParam(long roleId, int key, int val)
/*     */   {
/* 755 */     RoleParam rp = getParam(roleId);
/* 756 */     rp.putIntMap(key, val);
/*     */   }
/*     */   
/*     */   public Integer getRoleIntParam(long roleId, int key)
/*     */   {
/* 761 */     RoleParam param = (RoleParam)this.roleWorldParam.get(Long.valueOf(roleId));
/* 762 */     if (param == null)
/*     */     {
/* 764 */       return null;
/*     */     }
/* 766 */     return param.getIntVal(key);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\WorldInstance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */