/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.chart.main.RankManagerNew;
/*    */ import xbean.MenPaiStarChartInfo;
/*    */ 
/*    */ public class MenPaiStarChart
/*    */   extends RankManagerNew<Integer, MenPaiStarChartObj>
/*    */ {
/*    */   public MenPaiStarChart(int capacity, int extraSize)
/*    */   {
/* 13 */     super(capacity, extraSize);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void saveToDB()
/*    */   {
/* 20 */     xbean.MenPaiStarChart xMenPaiStarChart = MenPaiStarManager.getAndInitXMenPaiStarChart();
/*    */     
/*    */ 
/* 23 */     Map<Integer, MenPaiStarChartInfo> charts = xMenPaiStarChart.getCharts();
/* 24 */     charts.clear();
/*    */     
/*    */ 
/* 27 */     List<MenPaiStarChartObj> objs = getAllChartObjs();
/* 28 */     for (MenPaiStarChartObj obj : objs)
/*    */     {
/* 30 */       MenPaiStarChartInfo xMenPaiStarChartInfo = MenPaiStarManager.trans(obj);
/* 31 */       charts.put(Integer.valueOf(obj.getOcpid()), xMenPaiStarChartInfo);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void rankDataFromDB()
/*    */   {
/* 39 */     xbean.MenPaiStarChart xMenPaiStarCharts = MenPaiStarManager.getAndInitXMenPaiStarChart();
/* 40 */     for (MenPaiStarChartInfo xMenPaiStarChartInfo : xMenPaiStarCharts.getCharts().values())
/*    */     {
/*    */ 
/* 43 */       long roleid = xMenPaiStarChartInfo.getRoleid();
/* 44 */       int ocpid = xMenPaiStarChartInfo.getOccupationid();
/* 45 */       int point = xMenPaiStarChartInfo.getPoint();
/* 46 */       long updatePointTime = xMenPaiStarChartInfo.getUpdate_point_time();
/* 47 */       String name = xMenPaiStarChartInfo.getRole_name();
/* 48 */       rank(new MenPaiStarChartObj(roleid, ocpid, point, updatePointTime, name));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\MenPaiStarChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */