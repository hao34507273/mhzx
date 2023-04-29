/*     */ package mzm.gsp.activitypointexchange.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.activitypointexchange.MallInfo;
/*     */ import mzm.gsp.activitypointexchange.SMallInfoError;
/*     */ import mzm.gsp.activitypointexchange.SMallInfoRsp;
/*     */ import mzm.gsp.activitypointexchange.SoldOutInfo;
/*     */ import mzm.gsp.activitypointexchange.confbean.SActivityPointExchangeMallCfg;
/*     */ import mzm.gsp.activitypointexchange.confbean.TActivityPointExchangeActivityCfg;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.ActivityPointExchangeGoodsInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCMallInfoReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int activityId;
/*     */   
/*     */   public PCMallInfoReq(long roleId, int activityId)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.activityId = activityId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (!OpenInterface.getOpenStatus(516))
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  42 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1955, true))
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  48 */     TActivityPointExchangeActivityCfg activityCfg = TActivityPointExchangeActivityCfg.get(this.activityId);
/*  49 */     if (activityCfg == null)
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     if (!OpenInterface.getOpenStatus(activityCfg.activitySwitchId))
/*     */     {
/*  56 */       return false;
/*     */     }
/*  58 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  59 */     lock(Lockeys.get(User.getTable(), userId));
/*  60 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*  62 */     SMallInfoError mallInfoError = new SMallInfoError();
/*  63 */     mallInfoError.activityid = this.activityId;
/*  64 */     int mallCfgId = ActivityPointExchangeManager.getOpenMallCfgId(this.roleId, activityCfg);
/*  65 */     if (mallCfgId <= 0)
/*     */     {
/*  67 */       mallInfoError.errorcode = 1;
/*  68 */       OnlineManager.getInstance().sendAtOnce(this.roleId, mallInfoError);
/*  69 */       return false;
/*     */     }
/*  71 */     SActivityPointExchangeMallCfg mallCfg = SActivityPointExchangeMallCfg.get(mallCfgId);
/*  72 */     if (mallCfg == null)
/*     */     {
/*  74 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  78 */     ActivityPointExchangeGoodsInfo xActivityPointExchangeGoodsInfo = ActivityPointExchangeManager.getActivityPointExchangeGoodsInfo(this.roleId, this.activityId, mallCfgId);
/*     */     
/*     */ 
/*  81 */     SMallInfoRsp mallInfoRsp = new SMallInfoRsp();
/*  82 */     mallInfoRsp.activityid = this.activityId;
/*  83 */     mallInfoRsp.activitypointexchangemallcfgid = mallCfgId;
/*  84 */     mallInfoRsp.mallinfo.pointcount = MallInterface.getJifen(this.roleId, mallCfg.tokenType);
/*     */     
/*     */ 
/*  87 */     Collection<Integer> soldOutGoodsCfgIds = ActivityPointExchangeManager.getSoldOutGoodsCfgIds(this.activityId, mallCfgId);
/*     */     
/*  89 */     if ((soldOutGoodsCfgIds != null) && (!soldOutGoodsCfgIds.isEmpty()))
/*     */     {
/*  91 */       mallInfoRsp.mallinfo.soldoutinfo.goodscfgids.addAll(soldOutGoodsCfgIds);
/*     */     }
/*     */     
/*  94 */     if (xActivityPointExchangeGoodsInfo == null)
/*     */     {
/*  96 */       OnlineManager.getInstance().send(this.roleId, mallInfoRsp);
/*  97 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 101 */     long currentTimeStamp = TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis());
/* 102 */     mzm.gsp.activitypointexchange.main.handler.ActivityPointExchangeHandler activityPointExchangeHandler = ActivityPointExchangeManager.getActivityPointExchangeHandler(this.activityId);
/*     */     
/* 104 */     ActivityPointExchangeManager.checkResetExchangeCount(this.roleId, this.activityId, mallCfgId, xActivityPointExchangeGoodsInfo, currentTimeStamp, activityPointExchangeHandler);
/*     */     
/* 106 */     ActivityPointExchangeManager.checkResetManualRefreshCount(this.roleId, this.activityId, mallCfgId, xActivityPointExchangeGoodsInfo, currentTimeStamp, activityPointExchangeHandler);
/*     */     
/*     */ 
/*     */ 
/* 110 */     mallInfoRsp.mallinfo.exchangecountinfo.exchangecountresettimestamp = xActivityPointExchangeGoodsInfo.getExchangecountresettimestamp();
/* 111 */     if (!ActivityPointExchangeManager.getGoodsCfgId2available(xActivityPointExchangeGoodsInfo, mallCfg, mallInfoRsp.mallinfo.exchangecountinfo.cfgid2available))
/*     */     {
/*     */ 
/* 114 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 118 */     mallInfoRsp.mallinfo.manualrefreshcountinfo.manualrefreshcountresettimestamp = xActivityPointExchangeGoodsInfo.getManualrefreshcountresettimestamp();
/* 119 */     mallInfoRsp.mallinfo.manualrefreshcountinfo.manualrefreshcount = xActivityPointExchangeGoodsInfo.getManualrefreshcount();
/*     */     
/* 121 */     OnlineManager.getInstance().send(this.roleId, mallInfoRsp);
/* 122 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\main\PCMallInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */