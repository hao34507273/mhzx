/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.market.SQueryPetPricRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class PQueryPetPrice extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private int petCfgId;
/*    */   
/*    */   public PQueryPetPrice(long roleId, int petCfgId)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.petCfgId = petCfgId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (!MarketManager.isMarketOpen(this.roleId))
/*    */     {
/* 25 */       return false;
/*    */     }
/* 27 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*    */     {
/* 29 */       String logStr = String.format("[market]PQueryPetPrice.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 31 */       MarketManager.logger.info(logStr);
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     SQueryPetPricRes res = new SQueryPetPricRes();
/*    */     
/* 37 */     int max = MarketItemPetPriceManager.getMaxPrice(this.petCfgId);
/* 38 */     int min = MarketItemPetPriceManager.getMinPrice(this.petCfgId);
/* 39 */     if (max == 0)
/*    */     {
/* 41 */       max = MarketManager.getMaxPetPrice(this.petCfgId);
/*    */     }
/*    */     
/* 44 */     if (min == 0)
/*    */     {
/* 46 */       min = MarketManager.getMinPetPrice(this.petCfgId);
/*    */     }
/*    */     
/* 49 */     res.petcfgid = this.petCfgId;
/* 50 */     res.prices.add(Integer.valueOf(min));
/* 51 */     res.prices.add(Integer.valueOf(max));
/* 52 */     OnlineManager.getInstance().send(this.roleId, res);
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PQueryPetPrice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */