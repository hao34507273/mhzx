/*    */ package mzm.gsp.market.event;
/*    */ 
/*    */ public class MarketItemArg
/*    */ {
/*    */   public final long marketId;
/*    */   public final int itemId;
/*    */   public final boolean isPub;
/*    */   public final boolean isSysSupply;
/*    */   
/*    */   public MarketItemArg(long marketId, int itemId, boolean isPub, boolean isSysSupply)
/*    */   {
/* 12 */     this.marketId = marketId;
/* 13 */     this.itemId = itemId;
/* 14 */     this.isPub = isPub;
/* 15 */     this.isSysSupply = isSysSupply;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\event\MarketItemArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */