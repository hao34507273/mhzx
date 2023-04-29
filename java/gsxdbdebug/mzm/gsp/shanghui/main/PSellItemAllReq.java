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
/*     */ public class PSellItemAllReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int bagid;
/*     */   private int itemKey;
/*     */   private int itemId;
/*     */   private int itemNum;
/*     */   
/*     */   public PSellItemAllReq(long roleId, int bagid, int itemKey, int itemId, int itemNum)
/*     */   {
/*  38 */     this.roleId = roleId;
/*  39 */     this.bagid = bagid;
/*  40 */     this.itemKey = itemKey;
/*  41 */     this.itemId = itemId;
/*  42 */     this.itemNum = itemNum;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  48 */     if (!ShanghuiManager.isShangHuiSwitchOpenForRole(this.roleId)) {
/*  49 */       return false;
/*     */     }
/*  51 */     int serverLevel = mzm.gsp.server.main.ServerInterface.getCurrentServerLevel();
/*     */     
/*  53 */     int level = RoleInterface.getLevel(this.roleId);
/*  54 */     if (level < SShangHuiConsts.getInstance().OPEN_LEVEL) {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.SHANGHUI.value, this.itemId)) {
/*  59 */       String itemName = ItemInterface.getItemName(this.itemId);
/*  60 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, itemName);
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     if (!ShanghuiManager.isShangHuiOpenSubTypeItem(this.roleId, this.itemId)) {
/*  65 */       ShanghuiManager.logDebug("PSellItemAllReq.processImp@funtion not open!|roleid=%d|itemId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId) });
/*  66 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  70 */     BasicItem checkItem = ItemInterface.getItem(this.roleId, this.bagid, this.itemKey, true);
/*  71 */     if (checkItem == null) {
/*  72 */       ShanghuiManager.logDebug("PSellItemAllReq.processImp@itemkey get item is null|roleid=%d|bagid=%d|itemid=%d|itemkey=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagid), Integer.valueOf(this.itemId), Integer.valueOf(this.itemKey) });
/*  73 */       return false;
/*     */     }
/*  75 */     if (checkItem.getCfgId() != this.itemId) {
/*  76 */       ShanghuiManager.logDebug("PSellItemAllReq.processImp@itemkey cfgid not itemid|roleid=%d|bagid=%d|itemid=%d|itemkey=%d|itemkeycfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagid), Integer.valueOf(this.itemId), Integer.valueOf(this.itemKey), Integer.valueOf(checkItem.getCfgId()) });
/*  77 */       return false;
/*     */     }
/*  79 */     if (checkItem.isBind()) {
/*  80 */       ShanghuiManager.logDebug("PSellItemAllReq.processImp@bind item cannot be sold|roleid=%d|bagid=%d|itemid=%d|itemkey=%d|itemkeycfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagid), Integer.valueOf(this.itemId), Integer.valueOf(this.itemKey), Integer.valueOf(checkItem.getCfgId()) });
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     int totalNum = 0;
/*  85 */     int totalMoney = 0;
/*  86 */     int canSellNum = 0;
/*  87 */     int price = 0;
/*  88 */     int rise = 0;
/*  89 */     for (int i = 0; i < this.itemNum; i++)
/*     */     {
/*  91 */       RoleShangHuiBean xRoleShangHuiBean = Role2shanghui.get(Long.valueOf(this.roleId));
/*  92 */       long key = mzm.gsp.GameServerInfoManager.toGlobalId(this.itemId);
/*  93 */       ShangHuiItem xShangHuiItem = xtable.Shanghui.get(Long.valueOf(key));
/*  94 */       if (xShangHuiItem != null)
/*     */       {
/*     */ 
/*  97 */         if (xRoleShangHuiBean == null) {
/*  98 */           xRoleShangHuiBean = Pod.newRoleShangHuiBean();
/*  99 */           Role2shanghui.add(Long.valueOf(this.roleId), xRoleShangHuiBean);
/*     */         }
/* 101 */         long now = DateTimeUtils.getCurrTimeInMillis();
/* 102 */         if (!ShanghuiManager.isSameDay(now, xRoleShangHuiBean.getTimestamp())) {
/* 103 */           xRoleShangHuiBean.setTimestamp(now);
/* 104 */           xRoleShangHuiBean.getItemmap().clear();
/*     */         }
/* 106 */         RoleShangHuiItem xRoleItem = (RoleShangHuiItem)xRoleShangHuiBean.getItemmap().get(Integer.valueOf(this.itemId));
/* 107 */         if (xRoleItem == null) {
/* 108 */           xRoleItem = Pod.newRoleShangHuiItem();
/* 109 */           xRoleShangHuiBean.getItemmap().put(Integer.valueOf(this.itemId), xRoleItem);
/*     */         }
/*     */         
/* 112 */         if (-xShangHuiItem.getRiserate() > SShangHuiConsts.getInstance().NO_ITEM_SELLED_MORE_THAN_ORG_PRICE_RATE) {
/* 113 */           sendErrMsg(6);
/* 114 */           break;
/*     */         }
/* 116 */         SShangHuiItemToolsCfg itemCfg = ShanghuiManager.getShangHuiItemCfg(this.itemId);
/* 117 */         if (itemCfg != null)
/*     */         {
/*     */ 
/* 120 */           if (xRoleItem.getSellnum() >= itemCfg.daySellMaxNum) {
/* 121 */             sendErrMsg(5);
/* 122 */             break;
/*     */           }
/*     */           
/* 125 */           BasicItem item = ItemInterface.getAndRemoveItemInBag(this.roleId, this.bagid, this.itemKey, 1, new TLogArg(LogReason.SHANGHUI_SELL_REM, this.itemId));
/* 126 */           if (item == null) {
/* 127 */             ShanghuiManager.logDebug("PSellItemAllReq.processImp@itemkey get item is null|roleid=%d|itemid=%d|itemkey=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Integer.valueOf(this.itemKey) });
/* 128 */             break;
/*     */           }
/* 130 */           if (item.getCfgId() != this.itemId) {
/* 131 */             ShanghuiManager.logDebug("PSellItemReq.processImp@itemkey cfgid not itemid|roleid=%d|bagid=%d|itemid=%d|itemkey=%d|itemkeycfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagid), Integer.valueOf(this.itemId), Integer.valueOf(this.itemKey), Integer.valueOf(item.getCfgId()) });
/* 132 */             return false;
/*     */           }
/*     */           
/* 135 */           xRoleItem.setSellnum(xRoleItem.getSellnum() + 1);
/*     */           
/* 137 */           double sellRate = 1.0D;
/* 138 */           if (xShangHuiItem.getRiserate() <= SShangHuiConsts.getInstance().PRICE_DAY_MIN_FLOW_LIMIT) {
/* 139 */             sellRate = SShangHuiConsts.getInstance().STOP_FALL_SELL_RATE;
/*     */           }
/*     */           
/* 142 */           int curPrice = (int)(xShangHuiItem.getOrginalprice() * (ShanghuiManager.BASE_RATE + xShangHuiItem.getRiserate()) / ShanghuiManager.BASE_RATE);
/* 143 */           int sellPrice = 0;
/* 144 */           if (item.isItemFromShanghui()) {
/* 145 */             sellPrice = (int)(item.getShangHuiPrice() * SShangHuiConsts.getInstance().ITEM_FROM_SHANGHUI_SELL_BASE_BUY_RATE / ShanghuiManager.BASE_RATE);
/*     */           } else {
/* 147 */             sellPrice = (int)(curPrice * SShangHuiConsts.getInstance().ITEM_NOT_FROM_SHANGHUI_SELL_BASE_MARKET_RATE / ShanghuiManager.BASE_RATE);
/*     */           }
/* 149 */           sellPrice = (int)(sellPrice * sellRate);
/*     */           
/*     */ 
/*     */ 
/* 153 */           if (sellPrice < itemCfg.minPrice) {
/* 154 */             sellPrice = itemCfg.minPrice;
/*     */             
/* 156 */             ModMoneyResult modMoneyResult = RoleInterface.addGoldWithinMax(this.roleId, sellPrice, new TLogArg(LogReason.SHANGHUI_SELL_REM, this.itemId));
/* 157 */             if (!modMoneyResult.isSucceed()) {
/* 158 */               if (modMoneyResult.getRes() != ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT) break;
/* 159 */               SCommonResultRes result = new SCommonResultRes();
/* 160 */               result.res = 50;
/* 161 */               OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/* 162 */               break;
/*     */             }
/*     */             
/* 165 */             totalMoney += sellPrice;
/* 166 */             canSellNum = itemCfg.daySellMaxNum - xRoleItem.getSellnum();
/* 167 */             price = ShanghuiManager.calculatePrice(xShangHuiItem.getOrginalprice(), xShangHuiItem.getRiserate());
/* 168 */             rise = xShangHuiItem.getRiserate();
/* 169 */             totalNum++;
/*     */ 
/*     */ 
/*     */           }
/* 173 */           else if (itemCfg.isPriceFlow)
/*     */           {
/* 175 */             SRecommandPriceCfg recommandPriceCfg = ShanghuiManager.getRecommandCfg(this.itemId, serverLevel);
/* 176 */             if (recommandPriceCfg != null)
/*     */             {
/*     */ 
/* 179 */               int recommandPrice = recommandPriceCfg.recommandPrice;
/* 180 */               float p = (curPrice - recommandPrice) / recommandPrice;
/* 181 */               SPriceFlowFormulaCfg priceFlowFormulaCfg = SPriceFlowFormulaCfg.get(itemCfg.priceFlowFormulaId);
/* 182 */               double m = priceFlowFormulaCfg.offsetMinM;
/* 183 */               double y = priceFlowFormulaCfg.fallParamY;
/* 184 */               double z = priceFlowFormulaCfg.fallFormulaScallParamZ;
/* 185 */               double ajust = priceFlowFormulaCfg.fallFormulaAjustParam;
/* 186 */               double sqrtTime = priceFlowFormulaCfg.sqrtTime2;
/*     */               double sellAddRate;
/* 188 */               double sellAddRate; if (p > 0.0F) {
/* 189 */                 sellAddRate = (float)(y * Math.pow(p * ajust - m, sqrtTime) * z);
/*     */               } else {
/* 191 */                 sellAddRate = (float)(y * Math.pow(p - m, sqrtTime) * z);
/*     */               }
/* 193 */               xShangHuiItem.setRiserate((int)(xShangHuiItem.getRiserate() - sellAddRate * ShanghuiManager.BASE_RATE));
/*     */             }
/*     */           } else {
/* 196 */             ModMoneyResult modMoneyResult = RoleInterface.addGoldWithinMax(this.roleId, sellPrice, new TLogArg(LogReason.SHANGHUI_SELL_REM, this.itemId));
/* 197 */             if (!modMoneyResult.isSucceed()) {
/* 198 */               if (modMoneyResult.getRes() != ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT) break;
/* 199 */               SCommonResultRes result = new SCommonResultRes();
/* 200 */               result.res = 50;
/* 201 */               OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/* 202 */               break;
/*     */             }
/*     */             
/* 205 */             totalMoney += sellPrice;
/* 206 */             canSellNum = itemCfg.daySellMaxNum - xRoleItem.getSellnum();
/* 207 */             price = ShanghuiManager.calculatePrice(xShangHuiItem.getOrginalprice(), xShangHuiItem.getRiserate());
/* 208 */             rise = xShangHuiItem.getRiserate();
/* 209 */             totalNum++;
/*     */           }
/*     */         } } }
/* 212 */     if (totalNum > 0) {
/* 213 */       SSellItemRes res = new SSellItemRes();
/* 214 */       res.cansellnum = canSellNum;
/* 215 */       res.earngold = totalMoney;
/* 216 */       ShoppingItem shoppingItem = new ShoppingItem();
/* 217 */       shoppingItem.itemid = this.itemId;
/* 218 */       shoppingItem.price = price;
/* 219 */       shoppingItem.rise = rise;
/* 220 */       res.iteminfo = shoppingItem;
/* 221 */       OnlineManager.getInstance().send(this.roleId, res);
/*     */     }
/*     */     
/* 224 */     return true;
/*     */   }
/*     */   
/*     */   private void sendErrMsg(int errorCode) {
/* 228 */     SCommonResultRes res = new SCommonResultRes();
/* 229 */     res.res = errorCode;
/* 230 */     OnlineManager.getInstance().sendAtOnce(this.roleId, res);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\PSellItemAllReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */