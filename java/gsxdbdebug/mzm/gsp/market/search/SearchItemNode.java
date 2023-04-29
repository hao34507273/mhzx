/*     */ package mzm.gsp.market.search;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import mzm.gsp.util.Rank;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MarketItem;
/*     */ 
/*     */ public class SearchItemNode
/*     */ {
/*     */   private LinkedHashMap<AbstractCondition<MarketItem>, Rank<Long, ItemChartObj>> condition2MarketIds;
/*  19 */   private final ReadWriteLock nodeLock = new ReentrantReadWriteLock();
/*     */   
/*     */   SearchItemNode(int conditionNum)
/*     */   {
/*  23 */     this.condition2MarketIds = new LinkedHashMap(conditionNum)
/*     */     {
/*     */       private static final long serialVersionUID = -7970084122871015845L;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       protected boolean removeEldestEntry(Map.Entry<AbstractCondition<MarketItem>, Rank<Long, ItemChartObj>> eldest)
/*     */       {
/*  33 */         return size() >= MarketSearcherManager.getItemSubIdCacheNum();
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */   public void addItemChartObj(AbstractCondition<MarketItem> abstractCondition, ItemChartObj itemChartObj)
/*     */   {
/*     */     try
/*     */     {
/*  42 */       this.nodeLock.writeLock().lock();
/*     */       
/*  44 */       Rank<Long, ItemChartObj> rank = (Rank)this.condition2MarketIds.get(abstractCondition);
/*  45 */       if (rank == null)
/*     */       {
/*  47 */         rank = new Rank(0, MarketInterface.getPageSize());
/*  48 */         this.condition2MarketIds.put(abstractCondition, rank);
/*     */       }
/*  50 */       rank.rank(itemChartObj);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  54 */       String logStr = String.format("[marketsearch]SearchItemNode.addItemChartObj@error occured on addItemChartObj|condition=%s", new Object[] { abstractCondition.toString() });
/*     */       
/*     */ 
/*     */ 
/*  58 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/*  62 */       this.nodeLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void addItemChartObjs(AbstractCondition<MarketItem> abstractCondition, List<ItemChartObj> itemChartObjs)
/*     */   {
/*  68 */     if ((itemChartObjs == null) || (itemChartObjs.isEmpty()))
/*     */     {
/*  70 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  75 */       this.nodeLock.writeLock().lock();
/*     */       
/*  77 */       rank = (Rank)this.condition2MarketIds.get(abstractCondition);
/*  78 */       if (rank == null)
/*     */       {
/*  80 */         rank = new Rank(0, MarketInterface.getPageSize());
/*  81 */         this.condition2MarketIds.put(abstractCondition, rank);
/*     */       }
/*  83 */       for (ItemChartObj itemChartObj : itemChartObjs)
/*     */       {
/*  85 */         rank.rank(itemChartObj);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       Rank<Long, ItemChartObj> rank;
/*  91 */       String logStr = String.format("[marketsearch]SearchItemNode.addItemChartObjs@error occured on add marketid|condition=%s", new Object[] { abstractCondition.toString() });
/*     */       
/*     */ 
/*     */ 
/*  95 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/*  99 */       this.nodeLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeItemChartObj(AbstractCondition<MarketItem> abstractCondition, long marketId)
/*     */   {
/*     */     try
/*     */     {
/* 107 */       this.nodeLock.writeLock().lock();
/*     */       
/* 109 */       Rank<Long, ItemChartObj> rank = (Rank)this.condition2MarketIds.get(abstractCondition);
/* 110 */       if (rank == null) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 116 */       rank.delete(Long.valueOf(marketId));
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */ 
/* 122 */       String logStr = String.format("[marketsearch]SearchItemNode.removeItemChartObj@error occured on removeItemChartObj|condition=%s", new Object[] { abstractCondition.toString() });
/*     */       
/*     */ 
/*     */ 
/* 126 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/* 130 */       this.nodeLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public List<ItemChartObj> getByPage(AbstractCondition<MarketItem> abstractCondition, boolean isAsc, int pageNum)
/*     */   {
/*     */     try
/*     */     {
/* 138 */       this.nodeLock.readLock().lock();
/*     */       
/* 140 */       Rank<Long, ItemChartObj> rank = (Rank)this.condition2MarketIds.get(abstractCondition);
/* 141 */       Object localObject1; if (rank == null)
/*     */       {
/* 143 */         return null;
/*     */       }
/* 145 */       if (isAsc)
/*     */       {
/* 147 */         return rank.getAscendRankObjs(pageNum);
/*     */       }
/*     */       
/*     */ 
/* 151 */       return rank.getDesendRankObjs(pageNum);
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */ 
/* 157 */       String logStr = String.format("[marketsearch]SearchItemNode.getByPage@error occured on getByPage|condition=%s|pagenum=%d", new Object[] { abstractCondition.toString(), Integer.valueOf(pageNum) });
/*     */       
/*     */ 
/*     */ 
/* 161 */       MarketInterface.getLogger().error(logStr, e);
/* 162 */       return null;
/*     */     }
/*     */     finally
/*     */     {
/* 166 */       this.nodeLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void clear(AbstractCondition<MarketItem> abstractCondition)
/*     */   {
/*     */     try
/*     */     {
/* 174 */       this.nodeLock.readLock().lock();
/*     */       
/* 176 */       Rank<Long, ItemChartObj> rank = (Rank)this.condition2MarketIds.get(abstractCondition);
/* 177 */       if (rank != null)
/*     */       {
/* 179 */         rank.clear();
/*     */       }
/*     */       else
/*     */       {
/* 183 */         String logStr = String.format("[marketsearch]SearchItemNode.clear@marketIds is null|condition=%s|", new Object[] { abstractCondition.toString() });
/*     */         
/* 185 */         MarketInterface.getLogger().warn(logStr);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 190 */       String logStr = String.format("[marketsearch]SearchItemNode.clear@error occured on clear|condition=%s", new Object[] { abstractCondition.toString() });
/*     */       
/*     */ 
/* 193 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/* 197 */       this.nodeLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void remove(AbstractCondition<MarketItem> abstractCondition)
/*     */   {
/*     */     try
/*     */     {
/* 205 */       this.nodeLock.writeLock().lock();
/*     */       
/* 207 */       this.condition2MarketIds.remove(abstractCondition);
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 212 */       String logStr = String.format("[marketsearch]SearchItemNode.remove@error occured on remove|condition=%s|", new Object[] { abstractCondition.toString() });
/*     */       
/*     */ 
/* 215 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/* 219 */       this.nodeLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getSize(AbstractCondition<MarketItem> abstractCondition)
/*     */   {
/*     */     try
/*     */     {
/* 233 */       this.nodeLock.readLock().lock();
/*     */       
/* 235 */       Rank<Long, ItemChartObj> rank = (Rank)this.condition2MarketIds.get(abstractCondition);
/* 236 */       int i; if (rank == null)
/*     */       {
/* 238 */         return -1;
/*     */       }
/*     */       
/* 241 */       return rank.size();
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 246 */       String logStr = String.format("[marketsearch]SearchItemNode.getSize@error occured on getSize|condition=%s", new Object[] { abstractCondition.toString() });
/*     */       
/*     */ 
/* 249 */       MarketInterface.getLogger().error(logStr, e);
/* 250 */       return -1;
/*     */     }
/*     */     finally
/*     */     {
/* 254 */       this.nodeLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public Set<AbstractCondition<MarketItem>> getAllConditions()
/*     */   {
/*     */     try
/*     */     {
/* 262 */       this.nodeLock.readLock().lock();
/*     */       
/* 264 */       return new java.util.HashSet(this.condition2MarketIds.keySet());
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 269 */       String logStr = String.format("[marketsearch]SearchItemNode.getAllConditions@error occured ", new Object[0]);
/*     */       
/* 271 */       MarketInterface.getLogger().error(logStr, e);
/* 272 */       return Collections.emptySet();
/*     */     }
/*     */     finally
/*     */     {
/* 276 */       this.nodeLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\SearchItemNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */