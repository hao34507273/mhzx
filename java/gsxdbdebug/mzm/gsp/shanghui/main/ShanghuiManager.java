/*     */ package mzm.gsp.shanghui.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.Stack;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.shanghui.SCommonResultRes;
/*     */ import mzm.gsp.shanghui.SSyncShopingList;
/*     */ import mzm.gsp.shanghui.ShoppingItem;
/*     */ import mzm.gsp.shanghui.confbean.SOrginalPriceCfg;
/*     */ import mzm.gsp.shanghui.confbean.SRecommandPriceCfg;
/*     */ import mzm.gsp.shanghui.confbean.SShangHuiCfg;
/*     */ import mzm.gsp.shanghui.confbean.SShangHuiConsts;
/*     */ import mzm.gsp.shanghui.confbean.SShangHuiItemToolsCfg;
/*     */ import mzm.gsp.shanghui.confbean.SShangHuiSubTypeCfg;
/*     */ import mzm.gsp.shanghui.confbean.STItem2RecommandPriceCfg;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.DateObserver;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleShangHuiBean;
/*     */ import xbean.RoleShangHuiItem;
/*     */ import xbean.ShangHuiItem;
/*     */ import xdb.TTable;
/*     */ import xtable.Shanghui;
/*     */ 
/*     */ class ShanghuiManager
/*     */ {
/*  44 */   public static final Logger logger = Logger.getLogger(ShanghuiManager.class);
/*     */   
/*  46 */   public static long BASE_RATE = 10000L;
/*     */   
/*  48 */   private static Set<Integer> sellItemSet = new HashSet();
/*     */   
/*  50 */   private static ConcurrentHashMap<Integer, ShoppingItemMapInfo> syncShoppingItemMap = new ConcurrentHashMap();
/*     */   public static void init() {}
/*     */   
/*     */   private static class ShoppingItemMapInfo {
/*  54 */     final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
/*  55 */     final LinkedHashMap<Integer, ShoppingItem> shoppintItems = new LinkedHashMap();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean findNotRefLevel(int itemId)
/*     */   {
/*  65 */     SShangHuiItemToolsCfg cfg = getShangHuiItemCfg(itemId);
/*  66 */     if (cfg == null)
/*     */     {
/*  68 */       return false;
/*     */     }
/*  70 */     if (cfg.isOrginalPriceRefLevel)
/*     */     {
/*  72 */       return findNotRefLevel(SOrginalPriceCfg.get(cfg.orginalPriceCfgId).lastLevelItemId);
/*     */     }
/*  74 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public static void postInit()
/*     */   {
/*  80 */     List<SShangHuiItemToolsCfg> itemCfgList = getAllCanSellItemForLevel(ServerInterface.getCurrentServerLevel());
/*     */     
/*  82 */     for (SShangHuiItemToolsCfg itemCfg : itemCfgList)
/*     */     {
/*     */ 
/*  85 */       new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/*  90 */           if (null == this.val$itemCfg)
/*     */           {
/*  92 */             return false;
/*     */           }
/*  94 */           long key = mzm.gsp.GameServerInfoManager.toGlobalId(this.val$itemCfg.id);
/*  95 */           ShangHuiItem xShangHuiItem = Shanghui.select(Long.valueOf(key));
/*  96 */           if (null != xShangHuiItem)
/*     */           {
/*  98 */             ShanghuiManager.addInSell(this.val$itemCfg.id);
/*     */             
/* 100 */             ShanghuiManager.addShoppingItem(xShangHuiItem, this.val$itemCfg.id);
/*     */           }
/* 102 */           return true;
/*     */         }
/*     */       }.call();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 109 */     Shanghui.getTable().addListener(new ShangHuiItemChangeListener(), new String[] { "value", "orginalprice" });
/* 110 */     Shanghui.getTable().addListener(new ShangHuiItemChangeListener(), new String[] { "value", "riserate" });
/*     */     
/* 112 */     onServerLevelUp(ServerInterface.getCurrentServerLevel());
/* 113 */     new DateObserver((int)SShangHuiConsts.getInstance().SHANGHUI_PRICE_UDPATE_OBSERVER_ID)
/*     */     {
/*     */       protected boolean onTimeOut()
/*     */       {
/* 117 */         Set<Integer> _set = ShanghuiManager.getAllInSell();
/* 118 */         for (Integer itemid : _set)
/*     */         {
/* 120 */           NoneRealTimeTaskManager.getInstance().addTask(new PShangHuiPriceUpdate(itemid.intValue()));
/*     */         }
/* 122 */         return true;
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<SShangHuiItemToolsCfg> getAllCanSellItemForLevel(int serverLevel)
/*     */   {
/* 135 */     List<SShangHuiItemToolsCfg> itemCfgList = new ArrayList();
/* 136 */     for (SShangHuiCfg bigTypeCfg : SShangHuiCfg.getAll().values())
/*     */     {
/* 138 */       for (Integer subType : bigTypeCfg.SubTypeIdList)
/*     */       {
/* 140 */         SShangHuiSubTypeCfg subTypeCfg = SShangHuiSubTypeCfg.get(subType.intValue());
/* 141 */         if (subTypeCfg != null)
/*     */         {
/*     */ 
/*     */ 
/* 145 */           for (Integer ItemId : subTypeCfg.itemIdList)
/*     */           {
/* 147 */             SShangHuiItemToolsCfg itemCfg = getShangHuiItemCfg(ItemId.intValue());
/* 148 */             if (itemCfg != null)
/*     */             {
/*     */ 
/*     */ 
/* 152 */               if (itemCfg.openServerLevel <= serverLevel)
/*     */               {
/* 154 */                 itemCfgList.add(itemCfg); } }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 159 */     return itemCfgList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<Integer> getAllSubTypeItemForLevel(int serverLevel, int bigType, int subType)
/*     */   {
/* 170 */     List<Integer> itemCfgList = new ArrayList();
/* 171 */     for (SShangHuiCfg bigTypeCfg : SShangHuiCfg.getAll().values())
/*     */     {
/* 173 */       if (bigTypeCfg.id == bigType)
/*     */       {
/*     */ 
/*     */ 
/* 177 */         for (Integer subtype : bigTypeCfg.SubTypeIdList)
/*     */         {
/* 179 */           if (subtype.intValue() == subType)
/*     */           {
/*     */ 
/*     */ 
/* 183 */             SShangHuiSubTypeCfg subTypeCfg = SShangHuiSubTypeCfg.get(subType);
/* 184 */             if (subTypeCfg != null)
/*     */             {
/*     */ 
/*     */ 
/* 188 */               for (Integer ItemId : subTypeCfg.itemIdList)
/*     */               {
/* 190 */                 SShangHuiItemToolsCfg itemCfg = getShangHuiItemCfg(ItemId.intValue());
/* 191 */                 if (itemCfg != null)
/*     */                 {
/*     */ 
/*     */ 
/* 195 */                   if (itemCfg.openServerLevel <= serverLevel)
/*     */                   {
/* 197 */                     itemCfgList.add(Integer.valueOf(itemCfg.id)); } }
/*     */               } }
/*     */           } }
/*     */       }
/*     */     }
/* 202 */     return itemCfgList;
/*     */   }
/*     */   
/*     */   public static boolean isCanSellForLevel(int itemId, int serverLevel)
/*     */   {
/* 207 */     SShangHuiItemToolsCfg itemCfg = getShangHuiItemCfg(itemId);
/* 208 */     if (itemCfg == null)
/*     */     {
/* 210 */       return false;
/*     */     }
/* 212 */     return itemCfg.openServerLevel <= serverLevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Stack<Integer> getLevelChainList(int itemId)
/*     */   {
/* 224 */     Stack<Integer> itemStack = new Stack();
/* 225 */     SShangHuiItemToolsCfg cfg = getShangHuiItemCfg(itemId);
/* 226 */     itemStack.push(Integer.valueOf(cfg.id));
/* 227 */     while (cfg.isOrginalPriceRefLevel)
/*     */     {
/* 229 */       SOrginalPriceCfg orginalPriceCfg = SOrginalPriceCfg.get(cfg.orginalPriceCfgId);
/* 230 */       SShangHuiItemToolsCfg lastLvCfg = getShangHuiItemCfg(orginalPriceCfg.lastLevelItemId);
/* 231 */       itemStack.push(Integer.valueOf(lastLvCfg.id));
/* 232 */       cfg = lastLvCfg;
/*     */     }
/* 234 */     return itemStack;
/*     */   }
/*     */   
/*     */   public static void onServerLevelUp(int serverLevel)
/*     */   {
/* 239 */     List<SShangHuiItemToolsCfg> itemCfgList = getAllCanSellItemForLevel(serverLevel);
/* 240 */     Set<Integer> sellItemSet = getAllInSell();
/* 241 */     for (SShangHuiItemToolsCfg itemCfg : itemCfgList)
/*     */     {
/* 243 */       int itemId = itemCfg.id;
/* 244 */       if (!sellItemSet.contains(Integer.valueOf(itemId)))
/*     */       {
/*     */ 
/*     */ 
/* 248 */         NoneRealTimeTaskManager.getInstance().addTask(new POnAddShanghuiItem(itemId));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static int calculatePrice(int orginalPrice, int riseRate) {
/* 254 */     return (int)(orginalPrice * (BASE_RATE + riseRate) / BASE_RATE);
/*     */   }
/*     */   
/*     */   static void addInSell(int itemId)
/*     */   {
/* 259 */     synchronized (sellItemSet)
/*     */     {
/* 261 */       sellItemSet.add(Integer.valueOf(itemId));
/*     */     }
/*     */   }
/*     */   
/*     */   static void fill(int itemId, ShangHuiItem shangHuiItem, ShoppingItem shoppingItem)
/*     */   {
/* 267 */     shoppingItem.rise = shangHuiItem.getRiserate();
/* 268 */     shoppingItem.price = calculatePrice(shangHuiItem.getOrginalprice(), shangHuiItem.getRiserate());
/* 269 */     shoppingItem.itemid = itemId;
/*     */   }
/*     */   
/*     */   static Set<Integer> getAllInSell()
/*     */   {
/* 274 */     synchronized (sellItemSet)
/*     */     {
/* 276 */       Set<Integer> set = new HashSet(sellItemSet);
/* 277 */       return set;
/*     */     }
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   static boolean containsInSell(int itemid)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: getstatic 57	mzm/gsp/shanghui/main/ShanghuiManager:sellItemSet	Ljava/util/Set;
/*     */     //   3: dup
/*     */     //   4: astore_1
/*     */     //   5: monitorenter
/*     */     //   6: getstatic 57	mzm/gsp/shanghui/main/ShanghuiManager:sellItemSet	Ljava/util/Set;
/*     */     //   9: iload_0
/*     */     //   10: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   13: invokeinterface 51 2 0
/*     */     //   18: aload_1
/*     */     //   19: monitorexit
/*     */     //   20: ireturn
/*     */     //   21: astore_2
/*     */     //   22: aload_1
/*     */     //   23: monitorexit
/*     */     //   24: aload_2
/*     */     //   25: athrow
/*     */     // Line number table:
/*     */     //   Java source line #283	-> byte code offset #0
/*     */     //   Java source line #285	-> byte code offset #6
/*     */     //   Java source line #286	-> byte code offset #21
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	26	0	itemid	int
/*     */     //   4	19	1	Ljava/lang/Object;	Object
/*     */     //   21	4	2	localObject1	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   6	20	21	finally
/*     */     //   21	24	21	finally
/*     */   }
/*     */   
/*     */   static void syncShangHuiInfo(long roleId, int suType, int index)
/*     */   {
/* 297 */     ShoppingItemMapInfo shopItemMapInfo = (ShoppingItemMapInfo)syncShoppingItemMap.get(Integer.valueOf(suType));
/* 298 */     if (shopItemMapInfo == null)
/*     */     {
/* 300 */       SCommonResultRes res = new SCommonResultRes();
/* 301 */       res.res = 60;
/* 302 */       OnlineManager.getInstance().sendAtOnce(roleId, res);
/* 303 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 308 */       shopItemMapInfo.rwLock.readLock().lock();
/*     */       
/* 310 */       int indexNum = (index - 1) * SShangHuiConsts.getInstance().SHANGHUI_PAGE_NUM;
/* 311 */       if (indexNum < 0)
/*     */       {
/* 313 */         SCommonResultRes res = new SCommonResultRes();
/* 314 */         res.res = 60;
/* 315 */         OnlineManager.getInstance().sendAtOnce(roleId, res);
/*     */ 
/*     */       }
/* 318 */       else if (shopItemMapInfo.shoppintItems.size() <= indexNum)
/*     */       {
/* 320 */         SCommonResultRes res = new SCommonResultRes();
/* 321 */         res.res = 60;
/* 322 */         OnlineManager.getInstance().sendAtOnce(roleId, res);
/*     */       }
/*     */       else {
/* 325 */         List<Integer> itemIdList = getAllSubTypeItemForLevel(ServerInterface.getCurrentServerLevel(), getBigTypeIdFromSubType(suType).intValue(), suType);
/*     */         
/* 327 */         if (itemIdList.size() <= indexNum)
/*     */         {
/* 329 */           SCommonResultRes res = new SCommonResultRes();
/* 330 */           res.res = 60;
/* 331 */           OnlineManager.getInstance().sendAtOnce(roleId, res);
/*     */         }
/*     */         else {
/* 334 */           SSyncShopingList shopList = new SSyncShopingList();
/* 335 */           for (int i = indexNum; i <= indexNum + SShangHuiConsts.getInstance().SHANGHUI_PAGE_NUM; i++)
/*     */           {
/* 337 */             if (i >= itemIdList.size()) {
/*     */               break;
/*     */             }
/*     */             
/* 341 */             Integer itemId = (Integer)itemIdList.get(i);
/* 342 */             if (itemId != null)
/*     */             {
/* 344 */               ShoppingItem shoppingItem = (ShoppingItem)shopItemMapInfo.shoppintItems.get(Integer.valueOf(itemId.intValue()));
/* 345 */               if (shoppingItem != null)
/*     */               {
/* 347 */                 shopList.shoppingitemlist.add(shoppingItem);
/*     */               }
/*     */             }
/*     */           }
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
/* 365 */           OnlineManager.getInstance().send(roleId, shopList);
/*     */         }
/*     */       }
/*     */     } finally {
/* 369 */       shopItemMapInfo.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   static SShangHuiItemToolsCfg getShangHuiItemCfg(int itemId)
/*     */   {
/* 375 */     return SShangHuiItemToolsCfg.get(itemId);
/*     */   }
/*     */   
/*     */   static Integer getItemBigTypeId(int itemId)
/*     */   {
/* 380 */     SShangHuiItemToolsCfg item2TypeCfg = SShangHuiItemToolsCfg.get(itemId);
/* 381 */     if (item2TypeCfg == null)
/*     */     {
/* 383 */       return null;
/*     */     }
/* 385 */     return Integer.valueOf(item2TypeCfg.bigTypeId);
/*     */   }
/*     */   
/*     */   static Integer getItemSubTypeId(int itemId)
/*     */   {
/* 390 */     SShangHuiItemToolsCfg item2TypeCfg = SShangHuiItemToolsCfg.get(itemId);
/* 391 */     if (item2TypeCfg == null)
/*     */     {
/* 393 */       return null;
/*     */     }
/* 395 */     return Integer.valueOf(item2TypeCfg.SubTypeId);
/*     */   }
/*     */   
/*     */   static Integer getBigTypeIdFromSubType(int subType)
/*     */   {
/* 400 */     for (Iterator i$ = SShangHuiCfg.getAll().values().iterator(); i$.hasNext();) { bigTypeCfg = (SShangHuiCfg)i$.next();
/*     */       
/* 402 */       for (Integer subtype : bigTypeCfg.SubTypeIdList)
/*     */       {
/* 404 */         if (subtype.intValue() == subType)
/*     */         {
/* 406 */           return Integer.valueOf(bigTypeCfg.id); }
/*     */       }
/*     */     }
/*     */     SShangHuiCfg bigTypeCfg;
/* 410 */     return null;
/*     */   }
/*     */   
/*     */   static SRecommandPriceCfg getRecommandCfg(int itemId, int serverLevel)
/*     */   {
/* 415 */     STItem2RecommandPriceCfg item2cfg = STItem2RecommandPriceCfg.get(itemId);
/* 416 */     if (item2cfg == null)
/*     */     {
/* 418 */       return null;
/*     */     }
/* 420 */     for (Iterator i$ = item2cfg.recommandPriceCfgIds.iterator(); i$.hasNext();) { int cfgId = ((Integer)i$.next()).intValue();
/*     */       
/* 422 */       SRecommandPriceCfg cfg = SRecommandPriceCfg.get(cfgId);
/* 423 */       if (cfg != null)
/*     */       {
/*     */ 
/*     */ 
/* 427 */         if ((cfg.minServerLevel <= serverLevel) && (cfg.maxServerLevel >= serverLevel))
/*     */         {
/* 429 */           return cfg; }
/*     */       }
/*     */     }
/* 432 */     return null;
/*     */   }
/*     */   
/*     */   static boolean isSameDay(long time1, long time2)
/*     */   {
/* 437 */     Calendar c1 = Calendar.getInstance();
/* 438 */     Calendar c2 = Calendar.getInstance();
/* 439 */     c1.setTimeInMillis(time1);
/* 440 */     c2.setTimeInMillis(time2);
/* 441 */     if ((c1.get(6) != c2.get(6)) || (c1.get(1) != c2.get(1)))
/*     */     {
/* 443 */       return false;
/*     */     }
/* 445 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void updateShoppingItem(ShangHuiItem xShangHuiItem, int itemId)
/*     */   {
/* 456 */     ShoppingItem shoppingItem = getShoppingItem(itemId);
/* 457 */     if (shoppingItem == null)
/*     */     {
/* 459 */       return;
/*     */     }
/* 461 */     fill(itemId, xShangHuiItem, shoppingItem);
/*     */     
/* 463 */     ShoppingItemMapInfo shopItemMapInfo = (ShoppingItemMapInfo)syncShoppingItemMap.get(getItemSubTypeId(itemId));
/* 464 */     if (shopItemMapInfo != null)
/*     */     {
/*     */       try
/*     */       {
/* 468 */         shopItemMapInfo.rwLock.writeLock().lock();
/* 469 */         shopItemMapInfo.shoppintItems.put(Integer.valueOf(itemId), shoppingItem);
/*     */       }
/*     */       finally
/*     */       {
/* 473 */         shopItemMapInfo.rwLock.writeLock().unlock();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addShoppingItem(ShangHuiItem xShangHuiItem, int itemId)
/*     */   {
/* 486 */     ShoppingItem shoppingItem = new ShoppingItem();
/* 487 */     fill(itemId, xShangHuiItem, shoppingItem);
/*     */     
/* 489 */     int subTypeId = getItemSubTypeId(itemId).intValue();
/* 490 */     ShoppingItemMapInfo shopItemMapInfo = (ShoppingItemMapInfo)syncShoppingItemMap.get(Integer.valueOf(subTypeId));
/* 491 */     if (shopItemMapInfo == null)
/*     */     {
/* 493 */       shopItemMapInfo = new ShoppingItemMapInfo(null);
/* 494 */       syncShoppingItemMap.putIfAbsent(Integer.valueOf(subTypeId), shopItemMapInfo);
/* 495 */       shopItemMapInfo = (ShoppingItemMapInfo)syncShoppingItemMap.get(Integer.valueOf(subTypeId));
/*     */     }
/*     */     try
/*     */     {
/* 499 */       shopItemMapInfo.rwLock.writeLock().lock();
/* 500 */       shopItemMapInfo.shoppintItems.put(Integer.valueOf(itemId), shoppingItem);
/*     */     }
/*     */     finally
/*     */     {
/* 504 */       shopItemMapInfo.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void deleteShoppingItem(int itemId)
/*     */   {
/* 515 */     int subTypeId = getItemSubTypeId(itemId).intValue();
/* 516 */     ShoppingItemMapInfo shopItemMapInfo = (ShoppingItemMapInfo)syncShoppingItemMap.get(Integer.valueOf(subTypeId));
/* 517 */     if (shopItemMapInfo == null)
/*     */     {
/* 519 */       shopItemMapInfo = new ShoppingItemMapInfo(null);
/* 520 */       syncShoppingItemMap.putIfAbsent(Integer.valueOf(subTypeId), shopItemMapInfo);
/* 521 */       shopItemMapInfo = (ShoppingItemMapInfo)syncShoppingItemMap.get(Integer.valueOf(subTypeId));
/* 522 */       return;
/*     */     }
/*     */     try
/*     */     {
/* 526 */       shopItemMapInfo.rwLock.writeLock().lock();
/* 527 */       shopItemMapInfo.shoppintItems.remove(Integer.valueOf(itemId));
/*     */     }
/*     */     finally
/*     */     {
/* 531 */       shopItemMapInfo.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void deleteShoppingItem(int subTypeId, int itemId)
/*     */   {
/* 543 */     ShoppingItemMapInfo shopItemMapInfo = (ShoppingItemMapInfo)syncShoppingItemMap.get(Integer.valueOf(subTypeId));
/* 544 */     if (shopItemMapInfo == null)
/*     */     {
/* 546 */       return;
/*     */     }
/*     */     try
/*     */     {
/* 550 */       shopItemMapInfo.rwLock.writeLock().lock();
/* 551 */       shopItemMapInfo.shoppintItems.remove(Integer.valueOf(itemId));
/*     */     }
/*     */     finally
/*     */     {
/* 555 */       shopItemMapInfo.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static ShoppingItem getShoppingItem(int itemId)
/*     */   {
/* 567 */     Integer subType = getItemSubTypeId(itemId);
/* 568 */     if (subType == null)
/*     */     {
/* 570 */       return null;
/*     */     }
/* 572 */     ShoppingItemMapInfo shopItemMapInfo = (ShoppingItemMapInfo)syncShoppingItemMap.get(subType);
/* 573 */     if (shopItemMapInfo != null)
/*     */     {
/*     */       try
/*     */       {
/* 577 */         shopItemMapInfo.rwLock.readLock().lock();
/* 578 */         return (ShoppingItem)shopItemMapInfo.shoppintItems.get(Integer.valueOf(itemId));
/*     */       }
/*     */       finally
/*     */       {
/* 582 */         shopItemMapInfo.rwLock.readLock().unlock();
/*     */       }
/*     */     }
/*     */     
/* 586 */     return null;
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
/*     */   static int getItemPrice(int itemId)
/*     */   {
/* 599 */     ShoppingItem shoppingItem = getShoppingItem(itemId);
/* 600 */     if (shoppingItem != null)
/*     */     {
/* 602 */       return shoppingItem.price;
/*     */     }
/*     */     
/*     */ 
/* 606 */     SShangHuiItemToolsCfg cfg = getShangHuiItemCfg(itemId);
/* 607 */     if (cfg == null)
/*     */     {
/* 609 */       return -1;
/*     */     }
/* 611 */     SOrginalPriceCfg orginalPriceCfg = SOrginalPriceCfg.get(cfg.orginalPriceCfgId);
/* 612 */     if (orginalPriceCfg == null)
/*     */     {
/* 614 */       return -1;
/*     */     }
/* 616 */     shoppingItem = getShoppingItem(orginalPriceCfg.lastLevelItemId);
/* 617 */     if (shoppingItem == null)
/*     */     {
/* 619 */       return -1;
/*     */     }
/*     */     
/*     */ 
/* 623 */     return (int)(shoppingItem.price * orginalPriceCfg.priceRate);
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
/*     */   static boolean isItemPriceFloat(int itemid)
/*     */   {
/* 636 */     SShangHuiItemToolsCfg shangHuiItemCfg = getShangHuiItemCfg(itemid);
/* 637 */     if (shangHuiItemCfg == null)
/*     */     {
/* 639 */       return false;
/*     */     }
/* 641 */     return shangHuiItemCfg.isPriceFlow;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isItemInShanghuiCfg(int itemid)
/*     */   {
/* 653 */     SShangHuiItemToolsCfg shangHuiItemCfg = getShangHuiItemCfg(itemid);
/* 654 */     if (shangHuiItemCfg == null)
/*     */     {
/* 656 */       return false;
/*     */     }
/* 658 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isShangHuiSwitchOpenForRole(long roleid, boolean sendStatusTip)
/*     */   {
/* 670 */     if (!isShangHuiSwitchOpen())
/*     */     {
/* 672 */       return false;
/*     */     }
/* 674 */     if (OpenInterface.isBanPlay(roleid, 101))
/*     */     {
/* 676 */       OpenInterface.sendBanPlayMsg(roleid, 101);
/* 677 */       return false;
/*     */     }
/* 679 */     if (!checkRoleKuaFuStateCanUseFun(roleid, sendStatusTip))
/*     */     {
/* 681 */       return false;
/*     */     }
/* 683 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isShangHuiSwitchOpenForRole(long roleid)
/*     */   {
/* 695 */     return isShangHuiSwitchOpenForRole(roleid, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isShangHuiSwitchOpen()
/*     */   {
/* 705 */     if (!OpenInterface.getOpenStatus(101))
/*     */     {
/* 707 */       return false;
/*     */     }
/* 709 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isShangHuiOpenSubTypeItem(long roleId, int itemCfgId)
/*     */   {
/* 719 */     Integer subType = getItemSubTypeId(itemCfgId);
/* 720 */     if (subType == null)
/*     */     {
/* 722 */       return false;
/*     */     }
/* 724 */     SShangHuiSubTypeCfg shangHuiSubTypeCfg = SShangHuiSubTypeCfg.get(subType.intValue());
/* 725 */     if (shangHuiSubTypeCfg == null)
/*     */     {
/* 727 */       return false;
/*     */     }
/* 729 */     if (!OpenInterface.getOpenStatus(shangHuiSubTypeCfg.openId))
/*     */     {
/* 731 */       return false;
/*     */     }
/* 733 */     if (OpenInterface.isBanPlay(roleId, shangHuiSubTypeCfg.openId))
/*     */     {
/* 735 */       OpenInterface.sendBanPlayMsg(roleId, shangHuiSubTypeCfg.openId);
/* 736 */       return false;
/*     */     }
/* 738 */     return true;
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
/*     */   static int getRoleAlreadyBuyItemNum(RoleShangHuiBean xRoleShangHuiBean, int itemId)
/*     */   {
/* 751 */     if ((xRoleShangHuiBean == null) || (DateTimeUtils.needDailyReset(xRoleShangHuiBean.getTimestamp(), DateTimeUtils.getCurrTimeInMillis(), 0)))
/*     */     {
/*     */ 
/* 754 */       return 0;
/*     */     }
/* 756 */     RoleShangHuiItem xRoleItem = (RoleShangHuiItem)xRoleShangHuiBean.getItemmap().get(Integer.valueOf(itemId));
/* 757 */     return xRoleItem == null ? 0 : xRoleItem.getBuynum();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isDebugLogEnabled()
/*     */   {
/* 768 */     return logger.isDebugEnabled();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void logDebug(String format, Object... args)
/*     */   {
/* 779 */     if (logger.isDebugEnabled())
/*     */     {
/* 781 */       logger.debug(String.format(format, args));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void logInfo(String format, Object... args)
/*     */   {
/* 793 */     logger.info(String.format(format, args));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean checkRoleKuaFuStateCanUseFun(long roleid, boolean sendStatusTip)
/*     */   {
/* 805 */     if (!RoleStatusInterface.checkCanSetStatus(roleid, 193, sendStatusTip))
/*     */     {
/* 807 */       Set<Integer> statusSet = RoleStatusInterface.getStatusSet(roleid);
/* 808 */       mzm.gsp.GameServer.logger().error(String.format("[shanghui]ShanghuiManager.checkRoleKuaFuStateCanUseFun@ role in STATUS_ROAM close shanghui!|roleid=%d|status_set=%s", new Object[] { Long.valueOf(roleid), statusSet }));
/*     */       
/*     */ 
/*     */ 
/* 812 */       return false;
/*     */     }
/* 814 */     return true;
/*     */   }
/*     */   
/*     */   static List<ShoppingItem> getShangHuiItemListBySubType(int subType)
/*     */   {
/* 819 */     List<ShoppingItem> shoppingItemList = new ArrayList();
/* 820 */     ShoppingItemMapInfo shopItemMapInfo = (ShoppingItemMapInfo)syncShoppingItemMap.get(Integer.valueOf(subType));
/* 821 */     if (shopItemMapInfo == null)
/*     */     {
/* 823 */       return shoppingItemList;
/*     */     }
/* 825 */     List<Integer> itemIdList = getAllSubTypeItemForLevel(ServerInterface.getCurrentServerLevel(), getBigTypeIdFromSubType(subType).intValue(), subType);
/*     */     
/* 827 */     if ((itemIdList == null) || (itemIdList.isEmpty()))
/*     */     {
/* 829 */       return shoppingItemList;
/*     */     }
/*     */     try
/*     */     {
/* 833 */       shopItemMapInfo.rwLock.readLock().lock();
/* 834 */       for (i$ = itemIdList.iterator(); i$.hasNext();) { int itemId = ((Integer)i$.next()).intValue();
/*     */         
/* 836 */         if (shopItemMapInfo.shoppintItems.containsKey(Integer.valueOf(itemId)))
/*     */         {
/*     */ 
/*     */ 
/* 840 */           shoppingItemList.add(shopItemMapInfo.shoppintItems.get(Integer.valueOf(itemId)));
/*     */         }
/*     */       }
/*     */     } finally {
/*     */       Iterator i$;
/* 845 */       shopItemMapInfo.rwLock.readLock().unlock();
/*     */     }
/* 847 */     return shoppingItemList;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\ShanghuiManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */