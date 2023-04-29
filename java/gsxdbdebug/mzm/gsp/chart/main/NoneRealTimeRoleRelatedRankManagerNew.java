/*    */ package mzm.gsp.chart.main;
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
/*    */ abstract class NoneRealTimeRoleRelatedRankManagerNew<TKey, TChartObj extends RoleRelatedChartObj<TKey, TChartObj>>
/*    */   extends NoneRealTimeRankManager<TKey, TChartObj>
/*    */   implements RoleRelatedRankManager<TChartObj>
/*    */ {
/*    */   public NoneRealTimeRoleRelatedRankManagerNew(int chartType, RoleRelatedRankManagerNew<TKey, TChartObj> rankManagerNew)
/*    */   {
/* 20 */     super(chartType, rankManagerNew);
/* 21 */     RankCacheManager.addRoleRelatedManager(chartType, this);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\NoneRealTimeRoleRelatedRankManagerNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */