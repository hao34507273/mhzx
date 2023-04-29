/*     */ package mzm.gsp.superequipment.jewel.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.EquipmentItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.RoleEquipBag;
/*     */ import mzm.gsp.item.main.RoleItemBag;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.superequipment.SJewelError;
/*     */ import mzm.gsp.superequipment.confbean.SSuperEquipmentStageCfg;
/*     */ import mzm.gsp.superequipment.jewel.confbean.SSuperEquipmentJewelItem;
/*     */ import mzm.gsp.superequipment.jewel.confbean.STJewelCfgId2RefBaseLevelCfgIds;
/*     */ import mzm.gsp.superequipment.jewel.confbean.SuperEquipmentJewelConstants;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.JewelInfo;
/*     */ import xbean.JewelTransferInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2jeweltransferinfo;
/*     */ 
/*     */ public class SuperEquipmentJewelManager
/*     */ {
/*  38 */   static final Map<Integer, Double> yuanBaoMakeUpMoneyType2RateMap = new HashMap();
/*     */   
/*     */   static
/*     */   {
/*  42 */     initYuanBaoMakeUpMoneyType2RateMap();
/*     */   }
/*     */   
/*     */   private static void initYuanBaoMakeUpMoneyType2RateMap()
/*     */   {
/*  47 */     yuanBaoMakeUpMoneyType2RateMap.put(Integer.valueOf(3), Double.valueOf(10150.0D));
/*     */   }
/*     */   
/*     */ 
/*     */   static Boolean checkMoneyForRole(String userId, long roleId, int moneyType, long moneyToCut, Map<Integer, Long> moneyType2moneyCount)
/*     */   {
/*  53 */     long roleMoneyCount = getMoneyForRole(userId, roleId, moneyType) - ((Long)getValueFromMap(moneyType2moneyCount, moneyType, Long.valueOf(0L))).longValue();
/*  54 */     if (roleMoneyCount < moneyToCut)
/*     */     {
/*  56 */       GameServer.logger().error(String.format("[superequipmentjewel]SuperEquipmentJewelManager.checkMoneyForRole@ money not enough|roleid=%d|moneytype=%d|money=%d|moneyneed=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(moneyType), Long.valueOf(roleMoneyCount), Long.valueOf(moneyToCut) }));
/*     */       
/*     */ 
/*  59 */       return Boolean.valueOf(false);
/*     */     }
/*  61 */     return Boolean.valueOf(true);
/*     */   }
/*     */   
/*     */   static Boolean checkMoneyForRole(String userId, long roleId, int moneyType, long moneyToCut)
/*     */   {
/*  66 */     long roleMoneyCount = getMoneyForRole(userId, roleId, moneyType);
/*  67 */     if (roleMoneyCount < moneyToCut)
/*     */     {
/*  69 */       GameServer.logger().error(String.format("[superequipmentjewel]SuperEquipmentJewelManager.checkMoneyForRole@ money not enough|roleid=%d|moneytype=%d|money=%d|moneyneed=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(moneyType), Long.valueOf(roleMoneyCount), Long.valueOf(moneyToCut) }));
/*     */       
/*     */ 
/*  72 */       return Boolean.valueOf(false);
/*     */     }
/*  74 */     return Boolean.valueOf(true);
/*     */   }
/*     */   
/*     */   static long getMoneyForRole(String userId, long roleId, int moneyType)
/*     */   {
/*  79 */     switch (moneyType)
/*     */     {
/*     */     case 3: 
/*  82 */       return RoleInterface.getSilver(roleId);
/*     */     case 2: 
/*  84 */       return RoleInterface.getGold(roleId);
/*     */     case 5: 
/*  86 */       return RoleInterface.getGoldIngot(roleId);
/*     */     case 1: 
/*  88 */       return QingfuInterface.getBalance(userId, true);
/*     */     case 4: 
/*  90 */       return GangInterface.getBangGong(roleId);
/*     */     }
/*  92 */     return 0L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static boolean cutMoney(String userId, long roleId, LogReason logReason, int subReason, int moneyType, int moneyToCut, CostType costType)
/*     */   {
/*  99 */     TLogArg logArg = new TLogArg(logReason, subReason);
/* 100 */     switch (moneyType)
/*     */     {
/*     */     case 3: 
/* 103 */       if (!RoleInterface.cutSilver(roleId, moneyToCut, logArg))
/*     */       {
/* 105 */         return false;
/*     */       }
/*     */       break;
/*     */     case 2: 
/* 109 */       if (!RoleInterface.cutGold(roleId, moneyToCut, logArg))
/*     */       {
/* 111 */         return false;
/*     */       }
/*     */       break;
/*     */     case 5: 
/* 115 */       if (!RoleInterface.cutGoldIngot(roleId, moneyToCut, logArg))
/*     */       {
/* 117 */         return false;
/*     */       }
/*     */       break;
/*     */     case 1: 
/* 121 */       CostResult costResult = QingfuInterface.costYuanbao(userId, roleId, moneyToCut, costType, logArg);
/* 122 */       if (costResult != CostResult.Success)
/*     */       {
/* 124 */         return false;
/*     */       }
/*     */       break;
/*     */     case 4: 
/* 128 */       if (!GangInterface.cutBangGong(roleId, moneyToCut, logArg))
/*     */       {
/* 130 */         return false;
/*     */       }
/*     */       break;
/*     */     default: 
/* 134 */       return false;
/*     */     }
/* 136 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static boolean cutMoney(String userId, long roleId, LogReason logReason, int subReason, Map<Integer, Long> moneyType2moneyCount, CostType costType)
/*     */   {
/* 143 */     for (Map.Entry<Integer, Long> entry : moneyType2moneyCount.entrySet())
/*     */     {
/* 145 */       boolean ret = cutMoney(userId, roleId, logReason, subReason, ((Integer)entry.getKey()).intValue(), ((Long)entry.getValue()).intValue(), costType);
/* 146 */       if (!ret)
/*     */       {
/* 148 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 152 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Map<Integer, List<EquipmentItem>>> getAllSuperEquipment(long roleId)
/*     */   {
/* 163 */     Map<Integer, Map<Integer, List<EquipmentItem>>> bagId2wearPos2equipments = new HashMap();
/*     */     
/* 165 */     RoleItemBag roleItemBag = ItemInterface.getRoleItemBag(roleId);
/* 166 */     Map<Integer, BasicItem> grid2Item = roleItemBag.getAllItems(false);
/* 167 */     getSuperEquipmentFromMap(340600000, bagId2wearPos2equipments, grid2Item);
/*     */     
/* 169 */     RoleEquipBag equipbag = ItemInterface.getRoleEquipBag(roleId);
/* 170 */     grid2Item = equipbag.getAllItems(false);
/* 171 */     getSuperEquipmentFromMap(340600001, bagId2wearPos2equipments, grid2Item);
/*     */     
/* 173 */     return bagId2wearPos2equipments;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void getSuperEquipmentFromMap(int bagId, Map<Integer, Map<Integer, List<EquipmentItem>>> bagId2wearPos2equipments, Map<Integer, BasicItem> grid2Item)
/*     */   {
/* 183 */     for (Map.Entry<Integer, BasicItem> entry : grid2Item.entrySet())
/*     */     {
/* 185 */       if ((entry.getValue() instanceof EquipmentItem))
/*     */       {
/* 187 */         EquipmentItem equipmentItem = (EquipmentItem)entry.getValue();
/* 188 */         if (equipmentItem.getSuperEquipmentStage() > 0) { Map<Integer, List<EquipmentItem>> wearPos2equipments;
/*     */           Map<Integer, List<EquipmentItem>> wearPos2equipments;
/* 190 */           if (bagId2wearPos2equipments.containsKey(Integer.valueOf(bagId)))
/*     */           {
/* 192 */             wearPos2equipments = (Map)bagId2wearPos2equipments.get(Integer.valueOf(bagId));
/*     */           }
/*     */           else
/*     */           {
/* 196 */             wearPos2equipments = new HashMap();
/* 197 */             bagId2wearPos2equipments.put(Integer.valueOf(bagId), wearPos2equipments);
/*     */           }
/* 199 */           int wearPos = ItemInterface.getEquipWearpos(equipmentItem.getCfgId());
/* 200 */           List<EquipmentItem> equipmentItems; List<EquipmentItem> equipmentItems; if (wearPos2equipments.containsKey(Integer.valueOf(wearPos)))
/*     */           {
/* 202 */             equipmentItems = (List)wearPos2equipments.get(Integer.valueOf(wearPos));
/*     */           }
/*     */           else
/*     */           {
/* 206 */             equipmentItems = new ArrayList();
/* 207 */             wearPos2equipments.put(Integer.valueOf(wearPos), equipmentItems);
/*     */           }
/* 209 */           equipmentItems.add(equipmentItem);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static int getJewelMaxLevel(long roleId, int jewelType)
/*     */   {
/* 217 */     int maxLevel = SSuperEquipmentStageCfg.get(1).maxGemLevel;
/*     */     
/* 219 */     Map<Integer, Map<Integer, List<EquipmentItem>>> bagId2wearPos2equipments = getAllSuperEquipment(roleId);
/*     */     
/*     */ 
/*     */ 
/* 223 */     Map<Integer, List<EquipmentItem>> wearPos2equipments = (Map)bagId2wearPos2equipments.get(Integer.valueOf(340600001));
/* 224 */     if (wearPos2equipments != null)
/*     */     {
/* 226 */       List<EquipmentItem> equipmentItems = (List)wearPos2equipments.get(Integer.valueOf(jewelType));
/* 227 */       if (equipmentItems != null)
/*     */       {
/* 229 */         return SSuperEquipmentStageCfg.get(((EquipmentItem)equipmentItems.get(0)).getSuperEquipmentStage()).maxGemLevel;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 234 */     wearPos2equipments = (Map)bagId2wearPos2equipments.get(Integer.valueOf(340600000));
/* 235 */     if (wearPos2equipments != null)
/*     */     {
/* 237 */       List<EquipmentItem> equipmentItems = (List)wearPos2equipments.get(Integer.valueOf(jewelType));
/* 238 */       if (equipmentItems != null)
/*     */       {
/*     */ 
/* 241 */         int minStage = Integer.MAX_VALUE;
/*     */         
/* 243 */         for (EquipmentItem equipmentItem : equipmentItems)
/*     */         {
/* 245 */           int stage = equipmentItem.getSuperEquipmentStage();
/* 246 */           if (stage < minStage)
/*     */           {
/* 248 */             minStage = stage;
/*     */           }
/*     */         }
/* 251 */         maxLevel = SSuperEquipmentStageCfg.get(minStage).maxGemLevel;
/*     */       }
/*     */     }
/* 254 */     return maxLevel;
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
/*     */ 
/*     */   static boolean getComposeJewelCost(String userId, long roleId, int jewelcfgid, Map<Integer, Integer> cfgItemId2countToRemove, Map<Integer, Long> moneyType2moneyCount, int countFix)
/*     */   {
/* 275 */     SSuperEquipmentJewelItem cfgJewelItem = SSuperEquipmentJewelItem.get(jewelcfgid);
/*     */     
/*     */ 
/* 278 */     int craftNextLevelCount = cfgJewelItem.craftNextLevelCount + countFix;
/* 279 */     int jewelCountInBag = ItemInterface.getItemNumberById(roleId, jewelcfgid);
/* 280 */     if (jewelCountInBag < craftNextLevelCount)
/*     */     {
/* 282 */       GameServer.logger().error(String.format("[superequipmentjewel]SuperEquipmentJewelManager.processImp@ material:jewel not enough |roleid=%d|jewelcfgid=%d|craftNextLevelCount=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(jewelcfgid), Integer.valueOf(craftNextLevelCount) }));
/*     */       
/*     */ 
/* 285 */       OnlineManager.getInstance().sendAtOnce(roleId, new SJewelError(1));
/* 286 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 290 */     SItemCfg itemCfg = SItemCfg.get(cfgJewelItem.craftNextLevelItemId);
/* 291 */     if ((itemCfg != null) && (cfgJewelItem.craftNextLevelItemCount > 0))
/*     */     {
/* 293 */       int otherItemCountInBag = ItemInterface.getItemNumberById(roleId, cfgJewelItem.craftNextLevelItemId);
/* 294 */       if (otherItemCountInBag < cfgJewelItem.craftNextLevelItemCount)
/*     */       {
/* 296 */         GameServer.logger().error(String.format("[superequipmentjewel]SuperEquipmentJewelManager.processImp@ material:other item  not enough |roleid=%d|jewelcfgid=%d|itemcfgid=%d|itemcount=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(jewelcfgid), Integer.valueOf(cfgJewelItem.craftNextLevelItemId), Integer.valueOf(cfgJewelItem.craftNextLevelItemCount) }));
/*     */         
/*     */ 
/* 299 */         OnlineManager.getInstance().sendAtOnce(roleId, new SJewelError(1));
/* 300 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 305 */     if (cfgJewelItem.craftNextLevelMoneyCount > 0)
/*     */     {
/* 307 */       boolean moneyRet = checkMoneyForRole(userId, roleId, cfgJewelItem.craftNextLevelMoneyType, cfgJewelItem.craftNextLevelMoneyCount).booleanValue();
/*     */       
/* 309 */       if (!moneyRet)
/*     */       {
/* 311 */         GameServer.logger().error(String.format("[superequipmentjewel]SuperEquipmentJewelManager.processImp@ material:money not enough |roleid=%d|jewelcfgid=%d|moneytype=%d|moneytocut=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(jewelcfgid), Integer.valueOf(cfgJewelItem.craftNextLevelMoneyType), Integer.valueOf(cfgJewelItem.craftNextLevelMoneyCount) }));
/*     */         
/*     */ 
/* 314 */         OnlineManager.getInstance().sendAtOnce(roleId, new SJewelError(1));
/* 315 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 319 */     if (craftNextLevelCount > 0)
/*     */     {
/* 321 */       cfgItemId2countToRemove.put(Integer.valueOf(jewelcfgid), Integer.valueOf(craftNextLevelCount));
/*     */     }
/*     */     
/* 324 */     if ((itemCfg != null) && (cfgJewelItem.craftNextLevelItemCount > 0))
/*     */     {
/* 326 */       cfgItemId2countToRemove.put(Integer.valueOf(cfgJewelItem.craftNextLevelItemId), Integer.valueOf(cfgJewelItem.craftNextLevelItemCount));
/*     */     }
/* 328 */     if (cfgJewelItem.craftNextLevelMoneyCount > 0)
/*     */     {
/* 330 */       moneyType2moneyCount.put(Integer.valueOf(cfgJewelItem.craftNextLevelMoneyType), Long.valueOf(cfgJewelItem.craftNextLevelMoneyCount));
/*     */     }
/* 332 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean deleteItemAndCutMoney(String userId, long roleId, int jewelcfgid, Map<Integer, Integer> cfgItemId2countToRemove, Map<Integer, Long> moneyType2moneyCount)
/*     */   {
/* 338 */     SSuperEquipmentJewelItem cfgJewelItem = SSuperEquipmentJewelItem.get(jewelcfgid);
/*     */     
/* 340 */     ItemOperateResult itemOperateResult = ItemInterface.removeItemById(roleId, cfgItemId2countToRemove, new TLogArg(LogReason.SUPER_EQUIPMENT_JEWEL_COMPOSE));
/*     */     
/* 342 */     if (!itemOperateResult.success())
/*     */     {
/* 344 */       GameServer.logger().error(String.format("[superequipmentjewel]SuperEquipmentJewelManager.processImp@ remove jewel fail |roleid=%d|jewelcfgid=%d|cfgItemId2countToRemove=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(jewelcfgid), cfgItemId2countToRemove.toString() }));
/*     */       
/*     */ 
/* 347 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 351 */     boolean moneyRet = cutMoney(userId, roleId, LogReason.SUPER_EQUIPMENT_JEWEL_COMPOSE_COST, jewelcfgid, moneyType2moneyCount, CostType.COST_BIND_FIRST_SUPER_EQUIPMENT_JEWEL_COMPOSE);
/*     */     
/* 353 */     if (!moneyRet)
/*     */     {
/* 355 */       GameServer.logger().error(String.format("[superequipmentjewel]SuperEquipmentJewelManager.processImp@ cut money fail |roleid=%d|jewelcfgid=%d|moneytype=%d|moneytocut=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(jewelcfgid), Integer.valueOf(cfgJewelItem.craftNextLevelMoneyType), Integer.valueOf(cfgJewelItem.craftNextLevelMoneyCount) }));
/*     */       
/*     */ 
/* 358 */       OnlineManager.getInstance().sendAtOnce(roleId, new SJewelError(1));
/* 359 */       return false;
/*     */     }
/* 361 */     return true;
/*     */   }
/*     */   
/*     */   static Map<Integer, Integer> getSlotIndex2JewelCfgId(Map<Integer, JewelInfo> jewelMap)
/*     */   {
/* 366 */     Map<Integer, Integer> result = new HashMap();
/* 367 */     for (Map.Entry<Integer, JewelInfo> entry : jewelMap.entrySet())
/*     */     {
/* 369 */       result.put(entry.getKey(), Integer.valueOf(((JewelInfo)entry.getValue()).getJewelcfgid()));
/*     */     }
/* 371 */     return result;
/*     */   }
/*     */   
/*     */   static <T> T getValueFromMap(Map<Integer, T> map, int key, T defaultV) {
/*     */     T value;
/*     */     T value;
/* 377 */     if (map.containsKey(Integer.valueOf(key)))
/*     */     {
/* 379 */       value = map.get(Integer.valueOf(key));
/*     */     }
/*     */     else
/*     */     {
/* 383 */       value = defaultV;
/*     */     }
/* 385 */     return value;
/*     */   }
/*     */   
/*     */   static void addValueToMap(Map<Integer, Integer> map, int key, int valueToAdd) {
/*     */     int count;
/*     */     int count;
/* 391 */     if (map.containsKey(Integer.valueOf(key)))
/*     */     {
/* 393 */       count = ((Integer)map.get(Integer.valueOf(key))).intValue();
/*     */     }
/*     */     else
/*     */     {
/* 397 */       count = 0;
/*     */     }
/* 399 */     count += valueToAdd;
/* 400 */     map.put(Integer.valueOf(key), Integer.valueOf(count));
/*     */   }
/*     */   
/*     */   static void addValueToMap(Map<Integer, Long> map, int key, long valueToAdd) {
/*     */     long count;
/*     */     long count;
/* 406 */     if (map.containsKey(Integer.valueOf(key)))
/*     */     {
/* 408 */       count = ((Long)map.get(Integer.valueOf(key))).longValue();
/*     */     }
/*     */     else
/*     */     {
/* 412 */       count = 0L;
/*     */     }
/* 414 */     count += valueToAdd;
/* 415 */     map.put(Integer.valueOf(key), Long.valueOf(count));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void initTransferCount(long roleId)
/*     */   {
/* 425 */     JewelTransferInfo xJewelTransferInfo = Role2jeweltransferinfo.get(Long.valueOf(roleId));
/* 426 */     if (xJewelTransferInfo == null)
/*     */     {
/* 428 */       xJewelTransferInfo = Pod.newJewelTransferInfo();
/* 429 */       Role2jeweltransferinfo.insert(Long.valueOf(roleId), xJewelTransferInfo);
/*     */     }
/* 431 */     xJewelTransferInfo.setCount(0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getAvailableTransferCount(long roleId)
/*     */   {
/* 441 */     JewelTransferInfo xJewelTransferInfo = Role2jeweltransferinfo.get(Long.valueOf(roleId));
/* 442 */     if (xJewelTransferInfo == null)
/*     */     {
/* 444 */       return 0;
/*     */     }
/* 446 */     return SuperEquipmentJewelConstants.getInstance().MAX_TRANSFER_COUNT - xJewelTransferInfo.getCount();
/*     */   }
/*     */   
/*     */   static float getJewelTransferBasePrice(int jewelCfgId)
/*     */   {
/* 451 */     SSuperEquipmentJewelItem jewelItem = SSuperEquipmentJewelItem.get(jewelCfgId);
/* 452 */     if (jewelItem == null)
/*     */     {
/* 454 */       return -1.0F;
/*     */     }
/* 456 */     List<Integer> refBaseLevelCfgIds = STJewelCfgId2RefBaseLevelCfgIds.get(jewelCfgId).refBaseLevelCfgIds;
/* 457 */     if (refBaseLevelCfgIds.isEmpty())
/*     */     {
/* 459 */       return -1.0F;
/*     */     }
/*     */     
/*     */ 
/* 463 */     float total = 0.0F;
/* 464 */     for (Iterator i$ = refBaseLevelCfgIds.iterator(); i$.hasNext();) { int cfgId = ((Integer)i$.next()).intValue();
/*     */       
/* 466 */       jewelItem = SSuperEquipmentJewelItem.get(cfgId);
/* 467 */       if ((jewelItem == null) || (jewelItem.jewelLevel - 1 < 0))
/*     */       {
/* 469 */         return -1.0F;
/*     */       }
/* 471 */       float shangHuiPrice = mzm.gsp.shanghui.main.ShanghuiInterface.getItemPrice(cfgId);
/* 472 */       if (shangHuiPrice <= 0.0F)
/*     */       {
/* 474 */         return -1.0F;
/*     */       }
/* 476 */       total = (float)(total + shangHuiPrice / Math.pow(2.0D, jewelItem.jewelLevel - 1));
/*     */     }
/* 478 */     return total / refBaseLevelCfgIds.size();
/*     */   }
/*     */   
/*     */   static boolean checkJewelLevel(SSuperEquipmentJewelItem fromJewelItem, SSuperEquipmentJewelItem toJewelItem)
/*     */   {
/* 483 */     if (fromJewelItem.jewelLevel != toJewelItem.jewelLevel)
/*     */     {
/* 485 */       return false;
/*     */     }
/* 487 */     if (fromJewelItem.jewelLevel < SuperEquipmentJewelConstants.getInstance().TRANSFER_MIN_JEWEL_LEVEL)
/*     */     {
/* 489 */       return false;
/*     */     }
/* 491 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\jewel\main\SuperEquipmentJewelManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */