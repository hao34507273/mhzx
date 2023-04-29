/*    */ package mzm.gsp.map.main.scene;
/*    */ 
/*    */ import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
/*    */ 
/*    */ public class PositionWithCfgid extends Position {
/*    */   @com.thoughtworks.xstream.annotations.XStreamAlias("map_cfgid")
/*    */   @XStreamAsAttribute
/*    */   protected int _mapCfgid;
/*    */   
/*    */   public PositionWithCfgid(int _x, int _y, int _z, int _sceneId, int _mapCfgid) {
/* 11 */     super(_x, _y, _z, _sceneId);
/*    */     
/* 13 */     this._mapCfgid = _mapCfgid;
/*    */   }
/*    */   
/*    */   public PositionWithCfgid(PositionWithCfgid target)
/*    */   {
/* 18 */     super(target);
/*    */     
/* 20 */     this._mapCfgid = target._mapCfgid;
/*    */   }
/*    */   
/*    */   public void setXYZ(int x, int y, int z, int mapCfgid)
/*    */   {
/* 25 */     super.setXYZ(x, y, z);
/*    */     
/* 27 */     this._mapCfgid = mapCfgid;
/*    */   }
/*    */   
/*    */   public int getMapCfgid()
/*    */   {
/* 32 */     return this._mapCfgid;
/*    */   }
/*    */   
/*    */   public void setMapCfgid(int mapCfgid)
/*    */   {
/* 37 */     this._mapCfgid = mapCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 43 */     return "Position [_x=" + this._x + ", _y=" + this._y + ", _z=" + this._z + ", _sceneId=" + this._sceneId + ", _mapCfgid=" + this._mapCfgid + "]";
/*    */   }
/*    */   
/*    */ 
/*    */   protected Object clone()
/*    */     throws CloneNotSupportedException
/*    */   {
/* 50 */     return new PositionWithCfgid(this._x, this._y, this._z, this._sceneId, this._mapCfgid);
/*    */   }
/*    */   
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 56 */     return super.hashCode() ^ this._mapCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean equals(Object rhs)
/*    */   {
/* 62 */     if (rhs == this)
/*    */     {
/* 64 */       return true;
/*    */     }
/*    */     
/* 67 */     if ((rhs instanceof PositionWithCfgid))
/*    */     {
/* 69 */       PositionWithCfgid other = (PositionWithCfgid)rhs;
/*    */       
/* 71 */       return (this._sceneId == other._sceneId) && (this._x == other._x) && (this._y == other._y) && (this._z == other._z) && (this._mapCfgid == other._mapCfgid);
/*    */     }
/*    */     
/*    */ 
/* 75 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\PositionWithCfgid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */