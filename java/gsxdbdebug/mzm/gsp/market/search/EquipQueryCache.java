/*     */ package mzm.gsp.market.search;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import mzm.gsp.market.main.MarketLevelPriceChart;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MarketItem;
/*     */ import xtable.Marketitem;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EquipQueryCache
/*     */ {
/*  20 */   private static EquipQueryCache instance = new EquipQueryCache();
/*     */   private final ItemConditionNode pubEquipConditionNode;
/*     */   private final ItemConditionNode sellEquipConditionNode;
/*     */   
/*  24 */   public static EquipQueryCache getInstance() { return instance; }
/*     */   
/*     */ 
/*     */ 
/*     */   private EquipQueryCache()
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
/*     */   public void buildByCondition(int subid, EquipCondition condition, int state)
/*     */   {
/*  50 */     ItemConditionNode itemConditionNode = null;
/*  51 */     if (state == 2)
/*     */     {
/*  53 */       itemConditionNode = this.sellEquipConditionNode;
/*     */     }
/*     */     else
/*     */     {
/*  57 */       itemConditionNode = this.pubEquipConditionNode;
/*     */     }
/*  59 */     int size = itemConditionNode.getSize(subid, condition);
/*     */     
/*  61 */     if (size != -1)
/*     */     {
/*  63 */       return;
/*     */     }
/*  65 */     List<MarketLevelPriceChart> marketLevelCharts = MarketInterface.getBySubidlevel(subid, condition.getLevel(), state == 1);
/*     */     
/*     */ 
/*  68 */     String log = String.format("[marketsearch]EquipQueryCache.buildByCondition@start search|subid=%d|level=%d|colors=%s", new Object[] { Integer.valueOf(subid), Integer.valueOf(condition.getLevel()), condition.getColors().toString() });
/*     */     
/*     */ 
/*  71 */     MarketInterface.getLogger().info(log);
/*     */     
/*  73 */     int i = 0;
/*  74 */     for (MarketLevelPriceChart mc : marketLevelCharts)
/*     */     {
/*  76 */       MarketItem xMarketItem = Marketitem.select(Long.valueOf(mc.getMarketId()));
/*  77 */       if (xMarketItem != null)
/*     */       {
/*  79 */         itemConditionNode.addItemChartObj(subid, condition, new ItemChartObj(mc.getMarketId(), mc.getPrice()));
/*     */         
/*  81 */         i++;
/*     */       }
/*     */     }
/*     */     
/*  85 */     log = String.format("[marketsearch]EquipQueryCache.buildByCondition@end search|subid=%d|level=%d|colors=%s|resultNum=%d", new Object[] { Integer.valueOf(subid), Integer.valueOf(condition.getLevel()), condition.getColors().toString(), Integer.valueOf(i) });
/*     */     
/*     */ 
/*     */ 
/*  89 */     MarketInterface.getLogger().info(log);
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
/*     */   public void buildByConditionAll(int subid, EquipCondition condition, int state)
/*     */   {
/* 102 */     ItemConditionNode itemConditionNode = null;
/* 103 */     if (state == 2)
/*     */     {
/* 105 */       itemConditionNode = this.sellEquipConditionNode;
/*     */     }
/*     */     else
/*     */     {
/* 109 */       itemConditionNode = this.pubEquipConditionNode;
/*     */     }
/* 111 */     int size = itemConditionNode.getSize(subid, condition);
/*     */     
/* 113 */     if (size != -1)
/*     */     {
/* 115 */       return;
/*     */     }
/* 117 */     List<MarketLevelPriceChart> marketLevelCharts = MarketInterface.getBySubidlevel(subid, condition.getLevel(), state == 1);
/*     */     
/*     */ 
/* 120 */     String log = String.format("[marketsearch]EquipQueryCache.buildByConditionAll@start search|subid=%d|level=%d|colors=%s", new Object[] { Integer.valueOf(subid), Integer.valueOf(condition.getLevel()), condition.getColors().toString() });
/*     */     
/*     */ 
/*     */ 
/* 124 */     MarketInterface.getLogger().info(log);
/*     */     
/* 126 */     List<ItemChartObj> itemChartObjs = new ArrayList();
/* 127 */     for (MarketLevelPriceChart mc : marketLevelCharts)
/*     */     {
/* 129 */       MarketItem xMarketItem = Marketitem.select(Long.valueOf(mc.getMarketId()));
/* 130 */       if ((xMarketItem != null) && (condition.isTrue(xMarketItem)))
/*     */       {
/* 132 */         itemChartObjs.add(new ItemChartObj(mc.getMarketId(), mc.getPrice()));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 137 */     itemConditionNode.addItemChartObjs(subid, condition, itemChartObjs);
/* 138 */     log = String.format("[marketsearch]EquipQueryCache.buildByConditionAll@end search|subid=%d|level=%d|colors=%s|resultNum=%d", new Object[] { Integer.valueOf(subid), Integer.valueOf(condition.getLevel()), condition.getColors().toString(), Integer.valueOf(itemChartObjs.size()) });
/*     */     
/*     */ 
/*     */ 
/* 142 */     MarketInterface.getLogger().info(log);
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
/*     */   public void buildByConditionFromIndex(int subid, EquipCondition condition, int state)
/*     */   {
/* 155 */     ItemConditionNode itemConditionNode = null;
/* 156 */     if (state == 2)
/*     */     {
/* 158 */       itemConditionNode = this.sellEquipConditionNode;
/*     */     }
/*     */     else
/*     */     {
/* 162 */       itemConditionNode = this.pubEquipConditionNode;
/*     */     }
/* 164 */     int size = itemConditionNode.getSize(subid, condition);
/*     */     
/* 166 */     if (size != -1)
/*     */     {
/* 168 */       String log = String.format("[marketsearch]EquipQueryCache.buildByConditionFromIndex@condition already searched|subid=%d|level=%d|colors=%s|resultNum=%d|state=%d", new Object[] { Integer.valueOf(subid), Integer.valueOf(condition.getLevel()), condition.getColors().toString(), Integer.valueOf(size), Integer.valueOf(state) });
/*     */       
/*     */ 
/*     */ 
/* 172 */       MarketInterface.getLogger().info(log);
/*     */       
/* 174 */       return;
/*     */     }
/*     */     
/* 177 */     String log = String.format("[marketsearch]EquipQueryCache.buildByConditionFromIndex@start search|subid=%d|level=%d|colors=%s", new Object[] { Integer.valueOf(subid), Integer.valueOf(condition.getLevel()), condition.getColors().toString() });
/*     */     
/*     */ 
/*     */ 
/* 181 */     MarketInterface.getLogger().info(log);
/*     */     
/* 183 */     long start = DateTimeUtils.getCurrTimeInMillis();
/* 184 */     List<ItemChartObj> itemChartObjs = new ArrayList();
/* 185 */     boolean isPub = state == 1;
/* 186 */     for (Iterator i$ = EquipConditionManager.getInstance().siftByCondition(subid, condition, isPub).iterator(); i$.hasNext();) { long marketId = ((Long)i$.next()).longValue();
/*     */       
/* 188 */       int price = MarketInterface.getPrice(subid, condition.getLevel(), marketId, isPub);
/* 189 */       if (price != -1)
/*     */       {
/* 191 */         itemChartObjs.add(new ItemChartObj(marketId, price));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 196 */         String logStr = String.format("[marketsearch]EquipQueryCache.buildByConditionFromIndex@marketId is not exists|subid=%d|level=%d|skillids=%s|marketId=%d|state=%d", new Object[] { Integer.valueOf(subid), Integer.valueOf(condition.getLevel()), condition.getSkillIds().toString(), Long.valueOf(marketId), Integer.valueOf(state) });
/*     */         
/*     */ 
/* 199 */         MarketInterface.getLogger().info(logStr);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 205 */     itemConditionNode.addItemChartObjs(subid, condition, itemChartObjs);
/* 206 */     long end = DateTimeUtils.getCurrTimeInMillis();
/* 207 */     log = String.format("[marketsearch]EquipQueryCache.buildByConditionFromIndex@end search|subid=%d|level=%d|colors=%s|resultNum=%d|state=%d|useTime=%d", new Object[] { Integer.valueOf(subid), Integer.valueOf(condition.getLevel()), condition.getColors().toString(), Integer.valueOf(itemChartObjs.size()), Integer.valueOf(state), Long.valueOf(end - start) });
/*     */     
/*     */ 
/*     */ 
/* 211 */     MarketInterface.getLogger().info(log);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getSize(int subid, EquipCondition condition, int state)
/*     */   {
/* 223 */     ItemConditionNode itemConditionNode = null;
/* 224 */     if (state == 2)
/*     */     {
/* 226 */       itemConditionNode = this.sellEquipConditionNode;
/*     */     }
/*     */     else
/*     */     {
/* 230 */       itemConditionNode = this.pubEquipConditionNode;
/*     */     }
/* 232 */     return itemConditionNode.getSize(subid, condition);
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
/*     */   public List<ItemChartObj> getItemChartObjByPage(int subid, EquipCondition condition, int state, boolean isAsc, int pageNo)
/*     */   {
/* 248 */     List<ItemChartObj> marketIds = null;
/* 249 */     if (state == 2)
/*     */     {
/* 251 */       marketIds = this.sellEquipConditionNode.getItemChartObjByPage(subid, condition, isAsc, pageNo);
/*     */     }
/*     */     else
/*     */     {
/* 255 */       marketIds = this.pubEquipConditionNode.getItemChartObjByPage(subid, condition, isAsc, pageNo);
/*     */     }
/*     */     
/* 258 */     return marketIds;
/*     */   }
/*     */   
/*     */ 
/*     */   private void removeItemChartObj(int subid, EquipCondition condition, long marketId, boolean isPub)
/*     */   {
/* 264 */     if (isPub)
/*     */     {
/* 266 */       this.pubEquipConditionNode.removeItemChartObj(subid, condition, marketId);
/*     */     }
/*     */     else
/*     */     {
/* 270 */       this.sellEquipConditionNode.removeItemChartObj(subid, condition, marketId);
/*     */     }
/*     */   }
/*     */   
/*     */   private void addItemChartObj(int subid, EquipCondition condition, ItemChartObj itemChartObj, boolean isPub)
/*     */   {
/* 276 */     if (isPub)
/*     */     {
/* 278 */       this.pubEquipConditionNode.addItemChartObj(subid, condition, itemChartObj);
/*     */     }
/*     */     else
/*     */     {
/* 282 */       this.sellEquipConditionNode.addItemChartObj(subid, condition, itemChartObj);
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
/*     */   public void clear(int subid, EquipCondition condition, boolean isPub)
/*     */   {
/* 295 */     if (isPub)
/*     */     {
/* 297 */       this.pubEquipConditionNode.clear(subid, condition);
/*     */     }
/*     */     else
/*     */     {
/* 301 */       this.sellEquipConditionNode.clear(subid, condition);
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
/* 314 */     if (isPub)
/*     */     {
/* 316 */       return this.pubEquipConditionNode.getAllConditions(subid);
/*     */     }
/*     */     
/*     */ 
/* 320 */     return this.sellEquipConditionNode.getAllConditions(subid);
/*     */   }
/*     */   
/*     */ 
/*     */   public void addItemIntoCache(int subid, long marketId, MarketItem xMarketItem, boolean isPub)
/*     */   {
/* 326 */     Set<AbstractCondition<MarketItem>> conditions = getAllConditions(subid, isPub);
/*     */     
/* 328 */     if ((conditions != null) && (!conditions.isEmpty()))
/*     */     {
/*     */ 
/* 331 */       for (AbstractCondition<MarketItem> c : conditions)
/*     */       {
/* 333 */         EquipCondition equipCondition = (EquipCondition)c;
/* 334 */         if (equipCondition.isTrue(xMarketItem))
/*     */         {
/*     */ 
/* 337 */           addItemChartObj(subid, equipCondition, new ItemChartObj(marketId, xMarketItem.getPrice()), isPub);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void removeItemFromCache(int subid, long marketId, MarketItem xMarketItem, boolean isPub)
/*     */   {
/* 348 */     Set<AbstractCondition<MarketItem>> conditions = getAllConditions(subid, isPub);
/*     */     
/* 350 */     if ((conditions != null) && (!conditions.isEmpty()))
/*     */     {
/*     */ 
/* 353 */       for (AbstractCondition<MarketItem> c : conditions)
/*     */       {
/* 355 */         EquipCondition equipCondition = (EquipCondition)c;
/* 356 */         if (equipCondition.isTrue(xMarketItem))
/*     */         {
/*     */ 
/* 359 */           removeItemChartObj(subid, equipCondition, marketId, isPub);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void clearCache(MarketItem xMarketItem, int subid, boolean isPub)
/*     */   {
/* 370 */     Set<AbstractCondition<MarketItem>> conditions = getAllConditions(subid, isPub);
/*     */     
/* 372 */     if ((conditions != null) && (!conditions.isEmpty()))
/*     */     {
/*     */ 
/* 375 */       for (AbstractCondition<MarketItem> c : conditions)
/*     */       {
/* 377 */         EquipCondition equipCondition = (EquipCondition)c;
/* 378 */         if (equipCondition.isTrue(xMarketItem))
/*     */         {
/* 380 */           clear(subid, equipCondition, isPub);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\EquipQueryCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */