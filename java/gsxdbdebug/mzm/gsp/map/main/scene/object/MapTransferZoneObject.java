/*     */ package mzm.gsp.map.main.scene.object;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.map.STransforPosEnterView;
/*     */ import mzm.gsp.map.STransforPosLeaveView;
/*     */ import mzm.gsp.map.confbean.SMapTransferRegion;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.PEnterTransferZone;
/*     */ import mzm.gsp.map.main.controller.IControllerObject;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.SceneManager;
/*     */ import mzm.gsp.map.main.scene.TransferType;
/*     */ import mzm.gsp.map.main.scene.zone.ZoneForm;
/*     */ import mzm.gsp.map.main.scene.zone.bounding.CylinderBounding;
/*     */ import mzm.gsp.map.main.scene.zone.type.event.ZoneListenerProxy;
/*     */ import xio.Protocol;
/*     */ 
/*     */ public class MapTransferZoneObject extends SceneObject implements IControllerObject
/*     */ {
/*     */   private final MapTransferZoneObjectId objid;
/*     */   private final SMapTransferRegion transferRegion;
/*     */   private int zoneId;
/*     */   
/*     */   static class MapTransferZoneListener implements mzm.gsp.map.main.scene.zone.type.event.IZoneListener
/*     */   {
/*     */     final long worldid;
/*     */     final Position targetPos;
/*     */     
/*     */     MapTransferZoneListener(long worldid, Position targetPos)
/*     */     {
/*  32 */       this.worldid = worldid;
/*  33 */       this.targetPos = targetPos;
/*     */     }
/*     */     
/*     */ 
/*     */     public void onEnterRole(long roleId, ZoneForm zoneForm)
/*     */     {
/*  39 */       MapRole role = MapObjectInstanceManager.getInstance().getMapRole(roleId);
/*  40 */       if (role == null)
/*     */       {
/*  42 */         return;
/*     */       }
/*  44 */       new PEnterTransferZone(roleId, this.worldid, this.targetPos).execute();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public void onLeaveRole(long roleId, ZoneForm zoneForm) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public MapTransferZoneObject(SMapTransferRegion transferRegion, int sceneId)
/*     */   {
/*  62 */     this.objid = new MapTransferZoneObjectId(sceneObjIdGenerator.nextId());
/*  63 */     this.transferRegion = transferRegion;
/*  64 */     this.position.setXYZ(transferRegion.centerX, transferRegion.centerY, 0);
/*  65 */     this.position.setSceneId(sceneId);
/*  66 */     this.targetPos = new Position(this.position);
/*     */   }
/*     */   
/*     */   public int getTargetSceneId()
/*     */   {
/*  71 */     return this.transferRegion.targetMapCfgId;
/*     */   }
/*     */   
/*     */   public void spawnMe()
/*     */   {
/*  76 */     Scene scene = SceneManager.getInstance().getScene(this.position);
/*  77 */     CylinderBounding cb = new CylinderBounding(this.position.getX(), this.position.getY(), 0, this.transferRegion.radius);
/*     */     
/*  79 */     Position targetPos = new Position(this.transferRegion.targetX, this.transferRegion.targetY, 0, this.transferRegion.targetMapCfgId);
/*     */     
/*  81 */     this.zoneId = scene.registerZoneEvent(cb, 3, new ZoneListenerProxy(new MapTransferZoneListener(scene.getWorld().getId(), targetPos)));
/*     */     
/*     */ 
/*  84 */     MapObjectInstanceManager.getInstance().addMapTransferZoneObject(this);
/*     */     
/*  86 */     spawnMe(this.position.getX(), this.position.getY(), this.position.getZ(), this.position.getSceneId(), TransferType.SOMMON);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getCfgId()
/*     */   {
/*  92 */     return this.transferRegion.id;
/*     */   }
/*     */   
/*     */ 
/*     */   public MapTransferZoneObjectId getObjectId()
/*     */   {
/*  98 */     return this.objid;
/*     */   }
/*     */   
/*     */   public int getTransferZoneId()
/*     */   {
/* 103 */     return this.objid.getId().intValue();
/*     */   }
/*     */   
/*     */ 
/*     */   public Protocol createEnterView()
/*     */   {
/* 109 */     STransforPosEnterView transforPosEnterView = new STransforPosEnterView();
/* 110 */     transforPosEnterView.instanceid = getTransferZoneId();
/* 111 */     transforPosEnterView.pos.x = this.position.getX();
/* 112 */     transforPosEnterView.pos.y = this.position.getY();
/* 113 */     transforPosEnterView.targetmapid = this.transferRegion.targetMapCfgId;
/*     */     
/* 115 */     return transforPosEnterView;
/*     */   }
/*     */   
/*     */ 
/*     */   public Protocol createLeaveView()
/*     */   {
/* 121 */     STransforPosLeaveView transforPosLeaveView = new STransforPosLeaveView();
/* 122 */     transforPosLeaveView.instanceid = getTransferZoneId();
/*     */     
/* 124 */     return transforPosLeaveView;
/*     */   }
/*     */   
/*     */ 
/*     */   public Protocol createMoveProtocol()
/*     */   {
/* 130 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public void destroy()
/*     */   {
/* 136 */     super.destroy();
/*     */     
/* 138 */     Scene scene = SceneManager.getInstance().getScene(this.position);
/* 139 */     if (scene != null)
/*     */     {
/* 141 */       scene.unregisterZoneEvent(this.zoneId);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onDestroy()
/*     */   {
/* 148 */     MapObjectInstanceManager.getInstance().removeMapTransferZoneObject(getTransferZoneId());
/*     */   }
/*     */   
/*     */ 
/*     */   public java.util.List<? extends SceneObject> refresh(long worldId, int maxSpawnNum)
/*     */   {
/* 154 */     spawnMe();
/*     */     
/* 156 */     return Arrays.asList(new MapTransferZoneObject[] { this });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\object\MapTransferZoneObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */