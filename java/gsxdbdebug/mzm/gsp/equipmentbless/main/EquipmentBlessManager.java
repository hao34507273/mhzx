/*     */ package mzm.gsp.equipmentbless.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.equipmentbless.confbean.EquipmentBlessExpBean;
/*     */ import mzm.gsp.equipmentbless.confbean.EquipmentBlessItemCompatiblePositionCfg;
/*     */ import mzm.gsp.equipmentbless.confbean.SEquipmentBlessExpCfg;
/*     */ import mzm.gsp.equipmentbless.confbean.SEquipmentBlessExpRange;
/*     */ import mzm.gsp.equipmentbless.confbean.SEquipmentBlessExpRanges;
/*     */ import mzm.gsp.equipmentbless.confbean.SEquipmentBlessProbabilityCfg;
/*     */ import mzm.gsp.equipmentbless.confbean.SEquipmentBlessRangeProbabilityCfg;
/*     */ import mzm.gsp.equipmentbless.confbean.SItem2EquipmentBlessExpRange;
/*     */ import mzm.gsp.equipmentbless.confbean.SItem2EquipmentBlessProbability;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.EquipmentItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemStoreEnum;
/*     */ import mzm.gsp.item.main.RoleEquipBag;
/*     */ import mzm.gsp.item.main.RoleItemBag;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Bag;
/*     */ import xbean.Item;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ class EquipmentBlessManager
/*     */ {
/*     */   private static final int TEN_THOUSAND = 10000;
/*  33 */   private static final Logger LOGGER = Logger.getLogger("EquipmentBless");
/*     */   
/*     */   static void logInfo(String str, Object... args)
/*     */   {
/*  37 */     LOGGER.info("[EquipmentBless]" + String.format(str, args));
/*     */   }
/*     */   
/*     */   static void logError(String str, Object... args)
/*     */   {
/*  42 */     LOGGER.error("[EquipmentBless]" + String.format(str, args));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isEnabled()
/*     */   {
/*  50 */     return mzm.gsp.open.main.OpenInterface.getOpenStatus(530);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static EquipmentBlessExpBean getEquipmentBlessExpBean(int level, int position)
/*     */   {
/*  58 */     SEquipmentBlessExpCfg cfg = SEquipmentBlessExpCfg.get(level);
/*  59 */     if (cfg != null)
/*     */     {
/*  61 */       if ((0 <= position) && (position < cfg.position2bean.size()))
/*     */       {
/*  63 */         return (EquipmentBlessExpBean)cfg.position2bean.get(position);
/*     */       }
/*     */     }
/*  66 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkBlessItemCompatibility(int blessItemId, int equipmentId)
/*     */   {
/*  74 */     EquipmentBlessItemCompatiblePositionCfg cfg = EquipmentBlessItemCompatiblePositionCfg.get(blessItemId);
/*  75 */     if (cfg == null)
/*     */     {
/*  77 */       return false;
/*     */     }
/*  79 */     int position = ItemInterface.getEquipWearpos(equipmentId);
/*  80 */     return cfg.positions.contains(Integer.valueOf(position));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getRandomBlessResult(int level, int position, int itemId)
/*     */   {
/*  88 */     SEquipmentBlessProbabilityCfg cfg = SEquipmentBlessProbabilityCfg.get(level);
/*  89 */     if (cfg != null)
/*     */     {
/*  91 */       if ((0 <= position) && (position < cfg.position2item.size()))
/*     */       {
/*  93 */         SItem2EquipmentBlessProbability item2probability = (SItem2EquipmentBlessProbability)cfg.position2item.get(position);
/*  94 */         if (item2probability != null)
/*     */         {
/*  96 */           Integer probability = (Integer)item2probability.item2probability.get(Integer.valueOf(itemId));
/*  97 */           if (probability != null)
/*     */           {
/*  99 */             int random = Xdb.random().nextInt(10000);
/* 100 */             return random < probability.intValue() ? 1 : 0;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 105 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getRandomBlessExp(int level, int position, int itemId)
/*     */   {
/* 113 */     SEquipmentBlessRangeProbabilityCfg cfg = SEquipmentBlessRangeProbabilityCfg.get(level);
/* 114 */     int random; if (cfg != null)
/*     */     {
/* 116 */       if ((0 <= position) && (position < cfg.position2item.size()))
/*     */       {
/* 118 */         SItem2EquipmentBlessExpRange item2range = (SItem2EquipmentBlessExpRange)cfg.position2item.get(position);
/* 119 */         if (item2range != null)
/*     */         {
/* 121 */           SEquipmentBlessExpRanges ranges = (SEquipmentBlessExpRanges)item2range.item2range.get(Integer.valueOf(itemId));
/* 122 */           if ((ranges != null) && (ranges.ranges.size() > 0))
/*     */           {
/* 124 */             int maxWeight = ((SEquipmentBlessExpRange)ranges.ranges.get(ranges.ranges.size() - 1)).weight;
/* 125 */             random = Xdb.random().nextInt(maxWeight);
/* 126 */             for (SEquipmentBlessExpRange range : ranges.ranges)
/*     */             {
/* 128 */               if (random < range.weight)
/*     */               {
/* 130 */                 return range.minExp + Xdb.random().nextInt(range.maxExp - range.minExp + 1);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 137 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Integer> getPropertiesFromBlessedEquipments(RoleEquipBag bag)
/*     */   {
/* 145 */     if (isEnabled())
/*     */     {
/* 147 */       Map<Integer, Integer> extraProperties = new HashMap();
/* 148 */       for (BasicItem basicItem : bag.getAllItems(false).values())
/*     */       {
/* 150 */         if ((basicItem instanceof EquipmentItem))
/*     */         {
/* 152 */           EquipmentItem equipment = (EquipmentItem)basicItem;
/* 153 */           int level = equipment.getBlessLevel();
/* 154 */           int position = ItemInterface.getEquipWearpos(equipment.getCfgId());
/* 155 */           EquipmentBlessExpBean bean = getEquipmentBlessExpBean(level, position);
/* 156 */           if (bean != null)
/*     */           {
/*     */ 
/*     */ 
/* 160 */             SItemEquipCfg equipmentCfg = SItemEquipCfg.get(equipment.getCfgId());
/* 161 */             if (equipmentCfg != null)
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/* 166 */               if (equipmentCfg.attrA != 0)
/*     */               {
/* 168 */                 int valueA = Math.round(equipment.getRawValueOfAttrA() * bean.propertyBuff / 10000.0F);
/* 169 */                 if (valueA > 0)
/*     */                 {
/* 171 */                   Integer currentValueA = (Integer)extraProperties.get(Integer.valueOf(equipmentCfg.attrA));
/* 172 */                   if (currentValueA == null)
/*     */                   {
/* 174 */                     extraProperties.put(Integer.valueOf(equipmentCfg.attrA), Integer.valueOf(valueA));
/*     */                   }
/*     */                   else
/*     */                   {
/* 178 */                     extraProperties.put(Integer.valueOf(equipmentCfg.attrA), Integer.valueOf(currentValueA.intValue() + valueA));
/*     */                   }
/*     */                 }
/*     */               }
/*     */               
/* 183 */               if (equipmentCfg.attrB != 0)
/*     */               {
/* 185 */                 int valueB = Math.round(equipment.getRawValueOfAttrB() * bean.propertyBuff / 10000.0F);
/* 186 */                 if (valueB > 0)
/*     */                 {
/* 188 */                   Integer currentValueB = (Integer)extraProperties.get(Integer.valueOf(equipmentCfg.attrB));
/* 189 */                   if (currentValueB == null)
/*     */                   {
/* 191 */                     extraProperties.put(Integer.valueOf(equipmentCfg.attrB), Integer.valueOf(valueB));
/*     */                   }
/*     */                   else
/*     */                   {
/* 195 */                     extraProperties.put(Integer.valueOf(equipmentCfg.attrB), Integer.valueOf(currentValueB.intValue() + valueB)); }
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */         } }
/* 201 */       return extraProperties;
/*     */     }
/* 203 */     return java.util.Collections.emptyMap();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Collection<BasicItem> getRoleBlessedEquipments(long roleId, int minLevel)
/*     */   {
/* 214 */     Collection<BasicItem> blessedEquipments = new ArrayList();
/* 215 */     if (minLevel < 0)
/*     */     {
/* 217 */       return blessedEquipments;
/*     */     }
/*     */     
/*     */ 
/* 221 */     Collection<RoleItemBag> roleBags = new ArrayList();
/* 222 */     roleBags.add(ItemInterface.getRoleEquipBag(roleId));
/* 223 */     roleBags.add(ItemInterface.getRoleItemBag(roleId));
/* 224 */     roleBags.addAll(ItemInterface.getAllRoleStorageBags(roleId));
/* 225 */     for (RoleItemBag bag : roleBags)
/*     */     {
/* 227 */       if (bag != null)
/*     */       {
/* 229 */         for (BasicItem item : bag.getAllItems(false).values())
/*     */         {
/* 231 */           if (minLevel == 0)
/*     */           {
/* 233 */             Integer blessExp = item.getExtra(ItemStoreEnum.EQUIPMENT_BLESS_EXP);
/* 234 */             if ((blessExp != null) && (blessExp.intValue() > 0))
/*     */             {
/* 236 */               blessedEquipments.add(item);
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 241 */             Integer blessLevel = item.getExtra(ItemStoreEnum.EQUIPMENT_BLESS_LEVEL);
/* 242 */             if ((blessLevel != null) && (blessLevel.intValue() >= minLevel))
/*     */             {
/* 244 */               blessedEquipments.add(item);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 252 */     xbean.OcpEquipBag xOcpEquipBag = xtable.Role2ocpequipbag.get(Long.valueOf(roleId));
/* 253 */     if (xOcpEquipBag != null)
/*     */     {
/* 255 */       for (Bag xBag : xOcpEquipBag.getOcp2equipbag().values())
/*     */       {
/* 257 */         for (Item xItem : xBag.getItems().values())
/*     */         {
/* 259 */           if (minLevel == 0)
/*     */           {
/* 261 */             Integer blessExp = (Integer)xItem.getExtra().get(Integer.valueOf(282));
/* 262 */             if ((blessExp != null) && (blessExp.intValue() > 0))
/*     */             {
/* 264 */               blessedEquipments.add(new BasicItem(xItem));
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 269 */             Integer blessLevel = (Integer)xItem.getExtra().get(Integer.valueOf(281));
/* 270 */             if ((blessLevel != null) && (blessLevel.intValue() >= minLevel))
/*     */             {
/* 272 */               blessedEquipments.add(new BasicItem(xItem));
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 279 */     return blessedEquipments;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getFilteredRoleBlessedEquipmentNumber(long roleId, int minLevel)
/*     */   {
/* 287 */     int count = 0;
/* 288 */     Collection<BasicItem> items = getRoleBlessedEquipments(roleId, minLevel);
/* 289 */     int roleOcpId = RoleInterface.getOccupationId(roleId);
/* 290 */     int roleGender = RoleInterface.getGender(roleId);
/* 291 */     for (BasicItem item : items)
/*     */     {
/* 293 */       SItemEquipCfg cfg = SItemEquipCfg.get(item.getCfgId());
/* 294 */       if (cfg != null)
/*     */       {
/* 296 */         if (((cfg.menpai == 0) || (cfg.menpai == roleOcpId)) && ((cfg.sex == 0) || (cfg.sex == roleGender)))
/*     */         {
/*     */ 
/* 299 */           count++;
/*     */         }
/*     */       }
/*     */     }
/* 303 */     return count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getFilteredRoleHighestBlessLevel(long roleId)
/*     */   {
/* 311 */     int highestLevel = 0;
/* 312 */     Collection<BasicItem> items = getRoleBlessedEquipments(roleId, 1);
/* 313 */     int roleOcpId = RoleInterface.getOccupationId(roleId);
/* 314 */     int roleGender = RoleInterface.getGender(roleId);
/* 315 */     for (BasicItem item : items)
/*     */     {
/* 317 */       SItemEquipCfg cfg = SItemEquipCfg.get(item.getCfgId());
/* 318 */       if (cfg != null)
/*     */       {
/* 320 */         if (((cfg.menpai == 0) || (cfg.menpai == roleOcpId)) && ((cfg.sex == 0) || (cfg.sex == roleGender)))
/*     */         {
/*     */ 
/* 323 */           Integer level = item.getExtra(ItemStoreEnum.EQUIPMENT_BLESS_LEVEL);
/* 324 */           if ((level != null) && (level.intValue() > highestLevel))
/*     */           {
/* 326 */             highestLevel = level.intValue();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 331 */     return highestLevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void triggerEquipmentBlessLevelUpdated(long roleId, long equipmentUUID, int oldLevel, int newLevel)
/*     */   {
/* 340 */     mzm.event.TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.equipmentbless.event.EquipmentBlessLevelUpdated(), new mzm.gsp.equipmentbless.event.EquipmentBlessLevelUpdatedArg(roleId, equipmentUUID, oldLevel, newLevel), mzm.gsp.role.main.RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\equipmentbless\main\EquipmentBlessManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */