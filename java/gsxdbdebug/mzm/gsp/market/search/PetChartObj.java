/*    */ package mzm.gsp.market.search;
/*    */ 
/*    */ import mzm.gsp.util.RankObj;
/*    */ 
/*    */ public class PetChartObj extends RankObj<Long> {
/*    */   private final long marketId;
/*    */   private final int price;
/*    */   
/*    */   public PetChartObj(long marketId, int price) {
/* 10 */     this.marketId = marketId;
/*    */     
/* 12 */     this.price = price;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Long getKey()
/*    */   {
/* 23 */     return Long.valueOf(this.marketId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int compareTo(RankObj<Long> o)
/*    */   {
/* 30 */     PetChartObj obj = (PetChartObj)o;
/* 31 */     if (this.price == obj.getPrice())
/*    */     {
/* 33 */       return (int)(getKey().longValue() - ((Long)o.getKey()).longValue());
/*    */     }
/* 35 */     return this.price - obj.getPrice();
/*    */   }
/*    */   
/*    */   public long getMarketId()
/*    */   {
/* 40 */     return this.marketId;
/*    */   }
/*    */   
/*    */   public int getPrice()
/*    */   {
/* 45 */     return this.price;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\PetChartObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */