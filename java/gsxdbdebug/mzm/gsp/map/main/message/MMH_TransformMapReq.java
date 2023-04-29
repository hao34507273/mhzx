/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.map.SMapCommonResult;
/*    */ import mzm.gsp.map.confbean.SMapConfig;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ import mzm.gsp.map.main.proto.MapPrototype;
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import mzm.gsp.map.main.scene.Scene;
/*    */ import mzm.gsp.map.main.scene.SceneManager;
/*    */ import mzm.gsp.map.main.scene.TransferType;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ import org.apache.log4j.Logger;
/*    */ import xio.Protocol;
/*    */ 
/*    */ public class MMH_TransformMapReq extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleId;
/*    */   private final int mapId;
/*    */   private final int targetPosX;
/*    */   private final int targetPosY;
/*    */   
/*    */   public MMH_TransformMapReq(long paramLong, int paramInt1, int paramInt2, int paramInt3)
/*    */   {
/* 27 */     this.roleId = paramLong;
/* 28 */     this.mapId = paramInt1;
/* 29 */     this.targetPosX = paramInt2;
/* 30 */     this.targetPosY = paramInt3;
/*    */   }
/*    */   
/*    */   public void doProcess() {
/* 34 */     MapRole localMapRole = MapObjectInstanceManager.getInstance().getMapRole(this.roleId);
/* 35 */     if (localMapRole == null) {
/* 36 */       GameServer.logger().error(String.format("[map]MMH_TransformMapReq.doProcess@MapRole is null|roleid=%d|map_cfgid=%d|target_posx=%d|target_posy=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.mapId), Integer.valueOf(this.targetPosX), Integer.valueOf(this.targetPosY) }));
/* 37 */       return;
/*    */     }
/* 39 */     Position localPosition = localMapRole.getPositionForInner();
/* 40 */     Scene localScene1 = SceneManager.getInstance().getScene(localPosition);
/* 41 */     if (localScene1 == null) {
/* 42 */       GameServer.logger().error(String.format("[map]MMH_TransformMapReq.doProcess@nowScene is null|roleid=%d|map_cfgid=%d|target_posx=%d|target_posy=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.mapId), Integer.valueOf(this.targetPosX), Integer.valueOf(this.targetPosY) }));
/* 43 */       return;
/*    */     }
/* 45 */     Scene localScene2 = localScene1.getWorld().nextScene(this.mapId);
/* 46 */     if ((localScene2 == null) && ((localScene1.isGangMap()) || (localScene1.isHomelandMap())))
/* 47 */       localScene2 = WorldManager.getInstance().getBigWorldInstance().getSceneByCfgId(this.mapId);
/* 48 */     if (localScene2 == null) {
/* 49 */       localObject1 = new SMapCommonResult();
/* 50 */       ((SMapCommonResult)localObject1).result = 211;
/* 51 */       MapProtocolSendQueue.getInstance().send(this.roleId, (Protocol)localObject1);
/* 52 */       GameServer.logger().error(String.format("[map]MMH_TransformMapReq.doProcess@target scene is null|roleid=%d|worldid=%d|map_cfgid=%d|target_posx=%d|target_posy=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(localScene1.getWorld().getId()), Integer.valueOf(this.mapId), Integer.valueOf(this.targetPosX), Integer.valueOf(this.targetPosY) }));
/* 53 */       return;
/*    */     }
/* 55 */     Object localObject1 = localScene2.getMapConfig();
/* 56 */     Object localObject2; if (localObject1 == null) {
/* 57 */       localObject2 = new SMapCommonResult();
/* 58 */       ((SMapCommonResult)localObject2).result = 211;
/* 59 */       MapProtocolSendQueue.getInstance().send(this.roleId, (Protocol)localObject2);
/* 60 */       GameServer.logger().error(String.format("[map]MMH_TransformMapReq.doProcess@target map config is null|roleid=%d|worldid=%d|map_cfgid=%d|target_posx=%d|target_posy=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(localScene1.getWorld().getId()), Integer.valueOf(this.mapId), Integer.valueOf(this.targetPosX), Integer.valueOf(this.targetPosY) }));
/* 61 */       return;
/*    */     }
/* 63 */     if (!MapPrototype.canDirectTransfer((SMapConfig)localObject1)) {
/* 64 */       GameServer.logger().error(String.format("[map]MMH_TransformMapReq.doProcess@can not transfer directly|roleid=%d|worldid=%d|map_cfgid=%d|target_posx=%d|target_posy=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(localScene1.getWorld().getId()), Integer.valueOf(this.mapId), Integer.valueOf(this.targetPosX), Integer.valueOf(this.targetPosY) }));
/* 65 */       return;
/*    */     }
/* 67 */     if ((localMapRole.isFollower()) || (localMapRole.isFightState()) || (localMapRole.isTeleporting()) || (localMapRole.isServerDominateGroup())) {
/* 68 */       GameServer.logger().error(String.format("[map]MMH_TransformMapReq.doProcess@role isFollower or isFightState or isTeleporting or isServerDominateGroup|roleid=%d|worldid=%d|map_cfgid=%d|target_posx=%d|target_posy=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(localScene1.getWorld().getId()), Integer.valueOf(this.mapId), Integer.valueOf(this.targetPosX), Integer.valueOf(this.targetPosY) }));
/* 69 */       return;
/*    */     }
/* 71 */     if ((this.targetPosX <= 0) || (this.targetPosY <= 0)) {
/* 72 */       new MMH_PlayerTransferToScene(this.roleId, localScene2.getId()).doProcess();
/*    */     } else {
/* 74 */       localObject2 = localScene2.getCell((SMapConfig)localObject1, this.targetPosX, this.targetPosY);
/* 75 */       if (localObject2 == null) {
/* 76 */         GameServer.logger().error(String.format("[map]MMH_TransformMapReq.doProcess@target point invalid|roleid=%d|targetx=%d|targety=%d|cur_map_cfgid=%d|cur_sceneid=%d|cur_posx=%d|cur_posy=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.targetPosX), Integer.valueOf(this.targetPosY), Integer.valueOf(localScene2.getCfgId()), Integer.valueOf(localPosition.getSceneId()), Integer.valueOf(localPosition.getX()), Integer.valueOf(localPosition.getY()) }));
/* 77 */         return;
/*    */       }
/* 79 */       new MMH_PlayerTransferToScene(this.roleId, localScene2.getId(), ((SMapConfig)localObject1).defaultTransPosX, ((SMapConfig)localObject1).defaultTransPosY, this.targetPosX, this.targetPosY, TransferType.TRANSPOS).doProcess();
/*    */     }
/* 81 */     GameServer.logger().error(String.format("[map]MMH_TransformMapReq.doProcess@Xun Luo State False|roleid=%d|worldid=%d|map_cfgid=%d|target_posx=%d|target_posy=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(localScene1.getWorld().getId()), Integer.valueOf(this.mapId), Integer.valueOf(this.targetPosX), Integer.valueOf(this.targetPosY) }));
/* 82 */     localMapRole.setXunLuoState(false);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_TransformMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */