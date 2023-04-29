/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.item.confbean.SItemCfg;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PAbandonItem
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int bagid;
/*    */   private final long uuid;
/*    */   private int num;
/*    */   
/*    */   public PAbandonItem(long roleId, int bagid, long uuid, int num)
/*    */   {
/* 25 */     this.roleId = roleId;
/* 26 */     this.bagid = bagid;
/* 27 */     this.uuid = uuid;
/* 28 */     this.num = num;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     if (!ItemModuleSwitchInterface.isAbandonItemSwitchOpenForRole(this.roleId))
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleId))
/*    */     {
/* 40 */       String logStr = String.format("[item]PAbandonItem.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/* 41 */       ItemManager.logger.info(logStr);
/* 42 */       return false;
/*    */     }
/* 44 */     if (this.bagid != 340600000)
/*    */     {
/* 46 */       return false;
/*    */     }
/* 48 */     BasicItem basicItem = ItemInterface.getItemByUuid(this.roleId, this.bagid, this.uuid);
/* 49 */     if ((basicItem == null) || (basicItem.getNumber() <= 0))
/*    */     {
/* 51 */       return false;
/*    */     }
/* 53 */     if (this.num != basicItem.getNumber())
/*    */     {
/* 55 */       return false;
/*    */     }
/* 57 */     SItemCfg itemCfg = SItemCfg.get(basicItem.getCfgId());
/* 58 */     if (itemCfg == null)
/*    */     {
/* 60 */       return false;
/*    */     }
/* 62 */     if (!itemCfg.isProprietary)
/*    */     {
/* 64 */       return false;
/*    */     }
/* 66 */     if (!itemCfg.canSellAndThrow)
/*    */     {
/* 68 */       return false;
/*    */     }
/* 70 */     TLogArg tLogArg = new TLogArg(LogReason.ITEM_ABANDON_REM);
/*    */     
/* 72 */     return ItemInterface.removeItemByUuid(this.roleId, this.uuid, 1, tLogArg);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PAbandonItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */