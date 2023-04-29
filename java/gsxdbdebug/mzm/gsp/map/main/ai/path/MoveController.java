/*     */ package mzm.gsp.map.main.ai.path;
/*     */ 
/*     */ import java.awt.Point;
/*     */ import mzm.gsp.map.main.MapConfiguration;
/*     */ import mzm.gsp.map.main.ai.IMapAIObject;
/*     */ import mzm.gsp.map.main.ai.path.pathtype.PathTypeFactory;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MoveController
/*     */ {
/*     */   protected IMapAIObject _owner;
/*     */   protected Path _curPath;
/*  20 */   protected long lastMoveTime = 0L;
/*     */   protected IPathTypeStrategy strategy;
/*     */   protected long delayTime;
/*  23 */   protected Point speedVec = new Point();
/*     */   protected int moveDistPerUpdateAcculate;
/*     */   protected int targetDistance;
/*     */   
/*     */   public MoveController(IMapAIObject owner)
/*     */   {
/*  29 */     this._owner = owner;
/*  30 */     this.delayTime = (MapConfiguration.NPC_STEP_LENGTH * 1000 / owner.getVelocity());
/*     */   }
/*     */   
/*     */   protected PathNode nextStep()
/*     */   {
/*  35 */     return this._curPath.get(this.strategy.nextIdx());
/*     */   }
/*     */   
/*     */   public PathNode getTarget()
/*     */   {
/*  40 */     if (this.strategy.isEnd())
/*     */     {
/*  42 */       return null;
/*     */     }
/*  44 */     int index = this.strategy.getNextIdx();
/*  45 */     if (index == -1)
/*     */     {
/*  47 */       return null;
/*     */     }
/*  49 */     return this._curPath.get(index);
/*     */   }
/*     */   
/*     */   public void resetPath(Path newPath, int type)
/*     */   {
/*  54 */     newPath.setStartTime(-1L);
/*     */     
/*  56 */     this._curPath = newPath;
/*  57 */     updateStrategyForType(type);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean startMove()
/*     */   {
/*  63 */     long startTime = DateTimeUtils.getCurrTimeInMillis();
/*  64 */     PathNode target = getTarget();
/*  65 */     if (target == null)
/*     */     {
/*  67 */       return false;
/*     */     }
/*  69 */     Position curPos = this._owner.getPosition();
/*  70 */     int diffX = target.getX() - curPos.getX();
/*  71 */     int diffY = target.getY() - curPos.getY();
/*  72 */     int distance = (int)Math.sqrt(Math.pow(diffX, 2.0D) + Math.pow(diffY, 2.0D));
/*  73 */     float costTime = distance / this._owner.getVelocity();
/*  74 */     if (costTime == 0.0F)
/*     */     {
/*  76 */       return false;
/*     */     }
/*  78 */     this._owner.setTargetPos(target.getX(), target.getY(), target.getZ());
/*  79 */     this.lastMoveTime = startTime;
/*  80 */     this.speedVec.setLocation(diffX / costTime, diffY / costTime);
/*  81 */     this.targetDistance = distance;
/*  82 */     this.moveDistPerUpdateAcculate = 0;
/*  83 */     this.delayTime = 0L;
/*  84 */     this._owner.onMove();
/*  85 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void update(long updateTime)
/*     */   {
/*  95 */     if (this.strategy.isEnd())
/*     */     {
/*  97 */       return;
/*     */     }
/*  99 */     long useTime = updateTime - this.lastMoveTime;
/* 100 */     if (useTime <= 0L)
/*     */     {
/* 102 */       return;
/*     */     }
/* 104 */     this.lastMoveTime = updateTime;
/*     */     
/* 106 */     int x = (int)(this.speedVec.x * useTime / 1000L);
/* 107 */     int y = (int)(this.speedVec.y * useTime / 1000L);
/* 108 */     Position pos = this._owner.getPosition();
/* 109 */     this.moveDistPerUpdateAcculate = ((int)(this.moveDistPerUpdateAcculate + this._owner.getVelocity() * useTime / 1000L));
/*     */     
/* 111 */     if (this.moveDistPerUpdateAcculate >= this.targetDistance)
/*     */     {
/* 113 */       PathNode pn = getTarget();
/* 114 */       pn.execute(this._owner);
/* 115 */       if (pn.getStayTime() > 0)
/*     */       {
/* 117 */         this.delayTime = (pn.getStayTime() * 1000 + updateTime);
/*     */       }
/* 119 */       if ((nextStep() != null) && (this.delayTime == 0L))
/*     */       {
/* 121 */         startMove();
/*     */       }
/* 123 */       return;
/*     */     }
/*     */     
/* 126 */     this._owner.setXYZ(pos.getX() + x, pos.getY() + y, pos.getZ());
/*     */   }
/*     */   
/*     */   private void updateStrategyForType(int type)
/*     */   {
/* 131 */     this.strategy = PathTypeFactory.createByPathType(type, this._curPath);
/*     */   }
/*     */   
/*     */   public long getDelayTime()
/*     */   {
/* 136 */     return this.delayTime;
/*     */   }
/*     */   
/*     */   public boolean isEnd()
/*     */   {
/* 141 */     return this.strategy.isEnd();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\ai\path\MoveController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */