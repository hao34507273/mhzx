/*     */ package mzm.gsp.map.main.scene;
/*     */ 
/*     */ import com.thoughtworks.xstream.annotations.XStreamAlias;
/*     */ import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
/*     */ 
/*     */ public class Position
/*     */ {
/*     */   @XStreamAlias("x")
/*     */   @XStreamAsAttribute
/*     */   protected int _x;
/*     */   @XStreamAlias("y")
/*     */   @XStreamAsAttribute
/*     */   protected int _y;
/*     */   @XStreamAlias("z")
/*     */   @XStreamAsAttribute
/*     */   protected int _z;
/*     */   @XStreamAlias("sceneid")
/*     */   @XStreamAsAttribute
/*     */   protected int _sceneId;
/*     */   
/*     */   public Position(int _x, int _y, int _z, int _sceneId)
/*     */   {
/*  23 */     this._x = _x;
/*  24 */     this._y = _y;
/*  25 */     this._z = _z;
/*  26 */     this._sceneId = _sceneId;
/*     */   }
/*     */   
/*     */   public Position(Position target)
/*     */   {
/*  31 */     this._x = target.getX();
/*  32 */     this._y = target.getY();
/*  33 */     this._z = target.getZ();
/*  34 */     this._sceneId = target.getSceneId();
/*     */   }
/*     */   
/*     */   public void setXYZ(int x, int y, int z)
/*     */   {
/*  39 */     this._x = x;
/*  40 */     this._y = y;
/*  41 */     this._z = z;
/*     */   }
/*     */   
/*     */   public int getX()
/*     */   {
/*  46 */     return this._x;
/*     */   }
/*     */   
/*     */   public void setX(int x)
/*     */   {
/*  51 */     this._x = x;
/*     */   }
/*     */   
/*     */   public int getY()
/*     */   {
/*  56 */     return this._y;
/*     */   }
/*     */   
/*     */   public void setY(int y)
/*     */   {
/*  61 */     this._y = y;
/*     */   }
/*     */   
/*     */   public int getZ()
/*     */   {
/*  66 */     return this._z;
/*     */   }
/*     */   
/*     */   public void setZ(int z)
/*     */   {
/*  71 */     this._z = z;
/*     */   }
/*     */   
/*     */   public int getSceneId()
/*     */   {
/*  76 */     return this._sceneId;
/*     */   }
/*     */   
/*     */   public void setSceneId(int id)
/*     */   {
/*  81 */     this._sceneId = id;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/*  87 */     return "Position [_x=" + this._x + ", _y=" + this._y + ", _z=" + this._z + ", _sceneId=" + this._sceneId + "]";
/*     */   }
/*     */   
/*     */   protected Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  93 */     return new Position(this._x, this._y, this._z, this._sceneId);
/*     */   }
/*     */   
/*     */ 
/*     */   public int hashCode()
/*     */   {
/*  99 */     return this._sceneId ^ this._x ^ this._y ^ this._z;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean equals(Object rhs)
/*     */   {
/* 105 */     if (rhs == this)
/*     */     {
/* 107 */       return true;
/*     */     }
/*     */     
/* 110 */     if ((rhs instanceof Position))
/*     */     {
/* 112 */       Position other = (Position)rhs;
/*     */       
/* 114 */       return (this._sceneId == other._sceneId) && (this._x == other._x) && (this._y == other._y) && (this._z == other._z);
/*     */     }
/*     */     
/* 117 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\Position.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */