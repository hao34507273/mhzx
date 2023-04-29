/*      */ package mzm.gsp.map.main;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import mzm.gsp.map.Location;
/*      */ import mzm.gsp.map.NPCModelInfo;
/*      */ import mzm.gsp.map.confbean.SMapConfig;
/*      */ import mzm.gsp.map.confbean.SMapItemCfg;
/*      */ import mzm.gsp.map.confbean.SMapItemConfig;
/*      */ import mzm.gsp.map.confbean.SMapVisibleMonster;
/*      */ import mzm.gsp.map.main.group.MapGroupType;
/*      */ import mzm.gsp.map.main.message.MMH_AddMapEntity;
/*      */ import mzm.gsp.map.main.message.MMH_AddSpeedFixAdded;
/*      */ import mzm.gsp.map.main.message.MMH_AddSpeedPercentAdded;
/*      */ import mzm.gsp.map.main.message.MMH_BroadcastInSight;
/*      */ import mzm.gsp.map.main.message.MMH_ChangeMapEntityExtraInfos;
/*      */ import mzm.gsp.map.main.message.MMH_ChangeMapEntityInfos;
/*      */ import mzm.gsp.map.main.message.MMH_ChangeMapGroupExtraInfos;
/*      */ import mzm.gsp.map.main.message.MMH_CreateMapGroup;
/*      */ import mzm.gsp.map.main.message.MMH_CreateWorld;
/*      */ import mzm.gsp.map.main.message.MMH_DestroyScene;
/*      */ import mzm.gsp.map.main.message.MMH_DestroyVisibleMonster;
/*      */ import mzm.gsp.map.main.message.MMH_DestroyWorldById;
/*      */ import mzm.gsp.map.main.message.MMH_DestroyWorldBySceneId;
/*      */ import mzm.gsp.map.main.message.MMH_ForceTransferWhenFault;
/*      */ import mzm.gsp.map.main.message.MMH_GetAllSingleRoleAndTeamLeaderInWorld;
/*      */ import mzm.gsp.map.main.message.MMH_GetAllSingleRoleInWorld;
/*      */ import mzm.gsp.map.main.message.MMH_GetAllTeamInWorld;
/*      */ import mzm.gsp.map.main.message.MMH_GetMapEntityPos;
/*      */ import mzm.gsp.map.main.message.MMH_GetMonsterCountInMap;
/*      */ import mzm.gsp.map.main.message.MMH_GetMonsterNumInWorld;
/*      */ import mzm.gsp.map.main.message.MMH_GetRoleCountInMap;
/*      */ import mzm.gsp.map.main.message.MMH_GetRoleList;
/*      */ import mzm.gsp.map.main.message.MMH_GetRoleListNearbyMapEntity;
/*      */ import mzm.gsp.map.main.message.MMH_GetRoleMapId;
/*      */ import mzm.gsp.map.main.message.MMH_GetRoleNumInWorld;
/*      */ import mzm.gsp.map.main.message.MMH_GetRoleWorldId;
/*      */ import mzm.gsp.map.main.message.MMH_GetRolesInSomebodyView;
/*      */ import mzm.gsp.map.main.message.MMH_GetRolesPosition;
/*      */ import mzm.gsp.map.main.message.MMH_GetSceneInstanceId;
/*      */ import mzm.gsp.map.main.message.MMH_GetSceneName;
/*      */ import mzm.gsp.map.main.message.MMH_GetSingleRoleAndTeamInWorld;
/*      */ import mzm.gsp.map.main.message.MMH_GetSingleRoleCollectionFromPKZone;
/*      */ import mzm.gsp.map.main.message.MMH_GetTeamCollectionFromPKZone;
/*      */ import mzm.gsp.map.main.message.MMH_GetVisibleMonsterCfgId;
/*      */ import mzm.gsp.map.main.message.MMH_GroupMove;
/*      */ import mzm.gsp.map.main.message.MMH_IsNearByMapEntity;
/*      */ import mzm.gsp.map.main.message.MMH_IsNearByNPC;
/*      */ import mzm.gsp.map.main.message.MMH_IsNearByPos;
/*      */ import mzm.gsp.map.main.message.MMH_IsNpcExist;
/*      */ import mzm.gsp.map.main.message.MMH_IsRoleInMoveState;
/*      */ import mzm.gsp.map.main.message.MMH_IsRoleInPkZone;
/*      */ import mzm.gsp.map.main.message.MMH_IsRolesInSameView;
/*      */ import mzm.gsp.map.main.message.MMH_IsWorldExist;
/*      */ import mzm.gsp.map.main.message.MMH_IsXunLuo;
/*      */ import mzm.gsp.map.main.message.MMH_MapEntityMove;
/*      */ import mzm.gsp.map.main.message.MMH_ObserveMonsterFight;
/*      */ import mzm.gsp.map.main.message.MMH_OnPlayExpressionItem;
/*      */ import mzm.gsp.map.main.message.MMH_OnRoleColorChange;
/*      */ import mzm.gsp.map.main.message.MMH_OpMonsterFightHandler;
/*      */ import mzm.gsp.map.main.message.MMH_PlayerMove;
/*      */ import mzm.gsp.map.main.message.MMH_PlayerSetOtherOctetInfo;
/*      */ import mzm.gsp.map.main.message.MMH_PlayerTransferToScene;
/*      */ import mzm.gsp.map.main.message.MMH_RegisterZoneEvent;
/*      */ import mzm.gsp.map.main.message.MMH_RemoveCloneRoleNpc;
/*      */ import mzm.gsp.map.main.message.MMH_RemoveMapEntity;
/*      */ import mzm.gsp.map.main.message.MMH_RemoveMapGroup;
/*      */ import mzm.gsp.map.main.message.MMH_RemoveMapGroupByRoleid;
/*      */ import mzm.gsp.map.main.message.MMH_RolesNearBySomebody;
/*      */ import mzm.gsp.map.main.message.MMH_SetBroadcastPosInSceneStatus;
/*      */ import mzm.gsp.map.main.message.MMH_SetHuSong;
/*      */ import mzm.gsp.map.main.message.MMH_SetLimitPolygonMovementStatus;
/*      */ import mzm.gsp.map.main.message.MMH_SetMapMonsterStarLevelData;
/*      */ import mzm.gsp.map.main.message.MMH_SetSceneProperty;
/*      */ import mzm.gsp.map.main.message.MMH_SetWorldAppMsgHandler;
/*      */ import mzm.gsp.map.main.message.MMH_SetXunLuoState;
/*      */ import mzm.gsp.map.main.message.MMH_SpawnVisibleMonster;
/*      */ import mzm.gsp.map.main.message.MMH_TeleportOrCreateScene;
/*      */ import mzm.gsp.map.main.message.MMH_TeleportTargetMonster;
/*      */ import mzm.gsp.map.main.message.MMH_TransformToRole;
/*      */ import mzm.gsp.map.main.message.MMH_UnRegisterZoneEvent;
/*      */ import mzm.gsp.map.main.message.MMH_WorldHasRole;
/*      */ import mzm.gsp.map.main.message.MapMessageQueue;
/*      */ import mzm.gsp.map.main.message.MapProtocolSendQueue;
/*      */ import mzm.gsp.map.main.proto.Cell;
/*      */ import mzm.gsp.map.main.proto.MapPrototype;
/*      */ import mzm.gsp.map.main.scene.Position;
/*      */ import mzm.gsp.map.main.scene.ScenePropertyKey;
/*      */ import mzm.gsp.map.main.scene.TransferType;
/*      */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*      */ import mzm.gsp.map.main.scene.zone.ZoneForm;
/*      */ import mzm.gsp.map.main.scene.zone.type.event.IMapEntityZoneListener;
/*      */ import mzm.gsp.map.main.scene.zone.type.event.IZoneListener;
/*      */ import mzm.gsp.monster.confbean.SBrightMonster;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.pubdata.ModelInfo;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*      */ import xbean.CloneRoleNPCModel;
/*      */ import xio.Protocol;
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
/*      */ public class MapInterface
/*      */ {
/*      */   public static Position randomWalkablePos(int mapCfgid)
/*      */   {
/*  122 */     return MapPrototype.randomPosFromAllRegions(mapCfgid);
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
/*      */   public static Position randomPosFromRegion(int mapCfgid, int regionid)
/*      */   {
/*  137 */     return MapPrototype.randomPosFromRegion(mapCfgid, regionid);
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
/*      */   public static Position randomPos(int mapCfgid)
/*      */   {
/*  150 */     MapPrototype prototype = MapCfgManager.getInstance().getMapProtoById(mapCfgid);
/*  151 */     if (prototype == null)
/*      */     {
/*  153 */       return null;
/*      */     }
/*      */     
/*  156 */     return prototype.randomPos(mapCfgid);
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
/*      */   public static boolean isInSameView(long role1Id, long role2Id)
/*      */   {
/*  170 */     MMH_IsRolesInSameView handler = new MMH_IsRolesInSameView(Arrays.asList(new Long[] { Long.valueOf(role1Id), Long.valueOf(role2Id) }));
/*  171 */     handler.call();
/*  172 */     return handler.getResult();
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
/*      */   public static <T extends Position> void getRolePosition(long roleid, MapCallback<Map<Long, T>> callback)
/*      */   {
/*  185 */     getRolesPosition(Arrays.asList(new Long[] { Long.valueOf(roleid) }), callback);
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
/*      */   public static <T extends Position> void getRolesPosition(Collection<Long> roleids, MapCallback<Map<Long, T>> callback)
/*      */   {
/*  200 */     new MMH_GetRolesPosition(roleids, callback).execute();
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
/*      */   public static int getDarkMonsterTableId(int mapCfgId)
/*      */   {
/*  213 */     MapPrototype cfg = MapCfgManager.getInstance().getMapProtoById(mapCfgId);
/*  214 */     if (cfg == null)
/*      */     {
/*  216 */       return 0;
/*      */     }
/*  218 */     return cfg.getDarkMonsterTableId();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getDarkMonsterFightId(int invisibleMonsterCfgId)
/*      */   {
/*  230 */     return MapObjectManager.getInstance().getDarkMonsterFightId(invisibleMonsterCfgId);
/*      */   }
/*      */   
/*      */   public static boolean isMapHaveRandomRegion(int cfgId)
/*      */   {
/*  235 */     MapPrototype prototype = MapCfgManager.getInstance().getMapProtoById(cfgId);
/*  236 */     if (prototype == null)
/*      */     {
/*  238 */       return false;
/*      */     }
/*      */     
/*  241 */     Map<Integer, Integer> regions = prototype.getRegions();
/*  242 */     return (regions != null) && (!regions.isEmpty());
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
/*      */   public static void transformToRole(long transferRoleId, long targetRoleId, MapCallback<Boolean> callback)
/*      */   {
/*  257 */     new MMH_TransformToRole(transferRoleId, targetRoleId, callback).execute();
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
/*      */   public static void registerZoneEvent(int sceneid, ZoneForm zoneForm, IZoneListener listener, MapCallback<Integer> callback)
/*      */   {
/*  275 */     new MMH_RegisterZoneEvent(sceneid, zoneForm, listener, callback).execute();
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
/*      */   public static void registerZoneEvent(int sceneid, ZoneForm zoneForm, int spaceFlags, IZoneListener listener, MapCallback<Integer> callback)
/*      */   {
/*  295 */     new MMH_RegisterZoneEvent(sceneid, zoneForm, spaceFlags, listener, callback).execute();
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
/*      */   public static void registerZoneEvent(int sceneid, ZoneForm zoneForm, IMapEntityZoneListener listener, MapCallback<Integer> callback)
/*      */   {
/*  313 */     new MMH_RegisterZoneEvent(sceneid, zoneForm, listener, callback).execute();
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
/*      */   public static void registerZoneEvent(int sceneid, ZoneForm zoneForm, int spaceFlags, IMapEntityZoneListener listener, MapCallback<Integer> callback)
/*      */   {
/*  333 */     new MMH_RegisterZoneEvent(sceneid, zoneForm, spaceFlags, listener, callback).execute();
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
/*      */   public static void unregisterZoneEvent(int sceneid, int eventid)
/*      */   {
/*  346 */     new MMH_UnRegisterZoneEvent(sceneid, eventid).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isMapItemExist(int mapItemCfgId)
/*      */   {
/*  358 */     return (SMapItemConfig.get(mapItemCfgId) != null) && (SMapItemCfg.get(mapItemCfgId) != null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isNpcExist(int npcCfgId)
/*      */   {
/*  370 */     MMH_IsNpcExist hanlder = new MMH_IsNpcExist(npcCfgId);
/*  371 */     hanlder.call();
/*  372 */     return hanlder.getResult();
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
/*      */   public static void getSingleRoleCollectionFromPKZone(Collection<Long> collection, int sceneid)
/*      */   {
/*  386 */     MMH_GetSingleRoleCollectionFromPKZone handler = new MMH_GetSingleRoleCollectionFromPKZone(sceneid, collection);
/*  387 */     handler.call();
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
/*      */   public static void getTeamCollectionFromPKZone(Collection<Long> collection, int sceneid)
/*      */   {
/*  401 */     MMH_GetTeamCollectionFromPKZone handler = new MMH_GetTeamCollectionFromPKZone(sceneid, collection);
/*  402 */     handler.call();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isRoleInPkZone(int sceneid, long roleId)
/*      */   {
/*  414 */     MMH_IsRoleInPkZone handler = new MMH_IsRoleInPkZone(roleId, sceneid);
/*  415 */     handler.call();
/*  416 */     return handler.getResult();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isHasMap(int mapCfgId)
/*      */   {
/*  427 */     return MapCfgManager.getInstance().getMapProtoById(mapCfgId) != null;
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
/*      */   public static int spawnVisibleMonster(int sceneId, int visibleMonsterCfgId)
/*      */   {
/*  442 */     MMH_SpawnVisibleMonster handler = new MMH_SpawnVisibleMonster(sceneId, visibleMonsterCfgId);
/*  443 */     handler.call();
/*  444 */     return handler.getResult();
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
/*      */   public static int spawnVisibleMonster(long worldId, int mapCfgId, int visibleMonsterCfgId)
/*      */   {
/*  461 */     MMH_SpawnVisibleMonster handler = new MMH_SpawnVisibleMonster(worldId, mapCfgId, visibleMonsterCfgId);
/*  462 */     handler.call();
/*  463 */     return handler.getResult();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void destroyVisibleMonster(int monsterInstanceId)
/*      */   {
/*  474 */     new MMH_DestroyVisibleMonster(monsterInstanceId).call();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean checkIsExistVisibleMonster(int mapCfgId, int visibleMonsterCfgId)
/*      */   {
/*  486 */     MapPrototype cfg = MapCfgManager.getInstance().getMapProtoById(mapCfgId);
/*  487 */     if (cfg == null)
/*      */     {
/*  489 */       return false;
/*      */     }
/*      */     
/*  492 */     return cfg.isExistVisibleMonster(visibleMonsterCfgId);
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
/*      */   public static int getVisibleMonsterFightId(int mapCfgId, int visibleMonsterCfgId)
/*      */   {
/*  505 */     MapPrototype cfg = MapCfgManager.getInstance().getMapProtoById(mapCfgId);
/*  506 */     if (cfg == null)
/*      */     {
/*  508 */       return 0;
/*      */     }
/*  510 */     SMapVisibleMonster visibleMonster = cfg.getVisibleMonster(visibleMonsterCfgId);
/*  511 */     if (visibleMonster == null)
/*      */     {
/*  513 */       return 0;
/*      */     }
/*      */     
/*  516 */     return MapManager.getVisibleMonsterFightCfgid(visibleMonster);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getVisibleMonsterCfgId(int monsterInstanceId)
/*      */   {
/*  528 */     MMH_GetVisibleMonsterCfgId handler = new MMH_GetVisibleMonsterCfgId(monsterInstanceId);
/*  529 */     handler.call();
/*  530 */     return handler.getResult();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getRoleCountInMap(int sceneId)
/*      */   {
/*  541 */     MMH_GetRoleCountInMap handler = new MMH_GetRoleCountInMap(sceneId);
/*  542 */     handler.call();
/*  543 */     return handler.getResult();
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
/*      */   public static int getPassiveMonsterMaxKilledTimes(int monsterCfgid)
/*      */   {
/*  556 */     SBrightMonster brightMonster = SBrightMonster.get(monsterCfgid);
/*  557 */     if (brightMonster == null)
/*      */     {
/*  559 */       return -1;
/*      */     }
/*      */     
/*  562 */     return brightMonster.maxKilledTimes;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getMonsterCfgNumInMap(int mapCfgid, int monsterCfgid)
/*      */   {
/*  574 */     return MapCfgManager.getInstance().getMonsterCfgNumInMap(mapCfgid, monsterCfgid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getMonsterCountInMap(int sceneId)
/*      */   {
/*  585 */     MMH_GetMonsterCountInMap handler = new MMH_GetMonsterCountInMap(sceneId);
/*  586 */     handler.call();
/*  587 */     return handler.getResult();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getMonsterCountInMapCfg(int mapCfgId)
/*      */   {
/*  598 */     MapPrototype cfg = MapCfgManager.getInstance().getMapProtoById(mapCfgId);
/*  599 */     if (cfg == null)
/*  600 */       return 0;
/*  601 */     return cfg.getMonsterNumber();
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
/*      */   public static void autoMove(long roleId, int targetSceneId, int x, int y, int targetX, int targetY)
/*      */   {
/*  617 */     new MMH_PlayerTransferToScene(roleId, targetSceneId, x, y, targetX, targetY, TransferType.TRANSPOS).execute();
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
/*      */   public static void autoMove(long roleId, int targetSceneId, int targetX, int targetY)
/*      */   {
/*  632 */     new MMH_PlayerTransferToScene(roleId, targetSceneId, 0, 0, targetX, targetY, TransferType.TRANSPOS).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String getSceneName(int sceneId)
/*      */   {
/*  640 */     MMH_GetSceneName handler = new MMH_GetSceneName(sceneId);
/*  641 */     handler.call();
/*  642 */     return handler.getResult();
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
/*      */   public static long createWorld(Collection<Integer> mapCfgIds)
/*      */   {
/*  655 */     MMH_CreateWorld handler = new MMH_CreateWorld(mapCfgIds);
/*  656 */     handler.call();
/*  657 */     return handler.getResult();
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
/*      */   public static void createWorld(Collection<Integer> mapCfgIds, MapCallback<Long> callback)
/*      */   {
/*  672 */     new MMH_CreateWorld(mapCfgIds, callback).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void destroyWorld(long worldid)
/*      */   {
/*  684 */     new MMH_DestroyWorldById(worldid, null).execute();
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
/*      */   public static void destroyWorld(long worldid, MapCallback<Boolean> callback)
/*      */   {
/*  697 */     new MMH_DestroyWorldById(worldid, callback).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void destroyWorld(int sceneid)
/*      */   {
/*  709 */     new MMH_DestroyWorldBySceneId(sceneid, null).execute();
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
/*      */   public static void destroyWorld(int sceneid, MapCallback<Boolean> callback)
/*      */   {
/*  722 */     new MMH_DestroyWorldBySceneId(sceneid, callback).execute();
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
/*      */   public static void destroyScene(long worldid, int mapCfgid, MapCallback<Boolean> callback)
/*      */   {
/*  737 */     new MMH_DestroyScene(worldid, mapCfgid, callback).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setMenPaiNpcModelAsyc(long roleId)
/*      */   {
/*  748 */     NoneRealTimeTaskManager.getInstance().addTask(new PSetMenPaiNpcModel(roleId));
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
/*      */   public static void setCloneRoleNpcModelAsyc(CloneRoleNpcModelType cloneRoleNpcModelType, long roleid, int npcCfgid, int appellationCfgid)
/*      */   {
/*  763 */     NoneRealTimeTaskManager.getInstance().addTask(new PSetCloneRoleNpcModel(cloneRoleNpcModelType, -1L, roleid, npcCfgid, appellationCfgid));
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
/*      */   public static void setCloneRoleNpcModelAsyc(CloneRoleNpcModelType cloneRoleNpcModelType, long customKey, long roleid, int npcCfgid, int appellationCfgid)
/*      */   {
/*  780 */     NoneRealTimeTaskManager.getInstance().addTask(new PSetCloneRoleNpcModel(cloneRoleNpcModelType, customKey, roleid, npcCfgid, appellationCfgid));
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
/*      */   public static void unsetCloneRoleNpcModelAsync(CloneRoleNpcModelType cloneRoleNpcModelType, int npcCfgid)
/*      */   {
/*  793 */     NoneRealTimeTaskManager.getInstance().addTask(new PUnsetCloneRoleNpcModel(cloneRoleNpcModelType, -1L, npcCfgid));
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
/*      */   public static void unsetCloneRoleNpcModelAsync(CloneRoleNpcModelType cloneRoleNpcModelType, long customKey, int npcCfgid)
/*      */   {
/*  807 */     NoneRealTimeTaskManager.getInstance().addTask(new PUnsetCloneRoleNpcModel(cloneRoleNpcModelType, customKey, npcCfgid));
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
/*      */   public static void addCloneRoleNpcAsync(CloneRoleNpcModelType cloneRoleNpcModelType, long customKey, int npcCfgid, long worldid)
/*      */   {
/*  821 */     NoneRealTimeTaskManager.getInstance().addTask(new PAddCloneRoleNpc(cloneRoleNpcModelType, customKey, npcCfgid, worldid));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void removeCloneRoleNpcAsync(int npcCfgid, long worldid)
/*      */   {
/*  832 */     new MMH_RemoveCloneRoleNpc(worldid, npcCfgid).execute();
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
/*      */   public static ModelInfo getCloneRoleNpcPubModelInfo(CloneRoleNpcModelType cloneRoleNpcModelType, int npcCfgid, boolean isHoldLock)
/*      */   {
/*  849 */     return getCloneRoleNpcPubModelInfo(cloneRoleNpcModelType, -1L, npcCfgid, isHoldLock);
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
/*      */   public static ModelInfo getCloneRoleNpcPubModelInfo(CloneRoleNpcModelType cloneRoleNpcModelType, long customKey, int npcCfgid, boolean isHoldLock)
/*      */   {
/*  867 */     CloneRoleNPCModel xCloneRoleNPCModel = MapManager.getXCloneRoleNPCModel(cloneRoleNpcModelType, customKey, npcCfgid, isHoldLock);
/*      */     
/*  869 */     if (xCloneRoleNPCModel == null)
/*      */     {
/*  871 */       return null;
/*      */     }
/*      */     
/*  874 */     NPCModelInfo npcModelInfo = MapObjectManager.getInstance().boxNpcModelInfo(npcCfgid, xCloneRoleNPCModel);
/*  875 */     return npcModelInfo.model;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isNearByNPC(long roleId, int npcId)
/*      */   {
/*  887 */     MMH_IsNearByNPC handler = new MMH_IsNearByNPC(roleId, npcId);
/*  888 */     handler.call();
/*  889 */     return handler.getResult();
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
/*      */   public static boolean isNearByMapEntity(long roleid, MapEntityType entityType, long entityInstanceid)
/*      */   {
/*  903 */     MMH_IsNearByMapEntity handler = new MMH_IsNearByMapEntity(roleid, entityType, entityInstanceid);
/*  904 */     handler.call();
/*  905 */     return handler.getResult();
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
/*      */   public static void isNearByMapEntity(long roleid, MapEntityType entityType, long entityInstanceid, MapCallback<Boolean> callback)
/*      */   {
/*  919 */     new MMH_IsNearByMapEntity(roleid, entityType, entityInstanceid, callback).execute();
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
/*      */   public static void isNearByNPC(long roleId, int npcId, MapCallback<Boolean> callback)
/*      */   {
/*  932 */     new MMH_IsNearByNPC(roleId, npcId, callback).execute();
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
/*      */   public static void isNearByPos(long roleId, int mapCfgid, int x, int y, MapCallback<Boolean> callback)
/*      */   {
/*  954 */     new MMH_IsNearByPos(roleId, mapCfgid, x, y, callback).execute();
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
/*      */   public static void isNearByPos(long roleId, int mapCfgid, int x, int y, int thresholdDistance, MapCallback<Boolean> callback)
/*      */   {
/*  976 */     new MMH_IsNearByPos(roleId, mapCfgid, x, y, thresholdDistance, callback).execute();
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
/*      */   public static void isNearByPos(Collection<Long> roleIds, int mapCfgid, int x, int y, int thresholdDistance, MapCallback<Boolean> callback)
/*      */   {
/*  998 */     new MMH_IsNearByPos(roleIds, mapCfgid, x, y, thresholdDistance, callback).execute();
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
/*      */   public static void isNearByPos(Collection<Long> roleIds, int mapCfgid, int x, int y, MapCallback<Boolean> callback)
/*      */   {
/* 1020 */     new MMH_IsNearByPos(roleIds, mapCfgid, x, y, callback).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long getRoleWorldInstanceId(long roleId)
/*      */   {
/* 1032 */     MMH_GetRoleWorldId handler = new MMH_GetRoleWorldId(roleId);
/* 1033 */     handler.call();
/* 1034 */     return handler.getWorldInstanceId();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getRoleMapId(long roleId)
/*      */   {
/* 1046 */     MMH_GetRoleMapId handler = new MMH_GetRoleMapId(roleId);
/* 1047 */     handler.call();
/* 1048 */     return handler.getMapCfgid();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isInMoveState(long roleId)
/*      */   {
/* 1060 */     MMH_IsRoleInMoveState handler = new MMH_IsRoleInMoveState(roleId);
/* 1061 */     handler.call();
/* 1062 */     return handler.isMove();
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
/*      */   public static void getRolesNearBySomebody(long roleid, int thresholdDistance, MapCallback<List<Long>> callback)
/*      */   {
/* 1078 */     new MMH_RolesNearBySomebody(roleid, thresholdDistance, callback).execute();
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
/*      */   public static void getRolesInSomebodyView(long roleid, MapCallback<Collection<Long>> callback)
/*      */   {
/* 1091 */     new MMH_GetRolesInSomebodyView(roleid, callback).execute();
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
/*      */   public static Collection<Long> getRolesInSomebodyView(long roleid)
/*      */   {
/* 1104 */     MMH_GetRolesInSomebodyView handler = new MMH_GetRolesInSomebodyView(roleid);
/* 1105 */     handler.call();
/* 1106 */     return handler.getRoleids();
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
/*      */   public static void brocadCastInSomebodyView(long roleid, Protocol protocol, boolean isSendAtOnce)
/*      */   {
/* 1120 */     Collection<Long> roleList = getRolesInSomebodyView(roleid);
/* 1121 */     if ((roleList == null) || (roleList.isEmpty()))
/*      */     {
/* 1123 */       return;
/*      */     }
/*      */     
/* 1126 */     if (isSendAtOnce)
/*      */     {
/* 1128 */       OnlineManager.getInstance().sendMultiAtOnce(protocol, roleList);
/*      */     }
/*      */     else
/*      */     {
/* 1132 */       OnlineManager.getInstance().sendMulti(protocol, roleList);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<Long> getRoleList(long worldId)
/*      */   {
/* 1144 */     MMH_GetRoleList handler = new MMH_GetRoleList(worldId);
/* 1145 */     handler.call();
/* 1146 */     return handler.getRoleList();
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
/*      */   public static List<Long> getRoleList(long worldId, int mapCfgId)
/*      */   {
/* 1160 */     MMH_GetRoleList handler = new MMH_GetRoleList(worldId, mapCfgId);
/* 1161 */     handler.call();
/* 1162 */     return handler.getRoleList();
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
/*      */   public static void brocadCastInWorld(long worldId, Protocol protocol, boolean isSendAtOnce)
/*      */   {
/* 1176 */     List<Long> roleList = getRoleList(worldId);
/* 1177 */     if (roleList.isEmpty())
/*      */     {
/* 1179 */       return;
/*      */     }
/*      */     
/* 1182 */     if (isSendAtOnce)
/*      */     {
/* 1184 */       OnlineManager.getInstance().sendMultiAtOnce(protocol, roleList);
/*      */     }
/*      */     else
/*      */     {
/* 1188 */       OnlineManager.getInstance().sendMulti(protocol, roleList);
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
/*      */   public static void brocadCastInWorldMap(long worldId, int mapCfgId, Protocol protocol, boolean isSendAtOnce)
/*      */   {
/* 1204 */     List<Long> roleList = getRoleList(worldId, mapCfgId);
/* 1205 */     if (roleList.isEmpty())
/*      */     {
/* 1207 */       return;
/*      */     }
/*      */     
/* 1210 */     if (isSendAtOnce)
/*      */     {
/* 1212 */       OnlineManager.getInstance().sendMultiAtOnce(protocol, roleList);
/*      */     }
/*      */     else
/*      */     {
/* 1216 */       OnlineManager.getInstance().sendMulti(protocol, roleList);
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
/*      */   public static void setNormalHuSongState(long roleId, int targetNpcCfgid, int followMonsterCfgid)
/*      */   {
/* 1229 */     new MMH_SetHuSong(roleId, targetNpcCfgid, followMonsterCfgid).execute();
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
/*      */   public static void setSpecialHuSongState(long roleId, int targetNpcCfgid, int coupleNpcCfgid, int gender)
/*      */   {
/* 1243 */     new MMH_SetHuSong(roleId, targetNpcCfgid, coupleNpcCfgid, gender).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isWorldMap(int mapCfgId)
/*      */   {
/* 1254 */     MapPrototype cfg = MapCfgManager.getInstance().getMapProtoById(mapCfgId);
/* 1255 */     if (cfg == null)
/*      */     {
/* 1257 */       return false;
/*      */     }
/* 1259 */     return cfg.isWorldMap();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isFuBenMap(int mapCfgId)
/*      */   {
/* 1271 */     MapPrototype cfg = MapCfgManager.getInstance().getMapProtoById(mapCfgId);
/* 1272 */     if (cfg == null)
/*      */     {
/* 1274 */       return false;
/*      */     }
/*      */     
/* 1277 */     return !cfg.isWorldMap();
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
/*      */   public static void setWorldApp(long roleId, int colorId, String appText)
/*      */   {
/* 1292 */     new MMH_SetWorldAppMsgHandler(roleId, colorId, appText).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setMonsterStarLevel(int monsterCfgid, List<StarLevelWrapper> starLevelWrappers)
/*      */   {
/* 1303 */     new MMH_SetMapMonsterStarLevelData(monsterCfgid, starLevelWrappers).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void onRoleColorChange(long roleId, int hairId, int clothId)
/*      */   {
/* 1311 */     new MMH_OnRoleColorChange(roleId, hairId, clothId).execute();
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
/*      */   public static boolean isReachable(int mapCfgId, int x, int y)
/*      */   {
/* 1324 */     MapPrototype cfg = MapCfgManager.getInstance().getMapProtoById(mapCfgId);
/* 1325 */     if (cfg == null)
/*      */     {
/* 1327 */       return false;
/*      */     }
/*      */     
/* 1330 */     SMapConfig mapConfig = cfg.getMapConfig();
/* 1331 */     if (mapConfig == null)
/*      */     {
/* 1333 */       return false;
/*      */     }
/*      */     
/* 1336 */     Cell cell = MapPrototype.getCellPrototype(mapConfig, x / mapConfig.cellWidth, y / mapConfig.cellHeight);
/* 1337 */     if (cell == null)
/*      */     {
/* 1339 */       return false;
/*      */     }
/*      */     
/* 1342 */     return cell.isReachable();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean hasRole(long worldid)
/*      */   {
/* 1354 */     MMH_WorldHasRole handler = new MMH_WorldHasRole(worldid);
/* 1355 */     handler.call();
/* 1356 */     return handler.getResult();
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
/*      */   public static boolean isWorldExist(long worldid)
/*      */   {
/* 1369 */     MMH_IsWorldExist handler = new MMH_IsWorldExist(worldid);
/* 1370 */     handler.call();
/* 1371 */     return handler.getResult();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void isWorldExist(long worldid, MapCallback<Boolean> callback)
/*      */   {
/* 1383 */     new MMH_IsWorldExist(worldid, callback).execute();
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
/*      */   public static int getSceneInstanceId(long worldId, int mapCfgId, boolean createIfNoExist)
/*      */   {
/* 1397 */     MMH_GetSceneInstanceId handler = new MMH_GetSceneInstanceId(worldId, mapCfgId, createIfNoExist);
/* 1398 */     handler.call();
/* 1399 */     return handler.getSceneInstanceId();
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
/*      */   public static void setSceneProperties(long worldid, int mapCfgid, Map<ScenePropertyKey, Integer> properties, MapCallback<Boolean> callback)
/*      */   {
/* 1413 */     new MMH_SetSceneProperty(worldid, mapCfgid, properties, callback).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<List<Long>> getSingleRoleAndTeam(long worldId)
/*      */   {
/* 1425 */     MMH_GetSingleRoleAndTeamInWorld handler = new MMH_GetSingleRoleAndTeamInWorld(worldId);
/* 1426 */     handler.call();
/* 1427 */     return handler.getSingleRoleAndTeamWorld();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<Long> getAllTeamInWorld(long worldId)
/*      */   {
/* 1438 */     MMH_GetAllTeamInWorld handler = new MMH_GetAllTeamInWorld(worldId);
/* 1439 */     handler.call();
/* 1440 */     return handler.getAllTeamIdList();
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
/*      */   public static List<Long> getAllTeamInWorld(long worldId, int mapCfgId)
/*      */   {
/* 1454 */     MMH_GetAllTeamInWorld handler = new MMH_GetAllTeamInWorld(worldId, mapCfgId);
/* 1455 */     handler.call();
/* 1456 */     return handler.getAllTeamIdList();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<Long> getAllSingleRoleInWorld(long worldId)
/*      */   {
/* 1467 */     MMH_GetAllSingleRoleInWorld handler = new MMH_GetAllSingleRoleInWorld(worldId);
/* 1468 */     handler.call();
/* 1469 */     return handler.getAllSingleRoleList();
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
/*      */   public static List<Long> getAllSingleRoleInWorld(long worldId, int mapCfgId)
/*      */   {
/* 1483 */     MMH_GetAllSingleRoleInWorld handler = new MMH_GetAllSingleRoleInWorld(worldId, mapCfgId);
/* 1484 */     handler.call();
/* 1485 */     return handler.getAllSingleRoleList();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<Long> getAllSingleRoleAndTeamLeaderInWorld(long worldId)
/*      */   {
/* 1496 */     MMH_GetAllSingleRoleAndTeamLeaderInWorld handler = new MMH_GetAllSingleRoleAndTeamLeaderInWorld(worldId);
/* 1497 */     handler.call();
/* 1498 */     return handler.getAllSingleRoleAndTeamLeader();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<Long> getAllSingleRoleAndTeamLeaderInWorld(long worldId, int mapCfgId)
/*      */   {
/* 1510 */     MMH_GetAllSingleRoleAndTeamLeaderInWorld handler = new MMH_GetAllSingleRoleAndTeamLeaderInWorld(worldId, mapCfgId);
/* 1511 */     handler.call();
/* 1512 */     return handler.getAllSingleRoleAndTeamLeader();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getRoleNumInWorld(long worldId)
/*      */   {
/* 1523 */     MMH_GetRoleNumInWorld handler = new MMH_GetRoleNumInWorld(worldId);
/* 1524 */     handler.call();
/* 1525 */     return handler.getRoleNum();
/*      */   }
/*      */   
/*      */   public static int getMonsterNumInWorld(long worldId)
/*      */   {
/* 1530 */     MMH_GetMonsterNumInWorld handler = new MMH_GetMonsterNumInWorld(worldId);
/* 1531 */     handler.call();
/* 1532 */     return handler.getMonsterNum();
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
/*      */   public static void registerMonsterFightHandler(long worldId, IMonsterFightHandler handler)
/*      */   {
/* 1547 */     new MMH_OpMonsterFightHandler(worldId, handler, true).execute();
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
/*      */   public static void unregisterMonsterFightHandler(long worldId, IMonsterFightHandler handler)
/*      */   {
/* 1560 */     new MMH_OpMonsterFightHandler(worldId, handler, false).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setModelProtocol(long roleId, Protocol protocol)
/*      */   {
/* 1571 */     OctetsStream os = new OctetsStream();
/* 1572 */     os.marshal(protocol);
/* 1573 */     new MMH_PlayerSetOtherOctetInfo(roleId, protocol.getType(), os).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void unSetModelProtocol(long roleId, int protocolType)
/*      */   {
/* 1583 */     new MMH_PlayerSetOtherOctetInfo(roleId, protocolType, null).execute();
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
/*      */   public static void transferAllRole(List<Long> roleList, long worldId, int mapId)
/*      */   {
/* 1598 */     for (Long roleId : roleList)
/*      */     {
/* 1600 */       new MMH_TeleportOrCreateScene(roleId.longValue(), worldId, mapId, -1, -1, -1, -1, TransferType.TRANSPOS).execute();
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
/*      */   public static void transferAllRole(List<Long> roleList, long worldId, int mapId, int x, int y)
/*      */   {
/* 1620 */     for (Long roleId : roleList)
/*      */     {
/* 1622 */       new MMH_TeleportOrCreateScene(roleId.longValue(), worldId, mapId, x, y, x, y, TransferType.TRANSPOS).execute();
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
/*      */   public static void transferAllRole(List<Long> roleList, long worldId, int mapId, int x, int y, TransferType transferType)
/*      */   {
/* 1645 */     for (Long roleId : roleList)
/*      */     {
/* 1647 */       new MMH_TeleportOrCreateScene(roleId.longValue(), worldId, mapId, x, y, x, y, transferType).execute();
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
/*      */   public static void forceTransferAllRole(List<Long> roleList, long worldId, int mapId)
/*      */   {
/* 1663 */     for (Long roleId : roleList)
/*      */     {
/* 1665 */       new MMH_TeleportOrCreateScene(roleId.longValue(), worldId, mapId, -1, -1, -1, -1, TransferType.FORCE_TRANSFER).execute();
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
/*      */   public static void forceTransferAllRole(List<Long> roleList, long worldId, int mapId, int x, int y)
/*      */   {
/* 1686 */     for (Long roleId : roleList)
/*      */     {
/* 1688 */       new MMH_TeleportOrCreateScene(roleId.longValue(), worldId, mapId, x, y, x, y, TransferType.FORCE_TRANSFER).execute();
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
/*      */   public static void teleportToMonster(long roleId, long worldId, int mapId, int visibleMonsterCfgId)
/*      */   {
/* 1707 */     new MMH_TeleportTargetMonster(roleId, mapId, worldId, visibleMonsterCfgId).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void dragAllRoleToTargetWorld(long srcWorldId, long targetWorldId, int targetMapId)
/*      */   {
/* 1719 */     List<Long> allRoleList = getAllSingleRoleAndTeamLeaderInWorld(srcWorldId);
/* 1720 */     for (Long roleId : allRoleList)
/*      */     {
/* 1722 */       transferToScene(roleId.longValue(), targetWorldId, targetMapId);
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
/*      */   public static void dragAllRoleToTargetWorld(long srcWorldId, long targetWorldId, int targetMapId, int x, int y)
/*      */   {
/* 1742 */     List<Long> allRoleList = getAllSingleRoleAndTeamLeaderInWorld(srcWorldId);
/* 1743 */     for (Long roleId : allRoleList)
/*      */     {
/* 1745 */       transferToScene(roleId.longValue(), targetWorldId, targetMapId, x, y);
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
/*      */   public static void dragAllRoleTo(long worldId, int targetSceneId, int x, int y)
/*      */   {
/* 1759 */     List<Long> roleList = getAllSingleRoleAndTeamLeaderInWorld(worldId);
/* 1760 */     for (Long roleId : roleList)
/*      */     {
/* 1762 */       transferToScene(roleId.longValue(), targetSceneId, x, y);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void dragAllRoleTo(long worldId, int targetSceneId)
/*      */   {
/* 1774 */     List<Long> roleList = getAllSingleRoleAndTeamLeaderInWorld(worldId);
/* 1775 */     for (Long roleId : roleList)
/*      */     {
/* 1777 */       transferToScene(roleId.longValue(), targetSceneId);
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
/*      */   public static void transferToScene(long roleId, long worldId, int targetMapId, int x, int y)
/*      */   {
/* 1796 */     new MMH_TeleportOrCreateScene(roleId, worldId, targetMapId, x, y, x, y, TransferType.TRANSPOS).execute();
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
/*      */   public static void transferToScene(long roleId, long worldId, int targetMapId, int x, int y, int channelid)
/*      */   {
/* 1816 */     new MMH_TeleportOrCreateScene(roleId, worldId, targetMapId, x, y, x, y, channelid, TransferType.TRANSPOS).execute();
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
/*      */   public static void transferToScene(long roleId, long worldId, int targetMapId, int x, int y, MapCallback<Boolean> callback)
/*      */   {
/* 1836 */     new MMH_TeleportOrCreateScene(roleId, worldId, targetMapId, x, y, x, y, TransferType.TRANSPOS, callback).execute();
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
/*      */   public static void transferToScene(long roleId, long worldId, int targetMapId, int x, int y, int channelid, MapCallback<Boolean> callback)
/*      */   {
/* 1857 */     new MMH_TeleportOrCreateScene(roleId, worldId, targetMapId, x, y, x, y, channelid, TransferType.TRANSPOS, callback).execute();
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
/*      */   public static void transferToScene(long roleId, long worldId, int targetMapId, int x, int y, TransferType transferType, MapCallback<Boolean> callback)
/*      */   {
/* 1878 */     new MMH_TeleportOrCreateScene(roleId, worldId, targetMapId, x, y, x, y, transferType, callback).execute();
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
/*      */   public static void transferToScene(long roleId, long worldId, int targetMapId, int x, int y, int channelid, TransferType transferType, MapCallback<Boolean> callback)
/*      */   {
/* 1900 */     new MMH_TeleportOrCreateScene(roleId, worldId, targetMapId, x, y, x, y, channelid, transferType, callback).execute();
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
/*      */   public static void transferToScene(long roleId, long worldId, int targetMapId)
/*      */   {
/* 1916 */     new MMH_TeleportOrCreateScene(roleId, worldId, targetMapId, -1, -1, -1, -1, TransferType.TRANSPOS).execute();
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
/*      */   public static void transferToScene(long roleId, long worldId, int targetMapId, MapCallback<Boolean> callback)
/*      */   {
/* 1934 */     new MMH_TeleportOrCreateScene(roleId, worldId, targetMapId, -1, -1, -1, -1, TransferType.TRANSPOS, callback).execute();
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
/*      */   public static void forceTransferToScene(long roleId, long worldId, int targetMapId, int x, int y)
/*      */   {
/* 1953 */     new MMH_TeleportOrCreateScene(roleId, worldId, targetMapId, x, y, x, y, TransferType.FORCE_TRANSFER).execute();
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
/*      */   public static void forceTransferToScene(long roleId, long worldId, int targetMapId, int x, int y, int channelid)
/*      */   {
/* 1973 */     new MMH_TeleportOrCreateScene(roleId, worldId, targetMapId, x, y, x, y, channelid, TransferType.FORCE_TRANSFER).execute();
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
/*      */   public static void forceTransferToScene(long roleId, long worldId, int targetMapId, int x, int y, MapCallback<Boolean> callback)
/*      */   {
/* 1993 */     new MMH_TeleportOrCreateScene(roleId, worldId, targetMapId, x, y, x, y, TransferType.FORCE_TRANSFER, callback).execute();
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
/*      */   public static void forceTransferToScene(long roleId, long worldId, int targetMapId, int x, int y, int channelid, MapCallback<Boolean> callback)
/*      */   {
/* 2014 */     new MMH_TeleportOrCreateScene(roleId, worldId, targetMapId, x, y, x, y, channelid, TransferType.FORCE_TRANSFER, callback).execute();
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
/*      */   public static void forceTransferToScene(long roleId, long worldId, int targetMapId)
/*      */   {
/* 2031 */     new MMH_TeleportOrCreateScene(roleId, worldId, targetMapId, -1, -1, -1, -1, TransferType.FORCE_TRANSFER).execute();
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
/*      */   public static void forceTransferToScene(long roleId, long worldId, int targetMapId, MapCallback<Boolean> callback)
/*      */   {
/* 2049 */     new MMH_TeleportOrCreateScene(roleId, worldId, targetMapId, -1, -1, -1, -1, TransferType.FORCE_TRANSFER, callback).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void transferToScene(long roleId, int targetSceneId)
/*      */   {
/* 2061 */     new MMH_PlayerTransferToScene(roleId, targetSceneId).execute();
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
/*      */   public static void transferToScene(long roleId, int targetSceneId, MapCallback<Boolean> callback)
/*      */   {
/* 2074 */     new MMH_PlayerTransferToScene(roleId, targetSceneId, callback).execute();
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
/*      */   public static void transferToScene(long roleId, int targetSceneId, int x, int y)
/*      */   {
/* 2088 */     new MMH_PlayerTransferToScene(roleId, targetSceneId, x, y, TransferType.TRANSPOS).execute();
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
/*      */   public static void transferToScene(long roleId, int targetSceneId, int x, int y, MapCallback<Boolean> callback)
/*      */   {
/* 2104 */     new MMH_PlayerTransferToScene(roleId, targetSceneId, x, y, TransferType.TRANSPOS, callback).execute();
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
/*      */   public static void transferToScene(long roleId, int targetSceneId, int x, int y, int channelid, MapCallback<Boolean> callback)
/*      */   {
/* 2121 */     new MMH_PlayerTransferToScene(roleId, targetSceneId, x, y, x, y, channelid, TransferType.TRANSPOS, callback).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void forceTransferToScene(long roleId, int targetSceneId)
/*      */   {
/* 2133 */     new MMH_PlayerTransferToScene(roleId, targetSceneId, TransferType.FORCE_TRANSFER).execute();
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
/*      */   public static void forceTransferToScene(long roleId, int targetSceneId, MapCallback<Boolean> callback)
/*      */   {
/* 2146 */     new MMH_PlayerTransferToScene(roleId, targetSceneId, TransferType.FORCE_TRANSFER, callback).execute();
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
/*      */   public static void forceTransferToScene(long roleId, int targetSceneId, int x, int y)
/*      */   {
/* 2165 */     new MMH_PlayerTransferToScene(roleId, targetSceneId, x, y, TransferType.FORCE_TRANSFER).execute();
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
/*      */   public static void forceTransferToScene(long roleId, int targetSceneId, int x, int y, MapCallback<Boolean> callback)
/*      */   {
/* 2184 */     new MMH_PlayerTransferToScene(roleId, targetSceneId, x, y, TransferType.FORCE_TRANSFER, callback).execute();
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
/*      */   public static void forceTransferToScene(long roleId, int targetSceneId, int x, int y, int channelid, MapCallback<Boolean> callback)
/*      */   {
/* 2204 */     new MMH_PlayerTransferToScene(roleId, targetSceneId, x, y, x, y, channelid, TransferType.FORCE_TRANSFER, callback).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void forceTransferWhenFault(long roleid)
/*      */   {
/* 2214 */     new MMH_ForceTransferWhenFault(roleid).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void forceTransferWhenFault(long roleid, MapCallback<Boolean> callback)
/*      */   {
/* 2225 */     new MMH_ForceTransferWhenFault(roleid, callback).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long getCenterWorldid()
/*      */   {
/* 2235 */     return WorldManager.getInstance().getBigWorldInstance().getId();
/*      */   }
/*      */   
/*      */   public static long getBigWorldid()
/*      */   {
/* 2240 */     return WorldManager.getInstance().getBigWorldInstance().getId();
/*      */   }
/*      */   
/*      */   public static void asyncBroadcastInSight(long roleid, Protocol p, boolean includeSelf)
/*      */   {
/* 2245 */     new MMH_BroadcastInSight(roleid, p, includeSelf).execute();
/*      */   }
/*      */   
/*      */   public static int getMapMsgQueueSize()
/*      */   {
/* 2250 */     return MapMessageQueue.getInstance().getMapMsgQueueSize();
/*      */   }
/*      */   
/*      */   public static int getMapProtocolSendQueueSize()
/*      */   {
/* 2255 */     return MapProtocolSendQueue.getInstance().getQueueMutableSize();
/*      */   }
/*      */   
/*      */   public static boolean canFly(int mapcfgid)
/*      */   {
/* 2260 */     MapPrototype mapCfg = MapCfgManager.getInstance().getMapProtoById(mapcfgid);
/* 2261 */     if (mapCfg == null)
/*      */     {
/* 2263 */       return false;
/*      */     }
/* 2265 */     return mapCfg.canFly();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isXunLuo(long roleid)
/*      */   {
/* 2277 */     MMH_IsXunLuo handler = new MMH_IsXunLuo(roleid);
/* 2278 */     handler.call();
/* 2279 */     return handler.isXunLuo();
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
/*      */   public static void roleMove(long roleId, List<Location> keyPathList)
/*      */   {
/* 2292 */     new MMH_PlayerMove(roleId, keyPathList).execute();
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
/*      */   public static void groupMove(MapGroupType groupType, long groupid, List<Location> keyPathList)
/*      */   {
/* 2307 */     new MMH_GroupMove(groupType, groupid, keyPathList).execute();
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
/*      */   public static void addMapGroup(MapGroupType groupType, long groupid, List<Long> roleids, int flySpeed)
/*      */   {
/* 2325 */     addMapGroup(groupType, groupid, roleids, flySpeed, null);
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
/*      */   public static void addMapGroup(MapGroupType groupType, long groupid, List<Long> roleids, int groupSpeed, Map<Integer, Integer> groupExtraInfos)
/*      */   {
/* 2345 */     new MMH_CreateMapGroup(groupType, groupid, roleids, groupSpeed, groupExtraInfos).execute();
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
/*      */   public static void removeMapGroup(MapGroupType groupType, long groupid, List<Long> roles)
/*      */   {
/* 2358 */     new PRemoveMapGroup(groupType, groupid, roles).execute();
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
/*      */   public static void removeMapGroup(MapGroupType groupType, long groupid, Map<Long, Integer> nowFlyings, Set<Long> offlines)
/*      */   {
/* 2376 */     new MMH_RemoveMapGroup(groupType, groupid, nowFlyings, offlines).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void removeMapGroupByRoleid(long roleid)
/*      */   {
/* 2386 */     new MMH_RemoveMapGroupByRoleid(roleid).execute();
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
/*      */   public static void changeMapGroupExtraInfos(MapGroupType groupType, long groupid, Map<Integer, Integer> replaceExtraInfoEntries, Set<Integer> removeExtraInfoKeys)
/*      */   {
/* 2406 */     Set<Integer> allKeys = new HashSet();
/* 2407 */     Iterator i$; if ((replaceExtraInfoEntries != null) && (!replaceExtraInfoEntries.isEmpty()))
/*      */     {
/* 2409 */       Set<Integer> keys = replaceExtraInfoEntries.keySet();
/* 2410 */       for (i$ = keys.iterator(); i$.hasNext();) { int key = ((Integer)i$.next()).intValue();
/*      */         
/* 2412 */         allKeys.add(Integer.valueOf(key));
/*      */       } }
/*      */     Iterator i$;
/* 2415 */     if ((removeExtraInfoKeys != null) && (!removeExtraInfoKeys.isEmpty()))
/*      */     {
/* 2417 */       for (i$ = removeExtraInfoKeys.iterator(); i$.hasNext();) { int key = ((Integer)i$.next()).intValue();
/*      */         
/* 2419 */         if (!allKeys.add(Integer.valueOf(key)))
/*      */         {
/* 2421 */           return;
/*      */         }
/*      */       }
/*      */     }
/* 2425 */     if (allKeys.isEmpty())
/*      */     {
/* 2427 */       return;
/*      */     }
/*      */     
/* 2430 */     new MMH_ChangeMapGroupExtraInfos(groupType, groupid, replaceExtraInfoEntries, removeExtraInfoKeys).execute();
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
/*      */   public static void addMapEntity(MapEntityType entityType, long entityInstanceid, long worldid, int mapCfgid, Map<Integer, Integer> intExtraInfoEntries, Map<Integer, Long> longExtraInfoEntries, Map<Integer, String> stringExtraInfoEntries, MapCallback<Boolean> callback)
/*      */   {
/* 2457 */     addMapEntity(entityType, entityInstanceid, worldid, mapCfgid, -1, -1, -1, intExtraInfoEntries, longExtraInfoEntries, stringExtraInfoEntries, callback);
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
/*      */   public static void addMapEntity(MapEntityType entityType, long entityInstanceid, long worldid, int mapCfgid, int cfgid, Map<Integer, Integer> intExtraInfoEntries, Map<Integer, Long> longExtraInfoEntries, Map<Integer, String> stringExtraInfoEntries, MapCallback<Boolean> callback)
/*      */   {
/* 2488 */     addMapEntity(entityType, entityInstanceid, worldid, mapCfgid, -1, -1, cfgid, intExtraInfoEntries, longExtraInfoEntries, stringExtraInfoEntries, false, callback);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void addMapEntity(MapEntityType entityType, long entityInstanceid, long worldid, int mapCfgid, int x, int y, int cfgid, Map<Integer, Integer> intExtraInfoEntries, Map<Integer, Long> longExtraInfoEntries, Map<Integer, String> stringExtraInfoEntries, MapCallback<Boolean> callback)
/*      */   {
/* 2523 */     addMapEntity(entityType, entityInstanceid, worldid, mapCfgid, x, y, cfgid, intExtraInfoEntries, longExtraInfoEntries, stringExtraInfoEntries, false, callback);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void addMapEntity(MapEntityType entityType, long entityInstanceid, long worldid, int mapCfgid, int x, int y, int cfgid, Map<Integer, Integer> intExtraInfoEntries, Map<Integer, Long> longExtraInfoEntries, Map<Integer, String> stringExtraInfoEntries, boolean needCheck, MapCallback<Boolean> callback)
/*      */   {
/* 2561 */     Set<Integer> allKeys = new HashSet();
/* 2562 */     Iterator i$; if ((intExtraInfoEntries != null) && (!intExtraInfoEntries.isEmpty()))
/*      */     {
/* 2564 */       Set<Integer> keys = intExtraInfoEntries.keySet();
/* 2565 */       for (i$ = keys.iterator(); i$.hasNext();) { int key = ((Integer)i$.next()).intValue();
/*      */         
/* 2567 */         allKeys.add(Integer.valueOf(key));
/*      */       } }
/*      */     Iterator i$;
/* 2570 */     if ((longExtraInfoEntries != null) && (!longExtraInfoEntries.isEmpty()))
/*      */     {
/* 2572 */       Set<Integer> keys = longExtraInfoEntries.keySet();
/* 2573 */       for (i$ = keys.iterator(); i$.hasNext();) { int key = ((Integer)i$.next()).intValue();
/*      */         
/* 2575 */         if (!allKeys.add(Integer.valueOf(key))) {
/*      */           return;
/*      */         }
/*      */       }
/*      */     }
/*      */     Iterator i$;
/* 2581 */     if ((stringExtraInfoEntries != null) && (!stringExtraInfoEntries.isEmpty()))
/*      */     {
/* 2583 */       Set<Integer> keys = stringExtraInfoEntries.keySet();
/* 2584 */       for (i$ = keys.iterator(); i$.hasNext();) { int key = ((Integer)i$.next()).intValue();
/*      */         
/* 2586 */         if (!allKeys.add(Integer.valueOf(key)))
/*      */         {
/* 2588 */           return;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 2593 */     new MMH_AddMapEntity(entityType, entityInstanceid, worldid, mapCfgid, x, y, cfgid, intExtraInfoEntries, longExtraInfoEntries, stringExtraInfoEntries, needCheck, callback).execute();
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
/*      */   public static void removeMapEntity(MapEntityType entityType, long entityInstanceid, MapCallback<Boolean> callback)
/*      */   {
/* 2609 */     new MMH_RemoveMapEntity(entityType, entityInstanceid, callback).execute();
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
/*      */   public static void changeMapEntityInfos(MapEntityType entityType, long entityInstanceid, int cfgid, Map<Integer, Integer> replaceIntExtraInfoEntries, Map<Integer, Long> replaceLongExtraInfoEntries, Map<Integer, String> replaceStringExtraInfoEntries, Set<Integer> removeExtraInfoKeys, MapCallback<Boolean> callback)
/*      */   {
/* 2637 */     changeMapEntityInfos(entityType, entityInstanceid, cfgid, -1, -1, replaceIntExtraInfoEntries, replaceLongExtraInfoEntries, replaceStringExtraInfoEntries, removeExtraInfoKeys, callback);
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
/*      */   public static void changeMapEntityInfos(MapEntityType entityType, long entityInstanceid, int x, int y, Map<Integer, Integer> replaceIntExtraInfoEntries, Map<Integer, Long> replaceLongExtraInfoEntries, Map<Integer, String> replaceStringExtraInfoEntries, Set<Integer> removeExtraInfoKeys, MapCallback<Boolean> callback)
/*      */   {
/* 2668 */     changeMapEntityInfos(entityType, entityInstanceid, -1, x, y, replaceIntExtraInfoEntries, replaceLongExtraInfoEntries, replaceStringExtraInfoEntries, removeExtraInfoKeys, callback);
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
/*      */ 
/*      */ 
/*      */   public static void changeMapEntityInfos(MapEntityType entityType, long entityInstanceid, int cfgid, int x, int y, Map<Integer, Integer> replaceIntExtraInfoEntries, Map<Integer, Long> replaceLongExtraInfoEntries, Map<Integer, String> replaceStringExtraInfoEntries, Set<Integer> removeExtraInfoKeys, MapCallback<Boolean> callback)
/*      */   {
/* 2702 */     Set<Integer> allKeys = new HashSet();
/* 2703 */     Iterator i$; if ((replaceIntExtraInfoEntries != null) && (!replaceIntExtraInfoEntries.isEmpty()))
/*      */     {
/* 2705 */       Set<Integer> keys = replaceIntExtraInfoEntries.keySet();
/* 2706 */       for (i$ = keys.iterator(); i$.hasNext();) { int key = ((Integer)i$.next()).intValue();
/*      */         
/* 2708 */         allKeys.add(Integer.valueOf(key));
/*      */       } }
/*      */     Iterator i$;
/* 2711 */     if ((replaceLongExtraInfoEntries != null) && (!replaceLongExtraInfoEntries.isEmpty()))
/*      */     {
/* 2713 */       Set<Integer> keys = replaceLongExtraInfoEntries.keySet();
/* 2714 */       for (i$ = keys.iterator(); i$.hasNext();) { int key = ((Integer)i$.next()).intValue();
/*      */         
/* 2716 */         if (!allKeys.add(Integer.valueOf(key))) {
/*      */           return;
/*      */         }
/*      */       }
/*      */     }
/*      */     Iterator i$;
/* 2722 */     if ((replaceStringExtraInfoEntries != null) && (!replaceStringExtraInfoEntries.isEmpty()))
/*      */     {
/* 2724 */       Set<Integer> keys = replaceStringExtraInfoEntries.keySet();
/* 2725 */       for (i$ = keys.iterator(); i$.hasNext();) { int key = ((Integer)i$.next()).intValue();
/*      */         
/* 2727 */         if (!allKeys.add(Integer.valueOf(key))) {
/*      */           return;
/*      */         }
/*      */       }
/*      */     }
/*      */     Iterator i$;
/* 2733 */     if ((removeExtraInfoKeys != null) && (!removeExtraInfoKeys.isEmpty()))
/*      */     {
/* 2735 */       for (i$ = removeExtraInfoKeys.iterator(); i$.hasNext();) { int key = ((Integer)i$.next()).intValue();
/*      */         
/* 2737 */         if (!allKeys.add(Integer.valueOf(key)))
/*      */         {
/* 2739 */           return;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 2744 */     new MMH_ChangeMapEntityInfos(entityType, entityInstanceid, x, y, cfgid, replaceIntExtraInfoEntries, replaceLongExtraInfoEntries, replaceStringExtraInfoEntries, removeExtraInfoKeys, callback).execute();
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
/*      */   public static void changeMapEntityExtraInfos(MapEntityType entityType, long entityInstanceid, Map<Integer, Integer> replaceIntExtraInfoEntries, Map<Integer, Long> replaceLongExtraInfoEntries, Map<Integer, String> replaceStringExtraInfoEntries, Set<Integer> removeExtraInfoKeys, MapCallback<Boolean> callback)
/*      */   {
/* 2773 */     Set<Integer> allKeys = new HashSet();
/* 2774 */     Iterator i$; if ((replaceIntExtraInfoEntries != null) && (!replaceIntExtraInfoEntries.isEmpty()))
/*      */     {
/* 2776 */       Set<Integer> keys = replaceIntExtraInfoEntries.keySet();
/* 2777 */       for (i$ = keys.iterator(); i$.hasNext();) { int key = ((Integer)i$.next()).intValue();
/*      */         
/* 2779 */         allKeys.add(Integer.valueOf(key));
/*      */       } }
/*      */     Iterator i$;
/* 2782 */     if ((replaceLongExtraInfoEntries != null) && (!replaceLongExtraInfoEntries.isEmpty()))
/*      */     {
/* 2784 */       Set<Integer> keys = replaceLongExtraInfoEntries.keySet();
/* 2785 */       for (i$ = keys.iterator(); i$.hasNext();) { int key = ((Integer)i$.next()).intValue();
/*      */         
/* 2787 */         if (!allKeys.add(Integer.valueOf(key))) {
/*      */           return;
/*      */         }
/*      */       }
/*      */     }
/*      */     Iterator i$;
/* 2793 */     if ((replaceStringExtraInfoEntries != null) && (!replaceStringExtraInfoEntries.isEmpty()))
/*      */     {
/* 2795 */       Set<Integer> keys = replaceStringExtraInfoEntries.keySet();
/* 2796 */       for (i$ = keys.iterator(); i$.hasNext();) { int key = ((Integer)i$.next()).intValue();
/*      */         
/* 2798 */         if (!allKeys.add(Integer.valueOf(key))) {
/*      */           return;
/*      */         }
/*      */       }
/*      */     }
/*      */     Iterator i$;
/* 2804 */     if ((removeExtraInfoKeys != null) && (!removeExtraInfoKeys.isEmpty()))
/*      */     {
/* 2806 */       for (i$ = removeExtraInfoKeys.iterator(); i$.hasNext();) { int key = ((Integer)i$.next()).intValue();
/*      */         
/* 2808 */         if (!allKeys.add(Integer.valueOf(key)))
/*      */         {
/* 2810 */           return;
/*      */         }
/*      */       }
/*      */     }
/* 2814 */     if (allKeys.isEmpty())
/*      */     {
/* 2816 */       return;
/*      */     }
/*      */     
/* 2819 */     new MMH_ChangeMapEntityExtraInfos(entityType, entityInstanceid, replaceIntExtraInfoEntries, replaceLongExtraInfoEntries, replaceStringExtraInfoEntries, removeExtraInfoKeys, callback).execute();
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
/*      */   public static void mapEntityMove(MapEntityType entityType, long entityInstanceid, List<Location> keyPathList)
/*      */   {
/* 2837 */     mapEntityMove(entityType, entityInstanceid, keyPathList, 180);
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
/*      */   public static void mapEntityMove(MapEntityType entityType, long entityInstanceid, List<Location> keyPathList, int velocity)
/*      */   {
/* 2855 */     if (!entityType.canMove())
/*      */     {
/* 2857 */       return;
/*      */     }
/*      */     
/* 2860 */     new MMH_MapEntityMove(entityType, entityInstanceid, keyPathList, velocity).execute();
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
/*      */   public static <T extends Position> T getMapEntityPos(MapEntityType entityType, long entityInstanceid)
/*      */   {
/* 2873 */     MMH_GetMapEntityPos<T> mmh = new MMH_GetMapEntityPos(entityType, entityInstanceid);
/* 2874 */     mmh.call();
/* 2875 */     return mmh.getResult();
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
/*      */   public static <T extends Position> void getMapEntityPos(MapEntityType entityType, long entityInstanceid, MapCallback<T> callback)
/*      */   {
/* 2890 */     new MMH_GetMapEntityPos(entityType, entityInstanceid, callback).execute();
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
/*      */   public static List<Long> getRoleListNearbyMapEntity(MapEntityType entityType, long entityInstanceid, int radius)
/*      */   {
/* 2908 */     MMH_GetRoleListNearbyMapEntity handler = new MMH_GetRoleListNearbyMapEntity(entityType, entityInstanceid, radius);
/* 2909 */     handler.call();
/* 2910 */     return handler.getResult();
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
/*      */   public static void getRoleListNearbyMapEntity(MapEntityType entityType, long entityInstanceid, int radius, MapCallback<List<Long>> callback)
/*      */   {
/* 2929 */     new MMH_GetRoleListNearbyMapEntity(entityType, entityInstanceid, radius, callback).execute();
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
/*      */   public static final boolean regisMapItemGatherHandler(int handlerType, MapItemGatherHandler handler)
/*      */   {
/* 2944 */     return MapItemGatherHandlerManager.getInstance().regisHandler(handlerType, handler);
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
/*      */   public static final boolean unregisMapItemGatherHandler(int handlerType)
/*      */   {
/* 2957 */     return MapItemGatherHandlerManager.getInstance().unregisHandler(handlerType);
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
/*      */   public static final boolean regisTransferZoneProxyHandler(int handlerType, TransferZoneProxyHandler handler)
/*      */   {
/* 2972 */     return TransferZoneProxyHandlerManager.getInstance().regisHandler(handlerType, handler);
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
/*      */   public static final boolean unregisTransferZoneProxyHandler(int handlerType)
/*      */   {
/* 2985 */     return TransferZoneProxyHandlerManager.getInstance().unregisHandler(handlerType);
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
/*      */   public static final void observeMonsterFight(long obseverRoleid, int monsterInstanceid)
/*      */   {
/* 2998 */     new MMH_ObserveMonsterFight(obseverRoleid, monsterInstanceid).execute();
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
/*      */   public static final void onPlayExpressionItem(long roleid, int itemCfgid)
/*      */   {
/* 3011 */     new MMH_OnPlayExpressionItem(roleid, itemCfgid).execute();
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
/*      */   public static final void gatherMapItem(long roleid, int mapItemInstanceid, MapItemGatherContext context)
/*      */   {
/* 3026 */     new PMapItemGatherReq(roleid, mapItemInstanceid, context).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void send(long roleid, Protocol protocol)
/*      */   {
/* 3037 */     MapProtocolSendQueue.getInstance().send(roleid, protocol);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void sendMulti(Collection<Long> targets, Protocol protocol)
/*      */   {
/* 3048 */     MapProtocolSendQueue.getInstance().sendMulti(targets, protocol);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void sendAll(Protocol protocol)
/*      */   {
/* 3058 */     MapProtocolSendQueue.getInstance().sendAll(protocol);
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
/*      */   public static void setLimitPolygonMovementStatus(long roleid, boolean isLimit, MapCallback<Boolean> callback)
/*      */   {
/* 3071 */     new MMH_SetLimitPolygonMovementStatus(roleid, isLimit, callback).execute();
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
/*      */   public static void setBroadcastPosInSceneStatus(long roleid, boolean isBroadcast, MapCallback<Boolean> callback)
/*      */   {
/* 3084 */     new MMH_SetBroadcastPosInSceneStatus(roleid, isBroadcast, callback).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void addRoleSpeedFixAdded(long roleid, int fixAdded, MapCallback<Boolean> callback)
/*      */   {
/* 3096 */     new MMH_AddSpeedFixAdded(roleid, fixAdded, callback).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void addRoleSpeedPercentAdded(long roleid, int percentAdded, MapCallback<Boolean> callback)
/*      */   {
/* 3108 */     new MMH_AddSpeedPercentAdded(roleid, percentAdded, callback).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setXunLuoState(long roleid, boolean value)
/*      */   {
/* 3119 */     new MMH_SetXunLuoState(roleid, value).execute();
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
/*      */   public static boolean setLimitMovementStatus(long roleid, boolean value)
/*      */   {
/* 3136 */     if (value)
/*      */     {
/* 3138 */       return RoleStatusInterface.setStatus(roleid, 97, true);
/*      */     }
/*      */     
/*      */ 
/* 3142 */     return RoleStatusInterface.unsetStatus(roleid, 97);
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\MapInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */