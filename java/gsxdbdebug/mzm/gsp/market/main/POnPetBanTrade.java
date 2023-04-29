/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import mzm.gsp.item.event.BanTradeEventProcedure;
/*    */ import mzm.gsp.item.event.TradeArg;
/*    */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*    */ 
/*    */ public class POnPetBanTrade
/*    */   extends BanTradeEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     if (((TradeArg)this.arg).tradeType != ItemBanTrade.TradeTypeEnum.MARKET_PET.value)
/*    */     {
/* 14 */       return false;
/*    */     }
/* 16 */     int subid = MarketManager.getSubidByPetId(((TradeArg)this.arg).id);
/*    */     
/* 18 */     if (subid == -1)
/*    */     {
/* 20 */       return false;
/*    */     }
/* 22 */     MarketManager.synMarketPetBanTradeStateRes(((TradeArg)this.arg).id, ((TradeArg)this.arg).state);
/* 23 */     new PDealPetBanTrade(((TradeArg)this.arg).id, subid).execute();
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\POnPetBanTrade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */