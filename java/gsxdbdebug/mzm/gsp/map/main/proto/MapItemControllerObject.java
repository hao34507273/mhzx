/*     */ package mzm.gsp.map.main.proto;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.map.confbean.Loc;
/*     */ import mzm.gsp.map.confbean.SMapItemCfg;
/*     */ import mzm.gsp.map.confbean.SMapItemConfig;
/*     */ import mzm.gsp.map.main.WorldInstance;
/*     */ import mzm.gsp.map.main.WorldManager;
/*     */ import mzm.gsp.map.main.controller.IControllerObject;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.TransferType;
/*     */ import mzm.gsp.map.main.scene.object.MapItem;
/*     */ import mzm.gsp.map.main.scene.object.SceneObject;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class MapItemControllerObject implements IControllerObject
/*     */ {
/*  23 */   private static final Logger logger = Logger.getLogger(MapItemControllerObject.class);
/*     */   
/*     */   private final int cfgid;
/*     */   
/*     */   public MapItemControllerObject(int cfgid)
/*     */   {
/*  29 */     this.cfgid = cfgid;
/*     */   }
/*     */   
/*     */   public int getCfgid()
/*     */   {
/*  34 */     return this.cfgid;
/*     */   }
/*     */   
/*     */   public static List<Position> getBornPositions(SMapItemConfig mapItemConfig)
/*     */   {
/*  39 */     if (mapItemConfig == null)
/*     */     {
/*  41 */       return null;
/*     */     }
/*     */     
/*  44 */     List<Position> positions = new ArrayList();
/*  45 */     for (Loc loc : mapItemConfig.locations)
/*     */     {
/*  47 */       Position pos = new Position(loc.x, loc.y, 0, mapItemConfig.mapCfgid);
/*  48 */       positions.add(pos);
/*     */     }
/*  50 */     return positions;
/*     */   }
/*     */   
/*     */   public int getControllerId()
/*     */   {
/*  55 */     SMapItemCfg mapItemCfg = SMapItemCfg.get(this.cfgid);
/*  56 */     if (mapItemCfg == null)
/*     */     {
/*  58 */       return -1;
/*     */     }
/*     */     
/*  61 */     return mapItemCfg.controllerId;
/*     */   }
/*     */   
/*     */   private final MapItem makeMapItem(Scene scene, Position bornPos)
/*     */   {
/*  66 */     MapItem mapItem = new MapItem(this.cfgid);
/*  67 */     mapItem.setPosition(bornPos.getX(), bornPos.getY(), bornPos.getZ(), scene.getId());
/*  68 */     return mapItem;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<? extends SceneObject> refresh(long worldId, int maxSpawnNum)
/*     */   {
/*  74 */     WorldInstance worldInstance = WorldManager.getInstance().getWorldInstance(worldId);
/*  75 */     if (worldInstance == null)
/*     */     {
/*  77 */       return null;
/*     */     }
/*     */     
/*  80 */     SMapItemConfig mapItemConfig = SMapItemConfig.get(this.cfgid);
/*  81 */     if (mapItemConfig == null)
/*     */     {
/*  83 */       return null;
/*     */     }
/*     */     
/*  86 */     Scene scene = worldInstance.nextScene(mapItemConfig.mapCfgid);
/*  87 */     if (scene == null)
/*     */     {
/*  89 */       return null;
/*     */     }
/*     */     
/*  92 */     List<MapItem> items = new ArrayList();
/*  93 */     List<Position> positions = getBornPositions(mapItemConfig);
/*  94 */     int counter; if (!positions.isEmpty())
/*     */     {
/*  96 */       counter = 0;
/*  97 */       for (Position bornPos : positions)
/*     */       {
/*  99 */         MapItem mapItem = makeMapItem(scene, bornPos);
/* 100 */         items.add(mapItem);
/*     */         
/* 102 */         if (maxSpawnNum > 0) { counter++; if (counter >= maxSpawnNum) {
/*     */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 110 */       if (maxSpawnNum <= 0)
/*     */       {
/* 112 */         return null;
/*     */       }
/*     */       
/* 115 */       if (!mapItemConfig.randomRegions.isEmpty())
/*     */       {
/* 117 */         int counter = 0;
/* 118 */         for (;;) { counter++; if (counter > maxSpawnNum)
/*     */             break;
/* 120 */           int prob = xdb.Xdb.random().nextInt(mapItemConfig.randomRegionProbBase);
/* 121 */           Map.Entry<Integer, Integer> entry = mapItemConfig.randomRegions.ceilingEntry(Integer.valueOf(prob));
/* 122 */           if (entry == null)
/*     */           {
/* 124 */             logger.warn(String.format("[map]MapItemControllerObject.refresh@map item born region is empty|map_cfgid=%d|map_item_cfgid=%d", new Object[] { Integer.valueOf(mapItemConfig.mapCfgid), Integer.valueOf(this.cfgid) }));
/*     */             
/*     */ 
/*     */ 
/* 128 */             return null;
/*     */           }
/* 130 */           int regionCfgid = ((Integer)entry.getValue()).intValue();
/* 131 */           Position bornPos = scene.randomPosFromRegion(regionCfgid);
/* 132 */           if (bornPos == null)
/*     */           {
/* 134 */             logger.warn(String.format("[map]MapItemControllerObject.refresh@map item born position is null|map_cfgid=%d|map_item_cfgid=%d|region_cfgid=%d", new Object[] { Integer.valueOf(mapItemConfig.mapCfgid), Integer.valueOf(this.cfgid), Integer.valueOf(regionCfgid) }));
/*     */             
/*     */ 
/*     */ 
/* 138 */             return null;
/*     */           }
/*     */           
/* 141 */           MapItem mapItem = makeMapItem(scene, bornPos);
/* 142 */           items.add(mapItem);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 147 */         int counter = 0;
/* 148 */         for (;;) { counter++; if (counter > maxSpawnNum)
/*     */             break;
/* 150 */           Position bornPos = scene.randomPos();
/* 151 */           if (bornPos == null)
/*     */           {
/* 153 */             logger.warn(String.format("[map]MapItemControllerObject.refresh@map item born position is null|map_cfgid=%d|map_item_cfgid=%d", new Object[] { Integer.valueOf(mapItemConfig.mapCfgid), Integer.valueOf(this.cfgid) }));
/*     */             
/*     */ 
/*     */ 
/* 157 */             return null;
/*     */           }
/*     */           
/* 160 */           MapItem mapItem = makeMapItem(scene, bornPos);
/* 161 */           items.add(mapItem);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 166 */     for (MapItem mapItem : items)
/*     */     {
/* 168 */       mapItem.spawnMe(TransferType.SOMMON);
/*     */     }
/*     */     
/* 171 */     return items;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\proto\MapItemControllerObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */