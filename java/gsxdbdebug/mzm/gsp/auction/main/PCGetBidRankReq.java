/*     */ package mzm.gsp.auction.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.auction.SGetBidRankError;
/*     */ import mzm.gsp.auction.SGetBidRankRsp;
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
/*     */ public class PCGetBidRankReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int activityId;
/*     */   
/*     */   public PCGetBidRankReq(long roleId, int activityId)
/*     */   {
/*  27 */     this.roleId = roleId;
/*  28 */     this.activityId = activityId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (this.activityId <= 0)
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  40 */     if (!OpenInterface.getOpenStatus(534))
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  46 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 2044, true))
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     SGetBidRankError getBidRankError = new SGetBidRankError();
/*  52 */     getBidRankError.activityid = this.activityId;
/*     */     
/*     */ 
/*  55 */     SActivityCfg activityCfg = SActivityCfg.get(this.activityId);
/*  56 */     if (activityCfg == null)
/*     */     {
/*  58 */       return false;
/*     */     }
/*  60 */     int serverLevel = mzm.gsp.server.main.ServerInterface.getCurrentServerLevel();
/*  61 */     if (serverLevel < activityCfg.serverLevelMin)
/*     */     {
/*  63 */       getBidRankError.errorcode = 1;
/*  64 */       OnlineManager.getInstance().sendAtOnce(this.roleId, getBidRankError);
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*     */     
/*  70 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  72 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*  75 */     ActivityJoinResult activityJoinResult = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityId);
/*     */     
/*  77 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  83 */     AuctionActivityInfo xAuctionActivityInfo = AuctionManager.getAuctionActivityInfo(this.activityId, true);
/*  84 */     long currentTimeStamp = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  86 */     if ((xAuctionActivityInfo == null) || (xAuctionActivityInfo.getCurrentperiodinfo().getPeriodendtimestamp() <= currentTimeStamp) || (xAuctionActivityInfo.getCurrentperiodinfo().getPeriodstarttimestamp() > currentTimeStamp))
/*     */     {
/*     */ 
/*     */ 
/*  90 */       getBidRankError.errorcode = 2;
/*  91 */       OnlineManager.getInstance().sendAtOnce(this.roleId, getBidRankError);
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     SGetBidRankRsp getBidRankRsp = new SGetBidRankRsp();
/*  96 */     getBidRankRsp.activityid = this.activityId;
/*     */     
/*  98 */     AuctionPeriodInfo auctionPeriodInfo = xAuctionActivityInfo.getLastperiodinfo();
/*  99 */     if (auctionPeriodInfo == null)
/*     */     {
/* 101 */       OnlineManager.getInstance().send(this.roleId, getBidRankRsp);
/* 102 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 106 */     for (Map.Entry<Integer, AuctionTurnInfo> entry : auctionPeriodInfo.getTurnindex2turninfo().entrySet())
/*     */     {
/* 108 */       AuctionTurnInfo xAuctionTurnInfo = (AuctionTurnInfo)entry.getValue();
/* 109 */       for (Map.Entry<Integer, AucItemInfo> aucItemInfoEntry : xAuctionTurnInfo.getTemplateid2iteminfo().entrySet())
/*     */       {
/* 111 */         getBidRankRsp.iteminfolist.add(AuctionManager.getItemInfo((AucItemInfo)aucItemInfoEntry.getValue()));
/*     */       }
/*     */     }
/*     */     
/* 115 */     OnlineManager.getInstance().send(this.roleId, getBidRankRsp);
/* 116 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\main\PCGetBidRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */