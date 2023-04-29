/*     */ package mzm.gsp.shanghui.main;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
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
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.yuanbao.main.CurrencyType;
/*     */ import xbean.Item;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleShangHuiBean;
/*     */ import xbean.RoleShangHuiItem;
/*     */ import xbean.ShangHuiItem;
/*     */ import xtable.Role2shanghui;
/*     */ import xtable.Shanghui;
/*     */ 
/*     */ public class PBuyItemReqMulti
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int itemId;
/*     */   private int itemNum;
/*     */   private long curGold;
/*     */   
/*     */   public PBuyItemReqMulti(long roleId, int itemId, int itemNum, long curGold)
/*     */   {
/*  45 */     this.roleId = roleId;
/*  46 */     this.itemNum = itemNum;
/*  47 */     this.itemId = itemId;
/*  48 */     this.curGold = curGold;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  54 */     if (!canBuyBFLock())
/*     */     {
/*     */ 
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     RoleShangHuiItem xRoleItem = getXRoleShangItemDataIfAbsent();
/*     */     
/*  62 */     ShangHuiItem xShangHuiItem = Shanghui.get(Long.valueOf(GameServerInfoManager.toGlobalId(this.itemId)));
/*  63 */     if (xShangHuiItem == null)
/*     */     {
/*  65 */       ShanghuiManager.logDebug("PBuyItemReq.processImp@shanghui xdb not have item|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId) });
/*  66 */       return false;
/*     */     }
/*  68 */     SShangHuiItemToolsCfg itemCfg = ShanghuiManager.getShangHuiItemCfg(this.itemId);
/*  69 */     if (itemCfg == null)
/*     */     {
/*  71 */       return false;
/*     */     }
/*  73 */     return buyItem(xRoleItem, xShangHuiItem, itemCfg, getCanAddItemNum(this.itemNum, xRoleItem.getBuynum(), itemCfg.dayBuyMaxNum, itemCfg.isPriceFlow));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean buyItem(RoleShangHuiItem xRoleItem, ShangHuiItem xShangHuiItem, SShangHuiItemToolsCfg itemCfg, int canAddItemNum)
/*     */   {
/*  89 */     if (canAddItemNum <= 0)
/*     */     {
/*  91 */       return false;
/*     */     }
/*  93 */     if (itemCfg.isPriceFlow)
/*     */     {
/*  95 */       return buyFlowItems(itemCfg, xRoleItem, xShangHuiItem, canAddItemNum);
/*     */     }
/*  97 */     return buyFixItems(xRoleItem, xShangHuiItem, itemCfg, canAddItemNum);
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean buyFixItems(RoleShangHuiItem xRoleItem, ShangHuiItem xShangHuiItem, SShangHuiItemToolsCfg itemCfg, int canAddItemNum)
/*     */   {
/* 103 */     if ((itemCfg == null) || (itemCfg.isPriceFlow))
/*     */     {
/* 105 */       return false;
/*     */     }
/* 107 */     int totalPrice = xShangHuiItem.getOrginalprice() * canAddItemNum;
/* 108 */     long ownGold = RoleInterface.getGold(this.roleId);
/* 109 */     if (ownGold < totalPrice)
/*     */     {
/* 111 */       canAddItemNum = (int)ownGold / xShangHuiItem.getOrginalprice();
/* 112 */       totalPrice = xShangHuiItem.getOrginalprice() * canAddItemNum;
/*     */     }
/* 114 */     if (canAddItemNum <= 0)
/*     */     {
/*     */ 
/* 117 */       sendErrMsg(3);
/* 118 */       return false;
/*     */     }
/* 120 */     TLogArg arg = new TLogArg(LogReason.SHANGHUI_BUY_ADD, this.itemId);
/* 121 */     arg.addCurrencytype2num(CurrencyType.CURRENCY_GOLD, Integer.valueOf(-totalPrice));
/* 122 */     if (!RoleInterface.cutGold(this.roleId, totalPrice, arg))
/*     */     {
/* 124 */       sendErrMsg(3);
/* 125 */       return false;
/*     */     }
/* 127 */     List<Item> xItems = ItemInterface.createXItem(this.itemId, canAddItemNum, null, false);
/* 128 */     if (xItems.size() == 0)
/*     */     {
/* 130 */       return false;
/*     */     }
/* 132 */     ItemOperateResult result = ItemInterface.addItem(this.roleId, xItems, true, arg);
/* 133 */     if (!result.success())
/*     */     {
/* 135 */       sendErrMsg(4);
/* 136 */       return false;
/*     */     }
/* 138 */     xRoleItem.setBuynum(xRoleItem.getBuynum() + canAddItemNum);
/*     */     
/*     */ 
/* 141 */     buyItemsSucNotice(this.itemId, xShangHuiItem, itemCfg.dayBuyMaxNum - xRoleItem.getBuynum(), canAddItemNum, totalPrice);
/* 142 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private RoleShangHuiItem getXRoleShangItemDataIfAbsent()
/*     */   {
/* 154 */     RoleShangHuiBean xRoleShangHuiBean = Role2shanghui.get(Long.valueOf(this.roleId));
/* 155 */     if (xRoleShangHuiBean == null)
/*     */     {
/* 157 */       Role2shanghui.add(Long.valueOf(this.roleId), xRoleShangHuiBean = Pod.newRoleShangHuiBean());
/*     */     }
/* 159 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 160 */     if (!ShanghuiManager.isSameDay(now, xRoleShangHuiBean.getTimestamp()))
/*     */     {
/* 162 */       xRoleShangHuiBean.setTimestamp(now);
/* 163 */       xRoleShangHuiBean.getItemmap().clear();
/*     */     }
/* 165 */     RoleShangHuiItem xRoleItem = (RoleShangHuiItem)xRoleShangHuiBean.getItemmap().get(Integer.valueOf(this.itemId));
/* 166 */     if (xRoleItem == null)
/*     */     {
/* 168 */       xRoleShangHuiBean.getItemmap().put(Integer.valueOf(this.itemId), xRoleItem = Pod.newRoleShangHuiItem());
/*     */     }
/* 170 */     return xRoleItem;
/*     */   }
/*     */   
/*     */   private boolean canBuyBFLock()
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 176 */     if (!ShanghuiManager.isShangHuiSwitchOpenForRole(this.roleId))
/*     */     {
/* 178 */       return false;
/*     */     }
/*     */     
/* 181 */     int level = RoleInterface.getLevel(this.roleId);
/* 182 */     if (level < SShangHuiConsts.getInstance().OPEN_LEVEL)
/*     */     {
/* 184 */       return false;
/*     */     }
/*     */     
/* 187 */     if (RoleInterface.getGold(this.roleId) != this.curGold)
/*     */     {
/* 189 */       ShanghuiManager.logDebug("PBuyItemReq.canBuyBFLock@role gold not equals|roleid=%d|curgold=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.curGold) });
/* 190 */       return false;
/*     */     }
/*     */     
/* 193 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.SHANGHUI.value, this.itemId))
/*     */     {
/* 195 */       String itemName = ItemInterface.getItemName(this.itemId);
/* 196 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, itemName);
/* 197 */       return false;
/*     */     }
/*     */     
/* 200 */     if (!ShanghuiManager.isShangHuiOpenSubTypeItem(this.roleId, this.itemId))
/*     */     {
/* 202 */       ShanghuiManager.logDebug("PBuyItemReq.canBuyBFLock@funtion not open!|roleid=%d|itemId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId) });
/* 203 */       return false;
/*     */     }
/*     */     
/* 206 */     if (this.itemNum <= 0)
/*     */     {
/* 208 */       ShanghuiManager.logDebug("PBuyItemReq.canBuyBFLock@itemNum error!|roleid=%d|itemNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemNum) });
/* 209 */       return false;
/*     */     }
/* 211 */     return true;
/*     */   }
/*     */   
/*     */   private void sendErrMsg(int errCode)
/*     */   {
/* 216 */     SCommonResultRes res = new SCommonResultRes();
/* 217 */     res.res = errCode;
/* 218 */     OnlineManager.getInstance().sendAtOnce(this.roleId, res);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean buyFlowItems(SShangHuiItemToolsCfg itemCfg, RoleShangHuiItem xRoleItem, ShangHuiItem xShangHuiItem, int canAddItemNum)
/*     */   {
/* 233 */     if ((itemCfg == null) || (!itemCfg.isPriceFlow))
/*     */     {
/* 235 */       return false;
/*     */     }
/* 237 */     SRecommandPriceCfg recommandPriceCfg = ShanghuiManager.getRecommandCfg(this.itemId, ServerInterface.getCurrentServerLevel());
/* 238 */     if (recommandPriceCfg == null)
/*     */     {
/* 240 */       return false;
/*     */     }
/* 242 */     MultiBuyFlowItemInfo calRes = new MultiBuyFlowItemInfo(canAddItemNum, recommandPriceCfg.recommandPrice, xShangHuiItem.getRiserate(), xShangHuiItem.getOrginalprice(), itemCfg.maxPrice, SPriceFlowFormulaCfg.get(itemCfg.priceFlowFormulaId), RoleInterface.getGold(this.roleId));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 247 */     calRes.doCal();
/* 248 */     if (calRes.getErrorCode() != -1)
/*     */     {
/* 250 */       sendErrMsg(calRes.getErrorCode());
/* 251 */       return false;
/*     */     }
/*     */     
/* 254 */     if (!addFlowItems(calRes))
/*     */     {
/*     */ 
/* 257 */       return false;
/*     */     }
/*     */     
/* 260 */     if (!payPrice(calRes.getNeedGold()))
/*     */     {
/*     */ 
/* 263 */       return false;
/*     */     }
/*     */     
/* 266 */     xRoleItem.setBuynum(xRoleItem.getBuynum() + calRes.getCanBuyItemNum());
/*     */     
/* 268 */     xShangHuiItem.setRiserate(calRes.getFinalRiseRate());
/*     */     
/*     */ 
/* 271 */     buyItemsSucNotice(this.itemId, xShangHuiItem, itemCfg.dayBuyMaxNum - xRoleItem.getBuynum(), calRes.getCanBuyItemNum(), calRes.getNeedGold());
/*     */     
/* 273 */     return true;
/*     */   }
/*     */   
/*     */   private boolean addFlowItems(MultiBuyFlowItemInfo calRes)
/*     */   {
/* 278 */     TLogArg arg = new TLogArg(LogReason.SHANGHUI_BUY_ADD, this.itemId);
/* 279 */     arg.addCurrencytype2num(CurrencyType.CURRENCY_GOLD, Integer.valueOf(-calRes.getNeedGold()));
/* 280 */     boolean r = ItemInterface.addMultiShanghuiItem(this.roleId, this.itemId, calRes.get_prices(), arg);
/* 281 */     if (!r)
/*     */     {
/* 283 */       return false;
/*     */     }
/* 285 */     return true;
/*     */   }
/*     */   
/*     */   private void buyItemsSucNotice(int shopItemId, ShangHuiItem xShangHuiItem, int canBuyNum, int buyItemNum, int costGold)
/*     */   {
/* 290 */     SBuyItemRes res = new SBuyItemRes();
/* 291 */     res.buynum = buyItemNum;
/* 292 */     res.canbuynum = canBuyNum;
/* 293 */     res.costgold = costGold;
/* 294 */     fillShoppingInfo(this.itemId, xShangHuiItem, res.iteminfo);
/* 295 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */   }
/*     */   
/*     */   private void fillShoppingInfo(int shopItemId, ShangHuiItem xShangHuiItem, ShoppingItem shoppingItem)
/*     */   {
/* 300 */     shoppingItem.itemid = shopItemId;
/* 301 */     shoppingItem.price = ShanghuiManager.calculatePrice(xShangHuiItem.getOrginalprice(), xShangHuiItem.getRiserate());
/* 302 */     shoppingItem.rise = xShangHuiItem.getRiserate();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean payPrice(int totalPrice)
/*     */   {
/* 313 */     TLogArg arg = new TLogArg(LogReason.SHANGHUI_BUY_ADD, this.itemId);
/* 314 */     arg.addCurrencytype2num(CurrencyType.CURRENCY_GOLD, Integer.valueOf(-totalPrice));
/* 315 */     if (RoleInterface.cutGold(this.roleId, totalPrice, arg))
/*     */     {
/* 317 */       return true;
/*     */     }
/*     */     
/* 320 */     sendErrMsg(3);
/* 321 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getCanAddItemNum(int wantNum, int alreadyBuyNum, int canBuyMaxNum, boolean isPriceFlow)
/*     */   {
/* 334 */     if (wantNum <= 0)
/*     */     {
/* 336 */       return 0;
/*     */     }
/*     */     
/* 339 */     if (alreadyBuyNum + this.itemNum > canBuyMaxNum)
/*     */     {
/* 341 */       if (this.itemNum > 1)
/*     */       {
/* 343 */         sendErrMsg(7);
/*     */       }
/*     */       else
/*     */       {
/* 347 */         sendErrMsg(1);
/*     */       }
/* 349 */       return 0;
/*     */     }
/*     */     
/* 352 */     if (ItemInterface.computeCanAddItemNum(this.roleId, this.itemId, wantNum) != wantNum)
/*     */     {
/* 354 */       sendErrMsg(8);
/* 355 */       return 0;
/*     */     }
/*     */     
/* 358 */     if (ItemInterface.getCanAddItemNum(this.roleId, this.itemId, wantNum, true).intValue() != wantNum)
/*     */     {
/* 360 */       sendErrMsg(4);
/* 361 */       return 0;
/*     */     }
/* 363 */     return wantNum;
/*     */   }
/*     */   
/*     */ 
/*     */   private final class MultiBuyFlowItemInfo
/*     */   {
/*     */     private final int _num;
/*     */     private final int _recommandPrice;
/*     */     private final int _maxCfgPrice;
/*     */     private final SPriceFlowFormulaCfg _formulaCfg;
/*     */     private final long _ownGold;
/*     */     private final int _orgDayPrice;
/*     */     private final int _orgRiseRate;
/*     */     int finalRiseRate;
/*     */     
/*     */     MultiBuyFlowItemInfo(int num, int recommandPrice, int curRiseRate, int orgPrice, int maxCfgPrice, SPriceFlowFormulaCfg formulaCfg, long ownGold)
/*     */     {
/* 380 */       this._num = num;
/* 381 */       this._recommandPrice = recommandPrice;
/* 382 */       this._maxCfgPrice = maxCfgPrice;
/* 383 */       this._formulaCfg = formulaCfg;
/* 384 */       this._ownGold = ownGold;
/* 385 */       this._orgDayPrice = orgPrice;
/* 386 */       this._orgRiseRate = curRiseRate;
/*     */       
/* 388 */       this.finalRiseRate = curRiseRate;
/*     */     }
/*     */     
/*     */ 
/* 392 */     int needGold = 0;
/* 393 */     List<Integer> _prices = new ArrayList();
/* 394 */     int orgPrice = -1;
/*     */     
/* 396 */     int errCode = -1;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     void doCal()
/*     */     {
/* 403 */       for (int i = 0; i < this._num; i++)
/*     */       {
/* 405 */         if (this.finalRiseRate > SShangHuiConsts.getInstance().SHOW_ALL_SELLED_MORE_THAN_ORG_PRICE_RATE)
/*     */         {
/* 407 */           if (i != 0) {
/*     */             break;
/*     */           }
/* 410 */           this.errCode = 0; break;
/*     */         }
/*     */         
/*     */ 
/* 414 */         double buyRate = 1.0D;
/* 415 */         if (this.finalRiseRate >= SShangHuiConsts.getInstance().PRICE_DAY_MAX_FLOW_LIMIT)
/*     */         {
/* 417 */           buyRate = SShangHuiConsts.getInstance().STOP_RISE_BUY_RATE;
/*     */         }
/* 419 */         int curPrice = (int)(this._orgDayPrice * (this.finalRiseRate + ShanghuiManager.BASE_RATE) / ShanghuiManager.BASE_RATE);
/* 420 */         int buyPrice = (int)(curPrice * buyRate);
/*     */         
/* 422 */         int desbuyprice = buyPrice;
/* 423 */         if (buyPrice > this._maxCfgPrice)
/*     */         {
/* 425 */           desbuyprice = this._maxCfgPrice;
/*     */         }
/* 427 */         if (this.orgPrice < 0)
/*     */         {
/* 429 */           this.orgPrice = desbuyprice;
/*     */         }
/* 431 */         if (this.needGold + desbuyprice > this._ownGold)
/*     */         {
/*     */ 
/* 434 */           if (i != 0) {
/*     */             break;
/*     */           }
/* 437 */           this.errCode = 3; break;
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 443 */         this.needGold += desbuyprice;
/*     */         
/* 445 */         this._prices.add(Integer.valueOf(desbuyprice));
/*     */         
/* 447 */         calFinalRiseRate(curPrice, buyPrice);
/*     */       }
/*     */       
/* 450 */       printCurrentBuyItemInfo();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public List<Integer> get_prices()
/*     */     {
/* 460 */       return this._prices;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public int getCanBuyItemNum()
/*     */     {
/* 470 */       return get_prices().size();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public int getFinalRiseRate()
/*     */     {
/* 480 */       return this.finalRiseRate;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public int getNeedGold()
/*     */     {
/* 490 */       return this.needGold;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public int getErrorCode()
/*     */     {
/* 500 */       return this.errCode;
/*     */     }
/*     */     
/*     */     private void calFinalRiseRate(int curPrice, int buyPrice)
/*     */     {
/* 505 */       if (buyPrice > this._maxCfgPrice)
/*     */       {
/* 507 */         return;
/*     */       }
/* 509 */       float p = (curPrice - this._recommandPrice) / this._recommandPrice;
/* 510 */       double n = this._formulaCfg.offsetMaxLimitN;
/* 511 */       double sqrt = this._formulaCfg.sqrtTime1;
/* 512 */       double z = this._formulaCfg.riseFormulaScaleParamZ;
/* 513 */       double ajust = this._formulaCfg.riseFormulaAjustParam;
/* 514 */       double x = this._formulaCfg.riseParamX;
/*     */       float buyAddRate;
/* 516 */       float buyAddRate; if (p < 0.0F)
/*     */       {
/* 518 */         buyAddRate = (float)(x * Math.pow(n - p * ajust, sqrt) * z);
/*     */       }
/*     */       else
/*     */       {
/* 522 */         buyAddRate = (float)(x * Math.pow(n - p, sqrt) * z);
/*     */       }
/* 524 */       this.finalRiseRate = ((int)(this.finalRiseRate + buyAddRate * (float)ShanghuiManager.BASE_RATE));
/*     */     }
/*     */     
/*     */     private void printCurrentBuyItemInfo()
/*     */     {
/* 529 */       ShanghuiManager.logInfo("[shanghui]MultiBuyFlowItemInfo.printCurrentBuyItemInfo@ buy shang hui items!|roleId=%d|itemId=%d|wantItemNum=%d|finalBuyNum=%d|totalCostGold=%d|orgPrice=%d|orgPriceRate=%d|finalRise=%d|costList=%s", new Object[] { Long.valueOf(PBuyItemReqMulti.this.roleId), Integer.valueOf(PBuyItemReqMulti.this.itemId), Integer.valueOf(PBuyItemReqMulti.this.itemNum), Integer.valueOf(getCanBuyItemNum()), Integer.valueOf(getNeedGold()), Integer.valueOf(this.orgPrice), Integer.valueOf(this._orgRiseRate), Integer.valueOf(getFinalRiseRate()), get_prices().toString() });
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\PBuyItemReqMulti.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */