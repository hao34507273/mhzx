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
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MarketPet;
/*     */ 
/*     */ public class PetConditionIndex
/*     */ {
/*  21 */   private final Map<Integer, Set<Long>> pubPetType2MarketIds = new HashMap();
/*  22 */   private final Map<Integer, Set<Long>> pubQuallity2MarketIds = new HashMap();
/*  23 */   private final Map<Integer, Set<Long>> pubSkillId2MarketIds = new HashMap();
/*  24 */   private final Map<Integer, Set<Long>> pubSkillNum2MarketIds = new HashMap();
/*     */   
/*  26 */   private final Map<Integer, Set<Long>> sellPetType2MarketIds = new HashMap();
/*  27 */   private final Map<Integer, Set<Long>> sellQuallity2MarketIds = new HashMap();
/*  28 */   private final Map<Integer, Set<Long>> sellSkillId2MarketIds = new HashMap();
/*  29 */   private final Map<Integer, Set<Long>> sellSkillNum2MarketIds = new HashMap();
/*     */   
/*  31 */   private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
/*     */   
/*     */   public void addPet(long marketId, MarketPet xMarketPet, boolean isPub)
/*     */   {
/*  35 */     if (xMarketPet == null)
/*     */     {
/*  37 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  42 */       this.lock.writeLock().lock();
/*     */       
/*  44 */       addPetType(marketId, xMarketPet, isPub);
/*     */       
/*  46 */       addQuality(marketId, xMarketPet, isPub);
/*     */       
/*  48 */       addSkillId(marketId, xMarketPet, isPub);
/*     */       
/*  50 */       addSkillNum(marketId, xMarketPet, isPub);
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  55 */       String logStr = String.format("[marketsearch]PetConditionIndex.addPet@error occured on addPet|marketId=%d", new Object[] { Long.valueOf(marketId) });
/*     */       
/*     */ 
/*  58 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/*  62 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void removePet(long marketId, MarketPet xMarketPet, boolean isPub)
/*     */   {
/*  68 */     if (xMarketPet == null)
/*     */     {
/*  70 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  75 */       this.lock.writeLock().lock();
/*  76 */       removePetType(marketId, xMarketPet, isPub);
/*     */       
/*  78 */       removeQuality(marketId, xMarketPet, isPub);
/*     */       
/*  80 */       removeSkillId(marketId, xMarketPet, isPub);
/*     */       
/*  82 */       removeSkillNum(marketId, xMarketPet, isPub);
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  87 */       String logStr = String.format("[marketsearch]PetConditionIndex.removePet@error occured on removePet|marketId=%d", new Object[] { Long.valueOf(marketId) });
/*     */       
/*     */ 
/*  90 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/*  94 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   private void addPetType(long marketId, MarketPet xMarketPet, boolean isPub)
/*     */   {
/* 100 */     Map<Integer, Set<Long>> petType2MarketIds = null;
/* 101 */     if (isPub)
/*     */     {
/* 103 */       petType2MarketIds = this.pubPetType2MarketIds;
/*     */     }
/*     */     else
/*     */     {
/* 107 */       petType2MarketIds = this.sellPetType2MarketIds;
/*     */     }
/*     */     
/* 110 */     int type = PetInterface.getPetType(xMarketPet.getPet().getTemplateid());
/*     */     
/* 112 */     if (type != -1)
/*     */     {
/* 114 */       Set<Long> marketIdSet = (Set)petType2MarketIds.get(Integer.valueOf(type));
/* 115 */       if (marketIdSet == null)
/*     */       {
/* 117 */         marketIdSet = new HashSet();
/* 118 */         petType2MarketIds.put(Integer.valueOf(type), marketIdSet);
/*     */       }
/* 120 */       marketIdSet.add(Long.valueOf(marketId));
/*     */     }
/*     */     else
/*     */     {
/* 124 */       String logStr = String.format("[marketsearch]PetConditionIndex.addPetType@error occured on addPetType|marketId=%d|petCfgId=%d|petType=%d", new Object[] { Long.valueOf(marketId), Integer.valueOf(xMarketPet.getPet().getTemplateid()), Integer.valueOf(type) });
/*     */       
/*     */ 
/*     */ 
/* 128 */       MarketInterface.getLogger().error(logStr);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void removePetType(long marketId, MarketPet xMarketPet, boolean isPub)
/*     */   {
/* 135 */     Map<Integer, Set<Long>> petType2MarketIds = null;
/* 136 */     if (isPub)
/*     */     {
/* 138 */       petType2MarketIds = this.pubPetType2MarketIds;
/*     */     }
/*     */     else
/*     */     {
/* 142 */       petType2MarketIds = this.sellPetType2MarketIds;
/*     */     }
/*     */     
/* 145 */     int type = PetInterface.getPetType(xMarketPet.getPet().getTemplateid());
/*     */     
/* 147 */     if (type != -1)
/*     */     {
/* 149 */       Set<Long> marketIdSet = (Set)petType2MarketIds.get(Integer.valueOf(type));
/* 150 */       if (marketIdSet != null)
/*     */       {
/* 152 */         marketIdSet.remove(Long.valueOf(marketId));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void addQuality(long marketId, MarketPet xMarketPet, boolean isPub)
/*     */   {
/* 161 */     Map<Integer, Set<Long>> quallity2MarketIds = null;
/* 162 */     if (isPub)
/*     */     {
/* 164 */       quallity2MarketIds = this.pubQuallity2MarketIds;
/*     */     }
/*     */     else
/*     */     {
/* 168 */       quallity2MarketIds = this.sellQuallity2MarketIds;
/*     */     }
/*     */     
/* 171 */     int quality = PetInterface.getPetScoreLevel(xMarketPet.getPet());
/*     */     
/* 173 */     Set<Long> marketIdSet = (Set)quallity2MarketIds.get(Integer.valueOf(quality));
/* 174 */     if (marketIdSet == null)
/*     */     {
/* 176 */       marketIdSet = new HashSet();
/* 177 */       quallity2MarketIds.put(Integer.valueOf(quality), marketIdSet);
/*     */     }
/* 179 */     marketIdSet.add(Long.valueOf(marketId));
/*     */   }
/*     */   
/*     */ 
/*     */   private void addSkillId(long marketId, MarketPet xMarketPet, boolean isPub)
/*     */   {
/* 185 */     Map<Integer, Set<Long>> skillId2MarketIds = null;
/* 186 */     if (isPub)
/*     */     {
/* 188 */       skillId2MarketIds = this.pubSkillId2MarketIds;
/*     */     }
/*     */     else
/*     */     {
/* 192 */       skillId2MarketIds = this.sellSkillId2MarketIds;
/*     */     }
/* 194 */     Set<Integer> skillids = PetInterface.getPetHasSkills(xMarketPet.getPet());
/*     */     Iterator i$;
/* 196 */     if ((skillids != null) && (!skillids.isEmpty()))
/*     */     {
/* 198 */       for (i$ = skillids.iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/*     */         
/*     */ 
/* 201 */         Set<Long> marketIdSet = (Set)skillId2MarketIds.get(Integer.valueOf(skillid));
/* 202 */         if (marketIdSet == null)
/*     */         {
/* 204 */           marketIdSet = new HashSet();
/* 205 */           skillId2MarketIds.put(Integer.valueOf(skillid), marketIdSet);
/*     */         }
/* 207 */         marketIdSet.add(Long.valueOf(marketId));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void addSkillNum(long marketId, MarketPet xMarketPet, boolean isPub)
/*     */   {
/* 216 */     Map<Integer, Set<Long>> skillNum2MarketIds = null;
/* 217 */     if (isPub)
/*     */     {
/* 219 */       skillNum2MarketIds = this.pubSkillNum2MarketIds;
/*     */     }
/*     */     else
/*     */     {
/* 223 */       skillNum2MarketIds = this.sellSkillNum2MarketIds;
/*     */     }
/*     */     
/* 226 */     Set<Integer> skillids = PetInterface.getPetHasSkills(xMarketPet.getPet());
/*     */     
/* 228 */     int skillNum = 0;
/* 229 */     if (skillids != null)
/*     */     {
/* 231 */       skillNum = skillids.size();
/*     */     }
/*     */     
/*     */ 
/* 235 */     Set<Long> marketIdSet = (Set)skillNum2MarketIds.get(Integer.valueOf(skillNum));
/* 236 */     if (marketIdSet == null)
/*     */     {
/* 238 */       marketIdSet = new HashSet();
/* 239 */       skillNum2MarketIds.put(Integer.valueOf(skillNum), marketIdSet);
/*     */     }
/* 241 */     marketIdSet.add(Long.valueOf(marketId));
/*     */   }
/*     */   
/*     */ 
/*     */   private void removeSkillId(long marketId, MarketPet xMarketPet, boolean isPub)
/*     */   {
/* 247 */     Map<Integer, Set<Long>> skillId2MarketIds = null;
/* 248 */     if (isPub)
/*     */     {
/* 250 */       skillId2MarketIds = this.pubSkillId2MarketIds;
/*     */     }
/*     */     else
/*     */     {
/* 254 */       skillId2MarketIds = this.sellSkillId2MarketIds;
/*     */     }
/* 256 */     Set<Integer> skillids = PetInterface.getPetHasSkills(xMarketPet.getPet());
/*     */     Iterator i$;
/* 258 */     if ((skillids != null) && (!skillids.isEmpty()))
/*     */     {
/* 260 */       for (i$ = skillids.iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/*     */         
/*     */ 
/* 263 */         Set<Long> marketIdSet = (Set)skillId2MarketIds.get(Integer.valueOf(skillid));
/* 264 */         if (marketIdSet != null)
/*     */         {
/* 266 */           marketIdSet.remove(Long.valueOf(marketId));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void removeSkillNum(long marketId, MarketPet xMarketPet, boolean isPub)
/*     */   {
/* 276 */     Map<Integer, Set<Long>> skillNum2MarketIds = null;
/* 277 */     if (isPub)
/*     */     {
/* 279 */       skillNum2MarketIds = this.pubSkillNum2MarketIds;
/*     */     }
/*     */     else
/*     */     {
/* 283 */       skillNum2MarketIds = this.sellSkillNum2MarketIds;
/*     */     }
/*     */     
/* 286 */     Set<Integer> skillids = PetInterface.getPetHasSkills(xMarketPet.getPet());
/*     */     
/* 288 */     int skillNum = 0;
/* 289 */     if (skillids != null)
/*     */     {
/* 291 */       skillNum = skillids.size();
/*     */     }
/*     */     
/*     */ 
/* 295 */     Set<Long> marketIdSet = (Set)skillNum2MarketIds.get(Integer.valueOf(skillNum));
/* 296 */     if (marketIdSet != null)
/*     */     {
/* 298 */       marketIdSet.remove(Long.valueOf(marketId));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void removeQuality(long marketId, MarketPet xMarketPet, boolean isPub)
/*     */   {
/* 305 */     Map<Integer, Set<Long>> quallity2MarketIds = null;
/* 306 */     if (isPub)
/*     */     {
/* 308 */       quallity2MarketIds = this.pubQuallity2MarketIds;
/*     */     }
/*     */     else
/*     */     {
/* 312 */       quallity2MarketIds = this.sellQuallity2MarketIds;
/*     */     }
/*     */     
/* 315 */     int quality = PetInterface.getPetScoreLevel(xMarketPet.getPet());
/*     */     
/* 317 */     Set<Long> marketIdSet = (Set)quallity2MarketIds.get(Integer.valueOf(quality));
/* 318 */     if (marketIdSet != null)
/*     */     {
/* 320 */       marketIdSet.remove(Long.valueOf(marketId));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Long> getByQuality(int quality, boolean isPub)
/*     */   {
/*     */     try
/*     */     {
/* 330 */       this.lock.readLock().lock();
/*     */       
/* 332 */       Map<Integer, Set<Long>> quallity2MarketIds = null;
/* 333 */       if (isPub)
/*     */       {
/* 335 */         quallity2MarketIds = this.pubQuallity2MarketIds;
/*     */       }
/*     */       else
/*     */       {
/* 339 */         quallity2MarketIds = this.sellQuallity2MarketIds;
/*     */       }
/*     */       
/* 342 */       Set<Long> reSet = (Set)quallity2MarketIds.get(Integer.valueOf(quality));
/* 343 */       if (reSet == null)
/*     */       {
/* 345 */         return Collections.emptySet();
/*     */       }
/*     */       
/*     */ 
/* 349 */       return reSet;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       Object localObject1;
/*     */       
/* 355 */       String logStr = String.format("[marketsearch]PetConditionIndex.getByQuality@error occured on getByProperty|quality=%d", new Object[] { Integer.valueOf(quality) });
/*     */       
/*     */ 
/* 358 */       MarketInterface.getLogger().error(logStr, e);
/* 359 */       return Collections.emptySet();
/*     */     }
/*     */     finally
/*     */     {
/* 363 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getBySkillId(int skillId, boolean isPub)
/*     */   {
/*     */     try
/*     */     {
/* 372 */       this.lock.readLock().lock();
/*     */       
/* 374 */       Map<Integer, Set<Long>> skillId2MarketIds = null;
/* 375 */       if (isPub)
/*     */       {
/* 377 */         skillId2MarketIds = this.pubSkillId2MarketIds;
/*     */       }
/*     */       else
/*     */       {
/* 381 */         skillId2MarketIds = this.sellSkillId2MarketIds;
/*     */       }
/*     */       
/* 384 */       Set<Long> reSet = (Set)skillId2MarketIds.get(Integer.valueOf(skillId));
/* 385 */       if (reSet == null)
/*     */       {
/* 387 */         return Collections.emptySet();
/*     */       }
/*     */       
/*     */ 
/* 391 */       return reSet;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       Object localObject1;
/*     */       
/* 397 */       String logStr = String.format("[marketsearch]PetConditionIndex.getBySkillId@error occured on getBySkillId|skillId=%d", new Object[] { Integer.valueOf(skillId) });
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
/*     */   
/*     */ 
/*     */   public Set<Long> getBySkillNum(int skillNum, boolean isPub)
/*     */   {
/*     */     try
/*     */     {
/* 414 */       this.lock.readLock().lock();
/*     */       
/* 416 */       Map<Integer, Set<Long>> skillNum2MarketIds = null;
/* 417 */       if (isPub)
/*     */       {
/* 419 */         skillNum2MarketIds = this.pubSkillNum2MarketIds;
/*     */       }
/*     */       else
/*     */       {
/* 423 */         skillNum2MarketIds = this.sellSkillNum2MarketIds;
/*     */       }
/*     */       
/* 426 */       Set<Long> reSet = (Set)skillNum2MarketIds.get(Integer.valueOf(skillNum));
/* 427 */       if (reSet == null)
/*     */       {
/* 429 */         return Collections.emptySet();
/*     */       }
/*     */       
/*     */ 
/* 433 */       return reSet;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       Object localObject1;
/*     */       
/* 439 */       String logStr = String.format("[marketsearch]PetConditionIndex.getBySkillNum@error occured on getBySkillNum|skillNum=%d", new Object[] { Integer.valueOf(skillNum) });
/*     */       
/*     */ 
/* 442 */       MarketInterface.getLogger().error(logStr, e);
/* 443 */       return Collections.emptySet();
/*     */     }
/*     */     finally
/*     */     {
/* 447 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getByPetType(int petType, boolean isPub)
/*     */   {
/*     */     try
/*     */     {
/* 456 */       this.lock.readLock().lock();
/*     */       
/* 458 */       Map<Integer, Set<Long>> petType2MarketIds = null;
/* 459 */       if (isPub)
/*     */       {
/* 461 */         petType2MarketIds = this.pubPetType2MarketIds;
/*     */       }
/*     */       else
/*     */       {
/* 465 */         petType2MarketIds = this.sellPetType2MarketIds;
/*     */       }
/*     */       
/* 468 */       Set<Long> reSet = (Set)petType2MarketIds.get(Integer.valueOf(petType));
/* 469 */       if (reSet == null)
/*     */       {
/* 471 */         return Collections.emptySet();
/*     */       }
/*     */       
/*     */ 
/* 475 */       return reSet;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       Object localObject1;
/*     */       
/* 481 */       String logStr = String.format("[marketsearch]PetConditionIndex.getByPetType@error occured on getByProperty|petType=%d", new Object[] { Integer.valueOf(petType) });
/*     */       
/*     */ 
/* 484 */       MarketInterface.getLogger().error(logStr, e);
/* 485 */       return Collections.emptySet();
/*     */     }
/*     */     finally
/*     */     {
/* 489 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> siftByCondition(PetCondition petCondition, boolean isPub)
/*     */   {
/*     */     try
/*     */     {
/* 498 */       this.lock.readLock().lock();
/*     */       
/* 500 */       Set<Long> result = new HashSet();
/* 501 */       int i = petCondition.getSkillNum();
/*     */       
/* 503 */       maxSkillNum = getMaxSkillNum(isPub);
/* 504 */       while (i <= maxSkillNum)
/*     */       {
/* 506 */         result.addAll(getBySkillNum(i, isPub));
/* 507 */         i++;
/*     */       }
/*     */       
/* 510 */       if (result.isEmpty())
/*     */       {
/* 512 */         return result;
/*     */       }
/* 514 */       Object tempResult = new HashSet();
/*     */       Iterator i$;
/* 516 */       if (!petCondition.getPetTypes().isEmpty())
/*     */       {
/* 518 */         for (i$ = petCondition.getPetTypes().iterator(); i$.hasNext();) { int petType = ((Integer)i$.next()).intValue();
/*     */           
/* 520 */           ((Set)tempResult).addAll(getByPetType(petType, isPub));
/*     */         }
/* 522 */         result.retainAll((Collection)tempResult);
/*     */       }
/* 524 */       if (result.isEmpty())
/*     */       {
/* 526 */         return result;
/*     */       }
/*     */       
/* 529 */       ((Set)tempResult).clear();
/* 530 */       Iterator i$; if (!petCondition.getQualitys().isEmpty())
/*     */       {
/* 532 */         for (i$ = petCondition.getQualitys().iterator(); i$.hasNext();) { int quality = ((Integer)i$.next()).intValue();
/*     */           
/* 534 */           ((Set)tempResult).addAll(getByQuality(quality, isPub));
/*     */         }
/* 536 */         result.retainAll((Collection)tempResult);
/*     */       }
/* 538 */       if (result.isEmpty())
/*     */       {
/* 540 */         return result;
/*     */       }
/* 542 */       ((Set)tempResult).clear();
/* 543 */       Iterator i$; if (!petCondition.getQualitys().isEmpty())
/*     */       {
/* 545 */         for (i$ = petCondition.getSkillIds().iterator(); i$.hasNext();) { int skillId = ((Integer)i$.next()).intValue();
/*     */           
/* 547 */           ((Set)tempResult).addAll(getBySkillId(skillId, isPub));
/*     */         }
/* 549 */         result.retainAll((Collection)tempResult);
/*     */       }
/*     */       
/* 552 */       return result;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       int maxSkillNum;
/* 557 */       String logStr = String.format("[marketsearch]PetConditionIndex.siftByCondition@error occured on siftByCondition|condition=%s", new Object[] { petCondition.toString() });
/*     */       
/*     */ 
/*     */ 
/* 561 */       MarketInterface.getLogger().error(logStr, e);
/* 562 */       return Collections.emptySet();
/*     */     }
/*     */     finally
/*     */     {
/* 566 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private int getMaxSkillNum(boolean isPub)
/*     */   {
/*     */     try
/*     */     {
/* 575 */       this.lock.readLock().lock();
/*     */       int i;
/* 577 */       if (isPub)
/*     */       {
/* 579 */         Set<Integer> set = this.pubSkillNum2MarketIds.keySet();
/* 580 */         if (set.isEmpty())
/*     */         {
/* 582 */           return 0;
/*     */         }
/* 584 */         return ((Integer)Collections.max(set)).intValue();
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 589 */       Set<Integer> set = this.sellSkillNum2MarketIds.keySet();
/* 590 */       if (set.isEmpty())
/*     */       {
/* 592 */         return 0;
/*     */       }
/* 594 */       return ((Integer)Collections.max(set)).intValue();
/*     */ 
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */ 
/* 601 */       String logStr = String.format("[marketsearch]PetConditionIndex.getMaxSkillNum@error occured on getMaxSkillNum", new Object[0]);
/*     */       
/* 603 */       MarketInterface.getLogger().error(logStr, e);
/* 604 */       return 0;
/*     */     }
/*     */     finally
/*     */     {
/* 608 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\PetConditionIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */