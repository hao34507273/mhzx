/*     */ package mzm.gsp.activitypointexchange.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.activitypointexchange.SPointExchangeError;
/*     */ import mzm.gsp.activitypointexchange.SPointExchangeRsp;
/*     */ import mzm.gsp.activitypointexchange.confbean.SActivityPointExchangeMallCfg;
/*     */ import mzm.gsp.activitypointexchange.confbean.SPointExchangeGoodsInfo;
/*     */ import mzm.gsp.activitypointexchange.confbean.STActivityPointExchangeGoodsCfg;
/*     */ import mzm.gsp.activitypointexchange.confbean.TActivityPointExchangeActivityCfg;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.mall.main.JifenOperateResult;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.ActivityPointExchangeGoodsInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCPointExchangeReq extends LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int activityId;
/*     */   final int goodsCfgId;
/*     */   final int count;
/*     */   
/*     */   public PCPointExchangeReq(long roleId, int activityId, int goodsCfgId, int count)
/*     */   {
/*  38 */     this.roleId = roleId;
/*  39 */     this.activityId = activityId;
/*  40 */     this.goodsCfgId = goodsCfgId;
/*  41 */     this.count = count;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     if ((this.count <= 0) || (this.activityId <= 0) || (this.goodsCfgId <= 0))
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
/*  59 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1956, true))
/*     */     {
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  65 */     TActivityPointExchangeActivityCfg activityCfg = TActivityPointExchangeActivityCfg.get(this.activityId);
/*  66 */     if (activityCfg == null)
/*     */     {
/*  68 */       return false;
/*     */     }
/*  70 */     SPointExchangeError pointExchangeError = new SPointExchangeError();
/*  71 */     pointExchangeError.activityid = this.activityId;
/*  72 */     pointExchangeError.count = this.count;
/*  73 */     pointExchangeError.goodscfgid = this.goodsCfgId;
/*     */     
/*  75 */     if (!OpenInterface.getOpenStatus(activityCfg.activitySwitchId))
/*     */     {
/*  77 */       pointExchangeError.errorcode = 4;
/*  78 */       ActivityPointExchangeManager.onError(this.roleId, String.format("[activitypointexchange]PCPointExchangeReq.processImp@ activity closed|roleId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId) }), pointExchangeError);
/*     */       
/*     */ 
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     String userId = RoleInterface.getUserId(this.roleId);
/*  85 */     lock(Lockeys.get(User.getTable(), userId));
/*  86 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*  88 */     int mallCfgId = ActivityPointExchangeManager.getOpenMallCfgId(this.roleId, activityCfg);
/*  89 */     if (mallCfgId <= 0)
/*     */     {
/*  91 */       pointExchangeError.errorcode = 5;
/*  92 */       OnlineManager.getInstance().sendAtOnce(this.roleId, pointExchangeError);
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     SActivityPointExchangeMallCfg mallCfg = SActivityPointExchangeMallCfg.get(mallCfgId);
/*  97 */     if (mallCfg == null)
/*     */     {
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     STActivityPointExchangeGoodsCfg activityPointExchangeGoodsCfg = STActivityPointExchangeGoodsCfg.get(mallCfg.goodsCfgTypeId);
/*     */     
/* 104 */     if (activityPointExchangeGoodsCfg == null)
/*     */     {
/* 106 */       return false;
/*     */     }
/* 108 */     SPointExchangeGoodsInfo pointExchangeGoodsInfo = (SPointExchangeGoodsInfo)activityPointExchangeGoodsCfg.id2pointExchangeGoodsInfo.get(Integer.valueOf(this.goodsCfgId));
/*     */     
/* 110 */     if (pointExchangeGoodsInfo == null)
/*     */     {
/* 112 */       return false;
/*     */     }
/*     */     
/* 115 */     mzm.gsp.activitypointexchange.main.handler.ActivityPointExchangeHandler activityPointExchangeHandler = ActivityPointExchangeManager.getActivityPointExchangeHandler(this.activityId);
/*     */     
/*     */ 
/*     */ 
/* 119 */     ActivityPointExchangeGoodsInfo xActivityPointExchangeGoodsInfo = ActivityPointExchangeManager.getActivityPointExchangeGoodsInfoCreateIfNotExist(this.roleId, this.activityId, mallCfgId, activityPointExchangeHandler);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 124 */     Collection<Integer> soldOutGoodsCfgIds = ActivityPointExchangeManager.getSoldOutGoodsCfgIds(this.activityId, mallCfgId);
/*     */     
/* 126 */     if ((soldOutGoodsCfgIds != null) && (soldOutGoodsCfgIds.contains(Integer.valueOf(this.goodsCfgId))))
/*     */     {
/* 128 */       pointExchangeError.errorcode = 3;
/* 129 */       ActivityPointExchangeManager.onError(this.roleId, String.format("[activitypointexchange]PCPointExchangeReq.processImp@ goods sold out|roleId=%d|activityId=%d|goodsCfgId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.goodsCfgId) }), pointExchangeError);
/*     */       
/*     */ 
/* 132 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 136 */     long currentTimeStamp = TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis());
/* 137 */     ActivityPointExchangeManager.checkResetExchangeCount(this.roleId, this.activityId, mallCfgId, xActivityPointExchangeGoodsInfo, currentTimeStamp, activityPointExchangeHandler);
/*     */     
/* 139 */     ActivityPointExchangeManager.checkResetManualRefreshCount(this.roleId, this.activityId, mallCfgId, xActivityPointExchangeGoodsInfo, currentTimeStamp, activityPointExchangeHandler);
/*     */     
/*     */     int xLastGoodsCount;
/*     */     
/*     */     int xLastGoodsCount;
/* 144 */     if (xActivityPointExchangeGoodsInfo.getGoodscfgid2count().containsKey(Integer.valueOf(this.goodsCfgId)))
/*     */     {
/* 146 */       xLastGoodsCount = ((Integer)xActivityPointExchangeGoodsInfo.getGoodscfgid2count().get(Integer.valueOf(this.goodsCfgId))).intValue();
/*     */     }
/*     */     else
/*     */     {
/* 150 */       xLastGoodsCount = 0;
/*     */     }
/*     */     
/* 153 */     int currentGoodsCount = xLastGoodsCount + this.count;
/*     */     
/* 155 */     if ((pointExchangeGoodsInfo.exchangeMaxCount != -1) && (currentGoodsCount > pointExchangeGoodsInfo.exchangeMaxCount))
/*     */     {
/* 157 */       pointExchangeError.errorcode = 2;
/* 158 */       ActivityPointExchangeManager.onError(this.roleId, String.format("[activitypointexchange]PCPointExchangeReq.processImp@ exchange count max|roleId=%d|activityId=%d|goodsCfgId=%d|beforeExchangeCount=%d|afterExchangeCount=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.goodsCfgId), Integer.valueOf(this.count), Integer.valueOf(currentGoodsCount) }), pointExchangeError);
/*     */       
/*     */ 
/* 161 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 165 */     xActivityPointExchangeGoodsInfo.getGoodscfgid2count().put(Integer.valueOf(this.goodsCfgId), Integer.valueOf(currentGoodsCount));
/* 166 */     if (pointExchangeGoodsInfo.exchangeMaxCount != -1)
/*     */     {
/* 168 */       xActivityPointExchangeGoodsInfo.setIsneedrefresh(true);
/*     */     }
/*     */     
/*     */ 
/* 172 */     int needPointCount = this.count * pointExchangeGoodsInfo.tokenCount;
/* 173 */     long lastPointCount = MallInterface.getJifen(this.roleId, mallCfg.tokenType);
/* 174 */     JifenOperateResult jifenOperateResult = MallInterface.cutJifen(this.roleId, needPointCount, mallCfg.tokenType, new TLogArg(LogReason.ACTIVITY_POINT_EXCHANGE_POINT_EXCHANGE, this.activityId));
/*     */     
/* 176 */     if (!jifenOperateResult.isSuccess())
/*     */     {
/* 178 */       pointExchangeError.errorcode = 1;
/* 179 */       ActivityPointExchangeManager.onError(this.roleId, String.format("[activitypointexchange]PCPointExchangeReq.processImp@ point not enough|roleId=%d|activityId=%d|goodsCfgId=%d|needPoint=%d|currentPoint=%d|tokenType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.goodsCfgId), Integer.valueOf(needPointCount), Long.valueOf(lastPointCount), Integer.valueOf(mallCfg.tokenType) }), pointExchangeError);
/*     */       
/*     */ 
/*     */ 
/* 183 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 187 */     AwardReason awardReason = new AwardReason(LogReason.ACTIVITY_POINT_EXCHANGE_POINT_EXCHANGE, this.activityId);
/* 188 */     awardReason.setAwardItemBind(true);
/* 189 */     mzm.gsp.award.main.AwardModel awardModel = AwardInterface.awardFixAwardNTime(pointExchangeGoodsInfo.fixAwardId, this.count, userId, this.roleId, true, true, awardReason);
/*     */     
/* 191 */     if (awardModel == null)
/*     */     {
/* 193 */       return false;
/*     */     }
/*     */     
/* 196 */     SPointExchangeRsp pointExchangeRsp = new SPointExchangeRsp();
/* 197 */     pointExchangeRsp.activityid = this.activityId;
/* 198 */     pointExchangeRsp.activitypointexchangemallcfgid = mallCfgId;
/* 199 */     pointExchangeRsp.goodscfgid = this.goodsCfgId;
/* 200 */     pointExchangeRsp.count = this.count;
/* 201 */     pointExchangeRsp.available = (pointExchangeGoodsInfo.exchangeMaxCount == -1 ? -1 : pointExchangeGoodsInfo.exchangeMaxCount - currentGoodsCount);
/*     */     
/*     */ 
/* 204 */     pointExchangeRsp.pointcount = MallInterface.getJifen(this.roleId, mallCfg.tokenType);
/*     */     
/*     */ 
/* 207 */     ActivityPointExchangeTLogManager.tLogActivityPointExchangeLog(this.roleId, this.activityId, mallCfgId, this.goodsCfgId, this.count, mallCfg.tokenType, lastPointCount, pointExchangeRsp.pointcount, xLastGoodsCount, currentGoodsCount);
/*     */     
/*     */ 
/* 210 */     OnlineManager.getInstance().send(this.roleId, pointExchangeRsp);
/* 211 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\main\PCPointExchangeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */