/*    */ package mzm.gsp.shanghui.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.ShangHuiItem;
/*    */ import xtable.Shanghui;
/*    */ 
/*    */ 
/*    */ public class POnDeleteShanghuiItem
/*    */   extends LogicProcedure
/*    */ {
/*    */   private int subTypeId;
/*    */   private int itemId;
/*    */   
/*    */   public POnDeleteShanghuiItem(int subTypeId, int itemId)
/*    */   {
/* 18 */     this.subTypeId = subTypeId;
/* 19 */     this.itemId = itemId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     long itemKey = GameServerInfoManager.toGlobalId(this.itemId);
/* 27 */     ShangHuiItem xShangHuiItem = Shanghui.get(Long.valueOf(itemKey));
/* 28 */     if (xShangHuiItem != null)
/*    */     {
/* 30 */       Shanghui.remove(Long.valueOf(itemKey));
/* 31 */       if (ShanghuiManager.logger.isDebugEnabled())
/*    */       {
/* 33 */         ShanghuiManager.logger.debug("热更新数据变化 删除数据 :" + this.itemId);
/*    */       }
/*    */     }
/*    */     
/* 37 */     ShanghuiManager.deleteShoppingItem(this.subTypeId, this.itemId);
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\POnDeleteShanghuiItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */