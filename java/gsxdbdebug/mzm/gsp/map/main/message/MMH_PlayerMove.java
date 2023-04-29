/*     */ package mzm.gsp.map.main.message;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.map.Location;
/*     */ import mzm.gsp.map.confbean.SMapConfig;
/*     */ import mzm.gsp.map.event.PlayerUpdateKeyPath;
/*     */ import mzm.gsp.map.main.MapCfgManager;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.WorldInstance;
/*     */ import mzm.gsp.map.main.WorldManager;
/*     */ import mzm.gsp.map.main.proto.Cell;
/*     */ import mzm.gsp.map.main.proto.MapPolygonPrototype;
/*     */ import mzm.gsp.map.main.proto.MapPrototype;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.SceneManager;
/*     */ import mzm.gsp.map.main.scene.TransferType;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class MMH_PlayerMove
/*     */   extends AbstractMapMsgHandler
/*     */ {
/*  26 */   private static final Logger logger = Logger.getLogger(MMH_PlayerMove.class);
/*     */   
/*     */   private final long roleId;
/*     */   private final int mapCfgid;
/*     */   private final List<Location> keyPathList;
/*     */   
/*     */   public MMH_PlayerMove(long roleId, List<Location> keyPathList)
/*     */   {
/*  34 */     this(roleId, -1, keyPathList);
/*     */   }
/*     */   
/*     */   public MMH_PlayerMove(long roleId, int mapCfgid, List<Location> keyPathList)
/*     */   {
/*  39 */     this.roleId = roleId;
/*  40 */     this.mapCfgid = mapCfgid;
/*  41 */     this.keyPathList = keyPathList;
/*     */   }
/*     */   
/*     */ 
/*     */   public void doProcess()
/*     */   {
/*  47 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleId);
/*  48 */     if (role == null)
/*     */     {
/*  50 */       return;
/*     */     }
/*     */     
/*  53 */     if (this.keyPathList.isEmpty())
/*     */     {
/*  55 */       logger.warn(String.format("[map]MMH_PlayerMove.doProcess@key path list is empty from client|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  56 */       return;
/*     */     }
/*     */     
/*     */ 
/*  60 */     if ((this.mapCfgid != -1) && (role.isServerDominateGroup()))
/*     */     {
/*  62 */       return;
/*     */     }
/*     */     
/*     */ 
/*  66 */     Position curPos = role.getPositionForInner();
/*  67 */     if (role.isFollower())
/*     */     {
/*  69 */       return;
/*     */     }
/*  71 */     if (role.isFightState())
/*     */     {
/*  73 */       return;
/*     */     }
/*  75 */     if (role.isState(32))
/*     */     {
/*  77 */       return;
/*     */     }
/*     */     
/*  80 */     if ((role.isInHuSongState()) && (!role.isFlyState()) && (!role.getKeyPointPath().isEmpty()))
/*     */     {
/*  82 */       logger.warn(String.format("[map]MMH_PlayerMove.doProcess@role is in normal husong state and current key point path is not empty|roleid=%d|receive_map_cfgid=%d|cur_sceneid=%d|cur_posx=%d|cur_posy=%d|current_key_point_path=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.mapCfgid), Integer.valueOf(curPos.getSceneId()), Integer.valueOf(curPos.getX()), Integer.valueOf(curPos.getY()), role.getKeyPointPath().toString() }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  88 */     Scene scene = SceneManager.getInstance().getScene(curPos);
/*  89 */     if (scene == null)
/*     */     {
/*     */ 
/*  92 */       Position position = WorldManager.getInstance().getBigWorldInstance().getPosition(this.roleId);
/*  93 */       WorldManager.getInstance().dragTo(this.roleId, position, TransferType.FAULT);
/*     */       
/*  95 */       return;
/*     */     }
/*     */     
/*  98 */     SMapConfig mapConfig = scene.getMapConfig();
/*  99 */     if (mapConfig == null)
/*     */     {
/*     */ 
/* 102 */       Position position = WorldManager.getInstance().getBigWorldInstance().getPosition(this.roleId);
/* 103 */       WorldManager.getInstance().dragTo(this.roleId, position, TransferType.FAULT);
/*     */       
/* 105 */       return;
/*     */     }
/*     */     
/* 108 */     int curMapCfgid = scene.getCfgId();
/* 109 */     if (this.mapCfgid > 0)
/*     */     {
/* 111 */       if (curMapCfgid != this.mapCfgid)
/*     */       {
/* 113 */         logger.warn(String.format("[map]MMH_PlayerMove.doProcess@scene not match|roleid=%d|receive_map_cfgid=%d|cur_mapcfgid=%d|cur_sceneid=%d|cur_posx=%d|cur_posy=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.mapCfgid), Integer.valueOf(curMapCfgid), Integer.valueOf(curPos.getSceneId()), Integer.valueOf(curPos.getX()), Integer.valueOf(curPos.getY()) }));
/*     */         
/*     */ 
/*     */ 
/* 117 */         WorldManager.getInstance().dragTo(this.roleId, curPos, TransferType.FAULT);
/*     */         
/* 119 */         return;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 124 */     Location firstLocation = (Location)this.keyPathList.get(0);
/* 125 */     if ((curPos.getX() == firstLocation.x) && (curPos.getY() == firstLocation.y))
/*     */     {
/* 127 */       this.keyPathList.remove(0);
/* 128 */       if (this.keyPathList.isEmpty())
/*     */       {
/* 130 */         return;
/*     */       }
/*     */     }
/*     */     
/* 134 */     MapPolygonPrototype mapPolygonProto = null;
/* 135 */     if (role.isState(8))
/*     */     {
/* 137 */       Integer refPolygonCfgid = MapPrototype.getContainsPointPolygonCfgid(mapConfig, curPos.getX(), curPos.getY());
/* 138 */       if (refPolygonCfgid != null)
/*     */       {
/* 140 */         mapPolygonProto = MapCfgManager.getInstance().getMapPolygonProtoById(refPolygonCfgid.intValue());
/*     */       }
/*     */     }
/*     */     
/* 144 */     for (Location loc : this.keyPathList)
/*     */     {
/* 146 */       Cell cell = scene.getCell(mapConfig, loc.x, loc.y);
/* 147 */       if (cell == null)
/*     */       {
/* 149 */         logger.warn(String.format("[map]MMH_PlayerMove.doProcess@key path point invalid|roleid=%d|receive_map_cfgid=%d|key_pointx=%d|key_pointy=%d|cur_map_cfgid=%d|cur_sceneid=%d|cur_posx=%d|cur_posy=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.mapCfgid), Integer.valueOf(loc.x), Integer.valueOf(loc.y), Integer.valueOf(curMapCfgid), Integer.valueOf(curPos.getSceneId()), Integer.valueOf(curPos.getX()), Integer.valueOf(curPos.getY()) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 154 */         return;
/*     */       }
/*     */       
/*     */ 
/* 158 */       if (!MapPrototype.isHomelandMap(mapConfig))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 163 */         if ((!role.isFlyState()) && (!cell.isReachable()))
/*     */         {
/* 165 */           logger.warn(String.format("[map]MMH_PlayerMove.doProcess@key path point not reachable|roleid=%d|receive_map_cfgid=%d|key_pointx=%d|key_pointy=%d|cur_map_cfgid=%d|cur_sceneid=%d|cur_posx=%d|cur_posy=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.mapCfgid), Integer.valueOf(loc.x), Integer.valueOf(loc.y), Integer.valueOf(curMapCfgid), Integer.valueOf(curPos.getSceneId()), Integer.valueOf(curPos.getX()), Integer.valueOf(curPos.getY()) }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 170 */           return;
/*     */         }
/*     */         
/* 173 */         if ((mapPolygonProto != null) && (!mapPolygonProto.contains(loc.x, loc.y)))
/*     */         {
/* 175 */           logger.error(String.format("[map]MMH_PlayerMove.doProcess@role limit polygon movement|roleid=%d|receive_map_cfgid=%d|key_pointx=%d|key_pointy=%d|cur_map_cfgid=%d|cur_sceneid=%d|cur_posx=%d|cur_posy=%d|polygon_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.mapCfgid), Integer.valueOf(loc.x), Integer.valueOf(loc.y), Integer.valueOf(curMapCfgid), Integer.valueOf(curPos.getSceneId()), Integer.valueOf(curPos.getX()), Integer.valueOf(curPos.getY()), Integer.valueOf(mapPolygonProto.getTemplateId()) }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 180 */           return;
/*     */         }
/*     */       }
/*     */     }
/* 184 */     role.updateMovePath(this.keyPathList);
/* 185 */     Location targetLoc = (Location)this.keyPathList.get(this.keyPathList.size() - 1);
/* 186 */     role.setTargetPos(targetLoc.x, targetLoc.y, 0);
/*     */     
/*     */ 
/* 189 */     role.setXYZ(curPos.getX(), curPos.getY(), curPos.getZ());
/*     */     
/* 191 */     if (logger.isDebugEnabled())
/*     */     {
/* 193 */       logger.debug(String.format("[map]MMH_PlayerMove.doProcess@move info|roleid=%d|receive_map_cfgid=%d|cur_map_cfgid=%d|cur_sceneid=%d|cur_posx=%d|cur_posy=%d|velocity=%d|husong_state=%b|key_point_path=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.mapCfgid), Integer.valueOf(curMapCfgid), Integer.valueOf(curPos.getSceneId()), Integer.valueOf(curPos.getX()), Integer.valueOf(curPos.getY()), Integer.valueOf(role.getVelocity()), Boolean.valueOf(role.isInHuSongState()), this.keyPathList.toString() }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 200 */     PlayerUpdateKeyPath event = new PlayerUpdateKeyPath();
/* 201 */     TriggerEventsManger.getInstance().triggerEvent(event, Long.valueOf(this.roleId));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_PlayerMove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */