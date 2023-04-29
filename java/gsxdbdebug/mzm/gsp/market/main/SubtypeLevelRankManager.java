/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class SubtypeLevelRankManager
/*     */ {
/*  12 */   private final Map<Integer, LevelRankManager> level2RankManager = new java.util.HashMap();
/*  13 */   private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
/*     */   
/*     */ 
/*     */   public boolean rank(MarketLevelPriceChart marketLevelPriceChart)
/*     */   {
/*  18 */     if (marketLevelPriceChart == null)
/*     */     {
/*  20 */       return false;
/*     */     }
/*  22 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/*  25 */       LevelRankManager levelRankManager = (LevelRankManager)this.level2RankManager.get(Integer.valueOf(marketLevelPriceChart.getLevel()));
/*     */       
/*  27 */       if (levelRankManager == null)
/*     */       {
/*  29 */         levelRankManager = new LevelRankManager(0, MarketInterface.getPageSize());
/*  30 */         this.level2RankManager.put(Integer.valueOf(marketLevelPriceChart.getLevel()), levelRankManager);
/*     */       }
/*     */       
/*  33 */       return levelRankManager.rank(marketLevelPriceChart);
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  38 */       String logStr = String.format("[market]SubtypeLevelRankManager.rank@rank  error|marketId=%d|level=%d|price=%d", new Object[] { Long.valueOf(marketLevelPriceChart.getMarketId()), Integer.valueOf(marketLevelPriceChart.getLevel()), Integer.valueOf(marketLevelPriceChart.getPrice()) });
/*     */       
/*     */ 
/*  41 */       MarketManager.logger.error(logStr, e);
/*  42 */       return false;
/*     */     }
/*     */     finally
/*     */     {
/*  46 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean delete(long marketId, int level)
/*     */   {
/*  54 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/*  57 */       LevelRankManager levelRankManager = (LevelRankManager)this.level2RankManager.get(Integer.valueOf(level));
/*     */       
/*  59 */       if (levelRankManager != null)
/*     */       {
/*  61 */         return levelRankManager.delete(Long.valueOf(marketId));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  66 */       String logStr = String.format("[market]SubtypeLevelRankManager.delete@delete  error,rank is null|marketId=%d|level=%d", new Object[] { Long.valueOf(marketId), Integer.valueOf(level) });
/*     */       
/*     */ 
/*     */ 
/*  70 */       MarketManager.logger.info(logStr);
/*  71 */       return false;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       boolean bool2;
/*     */       
/*  77 */       String logStr = String.format("[market]SubtypeLevelRankManager.delete@delete  error|marketId=%d|level=%d", new Object[] { Long.valueOf(marketId), Integer.valueOf(level) });
/*     */       
/*     */ 
/*  80 */       MarketManager.logger.error(logStr, e);
/*  81 */       return false;
/*     */     }
/*     */     finally
/*     */     {
/*  85 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public List<MarketLevelPriceChart> getByPage(int level, int pageIndex, boolean isAsc)
/*     */   {
/*  92 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/*  95 */       LevelRankManager levelRankManager = (LevelRankManager)this.level2RankManager.get(Integer.valueOf(level));
/*     */       
/*  97 */       if (levelRankManager != null) {
/*     */         List localList1;
/*  99 */         if (isAsc)
/*     */         {
/* 101 */           return levelRankManager.getAscendRankObjs(pageIndex);
/*     */         }
/*     */         
/*     */ 
/* 105 */         return levelRankManager.getDesendRankObjs(pageIndex);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 111 */       String logStr = String.format("[market]SubtypeLevelRankManager.getByPage@getByPage  error,rank is null|pageIndex=%d|level=%d", new Object[] { Integer.valueOf(pageIndex), Integer.valueOf(level) });
/*     */       
/*     */ 
/*     */ 
/* 115 */       MarketManager.logger.info(logStr);
/*     */       
/* 117 */       return java.util.Collections.emptyList();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       List localList2;
/*     */       
/*     */ 
/* 124 */       String logStr = String.format("[market]SubtypeLevelRankManager.getByPage@getByPage  error|pageIndex=%d|level=%d", new Object[] { Integer.valueOf(pageIndex), Integer.valueOf(level) });
/*     */       
/*     */ 
/* 127 */       MarketManager.logger.error(logStr, e);
/* 128 */       return java.util.Collections.emptyList();
/*     */     }
/*     */     finally
/*     */     {
/* 132 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public List<MarketLevelPriceChart> getAll(int level)
/*     */   {
/* 138 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/* 141 */       LevelRankManager levelRankManager = (LevelRankManager)this.level2RankManager.get(Integer.valueOf(level));
/*     */       
/* 143 */       if (levelRankManager != null)
/*     */       {
/*     */ 
/* 146 */         return levelRankManager.getAllChartObjs();
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 151 */       String logStr = String.format("[market]SubtypeLevelRankManager.getAll@getAll  error,rank is null|level=%d", new Object[] { Integer.valueOf(level) });
/*     */       
/*     */ 
/* 154 */       MarketManager.logger.info(logStr);
/*     */       
/* 156 */       return java.util.Collections.emptyList();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       List localList2;
/*     */       
/*     */ 
/* 163 */       String logStr = String.format("[market]SubtypeLevelRankManager.getByPage@getByPage  error|level=%d", new Object[] { Integer.valueOf(level) });
/*     */       
/* 165 */       MarketManager.logger.error(logStr, e);
/* 166 */       return java.util.Collections.emptyList();
/*     */     }
/*     */     finally
/*     */     {
/* 170 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public int getSize(int level)
/*     */   {
/* 176 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/* 179 */       LevelRankManager levelRankManager = (LevelRankManager)this.level2RankManager.get(Integer.valueOf(level));
/*     */       int i;
/* 181 */       if (levelRankManager == null)
/*     */       {
/* 183 */         return 0;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 188 */       return levelRankManager.size();
/*     */ 
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */ 
/* 195 */       String logStr = String.format("[market]SubtypeLevelRankManager.getSize@getSize  error|level=%d", new Object[] { Integer.valueOf(level) });
/*     */       
/* 197 */       MarketManager.logger.error(logStr, e);
/* 198 */       return 0;
/*     */     }
/*     */     finally
/*     */     {
/* 202 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public int getTotalSize()
/*     */   {
/* 208 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/* 211 */       int t = 0;
/* 212 */       for (java.util.Iterator i$ = this.level2RankManager.keySet().iterator(); i$.hasNext();) { level = ((Integer)i$.next()).intValue();
/*     */         
/* 214 */         LevelRankManager levelRankManager = (LevelRankManager)this.level2RankManager.get(Integer.valueOf(level));
/*     */         
/* 216 */         if (levelRankManager != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 223 */           t += levelRankManager.size();
/*     */         }
/*     */       }
/*     */       
/* 227 */       return t;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       int level;
/* 232 */       String logStr = String.format("[market]SubtypeLevelRankManager.getTotalSize@getTotalSize  error", new Object[0]);
/*     */       
/* 234 */       MarketManager.logger.error(logStr, e);
/* 235 */       return 0;
/*     */     }
/*     */     finally
/*     */     {
/* 239 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public int getPrice(int level, long marketId)
/*     */   {
/* 245 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/* 248 */       LevelRankManager levelRankManager = (LevelRankManager)this.level2RankManager.get(Integer.valueOf(level));
/*     */       
/* 250 */       if (levelRankManager == null)
/*     */       {
/* 252 */         return -1;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 257 */       MarketLevelPriceChart marketLevelPriceChart = (MarketLevelPriceChart)levelRankManager.getObjByKey(Long.valueOf(marketId));
/*     */       
/* 259 */       if (marketLevelPriceChart == null)
/*     */       {
/* 261 */         return -1;
/*     */       }
/*     */       
/*     */ 
/* 265 */       return marketLevelPriceChart.getPrice();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       int j;
/*     */       
/*     */ 
/* 272 */       String logStr = String.format("[market]SubtypeLevelRankManager.getPrice@getPrice  error|level=%d|marketId=%d", new Object[] { Integer.valueOf(level), Long.valueOf(marketId) });
/*     */       
/*     */ 
/* 275 */       MarketManager.logger.error(logStr, e);
/* 276 */       return -1;
/*     */     }
/*     */     finally
/*     */     {
/* 280 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\SubtypeLevelRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */