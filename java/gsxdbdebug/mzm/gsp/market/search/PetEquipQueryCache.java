/*     */ package mzm.gsp.market.search;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import mzm.gsp.market.main.MarketPriceChart;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MarketItem;
/*     */ import xtable.Marketitem;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PetEquipQueryCache
/*     */ {
/*  20 */   private static PetEquipQueryCache instance = new PetEquipQueryCache();
/*     */   private final ItemConditionNode pubEquipConditionNode;
/*     */   private final ItemConditionNode sellEquipConditionNode;
/*     */   
/*  24 */   public static PetEquipQueryCache getInstance() { return instance; }
/*     */   
/*     */ 
/*     */ 
/*     */   private PetEquipQueryCache()
/*     */   {
/*  30 */     this.pubEquipConditionNode = new ItemConditionNode();
/*  31 */     this.sellEquipConditionNode = new ItemConditionNode();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void buildByCondition(int subid, PetEquipCondition condition, int state)
/*     */   {
/*  51 */     ItemConditionNode itemConditionNode = null;
/*  52 */     if (state == 2)
/*     */     {
/*  54 */       itemConditionNode = this.sellEquipConditionNode;
/*     */     }
/*     */     else
/*     */     {
/*  58 */       itemConditionNode = this.pubEquipConditionNode;
/*     */     }
/*     */     
/*  61 */     int size = itemConditionNode.getSize(subid, condition);
/*     */     
/*  63 */     if (size != -1)
/*     */     {
/*  65 */       return;
/*     */     }
/*  67 */     List<MarketPriceChart> marketPriceCharts = MarketInterface.getBySubid(subid, state == 1);
/*     */     
/*  69 */     if (marketPriceCharts == null)
/*     */     {
/*  71 */       return;
/*     */     }
/*     */     
/*  74 */     String logStr = String.format("[marketsearch]PetEquipQueryCache.buildByCondition@start search|subid=%d|property=%d|skillids=%s", new Object[] { Integer.valueOf(subid), Integer.valueOf(condition.getProperty()), condition.getSkillIds().toString() });
/*     */     
/*     */ 
/*     */ 
/*  78 */     MarketInterface.getLogger().info(logStr);
/*     */     
/*  80 */     int i = 0;
/*  81 */     for (MarketPriceChart mc : marketPriceCharts)
/*     */     {
/*  83 */       MarketItem xMarketItem = Marketitem.select(Long.valueOf(mc.getMarketId()));
/*  84 */       if ((xMarketItem != null) && (condition.isTrue(xMarketItem)))
/*     */       {
/*  86 */         itemConditionNode.addItemChartObj(subid, condition, new ItemChartObj(mc.getMarketId(), mc.getPrice()));
/*  87 */         i++;
/*     */       }
/*     */     }
/*     */     
/*  91 */     logStr = String.format("[marketsearch]PetEquipQueryCache.buildByCondition@end search|subid=%d|property=%d|skillids=%s|resultNum=%d", new Object[] { Integer.valueOf(subid), Integer.valueOf(condition.getProperty()), condition.getSkillIds().toString(), Integer.valueOf(i) });
/*     */     
/*     */ 
/*     */ 
/*  95 */     MarketInterface.getLogger().info(logStr);
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
/*     */   public void buildByConditionAll(int subid, PetEquipCondition condition, int state)
/*     */   {
/* 108 */     ItemConditionNode itemConditionNode = null;
/* 109 */     if (state == 2)
/*     */     {
/* 111 */       itemConditionNode = this.sellEquipConditionNode;
/*     */     }
/*     */     else
/*     */     {
/* 115 */       itemConditionNode = this.pubEquipConditionNode;
/*     */     }
/*     */     
/* 118 */     int size = itemConditionNode.getSize(subid, condition);
/*     */     
/* 120 */     if (size != -1)
/*     */     {
/* 122 */       return;
/*     */     }
/* 124 */     List<MarketPriceChart> marketPriceCharts = MarketInterface.getBySubid(subid, state == 1);
/*     */     
/* 126 */     if (marketPriceCharts == null)
/*     */     {
/* 128 */       return;
/*     */     }
/*     */     
/* 131 */     String logStr = String.format("[marketsearch]PetEquipQueryCache.buildByConditionAll@start search|subid=%d|property=%d|skillids=%s", new Object[] { Integer.valueOf(subid), Integer.valueOf(condition.getProperty()), condition.getSkillIds().toString() });
/*     */     
/*     */ 
/*     */ 
/* 135 */     MarketInterface.getLogger().info(logStr);
/*     */     
/* 137 */     List<ItemChartObj> itemChartObjs = new ArrayList();
/*     */     
/* 139 */     for (MarketPriceChart mc : marketPriceCharts)
/*     */     {
/* 141 */       MarketItem xMarketItem = Marketitem.select(Long.valueOf(mc.getMarketId()));
/* 142 */       if ((xMarketItem != null) && (condition.isTrue(xMarketItem)))
/*     */       {
/* 144 */         itemChartObjs.add(new ItemChartObj(mc.getMarketId(), mc.getPrice()));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 149 */     itemConditionNode.addItemChartObjs(subid, condition, itemChartObjs);
/* 150 */     logStr = String.format("[marketsearch]PetEquipQueryCache.buildByConditionAll@end search|subid=%d|property=%d|skillids=%s|resultNum=%d", new Object[] { Integer.valueOf(subid), Integer.valueOf(condition.getProperty()), condition.getSkillIds().toString(), Integer.valueOf(itemChartObjs.size()) });
/*     */     
/*     */ 
/*     */ 
/* 154 */     MarketInterface.getLogger().info(logStr);
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
/*     */   public void buildByConditionFromIndex(int subid, PetEquipCondition condition, int state)
/*     */   {
/* 167 */     ItemConditionNode itemConditionNode = null;
/* 168 */     if (state == 2)
/*     */     {
/* 170 */       itemConditionNode = this.sellEquipConditionNode;
/*     */     }
/*     */     else
/*     */     {
/* 174 */       itemConditionNode = this.pubEquipConditionNode;
/*     */     }
/*     */     
/* 177 */     int size = itemConditionNode.getSize(subid, condition);
/*     */     
/* 179 */     if (size != -1)
/*     */     {
/* 181 */       String logStr = String.format("[marketsearch]PetEquipQueryCache.buildByConditionFromIndex@condition already searched|subid=%d|property=%d|skillids=%s|resultNum=%d|state=%d", new Object[] { Integer.valueOf(subid), Integer.valueOf(condition.getProperty()), condition.getSkillIds().toString(), Integer.valueOf(size), Integer.valueOf(state) });
/*     */       
/*     */ 
/*     */ 
/* 185 */       MarketInterface.getLogger().info(logStr);
/* 186 */       return;
/*     */     }
/*     */     
/* 189 */     String logStr = String.format("[marketsearch]PetEquipQueryCache.buildByConditionFromIndex@start search|subid=%d|property=%d|skillids=%s", new Object[] { Integer.valueOf(subid), Integer.valueOf(condition.getProperty()), condition.getSkillIds().toString() });
/*     */     
/*     */ 
/*     */ 
/* 193 */     MarketInterface.getLogger().info(logStr);
/* 194 */     long start = DateTimeUtils.getCurrTimeInMillis();
/* 195 */     List<ItemChartObj> itemChartObjs = new ArrayList();
/*     */     
/* 197 */     boolean isPub = state == 1;
/* 198 */     for (Iterator i$ = PetEquipConditionManager.getInstance().siftByCondition(subid, condition, isPub).iterator(); i$.hasNext();) { long marketId = ((Long)i$.next()).longValue();
/*     */       
/* 200 */       int price = MarketInterface.getPrice(subid, marketId, isPub);
/* 201 */       if (price != -1)
/*     */       {
/* 203 */         itemChartObjs.add(new ItemChartObj(marketId, price));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 208 */         logStr = String.format("[marketsearch]PetEquipQueryCache.buildByConditionFromIndex@marketId is not exists|subid=%d|property=%d|skillids=%s|marketId=%d|state=%d", new Object[] { Integer.valueOf(subid), Integer.valueOf(condition.getProperty()), condition.getSkillIds().toString(), Long.valueOf(marketId), Integer.valueOf(state) });
/*     */         
/*     */ 
/* 211 */         MarketInterface.getLogger().info(logStr);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 216 */     itemConditionNode.addItemChartObjs(subid, condition, itemChartObjs);
/* 217 */     long end = DateTimeUtils.getCurrTimeInMillis();
/* 218 */     logStr = String.format("[marketsearch]PetEquipQueryCache.buildByConditionFromIndex@end search|subid=%d|property=%d|skillids=%s|resultNum=%d|state=%d|useTime=%d", new Object[] { Integer.valueOf(subid), Integer.valueOf(condition.getProperty()), condition.getSkillIds().toString(), Integer.valueOf(itemChartObjs.size()), Integer.valueOf(state), Long.valueOf(end - start) });
/*     */     
/*     */ 
/*     */ 
/* 222 */     MarketInterface.getLogger().info(logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getSize(int subid, PetEquipCondition condition, int state)
/*     */   {
/* 234 */     ItemConditionNode itemConditionNode = null;
/* 235 */     if (state == 2)
/*     */     {
/* 237 */       itemConditionNode = this.sellEquipConditionNode;
/*     */     }
/*     */     else
/*     */     {
/* 241 */       itemConditionNode = this.pubEquipConditionNode;
/*     */     }
/* 243 */     return itemConditionNode.getSize(subid, condition);
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
/*     */ 
/*     */   public List<ItemChartObj> getItemChartObjByPage(int subid, PetEquipCondition condition, int state, boolean isAsc, int pageNum)
/*     */   {
/* 260 */     List<ItemChartObj> marketIds = null;
/* 261 */     if (state == 2)
/*     */     {
/* 263 */       marketIds = this.sellEquipConditionNode.getItemChartObjByPage(subid, condition, isAsc, pageNum);
/*     */     }
/*     */     else
/*     */     {
/* 267 */       marketIds = this.pubEquipConditionNode.getItemChartObjByPage(subid, condition, isAsc, pageNum);
/*     */     }
/*     */     
/* 270 */     return marketIds;
/*     */   }
/*     */   
/*     */ 
/*     */   private void removeItemChartObj(int subid, PetEquipCondition condition, long marketId, boolean isPub)
/*     */   {
/* 276 */     if (isPub)
/*     */     {
/* 278 */       this.pubEquipConditionNode.removeItemChartObj(subid, condition, marketId);
/*     */     }
/*     */     else
/*     */     {
/* 282 */       this.sellEquipConditionNode.removeItemChartObj(subid, condition, marketId);
/*     */     }
/*     */   }
/*     */   
/*     */   private void addItemChartObj(int subid, PetEquipCondition condition, ItemChartObj itemChartObj, boolean isPub)
/*     */   {
/* 288 */     if (isPub)
/*     */     {
/* 290 */       this.pubEquipConditionNode.addItemChartObj(subid, condition, itemChartObj);
/*     */     }
/*     */     else
/*     */     {
/* 294 */       this.sellEquipConditionNode.addItemChartObj(subid, condition, itemChartObj);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void clear(int subid, PetEquipCondition condition, boolean isPub)
/*     */   {
/* 306 */     if (isPub)
/*     */     {
/* 308 */       this.pubEquipConditionNode.clear(subid, condition);
/*     */     }
/*     */     else
/*     */     {
/* 312 */       this.sellEquipConditionNode.clear(subid, condition);
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
/*     */   private Set<AbstractCondition<MarketItem>> getAllConditions(int subid, boolean isPub)
/*     */   {
/* 325 */     if (isPub)
/*     */     {
/* 327 */       return this.pubEquipConditionNode.getAllConditions(subid);
/*     */     }
/*     */     
/*     */ 
/* 331 */     return this.sellEquipConditionNode.getAllConditions(subid);
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
/*     */   public void addItemIntoCache(int subid, long marketId, MarketItem xMarketItem, boolean isPub)
/*     */   {
/* 345 */     Set<AbstractCondition<MarketItem>> conditions = getAllConditions(subid, isPub);
/*     */     
/* 347 */     if ((conditions != null) && (!conditions.isEmpty()))
/*     */     {
/*     */ 
/* 350 */       for (AbstractCondition<MarketItem> c : conditions)
/*     */       {
/* 352 */         PetEquipCondition petEquipCondition = (PetEquipCondition)c;
/* 353 */         if (petEquipCondition.isTrue(xMarketItem))
/*     */         {
/*     */ 
/* 356 */           addItemChartObj(subid, petEquipCondition, new ItemChartObj(marketId, xMarketItem.getPrice()), isPub);
/*     */         }
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
/*     */ 
/*     */ 
/*     */ 
/*     */   public void removeItemFromCache(int subid, long marketId, MarketItem xMarketItem, boolean isPub)
/*     */   {
/* 375 */     Set<AbstractCondition<MarketItem>> conditions = getAllConditions(subid, isPub);
/*     */     
/* 377 */     if ((conditions != null) && (!conditions.isEmpty()))
/*     */     {
/*     */ 
/* 380 */       for (AbstractCondition<MarketItem> c : conditions)
/*     */       {
/* 382 */         PetEquipCondition petEquipCondition = (PetEquipCondition)c;
/* 383 */         if (petEquipCondition.isTrue(xMarketItem))
/*     */         {
/*     */ 
/* 386 */           removeItemChartObj(subid, petEquipCondition, marketId, isPub);
/*     */         }
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
/*     */ 
/*     */ 
/*     */   public void clearCache(MarketItem xMarketItem, int subid, boolean isPub)
/*     */   {
/* 404 */     Set<AbstractCondition<MarketItem>> conditions = getAllConditions(subid, isPub);
/*     */     
/* 406 */     if ((conditions != null) && (!conditions.isEmpty()))
/*     */     {
/*     */ 
/* 409 */       for (AbstractCondition<MarketItem> c : conditions)
/*     */       {
/* 411 */         PetEquipCondition petEquipCondition = (PetEquipCondition)c;
/* 412 */         if (petEquipCondition.isTrue(xMarketItem))
/*     */         {
/* 414 */           clear(subid, petEquipCondition, isPub);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\PetEquipQueryCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */