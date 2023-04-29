/*     */ package mzm.gsp.map.main.message;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.map.Location;
/*     */ import mzm.gsp.map.confbean.SMapConfig;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.proto.Cell;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.SceneManager;
/*     */ import mzm.gsp.map.main.scene.object.MapEntity;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class MMH_MapEntityMove
/*     */   extends AbstractMapMsgHandler
/*     */ {
/*  19 */   private static final Logger logger = Logger.getLogger(MMH_MapEntityMove.class);
/*     */   
/*     */   private final MapEntityType entityType;
/*     */   
/*     */   private final long entityInstanceid;
/*     */   private final List<Location> keyPathList;
/*     */   private final int velocity;
/*     */   
/*     */   public MMH_MapEntityMove(MapEntityType entityType, long entityInstanceid, List<Location> keyPathList, int velocity)
/*     */   {
/*  29 */     this.entityType = entityType;
/*  30 */     this.entityInstanceid = entityInstanceid;
/*  31 */     this.keyPathList = keyPathList;
/*  32 */     this.velocity = velocity;
/*     */   }
/*     */   
/*     */ 
/*     */   public void doProcess()
/*     */   {
/*  38 */     if (!this.entityType.canMove())
/*     */     {
/*  40 */       logger.warn(String.format("[map]MMH_MapEntityMove.doProcess@map entity invalid|map_entity_type=%d|map_entity_instanceid=%d", new Object[] { Integer.valueOf(this.entityType.ordinal()), Long.valueOf(this.entityInstanceid) }));
/*     */       
/*     */ 
/*  43 */       return;
/*     */     }
/*     */     
/*  46 */     if (this.keyPathList.isEmpty())
/*     */     {
/*  48 */       logger.warn(String.format("[map]MMH_MapEntityMove.doProcess@key path list is empty from client|map_entity_type=%d|map_entity_instanceid=%d", new Object[] { Integer.valueOf(this.entityType.ordinal()), Long.valueOf(this.entityInstanceid) }));
/*     */       
/*     */ 
/*     */ 
/*  52 */       return;
/*     */     }
/*     */     
/*  55 */     MapEntity mapEntity = MapObjectInstanceManager.getInstance().getMapEntity(this.entityType.ordinal(), this.entityInstanceid);
/*     */     
/*  57 */     if (mapEntity == null)
/*     */     {
/*  59 */       logger.warn(String.format("[map]MMH_MapEntityMove.doProcess@map entity is null|map_entity_type=%d|map_entity_instanceid=%d", new Object[] { Integer.valueOf(this.entityType.ordinal()), Long.valueOf(this.entityInstanceid) }));
/*     */       
/*     */ 
/*  62 */       return;
/*     */     }
/*     */     
/*  65 */     Position curPos = mapEntity.getPositionForInner();
/*  66 */     Scene scene = SceneManager.getInstance().getScene(curPos);
/*  67 */     if (scene == null)
/*     */     {
/*     */ 
/*  70 */       logger.warn(String.format("[map]MMH_MapEntityMove.doProcess@scene is null|map_entity_type=%d|map_entity_instanceid=%d|cur_pos=%s", new Object[] { Integer.valueOf(this.entityType.ordinal()), Long.valueOf(this.entityInstanceid), curPos.toString() }));
/*     */       
/*     */ 
/*     */ 
/*  74 */       return;
/*     */     }
/*     */     
/*  77 */     SMapConfig mapConfig = scene.getMapConfig();
/*  78 */     if (mapConfig == null)
/*     */     {
/*     */ 
/*  81 */       logger.warn(String.format("[map]MMH_MapEntityMove.doProcess@map config is null|map_entity_type=%d|map_entity_instanceid=%d|cur_pos=%s", new Object[] { Integer.valueOf(this.entityType.ordinal()), Long.valueOf(this.entityInstanceid), curPos.toString() }));
/*     */       
/*     */ 
/*     */ 
/*  85 */       return;
/*     */     }
/*     */     
/*  88 */     int curMapCfgid = scene.getCfgId();
/*     */     
/*  90 */     Location firstLocation = (Location)this.keyPathList.get(0);
/*  91 */     if ((curPos.getX() == firstLocation.x) && (curPos.getY() == firstLocation.y))
/*     */     {
/*  93 */       this.keyPathList.remove(0);
/*  94 */       if (this.keyPathList.isEmpty())
/*     */       {
/*  96 */         return;
/*     */       }
/*     */     }
/*     */     
/* 100 */     for (Location loc : this.keyPathList)
/*     */     {
/* 102 */       Cell cell = scene.getCell(mapConfig, loc.x, loc.y);
/* 103 */       if (cell == null)
/*     */       {
/* 105 */         logger.warn(String.format("[map]MMH_MapEntityMove.doProcess@key path point invalid|map_entity_type=%d|map_entity_instanceid=%d|key_pointx=%d|key_pointy=%d|cur_map_cfgid=%d|cur_pos=%s", new Object[] { Integer.valueOf(this.entityType.ordinal()), Long.valueOf(this.entityInstanceid), Integer.valueOf(loc.x), Integer.valueOf(loc.y), Integer.valueOf(curMapCfgid), curPos.toString() }));
/*     */         
/*     */ 
/*     */ 
/* 109 */         return;
/*     */       }
/*     */       
/* 112 */       if (!cell.isReachable())
/*     */       {
/* 114 */         logger.warn(String.format("[map]MMH_MapEntityMove.doProcess@key path point not reachable|map_entity_type=%d|map_entity_instanceid=%d|key_pointx=%d|key_pointy=%d|cur_map_cfgid=%d|cur_pos=%s", new Object[] { Integer.valueOf(this.entityType.ordinal()), Long.valueOf(this.entityInstanceid), Integer.valueOf(loc.x), Integer.valueOf(loc.y), Integer.valueOf(curMapCfgid), curPos.toString() }));
/*     */         
/*     */ 
/*     */ 
/* 118 */         return;
/*     */       }
/*     */     }
/*     */     
/* 122 */     mapEntity.setVelocity(this.velocity);
/* 123 */     mapEntity.updateMovePath(this.keyPathList);
/* 124 */     Location targetLoc = (Location)this.keyPathList.get(this.keyPathList.size() - 1);
/* 125 */     mapEntity.setTargetPos(targetLoc.x, targetLoc.y, 0);
/*     */     
/*     */ 
/* 128 */     mapEntity.setXYZ(curPos.getX(), curPos.getY(), curPos.getZ());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_MapEntityMove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */