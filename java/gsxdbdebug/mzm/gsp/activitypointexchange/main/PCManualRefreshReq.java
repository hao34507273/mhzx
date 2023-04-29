/*     */ package mzm.gsp.activitypointexchange.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.activitypointexchange.ExchangeCountInfo;
/*     */ import mzm.gsp.activitypointexchange.MallInfo;
/*     */ import mzm.gsp.activitypointexchange.SManualRefreshError;
/*     */ import mzm.gsp.activitypointexchange.SManualRefreshRsp;
/*     */ import mzm.gsp.activitypointexchange.SoldOutInfo;
/*     */ import mzm.gsp.activitypointexchange.confbean.RefreshCostInfo;
/*     */ import mzm.gsp.activitypointexchange.confbean.SActivityPointExchangeMallCfg;
/*     */ import mzm.gsp.activitypointexchange.confbean.STActivityPointExchangeManualRefreshCostCfg;
/*     */ import mzm.gsp.activitypointexchange.confbean.TActivityPointExchangeActivityCfg;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.ActivityPointExchangeGoodsInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCManualRefreshReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int activityId;
/*     */   final int refreshCount;
/*     */   final long clientYuanBaoCount;
/*     */   
/*     */   public PCManualRefreshReq(long roleId, int activityId, int refreshCount, long clientYuanBaoCount)
/*     */   {
/*  38 */     this.roleId = roleId;
/*  39 */     this.activityId = activityId;
/*  40 */     this.refreshCount = refreshCount;
/*  41 */     this.clientYuanBaoCount = clientYuanBaoCount;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     if ((this.refreshCount < 0) || (this.clientYuanBaoCount < 0L) || (this.activityId <= 0))
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  53 */     if (!OpenInterface.getOpenStatus(516))
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  59 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1952, true))
/*     */     {
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     TActivityPointExchangeActivityCfg activityCfg = TActivityPointExchangeActivityCfg.get(this.activityId);
/*  65 */     if (activityCfg == null)
/*     */     {
/*  67 */       return false;
/*     */     }
/*  69 */     SManualRefreshError manualRefreshError = new SManualRefreshError();
/*  70 */     manualRefreshError.activityid = this.activityId;
/*  71 */     manualRefreshError.refreshcount = this.refreshCount;
/*     */     
/*     */ 
/*  74 */     if (!OpenInterface.getOpenStatus(activityCfg.activitySwitchId))
/*     */     {
/*  76 */       manualRefreshError.errorcode = 4;
/*  77 */       ActivityPointExchangeManager.onError(this.roleId, String.format("[activitypointexchange]PCManualRefreshReq.processImp@ activity closed|roleId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId) }), manualRefreshError);
/*     */       
/*     */ 
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  84 */     lock(Lockeys.get(User.getTable(), userId));
/*  85 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*  87 */     int mallCfgId = ActivityPointExchangeManager.getOpenMallCfgId(this.roleId, activityCfg);
/*  88 */     if (mallCfgId <= 0)
/*     */     {
/*  90 */       manualRefreshError.errorcode = 7;
/*  91 */       OnlineManager.getInstance().sendAtOnce(this.roleId, manualRefreshError);
/*  92 */       return false;
/*     */     }
/*  94 */     SActivityPointExchangeMallCfg mallCfg = SActivityPointExchangeMallCfg.get(mallCfgId);
/*  95 */     if (mallCfg == null)
/*     */     {
/*  97 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 101 */     long currentYuanBao = QingfuInterface.getBalance(userId, true);
/* 102 */     if (currentYuanBao != this.clientYuanBaoCount)
/*     */     {
/* 104 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 108 */     ActivityPointExchangeGoodsInfo xActivityPointExchangeGoodsInfo = ActivityPointExchangeManager.getActivityPointExchangeGoodsInfo(this.roleId, this.activityId, mallCfgId);
/*     */     
/*     */ 
/* 111 */     if (xActivityPointExchangeGoodsInfo == null)
/*     */     {
/* 113 */       manualRefreshError.errorcode = 3;
/* 114 */       ActivityPointExchangeManager.onError(this.roleId, String.format("[activitypointexchange]PCManualRefreshReq.processImp@ no need refresh|roleId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId) }), manualRefreshError);
/*     */       
/*     */ 
/* 117 */       return false;
/*     */     }
/*     */     
/* 120 */     SManualRefreshRsp manualRefreshRsp = new SManualRefreshRsp();
/* 121 */     manualRefreshRsp.activityid = this.activityId;
/* 122 */     manualRefreshRsp.activitypointexchangemallcfgid = mallCfgId;
/* 123 */     manualRefreshRsp.mallinfo.pointcount = MallInterface.getJifen(this.roleId, mallCfg.tokenType);
/*     */     
/* 125 */     Collection<Integer> soldOutGoodsCfgIds = ActivityPointExchangeManager.getSoldOutGoodsCfgIds(this.activityId, mallCfgId);
/*     */     
/* 127 */     if ((soldOutGoodsCfgIds != null) && (!soldOutGoodsCfgIds.isEmpty()))
/*     */     {
/* 129 */       manualRefreshRsp.mallinfo.soldoutinfo.goodscfgids.addAll(soldOutGoodsCfgIds);
/*     */     }
/*     */     
/*     */ 
/* 133 */     long currentTimeStamp = TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis());
/* 134 */     mzm.gsp.activitypointexchange.main.handler.ActivityPointExchangeHandler activityPointExchangeHandler = ActivityPointExchangeManager.getActivityPointExchangeHandler(this.activityId);
/*     */     
/* 136 */     ActivityPointExchangeManager.checkResetExchangeCount(this.roleId, this.activityId, mallCfgId, xActivityPointExchangeGoodsInfo, currentTimeStamp, activityPointExchangeHandler);
/*     */     
/* 138 */     ActivityPointExchangeManager.checkResetManualRefreshCount(this.roleId, this.activityId, mallCfgId, xActivityPointExchangeGoodsInfo, currentTimeStamp, activityPointExchangeHandler);
/*     */     
/*     */ 
/*     */ 
/* 142 */     if ((xActivityPointExchangeGoodsInfo.getGoodscfgid2count().isEmpty()) || (!xActivityPointExchangeGoodsInfo.getIsneedrefresh()))
/*     */     {
/*     */ 
/* 145 */       manualRefreshError.errorcode = 3;
/* 146 */       ActivityPointExchangeManager.onError(this.roleId, String.format("[activitypointexchange]PCManualRefreshReq.processImp@ no need refresh|roleId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId) }), manualRefreshError);
/*     */       
/*     */ 
/* 149 */       return false;
/*     */     }
/*     */     
/* 152 */     Map<Integer, Integer> TLog_beforeCfgId2count = new HashMap();
/* 153 */     TLog_beforeCfgId2count.putAll(xActivityPointExchangeGoodsInfo.getGoodscfgid2count());
/*     */     
/*     */ 
/*     */ 
/* 157 */     if (mallCfg.exchangeCountManualRefreshMaxCount == 0)
/*     */     {
/* 159 */       manualRefreshError.errorcode = 5;
/* 160 */       ActivityPointExchangeManager.onError(this.roleId, String.format("[activitypointexchange]PCManualRefreshReq.processImp@ not support refresh|roleId=%d|activityId=%d|mallCfgId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(mallCfgId) }), manualRefreshError);
/*     */       
/*     */ 
/* 163 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 167 */     if (this.refreshCount != xActivityPointExchangeGoodsInfo.getManualrefreshcount())
/*     */     {
/* 169 */       manualRefreshError.errorcode = 6;
/* 170 */       ActivityPointExchangeManager.onError(this.roleId, String.format("[activitypointexchange]PCManualRefreshReq.processImp@ refresh count error|roleId=%d|activityId=%d|refreshCount=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.refreshCount) }), manualRefreshError);
/*     */       
/*     */ 
/* 173 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 177 */     if ((mallCfg.exchangeCountManualRefreshMaxCount > 0) && (this.refreshCount >= mallCfg.exchangeCountManualRefreshMaxCount))
/*     */     {
/* 179 */       manualRefreshError.errorcode = 2;
/* 180 */       ActivityPointExchangeManager.onError(this.roleId, String.format("[activitypointexchange]PCManualRefreshReq.processImp@ refresh count max|roleId=%d|activityId=%d|refreshCount=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.refreshCount) }), manualRefreshError);
/*     */       
/*     */ 
/* 183 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 187 */     STActivityPointExchangeManualRefreshCostCfg activityPointExchangeManualRefreshCostCfg = STActivityPointExchangeManualRefreshCostCfg.get(mallCfg.manualRefreshCostTypeId);
/*     */     
/* 189 */     if (activityPointExchangeManualRefreshCostCfg == null)
/*     */     {
/* 191 */       return false;
/*     */     }
/* 193 */     Map.Entry<Integer, RefreshCostInfo> refreshCostInfoEntry = activityPointExchangeManualRefreshCostCfg.index2refreshCostInfo.floorEntry(Integer.valueOf(this.refreshCount + 1));
/*     */     
/* 195 */     if (refreshCostInfoEntry == null)
/*     */     {
/* 197 */       return false;
/*     */     }
/* 199 */     int moneyType = ((RefreshCostInfo)refreshCostInfoEntry.getValue()).moneyType;
/* 200 */     int moneyCount = ((RefreshCostInfo)refreshCostInfoEntry.getValue()).moneyCount;
/* 201 */     if ((moneyCount != 0) && (moneyType != 0))
/*     */     {
/* 203 */       boolean ret = mzm.gsp.wanted.main.WantedManager.cutMoney(userId, this.roleId, mzm.gsp.tlog.LogReason.ACTIVITY_POINT_EXCHANGE_MANUAL_REFRESH, this.activityId, moneyType, moneyCount, CostType.COST_BIND_FIRST_ACTIVITY_POINT_EXCHANGE_MANUAL_REFRESH);
/*     */       
/* 205 */       if (!ret)
/*     */       {
/* 207 */         manualRefreshError.errorcode = 1;
/* 208 */         ActivityPointExchangeManager.onError(this.roleId, String.format("[activitypointexchange]PCManualRefreshReq.processImp@ money not enough|roleId=%d|activityId=%d|moneyType=%d|moneyCount=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(moneyType), Integer.valueOf(moneyCount) }), manualRefreshError);
/*     */         
/*     */ 
/* 211 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 216 */     xActivityPointExchangeGoodsInfo.setManualrefreshcount(this.refreshCount + 1);
/*     */     
/*     */ 
/* 219 */     xActivityPointExchangeGoodsInfo.getGoodscfgid2count().clear();
/* 220 */     xActivityPointExchangeGoodsInfo.setIsneedrefresh(false);
/*     */     
/*     */ 
/* 223 */     manualRefreshRsp.mallinfo.exchangecountinfo.exchangecountresettimestamp = xActivityPointExchangeGoodsInfo.getExchangecountresettimestamp();
/* 224 */     if (!ActivityPointExchangeManager.getGoodsCfgId2available(xActivityPointExchangeGoodsInfo, mallCfg, manualRefreshRsp.mallinfo.exchangecountinfo.cfgid2available))
/*     */     {
/*     */ 
/* 227 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 231 */     manualRefreshRsp.mallinfo.manualrefreshcountinfo.manualrefreshcountresettimestamp = xActivityPointExchangeGoodsInfo.getManualrefreshcountresettimestamp();
/* 232 */     manualRefreshRsp.mallinfo.manualrefreshcountinfo.manualrefreshcount = xActivityPointExchangeGoodsInfo.getManualrefreshcount();
/*     */     
/* 234 */     OnlineManager.getInstance().send(this.roleId, manualRefreshRsp);
/*     */     
/*     */ 
/* 237 */     ActivityPointExchangeTLogManager.tLogActivityPointExchangeCountManualRefreshLog(this.roleId, this.activityId, mallCfgId, this.refreshCount, TLog_beforeCfgId2count, moneyType, moneyCount);
/*     */     
/*     */ 
/* 240 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\main\PCManualRefreshReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */