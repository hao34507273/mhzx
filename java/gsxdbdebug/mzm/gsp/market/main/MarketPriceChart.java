/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import mzm.gsp.util.RankObj;
/*    */ 
/*    */ public class MarketPriceChart
/*    */   extends RankObj<Long>
/*    */ {
/*    */   private final long marketId;
/*    */   private final int price;
/*    */   
/*    */   public MarketPriceChart(long marketId, int price)
/*    */   {
/* 13 */     this.marketId = marketId;
/* 14 */     this.price = price;
/*    */   }
/*    */   
/*    */ 
/*    */   public Long getKey()
/*    */   {
/* 20 */     return Long.valueOf(this.marketId);
/*    */   }
/*    */   
/*    */   public long getMarketId()
/*    */   {
/* 25 */     return this.marketId;
/*    */   }
/*    */   
/*    */   public int getPrice()
/*    */   {
/* 30 */     return this.price;
/*    */   }
/*    */   
/*    */ 
/*    */   public int compareTo(RankObj<Long> o)
/*    */   {
/* 36 */     MarketPriceChart obj = (MarketPriceChart)o;
/*    */     
/* 38 */     if (getPrice() == obj.getPrice())
/*    */     {
/*    */ 
/* 41 */       return (int)(getMarketId() - obj.getMarketId());
/*    */     }
/*    */     
/* 44 */     return getPrice() - obj.getPrice();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\MarketPriceChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */