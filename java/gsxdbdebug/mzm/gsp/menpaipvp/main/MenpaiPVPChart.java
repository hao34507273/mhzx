/*    */ package mzm.gsp.menpaipvp.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.MenpaiPVPScore;
/*    */ 
/*    */ public class MenpaiPVPChart extends mzm.gsp.chart.main.RankManagerNew<Long, MenpaiPVPChartObj>
/*    */ {
/*    */   private final int menpai;
/*    */   
/*    */   public MenpaiPVPChart(int menpai, int capacity, int extraSize)
/*    */   {
/* 12 */     super(capacity, extraSize);
/* 13 */     this.menpai = menpai;
/*    */   }
/*    */   
/*    */ 
/*    */   public void saveToDB()
/*    */   {
/* 19 */     xbean.MenpaiPVPChart xChart = MenpaiPVPManager.getAndCreateXMenpaiPVPChart(this.menpai);
/* 20 */     List<MenpaiPVPChartObj> objs = getAllChartObjs();
/*    */     
/* 22 */     xChart.getRanklist().clear();
/* 23 */     for (MenpaiPVPChartObj obj : objs) {
/* 24 */       xChart.getRanklist().add(Long.valueOf(obj.getRoleid()));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void rankDataFromDB()
/*    */   {
/* 31 */     xbean.MenpaiPVPChart xChart = MenpaiPVPManager.getAndCreateXMenpaiPVPChart(this.menpai);
/* 32 */     for (java.util.Iterator i$ = xChart.getRanklist().iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*    */       
/* 34 */       MenpaiPVPScore xScore = xtable.Menpaipvpscore.select(Long.valueOf(r));
/* 35 */       if (xScore != null)
/*    */       {
/*    */ 
/* 38 */         MenpaiPVPChartObj obj = new MenpaiPVPChartObj(r, xScore.getScore(), xScore.getWin_times());
/*    */         
/* 40 */         rank(obj);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\MenpaiPVPChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */