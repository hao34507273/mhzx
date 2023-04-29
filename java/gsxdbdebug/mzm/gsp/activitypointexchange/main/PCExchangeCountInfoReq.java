/*     */ package mzm.gsp.activitypointexchange.main;
/*     */ 
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.activitypointexchange.ExchangeCountInfo;
/*     */ import mzm.gsp.activitypointexchange.SExchangeCountInfoRsp;
/*     */ import mzm.gsp.activitypointexchange.SMallInfoError;
/*     */ import mzm.gsp.activitypointexchange.confbean.SActivityPointExchangeMallCfg;
/*     */ import mzm.gsp.activitypointexchange.confbean.TActivityPointExchangeActivityCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.ActivityPointExchangeGoodsInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCExchangeCountInfoReq extends LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int activityId;
/*     */   
/*     */   public PCExchangeCountInfoReq(long roleId, int activityId)
/*     */   {
/*  26 */     this.roleId = roleId;
/*  27 */     this.activityId = activityId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (!OpenInterface.getOpenStatus(516))
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  40 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1953, true))
/*     */     {
/*     */ 
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     TActivityPointExchangeActivityCfg activityCfg = TActivityPointExchangeActivityCfg.get(this.activityId);
/*  47 */     if (activityCfg == null)
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if (!OpenInterface.getOpenStatus(activityCfg.activitySwitchId))
/*     */     {
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     String userId = RoleInterface.getUserId(this.roleId);
/*  58 */     lock(Lockeys.get(User.getTable(), userId));
/*  59 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*  61 */     SMallInfoError mallInfoError = new SMallInfoError();
/*  62 */     mallInfoError.activityid = this.activityId;
/*  63 */     int mallCfgId = ActivityPointExchangeManager.getOpenMallCfgId(this.roleId, activityCfg);
/*  64 */     if (mallCfgId <= 0)
/*     */     {
/*  66 */       mallInfoError.errorcode = 1;
/*  67 */       OnlineManager.getInstance().sendAtOnce(this.roleId, mallInfoError);
/*  68 */       return false;
/*     */     }
/*  70 */     SActivityPointExchangeMallCfg mallCfg = SActivityPointExchangeMallCfg.get(mallCfgId);
/*  71 */     if (mallCfg == null)
/*     */     {
/*  73 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  77 */     ActivityPointExchangeGoodsInfo xActivityPointExchangeGoodsInfo = ActivityPointExchangeManager.getActivityPointExchangeGoodsInfo(this.roleId, this.activityId, mallCfgId);
/*     */     
/*     */ 
/*  80 */     SExchangeCountInfoRsp exchangeCountInfoRsp = new SExchangeCountInfoRsp();
/*  81 */     exchangeCountInfoRsp.activityid = this.activityId;
/*  82 */     exchangeCountInfoRsp.activitypointexchangemallcfgid = mallCfgId;
/*     */     
/*  84 */     if (xActivityPointExchangeGoodsInfo == null)
/*     */     {
/*  86 */       OnlineManager.getInstance().send(this.roleId, exchangeCountInfoRsp);
/*  87 */       return true;
/*     */     }
/*     */     
/*     */ 
/*  91 */     long currentTimeStamp = TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis());
/*  92 */     mzm.gsp.activitypointexchange.main.handler.ActivityPointExchangeHandler activityPointExchangeHandler = ActivityPointExchangeManager.getActivityPointExchangeHandler(this.activityId);
/*     */     
/*  94 */     ActivityPointExchangeManager.checkResetExchangeCount(this.roleId, this.activityId, mallCfgId, xActivityPointExchangeGoodsInfo, currentTimeStamp, activityPointExchangeHandler);
/*     */     
/*     */ 
/*     */ 
/*  98 */     exchangeCountInfoRsp.exchangecountinfo.exchangecountresettimestamp = xActivityPointExchangeGoodsInfo.getExchangecountresettimestamp();
/*  99 */     if (!ActivityPointExchangeManager.getGoodsCfgId2available(xActivityPointExchangeGoodsInfo, mallCfg, exchangeCountInfoRsp.exchangecountinfo.cfgid2available))
/*     */     {
/*     */ 
/* 102 */       return false;
/*     */     }
/*     */     
/* 105 */     OnlineManager.getInstance().send(this.roleId, exchangeCountInfoRsp);
/* 106 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\main\PCExchangeCountInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */