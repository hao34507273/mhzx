/*    */ package mzm.gsp.npc.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.item.confbean.SItemPriceCfg;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.npc.confbean.SNpcTrade;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NpcTradeManager
/*    */ {
/*    */   static void init() {}
/*    */   
/*    */   static SNpcTrade getSNpcTradeByServiceId(int serviceId)
/*    */   {
/* 24 */     return SNpcTrade.get(serviceId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void postInit() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isSellItem(int serviceId, int itemId)
/*    */   {
/* 38 */     SNpcTrade npcTrade = SNpcTrade.get(serviceId);
/* 39 */     if (npcTrade == null) {
/* 40 */       return false;
/*    */     }
/* 42 */     return npcTrade.items.contains(Integer.valueOf(itemId));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static Set<Integer> getAllNpcTradeServiceId()
/*    */   {
/* 51 */     return SNpcTrade.getAll().keySet();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static int getNPCShopItemPrice(int itemid)
/*    */   {
/* 61 */     for (SNpcTrade sNpcTrade : SNpcTrade.getAll().values())
/*    */     {
/* 63 */       if (sNpcTrade.items.contains(Integer.valueOf(itemid))) {
/* 64 */         SItemPriceCfg itemPriceCfg = ItemInterface.getSItemPriceCfg(itemid);
/* 65 */         if (itemPriceCfg == null) {
/* 66 */           return -1;
/*    */         }
/* 68 */         return itemPriceCfg.shopSilverNum;
/*    */       }
/*    */     }
/* 71 */     return -1;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\main\NpcTradeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */