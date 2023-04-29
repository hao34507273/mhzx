/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.function.confbean.SItemSplitCfg;
/*    */ import mzm.gsp.item.main.BasicItem;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.item.main.PSplitItem;
/*    */ 
/*    */ public class POnekeySplit extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   
/*    */   public POnekeySplit(long roleId)
/*    */   {
/* 16 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     for (Map.Entry<Integer, SItemSplitCfg> entry : SItemSplitCfg.getAll().entrySet()) {
/* 22 */       if (ItemInterface.getItemNumberById(this.roleId, ((Integer)entry.getKey()).intValue()) > 0) {
/* 23 */         Map<Integer, BasicItem> itemByItemId = ItemInterface.getItemByItemId(this.roleId, ((Integer)entry.getKey()).intValue(), false);
/* 24 */         for (Map.Entry<Integer, BasicItem> data : itemByItemId.entrySet()) {
/* 25 */           xdb.Procedure.execute(new PSplitItem(this.roleId, ((BasicItem)data.getValue()).getFirstUuid().longValue(), true));
/*    */         }
/*    */       }
/*    */     }
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnekeySplit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */