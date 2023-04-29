/*     */ package mzm.gsp.auction.main;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AucItemInfo;
/*     */ import xbean.AuctionActivityInfo;
/*     */ import xbean.AuctionPeriodInfo;
/*     */ import xbean.AuctionTurnInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AuctionItemBidEndSession
/*     */   extends Session
/*     */ {
/*     */   final int activityId;
/*     */   final int turnIndex;
/*     */   final int auctionItemCfgId;
/*     */   
/*     */   public AuctionItemBidEndSession(long interval, long roleId, int activityId, int turnIndex, int auctionItemCfgId)
/*     */   {
/*  36 */     super(interval, roleId);
/*  37 */     this.activityId = activityId;
/*  38 */     this.turnIndex = turnIndex;
/*  39 */     this.auctionItemCfgId = auctionItemCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  45 */     AuctionOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityId), new PAuctionItemBidEnd());
/*     */   }
/*     */   
/*     */   class PAuctionItemBidEnd extends LogicProcedure
/*     */   {
/*     */     PAuctionItemBidEnd() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  54 */       if (!OpenInterface.getOpenStatus(534))
/*     */       {
/*  56 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  60 */       long roleId = AuctionManager.getBidderRoleId(AuctionItemBidEndSession.this.activityId, AuctionItemBidEndSession.this.turnIndex, AuctionItemBidEndSession.this.auctionItemCfgId, false);
/*  61 */       if (roleId == 0L)
/*     */       {
/*  63 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  67 */       lock(Lockeys.get(User.getTable(), RoleInterface.getUserId(roleId)));
/*     */       
/*  69 */       lock(Lockeys.get(Basic.getTable(), Long.valueOf(roleId)));
/*     */       
/*     */ 
/*  72 */       AuctionActivityInfo xAuctionActivityInfo = AuctionManager.getAuctionActivityInfo(AuctionItemBidEndSession.this.activityId, true);
/*  73 */       if (xAuctionActivityInfo == null)
/*     */       {
/*  75 */         return false;
/*     */       }
/*  77 */       AuctionPeriodInfo xCurrentPeriodInfo = xAuctionActivityInfo.getCurrentperiodinfo();
/*  78 */       AuctionTurnInfo xAuctionTurnInfo = (AuctionTurnInfo)xCurrentPeriodInfo.getTurnindex2turninfo().get(Integer.valueOf(AuctionItemBidEndSession.this.turnIndex));
/*  79 */       if (xAuctionTurnInfo == null)
/*     */       {
/*  81 */         return false;
/*     */       }
/*     */       
/*  84 */       AucItemInfo xAucItemInfo = (AucItemInfo)xAuctionTurnInfo.getTemplateid2iteminfo().get(Integer.valueOf(AuctionItemBidEndSession.this.auctionItemCfgId));
/*  85 */       if (xAucItemInfo == null)
/*     */       {
/*  87 */         return false;
/*     */       }
/*     */       
/*  90 */       if (xAucItemInfo.getBidderroleid() != roleId)
/*     */       {
/*  92 */         return false;
/*     */       }
/*     */       
/*  95 */       long currentTimeStamp = DateTimeUtils.getCurrTimeInMillis();
/*     */       
/*  97 */       if (TimeUnit.MILLISECONDS.toSeconds(xAucItemInfo.getBidendtimestamp()) <= TimeUnit.MILLISECONDS.toSeconds(currentTimeStamp))
/*     */       {
/*     */ 
/* 100 */         boolean ret = AuctionManager.sendAuctionItemToRole(AuctionItemBidEndSession.this.activityId, AuctionItemBidEndSession.this.turnIndex, xCurrentPeriodInfo, xAuctionTurnInfo, xAucItemInfo);
/*     */         
/* 102 */         if (!ret)
/*     */         {
/* 104 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 108 */       SimpleDateFormat simpleDateFormat = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 109 */       GameServer.logger().info(String.format("[auction]AuctionItemBidEndSession.PAuctionItemBidEnd.processImp@ time out|activityId=%d|turnId=%d|auctionItemCfgId=%d|currentTimeStamp=%s|bidEndTimeStamp=%s", new Object[] { Integer.valueOf(AuctionItemBidEndSession.this.activityId), Integer.valueOf(AuctionItemBidEndSession.this.turnIndex), Integer.valueOf(AuctionItemBidEndSession.this.auctionItemCfgId), simpleDateFormat.format(Long.valueOf(currentTimeStamp)), simpleDateFormat.format(Long.valueOf(xAucItemInfo.getBidendtimestamp())) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 114 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\main\AuctionItemBidEndSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */