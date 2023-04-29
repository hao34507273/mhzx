/*     */ package mzm.gsp.mysteryshop.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.mall.confbean.SMallTypeCfg;
/*     */ import mzm.gsp.mysteryshop.SMysteryShopErrorInfo;
/*     */ import mzm.gsp.mysteryshop.SResMysteryShopInfo;
/*     */ import mzm.gsp.mysteryshop.confbean.CSMysteryShopConstsCfg;
/*     */ import mzm.gsp.mysteryshop.confbean.SLibGoodsRandomCfg;
/*     */ import mzm.gsp.mysteryshop.confbean.SMysteryShopGoodsCfg;
/*     */ import mzm.gsp.mysteryshop.confbean.SMysteryShopGoodsLibCfg;
/*     */ import mzm.gsp.mysteryshop.confbean.SSaleRandomCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.yuanbao.main.CurrencyType;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MallRefreshTime;
/*     */ import xbean.MysteryShopInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleMysteryShops;
/*     */ import xdb.Xdb;
/*     */ import xtable.Malltype2refreshtime;
/*     */ import xtable.Role2mystery_shops;
/*     */ 
/*     */ public class MysteryShopManager
/*     */ {
/*  50 */   static final Logger logger = Logger.getLogger("mysteryshop");
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void init() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Collection<Integer> getValidMysteryShopType()
/*     */   {
/*  64 */     return CSMysteryShopConstsCfg.getAll().keySet();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Map.Entry<Integer, CSMysteryShopConstsCfg>> getValidMysteryShopEntry()
/*     */   {
/*  74 */     return CSMysteryShopConstsCfg.getAll().entrySet();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean refreshMysteryShopGoods(long roleId, MysteryShopInfo mysteryShopInfo, int shoptype)
/*     */   {
/*  86 */     mysteryShopInfo.getGoods_list().clear();
/*  87 */     CSMysteryShopConstsCfg constsCfg = CSMysteryShopConstsCfg.get(shoptype);
/*  88 */     if (constsCfg == null)
/*     */     {
/*  90 */       return false;
/*     */     }
/*  92 */     int libId = getMysteryShopGoodsLibId(roleId, shoptype);
/*  93 */     if (libId <= 0)
/*     */     {
/*  95 */       return false;
/*     */     }
/*  97 */     List<Integer> goodsId = randomGoodsIds(libId, constsCfg.GOODS_GRID_NUM);
/*  98 */     if (goodsId.size() < constsCfg.GOODS_GRID_NUM)
/*     */     {
/* 100 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 104 */     for (int index = 0; index < constsCfg.GOODS_GRID_NUM; index++)
/*     */     {
/* 106 */       xbean.MysteryGoodsInfo goodsInfo = Pod.newMysteryGoodsInfo();
/* 107 */       SMysteryShopGoodsCfg goodsCfg = SMysteryShopGoodsCfg.get(((Integer)goodsId.get(index)).intValue());
/* 108 */       goodsInfo.setGoods_id(goodsCfg.id);
/* 109 */       goodsInfo.setSale(getSale(goodsCfg.saleId));
/* 110 */       goodsInfo.setCount(0);
/* 111 */       mysteryShopInfo.getGoods_list().add(goodsInfo);
/*     */     }
/* 113 */     return true;
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
/*     */   private static List<Integer> randomGoodsIds(int libId, int count)
/*     */   {
/* 126 */     SLibGoodsRandomCfg libGoodsRandomCfg = SLibGoodsRandomCfg.get(libId);
/* 127 */     if ((libGoodsRandomCfg == null) || (libGoodsRandomCfg.goodsId2randomWight.size() < count))
/*     */     {
/* 129 */       String logstr = String.format("[mysteryshop]MysteryShopManager.randomGoodsIds@goodsLib error |libId=%s|count=%d", new Object[] { Integer.valueOf(libId), Integer.valueOf(count) });
/*     */       
/* 131 */       logger.error(logstr);
/* 132 */       return Collections.EMPTY_LIST;
/*     */     }
/* 134 */     List<Integer> goodsIds = new ArrayList(count);
/* 135 */     Map<Integer, Integer> randomMap = new HashMap(libGoodsRandomCfg.goodsId2randomWight);
/* 136 */     int sumWight = libGoodsRandomCfg.sumWight;
/*     */     
/*     */ 
/* 139 */     for (int i = 0; i < count; i++)
/*     */     {
/* 141 */       int randomResult = Xdb.random().nextInt(sumWight);
/* 142 */       int current = 0;
/* 143 */       Iterator<Map.Entry<Integer, Integer>> it = randomMap.entrySet().iterator();
/* 144 */       while (it.hasNext())
/*     */       {
/* 146 */         Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 147 */         current += ((Integer)entry.getValue()).intValue();
/* 148 */         if (randomResult < current)
/*     */         {
/* 150 */           it.remove();
/* 151 */           sumWight -= ((Integer)entry.getValue()).intValue();
/* 152 */           goodsIds.add(entry.getKey());
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 157 */     return goodsIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int getSale(int saleId)
/*     */   {
/* 168 */     SSaleRandomCfg saleRandomCfg = SSaleRandomCfg.get(saleId);
/* 169 */     int randomResult = Xdb.random().nextInt(saleRandomCfg.sumWight);
/* 170 */     for (Map.Entry<Integer, Integer> entry : saleRandomCfg.randomWight2sale.entrySet())
/*     */     {
/* 172 */       if (randomResult < ((Integer)entry.getKey()).intValue())
/*     */       {
/* 174 */         return ((Integer)entry.getValue()).intValue();
/*     */       }
/*     */     }
/* 177 */     return 10000;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int getMysteryShopGoodsLibId(long roleId, int shoptype)
/*     */   {
/* 189 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 190 */     int serverLevel = ServerInterface.getCurrentServerLevel();
/* 191 */     TreeMap<Integer, SMysteryShopGoodsLibCfg> tm = (TreeMap)SMysteryShopGoodsLibCfg.getAll();
/*     */     
/* 193 */     for (Map.Entry<Integer, SMysteryShopGoodsLibCfg> entry : tm.descendingMap().entrySet())
/*     */     {
/* 195 */       SMysteryShopGoodsLibCfg libCfg = (SMysteryShopGoodsLibCfg)entry.getValue();
/*     */       
/* 197 */       if ((libCfg.shopType == shoptype) && 
/*     */       
/*     */ 
/*     */ 
/* 201 */         (serverLevel >= libCfg.minServerLevel) && (serverLevel <= libCfg.maxServerLevel) && 
/*     */         
/*     */ 
/*     */ 
/* 205 */         (roleLevel >= libCfg.minRoleLevel) && (roleLevel <= libCfg.maxRoleLevel))
/*     */       {
/*     */ 
/*     */ 
/* 209 */         return libCfg.id; }
/*     */     }
/* 211 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getRefreshtimeByMysterytype(int shopType)
/*     */   {
/* 222 */     return SMallTypeCfg.get(shopType).refreshtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void setMysteryShopResetTime(int shopType, long refreshtime)
/*     */   {
/* 233 */     long mt = GameServerInfoManager.toGlobalId(shopType);
/* 234 */     MallRefreshTime malRefreshTime = Malltype2refreshtime.get(Long.valueOf(mt));
/* 235 */     if (malRefreshTime == null)
/*     */     {
/* 237 */       malRefreshTime = Pod.newMallRefreshTime();
/* 238 */       Malltype2refreshtime.insert(Long.valueOf(mt), malRefreshTime);
/*     */     }
/* 240 */     malRefreshTime.setRefreshtime(refreshtime);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getRoleMysteryShopResetTime(long roleid, int shopType)
/*     */   {
/* 252 */     MysteryShopInfo mysteryShopInfo = getMysteryShopInfo(roleid, shopType);
/* 253 */     if (mysteryShopInfo == null)
/*     */     {
/* 255 */       return -1L;
/*     */     }
/* 257 */     return mysteryShopInfo.getReset_time();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getMysteryShopResetTime(int shopType)
/*     */   {
/* 268 */     long mt = GameServerInfoManager.toGlobalId(shopType);
/* 269 */     Long malRefreshTime = Malltype2refreshtime.selectRefreshtime(Long.valueOf(mt));
/* 270 */     if (malRefreshTime == null)
/*     */     {
/* 272 */       return -1L;
/*     */     }
/* 274 */     return malRefreshTime.longValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void synMysteryShopInfo(long roleid, int shoptype)
/*     */   {
/* 285 */     MysteryShopInfo mysteryShopInfo = getMysteryShopInfo(roleid, shoptype);
/* 286 */     if (mysteryShopInfo == null)
/*     */     {
/* 288 */       return;
/*     */     }
/*     */     
/*     */ 
/* 292 */     SResMysteryShopInfo sResMysteryShopInfo = new SResMysteryShopInfo();
/* 293 */     sResMysteryShopInfo.shoptype = shoptype;
/* 294 */     sResMysteryShopInfo.refresh_times = mysteryShopInfo.getRefresh_times();
/* 295 */     sResMysteryShopInfo.can_free_refresh_times = mysteryShopInfo.getCan_free_refresh_times();
/* 296 */     sResMysteryShopInfo.used_free_refresh_times = mysteryShopInfo.getUsed_free_refresh_times();
/*     */     
/* 298 */     for (xbean.MysteryGoodsInfo goodsInfo : mysteryShopInfo.getGoods_list())
/*     */     {
/* 300 */       mzm.gsp.mysteryshop.MysteryGoodsInfo sResGoodsInfo = new mzm.gsp.mysteryshop.MysteryGoodsInfo();
/* 301 */       sResGoodsInfo.goods_id = goodsInfo.getGoods_id();
/* 302 */       sResGoodsInfo.count = goodsInfo.getCount();
/* 303 */       sResGoodsInfo.sale = goodsInfo.getSale();
/* 304 */       sResMysteryShopInfo.goods_list.add(sResGoodsInfo);
/*     */     }
/* 306 */     OnlineManager.getInstance().send(roleid, sResMysteryShopInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean refreshMysteryShopSys(long roleid, int shoptype, long resetTime)
/*     */   {
/* 318 */     MysteryShopInfo mysteryShopInfo = getMysteryShopInfo(roleid, shoptype);
/* 319 */     if (mysteryShopInfo == null)
/*     */     {
/* 321 */       return false;
/*     */     }
/*     */     
/* 324 */     mysteryShopInfo.setReset_time(resetTime);
/*     */     
/* 326 */     mysteryShopInfo.setRefresh_times(0);
/*     */     
/* 328 */     mysteryShopInfo.setUsed_free_refresh_times(0);
/*     */     
/* 330 */     mysteryShopInfo.setCan_free_refresh_times(0);
/*     */     
/* 332 */     if (refreshMysteryShopGoods(roleid, mysteryShopInfo, shoptype))
/*     */     {
/*     */ 
/* 335 */       MysteryShopTLogManager.tlogMysteryShopRefresh(roleid, shoptype, -1, -1, mysteryShopInfo);
/* 336 */       return true;
/*     */     }
/* 338 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean refreshMysteryShop(long roleid, MysteryShopInfo mysteryShopInfo, int shoptype)
/*     */   {
/* 350 */     mysteryShopInfo.setRefresh_times(mysteryShopInfo.getRefresh_times() + 1);
/*     */     
/* 352 */     return refreshMysteryShopGoods(roleid, mysteryShopInfo, shoptype);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean refreshMysteryShopFree(long roleid, MysteryShopInfo mysteryShopInfo, int shoptype)
/*     */   {
/* 364 */     mysteryShopInfo.setUsed_free_refresh_times(mysteryShopInfo.getUsed_free_refresh_times() + 1);
/*     */     
/* 366 */     return refreshMysteryShopGoods(roleid, mysteryShopInfo, shoptype);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendWrongInfo(long roleid, int error_code, String... params)
/*     */   {
/* 378 */     SMysteryShopErrorInfo mysteryShopErrorInfo = new SMysteryShopErrorInfo();
/* 379 */     mysteryShopErrorInfo.error_code = error_code;
/* 380 */     for (String param : params)
/*     */     {
/* 382 */       mysteryShopErrorInfo.params.add(param);
/*     */     }
/* 384 */     OnlineManager.getInstance().sendAtOnce(roleid, mysteryShopErrorInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isMysteryShopOpenForRole(long roleid, int shoptype)
/*     */   {
/* 395 */     if (!isMysteryShopSwitchOpenForRole(roleid))
/*     */     {
/* 397 */       return false;
/*     */     }
/* 399 */     if (!isOpenForRoleLevel(roleid, shoptype))
/*     */     {
/* 401 */       return false;
/*     */     }
/* 403 */     if (!isRoleStateCanOperateMall(roleid, false))
/*     */     {
/* 405 */       return false;
/*     */     }
/* 407 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isMysteryShopSwitchOpenForRole(long roleid)
/*     */   {
/* 418 */     if (!OpenInterface.getOpenStatus(322))
/*     */     {
/* 420 */       return false;
/*     */     }
/* 422 */     if (OpenInterface.isBanPlay(roleid, 322))
/*     */     {
/* 424 */       OpenInterface.sendBanPlayMsg(roleid, 322);
/* 425 */       return false;
/*     */     }
/* 427 */     return true;
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
/*     */   static boolean isOpenForRoleLevel(long roleId, int shoptype)
/*     */   {
/* 440 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 441 */     CSMysteryShopConstsCfg constsCfg = CSMysteryShopConstsCfg.get(shoptype);
/* 442 */     if (constsCfg == null)
/*     */     {
/* 444 */       String logstr = String.format("[mysteryshop]MysteryShopManager.isOpenForRoleLevel@shoptype error |roleId=%d|shoptype=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(shoptype) });
/*     */       
/*     */ 
/* 447 */       logger.error(logstr);
/* 448 */       return false;
/*     */     }
/* 450 */     return roleLevel >= constsCfg.MIN_ROLE_LEVLE_FOR_MYSTERY_SHOP;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRoleStateCanOperateMall(long roleid)
/*     */   {
/* 461 */     return RoleStatusInterface.checkCanSetStatus(roleid, 153, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRoleStateCanOperateMall(long roleid, boolean sendStatusTip)
/*     */   {
/* 473 */     return RoleStatusInterface.checkCanSetStatus(roleid, 153, sendStatusTip);
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
/*     */   static MysteryShopInfo getMysteryShopInfo(long roleid, int shoptype)
/*     */   {
/* 486 */     if (!getValidMysteryShopType().contains(Integer.valueOf(shoptype)))
/*     */     {
/* 488 */       return null;
/*     */     }
/*     */     
/* 491 */     RoleMysteryShops roleMysteryShops = Role2mystery_shops.get(Long.valueOf(roleid));
/* 492 */     if (roleMysteryShops == null)
/*     */     {
/* 494 */       return null;
/*     */     }
/*     */     
/* 497 */     MysteryShopInfo mysteryShopInfo = (MysteryShopInfo)roleMysteryShops.getType2shop_info().get(Integer.valueOf(shoptype));
/* 498 */     if (mysteryShopInfo == null)
/*     */     {
/* 500 */       return null;
/*     */     }
/* 502 */     return mysteryShopInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getGoodsPrice(int goodsId, int sale)
/*     */   {
/* 514 */     SMysteryShopGoodsCfg goodsCfg = SMysteryShopGoodsCfg.get(goodsId);
/* 515 */     if (goodsCfg == null)
/*     */     {
/* 517 */       return -1;
/*     */     }
/* 519 */     return (int)Math.floor(goodsCfg.price * (sale / 10000.0F));
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
/*     */   static long getLeftCurrencyValue(long roleId, int currencyType)
/*     */   {
/* 534 */     switch (currencyType)
/*     */     {
/*     */     case 0: 
/* 537 */       return 0L;
/*     */     
/*     */     case 1: 
/* 540 */       String userid = RoleInterface.getUserId(roleId);
/* 541 */       return QingfuInterface.getBalance(userid, true);
/*     */     
/*     */     case 2: 
/* 544 */       return RoleInterface.getGold(roleId);
/*     */     
/*     */     case 3: 
/* 547 */       return RoleInterface.getSilver(roleId);
/*     */     
/*     */     case 4: 
/* 550 */       return GangInterface.getBangGong(roleId);
/*     */     
/*     */     case 5: 
/* 553 */       return RoleInterface.getGoldIngot(roleId);
/*     */     }
/*     */     
/* 556 */     GameServer.logger().error(String.format("[mysteryshop]MysteryShopManager.getLeftCurrencyValue@not support the currency type|role_id=%d|currency_type=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(currencyType) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 562 */     return 0L;
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
/*     */   static boolean costCurrencyValue(long roleId, long costValue, int currencyType, TLogArg tlog)
/*     */   {
/* 578 */     if (costValue == 0L)
/*     */     {
/* 580 */       return true;
/*     */     }
/* 582 */     String userId = RoleInterface.getUserId(roleId);
/* 583 */     switch (currencyType)
/*     */     {
/*     */     case 0: 
/* 586 */       return true;
/*     */     
/*     */     case 1: 
/* 589 */       CostResult costResult = QingfuInterface.costYuanbao(userId, roleId, (int)costValue, CostType.COST_BIND_FIRST_MYSTERY_SHOP, tlog);
/*     */       
/*     */ 
/* 592 */       return costResult == CostResult.Success;
/*     */     
/*     */     case 2: 
/* 595 */       return RoleInterface.cutGold(roleId, costValue, tlog);
/*     */     
/*     */     case 3: 
/* 598 */       return RoleInterface.cutSilver(roleId, costValue, tlog);
/*     */     
/*     */     case 5: 
/* 601 */       return RoleInterface.cutGoldIngot(roleId, costValue, tlog);
/*     */     
/*     */     case 4: 
/* 604 */       return GangInterface.cutBangGong(roleId, (int)costValue, tlog);
/*     */     }
/*     */     
/* 607 */     GameServer.logger().error(String.format("[mysteryshop]MysteryShopManager.costCurrencyValue@not support the currency type|role_id=%d|currency_type=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(currencyType) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 613 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static TLogArg newTLogArg(int currencyType, int goodsId)
/*     */   {
/* 625 */     switch (currencyType)
/*     */     {
/*     */     case 0: 
/* 628 */       if (goodsId > 0)
/*     */       {
/* 630 */         return new TLogArg(LogReason.MYSTERY_SHOP_BUY_COST_NULL);
/*     */       }
/* 632 */       return new TLogArg(LogReason.MYSTERY_SHOP_REFRESH_COST_NULL, goodsId);
/*     */     
/*     */     case 1: 
/* 635 */       if (goodsId > 0)
/*     */       {
/* 637 */         return new TLogArg(LogReason.MYSTERY_SHOP_BUY_COST_YUAN_BAO);
/*     */       }
/* 639 */       return new TLogArg(LogReason.MYSTERY_SHOP_REFRESH_COST_YUAN_BAO, goodsId);
/*     */     
/*     */     case 2: 
/* 642 */       if (goodsId > 0)
/*     */       {
/* 644 */         return new TLogArg(LogReason.MYSTERY_SHOP_BUY_COST_GOLD, goodsId);
/*     */       }
/* 646 */       return new TLogArg(LogReason.MYSTERY_SHOP_REFRESH_COST_GOLD);
/*     */     
/*     */     case 3: 
/* 649 */       if (goodsId > 0)
/*     */       {
/* 651 */         return new TLogArg(LogReason.MYSTERY_SHOP_BUY_COST_SILVER, goodsId);
/*     */       }
/* 653 */       return new TLogArg(LogReason.MYSTERY_SHOP_REFRESH_COST_SILVER);
/*     */     
/*     */     case 5: 
/* 656 */       if (goodsId > 0)
/*     */       {
/* 658 */         return new TLogArg(LogReason.MYSTERY_SHOP_BUY_COST_JIN_DING, goodsId);
/*     */       }
/* 660 */       return new TLogArg(LogReason.MYSTERY_SHOP_REFRESH_COST_JIN_DING);
/*     */     
/*     */     case 4: 
/* 663 */       if (goodsId > 0)
/*     */       {
/* 665 */         return new TLogArg(LogReason.MYSTERY_SHOP_BUY_COST_BANG_GONG, goodsId);
/*     */       }
/* 667 */       return new TLogArg(LogReason.MYSTERY_SHOP_REFRESH_COST_BANG_GONG);
/*     */     }
/*     */     
/* 670 */     GameServer.logger().error(String.format("[mysteryshop]MysteryShopManager.costCurrencyValue@not support the currency type|goodsId=%d|currency_type=%d", new Object[] { Integer.valueOf(goodsId), Integer.valueOf(currencyType) }));
/*     */     
/*     */ 
/*     */ 
/* 674 */     return null;
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
/*     */   static void fillCurrencyData(String userId, long roleid, TLogArg logArg, int needYuanbao)
/*     */   {
/* 688 */     int hasaward = (int)QingfuInterface.getBalance(userId, true);
/* 689 */     if (hasaward >= needYuanbao)
/*     */     {
/* 691 */       logArg.addCurrencytype2num(CurrencyType.CURRENCY_AWARDYUANBAO, Integer.valueOf(-needYuanbao));
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 696 */       if (hasaward > 0)
/*     */       {
/*     */ 
/* 699 */         logArg.addCurrencytype2num(CurrencyType.CURRENCY_AWARDYUANBAO, Integer.valueOf(-hasaward));
/*     */       }
/* 701 */       logArg.addCurrencytype2num(CurrencyType.CURRENCY_BUYYUANBAO, Integer.valueOf(-(needYuanbao - hasaward)));
/*     */     }
/* 703 */     logArg.addCurrencytype2num(CurrencyType.CURRENCY_YUANBAO, Integer.valueOf(-needYuanbao));
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
/*     */   static void sendBulletin(long roleid, int sale, SMysteryShopGoodsCfg goodsCfg)
/*     */   {
/* 717 */     if (mzm.gsp.itembulletin.main.ItemBulletinInterface.needBulletin(goodsCfg.itemId))
/*     */     {
/* 719 */       SBulletinInfo bulletinInfo = new SBulletinInfo();
/* 720 */       bulletinInfo.bulletintype = 38;
/* 721 */       bulletinInfo.params.put(Integer.valueOf(1), RoleInterface.getName(roleid));
/* 722 */       bulletinInfo.params.put(Integer.valueOf(20), String.valueOf(sale));
/* 723 */       bulletinInfo.params.put(Integer.valueOf(4), String.valueOf(goodsCfg.itemId));
/* 724 */       BulletinInterface.sendBulletin(bulletinInfo);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkAndUpdateFreeTimes(MysteryShopInfo mysteryShopInfo, CSMysteryShopConstsCfg constsCfg)
/*     */   {
/* 735 */     if (mysteryShopInfo.getCan_free_refresh_times() >= constsCfg.MAX_FREE_REFRESH_TIMES)
/*     */     {
/* 737 */       return false;
/*     */     }
/*     */     
/* 740 */     int finishedTime = 0;
/*     */     
/* 742 */     for (xbean.MysteryGoodsInfo goodsInfo : mysteryShopInfo.getGoods_list())
/*     */     {
/* 744 */       SMysteryShopGoodsCfg goodsCfg = SMysteryShopGoodsCfg.get(goodsInfo.getGoods_id());
/* 745 */       if (goodsCfg.maxbuynum <= goodsInfo.getCount())
/*     */       {
/* 747 */         finishedTime++;
/*     */       }
/*     */     }
/*     */     
/* 751 */     if ((finishedTime > 0) && (finishedTime % constsCfg.FREE_REFRESH_TIMES_CONDITION == 0))
/*     */     {
/* 753 */       mysteryShopInfo.setCan_free_refresh_times(mysteryShopInfo.getCan_free_refresh_times() + 1);
/* 754 */       return true;
/*     */     }
/* 756 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mysteryshop\main\MysteryShopManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */