/*     */ package mzm.gsp.map.main.scene.object;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.map.SNotifyPlayEffect;
/*     */ import mzm.gsp.map.confbean.SMapConfig;
/*     */ import mzm.gsp.map.main.IdGenerator;
/*     */ import mzm.gsp.map.main.WorldInstance;
/*     */ import mzm.gsp.map.main.ai.fsm.AIManager;
/*     */ import mzm.gsp.map.main.proto.Cell;
/*     */ import mzm.gsp.map.main.scene.Grid;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.PositionWithCfgid;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.SceneManager;
/*     */ import mzm.gsp.map.main.scene.TransferType;
/*     */ import mzm.gsp.map.main.scene.UnModifyPosition;
/*     */ import mzm.gsp.map.main.scene.UnModifyPositionWithCfgid;
/*     */ import mzm.gsp.map.main.scene.view.IView;
/*     */ import org.apache.log4j.Logger;
/*     */ import xio.Protocol;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class SceneObject
/*     */ {
/*  27 */   private static final Logger logger = Logger.getLogger(SceneObject.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  32 */   protected static final IdGenerator sceneObjIdGenerator = new IdGenerator(1, 1);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int STATE_NONE = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int STATE_FIGHT = 1;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int STATE_DELAY_SET_NONE_EXTERIORID = 2;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int STATE_MAP_ENTITY_STAY = 4;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int STATE_LIMIT_POLYGON_MOVEMENT = 8;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int STATE_BROADCAST_POS_IN_SCENE = 16;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int STATE_LIMIT_MOVEMENT = 32;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected int modelId;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected String name;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  82 */   protected Position position = new Position(0, 0, 0, 0);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected Position targetPos;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  92 */   protected boolean isVisible = true;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  97 */   protected int direction = 135;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected IView view;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected Grid grid;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 112 */   protected Cell cell = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 117 */   protected boolean isTeleporting = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected AIManager aiManager;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 127 */   protected volatile int state = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 132 */   protected int velocity = 180;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 137 */   protected boolean isActiveAttack = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 142 */   protected volatile boolean isAlive = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 147 */   protected List<ISceneObjectListener> listeners = new ArrayList();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 152 */   protected boolean targetDirty = true;
/*     */   
/*     */   public Position getPositionForInner()
/*     */   {
/* 156 */     return this.position;
/*     */   }
/*     */   
/*     */   public Position getPosition()
/*     */   {
/* 161 */     return new UnModifyPosition(this.position);
/*     */   }
/*     */   
/*     */   public PositionWithCfgid getPositionWithExtraInfo()
/*     */   {
/* 166 */     Scene scene = SceneManager.getInstance().getScene(this.position);
/* 167 */     int mapCfgid = scene == null ? 0 : scene.getCfgId();
/* 168 */     return new UnModifyPositionWithCfgid(this.position, mapCfgid);
/*     */   }
/*     */   
/*     */   public int getMapCfgid()
/*     */   {
/* 173 */     Scene scene = SceneManager.getInstance().getScene(this.position);
/* 174 */     return scene == null ? 0 : scene.getCfgId();
/*     */   }
/*     */   
/*     */   public abstract SceneObjectId getObjectId();
/*     */   
/*     */   public void notifyBorn()
/*     */   {
/* 181 */     for (ISceneObjectListener listener : this.listeners)
/*     */     {
/* 183 */       listener.onBorn(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public void notifyDead()
/*     */   {
/* 189 */     for (ISceneObjectListener listener : this.listeners)
/*     */     {
/* 191 */       listener.onDead(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public void broadcastPlayEffectInScene(int effectCfgid)
/*     */   {
/* 197 */     Scene scene = SceneManager.getInstance().getScene(this.position);
/* 198 */     if (scene == null)
/*     */     {
/* 200 */       return;
/*     */     }
/*     */     
/* 203 */     SNotifyPlayEffect core = new SNotifyPlayEffect();
/* 204 */     core.effect_cfgid = effectCfgid;
/* 205 */     scene.broadcast(core);
/*     */   }
/*     */   
/*     */   public void addListener(ISceneObjectListener listener)
/*     */   {
/* 210 */     this.listeners.add(listener);
/*     */   }
/*     */   
/*     */   public void removeListener(ISceneObjectListener listener)
/*     */   {
/* 215 */     this.listeners.remove(listener);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onSpawn() {}
/*     */   
/*     */ 
/*     */   public void spawnMe(int x, int y, int z, int sceneId, int channelid, TransferType type)
/*     */   {
/* 225 */     if (this.isAlive)
/*     */     {
/* 227 */       return;
/*     */     }
/*     */     
/* 230 */     Position pos = new Position(x, y, z, sceneId);
/* 231 */     Scene scene = SceneManager.getInstance().getScene(pos);
/* 232 */     if (scene == null)
/*     */     {
/* 234 */       return;
/*     */     }
/* 236 */     SMapConfig mapConfig = scene.getMapConfig();
/* 237 */     if (mapConfig == null)
/*     */     {
/* 239 */       return;
/*     */     }
/*     */     
/* 242 */     this.isAlive = true;
/*     */     
/* 244 */     this.position = pos;
/*     */     
/* 246 */     scene.addSceneObject(this, type);
/*     */     
/* 248 */     this.targetPos = new Position(pos);
/*     */     
/* 250 */     this.cell = scene.getCell(mapConfig, x, y);
/*     */     
/* 252 */     setXYZ(x, y, z);
/*     */     
/* 254 */     onSpawn();
/*     */     
/* 256 */     notifyBorn();
/*     */   }
/*     */   
/*     */   public void spawnMe(int x, int y, int z, int sceneId, TransferType type)
/*     */   {
/* 261 */     spawnMe(x, y, z, sceneId, Integer.MAX_VALUE, type);
/*     */   }
/*     */   
/*     */   public void spawnMe(TransferType type)
/*     */   {
/* 266 */     spawnMe(this.position.getX(), this.position.getY(), this.position.getZ(), this.position.getSceneId(), type);
/*     */   }
/*     */   
/*     */   public boolean isCanSee(MapRole role)
/*     */   {
/* 271 */     return isAlive();
/*     */   }
/*     */   
/*     */   public boolean isSameGroup(MapRole role)
/*     */   {
/* 276 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isFollower()
/*     */   {
/* 281 */     return false;
/*     */   }
/*     */   
/*     */   protected abstract void onDestroy();
/*     */   
/*     */   public void destroy()
/*     */   {
/* 288 */     if (!this.isAlive)
/*     */     {
/* 290 */       return;
/*     */     }
/*     */     
/* 293 */     this.isAlive = false;
/*     */     
/* 295 */     Scene scene = SceneManager.getInstance().getScene(this.position);
/* 296 */     if (scene != null)
/*     */     {
/* 298 */       scene.removeSceneObject(this);
/*     */     }
/*     */     
/* 301 */     notifyDead();
/*     */     
/* 303 */     onDestroy();
/*     */   }
/*     */   
/*     */   public boolean isAlive()
/*     */   {
/* 308 */     return this.isAlive;
/*     */   }
/*     */   
/*     */   public boolean isVisible()
/*     */   {
/* 313 */     return this.isVisible;
/*     */   }
/*     */   
/*     */   public int getSceneId()
/*     */   {
/* 318 */     return this.position.getSceneId();
/*     */   }
/*     */   
/*     */   public WorldInstance getWorldInstance()
/*     */   {
/* 323 */     Scene scene = SceneManager.getInstance().getScene(this.position);
/* 324 */     if (scene == null)
/*     */     {
/* 326 */       return null;
/*     */     }
/* 328 */     return scene.getWorld();
/*     */   }
/*     */   
/*     */   public void setXYZ(int x, int y, int z)
/*     */   {
/* 333 */     Scene scene = SceneManager.getInstance().getScene(this.position);
/* 334 */     if (scene == null)
/*     */     {
/*     */ 
/* 337 */       return;
/*     */     }
/*     */     
/* 340 */     this.direction = direction(x, y, this.targetPos.getX(), this.targetPos.getY());
/* 341 */     this.position.setXYZ(x, y, z);
/*     */     
/* 343 */     Grid oldGrid = this.grid;
/* 344 */     this.grid = scene.getGrid(this.position);
/* 345 */     if (this.grid == null)
/*     */     {
/* 347 */       logger.error(String.format("[map]SceneObject.setXYZ@map grid pos out of boundary|map_cfgid=%d|x=%d|y=%d|scene_objid=%s", new Object[] { Integer.valueOf(scene.getCfgId()), Integer.valueOf(this.position.getX()), Integer.valueOf(this.position.getY()), getObjectId().toString() }));
/*     */       
/*     */ 
/*     */ 
/* 351 */       return;
/*     */     }
/*     */     
/* 354 */     if (oldGrid != this.grid)
/*     */     {
/* 356 */       if (oldGrid != null)
/*     */       {
/* 358 */         oldGrid.removeSceneObj(this);
/*     */       }
/*     */       
/* 361 */       this.grid.addSceneObj(this);
/*     */     }
/*     */     
/* 364 */     this.grid.onMove(this);
/*     */     
/* 366 */     this.targetDirty = false;
/*     */   }
/*     */   
/*     */   public void setState(int state)
/*     */   {
/* 371 */     this.state |= state;
/*     */   }
/*     */   
/*     */   public void unsetState(int state)
/*     */   {
/* 376 */     this.state &= (state ^ 0xFFFFFFFF);
/*     */   }
/*     */   
/*     */   public boolean isState(int state)
/*     */   {
/* 381 */     return (this.state & state) == state;
/*     */   }
/*     */   
/*     */   public boolean isFightState()
/*     */   {
/* 386 */     return (this.state & 0x1) == 1;
/*     */   }
/*     */   
/*     */   public boolean isMoveState()
/*     */   {
/* 391 */     return !this.targetPos.equals(this.position);
/*     */   }
/*     */   
/*     */   protected int direction(int cx, int cy, int tx, int ty)
/*     */   {
/* 396 */     if ((cx == tx) && (cy == ty))
/*     */     {
/* 398 */       return this.direction;
/*     */     }
/*     */     
/* 401 */     int[] v1 = { 1, 0 };
/* 402 */     int[] v2 = { tx - cx, ty - cy };
/* 403 */     int dot = v1[0] * v2[0] + v1[1] * v2[1];
/* 404 */     double magnitudeV2 = Math.sqrt(v2[0] * v2[0] + v2[1] * v2[1]);
/* 405 */     double degree = Math.toDegrees(Math.acos(dot / magnitudeV2));
/* 406 */     if (v2[1] < 0)
/*     */     {
/* 408 */       return (int)(450.0D - degree);
/*     */     }
/*     */     
/*     */ 
/* 412 */     return (int)(degree + 90.0D);
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
/*     */   public boolean teleToLocation(int x, int y, int z, int sceneId, TransferType type)
/*     */   {
/* 427 */     setTeleporting(true);
/*     */     try
/*     */     {
/* 430 */       Scene oldScene = SceneManager.getInstance().getScene(this.position);
/* 431 */       Scene newScene = SceneManager.getInstance().getScene(sceneId);
/* 432 */       this.position.setXYZ(x, y, z);
/* 433 */       if (oldScene != newScene)
/*     */       {
/* 435 */         this.position.setSceneId(sceneId);
/* 436 */         if (oldScene != null)
/*     */         {
/* 438 */           oldScene.removeSceneObject(this);
/*     */         }
/* 440 */         if (newScene != null)
/*     */         {
/* 442 */           newScene.addSceneObject(this, type);
/*     */         }
/*     */       }
/*     */       
/* 446 */       this.targetPos.setXYZ(x, y, z);
/*     */       
/* 448 */       setXYZ(x, y, z);
/*     */     }
/*     */     finally
/*     */     {
/* 452 */       setTeleporting(false);
/*     */     }
/*     */     
/* 455 */     return true;
/*     */   }
/*     */   
/*     */   public void update(long time)
/*     */   {
/* 460 */     if (this.aiManager != null)
/*     */     {
/* 462 */       this.aiManager.updateAI(time);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isActivity()
/*     */   {
/* 468 */     return this.view != null;
/*     */   }
/*     */   
/*     */   public boolean updateView()
/*     */   {
/* 473 */     if (this.view != null)
/*     */     {
/* 475 */       return this.view.validateView();
/*     */     }
/*     */     
/* 478 */     return true;
/*     */   }
/*     */   
/*     */   public void clearView()
/*     */   {
/* 483 */     if (this.view != null)
/*     */     {
/* 485 */       this.view.clearView();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isTeleporting()
/*     */   {
/* 491 */     return this.isTeleporting;
/*     */   }
/*     */   
/*     */   public void setTeleporting(boolean isTeleporting)
/*     */   {
/* 496 */     this.isTeleporting = isTeleporting;
/*     */   }
/*     */   
/*     */   public IView getView()
/*     */   {
/* 501 */     return this.view;
/*     */   }
/*     */   
/*     */   public Grid getGrid()
/*     */   {
/* 506 */     return this.grid;
/*     */   }
/*     */   
/*     */   public void setGrid(Grid _grid)
/*     */   {
/* 511 */     this.grid = _grid;
/*     */   }
/*     */   
/*     */   public void setDirection(int dir)
/*     */   {
/* 516 */     this.direction = dir;
/*     */   }
/*     */   
/*     */   public int getDirection()
/*     */   {
/* 521 */     return this.direction;
/*     */   }
/*     */   
/*     */   public int getVelocity()
/*     */   {
/* 526 */     return this.velocity;
/*     */   }
/*     */   
/*     */   public void setVelocity(int velocity)
/*     */   {
/* 531 */     this.velocity = velocity;
/*     */   }
/*     */   
/*     */   public void setPosition(int x, int y, int z, int sceneId)
/*     */   {
/* 536 */     this.position = new Position(x, y, z, sceneId);
/* 537 */     this.targetPos = new Position(this.position);
/*     */   }
/*     */   
/*     */   public int getModelId()
/*     */   {
/* 542 */     return this.modelId;
/*     */   }
/*     */   
/*     */   public void setModelId(int modelId)
/*     */   {
/* 547 */     if (this.modelId != modelId) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 552 */     this.modelId = modelId;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 557 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name)
/*     */   {
/* 562 */     this.name = name;
/*     */   }
/*     */   
/*     */   public Position getTargetPosForInner()
/*     */   {
/* 567 */     return this.targetPos;
/*     */   }
/*     */   
/*     */   public Position getTargetPos()
/*     */   {
/* 572 */     return new UnModifyPosition(this.targetPos);
/*     */   }
/*     */   
/*     */   public void setTargetPos(Position targetPos)
/*     */   {
/* 577 */     this.targetPos = targetPos;
/* 578 */     this.targetDirty = true;
/*     */   }
/*     */   
/*     */   public Cell getCell()
/*     */   {
/* 583 */     return this.cell;
/*     */   }
/*     */   
/*     */   public void setCell(Cell cell)
/*     */   {
/* 588 */     this.cell = cell;
/*     */   }
/*     */   
/*     */   public AIManager getAiManager()
/*     */   {
/* 593 */     return this.aiManager;
/*     */   }
/*     */   
/*     */   public boolean isActiveAttack()
/*     */   {
/* 598 */     return this.isActiveAttack;
/*     */   }
/*     */   
/*     */ 
/*     */   public abstract Protocol createEnterView();
/*     */   
/*     */   public abstract Protocol createLeaveView();
/*     */   
/*     */   public abstract Protocol createMoveProtocol();
/*     */   
/*     */   public String toString()
/*     */   {
/* 610 */     return "SceneObject [id=" + getObjectId() + "modelId=" + this.modelId + ", name=" + getName() + ", _position=" + this.position + ", _targetPos=" + this.targetPos + ", _direction=" + this.direction + ", _grid=" + this.grid + ", _view=" + this.view + ", _isTeleporting=" + this.isTeleporting + ", _aiManager=" + this.aiManager + ", m_state=" + this.state + ", velocity=" + this.velocity + ", cell=" + this.cell + "]";
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
/*     */   public int acceptEnterView(SceneObject other, boolean delaySync)
/*     */   {
/* 632 */     return 1;
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
/*     */   public int acceptMoveView(SceneObject other, boolean delaySync)
/*     */   {
/* 651 */     return 0;
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
/*     */   public int acceptLeaveView(SceneObject other, boolean delaySync)
/*     */   {
/* 671 */     return 0;
/*     */   }
/*     */   
/*     */   public void setTargetPos(int x, int y, int z)
/*     */   {
/* 676 */     this.targetPos.setXYZ(x, y, z);
/* 677 */     this.targetDirty = true;
/*     */   }
/*     */   
/*     */   public void setTargetPos(int x, int y, int z, int sceneId)
/*     */   {
/* 682 */     this.targetPos.setXYZ(x, y, z);
/* 683 */     this.targetPos.setSceneId(sceneId);
/* 684 */     this.targetDirty = true;
/*     */   }
/*     */   
/*     */   public boolean isTargetDirty()
/*     */   {
/* 689 */     return this.targetDirty;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\object\SceneObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */