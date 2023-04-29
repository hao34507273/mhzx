/*     */ package mzm.gsp.map.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.children.main.ChildrenInterface.ShowChildObj;
/*     */ import mzm.gsp.guaji.confbean.SMapToModuleFunSwitchCfg;
/*     */ import mzm.gsp.map.Location;
/*     */ import mzm.gsp.map.MapModelInfo;
/*     */ import mzm.gsp.map.confbean.MapConsts;
/*     */ import mzm.gsp.map.confbean.SMapConfig;
/*     */ import mzm.gsp.map.confbean.SMapVisibleMonster;
/*     */ import mzm.gsp.map.main.message.MMH_GenCloneRoleNpc;
/*     */ import mzm.gsp.map.main.message.MMH_PetAppearanceChange;
/*     */ import mzm.gsp.map.main.message.MMH_RemoveCloneRoleNpc;
/*     */ import mzm.gsp.map.main.proto.Cell;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.SceneManager;
/*     */ import mzm.gsp.map.main.scene.object.MapEntity;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import mzm.gsp.map.main.scene.object.MapNPC;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import mzm.gsp.map.main.scene.object.MapRoleInitInfo;
/*     */ import mzm.gsp.map.main.scene.object.MapWorldShareEntity;
/*     */ import mzm.gsp.menpaipvp.main.MenpaiPVPInterface;
/*     */ import mzm.gsp.monster.confbean.SActiveBrightMonster;
/*     */ import mzm.gsp.monster.confbean.SBaseBrightMonster;
/*     */ import mzm.gsp.monster.confbean.SBrightMonster;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.pet.main.Pet;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.title.main.TitleInterface;
/*     */ import xbean.CloneRoleNPCModel;
/*     */ import xbean.CloneRoleNpcs;
/*     */ import xbean.Pod;
/*     */ import xtable.Clone_role_npc_models;
/*     */ import xtable.Clone_role_npc_of_gang;
/*     */ import xtable.Clone_role_npc_of_general;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MapManager
/*     */ {
/*     */   public static boolean canDoAction(long roleid, int aciton)
/*     */   {
/*  56 */     return RoleStatusInterface.checkCanSetStatus(roleid, aciton, true);
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
/*     */   public static boolean guajiMapIsOpen(long roleid, int mapCfgid)
/*     */   {
/*  70 */     SMapToModuleFunSwitchCfg cfg = SMapToModuleFunSwitchCfg.get(mapCfgid);
/*  71 */     if (cfg == null)
/*     */     {
/*  73 */       return true;
/*     */     }
/*     */     
/*  76 */     if (!OpenInterface.getOpenStatus(cfg.moduleFunSwitchId))
/*     */     {
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     if (OpenInterface.isBanPlay(roleid, cfg.moduleFunSwitchId))
/*     */     {
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isNearByNPC(long roleid, int npcid)
/*     */   {
/*  98 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(roleid);
/*  99 */     if (role == null)
/*     */     {
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     Scene scene = SceneManager.getInstance().getScene(role.getPositionForInner());
/* 105 */     if (scene == null)
/*     */     {
/* 107 */       return false;
/*     */     }
/* 109 */     MapNPC npc = scene.getNpcByCfgId(npcid);
/* 110 */     if (npc == null)
/*     */     {
/* 112 */       return false;
/*     */     }
/*     */     
/* 115 */     int dist = role.getDistance(npc);
/*     */     
/* 117 */     return dist <= MapConsts.getInstance().MAPOBJECT_TALK_DIST;
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
/*     */   public static boolean isNearByMapEntity(long roleid, MapEntityType entityType, long entityInstanceid)
/*     */   {
/* 131 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(roleid);
/* 132 */     if (role == null)
/*     */     {
/* 134 */       return false;
/*     */     }
/*     */     
/* 137 */     MapEntity entity = MapObjectInstanceManager.getInstance().getMapEntity(entityType.ordinal(), entityInstanceid);
/* 138 */     if (entity == null)
/*     */     {
/* 140 */       return false;
/*     */     }
/*     */     
/* 143 */     Position rolePos = role.getPositionForInner();
/* 144 */     Scene roleScene = SceneManager.getInstance().getScene(rolePos);
/* 145 */     if (roleScene == null)
/*     */     {
/* 147 */       return false;
/*     */     }
/*     */     
/* 150 */     if (entityType.isWorldShare())
/*     */     {
/* 152 */       return ((MapWorldShareEntity)entity).getWorldInstance() == roleScene.getWorld();
/*     */     }
/*     */     
/* 155 */     Position entityPos = entity.getPositionForInner();
/* 156 */     if (rolePos.getSceneId() != entityPos.getSceneId())
/*     */     {
/* 158 */       return false;
/*     */     }
/*     */     
/* 161 */     double dist = getDistance(rolePos.getX(), rolePos.getY(), entityPos.getX(), entityPos.getY());
/*     */     
/* 163 */     return dist <= MapConsts.getInstance().MAPOBJECT_TALK_DIST;
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
/*     */   public static int getDistanceSquare(int x1, int y1, int x2, int y2)
/*     */   {
/* 177 */     int diffX = x1 - x2;
/* 178 */     int diffY = y1 - y2;
/* 179 */     return diffX * diffX + diffY * diffY;
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
/*     */   public static double getDistance(int x1, int y1, int x2, int y2)
/*     */   {
/* 193 */     return Math.sqrt(getDistanceSquare(x1, y1, x2, y2));
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
/*     */   static boolean setMenPaiNpcModel(long roleid)
/*     */   {
/* 207 */     int occupationId = RoleInterface.getOccupationId(roleid);
/* 208 */     int npcCfgid = MenpaiPVPInterface.getMenpaiChampionNpc(occupationId);
/* 209 */     int appellationCfgid = MenpaiPVPInterface.getMenpaiChampionAppellation(occupationId);
/* 210 */     return setCloneRoleNpcModel(CloneRoleNpcModelType.MEN_PAI, -1L, roleid, npcCfgid, appellationCfgid);
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
/*     */   static boolean setCloneRoleNpcModel(CloneRoleNpcModelType cloneRoleNpcModelType, long customKey, long roleid, int npcCfgid, int appellationCfgid)
/*     */   {
/* 228 */     if ((roleid < 1L) || (npcCfgid < 1))
/*     */     {
/* 230 */       return false;
/*     */     }
/*     */     
/* 233 */     MapRoleInitInfo mapRoleInitInfo = new MapRoleInitInfo(roleid);
/* 234 */     MapModelInfo mapModelInfo = mapRoleInitInfo.roleModelInfo;
/*     */     
/* 236 */     CloneRoleNPCModel xCloneRoleNPCModel = null;
/* 237 */     CloneRoleNpcs xCloneRoleNpcs = createXCloneRoleNpcsIfNeeded(cloneRoleNpcModelType, customKey);
/* 238 */     Long cloneRoleNPCModelKey = (Long)xCloneRoleNpcs.getNpc_map().get(Integer.valueOf(npcCfgid));
/* 239 */     if (cloneRoleNPCModelKey == null)
/*     */     {
/* 241 */       xCloneRoleNPCModel = Pod.newCloneRoleNPCModel();
/* 242 */       cloneRoleNPCModelKey = Clone_role_npc_models.insert(xCloneRoleNPCModel);
/* 243 */       xCloneRoleNpcs.getNpc_map().put(Integer.valueOf(npcCfgid), cloneRoleNPCModelKey);
/*     */     }
/*     */     else
/*     */     {
/* 247 */       xCloneRoleNPCModel = Clone_role_npc_models.get(cloneRoleNPCModelKey);
/*     */     }
/*     */     
/* 250 */     xCloneRoleNPCModel.setRoleid(roleid);
/* 251 */     xCloneRoleNPCModel.getString_prop_map().clear();
/* 252 */     for (Map.Entry<Integer, String> entry : mapModelInfo.string_props.entrySet())
/*     */     {
/* 254 */       xCloneRoleNPCModel.getString_prop_map().put(entry.getKey(), entry.getValue());
/*     */     }
/* 256 */     String appName = TitleInterface.getAppNameById(roleid, appellationCfgid);
/* 257 */     xCloneRoleNPCModel.getString_prop_map().put(Integer.valueOf(1), appName);
/*     */     
/* 259 */     xCloneRoleNPCModel.getInt_prop_map().clear();
/* 260 */     for (Map.Entry<Integer, Integer> entry : mapModelInfo.int_props.entrySet())
/*     */     {
/* 262 */       xCloneRoleNPCModel.getInt_prop_map().put(entry.getKey(), entry.getValue());
/*     */     }
/* 264 */     xCloneRoleNPCModel.getInt_prop_map().put(Integer.valueOf(1), Integer.valueOf(appellationCfgid));
/*     */     
/* 266 */     ModelInfo modelInfo = mapModelInfo.model;
/* 267 */     xCloneRoleNPCModel.setModelid(modelInfo.modelid);
/*     */     
/* 269 */     xCloneRoleNPCModel.setColorid(0);
/* 270 */     Integer color = (Integer)modelInfo.extramap.get(Integer.valueOf(12));
/* 271 */     if (color != null)
/*     */     {
/* 273 */       xCloneRoleNPCModel.setColorid(color.intValue());
/*     */     }
/*     */     
/* 276 */     xCloneRoleNPCModel.getModel_info().clear();
/* 277 */     for (Map.Entry<Integer, Integer> entry : modelInfo.extramap.entrySet())
/*     */     {
/* 279 */       xCloneRoleNPCModel.getModel_info().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */     
/* 282 */     if (cloneRoleNpcModelType.cachable)
/*     */     {
/* 284 */       MapObjectManager.getInstance().initNpcModel(npcCfgid, xCloneRoleNPCModel);
/* 285 */       new MMH_GenCloneRoleNpc(npcCfgid).execute();
/*     */     }
/*     */     
/* 288 */     return true;
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
/*     */   static boolean unsetCloneRoleNpcModel(CloneRoleNpcModelType cloneRoleNpcModelType, int npcCfgid)
/*     */   {
/* 301 */     return unsetCloneRoleNpcModel(cloneRoleNpcModelType, -1L, npcCfgid);
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
/*     */   static boolean unsetCloneRoleNpcModel(CloneRoleNpcModelType cloneRoleNpcModelType, long customKey, int npcCfgid)
/*     */   {
/* 317 */     CloneRoleNpcs xCloneRoleNpcs = getXCloneRoleNpcs(cloneRoleNpcModelType, customKey, true);
/* 318 */     if (xCloneRoleNpcs == null)
/*     */     {
/* 320 */       return false;
/*     */     }
/*     */     
/* 323 */     Long cloneRoleNpcModelKey = (Long)xCloneRoleNpcs.getNpc_map().remove(Integer.valueOf(npcCfgid));
/* 324 */     if (cloneRoleNpcModelKey == null)
/*     */     {
/* 326 */       return false;
/*     */     }
/* 328 */     Clone_role_npc_models.remove(Long.valueOf(cloneRoleNpcModelKey.longValue()));
/*     */     
/* 330 */     if (cloneRoleNpcModelType.cachable)
/*     */     {
/* 332 */       MapObjectManager.getInstance().removeCloneRoleNpcModel(npcCfgid);
/*     */       
/*     */ 
/* 335 */       new MMH_RemoveCloneRoleNpc(npcCfgid).execute();
/*     */     }
/*     */     
/* 338 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static CloneRoleNpcs createXCloneRoleNpcsIfNeeded(CloneRoleNpcModelType cloneRoleNpcModelType, long customKey)
/*     */   {
/* 344 */     switch (cloneRoleNpcModelType)
/*     */     {
/*     */ 
/*     */     case MEN_PAI: 
/*     */     case QI_MAI_HUI_WU: 
/*     */     case MEN_PAI_STAR: 
/* 350 */       long generalKey = cloneRoleNpcModelType.toKey();
/* 351 */       CloneRoleNpcs xCloneRoleNpcs = Clone_role_npc_of_general.get(Long.valueOf(generalKey));
/* 352 */       if (xCloneRoleNpcs == null)
/*     */       {
/* 354 */         xCloneRoleNpcs = Pod.newCloneRoleNpcs();
/* 355 */         Clone_role_npc_of_general.insert(Long.valueOf(generalKey), xCloneRoleNpcs);
/*     */       }
/* 357 */       return xCloneRoleNpcs;
/*     */     
/*     */ 
/*     */ 
/*     */     case GANG: 
/* 362 */       CloneRoleNpcs xCloneRoleNpcs = Clone_role_npc_of_gang.get(Long.valueOf(customKey));
/* 363 */       if (xCloneRoleNpcs == null)
/*     */       {
/* 365 */         xCloneRoleNpcs = Pod.newCloneRoleNpcs();
/* 366 */         Clone_role_npc_of_gang.insert(Long.valueOf(customKey), xCloneRoleNpcs);
/*     */       }
/* 368 */       return xCloneRoleNpcs;
/*     */     }
/*     */     
/*     */     
/* 372 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static CloneRoleNpcs getXCloneRoleNpcs(CloneRoleNpcModelType cloneRoleNpcModelType, long customKey, boolean isHoldLock)
/*     */   {
/* 379 */     switch (cloneRoleNpcModelType)
/*     */     {
/*     */ 
/*     */     case MEN_PAI: 
/*     */     case QI_MAI_HUI_WU: 
/*     */     case MEN_PAI_STAR: 
/* 385 */       long generalKey = cloneRoleNpcModelType.toKey();
/* 386 */       return isHoldLock ? Clone_role_npc_of_general.get(Long.valueOf(generalKey)) : Clone_role_npc_of_general.select(Long.valueOf(generalKey));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     case GANG: 
/* 392 */       return isHoldLock ? Clone_role_npc_of_gang.get(Long.valueOf(customKey)) : Clone_role_npc_of_gang.select(Long.valueOf(customKey));
/*     */     }
/*     */     
/*     */     
/*     */ 
/* 397 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static CloneRoleNPCModel getXCloneRoleNPCModel(CloneRoleNpcModelType cloneRoleNpcModelType, long customKey, int npcCfgid, boolean isHoldLock)
/*     */   {
/* 404 */     CloneRoleNpcs xCloneRoleNpcs = getXCloneRoleNpcs(cloneRoleNpcModelType, customKey, isHoldLock);
/* 405 */     if (xCloneRoleNpcs == null)
/*     */     {
/* 407 */       return null;
/*     */     }
/*     */     
/* 410 */     Long cloneRoleNpcModelKey = (Long)xCloneRoleNpcs.getNpc_map().get(Integer.valueOf(npcCfgid));
/* 411 */     if (cloneRoleNpcModelKey == null)
/*     */     {
/* 413 */       return null;
/*     */     }
/*     */     
/* 416 */     return isHoldLock ? Clone_role_npc_models.get(cloneRoleNpcModelKey) : Clone_role_npc_models.select(cloneRoleNpcModelKey);
/*     */   }
/*     */   
/*     */ 
/*     */   public static SBaseBrightMonster getBaseBrightMonster(SMapVisibleMonster mapVisibleMonster)
/*     */   {
/* 422 */     if (mapVisibleMonster.monsterType == 3)
/*     */     {
/* 424 */       return null;
/*     */     }
/*     */     
/* 427 */     return mapVisibleMonster.monsterType == 1 ? SActiveBrightMonster.get(mapVisibleMonster.cfgid) : SBrightMonster.get(mapVisibleMonster.cfgid);
/*     */   }
/*     */   
/*     */ 
/*     */   public static int getVisibleMonsterFightCfgid(SMapVisibleMonster mapVisibleMonster)
/*     */   {
/* 433 */     SBaseBrightMonster baseBrightMonster = getBaseBrightMonster(mapVisibleMonster);
/* 434 */     if (baseBrightMonster == null)
/*     */     {
/* 436 */       return 0;
/*     */     }
/*     */     
/* 439 */     return baseBrightMonster.monsterFightTableId;
/*     */   }
/*     */   
/*     */   public static String getVisibleMonsterName(SMapVisibleMonster mapVisibleMonster)
/*     */   {
/* 444 */     SBaseBrightMonster baseBrightMonster = getBaseBrightMonster(mapVisibleMonster);
/* 445 */     if (baseBrightMonster == null)
/*     */     {
/* 447 */       return null;
/*     */     }
/*     */     
/* 450 */     return baseBrightMonster.name;
/*     */   }
/*     */   
/*     */   public static Integer getVisibleMonsterControllerCfgid(SMapVisibleMonster mapVisibleMonster)
/*     */   {
/* 455 */     SBaseBrightMonster baseBrightMonster = getBaseBrightMonster(mapVisibleMonster);
/* 456 */     if (baseBrightMonster == null)
/*     */     {
/* 458 */       return null;
/*     */     }
/*     */     
/* 461 */     return Integer.valueOf(baseBrightMonster.controllerId);
/*     */   }
/*     */   
/*     */   public static void forceTmpLeaveTeam(long roleid)
/*     */   {
/* 466 */     new PForceTmpLeaveTeam(roleid).execute();
/*     */   }
/*     */   
/*     */   public static MapModelInfo boxChildrenModelInfo(ChildrenInterface.ShowChildObj showChildObj)
/*     */   {
/* 471 */     return boxChildrenModelInfo(showChildObj, null);
/*     */   }
/*     */   
/*     */   public static MapModelInfo boxChildrenModelInfo(ChildrenInterface.ShowChildObj showChildObj, MapModelInfo childrenModelInfo)
/*     */   {
/* 476 */     if (childrenModelInfo == null)
/*     */     {
/* 478 */       childrenModelInfo = new MapModelInfo();
/*     */     }
/*     */     
/* 481 */     childrenModelInfo.id = showChildObj.getChildId();
/* 482 */     childrenModelInfo.string_props.put(Integer.valueOf(0), showChildObj.getChildName());
/* 483 */     childrenModelInfo.model.extramap.put(Integer.valueOf(25), Integer.valueOf(showChildObj.getChildPeriod()));
/* 484 */     childrenModelInfo.model.extramap.put(Integer.valueOf(26), Integer.valueOf(showChildObj.getChildGender()));
/* 485 */     childrenModelInfo.model.extramap.put(Integer.valueOf(28), Integer.valueOf(showChildObj.getChildrenCfgid()));
/*     */     
/* 487 */     int weaponCfgid = showChildObj.getChildrenWeaponCfgid();
/* 488 */     if (weaponCfgid > 0)
/*     */     {
/* 490 */       childrenModelInfo.model.extramap.put(Integer.valueOf(29), Integer.valueOf(weaponCfgid));
/*     */     }
/*     */     
/* 493 */     int fashionCfgid = showChildObj.getFashionCfgid();
/* 494 */     if (fashionCfgid > 0)
/*     */     {
/* 496 */       childrenModelInfo.model.extramap.put(Integer.valueOf(27), Integer.valueOf(fashionCfgid));
/*     */     }
/*     */     
/* 499 */     return childrenModelInfo;
/*     */   }
/*     */   
/*     */ 
/*     */   public static Location calculatePosition(LinkedList<Location> keyPointPath, double velocity, Location curPos, Location nextPos, long deltaTime)
/*     */   {
/* 505 */     return calculatePosition(keyPointPath, velocity, curPos, nextPos, deltaTime, null);
/*     */   }
/*     */   
/*     */ 
/*     */   public static Location calculatePosition(LinkedList<Location> keyPointPath, double velocity, Location curPos, Location nextPos, long deltaTime, Scene scene)
/*     */   {
/* 511 */     int dirX = nextPos.x - curPos.x;
/* 512 */     int dirY = nextPos.y - curPos.y;
/* 513 */     double dist = Math.sqrt(dirX * dirX + dirY * dirY);
/* 514 */     if (dist > 0.0D)
/*     */     {
/* 516 */       if (dist < velocity * deltaTime / 1000.0D)
/*     */       {
/* 518 */         long useTime = (dist / velocity * 1000.0D);
/* 519 */         deltaTime -= useTime;
/*     */         
/* 521 */         if (scene != null)
/*     */         {
/* 523 */           Location location = checkTrace(scene, curPos, nextPos);
/* 524 */           if (location != null)
/*     */           {
/* 526 */             keyPointPath.clear();
/* 527 */             return location;
/*     */           }
/*     */         }
/*     */         
/* 531 */         curPos = nextPos;
/* 532 */         keyPointPath.pollFirst();
/* 533 */         if (keyPointPath.isEmpty())
/*     */         {
/* 535 */           return curPos;
/*     */         }
/*     */         
/*     */ 
/* 539 */         curPos = nextPos;
/* 540 */         nextPos = (Location)keyPointPath.peekFirst();
/* 541 */         Location findPos = calculatePosition(keyPointPath, velocity, curPos, nextPos, deltaTime, scene);
/* 542 */         if (findPos == null)
/*     */         {
/* 544 */           return curPos;
/*     */         }
/*     */         
/* 547 */         return findPos;
/*     */       }
/*     */       
/* 550 */       double speedX = dirX / dist * velocity;
/* 551 */       double speedY = dirY / dist * velocity;
/* 552 */       nextPos = new Location((int)(curPos.x + speedX * deltaTime / 1000.0D), (int)(curPos.y + speedY * deltaTime / 1000.0D));
/*     */       
/* 554 */       if (scene != null)
/*     */       {
/* 556 */         Location location = checkTrace(scene, curPos, nextPos);
/* 557 */         if (location != null)
/*     */         {
/* 559 */           keyPointPath.clear();
/* 560 */           return location;
/*     */         }
/*     */       }
/*     */       
/* 564 */       return nextPos;
/*     */     }
/*     */     
/*     */ 
/* 568 */     keyPointPath.pollFirst();
/*     */     
/* 570 */     return null;
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
/*     */   static Location checkTrace(Scene scene, Location curPos, Location nextPos)
/*     */   {
/* 584 */     SMapConfig mapConfig = scene.getMapConfig();
/*     */     
/* 586 */     int cellCol0 = curPos.x / mapConfig.cellWidth;
/* 587 */     int cellRow0 = curPos.y / mapConfig.cellHeight;
/* 588 */     Cell cell0 = scene.getCellByColRow(mapConfig, cellCol0, cellRow0);
/* 589 */     int cellCol1 = nextPos.x / mapConfig.cellWidth;
/* 590 */     int cellRow1 = nextPos.y / mapConfig.cellHeight;
/* 591 */     Cell cell1 = scene.getCellByColRow(mapConfig, cellCol1, cellRow1);
/* 592 */     if ((cell0 == null) || (cell1 == null))
/*     */     {
/*     */ 
/* 595 */       return null;
/*     */     }
/*     */     
/* 598 */     if (!cell0.isReachable())
/*     */     {
/*     */ 
/* 601 */       return null;
/*     */     }
/*     */     
/* 604 */     if (!cell1.isReachable())
/*     */     {
/* 606 */       return curPos;
/*     */     }
/*     */     
/* 609 */     if (cell0 == cell1)
/*     */     {
/* 611 */       return null;
/*     */     }
/*     */     
/* 614 */     if ((Math.abs(cellCol0 - cellCol1) == 1) && (Math.abs(cellRow0 - cellRow1) == 1))
/*     */     {
/* 616 */       return null;
/*     */     }
/*     */     
/* 619 */     int px0 = curPos.x;
/* 620 */     int py0 = curPos.y;
/* 621 */     int x0 = cellCol0;
/* 622 */     int y0 = cellRow0;
/* 623 */     int px1 = nextPos.x;
/* 624 */     int py1 = nextPos.y;
/* 625 */     int x1 = cellCol1;
/* 626 */     int y1 = cellRow1;
/* 627 */     boolean steep = Math.abs(py1 - py0) > Math.abs(px1 - px0);
/* 628 */     if (steep)
/*     */     {
/* 630 */       int t = x0;
/* 631 */       x0 = y0;
/* 632 */       y0 = t;
/*     */       
/* 634 */       t = x1;
/* 635 */       x1 = y1;
/* 636 */       y1 = t;
/*     */       
/* 638 */       t = px0;
/* 639 */       px0 = py0;
/* 640 */       py0 = t;
/*     */       
/* 642 */       t = px1;
/* 643 */       px1 = py1;
/* 644 */       py1 = t;
/*     */     }
/*     */     
/* 647 */     if (px0 > px1)
/*     */     {
/* 649 */       int t = x0;
/* 650 */       x0 = x1;
/* 651 */       x1 = t;
/*     */       
/* 653 */       t = y0;
/* 654 */       y0 = y1;
/* 655 */       y1 = t;
/*     */       
/* 657 */       t = px0;
/* 658 */       px0 = px1;
/* 659 */       px1 = t;
/*     */       
/* 661 */       t = py0;
/* 662 */       py0 = py1;
/* 663 */       py1 = t;
/*     */     }
/*     */     
/* 666 */     int deltax = px1 - px0;
/* 667 */     int deltay = Math.abs(py1 - py0);
/* 668 */     float error = 0.0F;
/* 669 */     float deltaErr = deltay / deltax;
/*     */     
/* 671 */     int y = y0;
/* 672 */     int ystep; int ystep; if (py0 < py1)
/*     */     {
/* 674 */       error = ((x0 * 16 + 8 - px0) * deltaErr + py0 - y0 * 16 - 8.0F) / 16.0F;
/* 675 */       ystep = 1;
/*     */     }
/*     */     else
/*     */     {
/* 679 */       error = (y0 * 16 + 8 - (py0 - (x0 * 16 + 8 - px0) * deltaErr)) / 16.0F;
/* 680 */       ystep = -1;
/*     */     }
/*     */     
/* 683 */     int lastCellCol = -1;
/* 684 */     int lastCellRow = -1;
/* 685 */     for (int x = x0; x < x1; x++)
/*     */     {
/* 687 */       if (steep)
/*     */       {
/* 689 */         Cell cell = scene.getCellByColRow(mapConfig, x, y);
/* 690 */         if (cell == null)
/*     */         {
/* 692 */           return new Location(lastCellCol * 16, lastCellRow * 16);
/*     */         }
/*     */         
/* 695 */         if (!cell.isReachable())
/*     */         {
/* 697 */           Cell upCell = scene.getCellByColRow(mapConfig, x + 1, y);
/* 698 */           Cell downCell = scene.getCellByColRow(mapConfig, x - 1, y);
/*     */           
/* 700 */           if (((upCell == null) || (!upCell.isReachable())) && ((downCell == null) || (!downCell.isReachable())))
/*     */           {
/* 702 */             return new Location(lastCellCol * 16, lastCellRow * 16);
/*     */           }
/*     */         }
/*     */         
/* 706 */         lastCellCol = x;
/* 707 */         lastCellRow = y;
/*     */       }
/*     */       else
/*     */       {
/* 711 */         Cell cell = scene.getCellByColRow(mapConfig, y, x);
/* 712 */         if (cell == null)
/*     */         {
/* 714 */           return new Location(lastCellCol * 16, lastCellRow * 16);
/*     */         }
/*     */         
/* 717 */         if (!cell.isReachable())
/*     */         {
/* 719 */           Cell upCell = scene.getCellByColRow(mapConfig, y + 1, x);
/* 720 */           Cell downCell = scene.getCellByColRow(mapConfig, y - 1, x);
/*     */           
/* 722 */           if (((upCell == null) || (!upCell.isReachable())) && ((downCell == null) || (!downCell.isReachable())))
/*     */           {
/* 724 */             return new Location(lastCellCol * 16, lastCellRow * 16);
/*     */           }
/*     */         }
/*     */         
/* 728 */         lastCellCol = x;
/* 729 */         lastCellRow = y;
/*     */       }
/*     */       
/* 732 */       error += deltaErr;
/* 733 */       while (error > 0.5D)
/*     */       {
/* 735 */         y += ystep;
/* 736 */         error -= 1.0F;
/*     */       }
/*     */     }
/*     */     
/* 740 */     return null;
/*     */   }
/*     */   
/*     */   static final boolean onPetMarkChange(long roleid, long petid)
/*     */   {
/* 745 */     if (!PetInterface.isShowPet(roleid, petid))
/*     */     {
/* 747 */       return false;
/*     */     }
/*     */     
/* 750 */     Pet pet = PetInterface.getShowPet(roleid, false);
/* 751 */     if ((pet == null) || (pet.getId() != petid))
/*     */     {
/* 753 */       return false;
/*     */     }
/*     */     
/* 756 */     MapModelInfo petMapModelInfo = new MapModelInfo();
/* 757 */     pet.getMapModel(petMapModelInfo);
/* 758 */     new MMH_PetAppearanceChange(roleid, petid, petMapModelInfo, 6).execute();
/*     */     
/* 760 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\MapManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */