/*     */ package mzm.gsp.shanghui.main;
/*     */ 
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.shanghui.SGetSellItemPriceRes;
/*     */ import mzm.gsp.shanghui.confbean.SShangHuiConsts;
/*     */ import mzm.gsp.shanghui.confbean.SShangHuiItemToolsCfg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.ShangHuiItem;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Shanghui;
/*     */ 
/*     */ public class PCGetSellItemReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int bagid;
/*     */   private int itemId;
/*     */   private int itemKey;
/*     */   
/*     */   public PCGetSellItemReq(long roleId, int bagid, int itemId, int itemKey)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.bagid = bagid;
/*  31 */     this.itemKey = itemKey;
/*  32 */     this.itemId = itemId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!ShanghuiManager.isShangHuiSwitchOpenForRole(this.roleId)) {
/*  39 */       return false;
/*     */     }
/*  41 */     SShangHuiItemToolsCfg itemCfg = ShanghuiManager.getShangHuiItemCfg(this.itemId);
/*  42 */     if ((itemCfg == null) || (!itemCfg.isPriceFlow)) {
/*  43 */       SGetSellItemPriceRes sGetSellItemPriceRes = new SGetSellItemPriceRes();
/*  44 */       sGetSellItemPriceRes.bagid = this.bagid;
/*  45 */       sGetSellItemPriceRes.itemid = this.itemId;
/*  46 */       sGetSellItemPriceRes.itemkey = this.itemKey;
/*  47 */       sGetSellItemPriceRes.price = -1;
/*  48 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sGetSellItemPriceRes);
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.SHANGHUI.value, this.itemId)) {
/*  53 */       String itemName = ItemInterface.getItemName(this.itemId);
/*  54 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, itemName);
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     int level = RoleInterface.getLevel(this.roleId);
/*  59 */     if (level < SShangHuiConsts.getInstance().OPEN_LEVEL) {
/*  60 */       SGetSellItemPriceRes sGetSellItemPriceRes = new SGetSellItemPriceRes();
/*  61 */       sGetSellItemPriceRes.bagid = this.bagid;
/*  62 */       sGetSellItemPriceRes.itemid = this.itemId;
/*  63 */       sGetSellItemPriceRes.itemkey = this.itemKey;
/*  64 */       sGetSellItemPriceRes.price = -1;
/*  65 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sGetSellItemPriceRes);
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*  71 */     long key = GameServerInfoManager.toGlobalId(this.itemId);
/*  72 */     ShangHuiItem xShangHuiItem = Shanghui.get(Long.valueOf(key));
/*  73 */     if (xShangHuiItem == null) {
/*  74 */       SGetSellItemPriceRes sGetSellItemPriceRes = new SGetSellItemPriceRes();
/*  75 */       sGetSellItemPriceRes.bagid = this.bagid;
/*  76 */       sGetSellItemPriceRes.itemid = this.itemId;
/*  77 */       sGetSellItemPriceRes.itemkey = this.itemKey;
/*  78 */       sGetSellItemPriceRes.price = -1;
/*  79 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sGetSellItemPriceRes);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     BasicItem item = ItemInterface.getItem(this.roleId, this.bagid, this.itemKey, true);
/*  84 */     if (item == null) {
/*  85 */       SGetSellItemPriceRes sGetSellItemPriceRes = new SGetSellItemPriceRes();
/*  86 */       sGetSellItemPriceRes.bagid = this.bagid;
/*  87 */       sGetSellItemPriceRes.itemid = this.itemId;
/*  88 */       sGetSellItemPriceRes.itemkey = this.itemKey;
/*  89 */       sGetSellItemPriceRes.price = -1;
/*  90 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sGetSellItemPriceRes);
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     double sellRate = 1.0D;
/*  95 */     if (xShangHuiItem.getRiserate() <= SShangHuiConsts.getInstance().PRICE_DAY_MIN_FLOW_LIMIT) {
/*  96 */       sellRate = SShangHuiConsts.getInstance().STOP_FALL_SELL_RATE;
/*     */     }
/*     */     
/*  99 */     int curPrice = (int)(xShangHuiItem.getOrginalprice() * (ShanghuiManager.BASE_RATE + xShangHuiItem.getRiserate()) / ShanghuiManager.BASE_RATE);
/* 100 */     int sellPrice = 0;
/* 101 */     if (item.isItemFromShanghui()) {
/* 102 */       sellPrice = (int)(item.getShangHuiPrice() * SShangHuiConsts.getInstance().ITEM_FROM_SHANGHUI_SELL_BASE_BUY_RATE / ShanghuiManager.BASE_RATE);
/*     */     } else {
/* 104 */       sellPrice = (int)(curPrice * SShangHuiConsts.getInstance().ITEM_NOT_FROM_SHANGHUI_SELL_BASE_MARKET_RATE / ShanghuiManager.BASE_RATE);
/*     */     }
/* 106 */     sellPrice = (int)(sellPrice * sellRate);
/*     */     
/* 108 */     if (sellPrice < itemCfg.minPrice) {
/* 109 */       sellPrice = itemCfg.minPrice;
/*     */     }
/* 111 */     SGetSellItemPriceRes sGetSellItemPriceRes = new SGetSellItemPriceRes();
/* 112 */     sGetSellItemPriceRes.bagid = this.bagid;
/* 113 */     sGetSellItemPriceRes.itemid = this.itemId;
/* 114 */     sGetSellItemPriceRes.itemkey = this.itemKey;
/* 115 */     sGetSellItemPriceRes.price = sellPrice;
/* 116 */     OnlineManager.getInstance().send(this.roleId, sGetSellItemPriceRes);
/*     */     
/* 118 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\PCGetSellItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */