/*     */ package mzm.gsp.map.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.map.main.scene.object.MapEntity;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import mzm.gsp.map.main.scene.object.MapItem;
/*     */ import mzm.gsp.map.main.scene.object.MapMonster;
/*     */ import mzm.gsp.map.main.scene.object.MapNPC;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import mzm.gsp.map.main.scene.object.MapTransferZoneObject;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class MapObjectInstanceManager
/*     */ {
/*  19 */   private static final Logger logger = Logger.getLogger(MapObjectInstanceManager.class);
/*     */   
/*  21 */   private static final MapObjectInstanceManager instance = new MapObjectInstanceManager();
/*     */   
/*     */   public static MapObjectInstanceManager getInstance()
/*     */   {
/*  25 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  31 */   private final Map<Long, MapRole> roleMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  36 */   private Map<Integer, MapMonster> monsterMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  41 */   private Map<Integer, MapNPC> npcMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  46 */   private Map<Integer, MapItem> itemMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  51 */   private Map<Integer, MapTransferZoneObject> transferObjectMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  56 */   private Map<Integer, Map<Long, MapEntity>> entityTypeToEntitiesMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean addMapRole(MapRole role)
/*     */   {
/*  67 */     return this.roleMap.put(Long.valueOf(role.getRoleId()), role) == null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final MapRole removeMapRole(long roleid)
/*     */   {
/*  79 */     return (MapRole)this.roleMap.remove(Long.valueOf(roleid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final MapRole getMapRole(long roleid)
/*     */   {
/*  91 */     return (MapRole)this.roleMap.get(Long.valueOf(roleid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean addMapMonster(MapMonster monster)
/*     */   {
/* 103 */     return this.monsterMap.put(Integer.valueOf(monster.getMonsterId()), monster) == null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final MapMonster removeMapMonster(int monsterInstanceId)
/*     */   {
/* 115 */     return (MapMonster)this.monsterMap.remove(Integer.valueOf(monsterInstanceId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final MapMonster getMapMonster(int monsterInstanceId)
/*     */   {
/* 127 */     return (MapMonster)this.monsterMap.get(Integer.valueOf(monsterInstanceId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean addMapNPC(MapNPC npc)
/*     */   {
/* 139 */     return this.npcMap.put(Integer.valueOf(npc.getNpcId()), npc) == null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final MapNPC removeMapNPC(int npcInstanceId)
/*     */   {
/* 151 */     return (MapNPC)this.npcMap.remove(Integer.valueOf(npcInstanceId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final MapNPC getMapNpc(int npcInstanceId)
/*     */   {
/* 163 */     return (MapNPC)this.npcMap.get(Integer.valueOf(npcInstanceId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean addMapItem(MapItem item)
/*     */   {
/* 175 */     return this.itemMap.put(Integer.valueOf(item.getItemId()), item) == null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final MapItem removeMapItem(int itemInstanceId)
/*     */   {
/* 187 */     return (MapItem)this.itemMap.remove(Integer.valueOf(itemInstanceId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final MapItem getMapItem(int itemInstanceId)
/*     */   {
/* 199 */     return (MapItem)this.itemMap.get(Integer.valueOf(itemInstanceId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean addMapTransferZoneObject(MapTransferZoneObject transferObject)
/*     */   {
/* 211 */     return this.transferObjectMap.put(Integer.valueOf(transferObject.getTransferZoneId()), transferObject) == null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final MapTransferZoneObject removeMapTransferZoneObject(int transferObjectInstanceId)
/*     */   {
/* 223 */     return (MapTransferZoneObject)this.transferObjectMap.remove(Integer.valueOf(transferObjectInstanceId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final MapTransferZoneObject getMapTransferZoneObject(int transferObjectInstanceId)
/*     */   {
/* 235 */     return (MapTransferZoneObject)this.transferObjectMap.get(Integer.valueOf(transferObjectInstanceId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean addMapEntity(MapEntity entity)
/*     */   {
/* 247 */     int entityType = entity.getEntityType().ordinal();
/* 248 */     Map<Long, MapEntity> entityMap = (Map)this.entityTypeToEntitiesMap.get(Integer.valueOf(entityType));
/* 249 */     if (entityMap == null)
/*     */     {
/* 251 */       entityMap = new HashMap();
/* 252 */       this.entityTypeToEntitiesMap.put(Integer.valueOf(entityType), entityMap);
/*     */     }
/* 254 */     return entityMap.put(entity.getInstanceid(), entity) == null;
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
/*     */   public final MapEntity removeMapEntity(int entityType, long entityInstanceId)
/*     */   {
/* 268 */     Map<Long, MapEntity> entityMap = (Map)this.entityTypeToEntitiesMap.get(Integer.valueOf(entityType));
/* 269 */     if (entityMap == null)
/*     */     {
/* 271 */       return null;
/*     */     }
/* 273 */     return (MapEntity)entityMap.remove(Long.valueOf(entityInstanceId));
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
/*     */   public final MapEntity getMapEntity(int entityType, long entityInstanceId)
/*     */   {
/* 287 */     Map<Long, MapEntity> entityMap = (Map)this.entityTypeToEntitiesMap.get(Integer.valueOf(entityType));
/* 288 */     if (entityMap == null)
/*     */     {
/* 290 */       return null;
/*     */     }
/*     */     
/* 293 */     return (MapEntity)entityMap.get(Long.valueOf(entityInstanceId));
/*     */   }
/*     */   
/*     */   public List<MapMonster> getMonsterListByCfgId(int cfgId)
/*     */   {
/* 298 */     List<MapMonster> monsters = new ArrayList();
/* 299 */     for (MapMonster m : this.monsterMap.values())
/*     */     {
/* 301 */       if (m.getCfgId().intValue() == cfgId)
/*     */       {
/* 303 */         monsters.add(m);
/*     */       }
/*     */     }
/* 306 */     return monsters;
/*     */   }
/*     */   
/*     */   public MapNPC getNPCByCfgId(int id)
/*     */   {
/* 311 */     for (MapNPC npc : this.npcMap.values())
/*     */     {
/* 313 */       if (npc.getCfgId().intValue() == id)
/*     */       {
/* 315 */         return npc;
/*     */       }
/*     */     }
/* 318 */     return null;
/*     */   }
/*     */   
/*     */   public void update(long time)
/*     */   {
/*     */     try
/*     */     {
/* 325 */       for (MapNPC npc : this.npcMap.values())
/*     */       {
/*     */         try
/*     */         {
/* 329 */           npc.update(time);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/* 333 */           logger.error("npc帧更新出错!" + npc, e);
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 339 */       logger.error("npc帧更新出错!", e);
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 344 */       for (MapMonster monster : this.monsterMap.values())
/*     */       {
/*     */         try
/*     */         {
/* 348 */           monster.update(time);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/* 352 */           logger.error("monster帧更新出错!" + monster, e);
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 358 */       logger.error("monster帧更新出错!", e);
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 363 */       for (MapItem item : this.itemMap.values())
/*     */       {
/*     */         try
/*     */         {
/* 367 */           item.update(time);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/* 371 */           logger.error("item帧更新出错!" + item, e);
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 377 */       logger.error("item帧更新出错!", e);
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 382 */       for (MapRole role : this.roleMap.values())
/*     */       {
/*     */         try
/*     */         {
/* 386 */           role.update(time);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/* 390 */           logger.error("role帧更新出错！" + role, e);
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 396 */       logger.error("role帧更新出错！", e);
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 401 */       for (Map<Long, MapEntity> entityMap : this.entityTypeToEntitiesMap.values())
/*     */       {
/* 403 */         for (MapEntity entity : entityMap.values())
/*     */         {
/*     */           try
/*     */           {
/* 407 */             entity.update(time);
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 411 */             logger.error("map entity帧更新出错!" + entity, e);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 418 */       logger.error("map entity帧更新出错!", e);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\MapObjectInstanceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */