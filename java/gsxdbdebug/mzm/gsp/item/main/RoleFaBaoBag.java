/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.bag.confbean.ItemType2BagCfg;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import xbean.Bag;
/*     */ import xbean.Item;
/*     */ 
/*     */ 
/*     */ public class RoleFaBaoBag
/*     */   extends RoleItemBag
/*     */ {
/*     */   RoleFaBaoBag(Bag bag)
/*     */   {
/*  15 */     super(bag);
/*     */   }
/*     */   
/*     */   public RoleFaBaoBag(Bag xBag, long roleId)
/*     */   {
/*  20 */     super(xBag, roleId);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean add(BasicItem e)
/*     */   {
/*  26 */     SItemCfg itemCfg = SItemCfg.get(e.getCfgId());
/*  27 */     boolean ret = canAddItemToBag(itemCfg.type);
/*  28 */     if (!ret)
/*     */     {
/*  30 */       return false;
/*     */     }
/*  32 */     return super.add(e);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean add(int grid, BasicItem basicItem)
/*     */   {
/*  38 */     SItemCfg itemCfg = SItemCfg.get(basicItem.getCfgId());
/*  39 */     boolean ret = canAddItemToBag(itemCfg.type);
/*  40 */     if (!ret)
/*     */     {
/*  42 */       return false;
/*     */     }
/*  44 */     return super.add(grid, basicItem);
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemOperateResult addItem(BasicItem basicItem, boolean isMerge)
/*     */   {
/*  50 */     SItemCfg itemCfg = SItemCfg.get(basicItem.getCfgId());
/*  51 */     boolean ret = canAddItemToBag(itemCfg.type);
/*  52 */     if (!ret)
/*     */     {
/*  54 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_NOT_SUPPORT_ITEM);
/*     */     }
/*  56 */     return super.addItem(basicItem, isMerge);
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemOperateResult addItem(BasicItem itemInfo)
/*     */   {
/*  62 */     SItemCfg itemCfg = SItemCfg.get(itemInfo.getCfgId());
/*  63 */     boolean ret = canAddItemToBag(itemCfg.type);
/*  64 */     if (!ret)
/*     */     {
/*  66 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_NOT_SUPPORT_ITEM);
/*     */     }
/*  68 */     return super.addItem(itemInfo);
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemOperateResult addItem(Item xItem, boolean isMerge, boolean isRollbackWhenFull)
/*     */   {
/*  74 */     SItemCfg itemCfg = SItemCfg.get(xItem.getCfgid());
/*  75 */     boolean ret = canAddItemToBag(itemCfg.type);
/*  76 */     if (!ret)
/*     */     {
/*  78 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_NOT_SUPPORT_ITEM);
/*     */     }
/*  80 */     return super.addItem(xItem, isMerge, isRollbackWhenFull);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ItemOperateResult addItem(List<Item> xItems, boolean isMerge, boolean isRollbackWhenFull)
/*     */   {
/*  87 */     for (Item xItem : xItems)
/*     */     {
/*  89 */       SItemCfg itemCfg = SItemCfg.get(xItem.getCfgid());
/*  90 */       boolean ret = canAddItemToBag(itemCfg.type);
/*  91 */       if (!ret)
/*     */       {
/*  93 */         return new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_NOT_SUPPORT_ITEM);
/*     */       }
/*     */     }
/*  96 */     return super.addItem(xItems, isMerge, isRollbackWhenFull);
/*     */   }
/*     */   
/*     */   public static boolean canAddItemToBag(int itemType)
/*     */   {
/* 101 */     ItemType2BagCfg itemType2BagCfg = ItemType2BagCfg.get(itemType);
/* 102 */     if (itemType2BagCfg == null)
/*     */     {
/* 104 */       return false;
/*     */     }
/* 106 */     return itemType2BagCfg.bagId == 340600006;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\RoleFaBaoBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */