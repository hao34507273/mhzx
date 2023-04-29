/*    */ package mzm.gsp.map.main.scene.zone.bounding;
/*    */ 
/*    */ import java.awt.geom.Ellipse2D;
/*    */ import java.awt.geom.Ellipse2D.Float;
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import mzm.gsp.map.main.scene.zone.ZoneForm;
/*    */ 
/*    */ public class CylinderBounding implements ZoneForm
/*    */ {
/*    */   private final Ellipse2D ellipse2D;
/*    */   
/*    */   public CylinderBounding(int x, int y, int z, int r)
/*    */   {
/* 14 */     int w = r * 2;
/* 15 */     this.ellipse2D = new Ellipse2D.Float(x - r, y - r, w, w);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean test(int x, int y, int z)
/*    */   {
/* 21 */     return this.ellipse2D.contains(x, y);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean test(Position pos)
/*    */   {
/* 27 */     return test(pos.getX(), pos.getY(), pos.getZ());
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean intersectsRectangle(int ax, int bx, int ay, int by)
/*    */   {
/* 33 */     return this.ellipse2D.intersects(ax, ay, bx - ax, by - ay);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\zone\bounding\CylinderBounding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */