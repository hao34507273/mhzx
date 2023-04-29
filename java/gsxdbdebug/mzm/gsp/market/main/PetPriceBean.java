/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ public class PetPriceBean
/*    */ {
/*  5 */   private int maxPrice = -1;
/*  6 */   private int minPrice = -1;
/*    */   
/*    */   public PetPriceBean(int maxPrice, int minPrice)
/*    */   {
/* 10 */     this.maxPrice = maxPrice;
/* 11 */     this.minPrice = minPrice;
/*    */   }
/*    */   
/*    */   public int getMaxPrice()
/*    */   {
/* 16 */     return this.maxPrice;
/*    */   }
/*    */   
/*    */   public int getMinPrice()
/*    */   {
/* 21 */     return this.minPrice;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PetPriceBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */