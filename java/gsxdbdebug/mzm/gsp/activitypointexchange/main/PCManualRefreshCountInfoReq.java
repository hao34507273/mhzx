/*    */ package mzm.gsp.activitypointexchange.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.activitypointexchange.SMallInfoError;
/*    */ import mzm.gsp.activitypointexchange.SManualRefreshCountInfoRsp;
/*    */ import mzm.gsp.activitypointexchange.confbean.TActivityPointExchangeActivityCfg;
/*    */ import mzm.gsp.activitypointexchange.main.handler.ActivityPointExchangeHandler;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.ActivityPointExchangeGoodsInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCManualRefreshCountInfoReq extends LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   final int activityId;
/*    */   
/*    */   public PCManualRefreshCountInfoReq(long roleId, int activityId)
/*    */   {
/* 25 */     this.roleId = roleId;
/* 26 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     if (!OpenInterface.getOpenStatus(516))
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 39 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1951, true))
/*    */     {
/*    */ 
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     TActivityPointExchangeActivityCfg activityCfg = TActivityPointExchangeActivityCfg.get(this.activityId);
/* 46 */     if (activityCfg == null)
/*    */     {
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     if (!OpenInterface.getOpenStatus(activityCfg.activitySwitchId))
/*    */     {
/* 53 */       return false;
/*    */     }
/* 55 */     String userId = RoleInterface.getUserId(this.roleId);
/* 56 */     lock(Lockeys.get(User.getTable(), userId));
/* 57 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*    */     
/* 59 */     SMallInfoError mallInfoError = new SMallInfoError();
/* 60 */     mallInfoError.activityid = this.activityId;
/* 61 */     int mallCfgId = ActivityPointExchangeManager.getOpenMallCfgId(this.roleId, activityCfg);
/* 62 */     if (mallCfgId <= 0)
/*    */     {
/* 64 */       mallInfoError.errorcode = 1;
/* 65 */       OnlineManager.getInstance().sendAtOnce(this.roleId, mallInfoError);
/* 66 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 70 */     ActivityPointExchangeGoodsInfo xActivityPointExchangeGoodsInfo = ActivityPointExchangeManager.getActivityPointExchangeGoodsInfo(this.roleId, this.activityId, mallCfgId);
/*    */     
/*    */ 
/* 73 */     SManualRefreshCountInfoRsp manualRefreshCountInfoRsp = new SManualRefreshCountInfoRsp();
/* 74 */     manualRefreshCountInfoRsp.activityid = this.activityId;
/* 75 */     manualRefreshCountInfoRsp.activitypointexchangemallcfgid = mallCfgId;
/*    */     
/* 77 */     if (xActivityPointExchangeGoodsInfo == null)
/*    */     {
/* 79 */       OnlineManager.getInstance().send(this.roleId, manualRefreshCountInfoRsp);
/* 80 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 84 */     long currentTimeStamp = TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis());
/*    */     
/* 86 */     ActivityPointExchangeHandler activityPointExchangeHandler = ActivityPointExchangeManager.getActivityPointExchangeHandler(this.activityId);
/*    */     
/* 88 */     ActivityPointExchangeManager.checkResetManualRefreshCount(this.roleId, this.activityId, mallCfgId, xActivityPointExchangeGoodsInfo, currentTimeStamp, activityPointExchangeHandler);
/*    */     
/*    */ 
/* 91 */     manualRefreshCountInfoRsp.manualrefreshcountinfo.manualrefreshcountresettimestamp = xActivityPointExchangeGoodsInfo.getManualrefreshcountresettimestamp();
/* 92 */     manualRefreshCountInfoRsp.manualrefreshcountinfo.manualrefreshcount = xActivityPointExchangeGoodsInfo.getManualrefreshcount();
/*    */     
/* 94 */     OnlineManager.getInstance().send(this.roleId, manualRefreshCountInfoRsp);
/* 95 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\main\PCManualRefreshCountInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */