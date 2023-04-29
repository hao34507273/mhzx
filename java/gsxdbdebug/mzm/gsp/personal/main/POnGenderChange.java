/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.personal.event.GenderArg;
/*    */ import xbean.PersonalInfo;
/*    */ 
/*    */ public class POnGenderChange extends mzm.gsp.personal.event.GenderChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     PersonalInfo xPersonalInfo = xtable.Role2personal.get(Long.valueOf(((GenderArg)this.arg).roleId));
/* 13 */     if (xPersonalInfo.getAdverts().isEmpty())
/*    */     {
/* 15 */       return true;
/*    */     }
/*    */     
/* 18 */     for (Map.Entry<Integer, Long> entry : xPersonalInfo.getAdverts().entrySet())
/*    */     {
/* 20 */       long advertId = ((Long)entry.getValue()).longValue();
/* 21 */       int advertType = ((Integer)entry.getKey()).intValue();
/*    */       
/* 23 */       UpdateCacheOneByOne.getInstance().add(new ROnGenderChange(advertType, advertId, ((GenderArg)this.arg).oldGender, ((GenderArg)this.arg).newGender));
/*    */     }
/* 25 */     UpdateCacheOneByOne.getInstance().add(new RUpdateGender(((GenderArg)this.arg).roleId, ((GenderArg)this.arg).newGender));
/*    */     
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   private static class ROnGenderChange extends mzm.gsp.util.LogicRunnable
/*    */   {
/*    */     private final int advertType;
/*    */     private final long advertId;
/*    */     private final int oldGender;
/*    */     private final int newGender;
/*    */     
/*    */     public ROnGenderChange(int advertType, long advertId, int oldGender, int newGender)
/*    */     {
/* 39 */       this.advertType = advertType;
/* 40 */       this.advertId = advertId;
/* 41 */       this.oldGender = oldGender;
/* 42 */       this.newGender = newGender;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 48 */       FilterInfo oldFilterInfo = SNSIndexManager.getInstance().getFilteInfo(this.advertId, this.advertType);
/* 49 */       if (oldFilterInfo == null)
/*    */       {
/* 51 */         return;
/*    */       }
/* 53 */       SNSIndexManager.getInstance().genderChange(this.advertType, this.advertId, this.oldGender, this.newGender);
/*    */       
/* 55 */       AdvertChart advertChart = AdvertChartCache.getInstance().get(this.advertId);
/* 56 */       if (advertChart != null)
/*    */       {
/* 58 */         FilterInfo newFilterInfo = new FilterInfo(oldFilterInfo.advertType, oldFilterInfo.level, this.newGender, oldFilterInfo.province);
/*    */         
/* 60 */         SNSRankManager.getInstance().filterChanged(this.advertId, oldFilterInfo, newFilterInfo, advertChart);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   private static class RUpdateGender extends mzm.gsp.util.LogicRunnable
/*    */   {
/*    */     private final long roleId;
/*    */     private final int newGender;
/*    */     
/*    */     public RUpdateGender(long roleId, int newGender)
/*    */     {
/* 72 */       this.roleId = roleId;
/* 73 */       this.newGender = newGender;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 79 */       AdvertDataCache.getInstance().roleRealGenderChange(this.roleId, this.newGender);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\POnGenderChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */