/*    */ package mzm.gsp.singlebattle.buff;
/*    */ 
/*    */ import mzm.gsp.map.main.scene.zone.bounding.CylinderBounding;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BuffZoneForm
/*    */   extends CylinderBounding
/*    */ {
/*    */   private final long battleid;
/*    */   private final int sortid;
/*    */   
/*    */   public BuffZoneForm(int x, int y, int r, long battleid, int sortid)
/*    */   {
/* 16 */     super(x, y, 0, r);
/* 17 */     this.battleid = battleid;
/* 18 */     this.sortid = sortid;
/*    */   }
/*    */   
/*    */   public long getBattleid()
/*    */   {
/* 23 */     return this.battleid;
/*    */   }
/*    */   
/*    */   public int getSortid()
/*    */   {
/* 28 */     return this.sortid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\buff\BuffZoneForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */