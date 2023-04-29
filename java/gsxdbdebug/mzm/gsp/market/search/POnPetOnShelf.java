/*    */ package mzm.gsp.market.search;
/*    */ 
/*    */ import mzm.gsp.market.event.MarketPetArg;
/*    */ import mzm.gsp.market.event.MarketPetOnShelfProcedure;
/*    */ import mzm.gsp.market.main.MarketInterface;
/*    */ import xbean.MarketPet;
/*    */ 
/*    */ public class POnPetOnShelf extends MarketPetOnShelfProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     MarketPet xMarketPet = xtable.Marketpet.select(Long.valueOf(((MarketPetArg)this.arg).marketId));
/* 13 */     if (xMarketPet == null)
/*    */     {
/* 15 */       return false;
/*    */     }
/*    */     
/* 18 */     int subid = MarketInterface.getSubidByPetId(((MarketPetArg)this.arg).petCfgId);
/* 19 */     if (subid == -1)
/*    */     {
/* 21 */       return false;
/*    */     }
/* 23 */     PetConditionManager.getInstance().addPet(subid, ((MarketPetArg)this.arg).marketId, xMarketPet, ((MarketPetArg)this.arg).isPub);
/* 24 */     PetQueryCache.getInstance().clearCache(xMarketPet, subid, ((MarketPetArg)this.arg).isPub);
/* 25 */     CustomizedConditionManager.getInstance().sendPetOnShelfTipToAll(subid, ((MarketPetArg)this.arg).marketId, xMarketPet, ((MarketPetArg)this.arg).isPub);
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\POnPetOnShelf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */