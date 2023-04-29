/*     */ package mzm.gsp.shanghui.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.shanghui.SBuyItemRes;
/*     */ import mzm.gsp.shanghui.SCommonResultRes;
/*     */ import mzm.gsp.shanghui.ShoppingItem;
/*     */ import mzm.gsp.shanghui.confbean.SPriceFlowFormulaCfg;
/*     */ import mzm.gsp.shanghui.confbean.SRecommandPriceCfg;
/*     */ import mzm.gsp.shanghui.confbean.SShangHuiConsts;
/*     */ import mzm.gsp.shanghui.confbean.SShangHuiItemToolsCfg;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.Item;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleShangHuiBean;
/*     */ import xbean.RoleShangHuiItem;
/*     */ import xbean.ShangHuiItem;
/*     */ import xtable.Role2shanghui;
/*     */ 
/*     */ public class PBuyItemReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int itemId;
/*     */   private int itemNum;
/*     */   private long curGold;
/*     */   
/*     */   public PBuyItemReq(long roleId, int itemId, int itemNum, long curGold)
/*     */   {
/*  38 */     this.roleId = roleId;
/*  39 */     this.itemNum = itemNum;
/*  40 */     this.itemId = itemId;
/*  41 */     this.curGold = curGold;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     if (!ShanghuiManager.isShangHuiSwitchOpenForRole(this.roleId)) {
/*  48 */       return false;
/*     */     }
/*  50 */     int serverLevel = ServerInterface.getCurrentServerLevel();
/*     */     
/*  52 */     int level = RoleInterface.getLevel(this.roleId);
/*  53 */     if (level < SShangHuiConsts.getInstance().OPEN_LEVEL) {
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     if (RoleInterface.getGold(this.roleId) != this.curGold) {
/*  58 */       ShanghuiManager.logDebug("PBuyItemReq.processImp@role gold not equals|roleid=%d|curgold=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.curGold) });
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.SHANGHUI.value, this.itemId)) {
/*  63 */       String itemName = ItemInterface.getItemName(this.itemId);
/*  64 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, itemName);
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     if (!ShanghuiManager.isShangHuiOpenSubTypeItem(this.roleId, this.itemId)) {
/*  69 */       ShanghuiManager.logDebug("PBuyItemReq.processImp@funtion not open!|roleid=%d|itemId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId) });
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     if (this.itemNum <= 0) {
/*  74 */       ShanghuiManager.logDebug("PBuyItemReq.processImp@itemNum error!|roleid=%d|itemNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemNum) });
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     RoleShangHuiBean xRoleShangHuiBean = Role2shanghui.get(Long.valueOf(this.roleId));
/*  79 */     long key = GameServerInfoManager.toGlobalId(this.itemId);
/*  80 */     ShangHuiItem xShangHuiItem = xtable.Shanghui.get(Long.valueOf(key));
/*  81 */     if (xShangHuiItem == null) {
/*  82 */       ShanghuiManager.logDebug("PBuyItemReq.processImp@shanghui xdb not have item|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId) });
/*  83 */       return false;
/*     */     }
/*  85 */     if (xRoleShangHuiBean == null) {
/*  86 */       xRoleShangHuiBean = Pod.newRoleShangHuiBean();
/*  87 */       Role2shanghui.add(Long.valueOf(this.roleId), xRoleShangHuiBean);
/*     */     }
/*  89 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  90 */     if (!ShanghuiManager.isSameDay(now, xRoleShangHuiBean.getTimestamp())) {
/*  91 */       xRoleShangHuiBean.setTimestamp(now);
/*  92 */       xRoleShangHuiBean.getItemmap().clear();
/*     */     }
/*  94 */     RoleShangHuiItem xRoleItem = (RoleShangHuiItem)xRoleShangHuiBean.getItemmap().get(Integer.valueOf(this.itemId));
/*  95 */     if (xRoleItem == null) {
/*  96 */       xRoleItem = Pod.newRoleShangHuiItem();
/*  97 */       xRoleShangHuiBean.getItemmap().put(Integer.valueOf(this.itemId), xRoleItem);
/*     */     }
/*     */     
/* 100 */     if (xShangHuiItem.getRiserate() > SShangHuiConsts.getInstance().SHOW_ALL_SELLED_MORE_THAN_ORG_PRICE_RATE) {
/* 101 */       sendErrMsg(0);
/* 102 */       ShanghuiManager.logDebug("PBuyItemReq.processImp@shanghui item sell max|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId) });
/* 103 */       return false;
/*     */     }
/* 105 */     SShangHuiItemToolsCfg itemCfg = ShanghuiManager.getShangHuiItemCfg(this.itemId);
/*     */     
/* 107 */     if (itemCfg == null)
/* 108 */       return false;
/* 109 */     if ((itemCfg.isPriceFlow) && (this.itemNum > 1)) {
/* 110 */       return false;
/*     */     }
/* 112 */     if (xRoleItem.getBuynum() + this.itemNum > itemCfg.dayBuyMaxNum) {
/* 113 */       if (this.itemNum > 1) {
/* 114 */         sendErrMsg(7);
/*     */       } else {
/* 116 */         sendErrMsg(1);
/*     */       }
/* 118 */       ShanghuiManager.logDebug("PBuyItemReq.processImp@role buy item max today|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId) });
/* 119 */       return false;
/*     */     }
/*     */     
/* 122 */     double buyRate = 1.0D;
/* 123 */     if (xShangHuiItem.getRiserate() >= SShangHuiConsts.getInstance().PRICE_DAY_MAX_FLOW_LIMIT) {
/* 124 */       buyRate = SShangHuiConsts.getInstance().STOP_RISE_BUY_RATE;
/*     */     }
/* 126 */     int curPrice = (int)(xShangHuiItem.getOrginalprice() * (xShangHuiItem.getRiserate() + ShanghuiManager.BASE_RATE) / ShanghuiManager.BASE_RATE);
/* 127 */     int buyPrice = (int)(curPrice * buyRate);
/*     */     
/* 129 */     int desbuyprice = buyPrice;
/* 130 */     if (buyPrice > itemCfg.maxPrice) {
/* 131 */       desbuyprice = itemCfg.maxPrice;
/*     */     }
/*     */     
/* 134 */     int totalPrice = desbuyprice * this.itemNum;
/*     */     
/* 136 */     TLogArg arg = new TLogArg(mzm.gsp.tlog.LogReason.SHANGHUI_BUY_ADD, this.itemId);
/* 137 */     arg.addCurrencytype2num(mzm.gsp.yuanbao.main.CurrencyType.CURRENCY_GOLD, Integer.valueOf(-totalPrice));
/* 138 */     if (!RoleInterface.cutGold(this.roleId, totalPrice, arg)) {
/* 139 */       sendErrMsg(3);
/* 140 */       return false;
/*     */     }
/*     */     
/* 143 */     if (itemCfg.isPriceFlow)
/*     */     {
/* 145 */       boolean r = ItemInterface.addShanghuiItem(this.roleId, this.itemId, desbuyprice, arg);
/*     */       
/* 147 */       if (!r) {
/* 148 */         sendErrMsg(4);
/* 149 */         return false;
/*     */       }
/*     */     }
/*     */     else {
/* 153 */       List<Item> xItems = ItemInterface.createXItem(this.itemId, this.itemNum, null, false);
/* 154 */       if (xItems.size() == 0) {
/* 155 */         return false;
/*     */       }
/*     */       
/* 158 */       ItemOperateResult result = ItemInterface.addItem(this.roleId, xItems, true, arg);
/* 159 */       if (!result.success()) {
/* 160 */         sendErrMsg(4);
/* 161 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 165 */     xRoleItem.setBuynum(xRoleItem.getBuynum() + this.itemNum);
/*     */     
/* 167 */     if ((itemCfg.isPriceFlow) && (buyPrice <= itemCfg.maxPrice)) {
/* 168 */       SRecommandPriceCfg recommandPriceCfg = ShanghuiManager.getRecommandCfg(this.itemId, serverLevel);
/* 169 */       if (recommandPriceCfg == null) {
/* 170 */         return false;
/*     */       }
/* 172 */       int recommandPrice = recommandPriceCfg.recommandPrice;
/* 173 */       float p = (curPrice - recommandPrice) / recommandPrice;
/* 174 */       SPriceFlowFormulaCfg priceFlowFormulaCfg = SPriceFlowFormulaCfg.get(itemCfg.priceFlowFormulaId);
/* 175 */       double n = priceFlowFormulaCfg.offsetMaxLimitN;
/* 176 */       double sqrt = priceFlowFormulaCfg.sqrtTime1;
/* 177 */       double z = priceFlowFormulaCfg.riseFormulaScaleParamZ;
/* 178 */       double ajust = priceFlowFormulaCfg.riseFormulaAjustParam;
/* 179 */       double x = priceFlowFormulaCfg.riseParamX;
/*     */       float buyAddRate;
/* 181 */       float buyAddRate; if (p < 0.0F) {
/* 182 */         buyAddRate = (float)(x * Math.pow(n - p * ajust, sqrt) * z);
/*     */       } else {
/* 184 */         buyAddRate = (float)(x * Math.pow(n - p, sqrt) * z);
/*     */       }
/* 186 */       xShangHuiItem.setRiserate((int)(xShangHuiItem.getRiserate() + buyAddRate * (float)ShanghuiManager.BASE_RATE));
/*     */     }
/*     */     
/* 189 */     SBuyItemRes res = new SBuyItemRes();
/* 190 */     res.buynum = this.itemNum;
/* 191 */     res.canbuynum = (itemCfg.dayBuyMaxNum - xRoleItem.getBuynum());
/* 192 */     res.costgold = totalPrice;
/* 193 */     ShoppingItem shoppingItem = new ShoppingItem();
/* 194 */     shoppingItem.itemid = this.itemId;
/* 195 */     shoppingItem.price = ShanghuiManager.calculatePrice(xShangHuiItem.getOrginalprice(), xShangHuiItem.getRiserate());
/* 196 */     shoppingItem.rise = xShangHuiItem.getRiserate();
/* 197 */     res.iteminfo = shoppingItem;
/* 198 */     OnlineManager.getInstance().send(this.roleId, res);
/* 199 */     return true;
/*     */   }
/*     */   
/*     */   private void sendErrMsg(int errCode) {
/* 203 */     SCommonResultRes res = new SCommonResultRes();
/* 204 */     res.res = errCode;
/* 205 */     OnlineManager.getInstance().sendAtOnce(this.roleId, res);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\PBuyItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */