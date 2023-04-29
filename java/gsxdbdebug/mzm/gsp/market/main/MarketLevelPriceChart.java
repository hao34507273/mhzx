/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import mzm.gsp.util.RankObj;
/*    */ 
/*    */ public class MarketLevelPriceChart
/*    */   extends RankObj<Long>
/*    */ {
/*    */   private final long marketId;
/*    */   private final int level;
/*    */   private final int price;
/*    */   
/*    */   public MarketLevelPriceChart(long marketId, int level, int price)
/*    */   {
/* 14 */     this.marketId = marketId;
/* 15 */     this.level = level;
/* 16 */     this.price = price;
/*    */   }
/*    */   
/*    */ 
/*    */   public Long getKey()
/*    */   {
/* 22 */     return Long.valueOf(this.marketId);
/*    */   }
/*    */   
/*    */   public long getMarketId()
/*    */   {
/* 27 */     return this.marketId;
/*    */   }
/*    */   
/*    */   public int getLevel()
/*    */   {
/* 32 */     return this.level;
/*    */   }
/*    */   
/*    */   public int getPrice()
/*    */   {
/* 37 */     return this.price;
/*    */   }
/*    */   
/*    */ 
/*    */   public int compareTo(RankObj<Long> o)
/*    */   {
/* 43 */     MarketLevelPriceChart obj = (MarketLevelPriceChart)o;
/*    */     
/* 45 */     if (getLevel() == obj.getLevel())
/*    */     {
/* 47 */       if (getPrice() == obj.getPrice())
/*    */       {
/* 49 */         return (int)(getMarketId() - obj.getMarketId());
/*    */       }
/*    */       
/*    */ 
/* 53 */       return getPrice() - obj.getPrice();
/*    */     }
/*    */     
/*    */ 
/* 57 */     return getLevel() - obj.getLevel();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\MarketLevelPriceChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */