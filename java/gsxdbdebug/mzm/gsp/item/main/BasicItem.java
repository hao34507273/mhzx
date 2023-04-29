/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.item.confbean.ItemCfgConsts;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import xbean.Item;
/*     */ import xbean.JewelInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.XExtraProBean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BasicItem
/*     */ {
/*     */   protected final Item xItem;
/*     */   
/*     */   public BasicItem(Item item)
/*     */   {
/*  31 */     if (item == null)
/*  32 */       throw new NullPointerException();
/*  33 */     this.xItem = item;
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
/*     */   protected boolean onCreateItem()
/*     */   {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getNumber()
/*     */   {
/*  57 */     return this.xItem.getNumber();
/*     */   }
/*     */   
/*     */   public final void setNumber(int num)
/*     */   {
/*  62 */     this.xItem.setNumber(num);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getFlags()
/*     */   {
/*  73 */     return this.xItem.getFlags();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getCfgId()
/*     */   {
/*  83 */     return this.xItem.getCfgid();
/*     */   }
/*     */   
/*     */   public Set<Long> getUuid()
/*     */   {
/*  88 */     return this.xItem.getUuid();
/*     */   }
/*     */   
/*     */   public Long getFirstUuid()
/*     */   {
/*  93 */     return Long.valueOf(getTlogUuid());
/*     */   }
/*     */   
/*     */   public long getTlogUuid()
/*     */   {
/*  98 */     if (this.xItem.getUuid().isEmpty())
/*     */     {
/* 100 */       return 0L;
/*     */     }
/* 102 */     return ((Long)this.xItem.getUuid().iterator().next()).longValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private SItemCfg getItemCfg()
/*     */   {
/* 112 */     return SItemCfg.get(this.xItem.getCfgid());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void setState(int state)
/*     */   {
/* 122 */     this.xItem.setFlags(this.xItem.getFlags() | state);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected final void clearState(int state)
/*     */   {
/* 132 */     this.xItem.setFlags(this.xItem.getFlags() & (state ^ 0xFFFFFFFF));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected final void cleanState()
/*     */   {
/* 140 */     this.xItem.setFlags(0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected final boolean checkState(int state)
/*     */   {
/* 151 */     return (this.xItem.getFlags() & state) == state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isBind()
/*     */   {
/* 161 */     return (this.xItem.getFlags() & 0x1) == 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final Integer getExtra(ItemStoreEnum itemStoreEnum)
/*     */   {
/* 173 */     return (Integer)this.xItem.getExtra().get(Integer.valueOf(itemStoreEnum.getStoreType()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void setExtra(ItemStoreEnum itemStoreEnum, int value)
/*     */   {
/* 184 */     this.xItem.getExtra().put(Integer.valueOf(itemStoreEnum.getStoreType()), Integer.valueOf(value));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final Integer removeExtra(ItemStoreEnum itemStoreEnum)
/*     */   {
/* 193 */     return (Integer)this.xItem.getExtra().remove(Integer.valueOf(itemStoreEnum.getStoreType()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected final boolean containsExtra(ItemStoreEnum itemStoreEnum)
/*     */   {
/* 204 */     return this.xItem.getExtra().containsKey(Integer.valueOf(itemStoreEnum.getStoreType()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean canUse(long roleid)
/*     */   {
/* 214 */     SItemCfg itemCfg = getItemCfg();
/* 215 */     if (!ItemManager.useItemLevel(roleid, itemCfg.useLevel))
/*     */     {
/* 217 */       return false;
/*     */     }
/* 219 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean canSell(long roleid)
/*     */   {
/* 230 */     return true;
/*     */   }
/*     */   
/*     */   public Item getCopyItem()
/*     */   {
/* 235 */     return this.xItem.copy();
/*     */   }
/*     */   
/*     */   public Item getItem()
/*     */   {
/* 240 */     return this.xItem;
/*     */   }
/*     */   
/*     */   public boolean isItemFromShanghui()
/*     */   {
/* 245 */     Integer itemsource = (Integer)this.xItem.getExtra().get(Integer.valueOf(ItemStoreEnum.ITEM_SOURCE.getStoreType()));
/* 246 */     if (itemsource == null)
/*     */     {
/* 248 */       return false;
/*     */     }
/* 250 */     return itemsource.intValue() == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getShangHuiPrice()
/*     */   {
/* 260 */     Integer price = (Integer)this.xItem.getExtra().get(Integer.valueOf(ItemStoreEnum.SHANGHUI_PRICE.getStoreType()));
/* 261 */     if (price == null)
/*     */     {
/* 263 */       return -1;
/*     */     }
/* 265 */     return price.intValue() / ItemCfgConsts.getInstance().SHANGHUI_PRICE_RATE;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void removeShanghuiProperty()
/*     */   {
/* 273 */     this.xItem.getExtra().remove(Integer.valueOf(ItemStoreEnum.SHANGHUI_PRICE.getStoreType()));
/* 274 */     Integer itemsource = (Integer)this.xItem.getExtra().get(Integer.valueOf(ItemStoreEnum.ITEM_SOURCE.getStoreType()));
/* 275 */     if ((itemsource != null) && (itemsource.intValue() == 0))
/*     */     {
/* 277 */       this.xItem.getExtra().remove(Integer.valueOf(ItemStoreEnum.ITEM_SOURCE.getStoreType()));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getMarketBuytime()
/*     */   {
/* 289 */     return this.xItem.getMarketbuytime();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTlogExtraString()
/*     */   {
/* 299 */     StringBuffer logstr = new StringBuffer("");
/*     */     
/* 301 */     for (Map.Entry<Integer, Integer> entry : this.xItem.getExtra().entrySet())
/*     */     {
/* 303 */       logstr.append(entry.getKey() + "=" + entry.getValue()).append("#");
/*     */     }
/* 305 */     return logstr.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTlogHunProString()
/*     */   {
/* 315 */     StringBuffer logstr = new StringBuffer("");
/*     */     
/* 317 */     for (XExtraProBean xExtraProBean : this.xItem.getExtraprolist())
/*     */     {
/* 319 */       logstr.append(xExtraProBean.getProtype() + "=" + xExtraProBean.getProvalue()).append("#");
/*     */     }
/*     */     
/* 322 */     return logstr.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Item separateItem(int sepNumber)
/*     */   {
/* 334 */     int totalNumber = this.xItem.getNumber();
/* 335 */     if (totalNumber < sepNumber)
/*     */     {
/* 337 */       return null;
/*     */     }
/* 339 */     Item newItem = Pod.newItem();
/* 340 */     ItemInterface.fillXItem(newItem, this.xItem);
/*     */     
/* 342 */     this.xItem.setNumber(totalNumber - sepNumber);
/*     */     
/* 344 */     newItem.setNumber(sepNumber);
/* 345 */     newItem.getUuid().clear();
/*     */     
/* 347 */     List<Long> uuidSet = new ArrayList(this.xItem.getUuid());
/* 348 */     Collections.sort(uuidSet);
/*     */     
/* 350 */     List<Long> toremoveuuids = new ArrayList();
/*     */     
/* 352 */     for (int i = uuidSet.size() - 1; i >= 0; i--)
/*     */     {
/* 354 */       toremoveuuids.add(uuidSet.get(i));
/* 355 */       if (toremoveuuids.size() == sepNumber) {
/*     */         break;
/*     */       }
/*     */     }
/*     */     
/* 360 */     newItem.getUuid().addAll(toremoveuuids);
/* 361 */     this.xItem.getUuid().removeAll(toremoveuuids);
/*     */     
/* 363 */     return newItem;
/*     */   }
/*     */   
/*     */   public Map<Integer, JewelInfo> getJewelMap()
/*     */   {
/* 368 */     return this.xItem.getJewelmap();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\BasicItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */