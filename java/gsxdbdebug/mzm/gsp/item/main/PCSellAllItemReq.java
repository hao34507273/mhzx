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
/*     */ public class PCSellAllItemReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long uuid;
/*     */   private int bagid;
/*     */   private final long roleId;
/*     */   
/*     */   public PCSellAllItemReq(long uuid, int bagid, long roleId)
/*     */   {
/*  27 */     this.uuid = uuid;
/*  28 */     this.bagid = bagid;
/*  29 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
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
/*  43 */       String logStr = String.format("[item]PCSellAllItemReq.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  44 */       ItemManager.logger.info(logStr);
/*  45 */       return false;
/*     */     }
/*  47 */     BasicItem basicItem = ItemInterface.getItemByUuid(this.roleId, this.bagid, this.uuid, true);
/*  48 */     if ((basicItem == null) || (basicItem.getNumber() <= 0))
/*     */     {
/*  50 */       return false;
/*     */     }
/*  52 */     if (!basicItem.canSell(this.roleId))
/*     */     {
/*  54 */       return false;
/*     */     }
/*  56 */     SItemCfg itemCfg = SItemCfg.get(basicItem.getCfgId());
/*  57 */     if (itemCfg == null)
/*     */     {
/*  59 */       return false;
/*     */     }
/*  61 */     if (!ItemConfigManager.canSellAll(basicItem.getCfgId()))
/*     */     {
/*  63 */       return false;
/*     */     }
/*  65 */     if (!itemCfg.canSellAndThrow)
/*     */     {
/*  67 */       return false;
/*     */     }
/*  69 */     if (itemCfg.isProprietary)
/*     */     {
/*  71 */       return false;
/*     */     }
/*  73 */     TLogArg tLogArg = new TLogArg(LogReason.ITEM_SELL);
/*  74 */     int goldprice = ItemConfigManager.getItemSellGoldNum(itemCfg.id);
/*  75 */     boolean ret = false;
/*  76 */     if (goldprice != -1)
/*     */     {
/*  78 */       int goldnum = goldprice * basicItem.getNumber();
/*     */       
/*  80 */       if (!ItemManager.addMoneyWithinMax(this.roleId, tLogArg, goldnum, 2))
/*     */       {
/*  82 */         return false;
/*     */       }
/*     */       
/*  85 */       SSellGoldRes res = new SSellGoldRes();
/*  86 */       res.goldnum = goldnum;
/*  87 */       OnlineManager.getInstance().send(this.roleId, res);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  92 */       int silvernum = itemCfg.sellSilver * basicItem.getNumber();
/*  93 */       if (!ItemManager.addMoneyWithinMax(this.roleId, tLogArg, silvernum, 3))
/*     */       {
/*  95 */         return false;
/*     */       }
/*  97 */       SSellSilverRes res = new SSellSilverRes();
/*  98 */       res.silvernum = silvernum;
/*  99 */       OnlineManager.getInstance().send(this.roleId, res);
/*     */     }
/* 101 */     if (ret)
/*     */     {
/*     */ 
/* 104 */       ret = ItemInterface.removeItemByUuid(this.roleId, this.bagid, this.uuid, basicItem.getNumber(), tLogArg);
/*     */     }
/*     */     
/*     */ 
/* 108 */     return ret;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PCSellAllItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */