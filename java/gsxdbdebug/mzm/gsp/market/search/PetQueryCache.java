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
/*     */ import xbean.MarketPet;
/*     */ import xtable.Marketpet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PetQueryCache
/*     */ {
/*  20 */   private static PetQueryCache instance = new PetQueryCache();
/*     */   private final PetConditionNode pubPetConditionNode;
/*     */   private final PetConditionNode sellPetConditionNode;
/*     */   
/*  24 */   public static PetQueryCache getInstance() { return instance; }
/*     */   
/*     */ 
/*     */ 
/*     */   private PetQueryCache()
/*     */   {
/*  30 */     this.pubPetConditionNode = new PetConditionNode();
/*  31 */     this.sellPetConditionNode = new PetConditionNode();
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
/*     */   public void buildByCondition(int subid, PetCondition condition, int state)
/*     */   {
/*  51 */     PetConditionNode petConditionNode = null;
/*  52 */     if (state == 2)
/*     */     {
/*  54 */       petConditionNode = this.sellPetConditionNode;
/*     */     }
/*     */     else
/*     */     {
/*  58 */       petConditionNode = this.pubPetConditionNode;
/*     */     }
/*  60 */     int size = petConditionNode.getSize(subid, condition);
/*     */     
/*  62 */     if (size != -1)
/*     */     {
/*  64 */       return;
/*     */     }
/*  66 */     List<MarketPriceChart> marketPriceCharts = MarketInterface.getBySubid(subid, state == 1);
/*     */     
/*  68 */     if (marketPriceCharts == null)
/*     */     {
/*  70 */       return;
/*     */     }
/*     */     
/*  73 */     String logStr = String.format("[marketsearch]PetQueryCache.buildByCondition@start search|subid=%d|petTypes=%s|skillids=%s|qualitys=%s|skillnum=%d", new Object[] { Integer.valueOf(subid), condition.getPetTypes().toString(), condition.getSkillIds().toString(), condition.getQualitys().toString(), Integer.valueOf(condition.getSkillNum()) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  78 */     MarketInterface.getLogger().info(logStr);
/*     */     
/*  80 */     int i = 0;
/*  81 */     for (MarketPriceChart mc : marketPriceCharts)
/*     */     {
/*  83 */       MarketPet xMarketPet = Marketpet.select(Long.valueOf(mc.getMarketId()));
/*  84 */       if ((xMarketPet != null) && (condition.isTrue(xMarketPet)))
/*     */       {
/*  86 */         petConditionNode.addPetChartObj(subid, condition, new PetChartObj(mc.getMarketId(), mc.getPrice()));
/*     */         
/*  88 */         i++;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  93 */     logStr = String.format("[marketsearch]PetQueryCache.buildByCondition@end search|subid=%d|petTypes=%s|skillids=%s|qualitys=%s|skillnum=%d|resultNum", new Object[] { Integer.valueOf(subid), condition.getPetTypes().toString(), condition.getSkillIds().toString(), condition.getQualitys().toString(), Integer.valueOf(condition.getSkillNum()), Integer.valueOf(i) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  98 */     MarketInterface.getLogger().info(logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void buildByConditionAll(int subid, PetCondition condition, int state)
/*     */   {
/* 110 */     PetConditionNode petConditionNode = null;
/* 111 */     if (state == 2)
/*     */     {
/* 113 */       petConditionNode = this.sellPetConditionNode;
/*     */     }
/*     */     else
/*     */     {
/* 117 */       petConditionNode = this.pubPetConditionNode;
/*     */     }
/* 119 */     int size = petConditionNode.getSize(subid, condition);
/*     */     
/* 121 */     if (size != -1)
/*     */     {
/* 123 */       return;
/*     */     }
/* 125 */     List<MarketPriceChart> marketPriceCharts = MarketInterface.getBySubid(subid, state == 1);
/*     */     
/* 127 */     if (marketPriceCharts == null)
/*     */     {
/* 129 */       return;
/*     */     }
/*     */     
/* 132 */     String logStr = String.format("[marketsearch]PetQueryCache.buildByConditionAll@start search|subid=%d|petTypes=%s|skillids=%s|qualitys=%s|skillnum=%d", new Object[] { Integer.valueOf(subid), condition.getPetTypes().toString(), condition.getSkillIds().toString(), condition.getQualitys().toString(), Integer.valueOf(condition.getSkillNum()) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 137 */     MarketInterface.getLogger().info(logStr);
/*     */     
/* 139 */     List<PetChartObj> petChartObjs = new ArrayList();
/* 140 */     for (MarketPriceChart mc : marketPriceCharts)
/*     */     {
/* 142 */       MarketPet xMarketPet = Marketpet.select(Long.valueOf(mc.getMarketId()));
/* 143 */       if (xMarketPet != null)
/*     */       {
/* 145 */         petChartObjs.add(new PetChartObj(mc.getMarketId(), mc.getPrice()));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 150 */     petConditionNode.addPetChartObjs(subid, condition, petChartObjs);
/* 151 */     logStr = String.format("[marketsearch]PetQueryCache.buildByConditionAll@end search|subid=%d|petTypes=%s|skillids=%s|qualitys=%s|skillnum=%d|resultNum", new Object[] { Integer.valueOf(subid), condition.getPetTypes().toString(), condition.getSkillIds().toString(), condition.getQualitys().toString(), Integer.valueOf(condition.getSkillNum()), Integer.valueOf(petChartObjs.size()) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 156 */     MarketInterface.getLogger().info(logStr);
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
/*     */   public void buildByConditionFromIndex(int subid, PetCondition condition, int state)
/*     */   {
/* 169 */     PetConditionNode petConditionNode = null;
/* 170 */     if (state == 2)
/*     */     {
/* 172 */       petConditionNode = this.sellPetConditionNode;
/*     */     }
/*     */     else
/*     */     {
/* 176 */       petConditionNode = this.pubPetConditionNode;
/*     */     }
/* 178 */     int size = petConditionNode.getSize(subid, condition);
/*     */     
/* 180 */     if (size != -1)
/*     */     {
/* 182 */       String logStr = String.format("[marketsearch]PetQueryCache.buildByConditionFromIndex@condition already searched|subid=%d|petTypes=%s|skillids=%s|qualitys=%s|skillnum=%d|resultNum=%d|state=%d", new Object[] { Integer.valueOf(subid), condition.getPetTypes().toString(), condition.getSkillIds().toString(), condition.getQualitys().toString(), Integer.valueOf(condition.getSkillNum()), Integer.valueOf(size), Integer.valueOf(state) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 187 */       MarketInterface.getLogger().info(logStr);
/* 188 */       return;
/*     */     }
/*     */     
/* 191 */     String logStr = String.format("[marketsearch]PetQueryCache.buildByConditionFromIndex@start search|subid=%d|petTypes=%s|skillids=%s|qualitys=%s|skillnum=%d", new Object[] { Integer.valueOf(subid), condition.getPetTypes().toString(), condition.getSkillIds().toString(), condition.getQualitys().toString(), Integer.valueOf(condition.getSkillNum()) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 196 */     MarketInterface.getLogger().info(logStr);
/* 197 */     long start = DateTimeUtils.getCurrTimeInMillis();
/* 198 */     List<PetChartObj> petChartObjs = new ArrayList();
/* 199 */     boolean isPub = state == 1;
/* 200 */     for (Iterator i$ = PetConditionManager.getInstance().siftByCondition(subid, condition, isPub).iterator(); i$.hasNext();) { long marketId = ((Long)i$.next()).longValue();
/*     */       
/*     */ 
/* 203 */       int price = MarketInterface.getPrice(subid, marketId, isPub);
/* 204 */       if (price != -1)
/*     */       {
/* 206 */         petChartObjs.add(new PetChartObj(marketId, price));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 211 */         logStr = String.format("[marketsearch]PetQueryCache.buildByConditionFromIndex@marketId is not exists|subid=%d|skillids=%s|marketId=%d|state=%d", new Object[] { Integer.valueOf(subid), condition.getSkillIds().toString(), Long.valueOf(marketId), Integer.valueOf(state) });
/*     */         
/*     */ 
/* 214 */         MarketInterface.getLogger().info(logStr);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 220 */     petConditionNode.addPetChartObjs(subid, condition, petChartObjs);
/* 221 */     long end = DateTimeUtils.getCurrTimeInMillis();
/* 222 */     logStr = String.format("[marketsearch]PetQueryCache.buildByConditionFromIndex@end search|subid=%d|petTypes=%s|skillids=%s|qualitys=%s|skillnum=%d|resultNum=%d|state=%d|useTime=%d", new Object[] { Integer.valueOf(subid), condition.getPetTypes().toString(), condition.getSkillIds().toString(), condition.getQualitys().toString(), Integer.valueOf(condition.getSkillNum()), Integer.valueOf(petChartObjs.size()), Integer.valueOf(state), Long.valueOf(end - start) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 227 */     MarketInterface.getLogger().info(logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getSize(int subid, PetCondition condition, int state)
/*     */   {
/* 238 */     PetConditionNode petConditionNode = null;
/* 239 */     if (state == 2)
/*     */     {
/* 241 */       petConditionNode = this.sellPetConditionNode;
/*     */     }
/*     */     else
/*     */     {
/* 245 */       petConditionNode = this.pubPetConditionNode;
/*     */     }
/* 247 */     return petConditionNode.getSize(subid, condition);
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
/*     */   public List<PetChartObj> getPetChartObjByPage(int subid, PetCondition condition, int state, boolean isAsc, int pageNo)
/*     */   {
/* 263 */     List<PetChartObj> petChartObjs = null;
/* 264 */     if (state == 2)
/*     */     {
/* 266 */       petChartObjs = this.sellPetConditionNode.getPetChartObjByPage(subid, condition, isAsc, pageNo);
/*     */     }
/*     */     else
/*     */     {
/* 270 */       petChartObjs = this.pubPetConditionNode.getPetChartObjByPage(subid, condition, isAsc, pageNo);
/*     */     }
/*     */     
/* 273 */     return petChartObjs;
/*     */   }
/*     */   
/*     */ 
/*     */   private void removePetChartObj(int subid, PetCondition condition, long marketId, boolean isPub)
/*     */   {
/* 279 */     if (isPub)
/*     */     {
/* 281 */       this.pubPetConditionNode.removePetChartObj(subid, condition, marketId);
/*     */     }
/*     */     else
/*     */     {
/* 285 */       this.sellPetConditionNode.removePetChartObj(subid, condition, marketId);
/*     */     }
/*     */   }
/*     */   
/*     */   private void addPetChartObj(int subid, PetCondition condition, PetChartObj petChartObj, boolean isPub)
/*     */   {
/* 291 */     if (isPub)
/*     */     {
/* 293 */       this.pubPetConditionNode.addPetChartObj(subid, condition, petChartObj);
/*     */     }
/*     */     else
/*     */     {
/* 297 */       this.sellPetConditionNode.addPetChartObj(subid, condition, petChartObj);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void clear(int subid, PetCondition condition, boolean isPub)
/*     */   {
/* 309 */     if (isPub)
/*     */     {
/* 311 */       this.pubPetConditionNode.clear(subid, condition);
/*     */     }
/*     */     else
/*     */     {
/* 315 */       this.sellPetConditionNode.clear(subid, condition);
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
/*     */   private Set<AbstractCondition<MarketPet>> getAllConditions(int subid, boolean isPub)
/*     */   {
/* 328 */     if (isPub)
/*     */     {
/* 330 */       return this.pubPetConditionNode.getAllConditions(subid);
/*     */     }
/*     */     
/*     */ 
/* 334 */     return this.sellPetConditionNode.getAllConditions(subid);
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
/*     */   public void addPetIntoCache(int subid, long marketId, MarketPet xMarketPet, boolean isPub)
/*     */   {
/* 348 */     Set<AbstractCondition<MarketPet>> conditions = getAllConditions(subid, isPub);
/*     */     
/* 350 */     if ((conditions != null) && (!conditions.isEmpty()))
/*     */     {
/*     */ 
/* 353 */       for (AbstractCondition<MarketPet> c : conditions)
/*     */       {
/* 355 */         PetCondition petCondition = (PetCondition)c;
/* 356 */         if (petCondition.isTrue(xMarketPet))
/*     */         {
/*     */ 
/* 359 */           addPetChartObj(subid, petCondition, new PetChartObj(marketId, xMarketPet.getPrice()), isPub);
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
/*     */   public void removePetFromCache(int subid, long marketId, MarketPet xMarketPet, boolean isPub)
/*     */   {
/* 378 */     Set<AbstractCondition<MarketPet>> conditions = getAllConditions(subid, isPub);
/*     */     
/* 380 */     if ((conditions != null) && (!conditions.isEmpty()))
/*     */     {
/*     */ 
/* 383 */       for (AbstractCondition<MarketPet> c : conditions)
/*     */       {
/* 385 */         PetCondition petCondition = (PetCondition)c;
/* 386 */         if (petCondition.isTrue(xMarketPet))
/*     */         {
/*     */ 
/* 389 */           removePetChartObj(subid, petCondition, marketId, isPub);
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
/*     */   public void clearCache(MarketPet xMarketPet, int subid, boolean isPub)
/*     */   {
/* 408 */     Set<AbstractCondition<MarketPet>> conditions = getAllConditions(subid, isPub);
/*     */     
/* 410 */     if ((conditions != null) && (!conditions.isEmpty()))
/*     */     {
/*     */ 
/* 413 */       for (AbstractCondition<MarketPet> c : conditions)
/*     */       {
/* 415 */         PetCondition petCondition = (PetCondition)c;
/* 416 */         if (petCondition.isTrue(xMarketPet))
/*     */         {
/* 418 */           clear(subid, petCondition, isPub);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\PetQueryCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */