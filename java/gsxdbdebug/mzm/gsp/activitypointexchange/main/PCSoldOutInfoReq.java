/*    */ package mzm.gsp.activitypointexchange.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import mzm.gsp.activitypointexchange.SMallInfoError;
/*    */ import mzm.gsp.activitypointexchange.SSoldOutInfoRsp;
/*    */ import mzm.gsp.activitypointexchange.SoldOutInfo;
/*    */ import mzm.gsp.activitypointexchange.confbean.TActivityPointExchangeActivityCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCSoldOutInfoReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   final int activityId;
/*    */   
/*    */   public PCSoldOutInfoReq(long roleId, int activityId)
/*    */   {
/* 23 */     this.roleId = roleId;
/* 24 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     if (!OpenInterface.getOpenStatus(516))
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 37 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1954, true))
/*    */     {
/*    */ 
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     TActivityPointExchangeActivityCfg activityCfg = TActivityPointExchangeActivityCfg.get(this.activityId);
/* 44 */     if (activityCfg == null)
/*    */     {
/* 46 */       return false;
/*    */     }
/*    */     
/* 49 */     if (!OpenInterface.getOpenStatus(activityCfg.activitySwitchId))
/*    */     {
/* 51 */       return false;
/*    */     }
/*    */     
/* 54 */     SMallInfoError mallInfoError = new SMallInfoError();
/* 55 */     mallInfoError.activityid = this.activityId;
/*    */     
/* 57 */     String userId = RoleInterface.getUserId(this.roleId);
/* 58 */     lock(Lockeys.get(User.getTable(), userId));
/* 59 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*    */     
/* 61 */     int mallCfgId = ActivityPointExchangeManager.getOpenMallCfgId(this.roleId, activityCfg);
/* 62 */     if (mallCfgId <= 0)
/*    */     {
/* 64 */       mallInfoError.errorcode = 1;
/* 65 */       OnlineManager.getInstance().sendAtOnce(this.roleId, mallInfoError);
/* 66 */       return false;
/*    */     }
/*    */     
/* 69 */     SSoldOutInfoRsp soldOutInfoRsp = new SSoldOutInfoRsp();
/* 70 */     soldOutInfoRsp.activityid = this.activityId;
/* 71 */     soldOutInfoRsp.activitypointexchangemallcfgid = mallCfgId;
/*    */     
/*    */ 
/* 74 */     Collection<Integer> soldOutGoodsCfgIds = ActivityPointExchangeManager.getSoldOutGoodsCfgIds(this.activityId, mallCfgId);
/*    */     
/* 76 */     if ((soldOutGoodsCfgIds != null) && (!soldOutGoodsCfgIds.isEmpty()))
/*    */     {
/* 78 */       soldOutInfoRsp.soldoutinfo.goodscfgids.addAll(soldOutGoodsCfgIds);
/*    */     }
/*    */     
/* 81 */     OnlineManager.getInstance().send(this.roleId, soldOutInfoRsp);
/* 82 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\main\PCSoldOutInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */