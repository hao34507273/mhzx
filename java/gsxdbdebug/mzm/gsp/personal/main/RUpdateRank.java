/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class RUpdateRank extends LogicRunnable
/*    */ {
/*    */   private final long advertId;
/*    */   private final FilterInfo oldFilterInfo;
/*    */   private final FilterInfo newFilterInfo;
/*    */   
/*    */   public RUpdateRank(long advertId, FilterInfo oldFilterInfo, FilterInfo newFilterInfo)
/*    */   {
/* 13 */     this.advertId = advertId;
/* 14 */     this.oldFilterInfo = oldFilterInfo;
/* 15 */     this.newFilterInfo = newFilterInfo;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 21 */     AdvertChart advertChart = AdvertChartCache.getInstance().get(this.advertId);
/* 22 */     if (advertChart != null)
/*    */     {
/* 24 */       SNSRankManager.getInstance().filterChanged(this.advertId, this.oldFilterInfo, this.newFilterInfo, advertChart);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\RUpdateRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */