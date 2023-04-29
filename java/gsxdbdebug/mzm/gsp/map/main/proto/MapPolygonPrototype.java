/*    */ package mzm.gsp.map.main.proto;
/*    */ 
/*    */ import java.awt.Polygon;
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.map.confbean.SMapPolygonCfg;
/*    */ import mzm.gsp.map.confbean.Vertex;
/*    */ 
/*    */ 
/*    */ public class MapPolygonPrototype
/*    */ {
/*    */   private final int cfgid;
/* 12 */   private Polygon polygon = null;
/*    */   
/*    */   public MapPolygonPrototype(int cfgid)
/*    */   {
/* 16 */     this.cfgid = cfgid;
/*    */   }
/*    */   
/*    */   public int getTemplateId()
/*    */   {
/* 21 */     return this.cfgid;
/*    */   }
/*    */   
/*    */   public void init()
/*    */   {
/* 26 */     SMapPolygonCfg cfg = SMapPolygonCfg.get(this.cfgid);
/* 27 */     if (cfg == null)
/*    */     {
/* 29 */       return;
/*    */     }
/*    */     
/* 32 */     int npoints = cfg.vertices.size();
/* 33 */     int[] xpoints = new int[npoints];
/* 34 */     int[] ypoints = new int[npoints];
/* 35 */     int i = 0;
/* 36 */     for (Vertex vertex : cfg.vertices)
/*    */     {
/* 38 */       xpoints[i] = vertex.x;
/* 39 */       ypoints[i] = vertex.y;
/* 40 */       i++;
/*    */     }
/*    */     
/* 43 */     this.polygon = new Polygon(xpoints, ypoints, npoints);
/*    */   }
/*    */   
/*    */   public boolean contains(int x, int y)
/*    */   {
/* 48 */     if (this.polygon == null)
/*    */     {
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     return this.polygon.contains(x, y);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\proto\MapPolygonPrototype.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */