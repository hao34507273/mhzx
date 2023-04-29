/*    */ package mzm.gsp.chart.main;
/*    */ 
/*    */ import mzm.gsp.idip.main.IdipManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ abstract class RoleRelatedRankManagerNew<TKey, TChartObj extends RoleRelatedChartObj<TKey, TChartObj>>
/*    */   extends RankManagerNew<TKey, TChartObj>
/*    */   implements RoleRelatedRankManager<TChartObj>
/*    */ {
/*    */   protected int chartType;
/*    */   
/*    */   public RoleRelatedRankManagerNew(int chartType)
/*    */   {
/* 24 */     super(ChartCfgManager.getCapacity(chartType), ChartCfgManager.getExtraSize(chartType));
/* 25 */     this.chartType = chartType;
/* 26 */     RankCacheManager.addRoleRelatedManager(chartType, this);
/*    */   }
/*    */   
/*    */   public boolean rank(TChartObj rankObj)
/*    */   {
/* 31 */     if (rankObj == null) {
/* 32 */       return false;
/*    */     }
/* 34 */     if (IdipManager.isBanRank(rankObj.getRoleid(), this.chartType)) {
/* 35 */       return false;
/*    */     }
/* 37 */     return super.rank(rankObj);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\RoleRelatedRankManagerNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */