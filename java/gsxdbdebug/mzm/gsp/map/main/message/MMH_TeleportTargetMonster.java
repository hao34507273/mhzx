/*     */ package mzm.gsp.map.main.message;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.map.confbean.SMapConfig;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.WorldInstance;
/*     */ import mzm.gsp.map.main.WorldManager;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.TransferType;
/*     */ import mzm.gsp.map.main.scene.object.MapMonster;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class MMH_TeleportTargetMonster
/*     */   extends AbstractMapMsgHandler
/*     */ {
/*  23 */   private static final Logger logger = Logger.getLogger(MMH_TeleportTargetMonster.class);
/*     */   
/*     */   private final long roleId;
/*     */   private final int mapCfgId;
/*     */   private final long worldId;
/*     */   private final int targetMonsterCfgId;
/*     */   
/*     */   public MMH_TeleportTargetMonster(long roleId, int mapCfgId, long worldId, int targetMonsterCfgId)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.mapCfgId = mapCfgId;
/*  34 */     this.worldId = worldId;
/*  35 */     this.targetMonsterCfgId = targetMonsterCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */   public final void doProcess()
/*     */   {
/*  41 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleId);
/*  42 */     if (role == null)
/*     */     {
/*  44 */       return;
/*     */     }
/*     */     
/*  47 */     WorldInstance instance = WorldManager.getInstance().getWorldInstance(this.worldId);
/*  48 */     if (instance == null)
/*     */     {
/*  50 */       return;
/*     */     }
/*     */     
/*  53 */     Scene scene = instance.nextScene(this.mapCfgId);
/*  54 */     if (scene == null)
/*     */     {
/*  56 */       return;
/*     */     }
/*     */     
/*  59 */     SMapConfig mapConfig = scene.getMapConfig();
/*  60 */     if (mapConfig == null)
/*     */     {
/*  62 */       return;
/*     */     }
/*     */     
/*  65 */     List<MapMonster> monsterList = scene.getMonsterByCfgId(this.targetMonsterCfgId);
/*  66 */     if (monsterList.isEmpty())
/*     */     {
/*  68 */       if (logger.isDebugEnabled())
/*     */       {
/*  70 */         logger.debug("获得的怪物数量为空! visible monsterCfgID : " + this.targetMonsterCfgId);
/*     */       }
/*  72 */       return;
/*     */     }
/*     */     
/*  75 */     MapMonster monster = (MapMonster)monsterList.get(0);
/*  76 */     Position targetPos = monster.getPositionForInner();
/*  77 */     int x = targetPos.getX();
/*  78 */     int y = targetPos.getY();
/*  79 */     int cellWidth = mapConfig.cellWidth;
/*  80 */     int cellHeight = mapConfig.cellHeight;
/*  81 */     if (scene.isReachable(mapConfig, x + cellWidth, y - cellHeight))
/*     */     {
/*  83 */       x += cellWidth;
/*  84 */       y -= cellHeight;
/*     */     }
/*  86 */     else if (scene.isReachable(mapConfig, x - cellWidth, y - cellHeight))
/*     */     {
/*  88 */       x -= cellWidth;
/*  89 */       y -= cellHeight;
/*     */     }
/*  91 */     else if (scene.isReachable(mapConfig, x, y - cellHeight))
/*     */     {
/*  93 */       y -= cellHeight;
/*     */     }
/*  95 */     else if (scene.isReachable(mapConfig, x + cellWidth, y))
/*     */     {
/*  97 */       x += cellWidth;
/*     */     }
/*  99 */     else if (scene.isReachable(mapConfig, x - cellWidth, y))
/*     */     {
/* 101 */       x -= cellWidth;
/*     */     }
/* 103 */     role.teleportWithProtocol(x, y, 0, x, y, targetPos.getSceneId(), TransferType.TRANSPOS);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_TeleportTargetMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */