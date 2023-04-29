/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class PQueryItemYuanbaoPrice extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int itemId;
/*    */   
/*    */   public PQueryItemYuanbaoPrice(long roleId, int itemId)
/*    */   {
/* 12 */     this.roleId = roleId;
/* 13 */     this.itemId = itemId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception {
/* 17 */     int price = ItemInterface.getItemYuanBaoPrice(this.itemId);
/* 18 */     mzm.gsp.item.SItemYuanbaoPriceRes res = new mzm.gsp.item.SItemYuanbaoPriceRes();
/* 19 */     res.yuanbaoprice = price;
/* 20 */     res.itemid = this.itemId;
/* 21 */     OnlineManager.getInstance().send(this.roleId, res);
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PQueryItemYuanbaoPrice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */