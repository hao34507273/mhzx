/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import mzm.gsp.personal.event.ReleaseAdvertArg;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class POnReleaseAdvertAddCache extends mzm.gsp.personal.event.ReleaseAdvertRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 10 */     UpdateCacheOneByOne.getInstance().add(new RAddCache(((ReleaseAdvertArg)this.arg).advertId, ((ReleaseAdvertArg)this.arg).advertData, ((ReleaseAdvertArg)this.arg).roleData, ((ReleaseAdvertArg)this.arg).advertChart, ((ReleaseAdvertArg)this.arg).filterInfo));
/*    */   }
/*    */   
/*    */ 
/*    */   private static class RAddCache
/*    */     extends LogicRunnable
/*    */   {
/*    */     private final long advertId;
/*    */     private final AdvertData advertData;
/*    */     private final RoleData roleData;
/*    */     private final AdvertChart advertChart;
/*    */     private final FilterInfo filterInfo;
/*    */     
/*    */     public RAddCache(long advertId, AdvertData advertData, RoleData roleData, AdvertChart advertChart, FilterInfo filterInfo)
/*    */     {
/* 25 */       this.advertId = advertId;
/* 26 */       this.advertData = advertData;
/* 27 */       this.roleData = roleData;
/* 28 */       this.advertChart = advertChart;
/* 29 */       this.filterInfo = filterInfo;
/*    */     }
/*    */     
/*    */ 
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 36 */       if (this.roleData != null)
/*    */       {
/* 38 */         AdvertDataCache.getInstance().put(this.advertData, this.roleData);
/*    */       }
/*    */       else
/*    */       {
/* 42 */         AdvertDataCache.getInstance().put(this.advertData);
/*    */       }
/*    */       
/*    */ 
/* 46 */       AdvertChartCache.getInstance().put(this.advertId, this.advertChart);
/*    */       
/*    */ 
/* 49 */       SNSIndexManager.getInstance().addAdvert(this.advertId, this.filterInfo);
/*    */       
/*    */ 
/* 52 */       SNSRankManager.getInstance().add(this.filterInfo, this.advertChart);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\POnReleaseAdvertAddCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */