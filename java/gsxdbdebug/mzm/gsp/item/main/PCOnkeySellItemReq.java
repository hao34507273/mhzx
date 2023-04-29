/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.item.SSellGoldRes;
/*     */ import mzm.gsp.item.SSellSilverRes;
/*     */ import mzm.gsp.item.Uuid2num;
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
/*     */ 
/*     */ 
/*     */ public class PCOnkeySellItemReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int bagid;
/*     */   private List<Uuid2num> uuid2nums;
/*     */   
/*     */   public PCOnkeySellItemReq(long roleId, int bagid, List<Uuid2num> uuid2nums)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.bagid = bagid;
/*  33 */     this.uuid2nums = uuid2nums;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (!ItemModuleSwitchInterface.isItemRecycleSwitchOpenForRole(this.roleId))
/*     */     {
/*  41 */       return false;
/*     */     }
/*  43 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleId))
/*     */     {
/*  45 */       String logStr = String.format("[item]PCOnkeySellItemReq.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  47 */       ItemManager.logger.info(logStr);
/*  48 */       return false;
/*     */     }
/*  50 */     if (this.bagid == 340600001)
/*     */     {
/*  52 */       return false;
/*     */     }
/*  54 */     SSellGoldRes goldres = new SSellGoldRes();
/*     */     
/*  56 */     SSellSilverRes silverres = new SSellSilverRes();
/*     */     
/*  58 */     boolean ret = false;
/*  59 */     for (Uuid2num uuid2num : this.uuid2nums)
/*     */     {
/*  61 */       BasicItem basicItem = ItemInterface.getItemByUuid(this.roleId, this.bagid, uuid2num.uuid);
/*  62 */       if ((basicItem == null) || (basicItem.getNumber() <= 0))
/*     */       {
/*  64 */         return false;
/*     */       }
/*  66 */       if (!basicItem.canSell(this.roleId))
/*     */       {
/*  68 */         return false;
/*     */       }
/*  70 */       int num = uuid2num.num;
/*  71 */       if ((num <= 0) || (num > basicItem.getNumber()))
/*     */       {
/*  73 */         return false;
/*     */       }
/*     */       
/*  76 */       SItemCfg itemCfg = SItemCfg.get(basicItem.getCfgId());
/*  77 */       if (itemCfg == null)
/*     */       {
/*  79 */         return false;
/*     */       }
/*  81 */       if (!itemCfg.canSellAndThrow)
/*     */       {
/*  83 */         return false;
/*     */       }
/*  85 */       if (itemCfg.isProprietary)
/*     */       {
/*  87 */         return false;
/*     */       }
/*  89 */       TLogArg tLogArg = new TLogArg(LogReason.ITEM_SELL);
/*  90 */       int goldprice = ItemConfigManager.getItemSellGoldNum(itemCfg.id);
/*     */       
/*  92 */       if (goldprice != -1)
/*     */       {
/*  94 */         int addnum = goldprice * num;
/*  95 */         ret = ItemManager.addMoneyWithinMax(this.roleId, tLogArg, addnum, 2);
/*     */         
/*     */ 
/*  98 */         if (!ret)
/*     */         {
/* 100 */           return false;
/*     */         }
/* 102 */         goldres.goldnum += addnum;
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 107 */         int addnum = itemCfg.sellSilver * num;
/* 108 */         ret = ItemManager.addMoneyWithinMax(this.roleId, tLogArg, addnum, 3);
/*     */         
/* 110 */         if (!ret)
/*     */         {
/* 112 */           return false;
/*     */         }
/* 114 */         silverres.silvernum += addnum;
/*     */       }
/*     */       
/* 117 */       if (ret)
/*     */       {
/*     */ 
/* 120 */         ret = ItemInterface.removeItemByUuid(this.roleId, this.bagid, uuid2num.uuid, num, tLogArg);
/* 121 */         if ((ret) && (num > 1) && ((basicItem instanceof BaoTuItem)))
/*     */         {
/* 123 */           BaoTuItem baoTuItem = (BaoTuItem)basicItem;
/* 124 */           ret = baoTuItem.onCreateItem();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 129 */     if (goldres.goldnum > 0)
/*     */     {
/* 131 */       OnlineManager.getInstance().send(this.roleId, goldres);
/*     */     }
/* 133 */     if (silverres.silvernum > 0)
/*     */     {
/* 135 */       OnlineManager.getInstance().send(this.roleId, silverres);
/*     */     }
/*     */     
/* 138 */     return ret;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PCOnkeySellItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */