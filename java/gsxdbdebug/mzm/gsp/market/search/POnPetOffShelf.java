/*    */ package mzm.gsp.market.search;
/*    */ 
/*    */ import mzm.gsp.market.event.MarketPetOffShelfArg;
/*    */ import mzm.gsp.market.event.MarketPetOffShelfProcedure;
/*    */ import mzm.gsp.market.main.MarketInterface;
/*    */ import xbean.MarketPet;
/*    */ 
/*    */ public class POnPetOffShelf
/*    */   extends MarketPetOffShelfProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 14 */     MarketPet xMarketPet = ((MarketPetOffShelfArg)this.arg).xMarketPet;
/* 15 */     if (xMarketPet == null)
/*    */     {
/* 17 */       return false;
/*    */     }
/*    */     
/* 20 */     int subid = MarketInterface.getSubidByPetId(((MarketPetOffShelfArg)this.arg).petCfgId);
/* 21 */     if (subid == -1)
/*    */     {
/* 23 */       return false;
/*    */     }
/* 25 */     PetConditionManager.getInstance().removePet(subid, ((MarketPetOffShelfArg)this.arg).marketId, xMarketPet, ((MarketPetOffShelfArg)this.arg).isPub);
/* 26 */     PetQueryCache.getInstance().clearCache(xMarketPet, subid, ((MarketPetOffShelfArg)this.arg).isPub);
/*    */     
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\POnPetOffShelf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */