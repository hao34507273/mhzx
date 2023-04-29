/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.market.SQueryItemPricRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class PQueryItemPrice extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private int itemId;
/*    */   
/*    */   public PQueryItemPrice(long roleId, int itemId)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.itemId = itemId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*    */     {
/* 25 */       String logStr = String.format("[market]PQueryItemPrice.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 27 */       MarketManager.logger.info(logStr);
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     if (!MarketManager.isMarketOpen(this.roleId))
/*    */     {
/* 33 */       return false;
/*    */     }
/* 35 */     SQueryItemPricRes res = new SQueryItemPricRes();
/*    */     
/* 37 */     int max = MarketItemPetPriceManager.getMaxPrice(this.itemId);
/* 38 */     int min = MarketItemPetPriceManager.getMinPrice(this.itemId);
/* 39 */     if (max == 0)
/*    */     {
/* 41 */       boolean isEquip = ItemInterface.isEquipItem(this.itemId);
/* 42 */       max = MarketManager.getMaxItemPrice(this.itemId, isEquip);
/*    */     }
/*    */     
/* 45 */     if (min == 0)
/*    */     {
/* 47 */       min = MarketManager.getMinItemPrice(this.itemId);
/*    */     }
/*    */     
/* 50 */     res.itemid = this.itemId;
/* 51 */     res.prices.add(Integer.valueOf(min));
/* 52 */     res.prices.add(Integer.valueOf(max));
/* 53 */     OnlineManager.getInstance().send(this.roleId, res);
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PQueryItemPrice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */