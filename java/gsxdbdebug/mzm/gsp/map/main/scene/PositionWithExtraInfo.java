/*    */ package mzm.gsp.map.main.scene;
/*    */ 
/*    */ import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
/*    */ 
/*    */ public class PositionWithExtraInfo extends PositionWithCfgid
/*    */ {
/*    */   @com.thoughtworks.xstream.annotations.XStreamAlias("channelid")
/*    */   @XStreamAsAttribute
/*    */   private int _channelid;
/*    */   
/*    */   public PositionWithExtraInfo(int _x, int _y, int _z, int _sceneId, int _mapCfgid, int _channelid) {
/* 12 */     super(_x, _y, _z, _sceneId, _mapCfgid);
/*    */     
/* 14 */     this._channelid = _channelid;
/*    */   }
/*    */   
/*    */   public PositionWithExtraInfo(PositionWithExtraInfo target)
/*    */   {
/* 19 */     super(target);
/*    */     
/* 21 */     this._channelid = target._channelid;
/*    */   }
/*    */   
/*    */   public void setXYZ(int x, int y, int z, int mapCfgid, int channelid)
/*    */   {
/* 26 */     super.setXYZ(x, y, z, mapCfgid);
/*    */     
/* 28 */     this._channelid = channelid;
/*    */   }
/*    */   
/*    */   public int getChannelid()
/*    */   {
/* 33 */     return this._channelid;
/*    */   }
/*    */   
/*    */   public void setChannelid(int channelid)
/*    */   {
/* 38 */     this._channelid = channelid;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 44 */     return "Position [_x=" + this._x + ", _y=" + this._y + ", _z=" + this._z + ", _sceneId=" + this._sceneId + ", _mapCfgid=" + this._mapCfgid + ", _channelid=" + this._channelid + "]";
/*    */   }
/*    */   
/*    */ 
/*    */   protected Object clone()
/*    */     throws CloneNotSupportedException
/*    */   {
/* 51 */     return new PositionWithExtraInfo(this._x, this._y, this._z, this._sceneId, this._mapCfgid, this._channelid);
/*    */   }
/*    */   
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 57 */     return super.hashCode() ^ this._channelid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean equals(Object rhs)
/*    */   {
/* 63 */     if (rhs == this)
/*    */     {
/* 65 */       return true;
/*    */     }
/*    */     
/* 68 */     if ((rhs instanceof PositionWithExtraInfo))
/*    */     {
/* 70 */       PositionWithExtraInfo other = (PositionWithExtraInfo)rhs;
/*    */       
/* 72 */       return (this._sceneId == other._sceneId) && (this._x == other._x) && (this._y == other._y) && (this._z == other._z) && (this._mapCfgid == other._mapCfgid) && (this._channelid == other._channelid);
/*    */     }
/*    */     
/*    */ 
/* 76 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\PositionWithExtraInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */