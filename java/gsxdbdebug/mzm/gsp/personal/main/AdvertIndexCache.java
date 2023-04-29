/*     */ package mzm.gsp.personal.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.personal.ConditionInfo;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class AdvertIndexCache
/*     */ {
/*  23 */   private final ReadWriteLock readWriteLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*     */   
/*     */ 
/*  26 */   private final Map<Integer, Set<Long>> genderToIds = new HashMap();
/*     */   
/*  28 */   private final TreeMap<Integer, Set<Long>> levelToIds = new TreeMap();
/*     */   
/*     */ 
/*  31 */   private final Map<Integer, Set<Long>> provinceToIds = new HashMap();
/*     */   
/*     */ 
/*  34 */   private final Map<Long, FilterInfo> filterInfos = new HashMap();
/*     */   
/*     */   private final int advertType;
/*     */   
/*  38 */   private final Comparator<Index> comparator = new IndexComparator(null);
/*     */   
/*     */   public AdvertIndexCache(int advertType)
/*     */   {
/*  42 */     this.advertType = advertType;
/*     */   }
/*     */   
/*     */   public void addAdvert(long advertId, FilterInfo filterInfo)
/*     */   {
/*  47 */     this.readWriteLock.writeLock().lock();
/*     */     
/*     */ 
/*     */     try
/*     */     {
/*  52 */       Set<Long> advertIds = (Set)this.genderToIds.get(Integer.valueOf(filterInfo.gender));
/*  53 */       if (advertIds == null)
/*     */       {
/*  55 */         advertIds = new HashSet();
/*  56 */         this.genderToIds.put(Integer.valueOf(filterInfo.gender), advertIds);
/*     */       }
/*  58 */       advertIds.add(Long.valueOf(advertId));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  63 */       Set<Long> advertIds = (Set)this.levelToIds.get(Integer.valueOf(filterInfo.level));
/*  64 */       if (advertIds == null)
/*     */       {
/*  66 */         advertIds = new HashSet();
/*  67 */         this.levelToIds.put(Integer.valueOf(filterInfo.level), advertIds);
/*     */       }
/*  69 */       advertIds.add(Long.valueOf(advertId));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  74 */       Set<Long> advertIds = (Set)this.provinceToIds.get(Integer.valueOf(filterInfo.province));
/*  75 */       if (advertIds == null)
/*     */       {
/*  77 */         advertIds = new HashSet();
/*  78 */         this.provinceToIds.put(Integer.valueOf(filterInfo.province), advertIds);
/*     */       }
/*  80 */       advertIds.add(Long.valueOf(advertId));
/*     */       
/*     */ 
/*  83 */       this.filterInfos.put(Long.valueOf(advertId), filterInfo);
/*     */       
/*  85 */       GameServer.logger().info(String.format("[personal]AdvertIdCache.addAdvert@add advert success|advertid=%d|advert_type=%d|level=%d|gender=%d|province=%d", new Object[] { Long.valueOf(advertId), Integer.valueOf(this.advertType), Integer.valueOf(filterInfo.level), Integer.valueOf(filterInfo.gender), Integer.valueOf(filterInfo.province) }));
/*     */ 
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/*     */ 
/*  92 */       this.readWriteLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void delAdvert(long advertId)
/*     */   {
/*  98 */     this.readWriteLock.writeLock().lock();
/*     */     try
/*     */     {
/* 101 */       FilterInfo filterInfo = (FilterInfo)this.filterInfos.get(Long.valueOf(advertId));
/* 102 */       if (filterInfo == null)
/*     */       {
/* 104 */         GameServer.logger().error(String.format("[personal]AdvertIdCache.delAdvert@no advert filter info when delete|advertid=%d|advert_type=%d", new Object[] { Long.valueOf(advertId), Integer.valueOf(this.advertType) }));
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*     */ 
/* 113 */         Set<Long> advertIds = (Set)this.genderToIds.get(Integer.valueOf(filterInfo.gender));
/* 114 */         if (advertIds == null)
/*     */         {
/* 116 */           GameServer.logger().error(String.format("[personal]AdvertIdCache.delAdvert@no advert when delete on gender|advertid=%d|advert_type=%d|level=%d|gender=%d|province=%d", new Object[] { Long.valueOf(advertId), Integer.valueOf(this.advertType), Integer.valueOf(filterInfo.level), Integer.valueOf(filterInfo.gender), Integer.valueOf(filterInfo.province) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/* 122 */         else if (!advertIds.remove(Long.valueOf(advertId)))
/*     */         {
/* 124 */           GameServer.logger().error(String.format("[personal]AdvertIdCache.delAdvert@no advert when delete on gender|advertid=%d|advert_type=%d|level=%d|gender=%d|province=%d", new Object[] { Long.valueOf(advertId), Integer.valueOf(this.advertType), Integer.valueOf(filterInfo.level), Integer.valueOf(filterInfo.gender), Integer.valueOf(filterInfo.province) }));
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 134 */           Set<Long> advertIds = (Set)this.levelToIds.get(Integer.valueOf(filterInfo.level));
/* 135 */           if (advertIds == null)
/*     */           {
/* 137 */             GameServer.logger().error(String.format("[personal]AdvertIdCache.delAdvert@no advert when delete on level|advertid=%d|advert_type=%d|level=%d|gender=%d|province=%d", new Object[] { Long.valueOf(advertId), Integer.valueOf(this.advertType), Integer.valueOf(filterInfo.level), Integer.valueOf(filterInfo.gender), Integer.valueOf(filterInfo.province) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           }
/* 143 */           else if (!advertIds.remove(Long.valueOf(advertId)))
/*     */           {
/* 145 */             GameServer.logger().error(String.format("[personal]AdvertIdCache.delAdvert@no advert when delete on level|advertid=%d|advert_type=%d|level=%d|gender=%d|province=%d", new Object[] { Long.valueOf(advertId), Integer.valueOf(this.advertType), Integer.valueOf(filterInfo.level), Integer.valueOf(filterInfo.gender), Integer.valueOf(filterInfo.province) }));
/*     */ 
/*     */ 
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 155 */             Set<Long> advertIds = (Set)this.provinceToIds.get(Integer.valueOf(filterInfo.province));
/* 156 */             if (advertIds == null)
/*     */             {
/* 158 */               GameServer.logger().error(String.format("[personal]AdvertIdCache.delAdvert@no advert when delete on province|advertid=%d|advert_type=%d|level=%d|gender=%d|province=%d", new Object[] { Long.valueOf(advertId), Integer.valueOf(this.advertType), Integer.valueOf(filterInfo.level), Integer.valueOf(filterInfo.gender), Integer.valueOf(filterInfo.province) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             }
/* 164 */             else if (!advertIds.remove(Long.valueOf(advertId)))
/*     */             {
/* 166 */               GameServer.logger().error(String.format("[personal]AdvertIdCache.delAdvert@no advert when delete on province|advertid=%d|advert_type=%d|level=%d|gender=%d|province=%d", new Object[] { Long.valueOf(advertId), Integer.valueOf(this.advertType), Integer.valueOf(filterInfo.level), Integer.valueOf(filterInfo.gender), Integer.valueOf(filterInfo.province) }));
/*     */ 
/*     */ 
/*     */             }
/*     */             else
/*     */             {
/*     */ 
/*     */ 
/* 174 */               this.filterInfos.remove(Long.valueOf(advertId));
/*     */               
/* 176 */               GameServer.logger().info(String.format("[personal]AdvertIdCache.onDelAdvert@delete advert success|advertid=%d|advert_type=%d|level=%d|gender=%d|province=%d", new Object[] { Long.valueOf(advertId), Integer.valueOf(this.advertType), Integer.valueOf(filterInfo.level), Integer.valueOf(filterInfo.gender), Integer.valueOf(filterInfo.province) }));
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     finally {
/* 183 */       this.readWriteLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void genderChange(long advertId, int oldGender, int newGender)
/*     */   {
/* 189 */     this.readWriteLock.writeLock().lock();
/*     */     try
/*     */     {
/* 192 */       FilterInfo oldFilterInfo = (FilterInfo)this.filterInfos.get(Long.valueOf(advertId));
/* 193 */       if (oldFilterInfo == null)
/*     */       {
/* 195 */         GameServer.logger().error(String.format("[personal]AdvertIdCache.genderChange@no advert filte info when gender change|advertid=%d|advert_type=%d|old_gender=%d|new_gender=%d", new Object[] { Long.valueOf(advertId), Integer.valueOf(this.advertType), Integer.valueOf(oldGender), Integer.valueOf(newGender) }));
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*     */ 
/* 203 */         Set<Long> advertIds = (Set)this.genderToIds.get(Integer.valueOf(oldGender));
/* 204 */         if (advertIds == null)
/*     */         {
/* 206 */           GameServer.logger().error(String.format("[personal]AdvertIdCache.genderChange@no advert when gender change|advertid=%d|advert_type=%d|old_gender=%d|new_gender=%d", new Object[] { Long.valueOf(advertId), Integer.valueOf(this.advertType), Integer.valueOf(oldGender), Integer.valueOf(newGender) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/* 212 */         else if (!advertIds.remove(Long.valueOf(advertId)))
/*     */         {
/* 214 */           GameServer.logger().error(String.format("[personal]AdvertIdCache.genderChange@no advert when gender change|advertid=%d|advert_type=%d|old_gender=%d|new_gender=%d", new Object[] { Long.valueOf(advertId), Integer.valueOf(this.advertType), Integer.valueOf(oldGender), Integer.valueOf(newGender) }));
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*     */ 
/* 223 */           Set<Long> advertIds = (Set)this.genderToIds.get(Integer.valueOf(newGender));
/* 224 */           if (advertIds == null)
/*     */           {
/* 226 */             advertIds = new HashSet();
/* 227 */             this.genderToIds.put(Integer.valueOf(newGender), advertIds);
/*     */           }
/* 229 */           advertIds.add(Long.valueOf(advertId));
/*     */           
/*     */ 
/* 232 */           FilterInfo newFilterInfo = new FilterInfo(oldFilterInfo.advertType, oldFilterInfo.level, newGender, oldFilterInfo.province);
/*     */           
/* 234 */           this.filterInfos.put(Long.valueOf(advertId), newFilterInfo);
/*     */         }
/*     */       }
/*     */     } finally {
/* 238 */       this.readWriteLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void levelChange(long advertId, int oldLevel, int newLevel)
/*     */   {
/* 244 */     this.readWriteLock.writeLock().lock();
/*     */     try
/*     */     {
/* 247 */       FilterInfo oldFilterInfo = (FilterInfo)this.filterInfos.get(Long.valueOf(advertId));
/* 248 */       if (oldFilterInfo == null)
/*     */       {
/* 250 */         GameServer.logger().error(String.format("[personal]AdvertIdCache.delAdvert@no advert filter info when level change|advertid=%d|advert_type=%d|old_level=%d|new_level=%d", new Object[] { Long.valueOf(advertId), Integer.valueOf(this.advertType), Integer.valueOf(oldLevel), Integer.valueOf(newLevel) }));
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*     */ 
/* 258 */         Set<Long> advertIds = (Set)this.levelToIds.get(Integer.valueOf(oldLevel));
/* 259 */         if (advertIds == null)
/*     */         {
/* 261 */           GameServer.logger().error(String.format("[personal]AdvertIdCache.levelChange@no advert when level change|advertid=%d|advert_type=%d|old_level=%d|new_level=%d", new Object[] { Long.valueOf(advertId), Integer.valueOf(this.advertType), Integer.valueOf(oldLevel), Integer.valueOf(newLevel) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/* 267 */         else if (!advertIds.remove(Long.valueOf(advertId)))
/*     */         {
/* 269 */           GameServer.logger().error(String.format("[personal]AdvertIdCache.levelChange@no advert when level change|advertid=%d|advert_type=%d|old_level=%d|new_level=%d", new Object[] { Long.valueOf(advertId), Integer.valueOf(this.advertType), Integer.valueOf(oldLevel), Integer.valueOf(newLevel) }));
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*     */ 
/* 278 */           Set<Long> advertIds = (Set)this.levelToIds.get(Integer.valueOf(newLevel));
/* 279 */           if (advertIds == null)
/*     */           {
/* 281 */             advertIds = new HashSet();
/* 282 */             this.levelToIds.put(Integer.valueOf(newLevel), advertIds);
/*     */           }
/* 284 */           advertIds.add(Long.valueOf(advertId));
/*     */           
/*     */ 
/* 287 */           FilterInfo newFilterInfo = new FilterInfo(oldFilterInfo.advertType, newLevel, oldFilterInfo.gender, oldFilterInfo.province);
/*     */           
/* 289 */           this.filterInfos.put(Long.valueOf(advertId), newFilterInfo);
/*     */         }
/*     */       }
/*     */     } finally {
/* 293 */       this.readWriteLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void provinceChange(long advertId, int oldProvince, int newProvince)
/*     */   {
/* 299 */     this.readWriteLock.writeLock().lock();
/*     */     try
/*     */     {
/* 302 */       FilterInfo oldFilterInfo = (FilterInfo)this.filterInfos.get(Long.valueOf(advertId));
/* 303 */       if (oldFilterInfo == null)
/*     */       {
/* 305 */         GameServer.logger().error(String.format("[personal]AdvertIdCache.delAdvert@no advert filter info when province change|advertid=%d|advert_type=%d|old_province=%d|new_province=%d", new Object[] { Long.valueOf(advertId), Integer.valueOf(this.advertType), Integer.valueOf(oldProvince), Integer.valueOf(newProvince) }));
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*     */ 
/* 313 */         Set<Long> advertIds = (Set)this.provinceToIds.get(Integer.valueOf(oldProvince));
/* 314 */         if (advertIds == null)
/*     */         {
/* 316 */           GameServer.logger().error(String.format("[personal]AdvertIdCache.provinceChange@no advert when province change|advertid=%d|advert_type=%d|old_province=%d|new_province=%d", new Object[] { Long.valueOf(advertId), Integer.valueOf(this.advertType), Integer.valueOf(oldProvince), Integer.valueOf(newProvince) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/* 322 */         else if (!advertIds.remove(Long.valueOf(advertId)))
/*     */         {
/* 324 */           GameServer.logger().error(String.format("[personal]AdvertIdCache.provinceChange@no advert when province change|advertid=%d|advert_type=%d|old_province=%d|new_province=%d", new Object[] { Long.valueOf(advertId), Integer.valueOf(this.advertType), Integer.valueOf(oldProvince), Integer.valueOf(newProvince) }));
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*     */ 
/* 333 */           Set<Long> advertIds = (Set)this.provinceToIds.get(Integer.valueOf(newProvince));
/* 334 */           if (advertIds == null)
/*     */           {
/* 336 */             advertIds = new HashSet();
/* 337 */             this.provinceToIds.put(Integer.valueOf(newProvince), advertIds);
/*     */           }
/* 339 */           advertIds.add(Long.valueOf(advertId));
/*     */           
/*     */ 
/* 342 */           FilterInfo newFilterInfo = new FilterInfo(oldFilterInfo.advertType, oldFilterInfo.level, oldFilterInfo.gender, newProvince);
/*     */           
/* 344 */           this.filterInfos.put(Long.valueOf(advertId), newFilterInfo);
/*     */         }
/*     */       }
/*     */     } finally {
/* 348 */       this.readWriteLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public FilterInfo getFilterInfo(long advertid)
/*     */   {
/* 354 */     this.readWriteLock.readLock().lock();
/*     */     try
/*     */     {
/* 357 */       return (FilterInfo)this.filterInfos.get(Long.valueOf(advertid));
/*     */     }
/*     */     finally
/*     */     {
/* 361 */       this.readWriteLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public Collection<Long> searchAdverts(ConditionInfo queryConditionInfo)
/*     */   {
/* 367 */     this.readWriteLock.readLock().lock();
/*     */     try
/*     */     {
/* 370 */       return interSections(queryConditionInfo);
/*     */     }
/*     */     finally
/*     */     {
/* 374 */       this.readWriteLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   private Collection<Long> interSections(ConditionInfo queryConditionInfo)
/*     */   {
/* 380 */     int gender = queryConditionInfo.gender;
/* 381 */     int province = queryConditionInfo.location;
/* 382 */     int minLevel = queryConditionInfo.minlevel;
/* 383 */     int maxLevel = queryConditionInfo.maxlevel;
/*     */     
/* 385 */     List<Index> indexColls = new java.util.ArrayList();
/*     */     
/* 387 */     NavigableMap<Integer, Set<Long>> subLevelToIds = this.levelToIds.subMap(Integer.valueOf(minLevel), true, Integer.valueOf(maxLevel), true);
/* 388 */     if (subLevelToIds.isEmpty())
/*     */     {
/* 390 */       return Collections.emptyList();
/*     */     }
/* 392 */     Index levelIndex = new LevelIndex(subLevelToIds);
/* 393 */     indexColls.add(levelIndex);
/*     */     
/*     */ 
/* 396 */     if (province != -1)
/*     */     {
/* 398 */       Set<Long> provinceIds = (Set)this.provinceToIds.get(Integer.valueOf(province));
/* 399 */       if ((provinceIds == null) || (provinceIds.isEmpty()))
/*     */       {
/* 401 */         return Collections.emptyList();
/*     */       }
/* 403 */       Index provinceIndex = new CommonIndex(provinceIds);
/* 404 */       indexColls.add(provinceIndex);
/*     */     }
/*     */     
/*     */ 
/* 408 */     if (gender != -1)
/*     */     {
/* 410 */       Set<Long> genderIds = (Set)this.genderToIds.get(Integer.valueOf(gender));
/* 411 */       if ((genderIds == null) || (genderIds.isEmpty()))
/*     */       {
/* 413 */         return Collections.emptyList();
/*     */       }
/* 415 */       Index genderIndex = new CommonIndex(genderIds);
/* 416 */       indexColls.add(genderIndex);
/*     */     }
/*     */     
/* 419 */     if (indexColls.size() == 1)
/*     */     {
/* 421 */       return ((Index)indexColls.get(0)).getAdvertids();
/*     */     }
/*     */     
/* 424 */     Collections.sort(indexColls, this.comparator);
/*     */     
/* 426 */     Index index = (Index)indexColls.get(0);
/* 427 */     Set<Long> result = index.getAdvertids();
/* 428 */     int size = indexColls.size();
/* 429 */     for (int i = 1; i < size; i++)
/*     */     {
/* 431 */       result = ((Index)indexColls.get(i)).retainAll(result);
/*     */     }
/* 433 */     return result;
/*     */   }
/*     */   
/*     */   private static abstract interface Index
/*     */   {
/*     */     public abstract Set<Long> getAdvertids();
/*     */     
/*     */     public abstract int getSize();
/*     */     
/*     */     public abstract Set<Long> retainAll(Set<Long> paramSet);
/*     */   }
/*     */   
/*     */   private static class CommonIndex implements AdvertIndexCache.Index
/*     */   {
/*     */     final Set<Long> commonIds;
/*     */     
/*     */     public CommonIndex(Set<Long> commonIds)
/*     */     {
/* 451 */       this.commonIds = commonIds;
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Long> getAdvertids()
/*     */     {
/* 457 */       if (this.commonIds == null)
/*     */       {
/* 459 */         return Collections.emptySet();
/*     */       }
/*     */       
/*     */ 
/* 463 */       return new HashSet(this.commonIds);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSize()
/*     */     {
/* 470 */       if (this.commonIds == null)
/*     */       {
/* 472 */         return 0;
/*     */       }
/*     */       
/*     */ 
/* 476 */       return this.commonIds.size();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> retainAll(Set<Long> advertids)
/*     */     {
/* 483 */       advertids.retainAll(this.commonIds);
/* 484 */       return advertids;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class LevelIndex implements AdvertIndexCache.Index
/*     */   {
/*     */     private final NavigableMap<Integer, Set<Long>> subLevelToIds;
/* 491 */     private int size = -1;
/*     */     
/*     */     public LevelIndex(NavigableMap<Integer, Set<Long>> subLevelToIds)
/*     */     {
/* 495 */       this.subLevelToIds = subLevelToIds;
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Long> getAdvertids()
/*     */     {
/* 501 */       Set<Long> levelIds = new HashSet();
/* 502 */       for (Map.Entry<Integer, Set<Long>> entry : this.subLevelToIds.entrySet())
/*     */       {
/* 504 */         levelIds.addAll((Collection)entry.getValue());
/*     */       }
/* 506 */       return levelIds;
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSize()
/*     */     {
/* 512 */       if (this.size != -1)
/*     */       {
/* 514 */         return this.size;
/*     */       }
/*     */       
/* 517 */       int levelIdSize = 0;
/* 518 */       for (Set<Long> value : this.subLevelToIds.values())
/*     */       {
/* 520 */         levelIdSize += value.size();
/*     */       }
/* 522 */       this.size = levelIdSize;
/* 523 */       return this.size;
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Long> retainAll(Set<Long> advertids)
/*     */     {
/* 529 */       Set<Long> result = new HashSet();
/* 530 */       for (Iterator i$ = this.subLevelToIds.values().iterator(); i$.hasNext();) { value = (Set)i$.next();
/*     */         
/* 532 */         for (i$ = advertids.iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/*     */           
/* 534 */           if (value.contains(Long.valueOf(id)))
/*     */           {
/* 536 */             result.add(Long.valueOf(id)); }
/*     */         }
/*     */       }
/*     */       Set<Long> value;
/*     */       Iterator i$;
/* 541 */       return result;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class IndexComparator
/*     */     implements Comparator<AdvertIndexCache.Index>
/*     */   {
/*     */     public int compare(AdvertIndexCache.Index o1, AdvertIndexCache.Index o2)
/*     */     {
/* 550 */       return o1.getSize() - o2.getSize();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\AdvertIndexCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */