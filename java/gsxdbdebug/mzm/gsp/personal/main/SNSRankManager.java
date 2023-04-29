/*     */ package mzm.gsp.personal.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.personal.ConditionInfo;
/*     */ import mzm.gsp.personal.confbean.SNSConsts;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class SNSRankManager
/*     */ {
/*  19 */   private static final SNSRankManager instance = new SNSRankManager();
/*     */   
/*     */   public static SNSRankManager getInstance()
/*     */   {
/*  23 */     return instance;
/*     */   }
/*     */   
/*  26 */   private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
/*  27 */   private final Map<SearchInfo, AdvertRank> searchInfoToRankManager = new AdvertRankMap(SNSConsts.getInstance().SEARCH_CACHE_SIZE);
/*     */   
/*  29 */   private int searchNum = 0;
/*  30 */   private int buildCache = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void add(FilterInfo filterInfo, AdvertChart advertChart)
/*     */   {
/*  38 */     this.readWriteLock.readLock().lock();
/*     */     try
/*     */     {
/*  41 */       for (Map.Entry<SearchInfo, AdvertRank> entry : this.searchInfoToRankManager.entrySet())
/*     */       {
/*  43 */         if (isInSearch((SearchInfo)entry.getKey(), filterInfo))
/*     */         {
/*  45 */           ((AdvertRank)entry.getValue()).rank(advertChart);
/*     */         }
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*  51 */       this.readWriteLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void delete(long advertId, FilterInfo filterInfo)
/*     */   {
/*  57 */     this.readWriteLock.readLock().lock();
/*     */     try
/*     */     {
/*  60 */       for (Map.Entry<SearchInfo, AdvertRank> entry : this.searchInfoToRankManager.entrySet())
/*     */       {
/*  62 */         if (isInSearch((SearchInfo)entry.getKey(), filterInfo))
/*     */         {
/*  64 */           ((AdvertRank)entry.getValue()).delete(Long.valueOf(advertId));
/*     */         }
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*  70 */       this.readWriteLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void filterChanged(long advertId, FilterInfo oldFilterInfo, FilterInfo newFilterInfo, AdvertChart advertChart)
/*     */   {
/*  77 */     this.readWriteLock.readLock().lock();
/*     */     try
/*     */     {
/*  80 */       for (Map.Entry<SearchInfo, AdvertRank> entry : this.searchInfoToRankManager.entrySet())
/*     */       {
/*  82 */         SearchInfo searchInfo = (SearchInfo)entry.getKey();
/*  83 */         boolean isOldIn = isInSearch(searchInfo, oldFilterInfo);
/*  84 */         boolean isNewIn = isInSearch(searchInfo, newFilterInfo);
/*     */         
/*  86 */         if ((isOldIn) && (!isNewIn))
/*     */         {
/*  88 */           ((AdvertRank)entry.getValue()).delete(Long.valueOf(advertId));
/*     */         }
/*  90 */         else if ((!isOldIn) && (isNewIn))
/*     */         {
/*  92 */           ((AdvertRank)entry.getValue()).rank(advertChart);
/*     */         }
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*  98 */       this.readWriteLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void chartChanged(long advertId, FilterInfo filterInfo, AdvertChart newAdvertChart)
/*     */   {
/* 104 */     this.readWriteLock.readLock().lock();
/*     */     try
/*     */     {
/* 107 */       for (Map.Entry<SearchInfo, AdvertRank> entry : this.searchInfoToRankManager.entrySet())
/*     */       {
/* 109 */         if (isInSearch((SearchInfo)entry.getKey(), filterInfo))
/*     */         {
/* 111 */           ((AdvertRank)entry.getValue()).delete(Long.valueOf(advertId));
/* 112 */           ((AdvertRank)entry.getValue()).rank(newAdvertChart);
/*     */         }
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 118 */       this.readWriteLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public List<AdvertChart> search(SearchInfo searchInfo, int page, boolean isBuild)
/*     */   {
/* 124 */     List<AdvertChart> result = null;
/*     */     
/* 126 */     this.readWriteLock.readLock().lock();
/*     */     List<AdvertChart> localList1;
/*     */     try {
/* 129 */       if (!isBuild)
/*     */       {
/* 131 */         this.searchNum += 1;
/*     */       }
/*     */       
/* 134 */       AdvertRank advertRank = (AdvertRank)this.searchInfoToRankManager.get(searchInfo);
/* 135 */       if (advertRank != null)
/*     */       {
/*     */ 
/* 138 */         result = advertRank.getAscendRankObjs(page);
/* 139 */         if (result == null)
/*     */         {
/* 141 */           result = Collections.emptyList();
/*     */         }
/* 143 */         return result;
/*     */       }
/*     */       
/*     */ 
/* 147 */       if (!isBuild)
/*     */       {
/* 149 */         return null;
/*     */       }
/*     */       
/*     */     }
/*     */     finally
/*     */     {
/* 155 */       this.readWriteLock.readLock().unlock();
/*     */     }
/*     */     
/* 158 */     this.readWriteLock.writeLock().lock();
/*     */     try
/*     */     {
/* 161 */       AdvertRank advertRank = (AdvertRank)this.searchInfoToRankManager.get(searchInfo);
/* 162 */       if (advertRank != null)
/*     */       {
/*     */ 
/* 165 */         result = advertRank.getAscendRankObjs(page);
/* 166 */         if (result == null)
/*     */         {
/* 168 */           result = Collections.emptyList();
/*     */         }
/* 170 */         return result;
/*     */       }
/*     */       
/* 173 */       this.buildCache += 1;
/*     */       
/* 175 */       long beginTime = DateTimeUtils.getCurrTimeInMillis();
/*     */       
/* 177 */       advertRank = new AdvertRank(0, SNSConsts.getInstance().PAGE_SIZE);
/* 178 */       this.searchInfoToRankManager.put(searchInfo, advertRank);
/*     */       
/*     */ 
/* 181 */       Collection<Long> advertIds = SNSIndexManager.getInstance().searchAdvertIds(searchInfo);
/* 182 */       AdvertChartCache.getInstance().buildRank(advertIds, advertRank);
/*     */       
/*     */ 
/* 185 */       result = advertRank.getAscendRankObjs(page);
/* 186 */       if (result == null)
/*     */       {
/* 188 */         result = Collections.emptyList();
/*     */       }
/*     */       
/* 191 */       long costTime = DateTimeUtils.getCurrTimeInMillis() - beginTime;
/* 192 */       GameServer.logger().info(String.format("build search rank cost time %d|searchNum=%d|buildCache=%d", new Object[] { Long.valueOf(costTime), Integer.valueOf(this.searchNum), Integer.valueOf(this.buildCache) }));
/*     */       
/*     */ 
/* 195 */       return result;
/*     */     }
/*     */     finally
/*     */     {
/* 199 */       this.readWriteLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public int getSize(SearchInfo searchInfo)
/*     */   {
/* 205 */     this.readWriteLock.readLock().lock();
/*     */     try
/*     */     {
/* 208 */       AdvertRank advertRank = (AdvertRank)this.searchInfoToRankManager.get(searchInfo);
/* 209 */       int i; if (advertRank != null)
/*     */       {
/* 211 */         return advertRank.size();
/*     */       }
/* 213 */       return 0;
/*     */     }
/*     */     finally
/*     */     {
/* 217 */       this.readWriteLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isInSearch(SearchInfo searchInfo, FilterInfo filterInfo)
/*     */   {
/* 223 */     if (searchInfo.advertType == SNSConsts.getInstance().ALL_SUB_TYPE_ID)
/*     */     {
/*     */ 
/* 226 */       return isMatch(searchInfo.conditionInfo, filterInfo);
/*     */     }
/*     */     
/*     */ 
/* 230 */     if (searchInfo.advertType == filterInfo.advertType)
/*     */     {
/* 232 */       return isMatch(searchInfo.conditionInfo, filterInfo);
/*     */     }
/*     */     
/*     */ 
/* 236 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean isMatch(ConditionInfo conditionInfo, FilterInfo filterInfo)
/*     */   {
/* 242 */     if ((filterInfo.level < conditionInfo.minlevel) || (filterInfo.level > conditionInfo.maxlevel))
/*     */     {
/* 244 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 248 */     if ((conditionInfo.gender == -1) && (conditionInfo.location == -1))
/*     */     {
/* 250 */       return true;
/*     */     }
/* 252 */     if ((conditionInfo.gender == -1) && (conditionInfo.location != -1))
/*     */     {
/* 254 */       if (filterInfo.province == conditionInfo.location)
/*     */       {
/* 256 */         return true;
/*     */       }
/*     */     }
/* 259 */     else if ((conditionInfo.gender != -1) && (conditionInfo.location == -1))
/*     */     {
/* 261 */       if (filterInfo.gender == conditionInfo.gender)
/*     */       {
/* 263 */         return true;
/*     */       }
/*     */     }
/* 266 */     else if ((conditionInfo.gender != -1) && (conditionInfo.location != -1))
/*     */     {
/* 268 */       if ((filterInfo.province == conditionInfo.location) && (filterInfo.gender == conditionInfo.gender))
/*     */       {
/* 270 */         return true;
/*     */       }
/*     */     }
/* 273 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   private static class AdvertRankMap
/*     */     extends java.util.LinkedHashMap<SearchInfo, AdvertRank>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     private final int capacity;
/*     */     
/*     */     AdvertRankMap(int capacity)
/*     */     {
/* 285 */       this.capacity = capacity;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean removeEldestEntry(Map.Entry<SearchInfo, AdvertRank> eldest)
/*     */     {
/* 291 */       if (size() > this.capacity)
/*     */       {
/* 293 */         GameServer.logger().info(String.format("[personal]AdvertRankMap.removeEldestEntry@remove eldest entry|search_info=%s|size=%d|capacity=%d", new Object[] { ((SearchInfo)eldest.getKey()).toString(), Integer.valueOf(size()), Integer.valueOf(this.capacity) }));
/*     */         
/*     */ 
/*     */ 
/* 297 */         return true;
/*     */       }
/* 299 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\SNSRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */