/*    */ package mzm.gsp.flowerparade.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity4.confbean.FlowerParadeConstCfg;
/*    */ 
/*    */ public class PGM_FlowerPradeStart extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final int mapId;
/*    */   private final int ocp;
/*    */   
/*    */   public PGM_FlowerPradeStart(int mapId, int ocp)
/*    */   {
/* 13 */     this.mapId = (mapId <= 0 ? -1 : mapId);
/* 14 */     this.ocp = (ocp <= 0 ? -1 : ocp);
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     if (!ActivityInterface.isActivityOpen(FlowerParadeConstCfg.getInstance().activityId)) {
/* 21 */       return false;
/*    */     }
/* 23 */     if (!FlowerParadeManager.isOpen(0L)) {
/* 24 */       return false;
/*    */     }
/* 26 */     int GM_PARADE_INDEX = -1;
/* 27 */     FlowerParadeManager.startFlowerParade(FlowerParadeConstCfg.getInstance().activityId, -1, this.mapId, this.ocp);
/*    */     
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\PGM_FlowerPradeStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */