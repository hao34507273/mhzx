/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.map.Location;
/*    */ import mzm.gsp.map.SSyncMapFly;
/*    */ import mzm.gsp.map.confbean.SMapConfig;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ import mzm.gsp.map.main.proto.Cell;
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import mzm.gsp.map.main.scene.Scene;
/*    */ import mzm.gsp.map.main.scene.SceneManager;
/*    */ import mzm.gsp.map.main.scene.TransferType;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ public class MMH_PlayerFly
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleId;
/*    */   private final int targetX;
/*    */   private final int targetY;
/*    */   private final int flySpeed;
/*    */   
/*    */   public MMH_PlayerFly(long roleId, int targetX, int targetY, int flySpeed)
/*    */   {
/* 31 */     this.roleId = roleId;
/* 32 */     this.targetX = targetX;
/* 33 */     this.targetY = targetY;
/* 34 */     this.flySpeed = flySpeed;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 40 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleId);
/* 41 */     if (role.isFlyState())
/*    */     {
/* 43 */       return;
/*    */     }
/*    */     
/* 46 */     Position curPos = role.getPositionForInner();
/* 47 */     Scene scene = SceneManager.getInstance().getScene(curPos);
/* 48 */     if (scene == null)
/*    */     {
/*    */ 
/* 51 */       Position position = WorldManager.getInstance().getBigWorldInstance().getPosition(this.roleId);
/* 52 */       WorldManager.getInstance().dragTo(this.roleId, position, TransferType.FAULT);
/*    */       
/* 54 */       role.unSetFlyState();
/*    */       
/* 56 */       return;
/*    */     }
/*    */     
/* 59 */     SMapConfig mapConfig = scene.getMapConfig();
/* 60 */     if (mapConfig == null)
/*    */     {
/*    */ 
/* 63 */       Position position = WorldManager.getInstance().getBigWorldInstance().getPosition(this.roleId);
/* 64 */       WorldManager.getInstance().dragTo(this.roleId, position, TransferType.FAULT);
/*    */       
/* 66 */       role.unSetFlyState();
/*    */       
/* 68 */       return;
/*    */     }
/*    */     
/* 71 */     Cell cell = scene.getCell(mapConfig, this.targetX, this.targetY);
/* 72 */     if (cell == null)
/*    */     {
/* 74 */       GameServer.logger().error(String.format("[map]MMH_PlayerFly.doProcess@target point invalid|roleid=%d|targetx=%d|targety=%d|cur_map_cfgid=%d|cur_sceneid=%d|cur_posx=%d|cur_posy=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.targetX), Integer.valueOf(this.targetY), Integer.valueOf(scene.getCfgId()), Integer.valueOf(curPos.getSceneId()), Integer.valueOf(curPos.getX()), Integer.valueOf(curPos.getY()) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 79 */       role.unSetFlyState();
/*    */       
/* 81 */       return;
/*    */     }
/*    */     
/* 84 */     role.setTargetPos(this.targetX, this.targetY, 0);
/* 85 */     role.setFlySpeed(this.flySpeed);
/* 86 */     List<Location> locations = new ArrayList();
/* 87 */     locations.add(new Location(this.targetX, this.targetY));
/* 88 */     role.updateMovePath(locations);
/*    */     
/* 90 */     SSyncMapFly syncMapFly = new SSyncMapFly();
/* 91 */     syncMapFly.roleid = this.roleId;
/* 92 */     syncMapFly.targetpos.x = this.targetX;
/* 93 */     syncMapFly.targetpos.y = this.targetY;
/* 94 */     role.broadcastProtocolIncludeSelf(syncMapFly);
/*    */     
/* 96 */     if (GameServer.logger().isDebugEnabled())
/*    */     {
/* 98 */       GameServer.logger().debug(String.format("[map]MMH_PlayerFly.doProcess@fly info|roleid=%d|fly_speed=%d|targetx=%d|targety=%d|husong=%b", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.flySpeed), Integer.valueOf(this.targetX), Integer.valueOf(this.targetY), Boolean.valueOf(role.isInHuSongState()) }));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_PlayerFly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */