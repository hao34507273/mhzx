/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import mzm.gsp.market.event.MarketItemOffShelfArg;
/*    */ import mzm.gsp.market.event.MarketItemOffShelfProcedure;
/*    */ 
/*    */ public class POnItemOffShelf
/*    */   extends MarketItemOffShelfProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     return MarketManager.tryStartSupplyItemSession(((MarketItemOffShelfArg)this.arg).itemId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\POnItemOffShelf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */