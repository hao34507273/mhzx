/*     */ package mzm.gsp.map.main.scene.object;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.map.Location;
/*     */ import mzm.gsp.map.MapEntityExtraInfo;
/*     */ import mzm.gsp.map.SMapEntityEnterView;
/*     */ import mzm.gsp.map.SMapEntityLeaveView;
/*     */ import mzm.gsp.map.SSyncMapEntityExtraInfoChange;
/*     */ import mzm.gsp.map.SSyncMapEntityInfo;
/*     */ import mzm.gsp.map.SSyncMapEntityMove;
/*     */ import mzm.gsp.map.confbean.SMapConfig;
/*     */ import mzm.gsp.map.main.MapConfiguration;
/*     */ import mzm.gsp.map.main.MapManager;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.message.MapProtocolSendQueue;
/*     */ import mzm.gsp.map.main.proto.Cell;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.SceneManager;
/*     */ import mzm.gsp.map.main.scene.TransferType;
/*     */ import mzm.gsp.map.main.scene.view.CircleView;
/*     */ import mzm.gsp.map.main.scene.view.IView;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xio.Protocol;
/*     */ 
/*     */ public class MapEntity
/*     */   extends SceneObject
/*     */ {
/*     */   protected final MapEntityId objid;
/*     */   protected int cfgid;
/*  40 */   protected Map<Integer, Integer> intExtraInfos = null;
/*  41 */   protected Map<Integer, Long> longExtraInfos = null;
/*  42 */   protected Map<Integer, String> strExtraInfos = null;
/*     */   
/*  44 */   protected long lastTime = 0L;
/*  45 */   protected LinkedList<Location> keyPointPath = new LinkedList();
/*     */   
/*     */ 
/*     */ 
/*     */   public MapEntity(MapEntityType entityType, long instanceid, int bornSceneid, int x, int y, int cfgid, Map<Integer, Integer> intExtraInfoEntries, Map<Integer, Long> longExtraInfoEntries, Map<Integer, String> stringExtraInfoEntries)
/*     */   {
/*  51 */     this.objid = new MapEntityId(entityType, instanceid);
/*     */     
/*  53 */     this.position.setSceneId(bornSceneid);
/*  54 */     this.position.setX(x);
/*  55 */     this.position.setY(y);
/*     */     
/*  57 */     this.cfgid = cfgid;
/*  58 */     if ((intExtraInfoEntries != null) && (!intExtraInfoEntries.isEmpty()))
/*     */     {
/*  60 */       this.intExtraInfos = new HashMap(intExtraInfoEntries);
/*     */     }
/*  62 */     if ((longExtraInfoEntries != null) && (!longExtraInfoEntries.isEmpty()))
/*     */     {
/*  64 */       this.longExtraInfos = new HashMap(longExtraInfoEntries);
/*     */     }
/*  66 */     if ((stringExtraInfoEntries != null) && (!stringExtraInfoEntries.isEmpty()))
/*     */     {
/*  68 */       this.strExtraInfos = new HashMap(stringExtraInfoEntries);
/*     */     }
/*     */     
/*  71 */     if (entityType.isOwnView())
/*     */     {
/*  73 */       this.view = new CircleView(this, MapConfiguration.VIEW_WIDTH);
/*     */     }
/*     */   }
/*     */   
/*     */   public MapEntityType getEntityType()
/*     */   {
/*  79 */     return this.objid.getEntityType();
/*     */   }
/*     */   
/*     */ 
/*     */   public void spawnMe(TransferType type)
/*     */   {
/*  85 */     this.targetPos = new Position(this.position);
/*     */     
/*  87 */     MapObjectInstanceManager.getInstance().addMapEntity(this);
/*     */     
/*  89 */     super.spawnMe(type);
/*     */     
/*  91 */     onEnterScene();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onEnterScene()
/*     */   {
/*  99 */     if (getEntityType().isOwnView())
/*     */     {
/* 101 */       if (this.cell != null)
/*     */       {
/* 103 */         this.cell.onEnter(this);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCfgId()
/*     */   {
/* 115 */     return Integer.valueOf(this.cfgid);
/*     */   }
/*     */   
/*     */ 
/*     */   public MapEntityId getObjectId()
/*     */   {
/* 121 */     return this.objid;
/*     */   }
/*     */   
/*     */   public Long getInstanceid()
/*     */   {
/* 126 */     return Long.valueOf(this.objid.getInstanceid());
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onDestroy()
/*     */   {
/* 132 */     if (getEntityType().isOwnView())
/*     */     {
/* 134 */       if (this.cell != null)
/*     */       {
/* 136 */         this.cell.onRemove(this);
/*     */       }
/*     */     }
/*     */     
/* 140 */     MapObjectInstanceManager.getInstance().removeMapEntity(getEntityType().ordinal(), getInstanceid().longValue());
/*     */   }
/*     */   
/*     */ 
/*     */   public Protocol createEnterView()
/*     */   {
/* 146 */     SMapEntityEnterView enterView = new SMapEntityEnterView();
/* 147 */     enterView.entity_type = getEntityType().ordinal();
/* 148 */     enterView.instanceid = getInstanceid().longValue();
/* 149 */     enterView.cfgid = this.cfgid;
/* 150 */     Position pos = getPositionForInner();
/* 151 */     enterView.locs.add(new Location(pos.getX(), pos.getY()));
/* 152 */     enterView.locs.addAll(this.keyPointPath);
/*     */     
/*     */ 
/* 155 */     boxExtraInfo(enterView.extra_info);
/*     */     
/* 157 */     return enterView;
/*     */   }
/*     */   
/*     */ 
/*     */   public Protocol createLeaveView()
/*     */   {
/* 163 */     SMapEntityLeaveView leaveView = new SMapEntityLeaveView();
/* 164 */     leaveView.entity_type = getEntityType().ordinal();
/* 165 */     leaveView.instanceid = getInstanceid().longValue();
/*     */     
/* 167 */     return leaveView;
/*     */   }
/*     */   
/*     */ 
/*     */   public Protocol createMoveProtocol()
/*     */   {
/* 173 */     if (!getEntityType().canMove())
/*     */     {
/* 175 */       return null;
/*     */     }
/*     */     
/* 178 */     SSyncMapEntityMove mapEntityMove = new SSyncMapEntityMove();
/* 179 */     mapEntityMove.entity_type = getEntityType().ordinal();
/* 180 */     mapEntityMove.instanceid = getInstanceid().longValue();
/* 181 */     Position pos = getPositionForInner();
/* 182 */     mapEntityMove.keypointpath.add(new Location(pos.getX(), pos.getY()));
/* 183 */     mapEntityMove.keypointpath.addAll(this.keyPointPath);
/*     */     
/* 185 */     return mapEntityMove;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int acceptMoveView(SceneObject other, boolean delaySync)
/*     */   {
/* 197 */     return super.acceptMoveView(other, delaySync);
/*     */   }
/*     */   
/*     */   private void tryEnterZone(Scene scene, int x, int y)
/*     */   {
/* 202 */     SMapConfig mapConfig = scene.getMapConfig();
/* 203 */     if (mapConfig == null)
/*     */     {
/* 205 */       return;
/*     */     }
/*     */     
/* 208 */     Cell newCell = scene.getCell(mapConfig, x, y);
/* 209 */     if (newCell == null)
/*     */     {
/* 211 */       return;
/*     */     }
/*     */     
/* 214 */     if (!newCell.equals(this.cell))
/*     */     {
/* 216 */       newCell.onEnter(this);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void setXYZ(int x, int y, int z)
/*     */   {
/* 223 */     if (getEntityType().isOwnView())
/*     */     {
/* 225 */       Scene scene = SceneManager.getInstance().getScene(getSceneId());
/* 226 */       if (scene == null)
/*     */       {
/* 228 */         return;
/*     */       }
/* 230 */       tryEnterZone(scene, x, y);
/*     */       
/* 232 */       super.setXYZ(x, y, z);
/*     */     }
/*     */     else
/*     */     {
/* 236 */       this.direction = direction(x, y, this.targetPos.getX(), this.targetPos.getY());
/* 237 */       this.position.setXYZ(x, y, z);
/* 238 */       this.targetDirty = false;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void update(long time)
/*     */   {
/* 245 */     if (this.keyPointPath.isEmpty())
/*     */     {
/* 247 */       return;
/*     */     }
/*     */     
/* 250 */     long difTime = time - this.lastTime;
/*     */     
/* 252 */     Location nextPos = null;
/* 253 */     nextPos = (Location)this.keyPointPath.peekFirst();
/* 254 */     Location curPos = new Location(this.position.getX(), this.position.getY());
/*     */     
/*     */ 
/* 257 */     nextPos = MapManager.calculatePosition(this.keyPointPath, getVelocity(), curPos, nextPos, difTime);
/*     */     
/* 259 */     if (nextPos != null)
/*     */     {
/* 261 */       setXYZ(nextPos.x, nextPos.y, 0);
/*     */     }
/*     */     
/* 264 */     this.lastTime = time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean changeInfos(int x, int y, int cfgid, Map<Integer, Integer> replaceIntExtraInfoEntries, Map<Integer, Long> replaceLongExtraInfoEntries, Map<Integer, String> replaceStringExtraInfoEntries, Set<Integer> removeExtraInfoKeys)
/*     */   {
/* 289 */     boolean posChanged = (this.position.getX() != x) || (this.position.getY() != y);
/* 290 */     if (posChanged)
/*     */     {
/* 292 */       this.keyPointPath.clear();
/*     */     }
/*     */     
/* 295 */     this.position.setXYZ(x, y, 0);
/* 296 */     this.targetPos.setXYZ(x, y, 0);
/*     */     
/* 298 */     this.cfgid = cfgid;
/*     */     
/* 300 */     if ((replaceIntExtraInfoEntries != null) && (!replaceIntExtraInfoEntries.isEmpty()))
/*     */     {
/* 302 */       if (this.intExtraInfos == null)
/*     */       {
/* 304 */         this.intExtraInfos = new HashMap(replaceIntExtraInfoEntries);
/*     */       }
/*     */       else
/*     */       {
/* 308 */         this.intExtraInfos.putAll(replaceIntExtraInfoEntries);
/*     */       }
/*     */     }
/*     */     
/* 312 */     if ((replaceLongExtraInfoEntries != null) && (!replaceLongExtraInfoEntries.isEmpty()))
/*     */     {
/* 314 */       if (this.longExtraInfos == null)
/*     */       {
/* 316 */         this.longExtraInfos = new HashMap(replaceLongExtraInfoEntries);
/*     */       }
/*     */       else
/*     */       {
/* 320 */         this.longExtraInfos.putAll(replaceLongExtraInfoEntries);
/*     */       }
/*     */     }
/*     */     
/* 324 */     if ((replaceStringExtraInfoEntries != null) && (!replaceStringExtraInfoEntries.isEmpty()))
/*     */     {
/* 326 */       if (this.strExtraInfos == null)
/*     */       {
/* 328 */         this.strExtraInfos = new HashMap(replaceStringExtraInfoEntries.size());
/*     */       }
/* 330 */       for (Map.Entry<Integer, String> entry : replaceStringExtraInfoEntries.entrySet())
/*     */       {
/* 332 */         this.strExtraInfos.put(entry.getKey(), entry.getValue());
/*     */       }
/*     */     }
/*     */     
/* 336 */     if ((removeExtraInfoKeys != null) && (!removeExtraInfoKeys.isEmpty()))
/*     */     {
/* 338 */       for (Integer key : removeExtraInfoKeys)
/*     */       {
/* 340 */         if (((this.intExtraInfos != null) && (this.intExtraInfos.remove(key) != null)) || 
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 345 */           ((this.longExtraInfos != null) && (this.longExtraInfos.remove(key) != null)) || (
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 350 */           (this.strExtraInfos != null) && (this.strExtraInfos.remove(key) != null))) {}
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 357 */     SSyncMapEntityInfo core = new SSyncMapEntityInfo();
/* 358 */     core.entity_type = getEntityType().ordinal();
/* 359 */     core.instanceid = getInstanceid().longValue();
/* 360 */     Position pos = getPositionForInner();
/* 361 */     core.locs.add(new Location(pos.getX(), pos.getY()));
/* 362 */     core.locs.addAll(this.keyPointPath);
/* 363 */     core.cfgid = this.cfgid;
/* 364 */     boxExtraInfo(core.extra_info);
/*     */     
/* 366 */     if (getEntityType().isOwnView())
/*     */     {
/* 368 */       if (posChanged)
/*     */       {
/* 370 */         setXYZ(x, y, 0);
/*     */       }
/*     */       else
/*     */       {
/* 374 */         sendToView(core);
/*     */       }
/*     */       
/*     */     }
/*     */     else {
/* 379 */       broadcast(core);
/*     */     }
/*     */     
/* 382 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean changeExtraInfos(Map<Integer, Integer> replaceIntExtraInfoEntries, Map<Integer, Long> replaceLongExtraInfoEntries, Map<Integer, String> replaceStringExtraInfoEntries, Set<Integer> removeExtraInfoKeys)
/*     */   {
/* 401 */     SSyncMapEntityExtraInfoChange core = new SSyncMapEntityExtraInfoChange();
/* 402 */     core.entity_type = getEntityType().ordinal();
/* 403 */     core.instanceid = getInstanceid().longValue();
/*     */     
/* 405 */     if ((replaceIntExtraInfoEntries != null) && (!replaceIntExtraInfoEntries.isEmpty()))
/*     */     {
/* 407 */       if (this.intExtraInfos == null)
/*     */       {
/* 409 */         this.intExtraInfos = new HashMap(replaceIntExtraInfoEntries);
/*     */       }
/*     */       else
/*     */       {
/* 413 */         this.intExtraInfos.putAll(replaceIntExtraInfoEntries);
/*     */       }
/*     */       
/* 416 */       core.extra_info.int_extra_infos.putAll(replaceIntExtraInfoEntries);
/*     */     }
/*     */     
/* 419 */     if ((replaceLongExtraInfoEntries != null) && (!replaceLongExtraInfoEntries.isEmpty()))
/*     */     {
/* 421 */       if (this.longExtraInfos == null)
/*     */       {
/* 423 */         this.longExtraInfos = new HashMap(replaceLongExtraInfoEntries);
/*     */       }
/*     */       else
/*     */       {
/* 427 */         this.longExtraInfos.putAll(replaceLongExtraInfoEntries);
/*     */       }
/*     */       
/* 430 */       core.extra_info.long_extra_infos.putAll(replaceLongExtraInfoEntries);
/*     */     }
/*     */     
/* 433 */     if ((replaceStringExtraInfoEntries != null) && (!replaceStringExtraInfoEntries.isEmpty()))
/*     */     {
/* 435 */       if (this.strExtraInfos == null)
/*     */       {
/* 437 */         this.strExtraInfos = new HashMap(replaceStringExtraInfoEntries.size());
/*     */       }
/* 439 */       for (Map.Entry<Integer, String> entry : replaceStringExtraInfoEntries.entrySet())
/*     */       {
/* 441 */         this.strExtraInfos.put(entry.getKey(), entry.getValue());
/*     */         
/* 443 */         core.extra_info.string_extra_infos.put(entry.getKey(), Octets.wrap((String)entry.getValue(), "UTF-8"));
/*     */       }
/*     */     }
/*     */     
/* 447 */     if ((removeExtraInfoKeys != null) && (!removeExtraInfoKeys.isEmpty()))
/*     */     {
/* 449 */       for (Integer key : removeExtraInfoKeys)
/*     */       {
/* 451 */         if (((this.intExtraInfos != null) && (this.intExtraInfos.remove(key) != null)) || ((this.longExtraInfos != null) && (this.longExtraInfos.remove(key) != null)) || ((this.strExtraInfos != null) && (this.strExtraInfos.remove(key) != null)))
/*     */         {
/*     */ 
/*     */ 
/* 455 */           core.remove_extra_info_keys.add(key);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 460 */     if (getEntityType().isOwnView())
/*     */     {
/* 462 */       sendToView(core);
/*     */     }
/*     */     else
/*     */     {
/* 466 */       broadcast(core);
/*     */     }
/*     */     
/* 469 */     return true;
/*     */   }
/*     */   
/*     */   protected boolean onChangeCheck(int cfgid, int dir, int sceneid, int x, int y)
/*     */   {
/* 474 */     return true;
/*     */   }
/*     */   
/*     */   public boolean onAddCheck()
/*     */   {
/* 479 */     return true;
/*     */   }
/*     */   
/*     */   public void updateMovePath(List<Location> locationList)
/*     */   {
/* 484 */     this.lastTime = DateTimeUtils.getCurrTimeInMillis();
/* 485 */     this.keyPointPath.clear();
/* 486 */     this.keyPointPath.addAll(locationList);
/*     */   }
/*     */   
/*     */   protected void sendToView(Protocol protocol)
/*     */   {
/* 491 */     if (!getEntityType().isOwnView())
/*     */     {
/* 493 */       return;
/*     */     }
/*     */     
/* 496 */     Collection<MapRole> roles = this.view.getPlayers();
/* 497 */     List<Long> ids = new ArrayList();
/* 498 */     for (MapRole role : roles)
/*     */     {
/* 500 */       ids.add(Long.valueOf(role.getRoleId()));
/*     */     }
/* 502 */     MapProtocolSendQueue.getInstance().sendMulti(ids, protocol);
/*     */   }
/*     */   
/*     */   protected void broadcast(Protocol protocol)
/*     */   {
/* 507 */     Scene scene = SceneManager.getInstance().getScene(getSceneId());
/* 508 */     if (scene == null)
/*     */     {
/* 510 */       return;
/*     */     }
/*     */     
/* 513 */     scene.broadcast(protocol);
/*     */   }
/*     */   
/*     */ 
/*     */   private void boxExtraInfo(MapEntityExtraInfo extraInfo)
/*     */   {
/* 519 */     if ((this.intExtraInfos != null) && (!this.intExtraInfos.isEmpty()))
/*     */     {
/* 521 */       extraInfo.int_extra_infos.putAll(this.intExtraInfos);
/*     */     }
/*     */     
/*     */ 
/* 525 */     if ((this.longExtraInfos != null) && (!this.longExtraInfos.isEmpty()))
/*     */     {
/* 527 */       extraInfo.long_extra_infos.putAll(this.longExtraInfos);
/*     */     }
/*     */     
/*     */ 
/* 531 */     if ((this.strExtraInfos != null) && (!this.strExtraInfos.isEmpty()))
/*     */     {
/* 533 */       for (Map.Entry<Integer, String> entry : this.strExtraInfos.entrySet())
/*     */       {
/* 535 */         extraInfo.string_extra_infos.put(entry.getKey(), Octets.wrap((String)entry.getValue(), "UTF-8"));
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\object\MapEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */