/*     */ package mzm.gsp.util;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.NavigableSet;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import java.util.TreeSet;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Rank<TKey, TRankObj extends RankObj<TKey>>
/*     */ {
/*  25 */   private TreeSet<TRankObj> sortedSet = new TreeSet();
/*     */   
/*  27 */   private TreeMap<TKey, TRankObj> cacheMap = new TreeMap();
/*     */   
/*  29 */   private ReadWriteLock lock = new ReentrantReadWriteLock();
/*     */   
/*     */ 
/*     */   private final int capacity;
/*     */   
/*     */ 
/*     */   private final int pageSize;
/*     */   
/*     */ 
/*     */   private final RankPageCache<TKey, TRankObj> rankPageCache;
/*     */   
/*     */ 
/*     */ 
/*     */   public Rank(int capacity, int pageSize)
/*     */   {
/*  44 */     this(capacity, pageSize, (capacity > 0) && (capacity / pageSize < 512));
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
/*     */   private Rank(int capacity, int pageSize, boolean cacheWithList)
/*     */   {
/*  58 */     this.capacity = capacity;
/*  59 */     this.pageSize = pageSize;
/*  60 */     if (cacheWithList) {
/*  61 */       this.rankPageCache = new RankPageCacheWithList(this);
/*     */     }
/*     */     else {
/*  64 */       this.rankPageCache = new RankPageCacheWithMap(32, this);
/*     */     }
/*  66 */     if (pageSize <= 0) {
/*  67 */       throw new RuntimeException(String.format("[Rank]Rank.Rank@传递的参数值不合法|pageSize=%d", new Object[] { Integer.valueOf(pageSize) }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getCapacity()
/*     */   {
/*  78 */     return this.capacity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int size()
/*     */   {
/*  87 */     this.lock.readLock().lock();
/*     */     try {
/*  89 */       return this.sortedSet.size();
/*     */     } finally {
/*  91 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isOutOfCapacity(int nowSize) {
/*  96 */     return (this.capacity > 0) && (nowSize >= this.capacity);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean rank(TRankObj rankObj)
/*     */   {
/* 105 */     this.lock.writeLock().lock();
/*     */     try {
/* 107 */       int size = this.sortedSet.size();
/* 108 */       if (isOutOfCapacity(size))
/* 109 */         return false;
/*     */       Object key;
/* 111 */       if (this.sortedSet.add(rankObj))
/*     */       {
/* 113 */         key = rankObj.getKey();
/* 114 */         this.cacheMap.put(key, rankObj);
/* 115 */         this.rankPageCache.onAddRankObj(rankObj);
/* 116 */         return true;
/*     */       }
/* 118 */       return false;
/*     */     } finally {
/* 120 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   static class TestRankObj extends RankObj<Integer>
/*     */   {
/*     */     private int key;
/*     */     
/*     */     public TestRankObj(int key) {
/* 129 */       this.key = key;
/*     */     }
/*     */     
/*     */     public Integer getKey()
/*     */     {
/* 134 */       return Integer.valueOf(this.key);
/*     */     }
/*     */     
/*     */     public int compareTo(RankObj<Integer> o)
/*     */     {
/* 139 */       return this.key - ((Integer)o.getKey()).intValue();
/*     */     }
/*     */     
/*     */     public String toString()
/*     */     {
/* 144 */       return String.valueOf(this.key);
/*     */     }
/*     */   }
/*     */   
/*     */   <T> void print(List<T> list)
/*     */   {
/* 150 */     for (T t : list) {
/* 151 */       System.out.print(t.toString());
/* 152 */       System.out.print("|");
/*     */     }
/* 154 */     System.out.println();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args) {}
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TRankObj getObjByKey(TKey tKey)
/*     */   {
/* 255 */     this.lock.readLock().lock();
/*     */     try {
/* 257 */       return (RankObj)this.cacheMap.get(tKey);
/*     */     } finally {
/* 259 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean delete(TKey tKey) {
/* 264 */     TRankObj rankObj = getObjByKey(tKey);
/* 265 */     return delete(rankObj);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean delete(TRankObj rankObj)
/*     */   {
/* 274 */     if (rankObj == null) {
/* 275 */       return false;
/*     */     }
/* 277 */     this.lock.writeLock().lock();
/*     */     try {
/* 279 */       boolean ret = this.sortedSet.remove(rankObj);
/* 280 */       if (ret) {
/* 281 */         this.cacheMap.remove(rankObj.getKey());
/* 282 */         this.rankPageCache.onRemRankObj(rankObj);
/*     */       }
/* 284 */       return ret;
/*     */     } finally {
/* 286 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void clear()
/*     */   {
/* 294 */     this.lock.writeLock().lock();
/*     */     try {
/* 296 */       this.cacheMap.clear();
/* 297 */       this.sortedSet.clear();
/* 298 */       this.rankPageCache.clear();
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 301 */       this.lock.writeLock().unlock();
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
/*     */   public List<TRankObj> getAscendRankObjs(int pageNum)
/*     */   {
/* 314 */     this.lock.readLock().lock();
/*     */     try {
/* 316 */       return this.rankPageCache.getAscendRankObjs(pageNum);
/*     */     } finally {
/* 318 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<TRankObj> getDesendRankObjs(int pageNum)
/*     */   {
/* 330 */     this.lock.readLock().lock();
/*     */     try {
/* 332 */       return this.rankPageCache.getDesendRankObjs(pageNum);
/*     */     } finally {
/* 334 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<TRankObj> getAllChartObjs()
/*     */   {
/* 344 */     List<TRankObj> allChartObjs = new LinkedList();
/* 345 */     this.lock.readLock().lock();
/*     */     try {
/* 347 */       allChartObjs.addAll(this.sortedSet);
/*     */     } finally {
/* 349 */       this.lock.readLock().unlock();
/*     */     }
/* 351 */     return allChartObjs;
/*     */   }
/*     */   
/*     */ 
/*     */   private static class RankPageCacheWithMap<TKey, TRankObj extends RankObj<TKey>>
/*     */     implements RankPageCache<TKey, TRankObj>
/*     */   {
/* 358 */     private TreeMap<Integer, TRankObj> ascendPageMap = new TreeMap();
/*     */     private TreeMap<TRankObj, Integer> ascendObj2PageMap;
/* 360 */     private ReadWriteLock ascendReadWriteLock = new ReentrantReadWriteLock();
/*     */     
/*     */ 
/* 363 */     private TreeMap<Integer, TRankObj> descendPageMap = new TreeMap();
/*     */     private TreeMap<TRankObj, Integer> descendObj2PageMap;
/* 365 */     private ReadWriteLock descendReadWriteLock = new ReentrantReadWriteLock();
/*     */     
/*     */     private int useDoubleWhenSize;
/*     */     
/*     */     private Rank<TKey, TRankObj> rank;
/*     */     
/*     */ 
/*     */     public RankPageCacheWithMap(int useDoubleWhenSize, Rank<TKey, TRankObj> rank)
/*     */     {
/* 374 */       this.useDoubleWhenSize = useDoubleWhenSize;
/* 375 */       this.rank = rank;
/*     */     }
/*     */     
/*     */     public void onAddRankObj(TRankObj rankObj)
/*     */     {
/* 380 */       delCache(rankObj, true, this.ascendReadWriteLock);
/* 381 */       delCache(rankObj, false, this.descendReadWriteLock);
/*     */     }
/*     */     
/*     */     private void delCache(TRankObj rankObj, boolean ascend, ReadWriteLock readWriteLock) {
/* 385 */       TreeMap<TRankObj, Integer> obj2PageMap = getObjMap(ascend);
/* 386 */       TreeMap<Integer, TRankObj> pageMap = getPageMap(ascend);
/* 387 */       readWriteLock.writeLock().lock();
/*     */       try {
/* 389 */         int beginPage = -1;
/* 390 */         if (obj2PageMap != null) {
/* 391 */           NavigableMap<TRankObj, Integer> sortedMap = null;
/* 392 */           if (ascend) {
/* 393 */             sortedMap = obj2PageMap.tailMap(rankObj, true);
/* 394 */             Map.Entry<TRankObj, Integer> entry = sortedMap.firstEntry();
/* 395 */             if (entry != null) {
/* 396 */               beginPage = ((Integer)entry.getValue()).intValue();
/*     */             }
/*     */           } else {
/* 399 */             sortedMap = obj2PageMap.headMap(rankObj, true);
/* 400 */             Map.Entry<TRankObj, Integer> entry = sortedMap.lastEntry();
/* 401 */             if (entry != null) {
/* 402 */               beginPage = ((Integer)entry.getValue()).intValue();
/*     */             }
/*     */           }
/* 405 */           Iterator<Map.Entry<TRankObj, Integer>> iterator = sortedMap.entrySet().iterator();
/* 406 */           while (iterator.hasNext()) {
/* 407 */             iterator.next();
/* 408 */             iterator.remove();
/*     */           }
/*     */         }
/* 411 */         if (beginPage < 0)
/*     */         {
/* 413 */           beginPage = 1;
/*     */         }
/* 415 */         boolean validate = true;
/* 416 */         NavigableMap<Integer, TRankObj> sortedMap = pageMap.tailMap(Integer.valueOf(beginPage), true);
/* 417 */         Iterator<Map.Entry<Integer, TRankObj>> iterator = sortedMap.entrySet().iterator();
/* 418 */         while (iterator.hasNext()) {
/* 419 */           Map.Entry<Integer, TRankObj> entry = (Map.Entry)iterator.next();
/* 420 */           TRankObj tempRankObj = (RankObj)entry.getValue();
/* 421 */           if (validate) {
/* 422 */             if (((ascend) && (tempRankObj.compareTo(rankObj) >= 0)) || ((!ascend) && (tempRankObj.compareTo(rankObj) <= 0)))
/*     */             {
/* 424 */               validate = false;
/* 425 */               iterator.remove();
/*     */             }
/*     */           } else {
/* 428 */             iterator.remove();
/*     */           }
/*     */         }
/*     */       } finally {
/* 432 */         readWriteLock.writeLock().unlock();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     public void onRemRankObj(TRankObj rankObj)
/*     */     {
/* 439 */       delCache(rankObj, true, this.ascendReadWriteLock);
/* 440 */       delCache(rankObj, false, this.descendReadWriteLock);
/*     */     }
/*     */     
/*     */     public void clear()
/*     */     {
/* 445 */       this.ascendReadWriteLock.writeLock().lock();
/*     */       try {
/* 447 */         if (this.ascendObj2PageMap != null) {
/* 448 */           this.ascendObj2PageMap.clear();
/*     */         }
/* 450 */         this.ascendPageMap.clear();
/*     */       } finally {
/* 452 */         this.ascendReadWriteLock.writeLock().unlock();
/*     */       }
/*     */       
/* 455 */       this.descendReadWriteLock.writeLock().lock();
/*     */       try {
/* 457 */         if (this.descendObj2PageMap != null) {
/* 458 */           this.descendObj2PageMap.clear();
/*     */         }
/* 460 */         this.descendPageMap.clear();
/*     */       } finally {
/* 462 */         this.descendReadWriteLock.writeLock().unlock();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     public List<TRankObj> getAscendRankObjs(int pageNum)
/*     */     {
/* 469 */       return getCacheObjs(pageNum, true, this.ascendReadWriteLock);
/*     */     }
/*     */     
/*     */     public List<TRankObj> getDesendRankObjs(int pageNum)
/*     */     {
/* 474 */       return getCacheObjs(pageNum, false, this.descendReadWriteLock);
/*     */     }
/*     */     
/*     */     private TreeMap<TRankObj, Integer> getObjMap(boolean ascend) {
/* 478 */       if (ascend) {
/* 479 */         return this.ascendObj2PageMap;
/*     */       }
/* 481 */       return this.descendObj2PageMap;
/*     */     }
/*     */     
/*     */     private TreeMap<TRankObj, Integer> getAndInitObjMap(boolean ascend)
/*     */     {
/* 486 */       if (ascend) {
/* 487 */         this.ascendObj2PageMap = new TreeMap();
/* 488 */         return this.ascendObj2PageMap;
/*     */       }
/* 490 */       this.descendObj2PageMap = new TreeMap();
/* 491 */       return this.descendObj2PageMap;
/*     */     }
/*     */     
/*     */     private TreeMap<Integer, TRankObj> getPageMap(boolean ascend)
/*     */     {
/* 496 */       if (ascend) {
/* 497 */         return this.ascendPageMap;
/*     */       }
/* 499 */       return this.descendPageMap;
/*     */     }
/*     */     
/*     */     private List<TRankObj> getCacheObjs(int pageNum, boolean ascend, ReadWriteLock readWriteLock)
/*     */     {
/* 504 */       TreeMap<Integer, TRankObj> pageMap = getPageMap(ascend);
/* 505 */       TreeMap<TRankObj, Integer> objMap = getObjMap(ascend);
/* 506 */       int latestPageNum = -1;
/* 507 */       TRankObj fromObj = null;
/* 508 */       readWriteLock.readLock().lock();
/*     */       try {
/* 510 */         NavigableMap<Integer, TRankObj> tailMap = pageMap.tailMap(Integer.valueOf(pageNum), true);
/* 511 */         if (!tailMap.isEmpty()) {
/* 512 */           Map.Entry<Integer, TRankObj> fisrtEntry = tailMap.firstEntry();
/* 513 */           if (fisrtEntry != null) {
/* 514 */             latestPageNum = ((Integer)fisrtEntry.getKey()).intValue();
/*     */           }
/*     */         }
/*     */         
/* 518 */         if (latestPageNum != pageNum) {
/* 519 */           NavigableMap<Integer, TRankObj> headMap = pageMap.headMap(Integer.valueOf(pageNum), true);
/* 520 */           if (!headMap.isEmpty()) {
/* 521 */             Map.Entry<Integer, TRankObj> lastEntry = headMap.lastEntry();
/* 522 */             if (lastEntry != null) {
/* 523 */               int lastNum = ((Integer)lastEntry.getKey()).intValue();
/* 524 */               if (latestPageNum > 0) {
/* 525 */                 if (pageNum - lastNum < latestPageNum - pageNum) {
/* 526 */                   latestPageNum = lastNum;
/*     */                 }
/*     */               } else {
/* 529 */                 latestPageNum = lastNum;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 535 */         if (latestPageNum < 0) {
/* 536 */           latestPageNum = 0;
/*     */         }
/* 538 */         fromObj = (RankObj)pageMap.get(Integer.valueOf(latestPageNum));
/*     */       } finally {
/* 540 */         readWriteLock.readLock().unlock();
/*     */       }
/*     */       
/* 543 */       NavigableSet<TRankObj> navigableSet = this.rank.sortedSet;
/* 544 */       if (!ascend) {
/* 545 */         navigableSet = this.rank.sortedSet.descendingSet();
/*     */       }
/* 547 */       if (fromObj != null) {
/* 548 */         if (pageNum == latestPageNum) {
/* 549 */           navigableSet = navigableSet.headSet(fromObj, true);
/* 550 */           NavigableSet<TRankObj> descendSet = navigableSet.descendingSet();
/* 551 */           LinkedList<TRankObj> retList = new LinkedList();
/* 552 */           int num = 0;
/* 553 */           for (Iterator i$ = descendSet.iterator(); i$.hasNext(); 
/*     */               
/* 555 */               num >= this.rank.pageSize)
/*     */           {
/* 553 */             TRankObj rankObj = (RankObj)i$.next();
/* 554 */             retList.addFirst(rankObj);
/* 555 */             num++;
/*     */           }
/*     */           
/*     */ 
/* 559 */           return retList; }
/* 560 */         if (pageNum < latestPageNum) {
/* 561 */           navigableSet = navigableSet.headSet(fromObj, true);
/* 562 */           latestPageNum = 0;
/*     */         } else {
/* 564 */           navigableSet = navigableSet.tailSet(fromObj, false);
/*     */         }
/*     */       }
/*     */       
/* 568 */       List<TRankObj> retRankObjs = new ArrayList();
/* 569 */       int addNum = 0;
/* 570 */       for (Object rankObj : navigableSet) {
/* 571 */         if (latestPageNum == pageNum - 1) {
/* 572 */           retRankObjs.add(rankObj);
/*     */         }
/* 574 */         addNum++;
/* 575 */         if (addNum >= this.rank.pageSize) {
/* 576 */           addNum = 0;
/* 577 */           latestPageNum++;
/* 578 */           readWriteLock.writeLock().lock();
/*     */           try {
/* 580 */             pageMap.put(Integer.valueOf(latestPageNum), rankObj);
/* 581 */             if (objMap != null) {
/* 582 */               objMap.put(rankObj, Integer.valueOf(latestPageNum));
/*     */             }
/*     */           } finally {
/* 585 */             readWriteLock.writeLock().unlock();
/*     */           }
/* 587 */           if (latestPageNum >= pageNum) {
/*     */             break;
/*     */           }
/*     */         }
/*     */       }
/* 592 */       readWriteLock.writeLock().lock();
/*     */       try {
/* 594 */         if ((pageMap.size() > this.useDoubleWhenSize) && 
/* 595 */           (objMap == null)) {
/* 596 */           objMap = getAndInitObjMap(ascend);
/* 597 */           for (Object entry : pageMap.entrySet()) {
/* 598 */             objMap.put(((Map.Entry)entry).getValue(), ((Map.Entry)entry).getKey());
/*     */           }
/*     */         }
/*     */       }
/*     */       finally {
/* 603 */         readWriteLock.writeLock().unlock();
/*     */       }
/*     */       
/* 606 */       return retRankObjs;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class RankPageCacheWithList<TKey, TRankObj extends RankObj<TKey>> implements RankPageCache<TKey, TRankObj> {
/*     */     private List<CacheEntry<TRankObj>> ascendCacheEntries;
/*     */     private List<CacheEntry<TRankObj>> descendCacheEntries;
/*     */     
/*     */     static class CacheEntry<TRankObj> { private final int page;
/*     */       private TRankObj rankObj;
/*     */       
/* 617 */       public CacheEntry(int page, TRankObj rankObj) { this.page = page;
/* 618 */         this.rankObj = rankObj;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 626 */     private ReadWriteLock ascendReadWriteLock = new ReentrantReadWriteLock();
/*     */     
/* 628 */     private ReadWriteLock descendReadWriteLock = new ReentrantReadWriteLock();
/*     */     private Rank<TKey, TRankObj> rank;
/*     */     
/*     */     RankPageCacheWithList(Rank<TKey, TRankObj> rank)
/*     */     {
/* 633 */       this.ascendReadWriteLock.writeLock().lock();
/*     */       try {
/* 635 */         this.ascendCacheEntries = new ArrayList();
/*     */       } finally {
/* 637 */         this.ascendReadWriteLock.writeLock().unlock();
/*     */       }
/*     */       
/* 640 */       this.descendReadWriteLock.writeLock().lock();
/*     */       try {
/* 642 */         this.descendCacheEntries = new ArrayList();
/*     */       } finally {
/* 644 */         this.descendReadWriteLock.writeLock().unlock();
/*     */       }
/*     */       
/* 647 */       this.rank = rank;
/*     */     }
/*     */     
/*     */     public void onAddRankObj(TRankObj rankObj)
/*     */     {
/* 652 */       modifyCache(rankObj, true, this.ascendCacheEntries, this.ascendReadWriteLock);
/* 653 */       modifyCache(rankObj, false, this.descendCacheEntries, this.descendReadWriteLock);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private void modifyCache(TRankObj rankObj, boolean ascend, List<CacheEntry<TRankObj>> cacheEntries, ReadWriteLock readWriteLock)
/*     */     {
/* 666 */       readWriteLock.writeLock().lock();
/*     */       try {
/* 668 */         int index = topIndex(rankObj, ascend, cacheEntries);
/* 669 */         if (index >= 0) {
/* 670 */           for (int i = cacheEntries.size() - 1; i >= index; i--) {
/* 671 */             cacheEntries.remove(i);
/*     */           }
/*     */         }
/*     */       } finally {
/* 675 */         readWriteLock.writeLock().unlock();
/*     */       }
/*     */     }
/*     */     
/*     */     public void onRemRankObj(TRankObj rankObj)
/*     */     {
/* 681 */       modifyCache(rankObj, true, this.ascendCacheEntries, this.ascendReadWriteLock);
/* 682 */       modifyCache(rankObj, false, this.descendCacheEntries, this.ascendReadWriteLock);
/*     */     }
/*     */     
/*     */     public void clear()
/*     */     {
/* 687 */       this.ascendReadWriteLock.writeLock().lock();
/*     */       try {
/* 689 */         this.ascendCacheEntries.clear();
/*     */       } finally {
/* 691 */         this.ascendReadWriteLock.writeLock().unlock();
/*     */       }
/*     */       
/* 694 */       this.descendReadWriteLock.writeLock().lock();
/*     */       try {
/* 696 */         this.descendCacheEntries.clear();
/*     */       } finally {
/* 698 */         this.descendReadWriteLock.writeLock().unlock();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     public List<TRankObj> getAscendRankObjs(int pageNum)
/*     */     {
/* 705 */       return getCacheObjs(pageNum, true, this.ascendCacheEntries, this.ascendReadWriteLock);
/*     */     }
/*     */     
/*     */     public List<TRankObj> getDesendRankObjs(int pageNum)
/*     */     {
/* 710 */       return getCacheObjs(pageNum, false, this.descendCacheEntries, this.descendReadWriteLock);
/*     */     }
/*     */     
/*     */ 
/*     */     private List<TRankObj> getCacheObjs(int pageNum, boolean ascend, List<CacheEntry<TRankObj>> cacheEntries, ReadWriteLock readWriteLock)
/*     */     {
/* 716 */       readWriteLock.readLock().lock();
/*     */       
/* 718 */       CacheEntry<TRankObj> cacheEntry = null;
/*     */       try {
/* 720 */         int index = topIndex(pageNum, cacheEntries);
/* 721 */         int size = cacheEntries.size();
/*     */         
/* 723 */         if (index < 0) {
/* 724 */           if (size > 0)
/* 725 */             cacheEntry = (CacheEntry)cacheEntries.get(size - 1);
/*     */         } else {
/* 727 */           cacheEntry = (CacheEntry)cacheEntries.get(index);
/* 728 */           int beforeIndex = index - 1;
/* 729 */           if (beforeIndex >= 0) {
/* 730 */             CacheEntry<TRankObj> beforeEntry = (CacheEntry)cacheEntries.get(beforeIndex);
/* 731 */             if (pageNum - beforeEntry.page < cacheEntry.page - pageNum) {
/* 732 */               cacheEntry = beforeEntry;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       finally {
/* 738 */         readWriteLock.readLock().unlock();
/*     */       }
/*     */       
/* 741 */       int latestPageNum = 0;
/* 742 */       TRankObj fromObj = null;
/* 743 */       if (cacheEntry != null) {
/* 744 */         latestPageNum = cacheEntry.page;
/* 745 */         fromObj = (RankObj)cacheEntry.rankObj;
/*     */       }
/*     */       
/* 748 */       NavigableSet<TRankObj> navigableSet = this.rank.sortedSet;
/* 749 */       if (!ascend) {
/* 750 */         navigableSet = this.rank.sortedSet.descendingSet();
/*     */       }
/* 752 */       if (fromObj != null) {
/* 753 */         if (pageNum == latestPageNum) {
/* 754 */           navigableSet = navigableSet.headSet(fromObj, true);
/* 755 */           NavigableSet<TRankObj> descendSet = navigableSet.descendingSet();
/* 756 */           Object retList = new LinkedList();
/* 757 */           int num = 0;
/* 758 */           for (Iterator i$ = descendSet.iterator(); i$.hasNext(); 
/*     */               
/* 760 */               num >= this.rank.pageSize)
/*     */           {
/* 758 */             TRankObj rankObj = (RankObj)i$.next();
/* 759 */             ((LinkedList)retList).addFirst(rankObj);
/* 760 */             num++;
/*     */           }
/*     */           
/*     */ 
/* 764 */           return (List<TRankObj>)retList; }
/* 765 */         if (pageNum < latestPageNum) {
/* 766 */           navigableSet = navigableSet.headSet(fromObj, true);
/* 767 */           latestPageNum = 0;
/*     */         } else {
/* 769 */           navigableSet = navigableSet.tailSet(fromObj, false);
/*     */         }
/*     */       }
/*     */       
/* 773 */       List<TRankObj> retRankObjs = new ArrayList();
/* 774 */       int addNum = 0;
/* 775 */       for (TRankObj rankObj : navigableSet) {
/* 776 */         if (latestPageNum == pageNum - 1) {
/* 777 */           retRankObjs.add(rankObj);
/*     */         }
/* 779 */         addNum++;
/* 780 */         if (addNum >= this.rank.pageSize) {
/* 781 */           addNum = 0;
/* 782 */           latestPageNum++;
/* 783 */           if (latestPageNum >= pageNum) {
/*     */             break;
/*     */           }
/*     */           
/* 787 */           CacheEntry<TRankObj> tempCacheEntry = new CacheEntry(latestPageNum, rankObj);
/*     */           
/* 789 */           readWriteLock.writeLock().lock();
/* 790 */           int topIndex = -1;
/*     */           try {
/* 792 */             topIndex = topIndex(latestPageNum, cacheEntries);
/* 793 */             if (topIndex < 0) {
/* 794 */               if (!cacheEntries.contains(tempCacheEntry)) {
/* 795 */                 cacheEntries.add(tempCacheEntry);
/*     */               }
/*     */             } else {
/* 798 */               CacheEntry<TRankObj> entry = (CacheEntry)cacheEntries.get(topIndex);
/*     */               
/* 800 */               if ((entry.page != latestPageNum) && 
/* 801 */                 (!cacheEntries.contains(tempCacheEntry))) {
/* 802 */                 cacheEntries.add(topIndex, tempCacheEntry);
/*     */               }
/*     */             }
/*     */           }
/*     */           finally {
/* 807 */             readWriteLock.writeLock().unlock();
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 812 */       return retRankObjs;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private int topIndex(int pageNum, List<CacheEntry<TRankObj>> cacheEntries)
/*     */     {
/* 822 */       if (cacheEntries.size() <= 0) {
/* 823 */         return -1;
/*     */       }
/* 825 */       int begin = 0;
/* 826 */       int end = cacheEntries.size() - 1;
/* 827 */       CacheEntry<TRankObj> endCacheEntry = (CacheEntry)cacheEntries.get(end);
/* 828 */       if (endCacheEntry.page < pageNum)
/* 829 */         return -1;
/* 830 */       if (endCacheEntry.page == pageNum) {
/* 831 */         return end;
/*     */       }
/* 833 */       CacheEntry<TRankObj> beginCacheEntry = (CacheEntry)cacheEntries.get(0);
/* 834 */       if (beginCacheEntry.page >= pageNum) {
/* 835 */         return 0;
/*     */       }
/* 837 */       while (begin != end) {
/* 838 */         int middle = (begin + end) / 2;
/* 839 */         CacheEntry<TRankObj> middleChartObj = (CacheEntry)cacheEntries.get(middle);
/* 840 */         if (middleChartObj.page == pageNum)
/* 841 */           return middle;
/* 842 */         if (middleChartObj.page > pageNum) {
/* 843 */           if (end == middle) {
/* 844 */             return end;
/*     */           }
/* 846 */           end = middle;
/* 847 */         } else if (middleChartObj.page < pageNum) {
/* 848 */           if (begin == middle) {
/* 849 */             return end;
/*     */           }
/* 851 */           begin = middle;
/*     */         }
/*     */       }
/* 854 */       return end;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private int topIndex(TRankObj rankObj, boolean ascend, List<CacheEntry<TRankObj>> cacheEntries)
/*     */     {
/* 863 */       if (cacheEntries.size() <= 0) {
/* 864 */         return -1;
/*     */       }
/* 866 */       int begin = 0;
/* 867 */       int end = cacheEntries.size() - 1;
/* 868 */       CacheEntry<TRankObj> endCacheEntry = (CacheEntry)cacheEntries.get(end);
/* 869 */       if ((((RankObj)endCacheEntry.rankObj).compareTo(rankObj) < 0) && (ascend)) {
/* 870 */         return -1;
/*     */       }
/* 872 */       if (((RankObj)endCacheEntry.rankObj).compareTo(rankObj) == 0) {
/* 873 */         return end;
/*     */       }
/* 875 */       if ((((RankObj)endCacheEntry.rankObj).compareTo(rankObj) > 0) && (!ascend)) {
/* 876 */         return -1;
/*     */       }
/* 878 */       CacheEntry<TRankObj> beginCacheEntry = (CacheEntry)cacheEntries.get(0);
/* 879 */       if ((((RankObj)beginCacheEntry.rankObj).compareTo(rankObj) > 0) && (ascend)) {
/* 880 */         return 0;
/*     */       }
/* 882 */       if (((RankObj)endCacheEntry.rankObj).compareTo(rankObj) == 0) {
/* 883 */         return 0;
/*     */       }
/* 885 */       if ((((RankObj)beginCacheEntry.rankObj).compareTo(rankObj) < 0) && (!ascend)) {
/* 886 */         return 0;
/*     */       }
/*     */       
/* 889 */       while (begin != end) {
/* 890 */         int middle = (begin + end) / 2;
/* 891 */         CacheEntry<TRankObj> middleChartObj = (CacheEntry)cacheEntries.get(middle);
/* 892 */         if (((RankObj)middleChartObj.rankObj).compareTo(rankObj) == 0)
/* 893 */           return middle;
/* 894 */         if (((RankObj)middleChartObj.rankObj).compareTo(rankObj) > 0) {
/* 895 */           if (ascend) {
/* 896 */             if (end == middle) {
/* 897 */               return end;
/*     */             }
/* 899 */             end = middle;
/*     */           } else {
/* 901 */             if (begin == middle) {
/* 902 */               return end;
/*     */             }
/* 904 */             begin = middle;
/*     */           }
/* 906 */         } else if (((RankObj)middleChartObj.rankObj).compareTo(rankObj) < 0) {
/* 907 */           if (ascend) {
/* 908 */             if (begin == middle) {
/* 909 */               return end;
/*     */             }
/* 911 */             begin = middle;
/*     */           } else {
/* 913 */             if (end == middle) {
/* 914 */               return end;
/*     */             }
/* 916 */             end = middle;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 921 */       return end;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\Rank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */