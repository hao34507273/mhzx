/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import mzm.gsp.item.event.TradeArg;
/*    */ import mzm.gsp.item.event.UnBanTradeEventProcedure;
/*    */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*    */ 
/*    */ public class POnItemUnBanTrade extends UnBanTradeEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     if (((TradeArg)this.arg).tradeType != ItemBanTrade.TradeTypeEnum.MARKET_ITEM.value)
/*    */     {
/* 13 */       return false;
/*    */     }
/* 15 */     int subid = MarketManager.getSubidByItemId(((TradeArg)this.arg).id);
/* 16 */     if (subid == -1)
/*    */     {
/* 18 */       return false;
/*    */     }
/* 20 */     MarketManager.synMarketItemBanTradeStateRes(((TradeArg)this.arg).id, ((TradeArg)this.arg).state);
/* 21 */     MarketManager.tryStartSupplyItemSession(((TradeArg)this.arg).id);
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\POnItemUnBanTrade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */