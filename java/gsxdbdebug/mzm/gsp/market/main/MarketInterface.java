/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.market.SSearchRestTimeRes;
/*     */ import mzm.gsp.market.confbean.SItemSubTypeIds;
/*     */ import mzm.gsp.market.confbean.SMarketCfg;
/*     */ import mzm.gsp.market.confbean.SMarketSubTypeCfg;
/*     */ import mzm.gsp.market.confbean.SPetSubTypeIds;
/*     */ import mzm.gsp.market.event.BuyPetArg;
/*     */ import mzm.gsp.market.event.BuyPetEvent;
/*     */ import mzm.gsp.market.event.GetBackPetArg;
/*     */ import mzm.gsp.market.event.GetBackPetEvent;
/*     */ import mzm.gsp.market.event.MarketItemArg;
/*     */ import mzm.gsp.market.event.MarketItemOffShelf;
/*     */ import mzm.gsp.market.event.MarketItemOffShelfArg;
/*     */ import mzm.gsp.market.event.MarketItemOnShelf;
/*     */ import mzm.gsp.market.event.MarketPetArg;
/*     */ import mzm.gsp.market.event.MarketPetOffShelf;
/*     */ import mzm.gsp.market.event.MarketPetOffShelfArg;
/*     */ import mzm.gsp.market.event.MarketPetOnShelf;
/*     */ import mzm.gsp.market.event.SellPetArg;
/*     */ import mzm.gsp.market.event.SellPetEvent;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AuctionItemInfo;
/*     */ import xbean.AuctionPetInfo;
/*     */ import xbean.Item;
/*     */ import xbean.Pet;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleMarketInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MarketInterface
/*     */ {
/*     */   public static List<MarketLevelPriceChart> getBySubidlevel(int subid, int level, boolean ispublic)
/*     */   {
/*  54 */     SubtypeLevelRankManager subtypeLevelSiftRankManager = null;
/*  55 */     if (ispublic)
/*     */     {
/*  57 */       subtypeLevelSiftRankManager = LevelSiftRankManager.getPubRankManager(subid);
/*     */     }
/*     */     else
/*     */     {
/*  61 */       subtypeLevelSiftRankManager = LevelSiftRankManager.getSellRankManager(subid);
/*     */     }
/*  63 */     if (subtypeLevelSiftRankManager == null)
/*     */     {
/*  65 */       return null;
/*     */     }
/*     */     
/*  68 */     List<MarketLevelPriceChart> res = subtypeLevelSiftRankManager.getAll(level);
/*     */     
/*  70 */     return res;
/*     */   }
/*     */   
/*     */ 
/*     */   public static List<MarketPriceChart> getBySubid(int subid, boolean ispublic)
/*     */   {
/*  76 */     SubtypeMarketRankManager subtypeMarketRankManager = null;
/*  77 */     if (ispublic)
/*     */     {
/*  79 */       subtypeMarketRankManager = PriceRankManager.getPubRankManager(subid);
/*     */     }
/*     */     else
/*     */     {
/*  83 */       subtypeMarketRankManager = PriceRankManager.getSellRankManager(subid);
/*     */     }
/*  85 */     if (subtypeMarketRankManager == null)
/*     */     {
/*  87 */       return null;
/*     */     }
/*     */     
/*  90 */     return subtypeMarketRankManager.getAllChartObjs();
/*     */   }
/*     */   
/*     */ 
/*     */   public static int getPageSize()
/*     */   {
/*  96 */     return MarketManager.getPageSize();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void fillProtocolMarketItem(mzm.gsp.market.MarketItem marketItem, long marketId, xbean.MarketItem xMarketItem, AuctionItemInfo xAuctionItemInfo)
/*     */   {
/* 104 */     MarketManager.fillProtocolMarketItem(marketItem, marketId, xMarketItem, xAuctionItemInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void fillProtocolMarketPet(mzm.gsp.market.MarketPet marketPet, long marketId, xbean.MarketPet xMarketPet, AuctionPetInfo xAuctionPetInfo)
/*     */   {
/* 112 */     MarketManager.fillProtocolMarketPet(marketPet, marketId, xMarketPet, xAuctionPetInfo);
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
/*     */   public static boolean hasState(int currentState, int stateEnum)
/*     */   {
/* 125 */     return MarketManager.hasState(currentState, stateEnum);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getSubidByItemId(int itemId)
/*     */   {
/* 136 */     return MarketManager.getSubidByItemId(itemId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getSubidByPetId(int petId)
/*     */   {
/* 147 */     return MarketManager.getSubidByPetId(petId);
/*     */   }
/*     */   
/*     */   public static Logger getLogger()
/*     */   {
/* 152 */     return MarketManager.logger;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isMarketOpen(long roleid)
/*     */   {
/* 163 */     return MarketManager.isMarketOpen(roleid);
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
/*     */   public static boolean isMarketSwitchOpenForRole(long roleid)
/*     */   {
/* 176 */     return MarketManager.isMarketSwitchOpenForRole(roleid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isMarketSearchSwitchOpenForRole(long roleid)
/*     */   {
/* 188 */     if (!OpenInterface.getOpenStatus(107))
/*     */     {
/* 190 */       return false;
/*     */     }
/* 192 */     if (OpenInterface.isBanPlay(roleid, 107))
/*     */     {
/* 194 */       OpenInterface.sendBanPlayMsg(roleid, 107);
/* 195 */       return false;
/*     */     }
/* 197 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isMarketAuctionSwitchOpenForRole(long roleid)
/*     */   {
/* 209 */     if (!OpenInterface.getOpenStatus(118))
/*     */     {
/* 211 */       return false;
/*     */     }
/* 213 */     if (OpenInterface.isBanPlay(roleid, 118))
/*     */     {
/* 215 */       OpenInterface.sendBanPlayMsg(roleid, 118);
/* 216 */       return false;
/*     */     }
/* 218 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isMarketCustomizedSwitchOpenForRole(long roleid)
/*     */   {
/* 230 */     if (!OpenInterface.getOpenStatus(119))
/*     */     {
/* 232 */       return false;
/*     */     }
/* 234 */     if (OpenInterface.isBanPlay(roleid, 119))
/*     */     {
/* 236 */       OpenInterface.sendBanPlayMsg(roleid, 119);
/* 237 */       return false;
/*     */     }
/* 239 */     return true;
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
/*     */   public static boolean isRoleLevelRight(int roleLelve, int subid)
/*     */   {
/* 252 */     return MarketManager.isRoleLevelRight(roleLelve, subid);
/*     */   }
/*     */   
/*     */ 
/*     */   public static boolean isItemSubtype(int subid)
/*     */   {
/* 258 */     return MarketManager.isItemSubtype(subid);
/*     */   }
/*     */   
/*     */   public static boolean isPetSubtype(int subid)
/*     */   {
/* 263 */     return MarketManager.isPetSubtype(subid);
/*     */   }
/*     */   
/*     */   public static int getItemSubidSize()
/*     */   {
/* 268 */     return SItemSubTypeIds.getAll().size();
/*     */   }
/*     */   
/*     */ 
/*     */   public static int getPetSubidSize()
/*     */   {
/* 274 */     return SPetSubTypeIds.getAll().size();
/*     */   }
/*     */   
/*     */   public static void triggerMarketItemOnShelfEvent(long marketId, int itemId, boolean isPub)
/*     */   {
/* 279 */     triggerMarketItemOnShelfEvent(marketId, itemId, isPub, false);
/*     */   }
/*     */   
/*     */ 
/*     */   public static void triggerMarketItemOnShelfEvent(long marketId, int itemId, boolean isPub, boolean isSysSupply)
/*     */   {
/* 285 */     TriggerEventsManger.getInstance().triggerEvent(new MarketItemOnShelf(), new MarketItemArg(marketId, itemId, isPub, isSysSupply), MarketEventTaskManager.getInstance());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void triggerMarketItemOffShelfEvent(long marketId, int itemId, boolean isPub, xbean.MarketItem xMarketItem)
/*     */   {
/* 292 */     TriggerEventsManger.getInstance().triggerEvent(new MarketItemOffShelf(), new MarketItemOffShelfArg(marketId, itemId, isPub, xMarketItem), MarketEventTaskManager.getInstance());
/*     */   }
/*     */   
/*     */ 
/*     */   public static void triggerMarketPetOnShelfEvent(long marketId, int petCfgId, boolean isPub)
/*     */   {
/* 298 */     triggerMarketPetOnShelfEvent(marketId, petCfgId, isPub, false);
/*     */   }
/*     */   
/*     */ 
/*     */   public static void triggerMarketPetOnShelfEvent(long marketId, int petCfgId, boolean isPub, boolean isSysSupply)
/*     */   {
/* 304 */     TriggerEventsManger.getInstance().triggerEvent(new MarketPetOnShelf(), new MarketPetArg(marketId, petCfgId, isPub, isSysSupply), MarketEventTaskManager.getInstance());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void triggerMarketPetOffShelfEvent(long marketId, int petCfgId, boolean isPub, xbean.MarketPet xMarketPet)
/*     */   {
/* 311 */     TriggerEventsManger.getInstance().triggerEvent(new MarketPetOffShelf(), new MarketPetOffShelfArg(marketId, petCfgId, isPub, xMarketPet), MarketEventTaskManager.getInstance());
/*     */   }
/*     */   
/*     */ 
/*     */   public static void triggerSellPetEvent(long roleId, long petId, int petCfgId, int price)
/*     */   {
/* 317 */     TriggerEventsManger.getInstance().triggerEvent(new SellPetEvent(), new SellPetArg(roleId, petId, petCfgId, price));
/*     */   }
/*     */   
/*     */   public static void triggerBuyPetEvent(long roleId, long petId, int petCfgId, int price)
/*     */   {
/* 322 */     TriggerEventsManger.getInstance().triggerEvent(new BuyPetEvent(), new BuyPetArg(roleId, petId, petCfgId, price));
/*     */   }
/*     */   
/*     */   public static void triggerGetBackPetEvent(long roleId, long petId, int petCfgId)
/*     */   {
/* 327 */     TriggerEventsManger.getInstance().triggerEvent(new GetBackPetEvent(), new GetBackPetArg(roleId, petId, petCfgId));
/*     */   }
/*     */   
/*     */   public static void sendCommonError(long roleid, int code)
/*     */   {
/* 332 */     MarketManager.sendCommonError(roleid, code);
/*     */   }
/*     */   
/*     */   public static long computePublicEndtime(long onshelfTime)
/*     */   {
/* 337 */     return MarketManager.computePublicEndtime(onshelfTime);
/*     */   }
/*     */   
/*     */   public static void sendSearchRestTimeRes(long roleid, int restTime)
/*     */   {
/* 342 */     SSearchRestTimeRes res = new SSearchRestTimeRes(restTime);
/* 343 */     OnlineManager.getInstance().sendAtOnce(roleid, res);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean canSearch(int subid)
/*     */   {
/* 354 */     SMarketSubTypeCfg marketSubTypeCfg = SMarketSubTypeCfg.get(subid);
/* 355 */     if (marketSubTypeCfg == null)
/*     */     {
/* 357 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 361 */     SMarketCfg marketCfg = SMarketCfg.get(marketSubTypeCfg.marketCfgId);
/* 362 */     if (marketCfg == null)
/*     */     {
/* 364 */       return false;
/*     */     }
/* 366 */     return marketCfg.isSearch;
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
/*     */   public static Item separateItem(Item xSrcItem, int sepNumber)
/*     */   {
/* 382 */     return MarketManager.separateItem(xSrcItem, sepNumber);
/*     */   }
/*     */   
/*     */   public static boolean isLevelSift(int subid)
/*     */   {
/* 387 */     return MarketManager.isLevelSift(subid);
/*     */   }
/*     */   
/*     */   public static void deleteFromPubPriceRank(int subid, long marketId)
/*     */   {
/* 392 */     PriceRankManager.deletePub(subid, marketId);
/*     */   }
/*     */   
/*     */   public static void rankIntoPubPriceRank(int subid, long marketId, int price)
/*     */   {
/* 397 */     PriceRankManager.rankPub(subid, marketId, price);
/*     */   }
/*     */   
/*     */ 
/*     */   public static void deleteFromPubLevelSiftRank(int subid, long marketId, int level)
/*     */   {
/* 403 */     LevelSiftRankManager.deletePub(subid, marketId, level);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void rankIntoPubLevelSiftRank(int subid, long marketId, int level, int price)
/*     */   {
/* 410 */     LevelSiftRankManager.rankPub(subid, marketId, level, price);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void sendSSyncSellItemNotify(long roleid, long marketId, int itemId, int restNum, int sellNum)
/*     */   {
/* 417 */     MarketManager.sendSSyncSellItemNotify(roleid, marketId, itemId, restNum, sellNum);
/*     */   }
/*     */   
/*     */ 
/*     */   public static void sendSSyncSellPetNotify(long roleid, long marketId, int petCfgId)
/*     */   {
/* 423 */     MarketManager.sendSSyncSellPetNotify(roleid, marketId, petCfgId);
/*     */   }
/*     */   
/*     */ 
/*     */   public static void addMarketTimeOutOrSelledItem(RoleMarketInfo xRoleMarketInfo, long marketId, xbean.MarketItem xMarketItem)
/*     */   {
/* 429 */     MarketManager.addMarketTimeOutOrSelledItem(xRoleMarketInfo, marketId, xMarketItem);
/*     */   }
/*     */   
/*     */ 
/*     */   public static void addMarketTimeOutOrSelledPet(RoleMarketInfo xRoleMarketInfo, long marketId, xbean.MarketPet xMarketPet)
/*     */   {
/* 435 */     MarketManager.addMarketTimeOutOrSelledPet(xRoleMarketInfo, marketId, xMarketPet);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void removeMarketIdFromPetChannel(long petLockKey, long marketId, long channlel_id)
/*     */   {
/* 447 */     MarketManager.removeMarketIdFromPetChannel(petLockKey, marketId, channlel_id);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void removeMarketIdFromItemChannel(long itemLockKey, long marketId, long channlel_id)
/*     */   {
/* 459 */     MarketManager.removeMarketIdFromItemChannel(itemLockKey, marketId, channlel_id);
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
/*     */   public static int getPrice(int subid, long marketId, boolean isPub)
/*     */   {
/* 472 */     int price = PriceRankManager.getPrice(subid, marketId, isPub);
/*     */     
/* 474 */     return price;
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
/*     */   public static int getPrice(int subid, int level, long marketId, boolean isPub)
/*     */   {
/* 489 */     int price = LevelSiftRankManager.getPrice(subid, level, marketId, isPub);
/*     */     
/* 491 */     return price;
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
/*     */   public static boolean addPetToRole(long roleId, Pet xPet, long marketBuyTime)
/*     */   {
/* 507 */     Pet xAddPet = Pod.newPet();
/*     */     
/* 509 */     PetInterface.fillXpet(xAddPet, xPet);
/* 510 */     xAddPet.setMarketbuytime(marketBuyTime);
/*     */     
/* 512 */     boolean ret = PetInterface.addXpetIntoPetbag(roleId, xAddPet);
/*     */     
/* 514 */     if (!ret)
/*     */     {
/* 516 */       sendCommonError(roleId, 5);
/*     */     }
/*     */     
/* 519 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */   public static ItemOperateResult addItemToRole(long roleId, Item xItem, int addNum, LogReason logReason, long marketBuyTime)
/*     */   {
/* 525 */     TLogArg logArg = new TLogArg(logReason, xItem.getCfgid());
/*     */     
/* 527 */     Item xAddItem = MarketManager.separateItem(xItem, addNum);
/* 528 */     xAddItem.setMarketbuytime(marketBuyTime);
/*     */     
/* 530 */     ItemOperateResult result = ItemInterface.addItemActive(roleId, Arrays.asList(new Item[] { xAddItem }), false, true, logArg);
/* 531 */     if (!result.success())
/*     */     {
/* 533 */       sendCommonError(roleId, 2);
/*     */     }
/*     */     
/* 536 */     return result;
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
/*     */   public static boolean isItemInFrozenState(int itemId, long marketBuytime)
/*     */   {
/* 549 */     return MarketManager.isItemInFrozenState(itemId, marketBuytime);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getMaxPetPrice(Pet xPet)
/*     */   {
/* 560 */     return MarketManager.getPetPriceBean(xPet).getMaxPrice();
/*     */   }
/*     */   
/*     */   public static int getMaxItemPrice(int itemId, boolean isWithSkill)
/*     */   {
/* 565 */     return MarketManager.getMaxItemPrice(itemId, isWithSkill);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isRoleStateCanOperateMarket(long roleid)
/*     */   {
/* 576 */     return RoleStatusInterface.checkCanSetStatus(roleid, 134, true);
/*     */   }
/*     */   
/*     */   public static boolean isItemWithSkill(Item xItem)
/*     */   {
/* 581 */     return MarketManager.isItemWithSkill(xItem);
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
/*     */ 
/*     */ 
/*     */   public static void logMarketBuyItem(long buyRoleid, long sellerRoleid, long marketId, int itemId, int num, int price, Set<Long> uuids, long now)
/*     */   {
/* 599 */     MarketManager.logMarketBuyItem(buyRoleid, sellerRoleid, marketId, itemId, num, price, uuids, now);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void logMarketBuyPet(long buyRoleid, long sellerRoleid, long marketId, int petCfgId, int num, int price, int petLevel, int petScoreLevel, long petid, long now)
/*     */   {
/* 619 */     MarketManager.logMarketBuyPet(buyRoleid, sellerRoleid, marketId, petCfgId, num, price, petLevel, petScoreLevel, petid, now);
/*     */   }
/*     */   
/*     */ 
/*     */   public static boolean isSysRoleid(long roleid)
/*     */   {
/* 625 */     return roleid == 0L;
/*     */   }
/*     */   
/*     */   public static boolean isEquipItem(int itemid)
/*     */   {
/* 630 */     return MarketManager.isEquipItem(itemid);
/*     */   }
/*     */   
/*     */   public static boolean isPetEquipItem(int itemid)
/*     */   {
/* 635 */     return MarketManager.isPetEquipItem(itemid);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\MarketInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */