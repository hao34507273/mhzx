/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PSynMarketBanTrandeItemPetRes
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PSynMarketBanTrandeItemPetRes(long roleid)
/*    */   {
/* 12 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     MarketManager.synSSynMarketItemBanTradeRes(this.roleid);
/* 19 */     MarketManager.synSSynMarketPetBanTradeRes(this.roleid);
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PSynMarketBanTrandeItemPetRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */