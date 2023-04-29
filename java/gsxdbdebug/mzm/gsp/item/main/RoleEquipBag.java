/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.bag.confbean.SBagCfg;
/*     */ import xbean.Bag;
/*     */ import xbean.Item;
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
/*     */ public class RoleEquipBag
/*     */   extends RoleItemBag
/*     */ {
/*     */   public RoleEquipBag(Bag bag)
/*     */   {
/*  24 */     super(bag);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean add(BasicItem e)
/*     */   {
/*  31 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemOperateResult addItem(BasicItem itemInfo, boolean isMerge)
/*     */   {
/*  37 */     return new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_ERROR);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean add(int grid, BasicItem e)
/*     */   {
/*  44 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getCapacity()
/*     */   {
/*  50 */     SBagCfg bagCfg = SBagCfg.get(340600001);
/*  51 */     if (bagCfg == null)
/*     */     {
/*  53 */       return 12;
/*     */     }
/*  55 */     return bagCfg.initcapacity;
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemOperateResult addItem(BasicItem item)
/*     */   {
/*  61 */     if (item.getNumber() > ItemConfigManager.getPileMaxCount(item.getCfgId()))
/*     */     {
/*  63 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*     */     }
/*  65 */     return _addItem(item);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isEquiped(int wearpos)
/*     */   {
/*  76 */     return !isGridEmpty(wearpos);
/*     */   }
/*     */   
/*     */   private ItemOperateResult _addItem(BasicItem item)
/*     */   {
/*  81 */     if ((item instanceof EquipmentItem))
/*     */     {
/*  83 */       EquipmentItem equipmentItem = (EquipmentItem)item;
/*     */       
/*  85 */       equipmentItem.setState(1);
/*     */       
/*  87 */       int wearPos = ItemConfigManager.getEquipWearpos(equipmentItem.getCfgId());
/*  88 */       if (wearPos == -1)
/*     */       {
/*  90 */         return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_ITEMCFG);
/*     */       }
/*     */       
/*  93 */       if (isEquiped(wearPos))
/*     */       {
/*  95 */         return new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_ERROR);
/*     */       }
/*  97 */       this.xBag.getItems().put(Integer.valueOf(wearPos), equipmentItem.getItem());
/*     */       
/*  99 */       ItemOperateResult.ChangeItemInfo c = new ItemOperateResult.ChangeItemInfo(wearPos, equipmentItem.getCopyItem(), true);
/* 100 */       List<ItemOperateResult.ChangeItemInfo> addItemInfos = new ArrayList();
/* 101 */       addItemInfos.add(c);
/* 102 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.SUCCESS, addItemInfos);
/*     */     }
/*     */     
/*     */ 
/* 106 */     return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_ITEMCFG);
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemOperateResult addItem(Item xItem)
/*     */   {
/* 112 */     BasicItem basicItem = ItemManager.getBasicItem(xItem);
/* 113 */     return addItem(basicItem);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\RoleEquipBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */