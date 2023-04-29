/*     */ package mzm.gsp.superequipment.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.item.main.EquipmentItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.RoleEquipBag;
/*     */ 
/*     */ public class PTransferSuperEquipment extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final Set<Long> uuids;
/*     */   
/*     */   public PTransferSuperEquipment(long roleId, Set<Long> uuids)
/*     */   {
/*  19 */     this.roleId = roleId;
/*  20 */     this.uuids = uuids;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  26 */     if (!SuperEquipmentManager.checkBasicConditions(this.roleId)) {
/*  27 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  31 */     List<EquipmentItem> srcItems = new ArrayList();
/*  32 */     if (!checkoutSourceItemsFromUUIDs(srcItems)) {
/*  33 */       return false;
/*     */     }
/*  35 */     List<EquipmentItem> dstItems = new ArrayList();
/*  36 */     if (!checkoutRelatedEquippedItems(srcItems, dstItems)) {
/*  37 */       return false;
/*     */     }
/*  39 */     for (int i = 0; i < srcItems.size(); i++) {
/*  40 */       if (!transferData((EquipmentItem)srcItems.get(i), (EquipmentItem)dstItems.get(i)))
/*  41 */         return false;
/*     */     }
/*  43 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkoutSourceItemsFromUUIDs(List<EquipmentItem> srcItems)
/*     */   {
/*  53 */     for (Long uuid : this.uuids)
/*     */     {
/*  55 */       mzm.gsp.item.main.BasicItem basicItem = ItemInterface.getItemByUuid(this.roleId, uuid.longValue());
/*  56 */       if (basicItem == null)
/*     */       {
/*  58 */         SuperEquipmentManager.error("PTransferSuperEquipment.checkoutItemsFromUUIDs()@invalid uuid|roleid=%d|uuid=%d", new Object[] { Long.valueOf(this.roleId), uuid });
/*     */         
/*  60 */         return false;
/*     */       }
/*     */       
/*  63 */       if (!(basicItem instanceof EquipmentItem))
/*     */       {
/*  65 */         SuperEquipmentManager.error("PTransferSuperEquipment.checkoutItemsFromUUIDs()@invalid item|roleid=%d|uuid=%d", new Object[] { Long.valueOf(this.roleId), uuid });
/*     */         
/*  67 */         return false;
/*     */       }
/*     */       
/*  70 */       EquipmentItem item = (EquipmentItem)basicItem;
/*  71 */       if (!SuperEquipmentManager.isSuperEquipment(item))
/*     */       {
/*  73 */         SuperEquipmentManager.error("PTransferSuperEquipment.checkoutItemsFromUUIDs()@not super equipment|roleid=%d|uuid=%d", new Object[] { Long.valueOf(this.roleId), uuid });
/*     */         
/*  75 */         return false;
/*     */       }
/*     */       
/*  78 */       srcItems.add(item);
/*     */     }
/*  80 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkoutRelatedEquippedItems(List<EquipmentItem> srcItems, List<EquipmentItem> dstItems)
/*     */   {
/*  91 */     Set<Long> equippedItemUUIDs = new java.util.HashSet();
/*  92 */     for (EquipmentItem srcItem : srcItems)
/*     */     {
/*  94 */       int wearPos = ItemInterface.getEquipWearpos(srcItem.getCfgId());
/*  95 */       EquipmentItem dstItem = getEquippedItemByWearPos(wearPos);
/*  96 */       if (dstItem == null)
/*     */       {
/*  98 */         SuperEquipmentManager.error("PTransferSuperEquipment.checkoutRelatedEquippedItems()@not equipped|roleid=%d|uuid=%d|wearpos=%d", new Object[] { Long.valueOf(this.roleId), srcItem.getFirstUuid(), Integer.valueOf(wearPos) });
/*     */         
/* 100 */         return false;
/*     */       }
/* 102 */       if (srcItem.getFirstUuid().equals(dstItem.getFirstUuid()))
/*     */       {
/* 104 */         SuperEquipmentManager.error("PTransferSuperEquipment.checkoutRelatedEquippedItems()@equipped item as source|roleid=%d|uuid=%d|wearpos=%d", new Object[] { Long.valueOf(this.roleId), srcItem.getFirstUuid(), Integer.valueOf(wearPos) });
/*     */         
/* 106 */         return false;
/*     */       }
/* 108 */       if (!equippedItemUUIDs.add(dstItem.getFirstUuid()))
/*     */       {
/* 110 */         SuperEquipmentManager.error("PTransferSuperEquipment.checkoutRelatedEquippedItems()@duplicated equipment type|roleid=%d|uuid=%d|wearpos=%d", new Object[] { Long.valueOf(this.roleId), srcItem.getFirstUuid(), Integer.valueOf(wearPos) });
/*     */         
/* 112 */         return false;
/*     */       }
/* 114 */       dstItems.add(dstItem);
/*     */     }
/* 116 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private EquipmentItem getEquippedItemByWearPos(int wearPos)
/*     */   {
/* 124 */     RoleEquipBag equipBag = ItemInterface.getRoleEquipBag(this.roleId);
/* 125 */     for (mzm.gsp.item.main.BasicItem basicItem : equipBag.getAllItems(false).values())
/*     */     {
/* 127 */       if ((basicItem instanceof EquipmentItem))
/*     */       {
/* 129 */         EquipmentItem item = (EquipmentItem)basicItem;
/* 130 */         if (ItemInterface.getEquipWearpos(item.getCfgId()) == wearPos)
/* 131 */           return item;
/*     */       }
/*     */     }
/* 134 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean transferData(EquipmentItem srcItem, EquipmentItem dstItem)
/*     */   {
/* 144 */     int srcStage = srcItem.getSuperEquipmentStage();
/* 145 */     int srcLevel = srcItem.getSuperEquipmentLevel();
/* 146 */     int dstStage = dstItem.getSuperEquipmentStage();
/* 147 */     int dstLevel = dstItem.getSuperEquipmentLevel();
/*     */     
/*     */ 
/* 150 */     if (!SuperEquipmentManager.meetLowestConditionsForSuperEquipment(dstItem))
/*     */     {
/* 152 */       SuperEquipmentManager.error("PTransferSuperEquipment.transferData()@lowest conditions not met|roleid=%d|item_uuid=%d", new Object[] { Long.valueOf(this.roleId), dstItem.getFirstUuid() });
/*     */       
/*     */ 
/* 155 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 159 */     if ((dstLevel > srcLevel) || ((dstLevel == srcLevel) && (dstStage >= srcStage)))
/*     */     {
/* 161 */       SuperEquipmentManager.error("PTransferSuperEquipment.transferData()@level or stage relation error|roleid=%d|src_stage=%d|src_level=%d|dst_stage=%d|dst_level=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(srcStage), Integer.valueOf(srcLevel), Integer.valueOf(dstStage), Integer.valueOf(dstLevel) });
/*     */       
/*     */ 
/* 164 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 168 */     srcItem.setSuperEquipmentStage(dstStage);
/* 169 */     dstItem.setSuperEquipmentStage(srcStage);
/*     */     
/*     */ 
/* 172 */     srcItem.setSuperEquipmentLevel(dstLevel);
/* 173 */     dstItem.setSuperEquipmentLevel(srcLevel);
/*     */     
/*     */ 
/* 176 */     Map<Integer, Integer> srcStageCostMap = new HashMap(srcItem.getSuperEquipmentImproveStageCostMap());
/*     */     
/* 178 */     Map<Integer, Integer> srcLevelCostMap = new HashMap(srcItem.getSuperEquipmentImproveLevelCostMap());
/*     */     
/* 180 */     Map<Integer, Integer> dstStageCostMap = new HashMap(dstItem.getSuperEquipmentImproveStageCostMap());
/*     */     
/* 182 */     Map<Integer, Integer> dstLevelCostMap = new HashMap(dstItem.getSuperEquipmentImproveLevelCostMap());
/*     */     
/* 184 */     srcItem.getSuperEquipmentImproveStageCostMap().clear();
/* 185 */     srcItem.getSuperEquipmentImproveLevelCostMap().clear();
/* 186 */     dstItem.getSuperEquipmentImproveStageCostMap().clear();
/* 187 */     dstItem.getSuperEquipmentImproveLevelCostMap().clear();
/* 188 */     srcItem.getSuperEquipmentImproveStageCostMap().putAll(dstStageCostMap);
/* 189 */     srcItem.getSuperEquipmentImproveLevelCostMap().putAll(dstLevelCostMap);
/* 190 */     dstItem.getSuperEquipmentImproveStageCostMap().putAll(srcStageCostMap);
/* 191 */     dstItem.getSuperEquipmentImproveLevelCostMap().putAll(srcLevelCostMap);
/*     */     
/*     */ 
/* 194 */     Map<Integer, xbean.JewelInfo> srcGemMap = new HashMap(srcItem.getJewelMap());
/* 195 */     Map<Integer, xbean.JewelInfo> dstGemMap = new HashMap(dstItem.getJewelMap());
/* 196 */     srcItem.getJewelMap().clear();
/* 197 */     dstItem.getJewelMap().clear();
/* 198 */     srcItem.getJewelMap().putAll(dstGemMap);
/* 199 */     dstItem.getJewelMap().putAll(srcGemMap);
/*     */     
/*     */ 
/* 202 */     int srcBlessLevel = srcItem.getBlessLevel();
/* 203 */     int srcBlessExp = srcItem.getBlessExp();
/* 204 */     int dstBlessLevel = dstItem.getBlessLevel();
/* 205 */     int dstBlessExp = dstItem.getBlessExp();
/* 206 */     srcItem.setBlessLevel(dstBlessLevel);
/* 207 */     srcItem.setBlessExp(dstBlessExp);
/* 208 */     dstItem.setBlessLevel(srcBlessLevel);
/* 209 */     dstItem.setBlessExp(srcBlessExp);
/*     */     
/*     */ 
/* 212 */     SuperEquipmentManager.tlogExchangeData(this.roleId, srcItem.getFirstUuid().longValue(), dstItem.getFirstUuid().longValue());
/* 213 */     SuperEquipmentManager.triggerDataExchanged(this.roleId, srcItem.getFirstUuid().longValue(), dstItem.getFirstUuid().longValue());
/*     */     
/* 215 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\main\PTransferSuperEquipment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */