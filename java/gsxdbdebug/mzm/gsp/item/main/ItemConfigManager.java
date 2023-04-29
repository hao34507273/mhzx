/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.bag.confbean.SBagCfg;
/*     */ import mzm.gsp.bag.confbean.SBagidExpendcount2Itemcount;
/*     */ import mzm.gsp.bag.confbean.SStorageCfg;
/*     */ import mzm.gsp.item.confbean.EquipItemCfgConsts;
/*     */ import mzm.gsp.item.confbean.EquipSkillWeight;
/*     */ import mzm.gsp.item.confbean.ItemId2ExchangeCfgId;
/*     */ import mzm.gsp.item.confbean.Property2Param;
/*     */ import mzm.gsp.item.confbean.SAirCraftItem;
/*     */ import mzm.gsp.item.confbean.SAllEquipQilinpPropertyCfg;
/*     */ import mzm.gsp.item.confbean.SBaoshiduItem;
/*     */ import mzm.gsp.item.confbean.SEquipMaterialItem;
/*     */ import mzm.gsp.item.confbean.SEquipQiLinCfg;
/*     */ import mzm.gsp.item.confbean.SEquipSkillCfg;
/*     */ import mzm.gsp.item.confbean.SEquipTransferInherit;
/*     */ import mzm.gsp.item.confbean.SGoldRecycleCfg;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.confbean.SItemDrugInFightCfg;
/*     */ import mzm.gsp.item.confbean.SItemDrugOutFightCfg;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.item.confbean.SItemPriceCfg;
/*     */ import mzm.gsp.item.confbean.SItemSellAllCfg;
/*     */ import mzm.gsp.item.confbean.SItemTypeCfg;
/*     */ import mzm.gsp.item.confbean.SPetLifeItem;
/*     */ import mzm.gsp.item.confbean.SServerlevel2YuanbaoExchange;
/*     */ import mzm.gsp.item.confbean.YuanbaoExchange;
/*     */ import xdb.Tables;
/*     */ import xdb.Xdb;
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
/*     */ class ItemConfigManager
/*     */ {
/*     */   private static ItemConfigManager instance;
/*     */   
/*     */   static ItemConfigManager getInstance()
/*     */   {
/*  60 */     if (instance == null)
/*     */     {
/*  62 */       instance = new ItemConfigManager();
/*     */     }
/*  64 */     return instance;
/*     */   }
/*     */   
/*     */   void init()
/*     */   {
/*  69 */     initCfg();
/*  70 */     EquipmentLogStatus.checkEquipmengLogStatus();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initCfg()
/*     */   {
/*  81 */     for (SBagCfg bagCfg : SBagCfg.getAll().values())
/*     */     {
/*     */ 
/*  84 */       if (Xdb.getInstance().getTables().getTable(bagCfg.classname.trim()) == null)
/*     */       {
/*  86 */         throw new RuntimeException("包裹实现类不存在!" + bagCfg.classname);
/*     */       }
/*     */       
/*  89 */       if (bagCfg.id == 340600000)
/*     */       {
/*  91 */         if (SItemCfg.get(bagCfg.expendItemId).type != 49)
/*     */         {
/*  93 */           throw new RuntimeException("包裹配置的扩充包裹物品的类型错误!" + bagCfg.id);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  98 */     if (SBagCfg.get(340600000) == null)
/*     */     {
/* 100 */       throw new RuntimeException("BagInfo.BAG 包裹id不存在340600000");
/*     */     }
/* 102 */     if (SBagCfg.get(340600001) == null)
/*     */     {
/* 104 */       throw new RuntimeException("BagInfo.EQUIPBAG 装备包裹id不存在340600001");
/*     */     }
/*     */     
/* 107 */     for (SStorageCfg storageCfg : SStorageCfg.getAll().values())
/*     */     {
/* 109 */       if (Xdb.getInstance().getTables().getTable(storageCfg.classname.trim()) == null)
/*     */       {
/* 111 */         throw new RuntimeException("包裹实现类不存在!" + storageCfg.classname + " id=" + storageCfg.id);
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
/*     */ 
/*     */ 
/*     */   static int getItemSellGoldNum(int itemid)
/*     */   {
/* 126 */     SGoldRecycleCfg s = SGoldRecycleCfg.get(itemid);
/*     */     
/* 128 */     if (s == null)
/*     */     {
/* 130 */       return -1;
/*     */     }
/* 132 */     return s.goldnum;
/*     */   }
/*     */   
/*     */   static boolean canSellAll(int itemid)
/*     */   {
/* 137 */     return SItemSellAllCfg.get(itemid) != null;
/*     */   }
/*     */   
/*     */ 
/*     */   static SEquipQiLinCfg getSEquipQiLin(int qilinTypeid, int strenghLevel)
/*     */   {
/* 143 */     for (SEquipQiLinCfg equipQiLinCfg : SEquipQiLinCfg.getAll().values())
/*     */     {
/* 145 */       if ((equipQiLinCfg.qilinTypeid == qilinTypeid) && (equipQiLinCfg.strengthLevel == strenghLevel))
/*     */       {
/* 147 */         return equipQiLinCfg;
/*     */       }
/*     */     }
/*     */     
/* 151 */     return null;
/*     */   }
/*     */   
/*     */   static SEquipTransferInherit getSEquipTransferHun(int equipMentLevel)
/*     */   {
/* 156 */     return SEquipTransferInherit.get(equipMentLevel);
/*     */   }
/*     */   
/*     */ 
/*     */   static SItemPriceCfg getSItemPriceCfg(int itemId)
/*     */   {
/* 162 */     return SItemPriceCfg.get(itemId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getItemTypeById(int itemtypeid)
/*     */   {
/* 174 */     for (SItemTypeCfg itemTypeCfg : SItemTypeCfg.getAll().values())
/*     */     {
/* 176 */       if (itemTypeCfg.id == itemtypeid)
/*     */       {
/* 178 */         return itemTypeCfg.itemType;
/*     */       }
/*     */     }
/*     */     
/* 182 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getBagSort(int itemtype)
/*     */   {
/* 193 */     SItemTypeCfg itemTypeCfg = SItemTypeCfg.get(itemtype);
/* 194 */     if (itemTypeCfg == null)
/*     */     {
/* 196 */       return -1;
/*     */     }
/* 198 */     return itemTypeCfg.bagsort;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getItemTypeByItemId(int itemId)
/*     */   {
/* 209 */     if (SItemCfg.get(itemId) == null)
/*     */     {
/*     */ 
/* 212 */       return -1;
/*     */     }
/* 214 */     return SItemCfg.get(itemId).type;
/*     */   }
/*     */   
/*     */   static boolean isCanGive(int itemid)
/*     */   {
/* 219 */     SItemCfg itemCfg = SItemCfg.get(itemid);
/*     */     
/* 221 */     if (itemCfg == null)
/*     */     {
/* 223 */       return false;
/*     */     }
/* 225 */     int itemtype = itemCfg.type;
/* 226 */     SItemTypeCfg itemTypeCfg = SItemTypeCfg.get(itemtype);
/* 227 */     if (itemTypeCfg == null)
/*     */     {
/* 229 */       return false;
/*     */     }
/* 231 */     return itemTypeCfg.canGive;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isProprietary(int itemid)
/*     */   {
/* 242 */     if (SItemCfg.get(itemid) == null)
/*     */     {
/* 244 */       return false;
/*     */     }
/* 246 */     return SItemCfg.get(itemid).isProprietary;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getUseLevel(int itemid)
/*     */   {
/* 257 */     if (SItemCfg.get(itemid) == null)
/*     */     {
/* 259 */       return -1;
/*     */     }
/* 261 */     return SItemCfg.get(itemid).useLevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getColor(int itemid)
/*     */   {
/* 272 */     if (SItemCfg.get(itemid) == null)
/*     */     {
/* 274 */       return -1;
/*     */     }
/* 276 */     return SItemCfg.get(itemid).namecolor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<Integer> getEquipMaterialItem(int level, int materialType, int wearpos)
/*     */   {
/* 287 */     List<SEquipMaterialItem> ids = new ArrayList();
/* 288 */     for (SEquipMaterialItem equipMaterialItem : SEquipMaterialItem.getAllSelf().values())
/*     */     {
/* 290 */       if ((equipMaterialItem.level >= level) && (equipMaterialItem.materialType == materialType) && (equipMaterialItem.wearpos == wearpos))
/*     */       {
/*     */ 
/*     */ 
/* 294 */         ids.add(equipMaterialItem);
/*     */       }
/*     */     }
/* 297 */     Collections.sort(ids, new Comparator()
/*     */     {
/*     */ 
/*     */       public int compare(SEquipMaterialItem o1, SEquipMaterialItem o2)
/*     */       {
/*     */ 
/* 303 */         return o1.level - o2.level;
/*     */       }
/* 305 */     });
/* 306 */     List<Integer> resuList = new ArrayList();
/* 307 */     for (int i = 0; i < ids.size(); i++)
/*     */     {
/* 309 */       resuList.add(Integer.valueOf(((SEquipMaterialItem)ids.get(i)).id));
/*     */     }
/* 311 */     return resuList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getExpendNeedItemnum(int bagid, int expendCount)
/*     */   {
/* 323 */     SBagidExpendcount2Itemcount bagidExpendcount2Itemcount = SBagidExpendcount2Itemcount.get(bagid);
/* 324 */     if (bagidExpendcount2Itemcount == null)
/*     */     {
/* 326 */       return -1;
/*     */     }
/* 328 */     Integer itemcount = (Integer)bagidExpendcount2Itemcount.expendcount2itemcount.get(Integer.valueOf(expendCount));
/*     */     
/* 330 */     if (itemcount == null)
/*     */     {
/* 332 */       return -1;
/*     */     }
/* 334 */     return itemcount.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isCanPile(int itemId)
/*     */   {
/* 345 */     SItemCfg itemCfg = SItemCfg.get(itemId);
/* 346 */     return itemCfg.pilemax > 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getPileMaxCount(int itemId)
/*     */   {
/* 357 */     SItemCfg itemCfg = SItemCfg.get(itemId);
/* 358 */     if (itemCfg == null)
/*     */     {
/* 360 */       return 0;
/*     */     }
/* 362 */     return SItemCfg.get(itemId).pilemax;
/*     */   }
/*     */   
/*     */   static int getEquipWearpos(int itemId)
/*     */   {
/* 367 */     if (SItemEquipCfg.get(itemId) == null)
/*     */     {
/* 369 */       return -1;
/*     */     }
/* 371 */     return SItemEquipCfg.get(itemId).wearpos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getExchangeCfgIdByItemId(int itemid)
/*     */   {
/* 382 */     ItemId2ExchangeCfgId i = ItemId2ExchangeCfgId.get(itemid);
/* 383 */     if (i == null)
/*     */     {
/* 385 */       return -1;
/*     */     }
/* 387 */     return i.exchangecfgid;
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
/*     */   static int getExchangeValue(int moneytype, int needyuanbao, int serverlevel)
/*     */   {
/* 401 */     SServerlevel2YuanbaoExchange s = SServerlevel2YuanbaoExchange.get(serverlevel);
/* 402 */     if (s == null)
/*     */     {
/* 404 */       return -1;
/*     */     }
/* 406 */     YuanbaoExchange yuanbaoExchange = (YuanbaoExchange)s.type2YuanbaoExchange.get(Integer.valueOf(moneytype));
/* 407 */     if (yuanbaoExchange == null)
/*     */     {
/* 409 */       return -1;
/*     */     }
/* 411 */     Integer value = (Integer)yuanbaoExchange.yuanbao2value.get(Integer.valueOf(needyuanbao));
/* 412 */     if (value == null)
/*     */     {
/* 414 */       return -1;
/*     */     }
/* 416 */     return value.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getItemPro(int itemid)
/*     */   {
/* 428 */     if (SItemDrugInFightCfg.get(itemid) != null)
/*     */     {
/* 430 */       return SItemDrugInFightCfg.get(itemid).drugPro;
/*     */     }
/* 432 */     if (SBaoshiduItem.get(itemid) != null)
/*     */     {
/* 434 */       return SBaoshiduItem.get(itemid).drugPro;
/*     */     }
/* 436 */     if (SPetLifeItem.get(itemid) != null)
/*     */     {
/* 438 */       return SPetLifeItem.get(itemid).itemPro;
/*     */     }
/* 440 */     if (SPetLifeItem.get(itemid) != null)
/*     */     {
/* 442 */       return SPetLifeItem.get(itemid).itemPro;
/*     */     }
/* 444 */     if (SItemDrugOutFightCfg.get(itemid) != null)
/*     */     {
/* 446 */       return SItemDrugOutFightCfg.get(itemid).drugPro;
/*     */     }
/* 448 */     return -1;
/*     */   }
/*     */   
/*     */   static int getStorageid(int index)
/*     */   {
/* 453 */     List<Integer> storageidList = getAllStorageids();
/* 454 */     if ((index < 0) || (index >= storageidList.size()))
/*     */     {
/* 456 */       return -1;
/*     */     }
/* 458 */     return ((Integer)storageidList.get(index)).intValue();
/*     */   }
/*     */   
/*     */   static List<Integer> getDefaultStorageid()
/*     */   {
/* 463 */     List<Integer> result = new ArrayList();
/* 464 */     for (Iterator i$ = getAllStorageids().iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/*     */       
/* 466 */       SStorageCfg sStorageCfg = SStorageCfg.get(id);
/* 467 */       if (sStorageCfg.isopen)
/*     */       {
/* 469 */         result.add(Integer.valueOf(sStorageCfg.id));
/*     */       }
/*     */     }
/* 472 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   static List<Integer> getAllStorageids()
/*     */   {
/* 478 */     List<Integer> storageidList = new ArrayList(SStorageCfg.getAll().keySet());
/*     */     
/* 480 */     Collections.sort(storageidList);
/* 481 */     return storageidList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getFeijianId(int aircraftid)
/*     */   {
/* 492 */     SAirCraftItem airCraftItem = SAirCraftItem.get(aircraftid);
/* 493 */     if (airCraftItem == null)
/*     */     {
/* 495 */       return -1;
/*     */     }
/* 497 */     return airCraftItem.aircraftid;
/*     */   }
/*     */   
/*     */   static int randomEquipSkill(int equipSkillCfgid)
/*     */   {
/* 502 */     SEquipSkillCfg cfg = SEquipSkillCfg.get(equipSkillCfgid);
/* 503 */     if ((cfg == null) || (cfg.skills.isEmpty()))
/*     */     {
/* 505 */       return -1;
/*     */     }
/*     */     
/* 508 */     int sumWeight = ((EquipSkillWeight)cfg.skills.get(cfg.skills.size() - 1)).weight;
/* 509 */     if (sumWeight <= 0)
/*     */     {
/* 511 */       return -1;
/*     */     }
/* 513 */     int w = Xdb.random().nextInt(sumWeight);
/* 514 */     for (EquipSkillWeight weight : cfg.skills)
/*     */     {
/* 516 */       if (w < weight.weight)
/*     */       {
/* 518 */         return weight.skillid;
/*     */       }
/*     */     }
/* 521 */     return -1;
/*     */   }
/*     */   
/*     */   static int randomEquipSkill(int equipSkillCfgid, Set<Integer> toRemoveSkillIds)
/*     */   {
/* 526 */     SEquipSkillCfg cfg = SEquipSkillCfg.get(equipSkillCfgid);
/* 527 */     if ((cfg == null) || (cfg.skills.isEmpty()))
/*     */     {
/* 529 */       return -1;
/*     */     }
/* 531 */     List<EquipSkillWeight> equipSkillWeights = new ArrayList(cfg.skills.size());
/* 532 */     for (EquipSkillWeight e : cfg.skills)
/*     */     {
/* 534 */       EquipSkillWeight a = new EquipSkillWeight();
/* 535 */       a.skillid = e.skillid;
/* 536 */       a.weight = e.weight;
/* 537 */       equipSkillWeights.add(a);
/*     */     }
/*     */     
/* 540 */     List<Integer> toRemoveIndex = new ArrayList();
/* 541 */     for (Iterator i$ = toRemoveSkillIds.iterator(); i$.hasNext();) { int toRemoveSkillId = ((Integer)i$.next()).intValue();
/*     */       
/* 543 */       for (int i = 0; i < equipSkillWeights.size(); i++)
/*     */       {
/* 545 */         if (((EquipSkillWeight)equipSkillWeights.get(i)).skillid == toRemoveSkillId)
/*     */         {
/* 547 */           toRemoveIndex.add(Integer.valueOf(i));
/* 548 */           break;
/*     */         }
/*     */       }
/*     */     }
/* 552 */     Collections.sort(toRemoveIndex);
/* 553 */     for (Iterator i$ = toRemoveIndex.iterator(); i$.hasNext();) { int k = ((Integer)i$.next()).intValue();
/*     */       
/* 555 */       int toCutWieght = k == 0 ? ((EquipSkillWeight)equipSkillWeights.get(k)).weight : ((EquipSkillWeight)equipSkillWeights.get(k)).weight - ((EquipSkillWeight)equipSkillWeights.get(k - 1)).weight;
/*     */       
/* 557 */       for (int i = k + 1; i < equipSkillWeights.size(); i++)
/*     */       {
/* 559 */         ((EquipSkillWeight)equipSkillWeights.get(i)).weight -= toCutWieght;
/*     */       }
/*     */     }
/* 562 */     for (int i = toRemoveIndex.size() - 1; i >= 0; i--)
/*     */     {
/* 564 */       equipSkillWeights.remove(((Integer)toRemoveIndex.get(i)).intValue());
/*     */     }
/*     */     
/* 567 */     if (equipSkillWeights.isEmpty())
/*     */     {
/* 569 */       return -1;
/*     */     }
/*     */     
/* 572 */     int sumWeight = ((EquipSkillWeight)equipSkillWeights.get(equipSkillWeights.size() - 1)).weight;
/* 573 */     if (sumWeight <= 0)
/*     */     {
/* 575 */       return -1;
/*     */     }
/*     */     
/* 578 */     int w = Xdb.random().nextInt(sumWeight);
/* 579 */     for (EquipSkillWeight weight : equipSkillWeights)
/*     */     {
/* 581 */       if (w < weight.weight)
/*     */       {
/* 583 */         return weight.skillid;
/*     */       }
/*     */     }
/* 586 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean isEquipItem(int itemId)
/*     */   {
/* 592 */     return SItemEquipCfg.get(itemId) != null;
/*     */   }
/*     */   
/*     */   static String getItemName(int itemid)
/*     */   {
/* 597 */     if (SItemCfg.get(itemid) == null)
/*     */     {
/* 599 */       return "";
/*     */     }
/* 601 */     return SItemCfg.get(itemid).name;
/*     */   }
/*     */   
/*     */   static int getWearPos(int itemid)
/*     */   {
/* 606 */     if (SItemEquipCfg.get(itemid) == null)
/*     */     {
/* 608 */       return -1;
/*     */     }
/* 610 */     return SItemEquipCfg.get(itemid).wearpos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Integer> getWholeBodyQilinPropertyMap(int linlevel, int minEquipLevel)
/*     */   {
/* 622 */     Map<Integer, Integer> propertyMap = new HashMap();
/* 623 */     SAllEquipQilinpPropertyCfg allEquipQilinpPropertyCfg = null;
/* 624 */     Map<Integer, SAllEquipQilinpPropertyCfg> map = SAllEquipQilinpPropertyCfg.getAll();
/* 625 */     if ((map instanceof TreeMap))
/*     */     {
/* 627 */       TreeMap<Integer, SAllEquipQilinpPropertyCfg> treeMap = (TreeMap)map;
/* 628 */       Map.Entry<Integer, SAllEquipQilinpPropertyCfg> entry = treeMap.floorEntry(Integer.valueOf(linlevel));
/* 629 */       if (entry != null)
/*     */       {
/* 631 */         allEquipQilinpPropertyCfg = (SAllEquipQilinpPropertyCfg)entry.getValue();
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 638 */       List<Integer> leveList = new ArrayList(map.keySet());
/*     */       
/* 640 */       Collections.sort(leveList);
/* 641 */       int k = -1;
/* 642 */       for (int i = 0; i < leveList.size(); i++)
/*     */       {
/* 644 */         if (((Integer)leveList.get(i)).intValue() < linlevel)
/*     */           break;
/* 646 */         k = i;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 654 */       if (k != -1)
/*     */       {
/* 656 */         allEquipQilinpPropertyCfg = SAllEquipQilinpPropertyCfg.get(((Integer)leveList.get(k)).intValue());
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 661 */     if (allEquipQilinpPropertyCfg != null)
/*     */     {
/* 663 */       for (Property2Param property2Param : allEquipQilinpPropertyCfg.property2params)
/*     */       {
/* 665 */         if (property2Param.property != 0)
/*     */         {
/*     */ 
/*     */ 
/* 669 */           propertyMap.put(Integer.valueOf(property2Param.property), Integer.valueOf(property2Param.param * minEquipLevel)); }
/*     */       }
/*     */     }
/* 672 */     return propertyMap;
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
/*     */   static boolean canTransferStrengthLevel(long roleid, SItemEquipCfg srcItemEquipCfg, SItemEquipCfg desItemEquipCfg, boolean isSendTip)
/*     */   {
/* 688 */     int minLevel = EquipItemCfgConsts.getInstance().MIN_LEVEL_FOR_QILIN;
/* 689 */     if (desItemEquipCfg.useLevel < minLevel)
/*     */     {
/* 691 */       if (isSendTip)
/*     */       {
/* 693 */         ItemManager.sendWrongInfo(roleid, 1176, new String[] { String.valueOf(minLevel) });
/*     */       }
/* 695 */       return false;
/*     */     }
/*     */     
/* 698 */     SEquipTransferInherit srcEquipTransferInherit = getSEquipTransferHun(srcItemEquipCfg.useLevel);
/* 699 */     if (srcEquipTransferInherit == null)
/*     */     {
/* 701 */       return false;
/*     */     }
/* 703 */     SEquipTransferInherit desEquipTransferInherit = getSEquipTransferHun(desItemEquipCfg.useLevel);
/* 704 */     if (desEquipTransferInherit == null)
/*     */     {
/* 706 */       return false;
/*     */     }
/* 708 */     if (desEquipTransferInherit.qilingMaxLevel < srcEquipTransferInherit.qilingMaxLevel)
/*     */     {
/* 710 */       if (isSendTip)
/*     */       {
/* 712 */         ItemManager.sendWrongInfo(roleid, 1177, new String[0]);
/*     */       }
/* 714 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 718 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\ItemConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */