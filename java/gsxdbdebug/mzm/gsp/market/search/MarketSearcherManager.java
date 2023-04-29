/*     */ package mzm.gsp.market.search;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import mzm.gsp.market.SSearchEquipRes;
/*     */ import mzm.gsp.market.SSearchPetEquipRes;
/*     */ import mzm.gsp.market.SSearchPetRes;
/*     */ import mzm.gsp.market.confbean.SMarketConsts;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CustommizedCons;
/*     */ import xbean.MarketEquipCon;
/*     */ import xbean.MarketPetCon;
/*     */ import xbean.MarketPetEquipCon;
/*     */ 
/*     */ public class MarketSearcherManager
/*     */ {
/*  21 */   private static AtomicInteger itemSubIdCacheNum = new AtomicInteger(64);
/*  22 */   private static AtomicInteger petSubIdCacheNum = new AtomicInteger(64);
/*     */   
/*     */   public static int getItemSubIdCacheNum()
/*     */   {
/*  26 */     return itemSubIdCacheNum.get();
/*     */   }
/*     */   
/*     */   public static int getPetSubIdCacheNum()
/*     */   {
/*  31 */     return petSubIdCacheNum.get();
/*     */   }
/*     */   
/*     */   public static void setItemSubIdCacheNum(int cacheSize)
/*     */   {
/*  36 */     itemSubIdCacheNum.set(cacheSize);
/*     */   }
/*     */   
/*     */   public static void setPetSubIdCacheNum(int cacheSize)
/*     */   {
/*  41 */     petSubIdCacheNum.set(cacheSize);
/*     */   }
/*     */   
/*     */ 
/*     */   public static EquipCondition getEquipConditionFromProtocol(mzm.gsp.market.EquipCondition equipCondition)
/*     */   {
/*  47 */     EquipCondition t = new EquipCondition(equipCondition.level, equipCondition.colors, equipCondition.skillids);
/*     */     
/*     */ 
/*  50 */     return t;
/*     */   }
/*     */   
/*     */   public static PetEquipCondition getPetEquipConditionFromProtocol(mzm.gsp.market.PetEquipCondition petEquipCondition)
/*     */   {
/*  55 */     PetEquipCondition t = new PetEquipCondition(petEquipCondition.property, petEquipCondition.skillids);
/*     */     
/*     */ 
/*  58 */     return t;
/*     */   }
/*     */   
/*     */   public static PetCondition getPetConditionFromProtocol(mzm.gsp.market.PetCondition petCondition)
/*     */   {
/*  63 */     PetCondition t = new PetCondition(petCondition.pettypes, petCondition.qualitys, petCondition.skillnum, petCondition.skillids);
/*     */     
/*     */ 
/*  66 */     return t;
/*     */   }
/*     */   
/*     */   public static mzm.gsp.market.EquipCondition getEquipConditionFromXbean(int subid, MarketEquipCon equipCondition)
/*     */   {
/*  71 */     mzm.gsp.market.EquipCondition t = new mzm.gsp.market.EquipCondition(subid, equipCondition.getLevel(), new HashSet(equipCondition.getColors()), new HashSet(equipCondition.getSkillids()), equipCondition.getCusttime());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  76 */     return t;
/*     */   }
/*     */   
/*     */ 
/*     */   public static mzm.gsp.market.PetEquipCondition getPetEquipConditionFromXbean(int subid, MarketPetEquipCon petEquipCondition)
/*     */   {
/*  82 */     mzm.gsp.market.PetEquipCondition t = new mzm.gsp.market.PetEquipCondition(subid, petEquipCondition.getProperty(), new HashSet(petEquipCondition.getSkillids()), petEquipCondition.getCusttime());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  89 */     return t;
/*     */   }
/*     */   
/*     */   public static mzm.gsp.market.PetCondition getPetConditionFromXbean(int subid, MarketPetCon petCondition)
/*     */   {
/*  94 */     mzm.gsp.market.PetCondition t = new mzm.gsp.market.PetCondition(subid, new HashSet(petCondition.getQualitys()), new HashSet(petCondition.getPettypes()), petCondition.getSkillnum(), new HashSet(petCondition.getSkillids()), petCondition.getCusttime());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 101 */     return t;
/*     */   }
/*     */   
/*     */   public static EquipCondition getEquipConditionFromXbean(MarketEquipCon equipCondition)
/*     */   {
/* 106 */     EquipCondition t = new EquipCondition(equipCondition.getLevel(), equipCondition.getColors(), equipCondition.getSkillids());
/*     */     
/*     */ 
/*     */ 
/* 110 */     return t;
/*     */   }
/*     */   
/*     */ 
/*     */   public static PetEquipCondition getPetEquipConditionFromXbean(MarketPetEquipCon petEquipCondition)
/*     */   {
/* 116 */     PetEquipCondition t = new PetEquipCondition(petEquipCondition.getProperty(), petEquipCondition.getSkillids());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 122 */     return t;
/*     */   }
/*     */   
/*     */   public static PetCondition getPetConditionFromXbean(MarketPetCon petCondition)
/*     */   {
/* 127 */     PetCondition t = new PetCondition(petCondition.getPettypes(), petCondition.getQualitys(), petCondition.getSkillnum(), petCondition.getSkillids());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 133 */     return t;
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
/*     */   public static void fillAndSendQueryEquipResult(long roleId, int pubOrSell, int priceSort, mzm.gsp.market.EquipCondition condition, int pageIndex)
/*     */   {
/* 147 */     int state = 1;
/* 148 */     if (pubOrSell == 1)
/*     */     {
/* 150 */       state = 2;
/*     */     }
/*     */     else
/*     */     {
/* 154 */       state = 1;
/*     */     }
/* 156 */     EquipCondition c = getEquipConditionFromProtocol(condition);
/* 157 */     SSearchEquipRes res = new SSearchEquipRes();
/* 158 */     res.condition = condition;
/* 159 */     res.puborsell = pubOrSell;
/* 160 */     res.pricesort = priceSort;
/* 161 */     res.pageresult.subid = condition.subid;
/*     */     
/* 163 */     int size = EquipQueryCache.getInstance().getSize(condition.subid, c, state);
/* 164 */     if (size == -1)
/*     */     {
/* 166 */       res.pageresult.pageindex = pageIndex;
/* 167 */       res.pageresult.totalpagenum = 0;
/*     */       
/* 169 */       OnlineManager.getInstance().send(roleId, res);
/* 170 */       String log = String.format("[marketsearch]MarketSearcherManager.fillAndSendQueryEquipResult@send query result to role success|roleid=%d|pageIndex=%d|subid=%d|level=%d|colors=%s|size=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(pageIndex), Integer.valueOf(condition.subid), Integer.valueOf(condition.level), condition.colors.toString(), Integer.valueOf(size) });
/*     */       
/*     */ 
/*     */ 
/* 174 */       MarketInterface.getLogger().info(log);
/*     */       
/* 176 */       return;
/*     */     }
/* 178 */     int pageSize = MarketInterface.getPageSize();
/* 179 */     int totalPage = (size - 1) / pageSize + 1;
/* 180 */     if (pageIndex <= 0)
/*     */     {
/* 182 */       pageIndex = 1;
/*     */     }
/* 184 */     if (pageIndex > totalPage)
/*     */     {
/* 186 */       pageIndex = totalPage;
/*     */     }
/* 188 */     res.pageresult.pageindex = pageIndex;
/* 189 */     res.pageresult.totalpagenum = totalPage;
/*     */     
/* 191 */     java.util.List<ItemChartObj> itemChartObjs = EquipQueryCache.getInstance().getItemChartObjByPage(condition.subid, c, state, priceSort == 0, pageIndex);
/*     */     
/*     */ 
/* 194 */     if (itemChartObjs != null)
/*     */     {
/* 196 */       for (ItemChartObj itemChartObj : itemChartObjs)
/*     */       {
/* 198 */         xbean.MarketItem xMarketItem = xtable.Marketitem.select(Long.valueOf(itemChartObj.getMarketId()));
/* 199 */         xbean.AuctionItemInfo xAuctionItemInfo = xtable.Marketitemid2auction.select(Long.valueOf(itemChartObj.getMarketId()));
/* 200 */         if (xMarketItem != null)
/*     */         {
/* 202 */           mzm.gsp.market.MarketItem marketItem = new mzm.gsp.market.MarketItem();
/* 203 */           MarketInterface.fillProtocolMarketItem(marketItem, itemChartObj.getMarketId(), xMarketItem, xAuctionItemInfo);
/*     */           
/*     */ 
/* 206 */           res.pageresult.marketitemlist.add(marketItem);
/*     */         }
/*     */         
/*     */       }
/*     */       
/*     */     }
/*     */     else {
/* 213 */       res.pageresult.totalpagenum = 0;
/*     */     }
/*     */     
/* 216 */     String log = String.format("[marketsearch]MarketSearcherManager.fillAndSendQueryEquipResult@send query result to role success|roleid=%d|pageIndex=%d|subid=%d|level=%d|colors=%s|size=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(pageIndex), Integer.valueOf(condition.subid), Integer.valueOf(condition.level), condition.colors.toString(), Integer.valueOf(size) });
/*     */     
/*     */ 
/*     */ 
/* 220 */     MarketInterface.getLogger().info(log);
/*     */     
/* 222 */     OnlineManager.getInstance().send(roleId, res);
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
/*     */   public static void fillAndSendQueryPetEquipResult(long roleId, int pubOrSell, int priceSort, mzm.gsp.market.PetEquipCondition condition, int pageIndex)
/*     */   {
/* 236 */     int state = 1;
/* 237 */     if (pubOrSell == 1)
/*     */     {
/* 239 */       state = 2;
/*     */     }
/*     */     else
/*     */     {
/* 243 */       state = 1;
/*     */     }
/* 245 */     PetEquipCondition c = getPetEquipConditionFromProtocol(condition);
/* 246 */     SSearchPetEquipRes res = new SSearchPetEquipRes();
/* 247 */     res.condition = condition;
/* 248 */     res.puborsell = pubOrSell;
/*     */     
/* 250 */     res.pageresult.subid = condition.subid;
/* 251 */     res.pricesort = priceSort;
/* 252 */     int size = PetEquipQueryCache.getInstance().getSize(condition.subid, c, state);
/* 253 */     if (size == -1)
/*     */     {
/* 255 */       res.pageresult.pageindex = pageIndex;
/* 256 */       res.pageresult.totalpagenum = 0;
/*     */       
/* 258 */       OnlineManager.getInstance().send(roleId, res);
/*     */       
/* 260 */       String log = String.format("[marketsearch]MarketSearcherManager.fillAndSendQueryPetEquipResult@send query result to role success|roleid=%d|tasknum=%d|subid=%d|property=%d|skillids=%s|size=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(SearchTaskManager.getInstance().taskSize()), Integer.valueOf(condition.subid), Integer.valueOf(condition.property), condition.skillids.toString(), Integer.valueOf(size) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 265 */       MarketInterface.getLogger().info(log);
/*     */       
/* 267 */       return;
/*     */     }
/* 269 */     int pageSize = MarketInterface.getPageSize();
/* 270 */     int totalPage = (size - 1) / pageSize + 1;
/* 271 */     if (pageIndex <= 0)
/*     */     {
/* 273 */       pageIndex = 1;
/*     */     }
/* 275 */     if (pageIndex > totalPage)
/*     */     {
/* 277 */       pageIndex = totalPage;
/*     */     }
/* 279 */     res.pageresult.pageindex = pageIndex;
/* 280 */     res.pageresult.totalpagenum = totalPage;
/*     */     
/* 282 */     java.util.List<ItemChartObj> itemChartObjs = PetEquipQueryCache.getInstance().getItemChartObjByPage(condition.subid, c, state, priceSort == 0, pageIndex);
/*     */     
/*     */ 
/* 285 */     if (itemChartObjs != null)
/*     */     {
/*     */ 
/* 288 */       for (ItemChartObj itemChartObj : itemChartObjs)
/*     */       {
/* 290 */         xbean.MarketItem xMarketItem = xtable.Marketitem.select(Long.valueOf(itemChartObj.getMarketId()));
/* 291 */         xbean.AuctionItemInfo xAuctionItemInfo = xtable.Marketitemid2auction.select(Long.valueOf(itemChartObj.getMarketId()));
/* 292 */         if (xMarketItem != null)
/*     */         {
/* 294 */           mzm.gsp.market.MarketItem marketItem = new mzm.gsp.market.MarketItem();
/* 295 */           MarketInterface.fillProtocolMarketItem(marketItem, itemChartObj.getMarketId(), xMarketItem, xAuctionItemInfo);
/*     */           
/*     */ 
/* 298 */           res.pageresult.marketitemlist.add(marketItem);
/*     */         }
/*     */         
/*     */       }
/*     */       
/*     */     }
/*     */     else {
/* 305 */       res.pageresult.totalpagenum = 0;
/*     */     }
/*     */     
/* 308 */     String log = String.format("[marketsearch]MarketSearcherManager.fillAndSendQueryPetEquipResult@send query result to role success|roleid=%d|tasknum=%d|subid=%d|property=%d|skillids=%s|size=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(SearchTaskManager.getInstance().taskSize()), Integer.valueOf(condition.subid), Integer.valueOf(condition.property), condition.skillids.toString(), Integer.valueOf(size) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 313 */     MarketInterface.getLogger().info(log);
/*     */     
/* 315 */     OnlineManager.getInstance().send(roleId, res);
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
/*     */   public static void fillAndSendQueryPetResult(long roleId, int pubOrSell, int priceSort, mzm.gsp.market.PetCondition condition, int pageIndex)
/*     */   {
/* 329 */     int state = 1;
/* 330 */     if (pubOrSell == 1)
/*     */     {
/* 332 */       state = 2;
/*     */     }
/*     */     else
/*     */     {
/* 336 */       state = 1;
/*     */     }
/* 338 */     PetCondition c = getPetConditionFromProtocol(condition);
/* 339 */     SSearchPetRes res = new SSearchPetRes();
/* 340 */     res.condition = condition;
/* 341 */     res.puborsell = pubOrSell;
/* 342 */     res.pricesort = priceSort;
/* 343 */     res.pageresult.subid = condition.subid;
/*     */     
/* 345 */     int size = PetQueryCache.getInstance().getSize(condition.subid, c, state);
/* 346 */     if (size == -1)
/*     */     {
/* 348 */       res.pageresult.pageindex = pageIndex;
/* 349 */       res.pageresult.totalpagenum = 0;
/*     */       
/* 351 */       OnlineManager.getInstance().send(roleId, res);
/*     */       
/* 353 */       String log = String.format("[marketsearch]MarketSearcherManager.fillAndSendQueryPetResult@send query result to role success|roleid=%d|tasknum=%d|subid=%d|petTypes=%s|skillids=%s|qualitys=%s|skillnum=%d|size=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(SearchTaskManager.getInstance().taskSize()), Integer.valueOf(condition.subid), condition.pettypes, condition.skillids.toString(), condition.qualitys.toString(), Integer.valueOf(condition.skillnum), Integer.valueOf(size) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 358 */       MarketInterface.getLogger().info(log);
/* 359 */       return;
/*     */     }
/* 361 */     int pageSize = MarketInterface.getPageSize();
/* 362 */     int totalPage = (size - 1) / pageSize + 1;
/* 363 */     if (pageIndex <= 0)
/*     */     {
/* 365 */       pageIndex = 1;
/*     */     }
/* 367 */     if (pageIndex > totalPage)
/*     */     {
/* 369 */       pageIndex = totalPage;
/*     */     }
/* 371 */     res.pageresult.pageindex = pageIndex;
/* 372 */     res.pageresult.totalpagenum = totalPage;
/*     */     
/* 374 */     int startpos = 0;
/* 375 */     int endPos = 0;
/* 376 */     if (priceSort == 0)
/*     */     {
/* 378 */       startpos = (pageIndex - 1) * MarketInterface.getPageSize();
/* 379 */       endPos = Math.min(size, startpos + pageSize);
/*     */     }
/*     */     else
/*     */     {
/* 383 */       endPos = size - (pageIndex - 1) * MarketInterface.getPageSize();
/* 384 */       startpos = Math.max(endPos - pageSize, 0);
/*     */     }
/*     */     
/*     */ 
/* 388 */     java.util.List<PetChartObj> petChartObjs = PetQueryCache.getInstance().getPetChartObjByPage(condition.subid, c, state, priceSort == 0, pageIndex);
/*     */     
/*     */ 
/* 391 */     if (petChartObjs != null)
/*     */     {
/*     */ 
/* 394 */       for (PetChartObj petChartObj : petChartObjs)
/*     */       {
/* 396 */         xbean.MarketPet xMarketPet = xtable.Marketpet.select(Long.valueOf(petChartObj.getMarketId()));
/* 397 */         xbean.AuctionPetInfo xAuctionPetInfo = xtable.Marketpetid2auction.select(Long.valueOf(petChartObj.getMarketId()));
/* 398 */         if (xMarketPet != null)
/*     */         {
/* 400 */           mzm.gsp.market.MarketPet marketPet = new mzm.gsp.market.MarketPet();
/* 401 */           MarketInterface.fillProtocolMarketPet(marketPet, petChartObj.getMarketId(), xMarketPet, xAuctionPetInfo);
/*     */           
/* 403 */           res.pageresult.marketpetlist.add(marketPet);
/*     */         }
/*     */         
/*     */       }
/*     */       
/*     */     }
/*     */     else {
/* 410 */       res.pageresult.totalpagenum = 0;
/*     */     }
/* 412 */     String log = String.format("[marketsearch]MarketSearcherManager.fillAndSendQueryPetResult@send query result to role success|roleid=%d|tasknum=%d|subid=%d|petTypes=%s|skillids=%s|qualitys=%s|skillnum=%d|size=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(SearchTaskManager.getInstance().taskSize()), Integer.valueOf(condition.subid), condition.pettypes, condition.skillids.toString(), condition.qualitys.toString(), Integer.valueOf(condition.skillnum), Integer.valueOf(size) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 417 */     MarketInterface.getLogger().info(log);
/* 418 */     OnlineManager.getInstance().send(roleId, res);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkAndSetSearchTime(long roleid)
/*     */   {
/* 429 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 430 */     CustommizedCons xCustommizedCons = xtable.Role2customized.get(Long.valueOf(roleid));
/* 431 */     if (xCustommizedCons == null)
/*     */     {
/* 433 */       xCustommizedCons = xbean.Pod.newCustommizedCons();
/* 434 */       xtable.Role2customized.insert(Long.valueOf(roleid), xCustommizedCons);
/* 435 */       xCustommizedCons.setLastsearchtime(now);
/* 436 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 441 */     if (xCustommizedCons.getLastsearchtime() + TimeUnit.SECONDS.toMillis(SMarketConsts.getInstance().MIN_SEARCH_INTERVAL) < now)
/*     */     {
/*     */ 
/* 444 */       xCustommizedCons.setLastsearchtime(now);
/* 445 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 449 */     int restTime = SMarketConsts.getInstance().MIN_SEARCH_INTERVAL - (int)TimeUnit.MILLISECONDS.toSeconds(now - xCustommizedCons.getLastsearchtime());
/*     */     
/* 451 */     if (restTime <= 0)
/*     */     {
/* 453 */       restTime = 1;
/*     */     }
/* 455 */     MarketInterface.sendSearchRestTimeRes(roleid, restTime);
/* 456 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\MarketSearcherManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */