/*    */ package mzm.gsp.market.search;
/*    */ 
/*    */ import mzm.gsp.market.event.MarketItemArg;
/*    */ import mzm.gsp.market.main.MarketInterface;
/*    */ import xbean.Item;
/*    */ import xbean.MarketItem;
/*    */ 
/*    */ public class POnItemOnShelf extends mzm.gsp.market.event.MarketItemOnShelfProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     MarketItem xMarketItem = xtable.Marketitem.select(Long.valueOf(((MarketItemArg)this.arg).marketId));
/* 13 */     if (xMarketItem == null)
/*    */     {
/* 15 */       return false;
/*    */     }
/*    */     
/* 18 */     int subid = MarketInterface.getSubidByItemId(((MarketItemArg)this.arg).itemId);
/* 19 */     if (subid == -1)
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     if (MarketInterface.canSearch(subid))
/*    */     {
/* 26 */       if (MarketInterface.isEquipItem(xMarketItem.getItem().getCfgid()))
/*    */       {
/* 28 */         EquipConditionManager.getInstance().addItem(subid, ((MarketItemArg)this.arg).marketId, xMarketItem, ((MarketItemArg)this.arg).isPub);
/*    */         
/* 30 */         EquipQueryCache.getInstance().clearCache(xMarketItem, subid, ((MarketItemArg)this.arg).isPub);
/* 31 */         CustomizedConditionManager.getInstance().sendEquipOnShelfTipToAll(subid, ((MarketItemArg)this.arg).marketId, xMarketItem, ((MarketItemArg)this.arg).isPub);
/*    */ 
/*    */       }
/* 34 */       else if (MarketInterface.isPetEquipItem(xMarketItem.getItem().getCfgid()))
/*    */       {
/* 36 */         PetEquipConditionManager.getInstance().addItem(subid, ((MarketItemArg)this.arg).marketId, xMarketItem, ((MarketItemArg)this.arg).isPub);
/* 37 */         EquipQueryCache.getInstance().clearCache(xMarketItem, subid, ((MarketItemArg)this.arg).isPub);
/* 38 */         CustomizedConditionManager.getInstance().sendPetEquipOnShelfTipToAll(subid, ((MarketItemArg)this.arg).marketId, xMarketItem, ((MarketItemArg)this.arg).isPub);
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\POnItemOnShelf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */