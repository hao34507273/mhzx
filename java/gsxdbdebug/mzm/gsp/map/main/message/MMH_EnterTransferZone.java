/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapCfgManager;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.proto.MapPrototype;
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import mzm.gsp.map.main.scene.Scene;
/*    */ import mzm.gsp.map.main.scene.SceneManager;
/*    */ import mzm.gsp.map.main.scene.TransferType;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_EnterTransferZone extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/*    */   private final Position target;
/*    */   
/*    */   public MMH_EnterTransferZone(long roleid, Position target)
/*    */   {
/* 20 */     this.roleid = roleid;
/* 21 */     this.target = target;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 27 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 28 */     if (role == null)
/*    */     {
/* 30 */       return;
/*    */     }
/*    */     
/* 33 */     Scene scene = SceneManager.getInstance().getScene(role.getPositionForInner());
/* 34 */     MapPrototype prototype = MapCfgManager.getInstance().getMapProtoById(this.target.getSceneId());
/* 35 */     if (prototype == null)
/*    */     {
/* 37 */       mzm.gsp.GameServer.logger().error("not find map cfg : id " + this.target.getSceneId());
/* 38 */       return;
/*    */     }
/*    */     
/* 41 */     int targetX = this.target.getX();
/* 42 */     int targetY = this.target.getY();
/*    */     
/* 44 */     if (role.isInHuSongState())
/*    */     {
/* 46 */       Position targetPos = role.nextHuSongTargetPosition();
/* 47 */       if (targetPos != null)
/*    */       {
/* 49 */         targetX = targetPos.getX();
/* 50 */         targetY = targetPos.getY();
/*    */       }
/*    */     }
/*    */     
/* 54 */     if (prototype.isWorldMap())
/*    */     {
/* 56 */       new MMH_PlayerTransferToScene(role.getRoleId(), this.target.getSceneId(), this.target.getX(), this.target.getY(), targetX, targetY, TransferType.ZONE_TRANSFER).doProcess();
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 61 */       new MMH_TeleportOrCreateScene(role.getRoleId(), scene.getWorld().getId(), this.target.getSceneId(), this.target.getX(), this.target.getY(), targetX, targetY, TransferType.ZONE_TRANSFER).doProcess();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_EnterTransferZone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */