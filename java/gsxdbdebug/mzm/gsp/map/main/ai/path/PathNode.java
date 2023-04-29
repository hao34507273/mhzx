/*    */ package mzm.gsp.map.main.ai.path;
/*    */ 
/*    */ import mzm.gsp.map.main.ai.IMapAIObject;
/*    */ 
/*    */ public class PathNode
/*    */ {
/*    */   private int _x;
/*    */   private int _y;
/*    */   private int _z;
/*    */   private int stayTime;
/*    */   private int hideType;
/*    */   
/*    */   public PathNode(int _x, int _y, int _z)
/*    */   {
/* 15 */     this._x = _x;
/* 16 */     this._y = _y;
/* 17 */     this._z = _z;
/*    */   }
/*    */   
/*    */   public int getX()
/*    */   {
/* 22 */     return this._x;
/*    */   }
/*    */   
/*    */   public void setX(int _x)
/*    */   {
/* 27 */     this._x = _x;
/*    */   }
/*    */   
/*    */   public int getY()
/*    */   {
/* 32 */     return this._y;
/*    */   }
/*    */   
/*    */   public void setY(int _y)
/*    */   {
/* 37 */     this._y = _y;
/*    */   }
/*    */   
/*    */   public int getZ()
/*    */   {
/* 42 */     return this._z;
/*    */   }
/*    */   
/*    */   public void setZ(int _z)
/*    */   {
/* 47 */     this._z = _z;
/*    */   }
/*    */   
/*    */   public int getHideType()
/*    */   {
/* 52 */     return this.hideType;
/*    */   }
/*    */   
/*    */   public void setHideType(int hideType)
/*    */   {
/* 57 */     this.hideType = hideType;
/*    */   }
/*    */   
/*    */   public int getStayTime()
/*    */   {
/* 62 */     return this.stayTime;
/*    */   }
/*    */   
/*    */   public void setStayTime(int stayTime)
/*    */   {
/* 67 */     this.stayTime = stayTime;
/*    */   }
/*    */   
/*    */   public void execute(IMapAIObject obj)
/*    */   {
/* 72 */     obj.setXYZ(this._x, this._y, this._z);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\ai\path\PathNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */