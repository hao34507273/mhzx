/*    */ package mzm.gsp.shanghui.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.shanghui.confbean.SShangHuiConsts;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.ShangHuiItem;
/*    */ import xtable.Shanghui;
/*    */ 
/*    */ public class PShangHuiPriceUpdate
/*    */   extends LogicProcedure
/*    */ {
/*    */   private int shopItemId;
/*    */   
/*    */   public PShangHuiPriceUpdate(int shopItemId)
/*    */   {
/* 16 */     this.shopItemId = shopItemId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     long key = GameServerInfoManager.toGlobalId(this.shopItemId);
/* 22 */     ShangHuiItem xShangHuiItem = Shanghui.get(Long.valueOf(key));
/* 23 */     int curPrice = (int)(xShangHuiItem.getOrginalprice() * (xShangHuiItem.getRiserate() + ShanghuiManager.BASE_RATE) / ShanghuiManager.BASE_RATE);
/* 24 */     long diffPrice = xShangHuiItem.getOrginalprice() - curPrice;
/*    */     
/* 26 */     if (xShangHuiItem.getRiserate() > 0) {
/* 27 */       xShangHuiItem.setOrginalprice((int)(curPrice + diffPrice * SShangHuiConsts.getInstance().RISE_FALL_BACK_RATE / ShanghuiManager.BASE_RATE));
/*    */     }
/*    */     
/*    */ 
/* 31 */     if (xShangHuiItem.getRiserate() < 0) {
/* 32 */       xShangHuiItem.setOrginalprice((int)(curPrice + diffPrice * SShangHuiConsts.getInstance().FALL_RISE_BACK_RATE / ShanghuiManager.BASE_RATE));
/*    */     }
/* 34 */     xShangHuiItem.setRiserate(0);
/* 35 */     ShanghuiManager.logInfo("PShangHuiPriceUpdate.processImp@shanghui item price update|itemid=%d|orginalprice=%d", new Object[] { Integer.valueOf(this.shopItemId), Integer.valueOf(xShangHuiItem.getOrginalprice()) });
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\PShangHuiPriceUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */