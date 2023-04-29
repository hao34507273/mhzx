/*    */ package mzm.gsp.market.event;
/*    */ 
/*    */ import xbean.MarketPet;
/*    */ 
/*    */ public class MarketPetOffShelfArg {
/*    */   public final long marketId;
/*    */   public final int petCfgId;
/*    */   public final boolean isPub;
/*    */   public final MarketPet xMarketPet;
/*    */   
/*    */   public MarketPetOffShelfArg(long marketId, int petCfgId, boolean isPub, MarketPet xMarketPet) {
/* 12 */     this.marketId = marketId;
/* 13 */     this.petCfgId = petCfgId;
/* 14 */     this.isPub = isPub;
/* 15 */     this.xMarketPet = xMarketPet;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\event\MarketPetOffShelfArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */