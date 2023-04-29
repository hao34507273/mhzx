/*    */ package mzm.gsp.activitypointexchange.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activitypointexchange.SSoldOutInfoRsp;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.ActivityPointExchangeGlobalInfo;
/*    */ import xbean.ActivityPointExchangeMallGlobalInfo;
/*    */ import xtable.Activity2activitypointexchangeglobalinfo;
/*    */ 
/*    */ public class PAddSoldOutGoodsCfgId extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   final int activityId;
/*    */   final int mallCfgId;
/*    */   final int goodsCfgId;
/*    */   
/*    */   public PAddSoldOutGoodsCfgId(int activityId, int mallCfgId, int goodsCfgId)
/*    */   {
/* 20 */     this.activityId = activityId;
/* 21 */     this.mallCfgId = mallCfgId;
/* 22 */     this.goodsCfgId = goodsCfgId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     long globalTableKeyId = mzm.gsp.GameServerInfoManager.toGlobalId(this.activityId);
/*    */     
/* 30 */     ActivityPointExchangeGlobalInfo xActivityPointExchangeGlobalInfo = Activity2activitypointexchangeglobalinfo.get(Long.valueOf(globalTableKeyId));
/*    */     
/* 32 */     if (xActivityPointExchangeGlobalInfo == null)
/*    */     {
/* 34 */       xActivityPointExchangeGlobalInfo = xbean.Pod.newActivityPointExchangeGlobalInfo();
/* 35 */       Activity2activitypointexchangeglobalinfo.insert(Long.valueOf(globalTableKeyId), xActivityPointExchangeGlobalInfo);
/*    */     }
/* 37 */     ActivityPointExchangeMallGlobalInfo xActivityPointExchangeMallGlobalInfo = (ActivityPointExchangeMallGlobalInfo)xActivityPointExchangeGlobalInfo.getMallcfgid2mallinfo().get(Integer.valueOf(this.mallCfgId));
/*    */     
/* 39 */     if (xActivityPointExchangeMallGlobalInfo == null)
/*    */     {
/* 41 */       xActivityPointExchangeMallGlobalInfo = xbean.Pod.newActivityPointExchangeMallGlobalInfo();
/* 42 */       xActivityPointExchangeGlobalInfo.getMallcfgid2mallinfo().put(Integer.valueOf(this.mallCfgId), xActivityPointExchangeMallGlobalInfo);
/*    */     }
/*    */     
/* 45 */     Collection<Integer> xSoldOutGoodsCfgIds = xActivityPointExchangeMallGlobalInfo.getSoldoutgoodscfgidset();
/* 46 */     if (xSoldOutGoodsCfgIds.contains(Integer.valueOf(this.goodsCfgId)))
/*    */     {
/* 48 */       return false;
/*    */     }
/* 50 */     java.util.List<Integer> beforeSoldOutGoodsCfgIds = new ArrayList();
/* 51 */     beforeSoldOutGoodsCfgIds.addAll(xSoldOutGoodsCfgIds);
/*    */     
/* 53 */     xSoldOutGoodsCfgIds.add(Integer.valueOf(this.goodsCfgId));
/*    */     
/*    */ 
/* 56 */     SSoldOutInfoRsp soldOutInfoRsp = new SSoldOutInfoRsp();
/* 57 */     soldOutInfoRsp.activityid = this.activityId;
/* 58 */     soldOutInfoRsp.activitypointexchangemallcfgid = this.mallCfgId;
/* 59 */     soldOutInfoRsp.soldoutinfo.goodscfgids.addAll(xSoldOutGoodsCfgIds);
/* 60 */     OnlineManager.getInstance().sendAll(soldOutInfoRsp);
/*    */     
/*    */ 
/* 63 */     ActivityPointExchangeTLogManager.tLogActivityPointExchangeGoodsSoldOutLog(this.activityId, this.mallCfgId, beforeSoldOutGoodsCfgIds, xSoldOutGoodsCfgIds);
/*    */     
/*    */ 
/* 66 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\main\PAddSoldOutGoodsCfgId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */