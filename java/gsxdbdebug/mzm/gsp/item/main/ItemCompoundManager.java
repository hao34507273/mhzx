/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Random;
/*    */ import mzm.gsp.item.confbean.DesItemId2Rate;
/*    */ import mzm.gsp.item.confbean.ItemCfgConsts;
/*    */ import mzm.gsp.item.confbean.SEquipMakeItemCfg;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class ItemCompoundManager
/*    */ {
/*    */   static int generateItemId(SEquipMakeItemCfg sEquipMakeItemCfg)
/*    */   {
/* 22 */     int sum = 0;
/* 23 */     int desEqpId = ((DesItemId2Rate)sEquipMakeItemCfg.desItemList.get(0)).itemId;
/* 24 */     int randNum = Xdb.random().nextInt(ItemCfgConsts.getInstance().ITEM_RANDOM_SEED);
/* 25 */     for (DesItemId2Rate desItemId2Rate : sEquipMakeItemCfg.desItemList)
/*    */     {
/* 27 */       sum += desItemId2Rate.itemRate;
/* 28 */       if (randNum < sum)
/*    */       {
/* 30 */         desEqpId = desItemId2Rate.itemId;
/* 31 */         break;
/*    */       }
/*    */     }
/* 34 */     return desEqpId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean hasBindItem(ItemOperateResult res)
/*    */   {
/* 46 */     for (ItemOperateResult.ChangeItemInfo changeinfo : res.getChangeItemInfoList())
/*    */     {
/* 48 */       if (changeinfo.basicItem.isBind())
/*    */       {
/* 50 */         return true;
/*    */       }
/*    */     }
/* 53 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\ItemCompoundManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */