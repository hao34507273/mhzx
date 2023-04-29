/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.personal.confbean.SNSConsts;
/*    */ import mzm.gsp.personal.confbean.SNSSubTypeCfg;
/*    */ 
/*    */ 
/*    */ public class SNSIndexManager
/*    */ {
/* 14 */   private static final SNSIndexManager instance = new SNSIndexManager();
/*    */   
/*    */   public static final SNSIndexManager getInstance()
/*    */   {
/* 18 */     return instance;
/*    */   }
/*    */   
/* 21 */   private final Map<Integer, AdvertIndexCache> typeToAdvetIdCache = new HashMap();
/*    */   
/*    */   private SNSIndexManager()
/*    */   {
/* 25 */     for (Integer advertType : SNSSubTypeCfg.getAll().keySet())
/*    */     {
/* 27 */       if (advertType.intValue() != SNSConsts.getInstance().ALL_SUB_TYPE_ID)
/*    */       {
/*    */ 
/* 30 */         this.typeToAdvetIdCache.put(advertType, new AdvertIndexCache(advertType.intValue()));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   void addAdvert(long advertId, FilterInfo filterInfo)
/*    */   {
/* 37 */     ((AdvertIndexCache)this.typeToAdvetIdCache.get(Integer.valueOf(filterInfo.advertType))).addAdvert(advertId, filterInfo);
/*    */   }
/*    */   
/*    */   void delAdvert(long advertId, int advertType)
/*    */   {
/* 42 */     ((AdvertIndexCache)this.typeToAdvetIdCache.get(Integer.valueOf(advertType))).delAdvert(advertId);
/*    */   }
/*    */   
/*    */   void genderChange(int advertType, long advertId, int oldGender, int newGender)
/*    */   {
/* 47 */     ((AdvertIndexCache)this.typeToAdvetIdCache.get(Integer.valueOf(advertType))).genderChange(advertId, oldGender, newGender);
/*    */   }
/*    */   
/*    */   void levelChange(int advertType, long advertId, int oldLevel, int newLevel)
/*    */   {
/* 52 */     ((AdvertIndexCache)this.typeToAdvetIdCache.get(Integer.valueOf(advertType))).levelChange(advertId, oldLevel, newLevel);
/*    */   }
/*    */   
/*    */   void provinceChange(int advertType, long advertId, int oldProvince, int newProvince)
/*    */   {
/* 57 */     ((AdvertIndexCache)this.typeToAdvetIdCache.get(Integer.valueOf(advertType))).provinceChange(advertId, oldProvince, newProvince);
/*    */   }
/*    */   
/*    */   Collection<Long> searchAdvertIds(SearchInfo searchInfo)
/*    */   {
/* 62 */     if (searchInfo.advertType == SNSConsts.getInstance().ALL_SUB_TYPE_ID)
/*    */     {
/* 64 */       Set<Long> finalAdvertIds = new HashSet();
/* 65 */       for (AdvertIndexCache advertIndexCache : this.typeToAdvetIdCache.values())
/*    */       {
/* 67 */         finalAdvertIds.addAll(advertIndexCache.searchAdverts(searchInfo.conditionInfo));
/*    */       }
/* 69 */       return finalAdvertIds;
/*    */     }
/*    */     
/*    */ 
/* 73 */     return ((AdvertIndexCache)this.typeToAdvetIdCache.get(Integer.valueOf(searchInfo.advertType))).searchAdverts(searchInfo.conditionInfo);
/*    */   }
/*    */   
/*    */ 
/*    */   FilterInfo getFilteInfo(long advertId, int advertType)
/*    */   {
/* 79 */     return ((AdvertIndexCache)this.typeToAdvetIdCache.get(Integer.valueOf(advertType))).getFilterInfo(advertId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\SNSIndexManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */