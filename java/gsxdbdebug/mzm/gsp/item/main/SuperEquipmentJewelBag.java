/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.bag.confbean.ItemType2BagCfg;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import xbean.Bag;
/*     */ import xbean.Item;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SuperEquipmentJewelBag
/*     */   extends RoleItemBag
/*     */ {
/*     */   SuperEquipmentJewelBag(Bag bag)
/*     */   {
/*  18 */     super(bag);
/*     */   }
/*     */   
/*     */   public SuperEquipmentJewelBag(Bag xBag, long roleId)
/*     */   {
/*  23 */     super(xBag, roleId);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean add(BasicItem e)
/*     */   {
/*  29 */     SItemCfg itemCfg = SItemCfg.get(e.getCfgId());
/*  30 */     boolean ret = canAddItemToBag(itemCfg.type);
/*  31 */     if (!ret)
/*     */     {
/*  33 */       return false;
/*     */     }
/*  35 */     return super.add(e);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean add(int grid, BasicItem basicItem)
/*     */   {
/*  41 */     SItemCfg itemCfg = SItemCfg.get(basicItem.getCfgId());
/*  42 */     boolean ret = canAddItemToBag(itemCfg.type);
/*  43 */     if (!ret)
/*     */     {
/*  45 */       return false;
/*     */     }
/*  47 */     return super.add(grid, basicItem);
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemOperateResult addItem(BasicItem basicItem, boolean isMerge)
/*     */   {
/*  53 */     SItemCfg itemCfg = SItemCfg.get(basicItem.getCfgId());
/*  54 */     boolean ret = canAddItemToBag(itemCfg.type);
/*  55 */     if (!ret)
/*     */     {
/*  57 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_NOT_SUPPORT_ITEM);
/*     */     }
/*  59 */     return super.addItem(basicItem, isMerge);
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemOperateResult addItem(BasicItem itemInfo)
/*     */   {
/*  65 */     SItemCfg itemCfg = SItemCfg.get(itemInfo.getCfgId());
/*  66 */     boolean ret = canAddItemToBag(itemCfg.type);
/*  67 */     if (!ret)
/*     */     {
/*  69 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_NOT_SUPPORT_ITEM);
/*     */     }
/*  71 */     return super.addItem(itemInfo);
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemOperateResult addItem(Item xItem, boolean isMerge, boolean isRollbackWhenFull)
/*     */   {
/*  77 */     SItemCfg itemCfg = SItemCfg.get(xItem.getCfgid());
/*  78 */     boolean ret = canAddItemToBag(itemCfg.type);
/*  79 */     if (!ret)
/*     */     {
/*  81 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_NOT_SUPPORT_ITEM);
/*     */     }
/*  83 */     return super.addItem(xItem, isMerge, isRollbackWhenFull);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ItemOperateResult addItem(List<Item> xItems, boolean isMerge, boolean isRollbackWhenFull)
/*     */   {
/*  90 */     for (Item xItem : xItems)
/*     */     {
/*  92 */       SItemCfg itemCfg = SItemCfg.get(xItem.getCfgid());
/*  93 */       boolean ret = canAddItemToBag(itemCfg.type);
/*  94 */       if (!ret)
/*     */       {
/*  96 */         return new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_NOT_SUPPORT_ITEM);
/*     */       }
/*     */     }
/*  99 */     return super.addItem(xItems, isMerge, isRollbackWhenFull);
/*     */   }
/*     */   
/*     */   public static boolean canAddItemToBag(int itemType)
/*     */   {
/* 104 */     ItemType2BagCfg itemType2BagCfg = ItemType2BagCfg.get(itemType);
/* 105 */     if (itemType2BagCfg == null)
/*     */     {
/* 107 */       return false;
/*     */     }
/* 109 */     return itemType2BagCfg.bagId == 340600005;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\SuperEquipmentJewelBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */