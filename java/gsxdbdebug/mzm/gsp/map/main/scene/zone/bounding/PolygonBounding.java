/*    */ package mzm.gsp.map.main.scene.zone.bounding;
/*    */ 
/*    */ import java.awt.Polygon;
/*    */ import java.io.PrintStream;
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import mzm.gsp.map.main.scene.zone.ZoneForm;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PolygonBounding
/*    */   implements ZoneForm
/*    */ {
/*    */   public Polygon _polygon;
/*    */   
/*    */   public PolygonBounding(int[] points)
/*    */   {
/* 27 */     int npoint = points.length;
/* 28 */     int[] xarr = new int[npoint];
/* 29 */     int[] yarr = new int[npoint];
/* 30 */     for (int i = 0; i < points.length; i += 2)
/*    */     {
/* 32 */       int idx = i / 2;
/* 33 */       xarr[idx] = points[i];
/* 34 */       yarr[idx] = points[(i + 1)];
/*    */     }
/* 36 */     this._polygon = new Polygon(xarr, yarr, npoint);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public PolygonBounding(int[] xarr, int[] yarr, int npoints)
/*    */   {
/* 52 */     this._polygon = new Polygon(xarr, yarr, npoints);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean test(int x, int y, int z)
/*    */   {
/* 58 */     return this._polygon.contains(x, y);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean test(Position pos)
/*    */   {
/* 64 */     return test(pos.getX(), pos.getY(), pos.getZ());
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean intersectsRectangle(int ax, int bx, int ay, int by)
/*    */   {
/* 70 */     int _x1 = Math.min(ax, bx);
/* 71 */     int _x2 = Math.max(ax, bx);
/* 72 */     int _y1 = Math.min(ay, by);
/* 73 */     int _y2 = Math.max(ay, by);
/* 74 */     return this._polygon.contains(ax, ay, _x2 - _x1, _y2 - _y1);
/*    */   }
/*    */   
/*    */   public static void main(String[] args)
/*    */   {
/* 79 */     PolygonBounding pb = new PolygonBounding(new int[] { 0, 2, 1, 3, 2, 3, 3, 2, 3, 1, 2, 0, 1, 0 });
/* 80 */     System.out.println(pb.test(3, 0, 0));
/* 81 */     System.out.println(pb.test(2, 1, 0));
/* 82 */     System.out.println(pb.intersectsRectangle(2, 3, 1, 0));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\zone\bounding\PolygonBounding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */