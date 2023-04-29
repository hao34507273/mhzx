/*    */ package mzm.gsp.market.search;
/*    */ 
/*    */ import mzm.gsp.market.event.MarketItemOffShelfArg;
/*    */ import mzm.gsp.market.main.MarketInterface;
/*    */ import xbean.Item;
/*    */ import xbean.MarketItem;
/*    */ 
/*    */ public class POnItemOffShelf extends mzm.gsp.market.event.MarketItemOffShelfProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     MarketItem xMarketItem = ((MarketItemOffShelfArg)this.arg).xMarketItem;
/* 13 */     if (xMarketItem == null)
/*    */     {
/* 15 */       return false;
/*    */     }
/*    */     
/* 18 */     int subid = MarketInterface.getSubidByItemId(((MarketItemOffShelfArg)this.arg).itemId);
/* 19 */     if (subid == -1)
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     if (MarketInterface.canSearch(subid))
/*    */     {
/* 26 */       if (MarketInterface.isEquipItem(xMarketItem.getItem().getCfgid()))
/*    */       {
/* 28 */         EquipConditionManager.getInstance().removeItem(subid, ((MarketItemOffShelfArg)this.arg).marketId, xMarketItem, ((MarketItemOffShelfArg)this.arg).isPub);
/* 29 */         EquipQueryCache.getInstance().clearCache(xMarketItem, subid, ((MarketItemOffShelfArg)this.arg).isPub);
/*    */       }
/* 31 */       else if (MarketInterface.isPetEquipItem(xMarketItem.getItem().getCfgid()))
/*    */       {
/* 33 */         PetEquipConditionManager.getInstance().removeItem(subid, ((MarketItemOffShelfArg)this.arg).marketId, xMarketItem, ((MarketItemOffShelfArg)this.arg).isPub);
/* 34 */         PetEquipQueryCache.getInstance().clearCache(xMarketItem, subid, ((MarketItemOffShelfArg)this.arg).isPub);
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\POnItemOffShelf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */