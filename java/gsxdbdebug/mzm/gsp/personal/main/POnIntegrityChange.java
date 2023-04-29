/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.personal.event.IntegrityArg;
/*    */ import xbean.AdvertInfo;
/*    */ import xbean.PersonalInfo;
/*    */ 
/*    */ public class POnIntegrityChange extends mzm.gsp.personal.event.IntegrityChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     PersonalInfo xPersonalInfo = xtable.Role2personal.get(Long.valueOf(((IntegrityArg)this.arg).roleId));
/* 14 */     if (xPersonalInfo.getAdverts().isEmpty())
/*    */     {
/* 16 */       return true;
/*    */     }
/*    */     
/* 19 */     for (Map.Entry<Integer, Long> entry : xPersonalInfo.getAdverts().entrySet())
/*    */     {
/* 21 */       long advertId = ((Long)entry.getValue()).longValue();
/* 22 */       AdvertInfo xAdvertInfo = xtable.Advert.select(Long.valueOf(advertId));
/*    */       
/* 24 */       AdvertChart newAdvertChart = new AdvertChart(((IntegrityArg)this.arg).roleId, advertId, ((IntegrityArg)this.arg).newIntegrity, xAdvertInfo.getRelease_timestamp());
/*    */       
/* 26 */       UpdateCacheOneByOne.getInstance().add(new ROnIntegrityChange(advertId, ((Integer)entry.getKey()).intValue(), newAdvertChart));
/*    */     }
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   private static class ROnIntegrityChange extends mzm.gsp.util.LogicRunnable
/*    */   {
/*    */     private final long advertId;
/*    */     private final int advertType;
/*    */     private final AdvertChart newAdvertChart;
/*    */     
/*    */     public ROnIntegrityChange(long advertId, int advertType, AdvertChart newAdvertChart)
/*    */     {
/* 39 */       this.advertId = advertId;
/* 40 */       this.advertType = advertType;
/* 41 */       this.newAdvertChart = newAdvertChart;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 47 */       FilterInfo filterInfo = SNSIndexManager.getInstance().getFilteInfo(this.advertId, this.advertType);
/* 48 */       if (filterInfo == null)
/*    */       {
/* 50 */         return;
/*    */       }
/* 52 */       AdvertChartCache.getInstance().put(this.advertId, this.newAdvertChart);
/* 53 */       SNSRankManager.getInstance().chartChanged(this.advertId, filterInfo, this.newAdvertChart);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\POnIntegrityChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */