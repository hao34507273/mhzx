/*     */ package mzm.gsp.auction.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.auction.SBidError;
/*     */ import mzm.gsp.auction.SBidRsp;
/*     */ import mzm.gsp.auction.SSynAuctionItemInfo;
/*     */ import mzm.gsp.auction.confbean.OrigAuctionItemCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.wanted.main.WantedManager;
/*     */ import xbean.AucItemInfo;
/*     */ import xbean.AuctionActivityInfo;
/*     */ import xbean.AuctionPeriodInfo;
/*     */ import xbean.AuctionTurnInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCBidReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int activityId;
/*     */   final int turnIndex;
/*     */   final int itemCfgId;
/*     */   final long moneyCount;
/*     */   
/*     */   public PCBidReq(long roleId, int activityId, int turnIndex, int itemCfgId, long moneyCount)
/*     */   {
/*  37 */     this.roleId = roleId;
/*  38 */     this.activityId = activityId;
/*  39 */     this.turnIndex = turnIndex;
/*  40 */     this.itemCfgId = itemCfgId;
/*  41 */     this.moneyCount = moneyCount;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     if ((this.activityId <= 0) || (this.turnIndex <= 0) || (this.itemCfgId <= 0) || (this.moneyCount <= 0L))
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  53 */     if (!OpenInterface.getOpenStatus(534))
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  59 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 2041, true))
/*     */     {
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     SBidError bidError = new SBidError();
/*  65 */     bidError.activityid = this.activityId;
/*  66 */     bidError.turnindex = this.turnIndex;
/*  67 */     bidError.moneycount = this.moneyCount;
/*     */     
/*     */ 
/*  70 */     SActivityCfg activityCfg = SActivityCfg.get(this.activityId);
/*  71 */     if (activityCfg == null)
/*     */     {
/*  73 */       return false;
/*     */     }
/*  75 */     int serverLevel = ServerInterface.getCurrentServerLevel();
/*  76 */     if (serverLevel < activityCfg.serverLevelMin)
/*     */     {
/*  78 */       bidError.errorcode = 2;
/*  79 */       OnlineManager.getInstance().sendAtOnce(this.roleId, bidError);
/*  80 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  84 */     long lastBidderRoleIdBeforeLock = AuctionManager.getBidderRoleId(this.activityId, this.turnIndex, this.itemCfgId, false);
/*     */     
/*     */ 
/*  87 */     Set<Long> roleIdsToLock = new HashSet(2);
/*  88 */     roleIdsToLock.add(Long.valueOf(this.roleId));
/*  89 */     if (lastBidderRoleIdBeforeLock != 0L)
/*     */     {
/*  91 */       roleIdsToLock.add(Long.valueOf(lastBidderRoleIdBeforeLock));
/*     */     }
/*     */     
/*  94 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*     */     
/*  96 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  98 */     lock(Basic.getTable(), roleIdsToLock);
/*     */     
/*     */ 
/* 101 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityId);
/*     */     
/* 103 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/* 105 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 109 */     AuctionActivityInfo xAuctionActivityInfo = AuctionManager.getAuctionActivityInfo(this.activityId, true);
/* 110 */     long currentTimeStamp = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*     */ 
/* 113 */     if ((xAuctionActivityInfo == null) || (xAuctionActivityInfo.getCurrentperiodinfo().getPeriodendtimestamp() <= currentTimeStamp) || (xAuctionActivityInfo.getCurrentperiodinfo().getPeriodstarttimestamp() > currentTimeStamp))
/*     */     {
/*     */ 
/*     */ 
/* 117 */       bidError.errorcode = 3;
/* 118 */       OnlineManager.getInstance().sendAtOnce(this.roleId, bidError);
/* 119 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 123 */     AuctionPeriodInfo xCurrentPeriodInfo = xAuctionActivityInfo.getCurrentperiodinfo();
/* 124 */     AuctionTurnInfo xAuctionTurnInfo = (AuctionTurnInfo)xCurrentPeriodInfo.getTurnindex2turninfo().get(Integer.valueOf(this.turnIndex));
/* 125 */     if ((xAuctionTurnInfo == null) || (xAuctionTurnInfo.getTurnendtimestamp() <= currentTimeStamp) || (xAuctionTurnInfo.getTurnstarttimestamp() > currentTimeStamp))
/*     */     {
/*     */ 
/* 128 */       bidError.errorcode = 4;
/* 129 */       OnlineManager.getInstance().sendAtOnce(this.roleId, bidError);
/* 130 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 134 */     AucItemInfo xAucItemInfo = (AucItemInfo)xAuctionTurnInfo.getTemplateid2iteminfo().get(Integer.valueOf(this.itemCfgId));
/* 135 */     if (xAucItemInfo == null)
/*     */     {
/* 137 */       bidError.errorcode = 5;
/* 138 */       OnlineManager.getInstance().sendAtOnce(this.roleId, bidError);
/* 139 */       return false;
/*     */     }
/*     */     
/* 142 */     bidError.iteminfo = AuctionManager.getItemInfo(xAucItemInfo);
/*     */     
/* 144 */     if ((xAucItemInfo.getBidendtimestamp() <= currentTimeStamp) || (xAucItemInfo.getIssend() == 1))
/*     */     {
/* 146 */       bidError.errorcode = 6;
/* 147 */       OnlineManager.getInstance().sendAtOnce(this.roleId, bidError);
/* 148 */       return false;
/*     */     }
/*     */     
/* 151 */     OrigAuctionItemCfg auctionItemCfg = OrigAuctionItemCfg.get(this.itemCfgId);
/* 152 */     if (auctionItemCfg == null)
/*     */     {
/* 154 */       bidError.errorcode = 5;
/* 155 */       OnlineManager.getInstance().sendAtOnce(this.roleId, bidError);
/* 156 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 160 */     long lastBidPrice = xAucItemInfo.getMaxbidprice();
/* 161 */     long lastBidderRoleId = xAucItemInfo.getBidderroleid();
/* 162 */     if (lastBidderRoleId != lastBidderRoleIdBeforeLock)
/*     */     {
/* 164 */       return false;
/*     */     }
/* 166 */     long lastBidEndTimeStamp = xAucItemInfo.getBidendtimestamp();
/*     */     long minNeedBidPrice;
/*     */     long minNeedBidPrice;
/* 169 */     if (lastBidderRoleId == 0L)
/*     */     {
/* 171 */       minNeedBidPrice = auctionItemCfg.basePrice;
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 176 */       minNeedBidPrice = lastBidPrice + Math.ceil(lastBidPrice * auctionItemCfg.premiumRate / 10000.0D);
/*     */     }
/*     */     
/* 179 */     if (minNeedBidPrice > this.moneyCount)
/*     */     {
/* 181 */       bidError.errorcode = 7;
/* 182 */       OnlineManager.getInstance().sendAtOnce(this.roleId, bidError);
/* 183 */       return false;
/*     */     }
/* 185 */     boolean ret = AuctionManager.checkMoneyForRole(userId, this.roleId, auctionItemCfg.moneyType, this.moneyCount, auctionItemCfg.yuanBaoType == 2).booleanValue();
/*     */     
/* 187 */     if (!ret)
/*     */     {
/* 189 */       bidError.errorcode = 1;
/* 190 */       OnlineManager.getInstance().sendAtOnce(this.roleId, bidError);
/* 191 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 195 */     ret = WantedManager.cutMoney(userId, this.roleId, mzm.gsp.tlog.LogReason.AUCTION_BID, this.itemCfgId, auctionItemCfg.moneyType, this.moneyCount, auctionItemCfg.yuanBaoType == 2 ? CostType.COST_BIND_FIRST_AUCTION_BID : CostType.COST_UN_BIND_AUCTION_BID);
/*     */     
/*     */ 
/*     */ 
/* 199 */     if (!ret)
/*     */     {
/* 201 */       bidError.errorcode = 1;
/* 202 */       OnlineManager.getInstance().sendAtOnce(this.roleId, bidError);
/* 203 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 207 */     ret = AuctionManager.refundBidderWhenExceed(this.activityId, this.turnIndex, this.roleId, this.moneyCount, xCurrentPeriodInfo, xAuctionTurnInfo, xAucItemInfo);
/*     */     
/* 209 */     if (!ret)
/*     */     {
/* 211 */       return false;
/*     */     }
/*     */     
/* 214 */     SBidRsp bidRsp = new SBidRsp();
/* 215 */     bidRsp.activityid = this.activityId;
/* 216 */     bidRsp.turnindex = this.turnIndex;
/* 217 */     bidRsp.itemcfgid = this.itemCfgId;
/* 218 */     bidRsp.moneycount = this.moneyCount;
/* 219 */     OnlineManager.getInstance().send(this.roleId, bidRsp);
/*     */     
/*     */ 
/* 222 */     SSynAuctionItemInfo synAuctionItemInfo = new SSynAuctionItemInfo();
/* 223 */     synAuctionItemInfo.activityid = this.activityId;
/* 224 */     synAuctionItemInfo.turnindex = this.turnIndex;
/* 225 */     synAuctionItemInfo.iteminfo = AuctionManager.getItemInfo(xAucItemInfo);
/* 226 */     OnlineManager.getInstance().sendAll(synAuctionItemInfo);
/*     */     
/*     */ 
/* 229 */     AuctionTLogManager.tLogAuctionBidLog(this.roleId, this.activityId, xCurrentPeriodInfo.getPeriodstarttimestamp(), xCurrentPeriodInfo.getPeriodendtimestamp(), this.turnIndex, xAuctionTurnInfo.getTurnstarttimestamp(), xAuctionTurnInfo.getTurnendtimestamp(), this.itemCfgId, lastBidEndTimeStamp, xAucItemInfo.getBidendtimestamp(), xAucItemInfo.getBidendfinaltimestamp(), lastBidderRoleId, lastBidPrice, this.moneyCount);
/*     */     
/*     */ 
/*     */ 
/* 233 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\main\PCBidReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */