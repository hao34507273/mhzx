/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import xbean.Item;
/*     */ 
/*     */ public class ItemOperateResult
/*     */ {
/*     */   private ItemResultEnum resultEnum;
/*     */   private List<ChangeItemInfo> changeItemInfoList;
/*     */   
/*     */   public static enum ItemResultEnum
/*     */   {
/*  17 */     SUCCESS(0, "ok"), 
/*  18 */     UN_KNOWN_ERROR(64486, "un known error"), 
/*  19 */     WRONG_ITEMCFG(64485, "send item not exist"), 
/*  20 */     WRONG_NUMBER(64484, "item num not enough"), 
/*  21 */     BAG_ERROR(64482, "bag type not exist"),  BAG_FULL(64483, "bag full,extra item have send by mail"), 
/*     */     
/*  23 */     CARRY_MAX_ERROR(64477, "carry max"), 
/*  24 */     ITEM_TIME_NOT_VALID(64236, "time not valid"), 
/*  25 */     BAG_NOT_SUPPORT_ITEM(64136, "bag_not_support_item");
/*     */     
/*     */ 
/*     */ 
/*     */     public final int ret;
/*     */     
/*     */ 
/*     */     public final String retMsg;
/*     */     
/*     */ 
/*     */ 
/*     */     private ItemResultEnum(int ret, String retMsg)
/*     */     {
/*  38 */       this.ret = ret;
/*  39 */       this.retMsg = retMsg;
/*     */     }
/*     */   }
/*     */   
/*     */   public static enum RemoveModelEnum
/*     */   {
/*  45 */     NO_MODEL,  BIND_FIRST,  UNBIND_FIRST;
/*     */     
/*     */ 
/*     */     private RemoveModelEnum() {}
/*     */   }
/*     */   
/*  51 */   private int tocarrymaxitemid = 0;
/*     */   
/*  53 */   private int fullBagId = 0;
/*     */   
/*  55 */   private RemoveModelEnum removeModelEnum = RemoveModelEnum.NO_MODEL;
/*     */   
/*     */   public ItemOperateResult(ItemResultEnum resultEnum)
/*     */   {
/*  59 */     this.resultEnum = resultEnum;
/*  60 */     this.changeItemInfoList = new ArrayList();
/*     */   }
/*     */   
/*     */   public ItemOperateResult(ItemResultEnum resultEnum, RemoveModelEnum removeModelEnum)
/*     */   {
/*  65 */     this.resultEnum = resultEnum;
/*  66 */     this.changeItemInfoList = new ArrayList();
/*  67 */     this.removeModelEnum = removeModelEnum;
/*     */   }
/*     */   
/*     */   public ItemOperateResult(ItemResultEnum resultEnum, int tocarrymaxitemid)
/*     */   {
/*  72 */     this.resultEnum = resultEnum;
/*  73 */     this.changeItemInfoList = new ArrayList();
/*  74 */     this.tocarrymaxitemid = tocarrymaxitemid;
/*     */   }
/*     */   
/*     */   public ItemOperateResult(ItemResultEnum resultEnum, List<ChangeItemInfo> changeItemInfoList)
/*     */   {
/*  79 */     this.resultEnum = resultEnum;
/*  80 */     this.changeItemInfoList = changeItemInfoList;
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemOperateResult(ItemResultEnum resultEnum, List<ChangeItemInfo> changeItemInfoList, RemoveModelEnum removeModelEnum)
/*     */   {
/*  86 */     this.resultEnum = resultEnum;
/*  87 */     this.changeItemInfoList = changeItemInfoList;
/*  88 */     this.removeModelEnum = removeModelEnum;
/*     */   }
/*     */   
/*     */   public List<ChangeItemInfo> getChangeItemInfoList()
/*     */   {
/*  93 */     return this.changeItemInfoList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean success()
/*     */   {
/* 103 */     return this.resultEnum.equals(ItemResultEnum.SUCCESS);
/*     */   }
/*     */   
/*     */   public final RemoveModelEnum getRemoveModelEnum()
/*     */   {
/* 108 */     return this.removeModelEnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean isUnknowError()
/*     */   {
/* 116 */     return this.resultEnum.equals(ItemResultEnum.UN_KNOWN_ERROR);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean isParamError()
/*     */   {
/* 124 */     return (this.resultEnum.equals(ItemResultEnum.WRONG_ITEMCFG)) || (this.resultEnum.equals(ItemResultEnum.WRONG_NUMBER));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean isBagFull()
/*     */   {
/* 134 */     return this.resultEnum.equals(ItemResultEnum.BAG_FULL);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean isToCarryMax()
/*     */   {
/* 144 */     return this.resultEnum.equals(ItemResultEnum.CARRY_MAX_ERROR);
/*     */   }
/*     */   
/*     */   public ItemResultEnum getResultEnum()
/*     */   {
/* 149 */     return this.resultEnum;
/*     */   }
/*     */   
/*     */   public void setResultEnum(ItemResultEnum resultEnum)
/*     */   {
/* 154 */     this.resultEnum = resultEnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getItemChangeNum(int itemid)
/*     */   {
/* 165 */     Map<Integer, Integer> itemid2num = getItemChangeMap();
/* 166 */     if (null == itemid2num.get(Integer.valueOf(itemid)))
/*     */     {
/* 168 */       return 0;
/*     */     }
/* 170 */     return ((Integer)itemid2num.get(Integer.valueOf(itemid))).intValue();
/*     */   }
/*     */   
/*     */   public Map<Integer, Integer> getItemChangeMap()
/*     */   {
/* 175 */     Map<Integer, Integer> itemid2num = new HashMap();
/* 176 */     for (ChangeItemInfo c : this.changeItemInfoList)
/*     */     {
/* 178 */       int itemid = c.basicItem.getCfgId();
/* 179 */       if (itemid2num.containsKey(Integer.valueOf(itemid)))
/*     */       {
/* 181 */         itemid2num.put(Integer.valueOf(itemid), Integer.valueOf(((Integer)itemid2num.get(Integer.valueOf(itemid))).intValue() + c.basicItem.getNumber()));
/*     */       }
/*     */       else
/*     */       {
/* 185 */         itemid2num.put(Integer.valueOf(itemid), Integer.valueOf(c.basicItem.getNumber()));
/*     */       }
/*     */     }
/*     */     
/* 189 */     return itemid2num;
/*     */   }
/*     */   
/*     */   public Map<Integer, Set<Long>> getChangedItemId2Uuids()
/*     */   {
/* 194 */     Map<Integer, Set<Long>> itemid2uuids = new HashMap();
/* 195 */     for (ChangeItemInfo c : this.changeItemInfoList)
/*     */     {
/* 197 */       int itemid = c.basicItem.getCfgId();
/* 198 */       Set<Long> uuids = (Set)itemid2uuids.get(Integer.valueOf(itemid));
/* 199 */       if (uuids == null)
/*     */       {
/* 201 */         uuids = new java.util.HashSet();
/* 202 */         itemid2uuids.put(Integer.valueOf(itemid), uuids);
/*     */       }
/* 204 */       uuids.addAll(c.basicItem.getUuid());
/*     */     }
/*     */     
/* 207 */     return itemid2uuids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getTocarrymaxitemid()
/*     */   {
/* 215 */     return this.tocarrymaxitemid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFullBagId(int bagId)
/*     */   {
/* 226 */     this.fullBagId = bagId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getFullBagId()
/*     */   {
/* 236 */     return this.fullBagId;
/*     */   }
/*     */   
/*     */   public static class ChangeItemInfo
/*     */   {
/*     */     public final int grid;
/*     */     public final BasicItem basicItem;
/*     */     public final boolean isNewGrifOrRemove;
/*     */     
/*     */     public ChangeItemInfo(int grid, BasicItem basicItem, boolean isNewGrifOrRemove)
/*     */     {
/* 247 */       this.grid = grid;
/* 248 */       this.basicItem = basicItem;
/* 249 */       this.isNewGrifOrRemove = isNewGrifOrRemove;
/*     */     }
/*     */     
/*     */     public ChangeItemInfo(int grid, Item xitem, boolean isNewGrifOrRemove)
/*     */     {
/* 254 */       this.grid = grid;
/* 255 */       this.basicItem = ItemManager.getBasicItem(xitem);
/* 256 */       this.isNewGrifOrRemove = isNewGrifOrRemove;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\ItemOperateResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */