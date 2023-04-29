/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.item.SUseSelectBagItemRes;
/*    */ import mzm.gsp.item.confbean.SSelectItemBagCfg;
/*    */ import mzm.gsp.item.confbean.SelectBagItemNum;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PUseSelectBagItem extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   public long roleid;
/*    */   public long uuid;
/*    */   public int selectindex;
/*    */   
/*    */   public PUseSelectBagItem(long roleid, long uuid, int index)
/*    */   {
/* 20 */     this.roleid = roleid;
/* 21 */     this.uuid = uuid;
/* 22 */     this.selectindex = (index - 1);
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     if (!ItemModuleSwitchInterface.isUseSelectBagItemSwitchOpenForRole(this.roleid))
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*    */     {
/* 34 */       String logStr = String.format("[item]PUseSelectBagItem.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/* 36 */       ItemManager.logger.info(logStr);
/* 37 */       return false;
/*    */     }
/* 39 */     if (this.selectindex < 0)
/*    */     {
/* 41 */       String logStr = String.format("[item]PUseGiftBagItem.processImp@selectindex error|roleid=%d|uuid=%d|selectindex=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(this.selectindex) });
/*    */       
/*    */ 
/* 44 */       ItemManager.logger.error(logStr);
/* 45 */       return false;
/*    */     }
/* 47 */     BasicItem basicItem = ItemInterface.getItemByUuid(this.roleid, this.uuid);
/* 48 */     if ((basicItem == null) || (SSelectItemBagCfg.get(basicItem.getCfgId()) == null))
/*    */     {
/* 50 */       String logStr = String.format("[item]PUseGiftBagItem.processImp@basicItem itemid error|roleid=%d|uuid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(basicItem == null ? 0 : basicItem.getCfgId()) });
/*    */       
/*    */ 
/* 53 */       ItemManager.logger.error(logStr);
/* 54 */       return false;
/*    */     }
/* 56 */     SSelectItemBagCfg selectItemBagCfg = SSelectItemBagCfg.get(basicItem.getCfgId());
/* 57 */     if (this.selectindex >= selectItemBagCfg.items.size())
/*    */     {
/* 59 */       String logStr = String.format("[item]PUseGiftBagItem.processImp@selectindex over flow|roleid=%d|uuid=%d|selectindex=%d|maxsize=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(this.selectindex), Integer.valueOf(selectItemBagCfg.items.size()) });
/*    */       
/*    */ 
/* 62 */       ItemManager.logger.error(logStr);
/* 63 */       return false;
/*    */     }
/*    */     
/* 66 */     SelectBagItemNum item2Num = (SelectBagItemNum)selectItemBagCfg.items.get(this.selectindex);
/* 67 */     TLogArg logArg = new TLogArg(LogReason.ITEM_USE_Selectbag, item2Num.itemid);
/*    */     
/* 69 */     ItemOperateResult result = ItemInterface.addItem(this.roleid, item2Num.itemid, item2Num.num, logArg);
/* 70 */     if (result.isBagFull())
/*    */     {
/* 72 */       ItemInterface.sendSpecificBagFull(this.roleid, result.getFullBagId());
/* 73 */       return false;
/*    */     }
/* 75 */     boolean ret = ItemInterface.removeItemByUuid(this.roleid, this.uuid, 1, logArg);
/* 76 */     SUseSelectBagItemRes res = new SUseSelectBagItemRes();
/* 77 */     res.itemid = item2Num.itemid;
/* 78 */     res.num = item2Num.num;
/* 79 */     OnlineManager.getInstance().send(this.roleid, res);
/* 80 */     if ((result.success()) && (ret))
/*    */     {
/* 82 */       String logStr = String.format("[item]PUseGiftBagItem.processImp@success|roleid=%d|useditemid=%d|selectindex=%d|itemid=%d|num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(basicItem.getCfgId()), Integer.valueOf(this.selectindex), Integer.valueOf(item2Num.itemid), Integer.valueOf(item2Num.num) });
/*    */       
/*    */ 
/* 85 */       ItemManager.logger.info(logStr);
/*    */     }
/* 87 */     return (result.success()) && (ret);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PUseSelectBagItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */