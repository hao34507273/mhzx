/*     */ package mzm.gsp.shanghui.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.shanghui.SBuyItemRes;
/*     */ import mzm.gsp.shanghui.SCommonResultRes;
/*     */ import mzm.gsp.shanghui.ShoppingItem;
/*     */ import mzm.gsp.shanghui.confbean.SPriceFlowFormulaCfg;
/*     */ import mzm.gsp.shanghui.confbean.SRecommandPriceCfg;
/*     */ import mzm.gsp.shanghui.confbean.SShangHuiConsts;
/*     */ import mzm.gsp.shanghui.confbean.SShangHuiItemToolsCfg;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.yuanbao.main.CurrencyType;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleShangHuiBean;
/*     */ import xbean.RoleShangHuiItem;
/*     */ import xbean.ShangHuiItem;
/*     */ import xtable.Role2shanghui;
/*     */ 
/*     */ public class PGMShanghuiBuyItems extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int itemId;
/*     */   
/*     */   public PGMShanghuiBuyItems(long roleId, int itemId)
/*     */   {
/*  30 */     this.roleId = roleId;
/*  31 */     this.itemId = itemId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     int level = RoleInterface.getLevel(this.roleId);
/*  39 */     if (level < SShangHuiConsts.getInstance().OPEN_LEVEL) {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     RoleShangHuiBean xRoleShangHuiBean = Role2shanghui.get(Long.valueOf(this.roleId));
/*  44 */     long key = mzm.gsp.GameServerInfoManager.toGlobalId(this.itemId);
/*  45 */     ShangHuiItem xShangHuiItem = xtable.Shanghui.get(Long.valueOf(key));
/*  46 */     if (xShangHuiItem == null) {
/*  47 */       return false;
/*     */     }
/*  49 */     if (xRoleShangHuiBean == null) {
/*  50 */       xRoleShangHuiBean = Pod.newRoleShangHuiBean();
/*  51 */       Role2shanghui.add(Long.valueOf(this.roleId), xRoleShangHuiBean);
/*     */     }
/*  53 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  54 */     if (!ShanghuiManager.isSameDay(now, xRoleShangHuiBean.getTimestamp())) {
/*  55 */       xRoleShangHuiBean.setTimestamp(now);
/*  56 */       xRoleShangHuiBean.getItemmap().clear();
/*     */     }
/*  58 */     RoleShangHuiItem xRoleItem = (RoleShangHuiItem)xRoleShangHuiBean.getItemmap().get(Integer.valueOf(this.itemId));
/*  59 */     if (xRoleItem == null) {
/*  60 */       xRoleItem = Pod.newRoleShangHuiItem();
/*  61 */       xRoleShangHuiBean.getItemmap().put(Integer.valueOf(this.itemId), xRoleItem);
/*     */     }
/*     */     
/*  64 */     if (xShangHuiItem.getRiserate() > SShangHuiConsts.getInstance().SHOW_ALL_SELLED_MORE_THAN_ORG_PRICE_RATE) {
/*  65 */       sendErrMsg(0);
/*  66 */       return false;
/*     */     }
/*  68 */     SShangHuiItemToolsCfg itemCfg = ShanghuiManager.getShangHuiItemCfg(this.itemId);
/*  69 */     if (itemCfg == null) return false;
/*  70 */     if (xRoleItem.getBuynum() >= itemCfg.dayBuyMaxNum) {
/*  71 */       sendErrMsg(1);
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     double buyRate = 1.0D;
/*  76 */     if (xShangHuiItem.getRiserate() >= SShangHuiConsts.getInstance().PRICE_DAY_MAX_FLOW_LIMIT) {
/*  77 */       buyRate = SShangHuiConsts.getInstance().STOP_RISE_BUY_RATE;
/*     */     }
/*  79 */     int curPrice = (int)(xShangHuiItem.getOrginalprice() * (xShangHuiItem.getRiserate() + ShanghuiManager.BASE_RATE) / ShanghuiManager.BASE_RATE);
/*  80 */     int buyPrice = (int)(curPrice * buyRate);
/*     */     
/*  82 */     if (buyPrice > itemCfg.maxPrice) {
/*  83 */       buyPrice = itemCfg.maxPrice;
/*  84 */       if (!RoleInterface.cutGold(this.roleId, buyPrice, new TLogArg(LogReason.SHANGHUI_BUY_ADD, this.itemId))) {
/*  85 */         sendErrMsg(3);
/*  86 */         return false;
/*     */       }
/*  88 */       TLogArg arg = new TLogArg(LogReason.SHANGHUI_BUY_ADD, this.itemId);
/*  89 */       arg.addCurrencytype2num(CurrencyType.CURRENCY_GOLD, Integer.valueOf(-buyPrice));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  94 */       xRoleItem.setBuynum(xRoleItem.getBuynum() + 1);
/*  95 */       SBuyItemRes res = new SBuyItemRes();
/*  96 */       res.canbuynum = (itemCfg.dayBuyMaxNum - xRoleItem.getBuynum());
/*  97 */       res.costgold = buyPrice;
/*  98 */       OnlineManager.getInstance().send(this.roleId, res);
/*  99 */       return true;
/*     */     }
/* 101 */     if (!RoleInterface.cutGold(this.roleId, buyPrice, new TLogArg(LogReason.SHANGHUI_BUY_ADD, this.itemId))) {
/* 102 */       sendErrMsg(3);
/* 103 */       return false;
/*     */     }
/* 105 */     TLogArg arg = new TLogArg(LogReason.SHANGHUI_BUY_ADD, this.itemId);
/* 106 */     arg.addCurrencytype2num(CurrencyType.CURRENCY_GOLD, Integer.valueOf(-buyPrice));
/*     */     
/* 108 */     xRoleItem.setBuynum(xRoleItem.getBuynum() + 1);
/* 109 */     if (itemCfg.isPriceFlow) {
/* 110 */       int serverLevel = mzm.gsp.server.main.ServerInterface.getCurrentServerLevel();
/* 111 */       SRecommandPriceCfg recommandPriceCfg = ShanghuiManager.getRecommandCfg(this.itemId, serverLevel);
/* 112 */       if (recommandPriceCfg == null) {
/* 113 */         return false;
/*     */       }
/* 115 */       int recommandPrice = recommandPriceCfg.recommandPrice;
/* 116 */       float p = (curPrice - recommandPrice) / recommandPrice;
/* 117 */       SPriceFlowFormulaCfg priceFlowFormulaCfg = SPriceFlowFormulaCfg.get(itemCfg.priceFlowFormulaId);
/* 118 */       double n = priceFlowFormulaCfg.offsetMaxLimitN;
/* 119 */       double sqrt = priceFlowFormulaCfg.sqrtTime1;
/* 120 */       double z = priceFlowFormulaCfg.riseFormulaScaleParamZ;
/* 121 */       double ajust = priceFlowFormulaCfg.riseFormulaAjustParam;
/* 122 */       double x = priceFlowFormulaCfg.riseParamX;
/*     */       float buyAddRate;
/* 124 */       float buyAddRate; if (p < 0.0F) {
/* 125 */         buyAddRate = (float)(x * Math.pow(n - p * ajust, sqrt) * z);
/*     */       } else {
/* 127 */         buyAddRate = (float)(x * Math.pow(n - p, sqrt) * z);
/*     */       }
/* 129 */       xShangHuiItem.setRiserate((int)(xShangHuiItem.getRiserate() + buyAddRate * (float)ShanghuiManager.BASE_RATE));
/*     */     }
/* 131 */     SBuyItemRes res = new SBuyItemRes();
/* 132 */     res.canbuynum = (itemCfg.dayBuyMaxNum - xRoleItem.getBuynum());
/* 133 */     res.costgold = buyPrice;
/* 134 */     ShoppingItem shoppingItem = new ShoppingItem();
/* 135 */     shoppingItem.itemid = this.itemId;
/* 136 */     shoppingItem.price = ShanghuiManager.calculatePrice(xShangHuiItem.getOrginalprice(), xShangHuiItem.getRiserate());
/* 137 */     shoppingItem.rise = xShangHuiItem.getRiserate();
/* 138 */     res.iteminfo = shoppingItem;
/* 139 */     OnlineManager.getInstance().send(this.roleId, res);
/* 140 */     ShanghuiManager.logInfo("PGMShanghuiBuyItems.processImp@gm shanghui buy|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId) });
/* 141 */     return true;
/*     */   }
/*     */   
/*     */   private void sendErrMsg(int errCode) {
/* 145 */     SCommonResultRes res = new SCommonResultRes();
/* 146 */     res.res = errCode;
/* 147 */     OnlineManager.getInstance().sendAtOnce(this.roleId, res);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\PGMShanghuiBuyItems.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */