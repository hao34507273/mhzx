/*    */ package mzm.gsp.map.main.scene.zone.bounding;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ public class BoundingFactory
/*    */ {
/*    */   public static ZoneForm createBoxBounding(int x1, int y1, int x2, int y2)
/*    */   {
/* 23 */     return new BoxBounding(x1, y1, 0, x2, y2, 0);
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
/*    */   public static ZoneForm createCylinderBounding(int x, int y, int r)
/*    */   {
/* 39 */     return new CylinderBounding(x, y, 0, r);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static ZoneForm createPolygonBoding(int[] points)
/*    */   {
/* 50 */     return new PolygonBounding(points);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\zone\bounding\BoundingFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */