/*      */ package mzm.gsp.map.main.scene.object;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.map.Location;
/*      */ import mzm.gsp.map.MapModelInfo;
/*      */ import mzm.gsp.map.SBroadcastPositionInScene;
/*      */ import mzm.gsp.map.SForceLandRes;
/*      */ import mzm.gsp.map.SMapGroupForceLand;
/*      */ import mzm.gsp.map.SMapGroupInfo;
/*      */ import mzm.gsp.map.SMapTeamInfo;
/*      */ import mzm.gsp.map.SResetRoleModel;
/*      */ import mzm.gsp.map.SRoleEndFight;
/*      */ import mzm.gsp.map.SRoleEnterView;
/*      */ import mzm.gsp.map.SRoleExtraRemoveBrd;
/*      */ import mzm.gsp.map.SRoleExtraUpdateBrd;
/*      */ import mzm.gsp.map.SRoleLeaveView;
/*      */ import mzm.gsp.map.SRoleStartFight;
/*      */ import mzm.gsp.map.SSyncEndHuSong;
/*      */ import mzm.gsp.map.SSyncRoleModelChange;
/*      */ import mzm.gsp.map.SSyncRoleMove;
/*      */ import mzm.gsp.map.SSyncSelfPosChange;
/*      */ import mzm.gsp.map.STeamEndFight;
/*      */ import mzm.gsp.map.STeamForceLandRes;
/*      */ import mzm.gsp.map.STeamStartFight;
/*      */ import mzm.gsp.map.confbean.SMapConfig;
/*      */ import mzm.gsp.map.event.ArraivedAtNPC;
/*      */ import mzm.gsp.map.event.ArraivedAtNPCArg;
/*      */ import mzm.gsp.map.event.FlyLandArg;
/*      */ import mzm.gsp.map.event.FlyLandEvent;
/*      */ import mzm.gsp.map.event.MapRoleDestroyedArg;
/*      */ import mzm.gsp.map.event.MapRoleDestroyedEvent;
/*      */ import mzm.gsp.map.event.MapTransferArg;
/*      */ import mzm.gsp.map.event.PlayerTeleportToLocation;
/*      */ import mzm.gsp.map.event.PlayerTeleportToLocationArg;
/*      */ import mzm.gsp.map.event.PlayerTransferScene;
/*      */ import mzm.gsp.map.main.MapCfgManager;
/*      */ import mzm.gsp.map.main.MapConfiguration;
/*      */ import mzm.gsp.map.main.MapManager;
/*      */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*      */ import mzm.gsp.map.main.PUnsetFlyStatus;
/*      */ import mzm.gsp.map.main.PositionProcedure;
/*      */ import mzm.gsp.map.main.WorldInstance;
/*      */ import mzm.gsp.map.main.WorldManager;
/*      */ import mzm.gsp.map.main.group.MapGroupData;
/*      */ import mzm.gsp.map.main.group.MapGroupManager;
/*      */ import mzm.gsp.map.main.group.MapGroupType;
/*      */ import mzm.gsp.map.main.message.MapProtocolSendQueue;
/*      */ import mzm.gsp.map.main.message.PendingMessageManager;
/*      */ import mzm.gsp.map.main.proto.Cell;
/*      */ import mzm.gsp.map.main.proto.MapPrototype;
/*      */ import mzm.gsp.map.main.scene.Position;
/*      */ import mzm.gsp.map.main.scene.PositionWithExtraInfo;
/*      */ import mzm.gsp.map.main.scene.Scene;
/*      */ import mzm.gsp.map.main.scene.SceneManager;
/*      */ import mzm.gsp.map.main.scene.TransferType;
/*      */ import mzm.gsp.map.main.scene.UnModifyPosition;
/*      */ import mzm.gsp.map.main.scene.UnModifyPositionWithExtraInfo;
/*      */ import mzm.gsp.map.main.scene.view.CircleView;
/*      */ import mzm.gsp.map.main.scene.view.IView;
/*      */ import mzm.gsp.map.main.team.MapTeamData;
/*      */ import mzm.gsp.map.main.team.MapTeamManager;
/*      */ import mzm.gsp.pubdata.ModelInfo;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.task.main.TaskInterface.TaskState;
/*      */ import mzm.gsp.util.LogicProcedure;
/*      */ import org.apache.log4j.Logger;
/*      */ import xio.Protocol;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class MapRole
/*      */   extends SceneObject
/*      */ {
/*   88 */   private static final Logger logger = Logger.getLogger(MapRole.class);
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private final MapRoleId objid;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*   98 */   private boolean isInSafeZone = false;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private int dyeColorId;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private long deltaTime;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private long lastTraceTime;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private int moveDistance;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private int level;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private int menPai;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private int gender;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*  138 */   private volatile long teamId = -1L;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*  143 */   private MapGroupType groupType = MapGroupType.UNKNOWN;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*  148 */   private long groupid = -1L;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*  153 */   private int groupSpeed = -1;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private int mountsSpeed;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private int flySpeed;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*  168 */   private int speedFixAdded = 0;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*  173 */   private int speedPercentAdded = 0;
/*      */   
/*  175 */   private Map<SceneObjectId, SceneObject> invisibleObjectQueue = new HashMap();
/*      */   
/*  177 */   private Set<SceneObjectId> canSeeKeySet = new HashSet();
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private volatile Map<Integer, TaskInterface.TaskState> roleTaskStateMap;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*  187 */   private MapModelInfo roleModelInfo = new MapModelInfo();
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private OctetsStream roleModelInfoCache;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   protected MapModelInfo petModelInfo;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   protected OctetsStream petModelInfoCache;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   protected MapModelInfo childrenModelInfo;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   protected OctetsStream childrenModelInfoCache;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*  217 */   private boolean xunLuoState = false;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*  222 */   private boolean husongState = false;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*  227 */   private LinkedList<Position> husongKeyPointList = new LinkedList();
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private int husongTargetNpcId;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*  237 */   private LinkedList<Location> keyPointPath = new LinkedList();
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*  242 */   private int channelid = Integer.MAX_VALUE;
/*      */   
/*      */   public MapRole(long roleId, MapRoleInitInfo mapRoleInitInfo)
/*      */   {
/*  246 */     this.view = new CircleView(this, MapConfiguration.VIEW_WIDTH);
/*      */     
/*  248 */     this.objid = new MapRoleId(roleId);
/*      */     
/*  250 */     this.velocity = mapRoleInitInfo.velocity;
/*  251 */     this.modelId = mapRoleInitInfo.modelId;
/*  252 */     this.name = mapRoleInitInfo.name;
/*  253 */     this.dyeColorId = mapRoleInitInfo.dyeColorId;
/*  254 */     this.level = mapRoleInitInfo.level;
/*  255 */     this.menPai = mapRoleInitInfo.menPai;
/*  256 */     this.gender = mapRoleInitInfo.gender;
/*      */     
/*  258 */     Scene scene = null;
/*  259 */     WorldInstance instance = WorldManager.getInstance().getRoleWorldInstanceFromStack(roleId);
/*  260 */     if (instance != null)
/*      */     {
/*  262 */       this.position = new Position(instance.getPosition(roleId));
/*  263 */       scene = SceneManager.getInstance().getScene(this.position);
/*      */     }
/*      */     
/*      */ 
/*  267 */     if (scene == null)
/*      */     {
/*  269 */       this.position = mapRoleInitInfo.position;
/*  270 */       scene = SceneManager.getInstance().getScene(this.position);
/*      */     }
/*      */     
/*  273 */     if (scene == null)
/*      */     {
/*      */ 
/*  276 */       this.position = new Position(mapRoleInitInfo.defaultBornX, mapRoleInitInfo.defaultBornY, 0, mapRoleInitInfo.defaultBornMapid);
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/*  281 */       SMapConfig mapConfig = scene.getMapConfig();
/*  282 */       if (mapConfig == null)
/*      */       {
/*      */ 
/*  285 */         this.position = new Position(mapRoleInitInfo.defaultBornX, mapRoleInitInfo.defaultBornY, 0, mapRoleInitInfo.defaultBornMapid);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       }
/*  291 */       else if (!scene.isReachable(mapConfig, this.position.getX(), this.position.getY()))
/*      */       {
/*  293 */         this.position = new Position(mapConfig.defaultTransPosX, mapConfig.defaultTransPosY, 0, scene.getId());
/*      */       }
/*      */     }
/*      */     
/*  297 */     this.targetPos = new Position(this.position);
/*      */     
/*      */ 
/*  300 */     this.roleModelInfo = mapRoleInitInfo.roleModelInfo;
/*      */     
/*      */ 
/*  303 */     this.roleTaskStateMap = mapRoleInitInfo.taskStateMap;
/*      */     
/*      */ 
/*  306 */     this.petModelInfo = mapRoleInitInfo.petModelInfo;
/*      */     
/*      */ 
/*  309 */     this.childrenModelInfo = mapRoleInitInfo.childrenModelInfo;
/*      */     
/*      */ 
/*  312 */     this.mountsSpeed = mapRoleInitInfo.mountsSpeed;
/*      */     
/*      */ 
/*  315 */     this.flySpeed = mapRoleInitInfo.flySpeed;
/*      */     
/*  317 */     if (mapRoleInitInfo.roleStatusSet != null)
/*      */     {
/*  319 */       if (mapRoleInitInfo.roleStatusSet.contains(Integer.valueOf(97)))
/*      */       {
/*  321 */         setState(32);
/*      */       }
/*      */     }
/*      */     
/*  325 */     updateWorldTempApp();
/*      */     
/*  327 */     updateRoleModelCache();
/*      */     
/*  329 */     updatePetModelCache();
/*      */     
/*  331 */     updateChildrenModelCache();
/*      */     
/*  333 */     PendingMessageManager.getRolePendingMessageManager().redoPendingMessages(Long.valueOf(roleId));
/*      */   }
/*      */   
/*      */   public void onRoleSwitchOccupation(MapRoleInitInfo mapRoleInitInfo)
/*      */   {
/*  338 */     this.velocity = mapRoleInitInfo.velocity;
/*  339 */     this.modelId = mapRoleInitInfo.modelId;
/*  340 */     this.name = mapRoleInitInfo.name;
/*  341 */     this.dyeColorId = mapRoleInitInfo.dyeColorId;
/*  342 */     this.level = mapRoleInitInfo.level;
/*  343 */     this.menPai = mapRoleInitInfo.menPai;
/*  344 */     this.gender = mapRoleInitInfo.gender;
/*      */     
/*      */ 
/*  347 */     this.roleModelInfo = mapRoleInitInfo.roleModelInfo;
/*      */     
/*      */ 
/*  350 */     this.roleTaskStateMap = mapRoleInitInfo.taskStateMap;
/*      */     
/*      */ 
/*  353 */     this.petModelInfo = mapRoleInitInfo.petModelInfo;
/*      */     
/*      */ 
/*  356 */     this.mountsSpeed = mapRoleInitInfo.mountsSpeed;
/*      */     
/*      */ 
/*  359 */     this.flySpeed = mapRoleInitInfo.flySpeed;
/*      */     
/*  361 */     updateWorldTempApp();
/*      */     
/*  363 */     updateRoleModelCache();
/*      */     
/*  365 */     updateChildrenModelCache();
/*      */     
/*  367 */     notifyResetRoleModel();
/*      */   }
/*      */   
/*      */ 
/*      */   private void notifyResetRoleModel()
/*      */   {
/*  373 */     SResetRoleModel resetRoleModel = new SResetRoleModel();
/*  374 */     resetRoleModel.modelinfo = this.roleModelInfoCache;
/*  375 */     resetRoleModel.gender = this.gender;
/*  376 */     resetRoleModel.menpai = this.menPai;
/*  377 */     broadcastProtocol(resetRoleModel);
/*      */   }
/*      */   
/*      */ 
/*      */   public void setName(String name)
/*      */   {
/*  383 */     super.setName(name);
/*      */     
/*  385 */     this.roleModelInfo.string_props.put(Integer.valueOf(0), name);
/*      */     
/*  387 */     updateRoleModelCache();
/*      */   }
/*      */   
/*      */   public void updateRoleModelCache()
/*      */   {
/*  392 */     this.roleModelInfoCache = new OctetsStream();
/*  393 */     this.roleModelInfo.marshal(this.roleModelInfoCache);
/*      */   }
/*      */   
/*      */   public void updatePetModelCache()
/*      */   {
/*  398 */     if (this.petModelInfo == null)
/*      */     {
/*  400 */       this.petModelInfoCache = null;
/*  401 */       return;
/*      */     }
/*      */     
/*  404 */     this.petModelInfoCache = new OctetsStream();
/*  405 */     this.petModelInfo.marshal(this.petModelInfoCache);
/*      */   }
/*      */   
/*      */   public void updateChildrenModelCache()
/*      */   {
/*  410 */     if (this.childrenModelInfo == null)
/*      */     {
/*  412 */       this.childrenModelInfoCache = null;
/*  413 */       return;
/*      */     }
/*      */     
/*  416 */     this.childrenModelInfoCache = new OctetsStream();
/*  417 */     this.childrenModelInfo.marshal(this.childrenModelInfoCache);
/*      */   }
/*      */   
/*      */   public void spawnMe()
/*      */   {
/*  422 */     spawnMe(this.position.getX(), this.position.getY(), this.position.getZ(), this.position.getSceneId(), getChannelid(), TransferType.LOGIN);
/*      */     
/*      */ 
/*  425 */     onEnterScene();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void reSyncAllView()
/*      */   {
/*  433 */     this.canSeeKeySet.clear();
/*      */     
/*      */ 
/*  436 */     for (SceneObject object : this.view.getSceneObjects())
/*      */     {
/*  438 */       acceptEnterView(object, false);
/*      */     }
/*      */     
/*  441 */     Set<Long> roleids = new HashSet();
/*  442 */     MapTeamData teamData = MapTeamManager.getInstance().getTeamById(this.teamId);
/*  443 */     if (teamData != null)
/*      */     {
/*  445 */       roleids.add(Long.valueOf(teamData.getLeaderId()));
/*  446 */       roleids.addAll(teamData.getInTeamMember());
/*      */     }
/*  448 */     MapGroupData mapGroupData = MapGroupManager.getInstance().getMapGroupData(this.groupType, this.groupid);
/*  449 */     if (mapGroupData != null)
/*      */     {
/*  451 */       roleids.add(Long.valueOf(mapGroupData.getLeaderid()));
/*  452 */       roleids.addAll(mapGroupData.getOtherMemebersForInner());
/*      */     }
/*  454 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/*  456 */       MapRole mapRole = MapObjectInstanceManager.getInstance().getMapRole(roleid);
/*  457 */       if ((mapRole != null) && (mapRole != this))
/*      */       {
/*  459 */         Protocol core = mapRole.buildRoleEnterView();
/*  460 */         sendMapProtocol(core);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  465 */     for (MapRole role : this.view.getPlayers())
/*      */     {
/*  467 */       if ((roleids.isEmpty()) || (!roleids.contains(Long.valueOf(role.getRoleId()))))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  472 */         acceptEnterView(role, false);
/*      */         
/*      */ 
/*  475 */         if (role.isSameGroup(this))
/*      */         {
/*  477 */           Protocol core = role.buildRoleEnterView();
/*  478 */           sendMapProtocol(core);
/*      */         }
/*      */       }
/*      */     }
/*  482 */     if (teamData != null)
/*      */     {
/*  484 */       SMapTeamInfo teamInfo = teamData.buildTeamInfo();
/*  485 */       sendMapProtocol(teamInfo);
/*      */     }
/*      */     
/*  488 */     if (mapGroupData != null)
/*      */     {
/*  490 */       SMapGroupInfo groupInfo = mapGroupData.createGroupInfoProtocol(this.groupType, this.groupid, this.groupSpeed);
/*  491 */       sendMapProtocol(groupInfo);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean isFlyState()
/*      */   {
/*  497 */     return this.flySpeed > 0;
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean canMeetMonster()
/*      */   {
/*  503 */     if (this.husongState)
/*      */     {
/*  505 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  509 */     if (isFlyState())
/*      */     {
/*  511 */       return false;
/*      */     }
/*      */     
/*  514 */     MapGroupData mapGroupData = MapGroupManager.getInstance().getMapGroupData(this.groupType, this.groupid);
/*  515 */     if (mapGroupData != null)
/*      */     {
/*  517 */       if ((this.groupType == MapGroupType.MGT_MARRIAGE) || (this.groupType == MapGroupType.MGT_MARRIAGE))
/*      */       {
/*      */ 
/*  520 */         return false;
/*      */       }
/*      */     }
/*  523 */     return true;
/*      */   }
/*      */   
/*      */   public List<Location> getKeyPointPath()
/*      */   {
/*  528 */     return this.keyPointPath;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void onEnterScene()
/*      */   {
/*  536 */     if (this.cell != null)
/*      */     {
/*  538 */       this.cell.onEnter(this);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onRoleFashionDressModelChange(int fashionDressCfgid, int hairId, int clothId)
/*      */   {
/*  544 */     updateRoleColor(fashionDressCfgid, hairId, clothId);
/*      */     
/*  546 */     SSyncRoleModelChange syncRoleModelChange = new SSyncRoleModelChange();
/*  547 */     syncRoleModelChange.roleid = getRoleId();
/*  548 */     syncRoleModelChange.intpropmap.put(Integer.valueOf(24), Integer.valueOf(fashionDressCfgid));
/*  549 */     syncRoleModelChange.intpropmap.put(Integer.valueOf(16), Integer.valueOf(hairId));
/*  550 */     syncRoleModelChange.intpropmap.put(Integer.valueOf(17), Integer.valueOf(clothId));
/*      */     
/*  552 */     broadcastProtocolIncludeSelf(syncRoleModelChange);
/*      */   }
/*      */   
/*      */   private void updateRoleColor(int fashionDressCfgid, int hairId, int clothId)
/*      */   {
/*  557 */     this.roleModelInfo.model.extramap.put(Integer.valueOf(14), Integer.valueOf(fashionDressCfgid));
/*  558 */     this.roleModelInfo.model.extramap.put(Integer.valueOf(7), Integer.valueOf(hairId));
/*  559 */     this.roleModelInfo.model.extramap.put(Integer.valueOf(8), Integer.valueOf(clothId));
/*      */     
/*  561 */     updateRoleModelCache();
/*      */   }
/*      */   
/*      */   public void onRoleColorChange(int hairId, int clothId)
/*      */   {
/*  566 */     updateRoleColor(hairId, clothId);
/*      */     
/*  568 */     SSyncRoleModelChange syncRoleModelChange = new SSyncRoleModelChange();
/*  569 */     syncRoleModelChange.roleid = getRoleId();
/*  570 */     syncRoleModelChange.intpropmap.put(Integer.valueOf(16), Integer.valueOf(hairId));
/*  571 */     syncRoleModelChange.intpropmap.put(Integer.valueOf(17), Integer.valueOf(clothId));
/*  572 */     broadcastProtocolIncludeSelf(syncRoleModelChange);
/*      */   }
/*      */   
/*      */   private void updateRoleColor(int hairId, int clothId)
/*      */   {
/*  577 */     this.roleModelInfo.model.extramap.put(Integer.valueOf(7), Integer.valueOf(hairId));
/*  578 */     this.roleModelInfo.model.extramap.put(Integer.valueOf(8), Integer.valueOf(clothId));
/*      */     
/*  580 */     updateRoleModelCache();
/*      */   }
/*      */   
/*      */   public void onRoleExteriorChange(boolean isOnline, int exteriorid)
/*      */   {
/*  585 */     if (((this.groupType == MapGroupType.MGT_MARRIAGE) || (this.groupType == MapGroupType.MGT_GROUP_WEDDING)) && (exteriorid < 1) && (!isOnline))
/*      */     {
/*      */ 
/*  588 */       setState(2);
/*  589 */       return;
/*      */     }
/*  591 */     unsetState(2);
/*      */     
/*  593 */     updateRoleExterior(exteriorid);
/*      */     
/*  595 */     syncRoleExteriorChange(exteriorid);
/*      */   }
/*      */   
/*      */   public void delayUpdateRoleExterior()
/*      */   {
/*  600 */     if (!isState(2))
/*      */     {
/*  602 */       return;
/*      */     }
/*  604 */     unsetState(2);
/*      */     
/*  606 */     updateRoleExterior(-1);
/*      */     
/*  608 */     syncRoleExteriorChange(-1);
/*      */   }
/*      */   
/*      */   private void updateRoleExterior(int exteriorid)
/*      */   {
/*  613 */     this.roleModelInfo.model.extramap.put(Integer.valueOf(13), Integer.valueOf(exteriorid));
/*      */     
/*  615 */     updateRoleModelCache();
/*      */   }
/*      */   
/*      */   private void syncRoleExteriorChange(int exteriorid)
/*      */   {
/*  620 */     SSyncRoleModelChange syncRoleModelChange = new SSyncRoleModelChange();
/*  621 */     syncRoleModelChange.roleid = getRoleId();
/*  622 */     syncRoleModelChange.intpropmap.put(Integer.valueOf(21), Integer.valueOf(exteriorid));
/*  623 */     broadcastProtocolIncludeSelf(syncRoleModelChange);
/*      */   }
/*      */   
/*      */ 
/*      */   public MapRoleId getObjectId()
/*      */   {
/*  629 */     return this.objid;
/*      */   }
/*      */   
/*      */   public final long getRoleId()
/*      */   {
/*  634 */     return this.objid.getId().longValue();
/*      */   }
/*      */   
/*      */   public void tryEnterZone()
/*      */   {
/*  639 */     Scene scene = SceneManager.getInstance().getScene(getSceneId());
/*  640 */     if (scene == null)
/*      */     {
/*  642 */       return;
/*      */     }
/*      */     
/*  645 */     tryEnterZone(scene, this.position.getX(), this.position.getY(), true);
/*      */   }
/*      */   
/*      */   private void tryEnterZone(Scene scene, int x, int y, boolean ignoreCheckCell)
/*      */   {
/*  650 */     SMapConfig mapConfig = scene.getMapConfig();
/*  651 */     if (mapConfig == null)
/*      */     {
/*  653 */       return;
/*      */     }
/*      */     
/*  656 */     Cell newCell = scene.getCell(mapConfig, x, y);
/*  657 */     if (newCell == null)
/*      */     {
/*  659 */       return;
/*      */     }
/*      */     
/*  662 */     if ((ignoreCheckCell) || (!newCell.equals(this.cell)))
/*      */     {
/*  664 */       newCell.onEnter(this);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public void setXYZ(int x, int y, int z)
/*      */   {
/*  671 */     boolean isDirty = isTargetDirty();
/*  672 */     Scene scene = SceneManager.getInstance().getScene(getSceneId());
/*  673 */     if (scene == null)
/*      */     {
/*  675 */       return;
/*      */     }
/*  677 */     tryEnterZone(scene, x, y, false);
/*      */     
/*  679 */     super.setXYZ(x, y, z);
/*      */     
/*  681 */     long roleId = getRoleId();
/*  682 */     scene.onRoleMove(roleId, x, y, z);
/*      */     
/*  684 */     MapTeamData teamData = MapTeamManager.getInstance().getTeamById(this.teamId);
/*  685 */     if (teamData != null)
/*      */     {
/*  687 */       teamData.setXYZ(this, x, y, z, isDirty);
/*      */     }
/*      */     
/*  690 */     MapGroupData mapGroupData = MapGroupManager.getInstance().getMapGroupData(this.groupType, this.groupid);
/*  691 */     if (mapGroupData != null)
/*      */     {
/*  693 */       mapGroupData.setXYZ(this, x, y, z, isDirty);
/*      */     }
/*      */     
/*  696 */     if (isState(16))
/*      */     {
/*  698 */       SBroadcastPositionInScene core = new SBroadcastPositionInScene();
/*  699 */       core.roleid = roleId;
/*  700 */       core.pos.x = x;
/*  701 */       core.pos.y = y;
/*  702 */       scene.broadcast(core);
/*      */     }
/*      */   }
/*      */   
/*      */   public void follow(int x, int y, int z, int sceneId, int channelid)
/*      */   {
/*  708 */     Scene scene = SceneManager.getInstance().getScene(sceneId);
/*  709 */     if (scene == null)
/*      */     {
/*      */ 
/*  712 */       return;
/*      */     }
/*      */     
/*  715 */     long roleId = getRoleId();
/*  716 */     Scene oldScene = SceneManager.getInstance().getScene(this.position);
/*  717 */     this.position.setSceneId(sceneId);
/*  718 */     this.position.setXYZ(x, y, z);
/*  719 */     if (oldScene != null)
/*      */     {
/*  721 */       if ((oldScene != scene) || (getChannelid() != channelid))
/*      */       {
/*  723 */         oldScene.removeRole(this);
/*  724 */         scene.addSceneObject(this, channelid, TransferType.TRANSPOS);
/*      */       }
/*      */       
/*  727 */       if (oldScene.getWorld() != scene.getWorld())
/*      */       {
/*  729 */         oldScene.getWorld().onRoleLeave(roleId);
/*  730 */         WorldManager.getInstance().checkTopStack(roleId, scene.getWorld().getId());
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/*  735 */       scene.addSceneObject(this, channelid, TransferType.TRANSPOS);
/*  736 */       WorldManager.getInstance().checkTopStack(roleId, scene.getWorld().getId());
/*      */     }
/*      */     
/*  739 */     super.setXYZ(x, y, z);
/*      */     
/*  741 */     scene.onRoleMove(roleId, x, y, z);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean teleportWithProtocol(int x, int y, int z, int targetX, int targetY, int sceneId, int channelid, TransferType type)
/*      */   {
/*  759 */     Scene scene = SceneManager.getInstance().getScene(sceneId);
/*  760 */     if (scene == null)
/*      */     {
/*  762 */       return false;
/*      */     }
/*      */     
/*  765 */     if ((type != TransferType.ENTER_HOME) && (scene.isHomelandMap()))
/*      */     {
/*  767 */       Scene currScene = SceneManager.getInstance().getScene(getSceneId());
/*  768 */       if ((currScene != null) && (currScene.getWorld() != scene.getWorld()))
/*      */       {
/*  770 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  774 */     long roleId = getRoleId();
/*  775 */     MapTeamData teamData = MapTeamManager.getInstance().getTeamById(this.teamId);
/*  776 */     if (teamData != null)
/*      */     {
/*  778 */       return teamData.teamTeleportWithProtocol(roleId, x, y, z, targetX, targetY, sceneId, channelid, type);
/*      */     }
/*      */     
/*  781 */     MapGroupData mapGroupData = MapGroupManager.getInstance().getMapGroupData(this.groupType, this.groupid);
/*  782 */     if (mapGroupData != null)
/*      */     {
/*  784 */       return mapGroupData.groupTeleportWithProtocol(roleId, x, y, z, targetX, targetY, sceneId, channelid, type);
/*      */     }
/*      */     
/*  787 */     if (!isCanTransfer(sceneId, type))
/*      */     {
/*  789 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  793 */     SSyncSelfPosChange change = new SSyncSelfPosChange();
/*  794 */     change.direction = getDirection();
/*  795 */     change.mapid = scene.getCfgId();
/*  796 */     change.pos.x = x;
/*  797 */     change.pos.y = y;
/*  798 */     change.mapinstanceid = sceneId;
/*  799 */     change.targetpos.x = targetX;
/*  800 */     change.targetpos.y = targetY;
/*  801 */     MapProtocolSendQueue.getInstance().send(roleId, change);
/*      */     
/*  803 */     this.targetPos.setXYZ(targetX, targetY, this.targetPos.getZ());
/*      */     
/*      */ 
/*  806 */     if (!teleToLocation(x, y, z, sceneId, channelid, type))
/*      */     {
/*  808 */       return false;
/*      */     }
/*      */     
/*  811 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean teleportWithProtocol(int x, int y, int z, int targetX, int targetY, int sceneId, TransferType type)
/*      */   {
/*  817 */     return teleportWithProtocol(x, y, z, targetX, targetY, sceneId, Integer.MAX_VALUE, type);
/*      */   }
/*      */   
/*      */   public boolean isXunLuoState()
/*      */   {
/*  822 */     return this.xunLuoState;
/*      */   }
/*      */   
/*      */   public void setXunLuoState(boolean xunLuState)
/*      */   {
/*  827 */     this.xunLuoState = xunLuState;
/*      */   }
/*      */   
/*      */   public boolean isCanTransfer(int sceneId, TransferType type)
/*      */   {
/*  832 */     if (isXunLuoState())
/*      */     {
/*  834 */       return false;
/*      */     }
/*      */     
/*  837 */     if (isServerDominateGroup())
/*      */     {
/*  839 */       return false;
/*      */     }
/*      */     
/*  842 */     if ((isInHuSongState()) && (type != TransferType.ZONE_TRANSFER))
/*      */     {
/*  844 */       return false;
/*      */     }
/*      */     
/*  847 */     Scene newScene = SceneManager.getInstance().getScene(sceneId);
/*  848 */     if (newScene == null)
/*      */     {
/*  850 */       return false;
/*      */     }
/*      */     
/*  853 */     if ((type == TransferType.FORCE_TRANSFER) || (type == TransferType.FAULT))
/*      */     {
/*  855 */       return true;
/*      */     }
/*      */     
/*  858 */     if (isFightState())
/*      */     {
/*  860 */       return false;
/*      */     }
/*      */     
/*  863 */     return true;
/*      */   }
/*      */   
/*      */   public boolean canJoinTeamOrGroup(MapRole leaderRole)
/*      */   {
/*  868 */     return canJoinTeamOrGroup(leaderRole, this);
/*      */   }
/*      */   
/*      */   public static boolean canJoinTeamOrGroup(MapRole leaderRole, MapRole memberRole)
/*      */   {
/*  873 */     Scene leaderScene = SceneManager.getInstance().getScene(leaderRole.getSceneId());
/*  874 */     if ((leaderScene != null) && (leaderScene.isHomelandMap()))
/*      */     {
/*  876 */       Scene memberScene = SceneManager.getInstance().getScene(memberRole.getSceneId());
/*  877 */       if ((memberScene != null) && (leaderScene.getWorld() != memberScene.getWorld()))
/*      */       {
/*  879 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  883 */     return true;
/*      */   }
/*      */   
/*      */   public void updateMovePath(List<Location> locationList)
/*      */   {
/*  888 */     this.keyPointPath.clear();
/*  889 */     this.keyPointPath.addAll(locationList);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean teleToLocation(int x, int y, int z, int sceneId, TransferType type)
/*      */   {
/*  903 */     return teleToLocation(x, y, z, sceneId, Integer.MAX_VALUE, type);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean teleToLocation(int x, int y, int z, int sceneId, int channelid, TransferType type)
/*      */   {
/*  910 */     setTeleporting(true);
/*      */     
/*  912 */     long roleId = getRoleId();
/*      */     
/*      */     try
/*      */     {
/*  916 */       this.keyPointPath.clear();
/*  917 */       this.moveDistance = 0;
/*      */       
/*  919 */       Set<Long> roleids = new HashSet();
/*  920 */       roleids.add(Long.valueOf(roleId));
/*  921 */       MapTeamData teamData = MapTeamManager.getInstance().getTeamById(this.teamId);
/*  922 */       MapGroupData mapGroupData = MapGroupManager.getInstance().getMapGroupData(this.groupType, this.groupid);
/*  923 */       if (teamData != null)
/*      */       {
/*  925 */         roleids.addAll(teamData.getInTeamMember());
/*      */       }
/*  927 */       if (mapGroupData != null)
/*      */       {
/*  929 */         roleids.addAll(mapGroupData.getOtherMemebersForInner());
/*      */       }
/*      */       
/*  932 */       MapTransferArg arg = null;
/*      */       
/*  934 */       Scene newScene = SceneManager.getInstance().getScene(sceneId);
/*  935 */       WorldInstance newWorldInstance = newScene.getWorld();
/*  936 */       Scene oldScene = SceneManager.getInstance().getScene(this.position);
/*  937 */       boolean needRemoveRoleFromView = true;
/*  938 */       if ((oldScene == newScene) && (getChannelid() == channelid) && ((type == TransferType.TEAM) || (type == TransferType.COUPLE_FLY)) && (MapManager.getDistance(this.position.getX(), this.position.getY(), x, y) < getView().getRadius()))
/*      */       {
/*      */ 
/*      */ 
/*  942 */         needRemoveRoleFromView = false;
/*      */       }
/*  944 */       if (needRemoveRoleFromView)
/*      */       {
/*  946 */         arg = new MapTransferArg();
/*  947 */         arg.roleList.addAll(roleids);
/*  948 */         arg.newMapCfgId = newScene.getCfgId();
/*  949 */         arg.newWorldId = newWorldInstance.getId();
/*      */         
/*  951 */         this.position.setSceneId(sceneId);
/*  952 */         this.position.setXYZ(x, y, z);
/*      */         
/*  954 */         if (oldScene != null)
/*      */         {
/*  956 */           WorldInstance oldWorldInstance = oldScene.getWorld();
/*      */           
/*  958 */           arg.oldMapCfgId = oldScene.getCfgId();
/*  959 */           arg.oldWorldId = oldWorldInstance.getId();
/*      */           
/*  961 */           oldScene.removeRole(this);
/*      */           
/*  963 */           if (newWorldInstance != oldWorldInstance)
/*      */           {
/*  965 */             oldWorldInstance.onRoleLeave(roleId);
/*      */           }
/*      */         }
/*      */         
/*  969 */         newScene.addSceneObject(this, channelid, type);
/*      */         
/*  971 */         WorldManager.getInstance().checkTopStack(roleId, newWorldInstance.getId());
/*      */       }
/*      */       
/*  974 */       setXYZ(x, y, z);
/*      */       
/*  976 */       if (arg != null)
/*      */       {
/*  978 */         TriggerEventsManger.getInstance().triggerEventAtOnce(new PlayerTransferScene(), arg);
/*      */       }
/*      */       
/*  981 */       int mapcfgid = newScene.getCfgId();
/*  982 */       MapPrototype mapConf = MapCfgManager.getInstance().getMapProtoById(mapcfgid);
/*  983 */       if (mapConf == null)
/*      */       {
/*  985 */         GameServer.logger().error(String.format("[map]MapRole.teleToLocation@map config is not exist|roleid=%d|configid=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(mapcfgid) }));
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*      */ 
/*  991 */         if (!mapConf.canFly())
/*      */         {
/*  993 */           unSetFlyState();
/*      */           
/*      */ 
/*  996 */           if (this.teamId > 0L)
/*      */           {
/*  998 */             STeamForceLandRes teamForceLandRes = new STeamForceLandRes();
/*  999 */             teamForceLandRes.teamid = this.teamId;
/* 1000 */             broadcastProtocolIncludeSelf(teamForceLandRes);
/*      */           }
/* 1002 */           else if ((this.groupType != MapGroupType.UNKNOWN) && (this.groupid > 0L))
/*      */           {
/* 1004 */             SMapGroupForceLand mapGroupForceLand = new SMapGroupForceLand();
/* 1005 */             mapGroupForceLand.group_type = this.groupType.ordinal();
/* 1006 */             mapGroupForceLand.groupid = this.groupid;
/* 1007 */             broadcastProtocolIncludeSelf(mapGroupForceLand);
/*      */           }
/*      */           else
/*      */           {
/* 1011 */             SForceLandRes forceLandRes = new SForceLandRes();
/* 1012 */             forceLandRes.roleid = roleId;
/* 1013 */             broadcastProtocolIncludeSelf(forceLandRes);
/*      */           }
/*      */         }
/*      */         
/*      */ 
/* 1018 */         PlayerTeleportToLocationArg playerTeleportToLocationArg = new PlayerTeleportToLocationArg();
/* 1019 */         playerTeleportToLocationArg.roleList.addAll(roleids);
/* 1020 */         TriggerEventsManger.getInstance().triggerEventAtOnce(new PlayerTeleportToLocation(), playerTeleportToLocationArg);
/*      */       }
/*      */       
/*      */     }
/*      */     finally
/*      */     {
/* 1026 */       setTeleporting(false);
/*      */     }
/*      */     
/* 1029 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean teleportToDefaultPosWithProtocol(int sceneId, int targetX, int targetY, int channelid, TransferType type)
/*      */   {
/* 1044 */     Scene scene = SceneManager.getInstance().getScene(sceneId);
/* 1045 */     if (scene == null)
/*      */     {
/* 1047 */       return false;
/*      */     }
/*      */     
/* 1050 */     SMapConfig mapConfig = scene.getMapConfig();
/* 1051 */     if (mapConfig == null)
/*      */     {
/* 1053 */       return false;
/*      */     }
/*      */     
/* 1056 */     return teleportWithProtocol(mapConfig.defaultTransPosX, mapConfig.defaultTransPosY, getTargetPosForInner().getZ(), targetX, targetY, sceneId, channelid, type);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean teleportToDefaultPosAndTargetWithProtocol(int sceneId, int channelid, TransferType type)
/*      */   {
/* 1070 */     Scene scene = SceneManager.getInstance().getScene(sceneId);
/* 1071 */     if (scene == null)
/*      */     {
/* 1073 */       return false;
/*      */     }
/*      */     
/* 1076 */     SMapConfig mapConfig = scene.getMapConfig();
/* 1077 */     if (mapConfig == null)
/*      */     {
/* 1079 */       return false;
/*      */     }
/*      */     
/* 1082 */     return teleportWithProtocol(mapConfig.defaultTransPosX, mapConfig.defaultTransPosY, getTargetPosForInner().getZ(), mapConfig.defaultTransPosX, mapConfig.defaultTransPosY, sceneId, channelid, type);
/*      */   }
/*      */   
/*      */ 
/*      */   public Collection<Long> getPlayersInMyView(boolean includeSelf)
/*      */   {
/* 1088 */     Collection<MapRole> mapRoles = getView().getPlayers();
/* 1089 */     Set<Long> roleids = new HashSet();
/* 1090 */     for (MapRole role : mapRoles)
/*      */     {
/* 1092 */       roleids.add(Long.valueOf(role.getRoleId()));
/*      */     }
/*      */     
/* 1095 */     MapTeamData teamData = MapTeamManager.getInstance().getTeamById(this.teamId);
/* 1096 */     if (teamData != null)
/*      */     {
/* 1098 */       roleids.addAll(teamData.getInTeamMember());
/* 1099 */       roleids.add(Long.valueOf(teamData.getLeaderId()));
/*      */     }
/*      */     
/* 1102 */     MapGroupData mapGroupData = MapGroupManager.getInstance().getMapGroupData(this.groupType, this.groupid);
/* 1103 */     if (mapGroupData != null)
/*      */     {
/* 1105 */       roleids.add(Long.valueOf(mapGroupData.getLeaderid()));
/* 1106 */       roleids.addAll(mapGroupData.getOtherMemebersForInner());
/*      */     }
/* 1108 */     if (includeSelf)
/*      */     {
/* 1110 */       roleids.add(Long.valueOf(getRoleId()));
/*      */     }
/*      */     else
/*      */     {
/* 1114 */       roleids.remove(Long.valueOf(getRoleId()));
/*      */     }
/*      */     
/* 1117 */     return roleids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void broadcastProtocol(Protocol protocol)
/*      */   {
/* 1127 */     Collection<Long> roleids = getPlayersInMyView(false);
/*      */     
/* 1129 */     MapProtocolSendQueue.getInstance().sendMulti(roleids, protocol);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void broadcastProtocolIncludeSelf(Protocol protocol)
/*      */   {
/* 1139 */     Collection<Long> roleids = getPlayersInMyView(true);
/* 1140 */     MapProtocolSendQueue.getInstance().sendMulti(roleids, protocol);
/*      */   }
/*      */   
/*      */   public boolean isInSafeZone()
/*      */   {
/* 1145 */     return this.isInSafeZone;
/*      */   }
/*      */   
/*      */   public void setInSafeZone(boolean isInSafeZone)
/*      */   {
/* 1150 */     this.isInSafeZone = isInSafeZone;
/*      */   }
/*      */   
/*      */   public int getColorId()
/*      */   {
/* 1155 */     return this.dyeColorId;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setOtherOctetsInfo(int key, Octets octetsInfo)
/*      */   {
/* 1165 */     Octets oldOctets = (Octets)this.roleModelInfo.protocol_octets_map.put(Integer.valueOf(key), octetsInfo);
/* 1166 */     if ((oldOctets != null) && (oldOctets.equals(octetsInfo)))
/*      */     {
/* 1168 */       return;
/*      */     }
/*      */     
/* 1171 */     updateRoleModelCache();
/*      */     
/* 1173 */     SRoleExtraUpdateBrd brd = new SRoleExtraUpdateBrd();
/* 1174 */     brd.roleid = getRoleId();
/* 1175 */     brd.extra_type = key;
/* 1176 */     brd.extra_content = octetsInfo;
/* 1177 */     broadcastProtocolIncludeSelf(brd);
/*      */   }
/*      */   
/*      */   public void unsetOtherOctetsInfo(int key)
/*      */   {
/* 1182 */     if (this.roleModelInfo.protocol_octets_map.remove(Integer.valueOf(key)) == null)
/*      */     {
/* 1184 */       return;
/*      */     }
/*      */     
/* 1187 */     updateRoleModelCache();
/*      */     
/* 1189 */     SRoleExtraRemoveBrd brd = new SRoleExtraRemoveBrd();
/* 1190 */     brd.roleid = getRoleId();
/* 1191 */     brd.extra_type = key;
/* 1192 */     broadcastProtocolIncludeSelf(brd);
/*      */   }
/*      */   
/*      */   private void updateWorldTempApp()
/*      */   {
/* 1197 */     updateWorldTempApp(false);
/*      */   }
/*      */   
/*      */   private void updateWorldTempApp(boolean updateCache)
/*      */   {
/* 1202 */     long roleId = getRoleId();
/* 1203 */     WorldInstance instance = WorldManager.getInstance().getRoleWorldInstanceFromStack(roleId);
/* 1204 */     if (instance == null)
/*      */     {
/* 1206 */       return;
/*      */     }
/* 1208 */     Integer appId = instance.getRoleIntParam(roleId, 0);
/* 1209 */     String appText = instance.getRoleStringParam(roleId, 1);
/* 1210 */     if (appId != null)
/*      */     {
/* 1212 */       this.roleModelInfo.int_props.put(Integer.valueOf(5), appId);
/* 1213 */       this.roleModelInfo.string_props.put(Integer.valueOf(2), appText);
/*      */     }
/*      */     else
/*      */     {
/* 1217 */       this.roleModelInfo.int_props.remove(Integer.valueOf(5));
/* 1218 */       this.roleModelInfo.string_props.remove(Integer.valueOf(2));
/*      */     }
/*      */     
/* 1221 */     if (updateCache)
/*      */     {
/* 1223 */       updateRoleModelCache();
/*      */     }
/*      */   }
/*      */   
/*      */   public void updateStatusSet(List<Integer> addList, List<Integer> remList)
/*      */   {
/* 1229 */     this.roleModelInfo.role_status_list.removeAll(remList);
/* 1230 */     this.roleModelInfo.role_status_list.addAll(addList);
/*      */     
/* 1232 */     updateRoleModelCache();
/*      */   }
/*      */   
/*      */   public void setPetModelInfo(MapModelInfo petModelInfo)
/*      */   {
/* 1237 */     this.petModelInfo = petModelInfo;
/*      */     
/* 1239 */     updatePetModelCache();
/*      */   }
/*      */   
/*      */   public void setChildrenModelInfo(MapModelInfo childrenModelInfo)
/*      */   {
/* 1244 */     this.childrenModelInfo = childrenModelInfo;
/*      */     
/* 1246 */     updateChildrenModelCache();
/*      */   }
/*      */   
/*      */   public int getMoveDistance()
/*      */   {
/* 1251 */     return this.moveDistance;
/*      */   }
/*      */   
/*      */   public void setMoveDistance(int moveDistance)
/*      */   {
/* 1256 */     this.moveDistance = moveDistance;
/*      */   }
/*      */   
/*      */   public long getLastTraceTime()
/*      */   {
/* 1261 */     return this.lastTraceTime;
/*      */   }
/*      */   
/*      */   public void setLastTraceTime(long lastTraceTime)
/*      */   {
/* 1266 */     this.lastTraceTime = lastTraceTime;
/*      */   }
/*      */   
/*      */   public long getDeltaTime()
/*      */   {
/* 1271 */     return this.deltaTime;
/*      */   }
/*      */   
/*      */   public void setDeltaTime(long deltaTime)
/*      */   {
/* 1276 */     this.deltaTime = deltaTime;
/*      */   }
/*      */   
/*      */   public void addDeltaTime(long time)
/*      */   {
/* 1281 */     this.deltaTime += time;
/*      */   }
/*      */   
/*      */   public boolean isInTeam()
/*      */   {
/* 1286 */     return (this.teamId != -1L) && (MapTeamManager.getInstance().getTeamById(this.teamId) != null);
/*      */   }
/*      */   
/*      */   public void setTeamId(long teamId)
/*      */   {
/* 1291 */     this.teamId = teamId;
/*      */   }
/*      */   
/*      */   public long getTeamId()
/*      */   {
/* 1296 */     return this.teamId;
/*      */   }
/*      */   
/*      */   public boolean isServerDominateGroup()
/*      */   {
/* 1301 */     return (this.groupType == MapGroupType.MGT_MARRIAGE) || (this.groupType == MapGroupType.MGT_WATCH_MOON_SIDE_BY_SIDE_FLY) || (this.groupType == MapGroupType.MGT_WATCH_MOON_XYXW_FLY) || (this.groupType == MapGroupType.MGT_GROUP_WEDDING);
/*      */   }
/*      */   
/*      */ 
/*      */   public void setGroupType(MapGroupType groupType)
/*      */   {
/* 1307 */     this.groupType = groupType;
/*      */   }
/*      */   
/*      */   public MapGroupType getGroupType()
/*      */   {
/* 1312 */     return this.groupType;
/*      */   }
/*      */   
/*      */   public void setGroupid(long groupid)
/*      */   {
/* 1317 */     this.groupid = groupid;
/*      */   }
/*      */   
/*      */   public long getGroupid()
/*      */   {
/* 1322 */     return this.groupid;
/*      */   }
/*      */   
/*      */   private int getBaseVelocity()
/*      */   {
/* 1327 */     if (this.groupSpeed > 0)
/*      */     {
/* 1329 */       return this.groupSpeed;
/*      */     }
/* 1331 */     if (this.flySpeed > 0)
/*      */     {
/* 1333 */       return this.flySpeed;
/*      */     }
/* 1335 */     if (this.mountsSpeed > 0)
/*      */     {
/* 1337 */       return this.mountsSpeed;
/*      */     }
/* 1339 */     return this.velocity;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getVelocity()
/*      */   {
/* 1345 */     int baseVelocity = getBaseVelocity();
/*      */     
/* 1347 */     return (int)(this.speedFixAdded + (1.0D + this.speedPercentAdded / MapCfgManager.getInstance().getBaseRate()) * baseVelocity);
/*      */   }
/*      */   
/*      */ 
/*      */   private void updateVelocityInfo()
/*      */   {
/* 1353 */     int velocity = getVelocity();
/* 1354 */     this.roleModelInfo.velocity = velocity;
/* 1355 */     updateRoleModelCache();
/*      */     
/* 1357 */     SSyncRoleModelChange core = new SSyncRoleModelChange();
/* 1358 */     core.roleid = getRoleId();
/* 1359 */     core.intpropmap.put(Integer.valueOf(7), Integer.valueOf(velocity));
/* 1360 */     broadcastProtocolIncludeSelf(core);
/*      */   }
/*      */   
/*      */   public void addSpeedFixAdded(int fixAdded)
/*      */   {
/* 1365 */     this.speedFixAdded += fixAdded;
/*      */     
/* 1367 */     updateVelocityInfo();
/*      */   }
/*      */   
/*      */   public void addSpeedPercentAdded(int percentAdded)
/*      */   {
/* 1372 */     this.speedPercentAdded += percentAdded;
/*      */     
/* 1374 */     updateVelocityInfo();
/*      */   }
/*      */   
/*      */ 
/*      */   public void setVelocity(int velocity)
/*      */   {
/* 1380 */     if (this.velocity == velocity)
/*      */     {
/* 1382 */       return;
/*      */     }
/*      */     
/* 1385 */     super.setVelocity(velocity);
/*      */     
/* 1387 */     updateVelocityInfo();
/*      */   }
/*      */   
/*      */   public int getGroupSpeed()
/*      */   {
/* 1392 */     return this.groupSpeed;
/*      */   }
/*      */   
/*      */   public void setGroupSpeed(int groupSpeed)
/*      */   {
/* 1397 */     if (this.groupSpeed == groupSpeed)
/*      */     {
/* 1399 */       return;
/*      */     }
/*      */     
/* 1402 */     this.groupSpeed = groupSpeed;
/*      */     
/* 1404 */     updateVelocityInfo();
/*      */   }
/*      */   
/*      */   public int getFlySpeed()
/*      */   {
/* 1409 */     return this.flySpeed;
/*      */   }
/*      */   
/*      */   public void setFlySpeed(int flySpeed)
/*      */   {
/* 1414 */     if (this.flySpeed == flySpeed)
/*      */     {
/* 1416 */       return;
/*      */     }
/*      */     
/* 1419 */     this.flySpeed = flySpeed;
/*      */     
/* 1421 */     updateVelocityInfo();
/*      */   }
/*      */   
/*      */   public int getMountsSpeed()
/*      */   {
/* 1426 */     return this.mountsSpeed;
/*      */   }
/*      */   
/*      */   public void setMountsSpeed(int mountsSpeed)
/*      */   {
/* 1431 */     if (this.mountsSpeed == mountsSpeed)
/*      */     {
/* 1433 */       return;
/*      */     }
/*      */     
/* 1436 */     this.mountsSpeed = mountsSpeed;
/*      */     
/* 1438 */     updateVelocityInfo();
/*      */   }
/*      */   
/*      */   public void savePosition()
/*      */   {
/* 1443 */     Scene scene = SceneManager.getInstance().getScene(this.position);
/* 1444 */     if (scene != null)
/*      */     {
/* 1446 */       savePosition(scene, false);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void savePosition(Scene scene, boolean needClearFlyStatus)
/*      */   {
/* 1453 */     final Position curPos = getPosition();
/* 1454 */     final boolean curPosIsInBigWorld = SceneManager.getInstance().isPosInBigWorld(curPos);
/* 1455 */     final Position flyLandPosition = scene.getFlyLandPositionForInner(curPos);
/* 1456 */     final long roleId = getRoleId();
/* 1457 */     Position pos = WorldManager.getInstance().getBigWorldInstance().getPosition(roleId);
/* 1458 */     final Position bigWorldPos = pos == null ? null : new UnModifyPosition(pos);
/* 1459 */     new LogicProcedure()
/*      */     {
/*      */       protected boolean processImp()
/*      */         throws Exception
/*      */       {
/* 1464 */         if (RoleStatusInterface.containsStatus(roleId, 2))
/*      */         {
/* 1466 */           if (curPosIsInBigWorld)
/*      */           {
/* 1468 */             RoleStatusInterface.unsetStatus(roleId, 2);
/* 1469 */             FlyLandArg arg = new FlyLandArg();
/* 1470 */             arg.roleList.add(Long.valueOf(roleId));
/* 1471 */             TriggerEventsManger.getInstance().triggerEvent(new FlyLandEvent(), arg);
/*      */           }
/*      */           
/* 1474 */           if (flyLandPosition)
/*      */           {
/* 1476 */             return new PositionProcedure(roleId, curPos).call();
/*      */           }
/*      */         }
/*      */         
/* 1480 */         if (flyLandPosition)
/*      */         {
/* 1482 */           return new PositionProcedure(roleId, bigWorldPos).call();
/*      */         }
/*      */         
/* 1485 */         if (this.val$bigWorldPos != null)
/*      */         {
/* 1487 */           return new PositionProcedure(roleId, this.val$bigWorldPos).call();
/*      */         }
/*      */         
/* 1490 */         GameServer.logger().warn(String.format("[map]MapRole.savePosition.LogicProcedure.processImp@big world position is null|roleid=%d|curpos=%s|fly_down_pos=%s", new Object[] { Long.valueOf(roleId), bigWorldPos.toString(), curPos.toString() }));
/*      */         
/*      */ 
/*      */ 
/*      */ 
/* 1495 */         return true;
/*      */       }
/*      */     }.execute();
/*      */   }
/*      */   
/*      */ 
/*      */   public void destroy()
/*      */   {
/* 1503 */     if (!this.isAlive)
/*      */     {
/* 1505 */       return;
/*      */     }
/*      */     
/*      */ 
/* 1509 */     MapTeamData teamData = MapTeamManager.getInstance().getTeamById(this.teamId);
/* 1510 */     if (teamData != null)
/*      */     {
/* 1512 */       return;
/*      */     }
/*      */     
/* 1515 */     MapGroupData mapGroupData = MapGroupManager.getInstance().getMapGroupData(this.groupType, this.groupid);
/* 1516 */     if (mapGroupData != null)
/*      */     {
/* 1518 */       return;
/*      */     }
/*      */     
/* 1521 */     this.isAlive = false;
/* 1522 */     this.keyPointPath.clear();
/*      */     
/* 1524 */     Scene scene = SceneManager.getInstance().getScene(this.position);
/* 1525 */     if (scene != null)
/*      */     {
/*      */ 
/* 1528 */       long worldid = scene.getWorld().getId();
/* 1529 */       int mapid = scene.getCfgId();
/*      */       
/*      */ 
/* 1532 */       savePosition(scene, true);
/*      */       
/* 1534 */       scene.removeRole(this);
/*      */       
/*      */ 
/* 1537 */       long roleId = getRoleId();
/* 1538 */       MapRoleDestroyedArg arg = new MapRoleDestroyedArg(roleId, worldid, mapid);
/* 1539 */       TriggerEventsManger.getInstance().triggerEventAtOnce(new MapRoleDestroyedEvent(), arg);
/*      */     }
/*      */     
/* 1542 */     this.canSeeKeySet.clear();
/* 1543 */     this.invisibleObjectQueue.clear();
/*      */     
/* 1545 */     onDestroy();
/*      */   }
/*      */   
/*      */   protected void onDestroy()
/*      */   {
/* 1550 */     long roleId = getRoleId();
/* 1551 */     if (logger.isDebugEnabled())
/*      */     {
/* 1553 */       logger.debug(String.format("[map]MapRole.onDestroy@destroy role|roleid=%d", new Object[] { Long.valueOf(roleId) }));
/*      */     }
/*      */     
/* 1556 */     if (this.cell != null)
/*      */     {
/* 1558 */       this.cell.onRemove(this);
/*      */     }
/*      */     
/* 1561 */     MapObjectInstanceManager.getInstance().removeMapRole(roleId);
/*      */   }
/*      */   
/*      */   private Protocol buildRoleEnterView()
/*      */   {
/* 1566 */     SRoleEnterView roleEnterView = new SRoleEnterView();
/* 1567 */     roleEnterView.modelinfo = this.roleModelInfoCache;
/* 1568 */     List<Location> keyPath = getKeyPointPath();
/* 1569 */     Position pos = getPositionForInner();
/* 1570 */     roleEnterView.curpos.x = pos.getX();
/* 1571 */     roleEnterView.curpos.y = pos.getY();
/* 1572 */     roleEnterView.keypointpath.addAll(keyPath);
/* 1573 */     roleEnterView.direction = this.direction;
/* 1574 */     roleEnterView.level = this.level;
/* 1575 */     roleEnterView.gender = this.gender;
/* 1576 */     roleEnterView.menpai = this.menPai;
/* 1577 */     if (this.petModelInfo != null)
/*      */     {
/* 1579 */       roleEnterView.models.put(Integer.valueOf(1), this.petModelInfoCache);
/*      */     }
/* 1581 */     else if (this.childrenModelInfo != null)
/*      */     {
/* 1583 */       roleEnterView.models.put(Integer.valueOf(2), this.childrenModelInfoCache);
/*      */     }
/*      */     
/* 1586 */     return roleEnterView;
/*      */   }
/*      */   
/*      */ 
/*      */   public Protocol createEnterView()
/*      */   {
/* 1592 */     MapTeamData teamData = MapTeamManager.getInstance().getTeamById(this.teamId);
/* 1593 */     if (teamData != null)
/*      */     {
/* 1595 */       return teamData.createEnterView(this);
/*      */     }
/*      */     
/* 1598 */     MapGroupData mapGroupData = MapGroupManager.getInstance().getMapGroupData(this.groupType, this.groupid);
/* 1599 */     if (mapGroupData != null)
/*      */     {
/* 1601 */       return mapGroupData.createEnterView(this);
/*      */     }
/*      */     
/* 1604 */     return buildRoleEnterView();
/*      */   }
/*      */   
/*      */ 
/*      */   public Protocol createLeaveView()
/*      */   {
/* 1610 */     MapTeamData teamData = MapTeamManager.getInstance().getTeamById(this.teamId);
/* 1611 */     if (teamData != null)
/*      */     {
/* 1613 */       return teamData.createLeaveView(this);
/*      */     }
/*      */     
/* 1616 */     MapGroupData mapGroupData = MapGroupManager.getInstance().getMapGroupData(this.groupType, this.groupid);
/* 1617 */     if (mapGroupData != null)
/*      */     {
/* 1619 */       return mapGroupData.createLeaveView(this);
/*      */     }
/*      */     
/* 1622 */     SRoleLeaveView roleLeaveView = new SRoleLeaveView();
/* 1623 */     roleLeaveView.roleid = getRoleId();
/* 1624 */     return roleLeaveView;
/*      */   }
/*      */   
/*      */ 
/*      */   public Protocol createMoveProtocol()
/*      */   {
/* 1630 */     MapTeamData teamData = MapTeamManager.getInstance().getTeamById(this.teamId);
/* 1631 */     if (teamData != null)
/*      */     {
/* 1633 */       return teamData.createTeamMoveProtocol(this);
/*      */     }
/*      */     
/* 1636 */     MapGroupData mapGroupData = MapGroupManager.getInstance().getMapGroupData(this.groupType, this.groupid);
/* 1637 */     if (mapGroupData != null)
/*      */     {
/* 1639 */       return mapGroupData.createMoveProtocol(this);
/*      */     }
/*      */     
/* 1642 */     SSyncRoleMove roleMove = new SSyncRoleMove();
/* 1643 */     roleMove.direction = getDirection();
/* 1644 */     Position pos = getPositionForInner();
/* 1645 */     Scene scene = SceneManager.getInstance().getScene(pos);
/* 1646 */     roleMove.mapid = scene.getCfgId();
/* 1647 */     roleMove.roleid = getRoleId();
/* 1648 */     roleMove.keypointpath.addAll(getKeyPointPath());
/* 1649 */     if (roleMove.keypointpath.isEmpty())
/*      */     {
/* 1651 */       return null;
/*      */     }
/* 1653 */     return roleMove;
/*      */   }
/*      */   
/*      */ 
/*      */   public int acceptEnterView(SceneObject other, boolean delaySync)
/*      */   {
/* 1659 */     if (!other.isVisible())
/*      */     {
/* 1661 */       this.invisibleObjectQueue.put(other.getObjectId(), other);
/*      */     }
/*      */     
/* 1664 */     if (other.isSameGroup(this))
/*      */     {
/* 1666 */       this.canSeeKeySet.add(other.getObjectId());
/*      */     }
/*      */     
/* 1669 */     if (other.isFollower())
/*      */     {
/* 1671 */       this.canSeeKeySet.add(other.getObjectId());
/*      */     }
/*      */     
/* 1674 */     if (!other.isCanSee(this))
/*      */     {
/* 1676 */       return 0;
/*      */     }
/*      */     
/* 1679 */     if (!this.canSeeKeySet.add(other.getObjectId()))
/*      */     {
/* 1681 */       return 1;
/*      */     }
/*      */     
/* 1684 */     if (!delaySync)
/*      */     {
/* 1686 */       Protocol core = other.createEnterView();
/* 1687 */       sendMapProtocol(core);
/*      */     }
/*      */     
/* 1690 */     return 7;
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean isCanSee(MapRole role)
/*      */   {
/* 1696 */     if (isFollower())
/*      */     {
/* 1698 */       return false;
/*      */     }
/*      */     
/* 1701 */     if (isSameGroup(role))
/*      */     {
/* 1703 */       return false;
/*      */     }
/*      */     
/* 1706 */     return true;
/*      */   }
/*      */   
/*      */   public boolean isSee(SceneObject object)
/*      */   {
/* 1711 */     return this.canSeeKeySet.contains(object.getObjectId());
/*      */   }
/*      */   
/*      */ 
/*      */   public int acceptMoveView(SceneObject other, boolean delaySync)
/*      */   {
/* 1717 */     if (!this.canSeeKeySet.contains(other.getObjectId()))
/*      */     {
/* 1719 */       return 0;
/*      */     }
/*      */     
/* 1722 */     if (other.isSameGroup(this))
/*      */     {
/* 1724 */       return 0;
/*      */     }
/*      */     
/* 1727 */     if (!other.isTargetDirty())
/*      */     {
/* 1729 */       return 0;
/*      */     }
/*      */     
/* 1732 */     if (!delaySync)
/*      */     {
/* 1734 */       Protocol core = other.createMoveProtocol();
/* 1735 */       sendMapProtocol(core);
/*      */     }
/*      */     
/* 1738 */     return 33;
/*      */   }
/*      */   
/*      */ 
/*      */   public int acceptLeaveView(SceneObject other, boolean delaySync)
/*      */   {
/* 1744 */     this.invisibleObjectQueue.remove(other.getObjectId());
/*      */     
/* 1746 */     if (!this.canSeeKeySet.remove(other.getObjectId()))
/*      */     {
/* 1748 */       return 0;
/*      */     }
/*      */     
/* 1751 */     if (other.isSameGroup(this))
/*      */     {
/* 1753 */       return 0;
/*      */     }
/*      */     
/* 1756 */     if (!delaySync)
/*      */     {
/* 1758 */       Protocol core = other.createLeaveView();
/* 1759 */       sendMapProtocol(core);
/*      */     }
/*      */     
/* 1762 */     return 25;
/*      */   }
/*      */   
/*      */   public Map<Integer, TaskInterface.TaskState> getRoleTaskMap()
/*      */   {
/* 1767 */     return this.roleTaskStateMap;
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean isSameGroup(MapRole role)
/*      */   {
/* 1773 */     if ((this.teamId > 0L) && (this.teamId == role.getTeamId()))
/*      */     {
/* 1775 */       return true;
/*      */     }
/* 1777 */     if ((this.groupType != MapGroupType.UNKNOWN) && (this.groupType == role.getGroupType()) && (this.groupid == role.getGroupid()))
/*      */     {
/*      */ 
/* 1780 */       return true;
/*      */     }
/* 1782 */     return false;
/*      */   }
/*      */   
/*      */   public void setRoleTaskStateMap(Map<Integer, TaskInterface.TaskState> taskStateMap)
/*      */   {
/* 1787 */     this.roleTaskStateMap = taskStateMap;
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean updateView()
/*      */   {
/* 1793 */     boolean ret = super.updateView();
/* 1794 */     Iterator<Map.Entry<SceneObjectId, SceneObject>> it = this.invisibleObjectQueue.entrySet().iterator();
/* 1795 */     while (it.hasNext())
/*      */     {
/* 1797 */       Map.Entry<SceneObjectId, SceneObject> entry = (Map.Entry)it.next();
/* 1798 */       SceneObject object = (SceneObject)entry.getValue();
/* 1799 */       if (!object.isAlive())
/*      */       {
/* 1801 */         this.canSeeKeySet.remove(object.getObjectId());
/* 1802 */         it.remove();
/*      */ 
/*      */ 
/*      */ 
/*      */       }
/* 1807 */       else if (!(object instanceof MapRole))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1813 */         if (acceptEnterView(object, false) == 0)
/*      */         {
/* 1815 */           if (this.canSeeKeySet.contains(object.getObjectId()))
/*      */           {
/*      */ 
/* 1818 */             Protocol protocol = object.createLeaveView();
/* 1819 */             if (protocol != null)
/*      */             {
/* 1821 */               sendMapProtocol(protocol);
/*      */             }
/* 1823 */             this.canSeeKeySet.remove(object.getObjectId());
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 1828 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void sendMapProtocol(Protocol protocol)
/*      */   {
/* 1838 */     if (protocol == null)
/*      */     {
/* 1840 */       return;
/*      */     }
/* 1842 */     MapProtocolSendQueue.getInstance().send(getRoleId(), protocol);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void notifyOtherInFight()
/*      */   {
/* 1850 */     setState(1);
/*      */     
/*      */ 
/* 1853 */     this.targetPos.setXYZ(this.position.getX(), this.position.getY(), this.position.getZ());
/* 1854 */     setXYZ(this.position.getX(), this.position.getY(), this.position.getZ());
/*      */     
/* 1856 */     long roleId = getRoleId();
/* 1857 */     MapTeamData teamData = MapTeamManager.getInstance().getTeamById(this.teamId);
/* 1858 */     if (teamData != null)
/*      */     {
/* 1860 */       if (teamData.isLeader(roleId))
/*      */       {
/* 1862 */         STeamStartFight protocol = new STeamStartFight();
/* 1863 */         protocol.teamid = this.teamId;
/* 1864 */         broadcastProtocol(protocol);
/*      */       }
/* 1866 */       return;
/*      */     }
/*      */     
/* 1869 */     SRoleStartFight protocol = new SRoleStartFight();
/* 1870 */     protocol.roleid = roleId;
/* 1871 */     broadcastProtocol(protocol);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void notifyOtherOutFight()
/*      */   {
/* 1879 */     unsetState(1);
/*      */     
/* 1881 */     long roleId = getRoleId();
/* 1882 */     MapTeamData teamData = MapTeamManager.getInstance().getTeamById(this.teamId);
/* 1883 */     if (teamData != null)
/*      */     {
/* 1885 */       if (teamData.isLeader(roleId))
/*      */       {
/* 1887 */         STeamEndFight protocol = new STeamEndFight();
/* 1888 */         protocol.teamid = this.teamId;
/* 1889 */         broadcastProtocol(protocol);
/*      */       }
/* 1891 */       return;
/*      */     }
/*      */     
/* 1894 */     SRoleEndFight protocol = new SRoleEndFight();
/* 1895 */     protocol.roleid = roleId;
/* 1896 */     broadcastProtocol(protocol);
/*      */   }
/*      */   
/*      */   public int getDistance(SceneObject obj)
/*      */   {
/* 1901 */     Position ownerPt = getPositionForInner();
/* 1902 */     Position targetPt = obj.getPositionForInner();
/* 1903 */     if (targetPt.getSceneId() != ownerPt.getSceneId())
/*      */     {
/* 1905 */       return Integer.MAX_VALUE;
/*      */     }
/*      */     
/* 1908 */     return (int)MapManager.getDistance(ownerPt.getX(), ownerPt.getY(), targetPt.getX(), targetPt.getY());
/*      */   }
/*      */   
/*      */   public void setLevel(int level)
/*      */   {
/* 1913 */     this.level = level;
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean isMoveState()
/*      */   {
/* 1919 */     return !this.keyPointPath.isEmpty();
/*      */   }
/*      */   
/*      */   public MapModelInfo getRoleModel()
/*      */   {
/* 1924 */     return this.roleModelInfo;
/*      */   }
/*      */   
/*      */   public Octets getRoleModelCache()
/*      */   {
/* 1929 */     return this.roleModelInfoCache;
/*      */   }
/*      */   
/*      */   public MapModelInfo getPetModel()
/*      */   {
/* 1934 */     return this.petModelInfo;
/*      */   }
/*      */   
/*      */   public Octets getPetModelCache()
/*      */   {
/* 1939 */     return this.petModelInfoCache;
/*      */   }
/*      */   
/*      */   public MapModelInfo getChildrenModel()
/*      */   {
/* 1944 */     return this.childrenModelInfo;
/*      */   }
/*      */   
/*      */   public Octets getChildrenModelCache()
/*      */   {
/* 1949 */     return this.childrenModelInfoCache;
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean isFollower()
/*      */   {
/* 1955 */     long roleId = getRoleId();
/*      */     
/* 1957 */     MapTeamData teamData = MapTeamManager.getInstance().getTeamById(this.teamId);
/* 1958 */     if (teamData != null)
/*      */     {
/* 1960 */       if (!teamData.isLeader(roleId))
/*      */       {
/* 1962 */         return true;
/*      */       }
/*      */     }
/*      */     
/* 1966 */     MapGroupData mapGroupData = MapGroupManager.getInstance().getMapGroupData(this.groupType, this.groupid);
/* 1967 */     if (mapGroupData != null)
/*      */     {
/* 1969 */       if (mapGroupData.getLeaderid() != roleId)
/*      */       {
/* 1971 */         return true;
/*      */       }
/*      */     }
/*      */     
/* 1975 */     return false;
/*      */   }
/*      */   
/*      */   public boolean isInMapGroup()
/*      */   {
/* 1980 */     MapGroupData mapGroupData = MapGroupManager.getInstance().getMapGroupData(this.groupType, this.groupid);
/* 1981 */     return mapGroupData != null;
/*      */   }
/*      */   
/*      */   public boolean setHusongState(boolean isInHuSongState, boolean expect)
/*      */   {
/* 1986 */     if (this.husongState == expect)
/*      */     {
/* 1988 */       this.husongState = isInHuSongState;
/* 1989 */       return true;
/*      */     }
/*      */     
/* 1992 */     return false;
/*      */   }
/*      */   
/*      */   public void unsetHuSong()
/*      */   {
/* 1997 */     long roleId = getRoleId();
/* 1998 */     SSyncRoleModelChange syncRoleModelChange = new SSyncRoleModelChange();
/* 1999 */     syncRoleModelChange.roleid = roleId;
/* 2000 */     if (this.roleModelInfo.int_props.remove(Integer.valueOf(4)) != null)
/*      */     {
/* 2002 */       syncRoleModelChange.intpropmap.put(Integer.valueOf(14), Integer.valueOf(0));
/*      */     }
/* 2004 */     if (this.roleModelInfo.int_props.remove(Integer.valueOf(6)) != null)
/*      */     {
/* 2006 */       syncRoleModelChange.intpropmap.put(Integer.valueOf(22), Integer.valueOf(0));
/*      */     }
/* 2008 */     if (this.roleModelInfo.int_props.remove(Integer.valueOf(7)) != null)
/*      */     {
/* 2010 */       syncRoleModelChange.intpropmap.put(Integer.valueOf(23), Integer.valueOf(0));
/*      */     }
/* 2012 */     broadcastProtocolIncludeSelf(syncRoleModelChange);
/*      */     
/* 2014 */     updateRoleModelCache();
/*      */     
/* 2016 */     tryShowFollower();
/*      */     
/* 2018 */     stopMove();
/*      */     
/* 2020 */     this.husongTargetNpcId = 0;
/* 2021 */     this.husongKeyPointList.clear();
/*      */   }
/*      */   
/*      */   public void setHuSong(int coupleNpcOrFollowMonsterCfgid, int gender)
/*      */   {
/* 2026 */     long roleId = getRoleId();
/* 2027 */     SSyncRoleModelChange syncRoleModelChange = new SSyncRoleModelChange();
/* 2028 */     syncRoleModelChange.roleid = roleId;
/* 2029 */     if (gender < 0)
/*      */     {
/* 2031 */       syncRoleModelChange.intpropmap.put(Integer.valueOf(14), Integer.valueOf(coupleNpcOrFollowMonsterCfgid));
/*      */       
/* 2033 */       this.roleModelInfo.int_props.put(Integer.valueOf(4), Integer.valueOf(coupleNpcOrFollowMonsterCfgid));
/*      */     }
/*      */     else
/*      */     {
/* 2037 */       syncRoleModelChange.intpropmap.put(Integer.valueOf(22), Integer.valueOf(coupleNpcOrFollowMonsterCfgid));
/* 2038 */       syncRoleModelChange.intpropmap.put(Integer.valueOf(23), Integer.valueOf(gender));
/*      */       
/* 2040 */       this.roleModelInfo.int_props.put(Integer.valueOf(6), Integer.valueOf(coupleNpcOrFollowMonsterCfgid));
/* 2041 */       this.roleModelInfo.int_props.put(Integer.valueOf(7), Integer.valueOf(gender));
/*      */     }
/* 2043 */     broadcastProtocolIncludeSelf(syncRoleModelChange);
/*      */     
/* 2045 */     updateRoleModelCache();
/*      */   }
/*      */   
/*      */   public void huSongArraived()
/*      */   {
/* 2050 */     ArraivedAtNPCArg arg = new ArraivedAtNPCArg();
/* 2051 */     arg.roleId = getRoleId();
/* 2052 */     arg.npcId = this.husongTargetNpcId;
/* 2053 */     TriggerEventsManger.getInstance().triggerEventAtOnce(new ArraivedAtNPC(), arg);
/*      */   }
/*      */   
/*      */   public boolean isInHuSongState()
/*      */   {
/* 2058 */     return this.husongState;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean isCanTransfer(TransferType transferType)
/*      */   {
/* 2069 */     if ((isFollower()) || (isTeleporting()) || (isServerDominateGroup()))
/*      */     {
/* 2071 */       return false;
/*      */     }
/*      */     
/* 2074 */     if ((isInHuSongState()) && (transferType != TransferType.ZONE_TRANSFER))
/*      */     {
/* 2076 */       return false;
/*      */     }
/*      */     
/* 2079 */     if ((transferType == TransferType.FORCE_TRANSFER) || (transferType == TransferType.FAULT))
/*      */     {
/* 2081 */       return true;
/*      */     }
/*      */     
/* 2084 */     if (isFightState())
/*      */     {
/* 2086 */       return false;
/*      */     }
/*      */     
/* 2089 */     return true;
/*      */   }
/*      */   
/*      */   public void stopMove()
/*      */   {
/* 2094 */     if (this.keyPointPath.isEmpty())
/*      */     {
/* 2096 */       return;
/*      */     }
/*      */     
/* 2099 */     this.keyPointPath.clear();
/* 2100 */     this.targetPos.setXYZ(this.position.getX(), this.position.getY(), this.position.getZ());
/*      */   }
/*      */   
/*      */   public boolean isCanExpressionPlay()
/*      */   {
/* 2105 */     if ((isTeleporting()) || (isInMapGroup()))
/*      */     {
/* 2107 */       return false;
/*      */     }
/*      */     
/* 2110 */     if (isInHuSongState())
/*      */     {
/* 2112 */       return false;
/*      */     }
/*      */     
/* 2115 */     if (isFightState())
/*      */     {
/* 2117 */       return false;
/*      */     }
/*      */     
/* 2120 */     MapTeamData teamData = MapTeamManager.getInstance().getTeamById(this.teamId);
/* 2121 */     if (teamData != null)
/*      */     {
/* 2123 */       long roleId = getRoleId();
/* 2124 */       if (!teamData.isLeader(roleId))
/*      */       {
/* 2126 */         MapRole leader = MapObjectInstanceManager.getInstance().getMapRole(teamData.getLeaderId());
/* 2127 */         if ((leader != null) && (leader.isMoveState()))
/*      */         {
/* 2129 */           return false;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 2134 */     return true;
/*      */   }
/*      */   
/*      */   public void genHuSongNPCPath(MapNPC npc)
/*      */   {
/* 2139 */     this.husongTargetNpcId = npc.getCfgId().intValue();
/* 2140 */     this.husongKeyPointList.clear();
/*      */     
/* 2142 */     Position targetPos = npc.getPositionForInner();
/* 2143 */     Scene nowScene = SceneManager.getInstance().getScene(this.position);
/* 2144 */     if (targetPos.getSceneId() == nowScene.getId())
/*      */     {
/* 2146 */       this.husongKeyPointList.addLast(new Position(targetPos));
/* 2147 */       return;
/*      */     }
/*      */     
/* 2150 */     LinkedList<PositionNode> openPath = new LinkedList();
/* 2151 */     for (Position position : nowScene.getSurroundScene())
/*      */     {
/* 2153 */       openPath.add(new PositionNode(position, null));
/*      */     }
/*      */     
/* 2156 */     PositionNode _findPath = null;
/* 2157 */     Set<Integer> closeSceneSet = new HashSet();
/* 2158 */     closeSceneSet.add(Integer.valueOf(nowScene.getId()));
/* 2159 */     PositionNode node; while (!openPath.isEmpty())
/*      */     {
/* 2161 */       node = (PositionNode)openPath.pollFirst();
/* 2162 */       if (node._position.getSceneId() == targetPos.getSceneId())
/*      */       {
/* 2164 */         _findPath = node;
/* 2165 */         break;
/*      */       }
/*      */       
/* 2168 */       closeSceneSet.add(Integer.valueOf(node._position.getSceneId()));
/* 2169 */       Scene scene = SceneManager.getInstance().getScene(node._position);
/* 2170 */       for (Position position : scene.getSurroundScene())
/*      */       {
/* 2172 */         if (!closeSceneSet.contains(Integer.valueOf(position.getSceneId())))
/*      */         {
/*      */ 
/*      */ 
/* 2176 */           openPath.add(new PositionNode(position, node)); }
/*      */       }
/*      */     }
/* 2179 */     if (_findPath != null)
/*      */     {
/* 2181 */       while (_findPath != null)
/*      */       {
/* 2183 */         Position pos = _findPath._position;
/* 2184 */         _findPath = _findPath.parent;
/* 2185 */         if (_findPath != null)
/*      */         {
/* 2187 */           pos.setSceneId(_findPath._position.getSceneId());
/*      */         }
/*      */         else
/*      */         {
/* 2191 */           pos.setSceneId(getSceneId());
/*      */         }
/* 2193 */         this.husongKeyPointList.addFirst(pos);
/*      */       }
/*      */     }
/* 2196 */     this.husongKeyPointList.addLast(new Position(targetPos));
/*      */   }
/*      */   
/*      */   public int getHusongTargetNpcId()
/*      */   {
/* 2201 */     return this.husongTargetNpcId;
/*      */   }
/*      */   
/*      */   class PositionNode
/*      */   {
/*      */     Position _position;
/*      */     PositionNode parent;
/*      */     
/*      */     public PositionNode(Position _position, PositionNode parent)
/*      */     {
/* 2211 */       this._position = _position;
/* 2212 */       this.parent = parent;
/*      */     }
/*      */   }
/*      */   
/*      */   public Position nextHuSongTargetPosition()
/*      */   {
/* 2218 */     return (Position)this.husongKeyPointList.pollFirst();
/*      */   }
/*      */   
/*      */   public boolean tryShowPet()
/*      */   {
/* 2223 */     MapModelInfo petModelInfo = getPetModel();
/* 2224 */     if (petModelInfo == null)
/*      */     {
/* 2226 */       return false;
/*      */     }
/*      */     
/* 2229 */     long roleId = getRoleId();
/* 2230 */     long petId = petModelInfo.id;
/* 2231 */     int petModelId = petModelInfo.model.modelid;
/* 2232 */     String petName = (String)petModelInfo.string_props.get(Integer.valueOf(0));
/* 2233 */     Integer petModelColorId = (Integer)petModelInfo.model.extramap.get(Integer.valueOf(12));
/* 2234 */     Integer petShipin = (Integer)petModelInfo.model.extramap.get(Integer.valueOf(9));
/* 2235 */     Integer petExteriorId = (Integer)petModelInfo.model.extramap.get(Integer.valueOf(22));
/* 2236 */     Integer petExteriorColorId = (Integer)petModelInfo.model.extramap.get(Integer.valueOf(23));
/* 2237 */     Integer outlookId = (Integer)petModelInfo.model.extramap.get(Integer.valueOf(11));
/* 2238 */     Integer petMarkCfgId = (Integer)petModelInfo.model.extramap.get(Integer.valueOf(39));
/*      */     
/* 2240 */     SSyncRoleModelChange change = new SSyncRoleModelChange();
/* 2241 */     change.roleid = roleId;
/* 2242 */     change.longpropmap.put(Integer.valueOf(0), Long.valueOf(petId));
/* 2243 */     change.intpropmap.put(Integer.valueOf(0), Integer.valueOf(petModelId));
/* 2244 */     if (petModelColorId != null)
/*      */     {
/* 2246 */       change.intpropmap.put(Integer.valueOf(12), petModelColorId);
/*      */     }
/* 2248 */     if (petShipin != null)
/*      */     {
/* 2250 */       change.intpropmap.put(Integer.valueOf(18), petShipin);
/*      */     }
/* 2252 */     change.stringpropmap.put(Integer.valueOf(0), petName);
/* 2253 */     change.intpropmap.put(Integer.valueOf(26), petModelInfo.model.extramap.get(Integer.valueOf(17)));
/*      */     
/*      */ 
/* 2256 */     if (petExteriorId != null)
/*      */     {
/* 2258 */       change.intpropmap.put(Integer.valueOf(28), petExteriorId);
/*      */     }
/* 2260 */     if (petExteriorColorId != null)
/*      */     {
/* 2262 */       change.intpropmap.put(Integer.valueOf(29), petExteriorColorId);
/*      */     }
/* 2264 */     if (outlookId != null)
/*      */     {
/* 2266 */       change.intpropmap.put(Integer.valueOf(43), outlookId);
/*      */     }
/* 2268 */     if (petMarkCfgId != null)
/*      */     {
/* 2270 */       change.intpropmap.put(Integer.valueOf(44), petMarkCfgId);
/*      */     }
/*      */     
/* 2273 */     broadcastProtocolIncludeSelf(change);
/*      */     
/* 2275 */     return true;
/*      */   }
/*      */   
/*      */   public boolean tryShowChildren()
/*      */   {
/* 2280 */     MapModelInfo childrenModel = getChildrenModel();
/* 2281 */     if (childrenModel == null)
/*      */     {
/* 2283 */       return false;
/*      */     }
/* 2285 */     long roleId = getRoleId();
/* 2286 */     long childId = childrenModel.id;
/* 2287 */     String childName = (String)childrenModel.string_props.get(Integer.valueOf(0));
/* 2288 */     Integer childPhase = (Integer)childrenModel.model.extramap.get(Integer.valueOf(25));
/* 2289 */     Integer childGender = (Integer)childrenModel.model.extramap.get(Integer.valueOf(26));
/* 2290 */     Integer childModelid = (Integer)childrenModel.model.extramap.get(Integer.valueOf(28));
/* 2291 */     Integer childWeaponid = (Integer)childrenModel.model.extramap.get(Integer.valueOf(29));
/* 2292 */     Integer childFashion = (Integer)childrenModel.model.extramap.get(Integer.valueOf(27));
/*      */     
/* 2294 */     SSyncRoleModelChange change = new SSyncRoleModelChange();
/* 2295 */     change.roleid = roleId;
/* 2296 */     change.longpropmap.put(Integer.valueOf(1), Long.valueOf(childId));
/* 2297 */     change.stringpropmap.put(Integer.valueOf(3), childName);
/* 2298 */     if (childPhase != null)
/*      */     {
/* 2300 */       change.intpropmap.put(Integer.valueOf(31), childPhase);
/*      */     }
/* 2302 */     if (childGender != null)
/*      */     {
/* 2304 */       change.intpropmap.put(Integer.valueOf(32), childGender);
/*      */     }
/* 2306 */     if (childModelid != null)
/*      */     {
/* 2308 */       change.intpropmap.put(Integer.valueOf(34), childModelid);
/*      */     }
/* 2310 */     if (childWeaponid != null)
/*      */     {
/* 2312 */       change.intpropmap.put(Integer.valueOf(35), childWeaponid);
/*      */     }
/* 2314 */     if (childFashion != null)
/*      */     {
/* 2316 */       change.intpropmap.put(Integer.valueOf(33), childFashion);
/*      */     }
/* 2318 */     broadcastProtocolIncludeSelf(change);
/*      */     
/* 2320 */     return true;
/*      */   }
/*      */   
/*      */   public void tryShowFollower()
/*      */   {
/* 2325 */     if (tryShowPet())
/*      */     {
/* 2327 */       return;
/*      */     }
/*      */     
/* 2330 */     tryShowChildren();
/*      */   }
/*      */   
/*      */   public void setWorldApp(int colorId, String appText)
/*      */   {
/* 2335 */     long roleId = getRoleId();
/* 2336 */     WorldInstance instance = WorldManager.getInstance().getRoleWorldInstanceFromStack(roleId);
/* 2337 */     instance.putRoleIntParam(roleId, 0, colorId);
/* 2338 */     instance.putRoleStringParam(roleId, 1, appText);
/*      */     
/* 2340 */     updateWorldTempApp(true);
/*      */     
/* 2342 */     SSyncRoleModelChange change = new SSyncRoleModelChange();
/* 2343 */     change.roleid = roleId;
/* 2344 */     change.intpropmap.put(Integer.valueOf(15), Integer.valueOf(colorId));
/* 2345 */     change.stringpropmap.put(Integer.valueOf(2), appText);
/* 2346 */     broadcastProtocolIncludeSelf(change);
/*      */   }
/*      */   
/*      */   public void unSetWorldApp()
/*      */   {
/* 2351 */     this.roleModelInfo.int_props.remove(Integer.valueOf(5));
/* 2352 */     this.roleModelInfo.string_props.remove(Integer.valueOf(2));
/* 2353 */     updateRoleModelCache();
/*      */     
/* 2355 */     long roleId = getRoleId();
/* 2356 */     SSyncRoleModelChange change = new SSyncRoleModelChange();
/* 2357 */     change.roleid = roleId;
/* 2358 */     Integer applicationId = (Integer)this.roleModelInfo.int_props.get(Integer.valueOf(1));
/* 2359 */     String appText = (String)this.roleModelInfo.string_props.get(Integer.valueOf(1));
/* 2360 */     if ((applicationId == null) || (appText == null))
/*      */     {
/* 2362 */       change.intpropmap.put(Integer.valueOf(10), Integer.valueOf(0));
/*      */     }
/*      */     else
/*      */     {
/* 2366 */       change.intpropmap.put(Integer.valueOf(10), applicationId);
/* 2367 */       change.stringpropmap.put(Integer.valueOf(1), appText);
/*      */     }
/* 2369 */     broadcastProtocolIncludeSelf(change);
/*      */   }
/*      */   
/*      */ 
/*      */   public void update(long time)
/*      */   {
/* 2375 */     if ((!isFightState()) && (!isState(32)))
/*      */     {
/* 2377 */       long difTime = time - this.lastTraceTime;
/*      */       
/* 2379 */       if (!this.keyPointPath.isEmpty())
/*      */       {
/* 2381 */         Location curPos = new Location(this.position.getX(), this.position.getY());
/* 2382 */         Location nextPos = (Location)this.keyPointPath.peekFirst();
/*      */         
/* 2384 */         double velocity = getVelocity();
/* 2385 */         nextPos = MapManager.calculatePosition(this.keyPointPath, velocity, curPos, nextPos, difTime);
/* 2386 */         if (nextPos != null)
/*      */         {
/* 2388 */           setXYZ(nextPos.x, nextPos.y, 0);
/*      */           
/* 2390 */           this.moveDistance = ((int)(this.moveDistance + velocity * difTime / 1000.0D));
/*      */           
/* 2392 */           Scene scene = SceneManager.getInstance().getScene(this.position);
/* 2393 */           if (scene != null)
/*      */           {
/* 2395 */             if (canMeetMonster())
/*      */             {
/* 2397 */               scene.tryMeetMonster(this);
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */       
/* 2403 */       if (isInHuSongState())
/*      */       {
/* 2405 */         detectedHuSong();
/*      */       }
/*      */     }
/*      */     
/* 2409 */     this.lastTraceTime = time;
/*      */   }
/*      */   
/*      */ 
/*      */   private void detectedHuSong()
/*      */   {
/* 2415 */     long roleId = getRoleId();
/* 2416 */     int npcId = getHusongTargetNpcId();
/* 2417 */     if (MapManager.isNearByNPC(roleId, npcId))
/*      */     {
/* 2419 */       if (setHusongState(false, true))
/*      */       {
/* 2421 */         SSyncEndHuSong syncEndHuSong = new SSyncEndHuSong();
/* 2422 */         MapProtocolSendQueue.getInstance().send(roleId, syncEndHuSong);
/*      */         
/* 2424 */         huSongArraived();
/*      */         
/* 2426 */         unsetHuSong();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void unSetFlyState()
/*      */   {
/* 2433 */     long roleId = getRoleId();
/* 2434 */     List<Long> roleIdList = new ArrayList();
/* 2435 */     roleIdList.add(Long.valueOf(roleId));
/* 2436 */     setFlySpeed(0);
/*      */     
/* 2438 */     MapTeamData teamData = MapTeamManager.getInstance().getTeamById(this.teamId);
/* 2439 */     if (teamData != null)
/*      */     {
/* 2441 */       roleIdList.addAll(teamData.getInTeamMember());
/*      */     }
/* 2443 */     MapGroupData mapGroupData = MapGroupManager.getInstance().getMapGroupData(this.groupType, this.groupid);
/* 2444 */     if (mapGroupData != null)
/*      */     {
/* 2446 */       roleIdList.addAll(mapGroupData.getOtherMemebersForInner());
/*      */     }
/* 2448 */     for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long tempRoleid = ((Long)i$.next()).longValue();
/*      */       
/* 2450 */       if (roleId != tempRoleid)
/*      */       {
/*      */ 
/*      */ 
/* 2454 */         MapRole mapRole = MapObjectInstanceManager.getInstance().getMapRole(tempRoleid);
/* 2455 */         if (mapRole != null)
/*      */         {
/* 2457 */           mapRole.setFlySpeed(0);
/*      */         }
/*      */       }
/*      */     }
/* 2461 */     new PUnsetFlyStatus(roleIdList).execute();
/*      */   }
/*      */   
/*      */   public int getChannelid()
/*      */   {
/* 2466 */     return this.channelid;
/*      */   }
/*      */   
/*      */   public void setChannelid(int channelid)
/*      */   {
/* 2471 */     this.channelid = channelid;
/*      */   }
/*      */   
/*      */ 
/*      */   public PositionWithExtraInfo getPositionWithExtraInfo()
/*      */   {
/* 2477 */     Scene scene = SceneManager.getInstance().getScene(this.position);
/* 2478 */     int mapCfgid = scene == null ? 0 : scene.getCfgId();
/* 2479 */     return new UnModifyPositionWithExtraInfo(this.position, mapCfgid, this.channelid);
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\object\MapRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */