/*     */ package mzm.gsp.chart.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class RankManagerNew<TKey, TChartObj extends ChartObj<TKey, TChartObj>>
/*     */ {
/*     */   protected int capacity;
/*     */   protected int extraSize;
/*  28 */   private List<TChartObj> rankDatas = new ArrayList();
/*     */   
/*  30 */   private Map<TKey, Integer> keyToIndex = new HashMap();
/*     */   
/*  32 */   private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public RankManagerNew(int capacity, int extraSize)
/*     */   {
/*  43 */     this.capacity = capacity;
/*  44 */     this.extraSize = extraSize;
/*  45 */     RankDBManager.getInstance().registerDBHandle(this);
/*  46 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/*  50 */         RankManagerNew.this.rankDataFromDB();
/*  51 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getCapacity()
/*     */   {
/*  63 */     return this.capacity;
/*     */   }
/*     */   
/*     */   public int getExtraSize() {
/*  67 */     return this.extraSize;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int size()
/*     */   {
/*  76 */     this.lock.readLock().lock();
/*     */     try {
/*  78 */       return this.rankDatas.size();
/*     */     } catch (Exception e) {
/*  80 */       GameServer.logger().error("获取排行当前数量出错!!!");
/*     */     } finally {
/*  82 */       this.lock.readLock().unlock();
/*     */     }
/*  84 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean rank(TChartObj rankObj)
/*     */   {
/*  93 */     if (!rankObj.isAvailable()) {
/*  94 */       return false;
/*     */     }
/*  96 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/*  99 */       int index = index(rankObj.getKey());
/*     */       TChartObj originalObj;
/* 101 */       if (index >= 0)
/*     */       {
/* 103 */         originalObj = (ChartObj)this.rankDatas.get(index);
/* 104 */         int nowRank = index;
/*     */         
/* 106 */         if (rankObj.isTopThan(originalObj))
/*     */         {
/* 108 */           while (nowRank > 0) {
/* 109 */             TChartObj topObj = (ChartObj)this.rankDatas.get(nowRank - 1);
/* 110 */             if (!rankObj.isTopThan(topObj)) break;
/* 111 */             this.rankDatas.set(nowRank, topObj);
/* 112 */             this.keyToIndex.put(topObj.getKey(), Integer.valueOf(nowRank));
/* 113 */             nowRank--;
/*     */           }
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 119 */         int maxRank = this.rankDatas.size() - 1;
/* 120 */         while (nowRank < maxRank) {
/* 121 */           TChartObj lowObj = (ChartObj)this.rankDatas.get(nowRank + 1);
/* 122 */           if (!lowObj.isTopThan(rankObj)) break;
/* 123 */           this.rankDatas.set(nowRank, lowObj);
/* 124 */           this.keyToIndex.put(lowObj.getKey(), Integer.valueOf(nowRank));
/* 125 */           nowRank++;
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 131 */         this.rankDatas.set(nowRank, rankObj);
/* 132 */         this.keyToIndex.put(rankObj.getKey(), Integer.valueOf(nowRank));
/* 133 */         return 1;
/*     */       }
/*     */       
/*     */ 
/* 137 */       index = topIndex(rankObj);
/* 138 */       if (index < 0) {
/* 139 */         if (this.rankDatas.size() < this.capacity + this.extraSize) {
/* 140 */           this.rankDatas.add(rankObj);
/* 141 */           this.keyToIndex.put(rankObj.getKey(), Integer.valueOf(this.rankDatas.size() - 1));
/* 142 */           return 1;
/*     */         }
/*     */       } else {
/* 145 */         this.rankDatas.add(index, rankObj);
/* 146 */         this.keyToIndex.put(rankObj.getKey(), Integer.valueOf(index));
/*     */         
/* 148 */         for (int i = index + 1; i < this.rankDatas.size(); i++)
/* 149 */           this.keyToIndex.put(((ChartObj)this.rankDatas.get(i)).getKey(), Integer.valueOf(i));
/*     */         TChartObj remTChartObj;
/* 151 */         if (this.rankDatas.size() > this.capacity + this.extraSize) {
/* 152 */           remTChartObj = (ChartObj)this.rankDatas.remove(this.rankDatas.size() - 1);
/* 153 */           this.keyToIndex.remove(remTChartObj.getKey());
/*     */         }
/* 155 */         return 1;
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 160 */       GameServer.logger().error("rank error,", e);
/*     */     } finally {
/* 162 */       this.lock.writeLock().unlock();
/*     */     }
/* 164 */     return false;
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
/*     */   private int topIndex(TChartObj rankObj)
/*     */   {
/* 198 */     if (this.rankDatas.size() <= 0) {
/* 199 */       return -1;
/*     */     }
/* 201 */     int begin = 0;
/* 202 */     int end = this.rankDatas.size() - 1;
/* 203 */     TChartObj endObj = (ChartObj)this.rankDatas.get(end);
/* 204 */     if (!rankObj.isTopThan(endObj)) {
/* 205 */       return -1;
/*     */     }
/* 207 */     if (rankObj.isTopThan((ChartObj)this.rankDatas.get(0))) {
/* 208 */       return 0;
/*     */     }
/* 210 */     while (begin != end) {
/* 211 */       int middle = (begin + end) / 2;
/* 212 */       TChartObj middleChartObj = (ChartObj)this.rankDatas.get(middle);
/* 213 */       if (rankObj.isTopThan(middleChartObj)) {
/* 214 */         if (end == middle) {
/* 215 */           return middle;
/*     */         }
/* 217 */         end = middle;
/*     */       } else {
/* 219 */         if (begin == middle) {
/* 220 */           return begin + 1;
/*     */         }
/* 222 */         begin = middle;
/*     */       }
/*     */     }
/* 225 */     return end;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRank(TKey tKey)
/*     */   {
/* 235 */     this.lock.readLock().lock();
/*     */     try {
/* 237 */       Integer index = (Integer)this.keyToIndex.get(tKey);
/* 238 */       if ((index != null) && (index.intValue() < this.capacity)) {
/* 239 */         return index.intValue();
/*     */       }
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 243 */       this.lock.readLock().unlock();
/*     */     }
/* 245 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TChartObj getObjByKey(TKey tKey)
/*     */   {
/* 255 */     this.lock.readLock().lock();
/*     */     try {
/* 257 */       Integer index = (Integer)this.keyToIndex.get(tKey);
/* 258 */       if (index != null) {
/* 259 */         return (ChartObj)this.rankDatas.get(index.intValue());
/*     */       }
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 263 */       this.lock.readLock().unlock();
/*     */     }
/* 265 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TKey getKeyByRank(int rank)
/*     */   {
/* 274 */     this.lock.readLock().lock();
/*     */     try { Object localObject1;
/* 276 */       if ((this.rankDatas.size() <= rank) || (rank < 0)) {
/* 277 */         return null;
/*     */       }
/* 279 */       return (TKey)((ChartObj)this.rankDatas.get(rank)).getKey();
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 282 */       this.lock.readLock().unlock();
/*     */     }
/* 284 */     return null;
/*     */   }
/*     */   
/*     */   private int index(TKey tKey) {
/* 288 */     if (this.keyToIndex.containsKey(tKey)) {
/* 289 */       return ((Integer)this.keyToIndex.get(tKey)).intValue();
/*     */     }
/* 291 */     return -1;
/*     */   }
/*     */   
/*     */   public boolean delete(TKey tKey) {
/* 295 */     boolean ret = false;
/* 296 */     if (tKey == null) {
/* 297 */       return ret;
/*     */     }
/* 299 */     this.lock.writeLock().lock();
/*     */     try {
/* 301 */       Integer index = (Integer)this.keyToIndex.remove(tKey);
/* 302 */       if (index != null) {
/* 303 */         this.rankDatas.remove(index.intValue());
/*     */         
/* 305 */         for (int i = index.intValue(); i < this.rankDatas.size(); i++) {
/* 306 */           TChartObj moveChartObj = (ChartObj)this.rankDatas.get(i);
/* 307 */           this.keyToIndex.put(moveChartObj.getKey(), Integer.valueOf(i));
/*     */         }
/* 309 */         ret = true;
/*     */       }
/*     */     } catch (Exception e) {
/* 312 */       GameServer.logger().error("删除排行榜数据出错!!!", e);
/*     */     } finally {
/* 314 */       this.lock.writeLock().unlock();
/*     */     }
/* 316 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void delete(TChartObj rankObj)
/*     */   {
/* 325 */     if (rankObj == null) {
/* 326 */       return;
/*     */     }
/* 328 */     delete(rankObj.getKey());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void clear()
/*     */   {
/* 335 */     this.lock.writeLock().lock();
/*     */     try {
/* 337 */       this.rankDatas.clear();
/* 338 */       this.keyToIndex.clear();
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 341 */       this.lock.writeLock().unlock();
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
/*     */   public Pair<Integer, List<TChartObj>> getRankObjs(TKey tKey, int pageSize)
/*     */   {
/* 354 */     this.lock.readLock().lock();
/*     */     try {
/* 356 */       int rank = getRank(tKey);
/* 357 */       if (rank == -1) {
/* 358 */         return new Pair(Integer.valueOf(-1), null);
/*     */       }
/*     */       
/* 361 */       int begin = rank / pageSize * pageSize;
/* 362 */       int end = begin + pageSize - 1;
/* 363 */       return new Pair(Integer.valueOf(rank), getRankObjs(begin, end));
/*     */     } finally {
/* 365 */       this.lock.readLock().unlock();
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
/*     */   public List<TChartObj> getRankObjs(int fromOrder, int toOrder)
/*     */   {
/* 379 */     List<TChartObj> list = new ArrayList();
/* 380 */     if (fromOrder < 0) {
/* 381 */       return list;
/*     */     }
/* 383 */     if (fromOrder > toOrder) {
/* 384 */       return list;
/*     */     }
/* 386 */     this.lock.readLock().lock();
/*     */     try {
/* 388 */       int max = this.rankDatas.size() - 1;
/* 389 */       if (max > this.capacity - 1) {
/* 390 */         max = this.capacity - 1;
/*     */       }
/* 392 */       if (toOrder > max) {
/* 393 */         toOrder = max;
/*     */       }
/* 395 */       for (int i = fromOrder; i <= toOrder; i++) {
/* 396 */         list.add(this.rankDatas.get(i));
/*     */       }
/* 398 */       return list;
/*     */     } catch (Exception e) {
/* 400 */       GameServer.logger().error("获取排行榜数据出错!!!", e);
/*     */     } finally {
/* 402 */       this.lock.readLock().unlock();
/*     */     }
/* 404 */     return list;
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
/*     */   public List<TChartObj> getRanObjsFromPage(int pageNum, int pageSize)
/*     */   {
/* 417 */     int fromOrder = pageNum * pageSize;
/* 418 */     int toOrder = (pageNum + 1) * pageSize - 1;
/* 419 */     return getRankObjs(fromOrder, toOrder);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<TChartObj> getAllChartObjs()
/*     */   {
/* 428 */     List<TChartObj> allChartObjs = new ArrayList();
/* 429 */     this.lock.readLock().lock();
/*     */     try {
/* 431 */       allChartObjs.addAll(this.rankDatas);
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 434 */       this.lock.readLock().unlock();
/*     */     }
/* 436 */     return allChartObjs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Collection<TChartObj> getAfterRankObjs(int fromOrder)
/*     */   {
/* 445 */     return getRankObjs(fromOrder, this.capacity - 1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TChartObj getRankObj(int order)
/*     */   {
/* 455 */     this.lock.readLock().lock();
/*     */     try { Object localObject1;
/* 457 */       if ((order < 0) || (order >= this.rankDatas.size())) {
/* 458 */         return null;
/*     */       }
/* 460 */       return (ChartObj)this.rankDatas.get(order);
/*     */     } catch (Exception e) {
/* 462 */       GameServer.logger().error("获取排行榜数据出错!!!", e);
/*     */     } finally {
/* 464 */       this.lock.readLock().unlock();
/*     */     }
/* 466 */     return null;
/*     */   }
/*     */   
/*     */   public abstract void saveToDB();
/*     */   
/*     */   public abstract void rankDataFromDB();
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\RankManagerNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */