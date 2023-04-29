/*     */ package mzm.gsp.map.main.scene.object;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.map.MapModelInfo;
/*     */ import mzm.gsp.map.SModelNPCEnterView;
/*     */ import mzm.gsp.map.SNPCEnterView;
/*     */ import mzm.gsp.map.SNPCLeaveView;
/*     */ import mzm.gsp.map.confbean.Point;
/*     */ import mzm.gsp.map.confbean.SMapConfig;
/*     */ import mzm.gsp.map.confbean.SMapNPC;
/*     */ import mzm.gsp.map.confbean.StateSet;
/*     */ import mzm.gsp.map.main.MapConfiguration;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.MapObjectManager;
/*     */ import mzm.gsp.map.main.WorldInstance;
/*     */ import mzm.gsp.map.main.WorldManager;
/*     */ import mzm.gsp.map.main.ai.fsm.AIManager;
/*     */ import mzm.gsp.map.main.ai.fsm.MoveState;
/*     */ import mzm.gsp.map.main.ai.fsm.NormalState;
/*     */ import mzm.gsp.map.main.ai.path.MoveController;
/*     */ import mzm.gsp.map.main.ai.path.Path;
/*     */ import mzm.gsp.map.main.ai.path.PathNode;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.TransferType;
/*     */ import mzm.gsp.map.main.scene.view.CircleView;
/*     */ import mzm.gsp.map.main.scene.view.IView;
/*     */ import mzm.gsp.npc.confbean.SNpc;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.task.main.TaskInterface.TaskState;
/*     */ import xio.Protocol;
/*     */ 
/*     */ public class MapNPC extends BaseMapAIObjectAndControllerObject
/*     */ {
/*     */   private final MapNpcId objid;
/*     */   private SMapNPC npcCfg;
/*     */   
/*     */   public MapNPC(Scene scene, SMapConfig mapConfig, SMapNPC cfg)
/*     */   {
/*  46 */     this.objid = new MapNpcId(sceneObjIdGenerator.nextId());
/*  47 */     this.npcCfg = cfg;
/*  48 */     this.velocity = this.npcCfg.velocity;
/*  49 */     this.direction = this.npcCfg.dir;
/*     */     
/*  51 */     SNpc npcData = NpcInterface.getNpc(this.npcCfg.templateId);
/*  52 */     this.controllerId = npcData.controllerId;
/*     */     
/*  54 */     this.isVisible = npcData.isVisible;
/*  55 */     this.modelId = npcData.monsterModelTableId;
/*     */     
/*  57 */     this.view = new CircleView(this, MapConfiguration.VIEW_WIDTH);
/*     */     
/*     */ 
/*  60 */     this.position = new Position(this.npcCfg.orignalPoint.posX, this.npcCfg.orignalPoint.posY, 0, scene.getId());
/*     */     
/*  62 */     if (this.npcCfg.pathPoints.size() > 1)
/*     */     {
/*     */ 
/*  65 */       MoveController controller = new MoveController(this);
/*  66 */       Path path = new Path();
/*  67 */       for (Point pt : this.npcCfg.pathPoints)
/*     */       {
/*  69 */         PathNode pn = new PathNode(pt.posX * mapConfig.cellWidth, pt.posY * mapConfig.cellHeight, 0);
/*  70 */         pn.setStayTime(pt.stayTime);
/*  71 */         pn.setHideType(pt.hideType);
/*  72 */         path.add(pn);
/*     */       }
/*  74 */       controller.resetPath(path, this.npcCfg.pathType);
/*     */       
/*     */ 
/*  77 */       this.aiManager = new AIManager(this);
/*  78 */       MoveState moveState = new MoveState(this.aiManager, controller);
/*  79 */       NormalState state = new NormalState(this.aiManager);
/*  80 */       this.aiManager.initialize(state, null, moveState);
/*     */     }
/*  82 */     this.targetPos = new Position(this.position);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public MapNpcId getObjectId()
/*     */   {
/*  92 */     return this.objid;
/*     */   }
/*     */   
/*     */   public int getNpcId()
/*     */   {
/*  97 */     return this.objid.getId().intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCfgId()
/*     */   {
/* 107 */     return Integer.valueOf(this.npcCfg.templateId);
/*     */   }
/*     */   
/*     */   public Map<Integer, StateSet> getVisibleTaskState()
/*     */   {
/* 112 */     return this.npcCfg.visibleByTaskState;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getName()
/*     */   {
/* 118 */     return this.npcCfg.name;
/*     */   }
/*     */   
/*     */   public int getControllerId()
/*     */   {
/* 123 */     return this.controllerId;
/*     */   }
/*     */   
/*     */   public boolean isVisible()
/*     */   {
/* 128 */     SNpc npcData = NpcInterface.getNpc(this.npcCfg.templateId);
/* 129 */     if (npcData == null)
/*     */     {
/* 131 */       return this.isVisible;
/*     */     }
/*     */     
/* 134 */     return npcData.isVisible;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getModelId()
/*     */   {
/* 140 */     return this.modelId;
/*     */   }
/*     */   
/*     */   public void spawnMe(TransferType type)
/*     */   {
/* 145 */     MapObjectInstanceManager.getInstance().addMapNPC(this);
/*     */     
/* 147 */     super.spawnMe(this.position.getX(), this.position.getY(), this.position.getZ(), this.position.getSceneId(), type);
/*     */   }
/*     */   
/*     */ 
/*     */   public void spawnMe(int x, int y, int z, int sceneId, TransferType type)
/*     */   {
/* 153 */     MapObjectInstanceManager.getInstance().addMapNPC(this);
/*     */     
/* 155 */     super.spawnMe(x, y, z, sceneId, type);
/*     */   }
/*     */   
/*     */   public void fillMapModelInfo(MapModelInfo modelInfo)
/*     */   {
/* 160 */     modelInfo.model.modelid = getModelId();
/* 161 */     modelInfo.velocity = getVelocity();
/*     */   }
/*     */   
/*     */   private Protocol createDefaultEnterView()
/*     */   {
/* 166 */     SNPCEnterView enterView = new SNPCEnterView();
/* 167 */     enterView.npcid = getCfgId().intValue();
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
/* 178 */     return enterView;
/*     */   }
/*     */   
/*     */ 
/*     */   public Protocol createEnterView()
/*     */   {
/* 184 */     WorldInstance worldInstance = getWorldInstance();
/* 185 */     if (worldInstance == null)
/*     */     {
/* 187 */       return null;
/*     */     }
/* 189 */     if (worldInstance == WorldManager.getInstance().getBigWorldInstance())
/*     */     {
/* 191 */       Octets mapModelInfo = MapObjectManager.getInstance().getNpcModelInfo(getCfgId().intValue());
/* 192 */       if (mapModelInfo != null)
/*     */       {
/* 194 */         return createModelNpcEnterView(mapModelInfo);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 199 */       Octets mapModelInfo = worldInstance.getCloneRoleNpcModelData(getCfgId().intValue());
/* 200 */       if (mapModelInfo != null)
/*     */       {
/* 202 */         return createModelNpcEnterView(mapModelInfo);
/*     */       }
/*     */     }
/*     */     
/* 206 */     return createDefaultEnterView();
/*     */   }
/*     */   
/*     */ 
/*     */   public Protocol createLeaveView()
/*     */   {
/* 212 */     SNPCLeaveView leaveView = new SNPCLeaveView();
/* 213 */     leaveView.npcid = getCfgId().intValue();
/* 214 */     return leaveView;
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
/*     */   public Protocol createMoveProtocol()
/*     */   {
/* 230 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCanSee(MapRole role)
/*     */   {
/* 236 */     if (this.isVisible)
/*     */     {
/* 238 */       return true;
/*     */     }
/* 240 */     if (role.getHusongTargetNpcId() == getCfgId().intValue())
/*     */     {
/* 242 */       return true;
/*     */     }
/* 244 */     Map<Integer, StateSet> needTaskState = getVisibleTaskState();
/* 245 */     Map<Integer, TaskInterface.TaskState> roleTaskState = role.getRoleTaskMap();
/* 246 */     if (roleTaskState == null)
/*     */     {
/* 248 */       return false;
/*     */     }
/* 250 */     Iterator<Integer> needTaskIdit = needTaskState.keySet().iterator();
/* 251 */     StateSet needState; while (needTaskIdit.hasNext())
/*     */     {
/* 253 */       int needTaskId = ((Integer)needTaskIdit.next()).intValue();
/* 254 */       TaskInterface.TaskState state = (TaskInterface.TaskState)roleTaskState.get(Integer.valueOf(needTaskId));
/* 255 */       if (state != null)
/*     */       {
/*     */ 
/*     */ 
/* 259 */         needState = (StateSet)needTaskState.get(Integer.valueOf(needTaskId));
/* 260 */         for (Integer ts : state.getStateSet())
/*     */         {
/* 262 */           if (needState.stateSet.contains(ts))
/*     */           {
/* 264 */             return true; }
/*     */         }
/*     */       }
/*     */     }
/* 268 */     return false;
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
/*     */   public void stay(long time) {}
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
/*     */   public void onMove() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int tryStartFight()
/*     */   {
/* 303 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isStartFightSuccess()
/*     */   {
/* 309 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public void destroy()
/*     */   {
/* 315 */     this.isVisible = false;
/* 316 */     Collection<MapRole> mapRoles = getView().getPlayers();
/* 317 */     for (MapRole mapRole : mapRoles)
/*     */     {
/*     */ 
/* 320 */       mapRole.updateView();
/*     */     }
/*     */     
/* 323 */     notifyDead();
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onDestroy()
/*     */   {
/* 329 */     MapObjectInstanceManager.getInstance().removeMapNPC(getNpcId());
/*     */   }
/*     */   
/*     */   private SModelNPCEnterView createModelNpcEnterView(Octets modelInfo)
/*     */   {
/* 334 */     SModelNPCEnterView modelNPCEnterView = new SModelNPCEnterView();
/* 335 */     modelNPCEnterView.npcid = getCfgId().intValue();
/* 336 */     modelNPCEnterView.modelinfo = modelInfo;
/* 337 */     Position pos = getPositionForInner();
/* 338 */     modelNPCEnterView.posinit.curx = pos.getX();
/* 339 */     modelNPCEnterView.posinit.cury = pos.getY();
/* 340 */     modelNPCEnterView.posinit.direction = getDirection();
/* 341 */     Position target = getTargetPosForInner();
/* 342 */     modelNPCEnterView.posinit.targetx = target.getX();
/* 343 */     modelNPCEnterView.posinit.targety = target.getY();
/* 344 */     return modelNPCEnterView;
/*     */   }
/*     */   
/*     */   public void updateModel()
/*     */   {
/* 349 */     Octets mapModelInfo = MapObjectManager.getInstance().getNpcModelInfo(getCfgId().intValue());
/* 350 */     if (mapModelInfo != null)
/*     */     {
/* 352 */       Protocol core = createModelNpcEnterView(mapModelInfo);
/* 353 */       sendToView(core);
/*     */     }
/*     */   }
/*     */   
/*     */   public void updateModel(Octets mapModelInfo)
/*     */   {
/* 359 */     Protocol core = mapModelInfo == null ? createDefaultEnterView() : createModelNpcEnterView(mapModelInfo);
/*     */     
/* 361 */     sendToView(core);
/*     */   }
/*     */   
/*     */ 
/*     */   public java.util.List<? extends SceneObject> refresh(long worldId, int maxSpawnNum)
/*     */   {
/* 367 */     this.isVisible = true;
/* 368 */     syncView();
/* 369 */     notifyBorn();
/* 370 */     return Arrays.asList(new MapNPC[] { this });
/*     */   }
/*     */   
/*     */   private void syncView()
/*     */   {
/* 375 */     for (MapRole role : getView().getPlayers())
/*     */     {
/*     */ 
/* 378 */       role.updateView();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\object\MapNPC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */