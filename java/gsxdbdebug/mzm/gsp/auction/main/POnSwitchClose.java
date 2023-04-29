/*    */ package mzm.gsp.auction.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.auction.confbean.AuctionConsts;
/*    */ import xbean.AucItemInfo;
/*    */ import xbean.AuctionActivityInfo;
/*    */ import xbean.AuctionPeriodInfo;
/*    */ import xbean.AuctionTurnInfo;
/*    */ 
/*    */ public class POnSwitchClose extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   final int activityId;
/*    */   
/*    */   public POnSwitchClose(int activityId)
/*    */   {
/* 18 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     mzm.gsp.GameServer.logger().info(String.format("[auction]POnSwitchClose@processImp switch close|activityId=%d", new Object[] { Integer.valueOf(this.activityId) }));
/*    */     
/*    */ 
/* 27 */     long globalTableKeyId = mzm.gsp.GameServerInfoManager.toGlobalId(this.activityId);
/*    */     
/* 29 */     AuctionActivityInfo xAuctionActivityInfo = xtable.Auctionactivityinfo.get(Long.valueOf(globalTableKeyId));
/* 30 */     if (xAuctionActivityInfo == null)
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     AuctionPeriodInfo xCurrentPeriodInfo = xAuctionActivityInfo.getCurrentperiodinfo();
/* 36 */     long currentTimeStamp = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 37 */     if (xCurrentPeriodInfo.getPeriodendtimestamp() <= currentTimeStamp)
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 44 */     for (Iterator i$ = xCurrentPeriodInfo.getTurnindex2turninfo().entrySet().iterator(); i$.hasNext();) { entry = (Map.Entry)i$.next();
/*    */       
/* 46 */       xAuctionTurnInfo = (AuctionTurnInfo)entry.getValue();
/*    */       
/* 48 */       if (xAuctionTurnInfo.getTurnendtimestamp() > currentTimeStamp)
/*    */       {
/*    */ 
/*    */ 
/* 52 */         for (Map.Entry<Integer, AucItemInfo> aucItemInfoEntry : xAuctionTurnInfo.getTemplateid2iteminfo().entrySet())
/*    */         {
/* 54 */           AucItemInfo xAucItemInfo = (AucItemInfo)aucItemInfoEntry.getValue();
/* 55 */           if (xAucItemInfo.getBidendtimestamp() > currentTimeStamp)
/*    */           {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 61 */             AuctionManager.refundBidderWhenClose(this.activityId, ((Integer)entry.getKey()).intValue(), xCurrentPeriodInfo, xAuctionTurnInfo, xAucItemInfo, AuctionConsts.getInstance().SWITCH_CLOSE_REFUND_MAIL_ID, mzm.gsp.tlog.LogReason.AUCTION_SWITCH_CLOSE_REFUND);
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     Map.Entry<Integer, AuctionTurnInfo> entry;
/*    */     AuctionTurnInfo xAuctionTurnInfo;
/* 68 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\main\POnSwitchClose.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */