/*    */ package mzm.gsp.shanghui.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Stack;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.shanghui.confbean.SOrginalPriceCfg;
/*    */ import mzm.gsp.shanghui.confbean.SShangHuiItemToolsCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Pod;
/*    */ import xbean.ShangHuiItem;
/*    */ import xtable.Shanghui;
/*    */ 
/*    */ public class POnAddShanghuiItem extends LogicProcedure
/*    */ {
/*    */   private int itemId;
/*    */   
/*    */   public POnAddShanghuiItem(int itemId)
/*    */   {
/* 22 */     this.itemId = itemId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 27 */     Stack<Integer> idChain = ShanghuiManager.getLevelChainList(this.itemId);
/* 28 */     List<Long> lockIds = new ArrayList();
/* 29 */     Iterator<Integer> iter = idChain.iterator();
/* 30 */     while (iter.hasNext()) {
/* 31 */       int itemid = ((Integer)iter.next()).intValue();
/* 32 */       lockIds.add(Long.valueOf(GameServerInfoManager.toGlobalId(itemid)));
/*    */     }
/*    */     
/*    */ 
/* 36 */     lock(Shanghui.getTable(), lockIds);
/*    */     
/* 38 */     int lastPrice = 0;
/* 39 */     while (!idChain.isEmpty()) {
/* 40 */       int itemId = ((Integer)idChain.pop()).intValue();
/* 41 */       SShangHuiItemToolsCfg cfg = ShanghuiManager.getShangHuiItemCfg(itemId);
/* 42 */       if (ShanghuiManager.logger.isDebugEnabled()) {
/* 43 */         ShanghuiManager.logger.debug("init" + cfg.id);
/*    */       }
/* 45 */       ShangHuiItem xShangHuiItem = Shanghui.get(Long.valueOf(GameServerInfoManager.toGlobalId(itemId)));
/* 46 */       if (xShangHuiItem == null) {
/* 47 */         xShangHuiItem = Pod.newShangHuiItem();
/* 48 */         xShangHuiItem.setRiserate(0);
/* 49 */         int orginalPrice = cfg.orginialPrice;
/* 50 */         if (cfg.isOrginalPriceRefLevel) {
/* 51 */           SOrginalPriceCfg orginalPriceCfg = SOrginalPriceCfg.get(cfg.orginalPriceCfgId);
/* 52 */           orginalPrice = (int)(lastPrice * orginalPriceCfg.priceRate);
/*    */         }
/* 54 */         xShangHuiItem.setOrginalprice(orginalPrice);
/* 55 */         long key = GameServerInfoManager.toGlobalId(cfg.id);
/* 56 */         Shanghui.add(Long.valueOf(key), xShangHuiItem);
/*    */       }
/* 58 */       lastPrice = ShanghuiManager.calculatePrice(xShangHuiItem.getOrginalprice(), xShangHuiItem.getRiserate());
/* 59 */       ShanghuiManager.addShoppingItem(xShangHuiItem, itemId);
/*    */     }
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\POnAddShanghuiItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */