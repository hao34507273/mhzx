/*    */ package mzm.gsp.map.main.scene.zone.bounding;
/*    */ 
/*    */ import java.awt.Rectangle;
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import mzm.gsp.map.main.scene.zone.ZoneForm;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BoxBounding
/*    */   implements ZoneForm
/*    */ {
/*    */   private int z1;
/*    */   private int z2;
/*    */   private Rectangle _r;
/*    */   
/*    */   public BoxBounding(int x1, int y1, int z1, int x2, int y2, int z2)
/*    */   {
/* 18 */     int _x1 = Math.min(x1, x2);
/* 19 */     int _x2 = Math.max(x1, x2);
/* 20 */     int _y1 = Math.min(y1, y2);
/* 21 */     int _y2 = Math.max(y1, y2);
/*    */     
/* 23 */     this._r = new Rectangle(_x1, _y1, _x2 - _x1, _y2 - _y1);
/* 24 */     z1 = Math.min(z1, z2);
/* 25 */     z2 = Math.max(z1, z2);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean test(int x, int y, int z)
/*    */   {
/* 37 */     return this._r.contains(x, y);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean test(Position pos)
/*    */   {
/* 43 */     return test(pos.getX(), pos.getY(), pos.getZ());
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean intersectsRectangle(int ax, int bx, int ay, int by)
/*    */   {
/* 49 */     int _x1 = Math.min(ax, bx);
/* 50 */     int _x2 = Math.max(ax, bx);
/* 51 */     int _y1 = Math.min(ay, by);
/* 52 */     int _y2 = Math.max(ay, by);
/* 53 */     return this._r.intersects(_x1, _y1, _x2 - _x1, _y2 - _y1);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\zone\bounding\BoxBounding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */