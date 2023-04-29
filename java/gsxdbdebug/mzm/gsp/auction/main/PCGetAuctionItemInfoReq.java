/*     */ package mzm.gsp.auction.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.auction.SGetAuctionItemInfoError;
/*     */ import mzm.gsp.auction.SSynAuctionItemInfo;
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
/*     */ public class PCGetAuctionItemInfoReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int activityId;
/*     */   final int turnIndex;
/*     */   final int itemCfgId;
/*     */   
/*     */   public PCGetAuctionItemInfoReq(long roleId, int activityId, int turnIndex, int itemCfgId)
/*     */   {
/*  27 */     this.roleId = roleId;
/*  28 */     this.activityId = activityId;
/*  29 */     this.turnIndex = turnIndex;
/*  30 */     this.itemCfgId = itemCfgId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if ((this.activityId <= 0) || (this.turnIndex <= 0) || (this.itemCfgId <= 0))
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     if (!OpenInterface.getOpenStatus(534))
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 2043, true))
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     SGetAuctionItemInfoError getAuctionItemInfoError = new SGetAuctionItemInfoError();
/*  52 */     getAuctionItemInfoError.activityid = this.activityId;
/*  53 */     getAuctionItemInfoError.turnindex = this.turnIndex;
/*  54 */     getAuctionItemInfoError.itemcfgid = this.itemCfgId;
/*     */     
/*     */ 
/*  57 */     SActivityCfg activityCfg = SActivityCfg.get(this.activityId);
/*  58 */     if (activityCfg == null)
/*     */     {
/*  60 */       return false;
/*     */     }
/*  62 */     int serverLevel = mzm.gsp.server.main.ServerInterface.getCurrentServerLevel();
/*  63 */     if (serverLevel < activityCfg.serverLevelMin)
/*     */     {
/*  65 */       getAuctionItemInfoError.errorcode = 1;
/*  66 */       OnlineManager.getInstance().sendAtOnce(this.roleId, getAuctionItemInfoError);
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*     */     
/*  72 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  74 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*  77 */     ActivityJoinResult activityJoinResult = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityId);
/*     */     
/*  79 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*  81 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  85 */     AuctionActivityInfo xAuctionActivityInfo = AuctionManager.getAuctionActivityInfo(this.activityId, true);
/*  86 */     long currentTimeStamp = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  88 */     if ((xAuctionActivityInfo == null) || (xAuctionActivityInfo.getCurrentperiodinfo().getPeriodendtimestamp() <= currentTimeStamp) || (xAuctionActivityInfo.getCurrentperiodinfo().getPeriodstarttimestamp() > currentTimeStamp))
/*     */     {
/*     */ 
/*     */ 
/*  92 */       getAuctionItemInfoError.errorcode = 2;
/*  93 */       OnlineManager.getInstance().sendAtOnce(this.roleId, getAuctionItemInfoError);
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     AuctionPeriodInfo xAuctionPeriodInfo = xAuctionActivityInfo.getCurrentperiodinfo();
/*  98 */     AuctionTurnInfo xAuctionTurnInfo = (AuctionTurnInfo)xAuctionPeriodInfo.getTurnindex2turninfo().get(Integer.valueOf(this.turnIndex));
/*  99 */     if (xAuctionTurnInfo == null)
/*     */     {
/* 101 */       getAuctionItemInfoError.errorcode = 3;
/* 102 */       OnlineManager.getInstance().sendAtOnce(this.roleId, getAuctionItemInfoError);
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     AucItemInfo xAucItemInfo = (AucItemInfo)xAuctionTurnInfo.getTemplateid2iteminfo().get(Integer.valueOf(this.itemCfgId));
/* 107 */     if (xAucItemInfo == null)
/*     */     {
/* 109 */       getAuctionItemInfoError.errorcode = 3;
/* 110 */       OnlineManager.getInstance().sendAtOnce(this.roleId, getAuctionItemInfoError);
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     SSynAuctionItemInfo synAuctionItemInfo = new SSynAuctionItemInfo();
/* 115 */     synAuctionItemInfo.activityid = this.activityId;
/* 116 */     synAuctionItemInfo.turnindex = this.turnIndex;
/* 117 */     synAuctionItemInfo.iteminfo = AuctionManager.getItemInfo(xAucItemInfo);
/*     */     
/* 119 */     OnlineManager.getInstance().send(this.roleId, synAuctionItemInfo);
/* 120 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\main\PCGetAuctionItemInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */