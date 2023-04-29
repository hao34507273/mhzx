/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.personal.Location;
/*    */ import mzm.gsp.personal.event.LocationArg;
/*    */ import xbean.PersonalInfo;
/*    */ 
/*    */ public class POnLocationChange extends mzm.gsp.personal.event.LocationChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if (((LocationArg)this.arg).oldLocation.province == ((LocationArg)this.arg).newLocation.province)
/*    */     {
/* 15 */       return true;
/*    */     }
/*    */     
/* 18 */     PersonalInfo xPersonalInfo = xtable.Role2personal.get(Long.valueOf(((LocationArg)this.arg).roleId));
/* 19 */     if (xPersonalInfo.getAdverts().isEmpty())
/*    */     {
/* 21 */       return true;
/*    */     }
/*    */     
/* 24 */     for (Map.Entry<Integer, Long> entry : xPersonalInfo.getAdverts().entrySet())
/*    */     {
/* 26 */       int advertType = ((Integer)entry.getKey()).intValue();
/* 27 */       long advertId = ((Long)entry.getValue()).longValue();
/* 28 */       UpdateCacheOneByOne.getInstance().add(new RProvinceChange(advertType, advertId, ((LocationArg)this.arg).oldLocation.province, ((LocationArg)this.arg).newLocation.province));
/*    */     }
/*    */     
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   private static class RProvinceChange extends mzm.gsp.util.LogicRunnable
/*    */   {
/*    */     private final int advertType;
/*    */     private final long advertId;
/*    */     private final int oldProvince;
/*    */     private final int newProvince;
/*    */     
/*    */     public RProvinceChange(int advertType, long advertId, int oldProvince, int newProvince)
/*    */     {
/* 43 */       this.advertType = advertType;
/* 44 */       this.advertId = advertId;
/* 45 */       this.oldProvince = oldProvince;
/* 46 */       this.newProvince = newProvince;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 52 */       FilterInfo oldFilterInfo = SNSIndexManager.getInstance().getFilteInfo(this.advertId, this.advertType);
/* 53 */       if (oldFilterInfo == null)
/*    */       {
/* 55 */         return;
/*    */       }
/* 57 */       SNSIndexManager.getInstance().provinceChange(this.advertType, this.advertId, this.oldProvince, this.newProvince);
/*    */       
/* 59 */       AdvertChart advertChart = AdvertChartCache.getInstance().get(this.advertId);
/* 60 */       if (advertChart != null)
/*    */       {
/* 62 */         FilterInfo newFilterInfo = new FilterInfo(oldFilterInfo.advertType, oldFilterInfo.level, oldFilterInfo.gender, this.newProvince);
/*    */         
/* 64 */         SNSRankManager.getInstance().filterChanged(this.advertId, oldFilterInfo, newFilterInfo, advertChart);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\POnLocationChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */