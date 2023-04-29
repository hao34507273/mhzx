/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.item.main.BasicItem;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.SUseDrug;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PUseDrug
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int itemKey;
/*    */   private final int bagid;
/*    */   
/*    */   public PUseDrug(long roleId, int itemKey, int bagId)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.itemKey = itemKey;
/* 22 */     this.bagid = bagId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     BasicItem item = ItemInterface.getItem(this.roleId, this.itemKey);
/* 29 */     if (item == null)
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     int buffId = UseDrugManager.checkCollisionBuff(this.roleId, item.getCfgId());
/* 34 */     if (buffId > 0)
/*    */     {
/* 36 */       SUseDrug useDrugMsg = new SUseDrug();
/* 37 */       useDrugMsg.itemkey = this.itemKey;
/* 38 */       useDrugMsg.bagid = this.bagid;
/* 39 */       useDrugMsg.collisionbuffid = buffId;
/* 40 */       useDrugMsg.drugbuffid = UseDrugManager.getItemBuff(item.getCfgId());
/* 41 */       OnlineManager.getInstance().sendAtOnce(this.roleId, useDrugMsg);
/* 42 */       return false;
/*    */     }
/* 44 */     if (!ItemInterface.removeItemByUuid(this.roleId, item.getFirstUuid().longValue(), 1, new TLogArg(LogReason.ROLE_USE_DRUG_ITEM_REM, item.getCfgId())))
/*    */     {
/*    */ 
/* 47 */       return false;
/*    */     }
/* 49 */     return UseDrugManager.useDrag(this.roleId, item.getCfgId(), this.bagid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PUseDrug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */