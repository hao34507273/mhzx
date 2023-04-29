/*    */ package mzm.gsp.crossserver.top;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum TopChartObjType
/*    */ {
/*  8 */   LadderTopChartObj(0), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 13 */   SingleCrossFieldTopChartObj(1), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 18 */   CrossBattleBetWinTopChartObj(2), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 23 */   CrossBattleBetLoseTopChartObj(3), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 28 */   CrossLadderTopChartObj(4), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 33 */   BigBossTopChartObj(5);
/*    */   
/*    */   private final int chartObjType;
/*    */   
/*    */   private TopChartObjType(int chartObjType)
/*    */   {
/* 39 */     this.chartObjType = chartObjType;
/*    */   }
/*    */   
/*    */   public int getType()
/*    */   {
/* 44 */     return this.chartObjType;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\top\TopChartObjType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */