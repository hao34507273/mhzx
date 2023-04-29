/*     */ package mzm.gsp.map.main.message;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.map.MapModelInfo;
/*     */ import mzm.gsp.map.SEnterWorld;
/*     */ import mzm.gsp.map.event.MapRoleCreated;
/*     */ import mzm.gsp.map.event.MapRoleCreatedArg;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.WorldInstance;
/*     */ import mzm.gsp.map.main.WorldManager;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.SceneManager;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import mzm.gsp.map.main.scene.object.MapRoleInitInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MMH_PlayerEnterWorld
/*     */   extends AbstractMapMsgHandler
/*     */ {
/*     */   private final long roleid;
/*     */   private final MapRoleInitInfo mapRoleInitInfo;
/*     */   
/*     */   public MMH_PlayerEnterWorld(long roleid, MapRoleInitInfo mapRoleInitInfo)
/*     */   {
/*  30 */     this.roleid = roleid;
/*  31 */     this.mapRoleInitInfo = mapRoleInitInfo;
/*     */   }
/*     */   
/*     */ 
/*     */   public void doProcess()
/*     */   {
/*  37 */     boolean hit = true;
/*  38 */     MapRole mapRole = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/*  39 */     if (mapRole == null)
/*     */     {
/*  41 */       mapRole = new MapRole(this.roleid, this.mapRoleInitInfo);
/*  42 */       hit = false;
/*     */     }
/*  44 */     mapRole.setXunLuoState(false);
/*     */     
/*  46 */     MapObjectInstanceManager.getInstance().addMapRole(mapRole);
/*     */     
/*     */ 
/*  49 */     SEnterWorld enterWorld = new SEnterWorld();
/*  50 */     enterWorld.direction = mapRole.getDirection();
/*  51 */     Scene scene = SceneManager.getInstance().getScene(mapRole.getPositionForInner());
/*  52 */     if (scene == null)
/*     */     {
/*     */ 
/*  55 */       Position pos = WorldManager.getInstance().getBigWorldInstance().getPosition(this.roleid);
/*  56 */       mapRole.setPosition(pos.getX(), pos.getY(), pos.getZ(), pos.getSceneId());
/*  57 */       scene = SceneManager.getInstance().getScene(mapRole.getPositionForInner());
/*     */     }
/*  59 */     enterWorld.mapid = scene.getCfgId();
/*  60 */     enterWorld.mapinstanceid = scene.getId();
/*  61 */     Position pos = mapRole.getPositionForInner();
/*  62 */     Position flyLandPos = scene.getFlyLandPositionForInner(pos);
/*  63 */     if ((flyLandPos != null) && (flyLandPos != pos))
/*     */     {
/*  65 */       mapRole.setPosition(pos.getX(), pos.getY(), pos.getZ(), pos.getSceneId());
/*  66 */       pos = flyLandPos;
/*     */     }
/*  68 */     enterWorld.pos.x = pos.getX();
/*  69 */     enterWorld.pos.y = pos.getY();
/*  70 */     enterWorld.modelinfo = mapRole.getRoleModelCache();
/*  71 */     MapModelInfo petModel = mapRole.getPetModel();
/*  72 */     MapModelInfo childrenModel = mapRole.getChildrenModel();
/*  73 */     if (petModel != null)
/*     */     {
/*  75 */       enterWorld.othermodel.put(Integer.valueOf(1), mapRole.getPetModelCache());
/*     */     }
/*  77 */     else if (childrenModel != null)
/*     */     {
/*  79 */       enterWorld.othermodel.put(Integer.valueOf(2), mapRole.getChildrenModelCache());
/*     */     }
/*  81 */     MapProtocolSendQueue.getInstance().send(this.roleid, enterWorld);
/*     */     
/*  83 */     if (!hit)
/*     */     {
/*  85 */       mapRole.spawnMe();
/*     */       
/*     */ 
/*  88 */       Set<Integer> roleStatusSet = this.mapRoleInitInfo.roleStatusSet;
/*  89 */       if ((roleStatusSet != null) && (roleStatusSet.contains(Integer.valueOf(0))))
/*     */       {
/*  91 */         mapRole.notifyOtherInFight();
/*     */       }
/*     */       
/*     */ 
/*  95 */       MapRoleCreatedArg arg = new MapRoleCreatedArg(this.roleid, scene.getWorld().getId(), scene.getCfgId());
/*  96 */       TriggerEventsManger.getInstance().triggerEventAtOnce(new MapRoleCreated(), arg);
/*     */       
/*  98 */       return;
/*     */     }
/*     */     
/*     */ 
/* 102 */     scene.sendWorldShareMapEntityEnterViewToRole(mapRole);
/*     */     
/*     */ 
/* 105 */     scene.sendNotOwnViewMapEntityEnterViewToRole(mapRole);
/*     */     
/*     */ 
/* 108 */     scene.sendTransferEnterViewToRole(mapRole);
/*     */     
/* 110 */     mapRole.reSyncAllView();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_PlayerEnterWorld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */