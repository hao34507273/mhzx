/*     */ package mzm.gsp.market.search;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xbean.MarketItem;
/*     */ 
/*     */ public class EquipConditionIndex
/*     */ {
/*  21 */   private final Map<Integer, Set<Long>> pubSkillId2MarketIds = new HashMap();
/*  22 */   private final Map<Integer, Set<Long>> pubColor2MarketIds = new HashMap();
/*  23 */   private final Map<Integer, Set<Long>> pubLevel2MarketIds = new HashMap();
/*     */   
/*  25 */   private final Map<Integer, Set<Long>> sellSskillId2MarketIds = new HashMap();
/*  26 */   private final Map<Integer, Set<Long>> sellColor2MarketIds = new HashMap();
/*  27 */   private final Map<Integer, Set<Long>> sellLevel2MarketIds = new HashMap();
/*     */   
/*  29 */   private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
/*     */   
/*     */   public void addItem(long marketId, MarketItem xMarketItem, boolean isPub)
/*     */   {
/*  33 */     if (xMarketItem == null)
/*     */     {
/*  35 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  40 */       this.lock.writeLock().lock();
/*     */       
/*  42 */       addSkillId(marketId, xMarketItem, isPub);
/*  43 */       addColor(marketId, xMarketItem, isPub);
/*  44 */       addLevel(marketId, xMarketItem, isPub);
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  49 */       String logStr = String.format("[marketsearch]EquipConditionIndex.addItem@error occured on addItem|marketId=%d", new Object[] { Long.valueOf(marketId) });
/*     */       
/*     */ 
/*  52 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/*  56 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeItem(long marketId, MarketItem xMarketItem, boolean isPub)
/*     */   {
/*  62 */     if (xMarketItem == null)
/*     */     {
/*  64 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  69 */       this.lock.writeLock().lock();
/*     */       
/*  71 */       removeColor(marketId, xMarketItem, isPub);
/*     */       
/*  73 */       removeSkillId(marketId, xMarketItem, isPub);
/*     */       
/*  75 */       removeLevel(marketId, xMarketItem, isPub);
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  80 */       String logStr = String.format("[marketsearch]EquipConditionIndex.removeItem@error occured on removeItem|marketId=%d", new Object[] { Long.valueOf(marketId) });
/*     */       
/*     */ 
/*  83 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/*  87 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   private void addSkillId(long marketId, MarketItem xMarketItem, boolean isPub)
/*     */   {
/*  93 */     Map<Integer, Set<Long>> skillId2MarketIds = null;
/*  94 */     if (isPub)
/*     */     {
/*  96 */       skillId2MarketIds = this.pubSkillId2MarketIds;
/*     */     }
/*     */     else
/*     */     {
/* 100 */       skillId2MarketIds = this.sellSskillId2MarketIds;
/*     */     }
/*     */     
/* 103 */     int skillid = ItemInterface.getEquipSkill(xMarketItem.getItem());
/*     */     
/* 105 */     if (skillid != -1)
/*     */     {
/* 107 */       Set<Long> marketIdSet = (Set)skillId2MarketIds.get(Integer.valueOf(skillid));
/* 108 */       if (marketIdSet == null)
/*     */       {
/* 110 */         marketIdSet = new HashSet();
/* 111 */         skillId2MarketIds.put(Integer.valueOf(skillid), marketIdSet);
/*     */       }
/* 113 */       marketIdSet.add(Long.valueOf(marketId));
/*     */     }
/*     */   }
/*     */   
/*     */   private void addColor(long marketId, MarketItem xMarketItem, boolean isPub)
/*     */   {
/* 119 */     Map<Integer, Set<Long>> color2MarketIds = null;
/* 120 */     if (isPub)
/*     */     {
/* 122 */       color2MarketIds = this.pubColor2MarketIds;
/*     */     }
/*     */     else
/*     */     {
/* 126 */       color2MarketIds = this.sellColor2MarketIds;
/*     */     }
/*     */     
/* 129 */     int color = ItemInterface.getColor(xMarketItem.getItem().getCfgid());
/* 130 */     Set<Long> marketIdSet = (Set)color2MarketIds.get(Integer.valueOf(color));
/* 131 */     if (marketIdSet == null)
/*     */     {
/* 133 */       marketIdSet = new HashSet();
/* 134 */       color2MarketIds.put(Integer.valueOf(color), marketIdSet);
/*     */     }
/* 136 */     marketIdSet.add(Long.valueOf(marketId));
/*     */   }
/*     */   
/*     */   private void addLevel(long marketId, MarketItem xMarketItem, boolean isPub)
/*     */   {
/* 141 */     Map<Integer, Set<Long>> level2MarketIds = null;
/* 142 */     if (isPub)
/*     */     {
/* 144 */       level2MarketIds = this.pubLevel2MarketIds;
/*     */     }
/*     */     else
/*     */     {
/* 148 */       level2MarketIds = this.sellLevel2MarketIds;
/*     */     }
/*     */     
/* 151 */     int level = ItemInterface.getUseLevel(xMarketItem.getItem().getCfgid());
/* 152 */     Set<Long> marketIdSet = (Set)level2MarketIds.get(Integer.valueOf(level));
/* 153 */     if (marketIdSet == null)
/*     */     {
/* 155 */       marketIdSet = new HashSet();
/*     */       
/* 157 */       level2MarketIds.put(Integer.valueOf(level), marketIdSet);
/*     */     }
/* 159 */     marketIdSet.add(Long.valueOf(marketId));
/*     */   }
/*     */   
/*     */ 
/*     */   private void removeSkillId(long marketId, MarketItem xMarketItem, boolean isPub)
/*     */   {
/* 165 */     Map<Integer, Set<Long>> skillId2MarketIds = null;
/* 166 */     if (isPub)
/*     */     {
/* 168 */       skillId2MarketIds = this.pubSkillId2MarketIds;
/*     */     }
/*     */     else
/*     */     {
/* 172 */       skillId2MarketIds = this.sellSskillId2MarketIds;
/*     */     }
/*     */     
/* 175 */     int skillId = ItemInterface.getEquipSkill(xMarketItem.getItem());
/* 176 */     Set<Long> marketIdSet = (Set)skillId2MarketIds.get(Integer.valueOf(skillId));
/* 177 */     if (marketIdSet != null)
/*     */     {
/* 179 */       marketIdSet.remove(Long.valueOf(marketId));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void removeColor(long marketId, MarketItem xMarketItem, boolean isPub)
/*     */   {
/* 186 */     Map<Integer, Set<Long>> color2MarketIds = null;
/* 187 */     if (isPub)
/*     */     {
/* 189 */       color2MarketIds = this.pubColor2MarketIds;
/*     */     }
/*     */     else
/*     */     {
/* 193 */       color2MarketIds = this.sellColor2MarketIds;
/*     */     }
/*     */     
/* 196 */     int color = ItemInterface.getColor(xMarketItem.getItem().getCfgid());
/* 197 */     Set<Long> marketIdSet = (Set)color2MarketIds.get(Integer.valueOf(color));
/* 198 */     if (marketIdSet != null)
/*     */     {
/* 200 */       marketIdSet.remove(Long.valueOf(marketId));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void removeLevel(long marketId, MarketItem xMarketItem, boolean isPub)
/*     */   {
/* 207 */     Map<Integer, Set<Long>> level2MarketIds = null;
/* 208 */     if (isPub)
/*     */     {
/* 210 */       level2MarketIds = this.pubLevel2MarketIds;
/*     */     }
/*     */     else
/*     */     {
/* 214 */       level2MarketIds = this.sellLevel2MarketIds;
/*     */     }
/*     */     
/* 217 */     int level = ItemInterface.getUseLevel(xMarketItem.getItem().getCfgid());
/* 218 */     Set<Long> marketIdSet = (Set)level2MarketIds.get(Integer.valueOf(level));
/* 219 */     if (marketIdSet != null)
/*     */     {
/* 221 */       marketIdSet.remove(Long.valueOf(marketId));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Long> getByLevel(int level, boolean isPub)
/*     */   {
/*     */     try
/*     */     {
/* 231 */       this.lock.readLock().lock();
/*     */       
/* 233 */       Map<Integer, Set<Long>> level2MarketIds = null;
/* 234 */       if (isPub)
/*     */       {
/* 236 */         level2MarketIds = this.pubLevel2MarketIds;
/*     */       }
/*     */       else
/*     */       {
/* 240 */         level2MarketIds = this.sellLevel2MarketIds;
/*     */       }
/*     */       
/* 243 */       Set<Long> reSet = (Set)level2MarketIds.get(Integer.valueOf(level));
/* 244 */       if (reSet == null)
/*     */       {
/* 246 */         return Collections.emptySet();
/*     */       }
/*     */       
/*     */ 
/* 250 */       return reSet;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       Object localObject1;
/*     */       
/* 256 */       String logStr = String.format("[marketsearch]EquipConditionIndex.getByLevel@error occured on getByLevel|level=%d", new Object[] { Integer.valueOf(level) });
/*     */       
/*     */ 
/* 259 */       MarketInterface.getLogger().error(logStr, e);
/* 260 */       return Collections.emptySet();
/*     */     }
/*     */     finally
/*     */     {
/* 264 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getByColor(int color, boolean isPub)
/*     */   {
/*     */     try
/*     */     {
/* 273 */       this.lock.readLock().lock();
/*     */       
/* 275 */       Map<Integer, Set<Long>> color2MarketIds = null;
/* 276 */       if (isPub)
/*     */       {
/* 278 */         color2MarketIds = this.pubColor2MarketIds;
/*     */       }
/*     */       else
/*     */       {
/* 282 */         color2MarketIds = this.sellColor2MarketIds;
/*     */       }
/*     */       
/* 285 */       Set<Long> reSet = (Set)color2MarketIds.get(Integer.valueOf(color));
/* 286 */       if (reSet == null)
/*     */       {
/* 288 */         return Collections.emptySet();
/*     */       }
/*     */       
/*     */ 
/* 292 */       return reSet;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       Object localObject1;
/*     */       
/* 298 */       String logStr = String.format("[marketsearch]EquipConditionIndex.getByColor@error occured on getByColor|color=%d", new Object[] { Integer.valueOf(color) });
/*     */       
/*     */ 
/* 301 */       MarketInterface.getLogger().error(logStr, e);
/* 302 */       return Collections.emptySet();
/*     */     }
/*     */     finally
/*     */     {
/* 306 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getBySkillId(int skillId, boolean isPub)
/*     */   {
/*     */     try
/*     */     {
/* 315 */       this.lock.readLock().lock();
/*     */       
/* 317 */       Map<Integer, Set<Long>> skillId2MarketIds = null;
/* 318 */       if (isPub)
/*     */       {
/* 320 */         skillId2MarketIds = this.pubSkillId2MarketIds;
/*     */       }
/*     */       else
/*     */       {
/* 324 */         skillId2MarketIds = this.sellSskillId2MarketIds;
/*     */       }
/*     */       
/* 327 */       Set<Long> reSet = (Set)skillId2MarketIds.get(Integer.valueOf(skillId));
/* 328 */       if (reSet == null)
/*     */       {
/* 330 */         return Collections.emptySet();
/*     */       }
/*     */       
/*     */ 
/* 334 */       return reSet;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       Object localObject1;
/*     */       
/* 340 */       String logStr = String.format("[marketsearch]EquipConditionIndex.getBySkillId@error occured on getBySkillId|skillId=%d", new Object[] { Integer.valueOf(skillId) });
/*     */       
/*     */ 
/* 343 */       MarketInterface.getLogger().error(logStr, e);
/* 344 */       return Collections.emptySet();
/*     */     }
/*     */     finally
/*     */     {
/* 348 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> siftByCondition(EquipCondition equipCondition, boolean isPub)
/*     */   {
/*     */     try
/*     */     {
/* 357 */       this.lock.readLock().lock();
/*     */       
/* 359 */       Set<Long> result = new HashSet();
/*     */       
/* 361 */       result.addAll(getByLevel(equipCondition.getLevel(), isPub));
/* 362 */       if (result.isEmpty())
/*     */       {
/* 364 */         return result;
/*     */       }
/* 366 */       Object tempResult = new HashSet();
/*     */       Iterator i$;
/* 368 */       if (!equipCondition.getSkillIds().isEmpty())
/*     */       {
/* 370 */         for (i$ = equipCondition.getSkillIds().iterator(); i$.hasNext();) { int skillId = ((Integer)i$.next()).intValue();
/*     */           
/* 372 */           ((Set)tempResult).addAll(getBySkillId(skillId, isPub));
/*     */         }
/* 374 */         result.retainAll((java.util.Collection)tempResult);
/*     */       }
/* 376 */       if (result.isEmpty())
/*     */       {
/* 378 */         return result;
/*     */       }
/* 380 */       ((Set)tempResult).clear();
/* 381 */       if (!equipCondition.getColors().isEmpty())
/*     */       {
/* 383 */         for (i$ = equipCondition.getColors().iterator(); i$.hasNext();) { int color = ((Integer)i$.next()).intValue();
/*     */           
/* 385 */           ((Set)tempResult).addAll(getByColor(color, isPub));
/*     */         }
/*     */         
/* 388 */         result.retainAll((java.util.Collection)tempResult);
/*     */       }
/*     */       
/* 391 */       return result;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       Iterator i$;
/* 396 */       String logStr = String.format("[marketsearch]EquipConditionIndex.siftByCondition@error occured on siftByCondition|condition=%s", new Object[] { equipCondition.toString() });
/*     */       
/*     */ 
/*     */ 
/* 400 */       MarketInterface.getLogger().error(logStr, e);
/* 401 */       return Collections.emptySet();
/*     */     }
/*     */     finally
/*     */     {
/* 405 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\EquipConditionIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */