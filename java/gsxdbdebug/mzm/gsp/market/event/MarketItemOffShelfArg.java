/*    */ package mzm.gsp.market.event;
/*    */ 
/*    */ import xbean.MarketItem;
/*    */ 
/*    */ public class MarketItemOffShelfArg {
/*    */   public final long marketId;
/*    */   public final int itemId;
/*    */   public final boolean isPub;
/*    */   public final MarketItem xMarketItem;
/*    */   
/*    */   public MarketItemOffShelfArg(long marketId, int itemId, boolean isPub, MarketItem xMarketItem) {
/* 12 */     this.marketId = marketId;
/* 13 */     this.itemId = itemId;
/* 14 */     this.isPub = isPub;
/* 15 */     this.xMarketItem = xMarketItem;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\event\MarketItemOffShelfArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */