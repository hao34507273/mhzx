/*     */ package mzm.gsp.auction.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.auction.ItemInfo;
/*     */ import mzm.gsp.auction.SGetAuctionInfoError;
/*     */ import mzm.gsp.auction.SGetAuctionInfoRsp;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import xbean.AucItemInfo;
/*     */ import xbean.AuctionActivityInfo;
/*     */ import xbean.AuctionPeriodInfo;
/*     */ import xbean.AuctionTurnInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetAuctionInfoReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int activityId;
/*     */   final int turnIndex;
/*     */   
/*     */   public PCGetAuctionInfoReq(long roleId, int activityId, int turnIndex)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.activityId = activityId;
/*  31 */     this.turnIndex = turnIndex;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if ((this.activityId <= 0) || (this.turnIndex <= 0))
/*     */     {
/*  39 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  43 */     if (!OpenInterface.getOpenStatus(534))
/*     */     {
/*  45 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  49 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 2042, true))
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     SGetAuctionInfoError getAuctionInfoError = new SGetAuctionInfoError();
/*  55 */     getAuctionInfoError.activityid = this.activityId;
/*  56 */     getAuctionInfoError.turnindex = this.turnIndex;
/*     */     
/*     */ 
/*  59 */     SActivityCfg activityCfg = SActivityCfg.get(this.activityId);
/*  60 */     if (activityCfg == null)
/*     */     {
/*  62 */       return false;
/*     */     }
/*  64 */     int serverLevel = mzm.gsp.server.main.ServerInterface.getCurrentServerLevel();
/*  65 */     if (serverLevel < activityCfg.serverLevelMin)
/*     */     {
/*  67 */       getAuctionInfoError.errorcode = 1;
/*  68 */       OnlineManager.getInstance().sendAtOnce(this.roleId, getAuctionInfoError);
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*     */     
/*  74 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  76 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*  79 */     ActivityJoinResult activityJoinResult = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityId);
/*     */     
/*  81 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*  83 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  87 */     AuctionActivityInfo xAuctionActivityInfo = AuctionManager.getAuctionActivityInfo(this.activityId, true);
/*  88 */     long currentTimeStamp = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  90 */     if ((xAuctionActivityInfo == null) || (xAuctionActivityInfo.getCurrentperiodinfo().getPeriodendtimestamp() <= currentTimeStamp) || (xAuctionActivityInfo.getCurrentperiodinfo().getPeriodstarttimestamp() > currentTimeStamp))
/*     */     {
/*     */ 
/*     */ 
/*  94 */       getAuctionInfoError.errorcode = 2;
/*  95 */       OnlineManager.getInstance().sendAtOnce(this.roleId, getAuctionInfoError);
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     AuctionPeriodInfo xAuctionPeriodInfo = xAuctionActivityInfo.getCurrentperiodinfo();
/* 100 */     AuctionTurnInfo xAuctionTurnInfo = (AuctionTurnInfo)xAuctionPeriodInfo.getTurnindex2turninfo().get(Integer.valueOf(this.turnIndex));
/* 101 */     if (xAuctionTurnInfo == null)
/*     */     {
/* 103 */       getAuctionInfoError.errorcode = 3;
/* 104 */       OnlineManager.getInstance().sendAtOnce(this.roleId, getAuctionInfoError);
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     SGetAuctionInfoRsp getAuctionInfoRsp = new SGetAuctionInfoRsp();
/* 109 */     getAuctionInfoRsp.activityid = this.activityId;
/* 110 */     getAuctionInfoRsp.turnindex = this.turnIndex;
/*     */     
/*     */ 
/*     */ 
/* 114 */     for (Map.Entry<Integer, AucItemInfo> entry : xAuctionTurnInfo.getTemplateid2iteminfo().entrySet())
/*     */     {
/* 116 */       AucItemInfo xAucItemInfo = (AucItemInfo)entry.getValue();
/* 117 */       ItemInfo itemInfo = AuctionManager.getItemInfo(xAucItemInfo);
/* 118 */       getAuctionInfoRsp.iteminfolist.add(itemInfo);
/*     */     }
/*     */     
/* 121 */     OnlineManager.getInstance().send(this.roleId, getAuctionInfoRsp);
/* 122 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\main\PCGetAuctionInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */