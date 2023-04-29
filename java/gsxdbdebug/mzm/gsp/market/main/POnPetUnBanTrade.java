/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import mzm.gsp.item.event.TradeArg;
/*    */ import mzm.gsp.item.event.UnBanTradeEventProcedure;
/*    */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*    */ 
/*    */ public class POnPetUnBanTrade extends UnBanTradeEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     if (((TradeArg)this.arg).tradeType != ItemBanTrade.TradeTypeEnum.MARKET_PET.value)
/*    */     {
/* 13 */       return false;
/*    */     }
/* 15 */     int subid = MarketManager.getSubidByPetId(((TradeArg)this.arg).id);
/*    */     
/* 17 */     if (subid == -1)
/*    */     {
/* 19 */       return false;
/*    */     }
/* 21 */     MarketManager.synMarketPetBanTradeStateRes(((TradeArg)this.arg).id, ((TradeArg)this.arg).state);
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\POnPetUnBanTrade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */