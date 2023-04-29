/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MarketItemPetPriceManager
/*    */ {
/* 12 */   private static final Map<Integer, MarketTreeMap> itemPetPriceMap = new HashMap();
/*    */   
/*    */   static void init(int itemIdOrPetCfgId)
/*    */   {
/* 16 */     itemPetPriceMap.put(Integer.valueOf(itemIdOrPetCfgId), new MarketTreeMap());
/*    */   }
/*    */   
/*    */   static void addPrice(int itemIdOrPetCfgId, int price)
/*    */   {
/* 21 */     MarketTreeMap treeMap = (MarketTreeMap)itemPetPriceMap.get(Integer.valueOf(itemIdOrPetCfgId));
/* 22 */     if (treeMap != null)
/*    */     {
/* 24 */       treeMap.addPriceNum(price, 1);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   static void removePrice(int itemIdOrPetCfgId, int price)
/*    */   {
/* 31 */     MarketTreeMap treeMap = (MarketTreeMap)itemPetPriceMap.get(Integer.valueOf(itemIdOrPetCfgId));
/* 32 */     if (treeMap != null)
/*    */     {
/* 34 */       treeMap.decPriceNum(price, 1);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static int getMaxPrice(int itemIdOrPetCfgId)
/*    */   {
/* 47 */     MarketTreeMap treeMap = (MarketTreeMap)itemPetPriceMap.get(Integer.valueOf(itemIdOrPetCfgId));
/* 48 */     if (treeMap != null)
/*    */     {
/* 50 */       return treeMap.last().intValue();
/*    */     }
/* 52 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static int getMinPrice(int itemIdOrPetCfgId)
/*    */   {
/* 64 */     MarketTreeMap treeMap = (MarketTreeMap)itemPetPriceMap.get(Integer.valueOf(itemIdOrPetCfgId));
/* 65 */     if (treeMap != null)
/*    */     {
/* 67 */       return treeMap.first().intValue();
/*    */     }
/* 69 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static int getTotalOnSellNum(int itemIdOrPetCfgId)
/*    */   {
/* 81 */     MarketTreeMap treeMap = (MarketTreeMap)itemPetPriceMap.get(Integer.valueOf(itemIdOrPetCfgId));
/* 82 */     if (treeMap != null)
/*    */     {
/* 84 */       return treeMap.getTotalNum();
/*    */     }
/* 86 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\MarketItemPetPriceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */