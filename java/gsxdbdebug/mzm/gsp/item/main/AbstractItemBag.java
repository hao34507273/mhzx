/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
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
/*     */ public abstract class AbstractItemBag
/*     */   implements ItemBagItf
/*     */ {
/*     */   public boolean add(BasicItem e)
/*     */   {
/*  26 */     int grid = getNextAvailableGrid();
/*  27 */     if (grid == -1)
/*     */     {
/*  29 */       return false;
/*     */     }
/*  31 */     return add(grid, e);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isBagFull()
/*     */   {
/*  38 */     return size() == getCapacity();
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isGridEmpty(int grid)
/*     */   {
/*  44 */     return get(grid) == null;
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemOperateResult addItem(BasicItem itemInfo)
/*     */   {
/*  50 */     return addItem(itemInfo, false);
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemOperateResult removeItemByGrid(int grid, int num)
/*     */   {
/*  56 */     if (num <= 0)
/*  57 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*  58 */     BasicItem basicItem = (BasicItem)get(grid);
/*  59 */     if ((basicItem == null) || (basicItem.getNumber() < num))
/*     */     {
/*  61 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*     */     }
/*     */     
/*  64 */     if (!ItemManager.checkTimeIsValid(basicItem.getItem()))
/*     */     {
/*  66 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.ITEM_TIME_NOT_VALID);
/*     */     }
/*     */     
/*  69 */     List<ItemOperateResult.ChangeItemInfo> delItemInfos = new ArrayList();
/*  70 */     if (basicItem.getNumber() > num)
/*     */     {
/*  72 */       Set<Long> uuidSet = removeUUID(basicItem.getItem(), num);
/*     */       
/*     */ 
/*  75 */       BasicItem b = new BasicItem(basicItem.getCopyItem());
/*  76 */       b.setNumber(num);
/*  77 */       b.getUuid().clear();
/*  78 */       b.getUuid().addAll(uuidSet);
/*  79 */       ItemOperateResult.ChangeItemInfo c = new ItemOperateResult.ChangeItemInfo(grid, b, false);
/*     */       
/*  81 */       delItemInfos.add(c);
/*     */ 
/*     */     }
/*  84 */     else if (basicItem.getNumber() == num)
/*     */     {
/*  86 */       basicItem = (BasicItem)removeByGrid(grid);
/*  87 */       if (basicItem == null)
/*     */       {
/*  89 */         return new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_ERROR);
/*     */       }
/*  91 */       ItemOperateResult.ChangeItemInfo c = new ItemOperateResult.ChangeItemInfo(grid, basicItem.getCopyItem(), true);
/*  92 */       delItemInfos.add(c);
/*     */     }
/*     */     else
/*     */     {
/*  96 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*     */     }
/*     */     
/*  99 */     return new ItemOperateResult(ItemOperateResult.ItemResultEnum.SUCCESS, delItemInfos);
/*     */   }
/*     */   
/*     */ 
/*     */   public BasicItem getItemByUuid(long uuid)
/*     */   {
/* 105 */     for (BasicItem item : getAllItems(true).values())
/*     */     {
/* 107 */       if (item.getUuid().contains(Long.valueOf(uuid)))
/*     */       {
/* 109 */         return item;
/*     */       }
/*     */     }
/* 112 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public Map<Integer, BasicItem> getItemBycfgId(int itemId)
/*     */   {
/* 118 */     Map<Integer, BasicItem> resultMap = new HashMap();
/* 119 */     for (Map.Entry<Integer, BasicItem> e : getAllItems(false).entrySet())
/*     */     {
/* 121 */       BasicItem v = (BasicItem)e.getValue();
/* 122 */       if (v.getCfgId() == itemId)
/* 123 */         resultMap.put(e.getKey(), v);
/*     */     }
/* 125 */     return resultMap;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getItemNumberBycfgId(int itemId)
/*     */   {
/* 131 */     int count = 0;
/* 132 */     Map<Integer, BasicItem> itemMap = getItemBycfgId(itemId);
/* 133 */     for (BasicItem i : itemMap.values())
/*     */     {
/* 135 */       count += i.getNumber();
/*     */     }
/* 137 */     return count;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getItemNumberByGrid(int grid)
/*     */   {
/* 143 */     BasicItem info = (BasicItem)get(grid);
/* 144 */     if (info == null)
/*     */     {
/* 146 */       return 0;
/*     */     }
/* 148 */     return info.getNumber();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getAvailableGridNum()
/*     */   {
/* 158 */     return getCapacity() - size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Set<Long> removeUUID(Item info, int number)
/*     */   {
/* 170 */     Set<Long> uuidLongs = new HashSet();
/* 171 */     if ((number <= 0) || (number > info.getNumber()))
/*     */     {
/* 173 */       return uuidLongs;
/*     */     }
/* 175 */     List<Long> uuidListCopy = new ArrayList(info.getUuid());
/* 176 */     Collections.sort(uuidListCopy);
/* 177 */     for (int i = uuidListCopy.size() - 1; i >= 0; i--)
/*     */     {
/* 179 */       uuidLongs.add(uuidListCopy.get(i));
/* 180 */       if (uuidLongs.size() == number) {
/*     */         break;
/*     */       }
/*     */     }
/* 184 */     if (uuidLongs.size() != number)
/*     */     {
/* 186 */       uuidLongs.clear();
/* 187 */       return uuidLongs;
/*     */     }
/* 189 */     info.getUuid().removeAll(uuidLongs);
/* 190 */     info.setNumber(info.getNumber() - number);
/* 191 */     return uuidLongs;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\AbstractItemBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */