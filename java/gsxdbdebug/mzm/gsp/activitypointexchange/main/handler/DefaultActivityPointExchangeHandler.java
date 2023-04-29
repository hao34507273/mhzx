/*    */ package mzm.gsp.activitypointexchange.main.handler;
/*    */ 
/*    */ import mzm.gsp.activitypointexchange.confbean.SActivityPointExchangeMallCfg;
/*    */ import mzm.gsp.common.TimeCommonUtil;
/*    */ import mzm.gsp.common.confbean.STimeLimitCommonCfg;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.ActivityPointExchangeGoodsInfo;
/*    */ 
/*    */ 
/*    */ public class DefaultActivityPointExchangeHandler
/*    */   implements ActivityPointExchangeHandler
/*    */ {
/*    */   public long getPointExchangeCountResetTime(int activityId, int mallCfgId, ActivityPointExchangeGoodsInfo xActivityPointExchangeGoodsInfo)
/*    */   {
/* 15 */     return 0L;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getManualRefreshCountResetTime(int activityId, int mallCfgId, ActivityPointExchangeGoodsInfo xActivityPointExchangeGoodsInfo)
/*    */   {
/* 23 */     return 0L;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void registerActivityPointExchangeHandler() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isMallOpenForRole(long roleId, int activityId, int mallCfgId)
/*    */   {
/* 43 */     SActivityPointExchangeMallCfg activityPointExchangeMallCfg = SActivityPointExchangeMallCfg.get(mallCfgId);
/* 44 */     if (activityPointExchangeMallCfg == null)
/*    */     {
/* 46 */       return false;
/*    */     }
/* 48 */     STimeLimitCommonCfg timeLimitCommonCfg = STimeLimitCommonCfg.get(activityPointExchangeMallCfg.mallLimitTimeId);
/* 49 */     long currTimeStamp = DateTimeUtils.getCurrTimeInMillis();
/* 50 */     return (timeLimitCommonCfg != null) && (TimeCommonUtil.getLimitTimeBegin(timeLimitCommonCfg) <= currTimeStamp) && (TimeCommonUtil.getLimitTimeEnd(timeLimitCommonCfg) > currTimeStamp);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\main\handler\DefaultActivityPointExchangeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */