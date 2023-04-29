/*     */ package mzm.gsp.map.main.message;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.WorldInstance;
/*     */ import mzm.gsp.map.main.WorldManager;
/*     */ import mzm.gsp.map.main.proto.MapPrototype;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.SceneManager;
/*     */ import mzm.gsp.map.main.scene.TransferType;
/*     */ import mzm.gsp.map.main.scene.object.MapEntity;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityChildren;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityHomeLandBasicInfo;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import mzm.gsp.map.main.scene.object.MapFurniture;
/*     */ import mzm.gsp.map.main.scene.object.MapWorldShareEntity;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class MMH_AddMapEntity
/*     */   extends AbstractMapMsgHandler implements MapMsgHandlerDone<MMH_AddMapEntity>
/*     */ {
/*     */   private final MapEntityType entityType;
/*     */   private final long entityInstanceid;
/*     */   private final long worldid;
/*     */   private final int mapCfgidOrSceneid;
/*     */   private final int cfgid;
/*     */   private final int x;
/*     */   private final int y;
/*     */   private final Map<Integer, Integer> intExtraInfoEntries;
/*     */   private final Map<Integer, Long> longExtraInfoEntries;
/*     */   private final Map<Integer, String> stringExtraInfoEntries;
/*     */   private final boolean needCheck;
/*     */   private final MapCallback<Boolean> callback;
/*  36 */   private boolean result = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public MMH_AddMapEntity(MapEntityType entityType, long entityInstanceid, long worldid, int mapCfgid, int x, int y, int cfgid, Map<Integer, Integer> intExtraInfoEntries, Map<Integer, Long> longExtraInfoEntries, Map<Integer, String> stringExtraInfoEntries, boolean needCheck, MapCallback<Boolean> callback)
/*     */   {
/*  43 */     this.entityType = entityType;
/*  44 */     this.entityInstanceid = entityInstanceid;
/*  45 */     this.worldid = worldid;
/*  46 */     this.mapCfgidOrSceneid = mapCfgid;
/*  47 */     if ((x < 0) || (y < 0))
/*     */     {
/*  49 */       this.x = MapPrototype.getDefaultTransferPosX(mapCfgid);
/*  50 */       this.y = MapPrototype.getDefaultTransferPosY(mapCfgid);
/*     */     }
/*     */     else
/*     */     {
/*  54 */       this.x = x;
/*  55 */       this.y = y;
/*     */     }
/*  57 */     this.cfgid = cfgid;
/*  58 */     this.intExtraInfoEntries = intExtraInfoEntries;
/*  59 */     this.longExtraInfoEntries = longExtraInfoEntries;
/*  60 */     this.stringExtraInfoEntries = stringExtraInfoEntries;
/*  61 */     this.needCheck = needCheck;
/*  62 */     this.callback = callback;
/*     */   }
/*     */   
/*     */   public boolean getResult()
/*     */   {
/*  67 */     return this.result;
/*     */   }
/*     */   
/*     */ 
/*     */   public void doProcess()
/*     */   {
/*  73 */     Scene scene = null;
/*  74 */     if (this.worldid > -1L)
/*     */     {
/*  76 */       WorldInstance instance = WorldManager.getInstance().getWorldInstance(this.worldid);
/*  77 */       if (instance == null)
/*     */       {
/*  79 */         return;
/*     */       }
/*  81 */       scene = instance.nextScene(this.mapCfgidOrSceneid);
/*     */     }
/*     */     else
/*     */     {
/*  85 */       scene = SceneManager.getInstance().getScene(this.mapCfgidOrSceneid);
/*     */     }
/*     */     
/*  88 */     if (scene == null)
/*     */     {
/*  90 */       return;
/*     */     }
/*     */     
/*  93 */     int sceneid = scene.getId();
/*     */     
/*  95 */     MapEntity oldEntity = MapObjectInstanceManager.getInstance().getMapEntity(this.entityType.ordinal(), this.entityInstanceid);
/*     */     
/*  97 */     if (oldEntity != null)
/*     */     {
/*  99 */       GameServer.logger().warn(String.format("[map]MMH_AddMapEntity.doProcess@entity already exist|entity_type=%d|entity_instanceid=%d|map_cfgid=%d|x=%d|y=%d|cfgid=%d|int_extra_infos=%s|long_extra_infos=%s|str_extra_infos=%s", new Object[] { Integer.valueOf(this.entityType.ordinal()), Long.valueOf(this.entityInstanceid), Integer.valueOf(scene.getCfgId()), Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.cfgid), this.intExtraInfoEntries, this.longExtraInfoEntries, this.stringExtraInfoEntries }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 105 */       if (this.entityType.isWorldShare())
/*     */       {
/* 107 */         if (((MapWorldShareEntity)oldEntity).getWorldInstance() != scene.getWorld()) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 114 */       else if (oldEntity.getSceneId() == sceneid)
/*     */       {
/* 116 */         return;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 121 */     MapEntity entity = null;
/* 122 */     if (this.entityType == MapEntityType.MET_FURNITURE)
/*     */     {
/* 124 */       entity = new MapFurniture(this.entityType, this.entityInstanceid, sceneid, this.x, this.y, this.cfgid, this.intExtraInfoEntries, this.longExtraInfoEntries, this.stringExtraInfoEntries);
/*     */ 
/*     */     }
/* 127 */     else if (this.entityType == MapEntityType.MGT_HOME_LAND_BASIC_INFO)
/*     */     {
/* 129 */       entity = new MapEntityHomeLandBasicInfo(this.entityType, this.entityInstanceid, sceneid, this.x, this.y, this.cfgid, this.intExtraInfoEntries, this.longExtraInfoEntries, this.stringExtraInfoEntries);
/*     */ 
/*     */ 
/*     */     }
/* 133 */     else if (this.entityType == MapEntityType.MET_CHILDREN)
/*     */     {
/* 135 */       entity = new MapEntityChildren(this.entityType, this.entityInstanceid, sceneid, this.x, this.y, this.cfgid, this.intExtraInfoEntries, this.longExtraInfoEntries, this.stringExtraInfoEntries);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 140 */       entity = new MapEntity(this.entityType, this.entityInstanceid, sceneid, this.x, this.y, this.cfgid, this.intExtraInfoEntries, this.longExtraInfoEntries, this.stringExtraInfoEntries);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 145 */     if ((this.needCheck) && (!entity.onAddCheck()))
/*     */     {
/* 147 */       return;
/*     */     }
/*     */     
/*     */ 
/* 151 */     if (oldEntity != null)
/*     */     {
/* 153 */       oldEntity.destroy();
/*     */     }
/*     */     
/* 156 */     if (this.entityType.isWorldShare())
/*     */     {
/* 158 */       ((MapWorldShareEntity)entity).worldShare(scene.getWorld());
/*     */     }
/*     */     else
/*     */     {
/* 162 */       entity.spawnMe(TransferType.SOMMON);
/*     */     }
/*     */     
/* 165 */     this.result = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected MapMsgHandlerDone<MMH_AddMapEntity> getMapMsgHandlerDone()
/*     */   {
/* 172 */     if (this.callback == null)
/*     */     {
/* 174 */       return null;
/*     */     }
/*     */     
/* 177 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCallInProcedure()
/*     */   {
/* 183 */     return this.callback.isCallInProcedure();
/*     */   }
/*     */   
/*     */   public boolean onMapMsgHandlerDone(MMH_AddMapEntity mmh)
/*     */     throws Exception
/*     */   {
/* 189 */     return this.callback.onResult(Boolean.valueOf(mmh.getResult()));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_AddMapEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */