/*    */ package mzm.gsp.market.event;
/*    */ 
/*    */ public class MarketPetArg
/*    */ {
/*    */   public final long marketId;
/*    */   public final int petCfgId;
/*    */   public final boolean isPub;
/*    */   public final boolean isSysSupply;
/*    */   
/*    */   public MarketPetArg(long marketId, int petCfgId, boolean isPub, boolean isSysSupply)
/*    */   {
/* 12 */     this.marketId = marketId;
/* 13 */     this.petCfgId = petCfgId;
/* 14 */     this.isPub = isPub;
/* 15 */     this.isSysSupply = isSysSupply;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\event\MarketPetArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */