/*    */ package mzm.gsp.shanghui.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.shanghui.ShoppingItem;
/*    */ 
/*    */ public class ShanghuiInterface
/*    */ {
/*    */   public static Integer getItemBigTypeId(int itemId)
/*    */   {
/* 10 */     return ShanghuiManager.getItemBigTypeId(itemId);
/*    */   }
/*    */   
/* 13 */   public static Integer getItemSubTypeId(int itemId) { return ShanghuiManager.getItemSubTypeId(itemId); }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getItemPrice(int itemId)
/*    */   {
/* 22 */     return ShanghuiManager.getItemPrice(itemId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean isItemCanSellForServerLevel(int itemId, int serverLevel)
/*    */   {
/* 32 */     return ShanghuiManager.isCanSellForLevel(itemId, serverLevel);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean isItemPriceFloat(int itemId)
/*    */   {
/* 40 */     return ShanghuiManager.isItemPriceFloat(itemId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean isItemInShanghuiCfg(int itemid)
/*    */   {
/* 49 */     return ShanghuiManager.isItemInShanghuiCfg(itemid);
/*    */   }
/*    */   
/*    */   public static List<ShoppingItem> getShangHuiItemListBySubType(int subType)
/*    */   {
/* 54 */     return ShanghuiManager.getShangHuiItemListBySubType(subType);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\ShanghuiInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */