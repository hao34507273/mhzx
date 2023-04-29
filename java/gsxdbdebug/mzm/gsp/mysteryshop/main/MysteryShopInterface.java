/*    */ package mzm.gsp.mysteryshop.main;
/*    */ 
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MysteryShopInterface
/*    */ {
/*    */   public static int getGoodsPrice(int goodsId, int sale)
/*    */   {
/* 17 */     return MysteryShopManager.getGoodsPrice(goodsId, sale);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static long getLeftCurrencyValue(long roleId, int currencyType)
/*    */   {
/* 30 */     return MysteryShopManager.getLeftCurrencyValue(roleId, currencyType);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean costCurrencyValue(long roleId, long costValue, int currencyType, TLogArg tlog)
/*    */   {
/* 46 */     return MysteryShopManager.costCurrencyValue(roleId, costValue, currencyType, tlog);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void fillCurrencyData(String userId, long roleid, TLogArg logArg, int needYuanbao)
/*    */   {
/* 57 */     MysteryShopManager.fillCurrencyData(userId, roleid, logArg, needYuanbao);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mysteryshop\main\MysteryShopInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */