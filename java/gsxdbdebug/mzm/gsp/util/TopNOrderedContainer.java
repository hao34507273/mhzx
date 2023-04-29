/*     */ package mzm.gsp.util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TopNOrderedContainer<TObj extends IOrdered<TObj>>
/*     */ {
/*  18 */   protected ArrayList<TObj> orderedList = new ArrayList();
/*     */   protected int topNumber;
/*  20 */   protected ReadWriteLock lock = new ReentrantReadWriteLock();
/*     */   
/*     */   public TopNOrderedContainer(int topNumber) {
/*  23 */     this.topNumber = topNumber;
/*     */   }
/*     */   
/*     */   public final void addNewObject(TObj obj)
/*     */   {
/*  28 */     this.lock.writeLock().lock();
/*     */     try {
/*  30 */       doAddNewObject(obj);
/*     */     }
/*     */     finally {
/*  33 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public int size() {
/*  38 */     this.lock.readLock().lock();
/*     */     try {
/*  40 */       return this.orderedList.size();
/*     */     }
/*     */     finally {
/*  43 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void clear()
/*     */   {
/*  49 */     this.lock.writeLock().lock();
/*     */     try {
/*  51 */       this.orderedList.clear();
/*     */     }
/*     */     finally {
/*  54 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public List<TObj> getTopNList() {
/*  59 */     this.lock.readLock().lock();
/*     */     try {
/*  61 */       return new ArrayList(this.orderedList);
/*     */     }
/*     */     finally {
/*  64 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public List<TObj> getTopNList(int begin, int length) {
/*  69 */     this.lock.readLock().lock();
/*     */     try {
/*  71 */       List<TObj> list = new ArrayList();
/*  72 */       if ((begin < 0) || (begin > this.orderedList.size() - 1)) {
/*  73 */         return list;
/*     */       }
/*  75 */       int end = Math.min(begin + length, this.orderedList.size());
/*     */       
/*  77 */       for (int i = begin; i < end; i++) {
/*  78 */         list.add(this.orderedList.get(i));
/*     */       }
/*     */       
/*  81 */       return list;
/*     */     }
/*     */     finally {
/*  84 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTopNumber(int topNumber)
/*     */   {
/*  92 */     this.lock.writeLock().lock();
/*     */     try {
/*  94 */       this.topNumber = topNumber;
/*     */     }
/*     */     finally {
/*  97 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   private int doAdjustHead(int index)
/*     */   {
/* 103 */     if (index <= 0) {
/* 104 */       return index;
/*     */     }
/* 106 */     int begin = 0;
/* 107 */     int end = index - 1;
/*     */     
/* 109 */     TObj obj = (IOrdered)this.orderedList.get(index);
/*     */     
/* 111 */     if (!obj.isTopThan(this.orderedList.get(end))) {
/* 112 */       return index;
/*     */     }
/*     */     
/* 115 */     if (obj.isTopThan(this.orderedList.get(begin))) {
/* 116 */       move(index, begin);
/* 117 */       return begin;
/*     */     }
/*     */     
/* 120 */     return doAdjustRange(index, begin, end);
/*     */   }
/*     */   
/*     */   private int doAdjustEnd(int index)
/*     */   {
/* 125 */     if (index >= this.orderedList.size() - 1) {
/* 126 */       return index;
/*     */     }
/* 128 */     int begin = index + 1;
/* 129 */     int end = this.orderedList.size() - 1;
/*     */     
/* 131 */     TObj obj = (IOrdered)this.orderedList.get(index);
/*     */     
/* 133 */     if (obj.isTopThan(this.orderedList.get(begin))) {
/* 134 */       return index;
/*     */     }
/*     */     
/* 137 */     if (!obj.isTopThan(this.orderedList.get(end))) {
/* 138 */       move(index, end);
/* 139 */       return end;
/*     */     }
/*     */     
/* 142 */     return doAdjustRange(index, begin, end);
/*     */   }
/*     */   
/*     */   private int doAdjustRange(int index, int begin, int end) {
/* 146 */     if (end - begin <= 1) {
/* 147 */       if (index >= end) {
/* 148 */         move(index, end);
/* 149 */         return end;
/*     */       }
/*     */       
/* 152 */       move(index, begin);
/* 153 */       return begin;
/*     */     }
/*     */     
/*     */ 
/* 157 */     int mid = (begin + end) / 2;
/*     */     
/* 159 */     TObj obj = (IOrdered)this.orderedList.get(index);
/*     */     
/* 161 */     if (obj.isTopThan(this.orderedList.get(mid))) {
/* 162 */       end = mid;
/*     */     }
/*     */     else {
/* 165 */       begin = mid;
/*     */     }
/* 167 */     return doAdjustRange(index, begin, end);
/*     */   }
/*     */   
/*     */   protected int doAdjust(int index)
/*     */   {
/* 172 */     int des = doAdjustHead(index);
/* 173 */     if (des != index) {
/* 174 */       return des;
/*     */     }
/* 176 */     return doAdjustEnd(index);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void move(int index, int destination)
/*     */   {
/* 182 */     if (index == destination) {
/* 183 */       return;
/*     */     }
/* 185 */     if (index < destination) {
/* 186 */       for (int i = index; i < destination; i++) {
/* 187 */         doSwap(i, i + 1);
/*     */       }
/*     */       
/*     */     } else {
/* 191 */       for (int i = index; i > destination; i--) {
/* 192 */         doSwap(i, i - 1);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   protected int doAddNewObject(TObj obj)
/*     */   {
/* 199 */     if (obj == null) {
/* 200 */       return -1;
/*     */     }
/*     */     
/* 203 */     if ((this.topNumber < 0) || (this.orderedList.size() < this.topNumber)) {
/* 204 */       doAddObject2List(obj);
/* 205 */       return doAdjustHead(this.orderedList.size() - 1);
/*     */     }
/*     */     
/* 208 */     int endIndex = this.orderedList.size() - 1;
/* 209 */     TObj endObj = (IOrdered)this.orderedList.get(endIndex);
/* 210 */     if (!obj.isTopThan(endObj)) {
/* 211 */       return -1;
/*     */     }
/*     */     
/* 214 */     doSetObject2List(endIndex, obj);
/* 215 */     return doAdjustHead(endIndex);
/*     */   }
/*     */   
/*     */   protected void doSetObject2List(int index, TObj obj)
/*     */   {
/* 220 */     this.orderedList.set(index, obj);
/*     */   }
/*     */   
/*     */   protected void doAddObject2List(TObj obj) {
/* 224 */     this.orderedList.add(obj);
/*     */   }
/*     */   
/*     */   protected void doSwap(int i, int j) {
/* 228 */     Collections.swap(this.orderedList, i, j);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\TopNOrderedContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */