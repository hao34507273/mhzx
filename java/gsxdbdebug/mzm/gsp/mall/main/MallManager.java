/*      */ package mzm.gsp.mall.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.award.main.AwardInterface;
/*      */ import mzm.gsp.changemodelcard.confbean.SChangeModelCardConsts;
/*      */ import mzm.gsp.item.confbean.STokenType;
/*      */ import mzm.gsp.item.main.ItemBanTrade;
/*      */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*      */ import mzm.gsp.mall.MallItemInfo;
/*      */ import mzm.gsp.mall.SAllMallItemNum;
/*      */ import mzm.gsp.mall.SBuyItemErrorInfo;
/*      */ import mzm.gsp.mall.SSynJifen;
/*      */ import mzm.gsp.mall.confbean.PriceMaxbuynum;
/*      */ import mzm.gsp.mall.confbean.SExchangetype2ItemPrice;
/*      */ import mzm.gsp.mall.confbean.SMallTypeCfg;
/*      */ import mzm.gsp.mall.confbean.SMalltype2Item;
/*      */ import mzm.gsp.mall.confbean.SShimenExchangeItemCfg;
/*      */ import mzm.gsp.mall.event.JiFenChanged;
/*      */ import mzm.gsp.mall.event.JiFenChangedArg;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.petmark.confbean.SPetMarkConstants;
/*      */ import mzm.gsp.pk.confbean.SPKConsts;
/*      */ import mzm.gsp.qingfu.main.QingfuInterface;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.tlog.TlogUtil;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.yuanbao.main.CurrencyLogUtil;
/*      */ import mzm.gsp.yuanbao.main.CurrencyType;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.CoinInfo;
/*      */ import xbean.ItemBuyCount;
/*      */ import xbean.Jifen;
/*      */ import xbean.MallRefreshTime;
/*      */ import xbean.Pod;
/*      */ import xbean.Properties;
/*      */ import xbean.RoleLimitShop;
/*      */ import xtable.Malltype2refreshtime;
/*      */ import xtable.Role2itembuycount;
/*      */ import xtable.Role2jifen;
/*      */ import xtable.Role2limitshops;
/*      */ import xtable.Role2properties;
/*      */ 
/*      */ public class MallManager
/*      */ {
/*   56 */   static final Logger logger = Logger.getLogger("mall");
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*   61 */   static final Map<Integer, CurrentLimitShopRelation> CURRENT_LIMIT_SHOP = new HashMap();
/*      */   
/*      */ 
/*      */   static void init()
/*      */   {
/*   66 */     CURRENT_LIMIT_SHOP.put(Integer.valueOf(6), new CurrentLimitShopRelation(383, LogReason.DAILY_LIMIT_MALL, mzm.gsp.qingfu.main.CostType.COST_BIND_FIRST_MALL_BUY_DAILY_LIMIT_ITEM));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Set<Integer> getItemsBymalltype(int malltype)
/*      */   {
/*   77 */     return new HashSet(SMalltype2Item.get(malltype).itemid2pricenum.keySet());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getRefreshtimeByMalltype(int malltype)
/*      */   {
/*   88 */     return SMallTypeCfg.get(malltype).refreshtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getLimitItemMaxBuyNum(int malltype, int itemid)
/*      */   {
/*   99 */     PriceMaxbuynum p = (PriceMaxbuynum)SMalltype2Item.get(malltype).itemid2pricenum.get(Integer.valueOf(itemid));
/*      */     
/*  101 */     if (p == null)
/*      */     {
/*  103 */       return -1;
/*      */     }
/*  105 */     return p.maxbuynum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getJifenItemPrice(int jifenType, int itemid)
/*      */   {
/*  116 */     SExchangetype2ItemPrice exchangetype2ItemPrice = SExchangetype2ItemPrice.get(jifenType);
/*      */     
/*  118 */     if (exchangetype2ItemPrice == null)
/*      */     {
/*  120 */       return -1;
/*      */     }
/*  122 */     Integer p = (Integer)exchangetype2ItemPrice.itemid2price.get(Integer.valueOf(itemid));
/*  123 */     if (p == null)
/*      */     {
/*  125 */       return -1;
/*      */     }
/*  127 */     return p.intValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getLimitItemPrice(int malltype, int itemid)
/*      */   {
/*  138 */     PriceMaxbuynum p = (PriceMaxbuynum)SMalltype2Item.get(malltype).itemid2pricenum.get(Integer.valueOf(itemid));
/*      */     
/*  140 */     if (p == null)
/*      */     {
/*  142 */       return -1;
/*      */     }
/*  144 */     return p.price;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getPreciousItemPrice(int itemid)
/*      */   {
/*  156 */     PriceMaxbuynum p = (PriceMaxbuynum)SMalltype2Item.get(1).itemid2pricenum.get(Integer.valueOf(itemid));
/*      */     
/*  158 */     if (p == null)
/*      */     {
/*  160 */       return -1;
/*      */     }
/*  162 */     return p.price;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getItemPrice(int itemid)
/*      */   {
/*  173 */     Set<Integer> malltypeset = new HashSet(SMalltype2Item.getAll().keySet());
/*  174 */     malltypeset.remove(Integer.valueOf(2));
/*  175 */     malltypeset.removeAll(CURRENT_LIMIT_SHOP.keySet());
/*  176 */     for (Iterator i$ = malltypeset.iterator(); i$.hasNext();) { int malltype = ((Integer)i$.next()).intValue();
/*      */       
/*  178 */       PriceMaxbuynum p = (PriceMaxbuynum)SMalltype2Item.get(malltype).itemid2pricenum.get(Integer.valueOf(itemid));
/*  179 */       if (p != null)
/*      */       {
/*  181 */         return p.price;
/*      */       }
/*      */     }
/*  184 */     return -1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getFunctionItemPrice(int itemid)
/*      */   {
/*  196 */     PriceMaxbuynum p = (PriceMaxbuynum)SMalltype2Item.get(3).itemid2pricenum.get(Integer.valueOf(itemid));
/*      */     
/*  198 */     if (p == null)
/*      */     {
/*  200 */       return -1;
/*      */     }
/*  202 */     return p.price;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean addItemBuyCount(long roleid, int itemid, int count)
/*      */   {
/*  215 */     if (count <= 0)
/*      */     {
/*  217 */       return false;
/*      */     }
/*  219 */     ItemBuyCount itemBuyCount = Role2itembuycount.get(Long.valueOf(roleid));
/*  220 */     if (itemBuyCount == null)
/*      */     {
/*  222 */       itemBuyCount = Pod.newItemBuyCount();
/*  223 */       itemBuyCount.setCleartime(DateTimeUtils.getCurrTimeInMillis());
/*  224 */       Role2itembuycount.insert(Long.valueOf(roleid), itemBuyCount);
/*      */     }
/*  226 */     Integer c = (Integer)itemBuyCount.getId2count().get(Integer.valueOf(itemid));
/*  227 */     if (c == null)
/*      */     {
/*  229 */       c = Integer.valueOf(0);
/*      */     }
/*  231 */     itemBuyCount.getId2count().put(Integer.valueOf(itemid), Integer.valueOf(c.intValue() + count));
/*  232 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean clearItemBuyCount(long roleid, long cleartime)
/*      */   {
/*  243 */     ItemBuyCount itemBuyCount = Role2itembuycount.get(Long.valueOf(roleid));
/*  244 */     if (itemBuyCount == null)
/*      */     {
/*  246 */       return false;
/*      */     }
/*  248 */     itemBuyCount.setCleartime(cleartime);
/*  249 */     itemBuyCount.getId2count().clear();
/*  250 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getItemBuycountCleartime(long roleid)
/*      */   {
/*  261 */     ItemBuyCount itemBuyCount = Role2itembuycount.select(Long.valueOf(roleid));
/*  262 */     if (itemBuyCount == null)
/*      */     {
/*  264 */       return 0L;
/*      */     }
/*  266 */     return itemBuyCount.getCleartime();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getItemBuyCount(long roleid, int itemid)
/*      */   {
/*  278 */     ItemBuyCount itemBuyCount = Role2itembuycount.get(Long.valueOf(roleid));
/*  279 */     if (itemBuyCount == null)
/*      */     {
/*  281 */       return 0;
/*      */     }
/*  283 */     Integer c = (Integer)itemBuyCount.getId2count().get(Integer.valueOf(itemid));
/*  284 */     if (c == null)
/*      */     {
/*  286 */       return 0;
/*      */     }
/*  288 */     return c.intValue();
/*      */   }
/*      */   
/*      */   static Map<Integer, Integer> getItemBuyCountMap(long roleid)
/*      */   {
/*  293 */     ItemBuyCount itemBuyCount = Role2itembuycount.get(Long.valueOf(roleid));
/*  294 */     if (itemBuyCount == null)
/*      */     {
/*  296 */       return new HashMap();
/*      */     }
/*  298 */     return itemBuyCount.getId2count();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static long getDefaultJifenByJifenType(int jifenType)
/*      */   {
/*  306 */     switch (jifenType)
/*      */     {
/*      */     case 7: 
/*  309 */       return SPKConsts.getInstance().INITIAL_MORAL_VALUE;
/*      */     case 9: 
/*  311 */       return SChangeModelCardConsts.getInstance().INIT_ESSENCE;
/*      */     case 10: 
/*  313 */       return SChangeModelCardConsts.getInstance().INIT_SCORE;
/*      */     case 15: 
/*  315 */       return SPetMarkConstants.getInstance().INIT_PET_MARK_SCORE1;
/*      */     case 16: 
/*  317 */       return SPetMarkConstants.getInstance().INIT_PET_MARK_SCORE2;
/*      */     }
/*  319 */     return 0L;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static long getJifenByJifenType(Jifen xJifen, int jifenType)
/*      */   {
/*  328 */     Long value = (Long)xJifen.getType2point().get(Integer.valueOf(jifenType));
/*  329 */     return value == null ? getDefaultJifenByJifenType(jifenType) : value.longValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static JifenOperateResult addJifen(long roleid, long jifennum, int jifenType, boolean isaddWhenTomax, TLogArg logArg)
/*      */   {
/*  344 */     if (jifennum <= 0L)
/*      */     {
/*  346 */       return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.ParamError, 0L);
/*      */     }
/*  348 */     if (!isJifentypeRight(jifenType))
/*      */     {
/*  350 */       return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.TypeInvalid, 0L);
/*      */     }
/*  352 */     Jifen xJifen = Role2jifen.get(Long.valueOf(roleid));
/*  353 */     if (xJifen == null)
/*      */     {
/*  355 */       xJifen = Pod.newJifen();
/*  356 */       Role2jifen.insert(Long.valueOf(roleid), xJifen);
/*      */     }
/*  358 */     long c = getJifenByJifenType(xJifen, jifenType);
/*  359 */     int max = AwardInterface.getTokenOwnMax(jifenType);
/*  360 */     long addnum = jifennum;
/*  361 */     if (c + jifennum > max)
/*      */     {
/*  363 */       if (isaddWhenTomax)
/*      */       {
/*  365 */         addnum = max - c;
/*  366 */         xJifen.getType2point().put(Integer.valueOf(jifenType), Long.valueOf(max));
/*  367 */         AwardInterface.sendNormalRet(roleid, 25, true, new String[] { AwardInterface.getTokenNameBy(jifenType) });
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*  372 */         return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.JifenToMax, 0L);
/*      */       }
/*      */       
/*      */     }
/*      */     else {
/*  377 */       xJifen.getType2point().put(Integer.valueOf(jifenType), Long.valueOf(jifennum + c));
/*      */     }
/*      */     
/*  380 */     CurrencyType currencyType = TlogUtil.getCurrencyTypeByTokentype(jifenType);
/*      */     
/*  382 */     logJifenAndTriggerEvent(roleid, jifenType, currencyType, addnum, ((Long)xJifen.getType2point().get(Integer.valueOf(jifenType))).longValue(), logArg);
/*      */     
/*  384 */     return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.Success, addnum);
/*      */   }
/*      */   
/*      */   private static boolean isJifentypeRight(int jifenType)
/*      */   {
/*  389 */     STokenType sTokenType = STokenType.get(jifenType);
/*  390 */     if (sTokenType == null)
/*      */     {
/*  392 */       return false;
/*      */     }
/*  394 */     if (sTokenType.fatherType != 1)
/*      */     {
/*  396 */       return false;
/*      */     }
/*      */     
/*  399 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static JifenOperateEnum addJifenForIdip(long roleid, long jifennum, int jifenType, TLogArg logArg)
/*      */   {
/*  413 */     if (!isJifentypeRight(jifenType))
/*      */     {
/*  415 */       return JifenOperateEnum.JIFEN_TYPE_ERROR;
/*      */     }
/*      */     
/*  418 */     if (jifennum <= 0L)
/*      */     {
/*  420 */       return JifenOperateEnum.JIFEN_NUM_ERROR;
/*      */     }
/*  422 */     Jifen xJifen = Role2jifen.get(Long.valueOf(roleid));
/*  423 */     if (xJifen == null)
/*      */     {
/*  425 */       xJifen = Pod.newJifen();
/*  426 */       Role2jifen.insert(Long.valueOf(roleid), xJifen);
/*      */     }
/*  428 */     long c = getJifenByJifenType(xJifen, jifenType);
/*  429 */     xJifen.getType2point().put(Integer.valueOf(jifenType), Long.valueOf(jifennum + c));
/*      */     
/*  431 */     CurrencyType currencyType = TlogUtil.getCurrencyTypeByTokentype(jifenType);
/*      */     
/*  433 */     logJifenAndTriggerEvent(roleid, jifenType, currencyType, jifennum, jifennum + c, logArg);
/*      */     
/*  435 */     return JifenOperateEnum.SUCCESS;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static JifenOperateEnum cutJifenForIdip(long roleid, long jifennum, int jifenType, TLogArg logArg)
/*      */   {
/*  448 */     if (!isJifentypeRight(jifenType))
/*      */     {
/*  450 */       return JifenOperateEnum.JIFEN_TYPE_ERROR;
/*      */     }
/*      */     
/*  453 */     if (jifennum <= 0L)
/*      */     {
/*  455 */       return JifenOperateEnum.JIFEN_NUM_ERROR;
/*      */     }
/*      */     
/*  458 */     Jifen xJifen = getJifenForCut(roleid, jifenType);
/*  459 */     if (xJifen == null)
/*      */     {
/*  461 */       return JifenOperateEnum.JIFEN_NUM_NOT_ENOUGH;
/*      */     }
/*  463 */     long c = getJifenByJifenType(xJifen, jifenType);
/*  464 */     if (c < jifennum)
/*      */     {
/*  466 */       return JifenOperateEnum.JIFEN_NUM_NOT_ENOUGH;
/*      */     }
/*  468 */     xJifen.getType2point().put(Integer.valueOf(jifenType), Long.valueOf(c - jifennum));
/*      */     
/*  470 */     CurrencyType currencyType = TlogUtil.getCurrencyTypeByTokentype(jifenType);
/*      */     
/*  472 */     logJifenAndTriggerEvent(roleid, jifenType, currencyType, jifennum * -1L, c - jifennum, logArg);
/*      */     
/*  474 */     return JifenOperateEnum.SUCCESS;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static JifenOperateEnum cutJifenForAqIdip(long roleid, long jifennum, int jifenType, TLogArg logArg)
/*      */   {
/*  487 */     if (!isJifentypeRight(jifenType))
/*      */     {
/*  489 */       return JifenOperateEnum.JIFEN_TYPE_ERROR;
/*      */     }
/*      */     
/*  492 */     if (jifennum <= 0L)
/*      */     {
/*  494 */       return JifenOperateEnum.JIFEN_NUM_ERROR;
/*      */     }
/*      */     
/*  497 */     Jifen xJifen = getJifenForCut(roleid, jifenType);
/*  498 */     if (xJifen == null)
/*      */     {
/*  500 */       return JifenOperateEnum.JIFEN_NUM_CLEAR_FOR_AQIDIP;
/*      */     }
/*  502 */     long c = getJifenByJifenType(xJifen, jifenType);
/*  503 */     if (c == 0L)
/*      */     {
/*  505 */       return JifenOperateEnum.JIFEN_NUM_CLEAR_FOR_AQIDIP;
/*      */     }
/*  507 */     CurrencyType currencyType = TlogUtil.getCurrencyTypeByTokentype(jifenType);
/*      */     
/*  509 */     long endValue = c - jifennum;
/*  510 */     if (endValue < 0L)
/*      */     {
/*  512 */       xJifen.getType2point().put(Integer.valueOf(jifenType), Long.valueOf(0L));
/*      */       
/*  514 */       logJifenAndTriggerEvent(roleid, jifenType, currencyType, c * -1L, 0L, logArg);
/*      */       
/*  516 */       return JifenOperateEnum.JIFEN_NUM_CLEAR_FOR_AQIDIP;
/*      */     }
/*      */     
/*      */ 
/*  520 */     xJifen.getType2point().put(Integer.valueOf(jifenType), Long.valueOf(endValue));
/*      */     
/*  522 */     logJifenAndTriggerEvent(roleid, jifenType, currencyType, jifennum * -1L, endValue, logArg);
/*      */     
/*  524 */     return JifenOperateEnum.SUCCESS;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getJifen(long roleid, int jifenType)
/*      */   {
/*  538 */     Jifen xJifen = Role2jifen.get(Long.valueOf(roleid));
/*  539 */     return xJifen == null ? getDefaultJifenByJifenType(jifenType) : getJifenByJifenType(xJifen, jifenType);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long selectJifen(long roleid, int jifenType)
/*      */   {
/*  552 */     Jifen xJifen = Role2jifen.select(Long.valueOf(roleid));
/*  553 */     return xJifen == null ? getDefaultJifenByJifenType(jifenType) : getJifenByJifenType(xJifen, jifenType);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static JifenOperateResult cutJifen(long roleid, long jifennum, int jifenType, TLogArg logArg)
/*      */   {
/*  565 */     if (jifennum <= 0L)
/*      */     {
/*  567 */       return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.ParamError, 0L);
/*      */     }
/*  569 */     if (!isJifentypeRight(jifenType))
/*      */     {
/*  571 */       return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.TypeInvalid, 0L);
/*      */     }
/*      */     
/*  574 */     Jifen xJifen = getJifenForCut(roleid, jifenType);
/*  575 */     if (xJifen == null)
/*      */     {
/*  577 */       return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.UserNotFound, 0L);
/*      */     }
/*      */     
/*  580 */     long c = getJifenByJifenType(xJifen, jifenType);
/*  581 */     if (c < jifennum)
/*      */     {
/*  583 */       return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.Others, 0L);
/*      */     }
/*  585 */     xJifen.getType2point().put(Integer.valueOf(jifenType), Long.valueOf(c - jifennum));
/*      */     
/*  587 */     CurrencyType currencyType = TlogUtil.getCurrencyTypeByTokentype(jifenType);
/*      */     
/*  589 */     logJifenAndTriggerEvent(roleid, jifenType, currencyType, jifennum * -1L, c - jifennum, logArg);
/*      */     
/*  591 */     return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.Success, jifennum);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static Jifen getJifenForCut(long roleId, int jifenType)
/*      */   {
/*  600 */     Jifen xJifen = Role2jifen.get(Long.valueOf(roleId));
/*  601 */     if (xJifen == null)
/*      */     {
/*  603 */       switch (jifenType)
/*      */       {
/*      */       case 7: 
/*  606 */         xJifen = Pod.newJifen();
/*  607 */         Role2jifen.add(Long.valueOf(roleId), xJifen);
/*  608 */         return xJifen;
/*      */       }
/*      */       
/*      */     }
/*      */     
/*  613 */     return xJifen;
/*      */   }
/*      */   
/*      */   private static void logJifenAndTriggerEvent(long roleid, int tokenType, CurrencyType currencyType, long changeNum, long leftNum, TLogArg logArg)
/*      */   {
/*  618 */     CurrencyLogUtil.logCurrency(roleid, currencyType, (int)changeNum, leftNum, logArg);
/*  619 */     CurrencyLogUtil.tLogCurrency(roleid, currencyType, (int)changeNum, leftNum, logArg);
/*  620 */     CurrencyLogUtil.tlogMoneyFlow(roleid, currencyType, (int)changeNum, leftNum, logArg);
/*      */     
/*      */ 
/*  623 */     TriggerEventsManger.getInstance().triggerEvent(new JiFenChanged(), new JiFenChangedArg(roleid, tokenType, changeNum, leftNum));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Map<Integer, Long> getJifenMap(long roleid)
/*      */   {
/*  636 */     Jifen xJifen = Role2jifen.get(Long.valueOf(roleid));
/*  637 */     Map<Integer, Long> jifenMap = xJifen == null ? new HashMap() : xJifen.getType2point();
/*  638 */     processWhenGetJifenMap(jifenMap);
/*  639 */     return jifenMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void processWhenGetJifenMap(Map<Integer, Long> jifenMap)
/*      */   {
/*  648 */     if (!jifenMap.containsKey(Integer.valueOf(7)))
/*  649 */       jifenMap.put(Integer.valueOf(7), Long.valueOf(SPKConsts.getInstance().INITIAL_MORAL_VALUE));
/*  650 */     if (!jifenMap.containsKey(Integer.valueOf(9)))
/*  651 */       jifenMap.put(Integer.valueOf(9), Long.valueOf(SChangeModelCardConsts.getInstance().INIT_ESSENCE));
/*  652 */     if (!jifenMap.containsKey(Integer.valueOf(10)))
/*  653 */       jifenMap.put(Integer.valueOf(10), Long.valueOf(SChangeModelCardConsts.getInstance().INIT_SCORE));
/*  654 */     if (!jifenMap.containsKey(Integer.valueOf(15)))
/*  655 */       jifenMap.put(Integer.valueOf(15), Long.valueOf(SPetMarkConstants.getInstance().INIT_PET_MARK_SCORE1));
/*  656 */     if (!jifenMap.containsKey(Integer.valueOf(16))) {
/*  657 */       jifenMap.put(Integer.valueOf(16), Long.valueOf(SPetMarkConstants.getInstance().INIT_PET_MARK_SCORE2));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getMallRefreshTime(int malltype)
/*      */   {
/*  668 */     long mt = GameServerInfoManager.toGlobalId(malltype);
/*  669 */     Long malRefreshTime = Malltype2refreshtime.selectRefreshtime(Long.valueOf(mt));
/*  670 */     if (malRefreshTime == null)
/*      */     {
/*  672 */       return 0L;
/*      */     }
/*  674 */     return malRefreshTime.longValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void setMallRefreshTime(int malltype, long refreshtime)
/*      */   {
/*  685 */     long mt = GameServerInfoManager.toGlobalId(malltype);
/*  686 */     MallRefreshTime malRefreshTime = Malltype2refreshtime.get(Long.valueOf(mt));
/*  687 */     if (malRefreshTime == null)
/*      */     {
/*  689 */       malRefreshTime = Pod.newMallRefreshTime();
/*  690 */       Malltype2refreshtime.insert(Long.valueOf(mt), malRefreshTime);
/*      */     }
/*  692 */     malRefreshTime.setRefreshtime(refreshtime);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void sendWrongInfo(long roleid, int resCode, String... params)
/*      */   {
/*  704 */     SBuyItemErrorInfo buyItemErrorInfo = new SBuyItemErrorInfo();
/*  705 */     buyItemErrorInfo.errorcode = resCode;
/*  706 */     for (String param : params)
/*      */     {
/*  708 */       buyItemErrorInfo.params.add(param);
/*      */     }
/*  710 */     OnlineManager.getInstance().sendAtOnce(roleid, buyItemErrorInfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void synJifen(long roleid)
/*      */   {
/*  720 */     Map<Integer, Long> jifenMap = getJifenMap(roleid);
/*  721 */     SSynJifen jifen = new SSynJifen();
/*  722 */     jifen.jifen.putAll(jifenMap);
/*  723 */     fillRoleLadderJifenMap(roleid, jifen);
/*  724 */     OnlineManager.getInstance().send(roleid, jifen);
/*      */   }
/*      */   
/*      */   private static void fillRoleLadderJifenMap(long roleid, SSynJifen sSynJifen)
/*      */   {
/*  729 */     Properties xProperties = Role2properties.get(Long.valueOf(roleid));
/*  730 */     if (xProperties == null)
/*      */     {
/*  732 */       return;
/*      */     }
/*      */     
/*  735 */     Map<Integer, CoinInfo> xCoinInfoMap = xProperties.getCoins();
/*  736 */     Iterator i$; if (xCoinInfoMap != null)
/*      */     {
/*  738 */       for (i$ = xCoinInfoMap.keySet().iterator(); i$.hasNext();) { int type = ((Integer)i$.next()).intValue();
/*      */         
/*  740 */         CoinInfo xCoinInfo = (CoinInfo)xCoinInfoMap.get(Integer.valueOf(type));
/*  741 */         if (GameServerInfoManager.isRoamServer())
/*      */         {
/*  743 */           long total = getRestDstLadderJifenNum(xCoinInfo);
/*  744 */           sSynJifen.jifen.put(Integer.valueOf(type), Long.valueOf(total));
/*      */         }
/*      */         else
/*      */         {
/*  748 */           long total = getRestSrcLadderJifenNum(xCoinInfo);
/*  749 */           sSynJifen.jifen.put(Integer.valueOf(type), Long.valueOf(total));
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void synAllMallItemNum(long roleid)
/*      */   {
/*  764 */     SAllMallItemNum allMallItemNum = new SAllMallItemNum();
/*  765 */     allMallItemNum.mallitemlist.add(getPreciousMallCanBuyNum(roleid));
/*  766 */     allMallItemNum.mallitemlist.add(getLimitMallCanBuyNum(roleid));
/*  767 */     allMallItemNum.mallitemlist.add(getFunctionMallCanBuyNum(roleid));
/*  768 */     getFashionDressItemCanBuyNum(roleid, allMallItemNum);
/*  769 */     getCurrentLimitMallCanBuyNum(roleid, allMallItemNum);
/*  770 */     OnlineManager.getInstance().send(roleid, allMallItemNum);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void getFashionDressItemCanBuyNum(long roleid, SAllMallItemNum sAllMallItemNum)
/*      */   {
/*  782 */     MallItemInfo fashionDressMallItemInfo = new MallItemInfo();
/*  783 */     fashionDressMallItemInfo.malltype = 4;
/*  784 */     SMalltype2Item sMalltype2Item = SMalltype2Item.get(4);
/*  785 */     if (sMalltype2Item == null)
/*      */     {
/*  787 */       return;
/*      */     }
/*  789 */     Set<Integer> itemIdSet = new HashSet(sMalltype2Item.itemid2pricenum.keySet());
/*  790 */     for (Iterator i$ = itemIdSet.iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/*      */       
/*  792 */       if (!ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.MALL.value, itemid))
/*      */       {
/*      */ 
/*      */ 
/*  796 */         fashionDressMallItemInfo.itemid2count.put(Integer.valueOf(itemid), Integer.valueOf(-1)); }
/*      */     }
/*  798 */     sAllMallItemNum.mallitemlist.add(fashionDressMallItemInfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void synLimitMallItemNum(long roleid)
/*      */   {
/*  808 */     SAllMallItemNum allMallItemNum = new SAllMallItemNum();
/*  809 */     allMallItemNum.mallitemlist.add(getLimitMallCanBuyNum(roleid));
/*  810 */     OnlineManager.getInstance().send(roleid, allMallItemNum);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static MallItemInfo getLimitMallCanBuyNum(long roleid)
/*      */   {
/*  822 */     MallItemInfo limitMallItemInfo = new MallItemInfo();
/*  823 */     limitMallItemInfo.malltype = 2;
/*      */     
/*  825 */     Map<Integer, Integer> id2hasBuycountMap = getItemBuyCountMap(roleid);
/*      */     
/*  827 */     for (Iterator i$ = getItemsBymalltype(2).iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/*      */       
/*  829 */       if (!ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.MALL.value, itemid))
/*      */       {
/*      */ 
/*      */ 
/*  833 */         int maxBuynum = getLimitItemMaxBuyNum(2, itemid);
/*  834 */         if (maxBuynum != -1)
/*      */         {
/*      */ 
/*      */ 
/*  838 */           Integer hasBuyNum = (Integer)id2hasBuycountMap.get(Integer.valueOf(itemid));
/*  839 */           if (hasBuyNum == null)
/*      */           {
/*  841 */             hasBuyNum = Integer.valueOf(0);
/*      */           }
/*  843 */           limitMallItemInfo.itemid2count.put(Integer.valueOf(itemid), Integer.valueOf(maxBuynum - hasBuyNum.intValue()));
/*      */         } } }
/*  845 */     return limitMallItemInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static MallItemInfo getPreciousMallCanBuyNum(long roleid)
/*      */   {
/*  857 */     MallItemInfo presicousMallItemInfo = new MallItemInfo();
/*  858 */     presicousMallItemInfo.malltype = 1;
/*  859 */     for (Iterator i$ = getItemsBymalltype(1).iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/*      */       
/*  861 */       if (!ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.MALL.value, itemid))
/*      */       {
/*      */ 
/*      */ 
/*  865 */         presicousMallItemInfo.itemid2count.put(Integer.valueOf(itemid), Integer.valueOf(-1)); }
/*      */     }
/*  867 */     return presicousMallItemInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static MallItemInfo getFunctionMallCanBuyNum(long roleid)
/*      */   {
/*  879 */     MallItemInfo functionMallItemInfo = new MallItemInfo();
/*  880 */     functionMallItemInfo.malltype = 3;
/*  881 */     for (Iterator i$ = getItemsBymalltype(3).iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/*      */       
/*  883 */       if (!ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.MALL.value, itemid))
/*      */       {
/*      */ 
/*      */ 
/*  887 */         functionMallItemInfo.itemid2count.put(Integer.valueOf(itemid), Integer.valueOf(-1)); }
/*      */     }
/*  889 */     return functionMallItemInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<Integer> getMallTypeForItem(long roleid, int itemid)
/*      */   {
/*  901 */     List<SMallTypeCfg> list = new ArrayList();
/*  902 */     for (SMalltype2Item malltype2Item : SMalltype2Item.getAll().values())
/*      */     {
/*  904 */       if (malltype2Item.itemid2pricenum.containsKey(Integer.valueOf(itemid)))
/*      */       {
/*  906 */         list.add(SMallTypeCfg.get(malltype2Item.malltype));
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  911 */     java.util.Collections.sort(list, new java.util.Comparator()
/*      */     {
/*      */ 
/*      */       public int compare(SMallTypeCfg o1, SMallTypeCfg o2)
/*      */       {
/*      */ 
/*  917 */         return o1.sort - o2.sort;
/*      */       }
/*  919 */     });
/*  920 */     List<Integer> res = new ArrayList();
/*  921 */     for (SMallTypeCfg mallTypeCfg : list)
/*      */     {
/*  923 */       res.add(Integer.valueOf(mallTypeCfg.mallType));
/*      */     }
/*      */     
/*  926 */     return res;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Set<Integer> getJifenTypeForItem(int itemid)
/*      */   {
/*  937 */     Set<Integer> jifenTypes = new HashSet();
/*  938 */     for (SShimenExchangeItemCfg shimenExchangeItemCfg : SShimenExchangeItemCfg.getAll().values())
/*      */     {
/*  940 */       if (shimenExchangeItemCfg.itemid == itemid)
/*      */       {
/*  942 */         jifenTypes.add(Integer.valueOf(shimenExchangeItemCfg.exchangeType));
/*      */       }
/*      */     }
/*  945 */     return jifenTypes;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void fillCurrencyData(String userId, long roleid, TLogArg logArg, int needYuanbao)
/*      */   {
/*  958 */     int hasaward = (int)QingfuInterface.getBalance(userId, true);
/*  959 */     if (hasaward >= needYuanbao)
/*      */     {
/*  961 */       logArg.addCurrencytype2num(CurrencyType.CURRENCY_AWARDYUANBAO, Integer.valueOf(-needYuanbao));
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/*  966 */       if (hasaward > 0)
/*      */       {
/*      */ 
/*  969 */         logArg.addCurrencytype2num(CurrencyType.CURRENCY_AWARDYUANBAO, Integer.valueOf(-hasaward));
/*      */       }
/*  971 */       logArg.addCurrencytype2num(CurrencyType.CURRENCY_BUYYUANBAO, Integer.valueOf(-(needYuanbao - hasaward)));
/*      */     }
/*  973 */     logArg.addCurrencytype2num(CurrencyType.CURRENCY_YUANBAO, Integer.valueOf(-needYuanbao));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isMallSwitchOpenForRole(long roleid)
/*      */   {
/*  985 */     if (!OpenInterface.getOpenStatus(31))
/*      */     {
/*  987 */       OpenInterface.sendCloseProtocol(roleid, 31, null);
/*      */       
/*  989 */       return false;
/*      */     }
/*  991 */     if (OpenInterface.isBanPlay(roleid, 31))
/*      */     {
/*  993 */       OpenInterface.sendBanPlayMsg(roleid, 31);
/*  994 */       return false;
/*      */     }
/*  996 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isJifenExchangeSwitchOpenForRole(long roleid)
/*      */   {
/* 1008 */     if (!OpenInterface.getOpenStatus(57))
/*      */     {
/* 1010 */       OpenInterface.sendCloseProtocol(roleid, 57, null);
/*      */       
/* 1012 */       return false;
/*      */     }
/* 1014 */     if (OpenInterface.isBanPlay(roleid, 57))
/*      */     {
/* 1016 */       OpenInterface.sendBanPlayMsg(roleid, 57);
/* 1017 */       return false;
/*      */     }
/* 1019 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isRoleStateCanOperateMall(long roleid)
/*      */   {
/* 1031 */     return mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(roleid, 141, true);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getLadderJifen(long roleid, int jifenType)
/*      */   {
/* 1043 */     Map<Integer, CoinInfo> xConMap = Role2properties.selectCoins(Long.valueOf(roleid));
/* 1044 */     if (xConMap == null)
/*      */     {
/* 1046 */       return 0L;
/*      */     }
/* 1048 */     CoinInfo xCoinInfo = (CoinInfo)xConMap.get(Integer.valueOf(jifenType));
/* 1049 */     if (xCoinInfo == null)
/*      */     {
/* 1051 */       return 0L;
/*      */     }
/* 1053 */     if (GameServerInfoManager.isRoamServer())
/*      */     {
/* 1055 */       return getRestDstLadderJifenNum(xCoinInfo);
/*      */     }
/*      */     
/*      */ 
/* 1059 */     return getRestSrcLadderJifenNum(xCoinInfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static JifenOperateResult addLadderJifen(long roleid, int jifenType, long addNum, boolean isaddWhenTomax, TLogArg tLogArg)
/*      */   {
/* 1067 */     if (addNum <= 0L)
/*      */     {
/* 1069 */       String log = String.format("[mall]MallManager.addLadderJifen@jifen add num error|roleid=%d|jifentype=%d|addnum=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(jifenType), Long.valueOf(addNum) });
/*      */       
/* 1071 */       logger.error(log);
/* 1072 */       return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.ParamError, 0L);
/*      */     }
/* 1074 */     if (!isLadderJifentypeRight(jifenType))
/*      */     {
/* 1076 */       String log = String.format("[mall]MallManager.addLadderJifen@jifen type error|roleid=%d|jifentype=%d|addnum=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(jifenType), Long.valueOf(addNum) });
/*      */       
/* 1078 */       logger.error(log);
/* 1079 */       return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.TypeInvalid, 0L);
/*      */     }
/* 1081 */     Properties xProperties = Role2properties.get(Long.valueOf(roleid));
/* 1082 */     if (xProperties == null)
/*      */     {
/* 1084 */       String log = String.format("[mall]MallManager.addLadderJifen@xProperties is null|roleid=%d|jifentype=%d|addnum=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(jifenType), Long.valueOf(addNum) });
/*      */       
/* 1086 */       logger.error(log);
/*      */       
/* 1088 */       return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.UserNotFound, 0L);
/*      */     }
/*      */     
/* 1091 */     CoinInfo xCoinInfo = (CoinInfo)xProperties.getCoins().get(Integer.valueOf(jifenType));
/* 1092 */     if (xCoinInfo == null)
/*      */     {
/* 1094 */       xCoinInfo = Pod.newCoinInfo();
/* 1095 */       xProperties.getCoins().put(Integer.valueOf(jifenType), xCoinInfo);
/*      */     }
/*      */     
/* 1098 */     int max = AwardInterface.getTokenOwnMax(jifenType);
/* 1099 */     CurrencyType currencyType = TlogUtil.getCurrencyTypeByTokentype(jifenType);
/* 1100 */     long desAddnum = addNum;
/* 1101 */     if (GameServerInfoManager.isRoamServer())
/*      */     {
/* 1103 */       long oldRest = getRestDstLadderJifenNum(xCoinInfo);
/* 1104 */       long newRest = oldRest + addNum;
/*      */       
/* 1106 */       if (newRest <= oldRest)
/*      */       {
/* 1108 */         String log = String.format("[mall]MallManager.addLadderJifen@ dst total long over flow|roleid=%d|jifentype=%d|addnum=%d|newrest=%d|oldrest=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(jifenType), Long.valueOf(addNum), Long.valueOf(newRest), Long.valueOf(oldRest) });
/*      */         
/*      */ 
/* 1111 */         logger.error(log);
/* 1112 */         return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.ParamError, 0L);
/*      */       }
/* 1114 */       long oldDstTotal = xCoinInfo.getDst_total();
/* 1115 */       if (newRest > max)
/*      */       {
/* 1117 */         if (isaddWhenTomax)
/*      */         {
/* 1119 */           desAddnum = max - oldRest;
/* 1120 */           xCoinInfo.setDst_total(oldDstTotal + desAddnum);
/* 1121 */           AwardInterface.sendNormalRet(roleid, 25, true, new String[] { AwardInterface.getTokenNameBy(jifenType) });
/*      */           
/*      */ 
/* 1124 */           String log = String.format("[mall]MallManager.addLadderJifen@add dst total jifen success to max|roleid=%d|jifentype=%d|addnum=%d|newrest=%d|oldrest=%d|max=%d|addnum=%d|desaddnum=%d|olddsttotal=%d|newdsttotal=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(jifenType), Long.valueOf(addNum), Long.valueOf(newRest), Long.valueOf(oldRest), Integer.valueOf(max), Long.valueOf(addNum), Long.valueOf(desAddnum), Long.valueOf(oldDstTotal), Long.valueOf(oldDstTotal + desAddnum) });
/*      */           
/*      */ 
/*      */ 
/* 1128 */           logger.info(log);
/*      */         }
/*      */         else
/*      */         {
/* 1132 */           String log = String.format("[mall]MallManager.addLadderJifen@dst rest jifen to max|roleid=%d|jifentype=%d|addnum=%d|newrest=%d|oldrest=%d|max=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(jifenType), Long.valueOf(addNum), Long.valueOf(newRest), Long.valueOf(oldRest), Integer.valueOf(max) });
/*      */           
/*      */ 
/* 1135 */           logger.error(log);
/*      */           
/* 1137 */           return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.JifenToMax, 0L);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 1142 */         xCoinInfo.setDst_total(oldDstTotal + desAddnum);
/*      */         
/* 1144 */         String log = String.format("[mall]MallManager.addLadderJifen@add dst total jifen success|roleid=%d|jifentype=%d|addnum=%d|newrest=%d|oldrest=%d|max=%d|addnum=%d|desaddnum=%d|olddsttotal=%d|newdsttotal=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(jifenType), Long.valueOf(addNum), Long.valueOf(newRest), Long.valueOf(oldRest), Integer.valueOf(max), Long.valueOf(addNum), Long.valueOf(desAddnum), Long.valueOf(oldDstTotal), Long.valueOf(oldDstTotal + desAddnum) });
/*      */         
/*      */ 
/*      */ 
/* 1148 */         logger.info(log);
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/* 1153 */       long oldRest = getRestSrcLadderJifenNum(xCoinInfo);
/* 1154 */       long newRest = oldRest + addNum;
/*      */       
/* 1156 */       if (newRest <= oldRest)
/*      */       {
/* 1158 */         String log = String.format("[mall]MallManager.addLadderJifen@ srctotal long over flow|roleid=%d|jifentype=%d|addnum=%d|newrest=%d|oldrest=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(jifenType), Long.valueOf(addNum), Long.valueOf(newRest), Long.valueOf(oldRest) });
/*      */         
/*      */ 
/* 1161 */         logger.error(log);
/*      */         
/* 1163 */         return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.ParamError, 0L);
/*      */       }
/* 1165 */       long oldSrcTotal = xCoinInfo.getSrc_total();
/* 1166 */       if (newRest > max)
/*      */       {
/* 1168 */         if (isaddWhenTomax)
/*      */         {
/* 1170 */           desAddnum = max - oldRest;
/*      */           
/* 1172 */           xCoinInfo.setSrc_total(oldSrcTotal + desAddnum);
/* 1173 */           AwardInterface.sendNormalRet(roleid, 25, true, new String[] { AwardInterface.getTokenNameBy(jifenType) });
/*      */           
/*      */ 
/* 1176 */           String log = String.format("[mall]MallManager.addLadderJifen@add src total jifen success to max|roleid=%d|jifentype=%d|addnum=%d|newrest=%d|oldrest=%d|max=%d|addnum=%d|desaddnum=%d|oldsrctotal=%d|newsrctotal=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(jifenType), Long.valueOf(addNum), Long.valueOf(newRest), Long.valueOf(oldRest), Integer.valueOf(max), Long.valueOf(addNum), Long.valueOf(desAddnum), Long.valueOf(oldSrcTotal), Long.valueOf(oldSrcTotal + desAddnum) });
/*      */           
/*      */ 
/*      */ 
/* 1180 */           logger.info(log);
/*      */         }
/*      */         else
/*      */         {
/* 1184 */           String log = String.format("[mall]MallManager.addLadderJifen@src rest jifen to max|roleid=%d|jifentype=%d|addnum=%d|newrest=%d|oldrest=%d|max=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(jifenType), Long.valueOf(addNum), Long.valueOf(newRest), Long.valueOf(oldRest), Integer.valueOf(max) });
/*      */           
/*      */ 
/* 1187 */           logger.info(log);
/*      */           
/* 1189 */           return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.JifenToMax, 0L);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 1194 */         xCoinInfo.setSrc_total(oldSrcTotal + desAddnum);
/*      */         
/* 1196 */         String log = String.format("[mall]MallManager.addLadderJifen@add src total jifen success|roleid=%d|jifentype=%d|addnum=%d|newrest=%d|oldrest=%d|max=%d|addnum=%d|desaddnum=%d|oldsrctotal=%d|newsrctotal=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(jifenType), Long.valueOf(addNum), Long.valueOf(newRest), Long.valueOf(oldRest), Integer.valueOf(max), Long.valueOf(addNum), Long.valueOf(desAddnum), Long.valueOf(oldSrcTotal), Long.valueOf(oldSrcTotal + desAddnum) });
/*      */         
/*      */ 
/*      */ 
/* 1200 */         logger.info(log);
/*      */       }
/*      */     }
/* 1203 */     logJifenAndTriggerEvent(roleid, jifenType, currencyType, desAddnum, getRestLadderJifenNum(xCoinInfo), tLogArg);
/* 1204 */     synJifen(roleid);
/* 1205 */     return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.Success, desAddnum);
/*      */   }
/*      */   
/*      */ 
/*      */   static JifenOperateResult cutLadderJifen(long roleid, int jifenType, long cutNum, TLogArg tLogArg)
/*      */   {
/* 1211 */     if (cutNum <= 0L)
/*      */     {
/* 1213 */       return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.ParamError, 0L);
/*      */     }
/* 1215 */     if (!isLadderJifentypeRight(jifenType))
/*      */     {
/* 1217 */       return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.TypeInvalid, 0L);
/*      */     }
/* 1219 */     Properties xProperties = Role2properties.get(Long.valueOf(roleid));
/* 1220 */     if (xProperties == null)
/*      */     {
/* 1222 */       return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.UserNotFound, 0L);
/*      */     }
/*      */     
/* 1225 */     CoinInfo xCoinInfo = (CoinInfo)xProperties.getCoins().get(Integer.valueOf(jifenType));
/* 1226 */     if (xCoinInfo == null)
/*      */     {
/* 1228 */       return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.TypeInvalid, 0L);
/*      */     }
/* 1230 */     CurrencyType currencyType = TlogUtil.getCurrencyTypeByTokentype(jifenType);
/* 1231 */     if (GameServerInfoManager.isRoamServer())
/*      */     {
/* 1233 */       long oldtotalcost = xCoinInfo.getDst_total_cost();
/* 1234 */       long newtotalcost = oldtotalcost + cutNum;
/*      */       
/* 1236 */       long dstRest = getRestDstLadderJifenNum(xCoinInfo);
/* 1237 */       if (cutNum > dstRest)
/*      */       {
/* 1239 */         String log = String.format("[mall]MallManager.cutLadderJifen@cut dst jifen error|roleid=%d|jifentype=%d|cutnum=%d|dstrest=%d|dst_total_cost=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(jifenType), Long.valueOf(cutNum), Long.valueOf(dstRest), Long.valueOf(oldtotalcost) });
/*      */         
/*      */ 
/* 1242 */         logger.error(log);
/*      */         
/* 1244 */         return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.ParamError, 0L);
/*      */       }
/*      */       
/* 1247 */       if (newtotalcost <= oldtotalcost)
/*      */       {
/* 1249 */         String log = String.format("[mall]MallManager.cutLadderJifen@cut dst jifen over flow|roleid=%d|jifentype=%d|cutnum=%d|dstrest=%d|dst_total_cost=%d|new_dst_total_cost=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(jifenType), Long.valueOf(cutNum), Long.valueOf(dstRest), Long.valueOf(oldtotalcost), Long.valueOf(newtotalcost) });
/*      */         
/*      */ 
/* 1252 */         logger.error(log);
/*      */         
/* 1254 */         return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.ParamError, 0L);
/*      */       }
/*      */       
/*      */ 
/* 1258 */       xCoinInfo.setDst_total_cost(newtotalcost);
/*      */       
/* 1260 */       String log = String.format("[mall]MallManager.cutLadderJifen@cut dst jifen success|roleid=%d|jifentype=%d|cutnum=%d|dstrest=%d|dst_total_cost=%d|new_dst_total_cost=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(jifenType), Long.valueOf(cutNum), Long.valueOf(dstRest), Long.valueOf(oldtotalcost), Long.valueOf(newtotalcost) });
/*      */       
/*      */ 
/* 1263 */       logger.info(log);
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/* 1268 */       long oldtotalcost = xCoinInfo.getSrc_total_cost();
/* 1269 */       long newtotalcost = oldtotalcost + cutNum;
/*      */       
/* 1271 */       long srcRest = getRestSrcLadderJifenNum(xCoinInfo);
/* 1272 */       if (cutNum > srcRest)
/*      */       {
/* 1274 */         String log = String.format("[mall]MallManager.cutLadderJifen@cut src jifen error|roleid=%d|jifentype=%d|cutnum=%d|srcrest=%d|src_total_cost=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(jifenType), Long.valueOf(cutNum), Long.valueOf(srcRest), Long.valueOf(oldtotalcost) });
/*      */         
/*      */ 
/* 1277 */         logger.error(log);
/*      */         
/* 1279 */         return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.ParamError, 0L);
/*      */       }
/*      */       
/* 1282 */       if (newtotalcost <= oldtotalcost)
/*      */       {
/* 1284 */         String log = String.format("[mall]MallManager.cutLadderJifen@cut src jifen over flow|roleid=%d|jifentype=%d|cutnum=%d|srcrest=%d|src_total_cost=%d|new_src_total_cost=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(jifenType), Long.valueOf(cutNum), Long.valueOf(srcRest), Long.valueOf(oldtotalcost), Long.valueOf(newtotalcost) });
/*      */         
/*      */ 
/* 1287 */         logger.error(log);
/*      */         
/* 1289 */         return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.ParamError, 0L);
/*      */       }
/*      */       
/*      */ 
/* 1293 */       xCoinInfo.setSrc_total_cost(newtotalcost);
/*      */       
/* 1295 */       String log = String.format("[mall]MallManager.cutLadderJifen@cut src jifen success|roleid=%d|jifentype=%d|cutnum=%d|srcrest=%d|src_total_cost=%d|new_src_total_cost=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(jifenType), Long.valueOf(cutNum), Long.valueOf(srcRest), Long.valueOf(oldtotalcost), Long.valueOf(newtotalcost) });
/*      */       
/*      */ 
/* 1298 */       logger.info(log);
/*      */     }
/*      */     
/*      */ 
/* 1302 */     logJifenAndTriggerEvent(roleid, jifenType, currencyType, cutNum * -1L, getRestLadderJifenNum(xCoinInfo), tLogArg);
/* 1303 */     synJifen(roleid);
/* 1304 */     return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.Success, cutNum);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isLadderJifentypeRight(int jifenType)
/*      */   {
/* 1316 */     STokenType sTokenType = STokenType.get(jifenType);
/* 1317 */     if (sTokenType == null)
/*      */     {
/* 1319 */       return false;
/*      */     }
/* 1321 */     if (sTokenType.fatherType != 2)
/*      */     {
/* 1323 */       return false;
/*      */     }
/*      */     
/* 1326 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getJifenFatherType(int jifenType)
/*      */   {
/* 1337 */     STokenType sTokenType = STokenType.get(jifenType);
/* 1338 */     if (sTokenType == null)
/*      */     {
/* 1340 */       return -1;
/*      */     }
/* 1342 */     return sTokenType.fatherType;
/*      */   }
/*      */   
/*      */   static long getRestLadderJifenNum(CoinInfo xCoinInfo)
/*      */   {
/* 1347 */     long total = getRestSrcLadderJifenNum(xCoinInfo) + getRestDstLadderJifenNum(xCoinInfo);
/* 1348 */     return total;
/*      */   }
/*      */   
/*      */   static long getRestSrcLadderJifenNum(CoinInfo xCoinInfo)
/*      */   {
/* 1353 */     return xCoinInfo.getSrc_total() - xCoinInfo.getSrc_total_cost();
/*      */   }
/*      */   
/*      */   static long getRestDstLadderJifenNum(CoinInfo xCoinInfo)
/*      */   {
/* 1358 */     return xCoinInfo.getDst_total() - xCoinInfo.getDst_total_cost();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void getCurrentLimitMallCanBuyNum(long roleid, SAllMallItemNum sAllMallItemNum)
/*      */   {
/* 1372 */     for (Map.Entry<Integer, CurrentLimitShopRelation> entry : CURRENT_LIMIT_SHOP.entrySet())
/*      */     {
/* 1374 */       int malltype = ((Integer)entry.getKey()).intValue();
/* 1375 */       MallItemInfo limitMallItemInfo = new MallItemInfo();
/* 1376 */       limitMallItemInfo.malltype = malltype;
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1383 */       checkAndResetCurrentLimitMall(roleid, malltype);
/*      */       
/* 1385 */       Map<Integer, Integer> id2hasBuycountMap = getCurrentLimitItemBuyCountMap(roleid, malltype);
/*      */       
/* 1387 */       for (Iterator i$ = getItemsBymalltype(malltype).iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/*      */         
/* 1389 */         if (!ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.MALL.value, itemid))
/*      */         {
/*      */ 
/*      */ 
/* 1393 */           int maxBuynum = getLimitItemMaxBuyNum(malltype, itemid);
/* 1394 */           if (maxBuynum != -1)
/*      */           {
/*      */ 
/*      */ 
/* 1398 */             Integer hasBuyNum = (Integer)id2hasBuycountMap.get(Integer.valueOf(itemid));
/* 1399 */             if (hasBuyNum == null)
/*      */             {
/* 1401 */               hasBuyNum = Integer.valueOf(0);
/*      */             }
/* 1403 */             limitMallItemInfo.itemid2count.put(Integer.valueOf(itemid), Integer.valueOf(maxBuynum - hasBuyNum.intValue()));
/*      */           } } }
/* 1405 */       sAllMallItemNum.mallitemlist.add(limitMallItemInfo);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isCurrentLimitMallSwitchOpenForRole(long roleid, int malltype)
/*      */   {
/* 1417 */     CurrentLimitShopRelation currentLimitShopRelation = (CurrentLimitShopRelation)CURRENT_LIMIT_SHOP.get(Integer.valueOf(malltype));
/* 1418 */     if (currentLimitShopRelation == null)
/*      */     {
/* 1420 */       return false;
/*      */     }
/* 1422 */     if (!OpenInterface.getOpenStatus(currentLimitShopRelation.openId))
/*      */     {
/* 1424 */       return false;
/*      */     }
/* 1426 */     if (OpenInterface.isBanPlay(roleid, currentLimitShopRelation.openId))
/*      */     {
/* 1428 */       OpenInterface.sendBanPlayMsg(roleid, currentLimitShopRelation.openId);
/* 1429 */       return false;
/*      */     }
/* 1431 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static Map<Integer, Integer> getCurrentLimitItemBuyCountMap(long roleid, int malltype)
/*      */   {
/* 1444 */     RoleLimitShop xRoleLimitShop = Role2limitshops.get(Long.valueOf(roleid));
/* 1445 */     if (xRoleLimitShop == null)
/*      */     {
/* 1447 */       return new HashMap();
/*      */     }
/* 1449 */     ItemBuyCount xItemBuyCount = (ItemBuyCount)xRoleLimitShop.getType2itembuycount().get(Integer.valueOf(malltype));
/* 1450 */     if (xItemBuyCount == null)
/*      */     {
/* 1452 */       return new HashMap();
/*      */     }
/* 1454 */     return xItemBuyCount.getId2count();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getCurrentLimitMallItemBuyCount(long roleid, int malltype, int itemid)
/*      */   {
/* 1467 */     RoleLimitShop xRoleLimitShop = Role2limitshops.get(Long.valueOf(roleid));
/* 1468 */     if (xRoleLimitShop == null)
/*      */     {
/* 1470 */       return 0;
/*      */     }
/* 1472 */     ItemBuyCount xItemBuyCount = (ItemBuyCount)xRoleLimitShop.getType2itembuycount().get(Integer.valueOf(malltype));
/* 1473 */     if (xItemBuyCount == null)
/*      */     {
/* 1475 */       return 0;
/*      */     }
/* 1477 */     Integer c = (Integer)xItemBuyCount.getId2count().get(Integer.valueOf(itemid));
/* 1478 */     if (c == null)
/*      */     {
/* 1480 */       return 0;
/*      */     }
/* 1482 */     return c.intValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean addCurrentLimitMallItemBuyCount(long roleid, int malltype, int itemid, int count)
/*      */   {
/* 1495 */     if (count <= 0)
/*      */     {
/* 1497 */       return false;
/*      */     }
/* 1499 */     RoleLimitShop xRoleLimitShop = Role2limitshops.get(Long.valueOf(roleid));
/* 1500 */     if (xRoleLimitShop == null)
/*      */     {
/* 1502 */       xRoleLimitShop = Pod.newRoleLimitShop();
/* 1503 */       Role2limitshops.insert(Long.valueOf(roleid), xRoleLimitShop);
/*      */     }
/* 1505 */     ItemBuyCount xItemBuyCount = (ItemBuyCount)xRoleLimitShop.getType2itembuycount().get(Integer.valueOf(malltype));
/* 1506 */     if (xItemBuyCount == null)
/*      */     {
/* 1508 */       xItemBuyCount = Pod.newItemBuyCount();
/* 1509 */       xItemBuyCount.setCleartime(DateTimeUtils.getCurrTimeInMillis());
/* 1510 */       xRoleLimitShop.getType2itembuycount().put(Integer.valueOf(malltype), xItemBuyCount);
/*      */     }
/* 1512 */     Integer c = (Integer)xItemBuyCount.getId2count().get(Integer.valueOf(itemid));
/* 1513 */     if (c == null)
/*      */     {
/* 1515 */       c = Integer.valueOf(0);
/*      */     }
/* 1517 */     xItemBuyCount.getId2count().put(Integer.valueOf(itemid), Integer.valueOf(c.intValue() + count));
/* 1518 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void checkAndResetCurrentLimitMall(long roleid, int malltype)
/*      */   {
/* 1532 */     RoleLimitShop xRoleLimitShop = Role2limitshops.get(Long.valueOf(roleid));
/* 1533 */     if (xRoleLimitShop == null)
/*      */     {
/* 1535 */       return;
/*      */     }
/* 1537 */     ItemBuyCount xItemBuyCount = (ItemBuyCount)xRoleLimitShop.getType2itembuycount().get(Integer.valueOf(malltype));
/* 1538 */     if (xItemBuyCount == null)
/*      */     {
/* 1540 */       return;
/*      */     }
/* 1542 */     long cleartime = xItemBuyCount.getCleartime();
/* 1543 */     long mallcleartime = getMallRefreshTime(malltype);
/* 1544 */     if (mallcleartime == 0L)
/*      */     {
/* 1546 */       return;
/*      */     }
/* 1548 */     if (cleartime < mallcleartime)
/*      */     {
/* 1550 */       xItemBuyCount.setCleartime(mallcleartime);
/* 1551 */       xItemBuyCount.getId2count().clear();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\main\MallManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */