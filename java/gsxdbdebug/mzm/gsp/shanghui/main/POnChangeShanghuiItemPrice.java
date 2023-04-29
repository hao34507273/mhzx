/*    */ package mzm.gsp.shanghui.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.shanghui.confbean.SOrginalPriceCfg;
/*    */ import mzm.gsp.shanghui.confbean.SShangHuiItemToolsCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.ShangHuiItem;
/*    */ import xtable.Shanghui;
/*    */ 
/*    */ public class POnChangeShanghuiItemPrice
/*    */   extends LogicProcedure
/*    */ {
/*    */   private int itemId;
/*    */   
/*    */   public POnChangeShanghuiItemPrice(int itemId)
/*    */   {
/* 19 */     this.itemId = itemId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     long itemKey = GameServerInfoManager.toGlobalId(this.itemId);
/* 26 */     SShangHuiItemToolsCfg cfg = SShangHuiItemToolsCfg.get(this.itemId);
/* 27 */     if (!cfg.isOrginalPriceRefLevel)
/*    */     {
/* 29 */       ShangHuiItem xShangHuiItem = Shanghui.get(Long.valueOf(itemKey));
/* 30 */       if (xShangHuiItem != null) {
/* 31 */         xShangHuiItem.setOrginalprice(cfg.orginialPrice);
/* 32 */         xShangHuiItem.setRiserate(0);
/*    */       } else {
/* 34 */         new POnAddShanghuiItem(this.itemId).execute();
/*    */       }
/*    */     } else {
/* 37 */       SOrginalPriceCfg orginalPriceCfg = SOrginalPriceCfg.get(cfg.orginalPriceCfgId);
/* 38 */       List<Long> idList = new ArrayList();
/* 39 */       idList.add(Long.valueOf(itemKey));
/* 40 */       long lastItemKey = GameServerInfoManager.toGlobalId(orginalPriceCfg.lastLevelItemId);
/* 41 */       idList.add(Long.valueOf(lastItemKey));
/*    */       
/* 43 */       lock(Shanghui.getTable(), idList);
/* 44 */       ShangHuiItem xShangHuiItem = Shanghui.get(Long.valueOf(itemKey));
/* 45 */       ShangHuiItem xShangHuiItemLast = Shanghui.get(Long.valueOf(lastItemKey));
/*    */       
/* 47 */       if (xShangHuiItem == null) {
/* 48 */         new POnAddShanghuiItem(this.itemId).execute();
/* 49 */       } else if (xShangHuiItemLast == null) {
/* 50 */         xShangHuiItem.setOrginalprice(cfg.orginialPrice);
/* 51 */         xShangHuiItem.setRiserate(0);
/*    */       } else {
/* 53 */         int lastPrice = ShanghuiManager.calculatePrice(xShangHuiItemLast.getOrginalprice(), xShangHuiItemLast.getRiserate());
/* 54 */         int orginalPrice = (int)(lastPrice * orginalPriceCfg.priceRate);
/* 55 */         xShangHuiItem.setOrginalprice(orginalPrice);
/* 56 */         xShangHuiItem.setRiserate(0);
/*    */       }
/*    */     }
/* 59 */     ShanghuiManager.logInfo("POnChangeShanghuiItemPrice.processImp@shanghui item change price|itemid=%d", new Object[] { Integer.valueOf(this.itemId) });
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\POnChangeShanghuiItemPrice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */