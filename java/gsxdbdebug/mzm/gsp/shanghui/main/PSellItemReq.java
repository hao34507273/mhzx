/*     */ package mzm.gsp.shanghui.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.ModMoneyResult;
/*     */ import mzm.gsp.role.main.ModMoneyResult.ErrorResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.shanghui.SCommonResultRes;
/*     */ import mzm.gsp.shanghui.SSellItemRes;
/*     */ import mzm.gsp.shanghui.ShoppingItem;
/*     */ import mzm.gsp.shanghui.confbean.SPriceFlowFormulaCfg;
/*     */ import mzm.gsp.shanghui.confbean.SRecommandPriceCfg;
/*     */ import mzm.gsp.shanghui.confbean.SShangHuiConsts;
/*     */ import mzm.gsp.shanghui.confbean.SShangHuiItemToolsCfg;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleShangHuiBean;
/*     */ import xbean.RoleShangHuiItem;
/*     */ import xbean.ShangHuiItem;
/*     */ import xtable.Role2shanghui;
/*     */ 
/*     */ public class PSellItemReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int bagid;
/*     */   private int itemKey;
/*     */   private int itemId;
/*     */   
/*     */   public PSellItemReq(long roleId, int bagid, int itemKey, int itemId)
/*     */   {
/*  37 */     this.roleId = roleId;
/*  38 */     this.bagid = bagid;
/*  39 */     this.itemKey = itemKey;
/*  40 */     this.itemId = itemId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     if (!ShanghuiManager.isShangHuiSwitchOpenForRole(this.roleId)) {
/*  47 */       return false;
/*     */     }
/*  49 */     int serverLevel = mzm.gsp.server.main.ServerInterface.getCurrentServerLevel();
/*     */     
/*  51 */     int level = RoleInterface.getLevel(this.roleId);
/*  52 */     if (level < SShangHuiConsts.getInstance().OPEN_LEVEL) {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.SHANGHUI.value, this.itemId)) {
/*  57 */       String itemName = ItemInterface.getItemName(this.itemId);
/*  58 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, itemName);
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     if (!ShanghuiManager.isShangHuiOpenSubTypeItem(this.roleId, this.itemId)) {
/*  63 */       ShanghuiManager.logDebug("PSellItemReq.processImp@funtion not open!|roleid=%d|itemId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId) });
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  68 */     BasicItem checkItem = ItemInterface.getItem(this.roleId, this.bagid, this.itemKey, true);
/*  69 */     if (checkItem == null) {
/*  70 */       ShanghuiManager.logDebug("PSellItemReq.processImp@itemkey get item is null|roleid=%d|bagid=%d|itemid=%d|itemkey=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagid), Integer.valueOf(this.itemId), Integer.valueOf(this.itemKey) });
/*  71 */       return false;
/*     */     }
/*  73 */     if (checkItem.getCfgId() != this.itemId) {
/*  74 */       ShanghuiManager.logDebug("PSellItemReq.processImp@itemkey cfgid not itemid|roleid=%d|bagid=%d|itemid=%d|itemkey=%d|itemkeycfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagid), Integer.valueOf(this.itemId), Integer.valueOf(this.itemKey), Integer.valueOf(checkItem.getCfgId()) });
/*  75 */       return false;
/*     */     }
/*  77 */     if (checkItem.isBind()) {
/*  78 */       ShanghuiManager.logDebug("PSellItemReq.processImp@bind item cannot be sold|roleid=%d|bagid=%d|itemid=%d|itemkey=%d|itemkeycfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagid), Integer.valueOf(this.itemId), Integer.valueOf(this.itemKey), Integer.valueOf(checkItem.getCfgId()) });
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  83 */     RoleShangHuiBean xRoleShangHuiBean = Role2shanghui.get(Long.valueOf(this.roleId));
/*  84 */     long key = mzm.gsp.GameServerInfoManager.toGlobalId(this.itemId);
/*  85 */     ShangHuiItem xShangHuiItem = xtable.Shanghui.get(Long.valueOf(key));
/*  86 */     if (xShangHuiItem == null) {
/*  87 */       ShanghuiManager.logDebug("PSellItemReq.processImp@xdb not have item|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId) });
/*  88 */       return false;
/*     */     }
/*  90 */     if (xRoleShangHuiBean == null) {
/*  91 */       xRoleShangHuiBean = Pod.newRoleShangHuiBean();
/*  92 */       Role2shanghui.add(Long.valueOf(this.roleId), xRoleShangHuiBean);
/*     */     }
/*  94 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  95 */     if (!ShanghuiManager.isSameDay(now, xRoleShangHuiBean.getTimestamp())) {
/*  96 */       xRoleShangHuiBean.setTimestamp(now);
/*  97 */       xRoleShangHuiBean.getItemmap().clear();
/*     */     }
/*  99 */     RoleShangHuiItem xRoleItem = (RoleShangHuiItem)xRoleShangHuiBean.getItemmap().get(Integer.valueOf(this.itemId));
/* 100 */     if (xRoleItem == null) {
/* 101 */       xRoleItem = Pod.newRoleShangHuiItem();
/* 102 */       xRoleShangHuiBean.getItemmap().put(Integer.valueOf(this.itemId), xRoleItem);
/*     */     }
/*     */     
/* 105 */     if (-xShangHuiItem.getRiserate() > SShangHuiConsts.getInstance().NO_ITEM_SELLED_MORE_THAN_ORG_PRICE_RATE) {
/* 106 */       sendErrMsg(6);
/* 107 */       return false;
/*     */     }
/* 109 */     SShangHuiItemToolsCfg itemCfg = ShanghuiManager.getShangHuiItemCfg(this.itemId);
/* 110 */     if (itemCfg == null) {
/* 111 */       return false;
/*     */     }
/* 113 */     if (xRoleItem.getSellnum() >= itemCfg.daySellMaxNum) {
/* 114 */       sendErrMsg(5);
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     BasicItem item = ItemInterface.getAndRemoveItemInBag(this.roleId, this.bagid, this.itemKey, 1, new TLogArg(LogReason.SHANGHUI_SELL_REM, this.itemId));
/* 119 */     if (item == null) {
/* 120 */       ShanghuiManager.logDebug("PSellItemReq.processImp@sell item remove error|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId) });
/* 121 */       return false;
/*     */     }
/* 123 */     if (item.getCfgId() != this.itemId) {
/* 124 */       ShanghuiManager.logDebug("PSellItemReq.processImp@itemkey cfgid not itemid|roleid=%d|bagid=%d|itemid=%d|itemkey=%d|itemkeycfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagid), Integer.valueOf(this.itemId), Integer.valueOf(this.itemKey), Integer.valueOf(item.getCfgId()) });
/* 125 */       return false;
/*     */     }
/*     */     
/* 128 */     xRoleItem.setSellnum(xRoleItem.getSellnum() + 1);
/*     */     
/* 130 */     double sellRate = 1.0D;
/* 131 */     if (xShangHuiItem.getRiserate() <= SShangHuiConsts.getInstance().PRICE_DAY_MIN_FLOW_LIMIT) {
/* 132 */       sellRate = SShangHuiConsts.getInstance().STOP_FALL_SELL_RATE;
/*     */     }
/*     */     
/* 135 */     int curPrice = (int)(xShangHuiItem.getOrginalprice() * (ShanghuiManager.BASE_RATE + xShangHuiItem.getRiserate()) / ShanghuiManager.BASE_RATE);
/* 136 */     int sellPrice = 0;
/* 137 */     if (item.isItemFromShanghui()) {
/* 138 */       sellPrice = (int)(item.getShangHuiPrice() * SShangHuiConsts.getInstance().ITEM_FROM_SHANGHUI_SELL_BASE_BUY_RATE / ShanghuiManager.BASE_RATE);
/*     */     } else {
/* 140 */       sellPrice = (int)(curPrice * SShangHuiConsts.getInstance().ITEM_NOT_FROM_SHANGHUI_SELL_BASE_MARKET_RATE / ShanghuiManager.BASE_RATE);
/*     */     }
/* 142 */     sellPrice = (int)(sellPrice * sellRate);
/*     */     
/* 144 */     if (sellPrice < itemCfg.minPrice) {
/* 145 */       sellPrice = itemCfg.minPrice;
/*     */       
/* 147 */       ModMoneyResult modMoneyResult = RoleInterface.addGoldWithinMax(this.roleId, sellPrice, new TLogArg(LogReason.SHANGHUI_SELL_REM, this.itemId));
/* 148 */       if (!modMoneyResult.isSucceed()) {
/* 149 */         if (modMoneyResult.getRes() == ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT) {
/* 150 */           SCommonResultRes result = new SCommonResultRes();
/* 151 */           result.res = 50;
/* 152 */           OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/*     */         }
/* 154 */         return false;
/*     */       }
/* 156 */       SSellItemRes res = new SSellItemRes();
/* 157 */       res.cansellnum = (itemCfg.daySellMaxNum - xRoleItem.getSellnum());
/* 158 */       res.earngold = sellPrice;
/* 159 */       ShoppingItem shoppingItem = new ShoppingItem();
/* 160 */       shoppingItem.itemid = this.itemId;
/* 161 */       shoppingItem.price = ShanghuiManager.calculatePrice(xShangHuiItem.getOrginalprice(), xShangHuiItem.getRiserate());
/* 162 */       shoppingItem.rise = xShangHuiItem.getRiserate();
/* 163 */       res.iteminfo = shoppingItem;
/* 164 */       OnlineManager.getInstance().send(this.roleId, res);
/* 165 */       return true;
/*     */     }
/*     */     
/* 168 */     if (itemCfg.isPriceFlow) {
/* 169 */       SRecommandPriceCfg recommandPriceCfg = ShanghuiManager.getRecommandCfg(this.itemId, serverLevel);
/* 170 */       if (recommandPriceCfg == null) {
/* 171 */         return false;
/*     */       }
/* 173 */       int recommandPrice = recommandPriceCfg.recommandPrice;
/* 174 */       float p = (curPrice - recommandPrice) / recommandPrice;
/* 175 */       SPriceFlowFormulaCfg priceFlowFormulaCfg = SPriceFlowFormulaCfg.get(itemCfg.priceFlowFormulaId);
/* 176 */       double m = priceFlowFormulaCfg.offsetMinM;
/* 177 */       double y = priceFlowFormulaCfg.fallParamY;
/* 178 */       double z = priceFlowFormulaCfg.fallFormulaScallParamZ;
/* 179 */       double ajust = priceFlowFormulaCfg.fallFormulaAjustParam;
/* 180 */       double sqrtTime = priceFlowFormulaCfg.sqrtTime2;
/*     */       double sellAddRate;
/* 182 */       double sellAddRate; if (p > 0.0F) {
/* 183 */         sellAddRate = (float)(y * Math.pow(p * ajust - m, sqrtTime) * z);
/*     */       } else {
/* 185 */         sellAddRate = (float)(y * Math.pow(p - m, sqrtTime) * z);
/*     */       }
/* 187 */       xShangHuiItem.setRiserate((int)(xShangHuiItem.getRiserate() - sellAddRate * ShanghuiManager.BASE_RATE));
/*     */     }
/*     */     
/* 190 */     ModMoneyResult modMoneyResult = RoleInterface.addGoldWithinMax(this.roleId, sellPrice, new TLogArg(LogReason.SHANGHUI_SELL_REM, this.itemId));
/* 191 */     if (!modMoneyResult.isSucceed()) {
/* 192 */       if (modMoneyResult.getRes() == ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT) {
/* 193 */         SCommonResultRes result = new SCommonResultRes();
/* 194 */         result.res = 50;
/* 195 */         OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/*     */       }
/* 197 */       return false;
/*     */     }
/*     */     
/* 200 */     SSellItemRes res = new SSellItemRes();
/* 201 */     res.cansellnum = (itemCfg.daySellMaxNum - xRoleItem.getSellnum());
/* 202 */     res.earngold = sellPrice;
/* 203 */     ShoppingItem shoppingItem = new ShoppingItem();
/* 204 */     shoppingItem.itemid = this.itemId;
/* 205 */     shoppingItem.price = ShanghuiManager.calculatePrice(xShangHuiItem.getOrginalprice(), xShangHuiItem.getRiserate());
/* 206 */     shoppingItem.rise = xShangHuiItem.getRiserate();
/* 207 */     res.iteminfo = shoppingItem;
/*     */     
/* 209 */     OnlineManager.getInstance().send(this.roleId, res);
/* 210 */     return true;
/*     */   }
/*     */   
/*     */   private void sendErrMsg(int errorCode) {
/* 214 */     SCommonResultRes res = new SCommonResultRes();
/* 215 */     res.res = errorCode;
/* 216 */     OnlineManager.getInstance().sendAtOnce(this.roleId, res);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\PSellItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */