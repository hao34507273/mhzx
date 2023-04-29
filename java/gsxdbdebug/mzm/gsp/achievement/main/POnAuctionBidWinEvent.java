/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.auction.confbean.OrigAuctionItemCfg;
/*    */ import mzm.gsp.auction.event.AuctionBidWinEventArg;
/*    */ import mzm.gsp.auction.event.AuctionBidWinEventProcedure;
/*    */ 
/*    */ public class POnAuctionBidWinEvent
/*    */   extends AuctionBidWinEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     OrigAuctionItemCfg origAuctionItemCfg = OrigAuctionItemCfg.get(((AuctionBidWinEventArg)this.arg).auctionItemCfgId);
/*    */     
/*    */ 
/* 15 */     AchievementManager.updateGoalTypeState(((AuctionBidWinEventArg)this.arg).roleId, 1509, Integer.valueOf(1), "POnAuctionBidWinEvent.processImp@handle AUCTION_SUCCESS success");
/*    */     
/*    */ 
/*    */ 
/* 19 */     if (origAuctionItemCfg.moneyType == 1)
/*    */     {
/* 21 */       AchievementManager.updateGoalTypeState(((AuctionBidWinEventArg)this.arg).roleId, 1511, Integer.valueOf((int)((AuctionBidWinEventArg)this.arg).bidPrice), "POnAuctionBidWinEvent.processImp@handle AUCTION_CONSUME_YUANBAO success");
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 26 */     AchievementManager.updateGoalTypeState(((AuctionBidWinEventArg)this.arg).roleId, 1510, Integer.valueOf(origAuctionItemCfg.itemCfgId), "POnAuctionBidWinEvent.processImp@handle AUCTION_SPECIFIC_ITEM_SUCCESS success");
/*    */     
/*    */ 
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnAuctionBidWinEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */