/*    */ package mzm.gsp.auction.event;
/*    */ 
/*    */ 
/*    */ public class AuctionBidWinEventArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final int activityId;
/*    */   public final int turnIndex;
/*    */   public final long bidPrice;
/*    */   public final int auctionItemCfgId;
/*    */   
/*    */   public AuctionBidWinEventArg(long roleId, int activityId, int turnIndex, long bidPrice, int auctionItemCfgId)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.activityId = activityId;
/* 16 */     this.turnIndex = turnIndex;
/* 17 */     this.bidPrice = bidPrice;
/* 18 */     this.auctionItemCfgId = auctionItemCfgId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\event\AuctionBidWinEventArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */