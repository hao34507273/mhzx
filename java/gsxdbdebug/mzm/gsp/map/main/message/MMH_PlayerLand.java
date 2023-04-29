/*     */ package mzm.gsp.map.main.message;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.SLandErrorRes;
/*     */ import mzm.gsp.map.SSyncLand;
/*     */ import mzm.gsp.map.confbean.SMapConfig;
/*     */ import mzm.gsp.map.main.MapManager;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.group.MapGroupData;
/*     */ import mzm.gsp.map.main.group.MapGroupManager;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.SceneManager;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import mzm.gsp.map.main.team.MapTeamData;
/*     */ import mzm.gsp.map.main.team.MapTeamManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class MMH_PlayerLand
/*     */   extends AbstractMapMsgHandler
/*     */ {
/*     */   private final long roleId;
/*     */   private final int targetX;
/*     */   private final int targetY;
/*     */   
/*     */   public MMH_PlayerLand(long roleId, int targetX, int targetY)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.targetX = targetX;
/*  31 */     this.targetY = targetY;
/*     */   }
/*     */   
/*     */ 
/*     */   public void doProcess()
/*     */   {
/*  37 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleId);
/*  38 */     if (role == null)
/*     */     {
/*  40 */       return;
/*     */     }
/*     */     
/*     */ 
/*  44 */     if (role.isServerDominateGroup())
/*     */     {
/*  46 */       return;
/*     */     }
/*     */     
/*  49 */     MapTeamData teamData = MapTeamManager.getInstance().getTeamById(role.getTeamId());
/*  50 */     if ((teamData != null) && (this.roleId != teamData.getLeaderId()))
/*     */     {
/*  52 */       GameServer.logger().info(String.format("[map]MMH_PlayerLand.doProcess@team member can not do this|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/*  55 */       SLandErrorRes landErrorRes = new SLandErrorRes();
/*  56 */       landErrorRes.ret = 2;
/*  57 */       MapProtocolSendQueue.getInstance().send(this.roleId, landErrorRes);
/*     */       
/*  59 */       return;
/*     */     }
/*     */     
/*  62 */     MapGroupData mapGroupData = MapGroupManager.getInstance().getMapGroupData(role.getGroupType(), role.getGroupid());
/*  63 */     if (mapGroupData != null)
/*     */     {
/*  65 */       GameServer.logger().info(String.format("[map]MMH_PlayerLand.doProcess@group leader or member can not do this|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/*  68 */       SLandErrorRes landErrorRes = new SLandErrorRes();
/*  69 */       landErrorRes.ret = 3;
/*  70 */       MapProtocolSendQueue.getInstance().send(this.roleId, landErrorRes);
/*     */       
/*  72 */       return;
/*     */     }
/*     */     
/*  75 */     Scene scene = SceneManager.getInstance().getScene(role.getSceneId());
/*  76 */     if (scene == null)
/*     */     {
/*  78 */       return;
/*     */     }
/*     */     
/*  81 */     SMapConfig mapConfig = scene.getMapConfig();
/*  82 */     if (mapConfig == null)
/*     */     {
/*  84 */       return;
/*     */     }
/*     */     
/*  87 */     if (!scene.isReachable(mapConfig, this.targetX, this.targetY))
/*     */     {
/*  89 */       GameServer.logger().error(String.format("[map]MMH_PlayerLand.doProcess@position is not reachable|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/*  92 */       SLandErrorRes landErrorRes = new SLandErrorRes();
/*  93 */       landErrorRes.ret = 1;
/*  94 */       MapProtocolSendQueue.getInstance().send(this.roleId, landErrorRes);
/*     */       
/*  96 */       return;
/*     */     }
/*     */     
/*  99 */     Position position = role.getPositionForInner();
/* 100 */     double distance = MapManager.getDistance(position.getX(), position.getY(), this.targetX, this.targetY);
/* 101 */     if (distance > role.getVelocity())
/*     */     {
/* 103 */       GameServer.logger().warn(String.format("[map]MMH_PlayerLand.doProcess@land error,land position is too far |curposx=%d|curposy=%d|targetx=%d|targety=%d|mapid=%d|roleid=%d", new Object[] { Integer.valueOf(position.getX()), Integer.valueOf(position.getY()), Integer.valueOf(this.targetX), Integer.valueOf(this.targetY), Integer.valueOf(scene.getCfgId()), Long.valueOf(this.roleId) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 110 */     role.setXYZ(this.targetX, this.targetY, 0);
/* 111 */     role.unSetFlyState();
/*     */     
/* 113 */     SSyncLand syncLand = new SSyncLand();
/* 114 */     syncLand.roleid = this.roleId;
/* 115 */     syncLand.pos.x = this.targetX;
/* 116 */     syncLand.pos.y = this.targetY;
/* 117 */     role.broadcastProtocolIncludeSelf(syncLand);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_PlayerLand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */