/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.RoleKeyRankManagerNew;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ public class LadderChart
/*    */   extends RoleKeyRankManagerNew<LadderChartObj>
/*    */ {
/*    */   LadderChart(int chartType)
/*    */   {
/* 11 */     super(chartType);
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
/* 23 */     LadderRankManager.getInstance().saveToDB();
/*    */   }
/*    */   
/*    */ 
/*    */   public void addRankRoleForIDIP(long roleid)
/*    */   {
/* 29 */     Long currentSeasonBeginTimestamp = LadderManager.getBeforeSessionTimeMilSec(DateTimeUtils.getCurrTimeInMillis());
/* 30 */     if (currentSeasonBeginTimestamp == null)
/*    */     {
/* 32 */       return;
/*    */     }
/* 34 */     LadderRankManager.getInstance().rank(roleid, currentSeasonBeginTimestamp.longValue());
/*    */   }
/*    */   
/*    */   public void clearRoleRankData(long roleid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\LadderChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */