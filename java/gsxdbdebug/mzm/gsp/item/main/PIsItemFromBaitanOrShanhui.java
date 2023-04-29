/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.baitan.main.BaiTanInterface;
/*    */ import mzm.gsp.item.SItemFromBaitanOrShanhuiRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PIsItemFromBaitanOrShanhui
/*    */   extends LogicProcedure
/*    */ {
/*    */   private int itemidorsiftcfgid;
/*    */   private long roleid;
/*    */   
/*    */   public PIsItemFromBaitanOrShanhui(long roleid, int itemidorsiftcfgid)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.itemidorsiftcfgid = itemidorsiftcfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     SItemFromBaitanOrShanhuiRes res = new SItemFromBaitanOrShanhuiRes();
/* 31 */     List<Integer> itemList = new ArrayList();
/* 32 */     if (ItemInterface.isItemExist(this.itemidorsiftcfgid)) {
/* 33 */       itemList.add(Integer.valueOf(this.itemidorsiftcfgid));
/*    */     }
/*    */     else
/*    */     {
/* 37 */       itemList.addAll(ItemInterface.getSamePriceItems(this.itemidorsiftcfgid));
/*    */     }
/* 39 */     boolean ret = BaiTanInterface.isBaitanItem(((Integer)itemList.get(0)).intValue());
/* 40 */     if (ret) {
/* 41 */       res.baitanorshanghui = 1;
/*    */     }
/*    */     else {
/* 44 */       res.baitanorshanghui = 0;
/*    */     }
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 63 */     OnlineManager.getInstance().send(this.roleid, res);
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PIsItemFromBaitanOrShanhui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */