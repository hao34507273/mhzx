/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import mzm.gsp.item.SSellGoldRes;
/*     */ import mzm.gsp.item.SSellSilverRes;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCSellItemReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long uuid;
/*     */   private int bagid;
/*     */   private final long roleId;
/*     */   private int num;
/*     */   
/*     */   public PCSellItemReq(long uuid, int bagid, long roleId, int num)
/*     */   {
/*  28 */     this.uuid = uuid;
/*  29 */     this.bagid = bagid;
/*  30 */     this.roleId = roleId;
/*  31 */     this.num = num;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!ItemModuleSwitchInterface.isItemRecycleSwitchOpenForRole(this.roleId))
/*     */     {
/*  39 */       return false;
/*     */     }
/*  41 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleId))
/*     */     {
/*  43 */       String logStr = String.format("[item]PCSellItemReq.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  44 */       ItemManager.logger.info(logStr);
/*  45 */       return false;
/*     */     }
/*  47 */     BasicItem basicItem = ItemInterface.getItemByUuid(this.roleId, this.bagid, this.uuid, true);
/*  48 */     if ((basicItem == null) || (basicItem.getNumber() <= 0))
/*     */     {
/*  50 */       return false;
/*     */     }
/*  52 */     if (this.num != basicItem.getNumber())
/*     */     {
/*  54 */       return false;
/*     */     }
/*  56 */     SItemCfg itemCfg = SItemCfg.get(basicItem.getCfgId());
/*  57 */     if (itemCfg == null)
/*     */     {
/*  59 */       return false;
/*     */     }
/*  61 */     if (!itemCfg.canSellAndThrow)
/*     */     {
/*  63 */       return false;
/*     */     }
/*  65 */     if (itemCfg.isProprietary)
/*     */     {
/*  67 */       return false;
/*     */     }
/*  69 */     if (!basicItem.canSell(this.roleId))
/*     */     {
/*  71 */       return false;
/*     */     }
/*  73 */     TLogArg tLogArg = new TLogArg(LogReason.ITEM_SELL);
/*  74 */     int goldprice = ItemConfigManager.getItemSellGoldNum(itemCfg.id);
/*  75 */     if (goldprice != -1)
/*     */     {
/*  77 */       if (!ItemManager.addMoneyWithinMax(this.roleId, tLogArg, goldprice, 2))
/*     */       {
/*  79 */         return false;
/*     */       }
/*  81 */       SSellGoldRes res = new SSellGoldRes();
/*  82 */       res.goldnum = goldprice;
/*  83 */       OnlineManager.getInstance().send(this.roleId, res);
/*     */     }
/*     */     else
/*     */     {
/*  87 */       if (!ItemManager.addMoneyWithinMax(this.roleId, tLogArg, itemCfg.sellSilver, 3))
/*     */       {
/*  89 */         return false;
/*     */       }
/*  91 */       SSellSilverRes res = new SSellSilverRes();
/*  92 */       res.silvernum = itemCfg.sellSilver;
/*  93 */       OnlineManager.getInstance().send(this.roleId, res);
/*     */     }
/*  95 */     boolean ret = ItemInterface.removeItemByUuid(this.roleId, this.bagid, this.uuid, 1, tLogArg);
/*  96 */     if ((ret) && (this.num > 1) && ((basicItem instanceof BaoTuItem)))
/*     */     {
/*  98 */       BaoTuItem baoTuItem = (BaoTuItem)basicItem;
/*  99 */       ret = baoTuItem.onCreateItem();
/*     */     }
/*     */     
/* 102 */     return ret;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PCSellItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */