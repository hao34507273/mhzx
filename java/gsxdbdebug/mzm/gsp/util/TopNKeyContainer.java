/*     */ package mzm.gsp.util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TopNKeyContainer<TKey, TObj extends IOrderedWithKey<TKey, TObj>>
/*     */   extends TopNOrderedContainer<TObj>
/*     */ {
/*  15 */   protected Map<TKey, Integer> key2Index = new HashMap();
/*     */   
/*     */   public TopNKeyContainer(int topNumber) {
/*  18 */     super(topNumber);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void doSetObject2List(int index, TObj obj)
/*     */   {
/*  24 */     TObj oldObj = (IOrderedWithKey)this.orderedList.set(index, obj);
/*  25 */     if (oldObj != null) {
/*  26 */       this.key2Index.remove(oldObj.getKey());
/*     */     }
/*  28 */     this.key2Index.put(obj.getKey(), Integer.valueOf(index));
/*     */   }
/*     */   
/*     */   protected void doAddObject2List(TObj obj)
/*     */   {
/*  33 */     this.orderedList.add(obj);
/*  34 */     this.key2Index.put(obj.getKey(), Integer.valueOf(this.orderedList.size() - 1));
/*     */   }
/*     */   
/*     */   protected void doSwap(int i, int j)
/*     */   {
/*  39 */     super.doSwap(i, j);
/*  40 */     this.key2Index.put(((IOrderedWithKey)this.orderedList.get(i)).getKey(), Integer.valueOf(i));
/*  41 */     this.key2Index.put(((IOrderedWithKey)this.orderedList.get(j)).getKey(), Integer.valueOf(j));
/*     */   }
/*     */   
/*     */   public void addObject(TObj obj)
/*     */   {
/*  46 */     this.lock.writeLock().lock();
/*     */     try {
/*  48 */       Integer index = (Integer)this.key2Index.get(obj.getKey());
/*  49 */       if (index != null) {
/*  50 */         doSetObject2List(index.intValue(), obj);
/*  51 */         doAdjust(index.intValue());
/*     */       }
/*     */       else {
/*  54 */         doAddNewObject(obj);
/*     */       }
/*     */     } finally {
/*  57 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getIndexOfKey(TKey key)
/*     */   {
/*  63 */     this.lock.readLock().lock();
/*     */     try {
/*  65 */       return (Integer)this.key2Index.get(key);
/*     */     }
/*     */     finally {
/*  68 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean containsKey(TKey key)
/*     */   {
/*  74 */     this.lock.readLock().lock();
/*     */     try {
/*  76 */       return this.key2Index.containsKey(key);
/*     */     }
/*     */     finally {
/*  79 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean removeObject(TKey key)
/*     */   {
/*  85 */     this.lock.writeLock().lock();
/*  86 */     boolean ret = false;
/*     */     try {
/*  88 */       ret = doRemoveObject(key);
/*     */     }
/*     */     finally {
/*  91 */       this.lock.writeLock().unlock();
/*     */     }
/*  93 */     return ret;
/*     */   }
/*     */   
/*     */   protected boolean doRemoveObject(TKey key)
/*     */   {
/*  98 */     Integer index = (Integer)this.key2Index.remove(key);
/*  99 */     if (index == null) {
/* 100 */       return false;
/*     */     }
/* 102 */     this.orderedList.remove(index.intValue());
/*     */     
/* 104 */     for (int i = index.intValue(); i < this.orderedList.size(); i++) {
/* 105 */       TObj obj = (IOrderedWithKey)this.orderedList.get(i);
/* 106 */       this.key2Index.put(obj.getKey(), Integer.valueOf(i));
/*     */     }
/*     */     
/* 109 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\TopNKeyContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */