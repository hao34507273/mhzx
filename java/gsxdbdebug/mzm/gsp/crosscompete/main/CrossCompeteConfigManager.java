/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import mzm.gsp.crosscompete.confbean.ItemController;
/*    */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrossCompeteConfigManager
/*    */ {
/*    */   public static boolean isSignUpStage(int stage)
/*    */   {
/* 15 */     return stage == 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean isInFirstCompeteTime(int competeIndex)
/*    */   {
/* 23 */     return competeIndex < SCrossCompeteConsts.getInstance().MaxCompeteCountOfOneTime;
/*    */   }
/*    */   
/*    */ 
/*    */   public static int getCrossEnterSeconds()
/*    */   {
/* 29 */     return 120;
/*    */   }
/*    */   
/*    */   public static int getSumItemWeight() {
/* 33 */     int sum = 0;
/* 34 */     for (ItemController controller : SCrossCompeteConsts.getInstance().ItemControllers) {
/* 35 */       sum += controller.Weight;
/*    */     }
/* 37 */     return sum;
/*    */   }
/*    */   
/*    */   public static int getTreasureAwardByMapItemid(int mapItemid) {
/* 41 */     for (ItemController controller : SCrossCompeteConsts.getInstance().ItemControllers) {
/* 42 */       if (controller.TreasureMapItem == mapItemid) {
/* 43 */         return controller.TreasureAward;
/*    */       }
/*    */     }
/* 46 */     return -1;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\CrossCompeteConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */