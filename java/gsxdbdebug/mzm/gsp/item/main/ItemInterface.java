/*      */ package mzm.gsp.item.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import mzm.gsp.bag.confbean.SBagCfg;
/*      */ import mzm.gsp.baitan.main.BaiTanInterface;
/*      */ import mzm.gsp.equipmentbless.main.EquipmentBlessInterface;
/*      */ import mzm.gsp.feijian.confbean.SFeiJianCfg;
/*      */ import mzm.gsp.item.ItemInfo;
/*      */ import mzm.gsp.item.SResItemWithCarryMax;
/*      */ import mzm.gsp.item.SSynBagAddItem;
/*      */ import mzm.gsp.item.confbean.EquipItemCfgConsts;
/*      */ import mzm.gsp.item.confbean.IdTypeValueBean;
/*      */ import mzm.gsp.item.confbean.ItemCfgConsts;
/*      */ import mzm.gsp.item.confbean.SAirCraftItem;
/*      */ import mzm.gsp.item.confbean.SGiftbagItem;
/*      */ import mzm.gsp.item.confbean.SItemCfg;
/*      */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*      */ import mzm.gsp.item.confbean.SItemPriceCfg;
/*      */ import mzm.gsp.item.confbean.SItemSiftCfg;
/*      */ import mzm.gsp.item.main.sift.SiftInterface;
/*      */ import mzm.gsp.mail.main.MailAttachment;
/*      */ import mzm.gsp.mail.main.MailInterface;
/*      */ import mzm.gsp.mall.main.MallInterface;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.qingfu.main.CostResult;
/*      */ import mzm.gsp.qingfu.main.CostType;
/*      */ import mzm.gsp.qingfu.main.QingfuInterface;
/*      */ import mzm.gsp.server.main.ServerInterface;
/*      */ import mzm.gsp.serverconf.confbean.ServerLevelConsts;
/*      */ import mzm.gsp.shanghui.main.ShanghuiInterface;
/*      */ import mzm.gsp.skill.main.PassiveSkill;
/*      */ import mzm.gsp.superequipment.jewel.main.SuperEquipmentJewelInterface;
/*      */ import mzm.gsp.superequipment.main.SuperEquipmentInterface;
/*      */ import mzm.gsp.superequipment.wushi.main.WuShiInterface;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.LogicProcedure;
/*      */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*      */ import mzm.gsp.util.Pair;
/*      */ import mzm.gsp.util.confbean.MoneyExchangeCfgConsts;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.FumoInfo;
/*      */ import xbean.Item;
/*      */ import xdb.Xdb;
/*      */ import xio.Protocol;
/*      */ 
/*      */ public class ItemInterface
/*      */ {
/*      */   public static BasicItem getItemByCfgId(long paramLong, int paramInt)
/*      */   {
/*   62 */     return getItemByCfgId(paramLong, paramInt, true);
/*      */   }
/*      */   
/*      */   public static BasicItem getItemByCfgId(long paramLong, int paramInt, boolean paramBoolean) {
/*   66 */     return getItemByCfgId(paramLong, 340600000, paramInt, paramBoolean);
/*      */   }
/*      */   
/*      */   public static BasicItem getItemByCfgId(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean) {
/*   70 */     RoleItemBag localRoleItemBag = ItemManager.getBagByItemId(paramLong, paramInt1, paramInt2, paramBoolean);
/*   71 */     if (localRoleItemBag == null) {
/*   72 */       return null;
/*      */     }
/*   74 */     Map localMap = localRoleItemBag.getItemBycfgId(paramInt2);
/*   75 */     Iterator localIterator = localMap.values().iterator();
/*   76 */     if (localIterator.hasNext()) {
/*   77 */       return (BasicItem)localIterator.next();
/*      */     }
/*   79 */     return null;
/*      */   }
/*      */   
/*      */   public static BasicItem getItem(long paramLong, int paramInt) {
/*   83 */     return getItem(paramLong, 340600000, paramInt);
/*      */   }
/*      */   
/*      */   public static BasicItem getItem(long paramLong, int paramInt1, int paramInt2) {
/*   87 */     return getItem(paramLong, paramInt1, paramInt2, true);
/*      */   }
/*      */   
/*      */   public static BasicItem getItem(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean) {
/*   91 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, paramInt1, paramBoolean);
/*   92 */     if (localRoleItemBag == null) {
/*   93 */       return null;
/*      */     }
/*   95 */     return localRoleItemBag.get(paramInt2);
/*      */   }
/*      */   
/*      */   public static BasicItem getItemByUuid(long paramLong1, long paramLong2) {
/*   99 */     return getItemByUuid(paramLong1, 340600000, paramLong2);
/*      */   }
/*      */   
/*      */   public static BasicItem getItemByUuid(long paramLong1, int paramInt, long paramLong2) {
/*  103 */     return getItemByUuid(paramLong1, paramInt, paramLong2, true);
/*      */   }
/*      */   
/*      */   public static BasicItem getItemByUuidFromStorage(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean) {
/*  107 */     RoleStorageBag localRoleStorageBag = ItemManager.getRoleStorageBag(paramLong1, paramInt, paramBoolean);
/*  108 */     if (localRoleStorageBag == null) {
/*  109 */       return null;
/*      */     }
/*  111 */     return localRoleStorageBag.getItemByUuid(paramLong2);
/*      */   }
/*      */   
/*      */   public static BasicItem getItemByUuidFromStorage(long paramLong1, long paramLong2, boolean paramBoolean) {
/*  115 */     List localList = ItemManager.getAllRoleStorageBags(paramLong1, paramBoolean);
/*  116 */     for (RoleStorageBag localRoleStorageBag : localList) {
/*  117 */       BasicItem localBasicItem = localRoleStorageBag.getItemByUuid(paramLong2);
/*  118 */       if (localBasicItem != null) {
/*  119 */         return localBasicItem;
/*      */       }
/*      */     }
/*  122 */     return null;
/*      */   }
/*      */   
/*      */   public static BasicItem getItemByUuid(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean) {
/*  126 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong1, paramInt, paramBoolean);
/*  127 */     if (localRoleItemBag == null) {
/*  128 */       return null;
/*      */     }
/*  130 */     return localRoleItemBag.getItemByUuid(paramLong2);
/*      */   }
/*      */   
/*      */   public static int getGridByUuid(long paramLong1, int paramInt, long paramLong2) {
/*  134 */     return getGridByUuid(paramLong1, paramInt, paramLong2, true);
/*      */   }
/*      */   
/*      */   public static int getGridByUuid(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean) {
/*  138 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong1, paramInt, paramBoolean);
/*  139 */     return localRoleItemBag.getGridByUuid(paramLong2);
/*      */   }
/*      */   
/*      */   public static int getItemNumberById(long paramLong, int paramInt) {
/*  143 */     return getItemNumberById(paramLong, 340600000, paramInt, true);
/*      */   }
/*      */   
/*      */   public static int getItemNumberById(long paramLong, int paramInt1, int paramInt2) {
/*  147 */     return getItemNumberById(paramLong, paramInt1, paramInt2, true);
/*      */   }
/*      */   
/*      */   public static int getItemNumberById(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean) {
/*  151 */     RoleItemBag localRoleItemBag = ItemManager.getBagByItemId(paramLong, paramInt1, paramInt2, paramBoolean);
/*  152 */     if (localRoleItemBag == null) {
/*  153 */       return 0;
/*      */     }
/*  155 */     return localRoleItemBag.getItemNumberBycfgId(paramInt2);
/*      */   }
/*      */   
/*      */   public static int getTotalItemNumberById(long paramLong, int paramInt) {
/*  159 */     return getTotalItemNumberById(paramLong, paramInt, true);
/*      */   }
/*      */   
/*      */   public static int getTotalItemNumberById(long paramLong, int paramInt, boolean paramBoolean) {
/*  163 */     int i = ItemManager.getBagIdByItemId(340600000, paramInt);
/*  164 */     if (i != 340600000) {
/*  165 */       RoleItemBag localRoleItemBag1 = ItemManager.getBag(paramLong, i, paramBoolean);
/*  166 */       if (localRoleItemBag1 != null) {
/*  167 */         return localRoleItemBag1.getItemNumberBycfgId(paramInt);
/*      */       }
/*      */     }
/*  170 */     int j = 0;
/*  171 */     RoleItemBag localRoleItemBag2 = ItemManager.getBag(paramLong, 340600000, paramBoolean);
/*  172 */     if (localRoleItemBag2 != null) {
/*  173 */       j += localRoleItemBag2.getItemNumberBycfgId(paramInt);
/*      */     }
/*  175 */     RoleItemBag localRoleItemBag3 = ItemManager.getBag(paramLong, 340600001, paramBoolean);
/*  176 */     if (localRoleItemBag3 != null) {
/*  177 */       j += localRoleItemBag3.getItemNumberBycfgId(paramInt);
/*      */     }
/*  179 */     List localList = ItemManager.getAllRoleStorageBags(paramLong, paramBoolean);
/*  180 */     for (RoleStorageBag localRoleStorageBag : localList) {
/*  181 */       j += localRoleStorageBag.getItemNumberBycfgId(paramInt);
/*      */     }
/*  183 */     return j;
/*      */   }
/*      */   
/*      */   public static int getItemNumberByType(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean) {
/*  187 */     RoleItemBag localRoleItemBag = ItemManager.getBagByItemType(paramLong, paramInt1, paramInt2, paramBoolean);
/*  188 */     if (localRoleItemBag == null) {
/*  189 */       return 0;
/*      */     }
/*  191 */     return localRoleItemBag.getItemNumberByType(paramInt2);
/*      */   }
/*      */   
/*      */   public static boolean moveItemIntoEquipBag(long paramLong, int paramInt) {
/*  195 */     RoleItemBag localRoleItemBag = ItemManager.getRoleItemBag(paramLong);
/*  196 */     RoleEquipBag localRoleEquipBag = ItemManager.getRoleEquipBag(paramLong);
/*  197 */     if ((localRoleItemBag == null) || (localRoleEquipBag == null)) {
/*  198 */       return false;
/*      */     }
/*  200 */     BasicItem localBasicItem = localRoleItemBag.removeByGrid(paramInt);
/*  201 */     if (localBasicItem == null) {
/*  202 */       return false;
/*      */     }
/*  204 */     ItemOperateResult localItemOperateResult = localRoleEquipBag.addItem(localBasicItem);
/*  205 */     return localItemOperateResult.success();
/*      */   }
/*      */   
/*      */   public static BasicItem moveItemFromBag(long paramLong, int paramInt) {
/*  209 */     RoleItemBag localRoleItemBag = ItemManager.getRoleItemBag(paramLong);
/*  210 */     if (localRoleItemBag == null) {
/*  211 */       return null;
/*      */     }
/*  213 */     return localRoleItemBag.removeByGrid(paramInt);
/*      */   }
/*      */   
/*      */   public static BasicItem getAndRemoveFromBag(long paramLong, int paramInt1, int paramInt2) {
/*  217 */     RoleItemBag localRoleItemBag = ItemManager.getRoleItemBag(paramLong);
/*  218 */     if (localRoleItemBag == null) {
/*  219 */       return null;
/*      */     }
/*  221 */     return localRoleItemBag.getAndRemoveItem(paramInt1, paramInt2);
/*      */   }
/*      */   
/*      */   public static boolean moveItemInBag(long paramLong, BasicItem paramBasicItem) {
/*  225 */     return moveItemInBag(paramLong, paramBasicItem, false);
/*      */   }
/*      */   
/*      */   public static boolean moveItemInBag(long paramLong, BasicItem paramBasicItem, boolean paramBoolean) {
/*  229 */     RoleItemBag localRoleItemBag = ItemManager.getRoleItemBag(paramLong);
/*  230 */     if (localRoleItemBag == null) {
/*  231 */       return false;
/*      */     }
/*  233 */     ItemOperateResult localItemOperateResult = localRoleItemBag.addItem(paramBasicItem, paramBoolean);
/*  234 */     return localItemOperateResult.success();
/*      */   }
/*      */   
/*      */   public static boolean moveItemIntoEquipBag(long paramLong1, long paramLong2) {
/*  238 */     RoleItemBag localRoleItemBag = ItemManager.getRoleItemBag(paramLong1);
/*  239 */     RoleEquipBag localRoleEquipBag = ItemManager.getRoleEquipBag(paramLong1);
/*  240 */     if ((localRoleItemBag == null) || (localRoleEquipBag == null)) {
/*  241 */       return false;
/*      */     }
/*  243 */     ItemOperateResult localItemOperateResult1 = localRoleItemBag.removeItemByUuid(paramLong2, 1);
/*  244 */     if ((!localItemOperateResult1.success()) || (localItemOperateResult1.getChangeItemInfoList() == null) || (localItemOperateResult1.getChangeItemInfoList().size() == 0)) {
/*  245 */       return false;
/*      */     }
/*  247 */     BasicItem localBasicItem = ((ItemOperateResult.ChangeItemInfo)localItemOperateResult1.getChangeItemInfoList().get(0)).basicItem;
/*  248 */     ItemOperateResult localItemOperateResult2 = localRoleEquipBag.addItem(localBasicItem);
/*  249 */     return localItemOperateResult2.success();
/*      */   }
/*      */   
/*      */   public static boolean moveItemBetWeenBags(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  253 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, paramInt1);
/*  254 */     if (localRoleItemBag == null) {
/*  255 */       return false;
/*      */     }
/*  257 */     int i = localRoleItemBag.getItemNumberByGrid(paramInt2);
/*  258 */     return (i > 0) && (moveItemBetWeenBags(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, i));
/*      */   }
/*      */   
/*      */   public static boolean moveItemBetWeenBags(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/*  262 */     RoleItemBag localRoleItemBag1 = ItemManager.getBag(paramLong, paramInt1);
/*  263 */     RoleItemBag localRoleItemBag2 = ItemManager.getBag(paramLong, paramInt3);
/*  264 */     if ((localRoleItemBag1 == null) || (localRoleItemBag2 == null)) {
/*  265 */       return false;
/*      */     }
/*  267 */     BasicItem localBasicItem1 = localRoleItemBag1.get(paramInt2);
/*  268 */     if ((paramInt5 <= 0) || (localBasicItem1 == null) || (localBasicItem1.getNumber() < paramInt5)) {
/*  269 */       return false;
/*      */     }
/*  271 */     BasicItem localBasicItem2 = localRoleItemBag1.getAndRemoveItem(paramInt2, paramInt5);
/*  272 */     if (localBasicItem2 != null) {
/*      */       boolean bool;
/*  274 */       if (paramInt4 == -1) {
/*  275 */         bool = localRoleItemBag2.add(localBasicItem2);
/*      */       }
/*      */       else {
/*  278 */         bool = localRoleItemBag2.add(paramInt4, localBasicItem2);
/*      */       }
/*  280 */       return bool;
/*      */     }
/*  282 */     return false;
/*      */   }
/*      */   
/*      */   public static boolean moveItemIntoStorage(long paramLong, int paramInt1, int paramInt2) {
/*  286 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, 340600000);
/*  287 */     if (localRoleItemBag == null) {
/*  288 */       return false;
/*      */     }
/*  290 */     int i = localRoleItemBag.getItemNumberByGrid(paramInt1);
/*  291 */     return moveItemIntoStorage(paramLong, paramInt1, i, paramInt2);
/*      */   }
/*      */   
/*      */   public static boolean moveItemIntoStorage(long paramLong, int paramInt1, int paramInt2, int paramInt3) {
/*  295 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, 340600000);
/*  296 */     if (localRoleItemBag == null) {
/*  297 */       return false;
/*      */     }
/*  299 */     BasicItem localBasicItem = localRoleItemBag.getAndRemoveItem(paramInt1, paramInt2, true);
/*  300 */     if (localBasicItem == null) {
/*  301 */       return false;
/*      */     }
/*  303 */     RoleStorageBag localRoleStorageBag = ItemManager.getRoleStorageBag(paramLong, paramInt3, true);
/*  304 */     if (localRoleStorageBag == null) {
/*  305 */       localObject = String.format("[item]ItemInterface.moveItemIntoStorage@move item into storage error|roleid=%d|srcgird=%d|storageid=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
/*  306 */       ItemManager.logger.error(localObject);
/*  307 */       return false;
/*      */     }
/*  309 */     Object localObject = localRoleStorageBag.addItem(localBasicItem, true);
/*  310 */     if (((ItemOperateResult)localObject).isBagFull()) {
/*  311 */       ItemManager.sendWrongInfo(paramLong, 4, new String[0]);
/*      */     }
/*  313 */     return ((ItemOperateResult)localObject).success();
/*      */   }
/*      */   
/*      */   public static boolean moveItemIntoBag(long paramLong, int paramInt1, int paramInt2) {
/*  317 */     RoleStorageBag localRoleStorageBag = ItemManager.getRoleStorageBag(paramLong, paramInt2, true);
/*  318 */     if (localRoleStorageBag == null) {
/*  319 */       String str = String.format("[item]ItemInterface.moveItemIntoBag@move item into storage error|roleid=%d|srcGrid=%d|storageid=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
/*  320 */       ItemManager.logger.error(str);
/*  321 */       return false;
/*      */     }
/*  323 */     int i = localRoleStorageBag.getItemNumberByGrid(paramInt1);
/*  324 */     return moveItemIntoBag(paramLong, paramInt1, i, paramInt2);
/*      */   }
/*      */   
/*      */   public static boolean moveItemIntoBag(long paramLong, int paramInt1, int paramInt2, int paramInt3) {
/*  328 */     RoleStorageBag localRoleStorageBag = ItemManager.getRoleStorageBag(paramLong, paramInt3, true);
/*  329 */     if (localRoleStorageBag == null) {
/*  330 */       localObject = String.format("[item]ItemInterface.moveItemIntoBag@move item into storage failed|roleid=%d|srcGrid=%d|num=%d|storageid=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
/*  331 */       ItemManager.logger.error(localObject);
/*  332 */       return false;
/*      */     }
/*  334 */     Object localObject = localRoleStorageBag.getAndRemoveItem(paramInt1, paramInt2, true);
/*  335 */     if (localObject == null) {
/*  336 */       return false;
/*      */     }
/*  338 */     RoleItemBag localRoleItemBag = ItemManager.getBagByItemId(paramLong, 340600000, ((BasicItem)localObject).getCfgId(), true);
/*  339 */     if (localRoleItemBag == null) {
/*  340 */       return false;
/*      */     }
/*  342 */     ItemOperateResult localItemOperateResult = localRoleItemBag.addItem((BasicItem)localObject, true);
/*  343 */     if (localItemOperateResult.isBagFull()) {
/*  344 */       ItemManager.sendWrongInfo(paramLong, 5, new String[0]);
/*      */     }
/*  346 */     return localItemOperateResult.success();
/*      */   }
/*      */   
/*      */   public static boolean exchangeItem(long paramLong, int paramInt1, int paramInt2) {
/*  350 */     RoleItemBag localRoleItemBag = ItemManager.getRoleItemBag(paramLong);
/*  351 */     RoleEquipBag localRoleEquipBag = ItemManager.getRoleEquipBag(paramLong);
/*  352 */     if ((localRoleItemBag == null) || (localRoleEquipBag == null)) {
/*  353 */       return false;
/*      */     }
/*  355 */     BasicItem localBasicItem1 = localRoleItemBag.removeByGrid(paramInt1);
/*  356 */     BasicItem localBasicItem2 = localRoleEquipBag.removeByGrid(paramInt2);
/*  357 */     if ((localBasicItem1 == null) || (localBasicItem2 == null)) {
/*  358 */       return false;
/*      */     }
/*  360 */     ItemOperateResult localItemOperateResult1 = localRoleItemBag.addItem(localBasicItem2);
/*  361 */     ItemOperateResult localItemOperateResult2 = localRoleEquipBag.addItem(localBasicItem1);
/*  362 */     return (localItemOperateResult1.success()) && (localItemOperateResult2.success());
/*      */   }
/*      */   
/*      */   public static boolean exchangeItem(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3) {
/*  366 */     RoleItemBag localRoleItemBag1 = ItemManager.getBag(paramLong1, paramInt1);
/*  367 */     RoleItemBag localRoleItemBag2 = ItemManager.getBag(paramLong1, paramInt2);
/*  368 */     if ((localRoleItemBag1 == null) || (localRoleItemBag2 == null)) {
/*  369 */       return false;
/*      */     }
/*  371 */     int i = localRoleItemBag1.getGridByUuid(paramLong2);
/*  372 */     int j = localRoleItemBag2.getGridByUuid(paramLong3);
/*  373 */     BasicItem localBasicItem1 = localRoleItemBag1.removeByGrid(i);
/*  374 */     BasicItem localBasicItem2 = localRoleItemBag2.removeByGrid(j);
/*  375 */     if ((localBasicItem1 == null) || (localBasicItem2 == null)) {
/*  376 */       return false;
/*      */     }
/*  378 */     ItemOperateResult localItemOperateResult1 = localRoleItemBag1.addItem(localBasicItem2);
/*  379 */     ItemOperateResult localItemOperateResult2 = localRoleItemBag2.addItem(localBasicItem1);
/*  380 */     return (localItemOperateResult1.success()) && (localItemOperateResult2.success());
/*      */   }
/*      */   
/*      */   public static ItemOperateResult addItem(long paramLong, Map<Integer, Integer> paramMap, boolean paramBoolean, TLogArg paramTLogArg) {
/*  384 */     if ((paramMap == null) || (paramMap.size() == 0)) {
/*  385 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*      */     }
/*  387 */     Map localMap = classifyItemIdMapByBagId(paramMap);
/*  388 */     ItemOperateResult localItemOperateResult1 = null;
/*  389 */     for (Map.Entry localEntry : localMap.entrySet()) {
/*  390 */       ItemOperateResult localItemOperateResult2 = addItemWithNoMailLog(paramLong, ((Integer)localEntry.getKey()).intValue(), (Map)localEntry.getValue(), paramBoolean, true, false);
/*  391 */       if (localItemOperateResult2.isBagFull()) {
/*  392 */         sendMailWhenBagFull(paramLong, (Map)localEntry.getValue(), localItemOperateResult2.getChangeItemInfoList(), paramTLogArg);
/*      */       }
/*  394 */       sendSSynBagAddItem(paramLong, localItemOperateResult2.getChangeItemInfoList());
/*  395 */       if ((localItemOperateResult2.isBagFull()) || (localItemOperateResult2.success())) {
/*  396 */         logItemAndTriggerEvent(paramLong, localItemOperateResult2, 1, paramTLogArg);
/*      */       }
/*  398 */       localItemOperateResult1 = updateItemOperateResult(localItemOperateResult1, localItemOperateResult2);
/*      */     }
/*  400 */     localItemOperateResult1 = localItemOperateResult1 == null ? new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER) : localItemOperateResult1;
/*  401 */     return localItemOperateResult1;
/*      */   }
/*      */   
/*      */   public static ItemOperateResult addItem(long paramLong, int paramInt1, int paramInt2, TLogArg paramTLogArg) {
/*  405 */     return addItem(paramLong, paramInt1, paramInt2, false, paramTLogArg);
/*      */   }
/*      */   
/*      */   public static ItemOperateResult addItem(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, TLogArg paramTLogArg) {
/*  409 */     ItemOperateResult localItemOperateResult = addItemWithNoMailLog(paramLong, paramInt1, paramInt2, paramBoolean);
/*  410 */     if (localItemOperateResult.isBagFull()) {
/*  411 */       sendMailWhenBagFull(paramLong, paramInt1, paramInt2, localItemOperateResult.getChangeItemInfoList(), paramTLogArg);
/*      */     }
/*  413 */     sendSSynBagAddItem(paramLong, localItemOperateResult.getChangeItemInfoList());
/*  414 */     if (((localItemOperateResult.isBagFull()) || (localItemOperateResult.success())) && (!localItemOperateResult.getItemChangeMap().isEmpty())) {
/*  415 */       logItemAndTriggerEvent(paramLong, localItemOperateResult, 1, paramTLogArg);
/*      */     }
/*  417 */     return localItemOperateResult;
/*      */   }
/*      */   
/*      */   public static ItemOperateResult addItemForIdip(long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, TLogArg paramTLogArg) {
/*  421 */     if ((paramInt1 == 340600001) && (SItemEquipCfg.get(paramInt2) == null)) {
/*  422 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_ITEMCFG);
/*      */     }
/*  424 */     ItemOperateResult localItemOperateResult = addItemWithNoMailLogIDip(paramLong, paramInt1, paramInt2, paramInt3, paramBoolean);
/*  425 */     if (localItemOperateResult.isBagFull()) {
/*  426 */       sendMailWhenBagFull(paramLong, paramInt2, paramInt3, localItemOperateResult.getChangeItemInfoList(), paramTLogArg);
/*      */     }
/*  428 */     sendSSynBagAddItem(paramLong, localItemOperateResult.getChangeItemInfoList());
/*  429 */     if (((localItemOperateResult.isBagFull()) || (localItemOperateResult.success())) && (!localItemOperateResult.getItemChangeMap().isEmpty())) {
/*  430 */       logItemAndTriggerEvent(paramLong, localItemOperateResult, 1, paramTLogArg);
/*      */     }
/*  432 */     return localItemOperateResult;
/*      */   }
/*      */   
/*      */   private static ItemOperateResult addItemWithNoMailLogIDip(long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
/*  436 */     if (!isItemExist(paramInt2)) {
/*  437 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_ITEMCFG);
/*      */     }
/*  439 */     int i = computeCanAddItemNum(paramLong, paramInt2, paramInt3);
/*  440 */     if (i != paramInt3) {
/*  441 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.CARRY_MAX_ERROR);
/*      */     }
/*  443 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, paramInt1);
/*  444 */     if (localRoleItemBag == null) {
/*  445 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_ERROR);
/*      */     }
/*  447 */     List localList = ItemManager.createXItem(paramInt2, i, null, paramBoolean);
/*  448 */     ItemOperateResult localItemOperateResult = localRoleItemBag.addItem(localList, true, false);
/*  449 */     return localItemOperateResult;
/*      */   }
/*      */   
/*      */   public static ItemOperateResult addItemNoClientEffect(long paramLong, int paramInt1, int paramInt2, TLogArg paramTLogArg) {
/*  453 */     ItemOperateResult localItemOperateResult = addItemWithNoMailLog(paramLong, paramInt1, paramInt2, false);
/*  454 */     if (localItemOperateResult.isBagFull()) {
/*  455 */       sendMailWhenBagFull(paramLong, paramInt1, paramInt2, localItemOperateResult.getChangeItemInfoList(), paramTLogArg);
/*      */     }
/*  457 */     if (((localItemOperateResult.isBagFull()) || (localItemOperateResult.success())) && (!localItemOperateResult.getItemChangeMap().isEmpty())) {
/*  458 */       logItemAndTriggerEvent(paramLong, localItemOperateResult, 1, paramTLogArg);
/*      */     }
/*  460 */     return localItemOperateResult;
/*      */   }
/*      */   
/*      */   private static void sendSSynBagAddItem(long paramLong, List<ItemOperateResult.ChangeItemInfo> paramList) {
/*  464 */     if ((paramList == null) || (paramList.size() == 0)) {
/*  465 */       return;
/*      */     }
/*  467 */     HashMap localHashMap = new HashMap();
/*  468 */     for (Iterator localIterator = paramList.iterator(); localIterator.hasNext();) { localObject = (ItemOperateResult.ChangeItemInfo)localIterator.next();
/*  469 */       int i = ((ItemOperateResult.ChangeItemInfo)localObject).basicItem.getCfgId();
/*  470 */       if (localHashMap.get(Integer.valueOf(i)) == null) {
/*  471 */         localHashMap.put(Integer.valueOf(i), new SSynBagAddItem(new ArrayList(), i, 0));
/*      */       }
/*  473 */       SSynBagAddItem localSSynBagAddItem1 = (SSynBagAddItem)localHashMap.get(Integer.valueOf(i));
/*  474 */       localSSynBagAddItem1.grids.add(Integer.valueOf(((ItemOperateResult.ChangeItemInfo)localObject).grid));
/*  475 */       SSynBagAddItem localSSynBagAddItem2 = localSSynBagAddItem1;
/*  476 */       localSSynBagAddItem2.count += ((ItemOperateResult.ChangeItemInfo)localObject).basicItem.getNumber(); }
/*      */     Object localObject;
/*  478 */     for (localIterator = localHashMap.values().iterator(); localIterator.hasNext();) { localObject = (SSynBagAddItem)localIterator.next();
/*  479 */       if (((SSynBagAddItem)localObject).count > 0) {
/*  480 */         OnlineManager.getInstance().send(paramLong, (Protocol)localObject);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private static ItemOperateResult addItemWithNoMailLog(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean) {
/*  486 */     if (!isItemExist(paramInt1)) {
/*  487 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_ITEMCFG);
/*      */     }
/*  489 */     int i = computeCanAddItemNum(paramLong, paramInt1, paramInt2);
/*  490 */     if (i == 0) {
/*  491 */       sendItemWithCarryMaxRes(paramLong, paramInt1, i);
/*  492 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.SUCCESS);
/*      */     }
/*  494 */     RoleItemBag localRoleItemBag = ItemManager.getBagByItemId(paramLong, 340600000, paramInt1, true);
/*  495 */     List localList = ItemManager.createXItem(paramInt1, i, null, paramBoolean);
/*  496 */     ItemOperateResult localItemOperateResult = localRoleItemBag.addItem(localList, true, false);
/*  497 */     int j = localItemOperateResult.getItemChangeNum(paramInt1);
/*  498 */     if ((j != paramInt2) && (ItemManager.getItemCarryMax(paramInt1) > 0)) {
/*  499 */       sendItemWithCarryMaxRes(paramLong, paramInt1, j);
/*      */     }
/*  501 */     return localItemOperateResult;
/*      */   }
/*      */   
/*      */   public static ItemOperateResult addItemCheckCarrymax(long paramLong, Map<Integer, Integer> paramMap, boolean paramBoolean, TLogArg paramTLogArg) {
/*  505 */     if ((paramMap == null) || (paramMap.isEmpty())) {
/*  506 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*      */     }
/*  508 */     for (Object localObject1 = paramMap.keySet().iterator(); ((Iterator)localObject1).hasNext();) { int i = ((Integer)((Iterator)localObject1).next()).intValue();
/*  509 */       if (((Integer)paramMap.get(Integer.valueOf(i))).intValue() <= 0) {
/*  510 */         return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*      */       }
/*  512 */       if (!isItemExist(i)) {
/*  513 */         return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_ITEMCFG);
/*      */       }
/*  515 */       int j = computeCanAddItemNum(paramLong, i, ((Integer)paramMap.get(Integer.valueOf(i))).intValue());
/*  516 */       if (j != ((Integer)paramMap.get(Integer.valueOf(i))).intValue()) {
/*  517 */         return new ItemOperateResult(ItemOperateResult.ItemResultEnum.CARRY_MAX_ERROR, i);
/*      */       }
/*      */     }
/*  520 */     localObject1 = classifyItemIdMapByBagId(paramMap);
/*  521 */     ItemOperateResult localItemOperateResult = null;
/*  522 */     for (Map.Entry localEntry : ((Map)localObject1).entrySet()) {
/*  523 */       RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, ((Integer)localEntry.getKey()).intValue());
/*  524 */       ArrayList localArrayList = new ArrayList();
/*  525 */       for (Object localObject2 = ((Map)localEntry.getValue()).keySet().iterator(); ((Iterator)localObject2).hasNext();) { int k = ((Integer)((Iterator)localObject2).next()).intValue();
/*  526 */         localArrayList.addAll(ItemManager.createXItem(k, ((Integer)paramMap.get(Integer.valueOf(k))).intValue(), null, paramBoolean));
/*      */       }
/*  528 */       localObject2 = localRoleItemBag.addItem(localArrayList, true, true);
/*  529 */       if (((ItemOperateResult)localObject2).success()) {
/*  530 */         sendSSynBagAddItem(paramLong, ((ItemOperateResult)localObject2).getChangeItemInfoList());
/*  531 */         logItemAndTriggerEvent(paramLong, (ItemOperateResult)localObject2, 1, paramTLogArg);
/*      */       }
/*  533 */       localItemOperateResult = updateItemOperateResult(localItemOperateResult, (ItemOperateResult)localObject2);
/*      */     }
/*  535 */     localItemOperateResult = localItemOperateResult == null ? new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER) : localItemOperateResult;
/*  536 */     return localItemOperateResult;
/*      */   }
/*      */   
/*      */   public static Integer getCanAddItemNum(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean) {
/*  540 */     if ((!isItemExist(paramInt1)) || (paramInt2 <= 0)) {
/*  541 */       return Integer.valueOf(-1);
/*      */     }
/*  543 */     int i = computeCanAddItemNum(paramLong, paramInt1, paramInt2);
/*  544 */     if (i == 0) {
/*  545 */       return Integer.valueOf(0);
/*      */     }
/*  547 */     RoleItemBag localRoleItemBag = ItemManager.getBagByItemId(paramLong, 340600000, paramInt1, true);
/*  548 */     int j = getPileMaxCount(paramInt1);
/*  549 */     int k = (i - 1) / j + 1;
/*  550 */     int m = localRoleItemBag.getAvailableGridNum();
/*  551 */     if (m >= k) {
/*  552 */       return Integer.valueOf(paramInt2);
/*      */     }
/*  554 */     int n = m * j;
/*  555 */     if (!paramBoolean) {
/*  556 */       return Integer.valueOf(n);
/*      */     }
/*  558 */     Map localMap = localRoleItemBag.getItemBycfgId(paramInt1);
/*  559 */     for (BasicItem localBasicItem : localMap.values()) {
/*  560 */       n += j - localBasicItem.getNumber();
/*  561 */       if (n >= i) {
/*  562 */         return Integer.valueOf(i);
/*      */       }
/*      */     }
/*  565 */     return Integer.valueOf(n);
/*      */   }
/*      */   
/*      */   public static ItemOperateResult addItemActive(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, TLogArg paramTLogArg) {
/*  569 */     HashMap localHashMap = new HashMap();
/*  570 */     localHashMap.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
/*  571 */     return addItemActive(paramLong, localHashMap, paramBoolean1, paramBoolean2, paramTLogArg);
/*      */   }
/*      */   
/*      */   public static ItemOperateResult addItemActive(long paramLong, Map<Integer, Integer> paramMap, boolean paramBoolean1, boolean paramBoolean2, TLogArg paramTLogArg) {
/*  575 */     ItemOperateResult localItemOperateResult = addItemCheckCarrymax(paramLong, paramMap, paramBoolean1, paramTLogArg);
/*  576 */     if (paramBoolean2) {
/*  577 */       if (localItemOperateResult.isBagFull()) {
/*  578 */         sendSpecificBagFull(paramLong, localItemOperateResult.getFullBagId());
/*      */       }
/*  580 */       if (localItemOperateResult.isToCarryMax()) {
/*  581 */         ItemManager.sendWrongInfo(paramLong, 1105, new String[] { String.valueOf(localItemOperateResult.getTocarrymaxitemid()) });
/*      */       }
/*      */     }
/*  584 */     return localItemOperateResult;
/*      */   }
/*      */   
/*      */   public static ItemOperateResult addItemActive(long paramLong, List<Item> paramList, boolean paramBoolean1, boolean paramBoolean2, TLogArg paramTLogArg) {
/*  588 */     if ((paramList == null) || (paramList.isEmpty())) {
/*  589 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*      */     }
/*  591 */     HashMap localHashMap = new HashMap();
/*  592 */     for (Object localObject = paramList.iterator(); ((Iterator)localObject).hasNext();) { Item localItem = (Item)((Iterator)localObject).next();
/*  593 */       if (localItem.getNumber() <= 0) {
/*  594 */         return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*      */       }
/*  596 */       if (!isItemExist(localItem.getCfgid())) {
/*  597 */         return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_ITEMCFG);
/*      */       }
/*  599 */       Integer localInteger = (Integer)localHashMap.get(Integer.valueOf(localItem.getCfgid()));
/*  600 */       if (localInteger == null) {
/*  601 */         localInteger = Integer.valueOf(0);
/*      */       }
/*  603 */       localHashMap.put(Integer.valueOf(localItem.getCfgid()), Integer.valueOf(localInteger.intValue() + localItem.getNumber()));
/*      */     }
/*  605 */     for (localObject = localHashMap.keySet().iterator(); ((Iterator)localObject).hasNext();) { int i = ((Integer)((Iterator)localObject).next()).intValue();
/*  606 */       int j = computeCanAddItemNum(paramLong, i, ((Integer)localHashMap.get(Integer.valueOf(i))).intValue());
/*  607 */       if (j != ((Integer)localHashMap.get(Integer.valueOf(i))).intValue()) {
/*  608 */         if (paramBoolean2) {
/*  609 */           ItemManager.sendWrongInfo(paramLong, 1105, new String[] { String.valueOf(i) });
/*      */         }
/*  611 */         return new ItemOperateResult(ItemOperateResult.ItemResultEnum.CARRY_MAX_ERROR, i);
/*      */       }
/*      */     }
/*  614 */     localObject = classifyItemIdListByBagId(paramList);
/*  615 */     ItemOperateResult localItemOperateResult1 = null;
/*  616 */     for (Map.Entry localEntry : ((Map)localObject).entrySet()) {
/*  617 */       RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, ((Integer)localEntry.getKey()).intValue());
/*  618 */       ItemOperateResult localItemOperateResult2 = localRoleItemBag.addItem((List)localEntry.getValue(), paramBoolean1, true);
/*  619 */       if (localItemOperateResult2.success()) {
/*  620 */         sendSSynBagAddItem(paramLong, localItemOperateResult2.getChangeItemInfoList());
/*  621 */         logItemAndTriggerEvent(paramLong, localItemOperateResult2, 1, paramTLogArg);
/*      */       }
/*  623 */       if ((paramBoolean2) && (localItemOperateResult2.isBagFull())) {
/*  624 */         sendSpecificBagFull(paramLong, localItemOperateResult2.getFullBagId());
/*      */       }
/*  626 */       localItemOperateResult1 = updateItemOperateResult(localItemOperateResult1, localItemOperateResult2);
/*      */     }
/*  628 */     localItemOperateResult1 = localItemOperateResult1 == null ? new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER) : localItemOperateResult1;
/*  629 */     return localItemOperateResult1;
/*      */   }
/*      */   
/*      */   private static ItemOperateResult addItemWithNoMailLog(long paramLong, int paramInt, Map<Integer, Integer> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*  633 */     if ((paramMap == null) || (paramMap.isEmpty())) {
/*  634 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*      */     }
/*  636 */     for (Object localObject1 = paramMap.keySet().iterator(); ((Iterator)localObject1).hasNext();) { int i = ((Integer)((Iterator)localObject1).next()).intValue();
/*  637 */       if (!isItemExist(i)) {
/*  638 */         return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_ITEMCFG);
/*      */       }
/*  640 */       if (((Integer)paramMap.get(Integer.valueOf(i))).intValue() <= 0) {
/*  641 */         return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*      */       }
/*      */     }
/*  644 */     localObject1 = new HashMap();
/*  645 */     for (Object localObject2 = paramMap.keySet().iterator(); ((Iterator)localObject2).hasNext();) { int j = ((Integer)((Iterator)localObject2).next()).intValue();
/*  646 */       int k = computeCanAddItemNum(paramLong, j, ((Integer)paramMap.get(Integer.valueOf(j))).intValue());
/*  647 */       if (k == 0) {
/*  648 */         sendItemWithCarryMaxRes(paramLong, j, k);
/*      */       }
/*      */       else {
/*  651 */         ((Map)localObject1).put(Integer.valueOf(j), Integer.valueOf(k));
/*      */       }
/*      */     }
/*  654 */     if (((Map)localObject1).isEmpty()) {
/*  655 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.SUCCESS);
/*      */     }
/*  657 */     localObject2 = new ArrayList();
/*  658 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, paramInt);
/*  659 */     for (Object localObject3 = ((Map)localObject1).keySet().iterator(); ((Iterator)localObject3).hasNext();) { int m = ((Integer)((Iterator)localObject3).next()).intValue();
/*  660 */       ((List)localObject2).addAll(ItemManager.createXItem(m, ((Integer)((Map)localObject1).get(Integer.valueOf(m))).intValue(), null, paramBoolean1));
/*      */     }
/*  662 */     localObject3 = localRoleItemBag.addItem((List)localObject2, paramBoolean2, paramBoolean3);
/*  663 */     for (Iterator localIterator = ((Map)localObject1).keySet().iterator(); localIterator.hasNext();) { int n = ((Integer)localIterator.next()).intValue();
/*  664 */       int i1 = ((ItemOperateResult)localObject3).getItemChangeNum(n);
/*  665 */       int i2 = ((Integer)paramMap.get(Integer.valueOf(n))).intValue();
/*  666 */       if ((i1 != i2) && (ItemManager.getItemCarryMax(n) > 0)) {
/*  667 */         sendItemWithCarryMaxRes(paramLong, n, i1);
/*      */       }
/*      */     }
/*  670 */     return (ItemOperateResult)localObject3;
/*      */   }
/*      */   
/*      */   public static boolean addItemWithOutMail(long paramLong, Map<Integer, Integer> paramMap, boolean paramBoolean, TLogArg paramTLogArg) {
/*  674 */     ItemOperateResult localItemOperateResult = addItemWithNoMail(paramLong, paramMap, paramBoolean, paramTLogArg);
/*  675 */     return localItemOperateResult.success();
/*      */   }
/*      */   
/*      */   public static ItemOperateResult addItemWithNoMail(long paramLong, Map<Integer, Integer> paramMap, boolean paramBoolean, TLogArg paramTLogArg) {
/*  679 */     Map localMap = classifyItemIdMapByBagId(paramMap);
/*  680 */     ItemOperateResult localItemOperateResult1 = null;
/*  681 */     for (Map.Entry localEntry : localMap.entrySet()) {
/*  682 */       ItemOperateResult localItemOperateResult2 = addItemWithNoMailLog(paramLong, ((Integer)localEntry.getKey()).intValue(), (Map)localEntry.getValue(), paramBoolean, false, true);
/*  683 */       if (localItemOperateResult2.success()) {
/*  684 */         sendSSynBagAddItem(paramLong, localItemOperateResult2.getChangeItemInfoList());
/*  685 */         logItemAndTriggerEvent(paramLong, localItemOperateResult2, 1, paramTLogArg);
/*      */       }
/*  687 */       localItemOperateResult1 = updateItemOperateResult(localItemOperateResult1, localItemOperateResult2);
/*      */     }
/*  689 */     localItemOperateResult1 = localItemOperateResult1 == null ? new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER) : localItemOperateResult1;
/*  690 */     return localItemOperateResult1;
/*      */   }
/*      */   
/*      */   private static void sendItemWithCarryMaxRes(long paramLong, int paramInt1, int paramInt2) {
/*  694 */     SResItemWithCarryMax localSResItemWithCarryMax = new SResItemWithCarryMax();
/*  695 */     localSResItemWithCarryMax.carrymax = ItemManager.getItemCarryMax(paramInt1);
/*  696 */     localSResItemWithCarryMax.addnum = paramInt2;
/*  697 */     localSResItemWithCarryMax.itemid = paramInt1;
/*  698 */     OnlineManager.getInstance().send(paramLong, localSResItemWithCarryMax);
/*      */   }
/*      */   
/*      */   public static int computeCanAddItemNum(long paramLong, int paramInt1, int paramInt2) {
/*  702 */     int i = paramInt2;
/*  703 */     int j = ItemManager.getItemCarryMax(paramInt1);
/*  704 */     if (j > 0) {
/*  705 */       int k = getTotalItemNumberById(paramLong, paramInt1);
/*  706 */       i = Math.min(j - k, paramInt2);
/*      */     }
/*  708 */     return i;
/*      */   }
/*      */   
/*      */   private static void sendMailWhenBagFull(long paramLong, int paramInt1, int paramInt2, List<ItemOperateResult.ChangeItemInfo> paramList, TLogArg paramTLogArg) {
/*  712 */     if (ItemManager.getItemCarryMax(paramInt1) != 0) {
/*  713 */       return;
/*      */     }
/*  715 */     int i = paramInt2;
/*  716 */     Object localObject; if ((paramList != null) && (paramList.size() > 0)) {
/*  717 */       for (localObject = paramList.iterator(); ((Iterator)localObject).hasNext();) { ItemOperateResult.ChangeItemInfo localChangeItemInfo = (ItemOperateResult.ChangeItemInfo)((Iterator)localObject).next();
/*  718 */         i -= localChangeItemInfo.basicItem.getNumber();
/*      */       }
/*      */     }
/*  721 */     if (i > 0) {
/*  722 */       localObject = MailInterface.createMailAttachment();
/*  723 */       ((MailAttachment)localObject).addItem(paramInt1, i);
/*  724 */       MailInterface.synBuildAndSendMail(paramLong, ItemCfgConsts.getInstance().BAG_FULL_MAIL_ID, new ArrayList(), new ArrayList(), (MailAttachment)localObject, paramTLogArg);
/*      */     }
/*      */   }
/*      */   
/*      */   private static void sendMailWhenBagFull(long paramLong, Map<Integer, Integer> paramMap, List<ItemOperateResult.ChangeItemInfo> paramList, TLogArg paramTLogArg) {
/*  729 */     if ((paramMap == null) || (paramMap.size() == 0)) {
/*  730 */       return;
/*      */     }
/*  732 */     MailAttachment localMailAttachment = MailInterface.createMailAttachment();
/*  733 */     for (Iterator localIterator1 = paramMap.keySet().iterator(); localIterator1.hasNext();) { int i = ((Integer)localIterator1.next()).intValue();
/*  734 */       int j = ((Integer)paramMap.get(Integer.valueOf(i))).intValue();
/*  735 */       for (ItemOperateResult.ChangeItemInfo localChangeItemInfo : paramList) {
/*  736 */         if (localChangeItemInfo.basicItem.getCfgId() == i) {
/*  737 */           j -= localChangeItemInfo.basicItem.getNumber();
/*      */         }
/*      */       }
/*  740 */       if (j > 0) {
/*  741 */         localMailAttachment.addItem(i, j);
/*      */       }
/*      */     }
/*  744 */     MailInterface.synBuildAndSendMail(paramLong, ItemCfgConsts.getInstance().BAG_FULL_MAIL_ID, new ArrayList(), new ArrayList(), localMailAttachment, paramTLogArg);
/*      */   }
/*      */   
/*      */   public static boolean removeItemByUuid(long paramLong1, long paramLong2, int paramInt, TLogArg paramTLogArg) {
/*  748 */     return removeItemByUuid(paramLong1, 340600000, paramLong2, paramInt, paramTLogArg);
/*      */   }
/*      */   
/*      */   public static boolean removeItemByUuid(long paramLong1, int paramInt1, long paramLong2, int paramInt2, TLogArg paramTLogArg) {
/*  752 */     if (paramInt2 <= 0) {
/*  753 */       return false;
/*      */     }
/*  755 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong1, paramInt1);
/*  756 */     if (localRoleItemBag == null) {
/*  757 */       return false;
/*      */     }
/*  759 */     ItemOperateResult localItemOperateResult = localRoleItemBag.removeItemByUuid(paramLong2, paramInt2);
/*  760 */     if (!localItemOperateResult.success()) {
/*  761 */       return false;
/*      */     }
/*  763 */     logItemAndTriggerEvent(paramLong1, localItemOperateResult, -1, paramTLogArg);
/*  764 */     return localItemOperateResult.success();
/*      */   }
/*      */   
/*      */   public static ItemOperateResult removeItemByUuid(long paramLong, Map<Long, Integer> paramMap, TLogArg paramTLogArg) {
/*  768 */     if ((paramMap == null) || (paramMap.size() == 0)) {
/*  769 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*      */     }
/*  771 */     for (Object localObject = paramMap.values().iterator(); ((Iterator)localObject).hasNext();) { int i = ((Integer)((Iterator)localObject).next()).intValue();
/*  772 */       if (i <= 0) {
/*  773 */         return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*      */       }
/*      */     }
/*  776 */     localObject = classifyUUIDMapByBagId(paramMap, paramLong);
/*  777 */     ItemOperateResult localItemOperateResult1 = null;
/*  778 */     for (Map.Entry localEntry : ((Map)localObject).entrySet()) {
/*  779 */       RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, ((Integer)localEntry.getKey()).intValue());
/*  780 */       ItemOperateResult localItemOperateResult2 = localRoleItemBag.removeItemByUuid((Map)localEntry.getValue());
/*  781 */       if (!localItemOperateResult2.success()) {
/*  782 */         localItemOperateResult1 = updateItemOperateResult(localItemOperateResult1, localItemOperateResult2);
/*      */       }
/*      */       else {
/*  785 */         logItemAndTriggerEvent(paramLong, localItemOperateResult2, -1, paramTLogArg);
/*  786 */         localItemOperateResult1 = updateItemOperateResult(localItemOperateResult1, localItemOperateResult2);
/*      */       }
/*      */     }
/*  789 */     localItemOperateResult1 = localItemOperateResult1 == null ? new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER) : localItemOperateResult1;
/*  790 */     return localItemOperateResult1;
/*      */   }
/*      */   
/*      */   public static boolean removeItemById(long paramLong, int paramInt1, int paramInt2, TLogArg paramTLogArg) {
/*  794 */     return removeItemById(paramLong, 340600000, paramInt1, paramInt2, paramTLogArg);
/*      */   }
/*      */   
/*      */   public static boolean removeItemById(long paramLong, int paramInt1, int paramInt2, int paramInt3, TLogArg paramTLogArg) {
/*  798 */     RoleItemBag localRoleItemBag = ItemManager.getBagByItemId(paramLong, paramInt1, paramInt2, true);
/*  799 */     if (localRoleItemBag == null) {
/*  800 */       return false;
/*      */     }
/*  802 */     ItemOperateResult localItemOperateResult = localRoleItemBag.removeItemsByItemId(paramInt2, paramInt3);
/*  803 */     if (localItemOperateResult.success()) {
/*  804 */       logItemAndTriggerEvent(paramLong, localItemOperateResult, -1, paramTLogArg);
/*      */     }
/*  806 */     return localItemOperateResult.success();
/*      */   }
/*      */   
/*      */   public static ItemOperateResult removeItemById(long paramLong, Map<Integer, Integer> paramMap, TLogArg paramTLogArg) {
/*  810 */     if ((paramMap == null) || (paramMap.isEmpty())) {
/*  811 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*      */     }
/*  813 */     for (Object localObject = paramMap.keySet().iterator(); ((Iterator)localObject).hasNext();) { int i = ((Integer)((Iterator)localObject).next()).intValue();
/*  814 */       if (((Integer)paramMap.get(Integer.valueOf(i))).intValue() <= 0) {
/*  815 */         return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*      */       }
/*  817 */       if (!isItemExist(i)) {
/*  818 */         return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_ITEMCFG);
/*      */       }
/*      */     }
/*  821 */     localObject = classifyItemIdMapByBagId(paramMap);
/*  822 */     ItemOperateResult localItemOperateResult1 = null;
/*  823 */     for (Map.Entry localEntry : ((Map)localObject).entrySet()) {
/*  824 */       RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, ((Integer)localEntry.getKey()).intValue());
/*  825 */       if (localRoleItemBag == null) {
/*  826 */         localItemOperateResult1 = updateItemOperateResult(localItemOperateResult1, new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_ERROR));
/*      */       }
/*      */       else {
/*  829 */         ItemOperateResult localItemOperateResult2 = localRoleItemBag.removeItemsByItemId((Map)localEntry.getValue());
/*  830 */         if (localItemOperateResult2.success()) {
/*  831 */           logItemAndTriggerEvent(paramLong, localItemOperateResult2, -1, paramTLogArg);
/*      */         }
/*  833 */         localItemOperateResult1 = updateItemOperateResult(localItemOperateResult1, localItemOperateResult2);
/*      */       }
/*      */     }
/*  836 */     localItemOperateResult1 = localItemOperateResult1 == null ? new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER) : localItemOperateResult1;
/*  837 */     return localItemOperateResult1;
/*      */   }
/*      */   
/*      */   public static ItemOperateResult removeItemByIdForIdip(long paramLong, int paramInt1, int paramInt2, int paramInt3, TLogArg paramTLogArg) {
/*  841 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, paramInt1);
/*  842 */     if (localRoleItemBag == null) {
/*  843 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_ERROR);
/*      */     }
/*  845 */     ItemOperateResult localItemOperateResult = localRoleItemBag.removeItemsByItemId(paramInt2, paramInt3);
/*  846 */     if (localItemOperateResult.success()) {
/*  847 */       logItemAndTriggerEvent(paramLong, localItemOperateResult, -1, paramTLogArg);
/*      */     }
/*  849 */     return localItemOperateResult;
/*      */   }
/*      */   
/*      */   public static boolean removeItemByGrid(long paramLong, int paramInt1, int paramInt2, TLogArg paramTLogArg) {
/*  853 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, paramInt1);
/*  854 */     if (localRoleItemBag == null) {
/*  855 */       return false;
/*      */     }
/*  857 */     BasicItem localBasicItem = localRoleItemBag.removeByGrid(paramInt2);
/*  858 */     if (localBasicItem != null) {
/*  859 */       ArrayList localArrayList = new ArrayList();
/*  860 */       ItemOperateResult.ChangeItemInfo localChangeItemInfo = new ItemOperateResult.ChangeItemInfo(paramInt2, localBasicItem.getItem(), true);
/*  861 */       localArrayList.add(localChangeItemInfo);
/*  862 */       ItemOperateResult localItemOperateResult = new ItemOperateResult(ItemOperateResult.ItemResultEnum.SUCCESS, localArrayList);
/*  863 */       logItemAndTriggerEvent(paramLong, localItemOperateResult, -1, paramTLogArg);
/*  864 */       return true;
/*      */     }
/*  866 */     return false;
/*      */   }
/*      */   
/*      */   public static boolean removeItemByGrid(long paramLong, int paramInt1, int paramInt2, int paramInt3, TLogArg paramTLogArg) {
/*  870 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, paramInt1);
/*  871 */     if (localRoleItemBag == null) {
/*  872 */       return false;
/*      */     }
/*  874 */     ItemOperateResult localItemOperateResult = localRoleItemBag.removeItemByGrid(paramInt2, paramInt3);
/*  875 */     if (localItemOperateResult.success()) {
/*  876 */       logItemAndTriggerEvent(paramLong, localItemOperateResult, -1, paramTLogArg);
/*      */     }
/*  878 */     return localItemOperateResult.success();
/*      */   }
/*      */   
/*      */   public static boolean removeItemsByTypeId(long paramLong, int paramInt1, int paramInt2, TLogArg paramTLogArg) {
/*  882 */     int i = ItemConfigManager.getItemTypeById(paramInt1);
/*  883 */     return removeItemsByType(paramLong, i, paramInt2, paramTLogArg);
/*      */   }
/*      */   
/*      */   public static boolean removeItemsByTypeId(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, TLogArg paramTLogArg) {
/*  887 */     int i = ItemConfigManager.getItemTypeById(paramInt1);
/*  888 */     ItemOperateResult localItemOperateResult = removeItemsByItemType(paramLong, i, paramInt2, paramBoolean, paramTLogArg);
/*  889 */     return localItemOperateResult.success();
/*      */   }
/*      */   
/*      */   public static boolean removeItemsByType(long paramLong, int paramInt1, int paramInt2, TLogArg paramTLogArg) {
/*  893 */     ItemOperateResult localItemOperateResult = removeItemsByItemType(paramLong, paramInt1, paramInt2, paramTLogArg);
/*  894 */     return localItemOperateResult.success();
/*      */   }
/*      */   
/*      */   public static ItemOperateResult removeItemsByItemType(long paramLong, int paramInt1, int paramInt2, TLogArg paramTLogArg) {
/*  898 */     RoleItemBag localRoleItemBag = ItemManager.getRoleItemBag(paramLong);
/*  899 */     ItemOperateResult localItemOperateResult = localRoleItemBag.removeItemByType(paramInt1, paramInt2);
/*  900 */     if (localItemOperateResult.success()) {
/*  901 */       logItemAndTriggerEvent(paramLong, localItemOperateResult, -1, paramTLogArg);
/*      */     }
/*  903 */     return localItemOperateResult;
/*      */   }
/*      */   
/*      */   public static ItemOperateResult removeItemsByItemType(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, TLogArg paramTLogArg) {
/*  907 */     RoleItemBag localRoleItemBag = ItemManager.getRoleItemBag(paramLong);
/*  908 */     ItemOperateResult localItemOperateResult = localRoleItemBag.removeItemByType(paramInt1, paramInt2, paramBoolean);
/*  909 */     if (localItemOperateResult.success()) {
/*  910 */       logItemAndTriggerEvent(paramLong, localItemOperateResult, -1, paramTLogArg);
/*      */     }
/*  912 */     return localItemOperateResult;
/*      */   }
/*      */   
/*      */   public static ItemOperateResult removeItemsWithBindFirst(long paramLong, int paramInt1, int paramInt2, TLogArg paramTLogArg) {
/*  916 */     RoleItemBag localRoleItemBag = ItemManager.getRoleItemBag(paramLong);
/*  917 */     ItemOperateResult localItemOperateResult = localRoleItemBag.removeItemsWithBindFirst(paramInt1, paramInt2);
/*  918 */     if (localItemOperateResult.success()) {
/*  919 */       logItemAndTriggerEvent(paramLong, localItemOperateResult, -1, paramTLogArg);
/*      */     }
/*  921 */     return localItemOperateResult;
/*      */   }
/*      */   
/*      */   public static ItemOperateResult removeItemsWithBindFirst(long paramLong, int paramInt1, int paramInt2, int paramInt3, TLogArg paramTLogArg) {
/*  925 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, paramInt1);
/*  926 */     if (localRoleItemBag == null) {
/*  927 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_ERROR, ItemOperateResult.RemoveModelEnum.BIND_FIRST);
/*      */     }
/*  929 */     ItemOperateResult localItemOperateResult = localRoleItemBag.removeItemsWithBindFirst(paramInt2, paramInt3);
/*  930 */     if (localItemOperateResult.success()) {
/*  931 */       logItemAndTriggerEvent(paramLong, localItemOperateResult, -1, paramTLogArg);
/*      */     }
/*  933 */     return localItemOperateResult;
/*      */   }
/*      */   
/*      */   public static ItemOperateResult removeItemsWithBindFirst(long paramLong, int paramInt1, int paramInt2, int paramInt3) {
/*  937 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, paramInt1);
/*  938 */     if (localRoleItemBag == null) {
/*  939 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_ERROR, ItemOperateResult.RemoveModelEnum.BIND_FIRST);
/*      */     }
/*  941 */     ItemOperateResult localItemOperateResult = localRoleItemBag.removeItemsWithBindFirst(paramInt2, paramInt3);
/*  942 */     return localItemOperateResult;
/*      */   }
/*      */   
/*      */   public static boolean removeItemsWithCutYuanbao(String paramString, long paramLong, CostType paramCostType, Map<Integer, Integer> paramMap, int paramInt, TLogArg paramTLogArg) {
/*  946 */     for (Object localObject1 = paramMap.keySet().iterator(); ((Iterator)localObject1).hasNext();) { int i = ((Integer)((Iterator)localObject1).next()).intValue();
/*  947 */       if (((Integer)paramMap.get(Integer.valueOf(i))).intValue() <= 0) {
/*  948 */         return false;
/*      */       }
/*  950 */       if (!isItemExist(i)) {
/*  951 */         return false;
/*      */       }
/*      */     }
/*  954 */     localObject1 = new HashMap(paramMap);
/*  955 */     RoleItemBag localRoleItemBag = ItemManager.getRoleItemBag(paramLong);
/*  956 */     ArrayList localArrayList = new ArrayList();
/*  957 */     HashMap localHashMap = new HashMap();
/*  958 */     localRoleItemBag.computeToRemoveGridAndDelta((Map)localObject1, localArrayList, localHashMap);
/*  959 */     if (((Map)localObject1).isEmpty()) {
/*  960 */       for (Iterator localIterator = paramMap.keySet().iterator(); localIterator.hasNext();) { int k = ((Integer)localIterator.next()).intValue();
/*  961 */         ItemOperateResult localItemOperateResult = removeItemsWithBindFirst(paramLong, k, ((Integer)paramMap.get(Integer.valueOf(k))).intValue(), paramTLogArg);
/*  962 */         if (!localItemOperateResult.success()) {
/*  963 */           return false;
/*      */         }
/*      */       }
/*  966 */       return true;
/*      */     }
/*  968 */     int j = 0;
/*  969 */     for (Object localObject2 = ((Map)localObject1).keySet().iterator(); ((Iterator)localObject2).hasNext();) { m = ((Integer)((Iterator)localObject2).next()).intValue();
/*  970 */       j += getItemYuanBaoPrice(m) * ((Integer)((Map)localObject1).get(Integer.valueOf(m))).intValue(); }
/*      */     int m;
/*  972 */     if (j > 0) {
/*  973 */       if (j != paramInt) {
/*  974 */         sendWrongInfo(paramLong, 1106, new String[0]);
/*  975 */         return false;
/*      */       }
/*  977 */       localObject2 = QingfuInterface.costYuanbao(paramString, paramLong, j, paramCostType, paramTLogArg);
/*  978 */       if (localObject2 != CostResult.Success) {
/*  979 */         return false;
/*      */       }
/*      */     }
/*  982 */     for (localObject2 = localArrayList.iterator(); ((Iterator)localObject2).hasNext();) { m = ((Integer)((Iterator)localObject2).next()).intValue();
/*  983 */       if (!removeItemByGrid(paramLong, 340600000, m, paramTLogArg)) {
/*  984 */         return false;
/*      */       }
/*      */     }
/*  987 */     for (localObject2 = localHashMap.keySet().iterator(); ((Iterator)localObject2).hasNext();) { m = ((Integer)((Iterator)localObject2).next()).intValue();
/*  988 */       if (!removeItemByGrid(paramLong, 340600000, m, ((Integer)localHashMap.get(Integer.valueOf(m))).intValue(), paramTLogArg)) {
/*  989 */         return false;
/*      */       }
/*      */     }
/*  992 */     return true;
/*      */   }
/*      */   
/*      */   public static ItemOperateResult removeItemsWithUnBindFirst(long paramLong, int paramInt1, int paramInt2, TLogArg paramTLogArg) {
/*  996 */     RoleItemBag localRoleItemBag = ItemManager.getRoleItemBag(paramLong);
/*  997 */     ItemOperateResult localItemOperateResult = localRoleItemBag.removeItemsWithUnbindFirst(paramInt1, paramInt2);
/*  998 */     if (localItemOperateResult.success()) {
/*  999 */       logItemAndTriggerEvent(paramLong, localItemOperateResult, -1, paramTLogArg);
/*      */     }
/* 1001 */     return localItemOperateResult;
/*      */   }
/*      */   
/*      */   public static int getItemYuanBaoPrice(int paramInt) {
/* 1005 */     int i = MallInterface.getItemPrice(paramInt);
/* 1006 */     if (i != -1) {
/* 1007 */       return i;
/*      */     }
/* 1009 */     int j = ShanghuiInterface.getItemPrice(paramInt);
/* 1010 */     if (j > 0) {
/* 1011 */       return (j - 1) / MoneyExchangeCfgConsts.getInstance().YUANBAO_TO_GOLD_NUM + 1;
/*      */     }
/* 1013 */     int k = BaiTanInterface.getItemPrice(paramInt);
/* 1014 */     if (k > 0) {
/* 1015 */       return (k - 1) / MoneyExchangeCfgConsts.getInstance().YUANBAO_TO_SILVER_NUM + 1;
/*      */     }
/* 1017 */     SItemPriceCfg localSItemPriceCfg = getSItemPriceCfg(paramInt);
/* 1018 */     if ((localSItemPriceCfg != null) && (localSItemPriceCfg.baiTanSilverNum > 0)) {
/* 1019 */       return (localSItemPriceCfg.baiTanSilverNum - 1) / MoneyExchangeCfgConsts.getInstance().YUANBAO_TO_SILVER_NUM + 1;
/*      */     }
/* 1021 */     SItemCfg localSItemCfg = SItemCfg.get(paramInt);
/* 1022 */     if ((localSItemCfg != null) && (localSItemCfg.sellSilver > 0)) {
/* 1023 */       return (localSItemCfg.sellSilver - 1) / MoneyExchangeCfgConsts.getInstance().YUANBAO_TO_SILVER_NUM + 1;
/*      */     }
/* 1025 */     return 0;
/*      */   }
/*      */   
/*      */   public static List<Integer> getSamePriceItems(int paramInt) {
/* 1029 */     ArrayList localArrayList = new ArrayList();
/* 1030 */     SItemSiftCfg localSItemSiftCfg = SItemSiftCfg.get(paramInt);
/* 1031 */     if (localSItemSiftCfg == null) {
/* 1032 */       return localArrayList;
/*      */     }
/* 1034 */     for (IdTypeValueBean localIdTypeValueBean : localSItemSiftCfg.idTypeValueBeans) {
/* 1035 */       if (localIdTypeValueBean.idtype == 1) {
/* 1036 */         localArrayList.add(Integer.valueOf(localIdTypeValueBean.idvalue));
/*      */ 
/*      */       }
/* 1039 */       else if (localIdTypeValueBean.idtype == 2)
/*      */       {
/*      */ 
/* 1042 */         localArrayList.addAll(SiftInterface.siftItems(localIdTypeValueBean.idvalue));
/*      */       }
/*      */     }
/* 1045 */     return localArrayList;
/*      */   }
/*      */   
/*      */   public static boolean isItemExist(int paramInt) {
/* 1049 */     return SItemCfg.get(paramInt) != null;
/*      */   }
/*      */   
/*      */   public static SItemCfg getSItemCfg(int paramInt) {
/* 1053 */     return SItemCfg.get(paramInt);
/*      */   }
/*      */   
/*      */   public static Map<Integer, Integer> getAllEquipmentProMap(long paramLong) {
/* 1057 */     return getAllEquipmentProMap(paramLong, true);
/*      */   }
/*      */   
/*      */   public static Map<Integer, Integer> getAllEquipmentProMap(long paramLong, boolean paramBoolean) {
/* 1061 */     RoleEquipBag localRoleEquipBag = (RoleEquipBag)ItemManager.getBag(paramLong, 340600001, paramBoolean);
/* 1062 */     HashMap localHashMap = new HashMap();
/* 1063 */     for (Object localObject1 = localRoleEquipBag.getAllItems(false).values().iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (BasicItem)((Iterator)localObject1).next();
/* 1064 */       if ((localObject2 instanceof EquipmentItem)) {
/* 1065 */         localObject3 = ((EquipmentItem)localObject2).getProTypeValueMap();
/* 1066 */         for (Map.Entry localEntry : ((Map)localObject3).entrySet())
/* 1067 */           if (localHashMap.containsKey(localEntry.getKey())) {
/* 1068 */             int j = ((Integer)localHashMap.get(localEntry.getKey())).intValue() + ((Integer)localEntry.getValue()).intValue();
/* 1069 */             localHashMap.put(localEntry.getKey(), Integer.valueOf(j));
/*      */           }
/*      */           else {
/* 1072 */             localHashMap.put(localEntry.getKey(), localEntry.getValue());
/*      */           }
/*      */       }
/*      */     }
/*      */     Object localObject3;
/* 1077 */     localObject1 = getProMapByWholeBodyQilinLevel(localRoleEquipBag);
/* 1078 */     for (Object localObject2 = ((Map)localObject1).entrySet().iterator(); ((Iterator)localObject2).hasNext();) { localObject3 = (Map.Entry)((Iterator)localObject2).next();
/* 1079 */       if (localHashMap.containsKey(((Map.Entry)localObject3).getKey())) {
/* 1080 */         int i = ((Integer)localHashMap.get(((Map.Entry)localObject3).getKey())).intValue() + ((Integer)((Map.Entry)localObject3).getValue()).intValue();
/* 1081 */         localHashMap.put(((Map.Entry)localObject3).getKey(), Integer.valueOf(i));
/*      */       }
/*      */       else {
/* 1084 */         localHashMap.put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
/*      */       }
/*      */     }
/* 1087 */     mergePro(localHashMap, SuperEquipmentInterface.getProperties(localRoleEquipBag));
/* 1088 */     mergePro(localHashMap, SuperEquipmentJewelInterface.getProperties(localRoleEquipBag));
/* 1089 */     mergePro(localHashMap, WuShiInterface.getProperties(paramLong));
/* 1090 */     mergePro(localHashMap, EquipmentBlessInterface.getProperties(localRoleEquipBag));
/* 1091 */     return localHashMap;
/*      */   }
/*      */   
/*      */   public static Map<Integer, Integer> getAllEquipmentScoreProMap(long paramLong, boolean paramBoolean) {
/* 1095 */     RoleEquipBag localRoleEquipBag = (RoleEquipBag)ItemManager.getBag(paramLong, 340600001, paramBoolean);
/* 1096 */     HashMap localHashMap = new HashMap();
/* 1097 */     for (Object localObject1 = localRoleEquipBag.getAllItems(false).values().iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (BasicItem)((Iterator)localObject1).next();
/* 1098 */       if ((localObject2 instanceof EquipmentItem)) {
/* 1099 */         localObject3 = ((EquipmentItem)localObject2).getProTypeValueMap(false);
/* 1100 */         for (Map.Entry localEntry : ((Map)localObject3).entrySet())
/* 1101 */           if (localHashMap.containsKey(localEntry.getKey())) {
/* 1102 */             int j = ((Integer)localHashMap.get(localEntry.getKey())).intValue() + ((Integer)localEntry.getValue()).intValue();
/* 1103 */             localHashMap.put(localEntry.getKey(), Integer.valueOf(j));
/*      */           }
/*      */           else {
/* 1106 */             localHashMap.put(localEntry.getKey(), localEntry.getValue());
/*      */           }
/*      */       }
/*      */     }
/*      */     Object localObject3;
/* 1111 */     localObject1 = getProMapByWholeBodyQilinLevel(localRoleEquipBag);
/* 1112 */     for (Object localObject2 = ((Map)localObject1).entrySet().iterator(); ((Iterator)localObject2).hasNext();) { localObject3 = (Map.Entry)((Iterator)localObject2).next();
/* 1113 */       if (localHashMap.containsKey(((Map.Entry)localObject3).getKey())) {
/* 1114 */         int i = ((Integer)localHashMap.get(((Map.Entry)localObject3).getKey())).intValue() + ((Integer)((Map.Entry)localObject3).getValue()).intValue();
/* 1115 */         localHashMap.put(((Map.Entry)localObject3).getKey(), Integer.valueOf(i));
/*      */       }
/*      */       else {
/* 1118 */         localHashMap.put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
/*      */       }
/*      */     }
/* 1121 */     mergePro(localHashMap, SuperEquipmentInterface.getProperties(localRoleEquipBag));
/* 1122 */     mergePro(localHashMap, SuperEquipmentJewelInterface.getProperties(localRoleEquipBag));
/* 1123 */     mergePro(localHashMap, WuShiInterface.getProperties(paramLong));
/* 1124 */     mergePro(localHashMap, EquipmentBlessInterface.getProperties(localRoleEquipBag));
/* 1125 */     return localHashMap;
/*      */   }
/*      */   
/*      */   private static void mergePro(Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2) {
/* 1129 */     for (Map.Entry localEntry : paramMap2.entrySet()) {
/*      */       int i;
/* 1131 */       if (paramMap1.containsKey(localEntry.getKey())) {
/* 1132 */         i = ((Integer)paramMap1.get(localEntry.getKey())).intValue();
/*      */       }
/*      */       else {
/* 1135 */         i = 0;
/*      */       }
/* 1137 */       i += ((Integer)localEntry.getValue()).intValue();
/* 1138 */       paramMap1.put(localEntry.getKey(), Integer.valueOf(i));
/*      */     }
/*      */   }
/*      */   
/*      */   private static Map<Integer, Integer> getProMapByWholeBodyQilinLevel(RoleEquipBag paramRoleEquipBag) {
/* 1143 */     int i = getWholeBodyMinQilinLevel(paramRoleEquipBag);
/* 1144 */     if (i == -1) {
/* 1145 */       return new HashMap();
/*      */     }
/* 1147 */     int j = getMinEquipLevel(paramRoleEquipBag);
/* 1148 */     if (j == -1) {
/* 1149 */       return new HashMap();
/*      */     }
/* 1151 */     return ItemConfigManager.getWholeBodyQilinPropertyMap(i, j);
/*      */   }
/*      */   
/*      */   public static List<PassiveSkill> getEquipPassiveSkills(long paramLong, boolean paramBoolean) {
/* 1155 */     ArrayList localArrayList = new ArrayList();
/* 1156 */     RoleEquipBag localRoleEquipBag = (RoleEquipBag)ItemManager.getBag(paramLong, 340600001, paramBoolean);
/* 1157 */     for (BasicItem localBasicItem : localRoleEquipBag.getAllItems(false).values()) {
/* 1158 */       if ((localBasicItem instanceof EquipmentItem)) {
/* 1159 */         PassiveSkill localPassiveSkill = ((EquipmentItem)localBasicItem).getSkill();
/* 1160 */         if (localPassiveSkill != null)
/*      */         {
/*      */ 
/* 1163 */           localArrayList.add(localPassiveSkill); }
/*      */       }
/*      */     }
/* 1166 */     return localArrayList;
/*      */   }
/*      */   
/*      */   public static ItemInfo getItemInfo(long paramLong1, long paramLong2, boolean paramBoolean) {
/* 1170 */     return ItemManager.getItemInfo(paramLong1, paramLong2, paramBoolean);
/*      */   }
/*      */   
/*      */   public static SItemPriceCfg getSItemPriceCfg(int paramInt) {
/* 1174 */     return ItemConfigManager.getSItemPriceCfg(paramInt);
/*      */   }
/*      */   
/*      */   public static boolean addEquipment(long paramLong, int paramInt, TLogArg paramTLogArg) {
/* 1178 */     SItemEquipCfg localSItemEquipCfg = SItemEquipCfg.get(paramInt);
/* 1179 */     if (localSItemEquipCfg == null) {
/* 1180 */       localObject = SAirCraftItem.get(paramInt);
/* 1181 */       if (localObject == null) {
/* 1182 */         return false;
/*      */       }
/*      */     }
/* 1185 */     Object localObject = ItemManager.createXItem(paramInt, 1, null, true);
/* 1186 */     if ((localObject == null) || (((List)localObject).size() == 0)) {
/* 1187 */       return false;
/*      */     }
/* 1189 */     BasicItem localBasicItem = ItemManager.getBasicItem((Item)((List)localObject).get(0));
/* 1190 */     if (localBasicItem == null) {
/* 1191 */       return false;
/*      */     }
/* 1193 */     RoleEquipBag localRoleEquipBag = ItemManager.getRoleEquipBag(paramLong);
/* 1194 */     ItemOperateResult localItemOperateResult = localRoleEquipBag.addItem(localBasicItem);
/* 1195 */     if (localItemOperateResult.success()) {
/* 1196 */       logItemAndTriggerEvent(paramLong, localItemOperateResult, 1, paramTLogArg);
/*      */     }
/* 1198 */     return localItemOperateResult.success();
/*      */   }
/*      */   
/*      */   public static void decEquipUsePoint(Set<Long> paramSet1, Set<Long> paramSet2) { Iterator localIterator1;
/* 1202 */     if ((paramSet1 != null) && (paramSet1.size() > 0))
/* 1203 */       for (localIterator1 = paramSet1.iterator(); localIterator1.hasNext();) { localLong = (Long)localIterator1.next();
/* 1204 */         localRoleEquipBag = ItemManager.getRoleEquipBag(localLong.longValue());
/* 1205 */         if (localRoleEquipBag != null)
/*      */         {
/*      */ 
/* 1208 */           for (localIterator2 = localRoleEquipBag.getAllItems(false).values().iterator(); localIterator2.hasNext();) { localBasicItem = (BasicItem)localIterator2.next();
/* 1209 */             if ((localBasicItem instanceof EquipmentItem))
/*      */             {
/*      */ 
/* 1212 */               localEquipmentItem = (EquipmentItem)localBasicItem;
/* 1213 */               if (!localEquipmentItem.isUsePointNeverDec())
/*      */               {
/*      */ 
/* 1216 */                 Integer localInteger1 = localEquipmentItem.getExtra(ItemStoreEnum.USE_POINT_VALUE);
/* 1217 */                 int j = 0;
/* 1218 */                 if (localInteger1.intValue() - EquipItemCfgConsts.getInstance().DIE_USEPOINT_DEC_VALUE > 0) {
/* 1219 */                   j = localInteger1.intValue() - EquipItemCfgConsts.getInstance().DIE_USEPOINT_DEC_VALUE;
/*      */                 }
/* 1221 */                 localEquipmentItem.setExtra(ItemStoreEnum.USE_POINT_VALUE, j); } } } } }
/*      */     Long localLong;
/*      */     RoleEquipBag localRoleEquipBag;
/*      */     Iterator localIterator2;
/* 1225 */     BasicItem localBasicItem; EquipmentItem localEquipmentItem; if ((paramSet2 != null) && (paramSet2.size() > 0))
/* 1226 */       for (localIterator1 = paramSet2.iterator(); localIterator1.hasNext();) { localLong = (Long)localIterator1.next();
/* 1227 */         localRoleEquipBag = ItemManager.getRoleEquipBag(localLong.longValue());
/* 1228 */         if (localRoleEquipBag != null)
/*      */         {
/*      */ 
/* 1231 */           for (localIterator2 = localRoleEquipBag.getAllItems(false).values().iterator(); localIterator2.hasNext();) { localBasicItem = (BasicItem)localIterator2.next();
/* 1232 */             if ((localBasicItem instanceof EquipmentItem))
/*      */             {
/*      */ 
/* 1235 */               localEquipmentItem = (EquipmentItem)localBasicItem;
/* 1236 */               int i = Xdb.random().nextInt(ItemCfgConsts.getInstance().ITEM_RANDOM_SEED);
/* 1237 */               if ((i < EquipItemCfgConsts.getInstance().USEPOINT_DEC_RATE) && 
/*      */               
/*      */ 
/* 1240 */                 (!localEquipmentItem.isUsePointNeverDec()))
/*      */               {
/*      */ 
/* 1243 */                 Integer localInteger2 = localEquipmentItem.getExtra(ItemStoreEnum.USE_POINT_VALUE);
/* 1244 */                 int k = 0;
/* 1245 */                 if (localInteger2.intValue() - EquipItemCfgConsts.getInstance().USEPOINT_DEC_VALUE > 0) {
/* 1246 */                   k = localInteger2.intValue() - EquipItemCfgConsts.getInstance().USEPOINT_DEC_VALUE;
/*      */                 }
/* 1248 */                 localEquipmentItem.setExtra(ItemStoreEnum.USE_POINT_VALUE, k);
/*      */               }
/*      */             }
/*      */           } }
/*      */       }
/*      */   }
/*      */   
/* 1255 */   public static BasicItem getAndRemoveItemInBag(long paramLong, int paramInt1, int paramInt2, TLogArg paramTLogArg) { RoleItemBag localRoleItemBag = ItemManager.getRoleItemBag(paramLong);
/* 1256 */     BasicItem localBasicItem = localRoleItemBag.getAndRemoveItem(paramInt1, paramInt2);
/* 1257 */     if (localBasicItem != null) {
/* 1258 */       ArrayList localArrayList = new ArrayList();
/* 1259 */       ItemOperateResult.ChangeItemInfo localChangeItemInfo = new ItemOperateResult.ChangeItemInfo(paramInt1, localBasicItem.getCopyItem(), localRoleItemBag.get(paramInt1) == null);
/* 1260 */       localArrayList.add(localChangeItemInfo);
/* 1261 */       ItemOperateResult localItemOperateResult = new ItemOperateResult(ItemOperateResult.ItemResultEnum.SUCCESS, localArrayList);
/* 1262 */       logItemAndTriggerEvent(paramLong, localItemOperateResult, -1, paramTLogArg);
/*      */     }
/* 1264 */     return localBasicItem;
/*      */   }
/*      */   
/*      */   public static BasicItem getAndRemoveItemInBag(long paramLong, int paramInt1, int paramInt2, int paramInt3, TLogArg paramTLogArg) {
/* 1268 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, paramInt1);
/* 1269 */     if (localRoleItemBag == null) {
/* 1270 */       return null;
/*      */     }
/* 1272 */     BasicItem localBasicItem = localRoleItemBag.getAndRemoveItem(paramInt2, paramInt3);
/* 1273 */     if (localBasicItem != null) {
/* 1274 */       ArrayList localArrayList = new ArrayList();
/* 1275 */       ItemOperateResult.ChangeItemInfo localChangeItemInfo = new ItemOperateResult.ChangeItemInfo(paramInt2, localBasicItem.getCopyItem(), localRoleItemBag.get(paramInt2) == null);
/* 1276 */       localArrayList.add(localChangeItemInfo);
/* 1277 */       ItemOperateResult localItemOperateResult = new ItemOperateResult(ItemOperateResult.ItemResultEnum.SUCCESS, localArrayList);
/* 1278 */       logItemAndTriggerEvent(paramLong, localItemOperateResult, -1, paramTLogArg);
/*      */     }
/* 1280 */     return localBasicItem;
/*      */   }
/*      */   
/*      */   public static boolean addItem(long paramLong, Item paramItem, TLogArg paramTLogArg) {
/* 1284 */     ArrayList localArrayList = new ArrayList();
/* 1285 */     localArrayList.add(paramItem);
/* 1286 */     return addItem(paramLong, localArrayList, paramTLogArg).success();
/*      */   }
/*      */   
/*      */   public static ItemOperateResult addItem(long paramLong, List<Item> paramList, TLogArg paramTLogArg) {
/* 1290 */     return addItem(paramLong, paramList, false, paramTLogArg);
/*      */   }
/*      */   
/*      */   public static boolean addShanghuiItem(long paramLong, int paramInt1, int paramInt2, TLogArg paramTLogArg) {
/* 1294 */     HashMap localHashMap = new HashMap();
/* 1295 */     localHashMap.put(Integer.valueOf(ItemStoreEnum.SHANGHUI_PRICE.getStoreType()), Integer.valueOf(paramInt2 * ItemCfgConsts.getInstance().SHANGHUI_PRICE_RATE));
/* 1296 */     localHashMap.put(Integer.valueOf(ItemStoreEnum.ITEM_SOURCE.getStoreType()), Integer.valueOf(0));
/* 1297 */     List localList = ItemManager.createXItem(paramInt1, 1, localHashMap, false);
/* 1298 */     if (localList.size() == 0) {
/* 1299 */       return false;
/*      */     }
/* 1301 */     ItemOperateResult localItemOperateResult = addItem(paramLong, localList, true, paramTLogArg);
/* 1302 */     return localItemOperateResult.success();
/*      */   }
/*      */   
/*      */   public static boolean addMultiShanghuiItem(long paramLong, int paramInt, List<Integer> paramList, TLogArg paramTLogArg) {
/* 1306 */     ArrayList localArrayList = new ArrayList();
/* 1307 */     for (Object localObject = paramList.iterator(); ((Iterator)localObject).hasNext();) { Integer localInteger = (Integer)((Iterator)localObject).next();
/* 1308 */       HashMap localHashMap = new HashMap();
/* 1309 */       localHashMap.put(Integer.valueOf(ItemStoreEnum.SHANGHUI_PRICE.getStoreType()), Integer.valueOf(localInteger.intValue() * ItemCfgConsts.getInstance().SHANGHUI_PRICE_RATE));
/* 1310 */       localHashMap.put(Integer.valueOf(ItemStoreEnum.ITEM_SOURCE.getStoreType()), Integer.valueOf(0));
/* 1311 */       List localList = ItemManager.createXItem(paramInt, 1, localHashMap, false);
/* 1312 */       localArrayList.addAll(localList);
/*      */     }
/* 1314 */     if (localArrayList.isEmpty()) {
/* 1315 */       return false;
/*      */     }
/* 1317 */     localObject = addItem(paramLong, localArrayList, true, paramTLogArg);
/* 1318 */     return ((ItemOperateResult)localObject).success();
/*      */   }
/*      */   
/*      */   public static ItemOperateResult addItem(long paramLong, List<Item> paramList, boolean paramBoolean, TLogArg paramTLogArg) {
/* 1322 */     ItemOperateResult localItemOperateResult = addItemWithNoMailLog(paramLong, paramList, paramBoolean);
/* 1323 */     if (localItemOperateResult.success()) {
/* 1324 */       logItemAndTriggerEvent(paramLong, localItemOperateResult, 1, paramTLogArg);
/*      */     }
/* 1326 */     return localItemOperateResult;
/*      */   }
/*      */   
/*      */   private static ItemOperateResult addItemWithNoMailLog(long paramLong, List<Item> paramList, boolean paramBoolean) {
/* 1330 */     Map localMap = classifyItemIdListByBagId(paramList);
/* 1331 */     ItemOperateResult localItemOperateResult1 = null;
/* 1332 */     for (Map.Entry localEntry : localMap.entrySet()) {
/* 1333 */       ArrayList localArrayList = new ArrayList();
/* 1334 */       HashMap localHashMap = new HashMap();
/* 1335 */       for (Object localObject1 = ((List)localEntry.getValue()).iterator(); ((Iterator)localObject1).hasNext();) { Item localItem = (Item)((Iterator)localObject1).next();
/* 1336 */         localObject2 = (Integer)localHashMap.get(Integer.valueOf(localItem.getCfgid()));
/* 1337 */         if (localObject2 == null) {
/* 1338 */           localObject2 = Integer.valueOf(0);
/*      */         }
/* 1340 */         localHashMap.put(Integer.valueOf(localItem.getCfgid()), Integer.valueOf(((Integer)localObject2).intValue() + localItem.getNumber()));
/* 1341 */         checkAndModifyBasicItem(paramLong, localItem);
/* 1342 */         if (localItem.getNumber() != 0)
/* 1343 */           localArrayList.add(localItem);
/*      */       }
/*      */       Object localObject2;
/* 1346 */       if (localArrayList.size() == 0) {
/* 1347 */         for (localObject1 = localHashMap.keySet().iterator(); ((Iterator)localObject1).hasNext();) { int i = ((Integer)((Iterator)localObject1).next()).intValue();
/* 1348 */           sendItemWithCarryMaxRes(paramLong, i, 0);
/*      */         }
/* 1350 */         localItemOperateResult1 = updateItemOperateResult(localItemOperateResult1, new ItemOperateResult(ItemOperateResult.ItemResultEnum.SUCCESS));
/*      */       }
/*      */       else {
/* 1353 */         localObject1 = ItemManager.getBag(paramLong, ((Integer)localEntry.getKey()).intValue());
/* 1354 */         ItemOperateResult localItemOperateResult2 = ((RoleItemBag)localObject1).addItem(localArrayList, paramBoolean, true);
/* 1355 */         if (localItemOperateResult2.success()) {
/* 1356 */           sendSSynBagAddItem(paramLong, localItemOperateResult2.getChangeItemInfoList());
/* 1357 */           for (localObject2 = localHashMap.keySet().iterator(); ((Iterator)localObject2).hasNext();) { int j = ((Integer)((Iterator)localObject2).next()).intValue();
/* 1358 */             int k = ((Integer)localHashMap.get(Integer.valueOf(j))).intValue();
/* 1359 */             int m = localItemOperateResult2.getItemChangeNum(j);
/* 1360 */             if ((m != k) && (ItemManager.getItemCarryMax(j) > 0)) {
/* 1361 */               sendItemWithCarryMaxRes(paramLong, j, m);
/*      */             }
/*      */           }
/*      */         }
/* 1365 */         localItemOperateResult1 = updateItemOperateResult(localItemOperateResult1, localItemOperateResult2);
/*      */       }
/*      */     }
/* 1368 */     localItemOperateResult1 = localItemOperateResult1 == null ? new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER) : localItemOperateResult1;
/* 1369 */     return localItemOperateResult1;
/*      */   }
/*      */   
/*      */   private static void checkAndModifyBasicItem(long paramLong, Item paramItem) {
/* 1373 */     int i = computeCanAddItemNum(paramLong, paramItem.getCfgid(), paramItem.getNumber());
/* 1374 */     if (i != paramItem.getNumber()) {
/* 1375 */       paramItem.setNumber(i);
/* 1376 */       HashSet localHashSet = new HashSet();
/* 1377 */       for (Long localLong : paramItem.getUuid()) {
/* 1378 */         localHashSet.add(localLong);
/* 1379 */         if (localHashSet.size() == i) {
/*      */           break;
/*      */         }
/*      */       }
/* 1383 */       paramItem.getUuid().clear();
/* 1384 */       paramItem.getUuid().addAll(localHashSet);
/*      */     }
/*      */   }
/*      */   
/*      */   public static int getRoleWeapon(long paramLong) {
/* 1389 */     return getRoleWeapon(paramLong, true);
/*      */   }
/*      */   
/*      */   public static int getRoleWeapon(long paramLong, boolean paramBoolean) {
/* 1393 */     RoleEquipBag localRoleEquipBag = (RoleEquipBag)ItemManager.getBag(paramLong, 340600001, paramBoolean);
/* 1394 */     BasicItem localBasicItem = localRoleEquipBag.get(0);
/* 1395 */     if (localBasicItem == null) {
/* 1396 */       return -1;
/*      */     }
/* 1398 */     return localBasicItem.getCfgId();
/*      */   }
/*      */   
/*      */   public static EquipmentItem getRoleEquipByWearPos(long paramLong, int paramInt) {
/* 1402 */     return getRoleEquipByWearPos(paramLong, paramInt, true);
/*      */   }
/*      */   
/*      */   public static EquipmentItem getRoleEquipByWearPos(long paramLong, int paramInt, boolean paramBoolean) {
/* 1406 */     RoleEquipBag localRoleEquipBag = (RoleEquipBag)ItemManager.getBag(paramLong, 340600001, paramBoolean);
/* 1407 */     BasicItem localBasicItem = localRoleEquipBag.get(paramInt);
/* 1408 */     if ((localBasicItem == null) || (!(localBasicItem instanceof EquipmentItem))) {
/* 1409 */       return null;
/*      */     }
/* 1411 */     return (EquipmentItem)localBasicItem;
/*      */   }
/*      */   
/*      */   public static int getItemTypeById(int paramInt) {
/* 1415 */     return ItemConfigManager.getItemTypeById(paramInt);
/*      */   }
/*      */   
/*      */   public static int getItemTypeByItemId(int paramInt) {
/* 1419 */     return ItemConfigManager.getItemTypeByItemId(paramInt);
/*      */   }
/*      */   
/*      */   public static boolean fillInItemInfoBean(ItemInfo paramItemInfo, Item paramItem) {
/* 1423 */     return ItemManager.fillInItemInfoBean(paramItemInfo, paramItem);
/*      */   }
/*      */   
/*      */   public static List<EquipmentItem> getFumoTimeoutEquips(long paramLong1, int paramInt, long paramLong2) {
/* 1427 */     return getFumoTimeoutEquips(paramLong1, paramInt, paramLong2, true);
/*      */   }
/*      */   
/*      */   public static List<EquipmentItem> getFumoTimeoutEquips(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean) {
/* 1431 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong1, paramInt, paramBoolean);
/* 1432 */     if (localRoleItemBag == null) {
/* 1433 */       return new ArrayList();
/*      */     }
/* 1435 */     Map localMap = localRoleItemBag.getItemByType(2);
/* 1436 */     ArrayList localArrayList = new ArrayList();
/* 1437 */     for (BasicItem localBasicItem : localMap.values())
/* 1438 */       if ((localBasicItem instanceof EquipmentItem))
/*      */       {
/*      */ 
/* 1441 */         localEquipmentItem = (EquipmentItem)localBasicItem;
/* 1442 */         for (FumoInfo localFumoInfo : localEquipmentItem.getFumoInfos())
/* 1443 */           if (localFumoInfo.getTimeout() <= paramLong2) {
/* 1444 */             localArrayList.add(localEquipmentItem);
/* 1445 */             break;
/*      */           }
/*      */       }
/*      */     EquipmentItem localEquipmentItem;
/* 1449 */     return localArrayList;
/*      */   }
/*      */   
/*      */   public static List<Item> createXItem(int paramInt1, int paramInt2) {
/* 1453 */     return createXItem(paramInt1, paramInt2, null, false);
/*      */   }
/*      */   
/*      */   public static List<Item> createXItem(int paramInt1, int paramInt2, Map<Integer, Integer> paramMap, boolean paramBoolean) {
/* 1457 */     if (!isItemExist(paramInt1)) {
/* 1458 */       return new ArrayList();
/*      */     }
/* 1460 */     return ItemManager.createXItem(paramInt1, paramInt2, paramMap, paramBoolean);
/*      */   }
/*      */   
/*      */   public static Item createXItemWithOutUuid(int paramInt1, int paramInt2, Map<Integer, Integer> paramMap, boolean paramBoolean) {
/* 1464 */     if (!isItemExist(paramInt1)) {
/* 1465 */       return null;
/*      */     }
/* 1467 */     return ItemManager.createXItemWithOutUuid(paramInt1, paramInt2, paramMap, paramBoolean);
/*      */   }
/*      */   
/*      */   public static void sendWrongInfo(long paramLong, int paramInt, String... paramVarArgs) {
/* 1471 */     ItemManager.sendWrongInfo(paramLong, paramInt, paramVarArgs);
/*      */   }
/*      */   
/*      */   public static boolean isEquiped(long paramLong, int paramInt) {
/* 1475 */     return isEquiped(paramLong, paramInt, true);
/*      */   }
/*      */   
/*      */   public static boolean isEquiped(long paramLong, int paramInt, boolean paramBoolean) {
/* 1479 */     RoleEquipBag localRoleEquipBag = (RoleEquipBag)ItemManager.getBag(paramLong, 340600001, paramBoolean);
/* 1480 */     return localRoleEquipBag.isEquiped(paramInt);
/*      */   }
/*      */   
/*      */   public static boolean offerSystemAwards(long paramLong) {
/* 1484 */     return ItemManager.offerSystemAwards(paramLong);
/*      */   }
/*      */   
/*      */   public static boolean addSystemAward(Map<Integer, Integer> paramMap1, long paramLong1, long paramLong2, Map<Integer, Integer> paramMap2, Map<Integer, String> paramMap) {
/* 1488 */     return ItemManager.addSystemAward(paramMap1, paramLong1, paramLong2, paramMap2, paramMap);
/*      */   }
/*      */   
/*      */   public static boolean addSystemAward(String paramString1, String paramString2, int paramInt1, int paramInt2) {
/* 1492 */     HashMap localHashMap1 = new HashMap();
/* 1493 */     localHashMap1.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
/* 1494 */     HashMap localHashMap2 = new HashMap();
/* 1495 */     localHashMap2.put(Integer.valueOf(1000), paramString1);
/* 1496 */     localHashMap2.put(Integer.valueOf(1001), paramString2);
/* 1497 */     long l1 = DateTimeUtils.getCurrTimeInMillis();
/* 1498 */     long l2 = l1 + TimeUnit.DAYS.toMillis(1L);
/* 1499 */     boolean bool = ItemManager.addSystemAward(localHashMap1, DateTimeUtils.getCurrTimeInMillis(), l2, new HashMap(), localHashMap2);
/* 1500 */     Iterator localIterator; if (bool) {
/* 1501 */       for (localIterator = OnlineManager.getInstance().getAllRolesInWorld().iterator(); localIterator.hasNext();) { long l3 = ((Long)localIterator.next()).longValue();
/* 1502 */         NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*      */         {
/*      */           protected boolean processImp() throws Exception {
/* 1505 */             return ItemInterface.offerSystemAwards(this.val$roleid);
/*      */           }
/*      */         });
/*      */       }
/*      */     }
/* 1510 */     return bool;
/*      */   }
/*      */   
/*      */   private static void logItemAndTriggerEvent(long paramLong, ItemOperateResult paramItemOperateResult, int paramInt, TLogArg paramTLogArg) {
/* 1514 */     if (paramItemOperateResult.getItemChangeMap().isEmpty()) {
/* 1515 */       return;
/*      */     }
/* 1517 */     ItemManager.logItemAndTriggerEvent(paramLong, paramItemOperateResult, paramInt, paramTLogArg);
/*      */   }
/*      */   
/*      */   public static int getItemUseCount(long paramLong, int paramInt) {
/* 1521 */     return ItemManager.getItemUseCount(paramLong, paramInt);
/*      */   }
/*      */   
/*      */   public static boolean addItemUseCount(long paramLong, int paramInt1, int paramInt2) {
/* 1525 */     return ItemManager.addItemUseCount(paramLong, paramInt1, paramInt2);
/*      */   }
/*      */   
/*      */   public static int getItemCarryMax(int paramInt) {
/* 1529 */     return ItemManager.getItemCarryMax(paramInt);
/*      */   }
/*      */   
/*      */   public static List<BasicItem> getItemByExtraPro(long paramLong, int paramInt1, ItemStoreEnum paramItemStoreEnum, int paramInt2, boolean paramBoolean) {
/* 1533 */     ArrayList localArrayList = new ArrayList();
/* 1534 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, paramInt1, paramBoolean);
/* 1535 */     if (localRoleItemBag == null) {
/* 1536 */       return localArrayList;
/*      */     }
/* 1538 */     Map localMap = localRoleItemBag.getAllItems(false);
/* 1539 */     for (BasicItem localBasicItem : localMap.values()) {
/* 1540 */       Integer localInteger = localBasicItem.getExtra(paramItemStoreEnum);
/* 1541 */       if (localInteger != null) {
/* 1542 */         if (localInteger.intValue() == paramInt2)
/*      */         {
/*      */ 
/* 1545 */           localArrayList.add(localBasicItem); }
/*      */       }
/*      */     }
/* 1548 */     return localArrayList;
/*      */   }
/*      */   
/*      */   public static List<Integer> getDefaultStorageid() {
/* 1552 */     List localList = ItemConfigManager.getDefaultStorageid();
/* 1553 */     return localList;
/*      */   }
/*      */   
/*      */   public static List<Integer> getOpenStorageids(long paramLong, boolean paramBoolean) {
/* 1557 */     ArrayList localArrayList = new ArrayList();
/* 1558 */     List localList = ItemConfigManager.getAllStorageids();
/* 1559 */     for (Iterator localIterator = localList.iterator(); localIterator.hasNext();) { int i = ((Integer)localIterator.next()).intValue();
/* 1560 */       if (isBagEnable(paramLong, i, paramBoolean)) {
/* 1561 */         localArrayList.add(Integer.valueOf(i));
/*      */       }
/*      */     }
/* 1564 */     return localArrayList;
/*      */   }
/*      */   
/*      */   public static List<Integer> getAllStorageids() {
/* 1568 */     return ItemConfigManager.getAllStorageids();
/*      */   }
/*      */   
/*      */   public static boolean isBagEnable(long paramLong, int paramInt, boolean paramBoolean) {
/* 1572 */     return ItemManager.getBag(paramLong, paramInt, paramBoolean) != null;
/*      */   }
/*      */   
/*      */   public static boolean createRoleBags(long paramLong) {
/* 1576 */     boolean bool = ItemManager.createRoleItemBag(paramLong, 340600000);
/* 1577 */     if (!bool) {
/* 1578 */       return false;
/*      */     }
/* 1580 */     bool = ItemManager.createRoleItemBag(paramLong, 340600001);
/* 1581 */     if (!bool) {
/* 1582 */       return false;
/*      */     }
/* 1584 */     List localList = ItemConfigManager.getDefaultStorageid();
/* 1585 */     for (Iterator localIterator = localList.iterator(); localIterator.hasNext();) { int i = ((Integer)localIterator.next()).intValue();
/* 1586 */       bool = ItemManager.createRoleStorageBag(paramLong, i);
/* 1587 */       if (!bool) {
/* 1588 */         return false;
/*      */       }
/*      */     }
/* 1591 */     bool = ItemManager.createRoleItemBag(paramLong, 340600005);
/* 1592 */     if (!bool) {
/* 1593 */       return false;
/*      */     }
/* 1595 */     bool = ItemManager.createRoleItemBag(paramLong, 340600006);
/* 1596 */     if (!bool) {
/* 1597 */       return false;
/*      */     }
/* 1599 */     bool = ItemManager.createRoleItemBag(paramLong, 340600007);
/* 1600 */     if (!bool) {
/* 1601 */       return false;
/*      */     }
/* 1603 */     bool = ItemManager.createRoleItemBag(paramLong, 340600008);
/* 1604 */     if (!bool) {
/* 1605 */       return false;
/*      */     }
/* 1607 */     bool = ItemManager.createRoleItemBag(paramLong, 340600009);
/* 1608 */     return (bool) && (bool);
/*      */   }
/*      */   
/*      */   public static boolean isBagFull(long paramLong, int paramInt, boolean paramBoolean) {
/* 1612 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, paramInt, paramBoolean);
/* 1613 */     return (localRoleItemBag == null) || (localRoleItemBag.isBagFull());
/*      */   }
/*      */   
/*      */   public static int getAvailableGridNum(long paramLong, int paramInt, boolean paramBoolean) {
/* 1617 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, paramInt, paramBoolean);
/* 1618 */     if (localRoleItemBag == null) {
/* 1619 */       return 0;
/*      */     }
/* 1621 */     return localRoleItemBag.getAvailableGridNum();
/*      */   }
/*      */   
/*      */   public static boolean isGridEnough(long paramLong, int paramInt1, int paramInt2, int paramInt3) {
/* 1625 */     if ((paramInt3 < 0) || (!isItemExist(paramInt2))) {
/* 1626 */       return false;
/*      */     }
/* 1628 */     int i = paramInt3 / getPileMaxCount(paramInt2);
/* 1629 */     if (paramInt3 % getPileMaxCount(paramInt2) != 0) {
/* 1630 */       i++;
/*      */     }
/* 1632 */     int j = getAvailableGridNum(paramLong, paramInt1, true);
/* 1633 */     return i <= j;
/*      */   }
/*      */   
/*      */   public static boolean isGridEnough(long paramLong, int paramInt, Map<Integer, Integer> paramMap) {
/* 1637 */     int i = 0;
/* 1638 */     for (Iterator localIterator = paramMap.keySet().iterator(); localIterator.hasNext();) { int k = ((Integer)localIterator.next()).intValue();
/* 1639 */       int m = ((Integer)paramMap.get(Integer.valueOf(k))).intValue();
/* 1640 */       if ((m < 0) || (!isItemExist(k))) {
/* 1641 */         return false;
/*      */       }
/* 1643 */       i += m / getPileMaxCount(k);
/* 1644 */       if (m % getPileMaxCount(k) != 0)
/*      */       {
/*      */ 
/* 1647 */         i++; }
/*      */     }
/* 1649 */     int j = getAvailableGridNum(paramLong, paramInt, true);
/* 1650 */     return i <= j;
/*      */   }
/*      */   
/*      */   public static int needGrid(Map<Integer, Integer> paramMap) {
/* 1654 */     int i = 0;
/* 1655 */     for (Iterator localIterator = paramMap.keySet().iterator(); localIterator.hasNext();) { int j = ((Integer)localIterator.next()).intValue();
/* 1656 */       int k = ((Integer)paramMap.get(Integer.valueOf(j))).intValue();
/* 1657 */       int m = getPileMaxCount(j);
/* 1658 */       if ((k < 0) || (m == 0)) {
/* 1659 */         return Integer.MAX_VALUE;
/*      */       }
/* 1661 */       i += k / m;
/* 1662 */       if (k % m != 0)
/*      */       {
/*      */ 
/* 1665 */         i++; }
/*      */     }
/* 1667 */     return i;
/*      */   }
/*      */   
/*      */   public static int getPileMaxCount(int paramInt) {
/* 1671 */     return ItemConfigManager.getPileMaxCount(paramInt);
/*      */   }
/*      */   
/*      */   public static boolean expandCapacity(long paramLong, int paramInt1, int paramInt2) {
/* 1675 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, paramInt1);
/* 1676 */     return (localRoleItemBag != null) && (localRoleItemBag.expandCapacity(paramInt2));
/*      */   }
/*      */   
/*      */   public static int getCapacity(long paramLong, int paramInt, boolean paramBoolean) {
/* 1680 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, paramInt, paramBoolean);
/* 1681 */     if (localRoleItemBag == null) {
/* 1682 */       return 0;
/*      */     }
/* 1684 */     return localRoleItemBag.getCapacity();
/*      */   }
/*      */   
/*      */   public static int getItemPro(int paramInt) {
/* 1688 */     return ItemConfigManager.getItemPro(paramInt);
/*      */   }
/*      */   
/*      */   public static int getFeijianId(int paramInt) {
/* 1692 */     return ItemConfigManager.getFeijianId(paramInt);
/*      */   }
/*      */   
/*      */   public static SFeiJianCfg getFeiJianCfg(int paramInt) {
/* 1696 */     return SFeiJianCfg.get(paramInt);
/*      */   }
/*      */   
/*      */   public static int getEquipedAirCraftItemId(long paramLong, boolean paramBoolean) {
/* 1700 */     RoleEquipBag localRoleEquipBag = (RoleEquipBag)ItemManager.getBag(paramLong, 340600001, paramBoolean);
/* 1701 */     BasicItem localBasicItem = localRoleEquipBag.get(8);
/* 1702 */     if (localBasicItem == null) {
/* 1703 */       return -1;
/*      */     }
/* 1705 */     return localBasicItem.getCfgId();
/*      */   }
/*      */   
/*      */   public static int getGiftbagItemRewardId(int paramInt) {
/* 1709 */     if (SGiftbagItem.get(paramInt) == null) {
/* 1710 */       return -1;
/*      */     }
/* 1712 */     return SGiftbagItem.get(paramInt).awardId;
/*      */   }
/*      */   
/*      */   public static boolean isDirectlyUseGiftbagItem(int paramInt) {
/* 1716 */     return (mzm.gsp.item.confbean.SUseGiftbagItemCfg.get(paramInt) != null) && (SGiftbagItem.get(paramInt) != null);
/*      */   }
/*      */   
/*      */   public static boolean isItemFromShanghuiOrBaitan(int paramInt) {
/* 1720 */     return (BaiTanInterface.isBaitanItem(paramInt)) || (ShanghuiInterface.isItemInShanghuiCfg(paramInt));
/*      */   }
/*      */   
/*      */   public static void fillXItem(Item paramItem1, Item paramItem2) {
/* 1724 */     ItemManager.fillXItem(paramItem1, paramItem2);
/*      */   }
/*      */   
/*      */   public static int getUseLevel(int paramInt) {
/* 1728 */     return ItemConfigManager.getUseLevel(paramInt);
/*      */   }
/*      */   
/*      */   public static int getColor(int paramInt) {
/* 1732 */     return ItemConfigManager.getColor(paramInt);
/*      */   }
/*      */   
/*      */   public static boolean isEquipItem(int paramInt) {
/* 1736 */     return ItemConfigManager.isEquipItem(paramInt);
/*      */   }
/*      */   
/*      */   public static int getEquipSkill(Item paramItem) {
/* 1740 */     if ((paramItem == null) || (paramItem.getExtra().get(Integer.valueOf(6)) == null)) {
/* 1741 */       return -1;
/*      */     }
/* 1743 */     return ((Integer)paramItem.getExtra().get(Integer.valueOf(6))).intValue();
/*      */   }
/*      */   
/*      */   public static Set<Integer> getPetEquipItemSkills(Item paramItem) {
/* 1747 */     HashSet localHashSet = new HashSet();
/* 1748 */     if (paramItem == null) {
/* 1749 */       return localHashSet;
/*      */     }
/* 1751 */     Integer localInteger1 = (Integer)paramItem.getExtra().get(Integer.valueOf(42));
/* 1752 */     if (localInteger1 != null) {
/* 1753 */       localHashSet.add(localInteger1);
/*      */     }
/* 1755 */     Integer localInteger2 = (Integer)paramItem.getExtra().get(Integer.valueOf(43));
/* 1756 */     if (localInteger2 != null) {
/* 1757 */       localHashSet.add(localInteger2);
/*      */     }
/* 1759 */     return localHashSet;
/*      */   }
/*      */   
/*      */   public static boolean isPetEquipItemHasProperty(Item paramItem, int paramInt) {
/* 1763 */     return (paramItem != null) && (((paramItem.getExtra().get(Integer.valueOf(44)) != null) && (((Integer)paramItem.getExtra().get(Integer.valueOf(44))).intValue() == paramInt)) || ((paramItem.getExtra().get(Integer.valueOf(45)) != null) && (((Integer)paramItem.getExtra().get(Integer.valueOf(45))).intValue() == paramInt)));
/*      */   }
/*      */   
/*      */   public static Set<Integer> getPetEquipItemPropertys(Item paramItem) {
/* 1767 */     HashSet localHashSet = new HashSet();
/* 1768 */     if (paramItem == null) {
/* 1769 */       return localHashSet;
/*      */     }
/* 1771 */     Integer localInteger1 = (Integer)paramItem.getExtra().get(Integer.valueOf(44));
/* 1772 */     if (localInteger1 != null) {
/* 1773 */       localHashSet.add(localInteger1);
/*      */     }
/* 1775 */     Integer localInteger2 = (Integer)paramItem.getExtra().get(Integer.valueOf(45));
/* 1776 */     if (localInteger2 != null) {
/* 1777 */       localHashSet.add(localInteger2);
/*      */     }
/* 1779 */     return localHashSet;
/*      */   }
/*      */   
/*      */   public static boolean isItemColor(int paramInt) {
/* 1783 */     return (paramInt <= 5) && (paramInt >= 1);
/*      */   }
/*      */   
/*      */   public static int getWholeBodyMinQilinLevel(long paramLong, boolean paramBoolean) {
/* 1787 */     RoleEquipBag localRoleEquipBag = (RoleEquipBag)ItemManager.getBag(paramLong, 340600001, paramBoolean);
/* 1788 */     return getWholeBodyMinQilinLevel(localRoleEquipBag);
/*      */   }
/*      */   
/*      */   public static int getWholeBodyMinQilinLevel(RoleEquipBag paramRoleEquipBag) {
/* 1792 */     if (paramRoleEquipBag == null) {
/* 1793 */       return -1;
/*      */     }
/* 1795 */     int i = -1;
/* 1796 */     for (int j = 0; j <= 5; j++) {
/* 1797 */       BasicItem localBasicItem = paramRoleEquipBag.get(j);
/* 1798 */       if ((localBasicItem == null) || (!(localBasicItem instanceof EquipmentItem))) {
/* 1799 */         return -1;
/*      */       }
/* 1801 */       EquipmentItem localEquipmentItem = (EquipmentItem)localBasicItem;
/* 1802 */       if ((i == -1) || (i > localEquipmentItem.getStrengthLevel())) {
/* 1803 */         i = localEquipmentItem.getStrengthLevel();
/*      */       }
/*      */     }
/* 1806 */     return i;
/*      */   }
/*      */   
/*      */   public static int getMinEquipLevel(RoleEquipBag paramRoleEquipBag) {
/* 1810 */     if (paramRoleEquipBag == null) {
/* 1811 */       return -1;
/*      */     }
/* 1813 */     int i = -1;
/* 1814 */     for (int j = 0; j <= 5; j++) {
/* 1815 */       BasicItem localBasicItem = paramRoleEquipBag.get(j);
/* 1816 */       if (localBasicItem == null) {
/* 1817 */         return -1;
/*      */       }
/* 1819 */       int k = getUseLevel(localBasicItem.getCfgId());
/* 1820 */       if ((i == -1) || (i > k)) {
/* 1821 */         i = k;
/*      */       }
/*      */     }
/* 1824 */     return i;
/*      */   }
/*      */   
/*      */   public static String getItemName(int paramInt) {
/* 1828 */     return ItemConfigManager.getItemName(paramInt);
/*      */   }
/*      */   
/*      */   public static int getEquipCoulorCount(long paramLong, List<Integer> paramList, boolean paramBoolean) {
/* 1832 */     int i = 0;
/* 1833 */     if ((paramList == null) || (paramList.isEmpty())) {
/* 1834 */       return i;
/*      */     }
/* 1836 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, 340600000, paramBoolean);
/* 1837 */     for (Object localObject1 = localRoleItemBag.getAllItems(false).values().iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (BasicItem)((Iterator)localObject1).next();
/* 1838 */       if ((isEquipItem(((BasicItem)localObject2).getCfgId())) && 
/*      */       
/*      */ 
/* 1841 */         (paramList.contains(Integer.valueOf(getColor(((BasicItem)localObject2).getCfgId())))))
/*      */       {
/*      */ 
/* 1844 */         i++; }
/*      */     }
/* 1846 */     localObject1 = ItemManager.getBag(paramLong, 340600001, paramBoolean);
/* 1847 */     for (Object localObject2 = ((RoleItemBag)localObject1).getAllItems(false).values().iterator(); ((Iterator)localObject2).hasNext();) { localObject3 = (BasicItem)((Iterator)localObject2).next();
/* 1848 */       if (paramList.contains(Integer.valueOf(getColor(((BasicItem)localObject3).getCfgId())))) {
/* 1849 */         i++;
/*      */       }
/*      */     }
/* 1852 */     localObject2 = ItemManager.getAllRoleStorageBags(paramLong, paramBoolean);
/* 1853 */     for (Object localObject3 = ((List)localObject2).iterator(); ((Iterator)localObject3).hasNext();) { RoleStorageBag localRoleStorageBag = (RoleStorageBag)((Iterator)localObject3).next();
/* 1854 */       for (BasicItem localBasicItem : localRoleStorageBag.getAllItems(false).values()) {
/* 1855 */         if ((isEquipItem(localBasicItem.getCfgId())) && 
/*      */         
/*      */ 
/* 1858 */           (paramList.contains(Integer.valueOf(getColor(localBasicItem.getCfgId())))))
/*      */         {
/*      */ 
/* 1861 */           i++; }
/*      */       }
/*      */     }
/* 1864 */     return i;
/*      */   }
/*      */   
/*      */   public static List<Integer> getEquipSkillCount(long paramLong, List<Integer> paramList, boolean paramBoolean) {
/* 1868 */     Object localObject1 = null;
/* 1869 */     if ((paramList == null) || (paramList.isEmpty())) {
/* 1870 */       return (List<Integer>)localObject1;
/*      */     }
/* 1872 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, 340600000, paramBoolean);
/* 1873 */     for (Object localObject2 = localRoleItemBag.getAllItems(false).values().iterator(); ((Iterator)localObject2).hasNext();) { localObject3 = (BasicItem)((Iterator)localObject2).next();
/* 1874 */       if (isEquipItem(((BasicItem)localObject3).getCfgId()))
/*      */       {
/*      */ 
/* 1877 */         localObject4 = ((BasicItem)localObject3).getExtra(ItemStoreEnum.EQUIP_SKILL);
/* 1878 */         if ((localObject4 != null) && 
/*      */         
/*      */ 
/* 1881 */           (paramList.contains(localObject4)))
/*      */         {
/*      */ 
/* 1884 */           if (localObject1 == null) {
/* 1885 */             localObject1 = new ArrayList();
/*      */           }
/* 1887 */           ((List)localObject1).add(localObject4);
/*      */         } } }
/* 1889 */     localObject2 = ItemManager.getBag(paramLong, 340600001, paramBoolean);
/* 1890 */     for (Object localObject3 = ((RoleItemBag)localObject2).getAllItems(false).values().iterator(); ((Iterator)localObject3).hasNext();) { localObject4 = (BasicItem)((Iterator)localObject3).next();
/* 1891 */       localObject5 = ((BasicItem)localObject4).getExtra(ItemStoreEnum.EQUIP_SKILL);
/* 1892 */       if ((localObject5 != null) && 
/*      */       
/*      */ 
/* 1895 */         (paramList.contains(localObject5)))
/*      */       {
/*      */ 
/* 1898 */         if (localObject1 == null) {
/* 1899 */           localObject1 = new ArrayList();
/*      */         }
/* 1901 */         ((List)localObject1).add(localObject5); } }
/*      */     Object localObject5;
/* 1903 */     localObject3 = ItemManager.getAllRoleStorageBags(paramLong, paramBoolean);
/* 1904 */     for (Object localObject4 = ((List)localObject3).iterator(); ((Iterator)localObject4).hasNext();) { localObject5 = (RoleStorageBag)((Iterator)localObject4).next();
/* 1905 */       for (BasicItem localBasicItem : ((RoleStorageBag)localObject5).getAllItems(false).values()) {
/* 1906 */         Integer localInteger = localBasicItem.getExtra(ItemStoreEnum.EQUIP_SKILL);
/* 1907 */         if ((localInteger != null) && 
/*      */         
/*      */ 
/* 1910 */           (paramList.contains(localInteger)))
/*      */         {
/*      */ 
/* 1913 */           if (localObject1 == null) {
/* 1914 */             localObject1 = new ArrayList();
/*      */           }
/* 1916 */           ((List)localObject1).add(localInteger);
/*      */         }
/*      */       } }
/* 1919 */     return (List<Integer>)localObject1;
/*      */   }
/*      */   
/*      */   public static Map<Long, Integer> getUuid2QiLinLevel(long paramLong, int paramInt, boolean paramBoolean) {
/* 1923 */     HashMap localHashMap = new HashMap();
/* 1924 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, 340600000, paramBoolean);
/* 1925 */     for (Object localObject1 = localRoleItemBag.getAllItems(false).values().iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (BasicItem)((Iterator)localObject1).next();
/* 1926 */       if ((isEquipItem(((BasicItem)localObject2).getCfgId())) && 
/*      */       
/*      */ 
/* 1929 */         ((localObject2 instanceof EquipmentItem)))
/*      */       {
/*      */ 
/* 1932 */         localObject3 = (EquipmentItem)localObject2;
/* 1933 */         if (((EquipmentItem)localObject3).getStrengthLevel() >= paramInt)
/*      */         {
/*      */ 
/* 1936 */           localHashMap.put(((EquipmentItem)localObject3).getFirstUuid(), Integer.valueOf(((EquipmentItem)localObject3).getStrengthLevel())); }
/*      */       } }
/* 1938 */     localObject1 = ItemManager.getBag(paramLong, 340600001, paramBoolean);
/* 1939 */     for (Object localObject2 = ((RoleItemBag)localObject1).getAllItems(false).values().iterator(); ((Iterator)localObject2).hasNext();) { localObject3 = (BasicItem)((Iterator)localObject2).next();
/* 1940 */       if ((localObject3 instanceof EquipmentItem))
/*      */       {
/*      */ 
/* 1943 */         localObject4 = (EquipmentItem)localObject3;
/* 1944 */         if (((EquipmentItem)localObject4).getStrengthLevel() >= paramInt)
/*      */         {
/*      */ 
/* 1947 */           localHashMap.put(((EquipmentItem)localObject4).getFirstUuid(), Integer.valueOf(((EquipmentItem)localObject4).getStrengthLevel())); } } }
/*      */     Object localObject4;
/* 1949 */     localObject2 = ItemManager.getAllRoleStorageBags(paramLong, paramBoolean);
/* 1950 */     for (Object localObject3 = ((List)localObject2).iterator(); ((Iterator)localObject3).hasNext();) { localObject4 = (RoleStorageBag)((Iterator)localObject3).next();
/* 1951 */       for (BasicItem localBasicItem : ((RoleStorageBag)localObject4).getAllItems(false).values())
/* 1952 */         if ((isEquipItem(localBasicItem.getCfgId())) && 
/*      */         
/*      */ 
/* 1955 */           ((localBasicItem instanceof EquipmentItem)))
/*      */         {
/*      */ 
/* 1958 */           EquipmentItem localEquipmentItem = (EquipmentItem)localBasicItem;
/* 1959 */           if (localEquipmentItem.getStrengthLevel() >= paramInt)
/*      */           {
/*      */ 
/* 1962 */             localHashMap.put(localEquipmentItem.getFirstUuid(), Integer.valueOf(localEquipmentItem.getStrengthLevel())); }
/*      */         }
/*      */     }
/* 1965 */     return localHashMap;
/*      */   }
/*      */   
/*      */   public static List<Integer> getEquipSkillList(long paramLong, boolean paramBoolean) {
/* 1969 */     RoleEquipBag localRoleEquipBag = (RoleEquipBag)ItemManager.getBag(paramLong, 340600001, paramBoolean);
/* 1970 */     if (localRoleEquipBag == null) {
/* 1971 */       return null;
/*      */     }
/* 1973 */     ArrayList localArrayList = new ArrayList();
/* 1974 */     for (int i = 0; i <= 5; i++) {
/* 1975 */       BasicItem localBasicItem = localRoleEquipBag.get(i);
/* 1976 */       if ((localBasicItem != null) && 
/* 1977 */         ((localBasicItem instanceof EquipmentItem))) {
/* 1978 */         int j = getEquipSkill(localBasicItem.getItem());
/* 1979 */         if (j != -1) {
/* 1980 */           localArrayList.add(Integer.valueOf(j));
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1985 */     return localArrayList;
/*      */   }
/*      */   
/*      */   public static Map<Integer, BasicItem> getItemByItemId(long paramLong, int paramInt, boolean paramBoolean) {
/* 1989 */     RoleItemBag localRoleItemBag = ItemManager.getBagByItemId(paramLong, 340600000, paramInt, paramBoolean);
/* 1990 */     if (localRoleItemBag == null) {
/* 1991 */       return null;
/*      */     }
/* 1993 */     return localRoleItemBag.getItemBycfgId(paramInt);
/*      */   }
/*      */   
/*      */   public static int getEquipBagCapacity() {
/* 1997 */     SBagCfg localSBagCfg = SBagCfg.get(340600001);
/* 1998 */     if (localSBagCfg == null) {
/* 1999 */       return 0;
/*      */     }
/* 2001 */     return localSBagCfg.initcapacity;
/*      */   }
/*      */   
/*      */   public static RoleEquipBag getRoleEquipBag(long paramLong) {
/* 2005 */     RoleEquipBag localRoleEquipBag = ItemManager.getRoleEquipBag(paramLong);
/* 2006 */     return localRoleEquipBag;
/*      */   }
/*      */   
/*      */   public static RoleItemBag getRoleItemBag(long paramLong) {
/* 2010 */     RoleItemBag localRoleItemBag = ItemManager.getRoleItemBag(paramLong);
/* 2011 */     return localRoleItemBag;
/*      */   }
/*      */   
/*      */   public static RoleFaBaoBag getRoleFaBaoBag(long paramLong) {
/* 2015 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, 340600006);
/* 2016 */     if ((localRoleItemBag == null) || (!(localRoleItemBag instanceof RoleFaBaoBag))) {
/* 2017 */       return null;
/*      */     }
/* 2019 */     return (RoleFaBaoBag)localRoleItemBag;
/*      */   }
/*      */   
/*      */   public static RolePetMarkBag getRolePetMarkBag(long paramLong) {
/* 2023 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, 340600009);
/* 2024 */     if ((localRoleItemBag == null) || (!(localRoleItemBag instanceof RolePetMarkBag))) {
/* 2025 */       return null;
/*      */     }
/* 2027 */     return (RolePetMarkBag)localRoleItemBag;
/*      */   }
/*      */   
/*      */   public static int getEquipWearpos(int paramInt) {
/* 2031 */     return ItemConfigManager.getEquipWearpos(paramInt);
/*      */   }
/*      */   
/*      */   public static boolean checkEquipOnCondition(long paramLong, int paramInt1, int paramInt2, EquipmentItem paramEquipmentItem) {
/* 2035 */     return checkEquipOnCondition(paramLong, paramInt1, paramInt2, paramEquipmentItem, true);
/*      */   }
/*      */   
/*      */   public static boolean checkEquipOnCondition(long paramLong, int paramInt1, int paramInt2, EquipmentItem paramEquipmentItem, boolean paramBoolean) {
/* 2039 */     SItemEquipCfg localSItemEquipCfg = SItemEquipCfg.get(paramEquipmentItem.getCfgId());
/* 2040 */     if (localSItemEquipCfg == null) {
/* 2041 */       if (paramBoolean) {
/* 2042 */         ItemManager.sendWrongInfo(paramLong, 612, new String[0]);
/*      */       }
/* 2044 */       return false;
/*      */     }
/* 2046 */     if (!paramEquipmentItem.isUsePointNormal()) {
/* 2047 */       if (paramBoolean) {
/* 2048 */         ItemManager.sendWrongInfo(paramLong, 614, new String[0]);
/*      */       }
/* 2050 */       return false;
/*      */     }
/* 2052 */     int i = paramEquipmentItem.getEquipWearModifyLevel();
/* 2053 */     if (!ItemManager.useItemLevel(paramLong, localSItemEquipCfg.useLevel + i)) {
/* 2054 */       if (paramBoolean) {
/* 2055 */         ItemManager.sendWrongInfo(paramLong, 615, new String[0]);
/*      */       }
/* 2057 */       return false;
/*      */     }
/* 2059 */     if (!ItemManager.useItemOccupation(paramInt1, localSItemEquipCfg.menpai)) {
/* 2060 */       if (paramBoolean) {
/* 2061 */         ItemManager.sendWrongInfo(paramLong, 616, new String[0]);
/*      */       }
/* 2063 */       return false;
/*      */     }
/* 2065 */     if ((localSItemEquipCfg.sex != 0) && (paramInt2 != localSItemEquipCfg.sex)) {
/* 2066 */       if (paramBoolean) {
/* 2067 */         ItemManager.sendWrongInfo(paramLong, 617, new String[0]);
/*      */       }
/* 2069 */       return false;
/*      */     }
/* 2071 */     int j = ServerInterface.getCurrentServerLevel();
/* 2072 */     if ((j > ServerLevelConsts.getInstance().CRITICAL_SERVER_LEVEL) && (localSItemEquipCfg.useLevel > j)) {
/* 2073 */       if (paramBoolean) {
/* 2074 */         ItemManager.sendWrongInfo(paramLong, 618, new String[0]);
/*      */       }
/* 2076 */       return false;
/*      */     }
/* 2078 */     return true;
/*      */   }
/*      */   
/*      */   public static int getAvgQilinLevel(long paramLong, boolean paramBoolean) {
/* 2082 */     RoleEquipBag localRoleEquipBag = (RoleEquipBag)ItemManager.getBag(paramLong, 340600001, paramBoolean);
/* 2083 */     if (localRoleEquipBag == null) {
/* 2084 */       return 0;
/*      */     }
/* 2086 */     int i = 0;
/* 2087 */     for (int j = 0; j <= 5; j++) {
/* 2088 */       BasicItem localBasicItem = localRoleEquipBag.get(j);
/* 2089 */       if ((localBasicItem != null) && 
/* 2090 */         ((localBasicItem instanceof EquipmentItem))) {
/* 2091 */         EquipmentItem localEquipmentItem = (EquipmentItem)localBasicItem;
/* 2092 */         i += localEquipmentItem.getStrengthLevel();
/*      */       }
/*      */     }
/*      */     
/* 2096 */     return i / getEquipCount();
/*      */   }
/*      */   
/*      */   private static int getEquipCount() {
/* 2100 */     return 6;
/*      */   }
/*      */   
/*      */   public static void exchangeEquipAccumulationQilinInfo(EquipmentItem paramEquipmentItem1, EquipmentItem paramEquipmentItem2) {
/* 2104 */     ItemManager.exchangeEquipAccumulationQilinInfo(paramEquipmentItem1, paramEquipmentItem2);
/*      */   }
/*      */   
/*      */   public static boolean canTransferStrengthLevel(long paramLong, SItemEquipCfg paramSItemEquipCfg1, SItemEquipCfg paramSItemEquipCfg2, boolean paramBoolean) {
/* 2108 */     return ItemConfigManager.canTransferStrengthLevel(paramLong, paramSItemEquipCfg1, paramSItemEquipCfg2, paramBoolean);
/*      */   }
/*      */   
/*      */   public static List<Protocol> afterAwardRoleExp(long paramLong, int paramInt) {
/* 2112 */     Object localObject = null;
/* 2113 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, 340600000);
/* 2114 */     if (localRoleItemBag == null) {
/* 2115 */       return (List<Protocol>)localObject;
/*      */     }
/* 2117 */     Protocol localProtocol = localRoleItemBag.handleExpBottleItemAfterAwardExp(paramInt);
/* 2118 */     if (localProtocol != null) {
/* 2119 */       localObject = new ArrayList();
/* 2120 */       ((List)localObject).add(localProtocol);
/*      */     }
/* 2122 */     return (List<Protocol>)localObject;
/*      */   }
/*      */   
/*      */   public static Pair<Boolean, Protocol> triggerDoubleItemAward(long paramLong, Map<Integer, Integer> paramMap) {
/* 2126 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, 340600000);
/* 2127 */     if (localRoleItemBag == null) {
/* 2128 */       return new Pair(Boolean.valueOf(true), null);
/*      */     }
/* 2130 */     HashMap localHashMap = new HashMap(paramMap);
/* 2131 */     return localRoleItemBag.handleDoubleItemAfterAwardItem(localHashMap);
/*      */   }
/*      */   
/*      */   private static Map<Integer, Map<Integer, Integer>> classifyItemIdMapByBagId(Map<Integer, Integer> paramMap) {
/* 2135 */     HashMap localHashMap1 = new HashMap();
/* 2136 */     for (Map.Entry localEntry : paramMap.entrySet()) {
/* 2137 */       int i = ItemManager.getBagIdByItemId(340600000, ((Integer)localEntry.getKey()).intValue());
/* 2138 */       if (localHashMap1.containsKey(Integer.valueOf(i))) {
/* 2139 */         ((Map)localHashMap1.get(Integer.valueOf(i))).put(localEntry.getKey(), localEntry.getValue());
/*      */       }
/*      */       else {
/* 2142 */         HashMap localHashMap2 = new HashMap();
/* 2143 */         localHashMap2.put(localEntry.getKey(), localEntry.getValue());
/* 2144 */         localHashMap1.put(Integer.valueOf(i), localHashMap2);
/*      */       }
/*      */     }
/* 2147 */     return localHashMap1;
/*      */   }
/*      */   
/*      */   private static Map<Integer, Map<Long, Integer>> classifyUUIDMapByBagId(Map<Long, Integer> paramMap, long paramLong) {
/* 2151 */     HashMap localHashMap1 = new HashMap();
/* 2152 */     for (Map.Entry localEntry : paramMap.entrySet()) {
/* 2153 */       int i = ItemManager.getBagIdByUUID(paramLong, ((Long)localEntry.getKey()).longValue());
/* 2154 */       if (localHashMap1.containsKey(Integer.valueOf(i))) {
/* 2155 */         ((Map)localHashMap1.get(Integer.valueOf(i))).put(localEntry.getKey(), localEntry.getValue());
/*      */       }
/*      */       else {
/* 2158 */         HashMap localHashMap2 = new HashMap();
/* 2159 */         localHashMap2.put(localEntry.getKey(), localEntry.getValue());
/* 2160 */         localHashMap1.put(Integer.valueOf(i), localHashMap2);
/*      */       }
/*      */     }
/* 2163 */     return localHashMap1;
/*      */   }
/*      */   
/*      */   private static Map<Integer, List<Item>> classifyItemIdListByBagId(List<Item> paramList) {
/* 2167 */     HashMap localHashMap = new HashMap();
/* 2168 */     for (Item localItem : paramList) {
/* 2169 */       int i = ItemManager.getBagIdByItemId(340600000, localItem.getCfgid());
/* 2170 */       if (localHashMap.containsKey(Integer.valueOf(i))) {
/* 2171 */         ((List)localHashMap.get(Integer.valueOf(i))).add(localItem);
/*      */       }
/*      */       else {
/* 2174 */         ArrayList localArrayList = new ArrayList();
/* 2175 */         localArrayList.add(localItem);
/* 2176 */         localHashMap.put(Integer.valueOf(i), localArrayList);
/*      */       }
/*      */     }
/* 2179 */     return localHashMap;
/*      */   }
/*      */   
/*      */   private static ItemOperateResult updateItemOperateResult(ItemOperateResult paramItemOperateResult1, ItemOperateResult paramItemOperateResult2) {
/* 2183 */     if (paramItemOperateResult1 == null) {
/* 2184 */       return paramItemOperateResult2;
/*      */     }
/* 2186 */     if ((!paramItemOperateResult1.success()) && (!paramItemOperateResult1.isBagFull())) {
/* 2187 */       return paramItemOperateResult1;
/*      */     }
/* 2189 */     if (paramItemOperateResult1.success()) {
/* 2190 */       return paramItemOperateResult2;
/*      */     }
/* 2192 */     if ((!paramItemOperateResult2.success()) && (!paramItemOperateResult2.isBagFull())) {
/* 2193 */       return paramItemOperateResult2;
/*      */     }
/* 2195 */     return paramItemOperateResult1;
/*      */   }
/*      */   
/*      */   public static boolean createSuperEquipmentJewelBag(long paramLong) {
/* 2199 */     SuperEquipmentJewelBag localSuperEquipmentJewelBag = ItemManager.getSuperEquipmentJewelBag(paramLong);
/* 2200 */     return (localSuperEquipmentJewelBag != null) || (ItemManager.createRoleItemBag(paramLong, 340600005));
/*      */   }
/*      */   
/*      */   public static List<RoleStorageBag> getAllRoleStorageBags(long paramLong) {
/* 2204 */     return ItemManager.getAllRoleStorageBags(paramLong, true);
/*      */   }
/*      */   
/*      */   public static int getRoleStorageBagSize(long paramLong, boolean paramBoolean) {
/* 2208 */     return ItemManager.getRoleStorageBagSize(paramLong, paramBoolean);
/*      */   }
/*      */   
/*      */   public static int getTotalGiveFlowerPoint(long paramLong, boolean paramBoolean) {
/* 2212 */     return ItemGiveManager.getTotalGiveFlowerPoint(paramLong, paramBoolean);
/*      */   }
/*      */   
/*      */   public static int getTotalReceiveFlowerPoint(long paramLong, boolean paramBoolean) {
/* 2216 */     return ItemGiveManager.getTotalReceiveFlowerPoint(paramLong, paramBoolean);
/*      */   }
/*      */   
/*      */   public static BasicItem moveItemFromBag(long paramLong, int paramInt1, int paramInt2) {
/* 2220 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, paramInt1);
/* 2221 */     if (localRoleItemBag == null) {
/* 2222 */       return null;
/*      */     }
/* 2224 */     return localRoleItemBag.removeByGrid(paramInt2);
/*      */   }
/*      */   
/*      */   public static boolean moveItemInBag(long paramLong, int paramInt, BasicItem paramBasicItem) {
/* 2228 */     RoleItemBag localRoleItemBag = ItemManager.getBag(paramLong, paramInt);
/* 2229 */     if (localRoleItemBag == null) {
/* 2230 */       return false;
/*      */     }
/* 2232 */     ItemOperateResult localItemOperateResult = localRoleItemBag.addItem(paramBasicItem, false);
/* 2233 */     return localItemOperateResult.success();
/*      */   }
/*      */   
/*      */   public static void sendSpecificBagGridNotEnough(long paramLong, int paramInt) {
/* 2237 */     sendWrongInfo(paramLong, 22, new String[] { String.valueOf(paramInt) });
/*      */   }
/*      */   
/*      */   public static void sendSpecificBagFull(long paramLong, int paramInt) {
/* 2241 */     sendWrongInfo(paramLong, 23, new String[] { String.valueOf(paramInt) });
/*      */   }
/*      */   
/*      */   public static List<Integer> getAllBagids() {
/* 2245 */     ArrayList localArrayList = new ArrayList();
/* 2246 */     localArrayList.add(Integer.valueOf(340600000));
/* 2247 */     localArrayList.add(Integer.valueOf(340600001));
/* 2248 */     localArrayList.add(Integer.valueOf(340600007));
/* 2249 */     localArrayList.add(Integer.valueOf(340600006));
/* 2250 */     localArrayList.add(Integer.valueOf(340600005));
/* 2251 */     localArrayList.add(Integer.valueOf(340600008));
/* 2252 */     localArrayList.add(Integer.valueOf(340600009));
/* 2253 */     return localArrayList;
/*      */   }
/*      */   
/*      */   public static Map<Integer, Integer> getWearPos2extraInfoValue(long paramLong, boolean paramBoolean, ItemStoreEnum paramItemStoreEnum) {
/* 2257 */     RoleEquipBag localRoleEquipBag = (RoleEquipBag)ItemManager.getBag(paramLong, 340600001, paramBoolean);
/* 2258 */     return getWearPos2extraInfoValue(localRoleEquipBag, paramItemStoreEnum);
/*      */   }
/*      */   
/*      */   public static Map<Integer, Integer> getWearPos2extraInfoValue(RoleEquipBag paramRoleEquipBag, ItemStoreEnum paramItemStoreEnum) {
/* 2262 */     HashMap localHashMap = new HashMap();
/* 2263 */     if (paramRoleEquipBag == null) {
/* 2264 */       return localHashMap;
/*      */     }
/* 2266 */     for (int i = 0; i <= 8; i++) {
/* 2267 */       BasicItem localBasicItem = paramRoleEquipBag.get(i);
/* 2268 */       if ((localBasicItem != null) && 
/* 2269 */         ((localBasicItem instanceof EquipmentItem))) {
/* 2270 */         Integer localInteger = localBasicItem.getExtra(paramItemStoreEnum);
/* 2271 */         localHashMap.put(Integer.valueOf(i), Integer.valueOf(localInteger == null ? 0 : localInteger.intValue()));
/*      */       }
/*      */     }
/*      */     
/* 2275 */     return localHashMap;
/*      */   }
/*      */   
/*      */   public static Map<Integer, List<Integer>> getWearPos2jewelCfgIdList(long paramLong, boolean paramBoolean) {
/* 2279 */     RoleEquipBag localRoleEquipBag = (RoleEquipBag)ItemManager.getBag(paramLong, 340600001, paramBoolean);
/* 2280 */     return getWearPos2jewelCfgIdList(localRoleEquipBag);
/*      */   }
/*      */   
/*      */   public static Map<Integer, List<Integer>> getWearPos2jewelCfgIdList(RoleEquipBag paramRoleEquipBag) {
/* 2284 */     HashMap localHashMap = new HashMap();
/* 2285 */     if (paramRoleEquipBag == null) {
/* 2286 */       return localHashMap;
/*      */     }
/* 2288 */     for (int i = 0; i <= 8; i++) {
/* 2289 */       BasicItem localBasicItem = paramRoleEquipBag.get(i);
/* 2290 */       if ((localBasicItem != null) && 
/* 2291 */         ((localBasicItem instanceof EquipmentItem))) {
/* 2292 */         localHashMap.put(Integer.valueOf(i), ItemManager.getJewelCfgIdList(localBasicItem.getJewelMap()));
/*      */       }
/*      */     }
/*      */     
/* 2296 */     return localHashMap;
/*      */   }
/*      */   
/*      */   public static int getItemSellGoldNum(int paramInt) {
/* 2300 */     return ItemConfigManager.getItemSellGoldNum(paramInt);
/*      */   }
/*      */   
/*      */   public static boolean addMoneyWithinMax(long paramLong, TLogArg paramTLogArg, int paramInt1, int paramInt2) {
/* 2304 */     return ItemManager.addMoneyWithinMax(paramLong, paramTLogArg, paramInt1, paramInt2);
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\ItemInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */