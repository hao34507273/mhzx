/*    */ package mzm.gsp.activitypointexchange.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import xbean.ActivityPointExchangeGlobalInfo;
/*    */ import xbean.ActivityPointExchangeMallGlobalInfo;
/*    */ 
/*    */ public class BeanMapper
/*    */ {
/*    */   static class ActivityPointExchangeGlobalInfo
/*    */   {
/* 12 */     final Map<Integer, BeanMapper.ActivityPointExchangeMallGlobalInfo> mallCfgId2mallInfo = new java.util.HashMap();
/*    */   }
/*    */   
/*    */   static class ActivityPointExchangeMallGlobalInfo
/*    */   {
/* 17 */     final java.util.Set<Integer> soldOutGoodsCfgIdSet = new java.util.HashSet();
/*    */   }
/*    */   
/*    */ 
/*    */   static ActivityPointExchangeGlobalInfo getActivityPointExchangeGlobalInfoFromXdb(ActivityPointExchangeGlobalInfo xActivityPointExchangeGlobalInfo)
/*    */   {
/* 23 */     ActivityPointExchangeGlobalInfo result = new ActivityPointExchangeGlobalInfo();
/* 24 */     for (Map.Entry<Integer, ActivityPointExchangeMallGlobalInfo> entry : xActivityPointExchangeGlobalInfo.getMallcfgid2mallinfo().entrySet())
/*    */     {
/* 26 */       result.mallCfgId2mallInfo.put(entry.getKey(), getActivityPointExchangeMallGlobalInfoFromXdb((ActivityPointExchangeMallGlobalInfo)entry.getValue()));
/*    */     }
/* 28 */     return result;
/*    */   }
/*    */   
/*    */ 
/*    */   static ActivityPointExchangeMallGlobalInfo getActivityPointExchangeMallGlobalInfoFromXdb(ActivityPointExchangeMallGlobalInfo xActivityPointExchangeMallGlobalInfo)
/*    */   {
/* 34 */     ActivityPointExchangeMallGlobalInfo result = new ActivityPointExchangeMallGlobalInfo();
/* 35 */     result.soldOutGoodsCfgIdSet.addAll(xActivityPointExchangeMallGlobalInfo.getSoldoutgoodscfgidset());
/* 36 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\main\BeanMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */