/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.bag.confbean.ItemType2BagCfg;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import xbean.Bag;
/*     */ import xbean.Item;
/*     */ 
/*     */ 
/*     */ public class RoleTreasureBag
/*     */   extends RoleItemBag
/*     */ {
/*     */   RoleTreasureBag(Bag bag)
/*     */   {
/*  16 */     super(bag);
/*     */   }
/*     */   
/*     */   public RoleTreasureBag(Bag xBag, long roleId)
/*     */   {
/*  21 */     super(xBag, roleId);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean add(BasicItem e)
/*     */   {
/*  27 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  29 */       return true;
/*     */     }
/*     */     
/*  32 */     SItemCfg itemCfg = SItemCfg.get(e.getCfgId());
/*  33 */     if (itemCfg == null)
/*     */     {
/*  35 */       return false;
/*     */     }
/*     */     
/*  38 */     boolean ret = canAddItemToBag(itemCfg.type);
/*  39 */     if (!ret)
/*     */     {
/*  41 */       return false;
/*     */     }
/*  43 */     return super.add(e);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean add(int grid, BasicItem basicItem)
/*     */   {
/*  49 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  51 */       return true;
/*     */     }
/*     */     
/*  54 */     SItemCfg itemCfg = SItemCfg.get(basicItem.getCfgId());
/*  55 */     if (itemCfg == null)
/*     */     {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     boolean ret = canAddItemToBag(itemCfg.type);
/*  61 */     if (!ret)
/*     */     {
/*  63 */       return false;
/*     */     }
/*  65 */     return super.add(grid, basicItem);
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemOperateResult addItem(BasicItem basicItem, boolean isMerge)
/*     */   {
/*  71 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  73 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.SUCCESS);
/*     */     }
/*     */     
/*  76 */     SItemCfg itemCfg = SItemCfg.get(basicItem.getCfgId());
/*  77 */     if (itemCfg == null)
/*     */     {
/*  79 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_ITEMCFG);
/*     */     }
/*     */     
/*  82 */     boolean ret = canAddItemToBag(itemCfg.type);
/*  83 */     if (!ret)
/*     */     {
/*  85 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_NOT_SUPPORT_ITEM);
/*     */     }
/*  87 */     return super.addItem(basicItem, isMerge);
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemOperateResult addItem(BasicItem itemInfo)
/*     */   {
/*  93 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  95 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.SUCCESS);
/*     */     }
/*     */     
/*  98 */     SItemCfg itemCfg = SItemCfg.get(itemInfo.getCfgId());
/*  99 */     if (itemCfg == null)
/*     */     {
/* 101 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_ITEMCFG);
/*     */     }
/*     */     
/* 104 */     boolean ret = canAddItemToBag(itemCfg.type);
/* 105 */     if (!ret)
/*     */     {
/* 107 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_NOT_SUPPORT_ITEM);
/*     */     }
/* 109 */     return super.addItem(itemInfo);
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemOperateResult addItem(Item xItem, boolean isMerge, boolean isRollbackWhenFull)
/*     */   {
/* 115 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/* 117 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.SUCCESS);
/*     */     }
/*     */     
/* 120 */     SItemCfg itemCfg = SItemCfg.get(xItem.getCfgid());
/* 121 */     if (itemCfg == null)
/*     */     {
/* 123 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_ITEMCFG);
/*     */     }
/*     */     
/* 126 */     boolean ret = canAddItemToBag(itemCfg.type);
/* 127 */     if (!ret)
/*     */     {
/* 129 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_NOT_SUPPORT_ITEM);
/*     */     }
/* 131 */     return super.addItem(xItem, isMerge, isRollbackWhenFull);
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemOperateResult addItem(List<Item> xItems, boolean isMerge, boolean isRollbackWhenFull)
/*     */   {
/* 137 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/* 139 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.SUCCESS);
/*     */     }
/*     */     
/* 142 */     for (Item xItem : xItems)
/*     */     {
/* 144 */       SItemCfg itemCfg = SItemCfg.get(xItem.getCfgid());
/* 145 */       if (itemCfg == null)
/*     */       {
/* 147 */         return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_ITEMCFG);
/*     */       }
/*     */       
/* 150 */       boolean ret = canAddItemToBag(itemCfg.type);
/* 151 */       if (!ret)
/*     */       {
/* 153 */         return new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_NOT_SUPPORT_ITEM);
/*     */       }
/*     */     }
/* 156 */     return super.addItem(xItems, isMerge, isRollbackWhenFull);
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
/*     */   public static boolean canAddItemToBag(int itemType)
/*     */   {
/* 169 */     ItemType2BagCfg itemType2BagCfg = ItemType2BagCfg.get(itemType);
/* 170 */     if (itemType2BagCfg == null)
/*     */     {
/* 172 */       return false;
/*     */     }
/* 174 */     return itemType2BagCfg.bagId == 340600008;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\RoleTreasureBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */