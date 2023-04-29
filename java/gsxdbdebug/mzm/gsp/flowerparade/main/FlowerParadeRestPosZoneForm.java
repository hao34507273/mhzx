/*    */ package mzm.gsp.flowerparade.main;
/*    */ 
/*    */ import mzm.gsp.map.main.scene.zone.bounding.BoxBounding;
/*    */ 
/*    */ public class FlowerParadeRestPosZoneForm
/*    */   extends BoxBounding
/*    */ {
/*    */   public FlowerParadeRestPosZoneForm(int x1, int y1, int r)
/*    */   {
/* 10 */     super(x1 + r, y1 + r, 0, x1 - r, y1 - r, 0);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\FlowerParadeRestPosZoneForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */