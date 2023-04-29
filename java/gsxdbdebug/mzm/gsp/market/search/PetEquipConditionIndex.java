/*     */ package mzm.gsp.market.search;
/*     */ 
/*     */ import java.util.Collection;
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
/*     */ import xbean.MarketItem;
/*     */ 
/*     */ public class PetEquipConditionIndex
/*     */ {
/*  21 */   private final Map<Integer, Set<Long>> pubSkillId2MarketIds = new HashMap();
/*  22 */   private final Map<Integer, Set<Long>> pubProperty2MarketIds = new HashMap();
/*     */   
/*  24 */   private final Map<Integer, Set<Long>> sellSkillId2MarketIds = new HashMap();
/*  25 */   private final Map<Integer, Set<Long>> sellProperty2MarketIds = new HashMap();
/*     */   
/*  27 */   private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
/*     */   
/*     */   public void addItem(long marketId, MarketItem xMarketItem, boolean isPub)
/*     */   {
/*  31 */     if (xMarketItem == null)
/*     */     {
/*  33 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  38 */       this.lock.writeLock().lock();
/*     */       
/*  40 */       addSkillId(marketId, xMarketItem, isPub);
/*     */       
/*  42 */       addProperty(marketId, xMarketItem, isPub);
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  47 */       String logStr = String.format("[marketsearch]PetEquipConditionIndex.addItem@error occured on addItem|marketId=%d", new Object[] { Long.valueOf(marketId) });
/*     */       
/*     */ 
/*  50 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/*  54 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeItem(long marketId, MarketItem xMarketItem, boolean isPub)
/*     */   {
/*  60 */     if (xMarketItem == null)
/*     */     {
/*  62 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  67 */       this.lock.writeLock().lock();
/*     */       
/*  69 */       removeSkillId(marketId, xMarketItem, isPub);
/*  70 */       removeProperty(marketId, xMarketItem, isPub);
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  75 */       String logStr = String.format("[marketsearch]PetEquipConditionIndex.removeItem@error occured on removeItem|marketId=%d", new Object[] { Long.valueOf(marketId) });
/*     */       
/*     */ 
/*  78 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/*  82 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   private void addSkillId(long marketId, MarketItem xMarketItem, boolean isPub)
/*     */   {
/*  88 */     Map<Integer, Set<Long>> skillId2MarketIds = null;
/*  89 */     if (isPub)
/*     */     {
/*  91 */       skillId2MarketIds = this.pubSkillId2MarketIds;
/*     */     }
/*     */     else
/*     */     {
/*  95 */       skillId2MarketIds = this.sellSkillId2MarketIds;
/*     */     }
/*  97 */     Set<Integer> skillids = ItemInterface.getPetEquipItemSkills(xMarketItem.getItem());
/*     */     Iterator i$;
/*  99 */     if ((skillids != null) && (!skillids.isEmpty()))
/*     */     {
/* 101 */       for (i$ = skillids.iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/*     */         
/*     */ 
/* 104 */         Set<Long> marketIdSet = (Set)skillId2MarketIds.get(Integer.valueOf(skillid));
/* 105 */         if (marketIdSet == null)
/*     */         {
/* 107 */           marketIdSet = new HashSet();
/* 108 */           skillId2MarketIds.put(Integer.valueOf(skillid), marketIdSet);
/*     */         }
/* 110 */         marketIdSet.add(Long.valueOf(marketId));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void addProperty(long marketId, MarketItem xMarketItem, boolean isPub)
/*     */   {
/* 119 */     Map<Integer, Set<Long>> property2MarketIds = null;
/* 120 */     if (isPub)
/*     */     {
/* 122 */       property2MarketIds = this.pubProperty2MarketIds;
/*     */     }
/*     */     else
/*     */     {
/* 126 */       property2MarketIds = this.sellProperty2MarketIds;
/*     */     }
/*     */     
/* 129 */     Set<Integer> propertySet = ItemInterface.getPetEquipItemPropertys(xMarketItem.getItem());
/*     */     Iterator i$;
/* 131 */     if ((propertySet != null) && (!propertySet.isEmpty()))
/*     */     {
/* 133 */       for (i$ = propertySet.iterator(); i$.hasNext();) { int property = ((Integer)i$.next()).intValue();
/*     */         
/*     */ 
/* 136 */         Set<Long> marketIdSet = (Set)property2MarketIds.get(Integer.valueOf(property));
/* 137 */         if (marketIdSet == null)
/*     */         {
/* 139 */           marketIdSet = new HashSet();
/* 140 */           property2MarketIds.put(Integer.valueOf(property), marketIdSet);
/*     */         }
/* 142 */         marketIdSet.add(Long.valueOf(marketId));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void removeSkillId(long marketId, MarketItem xMarketItem, boolean isPub)
/*     */   {
/* 151 */     Map<Integer, Set<Long>> skillId2MarketIds = null;
/* 152 */     if (isPub)
/*     */     {
/* 154 */       skillId2MarketIds = this.pubSkillId2MarketIds;
/*     */     }
/*     */     else
/*     */     {
/* 158 */       skillId2MarketIds = this.sellSkillId2MarketIds;
/*     */     }
/*     */     
/* 161 */     Set<Integer> skillids = ItemInterface.getPetEquipItemSkills(xMarketItem.getItem());
/*     */     Iterator i$;
/* 163 */     if ((skillids != null) && (!skillids.isEmpty()))
/*     */     {
/* 165 */       for (i$ = skillids.iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/*     */         
/*     */ 
/* 168 */         Set<Long> marketIdSet = (Set)skillId2MarketIds.get(Integer.valueOf(skillid));
/* 169 */         if (marketIdSet != null)
/*     */         {
/* 171 */           marketIdSet.remove(Long.valueOf(marketId));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void removeProperty(long marketId, MarketItem xMarketItem, boolean isPub)
/*     */   {
/* 181 */     Set<Integer> propertySet = ItemInterface.getPetEquipItemPropertys(xMarketItem.getItem());
/*     */     
/* 183 */     Map<Integer, Set<Long>> property2MarketIds = null;
/* 184 */     if (isPub)
/*     */     {
/* 186 */       property2MarketIds = this.pubProperty2MarketIds;
/*     */     }
/*     */     else
/*     */     {
/* 190 */       property2MarketIds = this.sellProperty2MarketIds;
/*     */     }
/*     */     Iterator i$;
/* 193 */     if ((propertySet != null) && (!propertySet.isEmpty()))
/*     */     {
/* 195 */       for (i$ = propertySet.iterator(); i$.hasNext();) { int property = ((Integer)i$.next()).intValue();
/*     */         
/*     */ 
/* 198 */         Set<Long> marketIdSet = (Set)property2MarketIds.get(Integer.valueOf(property));
/* 199 */         if (marketIdSet != null)
/*     */         {
/* 201 */           marketIdSet.remove(Long.valueOf(marketId));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Long> getByProperty(int property, boolean isPub)
/*     */   {
/*     */     try
/*     */     {
/* 214 */       this.lock.readLock().lock();
/*     */       
/* 216 */       Map<Integer, Set<Long>> property2MarketIds = null;
/* 217 */       if (isPub)
/*     */       {
/* 219 */         property2MarketIds = this.pubProperty2MarketIds;
/*     */       }
/*     */       else
/*     */       {
/* 223 */         property2MarketIds = this.sellProperty2MarketIds;
/*     */       }
/*     */       
/* 226 */       Set<Long> reSet = (Set)property2MarketIds.get(Integer.valueOf(property));
/* 227 */       if (reSet == null)
/*     */       {
/* 229 */         return Collections.emptySet();
/*     */       }
/*     */       
/*     */ 
/* 233 */       return reSet;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       Object localObject1;
/*     */       
/* 239 */       String logStr = String.format("[marketsearch]PetEquipConditionIndex.getByProperty@error occured on getByProperty|property=%d", new Object[] { Integer.valueOf(property) });
/*     */       
/*     */ 
/* 242 */       MarketInterface.getLogger().error(logStr, e);
/* 243 */       return Collections.emptySet();
/*     */     }
/*     */     finally
/*     */     {
/* 247 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getBySkillId(int skillId, boolean isPub)
/*     */   {
/*     */     try
/*     */     {
/* 256 */       this.lock.readLock().lock();
/*     */       
/* 258 */       Map<Integer, Set<Long>> property2MarketIds = null;
/* 259 */       if (isPub)
/*     */       {
/* 261 */         property2MarketIds = this.pubSkillId2MarketIds;
/*     */       }
/*     */       else
/*     */       {
/* 265 */         property2MarketIds = this.sellSkillId2MarketIds;
/*     */       }
/*     */       
/* 268 */       Set<Long> reSet = (Set)property2MarketIds.get(Integer.valueOf(skillId));
/* 269 */       if (reSet == null)
/*     */       {
/* 271 */         return Collections.emptySet();
/*     */       }
/*     */       
/*     */ 
/* 275 */       return reSet;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       Object localObject1;
/*     */       
/* 281 */       String logStr = String.format("[marketsearch]PetEquipConditionIndex.getBySkillId@error occured on getBySkillId|skillId=%d", new Object[] { Integer.valueOf(skillId) });
/*     */       
/*     */ 
/* 284 */       MarketInterface.getLogger().error(logStr, e);
/* 285 */       return Collections.emptySet();
/*     */     }
/*     */     finally
/*     */     {
/* 289 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> siftByCondition(PetEquipCondition petEquipCondition, boolean isPub)
/*     */   {
/*     */     try
/*     */     {
/* 298 */       this.lock.readLock().lock();
/*     */       
/* 300 */       int property = petEquipCondition.getProperty();
/* 301 */       if (property != 0)
/*     */       {
/* 303 */         Set<Long> result = new HashSet();
/* 304 */         result.addAll(getByProperty(property, isPub));
/*     */         
/* 306 */         if (result.isEmpty())
/*     */         {
/* 308 */           return result;
/*     */         }
/* 310 */         Object tempResult = new HashSet();
/* 311 */         Iterator i$; if (!petEquipCondition.getSkillIds().isEmpty())
/*     */         {
/* 313 */           for (i$ = petEquipCondition.getSkillIds().iterator(); i$.hasNext();) { int skillId = ((Integer)i$.next()).intValue();
/*     */             
/* 315 */             ((Set)tempResult).addAll(getBySkillId(skillId, isPub));
/*     */           }
/* 317 */           result.retainAll((Collection)tempResult);
/*     */         }
/* 319 */         return result;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 325 */       if (!petEquipCondition.getSkillIds().isEmpty())
/*     */       {
/* 327 */         Set<Long> result = new HashSet();
/* 328 */         for (Object i$ = petEquipCondition.getSkillIds().iterator(); ((Iterator)i$).hasNext();) { int skillId = ((Integer)((Iterator)i$).next()).intValue();
/*     */           
/* 330 */           result.addAll(getBySkillId(skillId, isPub));
/*     */         }
/* 332 */         return result;
/*     */       }
/*     */       
/*     */ 
/* 336 */       Set<Long> result = new HashSet();
/* 337 */       if (isPub)
/*     */       {
/* 339 */         for (Set<Long> set : this.pubProperty2MarketIds.values())
/*     */         {
/* 341 */           result.addAll(set);
/*     */         }
/* 343 */         for (Set<Long> set : this.pubSkillId2MarketIds.values())
/*     */         {
/* 345 */           result.addAll(set);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 350 */         for (Set<Long> set : this.sellProperty2MarketIds.values())
/*     */         {
/* 352 */           result.addAll(set);
/*     */         }
/* 354 */         for (i$ = this.sellSkillId2MarketIds.values().iterator(); ((Iterator)i$).hasNext();) { Set<Long> set = (Set)((Iterator)i$).next();
/*     */           
/* 356 */           result.addAll(set);
/*     */         }
/*     */       }
/* 359 */       return result;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       Object i$;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 368 */       String logStr = String.format("[marketsearch]PetEquipConditionIndex.siftByCondition@error occured on siftByCondition|condition=%s", new Object[] { petEquipCondition.toString() });
/*     */       
/*     */ 
/*     */ 
/* 372 */       MarketInterface.getLogger().error(logStr, e);
/* 373 */       return Collections.emptySet();
/*     */     }
/*     */     finally
/*     */     {
/* 377 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\PetEquipConditionIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */