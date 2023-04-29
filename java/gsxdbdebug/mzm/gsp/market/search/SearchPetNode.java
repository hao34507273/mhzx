/*     */ package mzm.gsp.market.search;
/*     */ 
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
/*     */ import xbean.MarketPet;
/*     */ 
/*     */ public class SearchPetNode
/*     */ {
/*     */   private LinkedHashMap<AbstractCondition<MarketPet>, Rank<Long, PetChartObj>> condition2MarketIds;
/*  18 */   private final ReadWriteLock nodeLock = new ReentrantReadWriteLock();
/*     */   
/*     */   SearchPetNode(int conditionNum)
/*     */   {
/*  22 */     this.condition2MarketIds = new LinkedHashMap(conditionNum)
/*     */     {
/*     */       private static final long serialVersionUID = -7970084122871015845L;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */       protected boolean removeEldestEntry(Map.Entry<AbstractCondition<MarketPet>, Rank<Long, PetChartObj>> eldest)
/*     */       {
/*  31 */         return size() >= MarketSearcherManager.getPetSubIdCacheNum();
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */ 
/*     */   public void addPetChartObj(AbstractCondition<MarketPet> abstractCondition, PetChartObj petChartObj)
/*     */   {
/*     */     try
/*     */     {
/*  41 */       this.nodeLock.writeLock().lock();
/*     */       
/*  43 */       Rank<Long, PetChartObj> rank = (Rank)this.condition2MarketIds.get(abstractCondition);
/*  44 */       if (rank == null)
/*     */       {
/*  46 */         rank = new Rank(0, MarketInterface.getPageSize());
/*  47 */         this.condition2MarketIds.put(abstractCondition, rank);
/*     */       }
/*  49 */       rank.rank(petChartObj);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  53 */       String logStr = String.format("[marketsearch]SearchPetNode.addPetChartObj@error occured on addPetChartObj|condition=%s", new Object[] { abstractCondition.toString() });
/*     */       
/*     */ 
/*     */ 
/*  57 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/*  61 */       this.nodeLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void addPetChartObjs(AbstractCondition<MarketPet> abstractCondition, List<PetChartObj> petChartObjs)
/*     */   {
/*  67 */     if ((petChartObjs == null) || (petChartObjs.isEmpty()))
/*     */     {
/*  69 */       return;
/*     */     }
/*     */     try
/*     */     {
/*  73 */       this.nodeLock.writeLock().lock();
/*     */       
/*  75 */       rank = (Rank)this.condition2MarketIds.get(abstractCondition);
/*  76 */       if (rank == null)
/*     */       {
/*  78 */         rank = new Rank(0, MarketInterface.getPageSize());
/*  79 */         this.condition2MarketIds.put(abstractCondition, rank);
/*     */       }
/*  81 */       for (PetChartObj petChartObj : petChartObjs)
/*     */       {
/*  83 */         rank.rank(petChartObj);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       Rank<Long, PetChartObj> rank;
/*  89 */       String logStr = String.format("[marketsearch]SearchPetNode.addPetChartObjs@error occured on addPetChartObjs|condition=%s", new Object[] { abstractCondition.toString() });
/*     */       
/*     */ 
/*     */ 
/*  93 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/*  97 */       this.nodeLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void removePetChartObj(AbstractCondition<MarketPet> abstractCondition, long marketId)
/*     */   {
/*     */     try
/*     */     {
/* 105 */       this.nodeLock.readLock().lock();
/*     */       
/* 107 */       Rank<Long, PetChartObj> rank = (Rank)this.condition2MarketIds.get(abstractCondition);
/* 108 */       if (rank == null) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 114 */       rank.delete(Long.valueOf(marketId));
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */ 
/* 120 */       String logStr = String.format("[marketsearch]SearchPetNode.removePetChartObj@error occured on removePetChartObj|condition=%s", new Object[] { abstractCondition.toString() });
/*     */       
/*     */ 
/*     */ 
/* 124 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/* 128 */       this.nodeLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public List<PetChartObj> getByPage(AbstractCondition<MarketPet> abstractCondition, boolean isAsc, int pageNo)
/*     */   {
/*     */     try
/*     */     {
/* 136 */       this.nodeLock.readLock().lock();
/*     */       
/* 138 */       Rank<Long, PetChartObj> rank = (Rank)this.condition2MarketIds.get(abstractCondition);
/* 139 */       Object localObject1; if (rank == null)
/*     */       {
/* 141 */         return null;
/*     */       }
/* 143 */       if (isAsc)
/*     */       {
/* 145 */         return rank.getAscendRankObjs(pageNo);
/*     */       }
/*     */       
/*     */ 
/* 149 */       return rank.getDesendRankObjs(pageNo);
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 154 */       String logStr = String.format("[marketsearch]SearchPetNode.getByPage@error occured on getByPage|condition=%s|pageno=%d", new Object[] { abstractCondition.toString(), Integer.valueOf(pageNo) });
/*     */       
/*     */ 
/*     */ 
/* 158 */       MarketInterface.getLogger().error(logStr, e);
/* 159 */       return null;
/*     */     }
/*     */     finally
/*     */     {
/* 163 */       this.nodeLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void clear(AbstractCondition<MarketPet> abstractCondition)
/*     */   {
/*     */     try
/*     */     {
/* 171 */       this.nodeLock.readLock().lock();
/*     */       
/* 173 */       Rank<Long, PetChartObj> rank = (Rank)this.condition2MarketIds.get(abstractCondition);
/* 174 */       if (rank != null)
/*     */       {
/* 176 */         rank.clear();
/*     */       }
/*     */       else
/*     */       {
/* 180 */         String logStr = String.format("[marketsearch]SearchPetNode.clear@marketIds is null|condition=%s|", new Object[] { abstractCondition.toString() });
/*     */         
/* 182 */         MarketInterface.getLogger().warn(logStr);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 187 */       String logStr = String.format("[marketsearch]SearchPetNode.clear@error occured on clear|condition=%s", new Object[] { abstractCondition.toString() });
/*     */       
/*     */ 
/* 190 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/* 194 */       this.nodeLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void remove(AbstractCondition<MarketPet> abstractCondition)
/*     */   {
/*     */     try
/*     */     {
/* 202 */       this.nodeLock.writeLock().lock();
/*     */       
/* 204 */       this.condition2MarketIds.remove(abstractCondition);
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 209 */       String logStr = String.format("[marketsearch]SearchPetNode.remove@error occured on remove|condition=%s|", new Object[] { abstractCondition.toString() });
/*     */       
/*     */ 
/* 212 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/* 216 */       this.nodeLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getSize(AbstractCondition<MarketPet> abstractCondition)
/*     */   {
/*     */     try
/*     */     {
/* 230 */       this.nodeLock.readLock().lock();
/*     */       
/* 232 */       Rank<Long, PetChartObj> rank = (Rank)this.condition2MarketIds.get(abstractCondition);
/* 233 */       int i; if (rank == null)
/*     */       {
/* 235 */         return -1;
/*     */       }
/*     */       
/* 238 */       return rank.size();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 242 */       String logStr = String.format("[marketsearch]SearchPetNode.getSize@error occured on getSize|condition=%s", new Object[] { abstractCondition.toString() });
/*     */       
/*     */ 
/* 245 */       MarketInterface.getLogger().error(logStr, e);
/* 246 */       return -1;
/*     */     }
/*     */     finally
/*     */     {
/* 250 */       this.nodeLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public Set<AbstractCondition<MarketPet>> getAllConditions()
/*     */   {
/*     */     try
/*     */     {
/* 258 */       this.nodeLock.readLock().lock();
/*     */       
/* 260 */       return new java.util.HashSet(this.condition2MarketIds.keySet());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 264 */       String logStr = String.format("[marketsearch]SearchPetNode.getAllConditions@error occured ", new Object[0]);
/*     */       
/* 266 */       MarketInterface.getLogger().error(logStr, e);
/* 267 */       return java.util.Collections.emptySet();
/*     */     }
/*     */     finally
/*     */     {
/* 271 */       this.nodeLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\SearchPetNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */