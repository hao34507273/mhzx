/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.market.confbean.SMarketSupplyItemCfg;
/*    */ import mzm.gsp.market.event.MarketItemArg;
/*    */ import mzm.gsp.market.event.MarketItemOnShelfProcedure;
/*    */ 
/*    */ public class POnItemOnShelf
/*    */   extends MarketItemOnShelfProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 14 */     SMarketSupplyItemCfg sMarketSupplyItemCfg = SMarketSupplyItemCfg.get(((MarketItemArg)this.arg).itemId);
/* 15 */     if (sMarketSupplyItemCfg == null)
/*    */     {
/* 17 */       return false;
/*    */     }
/* 19 */     if (!MarketManager.canSupplyItem(((MarketItemArg)this.arg).itemId, sMarketSupplyItemCfg))
/*    */     {
/* 21 */       return MarketManager.removeSupplySession(((MarketItemArg)this.arg).itemId);
/*    */     }
/*    */     
/*    */ 
/* 25 */     return MarketManager.addSupplySession(((MarketItemArg)this.arg).itemId, TimeUnit.MINUTES.toSeconds(sMarketSupplyItemCfg.persistMinutes));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\POnItemOnShelf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */