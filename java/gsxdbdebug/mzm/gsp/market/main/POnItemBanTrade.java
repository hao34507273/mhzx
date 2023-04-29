/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import mzm.gsp.item.event.BanTradeEventProcedure;
/*    */ import mzm.gsp.item.event.TradeArg;
/*    */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*    */ 
/*    */ public class POnItemBanTrade
/*    */   extends BanTradeEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     if (((TradeArg)this.arg).tradeType != ItemBanTrade.TradeTypeEnum.MARKET_ITEM.value)
/*    */     {
/* 15 */       return false;
/*    */     }
/* 17 */     int subid = MarketManager.getSubidByItemId(((TradeArg)this.arg).id);
/* 18 */     if (subid == -1)
/*    */     {
/* 20 */       return false;
/*    */     }
/* 22 */     MarketManager.synMarketItemBanTradeStateRes(((TradeArg)this.arg).id, ((TradeArg)this.arg).state);
/* 23 */     new PDealItemBanTrade(((TradeArg)this.arg).id, subid).execute();
/* 24 */     MarketManager.removeSupplySession(((TradeArg)this.arg).id);
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\POnItemBanTrade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */