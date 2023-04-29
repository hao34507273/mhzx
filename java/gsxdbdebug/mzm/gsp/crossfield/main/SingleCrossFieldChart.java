/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.RoleKeyRankManagerNew;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SingleCrossFieldChart
/*    */   extends RoleKeyRankManagerNew<SingleCrossFieldChartObj>
/*    */ {
/*    */   public SingleCrossFieldChart(int chartType)
/*    */   {
/* 14 */     super(chartType);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void rankDataFromDB() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public void saveToDB()
/*    */   {
/* 26 */     SingleCrossFieldChartManager.getInstance().saveToDB();
/*    */   }
/*    */   
/*    */ 
/*    */   public void addRankRoleForIDIP(long roleid)
/*    */   {
/* 32 */     new PRefreshRank(roleid).call();
/*    */   }
/*    */   
/*    */   public void clearRoleRankData(long roleid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\SingleCrossFieldChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */