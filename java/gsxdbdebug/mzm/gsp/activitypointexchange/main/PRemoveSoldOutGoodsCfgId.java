/*    */ package mzm.gsp.activitypointexchange.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activitypointexchange.SSoldOutInfoRsp;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.ActivityPointExchangeGlobalInfo;
/*    */ import xbean.ActivityPointExchangeMallGlobalInfo;
/*    */ 
/*    */ public class PRemoveSoldOutGoodsCfgId extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   final int activityId;
/*    */   final int mallCfgId;
/*    */   final int goodsCfgId;
/*    */   
/*    */   PRemoveSoldOutGoodsCfgId(int activityId, int mallCfgId, int goodsCfgId)
/*    */   {
/* 20 */     this.activityId = activityId;
/* 21 */     this.mallCfgId = mallCfgId;
/* 22 */     this.goodsCfgId = goodsCfgId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     long globalTableKeyId = GameServerInfoManager.toGlobalId(this.activityId);
/*    */     
/* 30 */     ActivityPointExchangeGlobalInfo xActivityPointExchangeGlobalInfo = xtable.Activity2activitypointexchangeglobalinfo.get(Long.valueOf(globalTableKeyId));
/*    */     
/* 32 */     if (xActivityPointExchangeGlobalInfo == null)
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     ActivityPointExchangeMallGlobalInfo xActivityPointExchangeMallGlobalInfo = (ActivityPointExchangeMallGlobalInfo)xActivityPointExchangeGlobalInfo.getMallcfgid2mallinfo().get(Integer.valueOf(this.mallCfgId));
/*    */     
/* 38 */     if (xActivityPointExchangeMallGlobalInfo == null)
/*    */     {
/* 40 */       return false;
/*    */     }
/* 42 */     Collection<Integer> xSoldOutGoodsCfgIds = xActivityPointExchangeMallGlobalInfo.getSoldoutgoodscfgidset();
/*    */     
/* 44 */     if (!xSoldOutGoodsCfgIds.contains(Integer.valueOf(this.goodsCfgId)))
/*    */     {
/* 46 */       return false;
/*    */     }
/*    */     
/* 49 */     List<Integer> beforeSoldOutGoodsCfgIds = new ArrayList();
/* 50 */     beforeSoldOutGoodsCfgIds.addAll(xSoldOutGoodsCfgIds);
/*    */     
/* 52 */     xSoldOutGoodsCfgIds.remove(Integer.valueOf(this.goodsCfgId));
/*    */     
/*    */ 
/* 55 */     SSoldOutInfoRsp soldOutInfoRsp = new SSoldOutInfoRsp();
/* 56 */     soldOutInfoRsp.activityid = this.activityId;
/* 57 */     soldOutInfoRsp.activitypointexchangemallcfgid = this.mallCfgId;
/* 58 */     soldOutInfoRsp.soldoutinfo.goodscfgids.addAll(xSoldOutGoodsCfgIds);
/* 59 */     OnlineManager.getInstance().sendAll(soldOutInfoRsp);
/*    */     
/*    */ 
/* 62 */     ActivityPointExchangeTLogManager.tLogActivityPointExchangeGoodsSoldOutLog(this.activityId, this.mallCfgId, beforeSoldOutGoodsCfgIds, xSoldOutGoodsCfgIds);
/*    */     
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\main\PRemoveSoldOutGoodsCfgId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */