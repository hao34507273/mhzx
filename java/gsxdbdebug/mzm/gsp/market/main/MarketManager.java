/*      */ package mzm.gsp.market.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Calendar;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.idip.main.IdipManager;
/*      */ import mzm.gsp.item.main.ItemBanTrade;
/*      */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*      */ import mzm.gsp.item.main.ItemInterface;
/*      */ import mzm.gsp.market.SBuyItemRes;
/*      */ import mzm.gsp.market.SBuyPetRes;
/*      */ import mzm.gsp.market.SCommonResultRes;
/*      */ import mzm.gsp.market.SGetMoneyPetRes;
/*      */ import mzm.gsp.market.SItemBanTradeRes;
/*      */ import mzm.gsp.market.SMarketItemPetBulletinRes;
/*      */ import mzm.gsp.market.SPetBanTradeRes;
/*      */ import mzm.gsp.market.SSellItemRes;
/*      */ import mzm.gsp.market.SSellPetRes;
/*      */ import mzm.gsp.market.SSynMarketItemBanTradeRes;
/*      */ import mzm.gsp.market.SSynMarketPetBanTradeRes;
/*      */ import mzm.gsp.market.SSyncSellItemNotify;
/*      */ import mzm.gsp.market.SSyncSellPetNotify;
/*      */ import mzm.gsp.market.confbean.PriceRate2Weight;
/*      */ import mzm.gsp.market.confbean.SMarketConsts;
/*      */ import mzm.gsp.market.confbean.SMarketItemCfg;
/*      */ import mzm.gsp.market.confbean.SMarketPetCfg;
/*      */ import mzm.gsp.market.confbean.SMarketSubTypeCfg;
/*      */ import mzm.gsp.market.confbean.SMarketSupplyItemCfg;
/*      */ import mzm.gsp.market.confbean.SMultiMarketPetPriceCfg;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.pet.main.PetInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.AuctionItemInfo;
/*      */ import xbean.AuctionPetInfo;
/*      */ import xbean.Item;
/*      */ import xbean.MarketChannelIds;
/*      */ import xbean.MarketIds;
/*      */ import xbean.MarketLog;
/*      */ import xbean.Pet;
/*      */ import xbean.Pod;
/*      */ import xbean.RoleMarketInfo;
/*      */ import xbean.SaleLog;
/*      */ import xdb.Xdb;
/*      */ import xtable.Channel2marketids;
/*      */ import xtable.Item2marketchannelids;
/*      */ import xtable.Marketitem;
/*      */ import xtable.Marketitem2sessionid;
/*      */ import xtable.Marketpet;
/*      */ import xtable.Marketpet2sessionid;
/*      */ import xtable.Pet2marketchannelids;
/*      */ import xtable.Role2marketlog;
/*      */ 
/*      */ class MarketManager
/*      */ {
/*   66 */   static Logger logger = null;
/*      */   
/*      */   static final int WAN = 10000;
/*      */   
/*      */   public static final long SYS_ROLE_ID = 0L;
/*      */   
/*      */   static void init()
/*      */   {
/*   74 */     logger = Logger.getLogger("market");
/*   75 */     initRankManager();
/*   76 */     initMarketItemAndPet();
/*      */   }
/*      */   
/*      */   static void initRankManager()
/*      */   {
/*   81 */     for (SMarketSubTypeCfg marketSubTypeCfg : SMarketSubTypeCfg.getAll().values())
/*      */     {
/*   83 */       if (isLevelSift(marketSubTypeCfg.id))
/*      */       {
/*   85 */         LevelSiftRankManager.init(marketSubTypeCfg.id, marketSubTypeCfg.maxsellnum, marketSubTypeCfg.levelDelta);
/*      */       }
/*      */       else
/*      */       {
/*   89 */         PriceRankManager.init(marketSubTypeCfg.id, marketSubTypeCfg.maxsellnum);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private static void initMarketItemAndPet()
/*      */   {
/*   97 */     for (SMarketItemCfg marketItemCfg : SMarketItemCfg.getAll().values())
/*      */     {
/*   99 */       MarketItemPetPriceManager.init(marketItemCfg.itemid);
/*  100 */       if (!ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.MARKET_ITEM.value, marketItemCfg.itemid))
/*      */       {
/*      */ 
/*      */ 
/*  104 */         new GetMarketItemIdsPro(marketItemCfg.itemid, marketItemCfg.subid).call();
/*      */       }
/*      */     }
/*      */     
/*  108 */     for (SMarketPetCfg marketPetCfg : SMarketPetCfg.getAll().values())
/*      */     {
/*  110 */       MarketItemPetPriceManager.init(marketPetCfg.petid);
/*  111 */       if (!ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.MARKET_PET.value, marketPetCfg.petid))
/*      */       {
/*      */ 
/*      */ 
/*  115 */         new GetMarketPetIdsPro(marketPetCfg.petid, marketPetCfg.subid).call();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   static void tryStartAllSupplyItemSession() {
/*  121 */     for (SMarketSupplyItemCfg marketSupplyItemCfg : SMarketSupplyItemCfg.getAll().values())
/*      */     {
/*  123 */       new TryStartSupplySessionPro(marketSupplyItemCfg.itemid).execute();
/*      */     }
/*      */   }
/*      */   
/*      */   private static class TryStartSupplySessionPro extends mzm.gsp.util.LogicProcedure
/*      */   {
/*      */     private final int itemid;
/*      */     
/*      */     public TryStartSupplySessionPro(int itemid)
/*      */     {
/*  133 */       this.itemid = itemid;
/*      */     }
/*      */     
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/*  139 */       return MarketManager.tryStartSupplyItemSession(this.itemid);
/*      */     }
/*      */   }
/*      */   
/*      */   static void stopAllSupplyItemSession()
/*      */   {
/*  145 */     for (SMarketSupplyItemCfg marketSupplyItemCfg : SMarketSupplyItemCfg.getAll().values())
/*      */     {
/*  147 */       if (marketSupplyItemCfg != null)
/*      */       {
/*  149 */         removeSupplySession(marketSupplyItemCfg.itemid);
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
/*      */ 
/*      */ 
/*      */   static boolean isExpire(long now, long onShelfTime)
/*      */   {
/*  165 */     return TimeUnit.MILLISECONDS.toMinutes(now - onShelfTime) >= SMarketConsts.getInstance().AUCTION_TIME;
/*      */   }
/*      */   
/*      */   static boolean isItemSubtype(int subid)
/*      */   {
/*  170 */     return mzm.gsp.market.confbean.SItemSubTypeIds.get(subid) != null;
/*      */   }
/*      */   
/*      */   static boolean isPriceSort(int subid)
/*      */   {
/*  175 */     if (SMarketSubTypeCfg.get(subid) == null)
/*      */     {
/*  177 */       return false;
/*      */     }
/*  179 */     return SMarketSubTypeCfg.get(subid).ispricesort;
/*      */   }
/*      */   
/*      */   static boolean isLevelSift(int subid)
/*      */   {
/*  184 */     if (SMarketSubTypeCfg.get(subid) == null)
/*      */     {
/*  186 */       return false;
/*      */     }
/*  188 */     return SMarketSubTypeCfg.get(subid).islevelsift;
/*      */   }
/*      */   
/*      */   static boolean isPetSubtype(int subid)
/*      */   {
/*  193 */     return mzm.gsp.market.confbean.SPetSubTypeIds.get(subid) != null;
/*      */   }
/*      */   
/*      */   static boolean isRoleLevelRight(int roleLelve, int subid)
/*      */   {
/*  198 */     return roleLelve >= SMarketSubTypeCfg.get(subid).needlevel;
/*      */   }
/*      */   
/*      */   static boolean canSellItem(int itemId)
/*      */   {
/*  203 */     if (SMarketItemCfg.get(itemId) == null)
/*      */     {
/*  205 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  209 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static boolean canSellPet(int petId)
/*      */   {
/*  216 */     if (SMarketPetCfg.get(petId) == null)
/*      */     {
/*  218 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  222 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static int getRoleMaxMarketGrid()
/*      */   {
/*  229 */     return SMarketConsts.getInstance().AUCTION_GRID_NUM;
/*      */   }
/*      */   
/*      */   static int getRoleMaxConcernNum()
/*      */   {
/*  234 */     return SMarketConsts.getInstance().COLLECTION_NUM;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isMarketSellnumToMax(int subid)
/*      */   {
/*  245 */     return getMarketSellNum(subid) >= SMarketSubTypeCfg.get(subid).maxsellnum;
/*      */   }
/*      */   
/*      */   static int getMarketSellNum(int subid)
/*      */   {
/*  250 */     if (isLevelSift(subid))
/*      */     {
/*  252 */       return LevelSiftRankManager.getPubSize(subid) + LevelSiftRankManager.getSellSize(subid);
/*      */     }
/*      */     
/*      */ 
/*  256 */     return PriceRankManager.getSellSize(subid) + PriceRankManager.getPubSize(subid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static boolean isItemPriceRight(int itemId, int price, boolean isWithSkill)
/*      */   {
/*  263 */     int minPrice = getMinItemPrice(itemId);
/*  264 */     if (minPrice <= 0)
/*      */     {
/*  266 */       return false;
/*      */     }
/*  268 */     int maxPrice = getMaxItemPrice(itemId, isWithSkill);
/*  269 */     if (maxPrice <= 0)
/*      */     {
/*  271 */       return false;
/*      */     }
/*  273 */     if (minPrice > maxPrice)
/*      */     {
/*  275 */       return false;
/*      */     }
/*      */     
/*  278 */     if ((price < minPrice) || (price > maxPrice))
/*      */     {
/*  280 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  284 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static int getMaxItemPrice(int itemId, boolean isWithSkill)
/*      */   {
/*  291 */     SMarketItemCfg marketItemCfg = SMarketItemCfg.get(itemId);
/*  292 */     if (marketItemCfg == null)
/*      */     {
/*  294 */       return 0;
/*      */     }
/*  296 */     if (isWithSkill)
/*      */     {
/*  298 */       return SMarketConsts.getInstance().MARKET_ITEM_MAX_PRICE;
/*      */     }
/*      */     
/*      */ 
/*  302 */     return marketItemCfg.maxprice;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static int getMinItemPrice(int itemId)
/*      */   {
/*  309 */     SMarketItemCfg marketItemCfg = SMarketItemCfg.get(itemId);
/*  310 */     if (marketItemCfg == null)
/*      */     {
/*  312 */       return 0;
/*      */     }
/*  314 */     return marketItemCfg.minprice;
/*      */   }
/*      */   
/*      */   static int getMaxPetPrice(int petCfgId)
/*      */   {
/*  319 */     SMarketPetCfg marketPetCfg = SMarketPetCfg.get(petCfgId);
/*  320 */     if (marketPetCfg == null)
/*      */     {
/*  322 */       return 0;
/*      */     }
/*  324 */     return marketPetCfg.maxprice;
/*      */   }
/*      */   
/*      */   static int getMinPetPrice(int petCfgId)
/*      */   {
/*  329 */     SMarketPetCfg marketPetCfg = SMarketPetCfg.get(petCfgId);
/*  330 */     if (marketPetCfg == null)
/*      */     {
/*  332 */       return 0;
/*      */     }
/*  334 */     return marketPetCfg.minprice;
/*      */   }
/*      */   
/*      */   static boolean isPetPriceRight(Pet xPet, int price)
/*      */   {
/*  339 */     PetPriceBean petPriceBean = getPetPriceBean(xPet);
/*      */     
/*  341 */     int minPrice = petPriceBean.getMinPrice();
/*  342 */     if (minPrice <= 0)
/*      */     {
/*  344 */       return false;
/*      */     }
/*  346 */     int maxPrice = petPriceBean.getMaxPrice();
/*  347 */     if (maxPrice <= 0)
/*      */     {
/*  349 */       return false;
/*      */     }
/*  351 */     if (minPrice > maxPrice)
/*      */     {
/*  353 */       return false;
/*      */     }
/*  355 */     if ((price < minPrice) || (price > maxPrice))
/*      */     {
/*  357 */       return false;
/*      */     }
/*  359 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   static PetPriceBean getPetPriceBean(Pet xPet)
/*      */   {
/*  365 */     int minPrice = -1;
/*  366 */     int maxPrice = -1;
/*  367 */     int multiDataType = mzm.gsp.multixml.main.MultiXMLInterface.getXMLDateType();
/*  368 */     SMultiMarketPetPriceCfg s = SMultiMarketPetPriceCfg.get(multiDataType);
/*  369 */     if (s != null)
/*      */     {
/*  371 */       minPrice = computeMinPetPrice(xPet, s.pet_price_skill_num_param, s.pet_price_skill_num_power_param, s.pet_price_skill_num_ratio_param);
/*      */       
/*  373 */       maxPrice = (int)(minPrice * s.pet_max_price_param);
/*      */     }
/*      */     else
/*      */     {
/*  377 */       minPrice = computeMinPetPrice(xPet, SMarketConsts.getInstance().PET_PRICE_SKILL_NUM_PARAM, SMarketConsts.getInstance().PET_PRICE_SKILL_NUM_POWER_PARAM, SMarketConsts.getInstance().PET_PRICE_SKILL_NUM_RATIO_PARAM);
/*      */       
/*      */ 
/*  380 */       maxPrice = (int)(minPrice * SMarketConsts.getInstance().PET_MAX_PRICE_PARAM);
/*      */     }
/*  382 */     return new PetPriceBean(maxPrice, minPrice);
/*      */   }
/*      */   
/*      */ 
/*      */   private static int computeMinPetPrice(Pet xPet, int pet_price_skill_num_param, int pet_price_skill_num_power_param, int pet_price_skill_num_ratio_param)
/*      */   {
/*  388 */     int minPrice = PetInterface.getPetMarketPrice(xPet);
/*  389 */     if (minPrice <= 0)
/*      */     {
/*  391 */       return minPrice;
/*      */     }
/*  393 */     int skillnum = Math.max(0, PetInterface.getPetSkillNum(xPet) - pet_price_skill_num_param);
/*  394 */     minPrice = (int)(minPrice + Math.pow(skillnum, pet_price_skill_num_power_param) * pet_price_skill_num_ratio_param);
/*  395 */     return minPrice;
/*      */   }
/*      */   
/*      */   static long computeSellNeedTaxGold(int price, int num)
/*      */   {
/*  400 */     long tax = (SMarketConsts.getInstance().SELL_TAX_RATE / 10000.0D * price * num);
/*  401 */     tax = Math.min(tax, SMarketConsts.getInstance().MAX_SELL_TAX);
/*  402 */     return tax;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int computeGoldAfterCutTax(int price)
/*      */   {
/*  413 */     int tax = (int)((10000.0D - SMarketConsts.getInstance().GET_MONEY_TAX_RATE) / 10000.0D * price);
/*  414 */     return tax;
/*      */   }
/*      */   
/*      */   static void sendSGetMoneyItemRes(long roleId, long marketId, int itemId, int moneyNum)
/*      */   {
/*  419 */     mzm.gsp.market.SGetMoneyItemRes res = new mzm.gsp.market.SGetMoneyItemRes();
/*  420 */     res.marketid = marketId;
/*  421 */     res.money = moneyNum;
/*  422 */     res.itemid = itemId;
/*  423 */     OnlineManager.getInstance().send(roleId, res);
/*      */   }
/*      */   
/*      */   static void sendSGetMoneyPetRes(long roleId, long marketId, int petCfgId, int moneyNum)
/*      */   {
/*  428 */     SGetMoneyPetRes res = new SGetMoneyPetRes();
/*  429 */     res.marketid = marketId;
/*  430 */     res.money = moneyNum;
/*  431 */     res.petcfgid = petCfgId;
/*  432 */     OnlineManager.getInstance().send(roleId, res);
/*      */   }
/*      */   
/*      */   static void sendCommonError(long roleid, int code)
/*      */   {
/*  437 */     SCommonResultRes res = new SCommonResultRes(code);
/*  438 */     OnlineManager.getInstance().sendAtOnce(roleid, res);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static MarketChannelIds getMarketItemChannelIdsOnAdd(int itemid)
/*      */   {
/*  449 */     long key = GameServerInfoManager.toGlobalId(itemid);
/*  450 */     MarketChannelIds xMarketChannelIds = Item2marketchannelids.get(Long.valueOf(key));
/*  451 */     if (xMarketChannelIds == null)
/*      */     {
/*  453 */       xMarketChannelIds = Pod.newMarketChannelIds();
/*  454 */       Item2marketchannelids.insert(Long.valueOf(key), xMarketChannelIds);
/*      */     }
/*  456 */     resetXMarketChannelIds(xMarketChannelIds);
/*  457 */     return xMarketChannelIds;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static MarketChannelIds getMarketPetChannelIdsOnAdd(int petCfgId)
/*      */   {
/*  468 */     long key = GameServerInfoManager.toGlobalId(petCfgId);
/*  469 */     MarketChannelIds xMarketChannelIds = Pet2marketchannelids.get(Long.valueOf(key));
/*  470 */     if (xMarketChannelIds == null)
/*      */     {
/*  472 */       xMarketChannelIds = Pod.newMarketChannelIds();
/*  473 */       Pet2marketchannelids.insert(Long.valueOf(key), xMarketChannelIds);
/*      */     }
/*  475 */     resetXMarketChannelIds(xMarketChannelIds);
/*  476 */     return xMarketChannelIds;
/*      */   }
/*      */   
/*      */   private static void resetXMarketChannelIds(MarketChannelIds xMarketChannelIds)
/*      */   {
/*  481 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  482 */     if (DateTimeUtils.needDailyReset(xMarketChannelIds.getSupply_time(), now, 0))
/*      */     {
/*  484 */       xMarketChannelIds.setSupply_num(0);
/*  485 */       xMarketChannelIds.setSupply_time(now);
/*  486 */       xMarketChannelIds.setSupply_skill_equip_num(0);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long findLastChannelid(MarketChannelIds xMarketChannelIds)
/*      */   {
/*  498 */     if ((xMarketChannelIds == null) || (xMarketChannelIds.getChannel_ids().isEmpty()))
/*      */     {
/*  500 */       return -1L;
/*      */     }
/*  502 */     return ((Long)xMarketChannelIds.getChannel_ids().get(xMarketChannelIds.getChannel_ids().size() - 1)).longValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getChannelSizeByItemId(int itemId)
/*      */   {
/*  513 */     int subid = getSubidByItemId(itemId);
/*  514 */     if (subid == -1)
/*      */     {
/*  516 */       return -1;
/*      */     }
/*  518 */     return 10000;
/*      */   }
/*      */   
/*      */   static int getPageSize()
/*      */   {
/*  523 */     return SMarketConsts.getInstance().PAGE_SIZE;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getChannelSizeByPetId(int petId)
/*      */   {
/*  534 */     int subid = getSubidByPetId(petId);
/*  535 */     if (subid == -1)
/*      */     {
/*  537 */       return -1;
/*      */     }
/*  539 */     return 10000;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getSubidByItemId(int itemId)
/*      */   {
/*  550 */     SMarketItemCfg marketItemCfg = SMarketItemCfg.get(itemId);
/*  551 */     if (marketItemCfg == null)
/*      */     {
/*  553 */       return -1;
/*      */     }
/*  555 */     return marketItemCfg.subid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getSubidByPetId(int petId)
/*      */   {
/*  566 */     SMarketPetCfg marketPetCfg = SMarketPetCfg.get(petId);
/*  567 */     if (marketPetCfg == null)
/*      */     {
/*  569 */       return -1;
/*      */     }
/*  571 */     return marketPetCfg.subid;
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
/*      */ 
/*      */ 
/*      */   static long createMarketItemInfo(long roleId, Item xItem, int price, long now, long channel_id, int state)
/*      */   {
/*  588 */     xbean.MarketItem xMarketItem = Pod.newMarketItem();
/*  589 */     ItemInterface.fillXItem(xMarketItem.getItem(), xItem);
/*  590 */     xMarketItem.setChannel_id(channel_id);
/*  591 */     xMarketItem.setPrice(price);
/*  592 */     xMarketItem.setRoleid(roleId);
/*  593 */     xMarketItem.setRest_num(xMarketItem.getItem().getNumber());
/*  594 */     xMarketItem.setConcern_role_num(0);
/*  595 */     xMarketItem.setOnshelf_time(now);
/*  596 */     xMarketItem.setState(state);
/*      */     
/*  598 */     long marketId = Marketitem.insert(xMarketItem).longValue();
/*  599 */     return marketId;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Item separateItem(Item xSrcItem, int sepNumber)
/*      */   {
/*  642 */     int totalNumber = xSrcItem.getNumber();
/*  643 */     if (totalNumber < sepNumber)
/*      */     {
/*  645 */       return null;
/*      */     }
/*  647 */     Item newItem = Pod.newItem();
/*  648 */     ItemInterface.fillXItem(newItem, xSrcItem);
/*      */     
/*  650 */     newItem.setNumber(sepNumber);
/*  651 */     newItem.getUuid().clear();
/*      */     
/*  653 */     List<Long> uuidSet = new ArrayList(xSrcItem.getUuid());
/*  654 */     java.util.Collections.sort(uuidSet);
/*      */     
/*  656 */     List<Long> toremoveuuids = new ArrayList();
/*      */     
/*  658 */     for (int i = uuidSet.size() - 1; i >= 0; i--)
/*      */     {
/*  660 */       toremoveuuids.add(uuidSet.get(i));
/*  661 */       if (toremoveuuids.size() == sepNumber) {
/*      */         break;
/*      */       }
/*      */     }
/*      */     
/*  666 */     newItem.getUuid().addAll(toremoveuuids);
/*  667 */     xSrcItem.getUuid().removeAll(toremoveuuids);
/*      */     
/*  669 */     return newItem;
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
/*      */ 
/*      */ 
/*      */   static long createMarketPetInfo(long roleId, Pet xPet, int price, long now, long channel_id, int state)
/*      */   {
/*  686 */     xbean.MarketPet xMarketPet = Pod.newMarketPet();
/*  687 */     PetInterface.fillXpet(xMarketPet.getPet(), xPet);
/*      */     
/*  689 */     xMarketPet.setChannel_id(channel_id);
/*  690 */     xMarketPet.setPrice(price);
/*  691 */     xMarketPet.setRoleid(roleId);
/*  692 */     xMarketPet.setConcern_role_num(0);
/*  693 */     xMarketPet.setOnshelf_time(now);
/*  694 */     xMarketPet.setState(state);
/*      */     
/*  696 */     long marketId = Marketpet.insert(xMarketPet).longValue();
/*  697 */     return marketId;
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
/*      */   static void sendSSellItemRes(long roleid, long marketId, int itemId, int price, long publicEndtime, int restNum, int concernRoleNum, int state, long oldmarketid)
/*      */   {
/*  745 */     SSellItemRes res = new SSellItemRes();
/*  746 */     res.oldmarketid = oldmarketid;
/*  747 */     res.marketitem.itemid = itemId;
/*  748 */     res.marketitem.marketid = marketId;
/*  749 */     res.marketitem.price = price;
/*  750 */     res.marketitem.publicendtime = publicEndtime;
/*  751 */     res.marketitem.restnum = restNum;
/*  752 */     res.marketitem.concernrolenum = concernRoleNum;
/*  753 */     res.marketitem.state = state;
/*  754 */     OnlineManager.getInstance().send(roleid, res);
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
/*      */ 
/*      */ 
/*      */   static void sendSSellPetRes(long roleid, long marketId, int petCfgId, int price, long publicEndtime, int concernRoleNum, int state, long oldmarketid)
/*      */   {
/*  771 */     SSellPetRes res = new SSellPetRes();
/*  772 */     res.oldmarketid = oldmarketid;
/*  773 */     res.marketpet.petcfgid = petCfgId;
/*  774 */     res.marketpet.marketid = marketId;
/*  775 */     res.marketpet.price = price;
/*  776 */     res.marketpet.publicendtime = publicEndtime;
/*  777 */     res.marketpet.concernrolenum = concernRoleNum;
/*  778 */     res.marketpet.state = state;
/*  779 */     OnlineManager.getInstance().send(roleid, res);
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
/*      */ 
/*      */   static void sendSBuyItemRes(long roleid, long marketId, int itemId, int price, int restNum, int buyNum, int useMoney)
/*      */   {
/*  795 */     SBuyItemRes res = new SBuyItemRes();
/*  796 */     res.marketid = marketId;
/*  797 */     res.itemid = itemId;
/*  798 */     res.price = price;
/*  799 */     res.restnum = restNum;
/*  800 */     res.usemoney = useMoney;
/*  801 */     res.buynum = buyNum;
/*  802 */     OnlineManager.getInstance().send(roleid, res);
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
/*      */   static void sendSBuyPetRes(long roleid, long marketId, int petCfgId, int price, int useMoney)
/*      */   {
/*  816 */     SBuyPetRes res = new SBuyPetRes();
/*  817 */     res.marketid = marketId;
/*  818 */     res.petcfgid = petCfgId;
/*  819 */     res.price = price;
/*  820 */     res.usemoney = useMoney;
/*  821 */     OnlineManager.getInstance().send(roleid, res);
/*      */   }
/*      */   
/*      */ 
/*      */   static void sendSSyncSellItemNotify(long roleid, long marketId, int itemId, int restNum, int sellNum)
/*      */   {
/*  827 */     SSyncSellItemNotify res = new SSyncSellItemNotify();
/*  828 */     res.marketid = marketId;
/*  829 */     res.itemid = itemId;
/*  830 */     res.restnum = restNum;
/*  831 */     res.sellnum = sellNum;
/*  832 */     OnlineManager.getInstance().send(roleid, res);
/*      */   }
/*      */   
/*      */   static void sendSSyncSellPetNotify(long roleid, long marketId, int petCfgId)
/*      */   {
/*  837 */     SSyncSellPetNotify res = new SSyncSellPetNotify();
/*  838 */     res.marketid = marketId;
/*  839 */     res.petcfgid = petCfgId;
/*  840 */     OnlineManager.getInstance().send(roleid, res);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long computePublicTipEndTime(long onshelfTime)
/*      */   {
/*  852 */     return computePublicEndtime(onshelfTime) - TimeUnit.MINUTES.toSeconds(SMarketConsts.getInstance().TIME_BEFORE_END_PUBLIC);
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
/*      */   static long computePublicEndtime(long onshelfTime)
/*      */   {
/*  865 */     Calendar calendar = DateTimeUtils.getCalendar();
/*  866 */     calendar.setTimeInMillis(onshelfTime + TimeUnit.MINUTES.toMillis(SMarketConsts.getInstance().PUBLIC_TIME));
/*      */     
/*  868 */     long endTime = calendar.getTimeInMillis();
/*      */     
/*  870 */     long forbiddenStartTime = DateTimeUtils.getTimeInToday(endTime, SMarketConsts.getInstance().FORBIDDEN_ON_SHELF_START_HOUR, 0, 0);
/*      */     
/*  872 */     long forbiddenEndTime = DateTimeUtils.getTimeInToday(endTime, SMarketConsts.getInstance().FORBIDDEN_ON_SHELF_END_HOUR, 0, 0);
/*      */     
/*      */ 
/*  875 */     if ((forbiddenStartTime <= endTime) && (endTime < forbiddenEndTime))
/*      */     {
/*  877 */       endTime = forbiddenEndTime;
/*      */     }
/*  879 */     return TimeUnit.MILLISECONDS.toSeconds(endTime);
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
/*      */   static void tlogMarket(long roleid, int itemOrPetid, int num, int price, long cutgold, MarketOperateEnum marketOperateEnum)
/*      */   {
/*  894 */     String logname = "Market";
/*  895 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  896 */     String userid = RoleInterface.getUserId(roleid);
/*  897 */     int rolelevel = RoleInterface.getLevel(roleid);
/*      */     
/*  899 */     Object[] columns = { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(marketOperateEnum.value), Integer.valueOf(itemOrPetid), Integer.valueOf(num), Integer.valueOf(price), Long.valueOf(cutgold) };
/*      */     
/*  901 */     TLogManager.getInstance().addLog(roleid, logname, columns);
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
/*      */   static void tlogMarket(int itemOrPetid, int num, int price, long cutgold, MarketOperateEnum marketOperateEnum)
/*      */   {
/*  915 */     String logname = "Market";
/*  916 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  917 */     String userid = "";
/*  918 */     int rolelevel = 0;
/*  919 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/*  920 */     java.text.SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  921 */     long time = DateTimeUtils.getCurrTimeInMillis();
/*  922 */     String dtEventTime = sdf.format(Long.valueOf(time));
/*  923 */     String vGameAppid = "";
/*  924 */     int PlatID = 0;
/*  925 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/*  926 */     String vopenid = "";
/*  927 */     Object[] columns = { GameSvrId, dtEventTime, vGameAppid, Integer.valueOf(PlatID), Integer.valueOf(iZoneAreaID), vopenid, vGameIP, userid, Long.valueOf(0L), Integer.valueOf(rolelevel), Integer.valueOf(marketOperateEnum.value), Integer.valueOf(itemOrPetid), Integer.valueOf(num), Integer.valueOf(price), Long.valueOf(cutgold) };
/*      */     
/*  929 */     TLogManager.getInstance().addLog(logname, columns);
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
/*      */   static void tlogMarketBuy(long roleid, int itemOrPetid, int num, int price, long sellerRoleid)
/*      */   {
/*  943 */     String logname = "Marketbuy";
/*  944 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  945 */     String userid = String.valueOf(0);
/*  946 */     int rolelevel = 0;
/*  947 */     if (roleid == 0L)
/*      */     {
/*  949 */       userid = RoleInterface.getUserId(sellerRoleid);
/*  950 */       rolelevel = RoleInterface.getLevel(sellerRoleid);
/*      */     }
/*      */     else
/*      */     {
/*  954 */       userid = RoleInterface.getUserId(roleid);
/*  955 */       rolelevel = RoleInterface.getLevel(roleid);
/*      */     }
/*      */     
/*  958 */     Object[] columns = { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(itemOrPetid), Integer.valueOf(num), Integer.valueOf(price), Long.valueOf(sellerRoleid) };
/*      */     
/*  960 */     TLogManager.getInstance().addLog(userid, roleid, logname, columns);
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
/*      */ 
/*      */   static void addSaleLog(long buyRoleid, long sellRoleId, int itemOrPetid, int num, int price, long marketId, long now)
/*      */   {
/*  976 */     if ((buyRoleid == 0L) || (sellRoleId == 0L))
/*      */     {
/*  978 */       return;
/*      */     }
/*  980 */     MarketLog xMarketLog = Role2marketlog.get(Long.valueOf(buyRoleid));
/*  981 */     if (xMarketLog == null)
/*      */     {
/*  983 */       xMarketLog = Pod.newMarketLog();
/*  984 */       Role2marketlog.insert(Long.valueOf(buyRoleid), xMarketLog);
/*      */     }
/*  986 */     SaleLog xBuyLog = Pod.newSaleLog();
/*  987 */     xBuyLog.setBuytime(now);
/*  988 */     xBuyLog.setItemorpetcfgid(itemOrPetid);
/*  989 */     xBuyLog.setMarketid(marketId);
/*  990 */     xBuyLog.setNum(num);
/*  991 */     xBuyLog.setPrice(price);
/*  992 */     xBuyLog.setRoleid(sellRoleId);
/*  993 */     xMarketLog.getBuylog().add(0, xBuyLog);
/*      */     
/*  995 */     int size = xMarketLog.getBuylog().size();
/*  996 */     for (int i = size - 1; i >= SMarketConsts.getInstance().MARKET_BUY_SELL_LOG_MAX_NUM; i--)
/*      */     {
/*  998 */       xMarketLog.getBuylog().remove(i);
/*      */     }
/*      */     
/* 1001 */     MarketLog xSellerLog = Role2marketlog.get(Long.valueOf(sellRoleId));
/* 1002 */     if (xSellerLog == null)
/*      */     {
/* 1004 */       xSellerLog = Pod.newMarketLog();
/* 1005 */       Role2marketlog.insert(Long.valueOf(sellRoleId), xSellerLog);
/*      */     }
/* 1007 */     SaleLog xSellerSaleLog = Pod.newSaleLog();
/* 1008 */     xSellerSaleLog.setBuytime(now);
/* 1009 */     xSellerSaleLog.setItemorpetcfgid(itemOrPetid);
/* 1010 */     xSellerSaleLog.setMarketid(marketId);
/* 1011 */     xSellerSaleLog.setNum(num);
/* 1012 */     xSellerSaleLog.setPrice(price);
/* 1013 */     xSellerSaleLog.setRoleid(buyRoleid);
/* 1014 */     xSellerLog.getSelllog().add(0, xSellerSaleLog);
/*      */     
/* 1016 */     size = xSellerLog.getSelllog().size();
/* 1017 */     for (int i = size - 1; i >= SMarketConsts.getInstance().MARKET_BUY_SELL_LOG_MAX_NUM; i--)
/*      */     {
/* 1019 */       xSellerLog.getSelllog().remove(i);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogMarketBuyItemForIdip(long roleid, long sellerRoleid, int itemid, int num, int price, Set<Long> uuids, long shoppingId)
/*      */   {
/* 1041 */     int DealMainType = getMarketItemBigType(itemid);
/*      */     
/* 1043 */     int DealSubType = getSubidByItemId(itemid);
/* 1044 */     int DealLevel = ItemInterface.getUseLevel(itemid);
/*      */     
/*      */ 
/* 1047 */     int productType = 2;
/* 1048 */     int quality = ItemInterface.getColor(itemid);
/* 1049 */     IdipManager.marketBuyTLogAsync(roleid, sellerRoleid, itemid, num, price, uuids, shoppingId, DealMainType, DealSubType, DealLevel, 2, quality);
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
/*      */   static void tlogMarketBuyPetForIdip(long roleid, long sellerRoleid, int petCfgId, int num, int level, int quality, int price, Set<Long> petUuids, long shoppingId)
/*      */   {
/* 1074 */     int DealMainType = getMarketPetBigType(petCfgId);
/* 1075 */     int DealSubType = getSubidByPetId(petCfgId);
/*      */     
/*      */ 
/* 1078 */     int productType = 1;
/* 1079 */     IdipManager.marketBuyTLogAsync(roleid, sellerRoleid, petCfgId, num, price, petUuids, shoppingId, DealMainType, DealSubType, level, 1, quality);
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
/*      */   static void tlogMarketSellItemForIdip(long sellerRoleid, int itemId, int num, int price, Set<Long> uuids, long shoppingId, long lengthTime, int sellType)
/*      */   {
/* 1104 */     int DealMainType = getMarketPetBigType(itemId);
/* 1105 */     int DealSubType = getSubidByPetId(itemId);
/* 1106 */     int DealLevel = ItemInterface.getUseLevel(itemId);
/* 1107 */     int quality = ItemInterface.getColor(itemId);
/*      */     
/* 1109 */     int productType = 2;
/* 1110 */     IdipManager.marketSellTLogAsync(sellerRoleid, itemId, num, price, uuids, shoppingId, lengthTime, DealMainType, DealSubType, DealLevel, 2, quality);
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
/*      */ 
/*      */   static void tlogMarketSellPetForIdip(long sellerRoleid, int petCfgId, int num, int level, int quality, int price, Set<Long> petUuids, long shoppingId, long lengthTime, int sellType)
/*      */   {
/* 1137 */     int DealMainType = getMarketPetBigType(petCfgId);
/* 1138 */     int DealSubType = getSubidByPetId(petCfgId);
/*      */     
/* 1140 */     int productType = 1;
/* 1141 */     IdipManager.marketSellTLogAsync(sellerRoleid, petCfgId, num, price, petUuids, shoppingId, lengthTime, DealMainType, DealSubType, level, 1, quality);
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
/*      */   static long computeShangjiaExpireTime(long onShelfTime)
/*      */   {
/* 1154 */     return TimeUnit.MILLISECONDS.toSeconds(onShelfTime + TimeUnit.MINUTES.toMillis(SMarketConsts.getInstance().AUCTION_TIME));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getShangjiaLengthSeconds()
/*      */   {
/* 1165 */     return TimeUnit.MINUTES.toSeconds(SMarketConsts.getInstance().AUCTION_TIME);
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
/*      */   static void fillProtocolMarketItem(mzm.gsp.market.MarketItem marketItem, long marketId, xbean.MarketItem xMarketItem, AuctionItemInfo xAuctionItemInfo)
/*      */   {
/* 1179 */     marketItem.itemid = xMarketItem.getItem().getCfgid();
/* 1180 */     marketItem.marketid = marketId;
/* 1181 */     marketItem.price = xMarketItem.getPrice();
/* 1182 */     marketItem.restnum = xMarketItem.getRest_num();
/* 1183 */     marketItem.state = xMarketItem.getState();
/* 1184 */     marketItem.sellnum = (xMarketItem.getItem().getNumber() - xMarketItem.getRest_num());
/* 1185 */     if (xAuctionItemInfo != null)
/*      */     {
/* 1187 */       marketItem.publicendtime = TimeUnit.MILLISECONDS.toSeconds(xAuctionItemInfo.getEndtime());
/* 1188 */       marketItem.concernrolenum = xAuctionItemInfo.getAuctioncount();
/*      */     }
/*      */     else
/*      */     {
/* 1192 */       marketItem.concernrolenum = xMarketItem.getConcern_role_num();
/* 1193 */       if (xMarketItem.getState() == 1)
/*      */       {
/*      */ 
/* 1196 */         marketItem.publicendtime = computePublicEndtime(xMarketItem.getOnshelf_time());
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/* 1201 */         marketItem.publicendtime = computeShangjiaExpireTime(xMarketItem.getOnshelf_time());
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
/*      */ 
/*      */   static void fillProtocolMarketPet(mzm.gsp.market.MarketPet marketPet, long marketId, xbean.MarketPet xMarketPet, AuctionPetInfo xAuctionPetInfo)
/*      */   {
/* 1216 */     marketPet.petcfgid = xMarketPet.getPet().getTemplateid();
/* 1217 */     marketPet.marketid = marketId;
/* 1218 */     marketPet.price = xMarketPet.getPrice();
/* 1219 */     marketPet.state = xMarketPet.getState();
/* 1220 */     marketPet.petlevel = xMarketPet.getPet().getLevel();
/* 1221 */     if (xAuctionPetInfo != null)
/*      */     {
/* 1223 */       marketPet.publicendtime = TimeUnit.MILLISECONDS.toSeconds(xAuctionPetInfo.getEndtime());
/* 1224 */       marketPet.concernrolenum = xAuctionPetInfo.getAuctioncount();
/*      */     }
/*      */     else
/*      */     {
/* 1228 */       marketPet.concernrolenum = xMarketPet.getConcern_role_num();
/* 1229 */       if (xMarketPet.getState() == 1)
/*      */       {
/* 1231 */         marketPet.publicendtime = computePublicEndtime(xMarketPet.getOnshelf_time());
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/* 1236 */         marketPet.publicendtime = computeShangjiaExpireTime(xMarketPet.getOnshelf_time());
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
/*      */ 
/*      */   static boolean hasState(int currentState, int stateEnum)
/*      */   {
/* 1251 */     return (currentState & stateEnum) != 0;
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
/*      */   static boolean isItemInFrozenState(int itemId, long marketBuytime)
/*      */   {
/* 1264 */     if (SMarketItemCfg.get(itemId) == null)
/*      */     {
/* 1266 */       return false;
/*      */     }
/* 1268 */     return marketBuytime + SMarketItemCfg.get(itemId).forzentime >= TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis());
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
/*      */   static boolean isPetInFrozenState(int petCfgId, long marketBuytime)
/*      */   {
/* 1282 */     if (SMarketPetCfg.get(petCfgId) == null)
/*      */     {
/* 1284 */       return false;
/*      */     }
/* 1286 */     return marketBuytime + SMarketPetCfg.get(petCfgId).forzentime >= TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isMarketOpen(long roleid)
/*      */   {
/* 1298 */     return RoleInterface.getLevel(roleid) >= SMarketConsts.getInstance().ROLE_LEVEL_FOR_OPEN_MARKET;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isMarketSwitchOpenForRole(long roleid)
/*      */   {
/* 1310 */     if (!OpenInterface.getOpenStatus(24))
/*      */     {
/* 1312 */       return false;
/*      */     }
/* 1314 */     if (OpenInterface.isBanPlay(roleid, 24))
/*      */     {
/* 1316 */       OpenInterface.sendBanPlayMsg(roleid, 24);
/* 1317 */       return false;
/*      */     }
/* 1319 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getMinPointForSellPet(int petCfgId)
/*      */   {
/* 1331 */     if (SMarketPetCfg.get(petCfgId) == null)
/*      */     {
/* 1333 */       return -1;
/*      */     }
/* 1335 */     return SMarketPetCfg.get(petCfgId).minPoint;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void removeRolecConcernIds(RoleMarketInfo xRoleMarketInfo)
/*      */   {
/* 1345 */     List<Long> toRemoveItemList = new ArrayList();
/* 1346 */     for (Iterator i$ = xRoleMarketInfo.getConcern_item_ids().iterator(); i$.hasNext();) { long marketId = ((Long)i$.next()).longValue();
/*      */       
/* 1348 */       xbean.MarketItem xMarketItem = Marketitem.select(Long.valueOf(marketId));
/* 1349 */       if ((xMarketItem == null) || (xMarketItem.getRest_num() == 0) || (xMarketItem.getState() == 4) || (hasState(xMarketItem.getState(), 8)))
/*      */       {
/*      */ 
/* 1352 */         toRemoveItemList.add(Long.valueOf(marketId));
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1357 */     xRoleMarketInfo.getConcern_item_ids().removeAll(toRemoveItemList);
/* 1358 */     List<Long> toRemovePetList = new ArrayList();
/* 1359 */     for (Iterator i$ = xRoleMarketInfo.getConcern_pet_ids().iterator(); i$.hasNext();) { long marketId = ((Long)i$.next()).longValue();
/*      */       
/* 1361 */       xbean.MarketPet xMarketPet = Marketpet.select(Long.valueOf(marketId));
/* 1362 */       if ((xMarketPet == null) || (xMarketPet.getState() == 4) || (xMarketPet.getState() == 8))
/*      */       {
/*      */ 
/* 1365 */         toRemovePetList.add(Long.valueOf(marketId));
/*      */       }
/*      */     }
/*      */     
/* 1369 */     xRoleMarketInfo.getConcern_pet_ids().removeAll(toRemovePetList);
/*      */   }
/*      */   
/*      */   static int getMarketItemBigType(int itemId)
/*      */   {
/* 1374 */     int subid = getSubidByItemId(itemId);
/* 1375 */     if (SMarketSubTypeCfg.get(subid) == null)
/*      */     {
/* 1377 */       return -1;
/*      */     }
/* 1379 */     return SMarketSubTypeCfg.get(subid).marketCfgId;
/*      */   }
/*      */   
/*      */   static int getMarketPetBigType(int petCfgId)
/*      */   {
/* 1384 */     int subid = getSubidByPetId(petCfgId);
/* 1385 */     if (SMarketSubTypeCfg.get(subid) == null)
/*      */     {
/* 1387 */       return -1;
/*      */     }
/* 1389 */     return SMarketSubTypeCfg.get(subid).marketCfgId;
/*      */   }
/*      */   
/*      */   static int getConcernMax()
/*      */   {
/* 1394 */     return 10000;
/*      */   }
/*      */   
/*      */   static void addMarketTimeOutOrSelledItem(RoleMarketInfo xRoleMarketInfo, long marketId, xbean.MarketItem xMarketItem)
/*      */   {
/* 1399 */     xbean.MarketItem xMarketItem2 = Pod.newMarketItem();
/* 1400 */     xMarketItem2.setChannel_id(xMarketItem.getChannel_id());
/* 1401 */     xMarketItem2.setConcern_role_num(xMarketItem.getConcern_role_num());
/* 1402 */     xMarketItem2.setOnshelf_time(xMarketItem.getOnshelf_time());
/* 1403 */     xMarketItem2.setPrice(xMarketItem.getPrice());
/* 1404 */     xMarketItem2.setRest_num(xMarketItem.getRest_num());
/* 1405 */     xMarketItem2.setRoleid(xMarketItem.getRoleid());
/* 1406 */     xMarketItem2.setState(xMarketItem.getState());
/* 1407 */     ItemInterface.fillXItem(xMarketItem2.getItem(), xMarketItem.getItem());
/* 1408 */     xRoleMarketInfo.getMarketid2timeoutorselleditem().put(Long.valueOf(marketId), xMarketItem2);
/*      */   }
/*      */   
/*      */   static void addMarketTimeOutOrSelledPet(RoleMarketInfo xRoleMarketInfo, long marketId, xbean.MarketPet xMarketPet)
/*      */   {
/* 1413 */     xbean.MarketPet xMarketPet2 = Pod.newMarketPet();
/* 1414 */     xMarketPet2.setChannel_id(xMarketPet.getChannel_id());
/* 1415 */     xMarketPet2.setConcern_role_num(xMarketPet.getConcern_role_num());
/* 1416 */     xMarketPet2.setOnshelf_time(xMarketPet.getOnshelf_time());
/* 1417 */     xMarketPet2.setPrice(xMarketPet.getPrice());
/*      */     
/* 1419 */     xMarketPet2.setRoleid(xMarketPet.getRoleid());
/* 1420 */     xMarketPet2.setState(xMarketPet.getState());
/* 1421 */     PetInterface.fillXpet(xMarketPet2.getPet(), xMarketPet.getPet());
/* 1422 */     xRoleMarketInfo.getMarketid2timeoutorselledpet().put(Long.valueOf(marketId), xMarketPet2);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void removeMarketIdFromPetChannel(long petLockKey, long marketId, long channlel_id)
/*      */   {
/* 1434 */     MarketIds xMarketIds = Channel2marketids.get(Long.valueOf(channlel_id));
/* 1435 */     if (xMarketIds != null)
/*      */     {
/* 1437 */       xMarketIds.getMarket_ids().remove(Long.valueOf(marketId));
/* 1438 */       if (xMarketIds.getMarket_ids().isEmpty())
/*      */       {
/* 1440 */         Channel2marketids.remove(Long.valueOf(channlel_id));
/* 1441 */         MarketChannelIds xMarketChannelIds = Pet2marketchannelids.get(Long.valueOf(petLockKey));
/* 1442 */         xMarketChannelIds.getChannel_ids().remove(Long.valueOf(channlel_id));
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
/*      */   static void removeMarketIdFromItemChannel(long itemLockKey, long marketId, long channlel_id)
/*      */   {
/* 1456 */     MarketIds xMarketIds = Channel2marketids.get(Long.valueOf(channlel_id));
/* 1457 */     if (xMarketIds != null)
/*      */     {
/*      */ 
/* 1460 */       xMarketIds.getMarket_ids().remove(Long.valueOf(marketId));
/* 1461 */       if (xMarketIds.getMarket_ids().isEmpty())
/*      */       {
/* 1463 */         Channel2marketids.remove(Long.valueOf(channlel_id));
/* 1464 */         MarketChannelIds xMarketChannelIds = Item2marketchannelids.get(Long.valueOf(itemLockKey));
/* 1465 */         xMarketChannelIds.getChannel_ids().remove(Long.valueOf(channlel_id));
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
/*      */ 
/*      */ 
/*      */ 
/*      */   static void sendAuctionPublicEndTipMailToSeller(long sellerRoleid, long marketId, int itemIdOrpetCfgId, String name, int price)
/*      */   {
/* 1482 */     mzm.gsp.tlog.TLogArg logArg = new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.MARKET_AUCTION_PUBLIC_END_TIP_MAIL, itemIdOrpetCfgId);
/* 1483 */     List<String> contentArgs = new ArrayList();
/* 1484 */     contentArgs.add(name);
/* 1485 */     contentArgs.add(String.valueOf(0));
/* 1486 */     contentArgs.add(String.valueOf(price));
/*      */     
/* 1488 */     mzm.gsp.mail.main.MailInterface.asynBuildAndSendMail(sellerRoleid, SMarketConsts.getInstance().SELLER_AUCTION_PUBLIC_END_TIP_MAIL_ID, null, contentArgs, null, logArg);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void sendBulletinForItem(String sellerName, long marketId, int itemId, int price, boolean isPub)
/*      */   {
/* 1495 */     SMarketItemCfg marketItemCfg = SMarketItemCfg.get(itemId);
/* 1496 */     if (marketItemCfg == null)
/*      */     {
/* 1498 */       return;
/*      */     }
/* 1500 */     if (price >= marketItemCfg.priceForBulletin)
/*      */     {
/* 1502 */       SMarketItemPetBulletinRes res = new SMarketItemPetBulletinRes();
/* 1503 */       res.rolename = sellerName;
/* 1504 */       res.itemidorpetcfgid = itemId;
/* 1505 */       res.price = price;
/* 1506 */       res.marketid = marketId;
/* 1507 */       res.puborsell = (isPub ? 0 : 1);
/*      */       
/* 1509 */       OnlineManager.getInstance().sendAll(res);
/*      */     }
/*      */   }
/*      */   
/*      */   static void sendBulletinForPet(String sellerName, long marketId, int petCfgId, int price, boolean isPub)
/*      */   {
/* 1515 */     SMarketPetCfg marketPetCfg = SMarketPetCfg.get(petCfgId);
/* 1516 */     if (marketPetCfg == null)
/*      */     {
/* 1518 */       return;
/*      */     }
/* 1520 */     if (price >= marketPetCfg.priceForBulletin)
/*      */     {
/* 1522 */       SMarketItemPetBulletinRes res = new SMarketItemPetBulletinRes();
/* 1523 */       res.rolename = sellerName;
/* 1524 */       res.itemidorpetcfgid = petCfgId;
/* 1525 */       res.price = price;
/* 1526 */       res.marketid = marketId;
/* 1527 */       res.puborsell = (isPub ? 0 : 1);
/*      */       
/* 1529 */       OnlineManager.getInstance().sendAll(res);
/*      */     }
/*      */   }
/*      */   
/*      */   static boolean isItemWithSkill(Item xItem)
/*      */   {
/* 1535 */     int skill = ItemInterface.getEquipSkill(xItem);
/* 1536 */     if (skill == -1)
/*      */     {
/* 1538 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 1542 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   static void removeEquipSkill(Item xItem)
/*      */   {
/* 1548 */     xItem.getExtra().remove(Integer.valueOf(6));
/*      */   }
/*      */   
/*      */   static void synSSynMarketItemBanTradeRes(long roleid)
/*      */   {
/* 1553 */     Set<Integer> itemIds = ItemBanTrade.getInstance().getBanTradeIds(ItemBanTrade.TradeTypeEnum.MARKET_ITEM.value);
/* 1554 */     SSynMarketItemBanTradeRes res = new SSynMarketItemBanTradeRes();
/* 1555 */     res.itemids.addAll(itemIds);
/* 1556 */     OnlineManager.getInstance().send(roleid, res);
/*      */   }
/*      */   
/*      */   static void synSSynMarketPetBanTradeRes(long roleid)
/*      */   {
/* 1561 */     Set<Integer> petCfgIds = ItemBanTrade.getInstance().getBanTradeIds(ItemBanTrade.TradeTypeEnum.MARKET_PET.value);
/* 1562 */     SSynMarketPetBanTradeRes res = new SSynMarketPetBanTradeRes();
/* 1563 */     res.petcfgids.addAll(petCfgIds);
/* 1564 */     OnlineManager.getInstance().send(roleid, res);
/*      */   }
/*      */   
/*      */   static void synMarketItemBanTradeStateRes(int itemid, int state)
/*      */   {
/* 1569 */     SItemBanTradeRes res = new SItemBanTradeRes();
/* 1570 */     res.itemid = itemid;
/* 1571 */     res.state = state;
/* 1572 */     OnlineManager.getInstance().sendAll(res);
/*      */   }
/*      */   
/*      */   static void synMarketPetBanTradeStateRes(int petCfgId, int state)
/*      */   {
/* 1577 */     SPetBanTradeRes res = new SPetBanTradeRes();
/* 1578 */     res.petcfgid = petCfgId;
/* 1579 */     res.state = state;
/* 1580 */     OnlineManager.getInstance().sendAll(res);
/*      */   }
/*      */   
/*      */   static int computeOffSheldNeedGold(int price)
/*      */   {
/* 1585 */     return (int)(price * (SMarketConsts.getInstance().AUCTION_GOODS_OFF_SHELF_RATE / 10000.0F));
/*      */   }
/*      */   
/*      */   static boolean isCutGoldSwitchOpen()
/*      */   {
/* 1590 */     if (!OpenInterface.getOpenStatus(273))
/*      */     {
/* 1592 */       return false;
/*      */     }
/* 1594 */     return true;
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
/*      */   static ChannelIdXMarketIdsBean findChannelIdXMarketIdsBean(MarketChannelIds xMarketChannelIds, int channelSize)
/*      */   {
/* 1607 */     long channelid = findLastChannelid(xMarketChannelIds);
/* 1608 */     MarketIds xMarketIds = null;
/* 1609 */     if (channelid != -1L)
/*      */     {
/* 1611 */       xMarketIds = Channel2marketids.select(Long.valueOf(channelid));
/* 1612 */       if ((xMarketIds == null) || (xMarketIds.getMarket_ids().size() >= channelSize))
/*      */       {
/* 1614 */         return addXMarketIds(xMarketChannelIds);
/*      */       }
/*      */       
/*      */ 
/* 1618 */       xMarketIds = Channel2marketids.get(Long.valueOf(channelid));
/* 1619 */       if ((xMarketIds == null) || (xMarketIds.getMarket_ids().size() >= channelSize))
/*      */       {
/* 1621 */         return null;
/*      */       }
/*      */       
/*      */ 
/* 1625 */       return new ChannelIdXMarketIdsBean(channelid, xMarketIds);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1631 */     return addXMarketIds(xMarketChannelIds);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static ChannelIdXMarketIdsBean addXMarketIds(MarketChannelIds xMarketChannelIds)
/*      */   {
/* 1639 */     MarketIds xMarketIds = Pod.newMarketIds();
/*      */     
/* 1641 */     long channelid = Channel2marketids.insert(xMarketIds).longValue();
/* 1642 */     xMarketChannelIds.getChannel_ids().add(Long.valueOf(channelid));
/* 1643 */     return new ChannelIdXMarketIdsBean(channelid, xMarketIds);
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean addSupplySession(int itemIdOrPetCfgId, long interval)
/*      */   {
/* 1649 */     boolean ret = MarketSupplySessionIdManager.getInstance().addSession(itemIdOrPetCfgId, interval);
/* 1650 */     if (ret)
/*      */     {
/* 1652 */       String logStr = String.format("[market]MarketManager.onItemOrPetOffShelf@start supply session success|itemIdOrPetCfgId=%d|interval=%d", new Object[] { Integer.valueOf(itemIdOrPetCfgId), Long.valueOf(interval) });
/*      */       
/*      */ 
/* 1655 */       logger.info(logStr);
/*      */     }
/*      */     else
/*      */     {
/* 1659 */       String logStr = String.format("[market]MarketManager.onItemOrPetOffShelf@supply session is already exists|itemIdOrPetCfgId=%d|interval=%d", new Object[] { Integer.valueOf(itemIdOrPetCfgId), Long.valueOf(interval) });
/*      */       
/*      */ 
/* 1662 */       logger.info(logStr);
/*      */     }
/* 1664 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static boolean removeSupplySession(int itemIdOrPetCfgId)
/*      */   {
/* 1671 */     boolean ret = MarketSupplySessionIdManager.getInstance().removeSession(itemIdOrPetCfgId);
/* 1672 */     if (ret)
/*      */     {
/* 1674 */       String logStr = String.format("[market]MarketManager.onItemOrPetOnShelf@remove supply session success|itemIdOrPetCfgId=%d", new Object[] { Integer.valueOf(itemIdOrPetCfgId) });
/*      */       
/*      */ 
/* 1677 */       logger.info(logStr);
/*      */     }
/*      */     else
/*      */     {
/* 1681 */       String logStr = String.format("[market]MarketManager.onItemOrPetOnShelf@supply session is not exists|itemIdOrPetCfgId=%d", new Object[] { Integer.valueOf(itemIdOrPetCfgId) });
/*      */       
/*      */ 
/* 1684 */       logger.info(logStr);
/*      */     }
/*      */     
/* 1687 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean canRecycleItem(xbean.MarketItem xMarketItem)
/*      */   {
/* 1693 */     if (xMarketItem.getRoleid() == 0L)
/*      */     {
/* 1695 */       return false;
/*      */     }
/* 1697 */     if (!isMarketRecycleSwitchOpenForRole(xMarketItem.getRoleid()))
/*      */     {
/* 1699 */       return false;
/*      */     }
/* 1701 */     SMarketItemCfg marketItemCfg = SMarketItemCfg.get(xMarketItem.getItem().getCfgid());
/* 1702 */     if (marketItemCfg == null)
/*      */     {
/* 1704 */       return false;
/*      */     }
/* 1706 */     if (xMarketItem.getPrice() > marketItemCfg.priceRateToRecycle * marketItemCfg.minprice)
/*      */     {
/* 1708 */       return false;
/*      */     }
/* 1710 */     int randonNum = Xdb.random().nextInt(10000);
/* 1711 */     if (randonNum < marketItemCfg.recycleRate)
/*      */     {
/* 1713 */       return true;
/*      */     }
/*      */     
/*      */ 
/* 1717 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static boolean canRecyclePet(xbean.MarketPet xMarketPet)
/*      */   {
/* 1724 */     if (xMarketPet.getRoleid() == 0L)
/*      */     {
/* 1726 */       return false;
/*      */     }
/* 1728 */     if (!isMarketRecycleSwitchOpenForRole(xMarketPet.getRoleid()))
/*      */     {
/* 1730 */       return false;
/*      */     }
/* 1732 */     SMarketPetCfg marketPetCfg = SMarketPetCfg.get(xMarketPet.getPet().getTemplateid());
/* 1733 */     if (marketPetCfg == null)
/*      */     {
/* 1735 */       return false;
/*      */     }
/* 1737 */     PetPriceBean petPriceBean = getPetPriceBean(xMarketPet.getPet());
/* 1738 */     if (xMarketPet.getPrice() > marketPetCfg.priceRateToRecycle * petPriceBean.getMinPrice())
/*      */     {
/* 1740 */       return false;
/*      */     }
/*      */     
/* 1743 */     int randonNum = Xdb.random().nextInt(10000);
/* 1744 */     if (randonNum < marketPetCfg.recycleRate)
/*      */     {
/* 1746 */       return true;
/*      */     }
/*      */     
/*      */ 
/* 1750 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getRecycleSeconds(int itemIdOrPetCfgId)
/*      */   {
/* 1762 */     SMarketItemCfg marketItemCfg = SMarketItemCfg.get(itemIdOrPetCfgId);
/* 1763 */     if (marketItemCfg != null)
/*      */     {
/* 1765 */       int minutes = marketItemCfg.minRecycletime + Xdb.random().nextInt(marketItemCfg.maxRecycletime - marketItemCfg.minRecycletime);
/*      */       
/* 1767 */       return TimeUnit.MINUTES.toSeconds(minutes);
/*      */     }
/*      */     
/* 1770 */     SMarketPetCfg marketPetCfg = SMarketPetCfg.get(itemIdOrPetCfgId);
/* 1771 */     if (marketPetCfg != null)
/*      */     {
/* 1773 */       int minutes = marketPetCfg.minRecycletime + Xdb.random().nextInt(marketPetCfg.maxRecycletime - marketPetCfg.minRecycletime);
/*      */       
/* 1775 */       return TimeUnit.MINUTES.toSeconds(minutes);
/*      */     }
/* 1777 */     return 10000L;
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
/*      */ 
/*      */ 
/*      */   static void startOnSellItemPhaseSession(long marketId, xbean.MarketItem xMarketItem, long recycleSec, long shangJiaSec)
/*      */   {
/* 1794 */     Marketitem2sessionid.remove(Long.valueOf(marketId));
/* 1795 */     if (canRecycleItem(xMarketItem))
/*      */     {
/* 1797 */       RecycleItemSession recycleItemSession = new RecycleItemSession(recycleSec, marketId);
/* 1798 */       Marketitem2sessionid.insert(Long.valueOf(marketId), Long.valueOf(recycleItemSession.getSessionId()));
/* 1799 */       String logStr = String.format("[market]MarketManager.startOnSellItemPhaseSession@market item start recycle session|itemid=%d|num=%d|price=%d|marketid=%d|recycle_seconds=%d|seller_roleid=%d", new Object[] { Integer.valueOf(xMarketItem.getItem().getCfgid()), Integer.valueOf(xMarketItem.getRest_num()), Integer.valueOf(xMarketItem.getPrice()), Long.valueOf(marketId), Long.valueOf(recycleSec), Long.valueOf(xMarketItem.getRoleid()) });
/*      */       
/*      */ 
/*      */ 
/* 1803 */       logger.info(logStr);
/*      */     }
/*      */     else
/*      */     {
/* 1807 */       MarketItemSession marketItemSession = new MarketItemSession(shangJiaSec, marketId);
/* 1808 */       Marketitem2sessionid.insert(Long.valueOf(marketId), Long.valueOf(marketItemSession.getSessionId()));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void startOnSellPetPhaseSession(long marketId, xbean.MarketPet xMarketPet, long recycleSec, long shangJiaSec)
/*      */   {
/* 1825 */     Marketpet2sessionid.remove(Long.valueOf(marketId));
/* 1826 */     if (canRecyclePet(xMarketPet))
/*      */     {
/* 1828 */       RecyclePetSession recyclePetSession = new RecyclePetSession(recycleSec, marketId);
/* 1829 */       Marketpet2sessionid.insert(Long.valueOf(marketId), Long.valueOf(recyclePetSession.getSessionId()));
/* 1830 */       String logStr = String.format("[market]MarketManager.startOnSellPetPhaseSession@market pet start recycle session|petcfgid=%d|price=%d|marketid=%d|recycle_seconds=%d|seller_roleid=%d", new Object[] { Integer.valueOf(xMarketPet.getPet().getTemplateid()), Integer.valueOf(xMarketPet.getPrice()), Long.valueOf(marketId), Long.valueOf(recycleSec), Long.valueOf(xMarketPet.getRoleid()) });
/*      */       
/*      */ 
/* 1833 */       logger.info(logStr);
/*      */     }
/*      */     else
/*      */     {
/* 1837 */       MarketPetSession marketPetSession = new MarketPetSession(shangJiaSec, marketId);
/* 1838 */       Marketpet2sessionid.insert(Long.valueOf(marketId), Long.valueOf(marketPetSession.getSessionId()));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void logMarketBuyItem(long buyRoleid, long sellerRoleid, long marketId, int itemId, int num, int price, Set<Long> uuids, long now)
/*      */   {
/* 1857 */     tlogMarketBuy(buyRoleid, itemId, num, price, sellerRoleid);
/* 1858 */     addSaleLog(buyRoleid, sellerRoleid, itemId, num, price, marketId, now);
/* 1859 */     tlogMarketBuyItemForIdip(buyRoleid, sellerRoleid, itemId, num, price, uuids, marketId);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void logMarketBuyPet(long buyRoleid, long sellerRoleid, long marketId, int petCfgId, int num, int price, int petLevel, int petScoreLevel, long petid, long now)
/*      */   {
/* 1879 */     tlogMarketBuy(buyRoleid, petCfgId, num, price, sellerRoleid);
/* 1880 */     addSaleLog(buyRoleid, sellerRoleid, petCfgId, num, price, marketId, now);
/* 1881 */     Set<Long> uuids = new HashSet();
/* 1882 */     uuids.add(Long.valueOf(petid));
/* 1883 */     tlogMarketBuyPetForIdip(buyRoleid, sellerRoleid, petCfgId, 1, petLevel, petScoreLevel, price, uuids, marketId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isMarketRecycleSwitchOpenForRole(long roleid)
/*      */   {
/* 1895 */     if (!OpenInterface.getOpenStatus(317))
/*      */     {
/* 1897 */       return false;
/*      */     }
/* 1899 */     if (OpenInterface.isBanPlay(roleid, 317))
/*      */     {
/* 1901 */       OpenInterface.sendBanPlayMsg(roleid, 317);
/* 1902 */       return false;
/*      */     }
/* 1904 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isMarketSupplySwitchOpen()
/*      */   {
/* 1914 */     if (!OpenInterface.getOpenStatus(318))
/*      */     {
/* 1916 */       return false;
/*      */     }
/* 1918 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static int getTotalOnsellItemNum(boolean canPile, MarketChannelIds xChannelIds)
/*      */   {
/* 1929 */     int num = 0;
/* 1930 */     for (Iterator i$ = xChannelIds.getChannel_ids().iterator(); i$.hasNext();) { long channelid = ((Long)i$.next()).longValue();
/*      */       
/* 1932 */       List<Long> xMarketIds = Channel2marketids.selectMarket_ids(Long.valueOf(channelid));
/* 1933 */       if ((xMarketIds != null) && (!xMarketIds.isEmpty()))
/*      */       {
/*      */         Iterator i$;
/*      */         
/* 1937 */         if (canPile)
/*      */         {
/* 1939 */           for (i$ = xMarketIds.iterator(); i$.hasNext();) { long marketid = ((Long)i$.next()).longValue();
/*      */             
/* 1941 */             Integer restNum = Marketitem.selectRest_num(Long.valueOf(marketid));
/* 1942 */             if (restNum != null)
/*      */             {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1948 */               num += restNum.intValue();
/*      */             }
/*      */             
/*      */           }
/*      */           
/*      */         } else {
/* 1954 */           num += xMarketIds.size();
/*      */         }
/*      */       }
/*      */     }
/* 1958 */     return num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean canSupplyItem(int itemid, SMarketSupplyItemCfg marketSupplyItemCfg)
/*      */   {
/* 1969 */     if (!isMarketSupplySwitchOpen())
/*      */     {
/* 1971 */       return false;
/*      */     }
/* 1973 */     int currentLevel = mzm.gsp.server.main.ServerInterface.getCurrentServerLevel();
/* 1974 */     if (currentLevel < marketSupplyItemCfg.minServerLevel)
/*      */     {
/* 1976 */       return false;
/*      */     }
/* 1978 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.MARKET_ITEM.value, itemid))
/*      */     {
/* 1980 */       return false;
/*      */     }
/* 1982 */     if (GameServerInfoManager.isRoamServer())
/*      */     {
/* 1984 */       return false;
/*      */     }
/* 1986 */     MarketChannelIds xChannelIds = getMarketItemChannelIdsOnAdd(itemid);
/* 1987 */     if (xChannelIds.getSupply_num() >= marketSupplyItemCfg.daySupplyNum)
/*      */     {
/* 1989 */       return false;
/*      */     }
/* 1991 */     boolean canPile = ItemInterface.getPileMaxCount(itemid) > 1;
/* 1992 */     int num = getTotalOnsellItemNum(canPile, xChannelIds);
/* 1993 */     if (num >= marketSupplyItemCfg.minMarketItemNum)
/*      */     {
/* 1995 */       return false;
/*      */     }
/* 1997 */     String logStr = String.format("[market]MarketManager.canSupplyItem@market can supply item|itemid=%d|onsell_num=%d|minMarketItemNum=%d|currnet_server_level=%d|min_need_supply_level=%d", new Object[] { Integer.valueOf(itemid), Integer.valueOf(num), Integer.valueOf(marketSupplyItemCfg.minMarketItemNum), Integer.valueOf(currentLevel), Integer.valueOf(marketSupplyItemCfg.minServerLevel) });
/*      */     
/*      */ 
/* 2000 */     logger.info(logStr);
/* 2001 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean canSupplyPet(int petCfgId)
/*      */   {
/* 2007 */     if (!isMarketSupplySwitchOpen())
/*      */     {
/* 2009 */       return false;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 2015 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.MARKET_PET.value, petCfgId))
/*      */     {
/* 2017 */       return false;
/*      */     }
/* 2019 */     if (GameServerInfoManager.isRoamServer())
/*      */     {
/* 2021 */       return false;
/*      */     }
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
/* 2033 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   static int randomSupplyItemNum(SMarketSupplyItemCfg sMarketSupplyItemCfg, MarketChannelIds xChannelIds)
/*      */   {
/* 2039 */     int supplyNum = sMarketSupplyItemCfg.minSupplyNum + Xdb.random().nextInt(sMarketSupplyItemCfg.maxSupplyNum - sMarketSupplyItemCfg.minSupplyNum);
/*      */     
/* 2041 */     int restDaySupplyNum = sMarketSupplyItemCfg.daySupplyNum - xChannelIds.getSupply_num();
/* 2042 */     if (supplyNum > restDaySupplyNum)
/*      */     {
/* 2044 */       supplyNum = restDaySupplyNum;
/*      */     }
/* 2046 */     return supplyNum;
/*      */   }
/*      */   
/*      */   static Map<Integer, Integer> randomSupplyItemGridsNum(int itemid, int totalNum)
/*      */   {
/* 2051 */     int pixNum = ItemInterface.getPileMaxCount(itemid);
/* 2052 */     if (pixNum <= 0)
/*      */     {
/* 2054 */       return null;
/*      */     }
/* 2056 */     int minNeedGrids = (totalNum - 1) / pixNum + 1;
/* 2057 */     int maxNeedGrids = totalNum;
/* 2058 */     int gridNum = minNeedGrids;
/* 2059 */     if (maxNeedGrids > minNeedGrids)
/*      */     {
/* 2061 */       gridNum += Xdb.random().nextInt(maxNeedGrids - minNeedGrids + 1);
/*      */     }
/* 2063 */     return randomGrids(pixNum, totalNum, gridNum);
/*      */   }
/*      */   
/*      */   private static Map<Integer, Integer> randomGrids(int pixNum, int totalNum, int gridNum)
/*      */   {
/* 2068 */     if (totalNum < gridNum)
/*      */     {
/* 2070 */       return null;
/*      */     }
/* 2072 */     Map<Integer, Integer> index2Num = new java.util.HashMap();
/* 2073 */     for (int i = 0; i < gridNum; i++)
/*      */     {
/* 2075 */       index2Num.put(Integer.valueOf(i), Integer.valueOf(1));
/*      */     }
/* 2077 */     int restNum = totalNum - gridNum;
/* 2078 */     int canAddIndex = findCanAddIndex(pixNum, index2Num);
/* 2079 */     while ((restNum > 0) && (canAddIndex != -1))
/*      */     {
/* 2081 */       int hasNum = ((Integer)index2Num.get(Integer.valueOf(canAddIndex))).intValue();
/* 2082 */       int canAddNum = pixNum - hasNum;
/* 2083 */       int r = Math.min(canAddNum, restNum);
/*      */       
/* 2085 */       int addNum = Xdb.random().nextInt(r + 1);
/*      */       
/* 2087 */       index2Num.put(Integer.valueOf(canAddIndex), Integer.valueOf(hasNum + addNum));
/* 2088 */       restNum -= addNum;
/* 2089 */       canAddIndex = findCanAddIndex(pixNum, index2Num);
/*      */     }
/*      */     
/* 2092 */     return index2Num;
/*      */   }
/*      */   
/*      */   private static int findCanAddIndex(int pixNum, Map<Integer, Integer> index2Num)
/*      */   {
/* 2097 */     int startKey = Xdb.random().nextInt(index2Num.size());
/* 2098 */     int count = 0;
/* 2099 */     int size = index2Num.size();
/* 2100 */     while (count < size)
/*      */     {
/* 2102 */       if (((Integer)index2Num.get(Integer.valueOf(startKey))).intValue() < pixNum)
/*      */       {
/* 2104 */         return startKey;
/*      */       }
/* 2106 */       startKey++;
/* 2107 */       if (startKey >= size)
/*      */       {
/* 2109 */         startKey = 0;
/*      */       }
/* 2111 */       count++;
/*      */     }
/*      */     
/* 2114 */     return -1;
/*      */   }
/*      */   
/*      */   static double randomSupplyItemPrice(Item xItem, SMarketSupplyItemCfg sMarketSupplyItemCfg)
/*      */   {
/* 2119 */     int size = sMarketSupplyItemCfg.priceRate2Weight.size();
/*      */     
/* 2121 */     int totalWeight = ((PriceRate2Weight)sMarketSupplyItemCfg.priceRate2Weight.get(size - 1)).weight;
/* 2122 */     int r = Xdb.random().nextInt(totalWeight);
/* 2123 */     for (int i = 0; i < size; i++)
/*      */     {
/* 2125 */       if (r < ((PriceRate2Weight)sMarketSupplyItemCfg.priceRate2Weight.get(i)).weight)
/*      */       {
/* 2127 */         if (isEquipItem(xItem.getCfgid()))
/*      */         {
/* 2129 */           boolean isWithSkill = isItemWithSkill(xItem);
/* 2130 */           if (isWithSkill)
/*      */           {
/* 2132 */             return ((PriceRate2Weight)sMarketSupplyItemCfg.priceRate2Weight.get(i)).priceRate * sMarketSupplyItemCfg.extraRate;
/*      */           }
/*      */           
/*      */ 
/* 2136 */           return ((PriceRate2Weight)sMarketSupplyItemCfg.priceRate2Weight.get(i)).priceRate;
/*      */         }
/*      */         
/* 2139 */         if (isPetEquipItem(xItem.getCfgid()))
/*      */         {
/* 2141 */           return ((PriceRate2Weight)sMarketSupplyItemCfg.priceRate2Weight.get(i)).priceRate * sMarketSupplyItemCfg.extraRate;
/*      */         }
/*      */         
/*      */ 
/* 2145 */         return ((PriceRate2Weight)sMarketSupplyItemCfg.priceRate2Weight.get(i)).priceRate;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 2150 */     return -1.0D;
/*      */   }
/*      */   
/*      */   static boolean isEquipItem(int itemid)
/*      */   {
/* 2155 */     return mzm.gsp.item.confbean.SItemEquipCfg.get(itemid) != null;
/*      */   }
/*      */   
/*      */   static boolean isPetEquipItem(int itemid)
/*      */   {
/* 2160 */     return mzm.gsp.petequip.confbean.SPetEquipItem.get(itemid) != null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean tryStartSupplyItemSession(int itemid)
/*      */   {
/* 2171 */     SMarketSupplyItemCfg sMarketSupplyItemCfg = SMarketSupplyItemCfg.get(itemid);
/* 2172 */     if (sMarketSupplyItemCfg == null)
/*      */     {
/* 2174 */       return false;
/*      */     }
/* 2176 */     if (!canSupplyItem(itemid, sMarketSupplyItemCfg))
/*      */     {
/* 2178 */       return false;
/*      */     }
/* 2180 */     return addSupplySession(itemid, TimeUnit.MINUTES.toSeconds(sMarketSupplyItemCfg.persistMinutes));
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\MarketManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */