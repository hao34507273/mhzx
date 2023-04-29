/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.item.main.BasicItem;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PConfirmUseDrug
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int itemKey;
/*    */   private final int bagId;
/*    */   
/*    */   public PConfirmUseDrug(long roleId, int itemKey, int bagId)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.itemKey = itemKey;
/* 20 */     this.bagId = bagId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     BasicItem item = ItemInterface.getItem(this.roleId, this.bagId, this.itemKey);
/* 27 */     if (!ItemInterface.removeItemByUuid(this.roleId, item.getFirstUuid().longValue(), 1, new TLogArg(LogReason.ROLE_USE_DRUG_ITEM_REM, item.getCfgId())))
/*    */     {
/*    */ 
/* 30 */       return false;
/*    */     }
/* 32 */     return UseDrugManager.useDrag(this.roleId, item.getCfgId(), this.bagId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PConfirmUseDrug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */