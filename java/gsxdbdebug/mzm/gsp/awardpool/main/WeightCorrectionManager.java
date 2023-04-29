/*     */ package mzm.gsp.awardpool.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.awardpool.confbean.SAwardPoolSum;
/*     */ import mzm.gsp.awardpool.confbean.SAwardTypeId2ItemSubId;
/*     */ import mzm.gsp.awardpool.confbean.SItemPoolSub;
/*     */ import mzm.gsp.awardpool.confbean.SLotteryViewRandomCfg;
/*     */ import mzm.gsp.awardpool.confbean.SRandomTextTableCfg;
/*     */ import mzm.gsp.awardpool.confbean.STypeId2RandomTextTableCfgId;
/*     */ import mzm.gsp.awardpool.confbean.SWeightCorrectionCfg;
/*     */ import mzm.gsp.awardpool.confbean.SWeightCorrectionTypeCfg;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.WeightCorrectionCounter;
/*     */ import xbean.WeightCorrectionType2Count;
/*     */ import xtable.Role2weightcorrectioncount;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class WeightCorrectionManager
/*     */ {
/*     */   private static void refreshWeightCorrectionCounter(WeightCorrectionCounter xCounter, SWeightCorrectionTypeCfg weightCorrectionTypeCfg)
/*     */   {
/*  38 */     long lastModifyTime = xCounter.getModifytime();
/*  39 */     long currentTime = DateTimeUtils.getCurrTimeInMillis();
/*  40 */     switch (weightCorrectionTypeCfg.weightCorrectionClearType)
/*     */     {
/*     */     case 1: 
/*  43 */       if (DateTimeUtils.needDailyReset(lastModifyTime, currentTime, 0))
/*     */       {
/*  45 */         xCounter.setCount(0);
/*  46 */         xCounter.setModifytime(currentTime);
/*     */       }
/*     */       break;
/*     */     case 2: 
/*  50 */       int weeklyDay = weightCorrectionTypeCfg.weightCorrectionClearWeeklyDay;
/*  51 */       if (DateTimeUtils.needWeeklyReset(lastModifyTime, currentTime, weeklyDay, 0))
/*     */       {
/*  53 */         xCounter.setCount(0);
/*  54 */         xCounter.setModifytime(currentTime);
/*     */       }
/*     */       break;
/*     */     case 3: 
/*  58 */       int monthlyDay = weightCorrectionTypeCfg.weightCorrectionClearMonthlyDay;
/*  59 */       if (DateTimeUtils.needMonthlyReset(lastModifyTime, currentTime, monthlyDay, 0))
/*     */       {
/*  61 */         xCounter.setCount(0);
/*  62 */         xCounter.setModifytime(currentTime);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */       break;
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static WeightCorrectionCounter getRefreshedWeightCorrectionCounter(long roleId, SWeightCorrectionTypeCfg weightCorrectionTypeCfg)
/*     */   {
/*  78 */     int weightCorrectionType = weightCorrectionTypeCfg.id;
/*  79 */     WeightCorrectionType2Count xWeightCorrectionCount = Role2weightcorrectioncount.get(Long.valueOf(roleId));
/*  80 */     if (null == xWeightCorrectionCount)
/*     */     {
/*  82 */       xWeightCorrectionCount = Pod.newWeightCorrectionType2Count();
/*  83 */       Role2weightcorrectioncount.add(Long.valueOf(roleId), xWeightCorrectionCount);
/*     */     }
/*  85 */     Map<Integer, WeightCorrectionCounter> counterMap = xWeightCorrectionCount.getWeightcorrectiontype2count();
/*  86 */     WeightCorrectionCounter xCounter = (WeightCorrectionCounter)counterMap.get(Integer.valueOf(weightCorrectionType));
/*  87 */     if (null == xCounter)
/*     */     {
/*  89 */       xCounter = Pod.newWeightCorrectionCounter();
/*  90 */       counterMap.put(Integer.valueOf(weightCorrectionType), xCounter);
/*     */     }
/*     */     
/*  93 */     refreshWeightCorrectionCounter(xCounter, weightCorrectionTypeCfg);
/*  94 */     return xCounter;
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
/*     */   static Map<Integer, Integer> getLotteryCorrectedWeightMap(long roleId, int lotteryViewId)
/*     */   {
/* 108 */     Map<Integer, Integer> res = new HashMap();
/* 109 */     if (!OpenInterface.getOpenStatus(380))
/*     */     {
/* 111 */       return res;
/*     */     }
/* 113 */     SLotteryViewRandomCfg lotteryViewCfg = SLotteryViewRandomCfg.get(lotteryViewId);
/* 114 */     if (null == lotteryViewCfg)
/*     */     {
/* 116 */       return res;
/*     */     }
/* 118 */     int weightCorrectionType = lotteryViewCfg.weightCorrectionTypeCfgId;
/* 119 */     if (weightCorrectionType == 0)
/*     */     {
/* 121 */       return res;
/*     */     }
/* 123 */     SWeightCorrectionTypeCfg sWeightCorrectionTypeCfg = SWeightCorrectionTypeCfg.get(weightCorrectionType);
/* 124 */     if (null == sWeightCorrectionTypeCfg)
/*     */     {
/* 126 */       return res;
/*     */     }
/* 128 */     WeightCorrectionCounter xWeightCorrectionCounter = getRefreshedWeightCorrectionCounter(roleId, sWeightCorrectionTypeCfg);
/*     */     
/* 130 */     int currentLotteryCount = xWeightCorrectionCounter.getCount();
/* 131 */     NavigableMap<Integer, Integer> count2WeightMap = new TreeMap();
/* 132 */     for (Iterator i$ = lotteryViewCfg.typeIds.iterator(); i$.hasNext();) { int typeid = ((Integer)i$.next()).intValue();
/*     */       
/* 134 */       STypeId2RandomTextTableCfgId typeId2RandomTextTableCfgId = STypeId2RandomTextTableCfgId.get(typeid);
/* 135 */       if (null == typeId2RandomTextTableCfgId)
/*     */       {
/* 137 */         String logStr = String.format("[awardpool]WeightCorrectionManager.getCorrectedWeightMap@STypeId2RandomTextTableCfgId get null|lotteryViewId=%d|typeid=%d", new Object[] { Integer.valueOf(lotteryViewCfg.id), Integer.valueOf(typeid) });
/*     */         
/*     */ 
/* 140 */         AwardPoolManager.logger.error(logStr);
/*     */       }
/*     */       else {
/* 143 */         for (i$ = typeId2RandomTextTableCfgId.randomTextTableCfgIds.iterator(); i$.hasNext();) { int cfgid = ((Integer)i$.next()).intValue();
/*     */           
/* 145 */           SRandomTextTableCfg textTableCfg = SRandomTextTableCfg.get(cfgid);
/* 146 */           if (null == textTableCfg)
/*     */           {
/* 148 */             String logStr = String.format("[awardpool]WeightCorrectionManager.getCorrectedWeightMap@SRandomTextTableCfg get null|cfgid=%d", new Object[] { Integer.valueOf(cfgid) });
/*     */             
/*     */ 
/* 151 */             AwardPoolManager.logger.error(logStr);
/*     */           }
/*     */           else {
/* 154 */             int weightCorrectionCfgId = textTableCfg.weightCorrectionCfgId;
/* 155 */             if (weightCorrectionCfgId != 0)
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/* 160 */               SWeightCorrectionCfg weightCorrectionCfg = SWeightCorrectionCfg.get(weightCorrectionCfgId);
/* 161 */               if (null == weightCorrectionCfg)
/*     */               {
/* 163 */                 String logStr = String.format("[awardpool]WeightCorrectionManager.getCorrectedWeightMap@SWeightCorrectionCfg get null|cfgid=%d", new Object[] { Integer.valueOf(weightCorrectionCfgId) });
/*     */                 
/*     */ 
/* 166 */                 AwardPoolManager.logger.error(logStr);
/*     */               }
/*     */               else {
/* 169 */                 count2WeightMap.clear();
/* 170 */                 count2WeightMap.putAll(weightCorrectionCfg.count2WeightMap);
/* 171 */                 res.put(Integer.valueOf(cfgid), count2WeightMap.floorEntry(Integer.valueOf(currentLotteryCount)).getValue());
/*     */               } } } } } }
/*     */     Iterator i$;
/* 174 */     return res;
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
/*     */   static void addLotteryCount(long roleId, List<Integer> lotteryViewIds)
/*     */   {
/* 187 */     if (!OpenInterface.getOpenStatus(380))
/*     */     {
/* 189 */       return;
/*     */     }
/* 191 */     Set<Integer> weightCorrectionTypeSet = new HashSet();
/* 192 */     for (Iterator i$ = lotteryViewIds.iterator(); i$.hasNext();) { int lotteryViewId = ((Integer)i$.next()).intValue();
/*     */       
/* 194 */       SLotteryViewRandomCfg lotteryViewCfg = SLotteryViewRandomCfg.get(lotteryViewId);
/* 195 */       if (null != lotteryViewCfg)
/*     */       {
/*     */ 
/*     */ 
/* 199 */         weightCorrectionTypeSet.add(Integer.valueOf(lotteryViewCfg.weightCorrectionTypeCfgId)); }
/*     */     }
/* 201 */     if (weightCorrectionTypeSet.size() > 1)
/*     */     {
/* 203 */       String logStr = String.format("[awardpool]WeightCorrectionManager.addRoleLotteryCount@muilty weightCorrectionType in one time|roleId=%d, lotteryViewIds=%s", new Object[] { Long.valueOf(roleId), lotteryViewIds });
/*     */       
/*     */ 
/* 206 */       AwardPoolManager.logger.error(logStr);
/*     */     }
/* 208 */     for (Iterator i$ = weightCorrectionTypeSet.iterator(); i$.hasNext();) { int weightCorrectionType = ((Integer)i$.next()).intValue();
/*     */       
/*     */ 
/* 211 */       if (weightCorrectionType != 0)
/*     */       {
/*     */ 
/*     */ 
/* 215 */         SWeightCorrectionTypeCfg sWeightCorrectionTypeCfg = SWeightCorrectionTypeCfg.get(weightCorrectionType);
/* 216 */         if (null == sWeightCorrectionTypeCfg)
/*     */         {
/* 218 */           String logStr = String.format("[awardpool]WeightCorrectionManager.addLotteryCount@SWeightCorrectionTypeCfg get null|cfgid=%d", new Object[] { Integer.valueOf(weightCorrectionType) });
/*     */           
/*     */ 
/* 221 */           AwardPoolManager.logger.error(logStr);
/*     */         }
/*     */         else {
/* 224 */           WeightCorrectionCounter xWeightCorrectionCounter = getRefreshedWeightCorrectionCounter(roleId, sWeightCorrectionTypeCfg);
/*     */           
/* 226 */           int currentLotteryCount = xWeightCorrectionCounter.getCount();
/* 227 */           xWeightCorrectionCounter.setCount(currentLotteryCount + 1);
/* 228 */           xWeightCorrectionCounter.setModifytime(DateTimeUtils.getCurrTimeInMillis());
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
/*     */   static Map<Integer, Integer> getPoolCorrectedWeightMap(long roleId, int awardPoolSumId)
/*     */   {
/* 245 */     Map<Integer, Integer> res = new HashMap();
/* 246 */     if (!OpenInterface.getOpenStatus(380))
/*     */     {
/* 248 */       return res;
/*     */     }
/* 250 */     SAwardPoolSum awardPoolSumCfg = SAwardPoolSum.get(awardPoolSumId);
/* 251 */     if (null == awardPoolSumCfg)
/*     */     {
/* 253 */       return res;
/*     */     }
/* 255 */     int weightCorrectionType = awardPoolSumCfg.weightCorrectionTypeCfgId;
/* 256 */     if (weightCorrectionType == 0)
/*     */     {
/* 258 */       return res;
/*     */     }
/* 260 */     SWeightCorrectionTypeCfg sWeightCorrectionTypeCfg = SWeightCorrectionTypeCfg.get(weightCorrectionType);
/* 261 */     if (null == sWeightCorrectionTypeCfg)
/*     */     {
/* 263 */       String logStr = String.format("[awardpool]WeightCorrectionManager.getPoolCorrectedWeightMap@SWeightCorrectionTypeCfg get null|cfgid=%d", new Object[] { Integer.valueOf(weightCorrectionType) });
/*     */       
/*     */ 
/* 266 */       AwardPoolManager.logger.error(logStr);
/* 267 */       return res;
/*     */     }
/* 269 */     WeightCorrectionCounter xWeightCorrectionCounter = getRefreshedWeightCorrectionCounter(roleId, sWeightCorrectionTypeCfg);
/*     */     
/* 271 */     int currentLotteryCount = xWeightCorrectionCounter.getCount();
/* 272 */     NavigableMap<Integer, Integer> count2WeightMap = new TreeMap();
/*     */     
/* 274 */     SAwardTypeId2ItemSubId awardTypeId2ItemSubId = SAwardTypeId2ItemSubId.get(awardPoolSumCfg.awardTypeId);
/* 275 */     if ((null == awardTypeId2ItemSubId) || (awardTypeId2ItemSubId.itemSubIds.isEmpty()))
/*     */     {
/* 277 */       return res;
/*     */     }
/* 279 */     for (Iterator i$ = awardTypeId2ItemSubId.itemSubIds.iterator(); i$.hasNext();) { int cfgid = ((Integer)i$.next()).intValue();
/*     */       
/* 281 */       SItemPoolSub itemSubCfg = SItemPoolSub.get(cfgid);
/* 282 */       if (null == itemSubCfg)
/*     */       {
/* 284 */         String logStr = String.format("[awardpool]WeightCorrectionManager.getPoolCorrectedWeightMap@SRandomTextTableCfg get null|cfgid=%d", new Object[] { Integer.valueOf(cfgid) });
/*     */         
/*     */ 
/* 287 */         AwardPoolManager.logger.error(logStr);
/*     */       }
/*     */       else {
/* 290 */         int weightCorrectionCfgId = itemSubCfg.weightCorrectionCfgId;
/* 291 */         if (weightCorrectionCfgId != 0)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 296 */           SWeightCorrectionCfg weightCorrectionCfg = SWeightCorrectionCfg.get(weightCorrectionCfgId);
/* 297 */           if (null == weightCorrectionCfg)
/*     */           {
/* 299 */             String logStr = String.format("[awardpool]WeightCorrectionManager.getPoolCorrectedWeightMap@SWeightCorrectionCfg get null|cfgid=%d", new Object[] { Integer.valueOf(weightCorrectionCfgId) });
/*     */             
/*     */ 
/* 302 */             AwardPoolManager.logger.error(logStr);
/*     */           }
/*     */           else {
/* 305 */             count2WeightMap.clear();
/* 306 */             count2WeightMap.putAll(weightCorrectionCfg.count2WeightMap);
/* 307 */             res.put(Integer.valueOf(cfgid), count2WeightMap.floorEntry(Integer.valueOf(currentLotteryCount)).getValue());
/*     */           } } } }
/* 309 */     return res;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addPoolCount(long roleId, int awardPoolSumId)
/*     */   {
/* 321 */     if (!OpenInterface.getOpenStatus(380))
/*     */     {
/* 323 */       return;
/*     */     }
/* 325 */     SAwardPoolSum awardPoolSumCfg = SAwardPoolSum.get(awardPoolSumId);
/* 326 */     if (null == awardPoolSumCfg)
/*     */     {
/* 328 */       return;
/*     */     }
/* 330 */     int weightCorrectionType = awardPoolSumCfg.weightCorrectionTypeCfgId;
/* 331 */     if (weightCorrectionType == 0)
/*     */     {
/* 333 */       return;
/*     */     }
/* 335 */     SWeightCorrectionTypeCfg sWeightCorrectionTypeCfg = SWeightCorrectionTypeCfg.get(weightCorrectionType);
/* 336 */     if (null == sWeightCorrectionTypeCfg)
/*     */     {
/* 338 */       String logStr = String.format("[awardpool]WeightCorrectionManager.addPoolCount@SWeightCorrectionTypeCfg get null|cfgid=%d", new Object[] { Integer.valueOf(weightCorrectionType) });
/*     */       
/*     */ 
/* 341 */       AwardPoolManager.logger.error(logStr);
/* 342 */       return;
/*     */     }
/* 344 */     WeightCorrectionCounter xWeightCorrectionCounter = getRefreshedWeightCorrectionCounter(roleId, sWeightCorrectionTypeCfg);
/*     */     
/* 346 */     int currentLotteryCount = xWeightCorrectionCounter.getCount();
/* 347 */     xWeightCorrectionCounter.setCount(currentLotteryCount + 1);
/* 348 */     xWeightCorrectionCounter.setModifytime(DateTimeUtils.getCurrTimeInMillis());
/*     */   }
/*     */   
/*     */   static void addWeightCorrectCount(long roleId, int weightCorrectTypeCfgId)
/*     */   {
/* 353 */     if (!OpenInterface.getOpenStatus(380))
/*     */     {
/* 355 */       return;
/*     */     }
/* 357 */     SWeightCorrectionTypeCfg sWeightCorrectionTypeCfg = SWeightCorrectionTypeCfg.get(weightCorrectTypeCfgId);
/* 358 */     if (null == sWeightCorrectionTypeCfg)
/*     */     {
/* 360 */       String logStr = String.format("[awardpool]WeightCorrectionManager.addWeightCorrectCount@SWeightCorrectionTypeCfg get null|cfgid=%d", new Object[] { Integer.valueOf(weightCorrectTypeCfgId) });
/*     */       
/*     */ 
/* 363 */       AwardPoolManager.logger.error(logStr);
/* 364 */       return;
/*     */     }
/* 366 */     WeightCorrectionCounter xWeightCorrectionCounter = getRefreshedWeightCorrectionCounter(roleId, sWeightCorrectionTypeCfg);
/*     */     
/* 368 */     int currentCount = xWeightCorrectionCounter.getCount();
/* 369 */     xWeightCorrectionCounter.setCount(currentCount + 1);
/* 370 */     xWeightCorrectionCounter.setModifytime(DateTimeUtils.getCurrTimeInMillis());
/* 371 */     GameServer.logger().info(String.format("[awardpool]WeightCorrectionManager.addWeightCorrectCount:currentCount=%d", new Object[] { Integer.valueOf(xWeightCorrectionCounter.getCount()) }));
/*     */   }
/*     */   
/*     */ 
/*     */   static int getCorrectedWeight(long roleId, int weightCorrectTypeCfgId, int weightCorrectCfgId)
/*     */   {
/* 377 */     if (!OpenInterface.getOpenStatus(380))
/*     */     {
/* 379 */       return -1;
/*     */     }
/*     */     
/*     */ 
/* 383 */     SWeightCorrectionCfg weightCorrectionCfg = SWeightCorrectionCfg.get(weightCorrectCfgId);
/* 384 */     if (null == weightCorrectionCfg)
/*     */     {
/* 386 */       String logStr = String.format("[awardpool]WeightCorrectionManager.getCorrectedWeight@SWeightCorrectionCfg get null|cfgid=%d", new Object[] { Integer.valueOf(weightCorrectCfgId) });
/*     */       
/*     */ 
/* 389 */       AwardPoolManager.logger.error(logStr);
/* 390 */       return -1;
/*     */     }
/*     */     
/*     */ 
/* 394 */     SWeightCorrectionTypeCfg sWeightCorrectionTypeCfg = SWeightCorrectionTypeCfg.get(weightCorrectTypeCfgId);
/* 395 */     if (null == sWeightCorrectionTypeCfg)
/*     */     {
/* 397 */       return -1;
/*     */     }
/*     */     
/* 400 */     WeightCorrectionCounter xWeightCorrectionCounter = getRefreshedWeightCorrectionCounter(roleId, sWeightCorrectionTypeCfg);
/*     */     
/* 402 */     int currentCount = xWeightCorrectionCounter.getCount();
/*     */     
/* 404 */     NavigableMap<Integer, Integer> count2WeightMap = new TreeMap();
/* 405 */     count2WeightMap.putAll(weightCorrectionCfg.count2WeightMap);
/* 406 */     int correctedWeight = ((Integer)count2WeightMap.floorEntry(Integer.valueOf(currentCount)).getValue()).intValue();
/* 407 */     GameServer.logger().info(String.format("[awardpool]WeightCorrectionManager.getCorrectedWeight roleId=%d|weightCorrectTypeCfgId=%d|weightCorrectCfgId=%d|currentCount=%d|correctedWeight=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(weightCorrectTypeCfgId), Integer.valueOf(weightCorrectCfgId), Integer.valueOf(currentCount), Integer.valueOf(correctedWeight) }));
/*     */     
/*     */ 
/* 410 */     return correctedWeight;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\WeightCorrectionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */